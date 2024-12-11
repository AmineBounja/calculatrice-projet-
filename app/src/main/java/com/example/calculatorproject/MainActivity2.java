package com.example.calculatorproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button buttonCall = findViewById(R.id.buttonCall);
        Button nextPageButton = findViewById(R.id.nextPageButton);
        Button goToEnsaSite = findViewById(R.id.goToEnsaSite);



        buttonCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0607811275"));
            startActivity(intent);
        });


        nextPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });


        goToEnsaSite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://ensaf.ac.ma/"));
            startActivity(intent);
        });


    }
}
