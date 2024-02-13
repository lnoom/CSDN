package cn.ruauto;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-28 15:48
 */
public class ResponseServletOutputStream extends ServletOutputStream {
    private byte[] bytes = new byte[1024];
    private int pos = 0;

    @Override
    public void write(int b) throws IOException {
        bytes[pos++] = (byte) b;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }
}
