package com.example.user.lab6;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText txtData;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    File path = Environment.getExternalStorageDirectory();
    File directory = new File(path.getAbsolutePath() + "/MyFiles");
    File file = new File(directory, "textfile.txt");
    FileOutputStream fOut = null;
    OutputStreamWriter osw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (EditText) findViewById(R.id.txtData);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                directory.mkdirs();
                try {
                    fOut = new FileOutputStream(file);
                    PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(fOut));
                    String str = txtData.getText().toString();
                    printWriter.println(str);
                    printWriter.flush();
                    fOut.close();
                    Toast.makeText(getApplicationContext(), "Write SD File", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                txtData.setText("");
                Toast.makeText(MainActivity.this, "Clear Screen", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileInputStream fIn;
                    BufferedReader bfReader;
                    fIn = new FileInputStream(file);
                    bfReader = new BufferedReader(new FileReader(file));
                    String all_str="";
                    String str;
                    while ((str = bfReader.readLine()) != null) {
                        all_str += str+"\n";
                    }
                    fIn.close();
                    Toast.makeText(MainActivity.this, "Read SD File", Toast.LENGTH_SHORT).show();
                    txtData.setText(all_str);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error: button3", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {
            public void onClick (View v){
                Toast.makeText(MainActivity.this, "Finish App", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}