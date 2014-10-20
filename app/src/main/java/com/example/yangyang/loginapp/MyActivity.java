package com.example.yangyang.loginapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MyActivity extends Activity {

    public final static String USERNAME = "user name";
    public final static String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //getFragmentManager().beginTransaction().replace(android.R.id.content,new SettingsActivity()).commit();
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
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void showList(View view){
        Intent intent = new Intent(this,PopListView.class);
        startActivity(intent);
    }

    public void showLoginDialog(View view){
        DialogFragment fragment = new CustomDialogByXml();
        fragment.show(getFragmentManager(),"Login Dialog");
    }


    public void showFragment(View view){
        Intent intent = new Intent(this,FragmentActivity.class);
        startActivity(intent);
    }

    public void showNotification(View view){

        String currentText = "Test Notification";
        Notification.Builder notificationBuilder = new Notification.Builder(this);
        notificationBuilder.setContentTitle("Fragment Notification");
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
        notificationBuilder.setContentText(currentText);

        // create explicit  intent for an Activity in your app

        Intent  intent = new Intent(this,FragmentActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(this);
        stackBuilder.addNextIntent(intent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(resultPendingIntent);

        // notification manager
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        // notificationBuilder.addAction(null);

        // update current notification

//        notificationBuilder = new Notification.Builder(this);
//        notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
//        notificationBuilder.setContentTitle("New message");
//        notificationBuilder.setContentText("you are receive new message!!!!");
//        int messageNumber = 0;
//        notificationBuilder.setContentText(currentText).setNumber(messageNumber++);
//
        manager.notify(0,notificationBuilder.build());
    }

    // show drag and drop activity
    public void showDragAndDropActivity(View view){

        Intent intent = new Intent(this,DragAndDrop.class);
        startActivity(intent);

    }

    // show drag and drop activity
    public void showCopyAndPasteActivity(View view){

        Intent intent = new Intent(this,CopyAndPaste.class);
        startActivity(intent);

    }

    public void showImeActivity(View view){
        Intent intent = new Intent(this,ime.class);
        startActivity(intent);

    }

    public void showAnimationActivity(View view){

        

    }
}
