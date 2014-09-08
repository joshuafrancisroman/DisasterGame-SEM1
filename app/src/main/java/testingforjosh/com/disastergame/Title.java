package testingforjosh.com.disastergame;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Title extends ActionBarActivity {
    public TypedArray tscene;
    public TypedArray tchoice1;
    public TypedArray tchoice2;
    public TypedArray tchoice3;
    public TypedArray tchoice4;
    public static int run1=0;
    public static int run2=0;
    public static int run3=0;
    public static int run4=0;
    public static int main=0;
    public static Integer pic=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run1=run2=run3=run4=main=0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void start(View view)
    {

        tscene=getResources().obtainTypedArray(R.array.scenario);
        tchoice1=getResources().obtainTypedArray(R.array.choice1);
        tchoice2=getResources().obtainTypedArray(R.array.choice2);
        tchoice3=getResources().obtainTypedArray(R.array.choice3);
        tchoice4=getResources().obtainTypedArray(R.array.choice4);
        Intent intent=new Intent(this,Scenarios.class);
        intent.putExtra("image",pic.toString());
        intent.putExtra("scene",tscene.getText(main));
        intent.putExtra("choice1",tchoice1.getText(run1));
        intent.putExtra("choice2",tchoice2.getText(run2));
        intent.putExtra("choice3",tchoice3.getText(run3));
        intent.putExtra("choice4",tchoice4.getText(run4));
        startActivity(intent);
    }

}
