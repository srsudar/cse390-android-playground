package org.cse390.playground;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

/**
 * Created by sudars on 10/26/16.
 */

public class TopLevelAsyncTask extends AsyncTask<Integer, Long, String> {
  MainActivity mainActivity;

  public TopLevelAsyncTask(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  @Override
  protected void onPreExecute() {
    mainActivity.loading.setVisibility(View.VISIBLE);
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
    mainActivity.loading.setVisibility(View.INVISIBLE);
    Toast.makeText(this.mainActivity, "Completed with string: " + s, Toast
        .LENGTH_SHORT).show();
  }
}
