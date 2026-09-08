package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleRect} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleRectImpl implements DoubleRect {

    public double minX;
    public double minY;
    public double maxX;
    public double maxY;
    static final DoubleRectSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRectSegOpsUnsafe()
                    : new DoubleRectSegOpsMS();
    static final DoubleRectBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRectBbOpsUnsafe()
                    : new DoubleRectBbOpsApi();
    static final DoubleRectRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRectRawOpsUnsafe()
                    : new DoubleRectRawOpsApi();

    public DoubleRectImpl() {
        minX = Double.POSITIVE_INFINITY;
        minY = Double.POSITIVE_INFINITY;
        maxX = Double.NEGATIVE_INFINITY;
        maxY = Double.NEGATIVE_INFINITY;
    }


    /**
     * Add {@code other} to this rectangle and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect add(DoubleRectR other, @Mutated DoubleRect dest) {
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
    public DoubleRect add(double otherMINX, double otherMINY, double otherMAXX, double otherMAXY, @Mutated DoubleRect dest) {
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
    public DoubleRect sub(DoubleRectR other, @Mutated DoubleRect dest) {
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
    public DoubleRect sub(double otherMINX, double otherMINY, double otherMAXX, double otherMAXY, @Mutated DoubleRect dest) {
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
    public @Mutated DoubleRect set(DoubleRectR v) {
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
    @Mutated public DoubleRect set(double vMINX, double vMINY, double vMAXX, double vMAXY) {
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
    public DoubleRect setMax(Double2R max, @Mutated DoubleRect dest) {
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
    public DoubleRect setMax(double maxX, double maxY, @Mutated DoubleRect dest) {
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
    public DoubleRect setMin(Double2R min, @Mutated DoubleRect dest) {
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
    public DoubleRect setMin(double minX, double minY, @Mutated DoubleRect dest) {
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
        d.minX = (float) (this.minX);
        d.minY = (float) (this.minY);
        d.maxX = (float) (this.maxX);
        d.maxY = (float) (this.maxY);
        return d;
    }


    /**
     * Convert this rectangle to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    public IntRect toInt(@Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        d.minX = (int) (this.minX);
        d.minY = (int) (this.minY);
        d.maxX = (int) (this.maxX);
        d.maxY = (int) (this.maxY);
        return d;
    }


    /**
     * Convert this rectangle to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    public IntRect toInt(RoundingMode roundingMode, @Mutated IntRect dest) {
        IntRectImpl d = (IntRectImpl) dest;
        switch (roundingMode) {
            case TRUNCATE -> { return toInt(dest); }
            case FLOOR -> {
                d.minX = (int) Math.floor(this.minX);
                d.minY = (int) Math.floor(this.minY);
                d.maxX = (int) Math.floor(this.maxX);
                d.maxY = (int) Math.floor(this.maxY);
            }
            case CEILING -> {
                d.minX = (int) Math.ceil(this.minX);
                d.minY = (int) Math.ceil(this.minY);
                d.maxX = (int) Math.ceil(this.maxX);
                d.maxY = (int) Math.ceil(this.maxY);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                d.minX = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.minX)));
                d.minY = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.minY)));
                d.maxX = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.maxX)));
                d.maxY = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.maxY)));
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.minX = (int) (this.minX >= 0 ? Math.floor(this.minX + 0.5) : Math.ceil(this.minX - 0.5));
                d.minY = (int) (this.minY >= 0 ? Math.floor(this.minY + 0.5) : Math.ceil(this.minY - 0.5));
                d.maxX = (int) (this.maxX >= 0 ? Math.floor(this.maxX + 0.5) : Math.ceil(this.maxX - 0.5));
                d.maxY = (int) (this.maxY >= 0 ? Math.floor(this.maxY + 0.5) : Math.ceil(this.maxY - 0.5));
            }
            case HALF_EVEN -> {
                d.minX = (int) Math.rint(this.minX);
                d.minY = (int) Math.rint(this.minY);
                d.maxX = (int) Math.rint(this.maxX);
                d.maxY = (int) Math.rint(this.maxY);
            }
        }
        return dest;
    }


    /**
     * Linearly interpolate between this rectangle and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other rectangle
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect lerp(DoubleRectR other, double t, @Mutated DoubleRect dest) {
        return lerp(other.minX(), other.minY(), other.maxX(), other.maxY(), t, dest);
    }


    /**
     * Linearly interpolate between this rectangle and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) using the interpolation factor {@code t} and store the
     * result in {@code dest}.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect lerp(double otherMINX, double otherMINY, double otherMAXX, double otherMAXY, double t, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = Math.fma(t, otherMINX - this.minX, this.minX);
        d.minY = Math.fma(t, otherMINY - this.minY, this.minY);
        d.maxX = Math.fma(t, otherMAXX - this.maxX, this.maxX);
        d.maxY = Math.fma(t, otherMAXY - this.maxY, this.maxY);
        return d;
    }


    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are valid
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect correctBounds(@Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        double _buf0 = Math.min(this.minX, this.maxX);
        double _buf1 = Math.min(this.minY, this.maxY);
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
    public DoubleRect expand(double margin, @Mutated DoubleRect dest) {
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
    public DoubleRect intersect(DoubleRectR other, @Mutated DoubleRect dest) {
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
    public DoubleRect intersect(double otherMINX, double otherMINY, double otherMAXX, double otherMAXY, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = Math.max(this.minX, otherMINX);
        d.minY = Math.max(this.minY, otherMINY);
        d.maxX = Math.min(this.maxX, otherMAXX);
        d.maxY = Math.min(this.maxY, otherMAXY);
        return d;
    }


    /**
     * Scale the bounds of this rectangle about the origin {@code (0, 0)} by the given factors and
     * store the result in {@code dest}.
     *
     * @param sx the scale factor along the x axis
     * @param sy the scale factor along the y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect scale(double sx, double sy, @Mutated DoubleRect dest) {
        DoubleRectImpl d = (DoubleRectImpl) dest;
        d.minX = sx * this.minX;
        d.minY = sy * this.minY;
        d.maxX = sx * this.maxX;
        d.maxY = sy * this.maxY;
        return d;
    }


    /**
     * Translate this rectangle by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRect translate(Double2R delta, @Mutated DoubleRect dest) {
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
    public DoubleRect translate(double deltaX, double deltaY, @Mutated DoubleRect dest) {
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
    public DoubleRect union(DoubleRectR other, @Mutated DoubleRect dest) {
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
    public DoubleRect union(double otherMINX, double otherMINY, double otherMAXX, double otherMAXY, @Mutated DoubleRect dest) {
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
    public DoubleRect union(Double2R p, @Mutated DoubleRect dest) {
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
    public DoubleRect union(double pX, double pY, @Mutated DoubleRect dest) {
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
    public double area() {
        return (this.maxX - this.minX) * (this.maxY - this.minY);
    }


    /**
     * Compute the x coordinate of the center of this rectangle.
     *
     * @return the x coordinate of the center of this rectangle
     */
    public double centerX() {
        return 0.5 * (this.minX + this.maxX);
    }


    /**
     * Compute the y coordinate of the center of this rectangle.
     *
     * @return the y coordinate of the center of this rectangle
     */
    public double centerY() {
        return 0.5 * (this.minY + this.maxY);
    }


    /**
     * Determine whether this rectangle contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this rectangle contains the given point (boundary inclusive),
     *        {@code false} otherwise
     */
    public boolean containsPoint(Double2R p) {
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
    public boolean containsPoint(double pX, double pY) {
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
    public boolean containsRect(DoubleRectR o) {
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
    public boolean containsRect(double oMINX, double oMINY, double oMAXX, double oMAXY) {
        if (!(this.minX <= oMINX)) return false;
        if (!(this.maxX >= oMAXX)) return false;
        if (!(this.minY <= oMINY)) return false;
        return this.maxY >= oMAXY;
    }


    /**
     * Get the center of this rectangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getCenter(@Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        d.x = 0.5 * (this.minX + this.maxX);
        d.y = 0.5 * (this.minY + this.maxY);
        return d;
    }


    /**
     * Get the maximum corner of this rectangle and store the result in {@code dest}.
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
    public double height() {
        return this.maxY - this.minY;
    }


    /**
     * Determine whether this rectangle intersects {@code o}.
     *
     * @param o the rectangle
     * @return {@code true} if this rectangle intersects {@code o}, {@code false} otherwise
     */
    public boolean intersectsRect(DoubleRectR o) {
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
    public boolean intersectsRect(double oMINX, double oMINY, double oMAXX, double oMAXY) {
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
    public double width() {
        return this.maxX - this.minX;
    }

    public double minX() { return this.minX; }
    public double minY() { return this.minY; }
    public double maxX() { return this.maxX; }
    public double maxY() { return this.maxY; }

    @Override public String toString() {
        return "DoubleRect(" + minX() + ", " + minY() + ", " + maxX() + ", " + maxY() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleRectImpl)) return false;
        DoubleRectImpl o = (DoubleRectImpl) obj;
        return Double.doubleToLongBits(minX) == Double.doubleToLongBits(o.minX)
            && Double.doubleToLongBits(minY) == Double.doubleToLongBits(o.minY)
            && Double.doubleToLongBits(maxX) == Double.doubleToLongBits(o.maxX)
            && Double.doubleToLongBits(maxY) == Double.doubleToLongBits(o.maxY);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(minX) ^ (Double.doubleToLongBits(minX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(minY) ^ (Double.doubleToLongBits(minY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(maxX) ^ (Double.doubleToLongBits(maxX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(maxY) ^ (Double.doubleToLongBits(maxY) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(minX)
            && Double.isFinite(minY)
            && Double.isFinite(maxX)
            && Double.isFinite(maxY);
    }

    @Override public boolean equalsEpsilon(DoubleRectR other, double epsilon) {
        return Math.abs(minX - other.minX()) <= epsilon
            && Math.abs(minY - other.minY()) <= epsilon
            && Math.abs(maxX - other.maxX()) <= epsilon
            && Math.abs(maxY - other.maxY()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }
    public @Mutated DoubleRect load(double[] src, int offset) {
        this.minX = src[offset + 0];
        this.minY = src[offset + 1];
        this.maxX = src[offset + 2];
        this.maxY = src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRect loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleRect loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleRect storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleRect loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleRect load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.minX;
        dest[offset + 1] = (float) this.minY;
        dest[offset + 2] = (float) this.maxX;
        dest[offset + 3] = (float) this.maxY;
        return dest;
    }
    public @Mutated DoubleRect load(float[] src, int offset) {
        this.minX = src[offset + 0];
        this.minY = src[offset + 1];
        this.maxX = src[offset + 2];
        this.maxY = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRect loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleRect loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleRect storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleRect loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleRect loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
