package org.example.annotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {
    private HashMap<Class, Object> beanFactory = new HashMap<>();
    private String rootPath;

    @Override
    public Object getBean(Class cls) {
        return beanFactory.get(cls);
    }

    public AnnotationApplicationContext(String packageScan) {

        //首先需要将要扫描的包的连接符换一下
        String packageDir = packageScan.replace(".", "/");

        try {
            //获取当前根路径
            rootPath = new File(Thread.currentThread().getContextClassLoader().getResources("").nextElement().getFile()).toString();
            //获取自己和关联的包中所有带有packageDir的资源
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageDir);
            //遍历
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                //通过url获取文件名
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                //再根据文件名去加载其路径底下的所有bean
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("AnnotationApplicationContext扫描完毕");

        //开始进行依赖注入
        loadDI();
        System.out.println("依赖注入完成");
    }

    private void loadDI() {
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> m :
                entries) {
            Object o = m.getValue();
            Class<?> cls = o.getClass();
            for (Field declaredField : cls.getDeclaredFields()) {
                DI annotation = declaredField.getAnnotation(DI.class);
                if(annotation!=null){
                    declaredField.setAccessible(true);
                    System.out.println("给"+cls.getName()+"的"+declaredField.getName()+"进行依赖注入");
                    try {
                        declaredField.set(o,beanFactory.get(declaredField.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }

    }

    private void loadBean(File file) {
        if (file.isDirectory()) {
            //获取目录下所有文件，包括文件夹
            File[] subFiles = file.listFiles();
            if (subFiles == null || subFiles.length == 0) {
                return;
            }
            //遍历，要是文件夹就递归
            for (File subfile : subFiles) {
                if (subfile.isDirectory()) {
                    loadBean(subfile);
                } else {
                    //先处理文件名，将根路径去掉
                    String pathForLoad = subfile.getAbsolutePath().substring(rootPath.length() + 1);
                    pathForLoad = pathForLoad.replace("\\", ".").replace(".class", "");

                    try {
                        Class<?> cls = Class.forName(pathForLoad);
                        if (!cls.isInterface()) {
                            Bean annotation = cls.getAnnotation(Bean.class);
                            if (annotation != null) {
                                Constructor<?> constructor = cls.getConstructor(String.class);
                                String simpleName = cls.getSimpleName();
                                Object o = constructor.newInstance(simpleName);
                                //如果这个实例实现了某个接口，则按照接口的名字进行存储
                                if (cls.getInterfaces().length > 0) {
                                    beanFactory.put(cls.getInterfaces()[0], o);
                                    System.out.println("以接口：" + cls.getInterfaces()[0].getName() + "为名字存放实例");
                                } else {
                                    beanFactory.put(cls, o);
                                    System.out.println("以类名" + cls.getName() + "为名字存放实例");
                                }
                                System.out.println("bean实例存放" + beanFactory.size() + "个");
                            }
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


}
