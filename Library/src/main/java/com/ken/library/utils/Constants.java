package com.ken.library.utils;

import android.os.Environment;

/**
 * Create by zqf 2019/1/31
 * class desc
 */
public class Constants {

    //拍照
    public final static int CAMERA_CODE = 1001;
    //相册
    public final static int ALBUM_CODE = 1002;
    //缓存根目录
    public final static String BASE_CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/";
    //缓存文件夹
    public final static String COMPRESS_CACHE = "compress_cache";
}
