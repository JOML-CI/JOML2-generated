package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

/**
 * Immutable rectangle of {@code int} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param minX the {@code minX} component
 * @param minY the {@code minY} component
 * @param maxX the {@code maxX} component
 * @param maxY the {@code maxY} component
 */
public record IntRect(int minX, int minY, int maxX, int maxY) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** Canonical constructor. */
    public IntRect(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Create a new instance initialized to empty inverted bounds (so any union starts from the
     * first added geometry).
     */
    public IntRect() {
        this(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /** {@return the {@code minX} component} */
    public int minX() { return minX; }
    /** {@return the {@code minY} component} */
    public int minY() { return minY; }
    /** {@return the {@code maxX} component} */
    public int maxX() { return maxX; }
    /** {@return the {@code maxY} component} */
    public int maxY() { return maxY; }


    /**
     * Add {@code other} to this rectangle, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public IntRect add(IntRect other) {
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
    public IntRect add(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY) {
        return new IntRect(otherMINX + this.minX, otherMINY + this.minY, otherMAXX + this.maxX, otherMAXY + this.maxY);
    }


    /**
     * Negate this rectangle, returning the result as a value.
     *
     * @return the resulting rectangle
     */
    public IntRect negate() {
        return new IntRect(-this.minX, -this.minY, -this.maxX, -this.maxY);
    }


    /**
     * Subtract {@code other} from this rectangle, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public IntRect sub(IntRect other) {
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
    public IntRect sub(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY) {
        return new IntRect(this.minX - otherMINX, this.minY - otherMINY, this.maxX - otherMAXX, this.maxY - otherMAXY);
    }


    /**
     * Create a new rectangle from the given values.
     *
     * @param v the rectangle
     * @return the resulting rectangle
     */
    public IntRect set(IntRect v) {
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
    public IntRect set(int vMINX, int vMINY, int vMAXX, int vMAXY) {
        return new IntRect(vMINX, vMINY, vMAXX, vMAXY);
    }


    /**
     * Set the maximum corner of this rectangle to {@code max}, returning the result as a value.
     *
     * @param max the maximum corner
     * @return the resulting rectangle
     */
    public IntRect setMax(Int2 max) {
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
    public IntRect setMax(int maxX, int maxY) {
        return new IntRect(this.minX, this.minY, maxX, maxY);
    }


    /**
     * Set the minimum corner of this rectangle to {@code min}, returning the result as a value.
     *
     * @param min the minimum corner
     * @return the resulting rectangle
     */
    public IntRect setMin(Int2 min) {
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
    public IntRect setMin(int minX, int minY) {
        return new IntRect(minX, minY, this.maxX, this.maxY);
    }


    /**
     * Convert this rectangle to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatRect} holding the result
     */
    public FloatRect toFloat() {
        return new FloatRect(this.minX, this.minY, this.maxX, this.maxY);
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
     * Swap the minimum and maximum bounds of this rectangle where necessary so the bounds are
     * valid, returning the result as a value.
     *
     * @return the resulting rectangle
     */
    public IntRect correctBounds() {
        return new IntRect(Math.min(this.minX, this.maxX), Math.min(this.minY, this.maxY), Math.max(this.minX, this.maxX), Math.max(this.minY, this.maxY));
    }


    /**
     * Expand this rectangle by {@code margin} in every direction, returning the result as a value.
     *
     * @param margin the amount to expand by in every direction
     * @return the resulting rectangle
     */
    public IntRect expand(int margin) {
        return new IntRect(this.minX - margin, this.minY - margin, margin + this.maxX, margin + this.maxY);
    }


    /**
     * Compute the intersection of this rectangle and {@code other} (disjoint inputs yield inverted
     * bounds - check {@code isValid()}), returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public IntRect intersect(IntRect other) {
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
    public IntRect intersect(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY) {
        return new IntRect(Math.max(this.minX, otherMINX), Math.max(this.minY, otherMINY), Math.min(this.maxX, otherMAXX), Math.min(this.maxY, otherMAXY));
    }


    /**
     * Translate this rectangle by {@code delta}, returning the result as a value.
     *
     * @param delta the vector
     * @return the resulting rectangle
     */
    public IntRect translate(Int2 delta) {
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
    public IntRect translate(int deltaX, int deltaY) {
        return new IntRect(deltaX + this.minX, deltaY + this.minY, deltaX + this.maxX, deltaY + this.maxY);
    }


    /**
     * Set this rectangle to the union of itself and {@code other}, returning the result as a value.
     *
     * @param other the other rectangle
     * @return the resulting rectangle
     */
    public IntRect union(IntRect other) {
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
    public IntRect union(int otherMINX, int otherMINY, int otherMAXX, int otherMAXY) {
        return new IntRect(Math.min(this.minX, otherMINX), Math.min(this.minY, otherMINY), Math.max(this.maxX, otherMAXX), Math.max(this.maxY, otherMAXY));
    }


    /**
     * Grow this rectangle to include the point {@code p}, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting rectangle
     */
    public IntRect union(Int2 p) {
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
    public IntRect union(int pX, int pY) {
        return new IntRect(Math.min(this.minX, pX), Math.min(this.minY, pY), Math.max(this.maxX, pX), Math.max(this.maxY, pY));
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
        return (this.minX + this.maxX) / 2;
    }


    /**
     * Compute the y coordinate of the center of this rectangle (integer division truncates toward
     * zero).
     *
     * @return the y coordinate of the center of this rectangle (integer division truncates toward
     *        zero)
     */
    public int centerY() {
        return (this.minY + this.maxY) / 2;
    }


    /**
     * Determine whether this rectangle contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this rectangle contains the given point (boundary inclusive),
     *        {@code false} otherwise
     */
    public boolean containsPoint(Int2 p) {
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
    public boolean containsRect(IntRect o) {
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
     * Get the center of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Int2 getCenter() {
        return new Int2((this.minX + this.maxX) / 2, (this.minY + this.maxY) / 2);
    }


    /**
     * Get the maximum corner of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Int2 getMax() {
        return new Int2(this.maxX, this.maxY);
    }


    /**
     * Get the minimum corner of this rectangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Int2 getMin() {
        return new Int2(this.minX, this.minY);
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this rectangle, returning
     * the result as a value.
     *
     * @return the resulting vector
     */
    public Int2 getSize() {
        return new Int2(this.maxX - this.minX, this.maxY - this.minY);
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
    public boolean intersectsRect(IntRect o) {
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

    /** {@return a copy with the {@code minX} component replaced by {@code v}} */
    public IntRect withMinX(int v) {
        return new IntRect(v, minY, maxX, maxY);
    }

    /** {@return a copy with the {@code minY} component replaced by {@code v}} */
    public IntRect withMinY(int v) {
        return new IntRect(minX, v, maxX, maxY);
    }

    /** {@return a copy with the {@code maxX} component replaced by {@code v}} */
    public IntRect withMaxX(int v) {
        return new IntRect(minX, minY, v, maxY);
    }

    /** {@return a copy with the {@code maxY} component replaced by {@code v}} */
    public IntRect withMaxY(int v) {
        return new IntRect(minX, minY, maxX, v);
    }

    @Override public String toString() {
        return "IntRect(" + minX() + ", " + minY() + ", " + maxX() + ", " + maxY() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IntRect)) return false;
        IntRect o = (IntRect) obj;
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

    /** {@return whether all components of this value are finite} Integer components always are, so this always returns {@code true}. */
    public boolean isFinite() {
        return true;
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(IntRect other, int epsilon) {
        return Math.abs((long) minX - (long) other.minX()) <= epsilon
            && Math.abs((long) minY - (long) other.minY()) <= epsilon
            && Math.abs((long) maxX - (long) other.maxX()) <= epsilon
            && Math.abs((long) maxY - (long) other.maxY()) <= epsilon;
    }

    static final IntRectBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new IntRectBbOpsUnsafe()
                    : new IntRectBbOpsApi();
    static final IntRectRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new IntRectRawOpsUnsafe()
                    : new IntRectRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public int[] store(int[] dest, int offset) {
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
    public int[] store(int[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(int[] src, int offset) {
        int _c0 = src[offset + 0];
        int _c1 = src[offset + 1];
        int _c2 = src[offset + 2];
        int _c3 = src[offset + 3];
        return new IntRect(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(int[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public IntBuffer store(IntBuffer buf) {
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
    public IntBuffer storeAbsolute(int index, IntBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public IntBuffer storeRelative(IntBuffer buf) {
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
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(IntBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadAbsolute(int index, IntBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadRelative(IntBuffer buf) {
        int pos = buf.position();
        IntRect r = loadAbsolute(pos, buf);
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
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        IntRect r = loadAbsolute(pos, buf);
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
    public IntRect storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }


    /**
     * Store the elements into the given array, converting each element to {@code long}, starting at
     * the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public long[] store(long[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.maxX;
        dest[offset + 3] = this.maxY;
        return dest;
    }

    /**
     * Store the elements into the given array, converting each element to {@code long}.
     *
     * @param dest the destination array
     * @return dest
     */
    public long[] store(long[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, converting each element from {@code long}, starting
     * at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(long[] src, int offset) {
        int _c0 = (int) src[offset + 0];
        int _c1 = (int) src[offset + 1];
        int _c2 = (int) src[offset + 2];
        int _c3 = (int) src[offset + 3];
        return new IntRect(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code long}.
     *
     * @param src the source array
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(long[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code long}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public LongBuffer store(LongBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code long}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public LongBuffer storeAbsolute(int index, LongBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code long}, starting
     * at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public LongBuffer storeRelative(LongBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 4);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code long}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect load(LongBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code long}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadAbsolute(int index, LongBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code long}, starting
     * at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadRelative(LongBuffer buf) {
        int pos = buf.position();
        IntRect r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code long},
     * starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeLong(ByteBuffer buf) {
        return storeLongAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code long},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeLongAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeLongAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code long},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeLongRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeLongAbsolute(pos, buf);
        buf.position(pos + 32);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadLong(ByteBuffer buf) {
        return loadLongAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadLongAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadLongAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code long},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadLongRelative(ByteBuffer buf) {
        int pos = buf.position();
        IntRect r = loadLongAbsolute(pos, buf);
        buf.position(pos + 32);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code long}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public IntRect storeLongUnsafe(long address) {
        return RAW_OPS.storeLongUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code long}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code IntRect} holding the loaded elements
     */
    public static IntRect loadLongUnsafe(long address) {
        return RAW_OPS.loadLongUnsafe(address);
    }

}
