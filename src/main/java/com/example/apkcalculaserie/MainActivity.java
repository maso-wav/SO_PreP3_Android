package com.example.apkcalculaserie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etAdicionaNumero;
    private Button btnCalcula;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etAdicionaNumero = findViewById(R.id.etAdicionaNumero);
        etAdicionaNumero.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalcula = findViewById(R.id.btnCalcula);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcula.setOnClickListener(op -> calc());
    }

    private void calc(){

        double numero = Double.parseDouble(etAdicionaNumero.getText().toString());

            if(numero < 0 || numero > 20) {

                String res = getString(R.string.aviso);
                tvResultado.setText(res);
                return;
            }
        double resultado = calculaSerie(numero);
        @SuppressLint("DefaultLocale") String res = getString(R.string.soma) + " " + String.format("%.2f", resultado) + ".";
        tvResultado.setText(res);
    }

    public static double calculaSerie(double numero) {

        int num = 1;
        double soma = 0;

        for(int i = 0; i < numero; i++) {

            soma = soma + (num/Math.pow(num, 2));
            num++;
        }
        return soma;
    }
}