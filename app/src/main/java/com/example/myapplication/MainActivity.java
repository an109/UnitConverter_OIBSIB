package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner fromUnitSpinner, toUnitSpinner;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        fromUnitSpinner = findViewById(R.id.fromUnitSpinner);
        toUnitSpinner = findViewById(R.id.toUnitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String input = inputValue.getText().toString();
        if (input.isEmpty()) {
            resultTextView.setText("Please enter a value");
            return;
        }

        double value = Double.parseDouble(input);
        String fromUnit = fromUnitSpinner.getSelectedItem().toString();
        String toUnit = toUnitSpinner.getSelectedItem().toString();
        double result = 0;

        switch (fromUnit) {
            case "cm":
                if (toUnit.equals("m")) {
                    result = value / 100;
                } else if (toUnit.equals("cm")) {
                    result = value;
                }
                break;
            case "m":
                if (toUnit.equals("cm")) {
                    result = value * 100;
                } else if (toUnit.equals("m")) {
                    result = value;
                }
                break;
            case "g":
                if (toUnit.equals("kg")) {
                    result = value / 1000;
                } else if (toUnit.equals("g")) {
                    result = value;
                }
                break;
            case "kg":
                if (toUnit.equals("g")) {
                    result = value * 1000;
                } else if (toUnit.equals("kg")) {
                    result = value;
                }
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }
}
