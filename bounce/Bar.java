package com.example.bounce;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Bar {
    private int width, height;
    private float speed;

    private RectF bar_rect = new RectF();
    Paint white = new Paint();

    public void draw(Canvas canvas)
    {
        canvas.drawRect(bar_rect, white);
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = Math.abs(height);
    }

    public void setRect(int x, int y, int player)
    {
        this.bar_rect.left = x;
        this.bar_rect.top = y;
        this.bar_rect.right = x + this.width;

        if(player == 1) this.bar_rect.bottom = y - this.height;
        else this.bar_rect.bottom = y + this.height;

        white.setColor(Color.WHITE);
    }

    public void calcSpeed(int sWidth)
    {
        this.speed = (float) sWidth / 75;
    }

    public void moveRect(int dx)
    {
        if(dx == -1) bar_rect.offset(-speed, 0);
        else if(dx == +1) bar_rect.offset(speed, 0);
    }

    public int checkBounce(float ball_x, float radius)
    {
        if(bar_rect.left < ball_x && ball_x <= bar_rect.left + (float) width / 3) return 2;
        else if(bar_rect.left + (float) width / 3 < ball_x && ball_x < bar_rect.left + 2 * (float) width / 3) return 3;
        else if(bar_rect.left + 2 * (float) width / 3 <= ball_x && ball_x < bar_rect.left + width) return 4;
        else return 0;
    }

    public float getLeft()
    {
        return bar_rect.left;
    }

    public float getRight()
    {
        return bar_rect.right;
    }

    public float getX()
    {
        return bar_rect.centerX();
    }

    public float getTop()
    {
        return bar_rect.top;
    }

    public float getBottom()
    {
        return bar_rect.bottom;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public float getCentreX()
    {
        return bar_rect.left + (float) width / 2;
    }

    public float getSpeed()
    {
        return speed;
    }
}
