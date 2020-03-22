package com.zamzam.tugas01zamzamsaefulbahtiar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solve(View view){
        Intent intent = new Intent(this, SolveActivity.class);
        startActivity(intent);
    }
    public void read(View view){
        Uri ebook = Uri.parse("https://drive.google.com/drive/folders/1lmHYVfT9V1Y6R8_jYrOIDZZCO_BovotG?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW, ebook);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else{
            Toast.makeText(
                    getBaseContext(),
                    "Sorry, we are can't open book now :(",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
