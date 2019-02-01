package com.ken.library.listener;

import com.ken.library.bean.Photo;

import java.util.ArrayList;

/**
 * Create by zqf 2019/1/31
 * class desc 图片集合的压缩返回
 */
public interface CompressImage {

    //开始压缩
    void compress();

    //图片集合的压缩结果返回
    interface CompressListener {
        //成功
        void onCompressSuccess(ArrayList<Photo> arrayList);

        //失败
        void onCompressFailed(ArrayList<Photo> arrayList, String error);
    }
}
