package my.chan.com.x_ospaceedition;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;


public class AIgame extends ActionBarActivity {
    public String firststart="0";
  //  public TextView disChance;
    public TextView OName;
    int c=0;
    int dis=0;
    public TextView XName;
    String user="You";
    String comp="Computer";
    int min=1;
    int max=2;
    int t1=0;
    int t2=0;
    int t3=0;
    int d1=0;
    int d2=0;
    int d3=0;
    int m1=0;
    int m2=0;
    int m3=0;
    int usersym=0;
    int compsym=0;
    int randstart=0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bm1;
    Button bm2;
    Button bm3;
    Button bd1;
    Button bd2;
    Button bd3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aigame);
        Intent intent=getIntent();
        firststart=intent.getStringExtra(ComputerGame.PASS_X);
        Random rand=new Random();
        randstart=rand.nextInt((max-min)+1)+min;
        bt1=(Button) findViewById(R.id.button_t1);
        bt2=(Button) findViewById(R.id.button_t2);
        bt3=(Button) findViewById(R.id.button_t3);
        bm1=(Button) findViewById(R.id.button_m1);
        bm2=(Button) findViewById(R.id.button_m2);
        bm3=(Button) findViewById(R.id.button_m3);
        bd1=(Button) findViewById(R.id.button_d1);
        bd2=(Button) findViewById(R.id.button_d2);
        bd3=(Button) findViewById(R.id.button_d3);
        if(firststart.equals("1")){usersym=1;compsym=2;}
        if(firststart.equals("2")){usersym=2;compsym=1;}
        if(compsym==1&&randstart==1)
        {
            ai();
        }
        if(compsym==2&&randstart==2)
        {
            ai();
        }
        XName=(TextView) findViewById(R.id.xname);
        OName=(TextView) findViewById(R.id.oname);
        if(usersym==1){
            XName.setText(user);
            XName.setTextColor(Color.parseColor("#ffffffff"));
            OName.setText(comp);
            OName.setTextColor(Color.parseColor("#ffffffff"));}
        if(compsym==1){
            XName.setText(comp);
            XName.setTextColor(Color.parseColor("#ffffffff"));
            OName.setText(user);
            OName.setTextColor(Color.parseColor("#ffffffff"));}
    }
    public void putS(){
        if(t1==1){
        bt1.setText("X");
        bt1.setTextSize(75);
        bt1.setTextColor(Color.parseColor("#ff7370d1"));
        checkovero();checkoverx();}
        if(t1==2){
            bt1.setText("O");
            bt1.setTextSize(75);
            bt1.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(t2==1){bt2=(Button) findViewById (R.id.button_t2);
            bt2.setText("X");
            bt2.setTextSize(75);
            bt2.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(t2==2){
            bt2.setText("O");
            bt2.setTextSize(75);
            bt2.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(t3==1){
            bt3.setText("X");
            bt3.setTextSize(75);
            bt3.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(t3==2){
            bt3.setText("O");
            bt3.setTextSize(75);
            bt3.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(m1==1){bm1=(Button) findViewById (R.id.button_m1);
            bm1.setText("X");
            bm1.setTextSize(75);
            bm1.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(m1==2){
            bm1.setText("O");
            bm1.setTextSize(75);
            bm1.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(m2==1){
            bm2.setText("X");
            bm2.setTextSize(75);
            bm2.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(m2==2){
            bm2.setText("O");
            bm2.setTextSize(75);
            bm2.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(m3==1){
            bm3.setText("X");
            bm3.setTextSize(75);
            bm3.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(m3==2){
            bm3.setText("O");
            bm3.setTextSize(75);
            bm3.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(d1==1){
            bd1.setText("X");
            bd1.setTextSize(75);
            bd1.setTextColor(Color.parseColor("#ff7370d1"));}
        if(d1==2){
            bd1.setText("O");
            bd1.setTextSize(75);
            bd1.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(d2==1){
            bd2.setText("X");
            bd2.setTextSize(75);
            bd2.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(d2==2){
            bd2.setText("O");
            bd2.setTextSize(75);
            bd2.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
        if(d3==1){
            bd3.setText("X");
            bd3.setTextSize(75);
            bd3.setTextColor(Color.parseColor("#ff7370d1"));checkovero();checkoverx();}
        if(d3==2){
            bd3.setText("O");
            bd3.setTextSize(75);
            bd3.setTextColor(Color.parseColor("#ff5ffd2c"));checkovero();checkoverx();
        }
    }
    public void ai() {
        int dec = 0;
        int st = 0;
        c = 0;
        Random rand = new Random();
        dec = rand.nextInt((3 - min) + 1) + min;
        st = rand.nextInt((3 - min) + 1) + min;
        //complete priority 1
        if (t1 == 0 && compsym == 1 && c == 0) {
            if (t2 == 1 && t3 == 1) {
                t1 = 1;
                c = 1;
                putS();
            }
            if (m1 == 1 && d1 == 1) {
                t1 = 1;
                c = 1;
                putS();
            }
            if (m2 == 1 && d3 == 1) {
                t1 = 1;
                c = 1;
                putS();
            }
        }
        if (t1 == 0 && compsym == 2 && c == 0) {
            if (t2 == 2 && t3 == 2) {
                t1 = 2;
                c = 1;
                putS();
            }
            if (m1 == 2 && d1 == 2) {
                t1 = 2;
                c = 1;
                putS();
            }
            if (m2 == 2 && d3 == 2) {
                t1 = 2;
                c = 1;
                putS();
            }
        }
        if (t2 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && t3 == 1) {
                t2 = 1;
                c = 1;
                putS();
            }
            if (m2 == 1 && m3 == 1) {
                t2 = 1;
                c = 1;
                putS();
            }
        }
        if (t2 == 0 && compsym == 2 && c == 0) {
            if (t1 == 2 && t3 == 2) {
                t2 = 2;
                c = 1;
                putS();
            }
            if (t1 == 2 && t3 == 2) {
                t2 = 2;
                c = 1;
                putS();
            }
        }
        if (t3 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && t2 == 1) {
                t3 = 1;
                c = 1;
                putS();
            }
            if (m3 == 1 && d3 == 1) {
                t3 = 1;
                c = 1;
                putS();
            }
            if (d3 == 1 && m2 == 1) {
                t3 = 1;
                c = 1;
                putS();
            }
        }
        if(t3==0&&compsym==2&&c==0)
        {
            if(m3==2&&d3==2){t3=2;c=1;putS();}
            if(t1==2&&t2==2){t3=2;c=1;putS();}
            if(m2==2&&d1==2){t3=2;c=1;putS();}
        }
        if (m1 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && d1 == 1) {
                m1 = 1;
                c = 1;
                putS();
            }
            if (m2 == 1 && m3 == 1) {
                m1 = 1;
                c = 1;
                putS();
            }
        }
        if (m1 == 0 && compsym == 2 && c == 0) {
            if (t1 == 2 && d1 == 2) {
                m1 = 2;
                c = 1;
                putS();
            }
            if (m2 == 2 && m3 == 2) {
                m1 = 2;
                c = 1;
                putS();
            }
        }
        if (m2 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && d3 == 1) {
                m2 = 1;
                c = 1;
                putS();
            }
            if (t3 == 1 && d1 == 1) {
                m2 = 1;
                c = 1;
                putS();
            }
            if (t2 == 1 && d2 == 1) {
                m2 = 1;
                c = 1;
                putS();
            }
            if (m1 == 1 && m3 == 1) {
                m2 = 1;
                c = 1;
                putS();
            }
        }
        if (m2 == 0 && compsym == 2 && c == 0) {
            if (t1 == 2 && d3 == 2) {
                m2 = 2;
                c = 1;
                putS();
            }
            if (t3 == 2 && d1 == 2) {
                m2 = 2;
                c = 1;
                putS();
            }
            if (t2 == 2 && d2 == 2) {
                m2 = 2;
                c = 1;
                putS();
            }
            if (m1 == 2 && m3 == 2) {
                m2 = 2;
                c = 1;
                putS();
            }
        }
        if (m3 == 0 && compsym == 1 && c == 0) {
            if (m1 == 1 && m2 == 1) {
                m3 = 1;
                c = 1;
                putS();
            }
            if (t3 == 1 && d3 == 1) {
                m3 = 1;
                c = 1;
                putS();
            }
        }
        if (m3 == 0 && compsym == 2 && c == 0) {
            if (m1 == 2 && m2 == 2) {
                m3 = 2;
                c = 1;
                putS();
            }
            if (t3 == 2 && d3 == 2) {
                m3 = 2;
                c = 1;
                putS();
            }
        }
        if (d1 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && m1 == 1) {
                d1 = 1;
                c = 1;
                putS();
            }
            if (t3 == 1 && m2 == 1) {
                d1 = 1;
                c = 1;
                putS();
            }
            if (d2 == 1 && d3 == 1) {
                d1 = 1;
                c = 1;
                putS();
            }
        }
        if (d1 == 0 && compsym == 2 && c == 0) {
            if (t1 == 2 && m1 == 2) {
                d1 = 2;
                c = 1;
                putS();
            }
            if (t3 == 2 && m2 == 2) {
                d1 = 2;
                c = 1;
                putS();
            }
            if (d2 == 2 && d3 == 2) {
                d1 = 2;
                c = 1;
                putS();
            }
        }
        if (d2 == 0 && compsym == 1 && c == 0) {
            if (d1 == 1 && d3 == 1) {
                d2 = 1;
                c = 1;
                putS();
            }
            if (t2 == 1 && m2 == 1) {
                d2 = 1;
                c = 1;
                putS();
            }
        }
        if (d2 == 0 && compsym == 2 && c == 0) {
            if (d1 == 2 && d3 == 2) {
                d2 = 2;
                c = 1;
                putS();
            }
            if (t2 == 2 && m2 == 2) {
                d2 = 2;
                c = 1;
                putS();
            }
        }
        if (d3 == 0 && compsym == 1 && c == 0) {
            if (t1 == 1 && m2 == 1) {
                d3 = 1;
                c = 1;
                putS();
            }
            if (t3 == 1 && m3 == 1) {
                d3 = 1;
                c = 1;
                putS();
            }
            if (d1 == 1 && d2 == 1) {
                d3 = 1;
                c = 1;
                putS();
            }
        }
        if (d3 == 0 && compsym == 2 && c == 0)
        {
            if(t1==2&&m2==2){d3=2;c=1;putS();}
            if(t3==2&&m3==2){d3=2;c=1;putS();}
            if(d1==2&&d2==2){d3=2;c=1;putS();}
        }
        if(st==2&&c==0) {

            if (m2 == 0 && compsym == 1) {
                m2 = 1;c=1;
                putS();
            }
            if (m2 == 0 && compsym == 2&&c==0) {
                m2 = 2;c=1;
                putS();
            }
        }
        //horizontal last check
        if(t1==1&&t2==1&&t3==0&&compsym==2&&c==0){t3=2;putS();c=1;}
        if(t1==2&&t2==2&&t3==0&&compsym==1&&c==0){t3=1;putS();c=1;}
        if(m1==1&&m2==1&&m3==0&&compsym==2&&c==0){m3=2;putS();c=1;}
        if(m1==2&&m2==2&&m3==0&&compsym==1&&c==0){m3=1;putS();c=1;}
        if(d1==1&&d2==1&&d3==0&&compsym==2&&c==0){d3=2;putS();c=1;}
        if(d1==2&&d2==2&&d3==0&&compsym==1&&c==0){d3=1;putS();c=1;}
        //vertical last check
        if(t1==1&&m1==1&&d1==0&&compsym==2&&c==0){d1=2;putS();c=1;}
        if(t1==2&&m1==2&&d1==0&&compsym==1&&c==0){d1=1;putS();c=1;}
        if(t2==1&&m2==1&&d2==0&&compsym==2&&c==0){d2=2;putS();c=1;}
        if(t2==2&&m2==2&&d2==0&&compsym==1&&c==0){d2=1;putS();c=1;}
        if(t3==1&&m3==1&&d3==0&&compsym==2&&c==0){d3=2;putS();c=1;}
        if(t3==2&&m3==2&&d3==0&&compsym==1&&c==0){d3=1;putS();c=1;}
        //diagonal last check
        if(t1==1&&m2==1&&d3==0&&compsym==2&&c==0){d3=2;putS();c=1;}
        if(t1==2&&m2==2&&d3==0&&compsym==1&&c==0){d3=1;putS();c=1;}
        if(t3==1&&m2==1&&d1==0&&compsym==2&&c==0){d1=2;putS();c=1;}
        if(t3==2&&m2==2&&d1==0&&compsym==1&&c==0){d1=1;putS();c=1;}
        //horizontal middle check
        if(t1==1&&t3==1&&t2==0&&compsym==2&&c==0){t2=2;putS();c=1;}
        if(t1==2&&t3==2&&t2==0&&compsym==1&&c==0){t2=1;putS();c=1;}
        if(m1==1&&m3==1&&m2==0&&compsym==2&&c==0){m2=2;putS();c=1;}
        if(m1==2&&m3==2&&m2==0&&compsym==1&&c==0){m2=1;putS();c=1;}
        if(d1==1&&d3==1&&d2==0&&compsym==2&&c==0){d2=2;putS();c=1;}
        if(d1==2&&d3==2&&d2==0&&compsym==1&&c==0){d2=1;putS();c=1;}
        //vertical middle check
        if(t1==1&&d1==1&&m1==0&&compsym==2&&c==0){m1=2;putS();c=1;}
        if(t1==2&&d1==2&&m1==0&&compsym==1&&c==0){m1=1;putS();c=1;}
        if(t2==1&&d2==1&&m2==0&&compsym==2&&c==0){m2=2;putS();c=1;}
        if(t2==2&&d2==2&&m2==0&&compsym==1&&c==0){m2=1;putS();c=1;}
        if(t3==1&&d3==1&&m3==0&&compsym==2&&c==0){m3=2;putS();c=1;}
        if(t3==2&&d3==2&&m3==0&&compsym==1&&c==0){m3=1;putS();c=1;}
        //diagonal middle check
        if(t1==1&&d3==1&&m2==0&&compsym==2&&c==0){m2=2;putS();c=1;}
        if(t1==2&&d3==2&&m2==0&&compsym==1&&c==0){m2=1;putS();c=1;}
        if(t3==1&&d1==1&&m2==0&&compsym==2&&c==0){m2=2;putS();c=1;}
        if(t3==2&&d1==2&&m2==0&&compsym==1&&c==0){m2=1;putS();c=1;}
        //horizontal start check
        if(t2==1&&t3==1&&t1==0&&compsym==2&&c==0){t1=2;putS();c=1;}
        if(t2==2&&t3==2&&t1==0&&compsym==1&&c==0){t1=1;putS();c=1;}
        if(m2==1&&m3==1&&m1==0&&compsym==2&&c==0){m1=2;putS();c=1;}
        if(m2==2&&m3==2&&m1==0&&compsym==1&&c==0){m1=1;putS();c=1;}
        if(d2==1&&d3==1&&d1==0&&compsym==2&&c==0){d1=2;putS();c=1;}
        if(d2==2&&d3==2&&d1==0&&compsym==1&&c==0){d1=1;putS();c=1;}
        //vertical start check
        if(m1==1&&d1==1&&t1==0&&compsym==2&&c==0){t1=2;putS();c=1;}
        if(m1==2&&d1==2&&t1==0&&compsym==1&&c==0){t1=1;putS();c=1;}
        if(m2==1&&d2==1&&t2==0&&compsym==2&&c==0){t2=2;putS();c=1;}
        if(m2==2&&d2==2&&t2==0&&compsym==1&&c==0){t2=1;putS();c=1;}
        if(m3==1&&d3==1&&t3==0&&compsym==2&&c==0){t3=2;putS();c=1;}
        if(m3==2&&d3==2&&t3==0&&compsym==1&&c==0){t3=1;putS();c=1;}
        //diagonal start check
        if(m2==1&&d3==1&&t1==0&&compsym==2&&c==0){t1=2;putS();c=1;}
        if(m2==2&&d3==2&&t1==0&&compsym==1&&c==0){t1=1;putS();c=1;}
        if(m2==1&&d1==1&&t3==0&&compsym==2&&c==0){t3=2;putS();c=1;}
        if(m2==2&&d1==2&&t3==0&&compsym==1&&c==0){t3=1;putS();c=1;}
        if(st==1)
        {
            if(t2==0&&compsym==1&&c==0){t2=1;putS();c=1;}
            if(t2==0&&compsym==2&&c==0){t2=2;putS();c=1;}
            if(m1==0&&compsym==1&&c==0){m1=1;putS();c=1;}
            if(m1==0&&compsym==2&&c==0){m1=2;putS();c=1;}
        }
        if(st==3)
        {
            if(m3==0&&compsym==1&&c==0){m3=1;putS();c=1;}
            if(m3==0&&compsym==2&&c==0){m3=2;putS();c=1;}
            if(d2==0&&compsym==1&&c==0){d2=1;putS();c=1;}
            if(d2==0&&compsym==2&&c==0){d2=2;putS();c=1;}
        }
        if(dec==1){
            if(t1==0&&compsym==1&&c==0){t1=1;putS();c=1;}
            if(t3==0&&compsym==2&&c==0){t3=2;putS();c=1;}
            if(m3==0&&compsym==1&&c==0){m3=1;putS();c=1;}
        }
        if(dec==2){
            if(t1==0&&compsym==2&&c==0){t1=2;putS();c=1;}
            if(t3==0&&compsym==1&&c==0){t3=1;putS();c=1;}
            if(m3==0&&compsym==2&&c==0){m3=2;putS();c=1;}
        }
        if(dec==3){
            if(d3==0&&compsym==1&&c==0){d3=1;putS();c=1;}
            if(d1==0&&compsym==2&&c==0){d1=2;putS();c=1;}
            if(d3==0&&compsym==2&&c==0){d3=2;putS();c=1;}
            if(d1==0&&compsym==1&&c==0){d1=1;putS();c=1;}
        }
        if(compsym==1)
        {
            if(t1==0&&c==0){t1=1;c=1;putS();}
            if(t2==0&&c==0){t2=1;c=1;putS();}
            if(t3==0&&c==0){t3=1;c=1;putS();}
            if(m1==0&&c==0){m1=1;c=1;putS();}
            if(m2==0&&c==0){m2=1;c=1;putS();}
            if(m3==0&&c==0){m3=1;c=1;putS();}
            if(d3==0&&c==0){d3=1;c=1;putS();}
            if(d1==0&&c==0){d1=1;c=1;putS();}
            if(d2==0&&c==0){d2=1;c=1;putS();}
        }
        if(compsym==2)
        {
            if(m3==0&&c==0){m3=2;c=1;putS();}
            if(d3==0&&c==0){d3=2;c=1;putS();}
            if(m1==0&&c==0){m1=2;c=1;putS();}
            if(t2==0&&c==0){t2=2;c=1;putS();}
            if(t3==0&&c==0){t3=2;c=1;putS();}
            if(m2==0&&c==0){m2=2;c=1;putS();}
            if(d2==0&&c==0){d2=2;c=1;putS();}
            if(t1==0&&c==0){t1=1;c=1;putS();}
            if(d1==0&&c==0){d1=1;c=1;putS();}
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aigame, menu);
        return true;
    }
    public void putt1(View view){
        if(t1!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&t1==0){
            t1=1;putS();ai();
        }
        if(usersym==2&&t1==0){
            t1=2;putS();ai();
        }

    }
    public void putt2(View view){
        if(t2!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&t2==0){
            t2=1;putS();ai();
        }
        if(usersym==2&&t2==0){
            t2=2;putS();ai();
        }

    }
    public void putt3(View view){
        if(t3!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&t3==0){
            t3=1;putS();ai();
        }
        if(usersym==2&&t3==0){
            t3=2;putS();ai();
        }
    }
    public void putm1(View view){
        if(m1!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&m1==0){
            m1=1;putS();ai();
        }
        if(usersym==2&&m1==0){
            m1=2;putS();ai();
        }

    }
    public void putm2(View view){
        if(m2!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&m2==0){
            m2=1;putS();ai();
        }
        if(usersym==2&&m2==0){
            m2=2;putS();ai();
        }

    }
    public void putm3(View view){
        if(m3!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&m3==0){
            m3=1;putS();ai();
        }
        if(usersym==2&&m3==0){
            m3=2;putS();ai();
        }

    }
    public void putd1(View view){
        if(d1!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&d1==0){
            d1=1;putS();ai();
        }
        if(usersym==2&&d1==0){
            d1=2;putS();ai();
        }

    }
    public void putd2(View view){
        if(d2!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&d2==0){
            d2=1;putS();ai();
        }
        if(usersym==2&&d2==0){
            d2=2;putS();ai();
        }

    }
    public void putd3(View view){
        if(d3!=0){
            MediaPlayer error=MediaPlayer.create(AIgame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if(usersym==1&&d3==0){
            d3=1;putS();ai();
        }
        if(usersym==2&&d3==0){
            d3=2;putS();ai();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void checkoverx() {
        if (t1 == 1&& t2 == 1 && t3 == 1) {
            if(usersym==1&&dis==0) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();dis++;
            }
            if(compsym==1&&dis==0){
                Toast.makeText(this,"You Lost ",Toast.LENGTH_SHORT).show();dis++;
            }
            gover();
        }
        if(m1==1&&m2==1&&m3==1)
        {
            if(usersym==1&&dis==0) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();dis++;
            }
            if(compsym==1&&dis==0){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();dis++;
            }
            bm1.setTextColor(Color.parseColor("#ffffffff"));

            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(d1==1&&d2==1&&d3==1&&dis==0)
        {
            if(usersym==1&&dis==0) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();dis++;
            }
            if(compsym==1&&dis==0){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();dis++;
            }
            dis++;
            bd1.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 1 && m1 == 1 && d1 == 1&&dis==0) {
            if(usersym==1) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
            }
            if(compsym==1){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();
            }
            dis++;
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t2==1&&m2==1&&d2==1&&dis==0)
        {
            if(usersym==1) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
            }
            if(compsym==1){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt2.setTextColor(Color.parseColor("#ffffffff"));

            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==1&&d3==1&&m3==1&&dis==0)
        {
            if(usersym==1) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
            }
            if(compsym==1){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();
            }
            dis++;
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 1 && m2 == 1 && d3 == 1&&dis==0) {
            if(usersym==1) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
            }
            if(compsym==1){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();
            }
            dis++;
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==1&&m2==1&&d1==1&&dis==0)
        {
            if(usersym==1) {
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();
            }
            if(compsym==1){
                Toast.makeText(this,"You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t1!=0&&t2!=0&&t3!=0&&m1!=0&&m2!=0&&m3!=0&&d1!=0&&d2!=0&&d3!=0&&dis==0)
        {dis++;
            Toast.makeText(this,"Game Draw!\nStart new game",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,ComputerGame.class);
            startActivity(intent);
            finish();
        }
    }

    public void checkovero() {

        if (t1 == 2 && t2 == 2 && t3 == 2&&dis==0) {
            if(usersym==2){
            Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bt3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(m1==2&&m2==2&&m3==2&&dis==0)
        {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(d1==2&&d2==2&&d3==2&&dis==0)
        {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bd1.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));

            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 2 && m1 == 2 && d1 == 2&&dis==0) {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t2==2&&m2==2&&d2==2&&dis==0)
        {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==2&&d3==2&&m3==2&&dis==0)
        {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }
            dis++;
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 2 && m2 == 2 && d3 == 2&&dis==0) {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==2&&m2==2&&d1==2&&dis==0)
        {
            if(usersym==2){
                Toast.makeText(this, "You win!!!", Toast.LENGTH_SHORT).show();}
            if(compsym==2){
                Toast.makeText(this, "You Lost",Toast.LENGTH_SHORT).show();
            }dis++;
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t1!=0&&t2!=0&&t3!=0&&m1!=0&&m2!=0&&m3!=0&&d1!=0&&d2!=0&&d3!=0&&dis==0)
        {
            dis++;
            Toast.makeText(this,"Game Draw!\nStart New Game",Toast.LENGTH_SHORT).show();
            cleardata();
            Intent intent=new Intent(this,ComputerGame.class);
            startActivity(intent);
            finish();
        }
    }
    public void gover(){
        MediaPlayer finish=MediaPlayer.create(AIgame.this,R.raw.finish);
        finish.start();
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Intent intent=new Intent(this,ComputerGame.class);
        startActivity(intent);
        finish();
    }
    public void cleardata(){
        t1=0;
        t2=0;
        t3=0;
        m1=0;
        m2=0;
        m3=0;
        d1=0;
        d2=0;
        d3=0;
    }
}


