package my.chan.com.x_ospaceedition;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class TwoPlayerGame extends ActionBarActivity {
    public TextView x_name;
    public TextView o_name;
    public int cch=0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bm1;
    Button bm2;
    Button bm3;
    Button bd1;
    Button bd2;
    Button bd3;
    int t1 = 0;
    int t2 = 0;
    int t3 = 0;
    int m1 = 0;
    int m2 = 0;
    int m3 = 0;
    int d1 = 0;
    int d2 = 0;
    int d3 = 0;
    public int chance = 0;
    public TextView disChance;
    int min = 1;
    int max = 2;
    String unixname;
    String unioname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rand = new Random();
        chance = rand.nextInt((max - min) + 1) + min;
        setContentView(R.layout.activity_two_player_game);
        Intent intent = getIntent();
        String pxname = intent.getStringExtra(TwoPlayer.X_NAME);
        String poname = intent.getStringExtra(TwoPlayer.O_NAME);
        x_name = (TextView) findViewById(R.id.xname);
        x_name.setText(pxname);
        o_name = (TextView) findViewById(R.id.oname);
        o_name.setText(poname);
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            if(pxname==null){
            pxname="Player X";}
            disChance.setText("chance: " + pxname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            if(poname==null){
                poname="Player O";
            }
            disChance.setText("chance: " + poname);
        }
        unioname=poname;
        unixname=pxname;
    }

    public void putt1(View view) {
        if (t1 != 0) {
            MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && t1 == 0) {
            inserted();
            bt1 = (Button) findViewById(R.id.button_t1);
            bt1.setText("X");
            bt1.setTextSize(75);
            bt1.setTextColor(Color.parseColor("#ff7370d1"));
            t1 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & t1 == 0&&cch==0) {
            inserted();
            bt1 = (Button) findViewById(R.id.button_t1);
            bt1.setText("O");
            bt1.setTextColor(Color.parseColor("#ff5ffd2c"));
            bt1.setTextSize(75);
            t1 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putt2(View view){
        if(t2!=0)
        {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this,"insert your symbol in a vacant box only",Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if(chance==1&&t2==0)
        {
            inserted();
            bt2=(Button)findViewById(R.id.button_t2);
            bt2.setText("X");bt2.setTextColor(Color.parseColor("#ff7370d1"));bt2.setTextSize(75);t2=2;checkoverx();chance=2;
            cch=1;
        }
        if(chance==2&&t2==0&&cch==0){
            inserted();
            bt2=(Button)findViewById(R.id.button_t2);
            bt2.setText("O");bt2.setTextColor(Color.parseColor("#ff5ffd2c"));bt2.setTextSize(75);t2=4;checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putm1(View view) {
        cch=0;
        if (m1 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        if (chance == 1 && m1 == 0) {
            inserted();
            bm1 = (Button) findViewById(R.id.button_m1);
            bm1.setText("X");
            bm1.setTextSize(75);
            bm1.setTextColor(Color.parseColor("#ff7370d1"));
            m1 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & m1 == 0&&cch==0) {
            inserted();
            bm1 = (Button) findViewById(R.id.button_m1);
            bm1.setText("O");
            bm1.setTextColor(Color.parseColor("#ff5ffd2c"));
            bm1.setTextSize(75);
            m1 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putt3(View view) {
        if (t3 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && t3 == 0) {
            inserted();
            bt3 = (Button) findViewById(R.id.button_t3);
            bt3.setText("X");
            bt3.setTextSize(75);
            bt3.setTextColor(Color.parseColor("#ff7370d1"));
            t3 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & t3 == 0&&cch==0) {
            inserted();
            bt3 = (Button) findViewById(R.id.button_t3);
            bt3.setText("O");
            bt3.setTextColor(Color.parseColor("#ff5ffd2c"));
            bt3.setTextSize(75);
            t3 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putm2(View view) {
        if (m2 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && m2 == 0) {
            inserted();
            bm2 = (Button) findViewById(R.id.button_m2);
            bm2.setText("X");
            bm2.setTextSize(75);
            bm2.setTextColor(Color.parseColor("#ff7370d1"));
            m2 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & m2 == 0&&cch==0) {
            inserted();
            bm2 = (Button) findViewById(R.id.button_m2);
            bm2.setText("O");
            bm2.setTextColor(Color.parseColor("#ff5ffd2c"));
            bm2.setTextSize(75);
            m2 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putm3(View view) {
        if (m3 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && m3 == 0) {
            inserted();
            bm3 = (Button) findViewById(R.id.button_m3);
            bm3.setText("X");
            bm3.setTextSize(75);
            bm3.setTextColor(Color.parseColor("#ff7370d1"));
            m3 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & m3 == 0&&cch==0) {
            inserted();
            bm3 = (Button) findViewById(R.id.button_m3);
            bm3.setText("O");
            bm3.setTextColor(Color.parseColor("#ff5ffd2c"));
            bm3.setTextSize(75);
            m3 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putd1(View view) {
        if (d1 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && d1 == 0) {
            inserted();
            bd1 = (Button) findViewById(R.id.button_d1);
            bd1.setText("X");
            bd1.setTextSize(75);
            bd1.setTextColor(Color.parseColor("#ff7370d1"));
            d1 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & d1 == 0&&cch==0) {
            inserted();
            bd1 = (Button) findViewById(R.id.button_d1);
            bd1.setText("O");
            bd1.setTextColor(Color.parseColor("#ff5ffd2c"));
            bd1.setTextSize(75);
            d1 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putd2(View view) {
        if (d2 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && d2 == 0) {
            inserted();
            bd2 = (Button) findViewById(R.id.button_d2);
            bd2.setText("X");
            bd2.setTextSize(75);
            bd2.setTextColor(Color.parseColor("#ff7370d1"));
            d2 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & d2 == 0&&cch==0) {
            inserted();
            bd2 = (Button) findViewById(R.id.button_d2);
            bd2.setText("O");
            bd2.setTextColor(Color.parseColor("#ff5ffd2c"));
            bd2.setTextSize(75);
            d2 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }
    public void putd3(View view) {
        if (d3 != 0) {MediaPlayer error=MediaPlayer.create(TwoPlayerGame.this,R.raw.error);
            error.start();
            Toast.makeText(this, "Insert your symbol only in a vacant box", Toast.LENGTH_SHORT).show();
        }
        cch=0;
        if (chance == 1 && d3 == 0) {
            inserted();
            bd3 = (Button) findViewById(R.id.button_d3);
            bd3.setText("X");
            bd3.setTextSize(75);
            bd3.setTextColor(Color.parseColor("#ff7370d1"));
            d3 = 2;
            checkoverx();
            chance=2;cch=1;
        }
        if (chance == 2 & d3 == 0&&cch==0) {
            inserted();
            bd3 = (Button) findViewById(R.id.button_d3);
            bd3.setText("O");
            bd3.setTextColor(Color.parseColor("#ff5ffd2c"));
            bd3.setTextSize(75);
            d3 = 4;
            checkovero();chance=1;
        }
        if (chance == 1) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unixname);
        }
        if (chance == 2) {
            disChance = (TextView) findViewById(R.id.c_current);
            disChance.setText("chance: " + unioname);
        }
    }

    public void inserted(){
        MediaPlayer insert=MediaPlayer.create(TwoPlayerGame.this,R.raw.inser);
        insert.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player_game, menu);
        return true;
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
        if (t1 == 2 && t2 == 2 && t3 == 2) {
            Toast.makeText(this, "X wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            gover();
        }
        if(m1==2&&m2==2&&m3==2)
        {
            Toast.makeText(this,"X wins!!!",Toast.LENGTH_SHORT).show();
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(d1==2&&d2==2&&d3==2)
        {
            Toast.makeText(this,"X wins!!!",Toast.LENGTH_SHORT).show();
            bd1.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 2 && m1 == 2 && d1 == 2) {
            Toast.makeText(this, "X wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t2==2&&m2==2&&d2==2)
        {
            Toast.makeText(this,"X wins!!!",Toast.LENGTH_SHORT).show();
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==2&&d3==2&&m3==2)
        {
            Toast.makeText(this,"X wins!!!",Toast.LENGTH_SHORT).show();
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 2 && m2 == 2 && d3 == 2) {
            Toast.makeText(this, "X wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==2&&m2==2&&d1==2)
        {
            Toast.makeText(this,"X wins!!!",Toast.LENGTH_SHORT).show();
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t1!=0&&t2!=0&&t3!=0&&m1!=0&&m2!=0&&m3!=0&&d1!=0&&d2!=0&&d3!=0)
        {
            Toast.makeText(this,"Game Draw!\nStarting New Game",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,TwoPlayer.class);
            startActivity(intent);
        }
    }

    public void checkovero() {

        if (t1 == 4 && t2 == 4 && t3 == 4) {
            Toast.makeText(this, "O wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bt3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(m1==4&&m2==4&&m3==4)
        {
            Toast.makeText(this,"O wins!!!",Toast.LENGTH_SHORT).show();
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(d1==4&&d2==4&&d3==4)
        {
            Toast.makeText(this,"O wins!!!",Toast.LENGTH_SHORT).show();
            bd1.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 4 && m1 == 4 && d1 == 4) {
            Toast.makeText(this, "O wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm1.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t2==4&&m2==4&&d2==4)
        {
            Toast.makeText(this,"O wins!!!",Toast.LENGTH_SHORT).show();
            bt2.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd2.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==4&&d3==4&&m3==4)
        {
            Toast.makeText(this,"O wins!!!",Toast.LENGTH_SHORT).show();
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm3.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if (t1 == 4 && m2 == 4 && d3 == 4) {
            Toast.makeText(this, "O wins!!!", Toast.LENGTH_SHORT).show();
            bt1.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd3.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t3==4&&m2==4&&d1==4)
        {
            Toast.makeText(this,"O wins!!!",Toast.LENGTH_SHORT).show();
            bt3.setTextColor(Color.parseColor("#ffffffff"));
            bm2.setTextColor(Color.parseColor("#ffffffff"));
            bd1.setTextColor(Color.parseColor("#ffffffff"));gover();
        }
        if(t1!=0&&t2!=0&&t3!=0&&m1!=0&&m2!=0&&m3!=0&&d1!=0&&d2!=0&&d3!=0)
        {
            Toast.makeText(this,"Game Draw!\nStarting New Game",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,TwoPlayer.class);
            startActivity(intent);
            finish();
        }
    }
    public void gover(){
        MediaPlayer finish=MediaPlayer.create(TwoPlayerGame.this,R.raw.finish);
        finish.start();
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Intent intent=new Intent(this,OptionsActivity.class);
        startActivity(intent);
        finish();
    }
}

