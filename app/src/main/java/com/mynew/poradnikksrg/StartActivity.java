package com.mynew.poradnikksrg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start);

        FrameLayout frameLayoutVideo = findViewById(R.id.frameVideo);
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.koperek);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        findViewById(R.id.bInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        findViewById(R.id.buttonONZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showONZ();
            }
        });

        findViewById(R.id.buttonKPP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showKPP();
            }
        });

        findViewById(R.id.secretButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(frameLayoutVideo.getVisibility() == View.VISIBLE){
                    frameLayoutVideo.setVisibility(View.INVISIBLE);
                }else {
                    frameLayoutVideo.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(StartActivity.this).inflate(
                R.layout.dialog_layout, (ConstraintLayout) findViewById(R.id.dialog_container));

        TextView tLinkRatMed = view.findViewById(R.id.linkRatMed);
        TextView tLinkRatChem = view.findViewById(R.id.linkRatChem);
        TextView tLinkAnkieta = view.findViewById(R.id.linkAnkieta);

        builder.setView(view);
        AlertDialog alertDialog = builder.create();



        view.findViewById(R.id.bInfoClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });



        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

        tLinkRatMed.setMovementMethod(LinkMovementMethod.getInstance());
        tLinkRatChem.setMovementMethod(LinkMovementMethod.getInstance());
        tLinkAnkieta.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void showONZ() {
        String position = "0";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("POSITION", position);
        startActivity(intent);
    }

    private void showKPP() {
        String position = "1";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("POSITION", position);
        startActivity(intent);
    }
}