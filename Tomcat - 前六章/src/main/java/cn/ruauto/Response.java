package cn.ruauto;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-28 15:31
 */
public class Response extends AbstractHttpServletResponse {
    private int status = 200;
    private String message = "success";
    private byte SP = ' ';
    private byte CR = '\r';
    private byte LF = '\n';
    private Map<String, String> headers = new HashMap<>();
    private Request request;
    private OutputStream socketOutputStream;
    private ResponseServletOutputStream responseServletOutputStream = new ResponseServletOutputStream();

    public Response(Request request) {
        this.request = request;
        try {
            this.socketOutputStream = request.getSocket().getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseServletOutputStream getOutputStream() throws IOException {
        return responseServletOutputStream;
    }

    public void complete() {
        //发送响应
        try {
            sendResponseLine();
            sendResponseHeader();
            sendResponseBody();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendResponseBody() throws IOException {
        socketOutputStream.write(getOutputStream().getBytes());
    }

    private void sendResponseHeader() throws IOException {
        if(!headers.containsKey("Content-Length")){
            addHeader("Content-Length", String.valueOf(getOutputStream().getBytes().length));
        }
        if(!headers.containsKey("Content-Type")){
            addHeader("Content-Type", "text/plain;charset=utf-8");
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            socketOutputStream.write(key.getBytes());
            socketOutputStream.write(":".getBytes());
            socketOutputStream.write(value.getBytes());
            socketOutputStream.write(CR);
            socketOutputStream.write(LF);
        }
        socketOutputStream.write(CR);
        socketOutputStream.write(LF);
    }

    private void sendResponseLine() throws IOException {
        socketOutputStream.write(request.getProtocol().getBytes());
        socketOutputStream.write(SP);
        socketOutputStream.write(status);
        socketOutputStream.write(SP);
        socketOutputStream.write(message.getBytes());
        socketOutputStream.write(CR);
        socketOutputStream.write(LF);
    }

    public Response() {
    }

    public Response(int status, String message, Map<String, String> headers) {
        this.status = status;
        this.message = message;
        this.headers = headers;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int i, String s) {
        this.status = i;
        this.message = s;
    }

    @Override
    public void addHeader(String s, String s1) {
        headers.put(s, s1);
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
