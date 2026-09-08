package org.joml2;

import java.nio.ShortBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * A 2D vector of {@code short} components.
 * <p>
 * Extends the read-only view {@link Short2R} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface Short2 extends Short2R {

    /**
     * Add {@code other} to this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 add(Short2R other) { return add(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Add ({@code x}, {@code y}) to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 add(short x, short y) { return add(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 ceilDiv(short scalar) { return ceilDiv(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 ceilDiv(Short2R other) { return ceilDiv(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 ceilDiv(short x, short y) { return ceilDiv(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 ceilMod(short scalar) { return ceilMod(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 ceilMod(Short2R other) { return ceilMod(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 ceilMod(short x, short y) { return ceilMod(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero).
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 div(short scalar) { return div(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward
     * zero).
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 div(Short2R other) { return div(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}) (integer division, truncating
     * toward zero).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 div(short x, short y) { return div(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor division of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 floorDiv(short scalar) { return floorDiv(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor division of this vector by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 floorDiv(Short2R other) { return floorDiv(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor division of this vector by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 floorDiv(short x, short y) { return floorDiv(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 floorMod(short scalar) { return floorMod(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 floorMod(Short2R other) { return floorMod(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 floorMod(short x, short y) { return floorMod(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Multiply each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 mul(short scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Multiply this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 mul(Short2R other) { return mul(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 mul(short x, short y) { return mul(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Negate this vector.
     *
     * @return this
     */
    @Mutated default Short2 negate() { return negate(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 rem(short scalar) { return rem(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 rem(Short2R other) { return rem(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and ({@code x}, {@code y}) (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 rem(short x, short y) { return rem(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Subtract {@code other} from this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 sub(Short2R other) { return sub(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Subtract ({@code x}, {@code y}) from this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 sub(short x, short y) { return sub(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise AND of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 and(Short2R other) { return and(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise AND of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 and(short x, short y) { return and(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the number of one-bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 bitCount() { return bitCount(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise NOT of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 not() { return not(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the number of leading zero bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 numberOfLeadingZeros() { return numberOfLeadingZeros(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the number of trailing zero bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 numberOfTrailingZeros() { return numberOfTrailingZeros(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise OR of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 or(Short2R other) { return or(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise OR of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 or(short x, short y) { return or(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bit-reversed value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 reverseBits() { return reverseBits(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the byte-reversed value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 reverseBytes() { return reverseBytes(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions.
     *
     * @param distance the number of bit positions to rotate by
     * @return this
     */
    @Mutated default Short2 rotateLeft(short distance) { return rotateLeft(distance, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions.
     *
     * @param distance the number of bit positions to rotate by
     * @return this
     */
    @Mutated default Short2 rotateRight(short distance) { return rotateRight(distance, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Shift each component of this vector left by {@code shift} bits.
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Short2 shl(short shift) { return shl(shift, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits.
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Short2 shr(short shift) { return shr(shift, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Logically shift each component of this vector right by {@code shift} bits.
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Short2 ushr(short shift) { return ushr(shift, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise XOR of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 xor(Short2R other) { return xor(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the bitwise XOR of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 xor(short x, short y) { return xor(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Short2 set(Short2R v);

    /**
     * Set this vector to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated Short2 set(short x, short y);

    /**
     * Set this vector to {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated default Short2 set(short s) { return set(s, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Convert this vector to {@code float} precision, returning the result as a new instance.
     *
     * @return a new {@code Float2} holding the result
     */
    default Float2 toFloat() { return toFloat(Joml.float2()); }

    /**
     * Convert this vector to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double2} holding the result
     */
    default Double2 toDouble() { return toDouble(Joml.double2()); }

    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code Byte2} holding the result
     */
    default Byte2 toByte() { return toByte(Joml.byte2()); }

    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     *
     * @return a new {@code Int2} holding the result
     */
    default Int2 toInt() { return toInt(Joml.int2()); }

    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     *
     * @return a new {@code Long2} holding the result
     */
    default Long2 toLong() { return toLong(Joml.long2()); }

    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated Short2 makeZero();

    /**
     * Compute the absolute value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 absolute() { return absolute(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return this
     */
    @Mutated default Short2 clamp(short min, short max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return this
     */
    @Mutated default Short2 clamp(Short2R min, Short2R max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}).
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @return this
     */
    @Mutated default Short2 clamp(short minX, short minY, short maxX, short maxY) { return clamp(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the larger of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 max(short scalar) { return max(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 max(Short2R other) { return max(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 max(short x, short y) { return max(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Short2 min(short scalar) { return min(scalar, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 min(Short2R other) { return min(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 min(short x, short y) { return min(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Compute the sign of each component of this vector.
     *
     * @return this
     */
    @Mutated default Short2 sign() { return sign(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 satAdd(Short2R other) { return satAdd(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Add ({@code x}, {@code y}) to this vector, clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 satAdd(short x, short y) { return satAdd(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 satMul(Short2R other) { return satMul(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Multiply this vector by ({@code x}, {@code y}), clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 satMul(short x, short y) { return satMul(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Negate this vector, clamping to the value range instead of overflowing.
     *
     * @return this
     */
    @Mutated default Short2 satNegate() { return satNegate(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Short2 satSub(Short2R other) { return satSub(other, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Subtract ({@code x}, {@code y}) from this vector, clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Short2 satSub(short x, short y) { return satSub(x, y, Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Short2 xx() { return xx(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Short2 xy() { return xy(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Short2 yx() { return yx(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Short2 yy() { return yy(Joml.RETURN_NEW ? Joml.short2() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Short2 load(short[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Short2 load(short[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Short2 load(ShortBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Short2 loadAbsolute(ShortBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Short2 loadAbsolute(int index, ShortBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Short2 loadRelative(ShortBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Short2 loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 4);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default Short2 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated Short2 load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Short2 loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Short2 load(byte[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Short2 load(byte[] src, int offset);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code byte},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 loadByte(ByteBuffer src) { return loadByteAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code byte},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 loadByteAbsolute(ByteBuffer src) { return loadByteAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code byte},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Short2 loadByteAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code byte},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Short2 loadByteRelative(ByteBuffer src) {
        int pos = src.position();
        loadByteAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code byte}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default Short2 loadByte(MemorySegment src) { return loadByte(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code byte},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated Short2 loadByte(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code byte}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Short2 loadByteUnsafe(long address);
}
