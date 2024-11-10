package com.example.seminar_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity
{
    private static final int REQUEST_CODE_THIRD_ACTIVITY = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            Button btnDeschideActivitate3 = findViewById(R.id.button);
            btnDeschideActivitate3.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent it = new Intent(MainActivity2.this, MainActivity3.class);
                    it.putExtra("mesaj", "Au fost transmise doua numere: ");
                    it.putExtra("nr_1", 10);
                    it.putExtra("nr_2", 5);
                    startActivityForResult(it, REQUEST_CODE_THIRD_ACTIVITY);
                }
            });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_THIRD_ACTIVITY && resultCode == RESULT_OK && data != null)
        {
            String mesajReturnat = data.getStringExtra("mesaj2");
            int sumaReturnata = data.getIntExtra("suma", 0);

            Toast.makeText(this, mesajReturnat + sumaReturnata, Toast.LENGTH_LONG).show();
        }
            else
            {
                Toast.makeText(this, "Nu s-a primit un rezultat!", Toast.LENGTH_SHORT).show();
            }
    }
}
