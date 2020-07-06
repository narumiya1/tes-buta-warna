package com.eijunn.tesbutawarna;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.eijunn.tesbutawarna.activities.AboutActivity;
import com.eijunn.tesbutawarna.activities.PanduanActivity;
import com.eijunn.tesbutawarna.activities.TesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar ;
    @BindView(R.id.tv_toolbar)
    TextView textView ;
    @BindView(R.id.btn_play)
    LinearLayout btnPlay ;
    @BindView(R.id.btn_about)
    LinearLayout btnAbout ;
    @BindView(R.id.btn_panduan)
    LinearLayout btnPanduan ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick({R.id.btn_play, R.id.btn_panduan, R.id.btn_about})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.btn_about :
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.btn_panduan:
                startActivity(new Intent(MainActivity.this, PanduanActivity.class));
                break;
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this, TesActivity.class));
                break;
        }
    }


}
