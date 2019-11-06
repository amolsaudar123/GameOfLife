package com.ptc.plms.gol.oops;
/**
 *
 * amol s
 *
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NeighboursTest
{
  private AbstractGameStratedgy gameStrategy =new AbstractGameStratedgy();
  private RuleRunner ruleRunnerObj = new RuleRunner();

  @Test
  public void givenCellAt00Loc4NeighboursReturned()
  {
    Set<Cell> neighbourCells = gameStrategy.findNeighbours(new Cell(0, 0), new HashSet<Cell>());
    assertEquals(4, neighbourCells.size());
  }

  @Test
  public void givenCellAt10Loc6NeighboursReturned()
  {
    Set<Cell> neighbourCells = gameStrategy.findNeighbours(new Cell(1, 0), new HashSet<Cell>());
    assertEquals(6, neighbourCells.size());
  }

  @Test
  public void givenCellAt20Loc6NeighboursReturned()
  {
    Set<Cell> neighbourCells = gameStrategy.findNeighbours(new Cell(2, 0), new HashSet<Cell>());
    assertEquals(6, neighbourCells.size());
  }

  @Test
  public void givenCellAt11Loc9NeighboursReturned()
  {
    Set<Cell> neighbourCells = gameStrategy.findNeighbours(new Cell(1, 1), new HashSet<Cell>());
    assertEquals(9, neighbourCells.size());
  }

  @Test
  public void givenCellAt22Loc9NeighboursReturned()
  {
    Set<Cell> neighbourCells = gameStrategy.findNeighbours(new Cell(2, 2), new HashSet<Cell>());
    assertEquals(9, neighbourCells.size());
  }

  @Test
  public void givenCellWithNoLiveCell0LiveNeighbourReturned()
  {
    int liveNeighbourCount = ruleRunnerObj.findLiveNeighbourCount(new Cell(0, 0), new HashSet<Cell>());
    assertEquals(0, liveNeighbourCount);
  }


  @Test
  public void givenCellWith7LiveCellSevenLiveNeighbourReturned()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(2, 1, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));
    int liveNeighbourCount = ruleRunnerObj.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(7, liveNeighbourCount);
  }

  @Test
  public void givenCellWith8LiveCellThenReturn8LiveNeighbour()
  {
    HashSet<Cell> liveCells = new HashSet<>();
    liveCells.add(new Cell(0, 0, State.LIVE));
    liveCells.add(new Cell(0, 1, State.LIVE));
    liveCells.add(new Cell(0, 2, State.LIVE));
    liveCells.add(new Cell(1, 0, State.LIVE));
    liveCells.add(new Cell(1, 2, State.LIVE));
    liveCells.add(new Cell(2, 0, State.LIVE));
    liveCells.add(new Cell(2, 1, State.LIVE));
    liveCells.add(new Cell(2, 2, State.LIVE));
    int liveNeighbourCount = ruleRunnerObj.findLiveNeighbourCount(new Cell(1, 1), liveCells);
    assertEquals(8, liveNeighbourCount);
  }
}
