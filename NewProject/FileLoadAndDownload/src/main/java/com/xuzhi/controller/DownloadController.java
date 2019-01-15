package com.xuzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/download")
public class DownloadController {

    //定义一个文件下载的路径
    private static String DownloadPath="F:/TestFiles/";

    //
    @RequestMapping("/down")
    public String download(HttpServletResponse response){
        //通过输出流写入到客户端
        //1、获取文件下载名
        String fileName="Windows10.iso";

        //2、构建一个文件对象通过Paths工具类获取一个Path对象
        Path path = Paths.get(DownloadPath, fileName);

        //3、判断文件是否存在
        if(Files.exists(path)){
            //存在则此下载
            //通过response设定它响应的类型
            //4、获取文件的后缀，即获取文件的类型
            String fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1);

            //5、设置contentType，只有指定他才能下载文件
            response.setContentType("application/"+fileSuffix);

            //6、添加头信息
            //因为是springmvc只能处理ISO8859-1，所以要将文件名通过UTF-8提取出字节流名称再转换成标准的ISO8859-1
            try {
                response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //7、通过path写出该文件
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
