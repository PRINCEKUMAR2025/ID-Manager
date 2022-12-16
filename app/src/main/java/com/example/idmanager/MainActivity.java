package com.example.idmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID=findViewById(R.id.etID);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResults=findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idnumber=etID.getText().toString().trim();

                String dob=idnumber.substring(0,6);
                int gender=Integer.parseInt(Character.toString(idnumber.charAt(6)));

                String sgender;

                if (gender<5){
                    sgender="Female";
                }
                else{
                    sgender="Male";
                }

                int nationality=Integer.parseInt(Character.toString(idnumber.charAt(10)));

                String sNationality;

                if (nationality==0){
                    sNationality=" SA Citizen";
                }
                else{
                    sNationality="Permanent Citizen";
                }

                String text= getString(R.string.dob)+ dob + "\n" +
                        getString(R.string.gend) + sgender + "\n" + getString(R.string.naton)+ sNationality;

                tvResults.setText(text);
            }
        });
    }
}