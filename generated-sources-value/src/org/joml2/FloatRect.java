package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable rectangle of single-precision {@code float} components, declared as a value record.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance; as a value class, instances have no identity and may be flattened by the JVM.
 *
 * @param minX the {@code minX} component
 * @param minY the {@code minY} component
 * @param maxX the {@code maxX} component
 * @param maxY the {@code maxY} component
 */
@jdk.internal.vm.annotation.LooselyConsistentValue
public value record FloatRect(float minX, float minY, float maxX, float maxY) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** Canonical constructor. */
    public FloatRect(float minX, float minY, float maxX, float maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Create a new instance initialized to empty inverted bounds (so any union starts from the
     * first added geometry).
     */
    public FloatRect() {
        this(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

    /** {@return the {@code minX} component} */
    public float minX() { return minX; }
    /** {@return the {@code minY} component} */
    public float minY() { return minY; }
    /** {@return the {@code maxX} component} */
    public float maxX() { return maxX; }
    /** {@return the {@code maxY} component} */
    public float maxY() { return maxY; }


    /**
     * Add {@code other} to this rectangle, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public FloatRect add(FloatRect other) {
        return add(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Add ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) to this
     * rectangle, returning the result as a value.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the resulting rectangle
     */
    public FloatRect add(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        return new FloatRect(otherMINX + this.minX, otherMINY + this.minY, otherMAXX + this.maxX, otherMAXY + this.maxY);
    }


    /**
     * Negate this rectangle, returning the result as a value.
     *
     * @return the resulting rectangle
     */
    public FloatRect negate() {
        return new FloatRect(-this.minX, -this.minY, -this.maxX, -this.maxY);
    }


    /**
     * Subtract {@code other} from this rectangle, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public FloatRect sub(FloatRect other) {
        return sub(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Subtract ({@code otherMINX}, {@code otherMINY}, {@code otherMAXX}, {@code otherMAXY}) from
     * this rectangle, returning the result as a value.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the resulting rectangle
     */
    public FloatRect sub(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        return new FloatRect(this.minX - otherMINX, this.minY - otherMINY, this.maxX - otherMAXX, this.maxY - otherMAXY);
    }


    /**
     * Create a new rectangle from the given values.
     *
     * @param v the rectangle
     * @return the resulting rectangle
     */
    public FloatRect set(FloatRect v) {
        return set(v.minX(), v.minY(), v.maxX(), v.maxY());
    }


    /**
     * Create a new rectangle from the given values.
     *
     * @param vMINX the {@code minX} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMINY the {@code minY} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMAXX the {@code maxX} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @param vMAXY the {@code maxY} component of the rectangle {@code (vMINX, vMINY, vMAXX, vMAXY)}
     * @return the resulting rectangle
     */
    public FloatRect set(float vMINX, float vMINY, float vMAXX, float vMAXY) {
        return new FloatRect(vMINX, vMINY, vMAXX, vMAXY);
    }


    /**
     * Set the maximum corner of this rectangle to {@code max}, returning the result as a value.
     *
     * @param max the maximum corner
     * @return the resulting rectangle
     */
    public FloatRect setMax(Float2 max) {
        return setMax(max.x(), max.y());
    }


    /**
     * Set the maximum corner of this rectangle to ({@code maxX}, {@code maxY}), returning the
     * result as a value.
     *
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @return the resulting rectangle
     */
    public FloatRect setMax(float maxX, float maxY) {
        return new FloatRect(this.minX, this.minY, maxX, maxY);
    }


    /**
     * Set the minimum corner of this rectangle to {@code min}, returning the result as a value.
     *
     * @param min the minimum corner
     * @return the resulting rectangle
     */
    public FloatRect setMin(Float2 min) {
        return setMin(min.x(), min.y());
    }


    /**
     * Set the minimum corner of this rectangle to ({@code minX}, {@code minY}), returning the
     * result as a value.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @return the resulting rectangle
     */
    public FloatRect setMin(float minX, float minY) {
        return new FloatRect(minX, minY, this.maxX, this.maxY);
    }


    /**
     * Convert this rectangle to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoubleRect} holding the result
     */
    public DoubleRect toDouble() {
        return new DoubleRect(this.minX, this.minY, this.maxX, this.maxY);
    }


    /**
     * Convert this rectangle to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code IntRect} holding the result
     */
    public IntRect toInt() {
        return new IntRect((int) (this.minX), (int) (this.minY), (int) (this.maxX), (int) (this.maxY));
    }


    /**
     * Convert this rectangle to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code IntRect} holding the result
     */
    public IntRect toInt(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toInt();
            case FLOOR -> new IntRect((int) Math.floor(this.minX), (int) Math.floor(this.minY), (int) Math.floor(this.maxX), (int) Math.floor(this.maxY));
            case CEILING -> new IntRect((int) Math.ceil(this.minX), (int) Math.ceil(this.minY), (int) Math.ceil(this.maxX), (int) Math.ceil(this.maxY));
            case HALF_TOWARD_POSITIVE_INFINITY -> new IntRect(Math.round(this.minX), Math.round(this.minY), Math.round(this.maxX), Math.round(this.maxY));
            case HALF_AWAY_FROM_ZERO -> new IntRect((int) (this.minX >= 0 ? Math.floor(this.minX + 0.5) : Math.ceil(this.minX - 0.5)), (int) (this.minY >= 0 ? Math.floor(this.minY + 0.5) : Math.ceil(this.minY - 0.5)), (int) (this.maxX >= 0 ? Math.floor(this.maxX + 0.5) : Math.ceil(this.maxX - 0.5)), (int) (this.maxY >= 0 ? Math.floor(this.maxY + 0.5) : Math.ceil(this.maxY - 0.5)));
            case HALF_EVEN -> new IntRect((int) Math.rint(this.minX), (int) Math.rint(this.minY), (int) Math.rint(this.maxX), (int) Math.rint(this.maxY));
        };
    }


    /**
     * Linearly interpolate between this rectangle and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other rectangle
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting rectangle
     */
    public FloatRect lerp(FloatRect other, float t) {
        return lerp(other.minX(), other.minY(), other.maxX(), other.maxY(), t);
    }


    /**
     * Linearly interpolate between this rectangle and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) using the interpolation factor {@code t}, returning the
     * result as a value.
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
     * @return the resulting rectangle
     */
    public FloatRect lerp(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY, float t) {
        return new FloatRect(Math.fma(t, otherMINX - this.minX, this.minX), Math.fma(t, otherMINY - this.minY, this.minY), Math.fma(t, otherMAXX - this.maxX, this.maxX), Math.fma(t, otherMAXY - this.maxY, this.maxY));
    }


    /**
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are
     * valid, returning the result as a value.
     *
     * @return the resulting rectangle
     */
    public FloatRect correctBounds() {
        return new FloatRect(Math.min(this.minX, this.maxX), Math.min(this.minY, this.maxY), Math.max(this.minX, this.maxX), Math.max(this.minY, this.maxY));
    }


    /**
     * Expand this rectangle by {@code margin} in every direction, returning the result as a value.
     *
     * @param margin the amount to expand by in every direction
     * @return the resulting rectangle
     */
    public FloatRect expand(float margin) {
        return new FloatRect(this.minX - margin, this.minY - margin, margin + this.maxX, margin + this.maxY);
    }


    /**
     * Compute the intersection of this rectangle and {@code other} (disjoint inputs yield inverted
     * bounds - check {@code isValid()}), returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public FloatRect intersect(FloatRect other) {
        return intersect(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Compute the intersection of this rectangle and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}) (disjoint inputs yield inverted bounds - check
     * {@code isValid()}), returning the result as a value.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the resulting rectangle
     */
    public FloatRect intersect(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        return new FloatRect(Math.max(this.minX, otherMINX), Math.max(this.minY, otherMINY), Math.min(this.maxX, otherMAXX), Math.min(this.maxY, otherMAXY));
    }


    /**
     * Scale the bounds of this rectangle about the origin {@code (0, 0)} by the given factors,
     * returning the result as a value.
     *
     * @param sx the scale factor along the x axis
     * @param sy the scale factor along the y axis
     * @return the resulting rectangle
     */
    public FloatRect scale(float sx, float sy) {
        return new FloatRect(sx * this.minX, sy * this.minY, sx * this.maxX, sy * this.maxY);
    }


    /**
     * Translate this rectangle by {@code delta}, returning the result as a value.
     *
     * @param delta the vector
     * @return the resulting rectangle
     */
    public FloatRect translate(Float2 delta) {
        return translate(delta.x(), delta.y());
    }


    /**
     * Translate this rectangle by ({@code deltaX}, {@code deltaY}), returning the result as a
     * value.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY)}
     * @return the resulting rectangle
     */
    public FloatRect translate(float deltaX, float deltaY) {
        return new FloatRect(deltaX + this.minX, deltaY + this.minY, deltaX + this.maxX, deltaY + this.maxY);
    }


    /**
     * Set this rectangle to the union of itself and {@code other}, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public FloatRect union(FloatRect other) {
        return union(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Set this rectangle to the union of itself and ({@code otherMINX}, {@code otherMINY},
     * {@code otherMAXX}, {@code otherMAXY}), returning the result as a value.
     *
     * @param otherMINX the {@code minX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the resulting rectangle
     */
    public FloatRect union(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        return new FloatRect(Math.min(this.minX, otherMINX), Math.min(this.minY, otherMINY), Math.max(this.maxX, otherMAXX), Math.max(this.maxY, otherMAXY));
    }


    /**
     * Grow this rectangle to include the point {@code p}, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting rectangle
     */
    public FloatRect union(Float2 p) {
        return union(p.x(), p.y());
    }


    /**
     * Grow this rectangle to include the point ({@code pX}, {@code pY}), returning the result as a
     * value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY)}
     * @param pY the {@code y} component of the vector {@code (pX, pY)}
     * @return the resulting rectangle
     */
    public FloatRect union(float pX, float pY) {
        return new FloatRect(Math.min(this.minX, pX), Math.min(this.minY, pY), Math.max(this.maxX, pX), Math.max(this.maxY, pY));
    }


    /**
     * Compute the area of this rectangle.
     *
     * @return the area of this rectangle
     */
    public float area() {
        return (this.maxX - this.minX) * (this.maxY - this.minY);
    }


    /**
     * Compute the x coordinate of the center of this rectangle.
     *
     * @return the x coordinate of the center of this rectangle
     */
    public float centerX() {
        return 0.5f * (this.minX + this.maxX);
    }


    /**
     * Compute the y coordinate of the center of this rectangle.
     *
     * @return the y coordinate of the center of this rectangle
     */
    public float centerY() {
        return 0.5f * (this.minY + this.maxY);
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param p the point
     * @return the resulting vector
     */
    public Float2 closestPointToPoint(Float2 p) {
        return closestPointToPoint(p.x(), p.y());
    }


    /**
     * Compute the point of this rectangle closest to the given point, i.e. the point clamped per
     * axis into the rectangle's bounds. For a point inside or on the rectangle, the result is the
     * point itself.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @return the resulting vector
     */
    public Float2 closestPointToPoint(float pX, float pY) {
        return new Float2(Math.max(this.minX, Math.min(pX, this.maxX)), Math.max(this.minY, Math.min(pY, this.maxY)));
    }


    /**
     * Determine whether this rectangle contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this rectangle contains the given point (boundary inclusive),
     *        {@code false} otherwise
     */
    public boolean containsPoint(Float2 p) {
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
    public boolean containsPoint(float pX, float pY) {
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
    public boolean containsRect(FloatRect o) {
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
    public boolean containsRect(float oMINX, float oMINY, float oMAXX, float oMAXY) {
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
    public float distanceSquaredToPoint(Float2 p) {
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
    public float distanceSquaredToPoint(float pX, float pY) {
        float _t4 = pX - Math.max(this.minX, Math.min(pX, this.maxX));
        float _t5 = pY - Math.max(this.minY, Math.min(pY, this.maxY));
        return Math.fma(_t4, _t4, _t5 * _t5);
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
    public float distanceSquaredToRect(FloatRect other) {
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
    public float distanceSquaredToRect(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        float _t6 = Math.max(0.0f, Math.max(this.minX - otherMAXX, otherMINX - this.maxX));
        float _t7 = Math.max(0.0f, Math.max(this.minY - otherMAXY, otherMINY - this.maxY));
        return Math.fma(_t6, _t6, _t7 * _t7);
    }


    /**
     * Compute the distance between this rectangle and the given point, i.e. the length of the
     * difference between the point and its per-axis clamp into the rectangle's bounds; zero for a
     * point inside or on the rectangle.
     *
     * @param p the point
     * @return the distance between this rectangle and the given point, i.e. the length of the
     *        difference between the point and its per-axis clamp into the rectangle's bounds; zero
     *        for a point inside or on the rectangle
     */
    public float distanceToPoint(Float2 p) {
        return distanceToPoint(p.x(), p.y());
    }


    /**
     * Compute the distance between this rectangle and the given point, i.e. the length of the
     * difference between the point and its per-axis clamp into the rectangle's bounds; zero for a
     * point inside or on the rectangle.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY)}
     * @param pY the {@code y} component of the point {@code (pX, pY)}
     * @return the distance between this rectangle and the given point, i.e. the length of the
     *        difference between the point and its per-axis clamp into the rectangle's bounds; zero
     *        for a point inside or on the rectangle
     */
    public float distanceToPoint(float pX, float pY) {
        float _t4 = pX - Math.max(this.minX, Math.min(pX, this.maxX));
        float _t5 = pY - Math.max(this.minY, Math.min(pY, this.maxY));
        return (float) Math.sqrt(Math.fma(_t4, _t4, _t5 * _t5));
    }


    /**
     * Compute the distance between this rectangle and the given rectangle, i.e. the length of the
     * shortest vector between any two points of the two rectangles; zero when they overlap or
     * touch.
     *
     * @param other the other rectangle
     * @return the distance between this rectangle and the given rectangle, i.e. the length of the
     *        shortest vector between any two points of the two rectangles; zero when they overlap
     *        or touch
     */
    public float distanceToRect(FloatRect other) {
        return distanceToRect(other.minX(), other.minY(), other.maxX(), other.maxY());
    }


    /**
     * Compute the distance between this rectangle and the given rectangle, i.e. the length of the
     * shortest vector between any two points of the two rectangles; zero when they overlap or
     * touch.
     *
     * @param otherMINX the {@code minX} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMINY the {@code minY} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXX the {@code maxX} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @param otherMAXY the {@code maxY} component of the other rectangle
     *        {@code (otherMINX, otherMINY, otherMAXX, otherMAXY)}
     * @return the distance between this rectangle and the given rectangle, i.e. the length of the
     *        shortest vector between any two points of the two rectangles; zero when they overlap
     *        or touch
     */
    public float distanceToRect(float otherMINX, float otherMINY, float otherMAXX, float otherMAXY) {
        float _t6 = Math.max(0.0f, Math.max(this.minX - otherMAXX, otherMINX - this.maxX));
        float _t7 = Math.max(0.0f, Math.max(this.minY - otherMAXY, otherMINY - this.maxY));
        return (float) Math.sqrt(Math.fma(_t6, _t6, _t7 * _t7));
    }


    /**
     * Get the center of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float2 getCenter() {
        return new Float2(0.5f * (this.minX + this.maxX), 0.5f * (this.minY + this.maxY));
    }


    /**
     * Get the maximum corner of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float2 getMax() {
        return new Float2(this.maxX, this.maxY);
    }


    /**
     * Get the minimum corner of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float2 getMin() {
        return new Float2(this.minX, this.minY);
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle, returning
     * the result as a value.
     *
     * @return the resulting vector
     */
    public Float2 getSize() {
        return new Float2(this.maxX - this.minX, this.maxY - this.minY);
    }


    /**
     * Compute the height of this rectangle.
     *
     * @return the height of this rectangle
     */
    public float height() {
        return this.maxY - this.minY;
    }


    /**
     * Determine whether this rectangle intersects {@code o}.
     *
     * @param o the rectangle
     * @return {@code true} if this rectangle intersects {@code o}, {@code false} otherwise
     */
    public boolean intersectsRect(FloatRect o) {
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
    public boolean intersectsRect(float oMINX, float oMINY, float oMAXX, float oMAXY) {
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
    public float width() {
        return this.maxX - this.minX;
    }

    /** {@return a copy with the {@code minX} component replaced by {@code v}} */
    public FloatRect withMinX(float v) {
        return new FloatRect(v, minY, maxX, maxY);
    }

    /** {@return a copy with the {@code minY} component replaced by {@code v}} */
    public FloatRect withMinY(float v) {
        return new FloatRect(minX, v, maxX, maxY);
    }

    /** {@return a copy with the {@code maxX} component replaced by {@code v}} */
    public FloatRect withMaxX(float v) {
        return new FloatRect(minX, minY, v, maxY);
    }

    /** {@return a copy with the {@code maxY} component replaced by {@code v}} */
    public FloatRect withMaxY(float v) {
        return new FloatRect(minX, minY, maxX, v);
    }

    @Override public String toString() {
        return "FloatRect(" + minX() + ", " + minY() + ", " + maxX() + ", " + maxY() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatRect)) return false;
        FloatRect o = (FloatRect) obj;
        return Float.floatToIntBits(minX) == Float.floatToIntBits(o.minX)
            && Float.floatToIntBits(minY) == Float.floatToIntBits(o.minY)
            && Float.floatToIntBits(maxX) == Float.floatToIntBits(o.maxX)
            && Float.floatToIntBits(maxY) == Float.floatToIntBits(o.maxY);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(minX);
        h = 31 * h + Float.floatToIntBits(minY);
        h = 31 * h + Float.floatToIntBits(maxX);
        h = 31 * h + Float.floatToIntBits(maxY);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(minX)
            && Float.isFinite(minY)
            && Float.isFinite(maxX)
            && Float.isFinite(maxY);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatRect other, float epsilon) {
        return Math.abs(minX - other.minX()) <= epsilon
            && Math.abs(minY - other.minY()) <= epsilon
            && Math.abs(maxX - other.maxX()) <= epsilon
            && Math.abs(maxY - other.maxY()) <= epsilon;
    }

    static final FloatRectSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRectSegOpsUnsafe()
                    : new FloatRectSegOpsMS();
    static final FloatRectBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRectBbOpsUnsafe()
                    : new FloatRectBbOpsApi();
    static final FloatRectRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRectRawOpsUnsafe()
                    : new FloatRectRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store(float[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        return new FloatRect(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer store(FloatBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 4);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatRect r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer store(ByteBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatRect r = loadAbsolute(pos, buf);
        buf.position(pos + 16);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatRect storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(long offset, MemorySegment src) {
        return SEG_OPS.load(offset, src);
    }


    /**
     * Store the elements into the given array, converting each element to {@code double}, starting
     * at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] store(double[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }

    /**
     * Store the elements into the given array, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store(double[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, converting each element from {@code double}, starting
     * at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        return new FloatRect(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer store(DoubleBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 4);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatRect r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDouble(ByteBuffer buf) {
        return storeDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 32);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatRect r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 32);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatRect storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double}.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(MemorySegment dest) { return storeDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     *
     * @param src the source memory segment
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatRect} holding the loaded elements
     */
    public static FloatRect loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
