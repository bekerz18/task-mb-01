package com.zamzam.tugas01zamzamsaefulbahtiar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class SolveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void btnSolve(View view){
        EditText dataInput = findViewById(R.id.textData);
        String data = dataInput.getText().toString();


        if(TextUtils.isEmpty(data)){
            dataInput.setError("Please input number");
        }else{
            try {
                String[] dataSplitted = data.split(",", 100);
                int n;
                n = dataSplitted.length;
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(dataSplitted[i]);
                }
                String[] result= new String[4];

                result[0] = "" + solveMedian(a, n);
                result[1] = "" + solveMean(a, n);
                result[2] = "" + solveModus(a, n);


                Intent intent = new Intent(this, resultActivity.class);
                intent.putExtra("datas",data);
                intent.putExtra("result",result);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(
                        getBaseContext(),
                        "Sorry, we are can't :(",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
    private double solveMedian(int a[], int n)
    {
        Arrays.sort(a);

        if (n % 2 != 0)
            return (double)a[n / 2];
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }
    private double solveMean(int a[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];

        return (double)sum/(double)n;
    }
    
    private double solveModus(int[] a, int n) {
    try{
        @RequiresApi(api = Build.VERSION_CODES.N)
            int max = Arrays.stream(a).max().getAsInt();

            int t = max + 1;
            int[] count = new int[t];
            for (int i = 0; i < t; i++) {
                count[i] = 0;
            }

            for (int i = 0; i < n; i++) {
                count[a[i]]++;
            }

            int mode = 0;
            int k = count[0];
            for (int i = 1; i < t; i++) {
                if (count[i] > k) {
                    k = count[i];
                    mode = i;
                }
            }
        return mode;
    }catch (Exception e) {
        mode = 0;
        return mode;    
    }
        
    }
        public void back(View view){
        this.finish();
    }
}
