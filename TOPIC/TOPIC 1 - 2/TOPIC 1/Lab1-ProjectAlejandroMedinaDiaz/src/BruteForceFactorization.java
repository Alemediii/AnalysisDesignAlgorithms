
import java.util.LinkedList;
import java.util.List;

import es.uma.ada.problem.factorization.IntegerFactorization;

/**
 * Factorizes an integer n by exhaustively checking all prime
 * numbers less than or equal to sqrt(n).
 * @author ccottap
 *
 */
public class BruteForceFactorization extends IntegerFactorization {

	/**
	 * Default constructor
	 */
	public BruteForceFactorization () {
		super();
	}
	


	@Override
	public List<Long> _factorize(long n) {
		List<Long> factors = new LinkedList<Long>();
		int maxDiv = (int) Math.sqrt(n);
		int i = 2;
		
		while(i <= maxDiv) {
			if(n % i == 0) {
				while(!(n % i > 0) ) {
					factors.add((long) i);
					n /= i;					
				}
				maxDiv = (int) Math.sqrt(n);
			}
			i++;
		}
		
		if(i > n) {
			factors.add(n);
		}
		
		return factors;
	}


	@Override
	public String getName() {
		return "Brute-force factorization";
	}

}
