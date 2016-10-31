package org.cse390.playground;

import android.os.Build;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Robolectric.setupActivity;

/**
 * Created by sudars on 10/31/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class DependencyInjectableActivityTest {
  @After
  public void teardown() {
    DependencyInjectableActivityStub.resetState();
  }

  @Test
  public void activitySetsUpCorrectlyWithEmptyList() {
    List<FooObject> mockDataset = new ArrayList<>();
    FooRecyclerViewAdapter adapter =
        new FooRecyclerViewAdapter(mockDataset);

    DependencyInjectableActivityStub.DATASET = mockDataset;
    DependencyInjectableActivity testActivity =
        Robolectric.setupActivity(
            DependencyInjectableActivityStub.class);
    // Now we have an Activity with injected depedencies.
    // Perform some assertions below.

    assertThat(true).isTrue();
  }
}
