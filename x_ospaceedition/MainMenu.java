package my.chan.com.x_ospaceedition;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainMenu extends ActionBarActivity {
   Button button;
    ImageView devimg;
    TextView title1;
    TextView title2;
    int alplay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        // MediaPlayer intro=MediaPlayer.create(MainMenu.this,R.raw.androintro);
        playSound();
        title1=(TextView) findViewById(R.id.textView);
        title1.setText("X and O");
        Animation animation= AnimationUtils.loadAnimation(MainMenu.this,R.anim.zoom_out);
        title1.setAnimation(animation);
        Animation animation1=AnimationUtils.loadAnimation(MainMenu.this,R.anim.zoom_out);
        title2=(TextView) findViewById(R.id.textView2);
        title2.setText("Space Edition");
        title2.setAnimation(animation1);
    }

    public void playSound(){
        MediaPlayer scifi=MediaPlayer.create(MainMenu.this,R.raw.scifi);
        scifi.start();
        scifi.setLooping(true);
    }
    public void twoPlayerStart(View view){
        MediaPlayer select=MediaPlayer.create(MainMenu.this,R.raw.select);
        select.start();
        Intent intent=new Intent(this,TwoPlayer.class);
        startActivity(intent);
    }
    public void exitGame(View view){
        MediaPlayer select=MediaPlayer.create(MainMenu.this,R.raw.select);
        select.start();
       // ObjectAnimator.ofFloat(button,"alpha",0f).start();
       android.os.Process.killProcess(android.os.Process.myPid());
       /*Intent intent = new Intent(Intent.ACTION_MAIN);
       intent.addCategory(Intent.CATEGORY_HOME);
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(intent);*/
       // moveTaskToBack(true);
       // Intent intent=new Intent(this,MainMenu.class);
       // startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }
    public void startComputer(View view){
        Intent intent=new Intent(this,ComputerGame.class);
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
