
import es.uma.ada.backtracking.Backtracking;
import es.uma.ada.datastructures.tuple.Pair;
import es.uma.ada.problem.combinatorial.puzzle.latinsquare.LatinSquare;

/**
 * Backtracking for latinSquare
 * 
 * @author ccottap
 *
 */
public class LatinSquareBacktracking extends Backtracking {
	/**
	 * the Latin square to solve
	 */
	protected LatinSquare latinSquare;

	/**
	 * Creates the solver
	 */
	public LatinSquareBacktracking() {
		super();
		latinSquare = null;
	}

	/**
	 * Creates the solver with a specific puzzle
	 * 
	 * @param latinSquare a Latin square puzzle
	 */
	public LatinSquareBacktracking(LatinSquare latinSquare) {
		super();
		setPuzzle(latinSquare);
	}

	@Override
	protected Object initialState() {
		// The initial state is a pair with the coordinates of the 
		// first position, namely the upper left corner (0,0)
		
		//------------- TODO ------------- 
		return new Pair<>(0,0);
		//-------------------------------- 
	}

	@Override
	protected boolean backtracking(Object state) {
		@SuppressWarnings("unchecked")
		Pair<Integer, Integer> p = (Pair<Integer, Integer>) state;
		int i = p.getFirst();
		int j = p.getSecond();
		int n = latinSquare.getSize();
		
		// The algorithm must try to fill the table row by 
		// row, from left to right.
		// If a position is unspecified, the algorithm must check which
		// values are feasible for that position and continue recursively.
		// If a position is fixed, the algorithm must still check if that
		// value is feasible, because the initial instance might be unsolvable.

		//------------- TODO ------------- 
		nodes++;
		if(i == n) return true;

		//the way to assign values to the next I and J
		//we give value 'i + 1' or 'i' depending on the state j == n - 1;
		int nextI = (j == n - 1) ? i + 1 : i;
		int nextJ = (j == n - 1) ? 0 : j + 1;

		Pair<Integer, Integer> nextState = new Pair<>(nextI, nextJ);
		if(latinSquare.isFixed(i, j)){
			//if the function test returns true, it makes the backtracking of the nextState
			//if not we return false
			if(latinSquare.test(i, j, latinSquare.get(i, j))) return backtracking(nextState);
			else return false;
		}
		for(int value = 1; value <= n; value++){
			//if meets the constraints
			if(latinSquare.test(i, j, value)){
				latinSquare.set(i, j, value); //assign the value to the cell i j
 				if(backtracking(nextState)) return true;
			}

			//if not solution is gotten
			latinSquare.set(i, j, -1);
		}
		//-------------------------------- 

		
		return false;

	}

	/**
	 * Returns the internal Latin square
	 * 
	 * @return the internal Latin square
	 */
	public LatinSquare getPuzzle() {
		return latinSquare;
	}

	/**
	 * Sets the Latin square. The parameter is internally cloned, so it remains
	 * independent to the solver.
	 * 
	 * @param latinSquare the Latin square
	 */
	public void setPuzzle(LatinSquare latinSquare) {
		this.latinSquare = latinSquare.clone();
		if (verbosity) {
			System.out.println(this.latinSquare);
		}
	}

	@Override
	public String getName() {
		return "Latin-square backtracking";
	}

}
