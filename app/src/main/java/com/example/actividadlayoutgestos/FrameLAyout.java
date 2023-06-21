    package com.example.actividadlayoutgestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

    public class FrameLAyout extends AppCompatActivity {
        private GestureDetector gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        gDetector = new GestureDetector(this, new FrameLAyout.EscuchaGestos());
        final Button buttonNext = findViewById(R.id.btn04);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityLinear();
            }
        });
        final Button buttonPrev = findViewById(R.id.btn05);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityTable();
            }
        });
    }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            this.gDetector.onTouchEvent(event);
            return super.onTouchEvent(event);
        }
        private void openActivityTable() {
            Intent intent = new Intent(this, TableLayout.class);
            startActivity(intent);
        }
        private void openActivityLinear() {
            Intent intent = new Intent(this, LinearLayout.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        private class EscuchaGestos extends GestureDetector.SimpleOnGestureListener {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                float ancho = Math.abs(e2.getX() - e1.getX());
                float alto = Math.abs(e2.getY() - e1.getY());
                if(ancho > alto){
                    if(e2.getX() < e1.getX()){
                        openActivityTable();
                    }
                    else{
                        openActivityLinear();
                    }
                }
                return false;
            }
        }
}