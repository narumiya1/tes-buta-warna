package com.eijunn.tesbutawarna.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eijunn.tesbutawarna.R;
import com.eijunn.tesbutawarna.model.Tes;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TesActivity extends AppCompatActivity {

    private static final String TAG = "TesActivity";

    @BindView(R.id.img_tes)
    ImageView imageTes;
    @BindView(R.id.tv_text_jawaban)
    TextView tvTextJawaban;
    @BindView(R.id.tv_jawaban)
    TextView tvJawaban;
    @BindView(R.id.tv_jawaban_benar)
    TextView tvJawabanBenar;
    @BindView(R.id.et_jawaban)
    EditText etJawaban;
    @BindView(R.id.btn_next)
    Button buttonNext;
    @BindView(R.id.btn_jawab)
    ImageButton buttonJawab;

    @BindView(R.id.lay_jawaban)
    TextView layJawaban;

    List<Tes> tesList = new ArrayList<>();

    String[] jawaban = new String[]{"2", "3", "5", "6", "7", "8", "12", "15", "16", "57", "73", "74", "96", "97", "45"};
    ;
    int[] gambar = new int[]{
            R.drawable.ishihara_2,
            R.drawable.ishihara_3,
            R.drawable.ishihara_5,
            R.drawable.ishihara_6,
            R.drawable.ishihara_7,
            R.drawable.ishihara_8,
            R.drawable.ishihara_12,
            R.drawable.ishihara_15,
            R.drawable.ishihara_16,
            R.drawable.ishihara_57,
            R.drawable.ishihara_73,
            R.drawable.ishihara_74,
            R.drawable.ishihara_96,
            R.drawable.ishihara_97,
            R.drawable.ishihara_45,
    };

    boolean next = false;

    int pos = 0;

    int jawabanBenar, jawabanSalah, jumlahTest = 0;
    @BindView(R.id.tv_jumlah_pertanyaan)
    TextView tvJumlahPertanyaan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);
        ButterKnife.bind(this);

        initViews();

        generateSoal();

        Glide.with(this).load(gambar[pos]).into(imageTes);
        tvJumlahPertanyaan.setText(String.valueOf(pos + 1) + "/" + tesList.size());
    }

    private void initViews() {
        layJawaban.setVisibility(View.GONE);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick({R.id.btn_jawab, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_jawab:

                if (next) {
                    Toast.makeText(this, "Tekan next untuk melanjutkan", Toast.LENGTH_SHORT).show();
                } else {
                    jawabPertanyaan();
                }
                break;

            case R.id.btn_next:

                if (pos != tesList.size()) {
                    if (next) {
                        hideJawaban();
                    } else {
                        Toast.makeText(this, "Harap Jawab Pertanyaan Terlebih Dahulu ! ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    for (int i = 0 ; i<tesList.size(); i++) {
                        Log.d(TAG,"Jawaban betul = " + tesList.get(i).isBetul());
                        if (tesList.get(i).isBetul()) {
                            jawabanBenar++;
                        }else {
                            jawabanSalah++;
                        }
                    }

                    jumlahTest = tesList.size();

                    openHasil() ;

                }

                break;
        }
    }

    private void openHasil() {
        Intent intent = new Intent(this, HasilActivity.class);
        intent.putExtra("benar", jawabanBenar);
        intent.putExtra("salah", jawabanSalah);

    }

    private void hideJawaban() {
        next =false ;
        layJawaban.setVisibility(View.GONE);
        etJawaban.setText("");
        Glide.with(this).load(gambar[pos]).into(imageTes) ;
        buttonNext.setVisibility(View.INVISIBLE);
        tvJumlahPertanyaan.setText(String.valueOf(pos+1) + "/" + tesList.size());

    }

    private void jawabPertanyaan() {
        if (pos != tesList.size()){
            next = true ;
            jawab();
        }
    }

    private void jawab() {
        buttonNext.setVisibility(View.VISIBLE);
        layJawaban.setVisibility(View.VISIBLE);
        tvJawabanBenar.setText(String.valueOf(jawaban[pos]));

        Log.d(TAG, "jawab:" +etJawaban.getText().toString()+ " " +tesList.get(pos).getJawaban() ) ;
        if (etJawaban.getText().toString().equals(tesList.get(pos).getJawaban())) {
            tesList.get(pos).setBetul(true);
            tvJawaban.setText("betul");
            Log.d(TAG, "betul") ;
        }else {
            tesList.get(pos).setBetul(false);
            tvJawaban.setText("salah");
            Log.d(TAG, "salah") ;
        }

        //
        pos++;

    }

    private void generateSoal() {
        tesList.add(new Tes(jawaban[0], gambar[0])) ;
        tesList.add(new Tes(jawaban[1], gambar[1]));
        tesList.add(new Tes(jawaban[2], gambar[2]));
        tesList.add(new Tes(jawaban[3], gambar[3]));
        tesList.add(new Tes(jawaban[4], gambar[4]));
        tesList.add(new Tes(jawaban[5], gambar[5]));
        tesList.add(new Tes(jawaban[6], gambar[6]));
        tesList.add(new Tes(jawaban[7], gambar[7]));
        tesList.add(new Tes(jawaban[8], gambar[8]));
        tesList.add(new Tes(jawaban[9], gambar[9]));
        tesList.add(new Tes(jawaban[10], gambar[10]));
        tesList.add(new Tes(jawaban[11], gambar[11]));
        tesList.add(new Tes(jawaban[12], gambar[12]));
        tesList.add(new Tes(jawaban[13], gambar[13]));
        tesList.add(new Tes(jawaban[14], gambar[14]));

    }

    @Override
    public void onBackPressed() {
        closeDialog() ;
    }

    private void closeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("yakin untuk membatalkan tes buta waerna") ;
        builder.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("kembali", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

