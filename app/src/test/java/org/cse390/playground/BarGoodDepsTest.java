package org.cse390.playground;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sudars on 10/28/16.
 */

public class BarGoodDepsTest {
  @Test
  public void randPlusOneCorrect() {
    Random mockRandom = mock(Random.class);
    int nextInt = 55;
    int expected = nextInt + 1;
    when(mockRandom.nextInt()).thenReturn(nextInt);
    BarGoodDeps bar =
        new BarGoodDeps(null, null, mockRandom);
    int actual = bar.randPlus1();
    assertThat(actual).isEqualTo(expected);
  }
}
