package org.joml2;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.ByteBuffer;

/**
 * A 2D vector of {@code byte} components.
 * <p>
 * Extends the read-only view {@link Byte2R} with the mutating surface: in-place self-forms, setters
 * and load methods. A self-form operation writes its result to {@code this} and returns it - unless
 * the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this} unchanged and
 * returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface Byte2 extends Byte2R {

    /**
     * Add {@code other} to this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 add(Byte2R other) { return add(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Add ({@code x}, {@code y}) to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 add(byte x, byte y) { return add(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 ceilDiv(byte scalar) { return ceilDiv(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 ceilDiv(Byte2R other) { return ceilDiv(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling division of this vector by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 ceilDiv(byte x, byte y) { return ceilDiv(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 ceilMod(byte scalar) { return ceilMod(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 ceilMod(Byte2R other) { return ceilMod(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 ceilMod(byte x, byte y) { return ceilMod(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero).
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 div(byte scalar) { return div(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward
     * zero).
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 div(Byte2R other) { return div(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}) (integer division, truncating
     * toward zero).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 div(byte x, byte y) { return div(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor division of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 floorDiv(byte scalar) { return floorDiv(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor division of this vector by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 floorDiv(Byte2R other) { return floorDiv(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor division of this vector by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 floorDiv(byte x, byte y) { return floorDiv(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 floorMod(byte scalar) { return floorMod(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 floorMod(Byte2R other) { return floorMod(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise floor modulus of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 floorMod(byte x, byte y) { return floorMod(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Multiply each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 mul(byte scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Multiply this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 mul(Byte2R other) { return mul(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 mul(byte x, byte y) { return mul(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Negate this vector.
     *
     * @return this
     */
    @Mutated default Byte2 negate() { return negate(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 rem(byte scalar) { return rem(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 rem(Byte2R other) { return rem(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the component-wise truncated remainder of this vector and ({@code x}, {@code y}) (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 rem(byte x, byte y) { return rem(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Subtract {@code other} from this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 sub(Byte2R other) { return sub(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Subtract ({@code x}, {@code y}) from this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 sub(byte x, byte y) { return sub(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise AND of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 and(Byte2R other) { return and(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise AND of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 and(byte x, byte y) { return and(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the number of one-bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 bitCount() { return bitCount(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise NOT of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 not() { return not(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the number of leading zero bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 numberOfLeadingZeros() { return numberOfLeadingZeros(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the number of trailing zero bits of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 numberOfTrailingZeros() { return numberOfTrailingZeros(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise OR of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 or(Byte2R other) { return or(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise OR of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 or(byte x, byte y) { return or(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bit-reversed value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 reverseBits() { return reverseBits(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the byte-reversed value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 reverseBytes() { return reverseBytes(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions.
     *
     * @param distance the number of bit positions to rotate by
     * @return this
     */
    @Mutated default Byte2 rotateLeft(byte distance) { return rotateLeft(distance, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions.
     *
     * @param distance the number of bit positions to rotate by
     * @return this
     */
    @Mutated default Byte2 rotateRight(byte distance) { return rotateRight(distance, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Shift each component of this vector left by {@code shift} bits (the shift count is taken
     * modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to {@code int}
     * and takes it modulo 32).
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Byte2 shl(byte shift) { return shl(shift, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits (the shift
     * count is taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes
     * to {@code int} and takes it modulo 32).
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Byte2 shr(byte shift) { return shr(shift, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Logically shift each component of this vector right by {@code shift} bits (the shift count is
     * taken modulo the lane width of 8, unlike Java's {@code byte} shift, which promotes to
     * {@code int} and takes it modulo 32).
     *
     * @param shift the number of bit positions to shift by
     * @return this
     */
    @Mutated default Byte2 ushr(byte shift) { return ushr(shift, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise XOR of each component of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 xor(Byte2R other) { return xor(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the bitwise XOR of each component of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 xor(byte x, byte y) { return xor(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Byte2 set(Byte2R v);

    /**
     * Set this vector to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated Byte2 set(byte x, byte y);

    /**
     * Set this vector to {@code s}.
     *
     * @param s the value assigned to every component
     * @return this
     */
    @Mutated default Byte2 set(byte s) { return set(s, Joml.RETURN_NEW ? Joml.byte2() : this); }

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
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     *
     * @return a new {@code Short2} holding the result
     */
    default Short2 toShort() { return toShort(Joml.short2()); }

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
    @Mutated Byte2 makeZero();

    /**
     * Compute the absolute value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 absolute() { return absolute(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return this
     */
    @Mutated default Byte2 clamp(byte min, byte max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return this
     */
    @Mutated default Byte2 clamp(Byte2R min, Byte2R max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.byte2() : this); }

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
    @Mutated default Byte2 clamp(byte minX, byte minY, byte maxX, byte maxY) { return clamp(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the larger of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 max(byte scalar) { return max(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 max(Byte2R other) { return max(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 max(byte x, byte y) { return max(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Byte2 min(byte scalar) { return min(scalar, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 min(Byte2R other) { return min(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 min(byte x, byte y) { return min(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Compute the sign of each component of this vector.
     *
     * @return this
     */
    @Mutated default Byte2 sign() { return sign(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 satAdd(Byte2R other) { return satAdd(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Add ({@code x}, {@code y}) to this vector, clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 satAdd(byte x, byte y) { return satAdd(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 satMul(Byte2R other) { return satMul(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Multiply this vector by ({@code x}, {@code y}), clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 satMul(byte x, byte y) { return satMul(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Negate this vector, clamping to the value range instead of overflowing.
     *
     * @return this
     */
    @Mutated default Byte2 satNegate() { return satNegate(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Byte2 satSub(Byte2R other) { return satSub(other, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Subtract ({@code x}, {@code y}) from this vector, clamping to the value range instead of
     * overflowing.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Byte2 satSub(byte x, byte y) { return satSub(x, y, Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Byte2 xx() { return xx(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Byte2 xy() { return xy(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Byte2 yx() { return yx(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Byte2 yy() { return yy(Joml.RETURN_NEW ? Joml.byte2() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Byte2 load(byte[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Byte2 load(byte[] src, int offset);

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
    @Mutated default Byte2 load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

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
    @Mutated default Byte2 loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

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
    @Mutated Byte2 loadAbsolute(int index, ByteBuffer src);

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
    @Mutated default Byte2 loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Byte2 loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Byte2 load(short[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Byte2 load(short[] src, int offset);

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
    @Mutated default Byte2 load(ShortBuffer src) { return loadAbsolute(src.position(), src); }

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
    @Mutated default Byte2 loadAbsolute(ShortBuffer src) { return loadAbsolute(src.position(), src); }

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
    @Mutated Byte2 loadAbsolute(int index, ShortBuffer src);

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
    @Mutated default Byte2 loadRelative(ShortBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code short},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Byte2 loadShort(ByteBuffer src) { return loadShortAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code short},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Byte2 loadShortAbsolute(ByteBuffer src) { return loadShortAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code short},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Byte2 loadShortAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code short},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Byte2 loadShortRelative(ByteBuffer src) {
        int pos = src.position();
        loadShortAbsolute(pos, src);
        src.position(pos + 4);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code short}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Byte2 loadShortUnsafe(long address);
}
