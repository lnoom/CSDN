package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-21 11:05
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String account;

    /**
     * @param address 收件地址
     * @param subject 标题
     * @param body    正文
     * @return
     */
    @Override
    public String sendSimpleMail(String address, String subject, String body) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom(account);
        smm.setTo(address);
        smm.setSubject(subject);
        smm.setText(body);
        javaMailSender.send(smm);
        return "发送成功";
    }

    /**
     * @param address 收件地址
     * @param subject 标题
     * @param body    正文
     * @param attach  附件
     */
    @Override
    public String sendAttachmentMail(String address, String subject, String body, MultipartFile attach) throws MessagingException, IOException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom(account);
        mimeMessageHelper.setTo(new String[]{address});
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        // 获取附件的文件名和后缀名
        String fileName = attach.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 读取附件内容
        byte[] bytes = attach.getBytes();
        // 创建一个新的资源对象来存储附件内容
        ByteArrayResource attachmentResource = new ByteArrayResource(bytes);
        // 添加附件，使用完整的文件名（包括后缀名）
        mimeMessageHelper.addAttachment(fileName, attachmentResource);
        javaMailSender.send(mimeMailMessage);
        return "发送成功";
    }
}
