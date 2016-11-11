package com.qianfeng.maotuananimation.useractivity.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Bigname on 2016/11/8.
 */
public class CyclemageView extends ImageView {
    Paint paint;

    public CyclemageView(Context context) {
        this(context, null);
    }

    public CyclemageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CyclemageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        paint.reset();//这个是必不可少的
        //这张是设置的图片，根据控件大小进行缩放比例
        Bitmap srcBitmap = ((BitmapDrawable) drawable).getBitmap();
        //缩放步骤
        Matrix matrix = new Matrix();
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        float scale = Math.max(height * 1f / srcBitmap.getHeight(), width * 1f / srcBitmap.getWidth());
        matrix.postScale(scale, scale);
        //得到合适大小的bitmap，最后取圆角
        Bitmap bitmap = Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
        /*
        * 去圆角思路：
        * 创建一个新的画布，且以一张空白bitmap作为画板，把bitmap画进去且再话一个形状取交际
        * */
        Bitmap blankBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(blankBitmap);
        newCanvas.drawCircle(width / 2, width / 2, width / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        newCanvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawBitmap(blankBitmap, 0, 0, null);
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                bitmap.recycle();
            } catch (Exception e) {
                Log.d("bigname_log", "onDraw: " + e.getMessage());
            }
        }
    }
}
