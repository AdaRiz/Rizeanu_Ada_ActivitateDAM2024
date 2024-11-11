package com.example.seminar_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaProiectActivity extends AppCompatActivity {

    private EditText etNumeProiect, etDurata, etEchipaProiect;
    private Spinner spTipProiect;
    private Switch swActiv;
    private RatingBar rbRating;
    private Button btnSalveazaProiect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_proiect);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumeProiect=findViewById(R.id.et_NumeProiect);
        etDurata=findViewById(R.id.et_Durata);
        spTipProiect=findViewById(R.id.sp_TipProiect);
        swActiv=findViewById(R.id.sw_Activ);
        rbRating=findViewById(R.id.rb_Rating);
        btnSalveazaProiect=findViewById(R.id.btn_SalveazaProiect);
        etEchipaProiect=findViewById(R.id.et_EchipaProiect);

        ArrayAdapter<TipProiect> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TipProiect.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipProiect.setAdapter(adapter);

        btnSalveazaProiect.setOnClickListener(v -> {
            String nume=etNumeProiect.getText().toString();
            int durata=Integer.parseInt(etDurata.getText().toString());
            TipProiect tip=(TipProiect) spTipProiect.getSelectedItem();
            float rating=rbRating.getRating();
            boolean esteActiv=swActiv.isChecked();
            String[] echipa= etEchipaProiect.getText().toString().split(",");

            Proiect proiect=new Proiect(nume, durata, tip, rating, esteActiv, echipa);
            Intent it=new Intent(AdaugaProiectActivity.this, MainActivity.class);
            it.putExtra("proiect", proiect);
            setResult(RESULT_OK, it);
            finish();
        });
    }
}