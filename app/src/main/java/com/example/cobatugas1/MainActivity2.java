package com.example.cobatugas1;



        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtStb, txtNama;
    EditText txtNilaiTugas, txtNilaiMid, txtNilaiFinal;
    //    public static final String KEY_NILAI_TUGAS = "NILItugas";
//    public static final String KEY_NILAI_MID = "NILAImid";
//    public static final String KEY_NILAI_FINAL = "NILAIfinal";
    public static int RESULT_OK = 1;
    public static int RESULT_CANCEL = 0;

//    float akhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtStb = findViewById(R.id.tampil_stb);
        txtNama = findViewById(R.id.tampil_nama);
        txtNilaiTugas = findViewById(R.id.txt_tugas);
        txtNilaiMid = findViewById(R.id.txt_mid);
        txtNilaiFinal = findViewById(R.id.txt_final);


        Intent intent =  getIntent();
        String stb, nama, tugas, mid, nilaiFinal, akhir;

        stb = intent.getStringExtra(MainActivity.KEY_STB);
        nama = intent.getStringExtra(MainActivity.KEY_NAMA);
        tugas = intent.getStringExtra(MainActivity.KEY_TUGAS);
        mid = intent.getStringExtra(MainActivity.KEY_MID);
        nilaiFinal = intent.getStringExtra(MainActivity.KEY_FINAL);

        //akhir = intent.getStringExtra(MainActivity.KEY_AHKIR);
        //String txtAkhir = null;



        txtStb.setText(stb);
        txtNama.setText(nama);
        txtNilaiTugas.setText(tugas);
        txtNilaiMid.setText(mid);
        txtNilaiFinal.setText(nilaiFinal);

    }
    public void inputSelesai(View view){
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_TUGAS, txtNilaiTugas.getText().toString());
        intent.putExtra(MainActivity.KEY_MID, txtNilaiMid.getText().toString());
        intent.putExtra(MainActivity.KEY_FINAL, txtNilaiFinal.getText().toString());



        // akhir = (  txtNilaiMid + txtNilaiFinal)/3;

        setResult(RESULT_OK, intent);
        finish();


    }
    public void inputBatal(View view){
        Intent intent = new Intent();

        setResult(RESULT_CANCEL, intent);
        finish();
    }
}