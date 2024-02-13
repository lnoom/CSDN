package cn.ruauto;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-29 9:55
 */
public class WebappClassLoader extends URLClassLoader {

    public WebappClassLoader(URL[] urls) {
        super(urls);
    }
}
