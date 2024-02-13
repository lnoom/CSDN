package cn.ruauto;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-29 10:19
 */
public class Context {
    private String appName;
    private Map<String, Servlet> urlPatternMapping = new HashMap<>();
    public Context(String appName) {
        this.appName = appName;
    }
    public void addUrlPatternMapping(String urlPattern, Servlet servlet) {
        urlPatternMapping.put(urlPattern, servlet);
    }
    public Servlet getByUrlPattern(String urlPattern) {
        for(String key : urlPatternMapping.keySet()){
            if(key.contains(urlPattern)){
                return urlPatternMapping.get(key);
            }
        }
        return null;
    }
}
