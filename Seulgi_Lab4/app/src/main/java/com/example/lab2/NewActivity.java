package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.*;

public class NewActivity extends AppCompatActivity {
    Button button0;
    TextView text_name;
    TextView text_gender;
    TextView text_i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        button0 = (Button)findViewById(R.id.button0);
        text_name = (TextView)findViewById(R.id.text_name);
        text_gender = (TextView)findViewById(R.id.text_gender);
        text_i = (TextView)findViewById(R.id.text_i);
        Intent passedIntent= getIntent();
        if(passedIntent!=null){
            String name = passedIntent.getStringExtra("name");
            String gender = passedIntent.getStringExtra("gender");
            String i = passedIntent.getStringExtra("i");
            text_name.setText(name);
            text_gender.setText(gender);
            text_i.setText(i);
        }

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
    /*
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);

    }*/
}
