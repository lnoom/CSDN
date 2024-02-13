package cn.ruauto;

import java.net.Socket;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-28 15:10
 */
public class Request extends AbstractHttpServletRequest{
    private String url;
    private String method;
    private String protocol;
    private Socket socket;

    public Request() {
    }



    public Request(String url, String method, String protocol, Socket socket) {
        this.url = url;
        this.method = method;
        this.protocol = protocol;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public StringBuffer getRequestURL() {
        return new StringBuffer(url);
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }
}
