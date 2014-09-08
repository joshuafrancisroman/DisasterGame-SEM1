package testingforjosh.com.disastergame;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Scenarios extends ActionBarActivity {
    TextView scene;
    RadioButton choice1;
    RadioButton choice2;
    RadioButton choice3;
    RadioButton choice4;
    ImageView image;
    TypedArray tscene;
    TypedArray tchoice1;
    TypedArray tchoice2;
    TypedArray tchoice3;
    TypedArray tchoice4;
    public static int sound;
    public static int deadAddress;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenario);
        //xml objects initializations
        scene=(TextView)findViewById(R.id.textView);
        image=(ImageView)findViewById(R.id.imageView);
        choice1=(RadioButton)findViewById(R.id.radioButton);
        choice2=(RadioButton)findViewById(R.id.radioButton2);
        choice3=(RadioButton)findViewById(R.id.radioButton3);
        choice4=(RadioButton)findViewById(R.id.radioButton4);
        //array initializations
        tscene=getResources().obtainTypedArray(R.array.scenario);
        tchoice1=getResources().obtainTypedArray(R.array.choice1);
        tchoice2=getResources().obtainTypedArray(R.array.choice2);
        tchoice3=getResources().obtainTypedArray(R.array.choice3);
        tchoice4=getResources().obtainTypedArray(R.array.choice4);
        Intent intent=getIntent();
        int imageAddress=0;sound=0; //need to store in integer because accessing R.something.something returns the address in int value
        deadAddress=0;
        switch(Title.pic)//processing which image to use.
        {
            case 0:imageAddress=R.drawable.firedoor; deadAddress=R.drawable.firedoor1;sound=R.raw.fire; break;
            case 1:

        }
        //putting content into the xml objects
        image.setImageResource(imageAddress);
        scene.setText(intent.getStringExtra("scene"));
        choice1.setText(intent.getStringExtra("choice1"));
        choice2.setText(intent.getStringExtra("choice2"));
        choice3.setText(intent.getStringExtra("choice3"));
        choice4.setText(intent.getStringExtra("choice4"));
        mediaPlayer=MediaPlayer.create(this,Scenarios.sound);
        mediaPlayer.start();

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.title, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {

    }

    public void next(View view)
    {
        if(Title.run1==0 && view.getId()==R.id.radioButton)
        {
            Title.run2++;
            Intent intent=new Intent(this,gameover.class);
            mediaPlayer.stop();
            startActivity(intent);
        }

        else {
            Intent intent = new Intent(this, Scenarios.class);
            Title.run1++;Title.run2++;Title.run3++;Title.run4++;Title.main++;
            intent.putExtra("image",Title.main);
            intent.putExtra("scene", tscene.getText(Title.main));
            intent.putExtra("choice1", tchoice1.getText(Title.run1));
            intent.putExtra("choice2", tchoice2.getText(Title.run2));
            intent.putExtra("choice3", tchoice3.getText(Title.run3));
            intent.putExtra("choice4", tchoice4.getText(Title.run4));

            mediaPlayer.stop();
            startActivity(intent);

        }
    }
/*
    public void next2(View view)
    {
        if(Title.run==0)
        {

            Intent intent=new Intent(this,Scenarios.class);
            intent.putExtra("image","0");
            intent.putExtra("scene",tscene.getText(Title.run+1));
            intent.putExtra("choice1",tchoice1.getText(Title.run));
            intent.putExtra("choice2",tchoice2.getText(Title.run+1));
            intent.putExtra("choice3",tchoice3.getText(Title.run));
            intent.putExtra("choice4",tchoice4.getText(Title.run));
            startActivity(intent);
        }
        else{
        Intent intent=new Intent(this,Scenarios.class);
        Title.run++;
        intent.putExtra("image","0");
        intent.putExtra("scene",tscene.getText(Title.run));
        intent.putExtra("choice1",tchoice1.getText(Title.run));
        intent.putExtra("choice2",tchoice2.getText(Title.run));
        intent.putExtra("choice3",tchoice3.getText(Title.run));
        intent.putExtra("choice4",tchoice4.getText(Title.run));
        startActivity(intent);
        }
    }

    public void next3(View view)
    {
        Intent intent=new Intent(this,Scenarios.class);

        Title.run++;
        intent.putExtra("image","0");
        intent.putExtra("scene",tscene.getText(Title.run));
        intent.putExtra("choice1",tchoice1.getText(Title.run));
        intent.putExtra("choice2",tchoice2.getText(Title.run));
        intent.putExtra("choice3",tchoice3.getText(Title.run));
        intent.putExtra("choice4",tchoice4.getText(Title.run));
        startActivity(intent);
    }
    public void next4(View view)
    {
        Intent intent=new Intent(this,Scenarios.class);

        Title.run++;
        intent.putExtra("image","0");
        intent.putExtra("scene",tscene.getText(Title.run));
        intent.putExtra("choice1",tchoice1.getText(Title.run));
        intent.putExtra("choice2",tchoice2.getText(Title.run));
        intent.putExtra("choice3",tchoice3.getText(Title.run));
        intent.putExtra("choice4",tchoice4.getText(Title.run));
        startActivity(intent);
    }*/
}
