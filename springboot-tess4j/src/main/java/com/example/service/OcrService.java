package com.example.service;

import net.sourceforge.tess4j.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;

@Service
public class OcrService {

    public String recognizeText(File imageFile) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        
        // 设定训练文件的位置（如果是标准英文识别，此步可省略）
        tesseract.setDatapath("src/main/resources");
        tesseract.setLanguage("chi_sim");
        return tesseract.doOCR(imageFile);
    }

    public String recognizeTextFromUrl(String imageUrl) throws Exception {
        URL url = new URL(imageUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get("downloaded.jpg"), StandardCopyOption.REPLACE_EXISTING);

        File imageFile = new File("downloaded.jpg");
        return recognizeText(imageFile);
    }
}