package com.mxy.hearthstone.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    private static final int BUFFER = 1024;

    public static void decompress(File paramFile) throws Exception {
        decompress(paramFile, paramFile.getParent());
    }

    public static void decompress(File paramFile1, File paramFile2) throws Exception {
        ZipInputStream localZipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(paramFile1), new CRC32()));
        decompress(paramFile2, localZipInputStream);
        localZipInputStream.close();
    }

    public static void decompress(File paramFile, String paramString) throws Exception {
        decompress(paramFile, new File(paramString));
    }

    public static void decompress(File paramFile, ZipInputStream paramZipInputStream) throws Exception {
        ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
        if (localZipEntry == null)
            return;
        File localFile = new File(paramFile.getPath() + File.separator + localZipEntry.getName());
        fileProber(localFile);
        if (localZipEntry.isDirectory())
            localFile.mkdirs();
        // 反编译有问题
            decompressFile(localFile, paramZipInputStream);
        while (true) {
            paramZipInputStream.closeEntry();
            break;
        }
    }

    public static void decompress(String paramString) throws Exception {
        decompress(new File(paramString));
    }

    public static void decompress(String paramString1, String paramString2) throws Exception {
        decompress(new File(paramString1), paramString2);
    }

    private static void decompressFile(File paramFile, ZipInputStream paramZipInputStream) throws Exception {
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
        byte[] arrayOfByte = new byte[1024];
        while (true) {
            int i = paramZipInputStream.read(arrayOfByte, 0, 1024);
            if (i == -1) {
                localBufferedOutputStream.close();
                return;
            }
            localBufferedOutputStream.write(arrayOfByte, 0, i);
        }
    }

    private static void fileProber(File paramFile) {
        File localFile = paramFile.getParentFile();
        if (!localFile.exists()) {
            fileProber(localFile);
            localFile.mkdir();
        }
    }
}