package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ptc.plms.gol.oops.rules.RuleImpl;

public class RuleRunner {
	
	private GameStrategy gameStrategy;

	RuleRunner (){ }
	public RuleRunner(GameStrategy gameStrategy)
	{
		this.gameStrategy = gameStrategy;
	}


	public Set<Cell> applyRules(Set<Cell> liveCells) {
		HashSet<Cell> nextGeneration=new HashSet<Cell>();

		Set<Cell> neighbouringCells;
		for(Cell cellFromCurrentGeneration: liveCells)
		{
			if (!nextGeneration.contains(cellFromCurrentGeneration))
			{
				nextGeneration.add(processCell(cellFromCurrentGeneration, liveCells));
			}
			neighbouringCells = new AbstractGameStratedgy().findNeighbours(cellFromCurrentGeneration, liveCells);

			for (Cell neighbouringCell : neighbouringCells)
			{
				if (!nextGeneration.contains(neighbouringCell))
				{
					nextGeneration.add(processCell(neighbouringCell, liveCells));
				}
			}
		}

		return filterDead(nextGeneration);
	}
	
	private Set<Cell> filterDead(HashSet<Cell> nextGeneration) {
		Iterator<Cell> iterator = nextGeneration.iterator();
		
		while(iterator.hasNext())
		{
			if(State.DEAD.equals(iterator.next().getState()))
			{
				iterator.remove();
			}
		}
		
		return nextGeneration;
	}


	private Cell processCell(Cell cell, Set<Cell> currentGeneration)
	{
		cell = cell.createCopy();
		State nextState = new RuleImpl().nextState(cell.getState(), findLiveNeighbourCount(cell, currentGeneration));
		cell.setState(nextState);
		return cell;
	}



	int findLiveNeighbourCount(Cell cell,Set<Cell> liveCells)
	{
		int count=0;
		for(Cell c:new AbstractGameStratedgy().findNeighbours(cell, liveCells))
		{
			if(State.LIVE.equals(c.getState())) count++;
		}
		return count;
	}

}
