package com.example.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeService {
    @Value("${logo.path}")
    private String logoPath;

    // 定义一个名为generateQRCode的公共方法，它接收三个参数：content（字符串类型，表示二维码的内容）、width（整数类型，表示二维码的宽度）和height（整数类型，表示二维码的高度）。
    public byte[] generateQRCode(String content, int width, int height) {
        try {
            // 创建一个名为hints的HashMap对象，用于存储二维码编码的提示信息。
            Map<EncodeHintType, Object> hints = new HashMap<>();
            // 设置错误纠正级别为L，表示较低的纠错能力。
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            // 设置边距为2，即二维码边缘与内容之间的距离为2个像素。
            hints.put(EncodeHintType.MARGIN, 2);
            // 设置字符集为UTF-8，表示二维码支持UTF-8编码的字符。
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // 创建一个QRCodeWriter对象，用于生成二维码。
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 使用QRCodeWriter对象将内容编码为二维码，并指定宽度、高度和提示信息。
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            // 将BitMatrix对象转换为BufferedImage对象，以便于后续处理。
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            // 创建一个ByteArrayOutputStream对象，用于将BufferedImage对象转换为字节数组。
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // 将BufferedImage对象写入到ByteArrayOutputStream对象中，并指定输出格式为png。
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

            // 将ByteArrayOutputStream对象中的数据转换为字节数组，并返回该字节数组。
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            // 如果在生成二维码过程中出现异常，则打印异常信息。
            e.printStackTrace();
            // 返回空字节数组。
            return null;
        }
    }

    /**
     * 生成带有Logo的二维码
     *
     * @param content 二维码的内容
     * @param width 二维码的宽度
     * @param height 二维码的高度
     * @return 带有Logo的二维码的字节数组
     */
    public byte[] generateQRCodeWithLogo(String content, int width, int height) {
        try {
            // 调用方法生成二维码的字节数组
            byte[] qrCodeBytes = generateQRCode(content, width, height);

            // 从字节数组中读取二维码图像
            BufferedImage qrCodeImage = ImageIO.read(new ByteArrayInputStream(qrCodeBytes));
            System.out.println("logoPath"+logoPath);
            // 从指定路径读取Logo图像
            BufferedImage logoImage = ImageIO.read(new File(logoPath));

            // 计算Logo的大小，使其适合二维码的大小
            int logoWidth = qrCodeImage.getWidth() / 5;
            int logoHeight = qrCodeImage.getHeight() / 5;

            // 计算Logo在二维码上的位置，使其居中显示
            int x = (qrCodeImage.getWidth() - logoWidth) / 2;
            int y = (qrCodeImage.getHeight() - logoHeight) / 2;

            // 在二维码上绘制Logo图像
            Graphics2D graphics = qrCodeImage.createGraphics();
            graphics.drawImage(logoImage, x, y, logoWidth, logoHeight, null);
            graphics.dispose();

            // 将带有Logo的二维码转换为PNG格式的字节数组
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(qrCodeImage, "png", byteArrayOutputStream);

            // 返回带有Logo的二维码的字节数组
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            // 打印异常堆栈信息
            e.printStackTrace();
            // 返回空字节数组（表示失败）
            return null;
        }
    }
}
