package org.cse390.playground;

import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.support.design.R.styleable.View;

/**
 * Created by sudars on 10/31/16.
 */

public class FooRecyclerViewAdapter extends RecyclerView
    .Adapter<FooRecyclerViewAdapter.ViewHolder> {
  private List<FooObject> dataset;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(android.view.View view) {
      super(view);
    }
  }

  public FooRecyclerViewAdapter(List<FooObject> dataset) {
    this.dataset = dataset;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

}
