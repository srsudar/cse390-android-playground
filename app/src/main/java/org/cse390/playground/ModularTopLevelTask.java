package org.cse390.playground;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

/**
 * This is incomplete and is just kept around for taking screenshots to show
 * the general idea of what you have to do to generalize well.
 */
public class ModularTopLevelTask extends AsyncTask<Integer, Long,
    ModularTopLevelTask.ModularTaskResults> {

  public interface ModularTaskCallbacks {
    View getLoadingView();
    Context getContext();
    void onResult(String s);
    void onError(Throwable e);
  }
  public class ModularTaskResults {
    String result;
    Object metadata;
  }

  ModularTaskCallbacks callback;
  boolean isComplete;
  boolean isRunning;

  public ModularTopLevelTask(ModularTaskCallbacks callbacks) {
    this.callback = callbacks;
  }
  public void setCallback(ModularTaskCallbacks callback) {
    this.callback = callback;
  }

  @Override
  protected void onPreExecute() {
    if (callback != null && callback.getLoadingView() != null) {
      callback.getLoadingView().setVisibility(View.VISIBLE);
    }
  }

  @Override
  protected ModularTaskResults doInBackground(Integer... integers) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      return null;
    }
    return null;
  }

  @Override
  protected void onPostExecute(ModularTaskResults result) {
    if (callback != null && callback.getLoadingView() != null) {
      callback.getLoadingView().setVisibility(View.INVISIBLE);
      Toast.makeText(callback.getContext(), "Completed!",
          Toast.LENGTH_SHORT).show();
    }
  }
}
