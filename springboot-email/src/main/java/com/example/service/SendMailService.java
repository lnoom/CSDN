package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-21 11:04
 */
public interface SendMailService {
    public String sendSimpleMail(String address, String subject, String body);
    public String sendAttachmentMail(String address, String subject, String body, MultipartFile attach) throws MessagingException, IOException;
}
