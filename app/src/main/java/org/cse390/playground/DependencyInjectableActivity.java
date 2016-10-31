package org.cse390.playground;

import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DependencyInjectableActivity
    extends AppCompatActivity {
  private FooRecyclerViewAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dependency_injectable);

    this.adapter = createAdapter();
  }

  FooRecyclerViewAdapter createAdapter() {
    return new FooRecyclerViewAdapter(createDataset());
  }

  List<FooObject> createDataset() {
    return new ArrayList<>();
  }
}
