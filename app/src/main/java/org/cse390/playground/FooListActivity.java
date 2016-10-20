package org.cse390.playground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;

public class FooListActivity extends AppCompatActivity {
  @BindView(R.id.foo_recycler_view) RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_foo_list);

    recyclerView = (RecyclerView) findViewById(R.id.foo_recycler_view);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    FooFactory fooFactory = new FooFactory();
    List<FooObject> dataset = fooFactory.getFoos(25);

    adapter = new FooRecyclerViewAdapter(dataset);
    recyclerView.setAdapter(adapter);
  }
}
