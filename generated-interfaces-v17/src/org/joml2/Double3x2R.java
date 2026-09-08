package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * Read-only view of a 3x2 matrix of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link Double3x2}. APIs that only read a 3x2
 * matrix should accept {@code Double3x2R}, so callers can pass mutable instances without exposing
 * them to modification.
 */
public interface Double3x2R {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 48;

    /** The number of rows - the tight stride of the column-major ({@code storeCM}/{@code loadCM}) strided overloads. */
    public static final int ROWS = 3;
    /** The number of columns - the tight stride of the row-major ({@code storeRM}/{@code loadRM}) strided overloads. */
    public static final int COLUMNS = 2;

    /** {@return a shared identity matrix} Never mutate it - it is returned as the read-only view for that reason. */
    public static Double3x2R IDENTITY() { return Holder.IDENTITY; }
    /** {@return a shared all-zero matrix} Never mutate it - it is returned as the read-only view for that reason. */
    public static Double3x2R ZERO() { return Holder.ZERO; }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    Double3 getColumn(int col, @Mutated Double3 dest);

    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    Double2 getRow(int row, @Mutated Double2 dest);

    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    double frobeniusNorm();

    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2x3 transpose(@Mutated Double2x3 dest);

    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 add(Double3x2R other, @Mutated Double3x2 dest);

    /**
     * Add ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21}) to this
     * matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 add(double m00, double m01, double m10, double m11, double m20, double m21, @Mutated Double3x2 dest);

    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 negate(@Mutated Double3x2 dest);

    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 sub(Double3x2R other, @Mutated Double3x2 dest);

    /**
     * Subtract ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21}) from
     * this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 sub(double m00, double m01, double m10, double m11, double m20, double m21, @Mutated Double3x2 dest);

    /**
     * Convert this matrix to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3x2 toFloat(@Mutated Float3x2 dest);

    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 lerp(Double3x2R other, double t, @Mutated Double3x2 dest);

    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}, {@code m20}, {@code m21}) using the interpolation factor {@code t} and store the
     * result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 lerp(double m00, double m01, double m10, double m11, double m20, double m21, double t, @Mutated Double3x2 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 mul(Double2x2R right, @Mutated Double3x2 dest);

    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3x2 preMul(Double3x3R other, @Mutated Double3x2 dest);

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 mul(Double2R v, @Mutated Double3 dest);

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 mul(double x, double y, @Mutated Double3 dest);
    /** {@return the value of the {@code m00} element} */
    double m00();
    /** {@return the value of the {@code m01} element} */
    double m01();
    /** {@return the value of the {@code m10} element} */
    double m10();
    /** {@return the value of the {@code m11} element} */
    double m11();
    /** {@return the value of the {@code m20} element} */
    double m20();
    /** {@return the value of the {@code m21} element} */
    double m21();

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] storeCM(@Mutated double[] dest) { return storeCM(dest, 0); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    double[] storeCM(@Mutated double[] dest, int offset);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeCM(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeCMAbsolute(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeCMRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 6);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCM(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCMAbsolute(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeCMAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCMRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 48);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3x2 storeCMUnsafe(long address);

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] storeCM(@Mutated float[] dest) { return storeCM(dest, 0); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    float[] storeCM(@Mutated float[] dest, int offset);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeCM(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeCMAbsolute(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeCMRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 6);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCMFloat(@Mutated ByteBuffer dest) { return storeCMFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCMFloatAbsolute(@Mutated ByteBuffer dest) { return storeCMFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at the given absolute index (the position is not used or
     * modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeCMFloatAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeCMFloatRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeCMFloatAbsolute(pos, dest);
        dest.position(pos + 24);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3x2 storeCMFloatUnsafe(long address);

    /**
     * Store the elements into the given array in row-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] storeRM(@Mutated double[] dest) { return storeRM(dest, 0); }

    /**
     * Store the elements into the given array in row-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    double[] storeRM(@Mutated double[] dest, int offset);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRM(@Mutated DoubleBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRMAbsolute(@Mutated DoubleBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRMRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 6);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRM(@Mutated ByteBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRMAbsolute(@Mutated ByteBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeRMAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRMRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 48);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in row-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3x2 storeRMUnsafe(long address);

    /**
     * Store the elements into the given array in row-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] storeRM(@Mutated float[] dest) { return storeRM(dest, 0); }

    /**
     * Store the elements into the given array in row-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    float[] storeRM(@Mutated float[] dest, int offset);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRM(@Mutated FloatBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRMAbsolute(@Mutated FloatBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRMRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 6);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRMFloat(@Mutated ByteBuffer dest) { return storeRMFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRMFloatAbsolute(@Mutated ByteBuffer dest) { return storeRMFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeRMFloatAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRMFloatRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeRMFloatAbsolute(pos, dest);
        dest.position(pos + 24);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3x2 storeRMFloatUnsafe(long address);

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    double[] storeCM(@Mutated double[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeCM(@Mutated DoubleBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeCMRelative(@Mutated DoubleBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + 2 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCM(@Mutated ByteBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeCMAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + (2 * stride) * 8);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Double3x2 storeCMUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    float[] storeCM(@Mutated float[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeCM(@Mutated FloatBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeCMRelative(@Mutated FloatBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + 2 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMFloat(@Mutated ByteBuffer dest, int stride) { return storeCMFloatAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeCMFloatAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code float}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMFloatRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeCMFloatAbsolute(pos, dest, stride);
        dest.position(pos + (2 * stride) * 4);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code float}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Double3x2 storeCMFloatUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in row-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    double[] storeRM(@Mutated double[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRM(@Mutated DoubleBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRMRelative(@Mutated DoubleBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + 3 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRM(@Mutated ByteBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeRMAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + (3 * stride) * 8);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Double3x2 storeRMUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in row-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    float[] storeRM(@Mutated float[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRM(@Mutated FloatBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRMRelative(@Mutated FloatBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + 3 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMFloat(@Mutated ByteBuffer dest, int stride) { return storeRMFloatAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeRMFloatAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code float}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMFloatRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeRMFloatAbsolute(pos, dest, stride);
        dest.position(pos + (3 * stride) * 4);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code float}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Double3x2 storeRMFloatUnsafe(long address, int stride);

    /** {@return whether all components of this matrix are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this matrix component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the matrix to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(Double3x2R other, double epsilon);

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] store(@Mutated double[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    default double[] store(@Mutated double[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer store(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer store(int index, @Mutated DoubleBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code float}.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] store(@Mutated float[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code float}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    default float[] store(@Mutated float[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code float}, starting at its current position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer store(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code float}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer store(int index, @Mutated FloatBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code float}, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer store(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer store(int index, @Mutated ByteBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    default Double3x2 storeUnsafe(long address) { return storeCMUnsafe(address); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default double[] store(@Mutated double[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code float}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default float[] store(@Mutated float[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer store(int index, @Mutated DoubleBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code float}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer store(int index, @Mutated FloatBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code float}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer store(int index, @Mutated ByteBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    default Double3x2 storeUnsafe(long address, int stride) { return storeCMUnsafe(address, stride); }

    /** Backs {@code ZERO()} and {@code IDENTITY()}: defers the shared instances'
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final Double3x2R IDENTITY = Joml.double3x2();
        static final Double3x2R ZERO = Joml.double3x2(0, 0, 0, 0, 0, 0);
    }
}
