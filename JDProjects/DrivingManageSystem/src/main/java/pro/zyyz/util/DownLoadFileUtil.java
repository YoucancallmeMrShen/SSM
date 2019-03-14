package pro.zyyz.util;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownLoadFileUtil {

    /**
     * 将inputString流写入文件并下载到客户端
     * @param response
     * @param inputStream
     * @param fileType
     */
    public static String downFile(String fileName, String fileType){
        //设置文件路径
        String filePath = "C:/File";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建文件
        String creatFileName = "/" + fileName + "." + fileType;
        File creatFile = new File(filePath + creatFileName);
        try {
            if( !creatFile.exists()) {
                creatFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return creatFile.getPath();
    }


}
