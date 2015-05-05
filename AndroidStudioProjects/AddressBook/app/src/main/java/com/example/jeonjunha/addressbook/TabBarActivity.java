package com.example.jeonjunha.addressbook;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


/**
 * Created by jeonjunha on 15. 5. 5..
 */
public class TabBarActivity extends TabActivity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, FirstActivity.class);
        spec = tabHost.newTabSpec("First");
        spec.setIndicator("First");
        spec.setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, SecondActivity.class);
        spec = tabHost.newTabSpec("Second");
        spec.setIndicator("Second");
        spec.setContent(intent);
        tabHost.addTab(spec);

    }
}
