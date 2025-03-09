
import java.util.LinkedList;
import java.util.List;

import es.uma.ada.greedy.sequence.rearrangement.GreedySequenceRearrangement;
import es.uma.ada.problem.combinatorial.sequence.rearrangement.Permutation;
import es.uma.ada.problem.combinatorial.sequence.rearrangement.Reversal;
import es.uma.ada.problem.combinatorial.sequence.rearrangement.SequenceRearrangementOperation;

/**
 * Implementation of a basic rearrangement greedy algorithm that performs
 * reversals between breakpoints
 * 
 * @author ccottap
 *
 */
public class BreakpointReversalAlgorithm extends GreedySequenceRearrangement {

	/**
	 * Default constructor
	 */
	public BreakpointReversalAlgorithm() {
		super();
	}

	@Override
	protected List<SequenceRearrangementOperation> getCandidates(Permutation p) {
		int n = p.size();
		List<SequenceRearrangementOperation> ops = new LinkedList<SequenceRearrangementOperation>();
		

		// 1) Find where the breakpoints are.
		
		// 2) Candidates are reversals between breakpoints.

		// Step 1: Identify breakpoints
        List<Integer> breakpoints = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(p.get(i) - p.get(i + 1)) != 1) {
                breakpoints.add(i);
            }
        }

        // Step 2: Generate reversal candidates between breakpoints
        for (int i = 0; i < breakpoints.size(); i++) {
            for (int j = i + 1; j < breakpoints.size(); j++) {
                int start = breakpoints.get(i) + 1;
                int end = breakpoints.get(j);
                if (start < end) {
                    ops.add(new Reversal(start, end));
                }
            }
        }

		return ops;
	}

	@Override
	protected double getOperationQuality(Permutation p, SequenceRearrangementOperation op) {
		Reversal r = (Reversal) op;
	    int start = r.getStart();
	    int end = r.getFinish();
	    int result = 0;

	    // Calculate the number of breakpoints reduced by applying the reversal
	    // Apply the reversal virtually and count the change in breakpoints

	    // Step 1: Calculate current breakpoints
	    int initialBreakpoints = 0;
	    for (int i = 0; i < p.size() - 1; i++) {
	        if (Math.abs(p.get(i) - p.get(i + 1)) != 1) {
	            initialBreakpoints++;
	        }
	    }

	    // Step 2: Apply the reversal virtually
	    Permutation temp = p;
	    r.apply(temp);

	    // Step 3: Calculate new breakpoints after the reversal
	    int newBreakpoints = 0;
	    for (int i = 0; i < temp.size() - 1; i++) {
	        if (Math.abs(temp.get(i) - temp.get(i + 1)) != 1) {
	            newBreakpoints++;
	        }
	    }

	    // Step 4: Compute the reduction in breakpoints
	    result = initialBreakpoints - newBreakpoints;

	    return (double) result; // Higher reduction means better quality
	}

	@Override
	public String getName() {
		return "BreakpointReversal";
	}

	@Override
	public boolean isSignedCompatible() {
		return false;
	}

}
