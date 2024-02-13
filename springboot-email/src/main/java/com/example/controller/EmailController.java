package com.example.controller;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-21 11:02
 */
@RestController
public class EmailController {
    @Autowired
    private SendMailService sendMailService;
    @RequestMapping("/sendMail")
    public String sendMail(String address, String subject, String body) {
       return sendMailService.sendSimpleMail(address, subject, body);

    }
    @RequestMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(String address, String subject, String body, MultipartFile attach) throws IOException, MessagingException {
       return sendMailService.sendAttachmentMail(address, subject, body, attach);
    }
}
