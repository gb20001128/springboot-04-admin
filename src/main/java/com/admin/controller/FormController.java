package com.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    //接收发来的文件并保存在磁盘里(MultipartFile:自动封装上传过来的文件)
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息:email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            //保存到文件服务器,OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\cache\\"+originalFilename));//转成文件
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\"+originalFilename));
                }
            }
        }


        return "main";
    }

    /*实现文件下载*/
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象(这个对象全局唯一,而且工程内部的所有servlet都共享这个对象)
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径(在电脑硬盘上的存储位置)
        //String realPath = servletContext.getRealPath("/static/tt.mp4");
        //System.out.println(realPath);
        //创建输入流,导向该文件
        InputStream is = new FileInputStream("E:\\cache\\Java 学习路线图.jpg");
        //创建与文件一样大小的字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字(固定的)
        headers.add("Content-Disposition", "attachment;filename=tt.jpg");
        //设置响应状态码:成功响应
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        //将带有文件下载的响应实体响应给浏览器
        return responseEntity;
    }
}
