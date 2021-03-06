package generators;

import java.util.SplittableRandom;

import api.RandomGenerator32;
import util.ByteConverter;

/**
 * A wrapper for Java's SplittableRandom PRNG, which uses a SplitMix generator.
 *
 * @author Javier Centeno Vega <jacenve@telefonica.net>
 * @version 1.0
 * @see api.RandomGenerator
 * @see java.util.SplittableRandom
 * @since 1.0
 *
 */
public class JavaSplittableRandomGenerator implements RandomGenerator32 {

	////////////////////////////////////////////////////////////////////////////////
	// Class fields

	/**
	 * Size of this generator's seed in bytes.
	 */
	public static final int SEED_SIZE = 8;

	////////////////////////////////////////////////////////////////////////////////
	// Instance fields

	/**
	 * Underlying SplittableRandom object of this generator.
	 *
	 * @see java.util.SplittableRandom
	 */
	private SplittableRandom splittableRandom;

	////////////////////////////////////////////////////////////////////////////////
	// Instance initializers

	/**
	 * Constructs a generator using SplittableRandom's no argument constructor.
	 *
	 * @see java.util.SplittableRandom
	 */
	public JavaSplittableRandomGenerator() {
		this.splittableRandom = new SplittableRandom();
	}

	/**
	 * Constructs a generator using SplittableRandom's seed-based constructor.
	 *
	 * @param seed
	 *                 A seed.
	 * @see java.util.SplittableRandom
	 * @throws IllegalArgumentException
	 *                                      If the seed is too short.
	 */
	public JavaSplittableRandomGenerator(final byte[] seed) {
		if (seed.length < JavaSplittableRandomGenerator.SEED_SIZE) {
			throw new IllegalArgumentException();
		}
		this.splittableRandom = new SplittableRandom(ByteConverter.bytesToLong(seed));
	}

	/**
	 * Constructs a generator using the given SplittableRandom.
	 *
	 * @param splittableRandom
	 *                             A SplittableRandom object.
	 * @see java.util.SplittableRandom
	 */
	public JavaSplittableRandomGenerator(final SplittableRandom splittableRandom) {
		this.splittableRandom = splittableRandom;
	}

	////////////////////////////////////////////////////////////////////////////////
	// Instance methods

	@Override
	public int getSeedSize() {
		return JavaSplittableRandomGenerator.SEED_SIZE;
	}

	@Override
	public void setSeed(final byte[] seed) {
		if (seed.length < JavaSplittableRandomGenerator.SEED_SIZE) {
			throw new IllegalArgumentException();
		}
		this.splittableRandom = new SplittableRandom(ByteConverter.bytesToLong(seed));
	}

	@Override
	public JavaSplittableRandomGenerator split() {
		return new JavaSplittableRandomGenerator(this.splittableRandom.split());
	}

	@Override
	public int generateUniformInteger() {
		return this.splittableRandom.nextInt();
	}

	@Override
	public long generateUniformLong() {
		return this.splittableRandom.nextLong();
	}

}
