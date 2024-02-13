package cn.ruauto;


import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tomcat {
    private Map<String, Context> contextMap=new HashMap<>();
    public void start() {
        // socket连接 tcp
        try {
            //浏览器开启两个窗口 解决串行问题
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            ServerSocket serverSocket = new ServerSocket(8080);
            //循环接收 不能请求一次就断开
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new SocketProcessor(socket,this));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.deployApps();
        tomcat.start();
    }

    private void deployApps() {
        File webapps = new File(System.getProperty("user.dir"), "webapps");
        for (String app : webapps.list()) {
            deployApp(webapps, app);
        }
    }

    private void deployApp(File webapps, String appName) {
        //有哪些servlet
        Context context = new Context(appName);


        File appDirectory = new File(webapps, appName);
        File classesDirectory = new File(appDirectory, "classes");
        List<File> files = getAllFilePath(classesDirectory);
        for (File file : files) {
            for (File clazz : files) {
                String name = clazz.getPath();
                name = name.replace(classesDirectory.getPath() + "\\", "");
                name = name.replace(".class", "");
                name = name.replace("\\", ".");
                System.out.println(name);
                //loadClass
                try {
                    WebappClassLoader  classLoader = new WebappClassLoader(new URL[]{classesDirectory.toURL()});
                    Class<?> servletClass =classLoader.loadClass(name);
//                    Class<?> servletClass = Thread.currentThread().getContextClassLoader().loadClass(name);
                    //判断是不是servlet
                    if (HttpServlet.class.isAssignableFrom(servletClass)) {
                        if(servletClass.isAnnotationPresent(WebServlet.class)){
                            WebServlet annotation = servletClass.getAnnotation(WebServlet.class);
                            String[] urlPatterns = annotation.urlPatterns();

                            for (String urlPattern : urlPatterns) {
                                context.addUrlPatternMapping(urlPattern, (Servlet) servletClass.newInstance());
                            }
                        }
                    }
//                    System.out.println(servletClass);
                } catch (ClassNotFoundException | MalformedURLException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }

        }
        contextMap.put(appName, context);
    }

    public List<File> getAllFilePath(File srcFile) {
        List<File> result = new ArrayList<>();
        File[] files = srcFile.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    result.addAll(getAllFilePath(file));
                } else {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public Map<String, Context> getContextMap() {
        return contextMap;
    }
}
