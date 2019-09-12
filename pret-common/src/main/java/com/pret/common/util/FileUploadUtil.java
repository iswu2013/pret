package com.pret.common.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上传文件
 *
 * @author jswul
 */
public class FileUploadUtil {

    /**
     * @param file
     *            //文件对象
     * @param filePath
     *            //上传路径
     * @param fileName
     *            //文件名
     * @return 文件名
     */

    /**
     * 上传文件
     *
     * @param file     文件对象
     * @param filePath 上传路径
     * @param fileName 文件名
     * @return
     */
    public static String fileUp(MultipartFile file, String filePath, String fileName) {
        String extName = "";
        try {
            if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            }
            copyFile(file.getInputStream(), filePath, fileName + extName).replaceAll("-", "");
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileName + extName;
    }

    /**
     * 上传微信图片
     *
     * @param inputStream
     * @param filePath
     * @param fileName
     * @param oriName
     * @return
     */
    public static String fileUp(ByteArrayInputStream inputStream, String filePath, String fileName, String oriName) {
        String extName = "";
        try {
            if (oriName.lastIndexOf(".") >= 0) {
                extName = oriName.substring(oriName.lastIndexOf("."));
            }
            copyFile(inputStream, filePath, fileName + extName).replaceAll("-", "");
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileName + extName;
    }

    /**
     * 写到目录中
     *
     * @param in
     * @param dir
     * @param realName
     * @return
     * @throws IOException
     */
    private static String copyFile(InputStream in, String dir, String realName) throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }
}
