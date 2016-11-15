package org.cse390.playground;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Runnable;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  private TextView message;
  private Button addToMessage;
  private Button launchTime;
  private Button launchInnerTask;
  private Button launchTopLevelTask;
  protected ContentLoadingProgressBar loading;
  private Button causeAnr;

  private class SleepTask extends AsyncTask<Integer, Long, String> {
    @Override
    protected void onPreExecute() {
      loading.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Integer... integers) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        return "Interrupted!";
      }
      return "slept";
    }

    @Override
    protected void onPostExecute(String s) {
      loading.setVisibility(View.INVISIBLE);
      launchInnerTask.setText("Do it again!");
      Toast.makeText(MainActivity.this, "Completed with string: " + s, Toast
          .LENGTH_SHORT).show();
    }
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "onCreate");

    this.message = (TextView) findViewById(
        R.id.message);
    this.addToMessage = (Button) findViewById(
        R.id.add_to_message);
    this.launchTime = (Button) findViewById(R.id.launch_time_activity);
    this.launchInnerTask = (Button) findViewById(R.id.launch_inner_asynctask);
    this.launchTopLevelTask = (Button) findViewById(
        R.id.launch_standalone_asynctask);
    this.loading = (ContentLoadingProgressBar) findViewById(R.id.loading);
    this.causeAnr = (Button) findViewById(R.id.cause_anr);

    initListeners();
  }

  protected void initListeners() {
    addToMessage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            message.append("\n new message \n");
          }
        }).start();
      }
    });

    launchInnerTask.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SleepTask sleepTask = new SleepTask();
        sleepTask.execute(0, 1);
      }
    });

    launchTime.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, TimeActivity.class);
        startActivity(intent);
      }
    });

    launchTopLevelTask.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        TopLevelAsyncTask topTask = new TopLevelAsyncTask(MainActivity.this);
        topTask.execute(0, 1);
      }
    });

    causeAnr.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        try {
          Thread.sleep(15000);
        } catch (InterruptedException e) {
          Log.e(TAG, "interrupted");
        }
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy");
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Log.e(TAG, "onRestoreInstanceState");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.e(TAG, "onSaveInstanceState");
  }

}
