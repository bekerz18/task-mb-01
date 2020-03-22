package com.zamzam.tugas01zamzamsaefulbahtiar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    String[] result= new String[3];
    String datas;
    TextView median,mean,modus,tvdatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.result = getIntent().getStringArrayExtra("result");
        this.datas = getIntent().getStringExtra("datas");

        this.median = findViewById(R.id.result_median);
        this.mean = findViewById(R.id.result_mean);
        this.modus = findViewById(R.id.result_modus);
        this.tvdatas = findViewById(R.id.datas);

        this.tvdatas.setText(this.datas);
        this.median.setText(this.result[0]);
        this.mean.setText(this.result[1]);
        this.modus.setText(this.result[2]);
    }

    public void back(View view){
        this.finish();

    }
}
