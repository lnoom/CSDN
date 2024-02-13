package com.yu.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yu.pojo.User;
import com.yu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    //查询所有
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request){
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
        return "index";
    }

    //导入excel
    @RequestMapping("/import")
    public String importExcel(MultipartFile excelFile) throws Exception {
        log.info("文件名称： [{}]",excelFile.getOriginalFilename());
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//设置一级标题行为1行
        params.setHeadRows(1);//设置header标题为1行
        List<User> users;
        try (InputStream inputStream = excelFile.getInputStream()) {
            users = ExcelImportUtil.importExcel(inputStream, User.class, params);
        }
        log.info("导入总数为： [{}]", users.size());
        userService.saveAll(users);
        return "redirect:/user/findAll";
    }


    //导出excel
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response, HttpServletRequest request) throws IOException {

        List<User> users = userService.findAll();
        users.forEach(user -> {
            try {
                Excel excelAnn = user.getClass().getDeclaredField("photo").getAnnotation(Excel.class);
                user.setPhoto(excelAnn.savePath()+'/'+user.getPhoto());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        });
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户列表", "用户信息"), User.class, users);
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户信息表.xls","UTF-8"));
        ServletOutputStream os = response.getOutputStream();
        workbook.write(os);
        os.close();
        workbook.close();
    }

}
