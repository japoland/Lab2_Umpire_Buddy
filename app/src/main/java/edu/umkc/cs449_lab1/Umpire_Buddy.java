package edu.umkc.cs449_lab1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class Umpire_Buddy extends AppCompatActivity {

    TextView strikeCount;
    TextView ballCount;
    int ball_count = 0;
    int strike_count=0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpire__buddy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        strikeCount = (TextView) findViewById(R.id.strikevalue);
        ballCount = (TextView) findViewById(R.id.ballvalue);
    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.my_menu, menu);
       return true;
    }
    public void OutAlert() {
        new AlertDialog.Builder(Umpire_Buddy.this)
                .setTitle("Out!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                }).show();
    }
    public void WalkAlert(){
        new AlertDialog.Builder(Umpire_Buddy.this)
                .setTitle("Walk!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                }).show();
    }
    public void strike_count(View view) {
        strike_count++;
        if(strike_count==3) {
            OutAlert();
            strike_count = 0;
            ball_count = 0;
        }
        strikeCount.setText("Strike: " + Integer.toString(strike_count));
        ballCount.setText("Ball: " + Integer.toString(ball_count));
    }
    public void ball_count(View view){
        ball_count++;
        if(ball_count==4){
            WalkAlert();
            ball_count = 0;
            strike_count = 0;
        }
        ballCount.setText("Ball: " + Integer.toString(ball_count));
        strikeCount.setText("Strike: " + Integer.toString(strike_count));
    }
}