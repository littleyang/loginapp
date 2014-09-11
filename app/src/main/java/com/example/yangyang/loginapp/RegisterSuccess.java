package com.example.yangyang.loginapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;


public class RegisterSuccess extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register_success, menu);
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

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.check_meat:
                if(checked){
                    AlertDialog.Builder bundle = new AlertDialog.Builder(this);
                    bundle.setMessage("you have check meat ! thank you");
                    bundle.show();
                }
                break;
            case R.id.check_cheese:
                if(checked){
                    AlertDialog.Builder bundle = new AlertDialog.Builder(this);
                    bundle.setMessage("you have check cheese ! thank you");
                    bundle.show();
                }
                break;
            case R.id.check_fruits:
                if(checked){
                    AlertDialog.Builder bundle = new AlertDialog.Builder(this);
                    bundle.setMessage("you have check fruit ! thank you");
                    bundle.show();
                }
                break;
        }
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked) {
                    AlertDialog.Builder bundle = new AlertDialog.Builder(this);
                    bundle.setMessage("you have select radio_pirates ! thank you");
                    bundle.show();
                }
                break;
            case R.id.radio_ninjas:
                if (checked) {
                    AlertDialog.Builder bundle = new AlertDialog.Builder(this);
                    bundle.setMessage("you have select radio_ninjas ! thank you");
                    bundle.show();
                }
                break;
        }
    }
}
