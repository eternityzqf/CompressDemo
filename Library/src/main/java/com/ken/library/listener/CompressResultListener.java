package com.ken.library.listener;

/**
 * Create by zqf 2019/1/31
 * class desc 单张图片压缩时的监听
 */
public interface CompressResultListener {

    //成功
    void onCompressSuccess(String imagePath);

    //失败
    void onCompressFailed(String imagePath, String error);
}
