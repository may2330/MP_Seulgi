package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox sms;
    CheckBox email;
    RadioButton man;
    RadioButton woman;
    Button button1;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        sms = (CheckBox)findViewById(R.id.sms);
        email = (CheckBox)findViewById(R.id.email);
        man = (RadioButton)findViewById(R.id.man);
        woman = (RadioButton)findViewById(R.id.woman);
        button1 = (Button) findViewById(R.id.button1);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //String loginName = Name.getText().toString();
                //String loginAge = Age.getText().toString();
                String name = ": "+ editText.getText().toString();

                String gender=": ";
                int radioId = radioGroup.getCheckedRadioButtonId();
                if(man.getId()==radioId)
                    gender = gender+ " man";
                if(woman.getId()==radioId)
                    gender = gender + " woman";

                String i=": ";
                if(sms.isChecked())
                    i=i+" sms";
                if(email.isChecked())
                    i=i+" email";

                Intent intent =new Intent(getApplicationContext(),NewActivity.class);
               // intent.putExtra("loginName",loginName);
               // intent.putExtra("loginAge",loginAge);
                intent.putExtra("name",name);
                intent.putExtra("gender",gender);
                intent.putExtra("i",i);
                startActivity(intent);
                //Intent i = new Intent(getApplicationContext(),NewActivity.class);
                //startActivityForResult(i,1);
            }
        });
    }
}
