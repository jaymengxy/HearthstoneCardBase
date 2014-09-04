package com.mxy.hearthstone.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    public static void ectract(ZipInputStream zins, String sDestPath) {
        try {
            //            // 先指定压缩档的位置和档名，建立FileInputStream对象
            //            FileInputStream fins = new FileInputStream(sZipPathFile);
            //            // 将fins传入ZipInputStream中
            //            ZipInputStream zins = new ZipInputStream(fins);
            ZipEntry ze = null;
            byte ch[] = new byte[8192];
            while ((ze = zins.getNextEntry()) != null) {
                File zfile = new File(sDestPath + ze.getName());
                File fpath = new File(zfile.getParentFile().getPath());
                if (ze.isDirectory()) {
                    if (!zfile.exists())
                        zfile.mkdirs();
                    zins.closeEntry();
                } else {
                    if (!fpath.exists())
                        fpath.mkdirs();
                    FileOutputStream fouts = new FileOutputStream(zfile);
                    int i;
                    while ((i = zins.read(ch)) != -1)
                        fouts.write(ch, 0, i);
                    zins.closeEntry();
                    fouts.close();
                }
            }
            zins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}