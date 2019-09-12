package com.pret.common.util;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * DateTime: 2016/9/18 21:54
 * 功能：压缩文件为zip
 * 思路：
 */
public class FileZip {

    //测试
    public static void main(String[] args) {
        try {
            zip("G:\\demo", "G:\\demo.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param inputFileName 要压缩的文件夹(整个完整路径)
     * @param zipFileName   压缩后的文件(整个完整路径)
     */
    public static void zip(String inputFileName, String zipFileName) throws Exception {
        zip(zipFileName, new File(inputFileName));
    }

    public static void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, inputFile, "");
        out.flush();
        out.close();
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] f1 = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < f1.length; i++) {
                zip(out, f1[i], base + f1[i].getName());
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            while (-1 != (b = in.read())) {
                out.write(b);
            }
            in.close();
        }
    }

    public static void compress(String srcFilePath, String destFilePath) {
        File src = new File(srcFilePath);
        if (!src.exists()) {
            throw new RuntimeException(srcFilePath + "不存在");
        }
        File zipFile = new File(destFilePath);
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());
            ZipOutputStream zos = new ZipOutputStream(cos);
            String baseDir = "";
            compressbyType(src, zos, baseDir);
            zos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static void compressbyType(File src, ZipOutputStream zos, String baseDir) {
        if (!src.exists())
            return;
        System.out.println("压缩" + baseDir + src.getName());
        if (src.isFile()) {
            compressFile(src, zos, baseDir);
        } else if (src.isDirectory()) {
            compressDir(src, zos, baseDir);
        }
    }


    /**
     * 压缩文件
     */

    private static void compressFile(File file, ZipOutputStream zos, String baseDir) {
        if (!file.exists())
            return;
        try {

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();
        } catch (Exception e) {
        }
    }


    /**
     * 压缩文件夹
     */

    private static void compressDir(File dir, ZipOutputStream zos, String baseDir) {
        if (!dir.exists())
            return;
        File[] files = dir.listFiles();
        if (files.length == 0) {
            try {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName()
                        + File.separator));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
    }
}
