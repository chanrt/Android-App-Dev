package com.numberguessinggame.my.numberguessinggame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import java.util.Random;


public class MainMenuActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        MediaPlayer curiosity = MediaPlayer.create(MainMenuActivity.this, R.raw.curiosity);
            curiosity.start();
            curiosity.setLooping(true);
        MediaPlayer select=MediaPlayer.create(MainMenuActivity.this, R.raw.select);
            select.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    public void displayAbout(View view) {
        Intent intent = new Intent(this, DisplayAbout.class);
        startActivity(intent);
    }

    public void displaySettings(View view) {
        Intent intent = new Intent(this, DisplaySettings.class);
        startActivity(intent);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, displayGameplay.class);
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
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
