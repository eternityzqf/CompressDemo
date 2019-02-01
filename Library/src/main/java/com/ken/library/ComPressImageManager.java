package com.ken.library;

import com.ken.library.bean.Photo;
import com.ken.library.config.ComPressConfig;
import com.ken.library.core.CompressImageUtil;
import com.ken.library.listener.CompressImage;

import java.util.ArrayList;

/**
 * Create by zqf 2019/1/30
 * class desc 压缩图片管理类
 */
public class ComPressImageManager implements CompressImage {

    private CompressImageUtil compressImageUtil;
    private ArrayList<Photo> images;
    private CompressImage.CompressListener listener;
    private ComPressConfig config;

    @Override
    public void compress() {

    }
}
