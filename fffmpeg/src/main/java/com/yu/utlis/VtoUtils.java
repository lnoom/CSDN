package com.yu.utlis;

import ws.schild.jave.*;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

public class VtoUtils {
    public static File compressionVideo(File source, String picName) {
        if (source == null) {
            return null;
        }
        String newPath = source.getAbsolutePath().replace("\\", "/"); // 将路径中的反斜杠替换为正斜杠
        int lastIndex = newPath.lastIndexOf("/");
        if (lastIndex != -1) {
            newPath = newPath.substring(0, lastIndex + 1).concat(picName);
        } else {
            newPath = picName;
        }
        File target = new File(newPath);
        try {
            MultimediaObject object = new MultimediaObject(source);
            AudioInfo audioInfo = object.getInfo().getAudio();
            int maxSize = 100;
            double mb = Math.ceil(source.length() / 1048576);
            int second = (int) object.getInfo().getDuration() / 1000;
            BigDecimal bd = new BigDecimal(String.format("%.4f", mb / second));
            System.out.println("开始压缩视频了--> 视频每秒平均 " + bd + " MB ");
            boolean temp = mb > maxSize || bd.compareTo(new BigDecimal(0.5)) > 0;
            if (temp) {
                long time = System.currentTimeMillis();
                EncodingAttributes attr = createEncodingAttributes();
                Encoder encoder = new Encoder();
                encoder.encode(new MultimediaObject(source), target, attr);
                System.out.println("压缩总耗时：" + (System.currentTimeMillis() - time) / 1000);
                return target;
            }
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
        } finally {
            if (target.length() > 0) {
                source.delete();
            }
        }
        return source;
    }
    private static EncodingAttributes createEncodingAttributes() {
        EncodingAttributes attr = new EncodingAttributes();
        attr.setFormat("mp4");
        // 设置音频属性
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        attr.setAudioAttributes(audio);
        // 设置视频属性
        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264");
        video.setBitRate(800000);
        video.setFrameRate(20);
        video.setSize(new VideoSize(1280, 720));
        attr.setVideoAttributes(video);
        return attr;
    }

    /**
     * 获取视频大小
     * @param source
     * @return
     */
    @SuppressWarnings({ "resource" })
    public static BigDecimal ReadVideoSize(File source) {
        FileChannel fc = null;
        try {
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            return fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static File compressionVideo(String href){
        try{
 // 缓存到临时目录，压缩上传完到远程服务器上之后，记得删除源视频
            String savePath = "/tmp/tempVideo/";
            long time = System.currentTimeMillis();
            URL url=new URL(href);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(600*1000);
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
            InputStream in=connection.getInputStream();
            String fileName =  "zip" + href.substring(href.lastIndexOf("/") + 1);
            File saveDir = new File(savePath);
            if(!saveDir.exists()){
                saveDir.mkdirs();
            }
            File file = new File(savePath + fileName);
            OutputStream out=new FileOutputStream(file);
            byte[] bytes=new byte[1024];
            int len = 0;
            while((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            out.close();
            in.close();
            System.out.println("下载+压缩 总耗时：" + (System.currentTimeMillis() - time)/1000);
            return compressionVideo(file, fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
