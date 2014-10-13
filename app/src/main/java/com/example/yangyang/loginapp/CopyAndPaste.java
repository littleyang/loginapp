package com.example.yangyang.loginapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;


public class CopyAndPaste extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_and_paste);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.copy_and_paste, menu);
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

    public void copyData(View view){

        // get clip board manager
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // create clip data object
        ClipData clipData = ClipData.newPlainText("simple text","Hello, World!");

        //set clip data to clipboard manager
        clipboardManager.setPrimaryClip(clipData);
    }

    public void pastedData(View view){

        // define a string message
        String copyMessage = "";

        //get the clipboard manager
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // get the  pasted button
        Button pasteButton = (Button)findViewById(R.id.paste_data);

        //message view
        EditText editText = (EditText)findViewById(R.id.pasted_message_input);

        //check the clipboard manager to set the button enable
        if(!clipboardManager.hasPrimaryClip()){
            // If the clipboard doesn't contain data, disable the paste menu item.
            // If it does contain data, decide if you can handle the data.
            pasteButton.setEnabled(false);
        }else if(!(clipboardManager.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN))){
            // This disables the paste menu item, since the clipboard has data but it is not plain text
            pasteButton.setEnabled(false);

        }else{
            // set paste button enable
            pasteButton.setEnabled(true);
            ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
            copyMessage = item.getText().toString();
            editText.setText(item.getText());

        }


    }


}
