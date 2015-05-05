package com.example.jeonjunha.addressbook;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jeonjunha on 15. 5. 5..
 */
public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_list_item);
    }
}
