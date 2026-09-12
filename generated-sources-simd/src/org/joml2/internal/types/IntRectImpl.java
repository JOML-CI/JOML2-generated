package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import jdk.incubator.vector.*;
import org.joml2.internal.simd.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

/**
 * Generated implementation of {@link IntRect} backed by a {@code int[]} array, with Vector API SIMD
 * kernels where profitable.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class IntRectImpl implements IntRect {

    public int[] data;
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
        data = new int[4];
        data[0] = Integer.MAX_VALUE;
        data[1] = Integer.MAX_VALUE;
        data[2] = Integer.MIN_VALUE;
        data[3] = Integer.MIN_VALUE;
    }

    public IntRectImpl(int minX, int minY, int maxX, int maxY) {
        int[] dd = this.data = new int[4];
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = maxX;
        dd[3] = maxY;
    }

    public IntRectImpl(IntRectR src) {
        int[] dd = this.data = new int[4];
        dd[0] = src.minX();
        dd[1] = src.minY();
        dd[2] = src.maxX();
        dd[3] = src.maxY();
    }


    /**
     * Add {@code other} to this rectangle and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect add(IntRectR other, @Mutated IntRect dest) {
        int[] sd = this.data;
        int[] otherData = ((IntRectImpl) other).data;
        int[] dd = ((IntRectImpl) dest).data;
        var _col0 = IntVector.fromArray(COL_SPECIES, otherData, 0).add(IntVector.fromArray(COL_SPECIES, sd, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = otherMINX + sd[0];
        dd[1] = otherMINY + sd[1];
        dd[2] = otherMAXX + sd[2];
        dd[3] = otherMAXY + sd[3];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = otherMINX + sd[0];
        dd[1] = otherMINY + sd[1];
        dd[2] = otherMAXX + sd[2];
        dd[3] = otherMAXY + sd[3];
        return dest;
    }


    /**
     * Negate this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public IntRect negate(@Mutated IntRect dest) {
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        var _col0 = IntVector.fromArray(COL_SPECIES, sd, 0).neg();
        _col0.intoArray(dd, 0);
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        return dest;
    }


    /**
     * Subtract {@code other} from this rectangle and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public IntRect sub(IntRectR other, @Mutated IntRect dest) {
        int[] sd = this.data;
        int[] otherData = ((IntRectImpl) other).data;
        int[] dd = ((IntRectImpl) dest).data;
        var _col0 = IntVector.fromArray(COL_SPECIES, sd, 0).sub(IntVector.fromArray(COL_SPECIES, otherData, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = sd[0] - otherMINX;
        dd[1] = sd[1] - otherMINY;
        dd[2] = sd[2] - otherMAXX;
        dd[3] = sd[3] - otherMAXY;
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = sd[0] - otherMINX;
        dd[1] = sd[1] - otherMINY;
        dd[2] = sd[2] - otherMAXX;
        dd[3] = sd[3] - otherMAXY;
        return dest;
    }


    /**
     * Set this rectangle to the given values.
     *
     * @param v the rectangle
     * @return this
     */
    @Mutated public IntRect set(IntRectR v) {
        int[] dd = this.data;
        int[] vData = ((IntRectImpl) v).data;
        var _col0 = IntVector.fromArray(COL_SPECIES, vData, 0);
        _col0.intoArray(dd, 0);
        return this;
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
        int[] dd = this.data;
        dd[0] = vMINX;
        dd[1] = vMINY;
        dd[2] = vMAXX;
        dd[3] = vMAXY;
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
        int[] sd = this.data;
        int[] maxData = ((Int2Impl) max).data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = maxData[0];
        dd[3] = maxData[1];
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = maxX;
        dd[3] = maxY;
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = maxX;
        dd[3] = maxY;
        return dest;
    }


    /**
     * Set the minimum corner of this rectangle to {@code min} and store the result in {@code dest}.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public IntRect setMin(Int2R min, @Mutated IntRect dest) {
        int[] sd = this.data;
        int[] minData = ((Int2Impl) min).data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = minData[0];
        dd[1] = minData[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
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
        int[] sd = this.data;
        float[] dd = ((FloatRectImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Convert this rectangle to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect toDouble(@Mutated DoubleRect dest) {
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are valid
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public IntRect correctBounds(@Mutated IntRect dest) {
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        int _buf0 = Math.min(sd[0], sd[2]);
        int _buf1 = Math.min(sd[1], sd[3]);
        dd[2] = Math.max(sd[0], sd[2]);
        dd[3] = Math.max(sd[1], sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        int _buf0 = Math.min(sd[0], sd[2]);
        int _buf1 = Math.min(sd[1], sd[3]);
        dd[2] = Math.max(sd[0], sd[2]);
        dd[3] = Math.max(sd[1], sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = sd[0] - margin;
        dd[1] = sd[1] - margin;
        dd[2] = margin + sd[2];
        dd[3] = margin + sd[3];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = sd[0] - margin;
        dd[1] = sd[1] - margin;
        dd[2] = margin + sd[2];
        dd[3] = margin + sd[3];
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = Math.max(sd[0], otherMINX);
        dd[1] = Math.max(sd[1], otherMINY);
        dd[2] = Math.min(sd[2], otherMAXX);
        dd[3] = Math.min(sd[3], otherMAXY);
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = Math.max(sd[0], otherMINX);
        dd[1] = Math.max(sd[1], otherMINY);
        dd[2] = Math.min(sd[2], otherMAXX);
        dd[3] = Math.min(sd[3], otherMAXY);
        return dest;
    }


    /**
     * Translate this rectangle by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public IntRect translate(Int2R delta, @Mutated IntRect dest) {
        int[] sd = this.data;
        int[] deltaData = ((Int2Impl) delta).data;
        int[] dd = ((IntRectImpl) dest).data;
        var _col0 = IntVector.broadcast(COL_SPECIES, deltaData[0]).blend(IntVector.broadcast(COL_SPECIES, deltaData[1]), MASK_0).add(IntVector.fromArray(COL_SPECIES, sd, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        var _col0 = IntVector.broadcast(COL_SPECIES, deltaX).blend(IntVector.broadcast(COL_SPECIES, deltaY), MASK_0).add(IntVector.fromArray(COL_SPECIES, sd, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaX + sd[2];
        dd[3] = deltaY + sd[3];
        return dest;
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
        int[] sd = this.data;
        int[] otherData = ((IntRectImpl) other).data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = Math.min(sd[0], otherData[0]);
        dd[1] = Math.min(sd[1], otherData[1]);
        dd[2] = Math.max(sd[2], otherData[2]);
        dd[3] = Math.max(sd[3], otherData[3]);
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = Math.min(sd[0], otherMINX);
        dd[1] = Math.min(sd[1], otherMINY);
        dd[2] = Math.max(sd[2], otherMAXX);
        dd[3] = Math.max(sd[3], otherMAXY);
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = Math.min(sd[0], otherMINX);
        dd[1] = Math.min(sd[1], otherMINY);
        dd[2] = Math.max(sd[2], otherMAXX);
        dd[3] = Math.max(sd[3], otherMAXY);
        return dest;
    }


    /**
     * Grow this rectangle to include the point {@code p} and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public IntRect union(Int2R p, @Mutated IntRect dest) {
        int[] sd = this.data;
        int[] pData = ((Int2Impl) p).data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = Math.min(sd[0], pData[0]);
        dd[1] = Math.min(sd[1], pData[1]);
        dd[2] = Math.max(sd[2], pData[0]);
        dd[3] = Math.max(sd[3], pData[1]);
        return dest;
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
        int[] sd = this.data;
        int[] dd = ((IntRectImpl) dest).data;
        dd[0] = Math.min(sd[0], pX);
        dd[1] = Math.min(sd[1], pY);
        dd[2] = Math.max(sd[2], pX);
        dd[3] = Math.max(sd[3], pY);
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((DoubleRectImpl) dest).data;
        dd[0] = Math.min(sd[0], pX);
        dd[1] = Math.min(sd[1], pY);
        dd[2] = Math.max(sd[2], pX);
        dd[3] = Math.max(sd[3], pY);
        return dest;
    }


    /**
     * Compute the area of this rectangle.
     *
     * @return the area of this rectangle
     */
    public int area() {
        int[] sd = this.data;
        return (sd[2] - sd[0]) * (sd[3] - sd[1]);
    }


    /**
     * Compute the x coordinate of the center of this rectangle (integer division truncates toward
     * zero).
     *
     * @return the x coordinate of the center of this rectangle (integer division truncates toward
     *        zero)
     */
    public int centerX() {
        int[] sd = this.data;
        int _t1 = sd[0] ^ sd[2];
        int _t3 = (sd[0] & sd[2]) + (_t1 >> 1);
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
        int[] sd = this.data;
        int _t1 = sd[1] ^ sd[3];
        int _t3 = (sd[1] & sd[3]) + (_t1 >> 1);
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
        int[] sd = this.data;
        int[] dd = ((Int2Impl) dest).data;
        dd[0] = Math.max(sd[0], Math.min(pX, sd[2]));
        dd[1] = Math.max(sd[1], Math.min(pY, sd[3]));
        return dest;
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
        int[] sd = this.data;
        long[] dd = ((Long2Impl) dest).data;
        dd[0] = Math.max(sd[0], Math.min(pX, sd[2]));
        dd[1] = Math.max(sd[1], Math.min(pY, sd[3]));
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = Math.max(sd[0], Math.min(pX, sd[2]));
        dd[1] = Math.max(sd[1], Math.min(pY, sd[3]));
        return dest;
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
        int[] sd = this.data;
        if (!(pX >= sd[0])) return false;
        if (!(pX <= sd[2])) return false;
        if (!(pY >= sd[1])) return false;
        return pY <= sd[3];
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
        int[] sd = this.data;
        if (!(sd[0] <= oMINX)) return false;
        if (!(sd[2] >= oMAXX)) return false;
        if (!(sd[1] <= oMINY)) return false;
        return sd[3] >= oMAXY;
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
        int[] sd = this.data;
        int _t4 = pX - Math.max(sd[0], Math.min(pX, sd[2]));
        int _t5 = pY - Math.max(sd[1], Math.min(pY, sd[3]));
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
        int[] sd = this.data;
        int _t6 = Math.max(0, Math.max(sd[0] - otherMAXX, otherMINX - sd[2]));
        int _t7 = Math.max(0, Math.max(sd[1] - otherMAXY, otherMINY - sd[3]));
        return _t6 * _t6 + _t7 * _t7;
    }


    /**
     * Get the center of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getCenter(@Mutated Int2 dest) {
        int[] sd = this.data;
        int[] dd = ((Int2Impl) dest).data;
        int _t1 = sd[0] ^ sd[2];
        int _t3 = sd[1] ^ sd[3];
        int _t6 = (sd[0] & sd[2]) + (_t1 >> 1);
        int _t7 = (sd[1] & sd[3]) + (_t3 >> 1);
        dd[0] = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        dd[1] = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return dest;
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
        int[] sd = this.data;
        long[] dd = ((Long2Impl) dest).data;
        int _t1 = sd[0] ^ sd[2];
        int _t3 = sd[1] ^ sd[3];
        int _t6 = (sd[0] & sd[2]) + (_t1 >> 1);
        int _t7 = (sd[1] & sd[3]) + (_t3 >> 1);
        dd[0] = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        dd[1] = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        int _t1 = sd[0] ^ sd[2];
        int _t3 = sd[1] ^ sd[3];
        int _t6 = (sd[0] & sd[2]) + (_t1 >> 1);
        int _t7 = (sd[1] & sd[3]) + (_t3 >> 1);
        dd[0] = _t6 < 0 ? _t6 + (_t1 & 1) : _t6;
        dd[1] = _t7 < 0 ? _t7 + (_t3 & 1) : _t7;
        return dest;
    }


    /**
     * Get the maximum corner of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getMax(@Mutated Int2 dest) {
        int[] sd = this.data;
        int[] dd = ((Int2Impl) dest).data;
        dd[0] = sd[2];
        dd[1] = sd[3];
        return dest;
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
        int[] sd = this.data;
        long[] dd = ((Long2Impl) dest).data;
        dd[0] = sd[2];
        dd[1] = sd[3];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[2];
        dd[1] = sd[3];
        return dest;
    }


    /**
     * Get the minimum corner of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getMin(@Mutated Int2 dest) {
        int[] sd = this.data;
        int[] dd = ((Int2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        return dest;
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
        int[] sd = this.data;
        long[] dd = ((Long2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        return dest;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int2 getSize(@Mutated Int2 dest) {
        int[] sd = this.data;
        int[] dd = ((Int2Impl) dest).data;
        dd[0] = sd[2] - sd[0];
        dd[1] = sd[3] - sd[1];
        return dest;
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
        int[] sd = this.data;
        long[] dd = ((Long2Impl) dest).data;
        dd[0] = sd[2] - sd[0];
        dd[1] = sd[3] - sd[1];
        return dest;
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
        int[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[2] - sd[0];
        dd[1] = sd[3] - sd[1];
        return dest;
    }


    /**
     * Compute the height of this rectangle.
     *
     * @return the height of this rectangle
     */
    public int height() {
        int[] sd = this.data;
        return sd[3] - sd[1];
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
        int[] sd = this.data;
        if (!(sd[2] >= oMINX)) return false;
        if (!(sd[0] <= oMAXX)) return false;
        if (!(sd[3] >= oMINY)) return false;
        return sd[1] <= oMAXY;
    }


    /**
     * Determine whether this rectangle is valid, i.e. no minimum bound exceeds its maximum.
     *
     * @return {@code true} if this rectangle is valid, i.e. no minimum bound exceeds its maximum,
     *        {@code false} otherwise
     */
    public boolean isValid() {
        int[] sd = this.data;
        if (!(sd[0] <= sd[2])) return false;
        return sd[1] <= sd[3];
    }


    /**
     * Compute the width of this rectangle.
     *
     * @return the width of this rectangle
     */
    public int width() {
        int[] sd = this.data;
        return sd[2] - sd[0];
    }

    public int minX() { return data[0]; }
    public int minY() { return data[1]; }
    public int maxX() { return data[2]; }
    public int maxY() { return data[3]; }

    @Override public String toString() {
        return "IntRect(" + minX() + ", " + minY() + ", " + maxX() + ", " + maxY() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IntRectImpl)) return false;
        IntRectImpl o = (IntRectImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return true;
    }

    @Override public boolean equalsEpsilon(IntRectR other, int epsilon) {
        return Math.abs((long) data[0] - (long) other.minX()) <= epsilon
            && Math.abs((long) data[1] - (long) other.minY()) <= epsilon
            && Math.abs((long) data[2] - (long) other.maxX()) <= epsilon
            && Math.abs((long) data[3] - (long) other.maxY()) <= epsilon;
    }

    public int[] store(@Mutated int[] dest, int offset) {
        int[] d = this.data;
        IntVector.fromArray(COL_SPECIES, d, 0).intoArray(dest, offset);
        return dest;
    }
    public @Mutated IntRect load(int[] src, int offset) {
        int[] d = this.data;
        IntVector.fromArray(COL_SPECIES, src, offset).intoArray(d, 0);
        return this;
    }
    public IntBuffer storeAbsolute(int index, @Mutated IntBuffer buf) {
        int[] d = this.data;
        if (buf.hasArray()) {
            int[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            IntVector.fromArray(COL_SPECIES, d, 0).intoArray(arr, off);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.storeAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            IntVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, baseOff, ByteOrder.nativeOrder());
        }
        return buf;
    }
    @Mutated public IntRect loadAbsolute(int index, IntBuffer buf) {
        int[] d = this.data;
        if (buf.hasArray()) {
            int[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            IntVector.fromArray(COL_SPECIES, arr, off).intoArray(d, 0);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.loadAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            IntVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.storeAbsolute(this, index, buf);
        int[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        IntVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public IntRect loadAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.loadAbsolute(this, index, buf);
        int[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        IntVector.fromMemorySegment(COL_SPECIES, seg, index, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }
    public IntRect storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public IntRect loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        int[] d = this.data;
        MemorySegment seg = dest;
        IntVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, offset, ByteOrder.nativeOrder());
        return dest;
    }
    public IntRect load(long offset, MemorySegment src) {
        int[] d = this.data;
        MemorySegment seg = src;
        IntVector.fromMemorySegment(COL_SPECIES, seg, offset, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }

    public long[] store(@Mutated long[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated IntRect load(long[] src, int offset) {
        this.data[0] = (int) src[offset + 0];
        this.data[1] = (int) src[offset + 1];
        this.data[2] = (int) src[offset + 2];
        this.data[3] = (int) src[offset + 3];
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

    private static final VectorSpecies<Integer> COL_SPECIES = IntVector.SPECIES_128;
    private static final VectorMask<Integer> MASK_0 = VectorMask.fromValues(COL_SPECIES, false, true, false, true);

}
