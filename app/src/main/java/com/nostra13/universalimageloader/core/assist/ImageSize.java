package com.nostra13.universalimageloader.core.assist;

import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public ImageSize(int i, int i2, int i3) {
        if (i3 % SubsamplingScaleImageView.ORIENTATION_180 == 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        this.width = i2;
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ImageSize scaleDown(int i) {
        return new ImageSize(this.width / i, this.height / i);
    }

    public ImageSize scale(float f) {
        return new ImageSize((int) (this.width * f), (int) (this.height * f));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.width);
        sb.append(SEPARATOR);
        sb.append(this.height);
        return sb.toString();
    }
}
