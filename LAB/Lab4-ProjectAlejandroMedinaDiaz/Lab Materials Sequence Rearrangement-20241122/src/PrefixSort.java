import es.uma.ada.problem.combinatorial.sequence.rearrangement.Reversal;
import es.uma.ada.problem.combinatorial.sequence.rearrangement.Permutation;
import es.uma.ada.problem.combinatorial.sequence.rearrangement.SequenceRearrangementAlgorithm;

/**
 * Implementation of Prefix sorting as a rearrangement method on unsigned
 * permutations
 * 
 * @author ccottap
 *
 */
public class PrefixSort extends SequenceRearrangementAlgorithm {

	/**
	 * Default constructor
	 */
	public PrefixSort() {
	}

	@Override
	protected void _run(Permutation l) {
		int n = l.size();
		
		// This method implements PrefixSort.
		// See the slides for a description.
		// Remember to increase the counter numOperations
		// each time a reversal is made.
		
		// Implementing PrefixSort Algorithm
        for (int i = 0; i < n; i++) {
            // Check if the current element is in its correct position
            if (l.get(i) != i + 1) {
                // Find the index of the element that should be at position i
                int j = l.indexOf(i + 1);

                // Perform a reversal from i to j to place the correct element at i
                Reversal reversal = new Reversal(i, j);
                reversal.apply(l); // Apply the reversal

                // Increase the operation counter
                numOperations++;
            }
        }


	}

	@Override
	public String getName() {
		return "PrefixSort";
	}

	@Override
	public boolean isSignedCompatible() {
		return false;
	}

}
