package org.cse390.playground;

import android.os.Bundle;

import java.util.List;

/**
 * Created by sudars on 10/31/16.
 */

public class DependencyInjectableActivityStub extends
    DependencyInjectableActivity {
  public static List<FooObject> DATASET = null;
  public static FooRecyclerViewAdapter ADAPTER = null;

  public static void resetState() {
    DATASET = null;
    ADAPTER = null;
  }

  @Override
  protected void onCreate(Bundle state) {
    super.onCreate(state);
  }

  @Override
  List<FooObject> createDataset() {
    if (DATASET == null) {
      return super.createDataset();
    } else {
      return DATASET;
    }
  }

  @Override
  FooRecyclerViewAdapter createAdapter() {
    if (ADAPTER == null) {
      return super.createAdapter();
    } else {
      return ADAPTER;
    }
  }
}
