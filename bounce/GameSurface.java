package com.example.bounce;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

    private int sWidth, sHeight;
    private boolean moveLeft, moveRight;
    private float tolerance;
    private int top_down_margin;
    private boolean gamePaused;

    // declare game objects
    private GameThread gameThread;
    private Bar playerBar, aiBar;
    private Ball ball;
    private int aiTarget;
    private boolean targeted, locked;
    private int playerScore, computerScore, totalScore, runningScore;
    private String p_string, c_string, s_string, r_string;
    private MediaPlayer background, wall_hit, bar_hit, fail_hit;
    Paint white;

    public void pauseGame()
    {
        gamePaused = true;
    }

    public void resumeGame()
    {
        gamePaused = false;
    }

    public void stopBackground()
    {
        background.stop();
    }

    public GameSurface(Context context)  {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);

        background = MediaPlayer.create(context, R.raw.electro_pop);
        wall_hit = MediaPlayer.create(context, R.raw.wall_hit);
        bar_hit = MediaPlayer.create(context, R.raw.bar_hit);
        fail_hit = MediaPlayer.create(context, R.raw.fail);

        background.setLooping(true); // Set looping
        background.setVolume(100, 100);
        wall_hit.setVolume(100, 100);
        bar_hit.setVolume(90, 90);
        fail_hit.setVolume(90, 90);
    }

    public void update() throws IOException {
        if(!locked && moveLeft && playerBar.getLeft() > 0 && !gamePaused) playerBar.moveRect(-1);
        if(!locked && moveRight && playerBar.getRight() < sWidth && !gamePaused) playerBar.moveRect(+1);

        if(aiBar.getCentreX() - aiBar.getSpeed() < aiTarget && aiTarget < aiBar.getCentreX() + aiBar.getSpeed())
        {
            if(!targeted && !gamePaused && ball.getVy() < 0 && !targeted && ball.getY() < (float) sHeight / 3) ai(3);
        }
        else
        {
            if(!gamePaused && aiBar.getCentreX() < aiTarget && aiBar.getRight() < sWidth)  aiBar.moveRect(1);
            else if(!gamePaused && aiBar.getCentreX() > aiTarget && aiBar.getLeft() > 0) aiBar.moveRect(-1);
        }

        if(!gamePaused)
        {
            ball.move();

            if(ball.getX() < 0)
            {
                ball.setX(0);
                ball.reflectX();
                wall_hit.start();
            }
            else if(ball.getX() > sWidth)
            {
                ball.setX(sWidth);
                ball.reflectX();
                wall_hit.start();
            }
        }

        if(!locked && ball.getY() + ball.getRadius() - tolerance < playerBar.getTop() && ball.getY() + ball.getRadius() + tolerance > playerBar.getTop())
        {
            int direction = playerBar.checkBounce(ball.getX(), ball.getRadius());
            if(direction > 1 && direction < 5)
            {
                ball.reflectY();
                bar_hit.start();
                if(runningScore % 10 == 0) ball.accelerate(runningScore);
                if(runningScore == 2)
                {
                    background.start();
                }
                totalScore++;
                runningScore++;
                r_string = "Running score: " + runningScore;
                s_string = "Score: " + totalScore;
            }
            if(direction == 2)
            {
                ball.nudgeLeft();
            }
            else if(direction == 4)
            {
                ball.nudgeRight();
            }
            if(direction == 0)
            {
                computerScore++;
                locked = true;
                background.stop();
                fail_hit.start();
                background.prepare();
                runningScore = 0;
                r_string = "Running score: " + runningScore;
            }
            else
            {
                ai(2);
            }
        }
        else if(!locked && ball.getY() + ball.getRadius() - tolerance < aiBar.getBottom() && ball.getY() + ball.getRadius() + tolerance > aiBar.getBottom())
        {
            int direction = aiBar.checkBounce(ball.getX(), ball.getRadius());
            if(direction > 1 && direction < 5)
            {
                ball.reflectY();
                ai(1);
                targeted = false;
                bar_hit.start();
            }
            if(direction == 2)
            {
                ball.nudgeLeft();
            }
            else if(direction == 4)
            {
                ball.nudgeRight();
            }
            if(direction == 0)
            {
                playerScore++;
                background.stop();
                fail_hit.start();
                background.prepare();
                runningScore = 0;
                locked = true;
            }
        }
        if(locked && (ball.getY() < 0.0f || ball.getY() > (float) sHeight))
        {
            locked = false;
            spawnBall();
            p_string = "You: " + playerScore;
            c_string = "Computer: " + computerScore;
            r_string = "Running score: " + runningScore;
        }
    }

    private void ai(int state)
    {
        float x = ball.getX(), y = ball.getY(), vx = ball.getVx(), vy = ball.getVy(), rad = ball.getRadius();
        if(state == 1)
        {
            while(y > aiBar.getBottom())
            {
                x = x + vx;
                y = y + vy;

                if(x - rad < 0 || x + rad > sWidth) vx = -vx;
                if(y > playerBar.getTop())
                {
                    vy = -vy;
                    y = playerBar.getTop();
                }
            }
            aiTarget = (int) x;
        }
        else if(state == 2)
        {
            while(y > aiBar.getBottom())
            {
                x = x + vx;
                y = y + vy;
                if(x - rad < 0 || x + rad > sWidth) vx = -vx;
            }
            aiTarget = (int) x;
        }
        else if(state == 3)
        {
            while(y > aiBar.getBottom())
            {
                x = x + vx;
                y = y + vy;
                if(x - rad < 0 || x + rad > sWidth) vx = -vx;
            }
            if(playerBar.getCentreX() < aiBar.getCentreX()) aiTarget = (int) (x - (float) aiBar.getWidth() / 4);
            else if(playerBar.getCentreX() > aiBar.getCentreX()) aiTarget = (int) (x + (float) aiBar.getWidth() / 4);
            targeted = true;
        }
    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Rect screen = holder.getSurfaceFrame();
        sWidth = screen.width();
        sHeight = screen.height();

        setParams();
        initBars();
        ball = new Ball();
        spawnBall();
        ai(1);

        this.gameThread = new GameThread(this,holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();
    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry= true;
        while(retry) {
            try {
                this.gameThread.setRunning(false);

                // Parent thread must wait until the end of GameThread.
                this.gameThread.join();
            }catch(InterruptedException e)  {
                e.printStackTrace();
            }
            retry= true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            int x = (int) event.getX();
            if(0 < x && x < (sWidth / 2))
            {
                moveLeft = true;
            }
            if((sWidth / 2) < x && x < sWidth)
            {
                moveRight = true;
            }
            return true;
        }
        else if(event.getAction() == MotionEvent.ACTION_UP)
        {
            moveLeft = false;
            moveRight = false;
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas)  {
        super.draw(canvas);
        playerBar.draw(canvas);
        aiBar.draw(canvas);
        ball.draw(canvas);

        canvas.drawText("Bounce", (float) sWidth / 2 - 75, 30, white);
        canvas.drawText(c_string, 0, 30, white);
        canvas.drawText(p_string, 0, sHeight - 25, white);
        canvas.drawText(s_string, sWidth - 230, 30, white);
        canvas.drawText(r_string, sWidth - 360, sHeight - 25, white);
    }

    private void setParams()
    {
        moveLeft = false;
        moveRight = false;
        if(sHeight < 1000) top_down_margin = 30;
        else top_down_margin = 60;
        tolerance = (float) sHeight / 45;
        gamePaused = false;

        playerScore = 0;
        computerScore = 0;
        totalScore = 0;
        runningScore = 0;

        p_string = "Player: 0";
        c_string = "Computer: 0";
        s_string = "Score: 0";
        r_string = "Running score: 0";

        targeted = false;
        locked = false;

        white = new Paint();
        white.setTextSize(40);
        white.setColor(Color.WHITE);
    }

    private void initBars()
    {
        playerBar = new Bar();
        playerBar.setWidth(sWidth / 6);
        playerBar.setHeight(sHeight / 50);
        playerBar.setRect((sWidth / 2) - (playerBar.getWidth() / 2), sHeight - top_down_margin - 2 * playerBar.getHeight(), 1);
        playerBar.calcSpeed(sWidth);

        aiBar = new Bar();
        aiBar.setWidth(sWidth / 6);
        aiBar.setHeight(sHeight / 50);
        aiBar.setRect((sWidth / 2) - (aiBar.getWidth() / 2), top_down_margin + aiBar.getHeight(), 2);
        aiBar.calcSpeed(sWidth);
    }

    private void spawnBall()
    {
        int max = sWidth / 4;
        int min = 3 * sWidth / 4;
        int rand_x = (int) (Math.random() * (max - min + 1) + min);
        float rand_vx = (float) Math.random() - 0.5f;
        rand_vx = rand_vx * sWidth / 150;
        if(rand_x < playerBar.getX()) rand_vx = Math.abs(rand_vx);
        else rand_vx = - Math.abs(rand_vx);
        ball.init(rand_x, sHeight / 4, sHeight / 60, rand_vx, (float) sHeight / 150, sWidth);
    }
}