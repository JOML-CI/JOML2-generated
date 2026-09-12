package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

/**
 * Generated implementation of {@link IntRect} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class IntRectImpl implements IntRect {

    public int minX;
    public int minY;
    public int maxX;
    public int maxY;
    static final IntRectSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new IntRectSegOpsUnsafe()
                    : new IntRectSegOpsMS();
    static final IntRectBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new IntRectBbOpsUnsafe()
                    : new IntRectBbOpsApi();
    static final IntRectRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new IntRectRawOpsUnsafe()
                    : new IntRectRawOpsApi();

    public IntRectImpl() {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;
    }

    public IntRectImpl(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public IntRectImpl(IntRectR src) {
        this.minX = src.minX();
        this.minY = src.minY();
        this.maxX = src.maxX();
        this.maxY = src.maxY();
    }


    /**
     * Add {@code other} to this rectangle and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect add(IntRectR other, @Mutated IntRect dest) {
        return add(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Add {@code other} to this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect add(IntRectR other, @Mutated DoubleRect dest) {
        return add(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Add ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) to this
     * rectangle and store the result in {@code dest}.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect add(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = otherMINX + this.minX;
        d.minY = otherMINY + this.minY;
        d.maxX = otherMAXX + this.maxX;
        d.maxY = otherMAXY + this.maxY;
        return d;
    }


    /**
     * Add ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) to this
     * rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect add(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = otherMINX + this.minX;
        d.minY = otherMINY + this.minY;
        d.maxX = otherMAXX + this.maxX;
        d.maxY = otherMAXY + this.maxY;
        return d;
    }


    /**
     * Negate this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public IntRect negate(@Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = -this.minX;
        d.minY = -this.minY;
        d.maxX = -this.maxX;
        d.maxY = -this.maxY;
        return d;
    }


    /**
     * Negate this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect negate(@Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = -this.minX;
        d.minY = -this.minY;
        d.maxX = -this.maxX;
        d.maxY = -this.maxY;
        return d;
    }


    /**
     * Subtract {@code other} from this rectangle and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect sub(IntRectR other, @Mutated IntRect dest) {
        return sub(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Subtract {@code other} from this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect sub(IntRectR other, @Mutated DoubleRect dest) {
        return sub(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Subtract ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) from
     * this rectangle and store the result in {@code dest}.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect sub(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = this.minX - otherMINX;
        d.minY = this.minY - otherMINY;
        d.maxX = this.maxX - otherMAXX;
        d.maxY = this.maxY - otherMAXY;
        return d;
    }


    /**
     * Subtract ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) from
     * this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect sub(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = this.minX - otherMINX;
        d.minY = this.minY - otherMINY;
        d.maxX = this.maxX - otherMAXX;
        d.maxY = this.maxY - otherMAXY;
        return d;
    }


    /**
     * Set this rectangle to the given values.
     *
     * @param v the rectangle
     * @return this
     */
    public @Mutated IntRect set(IntRectR v) {
        return set(v.minX(), v.minY(), v.maxX(), v.maxY());
    }


    /**
     * Set this rectangle to the given values.
     *
     * @param vMINX the {@code minX} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMINY the {@code minY} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMAXX the {@code maxX} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMAXY the {@code maxY} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @return this
     */
    @Mutated public IntRect set(int vMINX, int vMINY, int vMAXX, int vMAXY) {
        this.minX = vMINX;
        this.minY = vMINY;
        this.maxX = vMAXX;
        this.maxY = vMAXY;
        return this;
    }


    /**
     * Set the maximum corner of this rectangle to {@code max} and store the result in {@code dest}.
     *
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public IntRect setMax(Int2R max, @Mutated IntRect dest) {
        return setMax(max.x(), max.y(), dest);
    }


    /**
     * Set the maximum corner of this rectangle to {@code max} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect setMax(Int2R max, @Mutated DoubleRect dest) {
        return setMax(max.x(), max.y(), dest);
    }


    /**
     * Set the maximum corner of this rectangle to ({@code maxX}, {@code maxY}) and store the result
     * in {@code dest}.
     *
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect setMax(int maxX, int maxY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.maxX = maxX;
        d.maxY = maxY;
        return d;
    }


    /**
     * Set the maximum corner of this rectangle to ({@code maxX}, {@code maxY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect setMax(int maxX, int maxY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.maxX = maxX;
        d.maxY = maxY;
        return d;
    }


    /**
     * Set the minimum corner of this rectangle to {@code min} and store the result in {@code dest}.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public IntRect setMin(Int2R min, @Mutated IntRect dest) {
        return setMin(min.x(), min.y(), dest);
    }


    /**
     * Set the minimum corner of this rectangle to {@code min} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect setMin(Int2R min, @Mutated DoubleRect dest) {
        return setMin(min.x(), min.y(), dest);
    }


    /**
     * Set the minimum corner of this rectangle to ({@code minX}, {@code minY}) and store the result
     * in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect setMin(int minX, int minY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = minX;
        d.minY = minY;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        return d;
    }


    /**
     * Set the minimum corner of this rectangle to ({@code minX}, {@code minY}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect setMin(int minX, int minY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = minX;
        d.minY = minY;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        return d;
    }


    /**
     * Convert this rectangle to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatRect toFloat(@Mutated FloatRect dest) {
        FloatRectImpl d = (FloatRectImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        return d;
    }


    /**
     * Convert this rectangle to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect toDouble(@Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        return d;
    }


    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are valid
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public IntRect correctBounds(@Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        int _buf0 = Math.min(this.minX, this.maxX);
        int _buf1 = Math.min(this.minY, this.maxY);
        d.maxX = Math.max(this.minX, this.maxX);
        d.maxY = Math.max(this.minY, this.maxY);
        d.minX = _buf0;
        d.minY = _buf1;
        return d;
    }


    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are valid
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect correctBounds(@Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        int _buf0 = Math.min(this.minX, this.maxX);
        int _buf1 = Math.min(this.minY, this.maxY);
        d.maxX = Math.max(this.minX, this.maxX);
        d.maxY = Math.max(this.minY, this.maxY);
        d.minX = _buf0;
        d.minY = _buf1;
        return d;
    }


    /**
     * Expand this rectangle by {@code margin} in every direction and store the result in
     * {@code dest}.
     *
     * @param margin the amount to expand by in every direction
     * @param dest will hold the result
     * @return dest
     */
    public IntRect expand(int margin, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = this.minX - margin;
        d.minY = this.minY - margin;
        d.maxX = margin + this.maxX;
        d.maxY = margin + this.maxY;
        return d;
    }


    /**
     * Expand this rectangle by {@code margin} in every direction and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param margin the amount to expand by in every direction
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect expand(int margin, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = this.minX - margin;
        d.minY = this.minY - margin;
        d.maxX = margin + this.maxX;
        d.maxY = margin + this.maxY;
        return d;
    }


    /**
     * Compute the intersection of this rectangle and {@code other} (disjoint inputs yield inverted
     * bounds - check {@code isValid()}) and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect intersect(IntRectR other, @Mutated IntRect dest) {
        return intersect(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Compute the intersection of this rectangle and {@code other} (disjoint inputs yield inverted
     * bounds - check {@code isValid()}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect intersect(IntRectR other, @Mutated DoubleRect dest) {
        return intersect(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Compute the intersection of this rectangle and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) (disjoint inputs yield inverted bounds - check
     * {@code isValid()}) and store the result in {@code dest}.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect intersect(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = Math.max(this.minX, otherMINX);
        d.minY = Math.max(this.minY, otherMINY);
        d.maxX = Math.min(this.maxX, otherMAXX);
        d.maxY = Math.min(this.maxY, otherMAXY);
        return d;
    }


    /**
     * Compute the intersection of this rectangle and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) (disjoint inputs yield inverted bounds - check
     * {@code isValid()}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect intersect(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = Math.max(this.minX, otherMINX);
        d.minY = Math.max(this.minY, otherMINY);
        d.maxX = Math.min(this.maxX, otherMAXX);
        d.maxY = Math.min(this.maxY, otherMAXY);
        return d;
    }


    /**
     * Translate this rectangle by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public IntRect translate(Int2R delta, @Mutated IntRect dest) {
        return translate(delta.x(), delta.y(), dest);
    }


    /**
     * Translate this rectangle by {@code delta} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect translate(Int2R delta, @Mutated DoubleRect dest) {
        return translate(delta.x(), delta.y(), dest);
    }


    /**
     * Translate this rectangle by ({@code deltaX}, {@code deltaY}) and store the result in
     * {@code dest}.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect translate(int deltaX, int deltaY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = deltaX + this.minX;
        d.minY = deltaY + this.minY;
        d.maxX = deltaX + this.maxX;
        d.maxY = deltaY + this.maxY;
        return d;
    }


    /**
     * Translate this rectangle by ({@code deltaX}, {@code deltaY}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect translate(int deltaX, int deltaY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = deltaX + this.minX;
        d.minY = deltaY + this.minY;
        d.maxX = deltaX + this.maxX;
        d.maxY = deltaY + this.maxY;
        return d;
    }


    /**
     * Set this rectangle to the union of itself and {@code other} and store the result in
     * {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect union(IntRectR other, @Mutated IntRect dest) {
        return union(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Set this rectangle to the union of itself and {@code other} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect union(IntRectR other, @Mutated DoubleRect dest) {
        return union(other.minX(), other.minY(), other.maxX(), other.maxY(), dest);
    }


    /**
     * Set this rectangle to the union of itself and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) and store the result in {@code dest}.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect union(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = Math.min(this.minX, otherMINX);
        d.minY = Math.min(this.minY, otherMINY);
        d.maxX = Math.max(this.maxX, otherMAXX);
        d.maxY = Math.max(this.maxY, otherMAXY);
        return d;
    }


    /**
     * Set this rectangle to the union of itself and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect union(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = Math.min(this.minX, otherMINX);
        d.minY = Math.min(this.minY, otherMINY);
        d.maxX = Math.max(this.maxX, otherMAXX);
        d.maxY = Math.max(this.maxY, otherMAXY);
        return d;
    }


    /**
     * Grow this rectangle to include the point {@code p} and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public IntRect union(Int2R p, @Mutated IntRect dest) {
        return union(p.x(), p.y(), dest);
    }


    /**
     * Grow this rectangle to include the point {@code p} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect union(Int2R p, @Mutated DoubleRect dest) {
        return union(p.x(), p.y(), dest);
    }


    /**
     * Grow this rectangle to include the point ({@code pX}, {@code pY}) and store the result in
     * {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY)}
     * @param pY the {@code y} component of the vector {@code (pX, pY)}
     * @param dest will hold the result
     * @return dest
     */
    public IntRect union(int pX, int pY, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = Math.min(this.minX, pX);
        d.minY = Math.min(this.minY, pY);
        d.maxX = Math.max(this.maxX, pX);
        d.maxY = Math.max(this.maxY, pY);
        return d;
    }


    /**
     * Grow this rectangle to include the point ({@code pX}, {@code pY}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY)}
     * @param pY the {@code y} component of the vector {@code (pX, pY)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect union(int pX, int pY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = Math.min(this.minX, pX);
        d.minY = Math.min(this.minY, pY);
        d.maxX = Math.max(this.maxX, pX);
        d.maxY = Math.max(this.maxY, pY);
        return d;
    }


    /**
     * Compute the area of this rectangle.
     *
     * @return the area of this rectangle
     */
    public int area() {
        return (this.maxX - this.minX) * (this.maxY - this.minY);
    }


    /**
     * Compute the x coordinate of the center of this rectangle (integer division truncates toward
     * zero).
     *
     * @return the x coordinate of the center of this rectangle (integer division truncates toward
     *        zero)
     */
    public int centerX() {
        int _t1 = this.minX ^ this.maxX;
        int _t3 = (this.minX & this.maxX) + (_t1 >> 1);
        return _t3 < 0 ? _t3 + (_t1 & 1) : _t3;
    }


    /**
     * Compute the y coordinate of the center of this rectangle (integer division truncates toward
     * zero).
     *
     * @return the y coordinate of the center of this rectangle (integer division truncates toward
     *        zero)
     */
    public int centerY() {
        int _t1 = this.minY ^ this.maxY;
        int _t3 = (this.minY & this.maxY) + (_t1 >> 1);
        return _t3 < 0 ? _t3 + (_t1 & 1) : _t3;
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Int2 closestPointToPoint(Int2R p, @Mutated Int2 dest) {
        return closestPointToPoint(p.x(), p.y(), dest);
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Long2 closestPointToPoint(Int2R p, @Mutated Long2 dest) {
        return closestPointToPoint(p.x(), p.y(), dest);
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Double2 closestPointToPoint(Int2R p, @Mutated Double2 dest) {
        return closestPointToPoint(p.x(), p.y(), dest);
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @param dest will hold the result
     * @return dest
     */
    public Int2 closestPointToPoint(int pX, int pY, @Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = Math.max(this.minX, Math.min(pX, this.maxX));
        d.y = Math.max(this.minY, Math.min(pY, this.maxY));
        return d;
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @param dest will hold the result
     * @return dest
     */
    public Long2 closestPointToPoint(int pX, int pY, @Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = Math.max(this.minX, Math.min(pX, this.maxX));
        d.y = Math.max(this.minY, Math.min(pY, this.maxY));
        return d;
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double2 closestPointToPoint(int pX, int pY, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = Math.max(this.minX, Math.min(pX, this.maxX));
        d.y = Math.max(this.minY, Math.min(pY, this.maxY));
        return d;
    }


    /**
     * Determine whether this rectangle contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this rectangle contains the given point (boundary inclusive),
     *        {@code false} otherwise
     */
    public boolean containsPoint(Int2R p) {
        return containsPoint(p.x(), p.y());
    }


    /**
     * Determine whether this rectangle contains the given point (boundary inclusive).
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY)}
     * @param pY the {@code y} component of the vector {@code (pX, pY)}
     * @return {@code true} if this rectangle contains the given point (boundary inclusive),
     *        {@code false} otherwise
     */
    public boolean containsPoint(int pX, int pY) {
        if (!(pX >= this.minX)) return false;
        if (!(pX <= this.maxX)) return false;
        if (!(pY >= this.minY)) return false;
        return pY <= this.maxY;
    }


    /**
     * Determine whether this rectangle completely contains {@code o}.
     *
     * @param o the rectangle
     * @return {@code true} if this rectangle completely contains {@code o}, {@code false} otherwise
     */
    public boolean containsRect(IntRectR o) {
        return containsRect(o.minX(), o.minY(), o.maxX(), o.maxY());
    }


    /**
     * Determine whether this rectangle completely contains ({@code oMINX}, {@code oMINY},
     * {@code oMAXX}, {@code oMAXY}).
     *
     * @param oMINX the {@code minX} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMINY the {@code minY} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMAXX the {@code maxX} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMAXY the {@code maxY} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @return {@code true} if this rectangle completely contains ({@code oMINX}, {@code oMINY},
     *        {@code oMAXX}, {@code oMAXY}), {@code false} otherwise
     */
    public boolean containsRect(int oMINX, int oMINY, int oMAXX, int oMAXY) {
        if (!(this.minX <= oMINX)) return false;
        if (!(this.maxX >= oMAXX)) return false;
        if (!(this.minY <= oMINY)) return false;
        return this.maxY >= oMAXY;
    }


    /**
     * Compute the squared distance between this rectangle and the given point, i.e. the squared
     * length of the difference between the point and its per-axis clamp into the rectangle's
     * bounds; zero for a point inside or on the rectangle.
     *
     * @param p the point
     * @return the squared distance between this rectangle and the given point, i.e. the squared
     *        length of the difference between the point and its per-axis clamp into the rectangle's
     *        bounds; zero for a point inside or on the rectangle
     */
    public int distanceSquaredToPoint(Int2R p) {
        return distanceSquaredToPoint(p.x(), p.y());
    }


    /**
     * Compute the squared distance between this rectangle and the given point, i.e. the squared
     * length of the difference between the point and its per-axis clamp into the rectangle's
     * bounds; zero for a point inside or on the rectangle.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @return the squared distance between this rectangle and the given point, i.e. the squared
     *        length of the difference between the point and its per-axis clamp into the rectangle's
     *        bounds; zero for a point inside or on the rectangle
     */
    public int distanceSquaredToPoint(int pX, int pY) {
        int _t4 = pX - Math.max(this.minX, Math.min(pX, this.maxX));
        int _t5 = pY - Math.max(this.minY, Math.min(pY, this.maxY));
        return _t4 * _t4 + _t5 * _t5;
    }


    /**
     * Compute the squared distance between this rectangle and the given rectangle, i.e. the squared
     * length of the shortest vector between any two points of the two rectangles; zero when they
     * overlap or touch.
     *
     * @param other the other rectangle
     * @return the squared distance between this rectangle and the given rectangle, i.e. the squared
     *        length of the shortest vector between any two points of the two rectangles; zero when
     *        they overlap or touch
     */
    public int distanceSquaredToRect(IntRectR other) {
        return distanceSquaredToRect(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Compute the squared distance between this rectangle and the given rectangle, i.e. the squared
     * length of the shortest vector between any two points of the two rectangles; zero when they
     * overlap or touch.
     *
     * @param otherMINX the {@code minX} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the squared distance between this rectangle and the given rectangle, i.e. the squared
     *        length of the shortest vector between any two points of the two rectangles; zero when
     *        they overlap or touch
     */
    public int distanceSquaredToRect(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY) {
        int _t6 = Math.max(0, Math.max(this.minX - otherMAXX, otherMINX - this.maxX));
        int _t7 = Math.max(0, Math.max(this.minY - otherMAXY, otherMINY - this.maxY));
        return _t6 * _t6 + _t7 * _t7;
    }


    /**
     * Get the center of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getCenter(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        int _t1 = this.minX ^ this.maxX;
        int _t3 = this.minY ^ this.maxY;
        int _t6 = (this.minX & this.maxX) + (_t1 >> 1);
        int _t7 = (this.minY & this.maxY) + (_t3 >> 1);
        d.x = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        d.y = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return d;
    }


    /**
     * Get the center of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 getCenter(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        int _t1 = this.minX ^ this.maxX;
        int _t3 = this.minY ^ this.maxY;
        int _t6 = (this.minX & this.maxX) + (_t1 >> 1);
        int _t7 = (this.minY & this.maxY) + (_t3 >> 1);
        d.x = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        d.y = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return d;
    }


    /**
     * Get the center of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getCenter(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        int _t1 = this.minX ^ this.maxX;
        int _t3 = this.minY ^ this.maxY;
        int _t6 = (this.minX & this.maxX) + (_t1 >> 1);
        int _t7 = (this.minY & this.maxY) + (_t3 >> 1);
        d.x = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        d.y = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return d;
    }


    /**
     * Get the maximum corner of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getMax(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.maxX;
        d.y = this.maxY;
        return d;
    }


    /**
     * Get the maximum corner of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 getMax(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.maxX;
        d.y = this.maxY;
        return d;
    }


    /**
     * Get the maximum corner of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getMax(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.maxX;
        d.y = this.maxY;
        return d;
    }


    /**
     * Get the minimum corner of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getMin(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.minX;
        d.y = this.minY;
        return d;
    }


    /**
     * Get the minimum corner of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 getMin(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.minX;
        d.y = this.minY;
        return d;
    }


    /**
     * Get the minimum corner of this rectangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getMin(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.minX;
        d.y = this.minY;
        return d;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getSize(@Mutated Int2 dest) {
        Int2Impl d = (Int2Impl) dest;
        d.x = this.maxX - this.minX;
        d.y = this.maxY - this.minY;
        return d;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code long} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long2 getSize(@Mutated Long2 dest) {
        Long2Impl d = (Long2Impl) dest;
        d.x = this.maxX - this.minX;
        d.y = this.maxY - this.minY;
        return d;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code int} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getSize(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = this.maxX - this.minX;
        d.y = this.maxY - this.minY;
        return d;
    }


    /**
     * Compute the height of this rectangle.
     *
     * @return the height of this rectangle
     */
    public int height() {
        return this.maxY - this.minY;
    }


    /**
     * Determine whether this rectangle intersects {@code o}.
     *
     * @param o the rectangle
     * @return {@code true} if this rectangle intersects {@code o}, {@code false} otherwise
     */
    public boolean intersectsRect(IntRectR o) {
        return intersectsRect(o.minX(), o.minY(), o.maxX(), o.maxY());
    }


    /**
     * Determine whether this rectangle intersects ({@code oMINX}, {@code oMINY}, {@code oMAXX},
     * {@code oMAXY}).
     *
     * @param oMINX the {@code minX} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMINY the {@code minY} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMAXX the {@code maxX} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @param oMAXY the {@code maxY} component of the rectangle {@code (oMINX, oMINY, oMAXX, oMAXY)}
     * @return {@code true} if this rectangle intersects ({@code oMINX}, {@code oMINY},
     *        {@code oMAXX}, {@code oMAXY}), {@code false} otherwise
     */
    public boolean intersectsRect(int oMINX, int oMINY, int oMAXX, int oMAXY) {
        if (!(this.maxX >= oMINX)) return false;
        if (!(this.minX <= oMAXX)) return false;
        if (!(this.maxY >= oMINY)) return false;
        return this.minY <= oMAXY;
    }


    /**
     * Determine whether this rectangle is valid, i.e. no minimum bound exceeds its maximum.
     *
     * @return {@code true} if this rectangle is valid, i.e. no minimum bound exceeds its maximum,
     *        {@code false} otherwise
     */
    public boolean isValid() {
        if (!(this.minX <= this.maxX)) return false;
        return this.minY <= this.maxY;
    }


    /**
     * Compute the width of this rectangle.
     *
     * @return the width of this rectangle
     */
    public int width() {
        return this.maxX - this.minX;
    }

    public int minX() { return this.minX; }
    public int minY() { return this.minY; }
    public int maxX() { return this.maxX; }
    public int maxY() { return this.maxY; }

    @Override public String toString() {
        return "IntRect(" + minX() + ", " + minY() + ", " + maxX() + ", " + maxY() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IntRectImpl)) return false;
        IntRectImpl o = (IntRectImpl) obj;
        return minX == o.minX
            && minY == o.minY
            && maxX == o.maxX
            && maxY == o.maxY;
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + minX;
        h = 31 * h + minY;
        h = 31 * h + maxX;
        h = 31 * h + maxY;
        return h;
    }

    @Override public boolean isFinite() {
        return true;
    }

    @Override public boolean equalsEpsilon(IntRectR other, int epsilon) {
        return Math.abs((long) minX - (long) other.minX()) <= epsilon
            && Math.abs((long) minY - (long) other.minY()) <= epsilon
            && Math.abs((long) maxX - (long) other.maxX()) <= epsilon
            && Math.abs((long) maxY - (long) other.maxY()) <= epsilon;
    }

    public int[] store(@Mutated int[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }
    public @Mutated IntRect load(int[] src, int offset) {
        this.minX = src[offset + 0];
        this.minY = src[offset + 1];
        this.maxX = src[offset + 2];
        this.maxY = src[offset + 3];
        return this;
    }
    public IntBuffer storeAbsolute(int index, @Mutated IntBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public IntRect loadAbsolute(int index, IntBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public IntRect loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public IntRect storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public IntRect loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public IntRect load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public long[] store(@Mutated long[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }
    public @Mutated IntRect load(long[] src, int offset) {
        this.minX = (int) src[offset + 0];
        this.minY = (int) src[offset + 1];
        this.maxX = (int) src[offset + 2];
        this.maxY = (int) src[offset + 3];
        return this;
    }
    public LongBuffer storeAbsolute(int index, @Mutated LongBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public IntRect loadAbsolute(int index, LongBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeLongAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeLongAbsolute(this, index, buf);
    }
    public IntRect loadLongAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadLongAbsolute(this, index, buf);
    }
    public IntRect storeLongUnsafe(long address) {
        return RAW_OPS.storeLongUnsafe(this, address);
    }
    @Mutated public IntRect loadLongUnsafe(long address) {
        return RAW_OPS.loadLongUnsafe(this, address);
    }
    public MemorySegment storeLong(long offset, MemorySegment dest) {
        return SEG_OPS.storeLong(this, offset, dest);
    }
    public IntRect loadLong(long offset, MemorySegment src) {
        return SEG_OPS.loadLong(this, offset, src);
    }

}
