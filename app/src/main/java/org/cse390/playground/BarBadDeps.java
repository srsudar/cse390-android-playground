package org.cse390.playground;

import java.util.Random;

/**
 * Created by sudars on 10/28/16.
 */

public class BarBadDeps {
  private FooObject foo;
  private Random random;
  private String fromCreator;

  public BarBadDeps(String fromCreator) {
    this.fromCreator = fromCreator;
    this.foo = new FooObject();
    this.random = new Random();
  }
}
