package org.joml2;

import java.nio.LongBuffer;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a 2D vector of {@code long} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link Long2}. APIs that only read a 2D vector
 * should accept {@code Long2R}, so callers can pass mutable instances without exposing them to
 * modification.
 */
public interface Long2R {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** {@return a shared all-zero vector} Never mutate it - it is returned as the read-only view for that reason. */
    public static Long2R ZERO() { return Holder.ZERO; }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 add(Long2R other, @Mutated Long2 dest);

    /**
     * Add ({@code x}, {@code y}) to this vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 add(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilDiv(long scalar, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling division of this vector by {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilDiv(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling division of this vector by ({@code x}, {@code y}) and
     * store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilDiv(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilMod(long scalar, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilMod(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the component-wise ceiling modulus of this vector and ({@code x}, {@code y}) and
     * store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 ceilMod(long x, long y, @Mutated Long2 dest);

    /**
     * Divide each component of this vector by {@code scalar} (integer division, truncating toward
     * zero) and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 div(long scalar, @Mutated Long2 dest);

    /**
     * Divide this vector component-wise by {@code other} (integer division, truncating toward zero)
     * and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 div(Long2R other, @Mutated Long2 dest);

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}) (integer division, truncating
     * toward zero) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 div(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor division of this vector by {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorDiv(long scalar, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor division of this vector by {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorDiv(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor division of this vector by ({@code x}, {@code y}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorDiv(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor modulus of this vector and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorMod(long scalar, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor modulus of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorMod(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the component-wise floor modulus of this vector and ({@code x}, {@code y}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 floorMod(long x, long y, @Mutated Long2 dest);

    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 mul(long scalar, @Mutated Long2 dest);

    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 mul(Long2R other, @Mutated Long2 dest);

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}) and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 mul(long x, long y, @Mutated Long2 dest);

    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 negate(@Mutated Long2 dest);

    /**
     * Compute the component-wise truncated remainder of this vector and {@code scalar} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 rem(long scalar, @Mutated Long2 dest);

    /**
     * Compute the component-wise truncated remainder of this vector and {@code other} (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 rem(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the component-wise truncated remainder of this vector and ({@code x}, {@code y}) (the
     * remainder carries the sign of the dividend, exactly Java's {@code %}, so it pairs with
     * {@code div}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 rem(long x, long y, @Mutated Long2 dest);

    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 sub(Long2R other, @Mutated Long2 dest);

    /**
     * Subtract ({@code x}, {@code y}) from this vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 sub(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the bitwise AND of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 and(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the bitwise AND of each component of this vector and ({@code x}, {@code y}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 and(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the number of one-bits of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 bitCount(@Mutated Long2 dest);

    /**
     * Compute the bitwise NOT of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 not(@Mutated Long2 dest);

    /**
     * Compute the number of leading zero bits of each component of this vector and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 numberOfLeadingZeros(@Mutated Long2 dest);

    /**
     * Compute the number of trailing zero bits of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 numberOfTrailingZeros(@Mutated Long2 dest);

    /**
     * Compute the bitwise OR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 or(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the bitwise OR of each component of this vector and ({@code x}, {@code y}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 or(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the bit-reversed value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 reverseBits(@Mutated Long2 dest);

    /**
     * Compute the byte-reversed value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 reverseBytes(@Mutated Long2 dest);

    /**
     * Rotate the bits of each component of this vector left by {@code distance} positions and store
     * the result in {@code dest}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    Long2 rotateLeft(long distance, @Mutated Long2 dest);

    /**
     * Rotate the bits of each component of this vector right by {@code distance} positions and
     * store the result in {@code dest}.
     *
     * @param distance the number of bit positions to rotate by
     * @param dest will hold the result
     * @return dest
     */
    Long2 rotateRight(long distance, @Mutated Long2 dest);

    /**
     * Shift each component of this vector left by {@code shift} bits and store the result in
     * {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    Long2 shl(long shift, @Mutated Long2 dest);

    /**
     * Arithmetically shift each component of this vector right by {@code shift} bits and store the
     * result in {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    Long2 shr(long shift, @Mutated Long2 dest);

    /**
     * Logically shift each component of this vector right by {@code shift} bits and store the
     * result in {@code dest}.
     *
     * @param shift the number of bit positions to shift by
     * @param dest will hold the result
     * @return dest
     */
    Long2 ushr(long shift, @Mutated Long2 dest);

