package org.cse390.playground;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by sudars on 10/19/16.
 */

public class FooAdapter extends BaseAdapter {
  private List<FooObject> items;

  public FooAdapter(List<FooObject> items) {
    this.items = items;
  }

  @Override
  public int getCount() {
    return items.size();
  }

  @Override
  public Object getItem(int i) {
    return items.get(i);
  }

  @Override
  public long getItemId(int i) {
    // This is an annoying method. "Get the row id associated with the
    // specified position in the list." To me, this is an annoying limitation
    // of how they seem to expect you to use the adapter. I'm sure it matters
    // for something, but I've never found that something. Returning 0.
    return 0;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    if (view == null) {
      // We aren't re-using a View. Instead we'll have to inflate a view for
      // ourselves.
      LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
      view = inflater.inflate(R.layout.foo_view, viewGroup, false);

      TextView staleView = (TextView) view.findViewById(R.id.stale);
      staleView.setText("I will be stale, first created for " + i);
    } else {
      // If view != null, then we are being given an existing view to recycle.
      // This means we might have to reset this view to a blank state, or we
      // could see state from the recycled view. Think about what will
      // happen to staleView if we are reusing a View.
    }

    // We have a View to work with. This View has our foo_view resource as
    // its view hierarchy. We update this to reflect the item at position i.

    FooObject fooObject = (FooObject) this.getItem(i);
    TextView nameView = (TextView) view.findViewById(R.id.foo_name);
    nameView.setText(fooObject.name);

    return view;
  }
}
