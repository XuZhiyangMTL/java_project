package utils;

import java.util.UUID;

//文件上传工具类
public class UploadUtils {
    //生成唯一的文件名 UUID:Universally Unique Identifier
    public static String getUUIDFileName(String fileName){
        //xx.jpg ----> .jpg
        int idx=fileName.lastIndexOf(".");
        String extention=fileName.substring(idx);
        String uuidFileName=UUID.randomUUID().toString().replace("-","")+extention;
        return uuidFileName;
    }
}
