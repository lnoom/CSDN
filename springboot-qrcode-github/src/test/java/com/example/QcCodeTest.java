package com.example;

import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenWrapper;
import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeOptions;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-24 11:44
 */
@SpringBootTest
public class QcCodeTest {
    @Test
    public void test() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 生成二维码，并输出为qr.png图片
        boolean ans = QrCodeGenWrapper.of(msg).asFile("src/main/resources/qr.png");
    }

    /**
     * 圆角二维码生成
     */
    @Test
    public void test02() {
        try {
            // 生成二维码，并输出为qr.png图片
            String msg = "https://blog.csdn.net/m0_53127626";
            boolean ans = QrCodeGenWrapper.of(msg)
                    .setW(500)
                    .setPadding(3)
                    // 圆角二维码, 不建议使用圆形的二维码，会导致生成的二维码不可用
                    .setQrStyle(QrCodeOptions.ImgStyle.ROUND)
                    // 圆角弧度默认是宽高的 1/8, 可以根据需要自行设置
                    .setQrCornerRadiusRate(0.125F)
                    .setPicType("png")
                    .asFile("src/main/resources/qr2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        boolean ans = QrCodeGenWrapper.of(msg)
                .setW(300)
                // 探测图形特殊处理
                .setDetectSpecial()
                // 定位点(探测图形)外边颜色
                .setDetectOutColor(Color.CYAN)
                // 定位点内部颜色
                .setDetectInColor(Color.RED)
                // 二维码着色点
                .setDrawPreColor(Color.BLUE)
                // 二维码背景图
                .setDrawBgColor(0xffffffff)
                .asFile("src/main/resources/qr3.png");

    }

    @Test
    public void test04() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 这里的图片地址，支持网络图片，本地相对路劲图片，本地绝对路径图片
        String logo = "https://profile-avatar.csdnimg.cn/8fbb637b12fc4276932d5631f421e5ea_m0_53127626.jpg!1";
        boolean ans = QrCodeGenWrapper.of(msg)
                .setLogo(logo)
                .setLogoStyle(QrCodeOptions.LogoStyle.ROUND)
                .setLogoBgColor(0xfffefefe)
                .setLogoBorderBgColor(0xffc7c7c7)
                .setLogoBorder(true)
                .asFile("src/main/resources/qr4.png");
    }

    @Test
    public void test05() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 这里的图片地址，支持网络图片，本地相对路劲图片，本地绝对路径图片
        String logo = "https://profile-avatar.csdnimg.cn/8fbb637b12fc4276932d5631f421e5ea_m0_53127626.jpg!1";
        boolean ans = QrCodeGenWrapper.of(msg)
                .setW(400)
                .setLogo(logo)
                // 圆形logo支持
                .setLogoStyle(QrCodeOptions.LogoStyle.CIRCLE)
                .setLogoBgColor(0xfffefefe)
                .setLogoBorderBgColor(0xffc7c7c7)
                .setLogoBorder(true)
                .asFile("src/main/resources/qr5.png");
    }

    @Test
    public void test06() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 这里的图片地址，支持网络图片，本地相对路劲图片，本地绝对路径图片
        String bg = "https://img2.baidu.com/it/u=2564921989,1524882583&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500";
        boolean ans = QrCodeGenWrapper.of(msg)
                .setBgImg(bg)
                .setW(500)
                .setBgOpacity(0.5f)
                .asFile("src/main/resources/qr6.png");
    }

    @Test
    public void test07() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 这里的图片地址，支持网络图片，本地相对路劲图片，本地绝对路径图片
        int size = 500;
            boolean ans = QrCodeGenWrapper.of(msg)
                    .setW(size)
                    .setH(size)
                    // 不指定text时，默认文本为千字文，宋体加粗
                    .setQrText("奇遇少年")
                    .setDetectSpecial()
                    .setErrorCorrection(ErrorCorrectionLevel.H)
                    .setDrawStyle(QrCodeOptions.DrawStyle.TXT)
                    .setPicType("png")
                    .asFile("src/main/resources/qr7.png");
    }

    @Test
    public void test08() throws IOException, WriterException {
        String msg = "https://blog.csdn.net/m0_53127626";
        // 这里的图片地址，支持网络图片，本地相对路劲图片，本地绝对路径图片
        String bg = "https://5b0988e595225.cdn.sohucs.com/images/20190502/ae86d1b2f3e84ad7b29d91fa143c738a.gif";
        boolean ans = QrCodeGenWrapper.of(msg)
                .setW(500)
                .setBgImg(bg)
                .setBgOpacity(0.6f)
                .setPicType("gif")
                .asFile("src/main/resources/qr8.gif");
    }


}
