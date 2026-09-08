package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link Float4x2} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Float4x2Impl implements Float4x2 {

    public float m00;
    public float m10;
    public float m20;
    public float m30;
    public float m01;
    public float m11;
    public float m21;
    public float m31;
    static final Float4x2SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4x2SegOpsUnsafe()
                    : new Float4x2SegOpsMS();
    static final Float4x2BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4x2BbOpsUnsafe()
                    : new Float4x2BbOpsApi();
    static final Float4x2RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4x2RawOpsUnsafe()
                    : new Float4x2RawOpsApi();

    public Float4x2Impl() {
        m00 = 1;
        m11 = 1;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Float4 getColumn(int col, @Mutated Float4 dest) {
        Float4Impl d = (Float4Impl) dest;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (col) {
            case 0: _idxSw0 = this.m00; _idxSw1 = this.m10; _idxSw2 = this.m20; _idxSw3 = this.m30; break;
            case 1: _idxSw0 = this.m01; _idxSw1 = this.m11; _idxSw2 = this.m21; _idxSw3 = this.m31; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        d.w = _idxSw3;
        return d;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double4 getColumn(int col, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        float _idxSw4;
        float _idxSw5;
        float _idxSw6;
        float _idxSw7;
        switch (col) {
            case 0: _idxSw4 = this.m00; _idxSw5 = this.m10; _idxSw6 = this.m20; _idxSw7 = this.m30; break;
            case 1: _idxSw4 = this.m01; _idxSw5 = this.m11; _idxSw6 = this.m21; _idxSw7 = this.m31; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw4;
        d.y = _idxSw5;
        d.z = _idxSw6;
        d.w = _idxSw7;
        return d;
    }


    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Float2 getRow(int row, @Mutated Float2 dest) {
        Float2Impl d = (Float2Impl) dest;
        float _idxSw0;
        float _idxSw1;
        switch (row) {
            case 0: _idxSw0 = this.m00; _idxSw1 = this.m01; break;
            case 1: _idxSw0 = this.m10; _idxSw1 = this.m11; break;
            case 2: _idxSw0 = this.m20; _idxSw1 = this.m21; break;
            case 3: _idxSw0 = this.m30; _idxSw1 = this.m31; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        return d;
    }


    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Double2 getRow(int row, @Mutated Double2 dest) {
        Double2Impl d = (Double2Impl) dest;
        float _idxSw2;
        float _idxSw3;
        switch (row) {
            case 0: _idxSw2 = this.m00; _idxSw3 = this.m01; break;
            case 1: _idxSw2 = this.m10; _idxSw3 = this.m11; break;
            case 2: _idxSw2 = this.m20; _idxSw3 = this.m21; break;
            case 3: _idxSw2 = this.m30; _idxSw3 = this.m31; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw2;
        d.y = _idxSw3;
        return d;
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public float frobeniusNorm() {
        return (float) Math.sqrt(this.m00 * this.m00 + this.m01 * this.m01 + (this.m10 * this.m10 + this.m11 * this.m11) + (this.m20 * this.m20 + this.m21 * this.m21 + (this.m30 * this.m30 + this.m31 * this.m31)));
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float2x4 transpose(@Mutated Float2x4 dest) {
        Float2x4Impl d = (Float2x4Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m10;
        d.m02 = this.m20;
        float _buf1 = this.m30;
        d.m10 = this.m01;
        float _buf2 = this.m11;
        d.m12 = this.m21;
        d.m13 = this.m31;
        d.m01 = _buf0;
        d.m03 = _buf1;
        d.m11 = _buf2;
        return d;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x4 transpose(@Mutated Double2x4 dest) {
        Double2x4Impl d = (Double2x4Impl) dest;
        d.m00 = this.m00;
        float _buf0 = this.m10;
        d.m02 = this.m20;
        float _buf1 = this.m30;
        d.m10 = this.m01;
        float _buf2 = this.m11;
        d.m12 = this.m21;
        d.m13 = this.m31;
        d.m01 = _buf0;
        d.m03 = _buf1;
        d.m11 = _buf2;
        return d;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 add(Float4x2R other, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = other.m00() + this.m00;
        d.m10 = other.m10() + this.m10;
        d.m20 = other.m20() + this.m20;
        d.m30 = other.m30() + this.m30;
        d.m01 = other.m01() + this.m01;
        d.m11 = other.m11() + this.m11;
        d.m21 = other.m21() + this.m21;
        d.m31 = other.m31() + this.m31;
        return d;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 add(Float4x2R other, @Mutated Double4x2 dest) {
        return add(other.m00(), other.m01(), other.m10(), other.m11(), other.m20(), other.m21(), other.m30(), other.m31(), dest);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21},
     * {@code m30}, {@code m31}) to this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 add(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = m00 + this.m00;
        d.m10 = m10 + this.m10;
        d.m20 = m20 + this.m20;
        d.m30 = m30 + this.m30;
        d.m01 = m01 + this.m01;
        d.m11 = m11 + this.m11;
        d.m21 = m21 + this.m21;
        d.m31 = m31 + this.m31;
        return d;
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21},
     * {@code m30}, {@code m31}) to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 add(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, @Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        d.m00 = m00 + this.m00;
        d.m10 = m10 + this.m10;
        d.m20 = m20 + this.m20;
        d.m30 = m30 + this.m30;
        d.m01 = m01 + this.m01;
        d.m11 = m11 + this.m11;
        d.m21 = m21 + this.m21;
        d.m31 = m31 + this.m31;
        return d;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 negate(@Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m30 = -this.m30;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m31 = -this.m31;
        return d;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 negate(@Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m30 = -this.m30;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m31 = -this.m31;
        return d;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 sub(Float4x2R other, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = this.m00 - other.m00();
        d.m10 = this.m10 - other.m10();
        d.m20 = this.m20 - other.m20();
        d.m30 = this.m30 - other.m30();
        d.m01 = this.m01 - other.m01();
        d.m11 = this.m11 - other.m11();
        d.m21 = this.m21 - other.m21();
        d.m31 = this.m31 - other.m31();
        return d;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 sub(Float4x2R other, @Mutated Double4x2 dest) {
        return sub(other.m00(), other.m01(), other.m10(), other.m11(), other.m20(), other.m21(), other.m30(), other.m31(), dest);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21},
     * {@code m30}, {@code m31}) from this matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 sub(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = this.m00 - m00;
        d.m10 = this.m10 - m10;
        d.m20 = this.m20 - m20;
        d.m30 = this.m30 - m30;
        d.m01 = this.m01 - m01;
        d.m11 = this.m11 - m11;
        d.m21 = this.m21 - m21;
        d.m31 = this.m31 - m31;
        return d;
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m10}, {@code m11}, {@code m20}, {@code m21},
     * {@code m30}, {@code m31}) from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 sub(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, @Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        d.m00 = this.m00 - m00;
        d.m10 = this.m10 - m10;
        d.m20 = this.m20 - m20;
        d.m30 = this.m30 - m30;
        d.m01 = this.m01 - m01;
        d.m11 = this.m11 - m11;
        d.m21 = this.m21 - m21;
        d.m31 = this.m31 - m31;
        return d;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Float4x2 set(Float4x2R v) {
        this.m00 = v.m00();
        this.m10 = v.m10();
        this.m20 = v.m20();
        this.m30 = v.m30();
        this.m01 = v.m01();
        this.m11 = v.m11();
        this.m21 = v.m21();
        this.m31 = v.m31();
        return this;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @return this
     */
    @Mutated public Float4x2 set(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31) {
        this.m00 = m00;
        this.m10 = m10;
        this.m20 = m20;
        this.m30 = m30;
        this.m01 = m01;
        this.m11 = m11;
        this.m21 = m21;
        this.m31 = m31;
        return this;
    }


    /**
     * Convert this matrix to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 toDouble(@Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        d.m00 = this.m00;
        d.m10 = this.m10;
        d.m20 = this.m20;
        d.m30 = this.m30;
        d.m01 = this.m01;
        d.m11 = this.m11;
        d.m21 = this.m21;
        d.m31 = this.m31;
        return d;
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Float4x2 makeIdentity() {
        this.m00 = 1.0f;
        this.m10 = 0.0f;
        this.m20 = 0.0f;
        this.m30 = 0.0f;
        this.m01 = 0.0f;
        this.m11 = 1.0f;
        this.m21 = 0.0f;
        this.m31 = 0.0f;
        return this;
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 lerp(Float4x2R other, float t, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = t * (other.m00() - this.m00) + this.m00;
        d.m10 = t * (other.m10() - this.m10) + this.m10;
        d.m20 = t * (other.m20() - this.m20) + this.m20;
        d.m30 = t * (other.m30() - this.m30) + this.m30;
        d.m01 = t * (other.m01() - this.m01) + this.m01;
        d.m11 = t * (other.m11() - this.m11) + this.m11;
        d.m21 = t * (other.m21() - this.m21) + this.m21;
        d.m31 = t * (other.m31() - this.m31) + this.m31;
        return d;
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 lerp(Float4x2R other, float t, @Mutated Double4x2 dest) {
        return lerp(other.m00(), other.m01(), other.m10(), other.m11(), other.m20(), other.m21(), other.m30(), other.m31(), t, dest);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}, {@code m20}, {@code m21}, {@code m30}, {@code m31}) using the interpolation
     * factor {@code t} and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Float4x2 lerp(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, float t, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        d.m00 = t * (m00 - this.m00) + this.m00;
        d.m10 = t * (m10 - this.m10) + this.m10;
        d.m20 = t * (m20 - this.m20) + this.m20;
        d.m30 = t * (m30 - this.m30) + this.m30;
        d.m01 = t * (m01 - this.m01) + this.m01;
        d.m11 = t * (m11 - this.m11) + this.m11;
        d.m21 = t * (m21 - this.m21) + this.m21;
        d.m31 = t * (m31 - this.m31) + this.m31;
        return d;
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m10},
     * {@code m11}, {@code m20}, {@code m21}, {@code m30}, {@code m31}) using the interpolation
     * factor {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 lerp(float m00, float m01, float m10, float m11, float m20, float m21, float m30, float m31, float t, @Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        d.m00 = t * (m00 - this.m00) + this.m00;
        d.m10 = t * (m10 - this.m10) + this.m10;
        d.m20 = t * (m20 - this.m20) + this.m20;
        d.m30 = t * (m30 - this.m30) + this.m30;
        d.m01 = t * (m01 - this.m01) + this.m01;
        d.m11 = t * (m11 - this.m11) + this.m11;
        d.m21 = t * (m21 - this.m21) + this.m21;
        d.m31 = t * (m31 - this.m31) + this.m31;
        return d;
    }


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
    public Float4x2 mul(Float2x2R right, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        float _buf0 = right.m00() * this.m00 + right.m10() * this.m01;
        float _buf1 = right.m00() * this.m10 + right.m10() * this.m11;
        float _buf2 = right.m00() * this.m20 + right.m10() * this.m21;
        float _buf3 = right.m00() * this.m30 + right.m10() * this.m31;
        d.m01 = right.m01() * this.m00 + right.m11() * this.m01;
        d.m11 = right.m01() * this.m10 + right.m11() * this.m11;
        d.m21 = right.m01() * this.m20 + right.m11() * this.m21;
        d.m31 = right.m01() * this.m30 + right.m11() * this.m31;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m30 = _buf3;
        return d;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 mul(Float2x2R right, @Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        float _buf0 = right.m00() * this.m00 + right.m10() * this.m01;
        float _buf1 = right.m00() * this.m10 + right.m10() * this.m11;
        float _buf2 = right.m00() * this.m20 + right.m10() * this.m21;
        float _buf3 = right.m00() * this.m30 + right.m10() * this.m31;
        d.m01 = right.m01() * this.m00 + right.m11() * this.m01;
        d.m11 = right.m01() * this.m10 + right.m11() * this.m11;
        d.m21 = right.m01() * this.m20 + right.m11() * this.m21;
        d.m31 = right.m01() * this.m30 + right.m11() * this.m31;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m30 = _buf3;
        return d;
    }


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
    public Float4x2 preMul(Float4x4R other, @Mutated Float4x2 dest) {
        Float4x2Impl d = (Float4x2Impl) dest;
        float _buf0 = other.m00() * this.m00 + other.m01() * this.m10 + other.m02() * this.m20 + other.m03() * this.m30;
        float _buf1 = other.m10() * this.m00 + other.m11() * this.m10 + other.m12() * this.m20 + other.m13() * this.m30;
        float _buf2 = other.m20() * this.m00 + other.m21() * this.m10 + other.m22() * this.m20 + other.m23() * this.m30;
        d.m30 = other.m30() * this.m00 + other.m31() * this.m10 + other.m32() * this.m20 + other.m33() * this.m30;
        float _buf3 = other.m00() * this.m01 + other.m01() * this.m11 + other.m02() * this.m21 + other.m03() * this.m31;
        float _buf4 = other.m10() * this.m01 + other.m11() * this.m11 + other.m12() * this.m21 + other.m13() * this.m31;
        float _buf5 = other.m20() * this.m01 + other.m21() * this.m11 + other.m22() * this.m21 + other.m23() * this.m31;
        d.m31 = other.m30() * this.m01 + other.m31() * this.m11 + other.m32() * this.m21 + other.m33() * this.m31;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        return d;
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x2 preMul(Float4x4R other, @Mutated Double4x2 dest) {
        Double4x2Impl d = (Double4x2Impl) dest;
        float _buf0 = other.m00() * this.m00 + other.m01() * this.m10 + other.m02() * this.m20 + other.m03() * this.m30;
        float _buf1 = other.m10() * this.m00 + other.m11() * this.m10 + other.m12() * this.m20 + other.m13() * this.m30;
        float _buf2 = other.m20() * this.m00 + other.m21() * this.m10 + other.m22() * this.m20 + other.m23() * this.m30;
        d.m30 = other.m30() * this.m00 + other.m31() * this.m10 + other.m32() * this.m20 + other.m33() * this.m30;
        float _buf3 = other.m00() * this.m01 + other.m01() * this.m11 + other.m02() * this.m21 + other.m03() * this.m31;
        float _buf4 = other.m10() * this.m01 + other.m11() * this.m11 + other.m12() * this.m21 + other.m13() * this.m31;
        float _buf5 = other.m20() * this.m01 + other.m21() * this.m11 + other.m22() * this.m21 + other.m23() * this.m31;
        d.m31 = other.m30() * this.m01 + other.m31() * this.m11 + other.m32() * this.m21 + other.m33() * this.m31;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float4 mul(Float2R v, @Mutated Float4 dest) {
        return mul(v.x(), v.y(), dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(Float2R v, @Mutated Double4 dest) {
        return mul(v.x(), v.y(), dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Float4 mul(float vX, float vY, @Mutated Float4 dest) {
        Float4Impl d = (Float4Impl) dest;
        d.x = this.m00 * vX + this.m01 * vY;
        d.y = this.m10 * vX + this.m11 * vY;
        d.z = this.m20 * vX + this.m21 * vY;
        d.w = this.m30 * vX + this.m31 * vY;
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(float vX, float vY, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.m00 * vX + this.m01 * vY;
        d.y = this.m10 * vX + this.m11 * vY;
        d.z = this.m20 * vX + this.m21 * vY;
        d.w = this.m30 * vX + this.m31 * vY;
        return d;
    }

    public float m00() { return this.m00; }
    public float m01() { return this.m01; }
    public float m10() { return this.m10; }
    public float m11() { return this.m11; }
    public float m20() { return this.m20; }
    public float m21() { return this.m21; }
    public float m30() { return this.m30; }
    public float m31() { return this.m31; }

    @Override public String toString() {
        return "Float4x2(\n    " + m00() + ", " + m01() + "\n    " + m10() + ", " + m11() + "\n    " + m20() + ", " + m21() + "\n    " + m30() + ", " + m31() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float4x2Impl)) return false;
        Float4x2Impl o = (Float4x2Impl) obj;
        return Float.floatToIntBits(m00) == Float.floatToIntBits(o.m00)
            && Float.floatToIntBits(m01) == Float.floatToIntBits(o.m01)
            && Float.floatToIntBits(m10) == Float.floatToIntBits(o.m10)
            && Float.floatToIntBits(m11) == Float.floatToIntBits(o.m11)
            && Float.floatToIntBits(m20) == Float.floatToIntBits(o.m20)
            && Float.floatToIntBits(m21) == Float.floatToIntBits(o.m21)
            && Float.floatToIntBits(m30) == Float.floatToIntBits(o.m30)
            && Float.floatToIntBits(m31) == Float.floatToIntBits(o.m31);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(m00);
        h = 31 * h + Float.floatToIntBits(m01);
        h = 31 * h + Float.floatToIntBits(m10);
        h = 31 * h + Float.floatToIntBits(m11);
        h = 31 * h + Float.floatToIntBits(m20);
        h = 31 * h + Float.floatToIntBits(m21);
        h = 31 * h + Float.floatToIntBits(m30);
        h = 31 * h + Float.floatToIntBits(m31);
        return h;
    }

    @Override public boolean isFinite() {
        return Float.isFinite(m00)
            && Float.isFinite(m01)
            && Float.isFinite(m10)
            && Float.isFinite(m11)
            && Float.isFinite(m20)
            && Float.isFinite(m21)
            && Float.isFinite(m30)
            && Float.isFinite(m31);
    }

    @Override public boolean equalsEpsilon(Float4x2R other, float epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m30 - other.m30()) <= epsilon
            && Math.abs(m31 - other.m31()) <= epsilon;
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m30;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadCM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[offset + 4];
        this.m11 = src[offset + 5];
        this.m21 = src[offset + 6];
        this.m31 = src[offset + 7];
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float4x2 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Float4x2 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Float4x2 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Float4x2 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM(this, offset, dest);
    }
    public Float4x2 loadCM(long offset, MemorySegment src) {
        return SEG_OPS.loadCM(this, offset, src);
    }

    public double[] storeCM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m30;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadCM(double[] src, int offset) {
        this.m00 = (float) src[offset + 0];
        this.m10 = (float) src[offset + 1];
        this.m20 = (float) src[offset + 2];
        this.m30 = (float) src[offset + 3];
        this.m01 = (float) src[offset + 4];
        this.m11 = (float) src[offset + 5];
        this.m21 = (float) src[offset + 6];
        this.m31 = (float) src[offset + 7];
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Float4x2 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf);
    }
    public Float4x2 loadCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf);
    }
    public Float4x2 storeCMDoubleUnsafe(long address) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address);
    }
    @Mutated public Float4x2 loadCMDoubleUnsafe(long address) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address);
    }
    public MemorySegment storeCMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeCMDouble(this, offset, dest);
    }
    public Float4x2 loadCMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadCMDouble(this, offset, src);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m10;
        dest[offset + 3] = this.m11;
        dest[offset + 4] = this.m20;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m30;
        dest[offset + 7] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadRM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m10 = src[offset + 2];
        this.m11 = src[offset + 3];
        this.m20 = src[offset + 4];
        this.m21 = src[offset + 5];
        this.m30 = src[offset + 6];
        this.m31 = src[offset + 7];
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float4x2 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Float4x2 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Float4x2 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Float4x2 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM(this, offset, dest);
    }
    public Float4x2 loadRM(long offset, MemorySegment src) {
        return SEG_OPS.loadRM(this, offset, src);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m10;
        dest[offset + 3] = this.m11;
        dest[offset + 4] = this.m20;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m30;
        dest[offset + 7] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadRM(double[] src, int offset) {
        this.m00 = (float) src[offset + 0];
        this.m01 = (float) src[offset + 1];
        this.m10 = (float) src[offset + 2];
        this.m11 = (float) src[offset + 3];
        this.m20 = (float) src[offset + 4];
        this.m21 = (float) src[offset + 5];
        this.m30 = (float) src[offset + 6];
        this.m31 = (float) src[offset + 7];
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Float4x2 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf);
    }
    public Float4x2 loadRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf);
    }
    public Float4x2 storeRMDoubleUnsafe(long address) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address);
    }
    @Mutated public Float4x2 loadRMDoubleUnsafe(long address) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address);
    }
    public MemorySegment storeRMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeRMDouble(this, offset, dest);
    }
    public Float4x2 loadRMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadRMDouble(this, offset, src);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m30;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p1 + 3] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m31 = src[_p1 + 3];
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float4x2 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Float4x2 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Float4x2 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Float4x2 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }
    public MemorySegment storeCM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCM(this, offset, dest, stride);
    }
    public Float4x2 loadCM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCM(this, offset, src, stride);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m30;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p1 + 3] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        this.m00 = (float) src[offset];
        this.m10 = (float) src[offset + 1];
        this.m20 = (float) src[offset + 2];
        this.m30 = (float) src[offset + 3];
        this.m01 = (float) src[_p1];
        this.m11 = (float) src[_p1 + 1];
        this.m21 = (float) src[_p1 + 2];
        this.m31 = (float) src[_p1 + 3];
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float4x2 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float4x2 loadCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMDoubleAbsolute(this, index, buf, stride);
    }
    public Float4x2 storeCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float4x2 loadCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadCMDoubleUnsafe(this, address, stride);
    }
    public MemorySegment storeCMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCMDouble(this, offset, dest, stride);
    }
    public Float4x2 loadCMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCMDouble(this, offset, src, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p3] = this.m30;
        dest[_p3 + 1] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m30 = src[_p3];
        this.m31 = src[_p3 + 1];
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float4x2 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Float4x2 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Float4x2 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Float4x2 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }
    public MemorySegment storeRM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRM(this, offset, dest, stride);
    }
    public Float4x2 loadRM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRM(this, offset, src, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p3] = this.m30;
        dest[_p3 + 1] = this.m31;
        return dest;
    }
    public @Mutated Float4x2 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = (float) src[offset];
        this.m01 = (float) src[offset + 1];
        this.m10 = (float) src[_p1];
        this.m11 = (float) src[_p1 + 1];
        this.m20 = (float) src[_p2];
        this.m21 = (float) src[_p2 + 1];
        this.m30 = (float) src[_p3];
        this.m31 = (float) src[_p3 + 1];
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Float4x2 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float4x2 loadRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMDoubleAbsolute(this, index, buf, stride);
    }
    public Float4x2 storeRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address, stride);
    }
    @Mutated public Float4x2 loadRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadRMDoubleUnsafe(this, address, stride);
    }
    public MemorySegment storeRMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRMDouble(this, offset, dest, stride);
    }
    public Float4x2 loadRMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRMDouble(this, offset, src, stride);
    }

}
