package com.ptc.plms.gol.oops;
/**
 *
 * Amol S
 *
 *
 */

import org.junit.Test;
import com.ptc.plms.gol.oops.rules.RuleImpl;
import static org.junit.Assert.assertEquals;

public class RuleTest

{

  @Test
  public void deadStateTest()
  {
    int[] lessThanTwo = {0, 1};
    for (int liveNeighbours : lessThanTwo)
    {
      State state = new RuleImpl().nextState(State.LIVE, liveNeighbours);
      assertEquals(State.DEAD.name(), state.name());
    }
  }

  @Test
  public void liveStateTest()
  {
    int[] twoOrThree = {2, 3};
    for (int liveNeighbours : twoOrThree)
    {
      State state = new RuleImpl().nextState(State.LIVE, liveNeighbours);
      assertEquals(State.LIVE.name(), state.name());
    }
  }
}
