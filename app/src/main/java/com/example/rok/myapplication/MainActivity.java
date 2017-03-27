package com.example.rok.myapplication;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    ImageView i1;
    TextView t1;
    RelativeLayout r1;
    MenuItem mi2,mi3;
    int count=1;
    int value =0;
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
        switch (item.getItemId()){
            case R.id.next1:
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
                break;
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
                count++;
                rotate(count);
                break;
            case R.id.title1:
                title1(item,value);
                break;
            case R.id.twice:
                twice2(item);
                break;
            case R.id.chicken:
                i1.setImageResource(R.drawable.chicken);
                t1.setText("CHICKEN");
                value =1;
                count =0;
                rotate(count);
                item.setChecked(true);
                break;
            case R.id.spa:
                i1.setImageResource(R.drawable.spa);
                t1.setText("SPAGETTI");
                value =2;
                count =0;
                rotate(count);
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    void init(){
        i1 = (ImageView)findViewById(R.id.image);
        t1 = (TextView)findViewById(R.id.text1);
        r1 = (RelativeLayout)findViewById(R.id.activity_main);
        mi2 =(MenuItem)findViewById(R.id.chicken);
        mi3 = (MenuItem)findViewById(R.id.spa);
    }
    void twice2(MenuItem item){
        if(item.isChecked()==false){
            i1.setScaleX((float)Math.sqrt(2));
            i1.setScaleY((float) Math.sqrt(2));
            item.setChecked(true);
        }
        else{
            i1.setScaleX(1);
            i1.setScaleY(1);
            item.setChecked(false);
        }
    }
    void rotate(int count){
        i1.setRotation(30*count);

    }
    void title1(MenuItem item,int value){
         if(item.isChecked() == false){
            if(value==1) {
                t1.setText("겁나맛있는 치킨");

            }
            else if(value==2){
                t1.setText("새콤한 스파케티");
        }
             item.setChecked(true);
        }
        else{
            if(value==1) {
               t1.setText("CHICKEN");

              }
            else if(value==2){
                t1.setText("SPAGETTI");

              }
             item.setChecked(false);
          }
      }
    }