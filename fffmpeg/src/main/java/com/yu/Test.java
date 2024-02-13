package com.yu;

import com.yu.utlis.VtoUtils;

import java.io.File;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-04 21:32
 */
public class Test {
    public static void main(String[] args) {
        File source = new File("/1.mp4");
        String picName = "4.mp4";
        File result = VtoUtils.compressionVideo(source, picName);
        if (result != null) {
            System.out.println("压缩成功，新文件路径：" + result.getAbsolutePath());
        } else {
            System.out.println("压缩失败");
        }
    }
}
