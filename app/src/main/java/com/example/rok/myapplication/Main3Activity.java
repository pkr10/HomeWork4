package com.example.rok.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
public class Main3Activity extends AppCompatActivity {
    TabHost tabHost;
    Button b1, b2, b3, b4, b5, b6, b7;
    EditText e1, e2, e3, e4, e5;
    TextView t1, t2, t3, t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("각종계산기");
        init();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    void init() {
        tabHost = (TabHost) findViewById(R.id.tabhost1);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("A").setContent(R.id.tab1).setIndicator("BMI계산기"));
        tabHost.addTab(tabHost.newTabSpec("B").setContent(R.id.tab2).setIndicator("면적계산기"));
        tabHost.addTab(tabHost.newTabSpec("C").setContent(R.id.tab3).setIndicator("축의금 계산기"));
        b1 = (Button) findViewById(R.id.cb);
        e1 = (EditText) findViewById(R.id.ce1);
        e2 = (EditText) findViewById(R.id.ce2);
        t1 = (TextView) findViewById(R.id.ct1);
        b2 = (Button) findViewById(R.id.cb2);
        b3 = (Button) findViewById(R.id.cb3);
        e3 = (EditText) findViewById(R.id.ce3);
        t2 = (TextView) findViewById(R.id.ct2);
        b4 =(Button)findViewById(R.id.cb4);
        e4 = (EditText)findViewById(R.id.ce4);
        e5 = (EditText)findViewById(R.id.ce5);
        t3 = (TextView)findViewById(R.id.ct3);
        t5 = (TextView)findViewById(R.id.ct5);
        t4 = (TextView)findViewById(R.id.ct4);
        b5 = (Button)findViewById(R.id.cb5);
        b6 = (Button)findViewById(R.id.cb6);
        b7 =(Button)findViewById(R.id.cb7);
    }
    public void onmyclick(View view) {
        String height = e1.getText().toString();
        String weight = e2.getText().toString();
        switch(view.getId()) {
            case R.id.cb:
                if(height.matches("")||weight.matches("")){
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e1.requestFocus();
                }
                else if(height.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e1.requestFocus();
                }
                else if(weight.matches("")){
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e2.requestFocus();
                }
                else{
                    decide(calculte(Double.parseDouble(height), Double.parseDouble(weight)));
                }
                break;
            case R.id.cb5:
                first(e1,e2);
                t1.setText("상태 : ");
                t5.setText("BMI : ");
                break;
        }
    }
    public void onmyclick2(View view) {
        String area = e3.getText().toString();
        switch (view.getId()) {
            case R.id.cb2:
                if (area.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e3.requestFocus();
                }
                else {
                    t2.setText(calculate2(Double.parseDouble(area)) + "평");
                }
                break;
            case R.id.cb3:

                if (area.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e3.requestFocus();
                } else {
                    t2.setText(calculate3(Double.parseDouble(area)) + "m");
                }
                break;
            case R.id.cb6:
                e3.setText("");
                t2.setText("계산결과가 없습니다");
                break;
        }
    }
    public void onmyclick3(View view) {
        String a  = e5.getText().toString();
        String b = e4.getText().toString();
        switch(view.getId()) {
            case R.id.cb4:
                if (a.matches("") && b.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e5.requestFocus();
                } else if (b.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e4.requestFocus();
                } else if (a.matches("")) {
                    Toast.makeText(getApplicationContext(), "다입력해주세요", Toast.LENGTH_SHORT).show();
                    e5.requestFocus();
                } else {
                    t3.setText(calculate4(Integer.parseInt(a), Integer.parseInt(b)) + "원");
                    t4.setText("5만원권 : " + b + " 매" + "  만원권 : " + a + " 매");
                }
                break;
            case R.id.cb7:
                first(e4,e5);
                t3.setText("계산결과가없습니다");
                t4.setText("5만원권 : 0 매 만원권 : 0 매");
        }
    }
    public int calculate4(int a, int b){
        int result = a*10000+b*50000;
        return result;
    }
    public void first(EditText a, EditText b){
        a.setText("");
        b.setText("");
    }
    public double calculte(double cm, double kg) {
        double bmi = (kg / (cm * cm)) * 10000;
        return bmi;
    }
    public double calculate3(double m) {
        double result = m * 3.3;
        return result;
    }
    public double calculate2(double m) {
        double result = m / 3.3;
        return result;
    }
    public void decide(double bmi) {
        if (bmi < 18.5) {
            t1.setText("상태 : 체중부족 ");
            t5.setText("BMI : "+bmi);
        } else if (bmi > 18.5 && bmi < 22.9) {
            t1.setText("상태 : 정상 ");
            t5.setText("BMI : "+bmi);
        } else if (bmi > 23.0 && bmi < 24.9) {
            t1.setText("상태 : 과체중 ");
            t5.setText("BMI : "+bmi);
        } else {
            t1.setText("상태 : 비만 ");
            t5.setText("BMI : "+bmi);
        }
    }
}