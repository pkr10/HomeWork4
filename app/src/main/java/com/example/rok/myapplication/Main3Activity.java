package com.example.rok.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TabHost tabHost;
    Button b1,b2,b3;
    EditText e1,e2,e3;
    TextView t1,t2;
    String area = e3.getText().toString();
    double m = Double.parseDouble(area);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("각종계산기");
        init();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = e1.getText().toString();
                String weight = e2.getText().toString();
                double cm = Double.parseDouble(height);
                double kg = Double.parseDouble(weight);
                double result = calculate(cm,kg);
                operate(result);
            }
        });
       b2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  double result2 = calculate2(m);
                  t2.setText(result2+"평");


              }
          });
          b3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  t2.setText(calculte3(m)+"m");

              }
          });
    }
    void init(){
        tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").
                setContent(R.id.tab1).setIndicator("BMI계산기"));
        tabHost.addTab(tabHost.newTabSpec("B").
                setContent(R.id.tab2).setIndicator("면적계산기"));
        b1 = (Button)findViewById(R.id.cb);
        e1 = (EditText)findViewById(R.id.ce1);
          e2 =(EditText)findViewById(R.id.ce2);
          t1 =(TextView)findViewById(R.id.ct1);
          e2 = (EditText)findViewById(R.id.ce3);
          b2 = (Button)findViewById(R.id.cb2);
          b3 = (Button)findViewById(R.id.cb3);
          t2 = (TextView)findViewById(R.id.ct2);
    }

    double calculate(double a, double b){
        double result =  b/(a*a);
       return result;
    }
    void operate(double a){
        if(a>18.5&&a<22.9){
            t1.setText("정상"+a);
        }
        else if(a>23.0&&a<24.9){
            t1.setText("과체중"+a);
        }
        else if(a>=25.0){
            t1.setText("비만"+a);
        }
        else{
            t1.setText("저체중"+a);
        }
    }
    double calculate2(double a){
        double result =  (a/3.3);
        return result;
    }
    double calculte3(double a){
        double result = a*3.3;
        return result;
    }





}
