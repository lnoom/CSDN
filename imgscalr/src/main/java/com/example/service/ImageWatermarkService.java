package com.example.service;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class ImageWatermarkService {

    public void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) throws IOException {
        BufferedImage sourceImage = ImageIO.read(sourceImageFile);
        BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

        // 创建图形对象
        Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

        // 在右下角添加水印
        int x = sourceImage.getWidth() - watermarkImage.getWidth() - 10;
        int y = sourceImage.getHeight() - watermarkImage.getHeight() - 10;

        // 初始化水印属性
        g2d.drawImage(watermarkImage, x, y, null);
        g2d.dispose();

        // 输出图片文件
        ImageIO.write(sourceImage, "jpg", destImageFile);
    }
}