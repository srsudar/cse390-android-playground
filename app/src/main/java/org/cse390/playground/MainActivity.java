package org.cse390.playground;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Runnable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements
    LoaderManager.LoaderCallbacks<List<FooObject>> {


  private static final String TAG = MainActivity.class.getSimpleName();
  private TextView message;
  private Button networkMainThread;
  private Button launchTime;
  private Button networkOkHttp;
  private Button launchTopLevelTask;
  protected ContentLoadingProgressBar loading;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate");

    this.message = (TextView) findViewById(
        R.id.message);
    this.networkMainThread = (Button) findViewById(
        R.id.do_network_main_thread);
    this.launchTime = (Button) findViewById(R.id.launch_time_activity);
    this.networkOkHttp = (Button) findViewById(R.id.do_network_http);
    this.launchTopLevelTask = (Button) findViewById(
        R.id.launch_standalone_asynctask);
    this.loading = (ContentLoadingProgressBar) findViewById(R.id.loading);

    initListeners();
  }

  protected void initListeners() {
    networkMainThread.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        try {
          // On the main thread, this will fail!
          URL url = new URL("https://api.github.com/users/srsudar");
          HttpsURLConnection urlConnection = (HttpsURLConnection) url
              .openConnection();
          InputStream in = new BufferedInputStream(urlConnection
              .getInputStream());
          in.read();
        } catch (MalformedURLException e) {
          Log.e(TAG, "malformed url", e);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    launchTime.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, TimeActivity.class);
        startActivity(intent);
      }
    });

    networkOkHttp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loading.setVisibility(View.VISIBLE);
        OkHttpFetcher fetcher = new OkHttpFetcher();
        fetcher.getStringFromUrl("https://api.github.com/users/srduar")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<String>() {
              @Override
              public void onCompleted() {
                loading.setVisibility(View.INVISIBLE);
              }

              @Override
              public void onError(Throwable e) {
                loading.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Something went wrong", Toast
                    .LENGTH_SHORT).show();              }

              @Override
              public void onNext(String s) {
                Toast.makeText(MainActivity.this, "Got string: " + s, Toast
                    .LENGTH_SHORT).show();
              }
            });
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

  @Override
  public Loader<List<FooObject>> onCreateLoader(int i, Bundle bundle) {
    return null;
  }

  @Override
  public void onLoadFinished(Loader<List<FooObject>> loader, List<FooObject> fooObjects) {

  }

  @Override
  public void onLoaderReset(Loader<List<FooObject>> loader) {

  }
}
