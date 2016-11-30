package org.cse390.playground;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by sudars on 11/29/16.
 */

public class LogicInterface {
  Context context;

  public LogicInterface(Context context) {
    this.context = context;
  }

  @JavascriptInterface
  public void toastToTheGroom() {
    Toast.makeText(context, "A toast to the groom!", Toast.LENGTH_SHORT)
        .show();
  }

  @JavascriptInterface
  public void toastToTheBride() {
    Toast.makeText(context, "To the bride!", Toast.LENGTH_SHORT).show();
  }

}
