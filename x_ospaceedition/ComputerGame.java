package my.chan.com.x_ospaceedition;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class ComputerGame extends ActionBarActivity {
    int symbol=0;
    public final static String PASS_X="my.chan.com.x_ospaceedition.PASS_X";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_game);
    }
    public void setX(View view) {
        Intent intent = new Intent(this, AIgame.class);
        intent.putExtra(PASS_X,"1");
        startActivity(intent);
        finish();
    }
    public void setO(View view){
        Intent intent = new Intent(this,AIgame.class);
        intent.putExtra(PASS_X,"2");
        startActivity(intent);
        finish();
    }
    public void randomSym(View view){
        int min = 1;
        int max = 2;
        Random rand = new Random();
        symbol = rand.nextInt((max-min)+1)+min;
        Intent intent=new Intent(this,AIgame.class);
        if(symbol==1){
        intent.putExtra(PASS_X,"1");
        startActivity(intent);
        finish();}
        if(symbol==2){
        intent.putExtra(PASS_X,"2");
        startActivity(intent);
        finish();}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_computer_game, menu);
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
}
