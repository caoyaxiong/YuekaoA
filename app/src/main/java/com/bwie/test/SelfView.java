package com.bwie.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelXorXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 15:52
 */

public class SelfView extends View {
    public static final int out = 0;
    public static final int donw = 1;
    public static final int in = 2;
    private Paint paint = new Paint();
    private float x;
    private float y;
    private int width;
    private int hight;
    private CallBackToData backToData;
    private float xx;
    private float yy;

    public SelfView(Context context) {
        super(context);
    }

    public SelfView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
    }

   

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth() / 2;
        hight = getHeight() / 2;
        Rect rect = new Rect(width - 80, hight - 80, width + 80, hight + 80);
        canvas.drawRect(rect, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(width, hight, 80, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(width, hight, 40, paint);
        paint.setColor(Color.BLACK);
        String text = "圆环";
        int i = text.length() / 2;
        paint.setTextSize(30);
        canvas.drawText(text, width - i, hight + 15, paint);
    }

    //判断点击位置
    private int weizhi(float x, float y) {
        int type = 0;
        double sqrt = Math.sqrt(Math.pow(x - width, 2) + Math.pow(y - hight, 2));
        if (sqrt > 80) {
            type = SelfView.out;
        } else if (sqrt >= 40 && sqrt <= 80) {
            type = SelfView.donw;
        } else if (sqrt < 40) {
            type = SelfView.in;
        }
        return type;
    }
    public void setMyCallBack(CallBackToData callBack) {
        this.backToData = callBack;
    }
    //监听事件

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                xx = event.getX();
                yy = event.getY();
            if (x == xx && y == yy) {
                int type = weizhi(xx, yy);
                if (backToData != null) {
                    backToData.listener(type);
                }
            }


        }
        return true;
    }
}
