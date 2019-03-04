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

    private CompressImageUtil compressImageUtil;//压缩工具类
    private ArrayList<Photo> images;//要压缩的图片集合
    private CompressImage.CompressListener listener;//压缩监听
    private ComPressConfig config;//压缩配置


    @Override
    public void compress() {

    }
}
