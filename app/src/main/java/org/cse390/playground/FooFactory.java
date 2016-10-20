package org.cse390.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sudars on 10/19/16.
 */

public class FooFactory {
  private static final String BASE_NAME = "I am foo #";

  public List<FooObject> getFoos(int numFoos) {
    List<FooObject> result = new ArrayList<>();

    for (int i = 0; i < numFoos; i++) {
      FooObject next = new FooObject();
      next.name = BASE_NAME + i;
      result.add(next);
    }

    return result;
  }

  public FooObject createFoo() {
    Random random = new Random();
    int semiRandomInt = random.nextInt(500);

    FooObject result = new FooObject();
    result.name = "I am semi-random Foo #" +semiRandomInt;
    return result;
  }
}
