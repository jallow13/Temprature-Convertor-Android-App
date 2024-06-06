package com.example.trial;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button convertButton, clearButton;
    TextView resultTextView;
    EditText inputEditText;
    RadioGroup unitRadioGroup;
    RadioButton celsiusRadioButton, fahrenheitRadioButton, kelvinRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = findViewById(R.id.convertButton);
        clearButton = findViewById(R.id.clearButton);
        resultTextView = findViewById(R.id.resultTextView);
        inputEditText = findViewById(R.id.inputEditText);
        unitRadioGroup = findViewById(R.id.unitRadioGroup);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        kelvinRadioButton = findViewById(R.id.kelvinRadioButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputEditText.getText().toString();
                if (TextUtils.isEmpty(input)) {
                    Toast.makeText(MainActivity.this, "Input can't be empty", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        double temp = Double.parseDouble(input);
                        DecimalFormat df = new DecimalFormat("#.00");
                        if (celsiusRadioButton.isChecked()) {
                            double ans = ((temp - 32) / 1.8);
                            resultTextView.setText(df.format(ans) + " °C");
                        } else if (fahrenheitRadioButton.isChecked()) {
                            double ans = ((temp * 1.8) + 32);
                            resultTextView.setText(df.format(ans) + " °F");
                        } else if (kelvinRadioButton.isChecked()) {
                            double ans = temp + 273.15;
                            resultTextView.setText(df.format(ans) + " K");
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEditText.setText("");
                resultTextView.setText("Result");
            }
        });
    }
}
