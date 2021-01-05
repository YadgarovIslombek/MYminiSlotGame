package com.example.myslotgame;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private int slotTanlash1 = -1;
    private int slotTanlash2 = -1;
    private int slotTanlash3 = -1;

    private ImageView slotImageView1;
    private ImageView slotImageView2;
    private ImageView slotImageView3;
    private TextView gameTextView;
    private TextView winsTextView;
    private TextView lossTextView;
    private TextView winCountTextView;
    private TextView lossCountTextView;
    private Random r1 = new Random();
    private Random r2 = new Random();
    private Random r3 = new Random();
    private int YutishlarCount = 0;
    private int YutqizishCount = 0;
    private int almostCount = 0;

    private MediaPlayer golibMusic;
    private MediaPlayer maglubMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        slotImageView1 = (ImageView)findViewById(R.id.slotImageView1);
        slotImageView2 = (ImageView)findViewById(R.id.slotImageView2);
        slotImageView3 = (ImageView)findViewById(R.id.slotImageView3);
        gameTextView = (TextView)findViewById(R.id.gameTextView);
        winsTextView = (TextView)findViewById(R.id.winsTextView);
        lossTextView = (TextView)findViewById(R.id.lossTextView);
        winCountTextView = (TextView)findViewById(R.id.winCountTextView);
        lossCountTextView = (TextView)findViewById(R.id.lossCountTextView);


        //gameTextView.setText(getString(R.string.spin_message));
        winCountTextView.setText(String.valueOf(YutishlarCount));
        lossCountTextView.setText(String.valueOf(YutqizishCount));

        slotImageView1.setImageResource(R.mipmap.cherry);
        slotImageView2.setImageResource(R.mipmap.goldbars);
        slotImageView3.setImageResource(R.mipmap.goldstar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void delaySpin(int times){
        final Handler handler = new Handler();
        times--;
        final int timesTracker = times;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                slotTanlash1 = r1.nextInt(5);
                slotTanlash2 = r2.nextInt(5);
                slotTanlash3 = r3.nextInt(5);
                slotSelect(slotTanlash1, slotTanlash2, slotTanlash3);
                if (timesTracker != 0) {
                    delaySpin(timesTracker);
                } else {
                    gameResults(slotTanlash1, slotTanlash2, slotTanlash3);
                }
            }
        }, 100);
    }



    public void spinSelected(View view){
        slotTanlash1 = r1.nextInt(5);
        slotTanlash2 = r2.nextInt(5);
        slotTanlash3 = r3.nextInt(5);
        slotSelect(slotTanlash1, slotTanlash2, slotTanlash3);
        delaySpin(20);

    }

    public void gameResults(int slotSelection1, int slotSelection2, int slotSelection3) {
        if(slotSelection1 == slotSelection2 && slotSelection2 == slotSelection3) {
            userWonGame();

        }
        else if(slotSelection1 == slotSelection2 || slotSelection1 == slotSelection3
                || slotSelection2 == slotSelection3) {
            userAlmostGame();
        }
        else {
            userLostGame();
        }

    }


    private void userWonGame() {
        gameTextView.setText(getString(R.string.win_message));
        //winSound.start();
        YutishlarCount++;
        winCountTextView.setText(String.valueOf(YutishlarCount));
        /*
        //creating vibration pattern
        int length = 200;		// Length in milliseconds
        int pause = 200;	// Length of pause
        long[] pattern = {0,length, pause, length, pause, length };
        vibrate.vibrate(pattern, -1);*/

    }
    private void userAlmostGame() {
        gameTextView.setText(getString(R.string.almost_message));

        almostCount++;
        YutqizishCount++;
        lossCountTextView.setText(String.valueOf(YutqizishCount));
    }
    private void userLostGame() {
        gameTextView.setText(getString(R.string.lose_message));

        YutqizishCount++;
        lossCountTextView.setText(String.valueOf(YutqizishCount));
    }

    public void slotSelect(int slotSelection1, int slotSelection2, int slotSelection3) {


        if(slotSelection1 == 0 ) {
            slotImageView1.setImageResource(R.mipmap.cherry);

        }
        if(slotSelection1 == 1 ) {
            slotImageView1.setImageResource(R.mipmap.goldbars);

        }
        if(slotSelection1 == 2 ) {
            slotImageView1.setImageResource(R.mipmap.goldenbell);

        }
        if(slotSelection1 == 3 ) {
            slotImageView1.setImageResource(R.mipmap.goldstar);

        }
        if(slotSelection1 == 4 ) {
            slotImageView1.setImageResource(R.mipmap.lucky7);

        }
        if(slotSelection2 == 0 ) {
            slotImageView2.setImageResource(R.mipmap.cherry);
        }
        if(slotSelection2 == 1 ) {
            slotImageView2.setImageResource(R.mipmap.goldbars);
        }
        if(slotSelection2 == 2 ) {
            slotImageView2.setImageResource(R.mipmap.goldenbell);
        }
        if(slotSelection2 == 3 ) {
            slotImageView2.setImageResource(R.mipmap.goldstar);
        }
        if(slotSelection2 == 4 ) {
            slotImageView2.setImageResource(R.mipmap.lucky7);
        }
        if(slotSelection3 == 0 ) {
            slotImageView3.setImageResource(R.mipmap.cherry);
        }
        if(slotSelection3 == 1 ) {
            slotImageView3.setImageResource(R.mipmap.goldbars);
        }
        if(slotSelection3 == 2 ) {
            slotImageView3.setImageResource(R.mipmap.goldenbell);
        }
        if(slotSelection3 == 3 ) {
            slotImageView3.setImageResource(R.mipmap.goldstar);
        }
        if(slotSelection3 == 4 ) {
            slotImageView3.setImageResource(R.mipmap.lucky7);
        }

    }

}
