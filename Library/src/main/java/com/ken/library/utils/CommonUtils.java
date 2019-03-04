package com.ken.library.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

/**
 * Create by zqf 2019/2/1
 * class desc
 */
public class CommonUtils {

    /**
     * 判断是否有摄像头
     *
     * @param activity    上下文
     * @param intent      意图
     * @param requestCode 请求码
     */
    public static void hasCamera(Activity activity, Intent intent, int requestCode) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity为空!");
        }
        PackageManager pm = activity.getPackageManager();
        boolean hasCamera = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)
                || pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)
                || android.hardware.Camera.getNumberOfCameras() > 0;
        if (hasCamera) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            Toast.makeText(activity, "当前设备没有摄像头", Toast.LENGTH_SHORT).show();
            throw new IllegalStateException("当前设备没有摄像头");
        }
    }

    //拍照意图
    public static Intent getCameraIntent(Uri outputUri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        return intent;
    }

    //打开相册
    public static void openAlbum(Activity activity, int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("images/*");
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 显示圆形进度框
     *
     * @param activity      上下文
     * @param progressTitle 显示的标题
     * @return ProgressDialog
     */
    public static ProgressDialog showProgressDialog(Activity activity, String... progressTitle) {
        if (activity == null || activity.isFinishing()) return null;
        String title = "提示";
        if (progressTitle != null && progressTitle.length > 0) title = progressTitle[0];
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(title);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
