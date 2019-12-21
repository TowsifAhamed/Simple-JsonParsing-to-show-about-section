package com.example.simplejsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    public static TextView mname;
    public static TextView mwebsite;
    public static TextView mmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mname = findViewById(R.id.name);
        mwebsite = findViewById(R.id.website);
        mmail = findViewById(R.id.mail);

        Button mfetch = findViewById(R.id.fetch);
        mfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData process = new FetchData();
                process.execute();
            }
        });
    }
}
