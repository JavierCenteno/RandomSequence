package api;

/**
 * This class offers default implementations for the methods of a random
 * generator that generates 8 bits at a time.
 * 
 * @author Javier Centeno Vega <jacenve@telefonica.net>
 * @version 1.0
 * @see api.RandomGenerator
 * @since 1.0
 * 
 */
public interface RandomGenerator8 extends RandomGenerator {

	////////////////////////////////////////////////////////////////////////////////
	// Instance methods

	@Override
	public byte generateUniformByte();

	@Override
	public default short generateUniformShort() {
		int byte0 = generateUniformByte() & 0x000000FF;
		int byte1 = generateUniformByte() & 0x000000FF;
		return (short) (byte0 << 8 | byte1);
	}

	@Override
	public default int generateUniformInteger() {
		int byte0 = generateUniformByte() & 0x000000FF;
		int byte1 = generateUniformByte() & 0x000000FF;
		int byte2 = generateUniformByte() & 0x000000FF;
		int byte3 = generateUniformByte() & 0x000000FF;
		return byte0 << 24 | byte1 << 16 | byte2 << 8 | byte3;
	}

	@Override
	public default long generateUniformLong() {
		long byte0 = generateUniformByte() & 0x00000000000000FFL;
		long byte1 = generateUniformByte() & 0x00000000000000FFL;
		long byte2 = generateUniformByte() & 0x00000000000000FFL;
		long byte3 = generateUniformByte() & 0x00000000000000FFL;
		long byte4 = generateUniformByte() & 0x00000000000000FFL;
		long byte5 = generateUniformByte() & 0x00000000000000FFL;
		long byte6 = generateUniformByte() & 0x00000000000000FFL;
		long byte7 = generateUniformByte() & 0x00000000000000FFL;
		return byte0 << 56 | byte1 << 48 | byte2 << 40 | byte3 << 32 | byte4 << 24 | byte5 << 16 | byte6 << 8 | byte7;
	}

}
