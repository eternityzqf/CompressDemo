package com.ken.library.bean;

import java.io.Serializable;

/**
 * Create by zqf 2019/1/30
 * class desc
 */
public class Photo implements Serializable {

    //源文件路径
    private String originalPath;
    //是否压缩过
    private boolean compressed;
    //压缩后的路径
    private String compressPath;

    public Photo(String originPath) { this.originalPath = originPath; }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    public String getCompressPath() {
        return compressPath;
    }

    public void setCompressPath(String compressPath) {
        this.compressPath = compressPath;
    }
}
