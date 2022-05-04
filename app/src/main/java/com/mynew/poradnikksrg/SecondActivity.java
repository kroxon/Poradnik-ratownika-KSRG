package com.mynew.poradnikksrg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mynew.poradnikksrg.R;
import com.ortiz.touchview.TouchImageView;

public class SecondActivity extends AppCompatActivity {

    TouchImageView mainImageView;
    TextView mainName, mainNumber;

    String name, number;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.imageViewProc);
        mainName = findViewById(R.id.textViewProTitle);
        mainNumber = findViewById(R.id.textViewProNumber);



        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("name")&&getIntent().hasExtra("number")&&
        getIntent().hasExtra("image")){

            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");
            image = getIntent().getIntExtra("image", 1);

        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        mainName.setText(name);
        mainNumber.setText(number);
        mainImageView.setImageResource(image);
    }
}