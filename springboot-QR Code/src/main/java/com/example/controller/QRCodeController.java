package com.example.controller;

import com.example.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    // 使用@GetMapping注解，表示这是一个处理HTTP GET请求的方法。
    // value属性指定了该方法对应的URL路径为"/generateQRCode"。
    // produces属性指定了该方法返回的数据类型，即PNG格式的图片。
    @GetMapping(value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCode(@RequestParam String content,
                                 @RequestParam(defaultValue = "200") int width,
                                 @RequestParam(defaultValue = "200") int height) {
        // 调用qrCodeService的generateQRCode方法来生成二维码。
        // 传入二维码的内容、宽度和高度作为参数。
        return qrCodeService.generateQRCode(content, width, height);
    }

    /**
     * 生成带有Logo的二维码的API接口
     *
     * @GetMapping 注解表示这是一个处理HTTP GET请求的方法，并映射到"/generateQRCodeWithLogo"路径。
     * @RequestParam 注解用于从请求中获取参数。
     * @RequestParam(defaultValue = "200") 表示如果请求中没有提供该参数，则使用默认值"200"。
     * @Produces 注解指定此方法将产生或接受的媒体类型为"image/png"。
     *
     * @param content 二维码的内容，将从请求中获取。
     * @param width 二维码的宽度，将从请求中获取，默认为200。
     * @param height 二维码的高度，将从请求中获取，默认为200。
     *
     * @return 返回生成的带有Logo的二维码的字节数组。
     */

    @GetMapping(value = "/generateQRCodeWithLogo", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCodeWithLogo(@RequestParam String content,
                                         @RequestParam(defaultValue = "200") int width,
                                         @RequestParam(defaultValue = "200") int height) {
        return qrCodeService.generateQRCodeWithLogo(content, width, height);
    }
}
