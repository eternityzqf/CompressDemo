package com.ken.library.config;

import java.io.Serializable;

/**
 * Create by zqf 2019/1/30
 * class desc 压缩配置类
 */
public class ComPressConfig implements Serializable {

    //最小像素不压缩
    private int unCompressMinPixel = 1000;
    //标准像素不压缩
    private int unCompressNormalPixel = 2000;
    //长或宽不超过的最大像素
    private int MaxPixel = 1200;
    //压缩到的最大大小 B
    private int MaxSize = 200 * 1024;
    //是否启用像素压缩
    private boolean enablePixelCompress = true;
    //是否启用质量压缩
    private boolean enableQualityCompress = true;
    //是否保留源文件
    private boolean enableReserveRaw = true;
    //压缩后的缓存路径
    private String cacheDir;
    //是否显示压缩进度条
    private boolean showCompressDialog = true;

    //返回默认ComPressConfig
    public static ComPressConfig getDefaultComPressConfig() {
        return new ComPressConfig();
    }

    private ComPressConfig() {
    }

    public int getUnCompressMinPixel() {
        return unCompressMinPixel;
    }

    public void setUnCompressMinPixel(int unCompressMinPixel) {
        this.unCompressMinPixel = unCompressMinPixel;
    }

    public int getUnCompressNormalPixel() {
        return unCompressNormalPixel;
    }

    public void setUnCompressNormalPixel(int unCompressNormalPixel) {
        this.unCompressNormalPixel = unCompressNormalPixel;
    }

    public int getMaxPixel() {
        return MaxPixel;
    }

    public void setMaxPixel(int maxPixel) {
        MaxPixel = maxPixel;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    public boolean isEnablePixelCompress() {
        return enablePixelCompress;
    }

    public void setEnablePixelCompress(boolean enablePixelCompress) {
        this.enablePixelCompress = enablePixelCompress;
    }

    public boolean isEnableQualityCompress() {
        return enableQualityCompress;
    }

    public void setEnableQualityCompress(boolean enableQualityCompress) {
        this.enableQualityCompress = enableQualityCompress;
    }

    public boolean isEnableReserveRaw() {
        return enableReserveRaw;
    }

    public void setEnableReserveRaw(boolean enableReserveRaw) {
        this.enableReserveRaw = enableReserveRaw;
    }

    public String getCacheDir() {
        return cacheDir;
    }

    public void setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    public boolean isShowCompressDialog() {
        return showCompressDialog;
    }

    public void setShowCompressDialog(boolean showCompressDialog) {
        this.showCompressDialog = showCompressDialog;
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        private ComPressConfig config;

        private Builder() {
            this.config = new ComPressConfig();
        }

        public Builder setUnCompressMinPixel(int unCompressMinPixel) {
            config.setUnCompressMinPixel(unCompressMinPixel);
            return this;
        }

        public Builder setUnCompressNormalPixel(int unCompressNormalPixel) {
            config.setUnCompressNormalPixel(unCompressNormalPixel);
            return this;
        }

        public Builder setMaxPixel(int maxPixel) {
            config.setMaxPixel(maxPixel);
            return this;
        }

        public Builder setMaxSize(int maxSize) {
            config.setMaxSize(maxSize);
            return this;
        }

        public Builder setEnablePixelCompress(boolean enablePixelCompress) {
            config.setEnablePixelCompress(enablePixelCompress);
            return this;
        }

        public Builder setEnableQualityCompress(boolean enableQualityCompress) {
            config.setEnablePixelCompress(enableQualityCompress);
            return this;
        }

        public Builder setEnableReserveRaw(boolean enableReserveRaw) {
            config.setEnableReserveRaw(enableReserveRaw);
            return this;
        }

        public Builder setCacheDir(String cacheDir) {
            config.setCacheDir(cacheDir);
            return this;
        }

        public Builder setShowCompressDialog(boolean showCompressDialog) {
            config.setShowCompressDialog(showCompressDialog);
            return this;
        }
    }
}
