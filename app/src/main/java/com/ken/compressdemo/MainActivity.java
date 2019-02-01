package com.ken.compressdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.ken.library.bean.Photo;
import com.ken.library.utils.CachePathUtils;
import com.ken.library.utils.CommonUtils;
import com.ken.library.utils.Constants;
import com.ken.library.utils.UriParseUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class MainActivity extends AppCompatActivity {

    private String test_path = "/storage/emulated/0/MagazineUnlock/MagazinePic-05-2.3.001-bigpicture_05_4.jpg";
    private String cameraCachePath;//拍照的源文件路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            String[] params = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            if (checkSelfPermission(params[0]) == PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(params[1]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(params, 200);
            }
        }
        testLuban();
    }

    private void testLuban() {
        String Cache = Constants.BASE_CACHE_PATH + this.getPackageName() + "/cache/" + Constants.COMPRESS_CACHE;

        Luban.with(this)
                .load(test_path)
                .ignoreBy(100)
                .setTargetDir(Cache)
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Log.e("Tag", "onStart");
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.e("Tag", "onSuccess>>>>" + file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Tag", e.getMessage());
                    }
                }).launch();
    }

    private void album_btn(View view) {
        Uri outputUri;
        File file = CachePathUtils.getCameraCacheFile();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0版本
            outputUri = UriParseUtils.getcameraOutPutUri(this, file);
        } else {
            //小于6.0版本
            outputUri = Uri.fromFile(file);
        }
        cameraCachePath = file.getAbsolutePath();

        CommonUtils.hasCamera(this, CommonUtils.getCameraIntent(outputUri), Constants.CAMERA_CODE);
    }

    private void camera_btn(View view) {
        CommonUtils.openAlbum(this, Constants.ALBUM_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //拍照
        if (requestCode == Constants.CAMERA_CODE && resultCode == RESULT_OK) {
            //开始压缩
            preCompress(cameraCachePath);
        }
        //相册
        if (requestCode == Constants.ALBUM_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                String path = UriParseUtils.getPath(this, uri);
                //集合 或者单张
                preCompress(path);
            }
        }
    }

    //压缩准备
    private void preCompress(String path) {
        ArrayList<Photo> arrayList = new ArrayList<>();
        arrayList.add(new Photo(path));
        if (!arrayList.isEmpty()) compress(arrayList);
    }

    //开始压缩
    private void compress(ArrayList<Photo> arrayList) {

    }
}
