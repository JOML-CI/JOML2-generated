package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * A rectangle of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleRectR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleRect extends DoubleRectR {

    /**
     * Add {@code other} to this rectangle.
     *
     * @param other the other rectangle
     * @return this
     */
    @Mutated default DoubleRect add(DoubleRectR other) { return add(other, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Add ({@code minX}, {@code minY}, {@code maxX}, {@code maxY}) to this rectangle.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this
     */
    @Mutated default DoubleRect add(double minX, double minY, double maxX, double maxY) { return add(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Negate this rectangle.
     *
     * @return this
     */
    @Mutated default DoubleRect negate() { return negate(Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Subtract {@code other} from this rectangle.
     *
     * @param other the other rectangle
     * @return this
     */
    @Mutated default DoubleRect sub(DoubleRectR other) { return sub(other, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Subtract ({@code minX}, {@code minY}, {@code maxX}, {@code maxY}) from this rectangle.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this
     */
    @Mutated default DoubleRect sub(double minX, double minY, double maxX, double maxY) { return sub(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set this rectangle to the given values.
     *
     * @param v the rectangle
     * @return this
     */
    @Mutated DoubleRect set(DoubleRectR v);

    /**
     * Set this rectangle to the given values.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this
     */
    @Mutated DoubleRect set(double minX, double minY, double maxX, double maxY);

    /**
     * Set the maximum corner of this rectangle to {@code max}.
     *
     * @param max the maximum corner
     * @return this
     */
    @Mutated default DoubleRect setMax(Double2R max) { return setMax(max, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set the maximum corner of this rectangle to ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default DoubleRect setMax(double x, double y) { return setMax(x, y, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set the minimum corner of this rectangle to {@code min}.
     *
     * @param min the minimum corner
     * @return this
     */
    @Mutated default DoubleRect setMin(Double2R min) { return setMin(min, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set the minimum corner of this rectangle to ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default DoubleRect setMin(double x, double y) { return setMin(x, y, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Convert this rectangle to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatRect} holding the result
     */
    default FloatRect toFloat() { return toFloat(Joml.floatRect()); }

    /**
     * Convert this rectangle to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code IntRect} holding the result
     */
    default IntRect toInt() { return toInt(Joml.intRect()); }

    /**
     * Convert this rectangle to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code IntRect} holding the result
     */
    default IntRect toInt(RoundingMode mode) { return toInt(mode, Joml.intRect()); }

    /**
     * Linearly interpolate between this rectangle and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other rectangle
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleRect lerp(DoubleRectR other, double t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Linearly interpolate between this rectangle and ({@code minX}, {@code minY}, {@code maxX},
     * {@code maxY}) using the interpolation factor {@code t}.
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleRect lerp(double minX, double minY, double maxX, double maxY, double t) { return lerp(minX, minY, maxX, maxY, t, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are
     * valid.
     *
     * @return this
     */
    @Mutated default DoubleRect correctBounds() { return correctBounds(Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Expand this rectangle by {@code margin} in every direction.
     *
     * @param margin the amount to expand by in every direction
     * @return this
     */
    @Mutated default DoubleRect expand(double margin) { return expand(margin, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Scale the bounds of this rectangle about the origin {@code (0, 0)} by the given factors.
     *
     * @param sx the scale factor along the x axis
     * @param sy the scale factor along the y axis
     * @return this
     */
    @Mutated default DoubleRect scale(double sx, double sy) { return scale(sx, sy, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Translate this rectangle by {@code delta}.
     *
     * @param delta the vector
     * @return this
     */
    @Mutated default DoubleRect translate(Double2R delta) { return translate(delta, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Translate this rectangle by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default DoubleRect translate(double x, double y) { return translate(x, y, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set this rectangle to the union of itself and {@code other}.
     *
     * @param other the other rectangle
     * @return this
     */
    @Mutated default DoubleRect union(DoubleRectR other) { return union(other, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Set this rectangle to the union of itself and ({@code minX}, {@code minY}, {@code maxX},
     * {@code maxY}).
     *
     * @param minX the {@code minX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param minY the {@code minY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxX the {@code maxX} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @param maxY the {@code maxY} component of the rectangle {@code (minX, minY, maxX, maxY)}
     * @return this
     */
    @Mutated default DoubleRect union(double minX, double minY, double maxX, double maxY) { return union(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Grow this rectangle to include the point {@code p}.
     *
     * @param p the vector
     * @return this
     */
    @Mutated default DoubleRect union(Double2R p) { return union(p, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Grow this rectangle to include the point ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default DoubleRect union(double x, double y) { return union(x, y, Joml.RETURN_NEW ? Joml.doubleRect() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRect load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRect load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRect loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect loadRelative(DoubleBuffer src) {
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
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRect loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 32);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRect loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRect load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRect load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRect loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRect loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 4);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRect loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRect loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 16);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRect loadFloatUnsafe(long address);
}
