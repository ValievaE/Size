package com.example.size;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinnerLanguage;
    private Spinner spinnerMargin;
    private String margin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Util.onActivityCreateTheme(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (margin) {
                    case "Мелкие":
                        Util.changeToTheme(MainActivity.this, R.style.Margin1);
                        break;
                    case "Средние":
                        Util.changeToTheme(MainActivity.this, R.style.Margin3);
                        break;
                    case "Большие":
                        Util.changeToTheme(MainActivity.this, R.style.Margin10);
                        break;
                }
            }
        });
    }

    private void initViews() {
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        spinnerMargin = findViewById(R.id.spinnerMargin);
        button = findViewById(R.id.button);
        initSpinnerMargins();
        initSpinnerLanguages();
    }

    private void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapterLanguages);
    }

    private void initSpinnerMargins() {
        ArrayAdapter<CharSequence> adapterMargins = ArrayAdapter.createFromResource(this, R.array.margins, android.R.layout.simple_spinner_item);
        adapterMargins.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMargin.setAdapter(adapterMargins);
        spinnerMargin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                margin = spinnerMargin.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}