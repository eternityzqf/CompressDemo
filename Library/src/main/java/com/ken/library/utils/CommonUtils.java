package com.ken.library.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Create by zqf 2019/2/1
 * class desc
 */
public class CommonUtils {

    /**
     * 判断是否有摄像头
     *
     * @param context 上下文
     * @param intent 意图
     * @param requestCode 请求码
     */
    public static void hasCamera(Context context, Intent intent, int requestCode) {

    }

    //拍照意图
    public static Intent getCameraIntent(Uri outputUri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.EXTRA_DOCK_STATE_DESK);
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", outputUri);
        return intent;
    }

    //打开相册
    public static void openAlbum(Activity activity, int requestCode) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("images/*");
        activity.startActivityForResult(intent, requestCode);
    }

}
