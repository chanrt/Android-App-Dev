package my.chan.com.x_ospaceedition;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class TwoPlayer extends ActionBarActivity {
    public final static String X_NAME="my.chan.com.x_ospaceedition.X_NAME";
    public final static String O_NAME="my.chan.com.x_ospaceedition.O_NAME";
    EditText editText1;
    EditText editText2;
    String pxname="player X";
    String poname="player O";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player, menu);
        return true;
    }
    public void startGameTwoPlayer(View view){
        MediaPlayer menuselect=MediaPlayer.create(TwoPlayer.this,R.raw.menuselect);
        menuselect.start();
        Intent intent=new Intent(this,TwoPlayerGame.class);
        EditText editText1=(EditText) findViewById(R.id.editText1);
        pxname=editText1.getText().toString();
        if(pxname.equalsIgnoreCase(""))
        {
            pxname="Player X";
        }
        intent.putExtra(X_NAME,pxname);
        EditText editText2=(EditText) findViewById(R.id.editText2);
        poname=editText2.getText().toString();
        if(poname.equalsIgnoreCase(""))
        {
            poname="Player O";
        }
        intent.putExtra(O_NAME,poname);
        startActivity(intent);
        finish();
    }
    public void clearEdittext(View view){
        editText1.getText().clear();
        editText2.getText().clear();
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
