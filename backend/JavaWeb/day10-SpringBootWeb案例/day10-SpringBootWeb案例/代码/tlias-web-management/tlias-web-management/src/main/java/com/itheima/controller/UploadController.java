package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @wwj
 * @date
 */
@Slf4j
@RestController
public class UploadController {

//本地存储
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//       log.info("文件上传：{},{},{}",username,age,image);
//    String originFilename=image.getOriginalFilename();
////构造唯一的文件名--uuid
//        int index=originFilename.lastIndexOf(".");
//        String ext=originFilename.substring(index);
//        String newFileName= UUID.randomUUID().toString()+ext;
//
//        log.info("新文件名：{}",newFileName);
//
//
//    image.transferTo(new File("F:\\1111\\黑马程序员\\JavaWeb\\day11-SpringBootWeb案例"+newFileName));
//     return Result.success();
//    }
@Autowired
private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
public Result upload(MultipartFile image) throws IOException {
    log.info("文件上传：{}",image.getOriginalFilename());
    //调用阿里云文件上传工具类
     String url=aliOSSUtils.upload(image);
log.info("文件上传成功，文件访问路径为：{}",url);
return Result.success(url);

}










}
