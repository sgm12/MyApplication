package com.example.hsm.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getPreferences(MODE_PRIVATE);
        boolean b = sp.contains("myVariable");
        Log.d("myLog",String.valueOf(b));
        String savedText = sp.getString("myVariable", "0");
        Log.d("myLog",savedText);
        Log.d("myLog", String.valueOf(savedText.length()));
        Toast.makeText(this, savedText, Toast.LENGTH_SHORT).show();
        if(savedText=="0"){

            Toast.makeText(this, "firstRun", Toast.LENGTH_SHORT).show();
            sp = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("myVariable","1");
            ed.commit();

        }else
            Toast.makeText(this, "secondRun", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStart()
    {
        super.onStart();

    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
