package com.example.actividadlayoutgestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class RelativeLayout extends AppCompatActivity {

    private GestureDetector gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        gDetector = new GestureDetector(this, new RelativeLayout.EscuchaGestos());
        final Button buttonConstrainNext = findViewById(R.id.btn08);
        buttonConstrainNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityTable();
            }
        });
    }
    private void openActivityTable() {
        Intent intent = new Intent(this, TableLayout.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
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
                if(e2.getX() > e1.getX()){
                    openActivityTable();
                }
            }
            return false;
        }
    }
}