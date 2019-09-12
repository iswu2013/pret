package com.pret.common.util;

import java.io.File;
import java.util.Date;

public class DeleteFileUtil {
    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName, Date date) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(file, date);
            else
                return deleteDirectory(fileName, date);
        }
    }

    /**
     * 删除单个文件
     *
     * @param file 要删除的文件
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(File file, Date date) {
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            System.out.print(file.lastModified());
            if (file.lastModified() < date.getTime() && file.delete()) {
                System.out.println("删除单个文件" + file.getName() + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + file.getName() + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + file.getName() + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir, Date date) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                DeleteFileUtil.deleteFile(files[i], date);
            } else if (files[i].isDirectory()) {
                DeleteFileUtil.deleteDirectory(files[i]
                        .getAbsolutePath(), date);
            }
        }

        String backupPath = "/usr/local/apllo/backup/";
        if (!dirFile.getAbsoluteFile().equals(backupPath)) {
            dirFile.delete();
        }

        return true;
    }


    public static void delDir(File file, Date date) {
        if (file.isDirectory()) {
            File zFiles[] = file.listFiles();
            for (File file2 : zFiles) {
                delDir(file2, date);
            }
            System.out.print(file.lastModified() + ":" + date.getTime());
            if (file.lastModified() < date.getTime() || Long.parseLong(file.getName()) < date.getTime()) {
                file.delete();
            }

        } else {
            System.out.print(file.lastModified() + ":" + date.getTime());
            if (file.lastModified() < date.getTime()) {
                file.delete();
            }
        }
    }
}
