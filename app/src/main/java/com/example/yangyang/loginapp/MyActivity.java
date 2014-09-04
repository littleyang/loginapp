package com.example.yangyang.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends Activity {

    public final static String USERNAME = "user name";
    public final static String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public void loginToApp(View view){
        Intent intent = new Intent(this,LoginSuccess.class);
        EditText nameEditText = (EditText)findViewById(R.id.user_name);
        String name = nameEditText.getText().toString();
        EditText pwdEditText = (EditText)findViewById(R.id.user_password);
        String passWord = pwdEditText.getText().toString();
        intent.putExtra(USERNAME,name);
        intent.putExtra(PASSWORD,passWord);
        startActivity(intent);

    }

    public void registerApp(View view){

    }
}
