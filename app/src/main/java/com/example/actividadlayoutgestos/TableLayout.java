package com.example.actividadlayoutgestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class TableLayout extends AppCompatActivity {

    private GestureDetector gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        gDetector = new GestureDetector(this, new TableLayout.EscuchaGestos());
        final Button buttonNext = findViewById(R.id.btn06);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityFrame();
            }
        });
        final Button buttonPrev = findViewById(R.id.btn07);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityRelative();
            }
        });
    }
    private void openActivityFrame() {
        Intent intent = new Intent(this, FrameLAyout.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    private void openActivityRelative() {
        Intent intent = new Intent(this, RelativeLayout.class);
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
                    openActivityRelative();
                }
                else{
                    openActivityFrame();
                }
            }
            return false;
        }
    }
}