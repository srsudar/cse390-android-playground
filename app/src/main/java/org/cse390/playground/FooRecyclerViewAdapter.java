package org.cse390.playground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sudars on 10/20/16.
 */

public class FooRecyclerViewAdapter extends RecyclerView
    .Adapter<FooRecyclerViewAdapter.FooViewHolder> {
  private List<FooObject> dataset;

  public static class FooViewHolder extends RecyclerView.ViewHolder {
    public TextView nameView;
    public TextView staleView;

    public FooViewHolder(View view) {
      super(view);
      this.nameView = (TextView) view.findViewById(R.id.foo_name);
      this.staleView = (TextView) view.findViewById(R.id.stale);
    }
  }

  public FooRecyclerViewAdapter(List<FooObject> dataset) {
    this.dataset = dataset;
  }

  @Override
  public FooRecyclerViewAdapter.FooViewHolder onCreateViewHolder(
      ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.foo_view, parent, false);
    FooViewHolder result = new FooViewHolder(view);
    return result;
  }

  @Override
  public void onBindViewHolder(FooViewHolder holder, int position) {
    FooObject fooObject = dataset.get(position);
    holder.nameView.setText(fooObject.name);
  }

  @Override
  public int getItemCount() {
    return dataset.size();
  }
}
