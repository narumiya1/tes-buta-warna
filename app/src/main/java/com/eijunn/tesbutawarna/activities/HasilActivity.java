package com.eijunn.tesbutawarna.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eijunn.tesbutawarna.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HasilActivity extends AppCompatActivity {

    private static final String TAG = "HasilActivity" ;
    int jawabanBenar, jawabanSalah, jumlahTest = 0;
    @BindView(R.id.img_tes)
    ImageView imageTes ;
    @BindView(R.id.tv_hasil)
    TextView tvHasil ;
    @BindView(R.id.tv_hasil_hitung)
    TextView tvHasilHitung ;
    @BindView(R.id.lay_jawaban)
    LinearLayout layJawabann ;
    @BindView(R.id.btn_tes_lagi)
    TextView btnTesLagi ;
    @BindView(R.id.btn_home)
    TextView btnHome ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        ButterKnife.bind(this);

        jawabanBenar = getIntent().getIntExtra("benar", 0);
        jumlahTest = getIntent().getIntExtra("jumlah", 0);

        if (jawabanBenar > 8) {
            Glide.with(this).load(R.drawable.happy).into(imageTes);
            tvHasil.setText("NORMAL");
        }else if ( jawabanBenar > 1 && jawabanBenar <8) {
            Glide.with(this).load(R.drawable.smiling).into(imageTes);
            tvHasil.setText("buta warna parsial");
        }else {
            Glide.with(this).load(R.drawable.unhappy).into(imageTes);
            tvHasil.setText("buta warna total");
        }

        tvHasilHitung.setText("Anda Betul " + jawabanBenar + " dari " + jumlahTest + " Pertanyaan");


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick({R.id.btn_tes_lagi, R.id.btn_home})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.btn_tes_lagi :
                Intent intent = new Intent(this, TesActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.btn_home :
                finish();
                break;

        }
    }
}
