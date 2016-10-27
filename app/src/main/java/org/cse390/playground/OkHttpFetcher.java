package org.cse390.playground;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.Callable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

/**
 * Created by sudars on 10/27/16.
 */

public class OkHttpFetcher {
  private static final String TAG = OkHttpFetcher.class.getSimpleName();

  public Observable<String> getStringFromUrl(String url) {
    // Return this because it lets us treat this method as if it were
    // asynchronous.
    return Observable.fromCallable(new Callable<String>() {
      @Override
      public String call() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://api.github.com/users/srsudar")
            .build();
        try {
          Response response = client.newCall(request).execute();
          String result = response.body().string();
          return result;
        } catch (IOException e) {
          Log.e(TAG, "io exception", e);
        }
        return null;
      }
    });
  }
}
