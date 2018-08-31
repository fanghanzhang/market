package com.ironghui.marketdemo.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CircularImageView extends ImageView {
    private int borderWidth = 6;
    private int viewWidth;
    private int viewHeight;
    private Bitmap bitmap;
    private Paint paint;
    private Paint paintBorder;
    private BitmapShader shader;
    private int action;

    public CircularImageView(Context context) {
        super(context);
        init();
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private int measureWidth(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY)
            return specSize;
        return viewWidth;
    }

    private int measureHeight(int measureSpecHeight, int measureSpecWidth) {
        int specMode = View.MeasureSpec.getMode(measureSpecHeight);
        int specSize = View.MeasureSpec.getSize(measureSpecHeight);
        if (specMode == MeasureSpec.EXACTLY)
            return specSize;
        return viewHeight;
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
        setBorderColor(Color.WHITE);
    }

    public void setBorderColor() {
        setBorderColor(Color.TRANSPARENT);
    }

    public void setBorderColor(int rscId) {
        if (this.paintBorder != null)
            this.paintBorder.setColor(rscId);
        invalidate();
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable != null) {
                    bitmap = bitmapDrawable.getBitmap();
                }
            } else if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                BitmapDrawable bitmapDrawable = (BitmapDrawable) transitionDrawable
                        .getDrawable(transitionDrawable.getNumberOfLayers() - 1);
                if (bitmapDrawable != null) {
                    bitmap = bitmapDrawable.getBitmap();
                }

            }
            if (bitmap != null) {
                shader = new BitmapShader(Bitmap.createScaledBitmap(bitmap,
                        viewWidth, viewHeight, false), Shader.TileMode.CLAMP,
                        Shader.TileMode.CLAMP);
                paint.setShader(shader);
                int circleCenter = viewWidth / 2;
                canvas.drawCircle(circleCenter, circleCenter, circleCenter,
                        paintBorder);
                canvas.drawCircle(circleCenter, circleCenter, circleCenter
                        - borderWidth, paint);
            }
            switch (this.action) {
                case MotionEvent.ACTION_DOWN :
                    setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                default :
            }
            clearColorFilter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        viewWidth = measureWidth(widthMeasureSpec);
        viewHeight = measureHeight(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(viewWidth, viewHeight);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        action = ev.getAction();
        return super.onTouchEvent(ev);
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        invalidate();
    }
}
