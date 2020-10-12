package id.ac.itn.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Alas, Tinggi, Hasil;
    Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alas = findViewById(R.id.Alas);
        Tinggi = findViewById(R.id.Tinggi);
        Hasil = findViewById(R.id.Hasil);
        Button = findViewById(R.id.Button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ETalas = Alas.getText().toString().trim();
                String ETtinggi = Tinggi.getText().toString().trim();
                boolean isEmpty = false;
                boolean isInValid = false;
                if (TextUtils.isEmpty(ETalas)){
                    isEmpty = true;
                    Alas.setError("Kolom Alas harus diisi");
                }
                if (TextUtils.isEmpty(ETtinggi)){
                    isEmpty = true;
                    Tinggi.setError("Kolom Tinggi harus diisi");
                }
                Double a = toDouble(ETalas);
                Double t = toDouble(ETtinggi);
                if (a==null){
                    isInValid=true;
                    Alas.setError("Kolom Alas harus diisi dengan angka yang valid");
                }
                if (t==null){
                    isInValid=true;
                    Tinggi.setError("Kolom Tinggi harus diisi dengan angka yang valid");
                }
                if (!isEmpty && !isInValid){
                    double hasil = 0.5 * a * t;
                    Hasil.setText(String.valueOf(hasil));
                }
            }
        });
    }

    private Double toDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}