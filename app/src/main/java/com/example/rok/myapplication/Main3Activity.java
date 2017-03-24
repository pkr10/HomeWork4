package com.example.rok.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main3Activity extends AppCompatActivity {
    TabHost tabHost;
    Button b1, b2, b3;
    EditText e1, e2, e3;
    TextView t1, t2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("각종계산기");
        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        b1 = (Button) findViewById(R.id.cb);
        e1 = (EditText) findViewById(R.id.ce1);
        e2 = (EditText) findViewById(R.id.ce2);
        t1 = (TextView) findViewById(R.id.ct1);
        b2 = (Button) findViewById(R.id.cb2);
        b3 = (Button) findViewById(R.id.cb3);
        e3 = (EditText) findViewById(R.id.ce3);
        t2 = (TextView) findViewById(R.id.ct2);
    }

    public void onmyclick(View view) {
        String height = e1.getText().toString();
        String weight = e2.getText().toString();
        nothing(height, weight);
        double cm = Double.parseDouble(height);
        double kg = Double.parseDouble(weight);
        decide(calculte(cm, kg));
    }

    public double calculte(double cm, double kg) {
        double bmi = (kg / (cm * cm)) * 10000;
        return bmi;
    }

    public void nothing(String a, String b) {
        if (a.matches("") || b.matches("")) {
            t1.setText("숫자를 입력해주요");
        }


    }

    public void decide(double bmi) {
        if (bmi < 18.5) {
            t1.setText("체중부족 " + bmi);
        } else if (bmi > 18.5 && bmi < 22.9) {
            t1.setText("정상 " + bmi);
        } else if (bmi > 23.0 && bmi < 24.9) {
            t1.setText("과체중 " + bmi);
        } else {
            t1.setText("비만 " + bmi);
        }
    }

    public void onmyclick2(View view) {
        String area = e3.getText().toString();
        double m = Double.parseDouble(area);

        switch (view.getId()) {
            case R.id.cb2:
                t2.setText(calculate2(m) + "평");
                break;
            case R.id.cb3:
                t2.setText(calculate3(m) + "m");
                break;
        }
    }

    public double calculate2(double m) {
        double result = m / 3.3;
        return result;
    }

    public double calculate3(double m) {
        double result = m * 3.3;
        return result;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main3 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
