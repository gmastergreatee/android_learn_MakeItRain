package com.example.makeitrain;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView txtMoney;
    private int moneyCounter = 0;
    private final NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMoney = findViewById(R.id.txtMoney);
        txtMoney.setText(numberFormatter.format(0));
    }

    public void addMoney(View view) {
        moneyCounter += 1000;

        switch (moneyCounter) {
            case 10000:
                txtMoney.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                Toast.makeText(MainActivity.this, "Ooo! You getting richer!", Toast.LENGTH_SHORT).show();
                break;
            case 15000:
                txtMoney.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                Toast.makeText(MainActivity.this, "AAAA! You SO RICH!!!", Toast.LENGTH_SHORT).show();
                break;
            case 20000:
                txtMoney.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.green));
                Toast.makeText(MainActivity.this, "OMG! THAT'S CRAZY!!!", Toast.LENGTH_SHORT).show();
                break;
            case 25000:
                txtMoney.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.red));
                Toast.makeText(MainActivity.this, "EEE! Cant take this N-E-MORE\n~~You reached the limit~~ :(", Toast.LENGTH_LONG).show();
                findViewById(R.id.btnMakeItRain).setEnabled(false);
        }

        txtMoney.setText(numberFormatter.format(moneyCounter));
    }

    public void showInfo(View view) {
        Snackbar.make(view, "Current balance : " + numberFormatter.format(moneyCounter), Snackbar.LENGTH_LONG)
                .setAction("More", v -> {
                    Toast.makeText(MainActivity.this, "Toast -> Current balance : " + numberFormatter.format(moneyCounter), Toast.LENGTH_SHORT).show();
                })
                .show();
    }
}