package com.example.jeonjunha.addressbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jeonjunha on 15. 5. 5..
 */
public class FirstActivity extends Activity
{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_data_input);

        final DBManager dbManager = new DBManager(getApplicationContext(), "Address.db", null, 1);

        //DB에 저장할 속성 입력
        final EditText etName = (EditText) findViewById(R.id.input_Name);
        final EditText etNumber = (EditText) findViewById(R.id.input_Phone);

        //쿼리 결과 입력
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);

        //insert
        Button btnInsert = (Button) findViewById(R.id.button_save);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //insert into 테이블명 values (값, 값, 값...);
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                dbManager.insert("insert into ADDRESS_LIST values(null, '" + name + "', " + number + ");");

                tvResult.setText(dbManager.PrintData());
            }
        });

        //delete
        Button btnReset = (Button) findViewById(R.id.button_reset);
        btnReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                dbManager.reset("delete from ADDRESS_LIST");
                dbManager.reset("UPDATE SQLITE_SEQUENCE SET seq = 0 WHERE name = 'ADDRESS_LIST'");
                tvResult.setText(dbManager.PrintData());
            }
        });

    }
}
