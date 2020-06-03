package com.numberguessinggame.my.numberguessinggame;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class DisplaySettings extends ActionBarActivity {
   // final Button buttonA = (Button) findViewById(R.id.ButtonA);
   // final Button buttonB = (Button) findViewById(R.id.ButtonB);
   //  final Button buttonC = (Button) findViewById(R.id.ButtonC);
      /*  public void changeColor2() {
            buttonA.setBackgroundColor(Color.BLACK);
            buttonC.setBackgroundColor(Color.BLACK);
        }*/
     /*   public void changeColor3(){
            buttonA.setBackgroundColor(Color.BLACK);
            buttonB.setBackgroundColor(Color.BLACK);
        }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_settings);
        MediaPlayer select= MediaPlayer.create(DisplaySettings.this, R.raw.select);
        select.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_settings, menu);
        return true;
    }
    public void backMenu(View view){
        Intent intent=new Intent(this, MainMenuActivity.class);
        startActivity(intent);
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
}
