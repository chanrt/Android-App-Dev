package com.example.bounce;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private float x, y, radius;
    private float vx, vy;
    private Paint white;
    private int sWidth;

    public void init(int x, int y, int radius, float vx, float vy, int sWidth)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.vx = vx;
        this.vy = vy;
        this.sWidth = sWidth;

        white = new Paint();
        white.setColor(Color.WHITE);
    }

    public void move()
    {
        x = x + vx;
        y = y + vy;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(x, y, radius, white);
    }

    public void accelerate(int score)
    {
        if(score == 10) vy = 1.2f * vy;
        else if(score == 20) vy = 1.15f * vy;
        else if(score == 30) vy = 1.1f * vy;
        else vy = 1.1f * vy;
    }

    public void reflectY()
    {
        vy = -vy;
    }

    public void reflectX()
    {
        vx = -vx;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void nudgeLeft()
    {
        if(vx > 0) vx = - (float) sWidth / 180;
        else vx = 1.1f * vx;
    }

    public void nudgeRight()
    {
        if(vx < 0) vx = (float) sWidth / 180;
        else vx = 1.1f * vx;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getRadius()
    {
        return radius;
    }

    public float getVx()
    {
        return vx;
    }

    public float getVy()
    {
        return vy;
    }
}
