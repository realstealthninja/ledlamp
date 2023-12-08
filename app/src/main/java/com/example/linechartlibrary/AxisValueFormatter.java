package com.example.linechartlibrary;

/* loaded from: classes.dex */
public interface AxisValueFormatter {
    int formatValueForAutoGeneratedAxis(char[] cArr, float f, int i);

    int formatValueForManualAxis(char[] cArr, AxisValue axisValue);
}
