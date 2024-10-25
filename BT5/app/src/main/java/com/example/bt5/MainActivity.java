package com.example.bt5;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoVaTen,edtMSV,edtLop,edtquequan;
    CheckBox checkTT;
    Button btnLuu;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        edtMSV=findViewById(R.id.edtMSV);
        edtHoVaTen= findViewById(R.id.edtHoVaTen);
        checkTT = findViewById(R.id.checkTT);
        btnLuu = findViewById(R.id.btnLuu);
        edtLop= findViewById(R.id.edtLop);
        edtquequan= findViewById(R.id.edtquequan);

        sharedPreferences = getSharedPreferences("LuuThongTin",MODE_PRIVATE);
        edtHoVaTen.setText(sharedPreferences.getString("hovaten",""));
        edtMSV.setText(sharedPreferences.getString("msv",""));
        checkTT.setChecked(sharedPreferences.getBoolean("checked", false));
        edtLop.setText(sharedPreferences.getString("lop",""));
        edtquequan.setText(sharedPreferences.getString("quequan",""));

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hovaten = edtHoVaTen.getText().toString().trim();
                String msv = edtMSV.getText().toString().trim();
                String lop= edtLop.getText().toString().trim();
                String quequan = edtquequan.getText().toString().trim();


                    Toast.makeText(MainActivity.this,"Lưu Thành Công", Toast.LENGTH_SHORT).show();
                    if (checkTT.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("hovaten",hovaten);
                        editor.putString("msv",msv);
                        editor.putBoolean("checked", true);
                        editor.putString("lop",lop);
                        editor.putString("quequan",quequan);
                        editor.commit();

                    }
                    else {
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.remove("hovaten");
                        editor.remove("msv");
                        editor.remove("checked");
                        editor.remove("lop");
                        editor.remove("quequan");
                        editor.commit();
                    }
                }

        });
    }


}