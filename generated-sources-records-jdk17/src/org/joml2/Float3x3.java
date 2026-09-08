package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable 3x3 matrix of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param m00 the element in row 0, column 0
 * @param m01 the element in row 0, column 1
 * @param m02 the element in row 0, column 2
 * @param m10 the element in row 1, column 0
 * @param m11 the element in row 1, column 1
 * @param m12 the element in row 1, column 2
 * @param m20 the element in row 2, column 0
 * @param m21 the element in row 2, column 1
 * @param m22 the element in row 2, column 2
 * @param properties the cached structural property bits
 */
public record Float3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, int properties) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 36;

    /** The number of rows - the tight stride of the column-major ({@code storeCM}/{@code loadCM}) strided overloads. */
    public static final int ROWS = 3;
    /** The number of columns - the tight stride of the row-major ({@code storeRM}/{@code loadRM}) strided overloads. */
    public static final int COLUMNS = 3;

    /** The zero matrix (all components 0). */
    public static final Float3x3 ZERO = new Float3x3(0, 0, 0, 0, 0, 0, 0, 0, 0);

    /** The identity matrix. */
    public static final Float3x3 IDENTITY = new Float3x3();

    /** Canonical constructor. */
    public Float3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, int properties) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.properties = properties;
    }

    /**
     * Create a new instance initialized to the identity.
     */
    public Float3x3() {
        this(1, 0, 0, 0, 1, 0, 0, 0, 1, Joml.BIT_IDENTITY);
    }

    /** Create a matrix from the given elements, computing the cached property bits. */
    public Float3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this(m00, m01, m02, m10, m11, m12, m20, m21, m22, props(m00, m01, m02, m10, m11, m12, m20, m21, m22));
    }

    /** Create a matrix from the given column vectors. */
    public Float3x3(Float3 c0, Float3 c1, Float3 c2) {
        this(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z());
    }

    /** Create a matrix from the given column vectors and precomputed property bits (no recomputation). */
    public Float3x3(Float3 c0, Float3 c1, Float3 c2, int properties) {
        this(c0.x(), c1.x(), c2.x(), c0.y(), c1.y(), c2.y(), c0.z(), c1.z(), c2.z(), properties);
    }

    /** Create a matrix by identity-extending {@code src} to this square shape. */
    public Float3x3(Float2x3 src) {
        this(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), 0, 0, 1);
    }

    /** Create a matrix by truncating {@code src} to the overlapping cells. */
    public Float3x3(Float4x4 src) {
        this(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22());
    }

    /** Create a matrix by truncating {@code src} to the overlapping cells. */
    public Float3x3(Float3x4 src) {
        this(src.m00(), src.m01(), src.m02(), src.m10(), src.m11(), src.m12(), src.m20(), src.m21(), src.m22());
    }

    /** Create a matrix by identity-extending {@code src} to this square shape. */
    public Float3x3(Float2x2 src) {
        this(src.m00(), src.m01(), 0, src.m10(), src.m11(), 0, 0, 0, 1);
    }

    /** {@return the element in row 0, column 0} */
    public float m00() { return m00; }
    /** {@return the element in row 0, column 1} */
    public float m01() { return m01; }
    /** {@return the element in row 0, column 2} */
    public float m02() { return m02; }
    /** {@return the element in row 1, column 0} */
    public float m10() { return m10; }
    /** {@return the element in row 1, column 1} */
    public float m11() { return m11; }
    /** {@return the element in row 1, column 2} */
    public float m12() { return m12; }
    /** {@return the element in row 2, column 0} */
    public float m20() { return m20; }
    /** {@return the element in row 2, column 1} */
    public float m21() { return m21; }
    /** {@return the element in row 2, column 2} */
    public float m22() { return m22; }
    /** {@return the cached structural property bits} */
    public int properties() { return properties; }

    private static int props(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        if (m20 != 0 || m21 != 0 || m22 != 1) return 0;
        if (m00 != 1 || m01 != 0 || m10 != 0 || m11 != 1) return 1;
        if (m02 != 0 || m12 != 0) return 7;
        return 15;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits. This is a pure query.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.m20 != 0 || this.m21 != 0 || this.m22 != 1) return 0;
        if (this.m00 != 1 || this.m01 != 0 || this.m10 != 0 || this.m11 != 1) return 1;
        if (this.m02 != 0 || this.m12 != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal} O(1) read of the cached property bits; conservative. */
    public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is known to be affine} O(1) read of the cached property bits; conservative. */
    public boolean isAffine() { return (this.properties & Joml.BIT_AFFINE) == Joml.BIT_AFFINE; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_identity(int col) {
        return new Float3(switch (col) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_translation(int col) {
        return new Float3(switch (col) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> this.m02; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> this.m12; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_general(int col) {
        return new Float3(switch (col) { case 0 -> this.m00; case 1 -> this.m01; case 2 -> this.m02; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> this.m10; case 1 -> this.m11; case 2 -> this.m12; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> this.m20; case 1 -> this.m21; case 2 -> this.m22; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
    }


    /**
     * Get the column at the given index of this matrix, returning the result as a value.
     *
     * @param col the column index
     * @return the resulting vector
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Float3 getColumn(int col) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getColumn_translation(col);
        return getColumn_general(col);
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_identity() {
        return Float3.ZERO;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_translation() {
        return new Float3(Math.fma(this.m12, this.m12, 1.0f) < Math.fma(this.m12, this.m12, Math.fma(this.m02, this.m02, 1.0f)) * 1.0E-7f ? 0.0f : (float) Math.atan2(-this.m12, 1.0f), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m02))), 0.0f);
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Float3 getEulerAnglesXYZ_general() {
        float _t1 = Math.fma(this.m12, this.m12, this.m22 * this.m22);
        float _t3 = Math.fma(this.m02, this.m02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(this.m21, this.m11), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m02))), 0.0f);
        } else {
            return new Float3((float) Math.atan2(-this.m12, this.m22), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m02))), (float) Math.atan2(-this.m01, this.m00));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXYZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXYZ_translation();
        return getEulerAnglesXYZ_general();
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_translation() {
        if (1.0f < 1.0E-7f) {
            return new Float3((float) Math.atan2(-this.m12, 1.0f), 0.0f, 0.0f);
        } else {
            return new Float3(0.0f, (float) Math.atan2(this.m02, 1.0f), 0.0f);
        }
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Float3 getEulerAnglesXZY_general() {
        float _t1 = Math.fma(this.m11, this.m11, this.m21 * this.m21);
        float _t3 = Math.fma(this.m01, this.m01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(-this.m12, this.m22), 0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m01))));
        } else {
            return new Float3((float) Math.atan2(this.m21, this.m11), (float) Math.atan2(this.m02, this.m00), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m01))));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXZY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXZY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXZY_translation();
        return getEulerAnglesXZY_general();
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_translation() {
        return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m12))), Math.fma(this.m02, this.m02, 1.0f) < Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f)) * 1.0E-7f ? 0.0f : (float) Math.atan2(this.m02, 1.0f), 0.0f);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Float3 getEulerAnglesYXZ_general() {
        float _t1 = Math.fma(this.m02, this.m02, this.m22 * this.m22);
        float _t3 = Math.fma(this.m12, this.m12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m12))), (float) Math.atan2(-this.m20, this.m00), 0.0f);
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m12))), (float) Math.atan2(this.m02, this.m22), (float) Math.atan2(this.m10, this.m11));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYXZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYXZ_translation();
        return getEulerAnglesYXZ_general();
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_translation() {
        float _t0 = Math.fma(this.m12, this.m12, 1.0f);
        float _t1 = _t0 * 1.0E-7f;
        if (_t0 < _t1) {
            return new Float3(0.0f, (float) Math.atan2(this.m02, 1.0f), 0.0f);
        } else {
            return new Float3((float) Math.atan2(-this.m12, 1.0f), 0.0f, 0.0f);
        }
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Float3 getEulerAnglesYZX_general() {
        float _t1 = Math.fma(this.m11, this.m11, this.m12 * this.m12);
        float _t3 = Math.fma(this.m10, this.m10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3(0.0f, (float) Math.atan2(this.m02, this.m22), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m10))));
        } else {
            return new Float3((float) Math.atan2(-this.m12, this.m11), (float) Math.atan2(-this.m20, this.m00), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m10))));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYZX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYZX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYZX_translation();
        return getEulerAnglesYZX_general();
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Float3 getEulerAnglesZXY_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Float3 getEulerAnglesZXY_orthogonal() {
        float _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        return new Float3(0.0f, 0.0f, _t1 < _t1 * 1.0E-7f ? (float) Math.atan2(this.m10, this.m00) : (float) Math.atan2(-this.m01, this.m11));
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Float3 getEulerAnglesZXY_general() {
        float _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        float _t3 = Math.fma(this.m21, this.m21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m21))), 0.0f, (float) Math.atan2(this.m10, this.m00));
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, this.m21))), (float) Math.atan2(-this.m20, this.m22), (float) Math.atan2(-this.m01, this.m11));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZXY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZXY_identity();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getEulerAnglesZXY_orthogonal();
        return getEulerAnglesZXY_general();
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_orthogonal() {
        return new Float3(0.0f, 0.0f, 1.0f < 1.0E-7f ? (float) Math.atan2(-this.m01, this.m11) : (float) Math.atan2(this.m10, this.m00));
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Float3 getEulerAnglesZYX_general() {
        float _t1 = Math.fma(this.m21, this.m21, this.m22 * this.m22);
        float _t3 = Math.fma(this.m20, this.m20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3(0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m20))), (float) Math.atan2(-this.m01, this.m11));
        } else {
            return new Float3((float) Math.atan2(this.m21, this.m22), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, -this.m20))), (float) Math.atan2(this.m10, this.m00));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZYX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZYX_identity();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getEulerAnglesZYX_orthogonal();
        return getEulerAnglesZYX_general();
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_identity() {
        return new FloatQuat(0.0f, 0.0f, 0.0f, 1.0f);
    }

    /** Private tail of {@code getNormalizedRotation_translation}; reached only through it. */
    private FloatQuat getNormalizedRotation_translation_s0_tail(float _t20, float _t13, float _t21, float _t8, float _t10, float _t6, float _t18, float _t5, float _t22, float _t9, float _t23, float _t19, float _t17) {
        float _t24 = (1.0f / (float) Math.sqrt(_t20));
        if (_t13 > 0.0f) {
            return new FloatQuat(-(0.5f * _t21 * _t8), 0.5f * _t21 * _t9, 0.0f, 0.5f * (float) Math.sqrt(_t17));
        } else {
            if (_t10 > _t6) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t18), 0.0f, 0.5f * _t23 * _t9, -(0.5f * _t23 * _t8));
            } else {
                if (1.0f > _t5) {
                    return new FloatQuat(0.0f, 0.5f * (float) Math.sqrt(_t20), 0.5f * _t24 * _t8, 0.5f * _t24 * _t9);
                } else {
                    return new FloatQuat(0.5f * _t22 * _t9, 0.5f * _t22 * _t8, 0.5f * (float) Math.sqrt(_t19), 0.0f);
                }
            }
        }
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_translation() {
        float _t1 = Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f));
        float _t2 = (1.0f / (float) Math.sqrt(_t1));
        float _t5, _t8, _t9;
        if (_t1 > 0.0f) {
            _t5 = _t2;
            _t8 = this.m12 * _t2;
            _t9 = this.m02 * _t2;
        } else {
            _t5 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t6 = Math.max(1.0f, _t5);
        float _t10 = _t5 < 0.0f ? -1.0f : 1.0f;
        float _t11 = 1.0f + _t10;
        float _t13 = _t11 + _t5;
        float _t17 = 1.0f + _t13;
        float _t18 = 1.0f + (_t10 - (1.0f + _t5));
        float _t19 = 1.0f + (_t5 - _t11);
        float _t20 = 1.0f + (1.0f - (_t10 + _t5));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t19));
        float _t23 = (1.0f / (float) Math.sqrt(_t18));
        return getNormalizedRotation_translation_s0_tail(_t20, _t13, _t21, _t8, _t10, _t6, _t18, _t5, _t22, _t9, _t23, _t19, _t17);
    }

    /** Private tail of {@code getNormalizedRotation_general}; reached only through it. */
    private FloatQuat getNormalizedRotation_general_s0_tail(float _t8, float _t11, float _t27, float _t22, float _t23, float _t26, float _t21, float _t24, float _t25) {
        float _t28, _t29;
        if (_t8 > 0.0f) {
            _t28 = this.m00 * _t11;
            _t29 = this.m10 * _t11;
        } else {
            _t28 = 0.0f;
            _t29 = 0.0f;
        }
        float _t36 = _t27 - _t22;
        float _t37 = Math.max(_t23, _t26);
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49, _t50, _t51;
        if (_t48 < 0.0f) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        return getNormalizedRotation_general_s0_tail2(_t64, _t65, _t63, _t58, _t36, _t66, _t49, _t37, _t23, _t26, _t53, _t55, _t56, _t39, _t57, _t62);
    }

    /** Private tail of {@code getNormalizedRotation_general}; reached only through it. */
    private FloatQuat getNormalizedRotation_general_s0_tail2(float _t64, float _t65, float _t63, float _t58, float _t36, float _t66, float _t49, float _t37, float _t23, float _t26, float _t53, float _t55, float _t56, float _t39, float _t57, float _t62) {
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        return getNormalizedRotation_general_s0_tail3(_t58, _t36, _t66, _t49, _t37, _t63, _t23, _t26, _t53, _t67, _t55, _t68, _t56, _t69, _t64, _t39, _t57, _t65, _t62);
    }

    /** Private tail of {@code getNormalizedRotation_general}; reached only through it. */
    private FloatQuat getNormalizedRotation_general_s0_tail3(float _t58, float _t36, float _t66, float _t49, float _t37, float _t63, float _t23, float _t26, float _t53, float _t67, float _t55, float _t68, float _t56, float _t69, float _t64, float _t39, float _t57, float _t65, float _t62) {
        float _sfx0, _sfx1, _sfx2, _sfx3;
        if (_t58 > 0.0f) {
            _sfx0 = 0.5f * _t36 * _t66;
            _sfx1 = 0.5f * _t56 * _t66;
            _sfx2 = 0.5f * _t57 * _t66;
            _sfx3 = 0.5f * (float) Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                _sfx0 = 0.5f * (float) Math.sqrt(_t63);
                _sfx1 = 0.5f * _t53 * _t69;
                _sfx2 = 0.5f * _t55 * _t69;
                _sfx3 = 0.5f * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    _sfx0 = 0.5f * _t53 * _t67;
                    _sfx1 = 0.5f * (float) Math.sqrt(_t64);
                    _sfx2 = 0.5f * _t39 * _t67;
                    _sfx3 = 0.5f * _t56 * _t67;
                } else {
                    _sfx0 = 0.5f * _t55 * _t68;
                    _sfx1 = 0.5f * _t39 * _t68;
                    _sfx2 = 0.5f * (float) Math.sqrt(_t65);
                    _sfx3 = 0.5f * _t57 * _t68;
                }
            }
        }
        return new FloatQuat(_sfx0, _sfx1, _sfx2, _sfx3);
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_general() {
        float _t6 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t7 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t8 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21, _t23, _t27;
        if (_t6 > 0.0f) {
            _t21 = this.m01 * _t9;
            _t23 = this.m11 * _t9;
            _t27 = this.m21 * _t9;
        } else {
            _t21 = 0.0f;
            _t23 = 0.0f;
            _t27 = 0.0f;
        }
        float _t22, _t24, _t26;
        if (_t7 > 0.0f) {
            _t22 = this.m12 * _t10;
            _t24 = this.m02 * _t10;
            _t26 = this.m22 * _t10;
        } else {
            _t22 = 0.0f;
            _t24 = 0.0f;
            _t26 = 0.0f;
        }
        float _t25 = _t8 > 0.0f ? this.m20 * _t11 : 0.0f;
        return getNormalizedRotation_general_s0_tail(_t8, _t11, _t27, _t22, _t23, _t26, _t21, _t24, _t25);
    }


    /**
     * Extract the rotation of this matrix as a unit quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed), returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getNormalizedRotation() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getNormalizedRotation_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getNormalizedRotation_translation();
        return getNormalizedRotation_general();
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_identity(int row) {
        return new Float3(switch (row) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); });
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_translation(int row) {
        return new Float3(switch (row) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m02; case 1 -> this.m12; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); });
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float3 getRow_general(int row) {
        return new Float3(switch (row) { case 0 -> this.m00; case 1 -> this.m10; case 2 -> this.m20; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m01; case 1 -> this.m11; case 2 -> this.m21; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m02; case 1 -> this.m12; case 2 -> this.m22; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); });
    }


    /**
     * Get the row at the given index of this matrix, returning the result as a value.
     *
     * @param row the row index
     * @return the resulting vector
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Float3 getRow(int row) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getRow_translation(row);
        return getRow_general(row);
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_identity() {
        return new Float3(1.0f, 1.0f, 1.0f);
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_translation() {
        return new Float3(1.0f, 1.0f, (float) Math.sqrt(Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f))));
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Float3 getScale_general() {
        return new Float3((float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))), (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))), (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored), returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getScale() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getScale_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getScale_translation();
        return getScale_general();
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float2 getTranslation_identity() {
        return Float2.ZERO;
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float2 getTranslation_general() {
        return new Float2(this.m02, this.m12);
    }


    /**
     * Get the translation of this matrix, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float2 getTranslation() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getTranslation_identity();
        return getTranslation_general();
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_identity() {
        return getNormalizedRotation_identity();
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_translation() {
        return new FloatQuat(-(0.25f * this.m12), 0.25f * this.m02, 0.0f, 1.0f);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_orthogonal() {
        float _t0 = Math.max(this.m11, 1.0f);
        float _t3 = this.m00 + this.m11;
        float _t4 = this.m01 + this.m10;
        float _t5 = this.m10 - this.m01;
        float _t6 = 1.0f + _t3;
        float _t10 = 1.0f + _t6;
        float _t11 = 1.0f + (this.m00 - (1.0f + this.m11));
        float _t12 = 1.0f + (this.m11 - (1.0f + this.m00));
        float _t13 = 1.0f + (1.0f - _t3);
        float _t14 = (1.0f / (float) Math.sqrt(_t10));
        float _t15 = (1.0f / (float) Math.sqrt(_t12));
        float _t16 = (1.0f / (float) Math.sqrt(_t13));
        float _t17 = (1.0f / (float) Math.sqrt(_t11));
        if (_t6 > 0.0f) {
            return new FloatQuat(-(0.5f * this.m12 * _t14), 0.5f * this.m02 * _t14, 0.5f * _t5 * _t14, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (this.m00 > _t0) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t11), 0.5f * _t4 * _t17, 0.5f * this.m02 * _t17, -(0.5f * this.m12 * _t17));
            } else {
                if (this.m11 > 1.0f) {
                    return new FloatQuat(0.5f * _t4 * _t15, 0.5f * (float) Math.sqrt(_t12), 0.5f * this.m12 * _t15, 0.5f * this.m02 * _t15);
                } else {
                    return new FloatQuat(0.5f * this.m02 * _t16, 0.5f * this.m12 * _t16, 0.5f * (float) Math.sqrt(_t13), 0.5f * _t5 * _t16);
                }
            }
        }
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_general() {
        float _t0 = this.m00 + this.m11;
        float _t1 = this.m21 - this.m12;
        float _t2 = Math.max(this.m11, this.m22);
        float _t4 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t10 = this.m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (this.m00 - (this.m11 + this.m22));
        float _t16 = 1.0f + (this.m11 - (this.m00 + this.m22));
        float _t17 = 1.0f + (this.m22 - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            return new FloatQuat(0.5f * _t1 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (this.m00 > _t2) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t4 * _t21, 0.5f * _t6 * _t21, 0.5f * _t1 * _t21);
            } else {
                if (this.m11 > this.m22) {
                    return new FloatQuat(0.5f * _t4 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19);
                } else {
                    return new FloatQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20);
                }
            }
        }
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getUnnormalizedRotation() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getUnnormalizedRotation_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getUnnormalizedRotation_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getUnnormalizedRotation_orthogonal();
        return getUnnormalizedRotation_general();
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_identity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_translation() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -this.m02, -this.m12, 1.0f, 0);
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_orthogonal() {
        return new Float3x3(this.m11, -this.m10, 0.0f, this.m10, this.m11, 0.0f, Math.fma(-this.m02, this.m11, -(this.m10 * this.m12)), Math.fma(this.m02, this.m10, -(this.m11 * this.m12)), 1.0f, 0);
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_affine() {
        return new Float3x3(this.m11, -this.m10, 0.0f, -this.m01, this.m00, 0.0f, Math.fma(this.m01, this.m12, -(this.m02 * this.m11)), Math.fma(this.m02, this.m10, -(this.m00 * this.m12)), Math.fma(this.m00, this.m11, -(this.m01 * this.m10)), 0);
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Float3x3 cofactor_general() {
        return new Float3x3(Math.fma(this.m11, this.m22, -(this.m12 * this.m21)), Math.fma(this.m12, this.m20, -(this.m10 * this.m22)), Math.fma(this.m10, this.m21, -(this.m11 * this.m20)), Math.fma(this.m02, this.m21, -(this.m01 * this.m22)), Math.fma(this.m00, this.m22, -(this.m02 * this.m20)), Math.fma(this.m01, this.m20, -(this.m00 * this.m21)), Math.fma(this.m01, this.m12, -(this.m02 * this.m11)), Math.fma(this.m02, this.m10, -(this.m00 * this.m12)), Math.fma(this.m00, this.m11, -(this.m01 * this.m10)), 0);
    }


    /**
     * Compute the cofactor matrix of this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 cofactor() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return cofactor_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine();
        return cofactor_general();
    }


    /**
     * Compute the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    public float determinant() {
        return Math.fma(this.m02, Math.fma(this.m10, this.m21, -(this.m11 * this.m20)), Math.fma(this.m00, Math.fma(this.m11, this.m22, -(this.m12 * this.m21)), -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public float frobeniusNorm() {
        return (float) Math.sqrt(Math.fma(this.m00, this.m00, this.m01 * this.m01) + Math.fma(this.m02, this.m02, this.m10 * this.m10) + (Math.fma(this.m11, this.m11, this.m12 * this.m12) + Math.fma(this.m20, this.m20, Math.fma(this.m21, this.m21, this.m22 * this.m22))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_identity() {
        return cofactor_identity();
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_translation() {
        return new Float3x3(1.0f, 0.0f, -this.m02, 0.0f, 1.0f, -this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_orthogonal() {
        return new Float3x3(this.m11, this.m10, Math.fma(-this.m02, this.m11, -(this.m10 * this.m12)), -this.m10, this.m11, Math.fma(this.m02, this.m10, -(this.m11 * this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_affine() {
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        return new Float3x3(this.m11 * _t2_inv, -(this.m01 * _t2_inv), Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv, -(this.m10 * _t2_inv), this.m00 * _t2_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x3 invert_general() {
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        return new Float3x3(_t6 * _t12_inv, Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv, Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv, Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv, Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv, _t7 * _t12_inv, Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv, Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv, 0);
    }


    /**
     * Invert this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 invert() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine();
        return invert_general();
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general(Float3x3 other) {
        float _t18 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        float _t19 = Math.fma(other.m22(), this.m22, Math.fma(other.m02(), this.m20, other.m12() * this.m21));
        float _t20 = Math.fma(other.m21(), this.m22, Math.fma(other.m01(), this.m20, other.m11() * this.m21));
        float _t21 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        float _t22 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        float _t23 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        float _t24 = Math.fma(other.m20(), this.m22, Math.fma(other.m00(), this.m20, other.m10() * this.m21));
        float _t25 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        float _t26 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        return new Float3x3(_t33 * _t39_inv, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv, _t34 * _t39_inv, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv, 0);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity(Float3x3 other) {
        float _t6 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        float _t7 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        float _t12 = Math.fma(other.m02(), _t7, Math.fma(other.m00(), _t6, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        float _t12_inv = 1.0f / _t12;
        return new Float3x3(_t6 * _t12_inv, Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22())) * _t12_inv, Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11())) * _t12_inv, Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22())) * _t12_inv, Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20())) * _t12_inv, Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12())) * _t12_inv, _t7 * _t12_inv, Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21())) * _t12_inv, Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10())) * _t12_inv, other.properties());
    }

    /** Private per-column body of {@code invertProduct_translation}; reached only through it. */
    private Float3 invertProduct_translation_s55dc17e2_c0(float _t12, float _t18_inv, Float3x3 other, float _t1, float _t3, float _t13) {
        return new Float3(_t12 * _t18_inv, Math.fma(other.m20(), _t1, -(other.m22() * _t3)) * _t18_inv, _t13 * _t18_inv);
    }

    /** Private per-column body of {@code invertProduct_translation}; reached only through it. */
    private Float3 invertProduct_translation_s55dc17e2_c1(Float3x3 other, float _t2, float _t5, float _t18_inv, float _t4) {
        return new Float3(Math.fma(other.m21(), _t2, -(other.m22() * _t5)) * _t18_inv, Math.fma(other.m22(), _t4, -(other.m20() * _t2)) * _t18_inv, Math.fma(other.m20(), _t5, -(other.m21() * _t4)) * _t18_inv);
    }

    /** Private per-column body of {@code invertProduct_translation}; reached only through it. */
    private Float3 invertProduct_translation_s55dc17e2_c2(float _t5, float _t1, float _t2, float _t0, float _t18_inv, float _t3, float _t4) {
        return new Float3(Math.fma(_t5, _t1, -(_t2 * _t0)) * _t18_inv, Math.fma(_t2, _t3, -(_t4 * _t1)) * _t18_inv, Math.fma(_t4, _t0, -(_t5 * _t3)) * _t18_inv);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation(Float3x3 other) {
        float _t0 = Math.fma(other.m21(), this.m12, other.m11());
        float _t1 = Math.fma(other.m22(), this.m12, other.m12());
        float _t2 = Math.fma(other.m22(), this.m02, other.m02());
        float _t3 = Math.fma(other.m20(), this.m12, other.m10());
        float _t4 = Math.fma(other.m20(), this.m02, other.m00());
        float _t5 = Math.fma(other.m21(), this.m02, other.m01());
        float _t12 = Math.fma(other.m22(), _t0, -(other.m21() * _t1));
        float _t13 = Math.fma(other.m21(), _t3, -(other.m20() * _t0));
        float _t18 = Math.fma(_t2, _t13, Math.fma(_t4, _t12, -(_t5 * Math.fma(other.m22(), _t3, -(other.m20() * _t1)))));
        float _t18_inv = 1.0f / _t18;
        return new Float3x3(invertProduct_translation_s55dc17e2_c0(_t12, _t18_inv, other, _t1, _t3, _t13), invertProduct_translation_s55dc17e2_c1(other, _t2, _t5, _t18_inv, _t4), invertProduct_translation_s55dc17e2_c2(_t5, _t1, _t2, _t0, _t18_inv, _t3, _t4), Joml.BIT_TRANSLATION & other.properties());
    }

    /** Private per-column body of {@code invertProduct_orthogonal}; reached only through it. */
    private Float3 invertProduct_orthogonal_s6f0f1b18_c0(float _t24, float _t30_inv, Float3x3 other, float _t13, float _t15, float _t25) {
        return new Float3(_t24 * _t30_inv, Math.fma(other.m20(), _t13, -(other.m22() * _t15)) * _t30_inv, _t25 * _t30_inv);
    }

    /** Private per-column body of {@code invertProduct_orthogonal}; reached only through it. */
    private Float3 invertProduct_orthogonal_s6f0f1b18_c1(Float3x3 other, float _t14, float _t17, float _t30_inv, float _t16) {
        return new Float3(Math.fma(other.m21(), _t14, -(other.m22() * _t17)) * _t30_inv, Math.fma(other.m22(), _t16, -(other.m20() * _t14)) * _t30_inv, Math.fma(other.m20(), _t17, -(other.m21() * _t16)) * _t30_inv);
    }

    /** Private per-column body of {@code invertProduct_orthogonal}; reached only through it. */
    private Float3 invertProduct_orthogonal_s6f0f1b18_c2(float _t17, float _t13, float _t12, float _t14, float _t30_inv, float _t15, float _t16) {
        return new Float3(Math.fma(_t17, _t13, -(_t12 * _t14)) * _t30_inv, Math.fma(_t15, _t14, -(_t16 * _t13)) * _t30_inv, Math.fma(_t16, _t12, -(_t15 * _t17)) * _t30_inv);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal(Float3x3 other, int _props) {
        float _t12 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        float _t13 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        float _t14 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        float _t15 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        float _t16 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        float _t17 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        float _t24 = Math.fma(other.m22(), _t12, -(other.m21() * _t13));
        float _t25 = Math.fma(other.m21(), _t15, -(other.m20() * _t12));
        float _t30 = Math.fma(_t14, _t25, Math.fma(_t16, _t24, -(_t17 * Math.fma(other.m22(), _t15, -(other.m20() * _t13)))));
        float _t30_inv = 1.0f / _t30;
        return new Float3x3(invertProduct_orthogonal_s6f0f1b18_c0(_t24, _t30_inv, other, _t13, _t15, _t25), invertProduct_orthogonal_s6f0f1b18_c1(other, _t14, _t17, _t30_inv, _t16), invertProduct_orthogonal_s6f0f1b18_c2(_t17, _t13, _t12, _t14, _t30_inv, _t15, _t16), _props);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_identity(Float3x3 other) {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_translation(Float3x3 other) {
        return new Float3x3(1.0f, 0.0f, -other.m02(), 0.0f, 1.0f, -other.m12(), 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_identity_affine(Float3x3 other) {
        float _t2 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t2_inv = 1.0f / _t2;
        return new Float3x3(other.m11() * _t2_inv, -(other.m01() * _t2_inv), Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11())) * _t2_inv, -(other.m10() * _t2_inv), other.m00() * _t2_inv, Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12())) * _t2_inv, 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_identity(Float3x3 other) {
        return new Float3x3(1.0f, 0.0f, -this.m02, 0.0f, 1.0f, -this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_translation(Float3x3 other) {
        return new Float3x3(1.0f, 0.0f, -(other.m02() + this.m02), 0.0f, 1.0f, -(other.m12() + this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_translation_affine(Float3x3 other) {
        float _t1 = other.m12() + this.m12;
        float _t2 = other.m02() + this.m02;
        float _t4 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t4_inv = 1.0f / _t4;
        return new Float3x3(other.m11() * _t4_inv, -(other.m01() * _t4_inv), Math.fma(other.m01(), _t1, -(other.m11() * _t2)) * _t4_inv, -(other.m10() * _t4_inv), other.m00() * _t4_inv, Math.fma(other.m10(), _t2, -(other.m00() * _t1)) * _t4_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_identity(Float3x3 other) {
        return new Float3x3(this.m11, this.m10, Math.fma(-this.m02, this.m11, -(this.m10 * this.m12)), -this.m10, this.m11, Math.fma(this.m02, this.m10, -(this.m11 * this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_translation(Float3x3 other) {
        float _t0 = -this.m10;
        return new Float3x3(this.m11, this.m10, Math.fma(_t0, this.m12, Math.fma(-this.m02, this.m11, -other.m02())), _t0, this.m11, Math.fma(this.m02, this.m10, Math.fma(-this.m11, this.m12, -other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_orthogonal_affine(Float3x3 other, int _props) {
        float _t6 = Math.fma(other.m01(), this.m10, other.m11() * this.m11);
        float _t7 = Math.fma(other.m00(), this.m00, other.m10() * this.m01);
        float _t8 = Math.fma(other.m00(), this.m10, other.m10() * this.m11);
        float _t9 = Math.fma(other.m01(), this.m00, other.m11() * this.m01);
        float _t10 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t11 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        float _t14_inv = 1.0f / _t14;
        return new Float3x3(_t6 * _t14_inv, -(_t9 * _t14_inv), Math.fma(_t10, _t9, -(_t11 * _t6)) * _t14_inv, -(_t8 * _t14_inv), _t7 * _t14_inv, Math.fma(_t11, _t8, -(_t10 * _t7)) * _t14_inv, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_affine_identity(Float3x3 other) {
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        return new Float3x3(this.m11 * _t2_inv, -(this.m01 * _t2_inv), Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv, -(this.m10 * _t2_inv), this.m00 * _t2_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_affine_translation(Float3x3 other) {
        float _t4 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t4_inv = 1.0f / _t4;
        float _t5 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t6 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        return new Float3x3(this.m11 * _t4_inv, -(this.m01 * _t4_inv), Math.fma(this.m01, _t5, -(this.m11 * _t6)) * _t4_inv, -(this.m10 * _t4_inv), this.m00 * _t4_inv, Math.fma(this.m10, _t6, -(this.m00 * _t5)) * _t4_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_identity(Float3x3 other) {
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        return new Float3x3(_t6 * _t12_inv, Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv, Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv, Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv, Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv, _t7 * _t12_inv, Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv, Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv, 0);
    }

    /** Private per-column body of {@code invertProduct_general_translation}; reached only through it. */
    private Float3 invertProduct_general_translation_s55dc17e2_c0(float _t13, float _t18_inv, float _t7, float _t6, float _t5) {
        return new Float3(_t13 * _t18_inv, Math.fma(this.m20, _t7, -(this.m10 * _t6)) * _t18_inv, _t5 * _t18_inv);
    }

    /** Private per-column body of {@code invertProduct_general_translation}; reached only through it. */
    private Float3 invertProduct_general_translation_s55dc17e2_c1(float _t8, float _t6, float _t18_inv) {
        return new Float3(Math.fma(this.m21, _t8, -(this.m01 * _t6)) * _t18_inv, Math.fma(this.m00, _t6, -(this.m20 * _t8)) * _t18_inv, Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t18_inv);
    }

    /** Private per-column body of {@code invertProduct_general_translation}; reached only through it. */
    private Float3 invertProduct_general_translation_s55dc17e2_c2(float _t7, float _t8, float _t18_inv) {
        return new Float3(Math.fma(this.m01, _t7, -(this.m11 * _t8)) * _t18_inv, Math.fma(this.m10, _t8, -(this.m00 * _t7)) * _t18_inv, Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t18_inv);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_translation(Float3x3 other) {
        float _t5 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t6 = Math.fma(other.m02(), this.m20, Math.fma(other.m12(), this.m21, this.m22));
        float _t7 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t8 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t13 = Math.fma(this.m11, _t6, -(this.m21 * _t7));
        float _t18 = Math.fma(_t8, _t5, Math.fma(this.m00, _t13, -(this.m01 * Math.fma(this.m10, _t6, -(this.m20 * _t7)))));
        float _t18_inv = 1.0f / _t18;
        return new Float3x3(invertProduct_general_translation_s55dc17e2_c0(_t13, _t18_inv, _t7, _t6, _t5), invertProduct_general_translation_s55dc17e2_c1(_t8, _t6, _t18_inv), invertProduct_general_translation_s55dc17e2_c2(_t7, _t8, _t18_inv), 0);
    }

    /** Private per-column body of {@code invertProduct_general_affine}; reached only through it. */
    private Float3 invertProduct_general_affine_s55dc17e2_c0(float _t25, float _t30_inv, float _t16, float _t12, float _t15, float _t11, float _t24) {
        return new Float3(_t25 * _t30_inv, Math.fma(_t16, _t12, -(_t15 * _t11)) * _t30_inv, _t24 * _t30_inv);
    }

    /** Private per-column body of {@code invertProduct_general_affine}; reached only through it. */
    private Float3 invertProduct_general_affine_s55dc17e2_c1(float _t17, float _t10, float _t15, float _t14, float _t30_inv, float _t13, float _t12) {
        return new Float3(Math.fma(_t17, _t10, -(_t15 * _t14)) * _t30_inv, Math.fma(_t15, _t13, -(_t17 * _t12)) * _t30_inv, Math.fma(_t12, _t14, -(_t13 * _t10)) * _t30_inv);
    }

    /** Private per-column body of {@code invertProduct_general_affine}; reached only through it. */
    private Float3 invertProduct_general_affine_s55dc17e2_c2(float _t16, float _t14, float _t17, float _t9, float _t30_inv, float _t11, float _t13) {
        return new Float3(Math.fma(_t16, _t14, -(_t17 * _t9)) * _t30_inv, Math.fma(_t17, _t11, -(_t16 * _t13)) * _t30_inv, Math.fma(_t13, _t9, -(_t11 * _t14)) * _t30_inv);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x3 invertProduct_general_affine(Float3x3 other) {
        float _t9 = Math.fma(other.m01(), this.m10, other.m11() * this.m11);
        float _t10 = Math.fma(other.m01(), this.m20, other.m11() * this.m21);
        float _t11 = Math.fma(other.m00(), this.m10, other.m10() * this.m11);
        float _t12 = Math.fma(other.m00(), this.m20, other.m10() * this.m21);
        float _t13 = Math.fma(other.m00(), this.m00, other.m10() * this.m01);
        float _t14 = Math.fma(other.m01(), this.m00, other.m11() * this.m01);
        float _t15 = Math.fma(other.m02(), this.m20, Math.fma(other.m12(), this.m21, this.m22));
        float _t16 = Math.fma(other.m02(), this.m10, Math.fma(other.m12(), this.m11, this.m12));
        float _t17 = Math.fma(other.m02(), this.m00, Math.fma(other.m12(), this.m01, this.m02));
        float _t24 = Math.fma(_t11, _t10, -(_t12 * _t9));
        float _t25 = Math.fma(_t15, _t9, -(_t16 * _t10));
        float _t30 = Math.fma(_t17, _t24, Math.fma(_t13, _t25, -(_t14 * Math.fma(_t15, _t11, -(_t16 * _t12)))));
        float _t30_inv = 1.0f / _t30;
        return new Float3x3(invertProduct_general_affine_s55dc17e2_c0(_t25, _t30_inv, _t16, _t12, _t15, _t11, _t24), invertProduct_general_affine_s55dc17e2_c1(_t17, _t10, _t15, _t14, _t30_inv, _t13, _t12), invertProduct_general_affine_s55dc17e2_c2(_t16, _t14, _t17, _t9, _t30_inv, _t11, _t13), 0);
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 invertProduct(Float3x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_identity_affine(other);
            return invertProduct_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_translation_affine(other);
            return invertProduct_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, Joml.BIT_ORTHOGONAL & other.properties());
            return invertProduct_orthogonal(other, Joml.BIT_ORTHOGONAL & other.properties());
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_affine_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_affine_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, Joml.BIT_AFFINE & other.properties());
            return invertProduct_orthogonal(other, Joml.BIT_AFFINE & other.properties());
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_general_affine(other);
        return invertProduct_general(other);
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}), returning the
     * result as a value.
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
     * @return the resulting matrix
     */
    public Float3x3 invertProduct(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        float _t18 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _t19 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        float _t20 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        float _t21 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        float _t22 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        float _t23 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _t24 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _t25 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _t26 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        float _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        float _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        float _t39_inv = 1.0f / _t39;
        return new Float3x3(_t33 * _t39_inv, Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv, Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv, Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv, Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv, Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv, _t34 * _t39_inv, Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv, Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv, 0);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_identity() {
        return cofactor_identity();
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_translation() {
        return cofactor_translation();
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_orthogonal() {
        return cofactor_orthogonal();
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_affine() {
        float _t2 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t2_inv = 1.0f / _t2;
        return new Float3x3(this.m11 * _t2_inv, -(this.m10 * _t2_inv), 0.0f, -(this.m01 * _t2_inv), this.m00 * _t2_inv, 0.0f, Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t2_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t2_inv, 1.0f, 0);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Float3x3 normal_general() {
        float _t6 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t7 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t12 = Math.fma(this.m02, _t7, Math.fma(this.m00, _t6, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t12_inv = 1.0f / _t12;
        return new Float3x3(_t6 * _t12_inv, Math.fma(this.m12, this.m20, -(this.m10 * this.m22)) * _t12_inv, _t7 * _t12_inv, Math.fma(this.m02, this.m21, -(this.m01 * this.m22)) * _t12_inv, Math.fma(this.m00, this.m22, -(this.m02 * this.m20)) * _t12_inv, Math.fma(this.m01, this.m20, -(this.m00 * this.m21)) * _t12_inv, Math.fma(this.m01, this.m12, -(this.m02 * this.m11)) * _t12_inv, Math.fma(this.m02, this.m10, -(this.m00 * this.m12)) * _t12_inv, Math.fma(this.m00, this.m11, -(this.m01 * this.m10)) * _t12_inv, 0);
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse, returning the
     * result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 normal() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normal_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine();
        return normal_general();
    }


    /**
     * Compute the trace of this matrix.
     *
     * @return the trace of this matrix
     */
    public float trace() {
        return this.m22 + (this.m00 + this.m11);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_identity() {
        return cofactor_identity();
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_translation() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, this.m02, this.m12, 1.0f, 0);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_orthogonal() {
        return new Float3x3(this.m00, this.m10, 0.0f, this.m01, this.m11, 0.0f, this.m02, this.m12, 1.0f, 0);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float3x3 transpose_general() {
        return new Float3x3(this.m00, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22, 0);
    }


    /**
     * Transpose this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 transpose() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_orthogonal();
        return transpose_general();
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general(Float3x3 other) {
        return new Float3x3(other.m00() + this.m00, other.m01() + this.m01, other.m02() + this.m02, other.m10() + this.m10, other.m11() + this.m11, other.m12() + this.m12, other.m20() + this.m20, other.m21() + this.m21, other.m22() + this.m22, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity(Float3x3 other) {
        return new Float3x3(1.0f + other.m00(), other.m01(), other.m02(), other.m10(), 1.0f + other.m11(), other.m12(), other.m20(), other.m21(), 1.0f + other.m22(), 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation(Float3x3 other) {
        return new Float3x3(1.0f + other.m00(), other.m01(), other.m02() + this.m02, other.m10(), 1.0f + other.m11(), other.m12() + this.m12, other.m20(), other.m21(), 1.0f + other.m22(), 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_identity(Float3x3 other) {
        return new Float3x3(2.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_translation(Float3x3 other) {
        return new Float3x3(2.0f, 0.0f, other.m02(), 0.0f, 2.0f, other.m12(), 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_identity_affine(Float3x3 other) {
        return new Float3x3(1.0f + other.m00(), other.m01(), other.m02(), other.m10(), 1.0f + other.m11(), other.m12(), 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_identity(Float3x3 other) {
        return new Float3x3(2.0f, 0.0f, this.m02, 0.0f, 2.0f, this.m12, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_translation(Float3x3 other) {
        return new Float3x3(2.0f, 0.0f, other.m02() + this.m02, 0.0f, 2.0f, other.m12() + this.m12, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_translation_affine(Float3x3 other) {
        return new Float3x3(1.0f + other.m00(), other.m01(), other.m02() + this.m02, other.m10(), 1.0f + other.m11(), other.m12() + this.m12, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_orthogonal_identity(Float3x3 other) {
        return new Float3x3(1.0f + this.m00, this.m01, this.m02, this.m10, 1.0f + this.m11, this.m12, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_orthogonal_translation(Float3x3 other) {
        return new Float3x3(1.0f + this.m00, this.m01, other.m02() + this.m02, this.m10, 1.0f + this.m11, other.m12() + this.m12, 0.0f, 0.0f, 2.0f, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general_identity(Float3x3 other) {
        return new Float3x3(1.0f + this.m00, this.m01, this.m02, this.m10, 1.0f + this.m11, this.m12, this.m20, this.m21, 1.0f + this.m22, 0);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x3 add_general_translation(Float3x3 other) {
        return new Float3x3(1.0f + this.m00, this.m01, other.m02() + this.m02, this.m10, 1.0f + this.m11, other.m12() + this.m12, this.m20, this.m21, 1.0f + this.m22, 0);
    }


    /**
     * Add {@code other} to this matrix, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 add(Float3x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_identity_affine(other);
            return add_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other);
            return add_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other);
            return add_general(other);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other);
            return add_general(other);
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other);
        return add_general(other);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) to this matrix, returning the result as a value.
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
     * @return the resulting matrix
     */
    public Float3x3 add(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        return new Float3x3(m00 + this.m00, m01 + this.m01, m02 + this.m02, m10 + this.m10, m11 + this.m11, m12 + this.m12, m20 + this.m20, m21 + this.m21, m22 + this.m22, 0);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_identity() {
        return new Float3x3(-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_translation() {
        return new Float3x3(-1.0f, 0.0f, -this.m02, 0.0f, -1.0f, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_orthogonal() {
        float _t0 = -this.m11;
        return new Float3x3(_t0, this.m10, -this.m02, -this.m10, _t0, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_affine() {
        return new Float3x3(-this.m00, -this.m01, -this.m02, -this.m10, -this.m11, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x3 negate_general() {
        return new Float3x3(-this.m00, -this.m01, -this.m02, -this.m10, -this.m11, -this.m12, -this.m20, -this.m21, -this.m22, 0);
    }


    /**
     * Negate this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 negate() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine();
        return negate_general();
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general(Float3x3 other) {
        return new Float3x3(this.m00 - other.m00(), this.m01 - other.m01(), this.m02 - other.m02(), this.m10 - other.m10(), this.m11 - other.m11(), this.m12 - other.m12(), this.m20 - other.m20(), this.m21 - other.m21(), this.m22 - other.m22(), 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity(Float3x3 other) {
        return new Float3x3(1.0f - other.m00(), -other.m01(), -other.m02(), -other.m10(), 1.0f - other.m11(), -other.m12(), -other.m20(), -other.m21(), 1.0f - other.m22(), 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_identity(Float3x3 other) {
        return Float3x3.ZERO;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_translation(Float3x3 other) {
        return new Float3x3(0.0f, 0.0f, -other.m02(), 0.0f, 0.0f, -other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_identity_affine(Float3x3 other) {
        return new Float3x3(1.0f - other.m00(), -other.m01(), -other.m02(), -other.m10(), 1.0f - other.m11(), -other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_identity(Float3x3 other) {
        return new Float3x3(0.0f, 0.0f, this.m02, 0.0f, 0.0f, this.m12, 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_translation(Float3x3 other) {
        return new Float3x3(0.0f, 0.0f, this.m02 - other.m02(), 0.0f, 0.0f, this.m12 - other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_translation_affine(Float3x3 other) {
        return new Float3x3(1.0f - other.m00(), -other.m01(), this.m02 - other.m02(), -other.m10(), 1.0f - other.m11(), this.m12 - other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_identity(Float3x3 other) {
        return new Float3x3(this.m00 - 1.0f, this.m01, this.m02, this.m10, this.m11 - 1.0f, this.m12, 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_translation(Float3x3 other) {
        return new Float3x3(this.m00 - 1.0f, this.m01, this.m02 - other.m02(), this.m10, this.m11 - 1.0f, this.m12 - other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_orthogonal_affine(Float3x3 other) {
        return new Float3x3(this.m00 - other.m00(), this.m01 - other.m01(), this.m02 - other.m02(), this.m10 - other.m10(), this.m11 - other.m11(), this.m12 - other.m12(), 0.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general_identity(Float3x3 other) {
        return new Float3x3(this.m00 - 1.0f, this.m01, this.m02, this.m10, this.m11 - 1.0f, this.m12, this.m20, this.m21, this.m22 - 1.0f, 0);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x3 sub_general_translation(Float3x3 other) {
        return new Float3x3(this.m00 - 1.0f, this.m01, this.m02 - other.m02(), this.m10, this.m11 - 1.0f, this.m12 - other.m12(), this.m20, this.m21, this.m22 - 1.0f, 0);
    }


    /**
     * Subtract {@code other} from this matrix, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 sub(Float3x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_identity_affine(other);
            return sub_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other);
            return sub_general(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other);
            return sub_general(other);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other);
            return sub_general(other);
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other);
        return sub_general(other);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) from this matrix, returning the result as a value.
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
     * @return the resulting matrix
     */
    public Float3x3 sub(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        return new Float3x3(this.m00 - m00, this.m01 - m01, this.m02 - m02, this.m10 - m10, this.m11 - m11, this.m12 - m12, this.m20 - m20, this.m21 - m21, this.m22 - m22, 0);
    }


    /**
     * Create a new matrix from the given values.
     *
     * @param v the matrix
     * @return the resulting matrix
     */
    public Float3x3 set(Float3x3 v) {
        return v;
    }


    /**
     * Create a new matrix from the given values.
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
     * @return the resulting matrix
     */
    public Float3x3 set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        return new Float3x3(m00, m01, m02, m10, m11, m12, m20, m21, m22);
    }


    /**
     * Create a new matrix from the given 2x2 matrix, copying the overlapping cells and filling the
     * rest with identity.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x3 set(Float2x2 m) {
        return new Float3x3(m.m00(), m.m01(), 0.0f, m.m10(), m.m11(), 0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Create a new matrix from the given 2x3 matrix, copying the overlapping cells and filling the
     * rest with identity.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x3 set(Float2x3 m) {
        return new Float3x3(m.m00(), m.m01(), m.m02(), m.m10(), m.m11(), m.m12(), 0.0f, 0.0f, 1.0f);
    }


    /**
     * Create a new matrix from the given 3x4 matrix, copying the overlapping cells and dropping the
     * rest.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x3 set(Float3x4 m) {
        return new Float3x3(m.m00(), m.m01(), m.m02(), m.m10(), m.m11(), m.m12(), m.m20(), m.m21(), m.m22());
    }


    /**
     * Create a new matrix from the given 4x4 matrix, copying the overlapping cells and dropping the
     * rest.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x3 set(Float4x4 m) {
        return new Float3x3(m.m00(), m.m01(), m.m02(), m.m10(), m.m11(), m.m12(), m.m20(), m.m21(), m.m22());
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @return the resulting matrix
     */
    public Float3x3 withTranslation(Float2 t) {
        return withTranslation(t.x(), t.y());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_identity(float tX, float tY) {
        return new Float3x3(1.0f, 0.0f, tX, 0.0f, 1.0f, tY, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_orthogonal(float tX, float tY) {
        return new Float3x3(this.m00, this.m01, tX, this.m10, this.m11, tY, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_affine(float tX, float tY) {
        return new Float3x3(this.m00, this.m01, tX, this.m10, this.m11, tY, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x3 withTranslation_general(float tX, float tY) {
        return new Float3x3(this.m00, this.m01, tX, this.m10, this.m11, tY, this.m20, this.m21, this.m22, 0);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @return the resulting matrix
     */
    public Float3x3 withTranslation(float tX, float tY) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return withTranslation_affine(tX, tY);
        return withTranslation_general(tX, tY);
    }


    /**
     * Convert this matrix to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double3x3} holding the result
     */
    public Double3x3 toDouble() {
        return new Double3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22);
    }


    /**
     * Create the given rigid transform's rotation block (the translation is dropped).
     *
     * @param r the rigid transform (must be a unit vector)
     * @return the resulting matrix
     */
    public static Float3x3 makeFromRigid(FloatRigid r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Create the given rigid transform's rotation block (the translation is dropped).
     *
     * @param rTX the {@code tX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rTY the {@code tY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rTZ the {@code tZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rRX the {@code rX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rRY the {@code rY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rRZ the {@code rZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @param rRW the {@code rW} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the vector must have unit length)
     * @return the resulting matrix
     */
    public static Float3x3 makeFromRigid(float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        return new Float3x3(Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f), 2.0f * Math.fma(rRX, rRY, -_t1), 2.0f * Math.fma(rRX, rRZ, _t2), 2.0f * Math.fma(rRX, rRY, _t1), Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f), 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)), 2.0f * Math.fma(rRX, rRZ, -_t2), 2.0f * Math.fma(rRX, rRW, rRY * rRZ), Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f), 0);
    }


    /**
     * Create the given transform's linear block {@code R * S} (the translation is dropped).
     *
     * @param t the transform
     * @return the resulting matrix
     */
    public static Float3x3 makeFromTransform(FloatTransform t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Create the given transform's linear block {@code R * S} (the translation is dropped).
     *
     * @param tTX the {@code tX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTY the {@code tY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTZ the {@code tZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRX the {@code rX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRY the {@code rY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRZ the {@code rZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRW the {@code rW} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSX the {@code sX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSY the {@code sY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSZ the {@code sZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @return the resulting matrix
     */
    public static Float3x3 makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        return new Float3x3(tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f), tSY * 2.0f * Math.fma(tRX, tRY, -_t1), tSZ * 2.0f * Math.fma(tRX, tRZ, _t2), tSX * 2.0f * Math.fma(tRX, tRY, _t1), tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f), tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)), tSX * 2.0f * Math.fma(tRX, tRZ, -_t2), tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ), tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f), 0);
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Float2x2 to2x2_identity() {
        return new Float2x2(1.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Float2x2 to2x2_general() {
        return new Float2x2(this.m00, this.m01, this.m10, this.m11, 0);
    }


    /**
     * Extract the upper-left 2x2 linear block of this matrix (dropping the translation column and
     * the last row), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float2x2 to2x2() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x2_identity();
        return to2x2_general();
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_identity() {
        return new Float2x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_translation() {
        return new Float2x3(1.0f, 0.0f, this.m02, 0.0f, 1.0f, this.m12, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_orthogonal() {
        return new Float2x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Float2x3 to2x3_general() {
        return new Float2x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, Joml.BIT_AFFINE);
    }


    /**
     * Truncate this matrix to a 2x3 matrix, dropping the last row (assumed {@code 0, 0, 1}),
     * returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float2x3 to2x3() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to2x3_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x3_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return to2x3_orthogonal();
        return to2x3_general();
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_translation() {
        return new Float3x4(1.0f, 0.0f, this.m02, 0.0f, 0.0f, 1.0f, this.m12, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_orthogonal() {
        return new Float3x4(this.m00, this.m01, this.m02, 0.0f, this.m10, this.m11, this.m12, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Float3x4 to3x4_general() {
        return new Float3x4(this.m00, this.m01, this.m02, 0.0f, this.m10, this.m11, this.m12, 0.0f, this.m20, this.m21, this.m22, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Extend this matrix to a 3x4 matrix with a zero translation column, returning the result as a
     * value.
     *
     * @return the resulting matrix
     */
    public Float3x4 to3x4() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to3x4_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x4_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to3x4_orthogonal();
        return to3x4_general();
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_identity() {
        return new Float4x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_translation() {
        return new Float4x4(1.0f, 0.0f, this.m02, 0.0f, 0.0f, 1.0f, this.m12, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_orthogonal() {
        return new Float4x4(this.m00, this.m01, this.m02, 0.0f, this.m10, this.m11, this.m12, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_general() {
        return new Float4x4(this.m00, this.m01, this.m02, 0.0f, this.m10, this.m11, this.m12, 0.0f, this.m20, this.m21, this.m22, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Extend this matrix to a 4x4 matrix, filling the missing cells with identity, returning the
     * result as a value.
     *
     * @return the resulting matrix
     */
    public Float4x4 to4x4() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to4x4_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to4x4_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to4x4_orthogonal();
        return to4x4_general();
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_identity() {
        return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_translation() {
        return new FloatDualQuat(-(0.25f * this.m12), 0.25f * this.m02, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_orthogonal() {
        float _t0 = Math.max(this.m11, 1.0f);
        float _t2 = 1.0f - this.m00;
        float _t4 = this.m01 + this.m10;
        float _t5 = this.m10 - this.m01;
        float _t8 = 1.0f + (this.m00 + this.m11);
        float _t10 = 1.0f + _t8;
        float _t11 = this.m00 + (1.0f - this.m11 - 1.0f);
        float _t12 = this.m11 + (_t2 - 1.0f);
        float _t13 = 1.0f + (_t2 - this.m11);
        float _t14 = (1.0f / (float) Math.sqrt(_t10));
        float _t15 = (1.0f / (float) Math.sqrt(_t12));
        float _t16 = (1.0f / (float) Math.sqrt(_t13));
        float _t17 = (1.0f / (float) Math.sqrt(_t11));
        if (_t8 > 0.0f) {
            return new FloatDualQuat(-(0.5f * this.m12 * _t14), 0.5f * this.m02 * _t14, 0.5f * _t5 * _t14, 0.5f * (float) Math.sqrt(_t10), 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.m00 > _t0) {
                return new FloatDualQuat(0.5f * (float) Math.sqrt(_t11), 0.5f * _t4 * _t17, 0.5f * this.m02 * _t17, -(0.5f * this.m12 * _t17), 0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                if (this.m11 > 1.0f) {
                    return new FloatDualQuat(0.5f * _t4 * _t15, 0.5f * (float) Math.sqrt(_t12), 0.5f * this.m12 * _t15, 0.5f * this.m02 * _t15, 0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    return new FloatDualQuat(0.5f * this.m02 * _t16, 0.5f * this.m12 * _t16, 0.5f * (float) Math.sqrt(_t13), 0.5f * _t5 * _t16, 0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_general() {
        float _t1 = 1.0f - this.m00;
        float _t3 = this.m21 - this.m12;
        float _t4 = Math.max(this.m11, this.m22);
        float _t5 = this.m01 + this.m10;
        float _t6 = this.m02 + this.m20;
        float _t7 = this.m02 - this.m20;
        float _t8 = this.m12 + this.m21;
        float _t9 = this.m10 - this.m01;
        float _t13 = this.m22 + (this.m00 + this.m11);
        float _t14 = 1.0f + _t13;
        float _t15 = this.m00 + (1.0f - this.m11 - this.m22);
        float _t16 = this.m11 + (_t1 - this.m22);
        float _t17 = this.m22 + (_t1 - this.m11);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            return new FloatDualQuat(0.5f * _t3 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14), 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.m00 > _t4) {
                return new FloatDualQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t5 * _t21, 0.5f * _t6 * _t21, 0.5f * _t3 * _t21, 0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                if (this.m11 > this.m22) {
                    return new FloatDualQuat(0.5f * _t5 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19, 0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    return new FloatDualQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20, 0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
    }


    /**
     * Convert this matrix (assumed orthonormal) to a pure-rotation dual quaternion, returning the
     * result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat toDualQuat() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toDualQuat_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toDualQuat_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return toDualQuat_orthogonal();
        return toDualQuat_general();
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_identity() {
        return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    /** Private tail of {@code toRigid_translation}; reached only through it. */
    private FloatRigid toRigid_translation_s0_tail(float _t16, float _t11, float _t5, float _t18, float _t7, float _t3, float _t2, float _t6, float _t19, float _t13, float _t14, float _t17, float _t15) {
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        if (_t11 > 0.0f) {
            return new FloatRigid(0.0f, 0.0f, 0.0f, -(0.5f * _t5 * _t18), 0.5f * _t6 * _t18, 0.0f, 0.5f * (float) Math.sqrt(_t15));
        } else {
            if (_t7 > _t3) {
                return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t16), 0.0f, 0.5f * _t6 * _t20, -(0.5f * _t5 * _t20));
            } else {
                if (1.0f > _t2) {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t13), 0.5f * _t5 * _t14, 0.5f * _t6 * _t14);
                } else {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t6 * _t19, 0.5f * _t5 * _t19, 0.5f * (float) Math.sqrt(_t17), 0.0f);
                }
            }
        }
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_translation() {
        float _t2 = (1.0f / (float) Math.sqrt(Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f))));
        float _t3 = Math.max(1.0f, _t2);
        float _t5 = this.m12 * _t2;
        float _t6 = this.m02 * _t2;
        float _t7 = _t2 < 0.0f ? -1.0f : 1.0f;
        float _t8 = 1.0f + _t7;
        float _t11 = _t8 + _t2;
        float _t13 = 2.0f - _t7 - _t2;
        float _t14 = (1.0f / (float) Math.sqrt(_t13));
        float _t15 = 1.0f + _t11;
        float _t16 = _t8 - 1.0f - _t2;
        float _t17 = 1.0f + _t2 - _t7 - 1.0f;
        float _t18 = (1.0f / (float) Math.sqrt(_t15));
        float _t19 = (1.0f / (float) Math.sqrt(_t17));
        return toRigid_translation_s0_tail(_t16, _t11, _t5, _t18, _t7, _t3, _t2, _t6, _t19, _t13, _t14, _t17, _t15);
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_general() {
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))));
        float _t15 = this.m10 * _t14;
        float _t16 = this.m22 * _t13;
        float _t17 = this.m12 * _t13;
        float _t18 = this.m20 * _t14;
        float _t20 = this.m21 * _t12;
        float _t21 = this.m11 * _t12;
        float _t23 = this.m00 * _t14;
        float _t28 = Math.fma(this.m12, _t13, _t20);
        float _t32 = Math.fma(this.m21, _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), this.m01 * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), this.m02 * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(this.m01, _t12, _t45);
        float _t52 = Math.fma(this.m02, _t13, _t46);
        float _t53 = Math.fma(this.m02, _t13, -_t46);
        float _t54 = Math.fma(-this.m01, _t12, _t45);
        float _t59 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t44));
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t32 * _t61, 0.5f * _t53 * _t61, 0.5f * _t54 * _t61, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t64), 0.5f * _t51 * _t67, 0.5f * _t52 * _t67, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t51 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t28 * _t65, 0.5f * _t53 * _t65);
                } else {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t52 * _t66, 0.5f * _t28 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t54 * _t66);
                }
            }
        }
    }


    /**
     * Extract this matrix's rotation into a rigid transform with zero translation (any scale or
     * shear projects onto the nearest rotation), returning the result as a value.
     *
     * @return the resulting rigid transform
     */
    public FloatRigid toRigid() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toRigid_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toRigid_translation();
        return toRigid_general();
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_identity() {
        return new FloatTransform(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    /** Private tail of {@code toTransform_translation}; reached only through it. */
    private FloatTransform toTransform_translation_s0_tail(float _t16, float _t11, float _t5, float _t18, float _t7, float _t3, float _t2, float _t6, float _t19, float _t13, float _t14, float _t17, float _t15, float _t1) {
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        if (_t11 > 0.0f) {
            return new FloatTransform(0.0f, 0.0f, 0.0f, -(0.5f * _t5 * _t18), 0.5f * _t6 * _t18, 0.0f, 0.5f * (float) Math.sqrt(_t15), _t7, 1.0f, (float) Math.sqrt(_t1));
        } else {
            if (_t7 > _t3) {
                return new FloatTransform(0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t16), 0.0f, 0.5f * _t6 * _t20, -(0.5f * _t5 * _t20), _t7, 1.0f, (float) Math.sqrt(_t1));
            } else {
                if (1.0f > _t2) {
                    return new FloatTransform(0.0f, 0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t13), 0.5f * _t5 * _t14, 0.5f * _t6 * _t14, _t7, 1.0f, (float) Math.sqrt(_t1));
                } else {
                    return new FloatTransform(0.0f, 0.0f, 0.0f, 0.5f * _t6 * _t19, 0.5f * _t5 * _t19, 0.5f * (float) Math.sqrt(_t17), 0.0f, _t7, 1.0f, (float) Math.sqrt(_t1));
                }
            }
        }
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_translation() {
        float _t1 = Math.fma(this.m02, this.m02, Math.fma(this.m12, this.m12, 1.0f));
        float _t2 = (1.0f / (float) Math.sqrt(_t1));
        float _t3 = Math.max(1.0f, _t2);
        float _t5 = this.m12 * _t2;
        float _t6 = this.m02 * _t2;
        float _t7 = _t2 < 0.0f ? -1.0f : 1.0f;
        float _t8 = 1.0f + _t7;
        float _t11 = _t8 + _t2;
        float _t13 = 2.0f - _t7 - _t2;
        float _t14 = (1.0f / (float) Math.sqrt(_t13));
        float _t15 = 1.0f + _t11;
        float _t16 = _t8 - 1.0f - _t2;
        float _t17 = 1.0f + _t2 - _t7 - 1.0f;
        float _t18 = (1.0f / (float) Math.sqrt(_t15));
        float _t19 = (1.0f / (float) Math.sqrt(_t17));
        return toTransform_translation_s0_tail(_t16, _t11, _t5, _t18, _t7, _t3, _t2, _t6, _t19, _t13, _t14, _t17, _t15, _t1);
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_general() {
        float _t0 = -this.m11;
        float _t1 = -this.m22;
        float _t9 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t10 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t11 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t12 = (1.0f / (float) Math.sqrt(_t9));
        float _t13 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = (1.0f / (float) Math.sqrt(_t11));
        float _t15 = (float) Math.sqrt(_t11);
        float _t16 = this.m10 * _t14;
        float _t17 = this.m22 * _t13;
        float _t18 = this.m12 * _t13;
        float _t19 = this.m20 * _t14;
        float _t21 = this.m21 * _t12;
        float _t22 = this.m11 * _t12;
        float _t24 = this.m00 * _t14;
        float _t29 = Math.fma(this.m12, _t13, _t21);
        float _t33 = Math.fma(this.m21, _t12, -_t18);
        float _t34 = Math.max(_t22, _t17);
        float _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), this.m01 * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), this.m02 * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        float _t45, _t46, _t47;
        if (_t44 < 0.0f) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        float _t49 = 1.0f + _t45;
        float _t50 = 1.0f - _t45;
        float _t52 = Math.fma(this.m01, _t12, _t46);
        float _t53 = Math.fma(this.m02, _t13, _t47);
        float _t54 = Math.fma(this.m02, _t13, -_t47);
        float _t55 = Math.fma(-this.m01, _t12, _t46);
        float _t60 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t45));
        float _t61 = Math.fma(this.m11, _t12, Math.fma(this.m22, _t13, _t49));
        float _t62 = (1.0f / (float) Math.sqrt(_t61));
        float _t63 = Math.fma(this.m11, _t12, Math.fma(_t1, _t13, _t50));
        float _t64 = Math.fma(this.m22, _t13, Math.fma(_t0, _t12, _t50));
        float _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        float _t68 = (1.0f / (float) Math.sqrt(_t65));
        return new FloatTransform(0.0f, 0.0f, 0.0f, _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67, _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67, _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64), _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67, _t44 < 0.0f ? -_t15 : _t15, (float) Math.sqrt(_t9), (float) Math.sqrt(_t10));
    }


    /**
     * Decompose this matrix's linear {@code R * S} block into a TRS transform with zero translation
     * (a sheared matrix projects onto the nearest rotation), returning the result as a value.
     *
     * @return the resulting transform
     */
    public FloatTransform toTransform() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toTransform_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toTransform_translation();
        return toTransform_general();
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private FloatQuat decomposeRotation_identity() {
        return getNormalizedRotation_identity();
    }

    /** Private tail of {@code decomposeRotation_general}; reached only through it. */
    private FloatQuat decomposeRotation_general_s0_tail(float _t20, float _t7, float _t35, float _t8, float _t34, float _t9, float _t36) {
        float _t40 = -Math.fma(Math.fma(_t20, _t7, this.m22), _t35, Math.fma(Math.fma(_t20, _t8, this.m02), _t34, Math.fma(_t20, _t9, this.m12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, this.m22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, this.m02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, this.m12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54, _t55, _t56;
        if (_t49 > 0.0f) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0f;
            _t55 = 0.0f;
            _t56 = 0.0f;
        }
        float _t60 = _t35 - _t54;
        float _t61 = Math.max(_t36, _t56);
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        return decomposeRotation_general_s0_tail2(_t72, _t8, _t9, _t7, _t36, _t34, _t55, _t56, _t60, _t61, _t63);
    }

    /** Private tail of {@code decomposeRotation_general}; reached only through it. */
    private FloatQuat decomposeRotation_general_s0_tail2(float _t72, float _t8, float _t9, float _t7, float _t36, float _t34, float _t55, float _t56, float _t60, float _t61, float _t63) {
        float _t73, _t74, _t75;
        if (_t72 < 0.0f) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t90 = (1.0f / (float) Math.sqrt(_t86));
        float _t91 = (1.0f / (float) Math.sqrt(_t88));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        return decomposeRotation_general_s0_tail3(_t82, _t60, _t90, _t73, _t61, _t87, _t36, _t56, _t77, _t91, _t80, _t92, _t81, _t93, _t88, _t63, _t78, _t89, _t86);
    }

    /** Private tail of {@code decomposeRotation_general}; reached only through it. */
    private FloatQuat decomposeRotation_general_s0_tail3(float _t82, float _t60, float _t90, float _t73, float _t61, float _t87, float _t36, float _t56, float _t77, float _t91, float _t80, float _t92, float _t81, float _t93, float _t88, float _t63, float _t78, float _t89, float _t86) {
        float _sfx0, _sfx1, _sfx2, _sfx3;
        if (_t82 > 0.0f) {
            _sfx0 = 0.5f * _t60 * _t90;
            _sfx1 = 0.5f * _t81 * _t90;
            _sfx2 = 0.5f * _t78 * _t90;
            _sfx3 = 0.5f * (float) Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                _sfx0 = 0.5f * (float) Math.sqrt(_t87);
                _sfx1 = 0.5f * _t77 * _t93;
                _sfx2 = 0.5f * _t80 * _t93;
                _sfx3 = 0.5f * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    _sfx0 = 0.5f * _t77 * _t91;
                    _sfx1 = 0.5f * (float) Math.sqrt(_t88);
                    _sfx2 = 0.5f * _t63 * _t91;
                    _sfx3 = 0.5f * _t81 * _t91;
                } else {
                    _sfx0 = 0.5f * _t80 * _t92;
                    _sfx1 = 0.5f * _t63 * _t92;
                    _sfx2 = 0.5f * (float) Math.sqrt(_t89);
                    _sfx3 = 0.5f * _t78 * _t92;
                }
            }
        }
        return new FloatQuat(_sfx0, _sfx1, _sfx2, _sfx3);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private FloatQuat decomposeRotation_general() {
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t19 = -Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t20 = -Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t21 = Math.fma(_t19, _t7, this.m21);
        float _t22 = Math.fma(_t19, _t8, this.m01);
        float _t23 = Math.fma(_t19, _t9, this.m11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34, _t35, _t36;
        if (_t29 > 0.0f) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0f;
            _t35 = 0.0f;
            _t36 = 0.0f;
        }
        return decomposeRotation_general_s0_tail(_t20, _t7, _t35, _t8, _t34, _t9, _t36);
    }


    /**
     * Extract the rotation part of this matrix, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat decomposeRotation() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeRotation_identity();
        return decomposeRotation_general();
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Float3 decomposeScale_identity() {
        return getScale_identity();
    }

    /** Private tail of {@code decomposeScale_general}; reached only through it. */
    private Float3 decomposeScale_general_s0_tail(float _t18, float _t8, float _t33, float _t9, float _t32, float _t10, float _t34, float _t4, float _t27) {
        float _t38 = -Math.fma(Math.fma(_t18, _t8, this.m22), _t33, Math.fma(Math.fma(_t18, _t9, this.m02), _t32, Math.fma(_t18, _t10, this.m12) * _t34));
        float _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, this.m22));
        float _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, this.m02));
        float _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t52, _t53, _t54;
        if (_t47 > 0.0f) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0f;
            _t53 = 0.0f;
            _t54 = 0.0f;
        }
        return new Float3(Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0f ? -_t4 : _t4, (float) Math.sqrt(_t27), (float) Math.sqrt(_t47));
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Float3 decomposeScale_general() {
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t4 = (float) Math.sqrt(_t2);
        float _t8, _t9, _t10;
        if (_t2 > 0.0f) {
            _t8 = this.m20 * _t3;
            _t9 = this.m00 * _t3;
            _t10 = this.m10 * _t3;
        } else {
            _t8 = 0.0f;
            _t9 = 0.0f;
            _t10 = 0.0f;
        }
        float _t17 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        float _t18 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        float _t19 = Math.fma(_t17, _t8, this.m21);
        float _t20 = Math.fma(_t17, _t9, this.m01);
        float _t21 = Math.fma(_t17, _t10, this.m11);
        float _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        return decomposeScale_general_s0_tail(_t18, _t8, _t33, _t9, _t32, _t10, _t34, _t4, _t27);
    }


    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative), returning
     * the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 decomposeScale() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeScale_identity();
        return decomposeScale_general();
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_translation() {
        return new Float3(this.m12, this.m02, 0.0f);
    }

    /** Private tail of {@code decomposeSkew_general}; reached only through it. */
    private Float3 decomposeSkew_general_s0_tail(float _t16, float _t7, float _t32, float _t8, float _t33, float _t9, float _t34, float _t14, float _t28) {
        float _t37 = Math.fma(Math.fma(_t16, _t7, this.m22), _t32, Math.fma(Math.fma(_t16, _t8, this.m02), _t33, Math.fma(_t16, _t9, this.m12) * _t34));
        float _t38 = -_t37;
        float _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, this.m22));
        float _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, this.m02));
        float _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, this.m12));
        float _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        float _t48 = (1.0f / (float) Math.sqrt(_t47));
        float _t49 = _t14 * _t48;
        float _t53, _t54, _t55;
        if (_t47 > 0.0f) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0f;
            _t54 = 0.0f;
            _t55 = 0.0f;
        }
        float _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0f) {
            return new Float3(_t37 * _t48, -_t49, -_t28);
        } else {
            return new Float3(_t37 * _t48, _t49, _t28);
        }
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Float3 decomposeSkew_general() {
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = this.m20 * _t3;
            _t8 = this.m00 * _t3;
            _t9 = this.m10 * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t14 = Math.fma(this.m22, _t7, Math.fma(this.m02, _t8, this.m12 * _t9));
        float _t15 = Math.fma(this.m21, _t7, Math.fma(this.m01, _t8, this.m11 * _t9));
        float _t16 = -_t14;
        float _t17 = -_t15;
        float _t19 = Math.fma(_t17, _t7, this.m21);
        float _t20 = Math.fma(_t17, _t8, this.m01);
        float _t21 = Math.fma(_t17, _t9, this.m11);
        float _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t28 = _t15 * _t27;
        float _t32, _t33, _t34;
        if (_t26 > 0.0f) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        return decomposeSkew_general_s0_tail(_t16, _t7, _t32, _t8, _t33, _t9, _t34, _t14, _t28);
    }


    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix), returning the result as
     * a value.
     *
     * @return the resulting vector
     */
    public Float3 decomposeSkew() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return decomposeSkew_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeSkew_translation();
        return decomposeSkew_general();
    }


    /**
     * Create an identity matrix.
     *
     * @return the resulting matrix
     */
    public static Float3x3 makeIdentity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_general(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - this.m00, this.m00), Math.fma(t, other.m01() - this.m01, this.m01), Math.fma(t, other.m02() - this.m02, this.m02), Math.fma(t, other.m10() - this.m10, this.m10), Math.fma(t, other.m11() - this.m11, this.m11), Math.fma(t, other.m12() - this.m12, this.m12), Math.fma(t, other.m20() - this.m20, this.m20), Math.fma(t, other.m21() - this.m21, this.m21), Math.fma(t, other.m22() - this.m22, this.m22), 0);
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), t * other.m02(), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), t * other.m12(), t * other.m20(), t * other.m21(), Math.fma(t, other.m22() - 1.0f, 1.0f), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), Math.fma(t, other.m02() - this.m02, this.m02), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), Math.fma(t, other.m12() - this.m12, this.m12), t * other.m20(), t * other.m21(), Math.fma(t, other.m22() - 1.0f, 1.0f), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - this.m00, this.m00), Math.fma(t, other.m01() - this.m01, this.m01), Math.fma(t, other.m02() - this.m02, this.m02), Math.fma(t, other.m10() - this.m10, this.m10), Math.fma(t, other.m11() - this.m11, this.m11), Math.fma(t, other.m12() - this.m12, this.m12), t * other.m20(), t * other.m21(), Math.fma(t, other.m22() - 1.0f, 1.0f), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_identity(Float3x3 other, float t) {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_translation(Float3x3 other, float t) {
        return new Float3x3(1.0f, 0.0f, t * other.m02(), 0.0f, 1.0f, t * other.m12(), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_identity_affine(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), t * other.m02(), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), t * other.m12(), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_identity(Float3x3 other, float t) {
        return new Float3x3(1.0f, 0.0f, Math.fma(-t, this.m02, this.m02), 0.0f, 1.0f, Math.fma(-t, this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_translation(Float3x3 other, float t) {
        return new Float3x3(1.0f, 0.0f, Math.fma(t, other.m02() - this.m02, this.m02), 0.0f, 1.0f, Math.fma(t, other.m12() - this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_translation_affine(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), Math.fma(t, other.m02() - this.m02, this.m02), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), Math.fma(t, other.m12() - this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_identity(Float3x3 other, float t) {
        float _t1 = Math.fma(-t, this.m11, t + this.m11);
        return new Float3x3(_t1, Math.fma(t, this.m10, -this.m10), Math.fma(-t, this.m02, this.m02), Math.fma(-t, this.m10, this.m10), _t1, Math.fma(-t, this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_translation(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, 1.0f - this.m00, this.m00), Math.fma(-t, this.m01, this.m01), Math.fma(t, other.m02() - this.m02, this.m02), Math.fma(-t, this.m10, this.m10), Math.fma(t, 1.0f - this.m11, this.m11), Math.fma(t, other.m12() - this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_orthogonal_affine(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, other.m00() - this.m00, this.m00), Math.fma(t, other.m01() - this.m01, this.m01), Math.fma(t, other.m02() - this.m02, this.m02), Math.fma(t, other.m10() - this.m10, this.m10), Math.fma(t, other.m11() - this.m11, this.m11), Math.fma(t, other.m12() - this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x3 lerp_affine_identity(Float3x3 other, float t) {
        return new Float3x3(Math.fma(t, 1.0f - this.m00, this.m00), Math.fma(-t, this.m01, this.m01), Math.fma(-t, this.m02, this.m02), Math.fma(-t, this.m10, this.m10), Math.fma(t, 1.0f - this.m11, this.m11), Math.fma(-t, this.m12, this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting matrix
     */
    public Float3x3 lerp(Float3x3 other, float t) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_identity_affine(other, t);
            return lerp_identity(other, t);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_translation_affine(other, t);
            return lerp_translation(other, t);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_orthogonal_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t);
            return lerp_orthogonal(other, t);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t);
            return lerp_orthogonal(other, t);
        }
        return lerp_general(other, t);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) using the
     * interpolation factor {@code t}, returning the result as a value.
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
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting matrix
     */
    public Float3x3 lerp(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, float t) {
        return new Float3x3(Math.fma(t, m00 - this.m00, this.m00), Math.fma(t, m01 - this.m01, this.m01), Math.fma(t, m02 - this.m02, this.m02), Math.fma(t, m10 - this.m10, this.m10), Math.fma(t, m11 - this.m11, this.m11), Math.fma(t, m12 - this.m12, this.m12), Math.fma(t, m20 - this.m20, this.m20), Math.fma(t, m21 - this.m21, this.m21), Math.fma(t, m22 - this.m22, this.m22), 0);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float3x3 right) {
        return new Float3x3(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)), Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)), Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)), Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21)), Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21)), Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21)), 0);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float3x3 right) {
        return new Float3x3(Math.fma(right.m20(), this.m02, right.m00()), Math.fma(right.m21(), this.m02, right.m01()), Math.fma(right.m22(), this.m02, right.m02()), Math.fma(right.m20(), this.m12, right.m10()), Math.fma(right.m21(), this.m12, right.m11()), Math.fma(right.m22(), this.m12, right.m12()), right.m20(), right.m21(), right.m22(), Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float3x3 right) {
        return new Float3x3(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m11, -(right.m10() * this.m10))), Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m11, -(right.m11() * this.m10))), Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m11, -(right.m12() * this.m10))), Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), right.m20(), right.m21(), right.m22(), Joml.BIT_ORTHOGONAL & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float3x3 right) {
        return new Float3x3(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)), Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)), Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)), Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), right.m20(), right.m21(), right.m22(), Joml.BIT_AFFINE & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_translation(Float3x3 right) {
        return new Float3x3(1.0f, 0.0f, right.m02() + this.m02, 0.0f, 1.0f, right.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_affine(Float3x3 right) {
        return new Float3x3(right.m00(), right.m01(), right.m02() + this.m02, right.m10(), right.m11(), right.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_translation(Float3x3 right, int _props) {
        return new Float3x3(this.m00, this.m01, Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m10, this.m11, Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_affine(Float3x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m11, -(right.m10() * this.m10)), Math.fma(right.m01(), this.m11, -(right.m11() * this.m10)), Math.fma(-right.m12(), this.m10, Math.fma(right.m02(), this.m11, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine_affine(Float3x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_translation(Float3x3 right) {
        return new Float3x3(this.m00, this.m01, Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m10, this.m11, Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), this.m20, this.m21, Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), 0);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_affine(Float3x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), 0);
    }


    /**
     * Multiply this matrix by {@code right}, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @return the resulting matrix
     */
    public Float3x3 mul(Float3x3 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return right;
        int q = right.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right);
            return mul_translation(right);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_ORTHOGONAL & right.properties());
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_orthogonal_affine(right);
            return mul_orthogonal(right);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_AFFINE & right.properties());
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_affine(right);
            return mul_affine(right);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_general_affine(right);
        return mul_general(right);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}, {@code m20}, {@code m21}, {@code m22}), returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
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
     * @return the resulting matrix
     */
    public Float3x3 mul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        return new Float3x3(Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01)), Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01)), Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01)), Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11)), Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11)), Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11)), Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21)), Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21)), Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21)), 0);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity(Float2x2 right) {
        return new Float3x3(right.m00(), right.m01(), 0.0f, right.m10(), right.m11(), 0.0f, 0.0f, 0.0f, 1.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float2x2 right) {
        return new Float3x3(right.m00(), right.m01(), this.m02, right.m10(), right.m11(), this.m12, 0.0f, 0.0f, 1.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float2x2 right) {
        return new Float3x3(Math.fma(right.m00(), this.m11, -(right.m10() * this.m10)), Math.fma(right.m01(), this.m11, -(right.m11() * this.m10)), this.m02, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), this.m12, 0.0f, 0.0f, 1.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float2x2 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), this.m02, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float2x2 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), this.m02, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), this.m12, Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), this.m22, 0);
    }


    /**
     * Multiply this matrix by {@code right}, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return the resulting matrix
     */
    public Float3x3 mul(Float2x2 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine(right);
        return mul_general(right);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general(Float2x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), 0);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity(Float2x3 right) {
        return new Float3x3(right.m00(), right.m01(), right.m02(), right.m10(), right.m11(), right.m12(), 0.0f, 0.0f, 1.0f, right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation(Float2x3 right) {
        return new Float3x3(right.m00(), right.m01(), right.m02() + this.m02, right.m10(), right.m11(), right.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal(Float2x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m11, -(right.m10() * this.m10)), Math.fma(right.m01(), this.m11, -(right.m11() * this.m10)), Math.fma(-right.m12(), this.m10, Math.fma(right.m02(), this.m11, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_affine(Float2x3 right) {
        return new Float3x3(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_identity_translation(Float2x3 right) {
        return new Float3x3(1.0f, 0.0f, right.m02(), 0.0f, 1.0f, right.m12(), 0.0f, 0.0f, 1.0f, right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_translation_translation(Float2x3 right) {
        return new Float3x3(1.0f, 0.0f, right.m02() + this.m02, 0.0f, 1.0f, right.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_orthogonal_translation(Float2x3 right, int _props) {
        return new Float3x3(this.m00, this.m01, Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m10, this.m11, Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x3 mul_general_translation(Float2x3 right) {
        return new Float3x3(this.m00, this.m01, Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m10, this.m11, Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), this.m20, this.m21, Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), 0);
    }


    /**
     * Multiply this matrix by {@code right}, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return the resulting matrix
     */
    public Float3x3 mul(Float2x3 right) {
        int p = this.properties;
        int q = right.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_identity_translation(right);
            return mul_identity(right);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right);
            return mul_translation(right);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_ORTHOGONAL & right.properties());
            return mul_orthogonal(right);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_AFFINE & right.properties());
            return mul_affine(right);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right);
        return mul_general(right);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float3x3 other) {
        return new Float3x3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)), Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)), Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)), 0);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float3x3 other) {
        return new Float3x3(other.m00(), other.m01(), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), other.m10(), other.m11(), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), other.m20(), other.m21(), Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22())), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float3x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m11, other.m01() * this.m10), Math.fma(other.m01(), this.m11, -(other.m00() * this.m10)), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m11, other.m11() * this.m10), Math.fma(other.m11(), this.m11, -(other.m10() * this.m10)), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), Math.fma(other.m20(), this.m11, other.m21() * this.m10), Math.fma(other.m21(), this.m11, -(other.m20() * this.m10)), Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22())), Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float3x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), Math.fma(other.m20(), this.m00, other.m21() * this.m10), Math.fma(other.m20(), this.m01, other.m21() * this.m11), Math.fma(other.m20(), this.m02, Math.fma(other.m21(), this.m12, other.m22())), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_translation(Float3x3 other) {
        return new Float3x3(1.0f, 0.0f, other.m02() + this.m02, 0.0f, 1.0f, other.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_affine(Float3x3 other) {
        return new Float3x3(other.m00(), other.m01(), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), other.m10(), other.m11(), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_translation(Float3x3 other, int _props) {
        return new Float3x3(this.m00, this.m01, other.m02() + this.m02, this.m10, this.m11, other.m12() + this.m12, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_affine(Float3x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m11, other.m01() * this.m10), Math.fma(other.m01(), this.m11, -(other.m00() * this.m10)), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m11, other.m11() * this.m10), Math.fma(other.m11(), this.m11, -(other.m10() * this.m10)), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine_affine(Float3x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_translation(Float3x3 other) {
        return new Float3x3(Math.fma(other.m02(), this.m20, this.m00), Math.fma(other.m02(), this.m21, this.m01), Math.fma(other.m02(), this.m22, this.m02), Math.fma(other.m12(), this.m20, this.m10), Math.fma(other.m12(), this.m21, this.m11), Math.fma(other.m12(), this.m22, this.m12), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_affine(Float3x3 other) {
        return new Float3x3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 preMul(Float3x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return other;
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other);
            return preMul_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_ORTHOGONAL & other.properties());
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_orthogonal_affine(other);
            return preMul_orthogonal(other);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_AFFINE & other.properties());
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_affine(other);
            return preMul_affine(other);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_general_affine(other);
        return preMul_general(other);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
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
     * @return the resulting matrix
     */
    public Float3x3 preMul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        return new Float3x3(Math.fma(m02, this.m20, Math.fma(m00, this.m00, m01 * this.m10)), Math.fma(m02, this.m21, Math.fma(m00, this.m01, m01 * this.m11)), Math.fma(m02, this.m22, Math.fma(m00, this.m02, m01 * this.m12)), Math.fma(m12, this.m20, Math.fma(m10, this.m00, m11 * this.m10)), Math.fma(m12, this.m21, Math.fma(m10, this.m01, m11 * this.m11)), Math.fma(m12, this.m22, Math.fma(m10, this.m02, m11 * this.m12)), Math.fma(m22, this.m20, Math.fma(m20, this.m00, m21 * this.m10)), Math.fma(m22, this.m21, Math.fma(m20, this.m01, m21 * this.m11)), Math.fma(m22, this.m22, Math.fma(m20, this.m02, m21 * this.m12)), 0);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity(Float2x2 other) {
        return new Float3x3(other.m00(), other.m01(), 0.0f, other.m10(), other.m11(), 0.0f, 0.0f, 0.0f, 1.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float2x2 other) {
        return new Float3x3(other.m00(), other.m01(), Math.fma(other.m00(), this.m02, other.m01() * this.m12), other.m10(), other.m11(), Math.fma(other.m10(), this.m02, other.m11() * this.m12), 0.0f, 0.0f, 1.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float2x2 other) {
        return new Float3x3(Math.fma(other.m00(), this.m11, other.m01() * this.m10), Math.fma(other.m01(), this.m11, -(other.m00() * this.m10)), Math.fma(other.m00(), this.m02, other.m01() * this.m12), Math.fma(other.m10(), this.m11, other.m11() * this.m10), Math.fma(other.m11(), this.m11, -(other.m10() * this.m10)), Math.fma(other.m10(), this.m02, other.m11() * this.m12), 0.0f, 0.0f, 1.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float2x2 other) {
        return new Float3x3(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, other.m01() * this.m12), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, other.m11() * this.m12), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float2x2 other) {
        return new Float3x3(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, other.m01() * this.m12), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, other.m11() * this.m12), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply {@code other} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 preMul(Float2x2 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine(other);
        return preMul_general(other);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general(Float2x3 other) {
        return new Float3x3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity(Float2x3 other) {
        return new Float3x3(other.m00(), other.m01(), other.m02(), other.m10(), other.m11(), other.m12(), 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation(Float2x3 other) {
        return new Float3x3(other.m00(), other.m01(), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), other.m10(), other.m11(), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal(Float2x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m11, other.m01() * this.m10), Math.fma(other.m01(), this.m11, -(other.m00() * this.m10)), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m11, other.m11() * this.m10), Math.fma(other.m11(), this.m11, -(other.m10() * this.m10)), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_affine(Float2x3 other) {
        return new Float3x3(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, Math.fma(other.m01(), this.m12, other.m02())), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, Math.fma(other.m11(), this.m12, other.m12())), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_identity_translation(Float2x3 other) {
        return new Float3x3(1.0f, 0.0f, other.m02(), 0.0f, 1.0f, other.m12(), 0.0f, 0.0f, 1.0f, other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_translation_translation(Float2x3 other) {
        return new Float3x3(1.0f, 0.0f, other.m02() + this.m02, 0.0f, 1.0f, other.m12() + this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_orthogonal_translation(Float2x3 other, int _props) {
        return new Float3x3(this.m00, this.m01, other.m02() + this.m02, this.m10, this.m11, other.m12() + this.m12, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x3 preMul_general_translation(Float2x3 other) {
        return new Float3x3(Math.fma(other.m02(), this.m20, this.m00), Math.fma(other.m02(), this.m21, this.m01), Math.fma(other.m02(), this.m22, this.m02), Math.fma(other.m12(), this.m20, this.m10), Math.fma(other.m12(), this.m21, this.m11), Math.fma(other.m12(), this.m22, this.m12), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply {@code other} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x3 preMul(Float2x3 other) {
        int p = this.properties;
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_identity_translation(other);
            return preMul_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other);
            return preMul_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_ORTHOGONAL & other.properties());
            return preMul_orthogonal(other);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_AFFINE & other.properties());
            return preMul_affine(other);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other);
        return preMul_general(other);
    }


    /**
     * Create the outer product of {@code col} and {@code row}.
     *
     * @param col the column vector (left operand)
     * @param row the row vector (right operand)
     * @return the resulting matrix
     */
    public static Float3x3 makeOuterProduct(Float3 col, Float3 row) {
        return makeOuterProduct(col.x(), col.y(), col.z(), row.x(), row.y(), row.z());
    }


    /**
     * Create the outer product of ({@code colX}, {@code colY}, {@code colZ}) and ({@code rowX},
     * {@code rowY}, {@code rowZ}).
     *
     * @param colX the {@code x} component of the vector {@code (colX, colY, colZ)}
     * @param colY the {@code y} component of the vector {@code (colX, colY, colZ)}
     * @param colZ the {@code z} component of the vector {@code (colX, colY, colZ)}
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @return the resulting matrix
     */
    public static Float3x3 makeOuterProduct(float colX, float colY, float colZ, float rowX, float rowY, float rowZ) {
        return new Float3x3(colX * rowX, colX * rowY, colX * rowZ, colY * rowX, colY * rowY, colY * rowZ, colZ * rowX, colZ * rowY, colZ * rowZ, 0);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public Float3x3 lookAlong(Float3 dir, Float3 up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    /** Private per-column body of {@code lookAlong}; reached only through it. */
    private Float3 lookAlong_s524747ee_c0(float _t26, float _t27, float _t28) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28)));
    }

    /** Private per-column body of {@code lookAlong}; reached only through it. */
    private Float3 lookAlong_s524747ee_c1(float _t35, float _t36, float _t37) {
        return new Float3(Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37)), Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37)), Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37)));
    }

    /** Private per-column body of {@code lookAlong}; reached only through it. */
    private Float3 lookAlong_s524747ee_c2(float _t9, float _t8, float _t7) {
        return new Float3(Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7)), Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7)), Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7)));
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public Float3x3 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        float _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        float _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        float _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        return new Float3x3(lookAlong_s524747ee_c0(_t26, _t27, _t28), lookAlong_s524747ee_c1(_t35, _t36, _t37), lookAlong_s524747ee_c2(_t9, _t8, _t7), 0);
    }


    /**
     * Create the rotation part of the unit dual quaternion {@code dq} (the encoded translation is
     * dropped).
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return the resulting matrix
     */
    public static Float3x3 makeFromDualQuat(FloatDualQuat dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Create the rotation part of the unit dual quaternion ({@code dqRX}, {@code dqRY},
     * {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ}, {@code dqDW}) (the
     * encoded translation is dropped).
     *
     * @param dqRX the {@code rX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqRY the {@code rY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqRZ the {@code rZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqRW the {@code rW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqDX the {@code dX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqDY the {@code dY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqDZ the {@code dZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @param dqDW the {@code dW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the dual quaternion must
     *        have unit length)
     * @return the resulting matrix
     */
    public static Float3x3 makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        return new Float3x3(Math.fma(-2.0f, _t0, _t6), Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY), 2.0f * Math.fma(dqRX, dqRZ, _t3), 2.0f * Math.fma(dqRX, dqRY, _t2), Math.fma(-2.0f, _t4, _t6), Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5), Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ), 2.0f * Math.fma(dqRX, dqRW, _t5), Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)), 0);
    }


    /**
     * Create a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x3 makeRotation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, -_t1, 0.0f, _t1, _t0, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationAxis(float angle, Float3 axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Create a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        return new Float3x3(Math.fma(_t2, axisX * axisX, _t0), Math.fma(_t2, _t3, -(axisZ * _t1)), Math.fma(axisY, _t1, _t2 * _t4), Math.fma(axisZ, _t1, _t2 * _t3), Math.fma(_t2, axisY * axisY, _t0), Math.fma(_t2, _t5, -(axisX * _t1)), Math.fma(_t2, _t4, -(axisY * _t1)), Math.fma(axisX, _t1, _t2 * _t5), Math.fma(_t2, axisZ * axisZ, _t0), 0);
    }


    /**
     * Create a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationLookAlong(Float3 dir, Float3 up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Create a rotation that makes {@code +z} point along ({@code dirX}, {@code dirY},
     * {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26, _t27, _t28;
        if (_t21 > 0.0f) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0f;
            _t27 = 0.0f;
            _t28 = 0.0f;
        }
        return new Float3x3(_t26, Math.fma(_t7, _t27, -(_t9 * _t28)), _t8, _t28, Math.fma(_t9, _t26, -(_t8 * _t27)), _t7, _t27, Math.fma(_t8, _t28, -(_t7 * _t26)), _t9, 0);
    }


    /**
     * Create the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationQuat(FloatQuat q) {
        return makeRotationQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Create the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}).
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationQuat(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        return new Float3x3(Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f), 2.0f * Math.fma(qX, qY, -_t1), 2.0f * Math.fma(qX, qZ, _t2), 2.0f * Math.fma(qX, qY, _t1), Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f), 2.0f * Math.fma(qY, qZ, -(qX * qW)), 2.0f * Math.fma(qX, qZ, -_t2), 2.0f * Math.fma(qX, qW, qY * qZ), Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f), 0);
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationX(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, _t0, -_t1, 0.0f, _t1, _t0, 0);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        return new Float3x3(_t0 * _t1, -(_t2 * _t0), _t3, Math.fma(_t6, _t1, _t2 * _t5), Math.fma(_t5, _t1, -(_t6 * _t2)), -(_t4 * _t0), Math.fma(_t4, _t2, -(_t7 * _t1)), Math.fma(_t7, _t2, _t4 * _t1), _t5 * _t0, 0);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationXZY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        return new Float3x3(_t0 * _t1, -_t2, _t3 * _t1, Math.fma(_t6, _t0, _t5 * _t3), _t4 * _t1, Math.fma(_t6, _t3, -(_t5 * _t0)), Math.fma(_t7, _t0, -(_t3 * _t4)), _t5 * _t1, Math.fma(_t7, _t3, _t4 * _t0), 0);
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationY(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, 0.0f, _t1, 0.0f, 1.0f, 0.0f, -_t1, 0.0f, _t0, 0);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        return new Float3x3(Math.fma(_t6, _t2, _t3 * _t4), Math.fma(_t6, _t4, -(_t2 * _t3)), _t1 * _t5, _t2 * _t5, _t5 * _t4, -_t0, Math.fma(_t7, _t2, -(_t1 * _t4)), Math.fma(_t7, _t4, _t1 * _t2), _t5 * _t3, 0);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationYZX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        return new Float3x3(_t0 * _t1, Math.fma(_t2, _t3, -(_t6 * _t5)), Math.fma(_t6, _t2, _t3 * _t5), _t4, _t5 * _t1, -(_t2 * _t1), -(_t3 * _t1), Math.fma(_t7, _t5, _t2 * _t0), Math.fma(_t5, _t0, -(_t7 * _t2)), 0);
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationZ(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, -_t1, 0.0f, _t1, _t0, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationZXY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        return new Float3x3(Math.fma(_t0, _t1, -(_t6 * _t4)), -(_t3 * _t5), Math.fma(_t6, _t0, _t4 * _t1), Math.fma(_t7, _t4, _t3 * _t0), _t5 * _t1, Math.fma(_t4, _t3, -(_t7 * _t0)), -(_t4 * _t5), _t2, _t5 * _t0, 0);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x3 makeRotationZYX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        return new Float3x3(_t0 * _t1, Math.fma(_t6, _t3, -(_t4 * _t5)), Math.fma(_t6, _t5, _t3 * _t4), _t4 * _t0, Math.fma(_t7, _t3, _t5 * _t1), Math.fma(_t7, _t5, -(_t3 * _t1)), -_t2, _t3 * _t0, _t5 * _t0, 0);
    }


    /**
     * Create a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return the resulting matrix
     */
    public static Float3x3 makeScaling(Float2 v) {
        return makeScaling(v.x(), v.y());
    }


    /**
     * Create a scaling transformation that scales by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return the resulting matrix
     */
    public static Float3x3 makeScaling(float vX, float vY) {
        return new Float3x3(vX, 0.0f, 0.0f, 0.0f, vY, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return the resulting matrix
     */
    public static Float3x3 makeScaling(float s) {
        return new Float3x3(s, 0.0f, 0.0f, 0.0f, s, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return the resulting matrix
     */
    public static Float3x3 makeTranslation(Float2 v) {
        return makeTranslation(v.x(), v.y());
    }


    /**
     * Create a translation transformation that translates by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return the resulting matrix
     */
    public static Float3x3 makeTranslation(float vX, float vY) {
        return new Float3x3(1.0f, 0.0f, vX, 0.0f, 1.0f, vY, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Create the 2D view transformation that maps the rectangle
     * {@code [left, right] x [bottom, top]} onto {@code [-1, +1] x [-1, +1]}.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return the resulting matrix
     */
    public static Float3x3 makeView(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        return new Float3x3(2.0f * _t0_inv, 0.0f, -((left + right) * _t0_inv), 0.0f, 2.0f * _t1_inv, -((bottom + top) * _t1_inv), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, -_t1, 0.0f, _t1, _t0, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, -_t1, Math.fma(this.m02, _t0, -(this.m12 * _t1)), _t1, _t0, Math.fma(this.m02, _t1, this.m12 * _t0), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(this.m02, _t0, -(this.m12 * _t1)), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(this.m02, _t1, this.m12 * _t0), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_affine(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(this.m02, _t0, -(this.m12 * _t1)), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(this.m02, _t1, this.m12 * _t0), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Float3x3 preRotate_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(this.m02, _t0, -(this.m12 * _t1)), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(this.m02, _t1, this.m12 * _t0), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 preRotate(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotate_orthogonal(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_affine(angle);
        return preRotate_general(angle);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 preRotateAround(float angle, Float2 pivot) {
        return preRotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_identity(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        return new Float3x3(_t0, -_t1, Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX)), _t1, _t0, Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_translation(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        return new Float3x3(_t0, -_t1, Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(this.m02, _t0, Math.fma(-this.m12, _t1, pivotX)))), _t1, _t0, Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(this.m02, _t1, Math.fma(this.m12, _t0, pivotY)))), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_orthogonal(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(this.m02, _t0, Math.fma(-this.m12, _t1, pivotX)))), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(this.m02, _t1, Math.fma(this.m12, _t0, pivotY)))), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_affine(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(this.m02, _t0, Math.fma(-this.m12, _t1, pivotX)))), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(this.m02, _t1, Math.fma(this.m12, _t0, pivotY)))), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x3 preRotateAround_general(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t0, Math.fma(_t2, _t1, pivotX));
        float _t7 = Math.fma(_t2, _t0, Math.fma(-pivotY, _t1, pivotY));
        return new Float3x3(Math.fma(this.m20, _t6, Math.fma(this.m00, _t1, -(this.m10 * _t0))), Math.fma(this.m21, _t6, Math.fma(this.m01, _t1, -(this.m11 * _t0))), Math.fma(this.m22, _t6, Math.fma(this.m02, _t1, -(this.m12 * _t0))), Math.fma(this.m20, _t7, Math.fma(this.m00, _t0, this.m10 * _t1)), Math.fma(this.m21, _t7, Math.fma(this.m01, _t0, this.m11 * _t1)), Math.fma(this.m22, _t7, Math.fma(this.m02, _t0, this.m12 * _t1)), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 preRotateAround(float angle, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(angle, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(angle, pivotX, pivotY);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(angle, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAround_affine(angle, pivotX, pivotY);
        return preRotateAround_general(angle, pivotX, pivotY);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting matrix
     */
    public Float3x3 preRotateAxis(float angle, Float3 axis) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_identity(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        return new Float3x3(Math.fma(_t2, axisX * axisX, _t0), Math.fma(_t2, _t3, -(axisZ * _t1)), Math.fma(axisY, _t1, _t2 * _t4), Math.fma(axisZ, _t1, _t2 * _t3), Math.fma(_t2, axisY * axisY, _t0), Math.fma(_t2, _t5, -(axisX * _t1)), Math.fma(_t2, _t4, -(axisY * _t1)), Math.fma(axisX, _t1, _t2 * _t5), Math.fma(_t2, axisZ * axisZ, _t0), 0);
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_translation(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t4 = axisX * axisY;
        float _t6 = axisX * axisZ;
        float _t8 = axisY * axisZ;
        float _t14 = Math.fma(_t2, axisX * axisX, _t0);
        float _t15 = Math.fma(_t2, axisY * axisY, _t0);
        float _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        float _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        float _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        float _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        return new Float3x3(_t14, _t18, Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(this.m02, _t14, this.m12 * _t18), _t16, _t15, Math.fma(this.m02, _t16, this.m12 * _t15) + Math.fma(_t2, _t8, -(axisX * _t1)), _t19, _t17, Math.fma(this.m02, _t19, Math.fma(this.m12, _t17, Math.fma(_t2, axisZ * axisZ, _t0))), 0);
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c0(float _t14, float _t18, float _t16, float _t15, float _t19, float _t17) {
        return new Float3(Math.fma(this.m00, _t14, this.m10 * _t18), Math.fma(this.m00, _t16, this.m10 * _t15), Math.fma(this.m00, _t19, this.m10 * _t17));
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c1(float _t14, float _t18, float _t16, float _t15, float _t19, float _t17) {
        return new Float3(Math.fma(this.m01, _t14, this.m11 * _t18), Math.fma(this.m01, _t16, this.m11 * _t15), Math.fma(this.m01, _t19, this.m11 * _t17));
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c2(float axisY, float _t1, float _t2, float _t6, float _t14, float _t18, float _t16, float _t15, float _t8, float axisX, float _t19, float _t17, float axisZ, float _t0) {
        return new Float3(Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(this.m02, _t14, this.m12 * _t18), Math.fma(this.m02, _t16, this.m12 * _t15) + Math.fma(_t2, _t8, -(axisX * _t1)), Math.fma(this.m02, _t19, Math.fma(this.m12, _t17, Math.fma(_t2, axisZ * axisZ, _t0))));
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t4 = axisX * axisY;
        float _t6 = axisX * axisZ;
        float _t8 = axisY * axisZ;
        float _t14 = Math.fma(_t2, axisX * axisX, _t0);
        float _t15 = Math.fma(_t2, axisY * axisY, _t0);
        float _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        float _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        float _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        float _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        return new Float3x3(preRotateAxis_orthogonal_s3b957671_c0(_t14, _t18, _t16, _t15, _t19, _t17), preRotateAxis_orthogonal_s3b957671_c1(_t14, _t18, _t16, _t15, _t19, _t17), preRotateAxis_orthogonal_s3b957671_c2(axisY, _t1, _t2, _t6, _t14, _t18, _t16, _t15, _t8, axisX, _t19, _t17, axisZ, _t0), 0);
    }

    /** Private per-column body of {@code preRotateAxis_general}; reached only through it. */
    private Float3 preRotateAxis_general_s3b957671_c0(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24)), Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19)), Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23)));
    }

    /** Private per-column body of {@code preRotateAxis_general}; reached only through it. */
    private Float3 preRotateAxis_general_s3b957671_c1(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24)), Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19)), Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23)));
    }

    /** Private per-column body of {@code preRotateAxis_general}; reached only through it. */
    private Float3 preRotateAxis_general_s3b957671_c2(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24)), Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19)), Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23)));
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x3 preRotateAxis_general(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t1);
        float _t19 = Math.fma(_t2, axisY * axisY, _t1);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        float _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        float _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        float _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        float _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        float _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        float _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        return new Float3x3(preRotateAxis_general_s3b957671_c0(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_general_s3b957671_c1(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_general_s3b957671_c2(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), 0);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting matrix
     */
    public Float3x3 preRotateAxis(float angle, float axisX, float axisY, float axisZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ);
        return preRotateAxis_general(angle, axisX, axisY, axisZ);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, _t0, -_t1, 0.0f, _t1, _t0, 0);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(1.0f, 0.0f, this.m02, 0.0f, _t0, Math.fma(this.m12, _t0, -_t1), 0.0f, _t1, Math.fma(this.m12, _t1, _t0), 0);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m00, this.m01, this.m02, this.m10 * _t0, this.m11 * _t0, Math.fma(this.m12, _t0, -_t1), this.m10 * _t1, this.m11 * _t1, Math.fma(this.m12, _t1, _t0), 0);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x3 preRotateX_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m00, this.m01, this.m02, Math.fma(this.m10, _t0, -(this.m20 * _t1)), Math.fma(this.m11, _t0, -(this.m21 * _t1)), Math.fma(this.m12, _t0, -(this.m22 * _t1)), Math.fma(this.m10, _t1, this.m20 * _t0), Math.fma(this.m11, _t1, this.m21 * _t0), Math.fma(this.m12, _t1, this.m22 * _t0), 0);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 preRotateX(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateX_orthogonal(angle);
        return preRotateX_general(angle);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, 0.0f, _t1, 0.0f, 1.0f, 0.0f, -_t1, 0.0f, _t0, 0);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, 0.0f, Math.fma(this.m02, _t0, _t1), 0.0f, 1.0f, this.m12, -_t1, 0.0f, Math.fma(-this.m02, _t1, _t0), 0);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m11 * _t0, -(this.m10 * _t0), Math.fma(this.m02, _t0, _t1), this.m10, this.m11, this.m12, -(this.m11 * _t1), this.m10 * _t1, Math.fma(-this.m02, _t1, _t0), 0);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_affine(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m00 * _t0, this.m01 * _t0, Math.fma(this.m02, _t0, _t1), this.m10, this.m11, this.m12, -(this.m00 * _t1), -(this.m01 * _t1), Math.fma(-this.m02, _t1, _t0), 0);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x3 preRotateY_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, this.m20 * _t1), Math.fma(this.m01, _t0, this.m21 * _t1), Math.fma(this.m02, _t0, this.m22 * _t1), this.m10, this.m11, this.m12, Math.fma(this.m20, _t0, -(this.m00 * _t1)), Math.fma(this.m21, _t0, -(this.m01 * _t1)), Math.fma(this.m22, _t0, -(this.m02 * _t1)), 0);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 preRotateY(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateY_affine(angle);
        return preRotateY_general(angle);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 preRotateZ(float angle) {
        return preRotate(angle);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return the resulting matrix
     */
    public Float3x3 preScale(Float2 v) {
        return preScale(v.x(), v.y());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity(float vX, float vY) {
        return new Float3x3(vX, 0.0f, 0.0f, 0.0f, vY, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation(float vX, float vY) {
        return new Float3x3(vX, 0.0f, this.m02 * vX, 0.0f, vY, this.m12 * vY, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal(float vX, float vY) {
        return new Float3x3(this.m00 * vX, this.m01 * vX, this.m02 * vX, this.m10 * vY, this.m11 * vY, this.m12 * vY, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_general(float vX, float vY) {
        return new Float3x3(this.m00 * vX, this.m01 * vX, this.m02 * vX, this.m10 * vY, this.m11 * vY, this.m12 * vY, this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix, returning the result as
     * a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return the resulting matrix
     */
    public Float3x3 preScale(float vX, float vY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(vX, vY);
        return preScale_general(vX, vY);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_identity(float s) {
        return new Float3x3(s, 0.0f, 0.0f, 0.0f, s, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_translation(float s) {
        return new Float3x3(s, 0.0f, s * this.m02, 0.0f, s, s * this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_orthogonal(float s) {
        return new Float3x3(s * this.m00, s * this.m01, s * this.m02, s * this.m10, s * this.m11, s * this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x3 preScale_general(float s) {
        return new Float3x3(s * this.m00, s * this.m01, s * this.m02, s * this.m10, s * this.m11, s * this.m12, this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return the resulting matrix
     */
    public Float3x3 preScale(float s) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(s);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(s);
        return preScale_general(s);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 preScaleAround(float s, Float2 pivot) {
        return preScaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity(float s, float pivotX, float pivotY) {
        return new Float3x3(s, 0.0f, Math.fma(-s, pivotX, pivotX), 0.0f, s, Math.fma(-s, pivotY, pivotY), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation(float s, float pivotX, float pivotY) {
        return new Float3x3(s, 0.0f, Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX)), 0.0f, s, Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal(float s, float pivotX, float pivotY) {
        return new Float3x3(s * this.m00, s * this.m01, Math.fma(-s, pivotX, Math.fma(s, this.m02, pivotX)), s * this.m10, s * this.m11, Math.fma(-s, pivotY, Math.fma(s, this.m12, pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_general(float s, float pivotX, float pivotY) {
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        return new Float3x3(Math.fma(s, this.m00, this.m20 * _t0), Math.fma(s, this.m01, this.m21 * _t0), Math.fma(s, this.m02, this.m22 * _t0), Math.fma(s, this.m10, this.m20 * _t1), Math.fma(s, this.m11, this.m21 * _t1), Math.fma(s, this.m12, this.m22 * _t1), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY})
     * onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 preScaleAround(float s, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(s, pivotX, pivotY);
        return preScaleAround_general(s, pivotX, pivotY);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 preScaleAround(Float2 s, Float2 pivot) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_identity(float sX, float sY, float pivotX, float pivotY) {
        return new Float3x3(sX, 0.0f, Math.fma(-pivotX, sX, pivotX), 0.0f, sY, Math.fma(-pivotY, sY, pivotY), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_translation(float sX, float sY, float pivotX, float pivotY) {
        return new Float3x3(sX, 0.0f, Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX)), 0.0f, sY, Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_orthogonal(float sX, float sY, float pivotX, float pivotY) {
        return new Float3x3(sX * this.m00, sX * this.m01, Math.fma(-pivotX, sX, Math.fma(sX, this.m02, pivotX)), sY * this.m10, sY * this.m11, Math.fma(-pivotY, sY, Math.fma(sY, this.m12, pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x3 preScaleAround_general(float sX, float sY, float pivotX, float pivotY) {
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        return new Float3x3(Math.fma(sX, this.m00, this.m20 * _t2), Math.fma(sX, this.m01, this.m21 * _t2), Math.fma(sX, this.m02, this.m22 * _t2), Math.fma(sY, this.m10, this.m20 * _t3), Math.fma(sY, this.m11, this.m21 * _t3), Math.fma(sY, this.m12, this.m22 * _t3), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 preScaleAround(float sX, float sY, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(sX, sY, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(sX, sY, pivotX, pivotY);
        return preScaleAround_general(sX, sY, pivotX, pivotY);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return the resulting matrix
     */
    public Float3x3 preTranslate(Float2 v) {
        return preTranslate(v.x(), v.y());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_identity(float vX, float vY) {
        return new Float3x3(1.0f, 0.0f, vX, 0.0f, 1.0f, vY, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_translation(float vX, float vY) {
        return new Float3x3(1.0f, 0.0f, this.m02 + vX, 0.0f, 1.0f, this.m12 + vY, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_orthogonal(float vX, float vY) {
        return new Float3x3(this.m00, this.m01, this.m02 + vX, this.m10, this.m11, this.m12 + vY, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_affine(float vX, float vY) {
        return new Float3x3(this.m00, this.m01, this.m02 + vX, this.m10, this.m11, this.m12 + vY, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x3 preTranslate_general(float vX, float vY) {
        return new Float3x3(Math.fma(this.m20, vX, this.m00), Math.fma(this.m21, vX, this.m01), Math.fma(this.m22, vX, this.m02), Math.fma(this.m20, vY, this.m10), Math.fma(this.m21, vY, this.m11), Math.fma(this.m22, vY, this.m12), this.m20, this.m21, this.m22, 0);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix, returning the result
     * as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return the resulting matrix
     */
    public Float3x3 preTranslate(float vX, float vY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preTranslate_affine(vX, vY);
        return preTranslate_general(vX, vY);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_identity(float angle) {
        return preRotate_identity(angle);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(_t0, -_t1, this.m02, _t1, _t0, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), this.m02, Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_affine(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), this.m02, Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Float3x3 rotate_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), this.m02, Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), this.m12, Math.fma(this.m20, _t0, this.m21 * _t1), Math.fma(this.m21, _t0, -(this.m20 * _t1)), this.m22, 0);
    }


    /**
     * Apply a rotation by {@code angle} to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 rotate(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotate_orthogonal(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_affine(angle);
        return rotate_general(angle);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 rotateAround(float angle, Float2 pivot) {
        return rotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_identity(float angle, float pivotX, float pivotY) {
        return preRotateAround_identity(angle, pivotX, pivotY);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_translation(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        return new Float3x3(_t0, -_t1, Math.fma(pivotY, _t1, Math.fma(_t2, _t0, this.m02 + pivotX)), _t1, _t0, Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, this.m12 + pivotY)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_orthogonal(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        float _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), Math.fma(this.m00, _t6, Math.fma(this.m01, _t7, this.m02)), Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), Math.fma(this.m10, _t6, Math.fma(this.m11, _t7, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_affine(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        float _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), Math.fma(this.m00, _t6, Math.fma(this.m01, _t7, this.m02)), Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), Math.fma(this.m10, _t6, Math.fma(this.m11, _t7, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x3 rotateAround_general(float angle, float pivotX, float pivotY) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = -pivotX;
        float _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        float _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        return new Float3x3(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), Math.fma(this.m00, _t6, Math.fma(this.m01, _t7, this.m02)), Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), Math.fma(this.m10, _t6, Math.fma(this.m11, _t7, this.m12)), Math.fma(this.m20, _t0, this.m21 * _t1), Math.fma(this.m21, _t0, -(this.m20 * _t1)), Math.fma(this.m20, _t6, Math.fma(this.m21, _t7, this.m22)), 0);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 rotateAround(float angle, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(angle, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(angle, pivotX, pivotY);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(angle, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAround_affine(angle, pivotX, pivotY);
        return rotateAround_general(angle, pivotX, pivotY);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting matrix
     */
    public Float3x3 rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_identity(float angle, float axisX, float axisY, float axisZ) {
        return preRotateAxis_identity(angle, axisX, axisY, axisZ);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_translation(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        float _t6 = axisX * axisY;
        float _t10 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t11 = Math.fma(axisX, _t1, _t2 * _t5);
        float _t12 = Math.fma(_t2, _t3, -(axisY * _t1));
        return new Float3x3(Math.fma(_t2, axisX * axisX, Math.fma(this.m02, _t12, _t0)), Math.fma(this.m02, _t11, Math.fma(_t2, _t6, -(axisZ * _t1))), Math.fma(this.m02, _t10, Math.fma(axisY, _t1, _t2 * _t3)), Math.fma(this.m12, _t12, Math.fma(axisZ, _t1, _t2 * _t6)), Math.fma(_t2, axisY * axisY, Math.fma(this.m12, _t11, _t0)), Math.fma(this.m12, _t10, Math.fma(_t2, _t5, -(axisX * _t1))), _t12, _t11, _t10, 0);
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c0(float _t24, float _t18, float _t21) {
        return new Float3(Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21)), Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21)), _t24);
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c1(float _t22, float _t25, float _t19) {
        return new Float3(Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19)), Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19)), _t22);
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c2(float _t20, float _t23, float _t26) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26)), _t20);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        return new Float3x3(rotateAxis_orthogonal_s3b957671_c0(_t24, _t18, _t21), rotateAxis_orthogonal_s3b957671_c1(_t22, _t25, _t19), rotateAxis_orthogonal_s3b957671_c2(_t20, _t23, _t26), 0);
    }

    /** Private per-column body of {@code rotateAxis_general}; reached only through it. */
    private Float3 rotateAxis_general_s3b957671_c0(float _t24, float _t18, float _t21) {
        return new Float3(Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21)), Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21)), Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21)));
    }

    /** Private per-column body of {@code rotateAxis_general}; reached only through it. */
    private Float3 rotateAxis_general_s3b957671_c1(float _t22, float _t25, float _t19) {
        return new Float3(Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19)), Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19)), Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19)));
    }

    /** Private per-column body of {@code rotateAxis_general}; reached only through it. */
    private Float3 rotateAxis_general_s3b957671_c2(float _t20, float _t23, float _t26) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26)));
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x3 rotateAxis_general(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        float _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        float _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        float _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        float _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        return new Float3x3(rotateAxis_general_s3b957671_c0(_t24, _t18, _t21), rotateAxis_general_s3b957671_c1(_t22, _t25, _t19), rotateAxis_general_s3b957671_c2(_t20, _t23, _t26), 0);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting matrix
     */
    public Float3x3 rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ);
        return rotateAxis_general(angle, axisX, axisY, axisZ);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_identity(float angle) {
        return preRotateX_identity(angle);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_translation(float angle) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        return new Float3x3(1.0f, this.m02 * _t0, this.m02 * _t1, 0.0f, Math.fma(this.m12, _t0, _t1), Math.fma(this.m12, _t1, -_t0), 0.0f, _t0, _t1, 0);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_orthogonal(float angle) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        return new Float3x3(this.m11, Math.fma(this.m02, _t0, -(this.m10 * _t1)), Math.fma(this.m02, _t1, this.m10 * _t0), this.m10, Math.fma(this.m11, _t1, this.m12 * _t0), Math.fma(this.m12, _t1, -(this.m11 * _t0)), 0.0f, _t0, _t1, 0);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_affine(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m00, Math.fma(this.m01, _t0, this.m02 * _t1), Math.fma(this.m02, _t0, -(this.m01 * _t1)), this.m10, Math.fma(this.m11, _t0, this.m12 * _t1), Math.fma(this.m12, _t0, -(this.m11 * _t1)), 0.0f, _t1, _t0, 0);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x3 rotateX_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(this.m00, Math.fma(this.m01, _t0, this.m02 * _t1), Math.fma(this.m02, _t0, -(this.m01 * _t1)), this.m10, Math.fma(this.m11, _t0, this.m12 * _t1), Math.fma(this.m12, _t0, -(this.m11 * _t1)), this.m20, Math.fma(this.m21, _t0, this.m22 * _t1), Math.fma(this.m22, _t0, -(this.m21 * _t1)), 0);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 rotateX(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX_affine(angle);
        return rotateX_general(angle);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_identity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_translation() {
        return new Float3x3(1.0f, 0.0f, -this.m02, 0.0f, -1.0f, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_orthogonal() {
        return new Float3x3(this.m11, this.m10, -this.m02, this.m10, -this.m11, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_affine() {
        return new Float3x3(this.m00, -this.m01, -this.m02, this.m10, -this.m11, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Float3x3 rotateX180_general() {
        return new Float3x3(this.m00, -this.m01, -this.m02, this.m10, -this.m11, -this.m12, this.m20, -this.m21, -this.m22, 0);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateX180() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX180_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX180_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX180_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX180_affine();
        return rotateX180_general();
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_identity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_translation() {
        return new Float3x3(1.0f, -this.m02, 0.0f, 0.0f, -this.m12, 1.0f, 0.0f, -1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_orthogonal() {
        return new Float3x3(this.m00, -this.m02, this.m01, this.m10, -this.m12, this.m11, 0.0f, -1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Float3x3 rotateX270_general() {
        return new Float3x3(this.m00, -this.m02, this.m01, this.m10, -this.m12, this.m11, this.m20, -this.m22, this.m21, 0);
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateX270() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX270_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX270_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX270_orthogonal();
        return rotateX270_general();
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_identity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_translation() {
        return new Float3x3(1.0f, this.m02, 0.0f, 0.0f, this.m12, -1.0f, 0.0f, 1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_orthogonal() {
        return new Float3x3(this.m11, this.m02, this.m10, this.m10, this.m12, -this.m11, 0.0f, 1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_affine() {
        return new Float3x3(this.m00, this.m02, -this.m01, this.m10, this.m12, -this.m11, 0.0f, 1.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Float3x3 rotateX90_general() {
        return new Float3x3(this.m00, this.m02, -this.m01, this.m10, this.m12, -this.m11, this.m20, this.m22, -this.m21, 0);
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateX90() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX90_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX90_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX90_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX90_affine();
        return rotateX90_general();
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        return new Float3x3(_t0 * _t1, -(_t2 * _t0), _t3, Math.fma(_t6, _t1, _t2 * _t5), Math.fma(_t5, _t1, -(_t6 * _t2)), -(_t4 * _t0), Math.fma(_t4, _t2, -(_t7 * _t1)), Math.fma(_t7, _t2, _t4 * _t1), _t5 * _t0, 0);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t8 = _t3 * _t5;
        float _t9 = _t0 * _t2;
        float _t12 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t13 = Math.fma(_t0, _t1, -(_t6 * _t4));
        return new Float3x3(Math.fma(this.m02, _t13, _t5 * _t4), Math.fma(this.m02, _t12, -(_t1 * _t5)), Math.fma(this.m02, _t8, _t2), Math.fma(this.m12, _t13, Math.fma(_t9, _t4, _t1 * _t3)), Math.fma(this.m12, _t12, Math.fma(_t3, _t4, -(_t9 * _t1))), Math.fma(this.m12, _t8, -(_t0 * _t5)), _t13, _t12, _t8, 0);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        return new Float3x3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18)), Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11))), Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13))), Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18)), Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11))), Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13))), _t20, _t19, _t12, 0);
    }

    /** Private per-column body of {@code rotateXYZ_general}; reached only through it. */
    private Float3 rotateXYZ_general_s6e793366_c0(float _t20, float _t7, float _t18) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t7, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateXYZ_general}; reached only through it. */
    private Float3 rotateXYZ_general_s6e793366_c1(float _t19, float _t21, float _t11) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11))), Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11))), Math.fma(this.m22, _t19, Math.fma(this.m21, _t21, -(this.m20 * _t11))));
    }

    /** Private per-column body of {@code rotateXYZ_general}; reached only through it. */
    private Float3 rotateXYZ_general_s6e793366_c2(float _t12, float _t2, float _t13) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13))), Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13))), Math.fma(this.m22, _t12, Math.fma(this.m20, _t2, -(this.m21 * _t13))));
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x3 rotateXYZ_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t7 = _t5 * _t4;
        float _t8 = _t0 * _t2;
        float _t11 = _t1 * _t5;
        float _t12 = _t3 * _t5;
        float _t13 = _t0 * _t5;
        float _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        float _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        float _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        float _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        return new Float3x3(rotateXYZ_general_s6e793366_c0(_t20, _t7, _t18), rotateXYZ_general_s6e793366_c1(_t19, _t21, _t11), rotateXYZ_general_s6e793366_c2(_t12, _t2, _t13), 0);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateXYZ(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXYZ_orthogonal(angleX, angleY, angleZ);
        return rotateXYZ_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        return new Float3x3(_t0 * _t1, -_t2, _t3 * _t1, Math.fma(_t6, _t0, _t5 * _t3), _t4 * _t1, Math.fma(_t6, _t3, -(_t5 * _t0)), Math.fma(_t7, _t0, -(_t3 * _t4)), _t5 * _t1, Math.fma(_t7, _t3, _t4 * _t0), 0);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t5;
        float _t10 = _t1 * _t4;
        float _t12 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        return new Float3x3(Math.fma(this.m02, _t13, _t2 * _t5), Math.fma(this.m02, _t8, -_t1), Math.fma(this.m02, _t12, _t3 * _t5), Math.fma(this.m12, _t13, Math.fma(_t10, _t2, _t0 * _t3)), Math.fma(this.m12, _t8, _t4 * _t5), Math.fma(this.m12, _t12, Math.fma(_t10, _t3, -(_t0 * _t2))), _t13, _t8, _t12, 0);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        return new Float3x3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18)), Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1))), Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18)), Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1))), Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21)), _t20, _t11, _t19, 0);
    }

    /** Private per-column body of {@code rotateXZY_general}; reached only through it. */
    private Float3 rotateXZY_general_s6e793366_c0(float _t20, float _t8, float _t18) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t8, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateXZY_general}; reached only through it. */
    private Float3 rotateXZY_general_s6e793366_c1(float _t11, float _t12, float _t1) {
        return new Float3(Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1))), Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1))), Math.fma(this.m22, _t11, Math.fma(this.m21, _t12, -(this.m20 * _t1))));
    }

    /** Private per-column body of {@code rotateXZY_general}; reached only through it. */
    private Float3 rotateXZY_general_s6e793366_c2(float _t19, float _t14, float _t21) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t14, this.m21 * _t21)));
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x3 rotateXZY_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t8 = _t2 * _t5;
        float _t9 = _t1 * _t4;
        float _t11 = _t0 * _t5;
        float _t12 = _t4 * _t5;
        float _t14 = _t3 * _t5;
        float _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        float _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        return new Float3x3(rotateXZY_general_s6e793366_c0(_t20, _t8, _t18), rotateXZY_general_s6e793366_c1(_t11, _t12, _t1), rotateXZY_general_s6e793366_c2(_t19, _t14, _t21), 0);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateXZY(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXZY_orthogonal(angleX, angleY, angleZ);
        return rotateXZY_general(angleX, angleY, angleZ);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateXn180() {
        return rotateX180();
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateXn270() {
        return rotateX90();
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateXn90() {
        return rotateX270();
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_identity(float angle) {
        return preRotateY_identity(angle);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_translation(float angle) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        return new Float3x3(Math.fma(-this.m02, _t0, _t1), 0.0f, Math.fma(this.m02, _t1, _t0), -(this.m12 * _t0), 1.0f, this.m12 * _t1, -_t0, 0.0f, _t1, 0);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m02 * _t1)), this.m01, Math.fma(this.m00, _t1, this.m02 * _t0), Math.fma(this.m10, _t0, -(this.m12 * _t1)), this.m11, Math.fma(this.m10, _t1, this.m12 * _t0), -_t1, 0.0f, _t0, 0);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x3 rotateY_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x3(Math.fma(this.m00, _t0, -(this.m02 * _t1)), this.m01, Math.fma(this.m00, _t1, this.m02 * _t0), Math.fma(this.m10, _t0, -(this.m12 * _t1)), this.m11, Math.fma(this.m10, _t1, this.m12 * _t0), Math.fma(this.m20, _t0, -(this.m22 * _t1)), this.m21, Math.fma(this.m20, _t1, this.m22 * _t0), 0);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 rotateY(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation(angle);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY_orthogonal(angle);
        return rotateY_general(angle);
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_identity() {
        return new Float3x3(-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_translation() {
        return new Float3x3(-1.0f, 0.0f, -this.m02, 0.0f, 1.0f, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_orthogonal() {
        return new Float3x3(-this.m00, this.m01, -this.m02, -this.m10, this.m11, -this.m12, 0.0f, 0.0f, -1.0f, 0);
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Float3x3 rotateY180_general() {
        return new Float3x3(-this.m00, this.m01, -this.m02, -this.m10, this.m11, -this.m12, -this.m20, this.m21, -this.m22, 0);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateY180() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY180_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY180_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY180_orthogonal();
        return rotateY180_general();
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_identity() {
        return new Float3x3(0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_translation() {
        return new Float3x3(this.m02, 0.0f, -1.0f, this.m12, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_orthogonal() {
        return new Float3x3(this.m02, this.m01, -this.m00, this.m12, this.m11, -this.m10, 1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Float3x3 rotateY270_general() {
        return new Float3x3(this.m02, this.m01, -this.m00, this.m12, this.m11, -this.m10, this.m22, this.m21, -this.m20, 0);
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateY270() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY270_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY270_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY270_orthogonal();
        return rotateY270_general();
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_identity() {
        return new Float3x3(0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_translation() {
        return new Float3x3(-this.m02, 0.0f, 1.0f, -this.m12, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_orthogonal() {
        return new Float3x3(-this.m02, this.m01, this.m00, -this.m12, this.m11, this.m10, -1.0f, 0.0f, 0.0f, 0);
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Float3x3 rotateY90_general() {
        return new Float3x3(-this.m02, this.m01, this.m00, -this.m12, this.m11, this.m10, -this.m22, this.m21, this.m20, 0);
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateY90() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY90_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY90_translation();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY90_orthogonal();
        return rotateY90_general();
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        return new Float3x3(Math.fma(_t6, _t2, _t3 * _t4), Math.fma(_t6, _t4, -(_t2 * _t3)), _t1 * _t5, _t2 * _t5, _t5 * _t4, -_t0, Math.fma(_t7, _t2, -(_t1 * _t4)), Math.fma(_t7, _t4, _t1 * _t2), _t5 * _t3, 0);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t5 * _t1;
        float _t12 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        return new Float3x3(Math.fma(this.m02, _t13, Math.fma(_t8, _t2, _t1 * _t4)), Math.fma(this.m02, _t12, Math.fma(_t8, _t4, -(_t2 * _t1))), Math.fma(this.m02, _t10, _t3 * _t5), Math.fma(this.m12, _t13, _t2 * _t5), Math.fma(this.m12, _t12, _t5 * _t4), Math.fma(this.m12, _t10, -_t0), _t13, _t12, _t10, 0);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        return new Float3x3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10)), Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13)), Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0))), Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13)), Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0))), _t20, _t19, _t14, 0);
    }

    /** Private per-column body of {@code rotateYXZ_general}; reached only through it. */
    private Float3 rotateYXZ_general_s6e793366_c0(float _t20, float _t18, float _t10) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t18, this.m21 * _t10)));
    }

    /** Private per-column body of {@code rotateYXZ_general}; reached only through it. */
    private Float3 rotateYXZ_general_s6e793366_c1(float _t19, float _t21, float _t13) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t21, this.m21 * _t13)));
    }

    /** Private per-column body of {@code rotateYXZ_general}; reached only through it. */
    private Float3 rotateYXZ_general_s6e793366_c2(float _t14, float _t15, float _t0) {
        return new Float3(Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0))), Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0))), Math.fma(this.m22, _t14, Math.fma(this.m20, _t15, -(this.m21 * _t0))));
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x3 rotateYXZ_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        return new Float3x3(rotateYXZ_general_s6e793366_c0(_t20, _t18, _t10), rotateYXZ_general_s6e793366_c1(_t19, _t21, _t13), rotateYXZ_general_s6e793366_c2(_t14, _t15, _t0), 0);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateYXZ(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYXZ_orthogonal(angleX, angleY, angleZ);
        return rotateYXZ_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        return new Float3x3(_t0 * _t1, Math.fma(_t2, _t3, -(_t6 * _t5)), Math.fma(_t6, _t2, _t3 * _t5), _t4, _t5 * _t1, -(_t2 * _t1), -(_t3 * _t1), Math.fma(_t7, _t5, _t2 * _t0), Math.fma(_t5, _t0, -(_t7 * _t2)), 0);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t3;
        float _t9 = _t3 * _t0;
        float _t12 = Math.fma(_t7, _t4, _t5 * _t0);
        float _t13 = Math.fma(_t4, _t0, -(_t7 * _t5));
        return new Float3x3(Math.fma(_t0, _t1, -(this.m02 * _t6)), Math.fma(this.m02, _t12, Math.fma(_t5, _t2, -(_t9 * _t4))), Math.fma(this.m02, _t13, Math.fma(_t9, _t5, _t2 * _t4)), Math.fma(-this.m12, _t6, _t3), Math.fma(this.m12, _t12, _t4 * _t1), Math.fma(this.m12, _t13, -(_t5 * _t1)), -_t6, _t12, _t13, 0);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        return new Float3x3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3)), Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11)), Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13))), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3)), Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11)), Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13))), -_t6, _t18, _t21, 0);
    }

    /** Private per-column body of {@code rotateYZX_general}; reached only through it. */
    private Float3 rotateYZX_general_s6e793366_c0(float _t6, float _t7, float _t3) {
        return new Float3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3)), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3)), Math.fma(-this.m22, _t6, Math.fma(this.m20, _t7, this.m21 * _t3)));
    }

    /** Private per-column body of {@code rotateYZX_general}; reached only through it. */
    private Float3 rotateYZX_general_s6e793366_c1(float _t18, float _t20, float _t11) {
        return new Float3(Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11)), Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11)), Math.fma(this.m22, _t18, Math.fma(this.m20, _t20, this.m21 * _t11)));
    }

    /** Private per-column body of {@code rotateYZX_general}; reached only through it. */
    private Float3 rotateYZX_general_s6e793366_c2(float _t21, float _t19, float _t13) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13))), Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13))), Math.fma(this.m22, _t21, Math.fma(this.m20, _t19, -(this.m21 * _t13))));
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x3 rotateYZX_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t2 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        float _t11 = _t4 * _t1;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        float _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        float _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        return new Float3x3(rotateYZX_general_s6e793366_c0(_t6, _t7, _t3), rotateYZX_general_s6e793366_c1(_t18, _t20, _t11), rotateYZX_general_s6e793366_c2(_t21, _t19, _t13), 0);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateYZX(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYZX_orthogonal(angleX, angleY, angleZ);
        return rotateYZX_general(angleX, angleY, angleZ);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateYn180() {
        return rotateY180();
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateYn270() {
        return rotateY90();
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateYn90() {
        return rotateY270();
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public Float3x3 rotateZ(float angle) {
        return rotate(angle);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_identity() {
        return new Float3x3(-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_translation() {
        return new Float3x3(-1.0f, 0.0f, this.m02, 0.0f, -1.0f, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_orthogonal() {
        float _t0 = -this.m11;
        return new Float3x3(_t0, this.m10, this.m02, -this.m10, _t0, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_affine() {
        return new Float3x3(-this.m00, -this.m01, this.m02, -this.m10, -this.m11, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Float3x3 rotateZ180_general() {
        return new Float3x3(-this.m00, -this.m01, this.m02, -this.m10, -this.m11, this.m12, -this.m20, -this.m21, this.m22, 0);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZ180() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ180_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ180_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ180_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ180_affine();
        return rotateZ180_general();
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_identity() {
        return new Float3x3(0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_translation() {
        return new Float3x3(0.0f, 1.0f, this.m02, -1.0f, 0.0f, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_orthogonal() {
        return new Float3x3(this.m10, this.m11, this.m02, -this.m11, this.m10, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_affine() {
        return new Float3x3(-this.m01, this.m00, this.m02, -this.m11, this.m10, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Float3x3 rotateZ270_general() {
        return new Float3x3(-this.m01, this.m00, this.m02, -this.m11, this.m10, this.m12, -this.m21, this.m20, this.m22, 0);
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZ270() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ270_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ270_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ270_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ270_affine();
        return rotateZ270_general();
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_identity() {
        return new Float3x3(0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_translation() {
        return new Float3x3(0.0f, -1.0f, this.m02, 1.0f, 0.0f, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_orthogonal() {
        return new Float3x3(this.m01, -this.m00, this.m02, this.m11, -this.m10, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_affine() {
        return new Float3x3(this.m01, -this.m00, this.m02, this.m11, -this.m10, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Float3x3 rotateZ90_general() {
        return new Float3x3(this.m01, -this.m00, this.m02, this.m11, -this.m10, this.m12, this.m21, -this.m20, this.m22, 0);
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZ90() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ90_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ90_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ90_orthogonal();
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ90_affine();
        return rotateZ90_general();
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        return new Float3x3(Math.fma(_t0, _t1, -(_t6 * _t4)), -(_t3 * _t5), Math.fma(_t6, _t0, _t4 * _t1), Math.fma(_t7, _t4, _t3 * _t0), _t5 * _t1, Math.fma(_t4, _t3, -(_t7 * _t0)), -(_t4 * _t5), _t2, _t5 * _t0, 0);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t1 * _t2;
        float _t9 = _t4 * _t3;
        return new Float3x3(Math.fma(-this.m02, _t6, Math.fma(_t2, _t3, -(_t7 * _t0))), Math.fma(this.m02, _t4, -(_t5 * _t1)), Math.fma(this.m02, _t8, Math.fma(_t7, _t2, _t0 * _t3)), Math.fma(-this.m12, _t6, Math.fma(_t9, _t0, _t5 * _t2)), Math.fma(this.m12, _t4, _t1 * _t3), Math.fma(this.m12, _t8, Math.fma(_t0, _t5, -(_t9 * _t2))), -_t6, _t4, _t8, 0);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        return new Float3x3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11))), Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11))), Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21)), -_t6, _t4, _t12, 0);
    }

    /** Private per-column body of {@code rotateZXY_general}; reached only through it. */
    private Float3 rotateZXY_general_s6e793366_c0(float _t6, float _t20, float _t18) {
        return new Float3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(-this.m22, _t6, Math.fma(this.m20, _t20, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateZXY_general}; reached only through it. */
    private Float3 rotateZXY_general_s6e793366_c1(float _t4, float _t10, float _t11) {
        return new Float3(Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11))), Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11))), Math.fma(this.m22, _t4, Math.fma(this.m21, _t10, -(this.m20 * _t11))));
    }

    /** Private per-column body of {@code rotateZXY_general}; reached only through it. */
    private Float3 rotateZXY_general_s6e793366_c2(float _t12, float _t19, float _t21) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21)), Math.fma(this.m22, _t12, Math.fma(this.m20, _t19, this.m21 * _t21)));
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x3 rotateZXY_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t6 = _t0 * _t1;
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        float _t10 = _t1 * _t3;
        float _t11 = _t5 * _t1;
        float _t12 = _t1 * _t2;
        float _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        float _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        float _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        float _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        return new Float3x3(rotateZXY_general_s6e793366_c0(_t6, _t20, _t18), rotateZXY_general_s6e793366_c1(_t4, _t10, _t11), rotateZXY_general_s6e793366_c2(_t12, _t19, _t21), 0);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateZXY(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZXY_orthogonal(angleX, angleY, angleZ);
        return rotateZXY_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        return new Float3x3(_t0 * _t1, Math.fma(_t6, _t3, -(_t4 * _t5)), Math.fma(_t6, _t5, _t3 * _t4), _t4 * _t0, Math.fma(_t7, _t3, _t5 * _t1), Math.fma(_t7, _t5, -(_t3 * _t1)), -_t2, _t3 * _t0, _t5 * _t0, 0);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t3 * _t0;
        float _t7 = _t2 * _t1;
        float _t8 = _t5 * _t0;
        float _t9 = _t2 * _t4;
        return new Float3x3(Math.fma(_t0, _t1, -(this.m02 * _t2)), Math.fma(this.m02, _t6, Math.fma(_t7, _t3, -(_t4 * _t5))), Math.fma(this.m02, _t8, Math.fma(_t7, _t5, _t3 * _t4)), Math.fma(_t4, _t0, -(this.m12 * _t2)), Math.fma(this.m12, _t6, Math.fma(_t9, _t3, _t5 * _t1)), Math.fma(this.m12, _t8, Math.fma(_t9, _t5, -(_t3 * _t1))), -_t2, _t6, _t8, 0);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_orthogonal(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        return new Float3x3(Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7)), Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7)), Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21)), -_t0, _t8, _t13, 0);
    }

    /** Private per-column body of {@code rotateZYX_general}; reached only through it. */
    private Float3 rotateZYX_general_s6e793366_c0(float _t0, float _t6, float _t7) {
        return new Float3(Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7)), Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7)), Math.fma(-this.m22, _t0, Math.fma(this.m20, _t6, this.m21 * _t7)));
    }

    /** Private per-column body of {@code rotateZYX_general}; reached only through it. */
    private Float3 rotateZYX_general_s6e793366_c1(float _t8, float _t20, float _t18) {
        return new Float3(Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(this.m22, _t8, Math.fma(this.m20, _t20, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateZYX_general}; reached only through it. */
    private Float3 rotateZYX_general_s6e793366_c2(float _t13, float _t19, float _t21) {
        return new Float3(Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21)), Math.fma(this.m22, _t13, Math.fma(this.m20, _t19, this.m21 * _t21)));
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x3 rotateZYX_general(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t1 * _t2;
        float _t7 = _t3 * _t1;
        float _t8 = _t4 * _t1;
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        float _t13 = _t5 * _t1;
        float _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        float _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        float _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        float _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        return new Float3x3(rotateZYX_general_s6e793366_c0(_t0, _t6, _t7), rotateZYX_general_s6e793366_c1(_t8, _t20, _t18), rotateZYX_general_s6e793366_c2(_t13, _t19, _t21), 0);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public Float3x3 rotateZYX(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZYX_orthogonal(angleX, angleY, angleZ);
        return rotateZYX_general(angleX, angleY, angleZ);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZn180() {
        return rotateZ180();
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZn270() {
        return rotateZ90();
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x3 rotateZn90() {
        return rotateZ270();
    }


    /**
     * Apply a scaling by {@code v} to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return the resulting matrix
     */
    public Float3x3 scale(Float2 v) {
        return scale(v.x(), v.y());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity(float vX, float vY) {
        return preScale_identity(vX, vY);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation(float vX, float vY) {
        return new Float3x3(vX, 0.0f, this.m02, 0.0f, vY, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal(float vX, float vY) {
        return new Float3x3(this.m00 * vX, this.m01 * vY, this.m02, this.m10 * vX, this.m11 * vY, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_general(float vX, float vY) {
        return new Float3x3(this.m00 * vX, this.m01 * vY, this.m02, this.m10 * vX, this.m11 * vY, this.m12, this.m20 * vX, this.m21 * vY, this.m22, 0);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return the resulting matrix
     */
    public Float3x3 scale(float vX, float vY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(vX, vY);
        return scale_general(vX, vY);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_identity(float s) {
        return preScale_identity(s);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_translation(float s) {
        return new Float3x3(s, 0.0f, this.m02, 0.0f, s, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_orthogonal(float s) {
        return new Float3x3(s * this.m00, s * this.m01, this.m02, s * this.m10, s * this.m11, this.m12, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x3 scale_general(float s) {
        return new Float3x3(s * this.m00, s * this.m01, this.m02, s * this.m10, s * this.m11, this.m12, s * this.m20, s * this.m21, this.m22, 0);
    }


    /**
     * Apply a scaling by {@code s} to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return the resulting matrix
     */
    public Float3x3 scale(float s) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(s);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(s);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(s);
        return scale_general(s);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 scaleAround(float s, Float2 pivot) {
        return scaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity(float s, float pivotX, float pivotY) {
        return preScaleAround_identity(s, pivotX, pivotY);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation(float s, float pivotX, float pivotY) {
        return new Float3x3(s, 0.0f, Math.fma(-s, pivotX, this.m02 + pivotX), 0.0f, s, Math.fma(-s, pivotY, this.m12 + pivotY), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal(float s, float pivotX, float pivotY) {
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        return new Float3x3(s * this.m00, s * this.m01, Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02)), s * this.m10, s * this.m11, Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_general(float s, float pivotX, float pivotY) {
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        return new Float3x3(s * this.m00, s * this.m01, Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, this.m02)), s * this.m10, s * this.m11, Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, this.m12)), s * this.m20, s * this.m21, Math.fma(this.m20, _t0, Math.fma(this.m21, _t1, this.m22)), 0);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY}) to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 scaleAround(float s, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(s, pivotX, pivotY);
        return scaleAround_general(s, pivotX, pivotY);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x3 scaleAround(Float2 s, Float2 pivot) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_identity(float sX, float sY, float pivotX, float pivotY) {
        return preScaleAround_identity(sX, sY, pivotX, pivotY);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_translation(float sX, float sY, float pivotX, float pivotY) {
        return new Float3x3(sX, 0.0f, Math.fma(-pivotX, sX, this.m02 + pivotX), 0.0f, sY, Math.fma(-pivotY, sY, this.m12 + pivotY), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_orthogonal(float sX, float sY, float pivotX, float pivotY) {
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        return new Float3x3(sX * this.m00, sY * this.m01, Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02)), sX * this.m10, sY * this.m11, Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x3 scaleAround_general(float sX, float sY, float pivotX, float pivotY) {
        float _t2 = Math.fma(-pivotX, sX, pivotX);
        float _t3 = Math.fma(-pivotY, sY, pivotY);
        return new Float3x3(sX * this.m00, sY * this.m01, Math.fma(this.m00, _t2, Math.fma(this.m01, _t3, this.m02)), sX * this.m10, sY * this.m11, Math.fma(this.m10, _t2, Math.fma(this.m11, _t3, this.m12)), sX * this.m20, sY * this.m21, Math.fma(this.m20, _t2, Math.fma(this.m21, _t3, this.m22)), 0);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return the resulting matrix
     */
    public Float3x3 scaleAround(float sX, float sY, float pivotX, float pivotY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, pivotX, pivotY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, pivotX, pivotY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(sX, sY, pivotX, pivotY);
        return scaleAround_general(sX, sY, pivotX, pivotY);
    }


    /**
     * Apply a translation by {@code v} to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return the resulting matrix
     */
    public Float3x3 translate(Float2 v) {
        return translate(v.x(), v.y());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_identity(float vX, float vY) {
        return preTranslate_identity(vX, vY);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_translation(float vX, float vY) {
        return preTranslate_translation(vX, vY);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_orthogonal(float vX, float vY) {
        return new Float3x3(this.m00, this.m01, Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02)), this.m10, this.m11, Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_affine(float vX, float vY) {
        return new Float3x3(this.m00, this.m01, Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02)), this.m10, this.m11, Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12)), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x3 translate_general(float vX, float vY) {
        return new Float3x3(this.m00, this.m01, Math.fma(this.m00, vX, Math.fma(this.m01, vY, this.m02)), this.m10, this.m11, Math.fma(this.m10, vX, Math.fma(this.m11, vY, this.m12)), this.m20, this.m21, Math.fma(this.m20, vX, Math.fma(this.m21, vY, this.m22)), 0);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return the resulting matrix
     */
    public Float3x3 translate(float vX, float vY) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return translate_affine(vX, vY);
        return translate_general(vX, vY);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_identity(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        return new Float3x3(2.0f * _t0_inv, 0.0f, -((left + right) * _t0_inv), 0.0f, 2.0f * _t1_inv, -((bottom + top) * _t1_inv), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_translation(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        return new Float3x3(2.0f * _t0_inv, 0.0f, this.m02 - (left + right) * _t0_inv, 0.0f, 2.0f * _t1_inv, this.m12 - (bottom + top) * _t1_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_orthogonal(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        return new Float3x3(2.0f * this.m00 * _t0_inv, 2.0f * this.m01 * _t1_inv, this.m02 - this.m00 * _t2 * _t0_inv - this.m01 * _t3 * _t1_inv, 2.0f * this.m10 * _t0_inv, 2.0f * this.m11 * _t1_inv, this.m12 - this.m10 * _t2 * _t0_inv - this.m11 * _t3 * _t1_inv, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_affine(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        return new Float3x3(2.0f * this.m00 * _t0_inv, 2.0f * this.m01 * _t1_inv, this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv), 2.0f * this.m10 * _t0_inv, 2.0f * this.m11 * _t1_inv, this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv), 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Float3x3 view_general(float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        return new Float3x3(2.0f * this.m00 * _t0_inv, 2.0f * this.m01 * _t1_inv, this.m02 + (-(this.m00 * _t2 * _t0_inv) - this.m01 * _t3 * _t1_inv), 2.0f * this.m10 * _t0_inv, 2.0f * this.m11 * _t1_inv, this.m12 + (-(this.m10 * _t2 * _t0_inv) - this.m11 * _t3 * _t1_inv), 2.0f * this.m20 * _t0_inv, 2.0f * this.m21 * _t1_inv, this.m22 + (-(this.m20 * _t2 * _t0_inv) - this.m21 * _t3 * _t1_inv), 0);
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return the resulting matrix
     */
    public Float3x3 view(float left, float right, float bottom, float top) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity(left, right, bottom, top);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation(left, right, bottom, top);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal(left, right, bottom, top);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return view_affine(left, right, bottom, top);
        return view_general(left, right, bottom, top);
    }


    /**
     * Multiply this matrix by the given vector, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 mul(Float3 v) {
        return mul(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_identity(float vX, float vY, float vZ) {
        return new Float3(vX, vY, vZ);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_translation(float vX, float vY, float vZ) {
        return new Float3(Math.fma(this.m02, vZ, vX), Math.fma(this.m12, vZ, vY), vZ);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_general(float vX, float vY, float vZ) {
        return new Float3(Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY)), Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY)), Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY)));
    }


    /**
     * Multiply this matrix by the given vector, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 mul(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ);
        return mul_general(vX, vY, vZ);
    }

    /** {@return a copy with the {@code m00} element replaced by {@code v}} */
    public Float3x3 withM00(float v) {
        return new Float3x3(v, m01, m02, m10, m11, m12, m20, m21, m22);
    }

    /** {@return a copy with the {@code m01} element replaced by {@code v}} */
    public Float3x3 withM01(float v) {
        return new Float3x3(m00, v, m02, m10, m11, m12, m20, m21, m22);
    }

    /** {@return a copy with the {@code m02} element replaced by {@code v}} */
    public Float3x3 withM02(float v) {
        return new Float3x3(m00, m01, v, m10, m11, m12, m20, m21, m22);
    }

    /** {@return a copy with the {@code m10} element replaced by {@code v}} */
    public Float3x3 withM10(float v) {
        return new Float3x3(m00, m01, m02, v, m11, m12, m20, m21, m22);
    }

    /** {@return a copy with the {@code m11} element replaced by {@code v}} */
    public Float3x3 withM11(float v) {
        return new Float3x3(m00, m01, m02, m10, v, m12, m20, m21, m22);
    }

    /** {@return a copy with the {@code m12} element replaced by {@code v}} */
    public Float3x3 withM12(float v) {
        return new Float3x3(m00, m01, m02, m10, m11, v, m20, m21, m22);
    }

    /** {@return a copy with the {@code m20} element replaced by {@code v}} */
    public Float3x3 withM20(float v) {
        return new Float3x3(m00, m01, m02, m10, m11, m12, v, m21, m22);
    }

    /** {@return a copy with the {@code m21} element replaced by {@code v}} */
    public Float3x3 withM21(float v) {
        return new Float3x3(m00, m01, m02, m10, m11, m12, m20, v, m22);
    }

    /** {@return a copy with the {@code m22} element replaced by {@code v}} */
    public Float3x3 withM22(float v) {
        return new Float3x3(m00, m01, m02, m10, m11, m12, m20, m21, v);
    }

    /** {@return a copy with the cached property bits replaced by {@code properties}} */
    public Float3x3 withProperties(int properties) {
        return new Float3x3(m00, m01, m02, m10, m11, m12, m20, m21, m22, properties);
    }

    @Override public String toString() {
        return "Float3x3(\n    " + m00() + ", " + m01() + ", " + m02() + "\n    " + m10() + ", " + m11() + ", " + m12() + "\n    " + m20() + ", " + m21() + ", " + m22() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3x3)) return false;
        Float3x3 o = (Float3x3) obj;
        return Float.floatToIntBits(m00) == Float.floatToIntBits(o.m00)
            && Float.floatToIntBits(m01) == Float.floatToIntBits(o.m01)
            && Float.floatToIntBits(m02) == Float.floatToIntBits(o.m02)
            && Float.floatToIntBits(m10) == Float.floatToIntBits(o.m10)
            && Float.floatToIntBits(m11) == Float.floatToIntBits(o.m11)
            && Float.floatToIntBits(m12) == Float.floatToIntBits(o.m12)
            && Float.floatToIntBits(m20) == Float.floatToIntBits(o.m20)
            && Float.floatToIntBits(m21) == Float.floatToIntBits(o.m21)
            && Float.floatToIntBits(m22) == Float.floatToIntBits(o.m22);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(m00);
        h = 31 * h + Float.floatToIntBits(m01);
        h = 31 * h + Float.floatToIntBits(m02);
        h = 31 * h + Float.floatToIntBits(m10);
        h = 31 * h + Float.floatToIntBits(m11);
        h = 31 * h + Float.floatToIntBits(m12);
        h = 31 * h + Float.floatToIntBits(m20);
        h = 31 * h + Float.floatToIntBits(m21);
        h = 31 * h + Float.floatToIntBits(m22);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(m00)
            && Float.isFinite(m01)
            && Float.isFinite(m02)
            && Float.isFinite(m10)
            && Float.isFinite(m11)
            && Float.isFinite(m12)
            && Float.isFinite(m20)
            && Float.isFinite(m21)
            && Float.isFinite(m22);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(Float3x3 other, float epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m02 - other.m02()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m12 - other.m12()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m22 - other.m22()) <= epsilon;
    }

    static final Float3x3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x3BbOpsUnsafe()
                    : new Float3x3BbOpsApi();
    static final Float3x3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x3RawOpsUnsafe()
                    : new Float3x3RawOpsApi();


    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] storeCM(float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m01;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m02;
        dest[offset + 7] = this.m12;
        dest[offset + 8] = this.m22;
        return dest;
    }

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] storeCM(float[] dest) { return storeCM(dest, 0); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c3 = src[offset + 1];
        float _c6 = src[offset + 2];
        float _c1 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c7 = src[offset + 5];
        float _c2 = src[offset + 6];
        float _c5 = src[offset + 7];
        float _c8 = src[offset + 8];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(float[] src) { return loadCM(src, 0); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCM(FloatBuffer buf) {
        return storeCMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCMRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(FloatBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM(ByteBuffer buf) {
        return storeCMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 36);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(ByteBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 36);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(address);
    }


    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] storeCM(double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = this.m01;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m21;
        dest[offset + 6] = this.m02;
        dest[offset + 7] = this.m12;
        dest[offset + 8] = this.m22;
        return dest;
    }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] storeCM(double[] dest) { return storeCM(dest, 0); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c3 = (float) src[offset + 1];
        float _c6 = (float) src[offset + 2];
        float _c1 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c7 = (float) src[offset + 5];
        float _c2 = (float) src[offset + 6];
        float _c5 = (float) src[offset + 7];
        float _c8 = (float) src[offset + 8];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(double[] src) { return loadCM(src, 0); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCM(DoubleBuffer buf) {
        return storeCMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(DoubleBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMDouble(ByteBuffer buf) {
        return storeCMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at the given absolute index (the position is not used or
     * modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeCMDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDouble(ByteBuffer buf) {
        return loadCMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadCMDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeCMDoubleUnsafe(long address) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleUnsafe(long address) {
        return RAW_OPS.loadCMDoubleUnsafe(address);
    }


    /**
     * Store the elements into the given array in row-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] storeRM(float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m10;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m12;
        dest[offset + 6] = this.m20;
        dest[offset + 7] = this.m21;
        dest[offset + 8] = this.m22;
        return dest;
    }

    /**
     * Store the elements into the given array in row-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] storeRM(float[] dest) { return storeRM(dest, 0); }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c5 = src[offset + 5];
        float _c6 = src[offset + 6];
        float _c7 = src[offset + 7];
        float _c8 = src[offset + 8];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(float[] src) { return loadRM(src, 0); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRM(FloatBuffer buf) {
        return storeRMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRMRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(FloatBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM(ByteBuffer buf) {
        return storeRMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 36);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(ByteBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 36);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in row-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in row-major order. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(address);
    }


    /**
     * Store the elements into the given array in row-major order, converting each element to
     * {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] storeRM(double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = this.m10;
        dest[offset + 4] = this.m11;
        dest[offset + 5] = this.m12;
        dest[offset + 6] = this.m20;
        dest[offset + 7] = this.m21;
        dest[offset + 8] = this.m22;
        return dest;
    }

    /**
     * Store the elements into the given array in row-major order, converting each element to
     * {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] storeRM(double[] dest) { return storeRM(dest, 0); }

    /**
     * Load the elements from the given array in row-major order, converting each element from
     * {@code double}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c5 = (float) src[offset + 5];
        float _c6 = (float) src[offset + 6];
        float _c7 = (float) src[offset + 7];
        float _c8 = (float) src[offset + 8];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array in row-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(double[] src) { return loadRM(src, 0); }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRM(DoubleBuffer buf) {
        return storeRMAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(DoubleBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMDouble(ByteBuffer buf) {
        return storeRMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeRMDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDouble(ByteBuffer buf) {
        return loadRMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x3 r = loadRMDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeRMDoubleUnsafe(long address) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleUnsafe(long address) {
        return RAW_OPS.loadRMDoubleUnsafe(address);
    }


    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public float[] storeCM(float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        return dest;
    }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = src[offset];
        float _c3 = src[offset + 1];
        float _c6 = src[offset + 2];
        float _c1 = src[_p1];
        float _c4 = src[_p1 + 1];
        float _c7 = src[_p1 + 2];
        float _c2 = src[_p2];
        float _c5 = src[_p2 + 1];
        float _c8 = src[_p2 + 2];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeCM(FloatBuffer buf, int stride) {
        return storeCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeCMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(FloatBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCM(ByteBuffer buf, int stride) {
        return storeCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 4);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(ByteBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 4);
        return r;
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
    public Float3x3 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(address, stride);
    }


    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public double[] storeCM(double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        return dest;
    }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = (float) src[offset];
        float _c3 = (float) src[offset + 1];
        float _c6 = (float) src[offset + 2];
        float _c1 = (float) src[_p1];
        float _c4 = (float) src[_p1 + 1];
        float _c7 = (float) src[_p1 + 2];
        float _c2 = (float) src[_p2];
        float _c5 = (float) src[_p2 + 1];
        float _c8 = (float) src[_p2 + 2];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeCM(DoubleBuffer buf, int stride) {
        return storeCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeCMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCM(DoubleBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMDouble(ByteBuffer buf, int stride) {
        return storeCMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMDoubleAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeCMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 8);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDouble(ByteBuffer buf, int stride) {
        return loadCMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMDoubleAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadCMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 8);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    public Float3x3 storeCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadCMDoubleUnsafe(address, stride);
    }


    /**
     * Store the elements into the given array in row-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public float[] storeRM(float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        return dest;
    }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = src[offset];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[_p1];
        float _c4 = src[_p1 + 1];
        float _c5 = src[_p1 + 2];
        float _c6 = src[_p2];
        float _c7 = src[_p2 + 1];
        float _c8 = src[_p2 + 2];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeRM(FloatBuffer buf, int stride) {
        return storeRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeRMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(FloatBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRM(ByteBuffer buf, int stride) {
        return storeRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 4);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(ByteBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 4);
        return r;
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
    public Float3x3 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(address, stride);
    }


    /**
     * Store the elements into the given array in row-major order, converting each element to
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public double[] storeRM(double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        return dest;
    }

    /**
     * Load the elements from the given array in row-major order, converting each element from
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = (float) src[offset];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[_p1];
        float _c4 = (float) src[_p1 + 1];
        float _c5 = (float) src[_p1 + 2];
        float _c6 = (float) src[_p2];
        float _c7 = (float) src[_p2 + 1];
        float _c8 = (float) src[_p2 + 2];
        return new Float3x3(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeRM(DoubleBuffer buf, int stride) {
        return storeRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeRMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRM(DoubleBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRMDouble(ByteBuffer buf, int stride) {
        return storeRMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMDoubleAbsolute(this, index, buf, stride);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeRMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeRMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 8);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDouble(ByteBuffer buf, int stride) {
        return loadRMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMDoubleAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x3 r = loadRMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (3 * stride) * 8);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    public Float3x3 storeRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadRMDoubleUnsafe(address, stride);
    }


    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] storeCM4x4(float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] storeCM4x4(float[] dest) { return storeCM4x4(dest, 0); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCM4x4(FloatBuffer buf) {
        return storeCM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCM4x4Absolute(int index, FloatBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCM4x4Relative(FloatBuffer buf) {
        int pos = buf.position();
        storeCM4x4Absolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4(ByteBuffer buf) {
        return storeCM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4Relative(ByteBuffer buf) {
        int pos = buf.position();
        storeCM4x4Absolute(pos, buf);
        buf.position(pos + 64);
        return buf;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, identity-extended
     * to a 4x4 matrix. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }


    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] storeCM4x4(double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m01;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m21;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m02;
        dest[offset + 9] = this.m12;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] storeCM4x4(double[] dest) { return storeCM4x4(dest, 0); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position (the
     * position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCM4x4(DoubleBuffer buf) {
        return storeCM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCM4x4Absolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position and
     * advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCM4x4Relative(DoubleBuffer buf) {
        int pos = buf.position();
        storeCM4x4Absolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, converting each element to {@code double}, starting at its current position (the
     * position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4Double(ByteBuffer buf) {
        return storeCM4x4DoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, converting each element to {@code double}, starting at the given absolute index
     * (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4DoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, converting each element to {@code double}, starting at its current position and
     * advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCM4x4DoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeCM4x4DoubleAbsolute(pos, buf);
        buf.position(pos + 128);
        return buf;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, identity-extended
     * to a 4x4 matrix, converting each element to {@code double}. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeCM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeCM4x4DoubleUnsafe(this, address);
    }


    /**
     * Store the elements into the given array in row-major order, identity-extended to a 4x4
     * matrix, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] storeRM4x4(float[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }

    /**
     * Store the elements into the given array in row-major order, identity-extended to a 4x4
     * matrix.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] storeRM4x4(float[] dest) { return storeRM4x4(dest, 0); }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRM4x4(FloatBuffer buf) {
        return storeRM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRM4x4Absolute(int index, FloatBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRM4x4Relative(FloatBuffer buf) {
        int pos = buf.position();
        storeRM4x4Absolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4(ByteBuffer buf) {
        return storeRM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4Relative(ByteBuffer buf) {
        int pos = buf.position();
        storeRM4x4Absolute(pos, buf);
        buf.position(pos + 64);
        return buf;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, identity-extended to
     * a 4x4 matrix. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }


    /**
     * Store the elements into the given array in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] storeRM4x4(double[] dest, int offset) {
        dest[offset + 0] = this.m00;
        dest[offset + 1] = this.m01;
        dest[offset + 2] = this.m02;
        dest[offset + 3] = 0.0f;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = 0.0f;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = 0.0f;
        dest[offset + 12] = 0.0f;
        dest[offset + 13] = 0.0f;
        dest[offset + 14] = 0.0f;
        dest[offset + 15] = 1.0f;
        return dest;
    }

    /**
     * Store the elements into the given array in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] storeRM4x4(double[] dest) { return storeRM4x4(dest, 0); }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position (the
     * position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRM4x4(DoubleBuffer buf) {
        return storeRM4x4Absolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRM4x4Absolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position and
     * advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRM4x4Relative(DoubleBuffer buf) {
        int pos = buf.position();
        storeRM4x4Absolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position (the
     * position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4Double(ByteBuffer buf) {
        return storeRM4x4DoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4DoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4DoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer in row-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position and
     * advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRM4x4DoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeRM4x4DoubleAbsolute(pos, buf);
        buf.position(pos + 128);
        return buf;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, identity-extended to
     * a 4x4 matrix, converting each element to {@code double}. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeRM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeRM4x4DoubleUnsafe(this, address);
    }


    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store(float[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store(FloatBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store(int index, FloatBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer storeRelative(FloatBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store(double[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] store(double[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store(DoubleBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store(int index, DoubleBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer storeRelative(DoubleBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store(ByteBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store(int index, ByteBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer storeRelative(ByteBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 storeUnsafe(long address) { return storeCMUnsafe(address); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public float[] store(float[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public double[] store(double[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

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
    public FloatBuffer store(int index, FloatBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public FloatBuffer storeRelative(FloatBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public DoubleBuffer store(int index, DoubleBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public DoubleBuffer storeRelative(DoubleBuffer dest, int stride) { return storeCMRelative(dest, stride); }

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
    public ByteBuffer store(int index, ByteBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public ByteBuffer storeRelative(ByteBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    public Float3x3 storeUnsafe(long address, int stride) { return storeCMUnsafe(address, stride); }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(float[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(float[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(FloatBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, FloatBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(FloatBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(double[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(double[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(DoubleBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, DoubleBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(DoubleBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(ByteBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, ByteBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(ByteBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadUnsafe(long address) { return loadCMUnsafe(address); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(float[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(double[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, FloatBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(FloatBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, DoubleBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(DoubleBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 load(int index, ByteBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadRelative(ByteBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x3} holding the loaded elements
     */
    public static Float3x3 loadUnsafe(long address, int stride) { return loadCMUnsafe(address, stride); }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store4x4(float[] dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store4x4(float[] dest, int offset) { return storeCM4x4(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at its current position (the position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store4x4(FloatBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store4x4(int index, FloatBuffer dest) { return storeCM4x4Absolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store4x4Relative(FloatBuffer dest) { return storeCM4x4Relative(dest); }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store4x4(double[] dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given array in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] store4x4(double[] dest, int offset) { return storeCM4x4(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position (the
     * position is not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store4x4(DoubleBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store4x4(int index, DoubleBuffer dest) { return storeCM4x4Absolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at its current position and
     * advancing the position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store4x4Relative(DoubleBuffer dest) { return storeCM4x4Relative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4(ByteBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4(int index, ByteBuffer dest) { return storeCM4x4Absolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4Relative(ByteBuffer dest) { return storeCM4x4Relative(dest); }

    /**
     * Store the elements into the given raw memory address in column-major order, identity-extended
     * to a 4x4 matrix. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x3 store4x4Unsafe(long address) { return storeCM4x4Unsafe(address); }
}
