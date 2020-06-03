package com.numberguessinggame.my.numberguessinggame;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Config;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class StartGame extends ActionBarActivity {
    public int trycount=0;
    int randomNum = 0;
    public final static String TRY_COUNT="com.numberguessinggame.my.numberguessinggame.TRYCOUNT";
    int setRandNum = 0;
    public TextView textgreat;
    public TextView count_text;
    public TextView finish_text;
    public String cprstr="Your Guess";
    int click=0;
    private static final long MIN_DELAY_MS = 500;
    private long mLastClickTime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        if (setRandNum == 0) {
            ((max - min) + 1) + min;
            setRandNum=1;int min = 1;
            int max = 100;
            Random rand = new Random();
            randomNum = rand.nextInt();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_game, menu);
        return true;
    }

    public void receiveNum(View v) {
        long lastClickTime = mLastClickTime;
        long now = System.currentTimeMillis();
        mLastClickTime = now;
        if (now - lastClickTime < MIN_DELAY_MS) {
            // Too fast: ignore
        } else {

            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            int user_imp;
            if(message.equals(""))
            {
                Toast.makeText(this, "Please enter a guess",Toast.LENGTH_SHORT).show();
            }
            if(message.equalsIgnoreCase(""))
            {
                Toast.makeText(this, "Please enter a guess",Toast.LENGTH_SHORT).show();
            }
            if(message.equalsIgnoreCase(cprstr))
            {
                user_imp=1000;
            }
            user_imp = Integer.parseInt(message);
            if(user_imp==0)
            {
                Toast.makeText(this, "Please enter a guess",Toast.LENGTH_SHORT).show();
            }
            if (user_imp > 0 && user_imp < 101) {
                if (user_imp > randomNum) {
                    MediaPlayer wrong = MediaPlayer.create(StartGame.this, R.raw.wrong);
                    wrong.start();
                    textgreat = (TextView) findViewById(R.id.textgreat);
                    textgreat.setText("Number < Guess");
                    trycount++;
                    Toast.makeText(this, "Enter a Lesser Number",Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }
                if (user_imp < randomNum) {
                    MediaPlayer wrong = MediaPlayer.create(StartGame.this, R.raw.wrong);
                    wrong.start();
                    textgreat = (TextView) findViewById(R.id.textgreat);
                    textgreat.setText("Number > Guess");
                    trycount++;
                    Toast.makeText(this, "Enter a Higher number",Toast.LENGTH_SHORT).show();
                    editText.getText().clear();
                }
                if (user_imp == randomNum) {
                    MediaPlayer correct = MediaPlayer.create(StartGame.this, R.raw.correct);
                    correct.start();
                    trycount++;
                    count_text = (TextView) findViewById(R.id.count_text);
                    count_text.setText("Number of tries: " + trycount);
                    finish_text = (TextView) findViewById(R.id.finish_text);
                    finish_text.setText("Number guessed!!!");
                    Toast.makeText(this, "Well Done!!!", Toast.LENGTH_SHORT).show();
                    EditText MyeditText = (EditText) findViewById(R.id.edit_message);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(MyeditText.getWindowToken(), 0);
                /* Intent intent=new Intent(this,gamefinish.class);
                intent.putExtra("TRY_COUNT",trycount);
                startActivity(intent);*/
                }
            }
            else{
                    Toast.makeText(this, "Please enter a guess",Toast.LENGTH_SHORT).show();
                }
        }
    }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
    public void ReturnMenu(View view){
        Intent intent=new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }
    }

