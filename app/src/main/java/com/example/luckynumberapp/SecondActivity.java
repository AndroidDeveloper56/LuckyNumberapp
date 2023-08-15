package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView result;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        result=findViewById(R.id.result);
        share=findViewById(R.id.share);
        Intent i=getIntent();
        String username=i.getStringExtra("name");
        int random_num=lucky_number();


        result.setText(""+random_num);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(username,random_num);
            }
        });

    }
    public int lucky_number(){
        Random random=new Random();
        int upperrandom=100;
        int random_number_genegator=random.nextInt(upperrandom);
        return random_number_genegator;
    }

    public void sharedata(String user,int randomnum){
        Intent i=new Intent(Intent.ACTION_SENDTO);
        i.setType("text/plain");

        //additional information
        i.putExtra(Intent.EXTRA_SUBJECT,user+"got lucky number");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is:"+randomnum);
        startActivity(Intent.createChooser(i,"Chose platform"));
    }


}