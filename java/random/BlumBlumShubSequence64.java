package random;

import java.math.BigInteger;

/**
 * Implementation of a blum blum shub PRNG with a state of 64 bits.
 * 
 * @author Javier Centeno Vega <jacenve@telefonica.net>
 * @version 1.0
 * @see random.RandomSequence
 * @since 1.0
 * 
 */
public class BlumBlumShubSequence64 implements RandomSequence {

	// -----------------------------------------------------------------------------
	// Class fields

	/**
	 * m is the product of the primes 67280421310721 and 274177, and equal to 2^64 +
	 * 1
	 */
	private BigInteger m = BigInteger.valueOf(67280421310721L).multiply(BigInteger.valueOf(274177L));
	/**
	 * longRange is equal to 2^64
	 */
	private BigInteger longRange = BigInteger.valueOf(1L).shiftLeft(64);

	// -----------------------------------------------------------------------------
	// Instance fields

	private BigInteger current;

	// -----------------------------------------------------------------------------
	// Instance initializers

	public BlumBlumShubSequence64(long seed) {
		this.current = BigInteger.valueOf(seed);
	}

	// -----------------------------------------------------------------------------
	// Instance methods

	@Override
	public void setSeed(long seed) {
		this.current = BigInteger.valueOf(seed);
	}

	@Override
	public long[] getState() {
		return new long[] { current.longValue() };
	}

	@Override
	public void setState(long[] state) {
		this.current = BigInteger.valueOf(state[0]);
	}

	@Override
	public long nextUniformLong() {
		/*
		 * This generator generates numbers in [0, 2^64 + 1). We generate numbers until
		 * we have a number that isn't 2^64, that is, we have a number in [0, 2^64),
		 * which is the unsigned long range of values.
		 */
		do {
			current = current.pow(2).mod(m);
		} while (current.compareTo(longRange) == 0);
		return current.longValue();
	}

	public static void main(String[] args) {
		BlumBlumShubSequence64 prng = new BlumBlumShubSequence64(System.nanoTime());
		int[] results = new int[100];
		for(int i = 0; i < 10000000; ++i) {
			++results[prng.nextUniformInteger(100)];
		}
		for(int i : results) {
			System.out.println(i);
		}
	}

}