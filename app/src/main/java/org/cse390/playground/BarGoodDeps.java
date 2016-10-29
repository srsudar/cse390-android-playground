package org.cse390.playground;

import java.util.Random;

/**
 * Created by sudars on 10/28/16.
 */

public class BarGoodDeps {
  private FooObject foo;
  private Random random;
  private String fromCreator;

  public BarGoodDeps(String fromCreator,
      FooObject foo, Random random) {
    this.fromCreator = fromCreator;
    this.foo = foo;
    this.random = random;
  }

  public int randPlus1() {
    return random.nextInt() + 1;
  }
}
