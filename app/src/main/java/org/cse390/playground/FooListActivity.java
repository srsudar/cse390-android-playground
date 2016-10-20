package org.cse390.playground;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FooListActivity extends AppCompatActivity {
  @BindView(R.id.foo_recycler_view) RecyclerView recyclerView;
  @BindView(R.id.add_foo) FloatingActionButton addFoo;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_foo_list);
    ButterKnife.bind(this);

    recyclerView = (RecyclerView) findViewById(R.id.foo_recycler_view);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    final FooFactory fooFactory = new FooFactory();
    final List<FooObject> dataset = fooFactory.getFoos(0);

    adapter = new FooRecyclerViewAdapter(dataset);
    recyclerView.setAdapter(adapter);

    addFoo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FooObject newFoo = fooFactory.createFoo();
        dataset.add(0, newFoo);
        adapter.notifyItemInserted(0);
      }
    });
  }
}
