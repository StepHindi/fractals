package com.example.flying_bolls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tree(canvas, 600, 1600, 350, (float) Math.PI / 2);
    }
    void fractal(Canvas canvas, float x, float y, float r) {
        if (r > 10) {
            Paint p = new Paint();
            p.setStrokeWidth(1);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x, y, r, p);
            fractal(canvas, x, y - r, r / 2);
            fractal(canvas, x, y + r, r / 2);
            fractal(canvas, x - r, y, r / 2);
            fractal(canvas, x + r, y, r / 2);
        }
    }

    void tree(Canvas canvas, float x, float y, float d, float alpha) {
        if (d > 10) {
            float stopX = x + (float) Math.cos(alpha) * d;
            float stopY = y - (float)Math.sin(alpha) * d;
            Paint p = new Paint();
            p.setStrokeWidth(2);
            canvas.drawLine(x, y, stopX, stopY, p);
            tree(canvas, stopX, stopY, d * 2 / 3, alpha + (float) Math.PI / 6);
            tree(canvas, stopX, stopY, d * 2 / 3, alpha - (float) Math.PI / 6);
        }
    }
}
