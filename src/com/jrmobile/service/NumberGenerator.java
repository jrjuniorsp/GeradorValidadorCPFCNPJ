package com.jrmobile.service;

import java.util.Random;

/**
 * Random generator of numbers.
 */
public class NumberGenerator {

	// TODO generate array with range

	static int[] generateArray(Random random, int length, int quantityOfZeros) {
		if (quantityOfZeros > length)
			throw new IllegalArgumentException("quantityOfZeros must be less or equal than length.");
		if (length <= 0)
			throw new IllegalArgumentException("length must be bigger than zero.");
		int[] digits = new int[length];
		int i;
		for (i = 0; i < quantityOfZeros; i++)
			digits[i] = random.nextInt(10);
		if (i < length)
			digits[i++] = 1 + random.nextInt(9); // != 0
		for (; i < length; i++)
			digits[i] = random.nextInt(10);
		return digits;
	}

	/**
	 * Return a random array[0..length-1] of digits [0-9].
	 *
	 * @param seed
	 *            seed to generate always the same array.
	 * @param quantityOfZeros
	 *            Quantity of zeros that can be the beginning of number.
	 *            quantityOfZeros must be <= length
	 * @param length
	 *            the length of the array returned.
	 * @return a random array of digits [0-9]
	 */
	public static int[] generateArray(long seed, int length, int quantityOfZeros) {
		return generateArray(new Random(seed), length, quantityOfZeros);
	}

	/**
	 * Return a random array[0..length-1] of digits [0-9].
	 *
	 * @param quantityOfZeros
	 *            Quantity of zeros that can be the beginning of number.
	 *            quantityOfZeros must be <= length
	 * @param length
	 *            the length of the array returned.
	 * @return a random array of digits [0-9]
	 */
	public static int[] generateRandomArray(int length, int quantityOfZeros) {
		return generateArray(new Random(), length, quantityOfZeros);
	}

	/**
	 * if the random number is bigger than Integer.MAX_VALUE, so
	 * Integer.MAX_VALUE is returned.
	 *
	 * @param maxLength
	 *            maybe the first digit is 0, so the number has maxLength-1
	 *            length. If the second digit is 0 too, so the number has
	 *            maxLength-2 length, and so on.
	 * @return return a random positive number with length <= maxLength
	 */
	public static int generateRandom(int maxLength) {
		long l = Util.arrayToLong(generateRandomArray(maxLength, maxLength));
		if (l > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) l;
	}

	/**
	 * if the random number is bigger than Integer.MAX_VALUE, so
	 * Integer.MAX_VALUE is returned.
	 *
	 * @param length
	 *            The number returned always has length digits.
	 * @return a random number with length digits.
	 */
	public static int generateRandomForce(int length) {
		long l = Util.arrayToLong(generateRandomArray(length, 0));
		if (l > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) l;
	}
}
