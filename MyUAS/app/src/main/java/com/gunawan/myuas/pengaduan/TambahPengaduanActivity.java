package com.gunawan.myuas.pengaduan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gunawan.myuas.R;

public class TambahPengaduanActivity extends AppCompatActivity {
    EditText edNama, edNik, edIsi;
    Button btnSimpan;

    RealmHelper realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengaduan);

        realm = new RealmHelper(TambahPengaduanActivity.this);

        edNama = findViewById(R.id.ed_nama);
        edNik = findViewById(R.id.ed_nik);
        edIsi = findViewById(R.id.ed_isi);
        btnSimpan = findViewById(R.id.btn_simpan);


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatatanModul catatan = new CatatanModul();
                catatan.setId((int) realm.getNextId());
                catatan.setNama(edNama.getText().toString());
                catatan.setNik(edNik.getText().toString());
                catatan.setIsi(edIsi.getText().toString());

                realm.insertData(catatan);
                finish();
            }
        });
    }
}

