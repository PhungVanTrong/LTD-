package com.example.bt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText inputTK, inputEm;
    TextView tvDisplay,btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btnLogin);
        inputTK = findViewById(R.id.inputTK);
        inputEm = findViewById(R.id.inputEm);
        tvDisplay= findViewById(R.id.tvDisplay);
        btn= findViewById(R.id.textViewsignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TK = inputTK.getText().toString();
                String Em = inputEm.getText().toString();
                tvDisplay.setText("Tên: " + TK + "\nMSV: " + Em);
            }
        });

    }
}