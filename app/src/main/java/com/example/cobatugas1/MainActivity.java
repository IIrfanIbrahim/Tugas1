package com.example.cobatugas1;


        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNama, txtStb;
    TextView txtAkhir, txtIndex;
    //Button btnPindah;
    public static final String KEY_STB = "STB";
    public static final String KEY_NAMA = "NAMA";
    public static final String KEY_TUGAS = "TUGAS";
    public static final String KEY_MID = "MID";
    public static final String KEY_FINAL = "FINAL";
    public static final String KEY_AHKIR = "AKHIR";
    private final int REQ_CODE_ACTIVITY2 = 0;

    int a, b, c, akhir;
    double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNama = findViewById(R.id.txt_nama);
        txtStb = findViewById(R.id.txt_stb);
        txtAkhir = findViewById(R.id.txt_nilai_akhir);
        txtIndex = findViewById(R.id.txt_indeks);
        //btnPindah = findViewById(R.id.btn_pindah);
    }
    public void bukaActity2(View view){
        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra(KEY_STB, txtStb.getText().toString());
        intent.putExtra(KEY_NAMA, txtNama.getText().toString());

        startActivityForResult(intent, REQ_CODE_ACTIVITY2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQ_CODE_ACTIVITY2){
            if (resultCode == MainActivity2.RESULT_OK){
                txtAkhir.setText(data.getStringExtra(KEY_FINAL));

                a = Integer.parseInt(data.getStringExtra(KEY_TUGAS));
                b = Integer.parseInt(data.getStringExtra(KEY_MID));
                c = Integer.parseInt(data.getStringExtra(KEY_FINAL));
                hasil = ((a+b+c)/3);
                txtAkhir.setText(String.valueOf(hasil));
                String status_index = "";
                if(hasil >= 90){
                    status_index = "A";
                }else if(hasil >= 80 && hasil < 90){
                    status_index = "B";
                }else if(hasil >= 70 && hasil < 80){
                    status_index = "C";
                }else if(hasil >= 45 && hasil < 70){
                    status_index = "D";
                }else if(hasil < 45){
                    status_index = "E";
                }

                txtIndex.setText(status_index);
//                akhir = (a+b+c)/3;
//                txtAkhir.setText(akhir);
//
            }
            else if ( resultCode == MainActivity2.RESULT_CANCEL){
                Toast.makeText(this, "Input Nilai Dibatalkan..", Toast.LENGTH_SHORT).show();

            }
        }
    }
}