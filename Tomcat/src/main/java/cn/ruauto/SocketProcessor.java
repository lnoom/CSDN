package cn.ruauto;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-28 9:17
 */
public class SocketProcessor implements Runnable {
    private Socket socket;
    private Tomcat tomcat;

    public SocketProcessor(Socket socket,Tomcat tomcat) {
        this.socket = socket;
        this.tomcat =tomcat;
    }

    @Override
    public void run() {
        ProcessSocket(socket);
    }

    private void ProcessSocket(Socket socket) {
        //处理socket连接 读数据 写数据
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);

            //解析字节流，遇到一个空格就退出
            int pos = 0;
            int begin = 0, end = 0;
            for (; pos < bytes.length; pos++, end++) {
                if (bytes[pos] == ' ')
                    break;
            }
            //组合空格之前的字节流，转换成字符串就是请求方法
            StringBuilder method = new StringBuilder();
            for (; begin < end; begin++) {
                method.append((char) bytes[begin]);
            }
            //解析URL
            pos++;
            begin++;
            end++;
            for (; pos < bytes.length; pos++, end++) {
                if (bytes[pos] == ' ')
                    break;
            }
            StringBuilder url = new StringBuilder();
            for (; begin < end; begin++) {
                url.append((char) bytes[begin]);
            }
            //解析协议版本
            pos++;
            begin++;
            end++;
            for (; pos < bytes.length; pos++, end++) {
                if (bytes[pos] == '\r')
                    break;
            }
            StringBuilder protocl = new StringBuilder();
            for (; begin < end; begin++) {
                protocl.append((char) bytes[begin]);
            }

            Request request = new Request(url.toString(), method.toString(), protocl.toString(),socket);
            Response response = new Response(request);
            String requestUrl = request.getRequestURL().toString();
            requestUrl = requestUrl.substring(1);
            String[] parts = requestUrl.split("/");
            
            String appName = parts[0];
            Context context = tomcat.getContextMap().get(appName);

            if(parts.length > 1) {
                Servlet servlet = context.getByUrlPattern(parts[1]);
                servlet.service(request, response);

//            //匹配servlet doGet
//            NgroServlet ngroServlet = new NgroServlet();
//            //servlet自动能判断请求方法
//            ngroServlet.service(request, response);

                //发送响应
                response.complete();
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
