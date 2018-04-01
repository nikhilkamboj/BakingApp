package com.nikhil.bakeit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BakeMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bake_main);

        DbFillUp.fillDb(this);
    }
}
