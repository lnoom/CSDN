package com.yu;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-05 21:35
 */
public class Test {
    public static void main(String[] args) {
        String url = "https://bbs.huaweicloud.com/blogs/421669"; // 将此URL替换为你要刷访问的网站链接
        int numberOfHits = 10000; // 设置你想要发送的访问次数

        for (int i = 0; i < numberOfHits; i++) {
            try {
                sendGETRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendGETRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("成功访问： " + urlString);
        } else {
            System.out.println("访问失败： " + urlString + "，响应码： " + responseCode);
        }

        connection.disconnect();
    }
}
