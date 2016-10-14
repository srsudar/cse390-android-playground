package org.cse390.playground;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.explicit_intent_description) TextView expIntentDesc;
  @BindView(R.id.implicit_intent_description) TextView impIntentDesc;
  @BindView(R.id.a_main_send_explicit_intent) Button sendExpIntent;
  @BindView(R.id.a_main_send_implicit_intent) Button sendImpIntent;

  private static final String TAG = MainActivity.class.getSimpleName();

  private String expIntentMsg = "An <b>explicit</b> Intent defines exactly" +
      "  what component should respond to our message. In this case," +
      " <p>ComponentName component = new ComponentName(" +
      "\"org.cse390.playground\", \"org.cse390.playground.TimeActivity\");" +
      "</p><p>Intent explicit = new Intent()</p>" +
      " <p>explicit.setComponent(component)<p>" +
      "Note that this refers precisely to our" +
      " activity.";

  private String impIntentMsg = "An <b>implicit</b> Intent tells Android" +
      " only about what it is we want, not how we want to do it. Android" +
      " then lets us choose what app will answer the call. For example:" +
      " <p>Intent implicit = new Intent(android.content.Intent.ACTION_SEND);" +
      "</p> <p>implicit.setType(\"text/plain\");</p>" +
      "<p>implicit.putExtra(android.content.Intent.EXTRA_TEXT," +
      " \"This was shared via an implicit intent\");</p>";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "onCreate");
    ButterKnife.bind(this);

    Spanned styledExp = Html.fromHtml(expIntentMsg);
    Spanned styledImp = Html.fromHtml(impIntentMsg);

    expIntentDesc.setText(styledExp);
    impIntentDesc.setText(styledImp);

    initListeners();
  }

  protected void initListeners() {
    sendExpIntent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ComponentName component = new ComponentName("org.cse390.playground",
            "org.cse390.playground.TimeActivity");
        Intent explicit = new Intent();
        explicit.setComponent(component);
        startActivity(explicit);
      }
    });

//    sendImpIntent.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        launchShareIntent();
//      }
//    });
  }

  @SuppressWarnings("unused")
  @OnClick(R.id.a_main_send_implicit_intent)
  public void clickSendImplicit(View view) {
    launchShareIntent();
  }

  protected void launchShareIntent() {
    Intent implicit = new Intent(Intent.ACTION_SEND);
    implicit.setType("text/plain");
    implicit.putExtra(Intent.EXTRA_TEXT,
        "This was shared via an implicit Intent");
    startActivity(implicit);
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
