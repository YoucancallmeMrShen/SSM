package com.xuzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    private static String uploadPath="I:/newFile/";

    /**
     * 文件上传要处理的问题
     * 1、传到哪里去；2、要传什么东西；3、文件传输的细节
     * @param multipartFile
     * @return
     */
    @RequestMapping("/upload")
    public String upload2(@RequestParam("upload")MultipartFile multipartFile, Model model){

        //1、判断上传的文件是否为空
        if(multipartFile!=null && !multipartFile.isEmpty()){
            //2、获取上传文件的原始文件名
            String originalFilename = multipartFile.getOriginalFilename();

            //3、截取源文件名的前缀，不带后缀
            String fileNamePrefix=originalFilename.substring(0,originalFilename.lastIndexOf("."));

            //4、加工处理原文件名，原文件名+时间戳
            String newFileNameProfix=fileNamePrefix+new Date().getTime();

            //5、得到新的文件名
            String newFileName=newFileNameProfix+originalFilename.substring(originalFilename.lastIndexOf("."));

            //6、构建文件对象
            File file =new File(uploadPath+newFileName);

            //7、上传
            try {
                multipartFile.transferTo(file);
                model.addAttribute("fileName",newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    @RequestMapping("/upload2")
    public String upload(@RequestParam("upload")MultipartFile[] multipartFiles, Model model){
        List<String> fileName=new ArrayList<>();
        if(multipartFiles!=null && multipartFiles.length>0){
            for(MultipartFile multipartFile:multipartFiles){
                //1、判断上传的文件是否为空
                if(multipartFile!=null && !multipartFile.isEmpty()){
                    //2、获取上传文件的原始文件名
                    String originalFilename = multipartFile.getOriginalFilename();

                    //3、截取源文件名的前缀，不带后缀
                    String fileNamePrefix=originalFilename.substring(0,originalFilename.lastIndexOf("."));

                    //4、加工处理原文件名，原文件名+时间戳
                    String newFileNameProfix=fileNamePrefix+new Date().getTime();

                    //5、得到新的文件名
                    String newFileName=newFileNameProfix+originalFilename.substring(originalFilename.lastIndexOf("."));

                    //6、构建文件对象
                    File file =new File(uploadPath+newFileName);

                    //7、上传
                    try {
                        multipartFile.transferTo(file);
                        fileName.add(newFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        model.addAttribute("fileNames",fileName);
        return "success2";
    }
}
