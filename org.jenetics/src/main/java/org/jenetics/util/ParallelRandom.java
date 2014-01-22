/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.util;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since @__version__@
 * @version @__version__@ &mdash; <em>$Date: 2014-01-22 $</em>
 */
public interface ParallelRandom {

	/**
	 * Changes the internal state of the PRNG in a way that future calls to
	 * {@link #nextLong()} will generated the s<sup>th</sup> sub-stream of
	 * p<sup>th</sup> sub-streams. <i>s</i> must be within the range of
	 * {@code [0, p-1)}. This method is mainly used for <i>parallelization</i>
	 * via <i>leap-frogging</i>.
	 *
	 * @param p the overall number of sub-streams
	 * @param s the s<sup>th</sup> sub-stream
	 * @throws IllegalArgumentException if {@code p < 1 || s >= p}.
	 */
	public void split(final int p, final int s);

	/**
	 * Changes the internal state of the PRNG in such a way that the engine
	 * <i>jumps</i> 2<sup>s</sup> steps ahead.
	 *
	 * @param s the 2<sup>s</sup> steps to jump ahead.
	 * @throws IllegalArgumentException if {@code s < 0}.
	 */
	public void jump2(final int s);

	/**
	 * Changes the internal state of the PRNG in such a way that the engine
	 * <i>jumps</i> s steps ahead.
	 *
	 * @param step the steps to jump ahead.
	 * @throws IllegalArgumentException if {@code s < 0}.
	 */
	public void jump(final long step);

	/*
	 * Duplicate the java.util.Random interface.
	 */

	/**
	 * @see java.util.Random#setSeed(long)
	 */
	public void setSeed(final long seed);

	/**
	 * @see java.util.Random#nextBytes(byte[])
	 */
	public void nextBytes(final byte[] bytes);

	/**
	 * @see java.util.Random#nextInt()
	 */
	public int nextInt();

	/**
	 * @see java.util.Random#nextInt(int)
	 */
	public int nextInt(int n);

	/**
	 * @see java.util.Random#nextLong()
	 */
	public long nextLong();

	/**
	 * @see java.util.Random#nextBoolean()
	 */
	public boolean nextBoolean();

	/**
	 * @see java.util.Random#nextFloat()
	 */
	public float nextFloat();

	/**
	 * @see java.util.Random#nextDouble()
	 */
	public double nextDouble();

	/**
	 * @see java.util.Random#nextGaussian()
	 */
	public double nextGaussian();

}
