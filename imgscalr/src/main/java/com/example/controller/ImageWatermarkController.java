package com.example.controller;

import com.example.service.ImageWatermarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/images")
public class ImageWatermarkController {

    @Autowired
    private ImageWatermarkService imageWatermarkService;

    @PostMapping("/watermark")
    public ResponseEntity<String> uploadAndAddWatermark(
            @RequestParam("image") MultipartFile image,
            @RequestParam("watermark") MultipartFile watermark) {

        try {
            // 存储图片到本地用于处理
            File sourceImageFile = new File(image.getOriginalFilename());
            System.out.println("image.getOriginalFilename()"+image.getOriginalFilename());
            System.out.println("sourceImageFile"+sourceImageFile);
            image.transferTo(sourceImageFile);

            File watermarkImageFile = new File(watermark.getOriginalFilename());
            System.out.println(watermark.getOriginalFilename());
            watermark.transferTo(watermarkImageFile);
            System.out.println("11111111111111");

            // 处理图片，添加水印
            File destImageFile = new File("watermarked_" + sourceImageFile.getName());
            System.out.println("2222222222222222222222222222222");

            imageWatermarkService.addImageWatermark(watermarkImageFile, sourceImageFile, destImageFile);
            System.out.println("3333333333333333333333");

            // 返回处理后的图片路径
            return ResponseEntity.ok(destImageFile.getPath());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error processing image.");
        }
    }
}