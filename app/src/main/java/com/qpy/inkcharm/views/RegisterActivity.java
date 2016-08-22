package com.qpy.inkcharm.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 孤箫残月 on 2016/8/19.
 */
public class RegisterActivity extends Activity {

    Button BT_activity_register_back, BT_activity_register_next;
    EditText ET_activity_register_username, ET_activity_register_password;

    private String register_username, register_password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.qpy.inkcharm.R.layout.activity_register);

        BT_activity_register_back = (Button) findViewById(com.qpy.inkcharm.R.id.BT_activity_register_back);
        BT_activity_register_next = (Button) findViewById(com.qpy.inkcharm.R.id.BT_activity_register_next);
        ET_activity_register_username = (EditText) findViewById(com.qpy.inkcharm.R.id.ET_activity_register_username);
        ET_activity_register_password = (EditText) findViewById(com.qpy.inkcharm.R.id.ET_activity_register_password);

        BT_activity_register_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        BT_activity_register_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }

}