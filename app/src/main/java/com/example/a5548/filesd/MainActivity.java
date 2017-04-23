package com.example.a5548.filesd;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
    EditText e;TextView t;Button s,r;
    String fname = "input.txt";
    String fpath = "storage";
    File f;
    String d = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = (EditText) findViewById(R.id.e);
        t = (TextView) findViewById(R.id.t);
        s = (Button) findViewById(R.id.s);
        r = (Button) findViewById(R.id.r);

        s.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(f);
                    fos.write(e.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                }
                e.setText("");
                t.setText("Input saved to External Storage...");
            }
        });


        r.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = new FileInputStream(f);
                    DataInputStream dis = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(dis));
                    String line;
                    while ((line = br.readLine()) != null) {
                        d = d + " " + line;
                    }
                    dis.close();
                } catch (IOException e) {
                }
                e.setText(d);
                t.setText("Input data retrieved from Internal Storage...");
            }
        });
        f = new File(getExternalFilesDir (fpath), fname);
    }
}