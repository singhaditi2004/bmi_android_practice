package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText heigh_inch,height_feet,weight;

AppCompatButton result_button;
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        heigh_inch = findViewById(R.id.heightin);
        height_feet = findViewById(R.id.heightft);
        weight = findViewById(R.id.weight);
        result_button = findViewById(R.id.result);
        result = findViewById(R.id.result_text);

        result_button = findViewById(R.id.result);

        result_button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                // Check if any of the input fields are empty
                if (heigh_inch.getText().toString().isEmpty() ||
                        height_feet.getText().toString().isEmpty() ||
                        weight.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                int height_in=Integer.parseInt(heigh_inch.getText().toString());
                int height_ft=Integer.parseInt(height_feet.getText().toString());
                int weight_in=Integer.parseInt(weight.getText().toString());


                    int tot_in=(height_ft*12)+height_in;
                    double tot_cm=tot_in*2.53;
                    double cm=tot_cm/100;
                    int bmi=(int)(weight_in/(cm*cm));
                    if(bmi<18.5){
                        result.setText("Underweight");
                        result.setVisibility(View.VISIBLE);
                    }
                    else if(bmi > 18.5 && bmi < 24.9){
                        result.setText("Normal");
                        result.setVisibility(View.VISIBLE);
                    }
                    else{
                        result.setText("Overweight");
                        result.setVisibility(View.VISIBLE);
                    }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}