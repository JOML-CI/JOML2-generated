package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable 3x4 matrix of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Float.floatToIntBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
 * NaN; the cached structural property bits are ignored, so two matrix objects holding the same
 * elements are equal whatever either one has determined about itself. {@code hashCode} is
 * consistent with it (derived from the same bit patterns).
 * <p>
 * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
 * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and a
 * NaN component never compares equal to anything.
 *
 * @param m00 the element in row 0, column 0
 * @param m01 the element in row 0, column 1
 * @param m02 the element in row 0, column 2
 * @param m03 the element in row 0, column 3
 * @param m10 the element in row 1, column 0
 * @param m11 the element in row 1, column 1
 * @param m12 the element in row 1, column 2
 * @param m13 the element in row 1, column 3
 * @param m20 the element in row 2, column 0
 * @param m21 the element in row 2, column 1
 * @param m22 the element in row 2, column 2
 * @param m23 the element in row 2, column 3
 * @param properties the cached structural property bits
 */
public record Float3x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, int properties) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 48;

    /** The number of rows - the tight stride of the column-major ({@code storeCM}/{@code loadCM}) strided overloads. */
    public static final int ROWS = 3;
    /** The number of columns - the tight stride of the row-major ({@code storeRM}/{@code loadRM}) strided overloads. */
    public static final int COLUMNS = 4;

    /** The zero matrix (all components 0). */
    public static final Float3x4 ZERO = new Float3x4(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /** The identity matrix. */
    public static final Float3x4 IDENTITY = new Float3x4();

    /** Canonical constructor. */
    public Float3x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, int properties) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.properties = properties;
    }

    /**
     * Create a new instance initialized to the identity.
     */
    public Float3x4() {
        this(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, Joml.BIT_IDENTITY);
    }

    /** Create a matrix from the given elements, computing the cached property bits. */
    public Float3x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        this(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, props(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23));
    }

    /** Create a matrix from the given column vectors. */
    public Float3x4(Float3 c0, Float3 c1, Float3 c2, Float3 c3) {
        this(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z());
    }

    /** Create a matrix from the given column vectors and precomputed property bits (no recomputation). */
    public Float3x4(Float3 c0, Float3 c1, Float3 c2, Float3 c3, int properties) {
        this(c0.x(), c1.x(), c2.x(), c3.x(), c0.y(), c1.y(), c2.y(), c3.y(), c0.z(), c1.z(), c2.z(), c3.z(), properties);
    }

    /** Create a matrix by identity-extending {@code src} with a zero translation column. */
    public Float3x4(Float3x3 src) {
        this(src.m00(), src.m01(), src.m02(), 0, src.m10(), src.m11(), src.m12(), 0, src.m20(), src.m21(), src.m22(), 0);
    }

    /** Create a matrix by truncating {@code src} to the overlapping cells. */
    public Float3x4(Float4x4 src) {
        this(src.m00(), src.m01(), src.m02(), src.m03(), src.m10(), src.m11(), src.m12(), src.m13(), src.m20(), src.m21(), src.m22(), src.m23());
    }

    /** {@return the element in row 0, column 0} */
    public float m00() { return m00; }
    /** {@return the element in row 0, column 1} */
    public float m01() { return m01; }
    /** {@return the element in row 0, column 2} */
    public float m02() { return m02; }
    /** {@return the element in row 0, column 3} */
    public float m03() { return m03; }
    /** {@return the element in row 1, column 0} */
    public float m10() { return m10; }
    /** {@return the element in row 1, column 1} */
    public float m11() { return m11; }
    /** {@return the element in row 1, column 2} */
    public float m12() { return m12; }
    /** {@return the element in row 1, column 3} */
    public float m13() { return m13; }
    /** {@return the element in row 2, column 0} */
    public float m20() { return m20; }
    /** {@return the element in row 2, column 1} */
    public float m21() { return m21; }
    /** {@return the element in row 2, column 2} */
    public float m22() { return m22; }
    /** {@return the element in row 2, column 3} */
    public float m23() { return m23; }
    /** {@return the cached structural property bits} */
    public int properties() { return properties; }

    private static int props(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        if (m00 != 1 || m01 != 0 || m02 != 0 || m10 != 0 || m11 != 1 || m12 != 0 || m20 != 0 || m21 != 0 || m22 != 1) return 1;
        if (m03 != 0 || m13 != 0 || m23 != 0) return 7;
        return 15;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits. This is a pure query.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.m00 != 1 || this.m01 != 0 || this.m02 != 0 || this.m10 != 0 || this.m11 != 1 || this.m12 != 0 || this.m20 != 0 || this.m21 != 0 || this.m22 != 1) return 1;
        if (this.m03 != 0 || this.m13 != 0 || this.m23 != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal, i.e. its upper-left block is orthonormal with positive determinant (a proper rotation; a reflection is affine, not orthogonal)} O(1) read of the cached property bits; conservative. */
    public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is affine} Always {@code true} for this shape. */
    public boolean isAffine() { return true; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_identity(int col) {
        return new Float3(switch (col) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; case 3 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; case 3 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; case 3 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_translation(int col) {
        return new Float3(switch (col) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; case 3 -> this.m03; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; case 3 -> this.m13; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; case 3 -> this.m23; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Float3 getColumn_general(int col) {
        return new Float3(switch (col) { case 0 -> this.m00; case 1 -> this.m01; case 2 -> this.m02; case 3 -> this.m03; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> this.m10; case 1 -> this.m11; case 2 -> this.m12; case 3 -> this.m13; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); }, switch (col) { case 0 -> this.m20; case 1 -> this.m21; case 2 -> this.m22; case 3 -> this.m23; default -> throw new IndexOutOfBoundsException("Index out of range: " + col); });
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
    private Float3 getEulerAnglesXYZ_general() {
        float _t1 = Math.fma(this.m12, this.m12, this.m22 * this.m22);
        float _t3 = Math.fma(this.m02, this.m02, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(this.m21, this.m11), (float) Math.atan2(this.m02, (float) Math.sqrt(_t1)), 0.0f);
        } else {
            return new Float3((float) Math.atan2(-this.m12, this.m22), (float) Math.atan2(this.m02, (float) Math.sqrt(_t1)), (float) Math.atan2(-this.m01, this.m00));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXYZ_identity();
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
    private Float3 getEulerAnglesXZY_general() {
        float _t1 = Math.fma(this.m11, this.m11, this.m21 * this.m21);
        float _t3 = Math.fma(this.m01, this.m01, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(-this.m12, this.m22), 0.0f, (float) Math.atan2(-this.m01, (float) Math.sqrt(_t1)));
        } else {
            return new Float3((float) Math.atan2(this.m21, this.m11), (float) Math.atan2(this.m02, this.m00), (float) Math.atan2(-this.m01, (float) Math.sqrt(_t1)));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXZY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXZY_identity();
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
    private Float3 getEulerAnglesYXZ_general() {
        float _t1 = Math.fma(this.m02, this.m02, this.m22 * this.m22);
        float _t3 = Math.fma(this.m12, this.m12, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(-this.m12, (float) Math.sqrt(_t1)), (float) Math.atan2(-this.m20, this.m00), 0.0f);
        } else {
            return new Float3((float) Math.atan2(-this.m12, (float) Math.sqrt(_t1)), (float) Math.atan2(this.m02, this.m22), (float) Math.atan2(this.m10, this.m11));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYXZ_identity();
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
    private Float3 getEulerAnglesYZX_general() {
        float _t1 = Math.fma(this.m11, this.m11, this.m12 * this.m12);
        float _t3 = Math.fma(this.m10, this.m10, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3(0.0f, (float) Math.atan2(this.m02, this.m22), (float) Math.atan2(this.m10, (float) Math.sqrt(_t1)));
        } else {
            return new Float3((float) Math.atan2(-this.m12, this.m11), (float) Math.atan2(-this.m20, this.m00), (float) Math.atan2(this.m10, (float) Math.sqrt(_t1)));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYZX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYZX_identity();
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
    private Float3 getEulerAnglesZXY_general() {
        float _t1 = Math.fma(this.m01, this.m01, this.m11 * this.m11);
        float _t3 = Math.fma(this.m21, this.m21, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3((float) Math.atan2(this.m21, (float) Math.sqrt(_t1)), 0.0f, (float) Math.atan2(this.m10, this.m00));
        } else {
            return new Float3((float) Math.atan2(this.m21, (float) Math.sqrt(_t1)), (float) Math.atan2(-this.m20, this.m22), (float) Math.atan2(-this.m01, this.m11));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZXY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZXY_identity();
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
    private Float3 getEulerAnglesZYX_general() {
        float _t1 = Math.fma(this.m21, this.m21, this.m22 * this.m22);
        float _t3 = Math.fma(this.m20, this.m20, _t1) * 1.0E-7f;
        if (_t1 < _t3) {
            return new Float3(0.0f, (float) Math.atan2(-this.m20, (float) Math.sqrt(_t1)), (float) Math.atan2(-this.m01, this.m11));
        } else {
            return new Float3((float) Math.atan2(this.m21, this.m22), (float) Math.atan2(-this.m20, (float) Math.sqrt(_t1)), (float) Math.atan2(this.m10, this.m00));
        }
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZYX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZYX_identity();
        return getEulerAnglesZYX_general();
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private FloatQuat getNormalizedRotation_identity() {
        return new FloatQuat(0.0f, 0.0f, 0.0f, 1.0f);
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
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length), returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getNormalizedRotation() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getNormalizedRotation_identity();
        return getNormalizedRotation_general();
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float4 getRow_identity(int row) {
        return new Float4(switch (row) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, 0.0f);
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float4 getRow_translation(int row) {
        return new Float4(switch (row) { case 0 -> 1.0f; case 1 -> 0.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 1.0f; case 2 -> 0.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> 0.0f; case 1 -> 0.0f; case 2 -> 1.0f; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m03; case 1 -> this.m13; case 2 -> this.m23; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); });
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Float4 getRow_general(int row) {
        return new Float4(switch (row) { case 0 -> this.m00; case 1 -> this.m10; case 2 -> this.m20; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m01; case 1 -> this.m11; case 2 -> this.m21; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m02; case 1 -> this.m12; case 2 -> this.m22; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); }, switch (row) { case 0 -> this.m03; case 1 -> this.m13; case 2 -> this.m23; default -> throw new IndexOutOfBoundsException("Index out of range: " + row); });
    }


    /**
     * Get the row at the given index of this matrix, returning the result as a value.
     *
     * @param row the row index
     * @return the resulting vector
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    public Float4 getRow(int row) {
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
    private Float3 getScale_general() {
        return new Float3((float) Math.sqrt(Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10))), (float) Math.sqrt(Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11))), (float) Math.sqrt(Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12))));
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored), returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 getScale() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getScale_identity();
        return getScale_general();
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float3 getTranslation_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Float3 getTranslation_general() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Get the translation of this matrix, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getTranslation() {
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
    private FloatQuat getUnnormalizedRotation_orthogonal() {
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
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private FloatQuat getUnnormalizedRotation_general() {
        return getUnnormalizedRotation_orthogonal();
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getUnnormalizedRotation() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getUnnormalizedRotation_identity();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return getUnnormalizedRotation_orthogonal();
        return getUnnormalizedRotation_general();
    }


    /**
     * Private body of {@code invNegativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeX} dispatcher.
     */
    private Float3 invNegativeX_identity() {
        return new Float3(-1.0f, 0.0f, 0.0f);
    }


    /**
     * Private body of {@code invNegativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeX} dispatcher.
     */
    private Float3 invNegativeX_general() {
        float _t6 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t7 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t8 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(-(_t7 * _t12), -(_t8 * _t12), -(_t6 * _t12));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeX_identity();
        return invNegativeX_general();
    }


    /**
     * Private body of {@code invNegativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeY} dispatcher.
     */
    private Float3 invNegativeY_identity() {
        return new Float3(0.0f, -1.0f, 0.0f);
    }


    /**
     * Private body of {@code invNegativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeY} dispatcher.
     */
    private Float3 invNegativeY_general() {
        float _t6 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        float _t7 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _t8 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(-(_t8 * _t12), -(_t7 * _t12), -(_t6 * _t12));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeY_identity();
        return invNegativeY_general();
    }


    /**
     * Private body of {@code invNegativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeZ} dispatcher.
     */
    private Float3 invNegativeZ_identity() {
        return new Float3(0.0f, 0.0f, -1.0f);
    }


    /**
     * Private body of {@code invNegativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invNegativeZ} dispatcher.
     */
    private Float3 invNegativeZ_general() {
        float _t6 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t7 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _t8 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(-(_t7 * _t12), -(_t8 * _t12), -(_t6 * _t12));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNegativeZ_identity();
        return invNegativeZ_general();
    }


    /**
     * Private body of {@code invNormalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeX} dispatcher.
     */
    private Float3 invNormalizedNegativeX_identity() {
        return invNegativeX_identity();
    }


    /**
     * Private body of {@code invNormalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeX} dispatcher.
     */
    private Float3 invNormalizedNegativeX_general() {
        return new Float3(-this.m00, -this.m01, -this.m02);
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeX_identity();
        return invNormalizedNegativeX_general();
    }


    /**
     * Private body of {@code invNormalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeY} dispatcher.
     */
    private Float3 invNormalizedNegativeY_identity() {
        return invNegativeY_identity();
    }


    /**
     * Private body of {@code invNormalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeY} dispatcher.
     */
    private Float3 invNormalizedNegativeY_general() {
        return new Float3(-this.m10, -this.m11, -this.m12);
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeY_identity();
        return invNormalizedNegativeY_general();
    }


    /**
     * Private body of {@code invNormalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeZ} dispatcher.
     */
    private Float3 invNormalizedNegativeZ_identity() {
        return invNegativeZ_identity();
    }


    /**
     * Private body of {@code invNormalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedNegativeZ} dispatcher.
     */
    private Float3 invNormalizedNegativeZ_general() {
        return new Float3(-this.m20, -this.m21, -this.m22);
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedNegativeZ_identity();
        return invNormalizedNegativeZ_general();
    }


    /**
     * Private body of {@code invNormalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveX} dispatcher.
     */
    private Float3 invNormalizedPositiveX_identity() {
        return new Float3(1.0f, 0.0f, 0.0f);
    }


    /**
     * Private body of {@code invNormalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveX} dispatcher.
     */
    private Float3 invNormalizedPositiveX_general() {
        return new Float3(this.m00, this.m01, this.m02);
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveX_identity();
        return invNormalizedPositiveX_general();
    }


    /**
     * Private body of {@code invNormalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveY} dispatcher.
     */
    private Float3 invNormalizedPositiveY_identity() {
        return new Float3(0.0f, 1.0f, 0.0f);
    }


    /**
     * Private body of {@code invNormalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveY} dispatcher.
     */
    private Float3 invNormalizedPositiveY_general() {
        return new Float3(this.m10, this.m11, this.m12);
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveY_identity();
        return invNormalizedPositiveY_general();
    }


    /**
     * Private body of {@code invNormalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveZ} dispatcher.
     */
    private Float3 invNormalizedPositiveZ_identity() {
        return new Float3(0.0f, 0.0f, 1.0f);
    }


    /**
     * Private body of {@code invNormalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code invNormalizedPositiveZ} dispatcher.
     */
    private Float3 invNormalizedPositiveZ_general() {
        return new Float3(this.m20, this.m21, this.m22);
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invNormalizedPositiveZ_identity();
        return invNormalizedPositiveZ_general();
    }


    /**
     * Private body of {@code invPositiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveX} dispatcher.
     */
    private Float3 invPositiveX_identity() {
        return invNormalizedPositiveX_identity();
    }


    /**
     * Private body of {@code invPositiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveX} dispatcher.
     */
    private Float3 invPositiveX_general() {
        float _t6 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t7 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t8 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(_t7 * _t12, _t8 * _t12, _t6 * _t12);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveX_identity();
        return invPositiveX_general();
    }


    /**
     * Private body of {@code invPositiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveY} dispatcher.
     */
    private Float3 invPositiveY_identity() {
        return invNormalizedPositiveY_identity();
    }


    /**
     * Private body of {@code invPositiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveY} dispatcher.
     */
    private Float3 invPositiveY_general() {
        float _t6 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        float _t7 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _t8 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(_t8 * _t12, _t7 * _t12, _t6 * _t12);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveY_identity();
        return invPositiveY_general();
    }


    /**
     * Private body of {@code invPositiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveZ} dispatcher.
     */
    private Float3 invPositiveZ_identity() {
        return invNormalizedPositiveZ_identity();
    }


    /**
     * Private body of {@code invPositiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code invPositiveZ} dispatcher.
     */
    private Float3 invPositiveZ_general() {
        float _t6 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t7 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _t8 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        float _t11 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new Float3(_t7 * _t12, _t8 * _t12, _t6 * _t12);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invPositiveZ_identity();
        return invPositiveZ_general();
    }


    /**
     * Private body of {@code negativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeX} dispatcher.
     */
    private Float3 negativeX_identity() {
        return invNegativeX_identity();
    }


    /**
     * Private body of {@code negativeX}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeX} dispatcher.
     */
    private Float3 negativeX_general() {
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(-(this.m00 * _t3), -(this.m10 * _t3), -(this.m20 * _t3));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 negativeX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeX_identity();
        return negativeX_general();
    }


    /**
     * Private body of {@code negativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeY} dispatcher.
     */
    private Float3 negativeY_identity() {
        return invNegativeY_identity();
    }


    /**
     * Private body of {@code negativeY}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeY} dispatcher.
     */
    private Float3 negativeY_general() {
        float _t2 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(-(this.m01 * _t3), -(this.m11 * _t3), -(this.m21 * _t3));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 negativeY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeY_identity();
        return negativeY_general();
    }


    /**
     * Private body of {@code negativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeZ} dispatcher.
     */
    private Float3 negativeZ_identity() {
        return invNegativeZ_identity();
    }


    /**
     * Private body of {@code negativeZ}, specialized by runtime matrix properties; reached only
     * through the public {@code negativeZ} dispatcher.
     */
    private Float3 negativeZ_general() {
        float _t2 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(-(this.m02 * _t3), -(this.m12 * _t3), -(this.m22 * _t3));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 negativeZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negativeZ_identity();
        return negativeZ_general();
    }


    /**
     * Private body of {@code normalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeX} dispatcher.
     */
    private Float3 normalizedNegativeX_identity() {
        return invNegativeX_identity();
    }


    /**
     * Private body of {@code normalizedNegativeX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeX} dispatcher.
     */
    private Float3 normalizedNegativeX_general() {
        return new Float3(-this.m00, -this.m10, -this.m20);
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeX_identity();
        return normalizedNegativeX_general();
    }


    /**
     * Private body of {@code normalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeY} dispatcher.
     */
    private Float3 normalizedNegativeY_identity() {
        return invNegativeY_identity();
    }


    /**
     * Private body of {@code normalizedNegativeY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeY} dispatcher.
     */
    private Float3 normalizedNegativeY_general() {
        return new Float3(-this.m01, -this.m11, -this.m21);
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeY_identity();
        return normalizedNegativeY_general();
    }


    /**
     * Private body of {@code normalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeZ} dispatcher.
     */
    private Float3 normalizedNegativeZ_identity() {
        return invNegativeZ_identity();
    }


    /**
     * Private body of {@code normalizedNegativeZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedNegativeZ} dispatcher.
     */
    private Float3 normalizedNegativeZ_general() {
        return new Float3(-this.m02, -this.m12, -this.m22);
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedNegativeZ_identity();
        return normalizedNegativeZ_general();
    }


    /**
     * Private body of {@code normalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveX} dispatcher.
     */
    private Float3 normalizedPositiveX_identity() {
        return invNormalizedPositiveX_identity();
    }


    /**
     * Private body of {@code normalizedPositiveX}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveX} dispatcher.
     */
    private Float3 normalizedPositiveX_general() {
        return new Float3(this.m00, this.m10, this.m20);
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveX_identity();
        return normalizedPositiveX_general();
    }


    /**
     * Private body of {@code normalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveY} dispatcher.
     */
    private Float3 normalizedPositiveY_identity() {
        return invNormalizedPositiveY_identity();
    }


    /**
     * Private body of {@code normalizedPositiveY}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveY} dispatcher.
     */
    private Float3 normalizedPositiveY_general() {
        return new Float3(this.m01, this.m11, this.m21);
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveY_identity();
        return normalizedPositiveY_general();
    }


    /**
     * Private body of {@code normalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveZ} dispatcher.
     */
    private Float3 normalizedPositiveZ_identity() {
        return invNormalizedPositiveZ_identity();
    }


    /**
     * Private body of {@code normalizedPositiveZ}, specialized by runtime matrix properties;
     * reached only through the public {@code normalizedPositiveZ} dispatcher.
     */
    private Float3 normalizedPositiveZ_general() {
        return new Float3(this.m02, this.m12, this.m22);
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normalizedPositiveZ_identity();
        return normalizedPositiveZ_general();
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Float3 origin_identity() {
        return getEulerAnglesXYZ_identity();
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Float3 origin_translation() {
        return new Float3(-this.m03, -this.m13, -this.m23);
    }


    /**
     * Private body of {@code origin}, specialized by runtime matrix properties; reached only
     * through the public {@code origin} dispatcher.
     */
    private Float3 origin_general() {
        return new Float3(-Math.fma(this.m20, this.m23, Math.fma(this.m00, this.m03, this.m10 * this.m13)), -Math.fma(this.m21, this.m23, Math.fma(this.m01, this.m03, this.m11 * this.m13)), -Math.fma(this.m22, this.m23, Math.fma(this.m02, this.m03, this.m12 * this.m13)));
    }


    /**
     * Obtain the position that is transformed to the origin by this matrix, assuming its upper-left
     * 3x3 block is orthonormal (e.g. a rotation-translation or view matrix), returning the result
     * as a value.
     *
     * @return the resulting vector
     */
    public Float3 origin() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return origin_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return origin_translation();
        return origin_general();
    }


    /**
     * Private body of {@code positiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveX} dispatcher.
     */
    private Float3 positiveX_identity() {
        return invNormalizedPositiveX_identity();
    }


    /**
     * Private body of {@code positiveX}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveX} dispatcher.
     */
    private Float3 positiveX_general() {
        float _t2 = Math.fma(this.m20, this.m20, Math.fma(this.m00, this.m00, this.m10 * this.m10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.m00 * _t3, this.m10 * _t3, this.m20 * _t3);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 positiveX() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveX_identity();
        return positiveX_general();
    }


    /**
     * Private body of {@code positiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveY} dispatcher.
     */
    private Float3 positiveY_identity() {
        return invNormalizedPositiveY_identity();
    }


    /**
     * Private body of {@code positiveY}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveY} dispatcher.
     */
    private Float3 positiveY_general() {
        float _t2 = Math.fma(this.m21, this.m21, Math.fma(this.m01, this.m01, this.m11 * this.m11));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.m01 * _t3, this.m11 * _t3, this.m21 * _t3);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 positiveY() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveY_identity();
        return positiveY_general();
    }


    /**
     * Private body of {@code positiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveZ} dispatcher.
     */
    private Float3 positiveZ_identity() {
        return invNormalizedPositiveZ_identity();
    }


    /**
     * Private body of {@code positiveZ}, specialized by runtime matrix properties; reached only
     * through the public {@code positiveZ} dispatcher.
     */
    private Float3 positiveZ_general() {
        float _t2 = Math.fma(this.m22, this.m22, Math.fma(this.m02, this.m02, this.m12 * this.m12));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.m02 * _t3, this.m12 * _t3, this.m22 * _t3);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied, returning the result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @return the resulting vector
     */
    public Float3 positiveZ() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return positiveZ_identity();
        return positiveZ_general();
    }


    /**
     * Compute the determinant of the linear part (the upper-left square block) of this matrix.
     *
     * @return the determinant of the linear part (the upper-left square block) of this matrix
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
        return (float) Math.sqrt(Math.fma(this.m00, this.m00, Math.fma(this.m01, this.m01, this.m02 * this.m02)) + Math.fma(this.m03, this.m03, Math.fma(this.m10, this.m10, this.m11 * this.m11)) + (Math.fma(this.m12, this.m12, Math.fma(this.m13, this.m13, this.m20 * this.m20)) + Math.fma(this.m21, this.m21, Math.fma(this.m22, this.m22, this.m23 * this.m23))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x4 invert_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x4 invert_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, -this.m03, 0.0f, 1.0f, 0.0f, -this.m13, 0.0f, 0.0f, 1.0f, -this.m23, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x4 invert_orthogonal() {
        return new Float3x4(this.m00, this.m10, this.m20, Math.fma(-this.m20, this.m23, Math.fma(-this.m10, this.m13, -(this.m00 * this.m03))), this.m01, this.m11, this.m21, Math.fma(-this.m21, this.m23, Math.fma(-this.m11, this.m13, -(this.m01 * this.m03))), this.m02, this.m12, this.m22, Math.fma(-this.m22, this.m23, Math.fma(-this.m12, this.m13, -(this.m02 * this.m03))), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code invert_general}; reached only through it. */
    private Float3 invert_general_s0_c0(float _t20, float _t33_inv, float _t25, float _t21) {
        return new Float3(_t20 * _t33_inv, _t25 * _t33_inv, _t21 * _t33_inv);
    }

    /** Private per-column body of {@code invert_general}; reached only through it. */
    private Float3 invert_general_s0_c1(float _t23, float _t33_inv, float _t26, float _t28) {
        return new Float3(_t23 * _t33_inv, _t26 * _t33_inv, _t28 * _t33_inv);
    }

    /** Private per-column body of {@code invert_general}; reached only through it. */
    private Float3 invert_general_s0_c2(float _t24, float _t33_inv, float _t27, float _t29) {
        return new Float3(_t24 * _t33_inv, _t27 * _t33_inv, _t29 * _t33_inv);
    }

    /** Private per-column body of {@code invert_general}; reached only through it. */
    private Float3 invert_general_s0_c3(float _t24, float _t20, float _t23, float _t33_inv, float _t27, float _t25, float _t26, float _t29, float _t21, float _t28) {
        return new Float3(-(Math.fma(this.m23, _t24, Math.fma(this.m03, _t20, this.m13 * _t23)) * _t33_inv), -(Math.fma(this.m23, _t27, Math.fma(this.m03, _t25, this.m13 * _t26)) * _t33_inv), -(Math.fma(this.m23, _t29, Math.fma(this.m03, _t21, this.m13 * _t28)) * _t33_inv));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Float3x4 invert_general() {
        float _t20 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t21 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t23 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _t24 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _t25 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _t26 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _t27 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        float _t28 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        float _t29 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t33 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t20, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t33_inv = 1.0f / _t33;
        return new Float3x4(invert_general_s0_c0(_t20, _t33_inv, _t25, _t21), invert_general_s0_c1(_t23, _t33_inv, _t26, _t28), invert_general_s0_c2(_t24, _t33_inv, _t27, _t29), invert_general_s0_c3(_t24, _t20, _t23, _t33_inv, _t27, _t25, _t26, _t29, _t21, _t28), Joml.BIT_AFFINE);
    }


    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix,
     * returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x4 invert() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal();
        return invert_general();
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_general(Float3x4 other, int _props) {
        float _t24 = Math.fma(other.m21(), this.m12, Math.fma(other.m01(), this.m10, other.m11() * this.m11));
        float _t25 = Math.fma(other.m22(), this.m22, Math.fma(other.m02(), this.m20, other.m12() * this.m21));
        float _t26 = Math.fma(other.m21(), this.m22, Math.fma(other.m01(), this.m20, other.m11() * this.m21));
        float _t27 = Math.fma(other.m22(), this.m12, Math.fma(other.m02(), this.m10, other.m12() * this.m11));
        float _t28 = Math.fma(other.m22(), this.m02, Math.fma(other.m02(), this.m00, other.m12() * this.m01));
        float _t29 = Math.fma(other.m20(), this.m12, Math.fma(other.m00(), this.m10, other.m10() * this.m11));
        float _t30 = Math.fma(other.m20(), this.m22, Math.fma(other.m00(), this.m20, other.m10() * this.m21));
        float _t31 = Math.fma(other.m20(), this.m02, Math.fma(other.m00(), this.m00, other.m10() * this.m01));
        float _t32 = Math.fma(other.m21(), this.m02, Math.fma(other.m01(), this.m00, other.m11() * this.m01));
        float _t33 = Math.fma(other.m03(), this.m20, Math.fma(other.m13(), this.m21, Math.fma(other.m23(), this.m22, this.m23)));
        float _t34 = Math.fma(other.m03(), this.m00, Math.fma(other.m13(), this.m01, Math.fma(other.m23(), this.m02, this.m03)));
        float _t35 = Math.fma(other.m03(), this.m10, Math.fma(other.m13(), this.m11, Math.fma(other.m23(), this.m12, this.m13)));
        float _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        float _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        float _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        float _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        float _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        float _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        float _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        float _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        float _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        float _t69 = Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        float _t69_inv = 1.0f / _t69;
        return new Float3x4(_t56 * _t69_inv, _t59 * _t69_inv, _t60 * _t69_inv, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv), _t61 * _t69_inv, _t62 * _t69_inv, _t63 * _t69_inv, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv), _t57 * _t69_inv, _t64 * _t69_inv, _t65 * _t69_inv, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv), _props);
    }

    /** Private per-column body of {@code invertProduct_identity}; reached only through it. */
    private Float3 invertProduct_identity_sac25323_c0(float _t20, float _t33_inv, float _t25, float _t21) {
        return new Float3(_t20 * _t33_inv, _t25 * _t33_inv, _t21 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_identity}; reached only through it. */
    private Float3 invertProduct_identity_sac25323_c1(float _t23, float _t33_inv, float _t26, float _t28) {
        return new Float3(_t23 * _t33_inv, _t26 * _t33_inv, _t28 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_identity}; reached only through it. */
    private Float3 invertProduct_identity_sac25323_c2(float _t24, float _t33_inv, float _t27, float _t29) {
        return new Float3(_t24 * _t33_inv, _t27 * _t33_inv, _t29 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_identity}; reached only through it. */
    private Float3 invertProduct_identity_sac25323_c3(Float3x4 other, float _t24, float _t20, float _t23, float _t33_inv, float _t27, float _t25, float _t26, float _t29, float _t21, float _t28) {
        return new Float3(-(Math.fma(other.m23(), _t24, Math.fma(other.m03(), _t20, other.m13() * _t23)) * _t33_inv), -(Math.fma(other.m23(), _t27, Math.fma(other.m03(), _t25, other.m13() * _t26)) * _t33_inv), -(Math.fma(other.m23(), _t29, Math.fma(other.m03(), _t21, other.m13() * _t28)) * _t33_inv));
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_identity(Float3x4 other) {
        float _t20 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        float _t21 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        float _t23 = Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22()));
        float _t24 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11()));
        float _t25 = Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22()));
        float _t26 = Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20()));
        float _t27 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12()));
        float _t28 = Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21()));
        float _t29 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t33 = Math.fma(other.m02(), _t21, Math.fma(other.m00(), _t20, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        float _t33_inv = 1.0f / _t33;
        return new Float3x4(invertProduct_identity_sac25323_c0(_t20, _t33_inv, _t25, _t21), invertProduct_identity_sac25323_c1(_t23, _t33_inv, _t26, _t28), invertProduct_identity_sac25323_c2(_t24, _t33_inv, _t27, _t29), invertProduct_identity_sac25323_c3(other, _t24, _t20, _t23, _t33_inv, _t27, _t25, _t26, _t29, _t21, _t28), other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_translation(Float3x4 other) {
        float _t5 = other.m23() + this.m23;
        float _t6 = other.m03() + this.m03;
        float _t7 = other.m13() + this.m13;
        float _t23 = Math.fma(other.m11(), other.m22(), -(other.m12() * other.m21()));
        float _t24 = Math.fma(other.m10(), other.m21(), -(other.m11() * other.m20()));
        float _t26 = Math.fma(other.m02(), other.m21(), -(other.m01() * other.m22()));
        float _t27 = Math.fma(other.m01(), other.m12(), -(other.m02() * other.m11()));
        float _t28 = Math.fma(other.m12(), other.m20(), -(other.m10() * other.m22()));
        float _t29 = Math.fma(other.m00(), other.m22(), -(other.m02() * other.m20()));
        float _t30 = Math.fma(other.m02(), other.m10(), -(other.m00() * other.m12()));
        float _t31 = Math.fma(other.m01(), other.m20(), -(other.m00() * other.m21()));
        float _t32 = Math.fma(other.m00(), other.m11(), -(other.m01() * other.m10()));
        float _t36 = Math.fma(other.m02(), _t24, Math.fma(other.m00(), _t23, -(other.m01() * Math.fma(other.m10(), other.m22(), -(other.m12() * other.m20())))));
        float _t36_inv = 1.0f / _t36;
        return new Float3x4(_t23 * _t36_inv, _t26 * _t36_inv, _t27 * _t36_inv, -(Math.fma(_t5, _t27, Math.fma(_t6, _t23, _t7 * _t26)) * _t36_inv), _t28 * _t36_inv, _t29 * _t36_inv, _t30 * _t36_inv, -(Math.fma(_t5, _t30, Math.fma(_t6, _t28, _t7 * _t29)) * _t36_inv), _t24 * _t36_inv, _t31 * _t36_inv, _t32 * _t36_inv, -(Math.fma(_t5, _t32, Math.fma(_t6, _t24, _t7 * _t31)) * _t36_inv), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_identity_identity(Float3x4 other) {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_identity_translation(Float3x4 other) {
        return new Float3x4(1.0f, 0.0f, 0.0f, -other.m03(), 0.0f, 1.0f, 0.0f, -other.m13(), 0.0f, 0.0f, 1.0f, -other.m23(), other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_translation_identity(Float3x4 other) {
        return new Float3x4(1.0f, 0.0f, 0.0f, -this.m03, 0.0f, 1.0f, 0.0f, -this.m13, 0.0f, 0.0f, 1.0f, -this.m23, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_translation_translation(Float3x4 other) {
        return new Float3x4(1.0f, 0.0f, 0.0f, -(other.m03() + this.m03), 0.0f, 1.0f, 0.0f, -(other.m13() + this.m13), 0.0f, 0.0f, 1.0f, -(other.m23() + this.m23), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_orthogonal_identity(Float3x4 other) {
        return new Float3x4(this.m00, this.m10, this.m20, Math.fma(-this.m20, this.m23, Math.fma(-this.m10, this.m13, -(this.m00 * this.m03))), this.m01, this.m11, this.m21, Math.fma(-this.m21, this.m23, Math.fma(-this.m11, this.m13, -(this.m01 * this.m03))), this.m02, this.m12, this.m22, Math.fma(-this.m22, this.m23, Math.fma(-this.m12, this.m13, -(this.m02 * this.m03))), Joml.BIT_ORTHOGONAL & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_orthogonal_translation(Float3x4 other) {
        return new Float3x4(this.m00, this.m10, this.m20, Math.fma(-this.m00, this.m03, Math.fma(-this.m10, this.m13, Math.fma(-this.m20, this.m23, -other.m03()))), this.m01, this.m11, this.m21, Math.fma(-this.m01, this.m03, Math.fma(-this.m11, this.m13, Math.fma(-this.m21, this.m23, -other.m13()))), this.m02, this.m12, this.m22, Math.fma(-this.m02, this.m03, Math.fma(-this.m12, this.m13, Math.fma(-this.m22, this.m23, -other.m23()))), Joml.BIT_ORTHOGONAL & other.properties());
    }

    /** Private per-column body of {@code invertProduct_general_identity}; reached only through it. */
    private Float3 invertProduct_general_identity_sac25323_c0(float _t20, float _t33_inv, float _t25, float _t21) {
        return new Float3(_t20 * _t33_inv, _t25 * _t33_inv, _t21 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_general_identity}; reached only through it. */
    private Float3 invertProduct_general_identity_sac25323_c1(float _t23, float _t33_inv, float _t26, float _t28) {
        return new Float3(_t23 * _t33_inv, _t26 * _t33_inv, _t28 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_general_identity}; reached only through it. */
    private Float3 invertProduct_general_identity_sac25323_c2(float _t24, float _t33_inv, float _t27, float _t29) {
        return new Float3(_t24 * _t33_inv, _t27 * _t33_inv, _t29 * _t33_inv);
    }

    /** Private per-column body of {@code invertProduct_general_identity}; reached only through it. */
    private Float3 invertProduct_general_identity_sac25323_c3(float _t24, float _t20, float _t23, float _t33_inv, float _t27, float _t25, float _t26, float _t29, float _t21, float _t28) {
        return new Float3(-(Math.fma(this.m23, _t24, Math.fma(this.m03, _t20, this.m13 * _t23)) * _t33_inv), -(Math.fma(this.m23, _t27, Math.fma(this.m03, _t25, this.m13 * _t26)) * _t33_inv), -(Math.fma(this.m23, _t29, Math.fma(this.m03, _t21, this.m13 * _t28)) * _t33_inv));
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_general_identity(Float3x4 other) {
        float _t20 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t21 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t23 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _t24 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _t25 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _t26 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _t27 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        float _t28 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        float _t29 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t33 = Math.fma(this.m02, _t21, Math.fma(this.m00, _t20, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t33_inv = 1.0f / _t33;
        return new Float3x4(invertProduct_general_identity_sac25323_c0(_t20, _t33_inv, _t25, _t21), invertProduct_general_identity_sac25323_c1(_t23, _t33_inv, _t26, _t28), invertProduct_general_identity_sac25323_c2(_t24, _t33_inv, _t27, _t29), invertProduct_general_identity_sac25323_c3(_t24, _t20, _t23, _t33_inv, _t27, _t25, _t26, _t29, _t21, _t28), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Float3x4 invertProduct_general_translation(Float3x4 other) {
        float _t23 = Math.fma(this.m11, this.m22, -(this.m12 * this.m21));
        float _t24 = Math.fma(this.m10, this.m21, -(this.m11 * this.m20));
        float _t26 = Math.fma(this.m02, this.m21, -(this.m01 * this.m22));
        float _t27 = Math.fma(this.m01, this.m12, -(this.m02 * this.m11));
        float _t28 = Math.fma(this.m12, this.m20, -(this.m10 * this.m22));
        float _t29 = Math.fma(this.m00, this.m22, -(this.m02 * this.m20));
        float _t30 = Math.fma(this.m02, this.m10, -(this.m00 * this.m12));
        float _t31 = Math.fma(this.m01, this.m20, -(this.m00 * this.m21));
        float _t32 = Math.fma(this.m00, this.m11, -(this.m01 * this.m10));
        float _t38 = Math.fma(other.m03(), this.m20, Math.fma(other.m13(), this.m21, Math.fma(other.m23(), this.m22, this.m23)));
        float _t39 = Math.fma(other.m03(), this.m00, Math.fma(other.m13(), this.m01, Math.fma(other.m23(), this.m02, this.m03)));
        float _t40 = Math.fma(other.m03(), this.m10, Math.fma(other.m13(), this.m11, Math.fma(other.m23(), this.m12, this.m13)));
        float _t42 = Math.fma(this.m02, _t24, Math.fma(this.m00, _t23, -(this.m01 * Math.fma(this.m10, this.m22, -(this.m12 * this.m20)))));
        float _t42_inv = 1.0f / _t42;
        return new Float3x4(_t23 * _t42_inv, _t26 * _t42_inv, _t27 * _t42_inv, -(Math.fma(_t38, _t27, Math.fma(_t39, _t23, _t40 * _t26)) * _t42_inv), _t28 * _t42_inv, _t29 * _t42_inv, _t30 * _t42_inv, -(Math.fma(_t38, _t30, Math.fma(_t39, _t28, _t40 * _t29)) * _t42_inv), _t24 * _t42_inv, _t31 * _t42_inv, _t32 * _t42_inv, -(Math.fma(_t38, _t32, Math.fma(_t39, _t24, _t40 * _t31)) * _t42_inv), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x4 invertProduct(Float3x4 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other);
            return invertProduct_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other);
            return invertProduct_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other);
            return invertProduct_general(other, Joml.BIT_ORTHOGONAL & other.properties());
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other);
        return invertProduct_general(other, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}), returning the result as a value.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 invertProduct(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        float _t24 = Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11));
        float _t25 = Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21));
        float _t26 = Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21));
        float _t27 = Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11));
        float _t28 = Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01));
        float _t29 = Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11));
        float _t30 = Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21));
        float _t31 = Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01));
        float _t32 = Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01));
        float _t33 = Math.fma(m03, this.m20, Math.fma(m13, this.m21, Math.fma(m23, this.m22, this.m23)));
        float _t34 = Math.fma(m03, this.m00, Math.fma(m13, this.m01, Math.fma(m23, this.m02, this.m03)));
        float _t35 = Math.fma(m03, this.m10, Math.fma(m13, this.m11, Math.fma(m23, this.m12, this.m13)));
        float _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        float _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        float _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        float _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        float _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        float _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        float _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        float _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        float _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        float _t69 = Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        float _t69_inv = 1.0f / _t69;
        return new Float3x4(_t56 * _t69_inv, _t59 * _t69_inv, _t60 * _t69_inv, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv), _t61 * _t69_inv, _t62 * _t69_inv, _t63 * _t69_inv, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv), _t57 * _t69_inv, _t64 * _t69_inv, _t65 * _t69_inv, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float4x3 transpose_identity() {
        return new Float4x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float4x3 transpose_translation() {
        return new Float4x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Float4x3 transpose_general() {
        return new Float4x3(this.m00, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22, this.m03, this.m13, this.m23);
    }


    /**
     * Transpose this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float4x3 transpose() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation();
        return transpose_general();
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_general(Float3x4 other) {
        return new Float3x4(other.m00() + this.m00, other.m01() + this.m01, other.m02() + this.m02, other.m03() + this.m03, other.m10() + this.m10, other.m11() + this.m11, other.m12() + this.m12, other.m13() + this.m13, other.m20() + this.m20, other.m21() + this.m21, other.m22() + this.m22, other.m23() + this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_identity(Float3x4 other) {
        return new Float3x4(1.0f + other.m00(), other.m01(), other.m02(), other.m03(), other.m10(), 1.0f + other.m11(), other.m12(), other.m13(), other.m20(), other.m21(), 1.0f + other.m22(), other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_translation(Float3x4 other) {
        return new Float3x4(1.0f + other.m00(), other.m01(), other.m02(), other.m03() + this.m03, other.m10(), 1.0f + other.m11(), other.m12(), other.m13() + this.m13, other.m20(), other.m21(), 1.0f + other.m22(), other.m23() + this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_identity_identity(Float3x4 other) {
        return new Float3x4(2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_identity_translation(Float3x4 other) {
        return new Float3x4(2.0f, 0.0f, 0.0f, other.m03(), 0.0f, 2.0f, 0.0f, other.m13(), 0.0f, 0.0f, 2.0f, other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_translation_identity(Float3x4 other) {
        return new Float3x4(2.0f, 0.0f, 0.0f, this.m03, 0.0f, 2.0f, 0.0f, this.m13, 0.0f, 0.0f, 2.0f, this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_translation_translation(Float3x4 other) {
        return new Float3x4(2.0f, 0.0f, 0.0f, other.m03() + this.m03, 0.0f, 2.0f, 0.0f, other.m13() + this.m13, 0.0f, 0.0f, 2.0f, other.m23() + this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_orthogonal_identity(Float3x4 other) {
        return new Float3x4(1.0f + this.m00, this.m01, this.m02, this.m03, this.m10, 1.0f + this.m11, this.m12, this.m13, this.m20, this.m21, 1.0f + this.m22, this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Float3x4 add_orthogonal_translation(Float3x4 other) {
        return new Float3x4(1.0f + this.m00, this.m01, this.m02, other.m03() + this.m03, this.m10, 1.0f + this.m11, this.m12, other.m13() + this.m13, this.m20, this.m21, 1.0f + this.m22, other.m23() + this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Add {@code other} to this matrix, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x4 add(Float3x4 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other);
            return add_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other);
            return add_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other);
            return add_general(other);
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other);
        return add_general(other);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) to this matrix,
     * returning the result as a value.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 add(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        return new Float3x4(m00 + this.m00, m01 + this.m01, m02 + this.m02, m03 + this.m03, m10 + this.m10, m11 + this.m11, m12 + this.m12, m13 + this.m13, m20 + this.m20, m21 + this.m21, m22 + this.m22, m23 + this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x4 negate_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x4 negate_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, -this.m03, 0.0f, -1.0f, 0.0f, -this.m13, 0.0f, 0.0f, -1.0f, -this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Float3x4 negate_general() {
        return new Float3x4(-this.m00, -this.m01, -this.m02, -this.m03, -this.m10, -this.m11, -this.m12, -this.m13, -this.m20, -this.m21, -this.m22, -this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Negate this matrix, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x4 negate() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation();
        return negate_general();
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_general(Float3x4 other) {
        return new Float3x4(this.m00 - other.m00(), this.m01 - other.m01(), this.m02 - other.m02(), this.m03 - other.m03(), this.m10 - other.m10(), this.m11 - other.m11(), this.m12 - other.m12(), this.m13 - other.m13(), this.m20 - other.m20(), this.m21 - other.m21(), this.m22 - other.m22(), this.m23 - other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_identity(Float3x4 other) {
        return new Float3x4(1.0f - other.m00(), -other.m01(), -other.m02(), -other.m03(), -other.m10(), 1.0f - other.m11(), -other.m12(), -other.m13(), -other.m20(), -other.m21(), 1.0f - other.m22(), -other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_identity_identity(Float3x4 other) {
        return new Float3x4(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_identity_translation(Float3x4 other) {
        return new Float3x4(0.0f, 0.0f, 0.0f, -other.m03(), 0.0f, 0.0f, 0.0f, -other.m13(), 0.0f, 0.0f, 0.0f, -other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_translation_identity(Float3x4 other) {
        return new Float3x4(0.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_translation_translation(Float3x4 other) {
        return new Float3x4(0.0f, 0.0f, 0.0f, this.m03 - other.m03(), 0.0f, 0.0f, 0.0f, this.m13 - other.m13(), 0.0f, 0.0f, 0.0f, this.m23 - other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_orthogonal_identity(Float3x4 other) {
        return new Float3x4(-1.0f + this.m00, this.m01, this.m02, this.m03, this.m10, -1.0f + this.m11, this.m12, this.m13, this.m20, this.m21, -1.0f + this.m22, this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_orthogonal_translation(Float3x4 other) {
        return new Float3x4(-1.0f + this.m00, this.m01, this.m02, this.m03 - other.m03(), this.m10, -1.0f + this.m11, this.m12, this.m13 - other.m13(), this.m20, this.m21, -1.0f + this.m22, this.m23 - other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_general_identity(Float3x4 other) {
        return new Float3x4(this.m00 - 1.0f, this.m01, this.m02, this.m03, this.m10, this.m11 - 1.0f, this.m12, this.m13, this.m20, this.m21, this.m22 - 1.0f, this.m23, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Float3x4 sub_general_translation(Float3x4 other) {
        return new Float3x4(this.m00 - 1.0f, this.m01, this.m02, this.m03 - other.m03(), this.m10, this.m11 - 1.0f, this.m12, this.m13 - other.m13(), this.m20, this.m21, this.m22 - 1.0f, this.m23 - other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Subtract {@code other} from this matrix, returning the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float3x4 sub(Float3x4 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other);
            return sub_identity(other);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other);
            return sub_general(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other);
            return sub_general(other);
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other);
        return sub_general(other);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) from this
     * matrix, returning the result as a value.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 sub(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        return new Float3x4(this.m00 - m00, this.m01 - m01, this.m02 - m02, this.m03 - m03, this.m10 - m10, this.m11 - m11, this.m12 - m12, this.m13 - m13, this.m20 - m20, this.m21 - m21, this.m22 - m22, this.m23 - m23, Joml.BIT_AFFINE);
    }


    /**
     * Create a new matrix from the given values.
     *
     * @param v the matrix
     * @return the resulting matrix
     */
    public Float3x4 set(Float3x4 v) {
        return v;
    }


    /**
     * Create a new matrix from the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 set(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23);
    }


    /**
     * Create a new matrix from the given 3x3 matrix, copying the overlapping cells and filling the
     * rest with identity.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x4 set(Float3x3 m) {
        return new Float3x4(m.m00(), m.m01(), m.m02(), 0.0f, m.m10(), m.m11(), m.m12(), 0.0f, m.m20(), m.m21(), m.m22(), 0.0f);
    }


    /**
     * Create a new matrix from the given 4x4 matrix, copying the overlapping cells and dropping the
     * rest.
     *
     * @param m the matrix
     * @return the resulting matrix
     */
    public Float3x4 set(Float4x4 m) {
        return new Float3x4(m.m00(), m.m01(), m.m02(), m.m03(), m.m10(), m.m11(), m.m12(), m.m13(), m.m20(), m.m21(), m.m22(), m.m23());
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @return the resulting matrix
     */
    public Float3x4 withTranslation(Float3 t) {
        return withTranslation(t.x(), t.y(), t.z());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x4 withTranslation_identity(float tX, float tY, float tZ) {
        return new Float3x4(1.0f, 0.0f, 0.0f, tX, 0.0f, 1.0f, 0.0f, tY, 0.0f, 0.0f, 1.0f, tZ, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x4 withTranslation_orthogonal(float tX, float tY, float tZ) {
        return new Float3x4(this.m00, this.m01, this.m02, tX, this.m10, this.m11, this.m12, tY, this.m20, this.m21, this.m22, tZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Float3x4 withTranslation_general(float tX, float tY, float tZ) {
        return new Float3x4(this.m00, this.m01, this.m02, tX, this.m10, this.m11, this.m12, tY, this.m20, this.m21, this.m22, tZ, Joml.BIT_AFFINE);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is returned as a value; {@code this} is not modified.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the translation offsets {@code (tX, tY, tZ)}
     * @return the resulting matrix
     */
    public Float3x4 withTranslation(float tX, float tY, float tZ) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY, tZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return withTranslation_orthogonal(tX, tY, tZ);
        return withTranslation_general(tX, tY, tZ);
    }


    /**
     * Convert this matrix to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double3x4} holding the result
     */
    public Double3x4 toDouble() {
        return new Double3x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23);
    }


    /**
     * Create the given rigid transform's {@code T * R} composition.
     *
     * @param r the rigid transform (whose rotation must be a unit quaternion)
     * @return the resulting matrix
     */
    public static Float3x4 makeFromRigid(FloatRigid r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Create the given rigid transform's {@code T * R} composition.
     *
     * @param rTX the {@code tX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTY the {@code tY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTZ the {@code tZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRX the {@code rX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRY the {@code rY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRZ the {@code rZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @param rRW the {@code rW} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)} (the rotation quaternion must have unit
     *        length)
     * @return the resulting matrix
     */
    public static Float3x4 makeFromRigid(float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = rRZ * rRZ;
        float _t1 = rRZ * rRW;
        float _t2 = rRY * rRW;
        return new Float3x4(Math.fma(-2.0f, Math.fma(rRY, rRY, _t0), 1.0f), 2.0f * Math.fma(rRX, rRY, -_t1), 2.0f * Math.fma(rRX, rRZ, _t2), rTX, 2.0f * Math.fma(rRX, rRY, _t1), Math.fma(-2.0f, Math.fma(rRX, rRX, _t0), 1.0f), 2.0f * Math.fma(rRY, rRZ, -(rRX * rRW)), rTY, 2.0f * Math.fma(rRX, rRZ, -_t2), 2.0f * Math.fma(rRX, rRW, rRY * rRZ), Math.fma(-2.0f, Math.fma(rRX, rRX, rRY * rRY), 1.0f), rTZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create the given transform's {@code T * R * S} composition.
     *
     * @param t the transform
     * @return the resulting matrix
     */
    public static Float3x4 makeFromTransform(FloatTransform t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Create the given transform's {@code T * R * S} composition.
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
    public static Float3x4 makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        return new Float3x4(tSX * Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f), tSY * 2.0f * Math.fma(tRX, tRY, -_t1), tSZ * 2.0f * Math.fma(tRX, tRZ, _t2), tTX, tSX * 2.0f * Math.fma(tRX, tRY, _t1), tSY * Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f), tSZ * 2.0f * Math.fma(tRY, tRZ, -(tRX * tRW)), tTY, tSX * 2.0f * Math.fma(tRX, tRZ, -_t2), tSY * 2.0f * Math.fma(tRX, tRW, tRY * tRZ), tSZ * Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f), tTZ, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_identity() {
        return new Float3x3(1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code to3x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x3} dispatcher.
     */
    private Float3x3 to3x3_general() {
        return new Float3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22, 0);
    }


    /**
     * Extract the upper-left 3x3 block of this matrix (dropping the translation column), returning
     * the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 to3x3() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x3_identity();
        return to3x3_general();
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
        return new Float4x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_orthogonal() {
        return new Float4x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Float4x4 to4x4_general() {
        return new Float4x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_AFFINE);
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
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return to4x4_orthogonal();
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
        return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, 0.5f * this.m03, 0.5f * this.m13, 0.5f * this.m23, 0.0f);
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_orthogonal() {
        float _t0 = -this.m23;
        float _t2 = 1.0f - this.m00;
        float _t4 = this.m21 - this.m12;
        float _t5 = Math.max(this.m11, this.m22);
        float _t6 = this.m01 + this.m10;
        float _t7 = this.m02 + this.m20;
        float _t8 = this.m02 - this.m20;
        float _t9 = this.m12 + this.m21;
        float _t10 = this.m10 - this.m01;
        float _t14 = this.m22 + (this.m00 + this.m11);
        float _t15 = 1.0f + _t14;
        float _t16 = this.m00 + (1.0f - this.m11 - this.m22);
        float _t17 = this.m11 + (_t2 - this.m22);
        float _t18 = this.m22 + (_t2 - this.m11);
        float _t19 = (1.0f / (float) Math.sqrt(_t15));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t18));
        float _t23 = (1.0f / (float) Math.sqrt(_t16));
        float _t63, _t64, _t65, _t66;
        if (_t14 > 0.0f) {
            _t63 = 0.5f * _t4 * _t19;
            _t64 = 0.5f * _t8 * _t19;
            _t65 = 0.5f * _t10 * _t19;
            _t66 = 0.5f * (float) Math.sqrt(_t15);
        } else {
            if (this.m00 > _t5) {
                _t63 = 0.5f * (float) Math.sqrt(_t16);
                _t64 = 0.5f * _t6 * _t23;
                _t65 = 0.5f * _t7 * _t23;
                _t66 = 0.5f * _t4 * _t23;
            } else {
                if (this.m11 > this.m22) {
                    _t63 = 0.5f * _t6 * _t21;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = 0.5f * _t9 * _t21;
                    _t66 = 0.5f * _t8 * _t21;
                } else {
                    _t63 = 0.5f * _t7 * _t22;
                    _t64 = 0.5f * _t9 * _t22;
                    _t65 = 0.5f * (float) Math.sqrt(_t18);
                    _t66 = 0.5f * _t10 * _t22;
                }
            }
        }
        return new FloatDualQuat(_t63, _t64, _t65, _t66, 0.5f * Math.fma(_t0, _t64, Math.fma(this.m03, _t66, this.m13 * _t65)), 0.5f * Math.fma(this.m23, _t63, Math.fma(this.m13, _t66, -(this.m03 * _t65))), 0.5f * Math.fma(this.m23, _t66, Math.fma(this.m03, _t64, -(this.m13 * _t63))), 0.5f * Math.fma(_t0, _t65, Math.fma(-this.m13, _t64, -(this.m03 * _t63))));
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private FloatDualQuat toDualQuat_general() {
        return toDualQuat_orthogonal();
    }


    /**
     * Convert this matrix to a dual quaternion, assuming its upper-left 3x3 block is orthonormal (a
     * rigid transform), returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat toDualQuat() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toDualQuat_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toDualQuat_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return toDualQuat_orthogonal();
        return toDualQuat_general();
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_identity() {
        return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private FloatRigid toRigid_translation() {
        return new FloatRigid(this.m03, this.m13, this.m23, 0.0f, 0.0f, 0.0f, 1.0f);
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
            return new FloatRigid(this.m03, this.m13, this.m23, 0.5f * _t32 * _t61, 0.5f * _t53 * _t61, 0.5f * _t54 * _t61, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                return new FloatRigid(this.m03, this.m13, this.m23, 0.5f * (float) Math.sqrt(_t64), 0.5f * _t51 * _t67, 0.5f * _t52 * _t67, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    return new FloatRigid(this.m03, this.m13, this.m23, 0.5f * _t51 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t28 * _t65, 0.5f * _t53 * _t65);
                } else {
                    return new FloatRigid(this.m03, this.m13, this.m23, 0.5f * _t52 * _t66, 0.5f * _t28 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t54 * _t66);
                }
            }
        }
    }


    /**
     * Decompose this matrix into a rigid transform: translation from the last column, rotation from
     * the column-normalized upper-left 3x3 block (scale is removed by normalizing the columns, but
     * shear is not removed: a sheared block yields a rotation quaternion that is not unit length),
     * returning the result as a value.
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


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private FloatTransform toTransform_translation() {
        return new FloatTransform(this.m03, this.m13, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f);
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
        return new FloatTransform(this.m03, this.m13, this.m23, _t60 > 0.0f ? 0.5f * _t33 * _t62 : _t45 > _t34 ? 0.5f * (float) Math.sqrt(_t65) : _t22 > _t17 ? 0.5f * _t52 * _t66 : 0.5f * _t53 * _t67, _t60 > 0.0f ? 0.5f * _t54 * _t62 : _t45 > _t34 ? 0.5f * _t52 * _t68 : _t22 > _t17 ? 0.5f * (float) Math.sqrt(_t63) : 0.5f * _t29 * _t67, _t60 > 0.0f ? 0.5f * _t55 * _t62 : _t45 > _t34 ? 0.5f * _t53 * _t68 : _t22 > _t17 ? 0.5f * _t29 * _t66 : 0.5f * (float) Math.sqrt(_t64), _t60 > 0.0f ? 0.5f * (float) Math.sqrt(_t61) : _t45 > _t34 ? 0.5f * _t33 * _t68 : _t22 > _t17 ? 0.5f * _t54 * _t66 : 0.5f * _t55 * _t67, _t44 < 0.0f ? -_t15 : _t15, (float) Math.sqrt(_t9), (float) Math.sqrt(_t10));
    }


    /**
     * Decompose this matrix into a TRS transform: translation from the last column, scale from the
     * column lengths of the upper-left 3x3 block, rotation from the column-normalized block (scale
     * is removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length), returning the result as a value.
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
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
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
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
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
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting vector
     */
    public Float3 decomposeSkew() {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeSkew_identity();
        return decomposeSkew_general();
    }

    /** Result value of {@code decomposeTRS}. */
    public record DecomposeTRSResult(Float3 translation, FloatQuat rotation, Float3 scale) {
        /** Canonical constructor. */
        public DecomposeTRSResult(Float3 translation, FloatQuat rotation, Float3 scale) {
            this.translation = translation;
            this.rotation = rotation;
            this.scale = scale;
        }
        /** {@return the {@code translation} component} */
        public Float3 translation() { return translation; }
        /** {@return the {@code rotation} component} */
        public FloatQuat rotation() { return rotation; }
        /** {@return the {@code scale} component} */
        public Float3 scale() { return scale; }
    }


    /**
     * Decompose this matrix into its translation, rotation and scale components.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return a new result value holding the translation, rotation and scale
     */
    public DecomposeTRSResult decomposeTRS() {
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
        float _t20 = -Math.fma(this.m21, _t8, Math.fma(this.m01, _t9, this.m11 * _t10));
        float _t21 = -Math.fma(this.m22, _t8, Math.fma(this.m02, _t9, this.m12 * _t10));
        float _t22 = Math.fma(_t20, _t8, this.m21);
        float _t23 = Math.fma(_t20, _t9, this.m01);
        float _t24 = Math.fma(_t20, _t10, this.m11);
        float _t30 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t23 * _t31;
            _t36 = _t22 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t41 = -Math.fma(Math.fma(_t21, _t8, this.m22), _t36, Math.fma(Math.fma(_t21, _t9, this.m02), _t35, Math.fma(_t21, _t10, this.m12) * _t37));
        float _t45 = Math.fma(_t21, _t8, Math.fma(_t41, _t36, this.m22));
        float _t46 = Math.fma(_t21, _t9, Math.fma(_t41, _t35, this.m02));
        float _t47 = Math.fma(_t21, _t10, Math.fma(_t41, _t37, this.m12));
        float _t50 = Math.fma(_t45, _t45, Math.fma(_t46, _t46, _t47 * _t47));
        float _t51 = (1.0f / (float) Math.sqrt(_t50));
        float _t55, _t56, _t57;
        if (_t50 > 0.0f) {
            _t55 = _t47 * _t51;
            _t56 = _t46 * _t51;
            _t57 = _t45 * _t51;
        } else {
            _t55 = 0.0f;
            _t56 = 0.0f;
            _t57 = 0.0f;
        }
        float _t61 = _t36 - _t55;
        float _t62 = Math.max(_t37, _t57);
        float _t64 = _t36 + _t55;
        float _t73 = Math.fma(Math.fma(_t35, _t55, -(_t37 * _t56)), _t8, Math.fma(Math.fma(_t37, _t57, -(_t36 * _t55)), _t9, Math.fma(_t36, _t56, -(_t35 * _t57)) * _t10));
        float _t74, _t75, _t76;
        if (_t73 < 0.0f) {
            _t74 = -_t9;
            _t75 = -_t10;
            _t76 = -_t8;
        } else {
            _t74 = _t9;
            _t75 = _t10;
            _t76 = _t8;
        }
        float _t77 = _t74 + _t37;
        float _t78 = _t75 + _t35;
        float _t79 = _t75 - _t35;
        float _t81 = _t76 + _t56;
        float _t82 = _t56 - _t76;
        float _t83 = _t77 + _t57;
        float _t87 = 1.0f + _t83;
        float _t88 = 1.0f + (_t74 - (_t37 + _t57));
        float _t89 = 1.0f + (_t37 - (_t74 + _t57));
        float _t90 = 1.0f + (_t57 - _t77);
        float _t91 = (1.0f / (float) Math.sqrt(_t87));
        float _t92 = (1.0f / (float) Math.sqrt(_t89));
        float _t93 = (1.0f / (float) Math.sqrt(_t90));
        float _t94 = (1.0f / (float) Math.sqrt(_t88));
        return new DecomposeTRSResult(new Float3(this.m03, this.m13, this.m23), new FloatQuat(_t83 > 0.0f ? 0.5f * _t61 * _t91 : _t74 > _t62 ? 0.5f * (float) Math.sqrt(_t88) : _t37 > _t57 ? 0.5f * _t78 * _t92 : 0.5f * _t81 * _t93, _t83 > 0.0f ? 0.5f * _t82 * _t91 : _t74 > _t62 ? 0.5f * _t78 * _t94 : _t37 > _t57 ? 0.5f * (float) Math.sqrt(_t89) : 0.5f * _t64 * _t93, _t83 > 0.0f ? 0.5f * _t79 * _t91 : _t74 > _t62 ? 0.5f * _t81 * _t94 : _t37 > _t57 ? 0.5f * _t64 * _t92 : 0.5f * (float) Math.sqrt(_t90), _t83 > 0.0f ? 0.5f * (float) Math.sqrt(_t87) : _t74 > _t62 ? 0.5f * _t61 * _t94 : _t37 > _t57 ? 0.5f * _t82 * _t92 : 0.5f * _t79 * _t93), new Float3(_t73 < 0.0f ? -_t4 : _t4, (float) Math.sqrt(_t30), (float) Math.sqrt(_t50)));
    }


    /**
     * Create an identity matrix.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeIdentity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_general(Float3x4 other, float t) {
        return new Float3x4(Math.fma(t, other.m00() - this.m00, this.m00), Math.fma(t, other.m01() - this.m01, this.m01), Math.fma(t, other.m02() - this.m02, this.m02), Math.fma(t, other.m03() - this.m03, this.m03), Math.fma(t, other.m10() - this.m10, this.m10), Math.fma(t, other.m11() - this.m11, this.m11), Math.fma(t, other.m12() - this.m12, this.m12), Math.fma(t, other.m13() - this.m13, this.m13), Math.fma(t, other.m20() - this.m20, this.m20), Math.fma(t, other.m21() - this.m21, this.m21), Math.fma(t, other.m22() - this.m22, this.m22), Math.fma(t, other.m23() - this.m23, this.m23), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_identity(Float3x4 other, float t) {
        return new Float3x4(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), t * other.m02(), t * other.m03(), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), t * other.m12(), t * other.m13(), t * other.m20(), t * other.m21(), Math.fma(t, other.m22() - 1.0f, 1.0f), t * other.m23(), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_translation(Float3x4 other, float t) {
        return new Float3x4(Math.fma(t, other.m00() - 1.0f, 1.0f), t * other.m01(), t * other.m02(), Math.fma(t, other.m03() - this.m03, this.m03), t * other.m10(), Math.fma(t, other.m11() - 1.0f, 1.0f), t * other.m12(), Math.fma(t, other.m13() - this.m13, this.m13), t * other.m20(), t * other.m21(), Math.fma(t, other.m22() - 1.0f, 1.0f), Math.fma(t, other.m23() - this.m23, this.m23), Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_identity_identity(Float3x4 other, float t) {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_identity_translation(Float3x4 other, float t) {
        return new Float3x4(1.0f, 0.0f, 0.0f, t * other.m03(), 0.0f, 1.0f, 0.0f, t * other.m13(), 0.0f, 0.0f, 1.0f, t * other.m23(), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_translation_identity(Float3x4 other, float t) {
        return new Float3x4(1.0f, 0.0f, 0.0f, Math.fma(-t, this.m03, this.m03), 0.0f, 1.0f, 0.0f, Math.fma(-t, this.m13, this.m13), 0.0f, 0.0f, 1.0f, Math.fma(-t, this.m23, this.m23), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Float3x4 lerp_translation_translation(Float3x4 other, float t) {
        return new Float3x4(1.0f, 0.0f, 0.0f, Math.fma(t, other.m03() - this.m03, this.m03), 0.0f, 1.0f, 0.0f, Math.fma(t, other.m13() - this.m13, this.m13), 0.0f, 0.0f, 1.0f, Math.fma(t, other.m23() - this.m23, this.m23), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting matrix
     */
    public Float3x4 lerp(Float3x4 other, float t) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t);
            return lerp_identity(other, t);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t);
            return lerp_translation(other, t);
        }
        return lerp_general(other, t);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}) using the interpolation factor {@code t}, returning the result as a
     * value.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting matrix
     */
    public Float3x4 lerp(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float t) {
        return new Float3x4(Math.fma(t, m00 - this.m00, this.m00), Math.fma(t, m01 - this.m01, this.m01), Math.fma(t, m02 - this.m02, this.m02), Math.fma(t, m03 - this.m03, this.m03), Math.fma(t, m10 - this.m10, this.m10), Math.fma(t, m11 - this.m11, this.m11), Math.fma(t, m12 - this.m12, this.m12), Math.fma(t, m13 - this.m13, this.m13), Math.fma(t, m20 - this.m20, this.m20), Math.fma(t, m21 - this.m21, this.m21), Math.fma(t, m22 - this.m22, this.m22), Math.fma(t, m23 - this.m23, this.m23), Joml.BIT_AFFINE);
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float3 mul_general_s26368de5_c0(Float3x4 right) {
        return new Float3(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)), Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21)));
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float3 mul_general_s26368de5_c1(Float3x4 right) {
        return new Float3(Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21)));
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float3 mul_general_s26368de5_c2(Float3x4 right) {
        return new Float3(Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21)));
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float3 mul_general_s26368de5_c3(Float3x4 right) {
        return new Float3(Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03))), Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13))), Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23))));
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_general(Float3x4 right, int _props) {
        return new Float3x4(mul_general_s26368de5_c0(right), mul_general_s26368de5_c1(right), mul_general_s26368de5_c2(right), mul_general_s26368de5_c3(right), _props);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_translation(Float3x4 right) {
        return new Float3x4(right.m00(), right.m01(), right.m02(), right.m03() + this.m03, right.m10(), right.m11(), right.m12(), right.m13() + this.m13, right.m20(), right.m21(), right.m22(), right.m23() + this.m23, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_translation_translation(Float3x4 right) {
        return new Float3x4(1.0f, 0.0f, 0.0f, right.m03() + this.m03, 0.0f, 1.0f, 0.0f, right.m13() + this.m13, 0.0f, 0.0f, 1.0f, right.m23() + this.m23, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_orthogonal_translation(Float3x4 right, int _props) {
        return new Float3x4(this.m00, this.m01, this.m02, Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03))), this.m10, this.m11, this.m12, Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13))), this.m20, this.m21, this.m22, Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23))), _props);
    }


    /**
     * Multiply this matrix by {@code right}, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return the resulting matrix
     */
    public Float3x4 mul(Float3x4 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return right;
        int q = right.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right);
            return mul_translation(right);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_ORTHOGONAL & right.properties());
            return mul_general(right, Joml.BIT_ORTHOGONAL & right.properties());
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_AFFINE & right.properties());
        return mul_general(right, Joml.BIT_AFFINE & right.properties());
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10},
     * {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}),
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 mul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        return new Float3x4(Math.fma(m20, this.m02, Math.fma(m00, this.m00, m10 * this.m01)), Math.fma(m21, this.m02, Math.fma(m01, this.m00, m11 * this.m01)), Math.fma(m22, this.m02, Math.fma(m02, this.m00, m12 * this.m01)), Math.fma(m03, this.m00, Math.fma(m13, this.m01, Math.fma(m23, this.m02, this.m03))), Math.fma(m20, this.m12, Math.fma(m00, this.m10, m10 * this.m11)), Math.fma(m21, this.m12, Math.fma(m01, this.m10, m11 * this.m11)), Math.fma(m22, this.m12, Math.fma(m02, this.m10, m12 * this.m11)), Math.fma(m03, this.m10, Math.fma(m13, this.m11, Math.fma(m23, this.m12, this.m13))), Math.fma(m20, this.m22, Math.fma(m00, this.m20, m10 * this.m21)), Math.fma(m21, this.m22, Math.fma(m01, this.m20, m11 * this.m21)), Math.fma(m22, this.m22, Math.fma(m02, this.m20, m12 * this.m21)), Math.fma(m03, this.m20, Math.fma(m13, this.m21, Math.fma(m23, this.m22, this.m23))), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_identity(Float2x2 right) {
        return new Float3x4(right.m00(), right.m01(), 0.0f, 0.0f, right.m10(), right.m11(), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_translation(Float2x2 right) {
        return new Float3x4(right.m00(), right.m01(), 0.0f, this.m03, right.m10(), right.m11(), 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_orthogonal(Float2x2 right) {
        return new Float3x4(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), this.m02, this.m03, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), this.m12, this.m13, Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), this.m22, this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_general(Float2x2 right) {
        return new Float3x4(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), this.m02, this.m03, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), this.m12, this.m13, Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 mul(Float2x2 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right);
        return mul_general(right);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_identity(Float2x3 right) {
        return new Float3x4(right.m00(), right.m01(), right.m02(), 0.0f, right.m10(), right.m11(), right.m12(), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_translation(Float2x3 right) {
        return new Float3x4(right.m00(), right.m01(), right.m02(), this.m03, right.m10(), right.m11(), right.m12(), this.m13, 0.0f, 0.0f, 1.0f, this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_orthogonal(Float2x3 right) {
        return new Float3x4(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m03, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), this.m13, Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_general(Float2x3 right) {
        return new Float3x4(Math.fma(right.m00(), this.m00, right.m10() * this.m01), Math.fma(right.m01(), this.m00, right.m11() * this.m01), Math.fma(right.m02(), this.m00, Math.fma(right.m12(), this.m01, this.m02)), this.m03, Math.fma(right.m00(), this.m10, right.m10() * this.m11), Math.fma(right.m01(), this.m10, right.m11() * this.m11), Math.fma(right.m02(), this.m10, Math.fma(right.m12(), this.m11, this.m12)), this.m13, Math.fma(right.m00(), this.m20, right.m10() * this.m21), Math.fma(right.m01(), this.m20, right.m11() * this.m21), Math.fma(right.m02(), this.m20, Math.fma(right.m12(), this.m21, this.m22)), this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 mul(Float2x3 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right);
        return mul_general(right);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_identity(Float3x3 right) {
        return new Float3x4(right.m00(), right.m01(), right.m02(), 0.0f, right.m10(), right.m11(), right.m12(), 0.0f, right.m20(), right.m21(), right.m22(), 0.0f, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_translation(Float3x3 right) {
        return new Float3x4(right.m00(), right.m01(), right.m02(), this.m03, right.m10(), right.m11(), right.m12(), this.m13, right.m20(), right.m21(), right.m22(), this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_orthogonal(Float3x3 right) {
        return new Float3x4(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)), Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)), Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)), this.m03, Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), this.m13, Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21)), Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21)), Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21)), this.m23, (right.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3x4 mul_general(Float3x3 right) {
        return new Float3x4(Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01)), Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01)), Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01)), this.m03, Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11)), Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11)), Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11)), this.m13, Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21)), Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21)), Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21)), this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 mul(Float3x3 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right);
        return mul_general(right);
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float4 mul_general_s32cf8366_c0(Float4x4 right) {
        return new Float4(Math.fma(right.m30(), this.m03, Math.fma(right.m20(), this.m02, Math.fma(right.m00(), this.m00, right.m10() * this.m01))), Math.fma(right.m30(), this.m13, Math.fma(right.m20(), this.m12, Math.fma(right.m00(), this.m10, right.m10() * this.m11))), Math.fma(right.m30(), this.m23, Math.fma(right.m20(), this.m22, Math.fma(right.m00(), this.m20, right.m10() * this.m21))), right.m30());
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float4 mul_general_s32cf8366_c1(Float4x4 right) {
        return new Float4(Math.fma(right.m31(), this.m03, Math.fma(right.m21(), this.m02, Math.fma(right.m01(), this.m00, right.m11() * this.m01))), Math.fma(right.m31(), this.m13, Math.fma(right.m21(), this.m12, Math.fma(right.m01(), this.m10, right.m11() * this.m11))), Math.fma(right.m31(), this.m23, Math.fma(right.m21(), this.m22, Math.fma(right.m01(), this.m20, right.m11() * this.m21))), right.m31());
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float4 mul_general_s32cf8366_c2(Float4x4 right) {
        return new Float4(Math.fma(right.m32(), this.m03, Math.fma(right.m22(), this.m02, Math.fma(right.m02(), this.m00, right.m12() * this.m01))), Math.fma(right.m32(), this.m13, Math.fma(right.m22(), this.m12, Math.fma(right.m02(), this.m10, right.m12() * this.m11))), Math.fma(right.m32(), this.m23, Math.fma(right.m22(), this.m22, Math.fma(right.m02(), this.m20, right.m12() * this.m21))), right.m32());
    }

    /** Private per-column body of {@code mul_general}; reached only through it. */
    private Float4 mul_general_s32cf8366_c3(Float4x4 right) {
        return new Float4(Math.fma(right.m33(), this.m03, Math.fma(right.m23(), this.m02, Math.fma(right.m03(), this.m00, right.m13() * this.m01))), Math.fma(right.m33(), this.m13, Math.fma(right.m23(), this.m12, Math.fma(right.m03(), this.m10, right.m13() * this.m11))), Math.fma(right.m33(), this.m23, Math.fma(right.m23(), this.m22, Math.fma(right.m03(), this.m20, right.m13() * this.m21))), right.m33());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_general(Float4x4 right, int _props) {
        return new Float4x4(mul_general_s32cf8366_c0(right), mul_general_s32cf8366_c1(right), mul_general_s32cf8366_c2(right), mul_general_s32cf8366_c3(right), _props);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_translation(Float4x4 right) {
        return new Float4x4(Math.fma(right.m30(), this.m03, right.m00()), Math.fma(right.m31(), this.m03, right.m01()), Math.fma(right.m32(), this.m03, right.m02()), Math.fma(right.m33(), this.m03, right.m03()), Math.fma(right.m30(), this.m13, right.m10()), Math.fma(right.m31(), this.m13, right.m11()), Math.fma(right.m32(), this.m13, right.m12()), Math.fma(right.m33(), this.m13, right.m13()), Math.fma(right.m30(), this.m23, right.m20()), Math.fma(right.m31(), this.m23, right.m21()), Math.fma(right.m32(), this.m23, right.m22()), Math.fma(right.m33(), this.m23, right.m23()), right.m30(), right.m31(), right.m32(), right.m33(), Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_translation_identity(Float4x4 right) {
        return new Float4x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_translation_translation(Float4x4 right) {
        return new Float4x4(1.0f, 0.0f, 0.0f, right.m03() + this.m03, 0.0f, 1.0f, 0.0f, right.m13() + this.m13, 0.0f, 0.0f, 1.0f, right.m23() + this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & right.properties());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_orthogonal_identity(Float4x4 right, int _props) {
        return new Float4x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float4x4 mul_orthogonal_translation(Float4x4 right, int _props) {
        return new Float4x4(this.m00, this.m01, this.m02, Math.fma(right.m03(), this.m00, Math.fma(right.m13(), this.m01, Math.fma(right.m23(), this.m02, this.m03))), this.m10, this.m11, this.m12, Math.fma(right.m03(), this.m10, Math.fma(right.m13(), this.m11, Math.fma(right.m23(), this.m12, this.m13))), this.m20, this.m21, this.m22, Math.fma(right.m03(), this.m20, Math.fma(right.m13(), this.m21, Math.fma(right.m23(), this.m22, this.m23))), 0.0f, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Multiply this matrix by the given matrix, returning the result as a value.
     *
     * @param right the right operand
     * @return the resulting matrix
     */
    public Float4x4 mul(Float4x4 right) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return right;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = right.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_translation_identity(right);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right);
            return mul_translation(right);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = right.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, Joml.BIT_ORTHOGONAL & right.properties());
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_ORTHOGONAL & right.properties());
            return mul_general(right, Joml.BIT_ORTHOGONAL & right.properties());
        }
        int q = right.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_orthogonal_identity(right, Joml.BIT_AFFINE & right.properties());
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, Joml.BIT_AFFINE & right.properties());
        return mul_general(right, 0);
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s3cb97cd9_c0(Float3x4 other) {
        return new Float3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s3cb97cd9_c1(Float3x4 other) {
        return new Float3(Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s3cb97cd9_c2(Float3x4 other) {
        return new Float3(Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s3cb97cd9_c3(Float3x4 other) {
        return new Float3(Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03()))), Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13()))), Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23()))));
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_general(Float3x4 other, int _props) {
        return new Float3x4(preMul_general_s3cb97cd9_c0(other), preMul_general_s3cb97cd9_c1(other), preMul_general_s3cb97cd9_c2(other), preMul_general_s3cb97cd9_c3(other), _props);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_translation(Float3x4 other) {
        return new Float3x4(other.m00(), other.m01(), other.m02(), Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03()))), other.m10(), other.m11(), other.m12(), Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13()))), other.m20(), other.m21(), other.m22(), Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23()))), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_translation_translation(Float3x4 other) {
        return new Float3x4(1.0f, 0.0f, 0.0f, other.m03() + this.m03, 0.0f, 1.0f, 0.0f, other.m13() + this.m13, 0.0f, 0.0f, 1.0f, other.m23() + this.m23, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_orthogonal_translation(Float3x4 other, int _props) {
        return new Float3x4(this.m00, this.m01, this.m02, other.m03() + this.m03, this.m10, this.m11, this.m12, other.m13() + this.m13, this.m20, this.m21, this.m22, other.m23() + this.m23, _props);
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
    public Float3x4 preMul(Float3x4 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return other;
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other);
            return preMul_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_ORTHOGONAL & other.properties());
            return preMul_general(other, Joml.BIT_ORTHOGONAL & other.properties());
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_AFFINE & other.properties());
        return preMul_general(other, Joml.BIT_AFFINE & other.properties());
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m03},
     * {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22},
     * {@code m23}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return the resulting matrix
     */
    public Float3x4 preMul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
        return new Float3x4(Math.fma(m02, this.m20, Math.fma(m00, this.m00, m01 * this.m10)), Math.fma(m02, this.m21, Math.fma(m00, this.m01, m01 * this.m11)), Math.fma(m02, this.m22, Math.fma(m00, this.m02, m01 * this.m12)), Math.fma(m00, this.m03, Math.fma(m01, this.m13, Math.fma(m02, this.m23, m03))), Math.fma(m12, this.m20, Math.fma(m10, this.m00, m11 * this.m10)), Math.fma(m12, this.m21, Math.fma(m10, this.m01, m11 * this.m11)), Math.fma(m12, this.m22, Math.fma(m10, this.m02, m11 * this.m12)), Math.fma(m10, this.m03, Math.fma(m11, this.m13, Math.fma(m12, this.m23, m13))), Math.fma(m22, this.m20, Math.fma(m20, this.m00, m21 * this.m10)), Math.fma(m22, this.m21, Math.fma(m20, this.m01, m21 * this.m11)), Math.fma(m22, this.m22, Math.fma(m20, this.m02, m21 * this.m12)), Math.fma(m20, this.m03, Math.fma(m21, this.m13, Math.fma(m22, this.m23, m23))), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_identity(Float2x2 other) {
        return new Float3x4(other.m00(), other.m01(), 0.0f, 0.0f, other.m10(), other.m11(), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_translation(Float2x2 other) {
        return new Float3x4(other.m00(), other.m01(), 0.0f, Math.fma(other.m00(), this.m03, other.m01() * this.m13), other.m10(), other.m11(), 0.0f, Math.fma(other.m10(), this.m03, other.m11() * this.m13), 0.0f, 0.0f, 1.0f, this.m23, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_orthogonal(Float2x2 other) {
        return new Float3x4(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, other.m01() * this.m12), Math.fma(other.m00(), this.m03, other.m01() * this.m13), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, other.m11() * this.m12), Math.fma(other.m10(), this.m03, other.m11() * this.m13), this.m20, this.m21, this.m22, this.m23, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_general(Float2x2 other) {
        return new Float3x4(Math.fma(other.m00(), this.m00, other.m01() * this.m10), Math.fma(other.m00(), this.m01, other.m01() * this.m11), Math.fma(other.m00(), this.m02, other.m01() * this.m12), Math.fma(other.m00(), this.m03, other.m01() * this.m13), Math.fma(other.m10(), this.m00, other.m11() * this.m10), Math.fma(other.m10(), this.m01, other.m11() * this.m11), Math.fma(other.m10(), this.m02, other.m11() * this.m12), Math.fma(other.m10(), this.m03, other.m11() * this.m13), this.m20, this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 preMul(Float2x2 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other);
        return preMul_general(other);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_identity(Float2x3 other) {
        return new Float3x4(other.m00(), other.m01(), other.m02(), 0.0f, other.m10(), other.m11(), other.m12(), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_translation(Float2x3 other) {
        return new Float3x4(other.m00(), other.m01(), other.m02(), Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), other.m10(), other.m11(), other.m12(), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), 0.0f, 0.0f, 1.0f, this.m23, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_orthogonal(Float2x3 other) {
        return new Float3x4(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), this.m20, this.m21, this.m22, this.m23, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_general(Float2x3 other) {
        return new Float3x4(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), this.m20, this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 preMul(Float2x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other);
        return preMul_general(other);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_identity(Float3x3 other) {
        return new Float3x4(other.m00(), other.m01(), other.m02(), 0.0f, other.m10(), other.m11(), other.m12(), 0.0f, other.m20(), other.m21(), other.m22(), 0.0f, (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_translation(Float3x3 other) {
        return new Float3x4(other.m00(), other.m01(), other.m02(), Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), other.m10(), other.m11(), other.m12(), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), other.m20(), other.m21(), other.m22(), Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13)), (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE);
    }

    /** Private per-column body of {@code preMul_orthogonal}; reached only through it. */
    private Float3 preMul_orthogonal_s55dc17e2_c0(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)));
    }

    /** Private per-column body of {@code preMul_orthogonal}; reached only through it. */
    private Float3 preMul_orthogonal_s55dc17e2_c1(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)));
    }

    /** Private per-column body of {@code preMul_orthogonal}; reached only through it. */
    private Float3 preMul_orthogonal_s55dc17e2_c2(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)));
    }

    /** Private per-column body of {@code preMul_orthogonal}; reached only through it. */
    private Float3 preMul_orthogonal_s55dc17e2_c3(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13)));
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_orthogonal(Float3x3 other) {
        return new Float3x4(preMul_orthogonal_s55dc17e2_c0(other), preMul_orthogonal_s55dc17e2_c1(other), preMul_orthogonal_s55dc17e2_c2(other), preMul_orthogonal_s55dc17e2_c3(other), (other.properties() & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE);
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s55dc17e2_c0(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s55dc17e2_c1(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s55dc17e2_c2(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float3 preMul_general_s55dc17e2_c3(Float3x3 other) {
        return new Float3(Math.fma(other.m02(), this.m23, Math.fma(other.m00(), this.m03, other.m01() * this.m13)), Math.fma(other.m12(), this.m23, Math.fma(other.m10(), this.m03, other.m11() * this.m13)), Math.fma(other.m22(), this.m23, Math.fma(other.m20(), this.m03, other.m21() * this.m13)));
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float3x4 preMul_general(Float3x3 other) {
        return new Float3x4(preMul_general_s55dc17e2_c0(other), preMul_general_s55dc17e2_c1(other), preMul_general_s55dc17e2_c2(other), preMul_general_s55dc17e2_c3(other), Joml.BIT_AFFINE);
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
    public Float3x4 preMul(Float3x3 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other);
        return preMul_general(other);
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float4 preMul_general_s4952725a_c0(Float4x4 other) {
        return new Float4(Math.fma(other.m02(), this.m20, Math.fma(other.m00(), this.m00, other.m01() * this.m10)), Math.fma(other.m12(), this.m20, Math.fma(other.m10(), this.m00, other.m11() * this.m10)), Math.fma(other.m22(), this.m20, Math.fma(other.m20(), this.m00, other.m21() * this.m10)), Math.fma(other.m32(), this.m20, Math.fma(other.m30(), this.m00, other.m31() * this.m10)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float4 preMul_general_s4952725a_c1(Float4x4 other) {
        return new Float4(Math.fma(other.m02(), this.m21, Math.fma(other.m00(), this.m01, other.m01() * this.m11)), Math.fma(other.m12(), this.m21, Math.fma(other.m10(), this.m01, other.m11() * this.m11)), Math.fma(other.m22(), this.m21, Math.fma(other.m20(), this.m01, other.m21() * this.m11)), Math.fma(other.m32(), this.m21, Math.fma(other.m30(), this.m01, other.m31() * this.m11)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float4 preMul_general_s4952725a_c2(Float4x4 other) {
        return new Float4(Math.fma(other.m02(), this.m22, Math.fma(other.m00(), this.m02, other.m01() * this.m12)), Math.fma(other.m12(), this.m22, Math.fma(other.m10(), this.m02, other.m11() * this.m12)), Math.fma(other.m22(), this.m22, Math.fma(other.m20(), this.m02, other.m21() * this.m12)), Math.fma(other.m32(), this.m22, Math.fma(other.m30(), this.m02, other.m31() * this.m12)));
    }

    /** Private per-column body of {@code preMul_general}; reached only through it. */
    private Float4 preMul_general_s4952725a_c3(Float4x4 other) {
        return new Float4(Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03()))), Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13()))), Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23()))), Math.fma(other.m30(), this.m03, Math.fma(other.m31(), this.m13, Math.fma(other.m32(), this.m23, other.m33()))));
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_general(Float4x4 other, int _props) {
        return new Float4x4(preMul_general_s4952725a_c0(other), preMul_general_s4952725a_c1(other), preMul_general_s4952725a_c2(other), preMul_general_s4952725a_c3(other), _props);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_translation(Float4x4 other) {
        return new Float4x4(other.m00(), other.m01(), other.m02(), Math.fma(other.m00(), this.m03, Math.fma(other.m01(), this.m13, Math.fma(other.m02(), this.m23, other.m03()))), other.m10(), other.m11(), other.m12(), Math.fma(other.m10(), this.m03, Math.fma(other.m11(), this.m13, Math.fma(other.m12(), this.m23, other.m13()))), other.m20(), other.m21(), other.m22(), Math.fma(other.m20(), this.m03, Math.fma(other.m21(), this.m13, Math.fma(other.m22(), this.m23, other.m23()))), other.m30(), other.m31(), other.m32(), Math.fma(other.m30(), this.m03, Math.fma(other.m31(), this.m13, Math.fma(other.m32(), this.m23, other.m33()))), Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_translation_identity(Float4x4 other) {
        return new Float4x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_translation_translation(Float4x4 other) {
        return new Float4x4(1.0f, 0.0f, 0.0f, other.m03() + this.m03, 0.0f, 1.0f, 0.0f, other.m13() + this.m13, 0.0f, 0.0f, 1.0f, other.m23() + this.m23, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_TRANSLATION & other.properties());
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_orthogonal_identity(Float4x4 other, int _props) {
        return new Float4x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, 0.0f, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Float4x4 preMul_orthogonal_translation(Float4x4 other, int _props) {
        return new Float4x4(this.m00, this.m01, this.m02, other.m03() + this.m03, this.m10, this.m11, this.m12, other.m13() + this.m13, this.m20, this.m21, this.m22, other.m23() + this.m23, 0.0f, 0.0f, 0.0f, 1.0f, _props);
    }


    /**
     * Pre-multiply the given matrix onto this matrix, i.e. compute {@code other * this}, returning
     * the result as a value.
     *
     * @param other the other matrix
     * @return the resulting matrix
     */
    public Float4x4 preMul(Float4x4 other) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return other;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_translation_identity(other);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other);
            return preMul_translation(other);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            int q = other.properties();
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, Joml.BIT_ORTHOGONAL & other.properties());
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_ORTHOGONAL & other.properties());
            return preMul_general(other, Joml.BIT_ORTHOGONAL & other.properties());
        }
        int q = other.properties();
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_orthogonal_identity(other, Joml.BIT_AFFINE & other.properties());
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, Joml.BIT_AFFINE & other.properties());
        return preMul_general(other, 0);
    }


    /**
     * Create a transformation composed of the given translation, rotation and scale, applied in
     * scale-rotation-translation order.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @return the resulting matrix
     */
    public static Float3x4 composeTRS(Float3 translation, FloatQuat rotation, Float3 scale) {
        return composeTRS(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w(), scale.x(), scale.y(), scale.z());
    }


    /**
     * Create a transformation composed of the given translation, rotation and scale, applied in
     * scale-rotation-translation order.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @return the resulting matrix
     */
    public static Float3x4 composeTRS(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        return new Float3x4(scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f), scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t1), scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t2), translationX, scaleX * 2.0f * Math.fma(rotationX, rotationY, _t1), scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f), scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)), translationY, scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t2), scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ), scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f), translationZ, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation composed of the given translation, rotation and scale (applied in
     * scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @param m the matrix
     * @return the resulting matrix
     */
    public static Float3x4 composeTRSMul(Float3 translation, FloatQuat rotation, Float3 scale, Float3x4 m) {
        return composeTRSMul(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w(), scale.x(), scale.y(), scale.z(), m);
    }

    /** Private per-column body of {@code composeTRSMul}; reached only through it. */
    private static Float3 composeTRSMul_s30ad71d3_c0(Float3x4 m, float _t27, float _t33, float _t30, float _t31, float _t28, float _t34, float _t35, float _t32, float _t29) {
        return new Float3(Math.fma(m.m20(), _t27, Math.fma(m.m00(), _t33, m.m10() * _t30)), Math.fma(m.m20(), _t31, Math.fma(m.m00(), _t28, m.m10() * _t34)), Math.fma(m.m20(), _t35, Math.fma(m.m00(), _t32, m.m10() * _t29)));
    }

    /** Private per-column body of {@code composeTRSMul}; reached only through it. */
    private static Float3 composeTRSMul_s30ad71d3_c1(Float3x4 m, float _t27, float _t33, float _t30, float _t31, float _t28, float _t34, float _t35, float _t32, float _t29) {
        return new Float3(Math.fma(m.m21(), _t27, Math.fma(m.m01(), _t33, m.m11() * _t30)), Math.fma(m.m21(), _t31, Math.fma(m.m01(), _t28, m.m11() * _t34)), Math.fma(m.m21(), _t35, Math.fma(m.m01(), _t32, m.m11() * _t29)));
    }

    /** Private per-column body of {@code composeTRSMul}; reached only through it. */
    private static Float3 composeTRSMul_s30ad71d3_c2(Float3x4 m, float _t27, float _t33, float _t30, float _t31, float _t28, float _t34, float _t35, float _t32, float _t29) {
        return new Float3(Math.fma(m.m22(), _t27, Math.fma(m.m02(), _t33, m.m12() * _t30)), Math.fma(m.m22(), _t31, Math.fma(m.m02(), _t28, m.m12() * _t34)), Math.fma(m.m22(), _t35, Math.fma(m.m02(), _t32, m.m12() * _t29)));
    }

    /** Private per-column body of {@code composeTRSMul}; reached only through it. */
    private static Float3 composeTRSMul_s30ad71d3_c3(Float3x4 m, float _t33, float _t30, float _t27, float translationX, float _t28, float _t34, float _t31, float translationY, float _t32, float _t29, float _t35, float translationZ) {
        return new Float3(Math.fma(m.m03(), _t33, Math.fma(m.m13(), _t30, Math.fma(m.m23(), _t27, translationX))), Math.fma(m.m03(), _t28, Math.fma(m.m13(), _t34, Math.fma(m.m23(), _t31, translationY))), Math.fma(m.m03(), _t32, Math.fma(m.m13(), _t29, Math.fma(m.m23(), _t35, translationZ))));
    }


    /**
     * Create a transformation composed of the given translation, rotation and scale (applied in
     * scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param m the matrix
     * @return the resulting matrix
     */
    public static Float3x4 composeTRSMul(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ, Float3x4 m) {
        float _t0 = rotationY * rotationW;
        float _t1 = rotationZ * rotationZ;
        float _t2 = rotationZ * rotationW;
        float _t27 = scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t0);
        float _t28 = scaleX * 2.0f * Math.fma(rotationX, rotationY, _t2);
        float _t29 = scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ);
        float _t30 = scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t2);
        float _t31 = scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW));
        float _t32 = scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t0);
        float _t33 = scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t1), 1.0f);
        float _t34 = scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t1), 1.0f);
        float _t35 = scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f);
        return new Float3x4(composeTRSMul_s30ad71d3_c0(m, _t27, _t33, _t30, _t31, _t28, _t34, _t35, _t32, _t29), composeTRSMul_s30ad71d3_c1(m, _t27, _t33, _t30, _t31, _t28, _t34, _t35, _t32, _t29), composeTRSMul_s30ad71d3_c2(m, _t27, _t33, _t30, _t31, _t28, _t34, _t35, _t32, _t29), composeTRSMul_s30ad71d3_c3(m, _t33, _t30, _t27, translationX, _t28, _t34, _t31, translationY, _t32, _t29, _t35, translationZ), Joml.BIT_AFFINE);
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
    public Float3x4 lookAlong(Float3 dir, Float3 up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Float3x4 lookAlong_identity(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new Float3x4(_t26, Math.fma(_t7, _t27, -(_t9 * _t28)), _t8, 0.0f, _t28, Math.fma(_t9, _t26, -(_t8 * _t27)), _t7, 0.0f, _t27, Math.fma(_t8, _t28, -(_t7 * _t26)), _t9, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Float3x4 lookAlong_translation(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new Float3x4(_t26, Math.fma(_t7, _t27, -(_t9 * _t28)), _t8, this.m03, _t28, Math.fma(_t9, _t26, -(_t8 * _t27)), _t7, this.m13, _t27, Math.fma(_t8, _t28, -(_t7 * _t26)), _t9, this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAlong_orthogonal}; reached only through it. */
    private Float3 lookAlong_orthogonal_s524747ee_c0(float _t26, float _t27, float _t28) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28)));
    }

    /** Private per-column body of {@code lookAlong_orthogonal}; reached only through it. */
    private Float3 lookAlong_orthogonal_s524747ee_c1(float _t35, float _t36, float _t37) {
        return new Float3(Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37)), Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37)), Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37)));
    }

    /** Private per-column body of {@code lookAlong_orthogonal}; reached only through it. */
    private Float3 lookAlong_orthogonal_s524747ee_c2(float _t9, float _t8, float _t7) {
        return new Float3(Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7)), Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7)), Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7)));
    }

    /** Private per-column body of {@code lookAlong_orthogonal}; reached only through it. */
    private Float3 lookAlong_orthogonal_s524747ee_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Float3x4 lookAlong_orthogonal(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new Float3x4(lookAlong_orthogonal_s524747ee_c0(_t26, _t27, _t28), lookAlong_orthogonal_s524747ee_c1(_t35, _t36, _t37), lookAlong_orthogonal_s524747ee_c2(_t9, _t8, _t7), lookAlong_orthogonal_s524747ee_c3(), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAlong_general}; reached only through it. */
    private Float3 lookAlong_general_s524747ee_c0(float _t26, float _t27, float _t28) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t27, this.m01 * _t28)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t27, this.m11 * _t28)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t27, this.m21 * _t28)));
    }

    /** Private per-column body of {@code lookAlong_general}; reached only through it. */
    private Float3 lookAlong_general_s524747ee_c1(float _t35, float _t36, float _t37) {
        return new Float3(Math.fma(this.m02, _t35, Math.fma(this.m00, _t36, this.m01 * _t37)), Math.fma(this.m12, _t35, Math.fma(this.m10, _t36, this.m11 * _t37)), Math.fma(this.m22, _t35, Math.fma(this.m20, _t36, this.m21 * _t37)));
    }

    /** Private per-column body of {@code lookAlong_general}; reached only through it. */
    private Float3 lookAlong_general_s524747ee_c2(float _t9, float _t8, float _t7) {
        return new Float3(Math.fma(this.m02, _t9, Math.fma(this.m00, _t8, this.m01 * _t7)), Math.fma(this.m12, _t9, Math.fma(this.m10, _t8, this.m11 * _t7)), Math.fma(this.m22, _t9, Math.fma(this.m20, _t8, this.m21 * _t7)));
    }

    /** Private per-column body of {@code lookAlong_general}; reached only through it. */
    private Float3 lookAlong_general_s524747ee_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code lookAlong}, specialized by runtime matrix properties; reached only
     * through the public {@code lookAlong} dispatcher.
     */
    private Float3x4 lookAlong_general(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new Float3x4(lookAlong_general_s524747ee_c0(_t26, _t27, _t28), lookAlong_general_s524747ee_c1(_t35, _t36, _t37), lookAlong_general_s524747ee_c2(_t9, _t8, _t7), lookAlong_general_s524747ee_c3(), Joml.BIT_AFFINE);
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
    public Float3x4 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAlong_identity(dirX, dirY, dirZ, upX, upY, upZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAlong_translation(dirX, dirY, dirZ, upX, upY, upZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAlong_orthogonal(dirX, dirY, dirZ, upX, upY, upZ);
        return lookAlong_general(dirX, dirY, dirZ, upX, upY, upZ);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh(Float3 eye, Float3 center, Float3 up) {
        return lookAt_lh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    /** Private per-column body of {@code lookAt_lh_identity}; reached only through it. */
    private Float3 lookAt_lh_identity_s185c1ac6_c0(float _t29, float _t38, float _t11) {
        return new Float3(_t29, _t38, _t11);
    }

    /** Private per-column body of {@code lookAt_lh_identity}; reached only through it. */
    private Float3 lookAt_lh_identity_s185c1ac6_c1(float _t30, float _t39, float _t10) {
        return new Float3(_t30, _t39, _t10);
    }

    /** Private per-column body of {@code lookAt_lh_identity}; reached only through it. */
    private Float3 lookAt_lh_identity_s185c1ac6_c2(float _t31, float _t40, float _t12) {
        return new Float3(_t31, _t40, _t12);
    }

    /** Private per-column body of {@code lookAt_lh_identity}; reached only through it. */
    private Float3 lookAt_lh_identity_s185c1ac6_c3(float eyeZ, float _t31, float eyeX, float _t29, float eyeY, float _t30, float _t40, float _t38, float _t39, float _t12, float _t11, float _t10) {
        return new Float3(-Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)), -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)), -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10)));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh_identity(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        return new Float3x4(lookAt_lh_identity_s185c1ac6_c0(_t29, _t38, _t11), lookAt_lh_identity_s185c1ac6_c1(_t30, _t39, _t10), lookAt_lh_identity_s185c1ac6_c2(_t31, _t40, _t12), lookAt_lh_identity_s185c1ac6_c3(eyeZ, _t31, eyeX, _t29, eyeY, _t30, _t40, _t38, _t39, _t12, _t11, _t10), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAt_lh_translation}; reached only through it. */
    private Float3 lookAt_lh_translation_s185c1ac6_c0(float _t32, float _t41, float _t14) {
        return new Float3(_t32, _t41, _t14);
    }

    /** Private per-column body of {@code lookAt_lh_translation}; reached only through it. */
    private Float3 lookAt_lh_translation_s185c1ac6_c1(float _t33, float _t42, float _t13) {
        return new Float3(_t33, _t42, _t13);
    }

    /** Private per-column body of {@code lookAt_lh_translation}; reached only through it. */
    private Float3 lookAt_lh_translation_s185c1ac6_c2(float _t34, float _t43, float _t15) {
        return new Float3(_t34, _t43, _t15);
    }

    /** Private per-column body of {@code lookAt_lh_translation}; reached only through it. */
    private Float3 lookAt_lh_translation_s185c1ac6_c3(float _t0, float _t32, float _t1, float _t33, float _t2, float _t34, float _t41, float _t42, float _t43, float _t14, float _t13, float _t15) {
        return new Float3(Math.fma(_t0, _t32, Math.fma(_t1, _t33, Math.fma(_t2, _t34, this.m03))), Math.fma(_t0, _t41, Math.fma(_t1, _t42, Math.fma(_t2, _t43, this.m13))), Math.fma(_t0, _t14, Math.fma(_t1, _t13, Math.fma(_t2, _t15, this.m23))));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh_translation(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -eyeX;
        float _t1 = -eyeY;
        float _t2 = -eyeZ;
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t5 * _t9;
            _t14 = _t4 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t22 = Math.fma(upX, _t13, -(upY * _t14));
        float _t23 = Math.fma(upY, _t15, -(upZ * _t13));
        float _t24 = Math.fma(upZ, _t14, -(upX * _t15));
        float _t27 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t23 * _t28;
            _t33 = _t24 * _t28;
            _t34 = _t22 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t41 = Math.fma(_t13, _t34, -(_t15 * _t33));
        float _t42 = Math.fma(_t15, _t32, -(_t14 * _t34));
        float _t43 = Math.fma(_t14, _t33, -(_t13 * _t32));
        return new Float3x4(lookAt_lh_translation_s185c1ac6_c0(_t32, _t41, _t14), lookAt_lh_translation_s185c1ac6_c1(_t33, _t42, _t13), lookAt_lh_translation_s185c1ac6_c2(_t34, _t43, _t15), lookAt_lh_translation_s185c1ac6_c3(_t0, _t32, _t1, _t33, _t2, _t34, _t41, _t42, _t43, _t14, _t13, _t15), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAt_lh_orthogonal}; reached only through it. */
    private Float3 lookAt_lh_orthogonal_s185c1ac6_c0(float _t10, float _t32, float _t43) {
        return new Float3(Math.fma(this.m02, _t10, Math.fma(this.m00, _t32, this.m01 * _t43)), Math.fma(this.m12, _t10, Math.fma(this.m10, _t32, this.m11 * _t43)), Math.fma(this.m22, _t10, Math.fma(this.m20, _t32, this.m21 * _t43)));
    }

    /** Private per-column body of {@code lookAt_lh_orthogonal}; reached only through it. */
    private Float3 lookAt_lh_orthogonal_s185c1ac6_c1(float _t11, float _t34, float _t44) {
        return new Float3(Math.fma(this.m02, _t11, Math.fma(this.m00, _t34, this.m01 * _t44)), Math.fma(this.m12, _t11, Math.fma(this.m10, _t34, this.m11 * _t44)), Math.fma(this.m22, _t11, Math.fma(this.m20, _t34, this.m21 * _t44)));
    }

    /** Private per-column body of {@code lookAt_lh_orthogonal}; reached only through it. */
    private Float3 lookAt_lh_orthogonal_s185c1ac6_c2(float _t12, float _t33, float _t45) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t33, this.m01 * _t45)), Math.fma(this.m12, _t12, Math.fma(this.m10, _t33, this.m11 * _t45)), Math.fma(this.m22, _t12, Math.fma(this.m20, _t33, this.m21 * _t45)));
    }

    /** Private per-column body of {@code lookAt_lh_orthogonal}; reached only through it. */
    private Float3 lookAt_lh_orthogonal_s185c1ac6_c3(float _t47, float _t49, float _t24) {
        return new Float3(Math.fma(-this.m00, _t47, Math.fma(-this.m01, _t49, Math.fma(-this.m02, _t24, this.m03))), Math.fma(-this.m10, _t47, Math.fma(-this.m11, _t49, Math.fma(-this.m12, _t24, this.m13))), Math.fma(-this.m20, _t47, Math.fma(-this.m21, _t49, Math.fma(-this.m22, _t24, this.m23))));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh_orthogonal(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        return new Float3x4(lookAt_lh_orthogonal_s185c1ac6_c0(_t10, _t32, _t43), lookAt_lh_orthogonal_s185c1ac6_c1(_t11, _t34, _t44), lookAt_lh_orthogonal_s185c1ac6_c2(_t12, _t33, _t45), lookAt_lh_orthogonal_s185c1ac6_c3(_t47, _t49, _t24), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAt_lh_general}; reached only through it. */
    private Float3 lookAt_lh_general_s185c1ac6_c0(float _t10, float _t32, float _t43) {
        return new Float3(Math.fma(this.m02, _t10, Math.fma(this.m00, _t32, this.m01 * _t43)), Math.fma(this.m12, _t10, Math.fma(this.m10, _t32, this.m11 * _t43)), Math.fma(this.m22, _t10, Math.fma(this.m20, _t32, this.m21 * _t43)));
    }

    /** Private per-column body of {@code lookAt_lh_general}; reached only through it. */
    private Float3 lookAt_lh_general_s185c1ac6_c1(float _t11, float _t34, float _t44) {
        return new Float3(Math.fma(this.m02, _t11, Math.fma(this.m00, _t34, this.m01 * _t44)), Math.fma(this.m12, _t11, Math.fma(this.m10, _t34, this.m11 * _t44)), Math.fma(this.m22, _t11, Math.fma(this.m20, _t34, this.m21 * _t44)));
    }

    /** Private per-column body of {@code lookAt_lh_general}; reached only through it. */
    private Float3 lookAt_lh_general_s185c1ac6_c2(float _t12, float _t33, float _t45) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t33, this.m01 * _t45)), Math.fma(this.m12, _t12, Math.fma(this.m10, _t33, this.m11 * _t45)), Math.fma(this.m22, _t12, Math.fma(this.m20, _t33, this.m21 * _t45)));
    }

    /** Private per-column body of {@code lookAt_lh_general}; reached only through it. */
    private Float3 lookAt_lh_general_s185c1ac6_c3(float _t47, float _t49, float _t24) {
        return new Float3(Math.fma(-this.m00, _t47, Math.fma(-this.m01, _t49, Math.fma(-this.m02, _t24, this.m03))), Math.fma(-this.m10, _t47, Math.fma(-this.m11, _t49, Math.fma(-this.m12, _t24, this.m13))), Math.fma(-this.m20, _t47, Math.fma(-this.m21, _t49, Math.fma(-this.m22, _t24, this.m23))));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh_general(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        return new Float3x4(lookAt_lh_general_s185c1ac6_c0(_t10, _t32, _t43), lookAt_lh_general_s185c1ac6_c1(_t11, _t34, _t44), lookAt_lh_general_s185c1ac6_c2(_t12, _t33, _t45), lookAt_lh_general_s185c1ac6_c3(_t47, _t49, _t24), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.LEFT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_lh(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_lh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_lh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_lh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh(Float3 eye, Float3 center, Float3 up) {
        return lookAt_rh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    /** Private per-column body of {@code lookAt_rh_identity}; reached only through it. */
    private Float3 lookAt_rh_identity_s185c1ac6_c0(float _t29, float _t38, float _t10) {
        return new Float3(_t29, _t38, -_t10);
    }

    /** Private per-column body of {@code lookAt_rh_identity}; reached only through it. */
    private Float3 lookAt_rh_identity_s185c1ac6_c1(float _t30, float _t39, float _t11) {
        return new Float3(_t30, _t39, -_t11);
    }

    /** Private per-column body of {@code lookAt_rh_identity}; reached only through it. */
    private Float3 lookAt_rh_identity_s185c1ac6_c2(float _t31, float _t40, float _t12) {
        return new Float3(_t31, _t40, -_t12);
    }

    /** Private per-column body of {@code lookAt_rh_identity}; reached only through it. */
    private Float3 lookAt_rh_identity_s185c1ac6_c3(float eyeZ, float _t31, float eyeX, float _t29, float eyeY, float _t30, float _t40, float _t38, float _t39, float _t12, float _t10, float _t11) {
        return new Float3(-Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)), -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)), Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh_identity(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upY, _t10, -(upX * _t11));
        float _t20 = Math.fma(upX, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upY * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        return new Float3x4(lookAt_rh_identity_s185c1ac6_c0(_t29, _t38, _t10), lookAt_rh_identity_s185c1ac6_c1(_t30, _t39, _t11), lookAt_rh_identity_s185c1ac6_c2(_t31, _t40, _t12), lookAt_rh_identity_s185c1ac6_c3(eyeZ, _t31, eyeX, _t29, eyeY, _t30, _t40, _t38, _t39, _t12, _t10, _t11), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code lookAt_rh_translation}; reached only through it. */
    private Float3 lookAt_rh_translation_s185c1ac6_c0(float _t32, float _t41, float _t13) {
        return new Float3(_t32, _t41, -_t13);
    }

    /** Private per-column body of {@code lookAt_rh_translation}; reached only through it. */
    private Float3 lookAt_rh_translation_s185c1ac6_c1(float _t33, float _t42, float _t14) {
        return new Float3(_t33, _t42, -_t14);
    }

    /** Private per-column body of {@code lookAt_rh_translation}; reached only through it. */
    private Float3 lookAt_rh_translation_s185c1ac6_c2(float _t34, float _t43, float _t15) {
        return new Float3(_t34, _t43, -_t15);
    }

    /** Private per-column body of {@code lookAt_rh_translation}; reached only through it. */
    private Float3 lookAt_rh_translation_s185c1ac6_c3(float _t0, float _t32, float _t1, float _t33, float _t2, float _t34, float _t41, float _t42, float _t43, float eyeX, float _t13, float eyeY, float _t14, float eyeZ, float _t15) {
        return new Float3(Math.fma(_t0, _t32, Math.fma(_t1, _t33, Math.fma(_t2, _t34, this.m03))), Math.fma(_t0, _t41, Math.fma(_t1, _t42, Math.fma(_t2, _t43, this.m13))), Math.fma(eyeX, _t13, Math.fma(eyeY, _t14, Math.fma(eyeZ, _t15, this.m23))));
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh_translation(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -eyeX;
        float _t1 = -eyeY;
        float _t2 = -eyeZ;
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t22 = Math.fma(upY, _t13, -(upX * _t14));
        float _t23 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t24 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t24 * _t28;
            _t33 = _t23 * _t28;
            _t34 = _t22 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t41 = Math.fma(_t15, _t33, -(_t14 * _t34));
        float _t42 = Math.fma(_t13, _t34, -(_t15 * _t32));
        float _t43 = Math.fma(_t14, _t32, -(_t13 * _t33));
        return new Float3x4(lookAt_rh_translation_s185c1ac6_c0(_t32, _t41, _t13), lookAt_rh_translation_s185c1ac6_c1(_t33, _t42, _t14), lookAt_rh_translation_s185c1ac6_c2(_t34, _t43, _t15), lookAt_rh_translation_s185c1ac6_c3(_t0, _t32, _t1, _t33, _t2, _t34, _t41, _t42, _t43, eyeX, _t13, eyeY, _t14, eyeZ, _t15), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh_orthogonal(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -this.m02;
        float _t1 = -this.m12;
        float _t2 = -this.m22;
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t24 = Math.fma(upY, _t13, -(upX * _t14));
        float _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        float _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        return new Float3x4(Math.fma(_t0, _t13, Math.fma(this.m00, _t35, this.m01 * _t46)), Math.fma(_t0, _t14, Math.fma(this.m00, _t36, this.m01 * _t47)), Math.fma(_t0, _t15, Math.fma(this.m00, _t37, this.m01 * _t48)), Math.fma(-this.m00, _t50, Math.fma(-this.m01, _t52, Math.fma(this.m02, _t27, this.m03))), Math.fma(_t1, _t13, Math.fma(this.m10, _t35, this.m11 * _t46)), Math.fma(_t1, _t14, Math.fma(this.m10, _t36, this.m11 * _t47)), Math.fma(_t1, _t15, Math.fma(this.m10, _t37, this.m11 * _t48)), Math.fma(-this.m10, _t50, Math.fma(-this.m11, _t52, Math.fma(this.m12, _t27, this.m13))), Math.fma(_t2, _t13, Math.fma(this.m20, _t35, this.m21 * _t46)), Math.fma(_t2, _t14, Math.fma(this.m20, _t36, this.m21 * _t47)), Math.fma(_t2, _t15, Math.fma(this.m20, _t37, this.m21 * _t48)), Math.fma(-this.m20, _t50, Math.fma(-this.m21, _t52, Math.fma(this.m22, _t27, this.m23))), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}, specialized by runtime
     * matrix properties; reached only through the public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh_general(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -this.m02;
        float _t1 = -this.m12;
        float _t2 = -this.m22;
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13, _t14, _t15;
        if (_t8 > 0.0f) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0f;
            _t14 = 0.0f;
            _t15 = 0.0f;
        }
        float _t24 = Math.fma(upY, _t13, -(upX * _t14));
        float _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35, _t36, _t37;
        if (_t30 > 0.0f) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0f;
            _t36 = 0.0f;
            _t37 = 0.0f;
        }
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        float _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        return new Float3x4(Math.fma(_t0, _t13, Math.fma(this.m00, _t35, this.m01 * _t46)), Math.fma(_t0, _t14, Math.fma(this.m00, _t36, this.m01 * _t47)), Math.fma(_t0, _t15, Math.fma(this.m00, _t37, this.m01 * _t48)), Math.fma(-this.m00, _t50, Math.fma(-this.m01, _t52, Math.fma(this.m02, _t27, this.m03))), Math.fma(_t1, _t13, Math.fma(this.m10, _t35, this.m11 * _t46)), Math.fma(_t1, _t14, Math.fma(this.m10, _t36, this.m11 * _t47)), Math.fma(_t1, _t15, Math.fma(this.m10, _t37, this.m11 * _t48)), Math.fma(-this.m10, _t50, Math.fma(-this.m11, _t52, Math.fma(this.m12, _t27, this.m13))), Math.fma(_t2, _t13, Math.fma(this.m20, _t35, this.m21 * _t46)), Math.fma(_t2, _t14, Math.fma(this.m20, _t36, this.m21 * _t47)), Math.fma(_t2, _t15, Math.fma(this.m20, _t37, this.m21 * _t48)), Math.fma(-this.m20, _t50, Math.fma(-this.m21, _t52, Math.fma(this.m22, _t27, this.m23))), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code lookAt} for {@code Handedness.RIGHT_HANDED}; reached only through the
     * public {@code lookAt} dispatcher.
     */
    private Float3x4 lookAt_rh(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lookAt_rh_identity(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lookAt_rh_translation(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return lookAt_rh_orthogonal(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_general(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return the resulting matrix
     */
    public Float3x4 lookAt(Float3 eye, Float3 center, Float3 up, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eye, center, up); }
            default -> { return lookAt_rh(eye, center, up); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return the resulting matrix
     */
    public Float3x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return lookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
            default -> { return lookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
        }
    }


    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public Float3x4 lookAt(Float3 eye, Float3 center, Float3 up) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED); }


    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public Float3x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED); }


    /**
     * Create a cylindrical billboard transformation that rotates about the given axis to face the
     * camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up" (must be a unit vector)
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardCylindrical(Float3 objPos, Float3 targetPos, Float3 up) {
        return makeBillboardCylindrical(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z(), up.x(), up.y(), up.z());
    }


    /**
     * Create a cylindrical billboard transformation that rotates about the given axis to face the
     * camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardCylindrical(float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        float _t0 = targetPosY - objPosY;
        float _t1 = targetPosX - objPosX;
        float _t2 = targetPosZ - objPosZ;
        float _t9 = Math.fma(upX, _t0, -(upY * _t1));
        float _t10 = Math.fma(upY, _t2, -(upZ * _t0));
        float _t11 = Math.fma(upZ, _t1, -(upX * _t2));
        float _t14 = Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        float _t19, _t20, _t21;
        if (_t14 > 0.0f) {
            _t19 = _t10 * _t15;
            _t20 = _t11 * _t15;
            _t21 = _t9 * _t15;
        } else {
            _t19 = 0.0f;
            _t20 = 0.0f;
            _t21 = 0.0f;
        }
        float _t28 = Math.fma(upY, _t19, -(upX * _t20));
        float _t29 = Math.fma(upX, _t21, -(upZ * _t19));
        float _t30 = Math.fma(upZ, _t20, -(upY * _t21));
        float _t33 = Math.fma(_t28, _t28, Math.fma(_t29, _t29, _t30 * _t30));
        float _t34 = (1.0f / (float) Math.sqrt(_t33));
        return new Float3x4(_t19, upX, _t33 > 0.0f ? _t30 * _t34 : 0.0f, objPosX, _t20, upY, _t33 > 0.0f ? _t29 * _t34 : 0.0f, objPosY, _t21, upZ, _t33 > 0.0f ? _t28 * _t34 : 0.0f, objPosZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a spherical billboard transformation that faces the camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardSpherical(Float3 objPos, Float3 targetPos, Float3 up) {
        return makeBillboardSpherical(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z(), up.x(), up.y(), up.z());
    }


    /**
     * Create a spherical billboard transformation that faces the camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardSpherical(float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        float _t0 = targetPosZ - objPosZ;
        float _t1 = targetPosX - objPosX;
        float _t2 = targetPosY - objPosY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        return new Float3x4(_t29, Math.fma(_t10, _t30, -(_t12 * _t31)), _t11, objPosX, _t31, Math.fma(_t12, _t29, -(_t11 * _t30)), _t10, objPosY, _t30, Math.fma(_t11, _t31, -(_t10 * _t29)), _t12, objPosZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a spherical billboard transformation that faces the camera.
     * <p>
     * Alias for {@code makeBillboardSpherical}.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public static Float3x4 targetTo(Float3 objPos, Float3 targetPos, Float3 up) {
        return targetTo(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z(), up.x(), up.y(), up.z());
    }


    /**
     * Create a spherical billboard transformation that faces the camera.
     * <p>
     * Alias for {@code makeBillboardSpherical}.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public static Float3x4 targetTo(float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ, float upX, float upY, float upZ) {
        float _t0 = targetPosZ - objPosZ;
        float _t1 = targetPosX - objPosX;
        float _t2 = targetPosY - objPosY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t19 * _t25;
            _t31 = _t21 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        return new Float3x4(_t29, Math.fma(_t10, _t30, -(_t12 * _t31)), _t11, objPosX, _t31, Math.fma(_t12, _t29, -(_t11 * _t30)), _t10, objPosY, _t30, Math.fma(_t11, _t31, -(_t10 * _t29)), _t12, objPosZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a spherical billboard transformation that faces the camera, using the rotation of
     * shortest arc.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardSphericalShortest(Float3 objPos, Float3 targetPos) {
        return makeBillboardSphericalShortest(objPos.x(), objPos.y(), objPos.z(), targetPos.x(), targetPos.y(), targetPos.z());
    }


    /**
     * Create a spherical billboard transformation that faces the camera, using the rotation of
     * shortest arc.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @return the resulting matrix
     */
    public static Float3x4 makeBillboardSphericalShortest(float objPosX, float objPosY, float objPosZ, float targetPosX, float targetPosY, float targetPosZ) {
        float _t0 = targetPosX - objPosX;
        float _t1 = targetPosZ - objPosZ;
        float _t2 = targetPosY - objPosY;
        float _t3 = objPosY - targetPosY;
        float _t10 = _t1 + (float) Math.sqrt(Math.fma(_t1, _t1, Math.fma(_t0, _t0, _t2 * _t2)));
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(_t10, _t10, Math.fma(_t3, _t3, _t0 * _t0))));
        float _t13 = _t0 * _t12;
        float _t14 = _t3 * _t12;
        float _t15 = 2.0f * _t13;
        float _t16 = 2.0f * _t14;
        float _t17 = -_t15;
        float _t19 = _t10 * _t12;
        float _t20 = _t16 * _t13;
        float _t21 = Math.fma(-_t16, _t14, 1.0f);
        float _t22 = _t15 * _t19;
        float _t23 = _t16 * _t19;
        return new Float3x4(Math.fma(_t17, _t13, 1.0f), _t20, _t22, objPosX, _t20, _t21, -_t23, objPosY, -_t22, _t23, Math.fma(_t17, _t13, _t21), objPosZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create the rigid transformation represented by the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return the resulting matrix
     */
    public static Float3x4 makeFromDualQuat(FloatDualQuat dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Create the rigid transformation represented by the unit dual quaternion ({@code dqRX},
     * {@code dqRY}, {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ},
     * {@code dqDW}).
     *
     * @param dqRX the {@code rX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRY the {@code rY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRZ the {@code rZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqRW the {@code rW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)} (the real part must have unit
     *        length)
     * @param dqDX the {@code dX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDY the {@code dY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDZ the {@code dZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDW the {@code dW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @return the resulting matrix
     */
    public static Float3x4 makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float _t0 = dqRY * dqRY;
        float _t2 = dqRZ * dqRW;
        float _t3 = dqRY * dqRW;
        float _t4 = dqRX * dqRX;
        float _t5 = dqRY * dqRZ;
        float _t6 = Math.fma(-2.0f, dqRZ * dqRZ, 1.0f);
        return new Float3x4(Math.fma(-2.0f, _t0, _t6), Math.fma(-2.0f, _t2, 2.0f * dqRX * dqRY), 2.0f * Math.fma(dqRX, dqRZ, _t3), 2.0f * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW))), 2.0f * Math.fma(dqRX, dqRY, _t2), Math.fma(-2.0f, _t4, _t6), Math.fma(-2.0f, dqRX * dqRW, 2.0f * _t5), 2.0f * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW))), Math.fma(-2.0f, _t3, 2.0f * dqRX * dqRZ), 2.0f * Math.fma(dqRX, dqRW, _t5), Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)), 2.0f * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW))), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.LEFT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private static Float3x4 makeLookAt_lh(Float3 eye, Float3 center, Float3 up) {
        return makeLookAt_lh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    /** Private per-column body of {@code makeLookAt_lh}; reached only through it. */
    private static Float3 makeLookAt_lh_s185c1ac6_c0(float _t29, float _t38, float _t11) {
        return new Float3(_t29, _t38, _t11);
    }

    /** Private per-column body of {@code makeLookAt_lh}; reached only through it. */
    private static Float3 makeLookAt_lh_s185c1ac6_c1(float _t30, float _t39, float _t10) {
        return new Float3(_t30, _t39, _t10);
    }

    /** Private per-column body of {@code makeLookAt_lh}; reached only through it. */
    private static Float3 makeLookAt_lh_s185c1ac6_c2(float _t31, float _t40, float _t12) {
        return new Float3(_t31, _t40, _t12);
    }

    /** Private per-column body of {@code makeLookAt_lh}; reached only through it. */
    private static Float3 makeLookAt_lh_s185c1ac6_c3(float eyeZ, float _t31, float eyeX, float _t29, float eyeY, float _t30, float _t40, float _t38, float _t39, float _t12, float _t11, float _t10) {
        return new Float3(-Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)), -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)), -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10)));
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.LEFT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private static Float3x4 makeLookAt_lh(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        return new Float3x4(makeLookAt_lh_s185c1ac6_c0(_t29, _t38, _t11), makeLookAt_lh_s185c1ac6_c1(_t30, _t39, _t10), makeLookAt_lh_s185c1ac6_c2(_t31, _t40, _t12), makeLookAt_lh_s185c1ac6_c3(eyeZ, _t31, eyeX, _t29, eyeY, _t30, _t40, _t38, _t39, _t12, _t11, _t10), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.RIGHT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private static Float3x4 makeLookAt_rh(Float3 eye, Float3 center, Float3 up) {
        return makeLookAt_rh(eye.x(), eye.y(), eye.z(), center.x(), center.y(), center.z(), up.x(), up.y(), up.z());
    }

    /** Private per-column body of {@code makeLookAt_rh}; reached only through it. */
    private static Float3 makeLookAt_rh_s185c1ac6_c0(float _t29, float _t38, float _t10) {
        return new Float3(_t29, _t38, -_t10);
    }

    /** Private per-column body of {@code makeLookAt_rh}; reached only through it. */
    private static Float3 makeLookAt_rh_s185c1ac6_c1(float _t30, float _t39, float _t11) {
        return new Float3(_t30, _t39, -_t11);
    }

    /** Private per-column body of {@code makeLookAt_rh}; reached only through it. */
    private static Float3 makeLookAt_rh_s185c1ac6_c2(float _t31, float _t40, float _t12) {
        return new Float3(_t31, _t40, -_t12);
    }

    /** Private per-column body of {@code makeLookAt_rh}; reached only through it. */
    private static Float3 makeLookAt_rh_s185c1ac6_c3(float eyeZ, float _t31, float eyeX, float _t29, float eyeY, float _t30, float _t40, float _t38, float _t39, float _t12, float _t10, float _t11) {
        return new Float3(-Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30)), -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39)), Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)));
    }


    /**
     * Private body of {@code makeLookAt} for {@code Handedness.RIGHT_HANDED}; reached only through
     * the public {@code makeLookAt} dispatcher.
     */
    private static Float3x4 makeLookAt_rh(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upY, _t10, -(upX * _t11));
        float _t20 = Math.fma(upX, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upY * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        return new Float3x4(makeLookAt_rh_s185c1ac6_c0(_t29, _t38, _t10), makeLookAt_rh_s185c1ac6_c1(_t30, _t39, _t11), makeLookAt_rh_s185c1ac6_c2(_t31, _t40, _t12), makeLookAt_rh_s185c1ac6_c3(eyeZ, _t31, eyeX, _t29, eyeY, _t30, _t40, _t38, _t39, _t12, _t10, _t11), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a "look at" view transformation with the eye at {@code eye} looking at {@code center}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return the resulting matrix
     */
    public static Float3x4 makeLookAt(Float3 eye, Float3 center, Float3 up, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return makeLookAt_lh(eye, center, up); }
            default -> { return makeLookAt_rh(eye, center, up); }
        }
    }


    /**
     * Create a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return the resulting matrix
     */
    public static Float3x4 makeLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return makeLookAt_lh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
            default -> { return makeLookAt_rh(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ); }
        }
    }


    /**
     * Create a "look at" view transformation with the eye at {@code eye} looking at {@code center}.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public static Float3x4 makeLookAt(Float3 eye, Float3 center, Float3 up) { return makeLookAt(eye, center, up, Handedness.RIGHT_HANDED); }


    /**
     * Create a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting matrix
     */
    public static Float3x4 makeLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) { return makeLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED); }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXYZ() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_IDENTITY);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXYnZ() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXZY() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXZnY() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXnYZ() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXnYnZ() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXnZY() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingXnZnY() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYXZ() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYXnZ() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYZX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYZnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYnXZ() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYnXnZ() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYnZX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingYnZnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZXY() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZXnY() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZYX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZYnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZnXY() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZnXnY() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZnYX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingZnYnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXYZ() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXYnZ() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXZY() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXZnY() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXnYZ() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXnYnZ() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXnZY() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnXnZnY() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYXZ() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYXnZ() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYZX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYZnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYnXZ() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYnXnZ() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYnZX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnYnZnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZXY() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZXnY() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZYX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZYnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZnXY() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZnXnY() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZnYX() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)}.
     *
     * @return the resulting matrix
     */
    public static Float3x4 makeMappingnZnYnX() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a reflection transformation about the plane through the origin with the normal
     * {@code normal}.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting matrix
     */
    public static Float3x4 makeReflection(Float3 normal) {
        return makeReflection(normal.x(), normal.y(), normal.z());
    }


    /**
     * Create a reflection transformation about the plane through the origin with the normal
     * ({@code normalX}, {@code normalY}, {@code normalZ}).
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return the resulting matrix
     */
    public static Float3x4 makeReflection(float normalX, float normalY, float normalZ) {
        float _t6 = -(2.0f * normalX * normalY);
        float _t7 = -(2.0f * normalX * normalZ);
        float _t8 = -(2.0f * normalY * normalZ);
        return new Float3x4(Math.fma(-2.0f, normalX * normalX, 1.0f), _t6, _t7, 0.0f, _t6, Math.fma(-2.0f, normalY * normalY, 1.0f), _t8, 0.0f, _t7, _t8, Math.fma(-2.0f, normalZ * normalZ, 1.0f), 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationAxis(float angle, Float3 axis) {
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
    public static Float3x4 makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        return new Float3x4(Math.fma(_t2, axisX * axisX, _t0), Math.fma(_t2, _t3, -(axisZ * _t1)), Math.fma(axisY, _t1, _t2 * _t4), 0.0f, Math.fma(axisZ, _t1, _t2 * _t3), Math.fma(_t2, axisY * axisY, _t0), Math.fma(_t2, _t5, -(axisX * _t1)), 0.0f, Math.fma(_t2, _t4, -(axisY * _t1)), Math.fma(axisX, _t1, _t2 * _t5), Math.fma(_t2, axisZ * axisZ, _t0), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationLookAlong(Float3 dir, Float3 up) {
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
    public static Float3x4 makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new Float3x4(_t26, Math.fma(_t7, _t27, -(_t9 * _t28)), _t8, 0.0f, _t28, Math.fma(_t9, _t26, -(_t8 * _t27)), _t7, 0.0f, _t27, Math.fma(_t8, _t28, -(_t7 * _t26)), _t9, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationQuat(FloatQuat q) {
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
    public static Float3x4 makeRotationQuat(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        return new Float3x4(Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f), 2.0f * Math.fma(qX, qY, -_t1), 2.0f * Math.fma(qX, qZ, _t2), 0.0f, 2.0f * Math.fma(qX, qY, _t1), Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f), 2.0f * Math.fma(qY, qZ, -(qX * qW)), 0.0f, 2.0f * Math.fma(qX, qZ, -_t2), 2.0f * Math.fma(qX, qW, qY * qZ), Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationX(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, _t0, -_t1, 0.0f, 0.0f, _t1, _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        return new Float3x4(_t0 * _t1, -(_t2 * _t0), _t3, 0.0f, Math.fma(_t6, _t1, _t2 * _t5), Math.fma(_t5, _t1, -(_t6 * _t2)), -(_t4 * _t0), 0.0f, Math.fma(_t4, _t2, -(_t7 * _t1)), Math.fma(_t7, _t2, _t4 * _t1), _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationXZY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        return new Float3x4(_t0 * _t1, -_t2, _t3 * _t1, 0.0f, Math.fma(_t6, _t0, _t5 * _t3), _t4 * _t1, Math.fma(_t6, _t3, -(_t5 * _t0)), 0.0f, Math.fma(_t7, _t0, -(_t3 * _t4)), _t5 * _t1, Math.fma(_t7, _t3, _t4 * _t0), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationY(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, 0.0f, _t1, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -_t1, 0.0f, _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        return new Float3x4(Math.fma(_t6, _t2, _t3 * _t4), Math.fma(_t6, _t4, -(_t2 * _t3)), _t1 * _t5, 0.0f, _t2 * _t5, _t5 * _t4, -_t0, 0.0f, Math.fma(_t7, _t2, -(_t1 * _t4)), Math.fma(_t7, _t4, _t1 * _t2), _t5 * _t3, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationYZX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t2, _t3, -(_t6 * _t5)), Math.fma(_t6, _t2, _t3 * _t5), 0.0f, _t4, _t5 * _t1, -(_t2 * _t1), 0.0f, -(_t3 * _t1), Math.fma(_t7, _t5, _t2 * _t0), Math.fma(_t5, _t0, -(_t7 * _t2)), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationZ(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, -_t1, 0.0f, 0.0f, _t1, _t0, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationZXY(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        return new Float3x4(Math.fma(_t0, _t1, -(_t6 * _t4)), -(_t3 * _t5), Math.fma(_t6, _t0, _t4 * _t1), 0.0f, Math.fma(_t7, _t4, _t3 * _t0), _t5 * _t1, Math.fma(_t4, _t3, -(_t7 * _t0)), 0.0f, -(_t4 * _t5), _t2, _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting matrix
     */
    public static Float3x4 makeRotationZYX(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t6, _t3, -(_t4 * _t5)), Math.fma(_t6, _t5, _t3 * _t4), 0.0f, _t4 * _t0, Math.fma(_t7, _t3, _t5 * _t1), Math.fma(_t7, _t5, -(_t3 * _t1)), 0.0f, -_t2, _t3 * _t0, _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Create a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return the resulting matrix
     */
    public static Float3x4 makeScaling(Float3 v) {
        return makeScaling(v.x(), v.y(), v.z());
    }


    /**
     * Create a scaling transformation that scales by ({@code vX}, {@code vY}, {@code vZ}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public static Float3x4 makeScaling(float vX, float vY, float vZ) {
        return new Float3x4(vX, 0.0f, 0.0f, 0.0f, 0.0f, vY, 0.0f, 0.0f, 0.0f, 0.0f, vZ, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return the resulting matrix
     */
    public static Float3x4 makeScaling(float s) {
        return new Float3x4(s, 0.0f, 0.0f, 0.0f, 0.0f, s, 0.0f, 0.0f, 0.0f, 0.0f, s, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Create a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return the resulting matrix
     */
    public static Float3x4 makeTranslation(Float3 v) {
        return makeTranslation(v.x(), v.y(), v.z());
    }


    /**
     * Create a translation transformation that translates by ({@code vX}, {@code vY}, {@code vZ}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the translation offsets {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public static Float3x4 makeTranslation(float vX, float vY, float vZ) {
        return new Float3x4(1.0f, 0.0f, 0.0f, vX, 0.0f, 1.0f, 0.0f, vY, 0.0f, 0.0f, 1.0f, vZ, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Float3x4 mapXYZ_identity() {
        return invert_identity();
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Float3x4 mapXYZ_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Float3x4 mapXYZ_orthogonal() {
        return new Float3x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYZ} dispatcher.
     */
    private Float3x4 mapXYZ_general() {
        return new Float3x4(this.m00, this.m01, this.m02, this.m03, this.m10, this.m11, this.m12, this.m13, this.m20, this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapXYZ_orthogonal();
        return mapXYZ_general();
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Float3x4 mapXYnZ_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Float3x4 mapXYnZ_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXYnZ} dispatcher.
     */
    private Float3x4 mapXYnZ_general() {
        return new Float3x4(this.m00, this.m01, -this.m02, this.m03, this.m10, this.m11, -this.m12, this.m13, this.m20, this.m21, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXYnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXYnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXYnZ_translation();
        return mapXYnZ_general();
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Float3x4 mapXZY_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Float3x4 mapXZY_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZY} dispatcher.
     */
    private Float3x4 mapXZY_general() {
        return new Float3x4(this.m00, this.m02, this.m01, this.m03, this.m10, this.m12, this.m11, this.m13, this.m20, this.m22, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXZY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZY_translation();
        return mapXZY_general();
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Float3x4 mapXZnY_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Float3x4 mapXZnY_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Float3x4 mapXZnY_orthogonal() {
        return new Float3x4(this.m00, this.m02, -this.m01, this.m03, this.m10, this.m12, -this.m11, this.m13, this.m20, this.m22, -this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXZnY} dispatcher.
     */
    private Float3x4 mapXZnY_general() {
        return new Float3x4(this.m00, this.m02, -this.m01, this.m03, this.m10, this.m12, -this.m11, this.m13, this.m20, this.m22, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXZnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXZnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXZnY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapXZnY_orthogonal();
        return mapXZnY_general();
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Float3x4 mapXnYZ_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Float3x4 mapXnYZ_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYZ} dispatcher.
     */
    private Float3x4 mapXnYZ_general() {
        return new Float3x4(this.m00, -this.m01, this.m02, this.m03, this.m10, -this.m11, this.m12, this.m13, this.m20, -this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXnYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYZ_translation();
        return mapXnYZ_general();
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Float3x4 mapXnYnZ_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Float3x4 mapXnYnZ_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Float3x4 mapXnYnZ_orthogonal() {
        return new Float3x4(this.m00, -this.m01, -this.m02, this.m03, this.m10, -this.m11, -this.m12, this.m13, this.m20, -this.m21, -this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnYnZ} dispatcher.
     */
    private Float3x4 mapXnYnZ_general() {
        return new Float3x4(this.m00, -this.m01, -this.m02, this.m03, this.m10, -this.m11, -this.m12, this.m13, this.m20, -this.m21, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXnYnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnYnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnYnZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapXnYnZ_orthogonal();
        return mapXnYnZ_general();
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Float3x4 mapXnZY_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Float3x4 mapXnZY_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Float3x4 mapXnZY_orthogonal() {
        return new Float3x4(this.m00, -this.m02, this.m01, this.m03, this.m10, -this.m12, this.m11, this.m13, this.m20, -this.m22, this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZY} dispatcher.
     */
    private Float3x4 mapXnZY_general() {
        return new Float3x4(this.m00, -this.m02, this.m01, this.m03, this.m10, -this.m12, this.m11, this.m13, this.m20, -this.m22, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXnZY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapXnZY_orthogonal();
        return mapXnZY_general();
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Float3x4 mapXnZnY_identity() {
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Float3x4 mapXnZnY_translation() {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapXnZnY} dispatcher.
     */
    private Float3x4 mapXnZnY_general() {
        return new Float3x4(this.m00, -this.m02, -this.m01, this.m03, this.m10, -this.m12, -this.m11, this.m13, this.m20, -this.m22, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapXnZnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapXnZnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapXnZnY_translation();
        return mapXnZnY_general();
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Float3x4 mapYXZ_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Float3x4 mapYXZ_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXZ} dispatcher.
     */
    private Float3x4 mapYXZ_general() {
        return new Float3x4(this.m01, this.m00, this.m02, this.m03, this.m11, this.m10, this.m12, this.m13, this.m21, this.m20, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXZ_translation();
        return mapYXZ_general();
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Float3x4 mapYXnZ_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Float3x4 mapYXnZ_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Float3x4 mapYXnZ_orthogonal() {
        return new Float3x4(this.m01, this.m00, -this.m02, this.m03, this.m11, this.m10, -this.m12, this.m13, this.m21, this.m20, -this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYXnZ} dispatcher.
     */
    private Float3x4 mapYXnZ_general() {
        return new Float3x4(this.m01, this.m00, -this.m02, this.m03, this.m11, this.m10, -this.m12, this.m13, this.m21, this.m20, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYXnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYXnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYXnZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapYXnZ_orthogonal();
        return mapYXnZ_general();
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Float3x4 mapYZX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Float3x4 mapYZX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Float3x4 mapYZX_orthogonal() {
        return new Float3x4(this.m01, this.m02, this.m00, this.m03, this.m11, this.m12, this.m10, this.m13, this.m21, this.m22, this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZX} dispatcher.
     */
    private Float3x4 mapYZX_general() {
        return new Float3x4(this.m01, this.m02, this.m00, this.m03, this.m11, this.m12, this.m10, this.m13, this.m21, this.m22, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYZX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapYZX_orthogonal();
        return mapYZX_general();
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Float3x4 mapYZnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Float3x4 mapYZnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYZnX} dispatcher.
     */
    private Float3x4 mapYZnX_general() {
        return new Float3x4(this.m01, this.m02, -this.m00, this.m03, this.m11, this.m12, -this.m10, this.m13, this.m21, this.m22, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYZnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYZnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYZnX_translation();
        return mapYZnX_general();
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Float3x4 mapYnXZ_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Float3x4 mapYnXZ_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Float3x4 mapYnXZ_orthogonal() {
        return new Float3x4(this.m01, -this.m00, this.m02, this.m03, this.m11, -this.m10, this.m12, this.m13, this.m21, -this.m20, this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXZ} dispatcher.
     */
    private Float3x4 mapYnXZ_general() {
        return new Float3x4(this.m01, -this.m00, this.m02, this.m03, this.m11, -this.m10, this.m12, this.m13, this.m21, -this.m20, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYnXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapYnXZ_orthogonal();
        return mapYnXZ_general();
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Float3x4 mapYnXnZ_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Float3x4 mapYnXnZ_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnXnZ} dispatcher.
     */
    private Float3x4 mapYnXnZ_general() {
        return new Float3x4(this.m01, -this.m00, -this.m02, this.m03, this.m11, -this.m10, -this.m12, this.m13, this.m21, -this.m20, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYnXnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnXnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnXnZ_translation();
        return mapYnXnZ_general();
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Float3x4 mapYnZX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Float3x4 mapYnZX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZX} dispatcher.
     */
    private Float3x4 mapYnZX_general() {
        return new Float3x4(this.m01, -this.m02, this.m00, this.m03, this.m11, -this.m12, this.m10, this.m13, this.m21, -this.m22, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYnZX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZX_translation();
        return mapYnZX_general();
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Float3x4 mapYnZnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Float3x4 mapYnZnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 1.0f, 0.0f, 0.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Float3x4 mapYnZnX_orthogonal() {
        return new Float3x4(this.m01, -this.m02, -this.m00, this.m03, this.m11, -this.m12, -this.m10, this.m13, this.m21, -this.m22, -this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapYnZnX} dispatcher.
     */
    private Float3x4 mapYnZnX_general() {
        return new Float3x4(this.m01, -this.m02, -this.m00, this.m03, this.m11, -this.m12, -this.m10, this.m13, this.m21, -this.m22, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapYnZnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapYnZnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapYnZnX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapYnZnX_orthogonal();
        return mapYnZnX_general();
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Float3x4 mapZXY_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Float3x4 mapZXY_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Float3x4 mapZXY_orthogonal() {
        return new Float3x4(this.m02, this.m00, this.m01, this.m03, this.m12, this.m10, this.m11, this.m13, this.m22, this.m20, this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXY} dispatcher.
     */
    private Float3x4 mapZXY_general() {
        return new Float3x4(this.m02, this.m00, this.m01, this.m03, this.m12, this.m10, this.m11, this.m13, this.m22, this.m20, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZXY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapZXY_orthogonal();
        return mapZXY_general();
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Float3x4 mapZXnY_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Float3x4 mapZXnY_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZXnY} dispatcher.
     */
    private Float3x4 mapZXnY_general() {
        return new Float3x4(this.m02, this.m00, -this.m01, this.m03, this.m12, this.m10, -this.m11, this.m13, this.m22, this.m20, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZXnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZXnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZXnY_translation();
        return mapZXnY_general();
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Float3x4 mapZYX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Float3x4 mapZYX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYX} dispatcher.
     */
    private Float3x4 mapZYX_general() {
        return new Float3x4(this.m02, this.m01, this.m00, this.m03, this.m12, this.m11, this.m10, this.m13, this.m22, this.m21, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZYX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYX_translation();
        return mapZYX_general();
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Float3x4 mapZYnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Float3x4 mapZYnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Float3x4 mapZYnX_orthogonal() {
        return new Float3x4(this.m02, this.m01, -this.m00, this.m03, this.m12, this.m11, -this.m10, this.m13, this.m22, this.m21, -this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZYnX} dispatcher.
     */
    private Float3x4 mapZYnX_general() {
        return new Float3x4(this.m02, this.m01, -this.m00, this.m03, this.m12, this.m11, -this.m10, this.m13, this.m22, this.m21, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZYnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZYnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZYnX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapZYnX_orthogonal();
        return mapZYnX_general();
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Float3x4 mapZnXY_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Float3x4 mapZnXY_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXY} dispatcher.
     */
    private Float3x4 mapZnXY_general() {
        return new Float3x4(this.m02, -this.m00, this.m01, this.m03, this.m12, -this.m10, this.m11, this.m13, this.m22, -this.m20, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZnXY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXY_translation();
        return mapZnXY_general();
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Float3x4 mapZnXnY_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Float3x4 mapZnXnY_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Float3x4 mapZnXnY_orthogonal() {
        return new Float3x4(this.m02, -this.m00, -this.m01, this.m03, this.m12, -this.m10, -this.m11, this.m13, this.m22, -this.m20, -this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnXnY} dispatcher.
     */
    private Float3x4 mapZnXnY_general() {
        return new Float3x4(this.m02, -this.m00, -this.m01, this.m03, this.m12, -this.m10, -this.m11, this.m13, this.m22, -this.m20, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZnXnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnXnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnXnY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapZnXnY_orthogonal();
        return mapZnXnY_general();
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Float3x4 mapZnYX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Float3x4 mapZnYX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Float3x4 mapZnYX_orthogonal() {
        return new Float3x4(this.m02, -this.m01, this.m00, this.m03, this.m12, -this.m11, this.m10, this.m13, this.m22, -this.m21, this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYX} dispatcher.
     */
    private Float3x4 mapZnYX_general() {
        return new Float3x4(this.m02, -this.m01, this.m00, this.m03, this.m12, -this.m11, this.m10, this.m13, this.m22, -this.m21, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZnYX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapZnYX_orthogonal();
        return mapZnYX_general();
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Float3x4 mapZnYnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Float3x4 mapZnYnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapZnYnX} dispatcher.
     */
    private Float3x4 mapZnYnX_general() {
        return new Float3x4(this.m02, -this.m01, -this.m00, this.m03, this.m12, -this.m11, -this.m10, this.m13, this.m22, -this.m21, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapZnYnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapZnYnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapZnYnX_translation();
        return mapZnYnX_general();
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Float3x4 mapnXYZ_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Float3x4 mapnXYZ_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYZ} dispatcher.
     */
    private Float3x4 mapnXYZ_general() {
        return new Float3x4(-this.m00, this.m01, this.m02, this.m03, -this.m10, this.m11, this.m12, this.m13, -this.m20, this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYZ_translation();
        return mapnXYZ_general();
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Float3x4 mapnXYnZ_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Float3x4 mapnXYnZ_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Float3x4 mapnXYnZ_orthogonal() {
        return new Float3x4(-this.m00, this.m01, -this.m02, this.m03, -this.m10, this.m11, -this.m12, this.m13, -this.m20, this.m21, -this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXYnZ} dispatcher.
     */
    private Float3x4 mapnXYnZ_general() {
        return new Float3x4(-this.m00, this.m01, -this.m02, this.m03, -this.m10, this.m11, -this.m12, this.m13, -this.m20, this.m21, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXYnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXYnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXYnZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnXYnZ_orthogonal();
        return mapnXYnZ_general();
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Float3x4 mapnXZY_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Float3x4 mapnXZY_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Float3x4 mapnXZY_orthogonal() {
        return new Float3x4(-this.m00, this.m02, this.m01, this.m03, -this.m10, this.m12, this.m11, this.m13, -this.m20, this.m22, this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZY} dispatcher.
     */
    private Float3x4 mapnXZY_general() {
        return new Float3x4(-this.m00, this.m02, this.m01, this.m03, -this.m10, this.m12, this.m11, this.m13, -this.m20, this.m22, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXZY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnXZY_orthogonal();
        return mapnXZY_general();
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Float3x4 mapnXZnY_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Float3x4 mapnXZnY_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXZnY} dispatcher.
     */
    private Float3x4 mapnXZnY_general() {
        return new Float3x4(-this.m00, this.m02, -this.m01, this.m03, -this.m10, this.m12, -this.m11, this.m13, -this.m20, this.m22, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXZnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXZnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXZnY_translation();
        return mapnXZnY_general();
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Float3x4 mapnXnYZ_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Float3x4 mapnXnYZ_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Float3x4 mapnXnYZ_orthogonal() {
        return new Float3x4(-this.m00, -this.m01, this.m02, this.m03, -this.m10, -this.m11, this.m12, this.m13, -this.m20, -this.m21, this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYZ} dispatcher.
     */
    private Float3x4 mapnXnYZ_general() {
        return new Float3x4(-this.m00, -this.m01, this.m02, this.m03, -this.m10, -this.m11, this.m12, this.m13, -this.m20, -this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXnYZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnXnYZ_orthogonal();
        return mapnXnYZ_general();
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Float3x4 mapnXnYnZ_identity() {
        return negate_identity();
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Float3x4 mapnXnYnZ_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXnYnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnYnZ} dispatcher.
     */
    private Float3x4 mapnXnYnZ_general() {
        return new Float3x4(-this.m00, -this.m01, -this.m02, this.m03, -this.m10, -this.m11, -this.m12, this.m13, -this.m20, -this.m21, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXnYnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnYnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnYnZ_translation();
        return mapnXnYnZ_general();
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Float3x4 mapnXnZY_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Float3x4 mapnXnZY_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnXnZY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZY} dispatcher.
     */
    private Float3x4 mapnXnZY_general() {
        return new Float3x4(-this.m00, -this.m02, this.m01, this.m03, -this.m10, -this.m12, this.m11, this.m13, -this.m20, -this.m22, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXnZY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZY_translation();
        return mapnXnZY_general();
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Float3x4 mapnXnZnY_identity() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Float3x4 mapnXnZnY_translation() {
        return new Float3x4(-1.0f, 0.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Float3x4 mapnXnZnY_orthogonal() {
        return new Float3x4(-this.m00, -this.m02, -this.m01, this.m03, -this.m10, -this.m12, -this.m11, this.m13, -this.m20, -this.m22, -this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnXnZnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnXnZnY} dispatcher.
     */
    private Float3x4 mapnXnZnY_general() {
        return new Float3x4(-this.m00, -this.m02, -this.m01, this.m03, -this.m10, -this.m12, -this.m11, this.m13, -this.m20, -this.m22, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnXnZnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnXnZnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnXnZnY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnXnZnY_orthogonal();
        return mapnXnZnY_general();
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Float3x4 mapnYXZ_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Float3x4 mapnYXZ_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Float3x4 mapnYXZ_orthogonal() {
        return new Float3x4(-this.m01, this.m00, this.m02, this.m03, -this.m11, this.m10, this.m12, this.m13, -this.m21, this.m20, this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXZ} dispatcher.
     */
    private Float3x4 mapnYXZ_general() {
        return new Float3x4(-this.m01, this.m00, this.m02, this.m03, -this.m11, this.m10, this.m12, this.m13, -this.m21, this.m20, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnYXZ_orthogonal();
        return mapnYXZ_general();
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Float3x4 mapnYXnZ_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Float3x4 mapnYXnZ_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYXnZ} dispatcher.
     */
    private Float3x4 mapnYXnZ_general() {
        return new Float3x4(-this.m01, this.m00, -this.m02, this.m03, -this.m11, this.m10, -this.m12, this.m13, -this.m21, this.m20, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYXnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYXnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYXnZ_translation();
        return mapnYXnZ_general();
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Float3x4 mapnYZX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Float3x4 mapnYZX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZX} dispatcher.
     */
    private Float3x4 mapnYZX_general() {
        return new Float3x4(-this.m01, this.m02, this.m00, this.m03, -this.m11, this.m12, this.m10, this.m13, -this.m21, this.m22, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYZX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZX_translation();
        return mapnYZX_general();
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Float3x4 mapnYZnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Float3x4 mapnYZnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Float3x4 mapnYZnX_orthogonal() {
        return new Float3x4(-this.m01, this.m02, -this.m00, this.m03, -this.m11, this.m12, -this.m10, this.m13, -this.m21, this.m22, -this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYZnX} dispatcher.
     */
    private Float3x4 mapnYZnX_general() {
        return new Float3x4(-this.m01, this.m02, -this.m00, this.m03, -this.m11, this.m12, -this.m10, this.m13, -this.m21, this.m22, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYZnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYZnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYZnX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnYZnX_orthogonal();
        return mapnYZnX_general();
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Float3x4 mapnYnXZ_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Float3x4 mapnYnXZ_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXZ} dispatcher.
     */
    private Float3x4 mapnYnXZ_general() {
        return new Float3x4(-this.m01, -this.m00, this.m02, this.m03, -this.m11, -this.m10, this.m12, this.m13, -this.m21, -this.m20, this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYnXZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXZ_translation();
        return mapnYnXZ_general();
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Float3x4 mapnYnXnZ_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Float3x4 mapnYnXnZ_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, 0.0f, -1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Float3x4 mapnYnXnZ_orthogonal() {
        return new Float3x4(-this.m01, -this.m00, -this.m02, this.m03, -this.m11, -this.m10, -this.m12, this.m13, -this.m21, -this.m20, -this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnXnZ}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnXnZ} dispatcher.
     */
    private Float3x4 mapnYnXnZ_general() {
        return new Float3x4(-this.m01, -this.m00, -this.m02, this.m03, -this.m11, -this.m10, -this.m12, this.m13, -this.m21, -this.m20, -this.m22, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYnXnZ() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnXnZ_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnXnZ_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnYnXnZ_orthogonal();
        return mapnYnXnZ_general();
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Float3x4 mapnYnZX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Float3x4 mapnYnZX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Float3x4 mapnYnZX_orthogonal() {
        return new Float3x4(-this.m01, -this.m02, this.m00, this.m03, -this.m11, -this.m12, this.m10, this.m13, -this.m21, -this.m22, this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnYnZX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZX} dispatcher.
     */
    private Float3x4 mapnYnZX_general() {
        return new Float3x4(-this.m01, -this.m02, this.m00, this.m03, -this.m11, -this.m12, this.m10, this.m13, -this.m21, -this.m22, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYnZX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnYnZX_orthogonal();
        return mapnYnZX_general();
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Float3x4 mapnYnZnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Float3x4 mapnYnZnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, -1.0f, 0.0f, 0.0f, this.m13, 0.0f, -1.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnYnZnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnYnZnX} dispatcher.
     */
    private Float3x4 mapnYnZnX_general() {
        return new Float3x4(-this.m01, -this.m02, -this.m00, this.m03, -this.m11, -this.m12, -this.m10, this.m13, -this.m21, -this.m22, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnYnZnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnYnZnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnYnZnX_translation();
        return mapnYnZnX_general();
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Float3x4 mapnZXY_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Float3x4 mapnZXY_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXY} dispatcher.
     */
    private Float3x4 mapnZXY_general() {
        return new Float3x4(-this.m02, this.m00, this.m01, this.m03, -this.m12, this.m10, this.m11, this.m13, -this.m22, this.m20, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZXY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXY_translation();
        return mapnZXY_general();
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Float3x4 mapnZXnY_identity() {
        return new Float3x4(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Float3x4 mapnZXnY_translation() {
        return new Float3x4(0.0f, 1.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Float3x4 mapnZXnY_orthogonal() {
        return new Float3x4(-this.m02, this.m00, -this.m01, this.m03, -this.m12, this.m10, -this.m11, this.m13, -this.m22, this.m20, -this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZXnY} dispatcher.
     */
    private Float3x4 mapnZXnY_general() {
        return new Float3x4(-this.m02, this.m00, -this.m01, this.m03, -this.m12, this.m10, -this.m11, this.m13, -this.m22, this.m20, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZXnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZXnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZXnY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnZXnY_orthogonal();
        return mapnZXnY_general();
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Float3x4 mapnZYX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Float3x4 mapnZYX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Float3x4 mapnZYX_orthogonal() {
        return new Float3x4(-this.m02, this.m01, this.m00, this.m03, -this.m12, this.m11, this.m10, this.m13, -this.m22, this.m21, this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYX} dispatcher.
     */
    private Float3x4 mapnZYX_general() {
        return new Float3x4(-this.m02, this.m01, this.m00, this.m03, -this.m12, this.m11, this.m10, this.m13, -this.m22, this.m21, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZYX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnZYX_orthogonal();
        return mapnZYX_general();
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Float3x4 mapnZYnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Float3x4 mapnZYnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 0.0f, 1.0f, 0.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZYnX} dispatcher.
     */
    private Float3x4 mapnZYnX_general() {
        return new Float3x4(-this.m02, this.m01, -this.m00, this.m03, -this.m12, this.m11, -this.m10, this.m13, -this.m22, this.m21, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZYnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZYnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZYnX_translation();
        return mapnZYnX_general();
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Float3x4 mapnZnXY_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Float3x4 mapnZnXY_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 0.0f, 0.0f, 1.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Float3x4 mapnZnXY_orthogonal() {
        return new Float3x4(-this.m02, -this.m00, this.m01, this.m03, -this.m12, -this.m10, this.m11, this.m13, -this.m22, -this.m20, this.m21, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnXY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXY} dispatcher.
     */
    private Float3x4 mapnZnXY_general() {
        return new Float3x4(-this.m02, -this.m00, this.m01, this.m03, -this.m12, -this.m10, this.m11, this.m13, -this.m22, -this.m20, this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZnXY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXY_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnZnXY_orthogonal();
        return mapnZnXY_general();
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Float3x4 mapnZnXnY_identity() {
        return new Float3x4(0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Float3x4 mapnZnXnY_translation() {
        return new Float3x4(0.0f, -1.0f, 0.0f, this.m03, 0.0f, 0.0f, -1.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZnXnY}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnXnY} dispatcher.
     */
    private Float3x4 mapnZnXnY_general() {
        return new Float3x4(-this.m02, -this.m00, -this.m01, this.m03, -this.m12, -this.m10, -this.m11, this.m13, -this.m22, -this.m20, -this.m21, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZnXnY() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnXnY_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnXnY_translation();
        return mapnZnXnY_general();
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Float3x4 mapnZnYX_identity() {
        return new Float3x4(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Float3x4 mapnZnYX_translation() {
        return new Float3x4(0.0f, 0.0f, 1.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code mapnZnYX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYX} dispatcher.
     */
    private Float3x4 mapnZnYX_general() {
        return new Float3x4(-this.m02, -this.m01, this.m00, this.m03, -this.m12, -this.m11, this.m10, this.m13, -this.m22, -this.m21, this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZnYX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYX_translation();
        return mapnZnYX_general();
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Float3x4 mapnZnYnX_identity() {
        return new Float3x4(0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Float3x4 mapnZnYnX_translation() {
        return new Float3x4(0.0f, 0.0f, -1.0f, this.m03, 0.0f, -1.0f, 0.0f, this.m13, -1.0f, 0.0f, 0.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Float3x4 mapnZnYnX_orthogonal() {
        return new Float3x4(-this.m02, -this.m01, -this.m00, this.m03, -this.m12, -this.m11, -this.m10, this.m13, -this.m22, -this.m21, -this.m20, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code mapnZnYnX}, specialized by runtime matrix properties; reached only
     * through the public {@code mapnZnYnX} dispatcher.
     */
    private Float3x4 mapnZnYnX_general() {
        return new Float3x4(-this.m02, -this.m01, -this.m00, this.m03, -this.m12, -this.m11, -this.m10, this.m13, -this.m22, -this.m21, -this.m20, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return the resulting matrix
     */
    public Float3x4 mapnZnYnX() {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mapnZnYnX_identity();
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mapnZnYnX_translation();
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mapnZnYnX_orthogonal();
        return mapnZnYnX_general();
    }


    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x4 preRotateAround(FloatQuat rot, Float3 pivot) {
        return preRotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x4 preRotateAround_identity(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotZ * rotZ;
        float _t2 = rotZ * rotW;
        float _t3 = rotY * rotW;
        float _t10 = Math.fma(rotY, rotY, _t1);
        float _t13 = Math.fma(rotX, rotX, _t1);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t2);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t2);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        return new Float3x4(Math.fma(-2.0f, _t10, 1.0f), _t22, _t19, Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t10, -(pivotY * _t22))), _t20, Math.fma(-2.0f, _t13, 1.0f), _t23, Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20))), _t24, _t21, Math.fma(-2.0f, _t15, 1.0f), Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t24))), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateAround_translation}; reached only through it. */
    private Float3 preRotateAround_translation_s373cbb5f_c0(float _t25, float _t20, float _t24) {
        return new Float3(_t25, _t20, _t24);
    }

    /** Private per-column body of {@code preRotateAround_translation}; reached only through it. */
    private Float3 preRotateAround_translation_s373cbb5f_c1(float _t22, float _t26, float _t21) {
        return new Float3(_t22, _t26, _t21);
    }

    /** Private per-column body of {@code preRotateAround_translation}; reached only through it. */
    private Float3 preRotateAround_translation_s373cbb5f_c2(float _t19, float _t23, float _t27) {
        return new Float3(_t19, _t23, _t27);
    }

    /** Private per-column body of {@code preRotateAround_translation}; reached only through it. */
    private Float3 preRotateAround_translation_s373cbb5f_c3(float _t19, float _t25, float _t22, float _t0, float pivotX, float _t10, float pivotY, float _t23, float _t20, float _t26, float _t13, float _t27, float _t24, float _t21, float pivotZ, float _t15) {
        return new Float3(Math.fma(this.m23, _t19, Math.fma(this.m03, _t25, this.m13 * _t22)) + Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t10, -(pivotY * _t22))), Math.fma(this.m23, _t23, Math.fma(this.m03, _t20, this.m13 * _t26)) + Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20))), Math.fma(this.m23, _t27, Math.fma(this.m03, _t24, this.m13 * _t21)) + Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t24))));
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x4 preRotateAround_translation(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotZ * rotZ;
        float _t2 = rotZ * rotW;
        float _t3 = rotY * rotW;
        float _t10 = Math.fma(rotY, rotY, _t1);
        float _t13 = Math.fma(rotX, rotX, _t1);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t2);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t2);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        float _t25 = Math.fma(-2.0f, _t10, 1.0f);
        float _t26 = Math.fma(-2.0f, _t13, 1.0f);
        float _t27 = Math.fma(-2.0f, _t15, 1.0f);
        return new Float3x4(preRotateAround_translation_s373cbb5f_c0(_t25, _t20, _t24), preRotateAround_translation_s373cbb5f_c1(_t22, _t26, _t21), preRotateAround_translation_s373cbb5f_c2(_t19, _t23, _t27), preRotateAround_translation_s373cbb5f_c3(_t19, _t25, _t22, _t0, pivotX, _t10, pivotY, _t23, _t20, _t26, _t13, _t27, _t24, _t21, pivotZ, _t15), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateAround_orthogonal}; reached only through it. */
    private Float3 preRotateAround_orthogonal_s373cbb5f_c0(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m20, _t19, Math.fma(this.m00, _t25, this.m10 * _t22)), Math.fma(this.m20, _t23, Math.fma(this.m00, _t20, this.m10 * _t26)), Math.fma(this.m20, _t27, Math.fma(this.m00, _t24, this.m10 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_orthogonal}; reached only through it. */
    private Float3 preRotateAround_orthogonal_s373cbb5f_c1(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m21, _t19, Math.fma(this.m01, _t25, this.m11 * _t22)), Math.fma(this.m21, _t23, Math.fma(this.m01, _t20, this.m11 * _t26)), Math.fma(this.m21, _t27, Math.fma(this.m01, _t24, this.m11 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_orthogonal}; reached only through it. */
    private Float3 preRotateAround_orthogonal_s373cbb5f_c2(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m22, _t19, Math.fma(this.m02, _t25, this.m12 * _t22)), Math.fma(this.m22, _t23, Math.fma(this.m02, _t20, this.m12 * _t26)), Math.fma(this.m22, _t27, Math.fma(this.m02, _t24, this.m12 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_orthogonal}; reached only through it. */
    private Float3 preRotateAround_orthogonal_s373cbb5f_c3(float _t19, float _t25, float _t22, float _t0, float pivotX, float _t11, float pivotY, float _t23, float _t20, float _t26, float _t13, float _t27, float _t24, float _t21, float pivotZ, float _t14) {
        return new Float3(Math.fma(this.m23, _t19, Math.fma(this.m03, _t25, this.m13 * _t22)) + Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t22))), Math.fma(this.m23, _t23, Math.fma(this.m03, _t20, this.m13 * _t26)) + Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20))), Math.fma(this.m23, _t27, Math.fma(this.m03, _t24, this.m13 * _t21)) + Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t14, -(pivotX * _t24))));
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x4 preRotateAround_orthogonal(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotY * rotW;
        float _t2 = rotZ * rotZ;
        float _t3 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t2);
        float _t13 = Math.fma(rotX, rotX, _t2);
        float _t14 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t1);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t3);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t3);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t1);
        float _t25 = Math.fma(-2.0f, _t11, 1.0f);
        float _t26 = Math.fma(-2.0f, _t13, 1.0f);
        float _t27 = Math.fma(-2.0f, _t14, 1.0f);
        return new Float3x4(preRotateAround_orthogonal_s373cbb5f_c0(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_orthogonal_s373cbb5f_c1(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_orthogonal_s373cbb5f_c2(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_orthogonal_s373cbb5f_c3(_t19, _t25, _t22, _t0, pivotX, _t11, pivotY, _t23, _t20, _t26, _t13, _t27, _t24, _t21, pivotZ, _t14), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateAround_general}; reached only through it. */
    private Float3 preRotateAround_general_s373cbb5f_c0(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m20, _t19, Math.fma(this.m00, _t25, this.m10 * _t22)), Math.fma(this.m20, _t23, Math.fma(this.m00, _t20, this.m10 * _t26)), Math.fma(this.m20, _t27, Math.fma(this.m00, _t24, this.m10 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_general}; reached only through it. */
    private Float3 preRotateAround_general_s373cbb5f_c1(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m21, _t19, Math.fma(this.m01, _t25, this.m11 * _t22)), Math.fma(this.m21, _t23, Math.fma(this.m01, _t20, this.m11 * _t26)), Math.fma(this.m21, _t27, Math.fma(this.m01, _t24, this.m11 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_general}; reached only through it. */
    private Float3 preRotateAround_general_s373cbb5f_c2(float _t19, float _t25, float _t22, float _t23, float _t20, float _t26, float _t27, float _t24, float _t21) {
        return new Float3(Math.fma(this.m22, _t19, Math.fma(this.m02, _t25, this.m12 * _t22)), Math.fma(this.m22, _t23, Math.fma(this.m02, _t20, this.m12 * _t26)), Math.fma(this.m22, _t27, Math.fma(this.m02, _t24, this.m12 * _t21)));
    }

    /** Private per-column body of {@code preRotateAround_general}; reached only through it. */
    private Float3 preRotateAround_general_s373cbb5f_c3(float _t19, float _t25, float _t22, float _t0, float pivotX, float _t11, float pivotY, float _t23, float _t20, float _t26, float _t13, float _t27, float _t24, float _t21, float pivotZ, float _t14) {
        return new Float3(Math.fma(this.m23, _t19, Math.fma(this.m03, _t25, this.m13 * _t22)) + Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t22))), Math.fma(this.m23, _t23, Math.fma(this.m03, _t20, this.m13 * _t26)) + Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20))), Math.fma(this.m23, _t27, Math.fma(this.m03, _t24, this.m13 * _t21)) + Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t14, -(pivotX * _t24))));
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Float3x4 preRotateAround_general(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotY * rotW;
        float _t2 = rotZ * rotZ;
        float _t3 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t2);
        float _t13 = Math.fma(rotX, rotX, _t2);
        float _t14 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t1);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t3);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t3);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t1);
        float _t25 = Math.fma(-2.0f, _t11, 1.0f);
        float _t26 = Math.fma(-2.0f, _t13, 1.0f);
        float _t27 = Math.fma(-2.0f, _t14, 1.0f);
        return new Float3x4(preRotateAround_general_s373cbb5f_c0(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_general_s373cbb5f_c1(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_general_s373cbb5f_c2(_t19, _t25, _t22, _t23, _t20, _t26, _t27, _t24, _t21), preRotateAround_general_s373cbb5f_c3(_t19, _t25, _t22, _t0, pivotX, _t11, pivotY, _t23, _t20, _t26, _t13, _t27, _t24, _t21, pivotZ, _t14), Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 preRotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return preRotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
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
    public Float3x4 preRotateAxis(float angle, Float3 axis) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x4 preRotateAxis_identity(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        return new Float3x4(Math.fma(_t2, axisX * axisX, _t0), Math.fma(_t2, _t3, -(axisZ * _t1)), Math.fma(axisY, _t1, _t2 * _t4), 0.0f, Math.fma(axisZ, _t1, _t2 * _t3), Math.fma(_t2, axisY * axisY, _t0), Math.fma(_t2, _t5, -(axisX * _t1)), 0.0f, Math.fma(_t2, _t4, -(axisY * _t1)), Math.fma(axisX, _t1, _t2 * _t5), Math.fma(_t2, axisZ * axisZ, _t0), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x4 preRotateAxis_translation(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t4 = axisX * axisY;
        float _t6 = axisX * axisZ;
        float _t8 = axisY * axisZ;
        float _t18 = Math.fma(_t2, axisX * axisX, _t0);
        float _t19 = Math.fma(_t2, axisY * axisY, _t0);
        float _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        float _t21 = Math.fma(axisY, _t1, _t2 * _t6);
        float _t22 = Math.fma(axisZ, _t1, _t2 * _t4);
        float _t23 = Math.fma(axisX, _t1, _t2 * _t8);
        float _t24 = Math.fma(_t2, _t4, -(axisZ * _t1));
        float _t25 = Math.fma(_t2, _t8, -(axisX * _t1));
        float _t26 = Math.fma(_t2, _t6, -(axisY * _t1));
        return new Float3x4(_t18, _t24, _t21, Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24)), _t22, _t19, _t25, Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19)), _t26, _t23, _t20, Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23)), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c0(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m20, _t21, Math.fma(this.m00, _t18, this.m10 * _t24)), Math.fma(this.m20, _t25, Math.fma(this.m00, _t22, this.m10 * _t19)), Math.fma(this.m20, _t20, Math.fma(this.m00, _t26, this.m10 * _t23)));
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c1(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m21, _t21, Math.fma(this.m01, _t18, this.m11 * _t24)), Math.fma(this.m21, _t25, Math.fma(this.m01, _t22, this.m11 * _t19)), Math.fma(this.m21, _t20, Math.fma(this.m01, _t26, this.m11 * _t23)));
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c2(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m22, _t21, Math.fma(this.m02, _t18, this.m12 * _t24)), Math.fma(this.m22, _t25, Math.fma(this.m02, _t22, this.m12 * _t19)), Math.fma(this.m22, _t20, Math.fma(this.m02, _t26, this.m12 * _t23)));
    }

    /** Private per-column body of {@code preRotateAxis_orthogonal}; reached only through it. */
    private Float3 preRotateAxis_orthogonal_s3b957671_c3(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24)), Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19)), Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23)));
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x4 preRotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ) {
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
        return new Float3x4(preRotateAxis_orthogonal_s3b957671_c0(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_orthogonal_s3b957671_c1(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_orthogonal_s3b957671_c2(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_orthogonal_s3b957671_c3(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code preRotateAxis_general}; reached only through it. */
    private Float3 preRotateAxis_general_s3b957671_c3(float _t21, float _t18, float _t24, float _t25, float _t22, float _t19, float _t20, float _t26, float _t23) {
        return new Float3(Math.fma(this.m23, _t21, Math.fma(this.m03, _t18, this.m13 * _t24)), Math.fma(this.m23, _t25, Math.fma(this.m03, _t22, this.m13 * _t19)), Math.fma(this.m23, _t20, Math.fma(this.m03, _t26, this.m13 * _t23)));
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Float3x4 preRotateAxis_general(float angle, float axisX, float axisY, float axisZ) {
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
        return new Float3x4(preRotateAxis_general_s3b957671_c0(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_general_s3b957671_c1(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_general_s3b957671_c2(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), preRotateAxis_general_s3b957671_c3(_t21, _t18, _t24, _t25, _t22, _t19, _t20, _t26, _t23), Joml.BIT_AFFINE);
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
    public Float3x4 preRotateAxis(float angle, float axisX, float axisY, float axisZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ);
        return preRotateAxis_general(angle, axisX, axisY, axisZ);
    }


    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return the resulting matrix
     */
    public Float3x4 preRotateQuat(FloatQuat q) {
        return preRotateQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Float3x4 preRotateQuat_identity(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        return new Float3x4(Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f), 2.0f * Math.fma(qX, qY, -_t1), 2.0f * Math.fma(qX, qZ, _t2), 0.0f, 2.0f * Math.fma(qX, qY, _t1), Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f), 2.0f * Math.fma(qY, qZ, -(qX * qW)), 0.0f, 2.0f * Math.fma(qX, qZ, -_t2), 2.0f * Math.fma(qX, qW, qY * qZ), Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Float3x4 preRotateQuat_translation(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        float _t18 = 2.0f * Math.fma(qX, qZ, _t2);
        float _t19 = 2.0f * Math.fma(qX, qY, _t1);
        float _t20 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t21 = 2.0f * Math.fma(qX, qY, -_t1);
        float _t22 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t23 = 2.0f * Math.fma(qX, qZ, -_t2);
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        return new Float3x4(_t24, _t21, _t18, Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21)), _t19, _t25, _t22, Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25)), _t23, _t20, _t26, Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20)), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateQuat_orthogonal}; reached only through it. */
    private Float3 preRotateQuat_orthogonal_s4eb09b0a_c0(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m20, _t18, Math.fma(this.m00, _t24, this.m10 * _t21)), Math.fma(this.m20, _t22, Math.fma(this.m00, _t19, this.m10 * _t25)), Math.fma(this.m20, _t26, Math.fma(this.m00, _t23, this.m10 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_orthogonal}; reached only through it. */
    private Float3 preRotateQuat_orthogonal_s4eb09b0a_c1(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m21, _t18, Math.fma(this.m01, _t24, this.m11 * _t21)), Math.fma(this.m21, _t22, Math.fma(this.m01, _t19, this.m11 * _t25)), Math.fma(this.m21, _t26, Math.fma(this.m01, _t23, this.m11 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_orthogonal}; reached only through it. */
    private Float3 preRotateQuat_orthogonal_s4eb09b0a_c2(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m22, _t18, Math.fma(this.m02, _t24, this.m12 * _t21)), Math.fma(this.m22, _t22, Math.fma(this.m02, _t19, this.m12 * _t25)), Math.fma(this.m22, _t26, Math.fma(this.m02, _t23, this.m12 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_orthogonal}; reached only through it. */
    private Float3 preRotateQuat_orthogonal_s4eb09b0a_c3(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21)), Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25)), Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20)));
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Float3x4 preRotateQuat_orthogonal(float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t19 = 2.0f * Math.fma(qX, qY, _t2);
        float _t20 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t21 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t22 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t23 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        return new Float3x4(preRotateQuat_orthogonal_s4eb09b0a_c0(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_orthogonal_s4eb09b0a_c1(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_orthogonal_s4eb09b0a_c2(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_orthogonal_s4eb09b0a_c3(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code preRotateQuat_general}; reached only through it. */
    private Float3 preRotateQuat_general_s4eb09b0a_c0(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m20, _t18, Math.fma(this.m00, _t24, this.m10 * _t21)), Math.fma(this.m20, _t22, Math.fma(this.m00, _t19, this.m10 * _t25)), Math.fma(this.m20, _t26, Math.fma(this.m00, _t23, this.m10 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_general}; reached only through it. */
    private Float3 preRotateQuat_general_s4eb09b0a_c1(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m21, _t18, Math.fma(this.m01, _t24, this.m11 * _t21)), Math.fma(this.m21, _t22, Math.fma(this.m01, _t19, this.m11 * _t25)), Math.fma(this.m21, _t26, Math.fma(this.m01, _t23, this.m11 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_general}; reached only through it. */
    private Float3 preRotateQuat_general_s4eb09b0a_c2(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m22, _t18, Math.fma(this.m02, _t24, this.m12 * _t21)), Math.fma(this.m22, _t22, Math.fma(this.m02, _t19, this.m12 * _t25)), Math.fma(this.m22, _t26, Math.fma(this.m02, _t23, this.m12 * _t20)));
    }

    /** Private per-column body of {@code preRotateQuat_general}; reached only through it. */
    private Float3 preRotateQuat_general_s4eb09b0a_c3(float _t18, float _t24, float _t21, float _t22, float _t19, float _t25, float _t26, float _t23, float _t20) {
        return new Float3(Math.fma(this.m23, _t18, Math.fma(this.m03, _t24, this.m13 * _t21)), Math.fma(this.m23, _t22, Math.fma(this.m03, _t19, this.m13 * _t25)), Math.fma(this.m23, _t26, Math.fma(this.m03, _t23, this.m13 * _t20)));
    }


    /**
     * Private body of {@code preRotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateQuat} dispatcher.
     */
    private Float3x4 preRotateQuat_general(float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t19 = 2.0f * Math.fma(qX, qY, _t2);
        float _t20 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t21 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t22 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t23 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        return new Float3x4(preRotateQuat_general_s4eb09b0a_c0(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_general_s4eb09b0a_c1(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_general_s4eb09b0a_c2(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), preRotateQuat_general_s4eb09b0a_c3(_t18, _t24, _t21, _t22, _t19, _t25, _t26, _t23, _t20), Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
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
    public Float3x4 preRotateQuat(float qX, float qY, float qZ, float qW) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateQuat_identity(qX, qY, qZ, qW);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateQuat_translation(qX, qY, qZ, qW);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateQuat_orthogonal(qX, qY, qZ, qW);
        return preRotateQuat_general(qX, qY, qZ, qW);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x4 preRotateX_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, _t0, -_t1, 0.0f, 0.0f, _t1, _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x4 preRotateX_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, _t0, -_t1, Math.fma(this.m13, _t0, -(this.m23 * _t1)), 0.0f, _t1, _t0, Math.fma(this.m13, _t1, this.m23 * _t0), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x4 preRotateX_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(this.m00, this.m01, this.m02, this.m03, Math.fma(this.m10, _t0, -(this.m20 * _t1)), Math.fma(this.m11, _t0, -(this.m21 * _t1)), Math.fma(this.m12, _t0, -(this.m22 * _t1)), Math.fma(this.m13, _t0, -(this.m23 * _t1)), Math.fma(this.m10, _t1, this.m20 * _t0), Math.fma(this.m11, _t1, this.m21 * _t0), Math.fma(this.m12, _t1, this.m22 * _t0), Math.fma(this.m13, _t1, this.m23 * _t0), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Float3x4 preRotateX_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(this.m00, this.m01, this.m02, this.m03, Math.fma(this.m10, _t0, -(this.m20 * _t1)), Math.fma(this.m11, _t0, -(this.m21 * _t1)), Math.fma(this.m12, _t0, -(this.m22 * _t1)), Math.fma(this.m13, _t0, -(this.m23 * _t1)), Math.fma(this.m10, _t1, this.m20 * _t0), Math.fma(this.m11, _t1, this.m21 * _t0), Math.fma(this.m12, _t1, this.m22 * _t0), Math.fma(this.m13, _t1, this.m23 * _t0), Joml.BIT_AFFINE);
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
    public Float3x4 preRotateX(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateX_orthogonal(angle);
        return preRotateX_general(angle);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x4 preRotateY_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, 0.0f, _t1, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -_t1, 0.0f, _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x4 preRotateY_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, 0.0f, _t1, Math.fma(this.m03, _t0, this.m23 * _t1), 0.0f, 1.0f, 0.0f, this.m13, -_t1, 0.0f, _t0, Math.fma(this.m23, _t0, -(this.m03 * _t1)), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x4 preRotateY_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, this.m20 * _t1), Math.fma(this.m01, _t0, this.m21 * _t1), Math.fma(this.m02, _t0, this.m22 * _t1), Math.fma(this.m03, _t0, this.m23 * _t1), this.m10, this.m11, this.m12, this.m13, Math.fma(this.m20, _t0, -(this.m00 * _t1)), Math.fma(this.m21, _t0, -(this.m01 * _t1)), Math.fma(this.m22, _t0, -(this.m02 * _t1)), Math.fma(this.m23, _t0, -(this.m03 * _t1)), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Float3x4 preRotateY_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, this.m20 * _t1), Math.fma(this.m01, _t0, this.m21 * _t1), Math.fma(this.m02, _t0, this.m22 * _t1), Math.fma(this.m03, _t0, this.m23 * _t1), this.m10, this.m11, this.m12, this.m13, Math.fma(this.m20, _t0, -(this.m00 * _t1)), Math.fma(this.m21, _t0, -(this.m01 * _t1)), Math.fma(this.m22, _t0, -(this.m02 * _t1)), Math.fma(this.m23, _t0, -(this.m03 * _t1)), Joml.BIT_AFFINE);
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
    public Float3x4 preRotateY(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle);
        return preRotateY_general(angle);
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Float3x4 preRotateZ_identity(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, -_t1, 0.0f, 0.0f, _t1, _t0, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Float3x4 preRotateZ_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, -_t1, 0.0f, Math.fma(this.m03, _t0, -(this.m13 * _t1)), _t1, _t0, 0.0f, Math.fma(this.m03, _t1, this.m13 * _t0), 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Float3x4 preRotateZ_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(this.m02, _t0, -(this.m12 * _t1)), Math.fma(this.m03, _t0, -(this.m13 * _t1)), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(this.m02, _t1, this.m12 * _t0), Math.fma(this.m03, _t1, this.m13 * _t0), this.m20, this.m21, this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preRotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateZ} dispatcher.
     */
    private Float3x4 preRotateZ_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, -(this.m10 * _t1)), Math.fma(this.m01, _t0, -(this.m11 * _t1)), Math.fma(this.m02, _t0, -(this.m12 * _t1)), Math.fma(this.m03, _t0, -(this.m13 * _t1)), Math.fma(this.m00, _t1, this.m10 * _t0), Math.fma(this.m01, _t1, this.m11 * _t0), Math.fma(this.m02, _t1, this.m12 * _t0), Math.fma(this.m03, _t1, this.m13 * _t0), this.m20, this.m21, this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 preRotateZ(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateZ_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateZ_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateZ_orthogonal(angle);
        return preRotateZ_general(angle);
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
    public Float3x4 preScale(Float3 v) {
        return preScale(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_identity(float vX, float vY, float vZ) {
        return new Float3x4(vX, 0.0f, 0.0f, 0.0f, 0.0f, vY, 0.0f, 0.0f, 0.0f, 0.0f, vZ, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_translation(float vX, float vY, float vZ) {
        return new Float3x4(vX, 0.0f, 0.0f, this.m03 * vX, 0.0f, vY, 0.0f, this.m13 * vY, 0.0f, 0.0f, vZ, this.m23 * vZ, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_general(float vX, float vY, float vZ) {
        return new Float3x4(this.m00 * vX, this.m01 * vX, this.m02 * vX, this.m03 * vX, this.m10 * vY, this.m11 * vY, this.m12 * vY, this.m13 * vY, this.m20 * vZ, this.m21 * vZ, this.m22 * vZ, this.m23 * vZ, Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public Float3x4 preScale(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY, vZ);
        return preScale_general(vX, vY, vZ);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_identity(float s) {
        return new Float3x4(s, 0.0f, 0.0f, 0.0f, 0.0f, s, 0.0f, 0.0f, 0.0f, 0.0f, s, 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_translation(float s) {
        return new Float3x4(s, 0.0f, 0.0f, s * this.m03, 0.0f, s, 0.0f, s * this.m13, 0.0f, 0.0f, s, s * this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Float3x4 preScale_general(float s) {
        return new Float3x4(s * this.m00, s * this.m01, s * this.m02, s * this.m03, s * this.m10, s * this.m11, s * this.m12, s * this.m13, s * this.m20, s * this.m21, s * this.m22, s * this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 preScale(float s) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(s);
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
    public Float3x4 preScaleAround(float s, Float3 pivot) {
        return preScaleAround(s, pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_identity(float s, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(s, 0.0f, 0.0f, Math.fma(-s, pivotX, pivotX), 0.0f, s, 0.0f, Math.fma(-s, pivotY, pivotY), 0.0f, 0.0f, s, Math.fma(-s, pivotZ, pivotZ), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_translation(float s, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(s, 0.0f, 0.0f, Math.fma(-s, pivotX, Math.fma(s, this.m03, pivotX)), 0.0f, s, 0.0f, Math.fma(-s, pivotY, Math.fma(s, this.m13, pivotY)), 0.0f, 0.0f, s, Math.fma(-s, pivotZ, Math.fma(s, this.m23, pivotZ)), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_general(float s, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(s * this.m00, s * this.m01, s * this.m02, Math.fma(-s, pivotX, Math.fma(s, this.m03, pivotX)), s * this.m10, s * this.m11, s * this.m12, Math.fma(-s, pivotY, Math.fma(s, this.m13, pivotY)), s * this.m20, s * this.m21, s * this.m22, Math.fma(-s, pivotZ, Math.fma(s, this.m23, pivotZ)), Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) onto this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 preScaleAround(float s, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY, pivotZ);
        return preScaleAround_general(s, pivotX, pivotY, pivotZ);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x4 preScaleAround(Float3 s, Float3 pivot) {
        return preScaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_identity(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(sX, 0.0f, 0.0f, Math.fma(-pivotX, sX, pivotX), 0.0f, sY, 0.0f, Math.fma(-pivotY, sY, pivotY), 0.0f, 0.0f, sZ, Math.fma(-pivotZ, sZ, pivotZ), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_translation(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(sX, 0.0f, 0.0f, Math.fma(-pivotX, sX, Math.fma(sX, this.m03, pivotX)), 0.0f, sY, 0.0f, Math.fma(-pivotY, sY, Math.fma(sY, this.m13, pivotY)), 0.0f, 0.0f, sZ, Math.fma(-pivotZ, sZ, Math.fma(sZ, this.m23, pivotZ)), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Float3x4 preScaleAround_general(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(sX * this.m00, sX * this.m01, sX * this.m02, Math.fma(-pivotX, sX, Math.fma(sX, this.m03, pivotX)), sY * this.m10, sY * this.m11, sY * this.m12, Math.fma(-pivotY, sY, Math.fma(sY, this.m13, pivotY)), sZ * this.m20, sZ * this.m21, sZ * this.m22, Math.fma(-pivotZ, sZ, Math.fma(sZ, this.m23, pivotZ)), Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 preScaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(sX, sY, sZ, pivotX, pivotY, pivotZ);
        return preScaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ);
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
    public Float3x4 preTranslate(Float3 v) {
        return preTranslate(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x4 preTranslate_identity(float vX, float vY, float vZ) {
        return new Float3x4(1.0f, 0.0f, 0.0f, vX, 0.0f, 1.0f, 0.0f, vY, 0.0f, 0.0f, 1.0f, vZ, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x4 preTranslate_translation(float vX, float vY, float vZ) {
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03 + vX, 0.0f, 1.0f, 0.0f, this.m13 + vY, 0.0f, 0.0f, 1.0f, this.m23 + vZ, Joml.BIT_TRANSLATION);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x4 preTranslate_orthogonal(float vX, float vY, float vZ) {
        return new Float3x4(this.m00, this.m01, this.m02, this.m03 + vX, this.m10, this.m11, this.m12, this.m13 + vY, this.m20, this.m21, this.m22, this.m23 + vZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Float3x4 preTranslate_general(float vX, float vY, float vZ) {
        return new Float3x4(this.m00, this.m01, this.m02, this.m03 + vX, this.m10, this.m11, this.m12, this.m13 + vY, this.m20, this.m21, this.m22, this.m23 + vZ, Joml.BIT_AFFINE);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}, {@code vZ}) onto this matrix,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public Float3x4 preTranslate(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY, vZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preTranslate_orthogonal(vX, vY, vZ);
        return preTranslate_general(vX, vY, vZ);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting matrix
     */
    public Float3x4 reflect(Float3 normal) {
        return reflect(normal.x(), normal.y(), normal.z());
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Float3x4 reflect_identity(float normalX, float normalY, float normalZ) {
        float _t6 = -(2.0f * normalX * normalY);
        float _t7 = -(2.0f * normalX * normalZ);
        float _t8 = -(2.0f * normalY * normalZ);
        return new Float3x4(Math.fma(-2.0f, normalX * normalX, 1.0f), _t6, _t7, 0.0f, _t6, Math.fma(-2.0f, normalY * normalY, 1.0f), _t8, 0.0f, _t7, _t8, Math.fma(-2.0f, normalZ * normalZ, 1.0f), 0.0f, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Float3x4 reflect_translation(float normalX, float normalY, float normalZ) {
        float _t6 = -(2.0f * normalX * normalY);
        float _t7 = -(2.0f * normalX * normalZ);
        float _t8 = -(2.0f * normalY * normalZ);
        return new Float3x4(Math.fma(-2.0f, normalX * normalX, 1.0f), _t6, _t7, this.m03, _t6, Math.fma(-2.0f, normalY * normalY, 1.0f), _t8, this.m13, _t7, _t8, Math.fma(-2.0f, normalZ * normalZ, 1.0f), this.m23, Joml.BIT_AFFINE);
    }

    /** Private per-column body of {@code reflect_orthogonal}; reached only through it. */
    private Float3 reflect_orthogonal_s1c31a68e_c0(float _t0, float _t9, float _t12, float _t10, float _t1, float _t2) {
        return new Float3(Math.fma(_t0, _t9, Math.fma(this.m00, _t12, -(this.m01 * _t10))), Math.fma(_t1, _t9, Math.fma(this.m10, _t12, -(this.m11 * _t10))), Math.fma(_t2, _t9, Math.fma(this.m20, _t12, -(this.m21 * _t10))));
    }

    /** Private per-column body of {@code reflect_orthogonal}; reached only through it. */
    private Float3 reflect_orthogonal_s1c31a68e_c1(float _t0, float _t11, float _t13, float _t10, float _t1, float _t2) {
        return new Float3(Math.fma(_t0, _t11, Math.fma(this.m01, _t13, -(this.m00 * _t10))), Math.fma(_t1, _t11, Math.fma(this.m11, _t13, -(this.m10 * _t10))), Math.fma(_t2, _t11, Math.fma(this.m21, _t13, -(this.m20 * _t10))));
    }

    /** Private per-column body of {@code reflect_orthogonal}; reached only through it. */
    private Float3 reflect_orthogonal_s1c31a68e_c2(float _t14, float _t11, float _t9) {
        return new Float3(Math.fma(this.m02, _t14, Math.fma(-this.m01, _t11, -(this.m00 * _t9))), Math.fma(this.m12, _t14, Math.fma(-this.m11, _t11, -(this.m10 * _t9))), Math.fma(this.m22, _t14, Math.fma(-this.m21, _t11, -(this.m20 * _t9))));
    }

    /** Private per-column body of {@code reflect_orthogonal}; reached only through it. */
    private Float3 reflect_orthogonal_s1c31a68e_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Float3x4 reflect_orthogonal(float normalX, float normalY, float normalZ) {
        float _t0 = -this.m02;
        float _t1 = -this.m12;
        float _t2 = -this.m22;
        float _t9 = 2.0f * normalX * normalZ;
        float _t10 = 2.0f * normalX * normalY;
        float _t11 = 2.0f * normalY * normalZ;
        float _t12 = Math.fma(-2.0f, normalX * normalX, 1.0f);
        float _t13 = Math.fma(-2.0f, normalY * normalY, 1.0f);
        float _t14 = Math.fma(-2.0f, normalZ * normalZ, 1.0f);
        return new Float3x4(reflect_orthogonal_s1c31a68e_c0(_t0, _t9, _t12, _t10, _t1, _t2), reflect_orthogonal_s1c31a68e_c1(_t0, _t11, _t13, _t10, _t1, _t2), reflect_orthogonal_s1c31a68e_c2(_t14, _t11, _t9), reflect_orthogonal_s1c31a68e_c3(), Joml.BIT_AFFINE);
    }



    /**
     * Private body of {@code reflect}, specialized by runtime matrix properties; reached only
     * through the public {@code reflect} dispatcher.
     */
    private Float3x4 reflect_general(float normalX, float normalY, float normalZ) {
        return reflect_orthogonal(normalX, normalY, normalZ);
    }


    /**
     * Apply a reflection about the plane through the origin with the normal ({@code normalX},
     * {@code normalY}, {@code normalZ}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return the resulting matrix
     */
    public Float3x4 reflect(float normalX, float normalY, float normalZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return reflect_identity(normalX, normalY, normalZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return reflect_translation(normalX, normalY, normalZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return reflect_orthogonal(normalX, normalY, normalZ);
        return reflect_general(normalX, normalY, normalZ);
    }


    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x4 rotateAround(FloatQuat rot, Float3 pivot) {
        return rotateAround(rot.x(), rot.y(), rot.z(), rot.w(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x4 rotateAround_identity(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        return preRotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x4 rotateAround_translation(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotY;
        float _t1 = -pivotZ;
        float _t2 = -pivotX;
        float _t3 = rotZ * rotZ;
        float _t4 = rotZ * rotW;
        float _t5 = rotY * rotW;
        float _t12 = Math.fma(rotY, rotY, _t3);
        float _t15 = Math.fma(rotX, rotX, _t3);
        float _t17 = Math.fma(rotX, rotX, rotY * rotY);
        float _t21 = 2.0f * Math.fma(rotX, rotZ, _t5);
        float _t22 = 2.0f * Math.fma(rotX, rotY, _t4);
        float _t23 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t24 = 2.0f * Math.fma(rotX, rotY, -_t4);
        float _t25 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t5);
        return new Float3x4(Math.fma(-2.0f, _t12, 1.0f), _t24, _t21, Math.fma(pivotX, 2.0f * _t12, Math.fma(_t0, _t24, Math.fma(_t1, _t21, this.m03))), _t22, Math.fma(-2.0f, _t15, 1.0f), _t25, Math.fma(pivotY, 2.0f * _t15, Math.fma(_t2, _t22, Math.fma(_t1, _t25, this.m13))), _t26, _t23, Math.fma(-2.0f, _t17, 1.0f), Math.fma(pivotZ, 2.0f * _t17, Math.fma(_t2, _t26, Math.fma(_t0, _t23, this.m23))), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateAround_orthogonal}; reached only through it. */
    private Float3 rotateAround_orthogonal_s373cbb5f_c0(float _t26, float _t29, float _t20) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t29, this.m01 * _t20)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t29, this.m11 * _t20)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t29, this.m21 * _t20)));
    }

    /** Private per-column body of {@code rotateAround_orthogonal}; reached only through it. */
    private Float3 rotateAround_orthogonal_s373cbb5f_c1(float _t21, float _t27, float _t30) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t27, this.m01 * _t30)), Math.fma(this.m12, _t21, Math.fma(this.m10, _t27, this.m11 * _t30)), Math.fma(this.m22, _t21, Math.fma(this.m20, _t27, this.m21 * _t30)));
    }

    /** Private per-column body of {@code rotateAround_orthogonal}; reached only through it. */
    private Float3 rotateAround_orthogonal_s373cbb5f_c2(float _t31, float _t22, float _t28) {
        return new Float3(Math.fma(this.m02, _t31, Math.fma(this.m00, _t22, this.m01 * _t28)), Math.fma(this.m12, _t31, Math.fma(this.m10, _t22, this.m11 * _t28)), Math.fma(this.m22, _t31, Math.fma(this.m20, _t22, this.m21 * _t28)));
    }

    /** Private per-column body of {@code rotateAround_orthogonal}; reached only through it. */
    private Float3 rotateAround_orthogonal_s373cbb5f_c3(float _t41, float _t42, float _t43) {
        return new Float3(Math.fma(this.m00, _t41, Math.fma(this.m01, _t42, Math.fma(this.m02, _t43, this.m03))), Math.fma(this.m10, _t41, Math.fma(this.m11, _t42, Math.fma(this.m12, _t43, this.m13))), Math.fma(this.m20, _t41, Math.fma(this.m21, _t42, Math.fma(this.m22, _t43, this.m23))));
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x4 rotateAround_orthogonal(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t2 = rotY * rotW;
        float _t3 = rotZ * rotZ;
        float _t4 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t3);
        float _t14 = Math.fma(rotX, rotX, _t3);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t4);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotZ, _t2);
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t2);
        float _t27 = 2.0f * Math.fma(rotX, rotY, -_t4);
        float _t28 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0f * _t14, -(pivotX * _t20)));
        float _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t26)));
        return new Float3x4(rotateAround_orthogonal_s373cbb5f_c0(_t26, _t29, _t20), rotateAround_orthogonal_s373cbb5f_c1(_t21, _t27, _t30), rotateAround_orthogonal_s373cbb5f_c2(_t31, _t22, _t28), rotateAround_orthogonal_s373cbb5f_c3(_t41, _t42, _t43), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateAround_general}; reached only through it. */
    private Float3 rotateAround_general_s373cbb5f_c0(float _t26, float _t29, float _t20) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t29, this.m01 * _t20)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t29, this.m11 * _t20)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t29, this.m21 * _t20)));
    }

    /** Private per-column body of {@code rotateAround_general}; reached only through it. */
    private Float3 rotateAround_general_s373cbb5f_c1(float _t21, float _t27, float _t30) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t27, this.m01 * _t30)), Math.fma(this.m12, _t21, Math.fma(this.m10, _t27, this.m11 * _t30)), Math.fma(this.m22, _t21, Math.fma(this.m20, _t27, this.m21 * _t30)));
    }

    /** Private per-column body of {@code rotateAround_general}; reached only through it. */
    private Float3 rotateAround_general_s373cbb5f_c2(float _t31, float _t22, float _t28) {
        return new Float3(Math.fma(this.m02, _t31, Math.fma(this.m00, _t22, this.m01 * _t28)), Math.fma(this.m12, _t31, Math.fma(this.m10, _t22, this.m11 * _t28)), Math.fma(this.m22, _t31, Math.fma(this.m20, _t22, this.m21 * _t28)));
    }

    /** Private per-column body of {@code rotateAround_general}; reached only through it. */
    private Float3 rotateAround_general_s373cbb5f_c3(float _t41, float _t42, float _t43) {
        return new Float3(Math.fma(this.m00, _t41, Math.fma(this.m01, _t42, Math.fma(this.m02, _t43, this.m03))), Math.fma(this.m10, _t41, Math.fma(this.m11, _t42, Math.fma(this.m12, _t43, this.m13))), Math.fma(this.m20, _t41, Math.fma(this.m21, _t42, Math.fma(this.m22, _t43, this.m23))));
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Float3x4 rotateAround_general(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t2 = rotY * rotW;
        float _t3 = rotZ * rotZ;
        float _t4 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t3);
        float _t14 = Math.fma(rotX, rotX, _t3);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t4);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotZ, _t2);
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t2);
        float _t27 = 2.0f * Math.fma(rotX, rotY, -_t4);
        float _t28 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0f * _t14, -(pivotX * _t20)));
        float _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t26)));
        return new Float3x4(rotateAround_general_s373cbb5f_c0(_t26, _t29, _t20), rotateAround_general_s373cbb5f_c1(_t21, _t27, _t30), rotateAround_general_s373cbb5f_c2(_t31, _t22, _t28), rotateAround_general_s373cbb5f_c3(_t41, _t42, _t43), Joml.BIT_AFFINE);
    }


    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix, returning the result
     * as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 rotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAround_orthogonal(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_general(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
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
    public Float3x4 rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x4 rotateAxis_identity(float angle, float axisX, float axisY, float axisZ) {
        return preRotateAxis_identity(angle, axisX, axisY, axisZ);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x4 rotateAxis_translation(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisY;
        float _t4 = axisX * axisZ;
        float _t5 = axisY * axisZ;
        return new Float3x4(Math.fma(_t2, axisX * axisX, _t0), Math.fma(_t2, _t3, -(axisZ * _t1)), Math.fma(axisY, _t1, _t2 * _t4), this.m03, Math.fma(axisZ, _t1, _t2 * _t3), Math.fma(_t2, axisY * axisY, _t0), Math.fma(_t2, _t5, -(axisX * _t1)), this.m13, Math.fma(_t2, _t4, -(axisY * _t1)), Math.fma(axisX, _t1, _t2 * _t5), Math.fma(_t2, axisZ * axisZ, _t0), this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c0(float _t24, float _t18, float _t21) {
        return new Float3(Math.fma(this.m02, _t24, Math.fma(this.m00, _t18, this.m01 * _t21)), Math.fma(this.m12, _t24, Math.fma(this.m10, _t18, this.m11 * _t21)), Math.fma(this.m22, _t24, Math.fma(this.m20, _t18, this.m21 * _t21)));
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c1(float _t22, float _t25, float _t19) {
        return new Float3(Math.fma(this.m02, _t22, Math.fma(this.m00, _t25, this.m01 * _t19)), Math.fma(this.m12, _t22, Math.fma(this.m10, _t25, this.m11 * _t19)), Math.fma(this.m22, _t22, Math.fma(this.m20, _t25, this.m21 * _t19)));
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c2(float _t20, float _t23, float _t26) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t23, this.m01 * _t26)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t23, this.m11 * _t26)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t23, this.m21 * _t26)));
    }

    /** Private per-column body of {@code rotateAxis_orthogonal}; reached only through it. */
    private Float3 rotateAxis_orthogonal_s3b957671_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x4 rotateAxis_orthogonal(float angle, float axisX, float axisY, float axisZ) {
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
        return new Float3x4(rotateAxis_orthogonal_s3b957671_c0(_t24, _t18, _t21), rotateAxis_orthogonal_s3b957671_c1(_t22, _t25, _t19), rotateAxis_orthogonal_s3b957671_c2(_t20, _t23, _t26), rotateAxis_orthogonal_s3b957671_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateAxis_general}; reached only through it. */
    private Float3 rotateAxis_general_s3b957671_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Float3x4 rotateAxis_general(float angle, float axisX, float axisY, float axisZ) {
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
        return new Float3x4(rotateAxis_general_s3b957671_c0(_t24, _t18, _t21), rotateAxis_general_s3b957671_c1(_t22, _t25, _t19), rotateAxis_general_s3b957671_c2(_t20, _t23, _t26), rotateAxis_general_s3b957671_c3(), Joml.BIT_AFFINE);
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
    public Float3x4 rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ);
        return rotateAxis_general(angle, axisX, axisY, axisZ);
    }


    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return the resulting matrix
     */
    public Float3x4 rotateQuat(FloatQuat q) {
        return rotateQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Float3x4 rotateQuat_identity(float qX, float qY, float qZ, float qW) {
        return preRotateQuat_identity(qX, qY, qZ, qW);
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Float3x4 rotateQuat_translation(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        return new Float3x4(Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f), 2.0f * Math.fma(qX, qY, -_t1), 2.0f * Math.fma(qX, qZ, _t2), this.m03, 2.0f * Math.fma(qX, qY, _t1), Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f), 2.0f * Math.fma(qY, qZ, -(qX * qW)), this.m13, 2.0f * Math.fma(qX, qZ, -_t2), 2.0f * Math.fma(qX, qW, qY * qZ), Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f), this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateQuat_orthogonal}; reached only through it. */
    private Float3 rotateQuat_orthogonal_s4eb09b0a_c0(float _t21, float _t24, float _t18) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t24, this.m01 * _t18)), Math.fma(this.m12, _t21, Math.fma(this.m10, _t24, this.m11 * _t18)), Math.fma(this.m22, _t21, Math.fma(this.m20, _t24, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateQuat_orthogonal}; reached only through it. */
    private Float3 rotateQuat_orthogonal_s4eb09b0a_c1(float _t19, float _t22, float _t25) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t22, this.m01 * _t25)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t22, this.m11 * _t25)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t22, this.m21 * _t25)));
    }

    /** Private per-column body of {@code rotateQuat_orthogonal}; reached only through it. */
    private Float3 rotateQuat_orthogonal_s4eb09b0a_c2(float _t26, float _t20, float _t23) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t20, this.m01 * _t23)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t20, this.m11 * _t23)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t20, this.m21 * _t23)));
    }

    /** Private per-column body of {@code rotateQuat_orthogonal}; reached only through it. */
    private Float3 rotateQuat_orthogonal_s4eb09b0a_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Float3x4 rotateQuat_orthogonal(float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qY, _t2);
        float _t19 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t20 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t21 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t22 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t23 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        return new Float3x4(rotateQuat_orthogonal_s4eb09b0a_c0(_t21, _t24, _t18), rotateQuat_orthogonal_s4eb09b0a_c1(_t19, _t22, _t25), rotateQuat_orthogonal_s4eb09b0a_c2(_t26, _t20, _t23), rotateQuat_orthogonal_s4eb09b0a_c3(), Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateQuat_general}; reached only through it. */
    private Float3 rotateQuat_general_s4eb09b0a_c0(float _t21, float _t24, float _t18) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t24, this.m01 * _t18)), Math.fma(this.m12, _t21, Math.fma(this.m10, _t24, this.m11 * _t18)), Math.fma(this.m22, _t21, Math.fma(this.m20, _t24, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateQuat_general}; reached only through it. */
    private Float3 rotateQuat_general_s4eb09b0a_c1(float _t19, float _t22, float _t25) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t22, this.m01 * _t25)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t22, this.m11 * _t25)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t22, this.m21 * _t25)));
    }

    /** Private per-column body of {@code rotateQuat_general}; reached only through it. */
    private Float3 rotateQuat_general_s4eb09b0a_c2(float _t26, float _t20, float _t23) {
        return new Float3(Math.fma(this.m02, _t26, Math.fma(this.m00, _t20, this.m01 * _t23)), Math.fma(this.m12, _t26, Math.fma(this.m10, _t20, this.m11 * _t23)), Math.fma(this.m22, _t26, Math.fma(this.m20, _t20, this.m21 * _t23)));
    }

    /** Private per-column body of {@code rotateQuat_general}; reached only through it. */
    private Float3 rotateQuat_general_s4eb09b0a_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateQuat} dispatcher.
     */
    private Float3x4 rotateQuat_general(float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        float _t18 = 2.0f * Math.fma(qX, qY, _t2);
        float _t19 = 2.0f * Math.fma(qX, qW, qY * qZ);
        float _t20 = 2.0f * Math.fma(qX, qZ, _t0);
        float _t21 = 2.0f * Math.fma(qX, qZ, -_t0);
        float _t22 = 2.0f * Math.fma(qX, qY, -_t2);
        float _t23 = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        float _t24 = Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f);
        float _t25 = Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f);
        float _t26 = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        return new Float3x4(rotateQuat_general_s4eb09b0a_c0(_t21, _t24, _t18), rotateQuat_general_s4eb09b0a_c1(_t19, _t22, _t25), rotateQuat_general_s4eb09b0a_c2(_t26, _t20, _t23), rotateQuat_general_s4eb09b0a_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply the rotation represented by the quaternion ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    public Float3x4 rotateQuat(float qX, float qY, float qZ, float qW) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateQuat_identity(qX, qY, qZ, qW);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateQuat_translation(qX, qY, qZ, qW);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateQuat_orthogonal(qX, qY, qZ, qW);
        return rotateQuat_general(qX, qY, qZ, qW);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x4 rotateX_identity(float angle) {
        return preRotateX_identity(angle);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x4 rotateX_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(1.0f, 0.0f, 0.0f, this.m03, 0.0f, _t0, -_t1, this.m13, 0.0f, _t1, _t0, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x4 rotateX_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(this.m00, Math.fma(this.m01, _t0, this.m02 * _t1), Math.fma(this.m02, _t0, -(this.m01 * _t1)), this.m03, this.m10, Math.fma(this.m11, _t0, this.m12 * _t1), Math.fma(this.m12, _t0, -(this.m11 * _t1)), this.m13, this.m20, Math.fma(this.m21, _t0, this.m22 * _t1), Math.fma(this.m22, _t0, -(this.m21 * _t1)), this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Float3x4 rotateX_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(this.m00, Math.fma(this.m01, _t0, this.m02 * _t1), Math.fma(this.m02, _t0, -(this.m01 * _t1)), this.m03, this.m10, Math.fma(this.m11, _t0, this.m12 * _t1), Math.fma(this.m12, _t0, -(this.m11 * _t1)), this.m13, this.m20, Math.fma(this.m21, _t0, this.m22 * _t1), Math.fma(this.m22, _t0, -(this.m21 * _t1)), this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 rotateX(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal(angle);
        return rotateX_general(angle);
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
    public Float3x4 rotateX180() {
        return mapXnYnZ();
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
    public Float3x4 rotateX270() {
        return mapXnZY();
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
    public Float3x4 rotateX90() {
        return mapXZnY();
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x4 rotateXYZ_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        return new Float3x4(_t0 * _t1, -(_t2 * _t0), _t3, 0.0f, Math.fma(_t6, _t1, _t2 * _t5), Math.fma(_t5, _t1, -(_t6 * _t2)), -(_t4 * _t0), 0.0f, Math.fma(_t4, _t2, -(_t7 * _t1)), Math.fma(_t7, _t2, _t4 * _t1), _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x4 rotateXYZ_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t3;
        float _t7 = _t3 * _t5;
        return new Float3x4(_t0 * _t1, -(_t2 * _t0), _t3, this.m03, Math.fma(_t6, _t1, _t2 * _t5), Math.fma(_t5, _t1, -(_t6 * _t2)), -(_t4 * _t0), this.m13, Math.fma(_t4, _t2, -(_t7 * _t1)), Math.fma(_t7, _t2, _t4 * _t1), _t5 * _t0, this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateXYZ_orthogonal}; reached only through it. */
    private Float3 rotateXYZ_orthogonal_s6e793366_c0(float _t20, float _t7, float _t18) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t7, this.m01 * _t18)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t7, this.m11 * _t18)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t7, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateXYZ_orthogonal}; reached only through it. */
    private Float3 rotateXYZ_orthogonal_s6e793366_c1(float _t19, float _t21, float _t11) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m01, _t21, -(this.m00 * _t11))), Math.fma(this.m12, _t19, Math.fma(this.m11, _t21, -(this.m10 * _t11))), Math.fma(this.m22, _t19, Math.fma(this.m21, _t21, -(this.m20 * _t11))));
    }

    /** Private per-column body of {@code rotateXYZ_orthogonal}; reached only through it. */
    private Float3 rotateXYZ_orthogonal_s6e793366_c2(float _t12, float _t2, float _t13) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t2, -(this.m01 * _t13))), Math.fma(this.m12, _t12, Math.fma(this.m10, _t2, -(this.m11 * _t13))), Math.fma(this.m22, _t12, Math.fma(this.m20, _t2, -(this.m21 * _t13))));
    }

    /** Private per-column body of {@code rotateXYZ_orthogonal}; reached only through it. */
    private Float3 rotateXYZ_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x4 rotateXYZ_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateXYZ_orthogonal_s6e793366_c0(_t20, _t7, _t18), rotateXYZ_orthogonal_s6e793366_c1(_t19, _t21, _t11), rotateXYZ_orthogonal_s6e793366_c2(_t12, _t2, _t13), rotateXYZ_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateXYZ_general}; reached only through it. */
    private Float3 rotateXYZ_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Float3x4 rotateXYZ_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateXYZ_general_s6e793366_c0(_t20, _t7, _t18), rotateXYZ_general_s6e793366_c1(_t19, _t21, _t11), rotateXYZ_general_s6e793366_c2(_t12, _t2, _t13), rotateXYZ_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix, returning the result as a value.
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
    public Float3x4 rotateXYZ(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateXYZ_orthogonal(angleX, angleY, angleZ);
        return rotateXYZ_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x4 rotateXZY_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        return new Float3x4(_t0 * _t1, -_t2, _t3 * _t1, 0.0f, Math.fma(_t6, _t0, _t5 * _t3), _t4 * _t1, Math.fma(_t6, _t3, -(_t5 * _t0)), 0.0f, Math.fma(_t7, _t0, -(_t3 * _t4)), _t5 * _t1, Math.fma(_t7, _t3, _t4 * _t0), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x4 rotateXZY_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t6 = _t2 * _t4;
        float _t7 = _t5 * _t2;
        return new Float3x4(_t0 * _t1, -_t2, _t3 * _t1, this.m03, Math.fma(_t6, _t0, _t5 * _t3), _t4 * _t1, Math.fma(_t6, _t3, -(_t5 * _t0)), this.m13, Math.fma(_t7, _t0, -(_t3 * _t4)), _t5 * _t1, Math.fma(_t7, _t3, _t4 * _t0), this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateXZY_orthogonal}; reached only through it. */
    private Float3 rotateXZY_orthogonal_s6e793366_c0(float _t20, float _t8, float _t18) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t8, this.m01 * _t18)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t8, this.m11 * _t18)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t8, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateXZY_orthogonal}; reached only through it. */
    private Float3 rotateXZY_orthogonal_s6e793366_c1(float _t11, float _t12, float _t1) {
        return new Float3(Math.fma(this.m02, _t11, Math.fma(this.m01, _t12, -(this.m00 * _t1))), Math.fma(this.m12, _t11, Math.fma(this.m11, _t12, -(this.m10 * _t1))), Math.fma(this.m22, _t11, Math.fma(this.m21, _t12, -(this.m20 * _t1))));
    }

    /** Private per-column body of {@code rotateXZY_orthogonal}; reached only through it. */
    private Float3 rotateXZY_orthogonal_s6e793366_c2(float _t19, float _t14, float _t21) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t14, this.m01 * _t21)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t14, this.m11 * _t21)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t14, this.m21 * _t21)));
    }

    /** Private per-column body of {@code rotateXZY_orthogonal}; reached only through it. */
    private Float3 rotateXZY_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x4 rotateXZY_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateXZY_orthogonal_s6e793366_c0(_t20, _t8, _t18), rotateXZY_orthogonal_s6e793366_c1(_t11, _t12, _t1), rotateXZY_orthogonal_s6e793366_c2(_t19, _t14, _t21), rotateXZY_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateXZY_general}; reached only through it. */
    private Float3 rotateXZY_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Float3x4 rotateXZY_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateXZY_general_s6e793366_c0(_t20, _t8, _t18), rotateXZY_general_s6e793366_c1(_t11, _t12, _t1), rotateXZY_general_s6e793366_c2(_t19, _t14, _t21), rotateXZY_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix, returning the result as a value.
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
    public Float3x4 rotateXZY(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateXZY_orthogonal(angleX, angleY, angleZ);
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
    public Float3x4 rotateXn180() {
        return mapXnYnZ();
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
    public Float3x4 rotateXn270() {
        return mapXZnY();
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
    public Float3x4 rotateXn90() {
        return mapXnZY();
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x4 rotateY_identity(float angle) {
        return preRotateY_identity(angle);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x4 rotateY_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, 0.0f, _t1, this.m03, 0.0f, 1.0f, 0.0f, this.m13, -_t1, 0.0f, _t0, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x4 rotateY_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, -(this.m02 * _t1)), this.m01, Math.fma(this.m00, _t1, this.m02 * _t0), this.m03, Math.fma(this.m10, _t0, -(this.m12 * _t1)), this.m11, Math.fma(this.m10, _t1, this.m12 * _t0), this.m13, Math.fma(this.m20, _t0, -(this.m22 * _t1)), this.m21, Math.fma(this.m20, _t1, this.m22 * _t0), this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Float3x4 rotateY_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, -(this.m02 * _t1)), this.m01, Math.fma(this.m00, _t1, this.m02 * _t0), this.m03, Math.fma(this.m10, _t0, -(this.m12 * _t1)), this.m11, Math.fma(this.m10, _t1, this.m12 * _t0), this.m13, Math.fma(this.m20, _t0, -(this.m22 * _t1)), this.m21, Math.fma(this.m20, _t1, this.m22 * _t0), this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 rotateY(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateY_orthogonal(angle);
        return rotateY_general(angle);
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
    public Float3x4 rotateY180() {
        return mapnXYnZ();
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
    public Float3x4 rotateY270() {
        return mapZYnX();
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
    public Float3x4 rotateY90() {
        return mapnZYX();
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x4 rotateYXZ_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        return new Float3x4(Math.fma(_t6, _t2, _t3 * _t4), Math.fma(_t6, _t4, -(_t2 * _t3)), _t1 * _t5, 0.0f, _t2 * _t5, _t5 * _t4, -_t0, 0.0f, Math.fma(_t7, _t2, -(_t1 * _t4)), Math.fma(_t7, _t4, _t1 * _t2), _t5 * _t3, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x4 rotateYXZ_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.cos(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t7 = _t0 * _t3;
        return new Float3x4(Math.fma(_t6, _t2, _t3 * _t4), Math.fma(_t6, _t4, -(_t2 * _t3)), _t1 * _t5, this.m03, _t2 * _t5, _t5 * _t4, -_t0, this.m13, Math.fma(_t7, _t2, -(_t1 * _t4)), Math.fma(_t7, _t4, _t1 * _t2), _t5 * _t3, this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateYXZ_orthogonal}; reached only through it. */
    private Float3 rotateYXZ_orthogonal_s6e793366_c0(float _t20, float _t18, float _t10) {
        return new Float3(Math.fma(this.m02, _t20, Math.fma(this.m00, _t18, this.m01 * _t10)), Math.fma(this.m12, _t20, Math.fma(this.m10, _t18, this.m11 * _t10)), Math.fma(this.m22, _t20, Math.fma(this.m20, _t18, this.m21 * _t10)));
    }

    /** Private per-column body of {@code rotateYXZ_orthogonal}; reached only through it. */
    private Float3 rotateYXZ_orthogonal_s6e793366_c1(float _t19, float _t21, float _t13) {
        return new Float3(Math.fma(this.m02, _t19, Math.fma(this.m00, _t21, this.m01 * _t13)), Math.fma(this.m12, _t19, Math.fma(this.m10, _t21, this.m11 * _t13)), Math.fma(this.m22, _t19, Math.fma(this.m20, _t21, this.m21 * _t13)));
    }

    /** Private per-column body of {@code rotateYXZ_orthogonal}; reached only through it. */
    private Float3 rotateYXZ_orthogonal_s6e793366_c2(float _t14, float _t15, float _t0) {
        return new Float3(Math.fma(this.m02, _t14, Math.fma(this.m00, _t15, -(this.m01 * _t0))), Math.fma(this.m12, _t14, Math.fma(this.m10, _t15, -(this.m11 * _t0))), Math.fma(this.m22, _t14, Math.fma(this.m20, _t15, -(this.m21 * _t0))));
    }

    /** Private per-column body of {@code rotateYXZ_orthogonal}; reached only through it. */
    private Float3 rotateYXZ_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x4 rotateYXZ_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateYXZ_orthogonal_s6e793366_c0(_t20, _t18, _t10), rotateYXZ_orthogonal_s6e793366_c1(_t19, _t21, _t13), rotateYXZ_orthogonal_s6e793366_c2(_t14, _t15, _t0), rotateYXZ_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateYXZ_general}; reached only through it. */
    private Float3 rotateYXZ_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Float3x4 rotateYXZ_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateYXZ_general_s6e793366_c0(_t20, _t18, _t10), rotateYXZ_general_s6e793366_c1(_t19, _t21, _t13), rotateYXZ_general_s6e793366_c2(_t14, _t15, _t0), rotateYXZ_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix, returning the result as a value.
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
    public Float3x4 rotateYXZ(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateYXZ_orthogonal(angleX, angleY, angleZ);
        return rotateYXZ_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x4 rotateYZX_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t2, _t3, -(_t6 * _t5)), Math.fma(_t6, _t2, _t3 * _t5), 0.0f, _t4, _t5 * _t1, -(_t2 * _t1), 0.0f, -(_t3 * _t1), Math.fma(_t7, _t5, _t2 * _t0), Math.fma(_t5, _t0, -(_t7 * _t2)), 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x4 rotateYZX_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t4 * _t0;
        float _t7 = _t3 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t2, _t3, -(_t6 * _t5)), Math.fma(_t6, _t2, _t3 * _t5), this.m03, _t4, _t5 * _t1, -(_t2 * _t1), this.m13, -(_t3 * _t1), Math.fma(_t7, _t5, _t2 * _t0), Math.fma(_t5, _t0, -(_t7 * _t2)), this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateYZX_orthogonal}; reached only through it. */
    private Float3 rotateYZX_orthogonal_s6e793366_c0(float _t6, float _t7, float _t3) {
        return new Float3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t7, this.m01 * _t3)), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t7, this.m11 * _t3)), Math.fma(-this.m22, _t6, Math.fma(this.m20, _t7, this.m21 * _t3)));
    }

    /** Private per-column body of {@code rotateYZX_orthogonal}; reached only through it. */
    private Float3 rotateYZX_orthogonal_s6e793366_c1(float _t18, float _t20, float _t11) {
        return new Float3(Math.fma(this.m02, _t18, Math.fma(this.m00, _t20, this.m01 * _t11)), Math.fma(this.m12, _t18, Math.fma(this.m10, _t20, this.m11 * _t11)), Math.fma(this.m22, _t18, Math.fma(this.m20, _t20, this.m21 * _t11)));
    }

    /** Private per-column body of {@code rotateYZX_orthogonal}; reached only through it. */
    private Float3 rotateYZX_orthogonal_s6e793366_c2(float _t21, float _t19, float _t13) {
        return new Float3(Math.fma(this.m02, _t21, Math.fma(this.m00, _t19, -(this.m01 * _t13))), Math.fma(this.m12, _t21, Math.fma(this.m10, _t19, -(this.m11 * _t13))), Math.fma(this.m22, _t21, Math.fma(this.m20, _t19, -(this.m21 * _t13))));
    }

    /** Private per-column body of {@code rotateYZX_orthogonal}; reached only through it. */
    private Float3 rotateYZX_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x4 rotateYZX_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateYZX_orthogonal_s6e793366_c0(_t6, _t7, _t3), rotateYZX_orthogonal_s6e793366_c1(_t18, _t20, _t11), rotateYZX_orthogonal_s6e793366_c2(_t21, _t19, _t13), rotateYZX_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateYZX_general}; reached only through it. */
    private Float3 rotateYZX_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Float3x4 rotateYZX_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateYZX_general_s6e793366_c0(_t6, _t7, _t3), rotateYZX_general_s6e793366_c1(_t18, _t20, _t11), rotateYZX_general_s6e793366_c2(_t21, _t19, _t13), rotateYZX_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix, returning the result as a value.
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
    public Float3x4 rotateYZX(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateYZX_orthogonal(angleX, angleY, angleZ);
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
    public Float3x4 rotateYn180() {
        return mapnXYnZ();
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
    public Float3x4 rotateYn270() {
        return mapnZYX();
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
    public Float3x4 rotateYn90() {
        return mapZYnX();
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Float3x4 rotateZ_identity(float angle) {
        return preRotateZ_identity(angle);
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Float3x4 rotateZ_translation(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(_t0, -_t1, 0.0f, this.m03, _t1, _t0, 0.0f, this.m13, 0.0f, 0.0f, 1.0f, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Float3x4 rotateZ_orthogonal(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), this.m02, this.m03, Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), this.m12, this.m13, Math.fma(this.m20, _t0, this.m21 * _t1), Math.fma(this.m21, _t0, -(this.m20 * _t1)), this.m22, this.m23, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ} dispatcher.
     */
    private Float3x4 rotateZ_general(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3x4(Math.fma(this.m00, _t0, this.m01 * _t1), Math.fma(this.m01, _t0, -(this.m00 * _t1)), this.m02, this.m03, Math.fma(this.m10, _t0, this.m11 * _t1), Math.fma(this.m11, _t0, -(this.m10 * _t1)), this.m12, this.m13, Math.fma(this.m20, _t0, this.m21 * _t1), Math.fma(this.m21, _t0, -(this.m20 * _t1)), this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 rotateZ(float angle) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ_identity(angle);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ_translation(angle);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ_orthogonal(angle);
        return rotateZ_general(angle);
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
    public Float3x4 rotateZ180() {
        return mapnXnYZ();
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
    public Float3x4 rotateZ270() {
        return mapnYXZ();
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
    public Float3x4 rotateZ90() {
        return mapYnXZ();
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x4 rotateZXY_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        return new Float3x4(Math.fma(_t0, _t1, -(_t6 * _t4)), -(_t3 * _t5), Math.fma(_t6, _t0, _t4 * _t1), 0.0f, Math.fma(_t7, _t4, _t3 * _t0), _t5 * _t1, Math.fma(_t4, _t3, -(_t7 * _t0)), 0.0f, -(_t4 * _t5), _t2, _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x4 rotateZXY_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleX);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleY);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t3;
        float _t7 = _t2 * _t1;
        return new Float3x4(Math.fma(_t0, _t1, -(_t6 * _t4)), -(_t3 * _t5), Math.fma(_t6, _t0, _t4 * _t1), this.m03, Math.fma(_t7, _t4, _t3 * _t0), _t5 * _t1, Math.fma(_t4, _t3, -(_t7 * _t0)), this.m13, -(_t4 * _t5), _t2, _t5 * _t0, this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateZXY_orthogonal}; reached only through it. */
    private Float3 rotateZXY_orthogonal_s6e793366_c0(float _t6, float _t20, float _t18) {
        return new Float3(Math.fma(-this.m02, _t6, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(-this.m12, _t6, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(-this.m22, _t6, Math.fma(this.m20, _t20, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateZXY_orthogonal}; reached only through it. */
    private Float3 rotateZXY_orthogonal_s6e793366_c1(float _t4, float _t10, float _t11) {
        return new Float3(Math.fma(this.m02, _t4, Math.fma(this.m01, _t10, -(this.m00 * _t11))), Math.fma(this.m12, _t4, Math.fma(this.m11, _t10, -(this.m10 * _t11))), Math.fma(this.m22, _t4, Math.fma(this.m21, _t10, -(this.m20 * _t11))));
    }

    /** Private per-column body of {@code rotateZXY_orthogonal}; reached only through it. */
    private Float3 rotateZXY_orthogonal_s6e793366_c2(float _t12, float _t19, float _t21) {
        return new Float3(Math.fma(this.m02, _t12, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(this.m12, _t12, Math.fma(this.m10, _t19, this.m11 * _t21)), Math.fma(this.m22, _t12, Math.fma(this.m20, _t19, this.m21 * _t21)));
    }

    /** Private per-column body of {@code rotateZXY_orthogonal}; reached only through it. */
    private Float3 rotateZXY_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x4 rotateZXY_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateZXY_orthogonal_s6e793366_c0(_t6, _t20, _t18), rotateZXY_orthogonal_s6e793366_c1(_t4, _t10, _t11), rotateZXY_orthogonal_s6e793366_c2(_t12, _t19, _t21), rotateZXY_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateZXY_general}; reached only through it. */
    private Float3 rotateZXY_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Float3x4 rotateZXY_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateZXY_general_s6e793366_c0(_t6, _t20, _t18), rotateZXY_general_s6e793366_c1(_t4, _t10, _t11), rotateZXY_general_s6e793366_c2(_t12, _t19, _t21), rotateZXY_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix, returning the result as a value.
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
    public Float3x4 rotateZXY(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZXY_orthogonal(angleX, angleY, angleZ);
        return rotateZXY_general(angleX, angleY, angleZ);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x4 rotateZYX_identity(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t6, _t3, -(_t4 * _t5)), Math.fma(_t6, _t5, _t3 * _t4), 0.0f, _t4 * _t0, Math.fma(_t7, _t3, _t5 * _t1), Math.fma(_t7, _t5, -(_t3 * _t1)), 0.0f, -_t2, _t3 * _t0, _t5 * _t0, 0.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x4 rotateZYX_translation(float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.cos(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = (float) Math.sin(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t2 * _t1;
        float _t7 = _t2 * _t4;
        return new Float3x4(_t0 * _t1, Math.fma(_t6, _t3, -(_t4 * _t5)), Math.fma(_t6, _t5, _t3 * _t4), this.m03, _t4 * _t0, Math.fma(_t7, _t3, _t5 * _t1), Math.fma(_t7, _t5, -(_t3 * _t1)), this.m13, -_t2, _t3 * _t0, _t5 * _t0, this.m23, Joml.BIT_ORTHOGONAL);
    }

    /** Private per-column body of {@code rotateZYX_orthogonal}; reached only through it. */
    private Float3 rotateZYX_orthogonal_s6e793366_c0(float _t0, float _t6, float _t7) {
        return new Float3(Math.fma(-this.m02, _t0, Math.fma(this.m00, _t6, this.m01 * _t7)), Math.fma(-this.m12, _t0, Math.fma(this.m10, _t6, this.m11 * _t7)), Math.fma(-this.m22, _t0, Math.fma(this.m20, _t6, this.m21 * _t7)));
    }

    /** Private per-column body of {@code rotateZYX_orthogonal}; reached only through it. */
    private Float3 rotateZYX_orthogonal_s6e793366_c1(float _t8, float _t20, float _t18) {
        return new Float3(Math.fma(this.m02, _t8, Math.fma(this.m00, _t20, this.m01 * _t18)), Math.fma(this.m12, _t8, Math.fma(this.m10, _t20, this.m11 * _t18)), Math.fma(this.m22, _t8, Math.fma(this.m20, _t20, this.m21 * _t18)));
    }

    /** Private per-column body of {@code rotateZYX_orthogonal}; reached only through it. */
    private Float3 rotateZYX_orthogonal_s6e793366_c2(float _t13, float _t19, float _t21) {
        return new Float3(Math.fma(this.m02, _t13, Math.fma(this.m00, _t19, this.m01 * _t21)), Math.fma(this.m12, _t13, Math.fma(this.m10, _t19, this.m11 * _t21)), Math.fma(this.m22, _t13, Math.fma(this.m20, _t19, this.m21 * _t21)));
    }

    /** Private per-column body of {@code rotateZYX_orthogonal}; reached only through it. */
    private Float3 rotateZYX_orthogonal_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x4 rotateZYX_orthogonal(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateZYX_orthogonal_s6e793366_c0(_t0, _t6, _t7), rotateZYX_orthogonal_s6e793366_c1(_t8, _t20, _t18), rotateZYX_orthogonal_s6e793366_c2(_t13, _t19, _t21), rotateZYX_orthogonal_s6e793366_c3(), Joml.BIT_ORTHOGONAL);
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

    /** Private per-column body of {@code rotateZYX_general}; reached only through it. */
    private Float3 rotateZYX_general_s6e793366_c3() {
        return new Float3(this.m03, this.m13, this.m23);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Float3x4 rotateZYX_general(float angleX, float angleY, float angleZ) {
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
        return new Float3x4(rotateZYX_general_s6e793366_c0(_t0, _t6, _t7), rotateZYX_general_s6e793366_c1(_t8, _t20, _t18), rotateZYX_general_s6e793366_c2(_t13, _t19, _t21), rotateZYX_general_s6e793366_c3(), Joml.BIT_AFFINE);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix, returning the result as a value.
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
    public Float3x4 rotateZYX(float angleX, float angleY, float angleZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZYX_orthogonal(angleX, angleY, angleZ);
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
    public Float3x4 rotateZn180() {
        return mapnXnYZ();
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
    public Float3x4 rotateZn270() {
        return mapYnXZ();
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
    public Float3x4 rotateZn90() {
        return mapnYXZ();
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
    public Float3x4 scale(Float3 v) {
        return scale(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_identity(float vX, float vY, float vZ) {
        return preScale_identity(vX, vY, vZ);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_translation(float vX, float vY, float vZ) {
        return new Float3x4(vX, 0.0f, 0.0f, this.m03, 0.0f, vY, 0.0f, this.m13, 0.0f, 0.0f, vZ, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_general(float vX, float vY, float vZ) {
        return new Float3x4(this.m00 * vX, this.m01 * vY, this.m02 * vZ, this.m03, this.m10 * vX, this.m11 * vY, this.m12 * vZ, this.m13, this.m20 * vX, this.m21 * vY, this.m22 * vZ, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}, {@code vZ}) to this matrix, returning the result
     * as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public Float3x4 scale(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY, vZ);
        return scale_general(vX, vY, vZ);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_identity(float s) {
        return preScale_identity(s);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_translation(float s) {
        return new Float3x4(s, 0.0f, 0.0f, this.m03, 0.0f, s, 0.0f, this.m13, 0.0f, 0.0f, s, this.m23, Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Float3x4 scale_general(float s) {
        return new Float3x4(s * this.m00, s * this.m01, s * this.m02, this.m03, s * this.m10, s * this.m11, s * this.m12, this.m13, s * this.m20, s * this.m21, s * this.m22, this.m23, Joml.BIT_AFFINE);
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
    public Float3x4 scale(float s) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(s);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(s);
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
    public Float3x4 scaleAround(float s, Float3 pivot) {
        return scaleAround(s, pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_identity(float s, float pivotX, float pivotY, float pivotZ) {
        return preScaleAround_identity(s, pivotX, pivotY, pivotZ);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_translation(float s, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(s, 0.0f, 0.0f, Math.fma(-s, pivotX, this.m03 + pivotX), 0.0f, s, 0.0f, Math.fma(-s, pivotY, this.m13 + pivotY), 0.0f, 0.0f, s, Math.fma(-s, pivotZ, this.m23 + pivotZ), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_orthogonal(float s, float pivotX, float pivotY, float pivotZ) {
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        return new Float3x4(s * this.m00, s * this.m01, s * this.m02, Math.fma(this.m00, _t0, Math.fma(this.m01, _t1, Math.fma(this.m02, _t2, this.m03))), s * this.m10, s * this.m11, s * this.m12, Math.fma(this.m10, _t0, Math.fma(this.m11, _t1, Math.fma(this.m12, _t2, this.m13))), s * this.m20, s * this.m21, s * this.m22, Math.fma(this.m20, _t0, Math.fma(this.m21, _t1, Math.fma(this.m22, _t2, this.m23))), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_general(float s, float pivotX, float pivotY, float pivotZ) {
        return scaleAround_orthogonal(s, pivotX, pivotY, pivotZ);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY},
     * {@code pivotZ}) to this matrix, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 scaleAround(float s, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(s, pivotX, pivotY, pivotZ);
        return scaleAround_general(s, pivotX, pivotY, pivotZ);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return the resulting matrix
     */
    public Float3x4 scaleAround(Float3 s, Float3 pivot) {
        return scaleAround(s.x(), s.y(), s.z(), pivot.x(), pivot.y(), pivot.z());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_identity(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return preScaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_translation(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return new Float3x4(sX, 0.0f, 0.0f, Math.fma(-pivotX, sX, this.m03 + pivotX), 0.0f, sY, 0.0f, Math.fma(-pivotY, sY, this.m13 + pivotY), 0.0f, 0.0f, sZ, Math.fma(-pivotZ, sZ, this.m23 + pivotZ), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_orthogonal(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        return new Float3x4(sX * this.m00, sY * this.m01, sZ * this.m02, Math.fma(this.m00, _t3, Math.fma(this.m01, _t4, Math.fma(this.m02, _t5, this.m03))), sX * this.m10, sY * this.m11, sZ * this.m12, Math.fma(this.m10, _t3, Math.fma(this.m11, _t4, Math.fma(this.m12, _t5, this.m13))), sX * this.m20, sY * this.m21, sZ * this.m22, Math.fma(this.m20, _t3, Math.fma(this.m21, _t4, Math.fma(this.m22, _t5, this.m23))), Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Float3x4 scaleAround_general(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        return scaleAround_orthogonal(sX, sY, sZ, pivotX, pivotY, pivotZ);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return the resulting matrix
     */
    public Float3x4 scaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, sZ, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, sZ, pivotX, pivotY, pivotZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return scaleAround_orthogonal(sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_general(sX, sY, sZ, pivotX, pivotY, pivotZ);
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
    public Float3x4 translate(Float3 v) {
        return translate(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x4 translate_identity(float vX, float vY, float vZ) {
        return preTranslate_identity(vX, vY, vZ);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x4 translate_translation(float vX, float vY, float vZ) {
        return preTranslate_translation(vX, vY, vZ);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x4 translate_orthogonal(float vX, float vY, float vZ) {
        return new Float3x4(this.m00, this.m01, this.m02, Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03))), this.m10, this.m11, this.m12, Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13))), this.m20, this.m21, this.m22, Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23))), Joml.BIT_ORTHOGONAL);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Float3x4 translate_general(float vX, float vY, float vZ) {
        return new Float3x4(this.m00, this.m01, this.m02, Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03))), this.m10, this.m11, this.m12, Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13))), this.m20, this.m21, this.m22, Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23))), Joml.BIT_AFFINE);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}, {@code vZ}) to this matrix, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the translation offsets {@code (vX, vY, vZ)}
     * @return the resulting matrix
     */
    public Float3x4 translate(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY, vZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return translate_orthogonal(vX, vY, vZ);
        return translate_general(vX, vY, vZ);
    }


    /**
     * Multiply this matrix by the given vector, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 mul(Float4 v) {
        return mul(v.x(), v.y(), v.z(), v.w());
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_identity(float vX, float vY, float vZ, float vW) {
        return new Float3(vX, vY, vZ);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_translation(float vX, float vY, float vZ, float vW) {
        return new Float3(Math.fma(this.m03, vW, vX), Math.fma(this.m13, vW, vY), Math.fma(this.m23, vW, vZ));
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Float3 mul_general(float vX, float vY, float vZ, float vW) {
        return new Float3(Math.fma(this.m03, vW, Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY))), Math.fma(this.m13, vW, Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY))), Math.fma(this.m23, vW, Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY))));
    }


    /**
     * Multiply this matrix by the given vector, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the vector {@code (vX, vY, vZ, vW)}
     * @return the resulting vector
     */
    public Float3 mul(float vX, float vY, float vZ, float vW) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ, vW);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ, vW);
        return mul_general(vX, vY, vZ, vW);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result, returning the result as a value.
     *
     * @param aabb the axis-aligned bounding box
     * @return the resulting axis-aligned bounding box
     */
    public FloatAABB transformAabb(FloatAABB aabb) {
        return transformAabb(aabb.minX(), aabb.minY(), aabb.minZ(), aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private FloatAABB transformAabb_identity(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return new FloatAABB(Math.min(minX, maxX), Math.min(minY, maxY), Math.min(minZ, maxZ), Math.max(minX, maxX), Math.max(minY, maxY), Math.max(minZ, maxZ));
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private FloatAABB transformAabb_translation(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return new FloatAABB(this.m03 + Math.min(minX, maxX), this.m13 + Math.min(minY, maxY), this.m23 + Math.min(minZ, maxZ), this.m03 + Math.max(minX, maxX), this.m13 + Math.max(minY, maxY), this.m23 + Math.max(minZ, maxZ));
    }

    /** Private tail of {@code transformAabb_orthogonal}; reached only through it. */
    private FloatAABB transformAabb_orthogonal_s4a041090_tail(float maxZ, float _t0, float _t1, float _t2, float _t3, float _t4, float _t5, float _t6, float _t7, float _t8, float _t9, float _t10, float _t11, float _t12, float _t13, float _t14, float _t15, float _t16) {
        float _t17 = maxZ * this.m22;
        return new FloatAABB(this.m03 + Math.min(_t0, _t1) + Math.min(_t2, _t3) + Math.min(_t4, _t5), this.m13 + Math.min(_t6, _t7) + Math.min(_t8, _t9) + Math.min(_t10, _t11), this.m23 + Math.min(_t12, _t13) + Math.min(_t14, _t15) + Math.min(_t16, _t17), this.m03 + Math.max(_t0, _t1) + Math.max(_t2, _t3) + Math.max(_t4, _t5), this.m13 + Math.max(_t6, _t7) + Math.max(_t8, _t9) + Math.max(_t10, _t11), this.m23 + Math.max(_t12, _t13) + Math.max(_t14, _t15) + Math.max(_t16, _t17));
    }


    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private FloatAABB transformAabb_orthogonal(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _t0 = minX * this.m00;
        float _t1 = maxX * this.m00;
        float _t2 = minY * this.m01;
        float _t3 = maxY * this.m01;
        float _t4 = minZ * this.m02;
        float _t5 = maxZ * this.m02;
        float _t6 = minX * this.m10;
        float _t7 = maxX * this.m10;
        float _t8 = minY * this.m11;
        float _t9 = maxY * this.m11;
        float _t10 = minZ * this.m12;
        float _t11 = maxZ * this.m12;
        float _t12 = minX * this.m20;
        float _t13 = maxX * this.m20;
        float _t14 = minY * this.m21;
        float _t15 = maxY * this.m21;
        float _t16 = minZ * this.m22;
        return transformAabb_orthogonal_s4a041090_tail(maxZ, _t0, _t1, _t2, _t3, _t4, _t5, _t6, _t7, _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15, _t16);
    }



    /**
     * Private body of {@code transformAabb}, specialized by runtime matrix properties; reached only
     * through the public {@code transformAabb} dispatcher.
     */
    private FloatAABB transformAabb_general(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return transformAabb_orthogonal(minX, minY, minZ, maxX, maxY, maxZ);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result, returning the result as a value.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @return the resulting axis-aligned bounding box
     */
    public FloatAABB transformAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transformAabb_identity(minX, minY, minZ, maxX, maxY, maxZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformAabb_translation(minX, minY, minZ, maxX, maxY, maxZ);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return transformAabb_orthogonal(minX, minY, minZ, maxX, maxY, maxZ);
        return transformAabb_general(minX, minY, minZ, maxX, maxY, maxZ);
    }


    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result, returning the result as a value.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return the resulting axis-aligned bounding box
     */
    public FloatAABB transformAabb(Float3 min, Float3 max) {
        return transformAabb(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation, returning the result
     * as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformDirection(Float3 v) {
        return transformDirection(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Float3 transformDirection_identity(float vX, float vY, float vZ) {
        return new Float3(vX, vY, vZ);
    }


    /**
     * Private body of {@code transformDirection}, specialized by runtime matrix properties; reached
     * only through the public {@code transformDirection} dispatcher.
     */
    private Float3 transformDirection_general(float vX, float vY, float vZ) {
        return new Float3(Math.fma(this.m02, vZ, Math.fma(this.m00, vX, this.m01 * vY)), Math.fma(this.m12, vZ, Math.fma(this.m10, vX, this.m11 * vY)), Math.fma(this.m22, vZ, Math.fma(this.m20, vX, this.m21 * vY)));
    }


    /**
     * Transform the given direction by this matrix, ignoring any translation, returning the result
     * as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformDirection(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformDirection_identity(vX, vY, vZ);
        return transformDirection_general(vX, vY, vZ);
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformPosition(Float3 v) {
        return transformPosition(v.x(), v.y(), v.z());
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Float3 transformPosition_identity(float vX, float vY, float vZ) {
        return transformDirection_identity(vX, vY, vZ);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Float3 transformPosition_translation(float vX, float vY, float vZ) {
        return new Float3(this.m03 + vX, this.m13 + vY, this.m23 + vZ);
    }


    /**
     * Private body of {@code transformPosition}, specialized by runtime matrix properties; reached
     * only through the public {@code transformPosition} dispatcher.
     */
    private Float3 transformPosition_general(float vX, float vY, float vZ) {
        return new Float3(Math.fma(this.m00, vX, Math.fma(this.m01, vY, Math.fma(this.m02, vZ, this.m03))), Math.fma(this.m10, vX, Math.fma(this.m11, vY, Math.fma(this.m12, vZ, this.m13))), Math.fma(this.m20, vX, Math.fma(this.m21, vY, Math.fma(this.m22, vZ, this.m23))));
    }


    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformPosition(float vX, float vY, float vZ) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transformPosition_identity(vX, vY, vZ);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transformPosition_translation(vX, vY, vZ);
        return transformPosition_general(vX, vY, vZ);
    }

    /** {@return a copy with the {@code m00} element replaced by {@code v}} */
    public Float3x4 withM00(float v) {
        return new Float3x4(v, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m01} element replaced by {@code v}} */
    public Float3x4 withM01(float v) {
        return new Float3x4(m00, v, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m02} element replaced by {@code v}} */
    public Float3x4 withM02(float v) {
        return new Float3x4(m00, m01, v, m03, m10, m11, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m03} element replaced by {@code v}} */
    public Float3x4 withM03(float v) {
        return new Float3x4(m00, m01, m02, v, m10, m11, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m10} element replaced by {@code v}} */
    public Float3x4 withM10(float v) {
        return new Float3x4(m00, m01, m02, m03, v, m11, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m11} element replaced by {@code v}} */
    public Float3x4 withM11(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, v, m12, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m12} element replaced by {@code v}} */
    public Float3x4 withM12(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, v, m13, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m13} element replaced by {@code v}} */
    public Float3x4 withM13(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, v, m20, m21, m22, m23);
    }

    /** {@return a copy with the {@code m20} element replaced by {@code v}} */
    public Float3x4 withM20(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, v, m21, m22, m23);
    }

    /** {@return a copy with the {@code m21} element replaced by {@code v}} */
    public Float3x4 withM21(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, m20, v, m22, m23);
    }

    /** {@return a copy with the {@code m22} element replaced by {@code v}} */
    public Float3x4 withM22(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, v, m23);
    }

    /** {@return a copy with the {@code m23} element replaced by {@code v}} */
    public Float3x4 withM23(float v) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, v);
    }

    /** {@return a copy with the cached property bits replaced by {@code properties}} */
    public Float3x4 withProperties(int properties) {
        return new Float3x4(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, properties);
    }

    @Override public String toString() {
        return "Float3x4(\n    " + m00() + ", " + m01() + ", " + m02() + ", " + m03() + "\n    " + m10() + ", " + m11() + ", " + m12() + ", " + m13() + "\n    " + m20() + ", " + m21() + ", " + m22() + ", " + m23() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3x4)) return false;
        Float3x4 o = (Float3x4) obj;
        return Float.floatToIntBits(m00) == Float.floatToIntBits(o.m00)
            && Float.floatToIntBits(m01) == Float.floatToIntBits(o.m01)
            && Float.floatToIntBits(m02) == Float.floatToIntBits(o.m02)
            && Float.floatToIntBits(m03) == Float.floatToIntBits(o.m03)
            && Float.floatToIntBits(m10) == Float.floatToIntBits(o.m10)
            && Float.floatToIntBits(m11) == Float.floatToIntBits(o.m11)
            && Float.floatToIntBits(m12) == Float.floatToIntBits(o.m12)
            && Float.floatToIntBits(m13) == Float.floatToIntBits(o.m13)
            && Float.floatToIntBits(m20) == Float.floatToIntBits(o.m20)
            && Float.floatToIntBits(m21) == Float.floatToIntBits(o.m21)
            && Float.floatToIntBits(m22) == Float.floatToIntBits(o.m22)
            && Float.floatToIntBits(m23) == Float.floatToIntBits(o.m23);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(m00);
        h = 31 * h + Float.floatToIntBits(m01);
        h = 31 * h + Float.floatToIntBits(m02);
        h = 31 * h + Float.floatToIntBits(m03);
        h = 31 * h + Float.floatToIntBits(m10);
        h = 31 * h + Float.floatToIntBits(m11);
        h = 31 * h + Float.floatToIntBits(m12);
        h = 31 * h + Float.floatToIntBits(m13);
        h = 31 * h + Float.floatToIntBits(m20);
        h = 31 * h + Float.floatToIntBits(m21);
        h = 31 * h + Float.floatToIntBits(m22);
        h = 31 * h + Float.floatToIntBits(m23);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(m00)
            && Float.isFinite(m01)
            && Float.isFinite(m02)
            && Float.isFinite(m03)
            && Float.isFinite(m10)
            && Float.isFinite(m11)
            && Float.isFinite(m12)
            && Float.isFinite(m13)
            && Float.isFinite(m20)
            && Float.isFinite(m21)
            && Float.isFinite(m22)
            && Float.isFinite(m23);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(Float3x4 other, float epsilon) {
        return Math.abs(m00 - other.m00()) <= epsilon
            && Math.abs(m01 - other.m01()) <= epsilon
            && Math.abs(m02 - other.m02()) <= epsilon
            && Math.abs(m03 - other.m03()) <= epsilon
            && Math.abs(m10 - other.m10()) <= epsilon
            && Math.abs(m11 - other.m11()) <= epsilon
            && Math.abs(m12 - other.m12()) <= epsilon
            && Math.abs(m13 - other.m13()) <= epsilon
            && Math.abs(m20 - other.m20()) <= epsilon
            && Math.abs(m21 - other.m21()) <= epsilon
            && Math.abs(m22 - other.m22()) <= epsilon
            && Math.abs(m23 - other.m23()) <= epsilon;
    }

    static final Float3x4SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x4SegOpsUnsafe()
                    : new Float3x4SegOpsMS();
    static final Float3x4BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x4BbOpsUnsafe()
                    : new Float3x4BbOpsApi();
    static final Float3x4RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3x4RawOpsUnsafe()
                    : new Float3x4RawOpsApi();


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
        dest[offset + 9] = this.m03;
        dest[offset + 10] = this.m13;
        dest[offset + 11] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c4 = src[offset + 1];
        float _c8 = src[offset + 2];
        float _c1 = src[offset + 3];
        float _c5 = src[offset + 4];
        float _c9 = src[offset + 5];
        float _c2 = src[offset + 6];
        float _c6 = src[offset + 7];
        float _c10 = src[offset + 8];
        float _c3 = src[offset + 9];
        float _c7 = src[offset + 10];
        float _c11 = src[offset + 11];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(float[] src) { return loadCM(src, 0); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeCMRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 12);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(FloatBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 48);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(ByteBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 48);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM(MemorySegment dest) { return storeCM(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(MemorySegment src) { return loadCM(0L, src); }

    /**
     * Load the elements from the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(long offset, MemorySegment src) {
        return SEG_OPS.loadCM(offset, src);
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
        dest[offset + 9] = this.m03;
        dest[offset + 10] = this.m13;
        dest[offset + 11] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c4 = (float) src[offset + 1];
        float _c8 = (float) src[offset + 2];
        float _c1 = (float) src[offset + 3];
        float _c5 = (float) src[offset + 4];
        float _c9 = (float) src[offset + 5];
        float _c2 = (float) src[offset + 6];
        float _c6 = (float) src[offset + 7];
        float _c10 = (float) src[offset + 8];
        float _c3 = (float) src[offset + 9];
        float _c7 = (float) src[offset + 10];
        float _c11 = (float) src[offset + 11];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(double[] src) { return loadCM(src, 0); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeCMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf);
        buf.position(pos + 12);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(DoubleBuffer buf) {
        return loadCMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeCMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeCMDoubleAbsolute(pos, buf);
        buf.position(pos + 96);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(ByteBuffer buf) {
        return loadCMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadCMDoubleAbsolute(pos, buf);
        buf.position(pos + 96);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 storeCMDoubleUnsafe(long address) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleUnsafe(long address) {
        return RAW_OPS.loadCMDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCMDouble(MemorySegment dest) { return storeCMDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeCMDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment in column-major order, converting each
     * element from {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(MemorySegment src) { return loadCMDouble(0L, src); }

    /**
     * Load the elements from the given memory segment in column-major order, converting each
     * element from {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadCMDouble(offset, src);
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
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c5 = src[offset + 5];
        float _c6 = src[offset + 6];
        float _c7 = src[offset + 7];
        float _c8 = src[offset + 8];
        float _c9 = src[offset + 9];
        float _c10 = src[offset + 10];
        float _c11 = src[offset + 11];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(float[] src) { return loadRM(src, 0); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRMRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 12);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(FloatBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 48);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(ByteBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 48);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in row-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in row-major order. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment in row-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM(MemorySegment dest) { return storeRM(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment in row-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(MemorySegment src) { return loadRM(0L, src); }

    /**
     * Load the elements from the given memory segment in row-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(long offset, MemorySegment src) {
        return SEG_OPS.loadRM(offset, src);
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
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c5 = (float) src[offset + 5];
        float _c6 = (float) src[offset + 6];
        float _c7 = (float) src[offset + 7];
        float _c8 = (float) src[offset + 8];
        float _c9 = (float) src[offset + 9];
        float _c10 = (float) src[offset + 10];
        float _c11 = (float) src[offset + 11];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Load the elements from the given array in row-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(double[] src) { return loadRM(src, 0); }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeRMAbsolute(pos, buf);
        buf.position(pos + 12);
        return buf;
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(DoubleBuffer buf) {
        return loadRMAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeRMDoubleAbsolute(pos, buf);
        buf.position(pos + 96);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(ByteBuffer buf) {
        return loadRMDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3x4 r = loadRMDoubleAbsolute(pos, buf);
        buf.position(pos + 96);
        return r;
    }

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 storeRMDoubleUnsafe(long address) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleUnsafe(long address) {
        return RAW_OPS.loadRMDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRMDouble(MemorySegment dest) { return storeRMDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRMDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeRMDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment in row-major order, converting each element
     * from {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(MemorySegment src) { return loadRMDouble(0L, src); }

    /**
     * Load the elements from the given memory segment in row-major order, converting each element
     * from {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadRMDouble(offset, src);
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
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        dest[_p3] = this.m03;
        dest[_p3 + 1] = this.m13;
        dest[_p3 + 2] = this.m23;
        return dest;
    }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        float _c0 = src[offset];
        float _c4 = src[offset + 1];
        float _c8 = src[offset + 2];
        float _c1 = src[_p1];
        float _c5 = src[_p1 + 1];
        float _c9 = src[_p1 + 2];
        float _c2 = src[_p2];
        float _c6 = src[_p2 + 1];
        float _c10 = src[_p2 + 2];
        float _c3 = src[_p3];
        float _c7 = src[_p3 + 1];
        float _c11 = src[_p3 + 2];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public FloatBuffer storeCMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + 4 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(FloatBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + 4 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + (4 * stride) * 4);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(ByteBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + (4 * stride) * 4);
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
    public Float3x4 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(address, stride);
    }

    /**
     * Store the elements into the given memory segment in column-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeCM(MemorySegment dest, int stride) { return storeCM(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeCM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCM(this, offset, dest, stride);
    }

    /**
     * Load the elements from the given memory segment in column-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(MemorySegment src, int stride) { return loadCM(0L, src, stride); }

    /**
     * Load the elements from the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCM(offset, src, stride);
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
        int _p3 = _p2 + stride;
        dest[offset] = this.m00;
        dest[offset + 1] = this.m10;
        dest[offset + 2] = this.m20;
        dest[_p1] = this.m01;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m21;
        dest[_p2] = this.m02;
        dest[_p2 + 1] = this.m12;
        dest[_p2 + 2] = this.m22;
        dest[_p3] = this.m03;
        dest[_p3 + 1] = this.m13;
        dest[_p3 + 2] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        int _p3 = _p2 + stride;
        float _c0 = (float) src[offset];
        float _c4 = (float) src[offset + 1];
        float _c8 = (float) src[offset + 2];
        float _c1 = (float) src[_p1];
        float _c5 = (float) src[_p1 + 1];
        float _c9 = (float) src[_p1 + 2];
        float _c2 = (float) src[_p2];
        float _c6 = (float) src[_p2 + 1];
        float _c10 = (float) src[_p2 + 2];
        float _c3 = (float) src[_p3];
        float _c7 = (float) src[_p3 + 1];
        float _c11 = (float) src[_p3 + 2];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public DoubleBuffer storeCMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        storeCMAbsolute(pos, buf, stride);
        buf.position(pos + 4 * stride);
        return buf;
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCM(DoubleBuffer buf, int stride) {
        return loadCMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadCMAbsolute(pos, buf, stride);
        buf.position(pos + 4 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return buf
     */
    public ByteBuffer storeCMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        storeCMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (4 * stride) * 8);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(ByteBuffer buf, int stride) {
        return loadCMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMDoubleAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadCMDoubleAbsolute(pos, buf, stride);
        buf.position(pos + (4 * stride) * 8);
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
    public Float3x4 storeCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeCMDoubleUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadCMDoubleUnsafe(address, stride);
    }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeCMDouble(MemorySegment dest, int stride) { return storeCMDouble(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, starting at the given offset, with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeCMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeCMDouble(this, offset, dest, stride);
    }

    /**
     * Load the elements from the given memory segment in column-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(MemorySegment src, int stride) { return loadCMDouble(0L, src, stride); }

    /**
     * Load the elements from the given memory segment in column-major order, converting each
     * element from {@code double}, starting at the given offset, with {@code stride} elements
     * between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadCMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadCMDouble(offset, src, stride);
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
        dest[offset + 3] = this.m03;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p1 + 3] = this.m13;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        dest[_p2 + 3] = this.m23;
        return dest;
    }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = src[offset];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[_p1];
        float _c5 = src[_p1 + 1];
        float _c6 = src[_p1 + 2];
        float _c7 = src[_p1 + 3];
        float _c8 = src[_p2];
        float _c9 = src[_p2 + 1];
        float _c10 = src[_p2 + 2];
        float _c11 = src[_p2 + 3];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(FloatBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(FloatBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(ByteBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf, stride);
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
    public Float3x4 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(address, stride);
    }

    /**
     * Store the elements into the given memory segment in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeRM(MemorySegment dest, int stride) { return storeRM(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in row-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeRM(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRM(this, offset, dest, stride);
    }

    /**
     * Load the elements from the given memory segment in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(MemorySegment src, int stride) { return loadRM(0L, src, stride); }

    /**
     * Load the elements from the given memory segment in row-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRM(offset, src, stride);
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
        dest[offset + 3] = this.m03;
        dest[_p1] = this.m10;
        dest[_p1 + 1] = this.m11;
        dest[_p1 + 2] = this.m12;
        dest[_p1 + 3] = this.m13;
        dest[_p2] = this.m20;
        dest[_p2 + 1] = this.m21;
        dest[_p2 + 2] = this.m22;
        dest[_p2 + 3] = this.m23;
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
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        float _c0 = (float) src[offset];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[_p1];
        float _c5 = (float) src[_p1 + 1];
        float _c6 = (float) src[_p1 + 2];
        float _c7 = (float) src[_p1 + 3];
        float _c8 = (float) src[_p2];
        float _c9 = (float) src[_p2 + 1];
        float _c10 = (float) src[_p2 + 2];
        float _c11 = (float) src[_p2 + 3];
        return new Float3x4(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11);
    }

    /**
     * Store the elements into the given buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRM(DoubleBuffer buf, int stride) {
        return loadRMAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMRelative(DoubleBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadRMAbsolute(pos, buf, stride);
        buf.position(pos + 3 * stride);
        return r;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(ByteBuffer buf, int stride) {
        return loadRMDoubleAbsolute(buf.position(), buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMDoubleAbsolute(index, buf, stride);
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleRelative(ByteBuffer buf, int stride) {
        int pos = buf.position();
        Float3x4 r = loadRMDoubleAbsolute(pos, buf, stride);
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
    public Float3x4 storeRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.storeRMDoubleUnsafe(this, address, stride);
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDoubleUnsafe(long address, int stride) {
        return RAW_OPS.loadRMDoubleUnsafe(address, stride);
    }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeRMDouble(MemorySegment dest, int stride) { return storeRMDouble(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, starting at the given offset, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment storeRMDouble(long offset, MemorySegment dest, int stride) {
        return SEG_OPS.storeRMDouble(this, offset, dest, stride);
    }

    /**
     * Load the elements from the given memory segment in row-major order, converting each element
     * from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(MemorySegment src, int stride) { return loadRMDouble(0L, src, stride); }

    /**
     * Load the elements from the given memory segment in row-major order, converting each element
     * from {@code double}, starting at the given offset, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRMDouble(long offset, MemorySegment src, int stride) {
        return SEG_OPS.loadRMDouble(offset, src, stride);
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
        dest[offset + 12] = this.m03;
        dest[offset + 13] = this.m13;
        dest[offset + 14] = this.m23;
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
    public Float3x4 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM4x4(MemorySegment dest) { return storeCM4x4(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4(this, offset, dest);
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
        dest[offset + 12] = this.m03;
        dest[offset + 13] = this.m13;
        dest[offset + 14] = this.m23;
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
    public Float3x4 storeCM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeCM4x4DoubleUnsafe(this, address);
    }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix, converting each element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM4x4Double(MemorySegment dest) { return storeCM4x4Double(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix, converting each element to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeCM4x4Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeCM4x4Double(this, offset, dest);
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
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
    public Float3x4 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }

    /**
     * Store the elements into the given memory segment in row-major order, identity-extended to a
     * 4x4 matrix.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM4x4(MemorySegment dest) { return storeRM4x4(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, identity-extended to a
     * 4x4 matrix, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM4x4(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4(this, offset, dest);
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
        dest[offset + 3] = this.m03;
        dest[offset + 4] = this.m10;
        dest[offset + 5] = this.m11;
        dest[offset + 6] = this.m12;
        dest[offset + 7] = this.m13;
        dest[offset + 8] = this.m20;
        dest[offset + 9] = this.m21;
        dest[offset + 10] = this.m22;
        dest[offset + 11] = this.m23;
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
    public Float3x4 storeRM4x4DoubleUnsafe(long address) {
        return RAW_OPS.storeRM4x4DoubleUnsafe(this, address);
    }

    /**
     * Store the elements into the given memory segment in row-major order, identity-extended to a
     * 4x4 matrix, converting each element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM4x4Double(MemorySegment dest) { return storeRM4x4Double(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, identity-extended to a
     * 4x4 matrix, converting each element to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeRM4x4Double(long offset, MemorySegment dest) {
        return SEG_OPS.storeRM4x4Double(this, offset, dest);
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store(FloatBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store(int index, FloatBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store(DoubleBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store(int index, DoubleBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer storeRelative(DoubleBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store(ByteBuffer dest) { return storeCM(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store(int index, ByteBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer storeRelative(ByteBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return storeCM(dest); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(long offset, MemorySegment dest) { return storeCM(offset, dest); }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 storeUnsafe(long address) { return storeCMUnsafe(address); }

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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public ByteBuffer storeRelative(ByteBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    public MemorySegment store(long offset, MemorySegment dest, int stride) { return storeCM(offset, dest, stride); }

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    public Float3x4 storeUnsafe(long address, int stride) { return storeCMUnsafe(address, stride); }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(float[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(float[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(FloatBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, FloatBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(FloatBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(double[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(double[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(DoubleBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, DoubleBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(DoubleBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(ByteBuffer src) { return loadCM(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, ByteBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source byte buffer
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(ByteBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(MemorySegment src) { return loadCM(src); }

    /**
     * Load the elements from the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(long offset, MemorySegment src) { return loadCM(offset, src); }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadUnsafe(long address) { return loadCMUnsafe(address); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(float[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(double[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, FloatBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(FloatBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, DoubleBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(DoubleBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(int index, ByteBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadRelative(ByteBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 load(long offset, MemorySegment src, int stride) { return loadCM(offset, src, stride); }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return a new {@code Float3x4} holding the loaded elements
     */
    public static Float3x4 loadUnsafe(long address, int stride) { return loadCMUnsafe(address, stride); }

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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store4x4(FloatBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    public FloatBuffer store4x4(int index, FloatBuffer dest) { return storeCM4x4Absolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store4x4(DoubleBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given buffer in column-major order, identity-extended to a 4x4
     * matrix, converting each element to {@code double}, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    public DoubleBuffer store4x4Relative(DoubleBuffer dest) { return storeCM4x4Relative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4(ByteBuffer dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4(int index, ByteBuffer dest) { return storeCM4x4Absolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, identity-extended to a
     * 4x4 matrix, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    public ByteBuffer store4x4Relative(ByteBuffer dest) { return storeCM4x4Relative(dest); }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store4x4(MemorySegment dest) { return storeCM4x4(dest); }

    /**
     * Store the elements into the given memory segment in column-major order, identity-extended to
     * a 4x4 matrix, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store4x4(long offset, MemorySegment dest) { return storeCM4x4(offset, dest); }

    /**
     * Store the elements into the given raw memory address in column-major order, identity-extended
     * to a 4x4 matrix. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3x4 store4x4Unsafe(long address) { return storeCM4x4Unsafe(address); }
}
