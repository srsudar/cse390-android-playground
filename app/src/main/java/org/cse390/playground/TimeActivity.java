package org.cse390.playground;

import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeActivity extends AppCompatActivity {
  private TextView time;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_time);

    this.time = (TextView) findViewById(R.id.a_time_time);

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    String formattedDate = format.format(calendar.getTime());
    String labelPrefix = getString(R.string.moment_on_create_called);
    time.setText(labelPrefix + formattedDate);
  }
}
