package com.example.seminar_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADAUGA_PROIECT = 1;
    private TextView tvInformatiiProiect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            tvInformatiiProiect=findViewById(R.id.tv_InformatiiProiect);
            Button btnAdaugaProiect = findViewById(R.id.btn_AdaugaProiect);
            btnAdaugaProiect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AdaugaProiectActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_ADAUGA_PROIECT);
                }
            });

            Intent intent=getIntent();
            Proiect proiect=intent.getParcelableExtra("proiect");
            if(proiect != null)
            {
                String informatiiProiect=proiect.toString();
                tvInformatiiProiect.setText(informatiiProiect);
            } else {
                tvInformatiiProiect.setText("Nu a fost adaugat niciun proiect!");
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADAUGA_PROIECT && resultCode == RESULT_OK && data!=null)
        {
            Proiect proiect=data.getParcelableExtra("proiect");
            if(proiect!=null)
            {
                String informatiiProiect=proiect.toString();
                tvInformatiiProiect.setText(informatiiProiect);//afisare
            } else{
                tvInformatiiProiect.setText("Nu a fost adaugat niciun proiect!");
            }
        }
    }

}