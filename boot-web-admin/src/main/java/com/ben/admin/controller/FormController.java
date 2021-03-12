package com.ben.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {

    @GetMapping("form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("email") String email,
                             @RequestParam("nickname") String nickname,
                             @RequestParam("headerImg") MultipartFile headerImg,
                             @RequestParam("photos") MultipartFile[] photos) throws IOException {
        //日志输出，检测是否成功接收到了参数
        log.info("email:{},nickname:{},headerImg.size={},photos.count={}",
                email, nickname, headerImg.getSize(), photos.length);

        //把接收到的文件输出到指定目录：
        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\TestE\\upload\\" + originalFilename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:/TestE/upload/" + originalFilename));
                }
            }
        }

        return "main";
    }

}
