package org.joml2;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ByteBuffer;

/**
 * A rectangle of {@code int} components.
 * <p>
 * Extends the read-only view {@link IntRectR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 * <p>
 * {@code equals} compares the components element-wise with {@code ==}. {@code hashCode} is
 * consistent with it. Only instances of this library's implementation compare equal to each other;
 * the {@code equals} of a rectangle never returns {@code true} for an object of another type.
 * <p>
 * {@code equalsEpsilon} compares per component with an exact, non-negative integer tolerance: the
 * difference is widened to {@code long} before its magnitude is taken, so the two are compared
 * exactly without overflow, and a negative {@code epsilon} matches nothing.
 */
public interface IntRect extends IntRectR {

    /**
     * Add {@code other} to this rectangle.
     *
     * @param other the other rectangle
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect add(IntRectR other) { return add(other, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Add ({@code minX}, {@code minY}, {@code maxX}, {@code maxY}) to this rectangle.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect add(int minX, int minY, int maxX, int maxY) { return add(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Negate this rectangle.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect negate() { return negate(Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Subtract {@code other} from this rectangle.
     *
     * @param other the other rectangle
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect sub(IntRectR other) { return sub(other, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Subtract ({@code minX}, {@code minY}, {@code maxX}, {@code maxY}) from this rectangle.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect sub(int minX, int minY, int maxX, int maxY) { return sub(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set this rectangle to the given values.
     *
     * @param v the rectangle
     * @return this
     */
    @Mutated IntRect set(IntRectR v);

    /**
     * Set this rectangle to the given values.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this
     */
    @Mutated IntRect set(int minX, int minY, int maxX, int maxY);

    /**
     * Set the maximum corner of this rectangle to {@code max}.
     *
     * @param max the maximum corner
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect setMax(Int2R max) { return setMax(max, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set the maximum corner of this rectangle to ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect setMax(int x, int y) { return setMax(x, y, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set the minimum corner of this rectangle to {@code min}.
     *
     * @param min the minimum corner
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect setMin(Int2R min) { return setMin(min, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set the minimum corner of this rectangle to ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect setMin(int x, int y) { return setMin(x, y, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Convert this rectangle to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatRect} holding the result
     */
    default FloatRect toFloat() { return toFloat(Joml.floatRect()); }

    /**
     * Convert this rectangle to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoubleRect} holding the result
     */
    default DoubleRect toDouble() { return toDouble(Joml.doubleRect()); }

    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are
     * valid.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect correctBounds() { return correctBounds(Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Expand this rectangle by {@code margin} in every direction.
     *
     * @param margin the amount to expand by in every direction
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect expand(int margin) { return expand(margin, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Translate this rectangle by {@code delta}.
     *
     * @param delta the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect translate(Int2R delta) { return translate(delta, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Translate this rectangle by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect translate(int x, int y) { return translate(x, y, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set this rectangle to the union of itself and {@code other}.
     *
     * @param other the other rectangle
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect union(IntRectR other) { return union(other, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Set this rectangle to the union of itself and ({@code minX}, {@code minY}, {@code maxX},
     * {@code maxY}).
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect union(int minX, int minY, int maxX, int maxY) { return union(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Grow this rectangle to include the point {@code p}.
     *
     * @param p the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect union(Int2R p) { return union(p, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Grow this rectangle to include the point ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default IntRect union(int x, int y) { return union(x, y, Joml.RETURN_NEW ? Joml.intRect() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default IntRect load(int[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated IntRect load(int[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect load(IntBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect loadAbsolute(IntBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated IntRect loadAbsolute(int index, IntBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect loadRelative(IntBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 4);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated IntRect loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 16);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated IntRect loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default IntRect load(long[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated IntRect load(long[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect load(LongBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect loadAbsolute(LongBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated IntRect loadAbsolute(int index, LongBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default IntRect loadRelative(LongBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 4);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect loadLong(ByteBuffer src) { return loadLongAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect loadLongAbsolute(ByteBuffer src) { return loadLongAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated IntRect loadLongAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default IntRect loadLongRelative(ByteBuffer src) {
        int pos = src.position();
        loadLongAbsolute(pos, src);
        src.position(pos + 32);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code long}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated IntRect loadLongUnsafe(long address);
}
