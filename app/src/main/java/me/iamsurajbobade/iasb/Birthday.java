package me.iamsurajbobade.iasb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Birthday extends AppCompatActivity {

    TextView days;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        days = (TextView) findViewById(R.id.birthday_days_id);

        preferences = PreferenceManager.getDefaultSharedPreferences(Birthday.this);
        String str_dob = preferences.getString("dob","");

        if(str_dob.isEmpty()){

        }
        // set dates

        String dob = "28/05/1995";
        days.setText(Integer.toString(getDaysDiff(dob)));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public int getDaysDiff(String yourDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int date = 0;
        Calendar c = Calendar.getInstance();
        try {
            Long fromDate = simpleDateFormat.parse(""+yourDate).getTime();
            Long toDate = simpleDateFormat.parse(simpleDateFormat.format(c.getTime())).getTime();
            date = (int) TimeUnit.DAYS.convert(toDate-fromDate, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            // log exception
        }
        return date;
    }

}
