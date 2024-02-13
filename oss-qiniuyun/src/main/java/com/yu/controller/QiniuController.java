package com.yu.controller;

import com.qiniu.storage.model.FileInfo;
import com.yu.utils.QiniuUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/qiniu")
public class QiniuController {

    @Resource
    QiniuUtil qiniuUtil;


    @RequestMapping("/upload")
    public String upload(String localFilePath) {
        return  qiniuUtil.upload(localFilePath);
    }

    @RequestMapping("/listSpaceFiles")
    public List<String> listSpaceFiles() {
       return qiniuUtil.listSpaceFiles();
    }

    @RequestMapping("/getFileUrl")
    public String getFileUrl(String fileName) {
        try {
           return qiniuUtil.getFileUrl(fileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteFile")
    public String deleteFile(String[] fileList) {
       return qiniuUtil.deleteFile(fileList);
    }
}
