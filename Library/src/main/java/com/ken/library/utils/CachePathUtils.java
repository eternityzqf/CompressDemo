package com.ken.library.utils;

import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Create by zqf 2019/2/1
 * class desc
 */
public class CachePathUtils {

    public CachePathUtils() {
    }

    private static File getCameraCacheDir(String fileName) {
        File cache = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return cache.mkdirs() || cache.exists() && cache.isDirectory() ? new File(cache, fileName) : null;
    }

    private static String getBaseFileName() {
        return (new SimpleDateFormat("yyyyMMDD_HHmmss", Locale.ENGLISH).format(new Date()));
    }

    public static File getCameraCacheFile() {
        String filename = "camera_" + getBaseFileName() + ".jpg";
        return getCameraCacheDir(filename);
    }
}
