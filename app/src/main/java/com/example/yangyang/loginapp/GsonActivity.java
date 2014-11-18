package com.example.yangyang.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GsonActivity extends Activity {

    private String singleGsonString = "{\"name\":\"test one\",\"age\":26}";
    private String arrayGsonString = "[{\"name\":\"test two\",\"age\":27},{\"name\":\"test three\",\"age\":28}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Button singleButton = (Button) findViewById(R.id.single_gson);
        singleButton.setOnClickListener(new SingleGsonOnClickListener());

        Button arrayButton = (Button) findViewById(R.id.array_gson);
        arrayButton.setOnClickListener(new ArrayGsonOnClickListener());

    }

    private class SingleGsonOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            GsonUtil util = new GsonUtil();
            util.parsonSingleGsonObject(singleGsonString);
        }
    }

    private class ArrayGsonOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            GsonUtil util = new GsonUtil();
            util.parsonArrayGsonObject(arrayGsonString);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gson, menu);
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