    /**
     * Compute the bitwise XOR of each component of this vector and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 xor(Long2R other, @Mutated Long2 dest);

    /**
     * Compute the bitwise XOR of each component of this vector and ({@code x}, {@code y}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 xor(long x, long y, @Mutated Long2 dest);

    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    Long2 set(long s, @Mutated Long2 dest);

    /**
     * Convert this vector to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float2 toFloat(@Mutated Float2 dest);

    /**
     * Convert this vector to {@code double} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 toDouble(@Mutated Double2 dest);

    /**
     * Convert this vector to {@code byte} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Byte2 toByte(@Mutated Byte2 dest);

    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Short2 toShort(@Mutated Short2 dest);

    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Int2 toInt(@Mutated Int2 dest);

    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 absolute(@Mutated Long2 dest);

    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    Long2 clamp(long min, long max, @Mutated Long2 dest);

    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    Long2 clamp(Long2R min, Long2R max, @Mutated Long2 dest);

    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}) and store the result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 clamp(long minX, long minY, long maxX, long maxY, @Mutated Long2 dest);

    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    long compAdd();

    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    long compMax();

    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    long compMin();

    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    long compMul();

    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    long distanceSquared(Long2R other);

    /**
     * Compute the squared distance between this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return the squared distance between this vector and ({@code x}, {@code y})
     */
    long distanceSquared(long x, long y);

    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    long dot(Long2R other);

    /**
     * Compute the dot product of this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return the dot product of this vector and ({@code x}, {@code y})
     */
    long dot(long x, long y);

    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    long lengthSquared();

    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    long manhattanDistance(Long2R other);

    /**
     * Compute the Manhattan distance between this vector and ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return the Manhattan distance between this vector and ({@code x}, {@code y})
     */
    long manhattanDistance(long x, long y);

    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    long manhattanLength();

    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 max(long scalar, @Mutated Long2 dest);

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 max(Long2R other, @Mutated Long2 dest);

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 max(long x, long y, @Mutated Long2 dest);

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Long2 min(long scalar, @Mutated Long2 dest);

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 min(Long2R other, @Mutated Long2 dest);

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 min(long x, long y, @Mutated Long2 dest);

    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 sign(@Mutated Long2 dest);

    /**
     * Add {@code other} to this vector, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 satAdd(Long2R other, @Mutated Long2 dest);

    /**
     * Add ({@code x}, {@code y}) to this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 satAdd(long x, long y, @Mutated Long2 dest);

    /**
     * Multiply this vector by {@code other}, clamping to the value range instead of overflowing and
     * store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 satMul(Long2R other, @Mutated Long2 dest);

    /**
     * Multiply this vector by ({@code x}, {@code y}), clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 satMul(long x, long y, @Mutated Long2 dest);

    /**
     * Negate this vector, clamping to the value range instead of overflowing and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 satNegate(@Mutated Long2 dest);

    /**
     * Subtract {@code other} from this vector, clamping to the value range instead of overflowing
     * and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Long2 satSub(Long2R other, @Mutated Long2 dest);

    /**
     * Subtract ({@code x}, {@code y}) from this vector, clamping to the value range instead of
     * overflowing and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Long2 satSub(long x, long y, @Mutated Long2 dest);
    /** {@return the value of the {@code x} component} */
    long x();
    /** {@return the value of the {@code y} component} */
    long y();

    /**
     * Swizzle: copy ({@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 xx(@Mutated Long2 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 xy(@Mutated Long2 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 yx(@Mutated Long2 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long2 yy(@Mutated Long2 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 xxx(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 xxy(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 xyx(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 xyy(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 yxx(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 yxy(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 yyx(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 yyy(@Mutated Long3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xxxx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xxxy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xxyx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xxyy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xyxx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xyxy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xyyx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 xyyy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yxxx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yxxy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yxyx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yxyy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yyxx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yyxy(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yyyx(@Mutated Long4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long4 yyyy(@Mutated Long4 dest);

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    default long[] store(@Mutated long[] dest) { return store(dest, 0); }

    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    long[] store(@Mutated long[] dest, int offset);

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default LongBuffer store(@Mutated LongBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default LongBuffer storeAbsolute(@Mutated LongBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    LongBuffer storeAbsolute(int index, @Mutated LongBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default LongBuffer storeRelative(@Mutated LongBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 2);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer store(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeAbsolute(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given memory segment.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment store(@Mutated MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment store(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Long2 storeUnsafe(long address);

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    default int[] store(@Mutated int[] dest) { return store(dest, 0); }

    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    int[] store(@Mutated int[] dest, int offset);

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default IntBuffer store(@Mutated IntBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default IntBuffer storeAbsolute(@Mutated IntBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    IntBuffer storeAbsolute(int index, @Mutated IntBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default IntBuffer storeRelative(@Mutated IntBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 2);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code int},
     * starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeInt(@Mutated ByteBuffer dest) { return storeIntAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code int},
     * starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeIntAbsolute(@Mutated ByteBuffer dest) { return storeIntAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code int},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeIntAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, converting each element to {@code int},
     * starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeIntRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeIntAbsolute(pos, dest);
        dest.position(pos + 8);
        return dest;
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code int}.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeInt(@Mutated MemorySegment dest) { return storeInt(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code int},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeInt(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address, converting each element to {@code int}.
     * No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Long2 storeIntUnsafe(long address);

    /** {@return whether all components of this vector are finite} Integer components always are, so this always returns {@code true}. */
    boolean isFinite();

    /**
     * Compare this vector component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the vector to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(Long2R other, long epsilon);

    /** Backs {@code ZERO()}: defers the shared instance's
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final Long2R ZERO = Joml.long2(0L, 0L);
    }
}
