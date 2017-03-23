package com.example.rok.myapplication;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.opengl.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView i1;
    TextView t1;
    RelativeLayout r1;
    ClipData.Item sub1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int count = 0;
        switch (item.getItemId()){
            case R.id.red:
                r1.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                r1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yello:
                r1.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.picture:

                i1.setRotation(30);
                break;
            case R.id.title1:
                Toast.makeText(getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();

                break;
            case R.id.twice:
                i1.setScaleX(2);
                i1.setScaleY(2);
                item.setChecked(true);


                break;
            case R.id.chicken:
                i1.setImageResource(R.drawable.chicken);
                t1.setText("CHICKEN");

                item.setChecked(true);
                break;
            case R.id.spa:
                i1.setImageResource(R.drawable.spa);
                t1.setText("SPAGETTI");
                item.setChecked(true);
                break;

        }





        return super.onOptionsItemSelected(item);
    }
    void init(){
        i1 = (ImageView)findViewById(R.id.image);
        t1 = (TextView)findViewById(R.id.text1);
        r1 = (RelativeLayout)findViewById(R.id.activity_main);
    }


}
