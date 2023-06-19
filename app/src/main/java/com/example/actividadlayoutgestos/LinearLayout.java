package com.example.actividadlayoutgestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class LinearLayout extends AppCompatActivity {

    private GestureDetector gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        gDetector = new GestureDetector(this, new LinearLayout.EscuchaGestos());
        final Button buttonNext = findViewById(R.id.btn02);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityConstrain();
            }
        });
        final Button buttonPrev = findViewById(R.id.btn03);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityFrame();
            }
        });
    }
    private void openActivityConstrain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void openActivityFrame() {
        Intent intent = new Intent(this, FrameLAyout.class);
        startActivity(intent);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    private class EscuchaGestos extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            float ancho = Math.abs(e2.getX() - e1.getX());
            float alto = Math.abs(e2.getY() - e1.getY());
            if(ancho > alto){
                if(e2.getX() < e1.getX()){
                    openActivityFrame();
                }
                else{
                    openActivityConstrain();
                }
            }
            return false;
        }
    }
}