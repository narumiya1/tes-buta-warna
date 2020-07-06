package com.eijunn.tesbutawarna.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.eijunn.tesbutawarna.R;

import butterknife.ButterKnife;

public class PanduanActivity extends AppCompatActivity {

    private static final String TAG = "Panduan" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan);
        ButterKnife.bind(this);
    }
}
