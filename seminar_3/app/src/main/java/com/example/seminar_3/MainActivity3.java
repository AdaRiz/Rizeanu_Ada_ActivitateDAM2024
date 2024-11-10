package com.example.seminar_3;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent=getIntent();
        String mesajPrimit=intent.getStringExtra("mesaj");
        int numar1 = intent.getIntExtra("nr_1", 0);
        int numar2 = intent.getIntExtra("nr_2", 0);

        Toast.makeText(this, mesajPrimit + numar1 + " si " + numar2, Toast.LENGTH_SHORT).show();

        int suma = numar1 + numar2;

        Button btnDeschideActivitate2=findViewById(R.id.button2);
        btnDeschideActivitate2.setOnClickListener(v -> {

            Intent it2 = new Intent(MainActivity3.this, MainActivity2.class);
            it2.putExtra("mesaj2", "Suma numerelor transmise este: ");
            it2.putExtra("suma", suma);
            setResult(RESULT_OK, it2);
            finish();
        });
    }
}