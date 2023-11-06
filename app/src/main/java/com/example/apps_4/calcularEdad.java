package com.example.apps_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

public class calcularEdad extends AppCompatActivity {
    private EditText etDia;
    private EditText etMes;
    private  EditText etAno;
    private TextView tvEdadActual;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_edad);
        this.etDia = findViewById(R.id.etDia);
        this.etMes = findViewById(R.id.etMes);
        this.etAno = findViewById(R.id.etAno);
        this.tvEdadActual = findViewById(R.id.tvEdadActual);

        Button calcularButton = findViewById(R.id.btnCalcular);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularEdad();
            }
        });
      }
    private void calcularEdad() {
        int dia = Integer.parseInt(etDia.getText().toString());
        int mes = Integer.parseInt(etMes.getText().toString());
        int ano = Integer.parseInt(etAno.getText().toString());

        Calendar calendar = Calendar.getInstance();
        int anoActual = calendar.get(Calendar.YEAR);
        int mesActual = calendar.get(Calendar.MONTH) + 1;
        int diaActual = calendar.get(Calendar.DAY_OF_MONTH);

        int edad = anoActual - ano;
        if (mesActual < mes || (mesActual == mes && diaActual < dia)) {
            edad--;
        }
        tvEdadActual.setText(edad + " Años");
    }
}