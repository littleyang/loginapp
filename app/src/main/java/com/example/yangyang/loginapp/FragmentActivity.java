package com.example.yangyang.loginapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentActivity extends Activity implements View.OnClickListener{


    // message fragment
    private MessageFragment messageFragment;

    // contacts fragment
    private  ContactsFragment contactsFragment;

    // news fragment
    private  NewsFragment newsFragment;

    //setting fragment
    private  SettingFragment settingFragment;

    // message layout
    private  View messageViewLayout;

    //contact layout
    private View contactViewLayout;

    // news layout
    private View newsViewLayout;

    // setting layout
    private View settingViewLayout;

    // message image view
    private ImageView messageImageView;

    // contact image view
    private ImageView contactImageView;

    // news image view
    private  ImageView newsImageView;

    //setting image view
    private ImageView settingImageView;

    // message text view
    private TextView messageText;

    // contact text view
    private TextView contactsText;

    // news text view
    private TextView newsText;

    // setting text view
    private TextView settingText;

    // fragment manager
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);
        // init elements
        initViews();
        fragmentManager = getFragmentManager();
        // first start ,select first tab
        setTabSelection(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fragment, menu);
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
    public void onClick(View view) {

        switch (view.getId()){
            case R.layout.messages:
                setTabSelection(0);
                break;
            case R.layout.contacts:
                setTabSelection(1);
                break;
            case R.layout.news:
                setTabSelection(2);
                break;
            case R.layout.settings:
                setTabSelection(3);
                break;
        }

    }

    private  void initViews(){

        messageViewLayout = findViewById(R.id.message_layout);
        contactViewLayout = findViewById(R.id.contacts_layout);
        newsViewLayout = findViewById(R.id.news_layout);
        settingViewLayout = findViewById(R.id.setting_layout);

        messageImageView = (ImageView)findViewById(R.id.message_image);
        contactImageView = (ImageView)findViewById(R.id.contacts_image);
        newsImageView = (ImageView) findViewById(R.id.news_image);
        settingImageView = (ImageView)findViewById(R.id.setting_image);

        messageText = (TextView) findViewById(R.id.message_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        settingText = (TextView)findViewById(R.id.setting_text);

        messageViewLayout.setOnClickListener(this);
        contactViewLayout.setOnClickListener(this);
        newsViewLayout.setOnClickListener(this);
        settingViewLayout.setOnClickListener(this);

    }

    private void setTabSelection(int index){
        // clean last status
        clearSelection();

        // open an fragment transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // hidden all fragment
        hideFragments(transaction);

        switch (index){

            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messageImageView.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                contactImageView.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if (contactsFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                newsImageView.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(newsFragment);
                }
                break;
            case 3:
            default:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                settingImageView.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if (settingFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);
                }
                break;

        }
        // commit the transaction
        transaction.commit();


    }

    private  void clearSelection(){
        messageImageView.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactImageView.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImageView.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImageView.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }

    private  void hideFragments(FragmentTransaction transaction){
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }
}
