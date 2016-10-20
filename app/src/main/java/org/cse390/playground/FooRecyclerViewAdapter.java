package org.cse390.playground;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sudars on 10/20/16.
 */

public class FooRecyclerViewAdapter extends RecyclerView
    .Adapter<FooRecyclerViewAdapter.FooViewHolder> {
  private List<FooObject> dataset;
  private View.OnClickListener deleteListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      FooViewHolder holder = (FooViewHolder) view.getTag();
      int itemPosition = holder.getAdapterPosition();
      dataset.remove(itemPosition);
      notifyItemRemoved(itemPosition);
    }
  };

  public static class FooViewHolder extends RecyclerView.ViewHolder {
    public TextView nameView;
    public TextView staleView;
    public ImageView delete;

    public FooViewHolder(View view) {
      super(view);
      this.nameView = (TextView) view.findViewById(R.id.foo_name);
      this.staleView = (TextView) view.findViewById(R.id.stale);
      this.delete = (ImageView) view.findViewById(R.id.delete_foo);
    }
  }

  public List<FooObject> getDataset() {
    return dataset;
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
  public void onBindViewHolder(FooViewHolder holder, final int position) {
    FooObject fooObject = dataset.get(position);
    holder.nameView.setText(fooObject.name);
    holder.delete.setTag(holder);

    holder.delete.setOnClickListener(deleteListener);
  }

  @Override
  public int getItemCount() {
    return dataset.size();
  }
}
