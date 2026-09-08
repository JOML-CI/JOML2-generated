package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link Double4x3} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Double4x3Impl implements Double4x3 {

    public double m00;
    public double m10;
    public double m20;
    public double m30;
    public double m01;
    public double m11;
    public double m21;
    public double m31;
    public double m02;
    public double m12;
    public double m22;
    public double m32;
    static final Double4x3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double4x3BbOpsUnsafe()
                    : new Double4x3BbOpsApi();
    static final Double4x3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double4x3RawOpsUnsafe()
                    : new Double4x3RawOpsApi();

    public Double4x3Impl() {
        m00 = 1;
        m11 = 1;
        m22 = 1;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double4 getColumn(int col, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        double _idxSw3;
        switch (col) {
            case 0: _idxSw0 = this.m00; _idxSw1 = this.m10; _idxSw2 = this.m20; _idxSw3 = this.m30; break;
            case 1: _idxSw0 = this.m01; _idxSw1 = this.m11; _idxSw2 = this.m21; _idxSw3 = this.m31; break;
            case 2: _idxSw0 = this.m02; _idxSw1 = this.m12; _idxSw2 = this.m22; _idxSw3 = this.m32; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        d.w = _idxSw3;
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
    public Double3 getRow(int row, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (row) {
            case 0: _idxSw0 = this.m00; _idxSw1 = this.m01; _idxSw2 = this.m02; break;
            case 1: _idxSw0 = this.m10; _idxSw1 = this.m11; _idxSw2 = this.m12; break;
            case 2: _idxSw0 = this.m20; _idxSw1 = this.m21; _idxSw2 = this.m22; break;
            case 3: _idxSw0 = this.m30; _idxSw1 = this.m31; _idxSw2 = this.m32; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        d.x = _idxSw0;
        d.y = _idxSw1;
        d.z = _idxSw2;
        return d;
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public double frobeniusNorm() {
        return Math.sqrt(Math.fma(this.m00, this.m00, Math.fma(this.m01, this.m01, this.m02 * this.m02)) + Math.fma(this.m10, this.m10, Math.fma(this.m11, this.m11, this.m12 * this.m12)) + (Math.fma(this.m20, this.m20, Math.fma(this.m21, this.m21, this.m22 * this.m22)) + Math.fma(this.m30, this.m30, Math.fma(this.m31, this.m31, this.m32 * this.m32))));
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 transpose(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        d.m00 = this.m00;
        double _buf0 = this.m10;
        double _buf1 = this.m20;
        d.m03 = this.m30;
        double _buf2 = this.m01;
        double _buf3 = this.m11;
        d.m12 = this.m21;
        d.m13 = this.m31;
        double _buf4 = this.m02;
        d.m21 = this.m12;
        d.m22 = this.m22;
        d.m23 = this.m32;
        d.m01 = _buf0;
        d.m02 = _buf1;
        d.m10 = _buf2;
        d.m11 = _buf3;
        d.m20 = _buf4;
        d.properties = 0;
        return d;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 add(Double4x3R other, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = other.m00() + this.m00;
        d.m10 = other.m10() + this.m10;
        d.m20 = other.m20() + this.m20;
        d.m30 = other.m30() + this.m30;
        d.m01 = other.m01() + this.m01;
        d.m11 = other.m11() + this.m11;
        d.m21 = other.m21() + this.m21;
        d.m31 = other.m31() + this.m31;
        d.m02 = other.m02() + this.m02;
        d.m12 = other.m12() + this.m12;
        d.m22 = other.m22() + this.m22;
        d.m32 = other.m32() + this.m32;
        return d;
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}, {@code m30}, {@code m31}, {@code m32}) to this matrix
     * and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 add(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double m30, double m31, double m32, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = m00 + this.m00;
        d.m10 = m10 + this.m10;
        d.m20 = m20 + this.m20;
        d.m30 = m30 + this.m30;
        d.m01 = m01 + this.m01;
        d.m11 = m11 + this.m11;
        d.m21 = m21 + this.m21;
        d.m31 = m31 + this.m31;
        d.m02 = m02 + this.m02;
        d.m12 = m12 + this.m12;
        d.m22 = m22 + this.m22;
        d.m32 = m32 + this.m32;
        return d;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 negate(@Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = -this.m00;
        d.m10 = -this.m10;
        d.m20 = -this.m20;
        d.m30 = -this.m30;
        d.m01 = -this.m01;
        d.m11 = -this.m11;
        d.m21 = -this.m21;
        d.m31 = -this.m31;
        d.m02 = -this.m02;
        d.m12 = -this.m12;
        d.m22 = -this.m22;
        d.m32 = -this.m32;
        return d;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 sub(Double4x3R other, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = this.m00 - other.m00();
        d.m10 = this.m10 - other.m10();
        d.m20 = this.m20 - other.m20();
        d.m30 = this.m30 - other.m30();
        d.m01 = this.m01 - other.m01();
        d.m11 = this.m11 - other.m11();
        d.m21 = this.m21 - other.m21();
        d.m31 = this.m31 - other.m31();
        d.m02 = this.m02 - other.m02();
        d.m12 = this.m12 - other.m12();
        d.m22 = this.m22 - other.m22();
        d.m32 = this.m32 - other.m32();
        return d;
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}, {@code m30}, {@code m31}, {@code m32}) from this
     * matrix and store the result in {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 sub(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double m30, double m31, double m32, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = this.m00 - m00;
        d.m10 = this.m10 - m10;
        d.m20 = this.m20 - m20;
        d.m30 = this.m30 - m30;
        d.m01 = this.m01 - m01;
        d.m11 = this.m11 - m11;
        d.m21 = this.m21 - m21;
        d.m31 = this.m31 - m31;
        d.m02 = this.m02 - m02;
        d.m12 = this.m12 - m12;
        d.m22 = this.m22 - m22;
        d.m32 = this.m32 - m32;
        return d;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Double4x3 set(Double4x3R v) {
        this.m00 = v.m00();
        this.m10 = v.m10();
        this.m20 = v.m20();
        this.m30 = v.m30();
        this.m01 = v.m01();
        this.m11 = v.m11();
        this.m21 = v.m21();
        this.m31 = v.m31();
        this.m02 = v.m02();
        this.m12 = v.m12();
        this.m22 = v.m22();
        this.m32 = v.m32();
        return this;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @return this
     */
    @Mutated public Double4x3 set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double m30, double m31, double m32) {
        this.m00 = m00;
        this.m10 = m10;
        this.m20 = m20;
        this.m30 = m30;
        this.m01 = m01;
        this.m11 = m11;
        this.m21 = m21;
        this.m31 = m31;
        this.m02 = m02;
        this.m12 = m12;
        this.m22 = m22;
        this.m32 = m32;
        return this;
    }


    /**
     * Convert this matrix to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x3 toFloat(@Mutated Float4x3 dest) {
        Float4x3Impl d = (Float4x3Impl) dest;
        d.m00 = (float) (this.m00);
        d.m10 = (float) (this.m10);
        d.m20 = (float) (this.m20);
        d.m30 = (float) (this.m30);
        d.m01 = (float) (this.m01);
        d.m11 = (float) (this.m11);
        d.m21 = (float) (this.m21);
        d.m31 = (float) (this.m31);
        d.m02 = (float) (this.m02);
        d.m12 = (float) (this.m12);
        d.m22 = (float) (this.m22);
        d.m32 = (float) (this.m32);
        return d;
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Double4x3 makeIdentity() {
        this.m00 = 1.0;
        this.m10 = 0.0;
        this.m20 = 0.0;
        this.m30 = 0.0;
        this.m01 = 0.0;
        this.m11 = 1.0;
        this.m21 = 0.0;
        this.m31 = 0.0;
        this.m02 = 0.0;
        this.m12 = 0.0;
        this.m22 = 1.0;
        this.m32 = 0.0;
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
    public Double4x3 lerp(Double4x3R other, double t, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = Math.fma(t, other.m00() - this.m00, this.m00);
        d.m10 = Math.fma(t, other.m10() - this.m10, this.m10);
        d.m20 = Math.fma(t, other.m20() - this.m20, this.m20);
        d.m30 = Math.fma(t, other.m30() - this.m30, this.m30);
        d.m01 = Math.fma(t, other.m01() - this.m01, this.m01);
        d.m11 = Math.fma(t, other.m11() - this.m11, this.m11);
        d.m21 = Math.fma(t, other.m21() - this.m21, this.m21);
        d.m31 = Math.fma(t, other.m31() - this.m31, this.m31);
        d.m02 = Math.fma(t, other.m02() - this.m02, this.m02);
        d.m12 = Math.fma(t, other.m12() - this.m12, this.m12);
        d.m22 = Math.fma(t, other.m22() - this.m22, this.m22);
        d.m32 = Math.fma(t, other.m32() - this.m32, this.m32);
        return d;
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}, {@code m30},
     * {@code m31}, {@code m32}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double4x3 lerp(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double m30, double m31, double m32, double t, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        d.m00 = Math.fma(t, m00 - this.m00, this.m00);
        d.m10 = Math.fma(t, m10 - this.m10, this.m10);
        d.m20 = Math.fma(t, m20 - this.m20, this.m20);
        d.m30 = Math.fma(t, m30 - this.m30, this.m30);
        d.m01 = Math.fma(t, m01 - this.m01, this.m01);
        d.m11 = Math.fma(t, m11 - this.m11, this.m11);
        d.m21 = Math.fma(t, m21 - this.m21, this.m21);
        d.m31 = Math.fma(t, m31 - this.m31, this.m31);
        d.m02 = Math.fma(t, m02 - this.m02, this.m02);
        d.m12 = Math.fma(t, m12 - this.m12, this.m12);
        d.m22 = Math.fma(t, m22 - this.m22, this.m22);
        d.m32 = Math.fma(t, m32 - this.m32, this.m32);
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
    public Double4x3 mul(Double3x3R right, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        double _buf0 = Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01));
        double _buf1 = Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11));
        double _buf2 = Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21));
        double _buf3 = Math.fma(right.m20(), this.m32, Math.fma(right.m00(), this.m30, right.m10() * this.m31));
        double _buf4 = Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01));
        double _buf5 = Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11));
        double _buf6 = Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21));
        double _buf7 = Math.fma(right.m21(), this.m32, Math.fma(right.m01(), this.m30, right.m11() * this.m31));
        d.m02 = Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01));
        d.m12 = Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11));
        d.m22 = Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21));
        d.m32 = Math.fma(right.m22(), this.m32, Math.fma(right.m02(), this.m30, right.m12() * this.m31));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m30 = _buf3;
        d.m01 = _buf4;
        d.m11 = _buf5;
        d.m21 = _buf6;
        d.m31 = _buf7;
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
    public Double4x3 preMul(Double4x4R other, @Mutated Double4x3 dest) {
        Double4x3Impl d = (Double4x3Impl) dest;
        double _buf0 = Math.fma(other.m03(), this.m30, Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)));
        double _buf1 = Math.fma(other.m13(), this.m30, Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)));
        double _buf2 = Math.fma(other.m23(), this.m30, Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)));
        d.m30 = Math.fma(other.m33(), this.m30, Math.fma(other.m32(), this.m20, Math.fma(other.m30(), this.m00, other.m31() * this.m10)));
        double _buf3 = Math.fma(other.m03(), this.m31, Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)));
        double _buf4 = Math.fma(other.m13(), this.m31, Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)));
        double _buf5 = Math.fma(other.m23(), this.m31, Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)));
        d.m31 = Math.fma(other.m33(), this.m31, Math.fma(other.m32(), this.m21, Math.fma(other.m30(), this.m01, other.m31() * this.m11)));
        double _buf6 = Math.fma(other.m03(), this.m32, Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)));
        double _buf7 = Math.fma(other.m13(), this.m32, Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)));
        double _buf8 = Math.fma(other.m23(), this.m32, Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)));
        d.m32 = Math.fma(other.m33(), this.m32, Math.fma(other.m32(), this.m22, Math.fma(other.m30(), this.m02, other.m31() * this.m12)));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m20 = _buf2;
        d.m01 = _buf3;
        d.m11 = _buf4;
        d.m21 = _buf5;
        d.m02 = _buf6;
        d.m12 = _buf7;
        d.m22 = _buf8;
        return d;
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(Double3R v, @Mutated Double4 dest) {
        return mul(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(double vX, double vY, double vZ, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY));
        d.y = Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY));
        d.z = Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY));
        d.w = Math.fma(this.m32, vZ, Math.fma(this.m30, vX, this.m31 * vY));
        return d;
    }

    public double m00() { return this.m00; }
    public double m01() { return this.m01; }
    public double m02() { return this.m02; }
    public double m10() { return this.m10; }
    public double m11() { return this.m11; }
    public double m12() { return this.m12; }
    public double m20() { return this.m20; }
    public double m21() { return this.m21; }
    public double m22() { return this.m22; }
    public double m30() { return this.m30; }
    public double m31() { return this.m31; }
    public double m32() { return this.m32; }

    @Override public String toString() {
        return "Double4x3(\n    " + m00() + ", " + m01() + ", " + m02() + "\n    " + m10() + ", " + m11() + ", " + m12() + "\n    " + m20() + ", " + m21() + ", " + m22() + "\n    " + m30() + ", " + m31() + ", " + m32() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double4x3Impl)) return false;
        Double4x3Impl o = (Double4x3Impl) obj;
        return Double.doubleToLongBits(m00) == Double.doubleToLongBits(o.m00)
            && Double.doubleToLongBits(m01) == Double.doubleToLongBits(o.m01)
            && Double.doubleToLongBits(m02) == Double.doubleToLongBits(o.m02)
            && Double.doubleToLongBits(m10) == Double.doubleToLongBits(o.m10)
            && Double.doubleToLongBits(m11) == Double.doubleToLongBits(o.m11)
            && Double.doubleToLongBits(m12) == Double.doubleToLongBits(o.m12)
            && Double.doubleToLongBits(m20) == Double.doubleToLongBits(o.m20)
            && Double.doubleToLongBits(m21) == Double.doubleToLongBits(o.m21)
            && Double.doubleToLongBits(m22) == Double.doubleToLongBits(o.m22)
            && Double.doubleToLongBits(m30) == Double.doubleToLongBits(o.m30)
            && Double.doubleToLongBits(m31) == Double.doubleToLongBits(o.m31)
            && Double.doubleToLongBits(m32) == Double.doubleToLongBits(o.m32);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(m00) ^ (Double.doubleToLongBits(m00) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m01) ^ (Double.doubleToLongBits(m01) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m02) ^ (Double.doubleToLongBits(m02) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m10) ^ (Double.doubleToLongBits(m10) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m11) ^ (Double.doubleToLongBits(m11) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m12) ^ (Double.doubleToLongBits(m12) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m20) ^ (Double.doubleToLongBits(m20) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m21) ^ (Double.doubleToLongBits(m21) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m22) ^ (Double.doubleToLongBits(m22) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m30) ^ (Double.doubleToLongBits(m30) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m31) ^ (Double.doubleToLongBits(m31) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(m32) ^ (Double.doubleToLongBits(m32) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(m00)
            && Double.isFinite(m01)
            && Double.isFinite(m02)
            && Double.isFinite(m10)
            && Double.isFinite(m11)
            && Double.isFinite(m12)
            && Double.isFinite(m20)
            && Double.isFinite(m21)
            && Double.isFinite(m22)
            && Double.isFinite(m30)
            && Double.isFinite(m31)
            && Double.isFinite(m32);
    }

    @Override public boolean equalsEpsilon(Double4x3R other, double epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m02 - other.m02()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m12 - other.m12()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m22 - other.m22()) <= epsilon
            && Math.abs(m30 - other.m30()) <= epsilon
            && Math.abs(m31 - other.m31()) <= epsilon
            && Math.abs(m32 - other.m32()) <= epsilon;
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
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadCM(double[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[offset + 4];
        this.m11 = src[offset + 5];
        this.m21 = src[offset + 6];
        this.m31 = src[offset + 7];
        this.m02 = src[offset + 8];
        this.m12 = src[offset + 9];
        this.m22 = src[offset + 10];
        this.m32 = src[offset + 11];
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double4x3 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Double4x3 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Double4x3 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Double4x3 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m10;
        dest[offset + 2] = (float) this.m20;
        dest[offset + 3] = (float) this.m30;
        dest[offset + 4] = (float) this.m01;
        dest[offset + 5] = (float) this.m11;
        dest[offset + 6] = (float) this.m21;
        dest[offset + 7] = (float) this.m31;
        dest[offset + 8] = (float) this.m02;
        dest[offset + 9] = (float) this.m12;
        dest[offset + 10] = (float) this.m22;
        dest[offset + 11] = (float) this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadCM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[offset + 4];
        this.m11 = src[offset + 5];
        this.m21 = src[offset + 6];
        this.m31 = src[offset + 7];
        this.m02 = src[offset + 8];
        this.m12 = src[offset + 9];
        this.m22 = src[offset + 10];
        this.m32 = src[offset + 11];
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double4x3 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf);
    }
    public Double4x3 loadCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf);
    }
    public Double4x3 storeCMFloatUnsafe(long address) {
        return RAW_OPS.storeCMFloatUnsafe(this, address);
    }
    @Mutated public Double4x3 loadCMFloatUnsafe(long address) {
        return RAW_OPS.loadCMFloatUnsafe(this, address);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m10;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m12;
        dest[offset + 6] = this.m20;
        dest[offset + 7] = this.m21;
        dest[offset + 8] = this.m22;
        dest[offset + 9] = this.m30;
        dest[offset + 10] = this.m31;
        dest[offset + 11] = this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadRM(double[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m12 = src[offset + 5];
        this.m20 = src[offset + 6];
        this.m21 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.m30 = src[offset + 9];
        this.m31 = src[offset + 10];
        this.m32 = src[offset + 11];
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double4x3 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Double4x3 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Double4x3 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Double4x3 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.m00;
        dest[offset + 1] = (float) this.m01;
        dest[offset + 2] = (float) this.m02;
        dest[offset + 3] = (float) this.m10;
        dest[offset + 4] = (float) this.m11;
        dest[offset + 5] = (float) this.m12;
        dest[offset + 6] = (float) this.m20;
        dest[offset + 7] = (float) this.m21;
        dest[offset + 8] = (float) this.m22;
        dest[offset + 9] = (float) this.m30;
        dest[offset + 10] = (float) this.m31;
        dest[offset + 11] = (float) this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadRM(float[] src, int offset) {
        this.m00 = src[offset + 0];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[offset + 3];
        this.m11 = src[offset + 4];
        this.m12 = src[offset + 5];
        this.m20 = src[offset + 6];
        this.m21 = src[offset + 7];
        this.m22 = src[offset + 8];
        this.m30 = src[offset + 9];
        this.m31 = src[offset + 10];
        this.m32 = src[offset + 11];
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double4x3 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf);
    }
    public Double4x3 loadRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf);
    }
    public Double4x3 storeRMFloatUnsafe(long address) {
        return RAW_OPS.storeRMFloatUnsafe(this, address);
    }
    @Mutated public Double4x3 loadRMFloatUnsafe(long address) {
        return RAW_OPS.loadRMFloatUnsafe(this, address);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m30;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p1 + 3] = this.m31;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        dest[_p2 + 3] = this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m31 = src[_p1 + 3];
        this.m02 = src[_p2];
        this.m12 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m32 = src[_p2 + 3];
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double4x3 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Double4x3 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Double4x3 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Double4x3 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = (float) this.m00;
        dest[offset + 1] = (float) this.m10;
        dest[offset + 2] = (float) this.m20;
        dest[offset + 3] = (float) this.m30;
        dest[_p1] = (float) this.m01;
        dest[_p1 + 1] = (float) this.m11;
        dest[_p1 + 2] = (float) this.m21;
        dest[_p1 + 3] = (float) this.m31;
        dest[_p2] = (float) this.m02;
        dest[_p2 + 1] = (float) this.m12;
        dest[_p2 + 2] = (float) this.m22;
        dest[_p2 + 3] = (float) this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.m00 = src[offset];
        this.m10 = src[offset + 1];
        this.m20 = src[offset + 2];
        this.m30 = src[offset + 3];
        this.m01 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m21 = src[_p1 + 2];
        this.m31 = src[_p1 + 3];
        this.m02 = src[_p2];
        this.m12 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m32 = src[_p2 + 3];
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double4x3 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf, stride);
    }
    public Double4x3 loadCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf, stride);
    }
    public Double4x3 storeCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeCMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double4x3 loadCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadCMFloatUnsafe(this, address, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        dest[_p3] = this.m30;
        dest[_p3 + 1] = this.m31;
        dest[_p3 + 2] = this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m12 = src[_p1 + 2];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m30 = src[_p3];
        this.m31 = src[_p3 + 1];
        this.m32 = src[_p3 + 2];
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double4x3 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Double4x3 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Double4x3 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Double4x3 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        dest[offset] = (float) this.m00;
        dest[offset + 1] = (float) this.m01;
        dest[offset + 2] = (float) this.m02;
        dest[_p1] = (float) this.m10;
        dest[_p1 + 1] = (float) this.m11;
        dest[_p1 + 2] = (float) this.m12;
        dest[_p2] = (float) this.m20;
        dest[_p2 + 1] = (float) this.m21;
        dest[_p2 + 2] = (float) this.m22;
        dest[_p3] = (float) this.m30;
        dest[_p3 + 1] = (float) this.m31;
        dest[_p3 + 2] = (float) this.m32;
        return dest;
    }
    public @Mutated Double4x3 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        this.m00 = src[offset];
        this.m01 = src[offset + 1];
        this.m02 = src[offset + 2];
        this.m10 = src[_p1];
        this.m11 = src[_p1 + 1];
        this.m12 = src[_p1 + 2];
        this.m20 = src[_p2];
        this.m21 = src[_p2 + 1];
        this.m22 = src[_p2 + 2];
        this.m30 = src[_p3];
        this.m31 = src[_p3 + 1];
        this.m32 = src[_p3 + 2];
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double4x3 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf, stride);
    }
    public Double4x3 loadRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf, stride);
    }
    public Double4x3 storeRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeRMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double4x3 loadRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadRMFloatUnsafe(this, address, stride);
    }

}
