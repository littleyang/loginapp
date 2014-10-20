package com.example.yangyang.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class ShowAnimation extends Activity {

    // define all button and imagine
    private Button translateButton = null;
    private Button alphaButton = null;
    private Button rotateButton = null;
    private Button scaleButton = null;
    private ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animation);

        // find buttons
        translateButton = (Button) findViewById(R.id.translate_animation);
        translateButton.setOnClickListener( new TranslateButtonOnClickListener());

        alphaButton = (Button) findViewById(R.id.alpha_animation);
        alphaButton.setOnClickListener(new AlphaAnimationListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_animation, menu);
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

    private class TranslateButtonOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

        }
    }

    private class AlphaAnimationListener implements  View.OnClickListener{
        @Override
        public void onClick(View view) {
            
        }
    }

}
