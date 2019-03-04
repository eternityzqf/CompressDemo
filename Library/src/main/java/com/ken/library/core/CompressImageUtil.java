package com.ken.library.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import com.ken.library.config.ComPressConfig;
import com.ken.library.listener.CompressResultListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Create by zqf 2019/1/31
 * class desc 压缩照片
 */
public class CompressImageUtil {

    private ComPressConfig config;
    private Context context;
    private android.os.Handler mhHandler = new Handler();

    public CompressImageUtil(Context context, ComPressConfig config) {
        this.context = context;
        this.config = config == null ? ComPressConfig.getDefaultComPressConfig() : config;
    }

    public void compress(String imgPath, CompressResultListener listener) {
        if (config.isEnablePixelCompress()) {
            try {
                compressImageByPixel(imgPath, listener);
            } catch (Exception e) {
                listener.onCompressFailed(imgPath, String.format("图片压缩失败,%s", e.toString()));
            }
        } else {
            compressImageByQualit(BitmapFactory.decodeFile(imgPath), imgPath, listener);
        }
    }

    /**
     * 图片像素压缩
     *
     * @param imgPath  路径
     * @param listener 监听
     */
    private void compressImageByPixel(String imgPath, CompressResultListener listener) {

    }

    /**
     * 多线程的图片质量压缩
     *
     * @param bitmap   bitmao
     * @param imgPath  路径
     * @param listener 压缩的监听
     */
    private void compressImageByQualit(final Bitmap bitmap, final String imgPath, final CompressResultListener listener) {
        if (bitmap == null) {
            sendMsg(false, imgPath, "像素压缩失败，Bitmap为空", listener);
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int options = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
                while (baos.toByteArray().length > config.getMaxSize()) {
                    baos.reset();//重置baos
                    options -= 5;//图片质量每次减少5
                    if (options <= 5) options = 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
                    if (options == 5) break;
                }
                try {
                    File thumbnailFile = getThumbnailFile(new File(imgPath));
                    FileOutputStream fos = new FileOutputStream(thumbnailFile);
                    fos.write(baos.toByteArray());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 发送消息
     *
     * @param b        是否
     * @param imgPath  路径
     * @param s        失败提示语
     * @param listener 监听
     */
    private void sendMsg(boolean b, String imgPath, String s, CompressResultListener listener) {

    }

    /**
     * 得到缩略图
     *
     * @param file 文件
     * @return 返回
     */
    private File getThumbnailFile(File file) {
        return null;
    }
}
