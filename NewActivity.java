package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.*;

public class NewActivity extends AppCompatActivity {
    Button button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        button0 = (Button)findViewById(R.id.button0);

        Intent passedIntent= getIntent();
        if(passedIntent!=null){
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");
            Toast.makeText(getApplication(),"Student Info: "+loginName+","+loginAge,Toast.LENGTH_LONG).show();
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
