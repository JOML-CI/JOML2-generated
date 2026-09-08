package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link Double3x3} backed by a {@code double[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public class Double3x3Impl implements Double3x3 {

    public double[] data;
    public int properties;
    static final Double3x3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3x3BbOpsUnsafe()
                    : new Double3x3BbOpsApi();
    static final Double3x3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3x3RawOpsUnsafe()
                    : new Double3x3RawOpsApi();

    public Double3x3Impl() {
        data = new double[9];
        data[0] = 1;
        data[4] = 1;
        data[8] = 1;
        properties = Joml.BIT_IDENTITY;
    }

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits. This is a pure query.
     *
     * @return the determined property bits
     */
    public int determineProperties() {
        if (this.data[2] != 0 || this.data[5] != 0 || this.data[8] != 1) return 0;
        if (this.data[0] != 1 || this.data[3] != 0 || this.data[1] != 0 || this.data[4] != 1) return 1;
        if (this.data[6] != 0 || this.data[7] != 0) return 7;
        return 15;
    }

    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    @Override public boolean isIdentity() { return (this.properties & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY; }
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    @Override public boolean isTranslation() { return (this.properties & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION; }
    /** {@return whether this matrix is known to be orthogonal} O(1) read of the cached property bits; conservative. */
    @Override public boolean isOrthogonal() { return (this.properties & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL; }
    /** {@return whether this matrix is known to be affine} O(1) read of the cached property bits; conservative. */
    @Override public boolean isAffine() { return (this.properties & Joml.BIT_AFFINE) == Joml.BIT_AFFINE; }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_identity(int col, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (col) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; _idxSw2 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; _idxSw2 = 0.0; break;
            case 2: _idxSw0 = 0.0; _idxSw1 = 0.0; _idxSw2 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw0;
        dd[1] = _idxSw1;
        dd[2] = _idxSw2;
        return dest;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_translation(int col, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw3;
        double _idxSw4;
        double _idxSw5;
        switch (col) {
            case 0: _idxSw3 = 1.0; _idxSw4 = 0.0; _idxSw5 = 0.0; break;
            case 1: _idxSw3 = 0.0; _idxSw4 = 1.0; _idxSw5 = 0.0; break;
            case 2: _idxSw3 = sd[6]; _idxSw4 = sd[7]; _idxSw5 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw3;
        dd[1] = _idxSw4;
        dd[2] = _idxSw5;
        return dest;
    }


    /**
     * Private body of {@code getColumn}, specialized by runtime matrix properties; reached only
     * through the public {@code getColumn} dispatcher.
     */
    private Double3 getColumn_general(int col, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw6;
        double _idxSw7;
        double _idxSw8;
        switch (col) {
            case 0: _idxSw6 = sd[0]; _idxSw7 = sd[1]; _idxSw8 = sd[2]; break;
            case 1: _idxSw6 = sd[3]; _idxSw7 = sd[4]; _idxSw8 = sd[5]; break;
            case 2: _idxSw6 = sd[6]; _idxSw7 = sd[7]; _idxSw8 = sd[8]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        dd[0] = _idxSw6;
        dd[1] = _idxSw7;
        dd[2] = _idxSw8;
        return dest;
    }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    public Double3 getColumn(int col, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getColumn_identity(col, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getColumn_translation(col, dest);
        return getColumn_general(col, dest);
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Double3 getEulerAnglesXYZ_identity(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Double3 getEulerAnglesXYZ_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(sd[7], sd[7], 1.0) < Math.fma(sd[7], sd[7], Math.fma(sd[6], sd[6], 1.0)) * 1.0E-15 ? 0.0 : Math.atan2(-sd[7], 1.0);
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, sd[6])));
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesXYZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXYZ} dispatcher.
     */
    private Double3 getEulerAnglesXYZ_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[7], sd[7], sd[8] * sd[8]);
        double _t3 = Math.fma(sd[6], sd[6], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = Math.atan2(sd[5], sd[4]);
            dd[2] = 0.0;
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(-sd[7], sd[8]);
            dd[2] = Math.atan2(-sd[3], sd[0]);
            dd[0] = _buf0;
        }
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, sd[6])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXYZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXYZ_translation(dest);
        return getEulerAnglesXYZ_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Double3 getEulerAnglesXZY_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Double3 getEulerAnglesXZY_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        if (1.0 < 1.0E-15) {
            dd[0] = Math.atan2(-sd[7], 1.0);
            dd[1] = 0.0;
        } else {
            dd[0] = 0.0;
            dd[1] = Math.atan2(sd[6], 1.0);
        }
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesXZY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesXZY} dispatcher.
     */
    private Double3 getEulerAnglesXZY_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[4], sd[4], sd[5] * sd[5]);
        double _t3 = Math.fma(sd[3], sd[3], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = Math.atan2(-sd[7], sd[8]);
            double _buf1 = 0.0;
            dd[0] = _buf0;
            dd[1] = _buf1;
        } else {
            double _buf0 = Math.atan2(sd[5], sd[4]);
            double _buf1 = Math.atan2(sd[6], sd[0]);
            dd[0] = _buf0;
            dd[1] = _buf1;
        }
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, -sd[3])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesXZY_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesXZY_translation(dest);
        return getEulerAnglesXZY_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Double3 getEulerAnglesYXZ_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Double3 getEulerAnglesYXZ_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, -sd[7])));
        dd[1] = Math.fma(sd[6], sd[6], 1.0) < Math.fma(sd[6], sd[6], Math.fma(sd[7], sd[7], 1.0)) * 1.0E-15 ? 0.0 : Math.atan2(sd[6], 1.0);
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesYXZ}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYXZ} dispatcher.
     */
    private Double3 getEulerAnglesYXZ_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[6], sd[6], sd[8] * sd[8]);
        double _t3 = Math.fma(sd[7], sd[7], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            dd[1] = Math.atan2(-sd[2], sd[0]);
            dd[2] = 0.0;
        } else {
            dd[1] = Math.atan2(sd[6], sd[8]);
            dd[2] = Math.atan2(sd[1], sd[4]);
        }
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, -sd[7])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYXZ_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYXZ_translation(dest);
        return getEulerAnglesYXZ_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Double3 getEulerAnglesYZX_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Double3 getEulerAnglesYZX_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = Math.fma(sd[7], sd[7], 1.0);
        double _t1 = _t0 * 1.0E-15;
        if (_t0 < _t1) {
            dd[0] = 0.0;
            dd[1] = Math.atan2(sd[6], 1.0);
        } else {
            dd[0] = Math.atan2(-sd[7], 1.0);
            dd[1] = 0.0;
        }
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesYZX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesYZX} dispatcher.
     */
    private Double3 getEulerAnglesYZX_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[4], sd[4], sd[7] * sd[7]);
        double _t3 = Math.fma(sd[1], sd[1], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            dd[1] = Math.atan2(sd[6], sd[8]);
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(-sd[7], sd[4]);
            dd[1] = Math.atan2(-sd[2], sd[0]);
            dd[0] = _buf0;
        }
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, sd[1])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getEulerAnglesYZX_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesYZX_translation(dest);
        return getEulerAnglesYZX_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Double3 getEulerAnglesZXY_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Double3 getEulerAnglesZXY_orthogonal(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[3], sd[3], sd[4] * sd[4]);
        double _buf0 = 0.0;
        double _buf1 = 0.0;
        dd[2] = _t1 < _t1 * 1.0E-15 ? Math.atan2(sd[1], sd[0]) : Math.atan2(-sd[3], sd[4]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesZXY}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZXY} dispatcher.
     */
    private Double3 getEulerAnglesZXY_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[3], sd[3], sd[4] * sd[4]);
        double _t3 = Math.fma(sd[5], sd[5], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(sd[1], sd[0]);
            dd[1] = _buf0;
        } else {
            double _buf0 = Math.atan2(-sd[2], sd[8]);
            dd[2] = Math.atan2(-sd[3], sd[4]);
            dd[1] = _buf0;
        }
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, sd[5])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZXY_identity(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getEulerAnglesZXY_orthogonal(dest);
        return getEulerAnglesZXY_general(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Double3 getEulerAnglesZYX_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Double3 getEulerAnglesZYX_orthogonal(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 0.0;
        double _buf1 = 0.0;
        dd[2] = 1.0 < 1.0E-15 ? Math.atan2(-sd[3], sd[4]) : Math.atan2(sd[1], sd[0]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Private body of {@code getEulerAnglesZYX}, specialized by runtime matrix properties; reached
     * only through the public {@code getEulerAnglesZYX} dispatcher.
     */
    private Double3 getEulerAnglesZYX_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = Math.fma(sd[5], sd[5], sd[8] * sd[8]);
        double _t3 = Math.fma(sd[2], sd[2], _t1) * 1.0E-15;
        if (_t1 < _t3) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(-sd[3], sd[4]);
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(sd[5], sd[8]);
            dd[2] = Math.atan2(sd[1], sd[0]);
            dd[0] = _buf0;
        }
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, -sd[2])));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getEulerAnglesZYX_identity(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getEulerAnglesZYX_orthogonal(dest);
        return getEulerAnglesZYX_general(dest);
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private DoubleQuat getNormalizedRotation_identity(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        return dest;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private DoubleQuat getNormalizedRotation_translation(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t1 = Math.fma(sd[6], sd[6], Math.fma(sd[7], sd[7], 1.0));
        double _t2 = (1.0 / Math.sqrt(_t1));
        double _t5, _t8, _t9;
        if (_t1 > 0.0) {
            _t5 = _t2;
            _t8 = sd[7] * _t2;
            _t9 = sd[6] * _t2;
        } else {
            _t5 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t6 = Math.max(1.0, _t5);
        double _t10 = _t5 < 0.0 ? -1.0 : 1.0;
        double _t11 = 1.0 + _t10;
        double _t13 = _t11 + _t5;
        double _t17 = 1.0 + _t13;
        double _t18 = 1.0 + (_t10 - (1.0 + _t5));
        double _t19 = 1.0 + (_t5 - _t11);
        double _t20 = 1.0 + (1.0 - (_t10 + _t5));
        double _t21 = (1.0 / Math.sqrt(_t17));
        double _t22 = (1.0 / Math.sqrt(_t19));
        double _t23 = (1.0 / Math.sqrt(_t18));
        double _t24 = (1.0 / Math.sqrt(_t20));
        if (_t13 > 0.0) {
            dd[0] = -(0.5 * _t21 * _t8);
            dd[1] = 0.5 * _t21 * _t9;
            dd[2] = 0.0;
            dd[3] = 0.5 * Math.sqrt(_t17);
        } else {
            if (_t10 > _t6) {
                dd[0] = 0.5 * Math.sqrt(_t18);
                dd[1] = 0.0;
                dd[2] = 0.5 * _t23 * _t9;
                dd[3] = -(0.5 * _t23 * _t8);
            } else {
                if (1.0 > _t5) {
                    dd[0] = 0.0;
                    dd[1] = 0.5 * Math.sqrt(_t20);
                    dd[2] = 0.5 * _t24 * _t8;
                    dd[3] = 0.5 * _t24 * _t9;
                } else {
                    dd[0] = 0.5 * _t22 * _t9;
                    dd[1] = 0.5 * _t22 * _t8;
                    dd[2] = 0.5 * Math.sqrt(_t19);
                    dd[3] = 0.0;
                }
            }
        }
        return dest;
    }


    /**
     * Private body of {@code getNormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getNormalizedRotation} dispatcher.
     */
    private DoubleQuat getNormalizedRotation_general(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t6 = Math.fma(sd[5], sd[5], Math.fma(sd[3], sd[3], sd[4] * sd[4]));
        double _t7 = Math.fma(sd[8], sd[8], Math.fma(sd[6], sd[6], sd[7] * sd[7]));
        double _t8 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t9 = (1.0 / Math.sqrt(_t6));
        double _t10 = (1.0 / Math.sqrt(_t7));
        double _t11 = (1.0 / Math.sqrt(_t8));
        double _t21, _t23, _t27;
        if (_t6 > 0.0) {
            _t21 = sd[3] * _t9;
            _t23 = sd[4] * _t9;
            _t27 = sd[5] * _t9;
        } else {
            _t21 = 0.0;
            _t23 = 0.0;
            _t27 = 0.0;
        }
        double _t22, _t24, _t26;
        if (_t7 > 0.0) {
            _t22 = sd[7] * _t10;
            _t24 = sd[6] * _t10;
            _t26 = sd[8] * _t10;
        } else {
            _t22 = 0.0;
            _t24 = 0.0;
            _t26 = 0.0;
        }
        double _t25, _t28, _t29;
        if (_t8 > 0.0) {
            _t25 = sd[2] * _t11;
            _t28 = sd[0] * _t11;
            _t29 = sd[1] * _t11;
        } else {
            _t25 = 0.0;
            _t28 = 0.0;
            _t29 = 0.0;
        }
        double _t36 = _t27 - _t22;
        double _t37 = Math.max(_t23, _t26);
        double _t39 = _t27 + _t22;
        double _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        double _t49, _t50, _t51;
        if (_t48 < 0.0) {
            _t49 = -_t28;
            _t50 = -_t29;
            _t51 = -_t25;
        } else {
            _t49 = _t28;
            _t50 = _t29;
            _t51 = _t25;
        }
        double _t52 = _t49 + _t23;
        double _t53 = _t50 + _t21;
        double _t55 = _t51 + _t24;
        double _t56 = _t24 - _t51;
        double _t57 = _t50 - _t21;
        double _t58 = _t52 + _t26;
        double _t62 = 1.0 + _t58;
        double _t63 = 1.0 + (_t49 - (_t23 + _t26));
        double _t64 = 1.0 + (_t23 - (_t49 + _t26));
        double _t65 = 1.0 + (_t26 - _t52);
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t64));
        double _t68 = (1.0 / Math.sqrt(_t65));
        double _t69 = (1.0 / Math.sqrt(_t63));
        if (_t58 > 0.0) {
            dd[0] = 0.5 * _t36 * _t66;
            dd[1] = 0.5 * _t56 * _t66;
            dd[2] = 0.5 * _t57 * _t66;
            dd[3] = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t49 > _t37) {
                dd[0] = 0.5 * Math.sqrt(_t63);
                dd[1] = 0.5 * _t53 * _t69;
                dd[2] = 0.5 * _t55 * _t69;
                dd[3] = 0.5 * _t36 * _t69;
            } else {
                if (_t23 > _t26) {
                    dd[0] = 0.5 * _t53 * _t67;
                    dd[1] = 0.5 * Math.sqrt(_t64);
                    dd[2] = 0.5 * _t39 * _t67;
                    dd[3] = 0.5 * _t56 * _t67;
                } else {
                    dd[0] = 0.5 * _t55 * _t68;
                    dd[1] = 0.5 * _t39 * _t68;
                    dd[2] = 0.5 * Math.sqrt(_t65);
                    dd[3] = 0.5 * _t57 * _t68;
                }
            }
        }
        return dest;
    }


    /**
     * Extract the rotation of this matrix as a unit quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getNormalizedRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getNormalizedRotation_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getNormalizedRotation_translation(dest);
        return getNormalizedRotation_general(dest);
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_identity(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw0;
        double _idxSw1;
        double _idxSw2;
        switch (row) {
            case 0: _idxSw0 = 1.0; _idxSw1 = 0.0; _idxSw2 = 0.0; break;
            case 1: _idxSw0 = 0.0; _idxSw1 = 1.0; _idxSw2 = 0.0; break;
            case 2: _idxSw0 = 0.0; _idxSw1 = 0.0; _idxSw2 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw0;
        dd[1] = _idxSw1;
        dd[2] = _idxSw2;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_translation(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw3;
        double _idxSw4;
        double _idxSw5;
        switch (row) {
            case 0: _idxSw3 = 1.0; _idxSw4 = 0.0; _idxSw5 = sd[6]; break;
            case 1: _idxSw3 = 0.0; _idxSw4 = 1.0; _idxSw5 = sd[7]; break;
            case 2: _idxSw3 = 0.0; _idxSw4 = 0.0; _idxSw5 = 1.0; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw3;
        dd[1] = _idxSw4;
        dd[2] = _idxSw5;
        return dest;
    }


    /**
     * Private body of {@code getRow}, specialized by runtime matrix properties; reached only
     * through the public {@code getRow} dispatcher.
     */
    private Double3 getRow_general(int row, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _idxSw6;
        double _idxSw7;
        double _idxSw8;
        switch (row) {
            case 0: _idxSw6 = sd[0]; _idxSw7 = sd[3]; _idxSw8 = sd[6]; break;
            case 1: _idxSw6 = sd[1]; _idxSw7 = sd[4]; _idxSw8 = sd[7]; break;
            case 2: _idxSw6 = sd[2]; _idxSw7 = sd[5]; _idxSw8 = sd[8]; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        dd[0] = _idxSw6;
        dd[1] = _idxSw7;
        dd[2] = _idxSw8;
        return dest;
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
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getRow_identity(row, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getRow_translation(row, dest);
        return getRow_general(row, dest);
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Double3 getScale_identity(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 1.0;
        dd[2] = 1.0;
        return dest;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Double3 getScale_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 1.0;
        dd[2] = Math.sqrt(Math.fma(sd[6], sd[6], Math.fma(sd[7], sd[7], 1.0)));
        return dest;
    }


    /**
     * Private body of {@code getScale}, specialized by runtime matrix properties; reached only
     * through the public {@code getScale} dispatcher.
     */
    private Double3 getScale_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        dd[1] = Math.sqrt(Math.fma(sd[5], sd[5], Math.fma(sd[3], sd[3], sd[4] * sd[4])));
        dd[2] = Math.sqrt(Math.fma(sd[8], sd[8], Math.fma(sd[6], sd[6], sd[7] * sd[7])));
        return dest;
    }


    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getScale(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getScale_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getScale_translation(dest);
        return getScale_general(dest);
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double2 getTranslation_identity(@Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code getTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code getTranslation} dispatcher.
     */
    private Double2 getTranslation_general(@Mutated Double2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        return dest;
    }


    /**
     * Get the translation of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2 getTranslation(@Mutated Double2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getTranslation_identity(dest);
        return getTranslation_general(dest);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_identity(@Mutated DoubleQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_translation(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = -(0.25 * sd[7]);
        dd[1] = 0.25 * sd[6];
        dd[2] = 0.0;
        dd[3] = 1.0;
        return dest;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_orthogonal(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = Math.max(sd[4], 1.0);
        double _t3 = sd[0] + sd[4];
        double _t4 = sd[3] + sd[1];
        double _t5 = sd[1] - sd[3];
        double _t6 = 1.0 + _t3;
        double _t10 = 1.0 + _t6;
        double _t11 = 1.0 + (sd[0] - (1.0 + sd[4]));
        double _t12 = 1.0 + (sd[4] - (1.0 + sd[0]));
        double _t13 = 1.0 + (1.0 - _t3);
        double _t14 = (1.0 / Math.sqrt(_t10));
        double _t15 = (1.0 / Math.sqrt(_t12));
        double _t16 = (1.0 / Math.sqrt(_t13));
        double _t17 = (1.0 / Math.sqrt(_t11));
        if (_t6 > 0.0) {
            double _buf0 = -(0.5 * sd[7] * _t14);
            dd[1] = 0.5 * sd[6] * _t14;
            double _buf1 = 0.5 * _t5 * _t14;
            dd[3] = 0.5 * Math.sqrt(_t10);
            dd[0] = _buf0;
            dd[2] = _buf1;
        } else {
            if (sd[0] > _t0) {
                double _buf0 = 0.5 * Math.sqrt(_t11);
                dd[1] = 0.5 * _t4 * _t17;
                double _buf1 = 0.5 * sd[6] * _t17;
                dd[3] = -(0.5 * sd[7] * _t17);
                dd[0] = _buf0;
                dd[2] = _buf1;
            } else {
                if (sd[4] > 1.0) {
                    double _buf0 = 0.5 * _t4 * _t15;
                    dd[1] = 0.5 * Math.sqrt(_t12);
                    double _buf1 = 0.5 * sd[7] * _t15;
                    dd[3] = 0.5 * sd[6] * _t15;
                    dd[0] = _buf0;
                    dd[2] = _buf1;
                } else {
                    double _buf0 = 0.5 * sd[6] * _t16;
                    dd[1] = 0.5 * sd[7] * _t16;
                    double _buf1 = 0.5 * Math.sqrt(_t13);
                    dd[3] = 0.5 * _t5 * _t16;
                    dd[0] = _buf0;
                    dd[2] = _buf1;
                }
            }
        }
        return dest;
    }


    /**
     * Private body of {@code getUnnormalizedRotation}, specialized by runtime matrix properties;
     * reached only through the public {@code getUnnormalizedRotation} dispatcher.
     */
    private DoubleQuat getUnnormalizedRotation_general(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = sd[0] + sd[4];
        double _t1 = sd[5] - sd[7];
        double _t2 = Math.max(sd[4], sd[8]);
        double _t4 = sd[3] + sd[1];
        double _t6 = sd[6] + sd[2];
        double _t7 = sd[6] - sd[2];
        double _t8 = sd[7] + sd[5];
        double _t9 = sd[1] - sd[3];
        double _t10 = sd[8] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (sd[0] - (sd[4] + sd[8]));
        double _t16 = 1.0 + (sd[4] - (sd[0] + sd[8]));
        double _t17 = 1.0 + (sd[8] - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            double _buf0 = 0.5 * _t1 * _t18;
            dd[1] = 0.5 * _t7 * _t18;
            dd[2] = 0.5 * _t9 * _t18;
            dd[3] = 0.5 * Math.sqrt(_t14);
            dd[0] = _buf0;
        } else {
            if (sd[0] > _t2) {
                double _buf0 = 0.5 * Math.sqrt(_t15);
                dd[1] = 0.5 * _t4 * _t21;
                dd[2] = 0.5 * _t6 * _t21;
                dd[3] = 0.5 * _t1 * _t21;
                dd[0] = _buf0;
            } else {
                if (sd[4] > sd[8]) {
                    double _buf0 = 0.5 * _t4 * _t19;
                    dd[1] = 0.5 * Math.sqrt(_t16);
                    dd[2] = 0.5 * _t8 * _t19;
                    dd[3] = 0.5 * _t7 * _t19;
                    dd[0] = _buf0;
                } else {
                    double _buf0 = 0.5 * _t6 * _t20;
                    dd[1] = 0.5 * _t8 * _t20;
                    dd[2] = 0.5 * Math.sqrt(_t17);
                    dd[3] = 0.5 * _t9 * _t20;
                    dd[0] = _buf0;
                }
            }
        }
        return dest;
    }


    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getUnnormalizedRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return getUnnormalizedRotation_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return getUnnormalizedRotation_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return getUnnormalizedRotation_orthogonal(dest);
        return getUnnormalizedRotation_general(dest);
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        ((Double3x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = -sd[6];
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = -sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[2] = -sd[6];
        dd[5] = -sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[2] = Math.fma(-sd[6], sd[4], -(sd[1] * sd[7]));
        dd[3] = -sd[1];
        double _buf1 = sd[4];
        dd[5] = Math.fma(sd[6], sd[1], -(sd[4] * sd[7]));
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code cofactor}, specialized by runtime matrix
     * properties; reached only through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[2] = Math.fma(-sd[6], sd[4], -(sd[1] * sd[7]));
        dd[3] = -sd[1];
        double _buf1 = sd[4];
        dd[5] = Math.fma(sd[6], sd[1], -(sd[4] * sd[7]));
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[4];
        double _buf1 = -sd[3];
        dd[2] = Math.fma(sd[3], sd[7], -(sd[6] * sd[4]));
        double _buf2 = -sd[1];
        double _buf3 = sd[0];
        dd[5] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7]));
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code cofactor}, specialized by runtime matrix properties; reached only
     * through the public {@code cofactor} dispatcher.
     */
    private Double3x3 cofactor_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(sd[4], sd[8], -(sd[7] * sd[5]));
        double _buf1 = Math.fma(sd[6], sd[5], -(sd[3] * sd[8]));
        double _buf2 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4]));
        double _buf3 = Math.fma(sd[7], sd[2], -(sd[1] * sd[8]));
        double _buf4 = Math.fma(sd[0], sd[8], -(sd[6] * sd[2]));
        double _buf5 = Math.fma(sd[6], sd[1], -(sd[0] * sd[7]));
        dd[6] = Math.fma(sd[1], sd[5], -(sd[4] * sd[2]));
        dd[7] = Math.fma(sd[3], sd[2], -(sd[0] * sd[5]));
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 cofactor(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return cofactor_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine(dest);
        return cofactor_general(dest);
    }


    /**
     * Compute the cofactor matrix of this matrix.
     *
     * @return this
     */
    @Mutated public Double3x3 cofactor() {
        if (Joml.RETURN_NEW) return cofactor(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return cofactor_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return cofactor_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return cofactor_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return cofactor_affine(this);
        return cofactor_general(this);
    }


    /**
     * Compute the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    public double determinant() {
        double[] sd = this.data;
        return Math.fma(sd[6], Math.fma(sd[1], sd[5], -(sd[4] * sd[2])), Math.fma(sd[0], Math.fma(sd[4], sd[8], -(sd[7] * sd[5])), -(sd[3] * Math.fma(sd[1], sd[8], -(sd[7] * sd[2])))));
    }


    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    public double frobeniusNorm() {
        double[] sd = this.data;
        return Math.sqrt(Math.fma(sd[0], sd[0], sd[3] * sd[3]) + Math.fma(sd[6], sd[6], sd[1] * sd[1]) + (Math.fma(sd[4], sd[4], sd[7] * sd[7]) + Math.fma(sd[2], sd[2], Math.fma(sd[5], sd[5], sd[8] * sd[8]))));
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_identity(@Mutated Double3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_identity_self(@Mutated Double3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = -sd[1];
        dd[2] = 0.0;
        dd[3] = sd[1];
        double _buf1 = sd[4];
        dd[5] = 0.0;
        double _buf2 = Math.fma(-sd[6], sd[4], -(sd[1] * sd[7]));
        dd[7] = Math.fma(sd[6], sd[1], -(sd[4] * sd[7]));
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = -sd[1];
        dd[3] = sd[1];
        double _buf1 = sd[4];
        double _buf2 = Math.fma(-sd[6], sd[4], -(sd[1] * sd[7]));
        dd[7] = Math.fma(sd[6], sd[1], -(sd[4] * sd[7]));
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[4] * _t2_inv;
        double _buf1 = -(sd[1] * _t2_inv);
        dd[2] = 0.0;
        double _buf2 = -(sd[3] * _t2_inv);
        double _buf3 = sd[0] * _t2_inv;
        dd[5] = 0.0;
        double _buf4 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t2_inv;
        dd[7] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t2_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code invert}, specialized by runtime matrix properties;
     * reached only through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[4] * _t2_inv;
        double _buf1 = -(sd[1] * _t2_inv);
        double _buf2 = -(sd[3] * _t2_inv);
        double _buf3 = sd[0] * _t2_inv;
        double _buf4 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t2_inv;
        dd[7] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t2_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code invert}, specialized by runtime matrix properties; reached only
     * through the public {@code invert} dispatcher.
     */
    private Double3x3 invert_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t6 = Math.fma(sd[4], sd[8], -(sd[7] * sd[5]));
        double _t7 = Math.fma(sd[1], sd[5], -(sd[4] * sd[2]));
        double _t12 = Math.fma(sd[6], _t7, Math.fma(sd[0], _t6, -(sd[3] * Math.fma(sd[1], sd[8], -(sd[7] * sd[2])))));
        double _t12_inv = 1.0 / _t12;
        double _buf0 = _t6 * _t12_inv;
        double _buf1 = Math.fma(sd[7], sd[2], -(sd[1] * sd[8])) * _t12_inv;
        double _buf2 = _t7 * _t12_inv;
        double _buf3 = Math.fma(sd[6], sd[5], -(sd[3] * sd[8])) * _t12_inv;
        double _buf4 = Math.fma(sd[0], sd[8], -(sd[6] * sd[2])) * _t12_inv;
        dd[5] = Math.fma(sd[3], sd[2], -(sd[0] * sd[5])) * _t12_inv;
        double _buf5 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t12_inv;
        dd[7] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t12_inv;
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1])) * _t12_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[6] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Invert this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invert(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine(dest);
        return invert_general(dest);
    }


    /**
     * Invert this matrix.
     *
     * @return this
     */
    @Mutated public Double3x3 invert() {
        if (Joml.RETURN_NEW) return invert(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invert_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invert_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return invert_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invert_affine_self(this);
        return invert_general(this);
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_general(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t18 = Math.fma(otherData[5], sd[7], Math.fma(otherData[3], sd[1], otherData[4] * sd[4]));
        double _t19 = Math.fma(otherData[8], sd[8], Math.fma(otherData[6], sd[2], otherData[7] * sd[5]));
        double _t20 = Math.fma(otherData[5], sd[8], Math.fma(otherData[3], sd[2], otherData[4] * sd[5]));
        double _t21 = Math.fma(otherData[8], sd[7], Math.fma(otherData[6], sd[1], otherData[7] * sd[4]));
        double _t22 = Math.fma(otherData[8], sd[6], Math.fma(otherData[6], sd[0], otherData[7] * sd[3]));
        double _t23 = Math.fma(otherData[2], sd[7], Math.fma(otherData[0], sd[1], otherData[1] * sd[4]));
        double _t24 = Math.fma(otherData[2], sd[8], Math.fma(otherData[0], sd[2], otherData[1] * sd[5]));
        double _t25 = Math.fma(otherData[2], sd[6], Math.fma(otherData[0], sd[0], otherData[1] * sd[3]));
        double _t26 = Math.fma(otherData[5], sd[6], Math.fma(otherData[3], sd[0], otherData[4] * sd[3]));
        double _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        double _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        double _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        double _t39_inv = 1.0 / _t39;
        dd[0] = _t33 * _t39_inv;
        dd[1] = Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv;
        dd[2] = _t34 * _t39_inv;
        dd[3] = Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv;
        dd[4] = Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv;
        dd[5] = Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv;
        dd[6] = Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv;
        dd[7] = Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv;
        dd[8] = Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t6 = Math.fma(otherData[4], otherData[8], -(otherData[7] * otherData[5]));
        double _t7 = Math.fma(otherData[1], otherData[5], -(otherData[4] * otherData[2]));
        double _t12 = Math.fma(otherData[6], _t7, Math.fma(otherData[0], _t6, -(otherData[3] * Math.fma(otherData[1], otherData[8], -(otherData[7] * otherData[2])))));
        double _t12_inv = 1.0 / _t12;
        double _buf0 = _t6 * _t12_inv;
        double _buf1 = Math.fma(otherData[7], otherData[2], -(otherData[1] * otherData[8])) * _t12_inv;
        double _buf2 = _t7 * _t12_inv;
        double _buf3 = Math.fma(otherData[6], otherData[5], -(otherData[3] * otherData[8])) * _t12_inv;
        double _buf4 = Math.fma(otherData[0], otherData[8], -(otherData[6] * otherData[2])) * _t12_inv;
        dd[5] = Math.fma(otherData[3], otherData[2], -(otherData[0] * otherData[5])) * _t12_inv;
        double _buf5 = Math.fma(otherData[3], otherData[7], -(otherData[6] * otherData[4])) * _t12_inv;
        dd[7] = Math.fma(otherData[6], otherData[1], -(otherData[0] * otherData[7])) * _t12_inv;
        dd[8] = Math.fma(otherData[0], otherData[4], -(otherData[3] * otherData[1])) * _t12_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[6] = _buf5;
        ((Double3x3Impl) dest).properties = ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.fma(otherData[5], sd[7], otherData[4]);
        double _t1 = Math.fma(otherData[8], sd[7], otherData[7]);
        double _t2 = Math.fma(otherData[8], sd[6], otherData[6]);
        double _t3 = Math.fma(otherData[2], sd[7], otherData[1]);
        double _t4 = Math.fma(otherData[2], sd[6], otherData[0]);
        double _t5 = Math.fma(otherData[5], sd[6], otherData[3]);
        double _t12 = Math.fma(otherData[8], _t0, -(otherData[5] * _t1));
        double _t13 = Math.fma(otherData[5], _t3, -(otherData[2] * _t0));
        double _t18 = Math.fma(_t2, _t13, Math.fma(_t4, _t12, -(_t5 * Math.fma(otherData[8], _t3, -(otherData[2] * _t1)))));
        double _t18_inv = 1.0 / _t18;
        dd[0] = _t12 * _t18_inv;
        dd[1] = Math.fma(otherData[2], _t1, -(otherData[8] * _t3)) * _t18_inv;
        double _buf0 = _t13 * _t18_inv;
        dd[3] = Math.fma(otherData[5], _t2, -(otherData[8] * _t5)) * _t18_inv;
        dd[4] = Math.fma(otherData[8], _t4, -(otherData[2] * _t2)) * _t18_inv;
        dd[5] = Math.fma(otherData[2], _t5, -(otherData[5] * _t4)) * _t18_inv;
        dd[6] = Math.fma(_t5, _t1, -(_t2 * _t0)) * _t18_inv;
        dd[7] = Math.fma(_t2, _t3, -(_t4 * _t1)) * _t18_inv;
        dd[8] = Math.fma(_t4, _t0, -(_t5 * _t3)) * _t18_inv;
        dd[2] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_orthogonal(Double3x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t12 = Math.fma(otherData[5], sd[7], Math.fma(otherData[3], sd[1], otherData[4] * sd[4]));
        double _t13 = Math.fma(otherData[8], sd[7], Math.fma(otherData[6], sd[1], otherData[7] * sd[4]));
        double _t14 = Math.fma(otherData[8], sd[6], Math.fma(otherData[6], sd[0], otherData[7] * sd[3]));
        double _t15 = Math.fma(otherData[2], sd[7], Math.fma(otherData[0], sd[1], otherData[1] * sd[4]));
        double _t16 = Math.fma(otherData[2], sd[6], Math.fma(otherData[0], sd[0], otherData[1] * sd[3]));
        double _t17 = Math.fma(otherData[5], sd[6], Math.fma(otherData[3], sd[0], otherData[4] * sd[3]));
        double _t24 = Math.fma(otherData[8], _t12, -(otherData[5] * _t13));
        double _t25 = Math.fma(otherData[5], _t15, -(otherData[2] * _t12));
        double _t30 = Math.fma(_t14, _t25, Math.fma(_t16, _t24, -(_t17 * Math.fma(otherData[8], _t15, -(otherData[2] * _t13)))));
        double _t30_inv = 1.0 / _t30;
        dd[0] = _t24 * _t30_inv;
        dd[1] = Math.fma(otherData[2], _t13, -(otherData[8] * _t15)) * _t30_inv;
        double _buf0 = _t25 * _t30_inv;
        dd[3] = Math.fma(otherData[5], _t14, -(otherData[8] * _t17)) * _t30_inv;
        dd[4] = Math.fma(otherData[8], _t16, -(otherData[2] * _t14)) * _t30_inv;
        dd[5] = Math.fma(otherData[2], _t17, -(otherData[5] * _t16)) * _t30_inv;
        dd[6] = Math.fma(_t17, _t13, -(_t12 * _t14)) * _t30_inv;
        dd[7] = Math.fma(_t15, _t14, -(_t16 * _t13)) * _t30_inv;
        dd[8] = Math.fma(_t16, _t12, -(_t15 * _t17)) * _t30_inv;
        dd[2] = _buf0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_identity_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_identity_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -otherData[6];
        dd[7] = -otherData[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_identity_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(otherData[0], otherData[4], -(otherData[3] * otherData[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = otherData[4] * _t2_inv;
        double _buf1 = -(otherData[1] * _t2_inv);
        dd[2] = 0.0;
        double _buf2 = -(otherData[3] * _t2_inv);
        double _buf3 = otherData[0] * _t2_inv;
        dd[5] = 0.0;
        double _buf4 = Math.fma(otherData[3], otherData[7], -(otherData[6] * otherData[4])) * _t2_inv;
        dd[7] = Math.fma(otherData[6], otherData[1], -(otherData[0] * otherData[7])) * _t2_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_translation_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_translation_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -(otherData[6] + sd[6]);
        dd[7] = -(otherData[7] + sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_translation_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t1 = otherData[7] + sd[7];
        double _t2 = otherData[6] + sd[6];
        double _t4 = Math.fma(otherData[0], otherData[4], -(otherData[3] * otherData[1]));
        double _t4_inv = 1.0 / _t4;
        double _buf0 = otherData[4] * _t4_inv;
        double _buf1 = -(otherData[1] * _t4_inv);
        dd[2] = 0.0;
        double _buf2 = -(otherData[3] * _t4_inv);
        double _buf3 = otherData[0] * _t4_inv;
        dd[5] = 0.0;
        dd[6] = Math.fma(otherData[3], _t1, -(otherData[4] * _t2)) * _t4_inv;
        dd[7] = Math.fma(otherData[1], _t2, -(otherData[0] * _t1)) * _t4_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_orthogonal_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = -sd[1];
        dd[2] = 0.0;
        dd[3] = sd[1];
        double _buf1 = sd[4];
        dd[5] = 0.0;
        double _buf2 = Math.fma(-sd[6], sd[4], -(sd[1] * sd[7]));
        dd[7] = Math.fma(sd[6], sd[1], -(sd[4] * sd[7]));
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_orthogonal_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = -sd[1];
        dd[0] = sd[4];
        double _buf0 = _t0;
        dd[2] = 0.0;
        dd[3] = sd[1];
        double _buf1 = sd[4];
        dd[5] = 0.0;
        double _buf2 = Math.fma(_t0, sd[7], Math.fma(-sd[6], sd[4], -otherData[6]));
        dd[7] = Math.fma(sd[6], sd[1], Math.fma(-sd[4], sd[7], -otherData[7]));
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_orthogonal_affine(Double3x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t6 = Math.fma(otherData[3], sd[1], otherData[4] * sd[4]);
        double _t7 = Math.fma(otherData[0], sd[0], otherData[1] * sd[3]);
        double _t8 = Math.fma(otherData[0], sd[1], otherData[1] * sd[4]);
        double _t9 = Math.fma(otherData[3], sd[0], otherData[4] * sd[3]);
        double _t10 = Math.fma(otherData[6], sd[1], Math.fma(otherData[7], sd[4], sd[7]));
        double _t11 = Math.fma(otherData[6], sd[0], Math.fma(otherData[7], sd[3], sd[6]));
        double _t14 = Math.fma(_t7, _t6, -(_t8 * _t9));
        double _t14_inv = 1.0 / _t14;
        dd[0] = _t6 * _t14_inv;
        dd[1] = -(_t8 * _t14_inv);
        dd[2] = 0.0;
        dd[3] = -(_t9 * _t14_inv);
        dd[4] = _t7 * _t14_inv;
        dd[5] = 0.0;
        dd[6] = Math.fma(_t10, _t9, -(_t11 * _t6)) * _t14_inv;
        dd[7] = Math.fma(_t11, _t8, -(_t10 * _t7)) * _t14_inv;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_affine_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[4] * _t2_inv;
        double _buf1 = -(sd[1] * _t2_inv);
        dd[2] = 0.0;
        double _buf2 = -(sd[3] * _t2_inv);
        double _buf3 = sd[0] * _t2_inv;
        dd[5] = 0.0;
        double _buf4 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t2_inv;
        dd[7] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t2_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_affine_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t4 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t4_inv = 1.0 / _t4;
        double _t5 = Math.fma(otherData[6], sd[1], Math.fma(otherData[7], sd[4], sd[7]));
        double _t6 = Math.fma(otherData[6], sd[0], Math.fma(otherData[7], sd[3], sd[6]));
        double _buf0 = sd[4] * _t4_inv;
        double _buf1 = -(sd[1] * _t4_inv);
        dd[2] = 0.0;
        double _buf2 = -(sd[3] * _t4_inv);
        double _buf3 = sd[0] * _t4_inv;
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[3], _t5, -(sd[4] * _t6)) * _t4_inv;
        dd[7] = Math.fma(sd[1], _t6, -(sd[0] * _t5)) * _t4_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_general_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t6 = Math.fma(sd[4], sd[8], -(sd[7] * sd[5]));
        double _t7 = Math.fma(sd[1], sd[5], -(sd[4] * sd[2]));
        double _t12 = Math.fma(sd[6], _t7, Math.fma(sd[0], _t6, -(sd[3] * Math.fma(sd[1], sd[8], -(sd[7] * sd[2])))));
        double _t12_inv = 1.0 / _t12;
        double _buf0 = _t6 * _t12_inv;
        double _buf1 = Math.fma(sd[7], sd[2], -(sd[1] * sd[8])) * _t12_inv;
        double _buf2 = _t7 * _t12_inv;
        double _buf3 = Math.fma(sd[6], sd[5], -(sd[3] * sd[8])) * _t12_inv;
        double _buf4 = Math.fma(sd[0], sd[8], -(sd[6] * sd[2])) * _t12_inv;
        dd[5] = Math.fma(sd[3], sd[2], -(sd[0] * sd[5])) * _t12_inv;
        double _buf5 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t12_inv;
        dd[7] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t12_inv;
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1])) * _t12_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[6] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_general_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t5 = Math.fma(sd[1], sd[5], -(sd[4] * sd[2]));
        double _t6 = Math.fma(otherData[6], sd[2], Math.fma(otherData[7], sd[5], sd[8]));
        double _t7 = Math.fma(otherData[6], sd[1], Math.fma(otherData[7], sd[4], sd[7]));
        double _t8 = Math.fma(otherData[6], sd[0], Math.fma(otherData[7], sd[3], sd[6]));
        double _t13 = Math.fma(sd[4], _t6, -(sd[5] * _t7));
        double _t18 = Math.fma(_t8, _t5, Math.fma(sd[0], _t13, -(sd[3] * Math.fma(sd[1], _t6, -(sd[2] * _t7)))));
        double _t18_inv = 1.0 / _t18;
        double _buf0 = _t13 * _t18_inv;
        double _buf1 = Math.fma(sd[2], _t7, -(sd[1] * _t6)) * _t18_inv;
        double _buf2 = _t5 * _t18_inv;
        double _buf3 = Math.fma(sd[5], _t8, -(sd[3] * _t6)) * _t18_inv;
        double _buf4 = Math.fma(sd[0], _t6, -(sd[2] * _t8)) * _t18_inv;
        dd[5] = Math.fma(sd[3], sd[2], -(sd[0] * sd[5])) * _t18_inv;
        dd[6] = Math.fma(sd[3], _t7, -(sd[4] * _t8)) * _t18_inv;
        dd[7] = Math.fma(sd[1], _t8, -(sd[0] * _t7)) * _t18_inv;
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1])) * _t18_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code invertProduct}, specialized by runtime matrix properties; reached only
     * through the public {@code invertProduct} dispatcher.
     */
    private Double3x3 invertProduct_general_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t9 = Math.fma(otherData[3], sd[1], otherData[4] * sd[4]);
        double _t10 = Math.fma(otherData[3], sd[2], otherData[4] * sd[5]);
        double _t11 = Math.fma(otherData[0], sd[1], otherData[1] * sd[4]);
        double _t12 = Math.fma(otherData[0], sd[2], otherData[1] * sd[5]);
        double _t13 = Math.fma(otherData[0], sd[0], otherData[1] * sd[3]);
        double _t14 = Math.fma(otherData[3], sd[0], otherData[4] * sd[3]);
        double _t15 = Math.fma(otherData[6], sd[2], Math.fma(otherData[7], sd[5], sd[8]));
        double _t16 = Math.fma(otherData[6], sd[1], Math.fma(otherData[7], sd[4], sd[7]));
        double _t17 = Math.fma(otherData[6], sd[0], Math.fma(otherData[7], sd[3], sd[6]));
        double _t24 = Math.fma(_t11, _t10, -(_t12 * _t9));
        double _t25 = Math.fma(_t15, _t9, -(_t16 * _t10));
        double _t30 = Math.fma(_t17, _t24, Math.fma(_t13, _t25, -(_t14 * Math.fma(_t15, _t11, -(_t16 * _t12)))));
        double _t30_inv = 1.0 / _t30;
        dd[0] = _t25 * _t30_inv;
        dd[1] = Math.fma(_t16, _t12, -(_t15 * _t11)) * _t30_inv;
        dd[2] = _t24 * _t30_inv;
        dd[3] = Math.fma(_t17, _t10, -(_t15 * _t14)) * _t30_inv;
        dd[4] = Math.fma(_t15, _t13, -(_t17 * _t12)) * _t30_inv;
        dd[5] = Math.fma(_t12, _t14, -(_t13 * _t10)) * _t30_inv;
        dd[6] = Math.fma(_t16, _t14, -(_t17 * _t9)) * _t30_inv;
        dd[7] = Math.fma(_t17, _t11, -(_t16 * _t13)) * _t30_inv;
        dd[8] = Math.fma(_t13, _t9, -(_t11 * _t14)) * _t30_inv;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invertProduct(Double3x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_identity_affine(other, dest);
            return invertProduct_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_translation_affine(other, dest);
            return invertProduct_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, dest, Joml.BIT_ORTHOGONAL & q);
            return invertProduct_orthogonal(other, dest, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_affine_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_affine_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, dest, Joml.BIT_AFFINE & q);
            return invertProduct_orthogonal(other, dest, Joml.BIT_AFFINE & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_general_affine(other, dest);
        return invertProduct_general(other, dest);
    }


    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 invertProduct(Double3x3R other) {
        if (Joml.RETURN_NEW) return invertProduct(other, Joml.double3x3());
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_identity_affine(other, this);
            return invertProduct_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_translation_affine(other, this);
            return invertProduct_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, this, Joml.BIT_ORTHOGONAL & q);
            return invertProduct_orthogonal(other, this, Joml.BIT_ORTHOGONAL & q);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_affine_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_affine_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_orthogonal_affine(other, this, Joml.BIT_AFFINE & q);
            return invertProduct_orthogonal(other, this, Joml.BIT_AFFINE & q);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return invertProduct_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return invertProduct_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return invertProduct_general_affine(other, this);
        return invertProduct_general(other, this);
    }


    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the
     * result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 invertProduct(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t18 = Math.fma(m21, sd[7], Math.fma(m01, sd[1], m11 * sd[4]));
        double _t19 = Math.fma(m22, sd[8], Math.fma(m02, sd[2], m12 * sd[5]));
        double _t20 = Math.fma(m21, sd[8], Math.fma(m01, sd[2], m11 * sd[5]));
        double _t21 = Math.fma(m22, sd[7], Math.fma(m02, sd[1], m12 * sd[4]));
        double _t22 = Math.fma(m22, sd[6], Math.fma(m02, sd[0], m12 * sd[3]));
        double _t23 = Math.fma(m20, sd[7], Math.fma(m00, sd[1], m10 * sd[4]));
        double _t24 = Math.fma(m20, sd[8], Math.fma(m00, sd[2], m10 * sd[5]));
        double _t25 = Math.fma(m20, sd[6], Math.fma(m00, sd[0], m10 * sd[3]));
        double _t26 = Math.fma(m21, sd[6], Math.fma(m01, sd[0], m11 * sd[3]));
        double _t33 = Math.fma(_t18, _t19, -(_t20 * _t21));
        double _t34 = Math.fma(_t23, _t20, -(_t24 * _t18));
        double _t39 = Math.fma(_t22, _t34, Math.fma(_t25, _t33, -(_t26 * Math.fma(_t23, _t19, -(_t24 * _t21)))));
        double _t39_inv = 1.0 / _t39;
        dd[0] = _t33 * _t39_inv;
        dd[1] = Math.fma(_t24, _t21, -(_t23 * _t19)) * _t39_inv;
        dd[2] = _t34 * _t39_inv;
        dd[3] = Math.fma(_t20, _t22, -(_t26 * _t19)) * _t39_inv;
        dd[4] = Math.fma(_t25, _t19, -(_t24 * _t22)) * _t39_inv;
        dd[5] = Math.fma(_t24, _t26, -(_t25 * _t20)) * _t39_inv;
        dd[6] = Math.fma(_t26, _t21, -(_t18 * _t22)) * _t39_inv;
        dd[7] = Math.fma(_t23, _t22, -(_t25 * _t21)) * _t39_inv;
        dd[8] = Math.fma(_t25, _t18, -(_t23 * _t26)) * _t39_inv;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_identity(@Mutated Double3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_identity_self(@Mutated Double3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_translation(@Mutated Double3x3 dest) {
        return cofactor_translation(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_translation_self(@Mutated Double3x3 dest) {
        return cofactor_translation_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_orthogonal(@Mutated Double3x3 dest) {
        return cofactor_orthogonal(dest);
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_orthogonal_self(@Mutated Double3x3 dest) {
        return cofactor_orthogonal_self(dest);
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[4] * _t2_inv;
        double _buf1 = -(sd[3] * _t2_inv);
        dd[2] = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t2_inv;
        dd[3] = -(sd[1] * _t2_inv);
        dd[4] = sd[0] * _t2_inv;
        dd[5] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t2_inv;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code normal}, specialized by runtime matrix properties;
     * reached only through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(sd[0], sd[4], -(sd[3] * sd[1]));
        double _t2_inv = 1.0 / _t2;
        double _buf0 = sd[4] * _t2_inv;
        double _buf1 = -(sd[3] * _t2_inv);
        dd[2] = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t2_inv;
        dd[3] = -(sd[1] * _t2_inv);
        dd[4] = sd[0] * _t2_inv;
        dd[5] = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t2_inv;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code normal}, specialized by runtime matrix properties; reached only
     * through the public {@code normal} dispatcher.
     */
    private Double3x3 normal_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t6 = Math.fma(sd[4], sd[8], -(sd[7] * sd[5]));
        double _t7 = Math.fma(sd[1], sd[5], -(sd[4] * sd[2]));
        double _t12 = Math.fma(sd[6], _t7, Math.fma(sd[0], _t6, -(sd[3] * Math.fma(sd[1], sd[8], -(sd[7] * sd[2])))));
        double _t12_inv = 1.0 / _t12;
        double _buf0 = _t6 * _t12_inv;
        double _buf1 = Math.fma(sd[6], sd[5], -(sd[3] * sd[8])) * _t12_inv;
        double _buf2 = Math.fma(sd[3], sd[7], -(sd[6] * sd[4])) * _t12_inv;
        double _buf3 = Math.fma(sd[7], sd[2], -(sd[1] * sd[8])) * _t12_inv;
        double _buf4 = Math.fma(sd[0], sd[8], -(sd[6] * sd[2])) * _t12_inv;
        double _buf5 = Math.fma(sd[6], sd[1], -(sd[0] * sd[7])) * _t12_inv;
        dd[6] = _t7 * _t12_inv;
        dd[7] = Math.fma(sd[3], sd[2], -(sd[0] * sd[5])) * _t12_inv;
        dd[8] = Math.fma(sd[0], sd[4], -(sd[3] * sd[1])) * _t12_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 normal(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normal_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine(dest);
        return normal_general(dest);
    }


    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse.
     *
     * @return this
     */
    @Mutated public Double3x3 normal() {
        if (Joml.RETURN_NEW) return normal(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return normal_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return normal_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return normal_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return normal_affine_self(this);
        return normal_general(this);
    }


    /**
     * Compute the trace of this matrix.
     *
     * @return the trace of this matrix
     */
    public double trace() {
        double[] sd = this.data;
        return sd[8] + (sd[0] + sd[4]);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_identity(@Mutated Double3x3 dest) {
        return cofactor_identity(dest);
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_identity_self(@Mutated Double3x3 dest) {
        return cofactor_identity_self(dest);
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = sd[6];
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[2] = sd[6];
        dd[5] = sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[3];
        dd[2] = sd[6];
        dd[3] = sd[1];
        dd[4] = sd[4];
        dd[5] = sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code transpose}, specialized by runtime matrix
     * properties; reached only through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[3];
        dd[2] = sd[6];
        dd[3] = sd[1];
        dd[4] = sd[4];
        dd[5] = sd[7];
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code transpose}, specialized by runtime matrix properties; reached only
     * through the public {@code transpose} dispatcher.
     */
    private Double3x3 transpose_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[3];
        double _buf1 = sd[6];
        dd[3] = sd[1];
        dd[4] = sd[4];
        double _buf2 = sd[7];
        dd[6] = sd[2];
        dd[7] = sd[5];
        dd[8] = sd[8];
        dd[1] = _buf0;
        dd[2] = _buf1;
        dd[5] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 transpose(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_orthogonal(dest);
        return transpose_general(dest);
    }


    /**
     * Transpose this matrix.
     *
     * @return this
     */
    @Mutated public Double3x3 transpose() {
        if (Joml.RETURN_NEW) return transpose(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return transpose_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return transpose_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return transpose_orthogonal_self(this);
        return transpose_general(this);
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_general(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0] + sd[0];
        dd[1] = otherData[1] + sd[1];
        dd[2] = otherData[2] + sd[2];
        dd[3] = otherData[3] + sd[3];
        dd[4] = otherData[4] + sd[4];
        dd[5] = otherData[5] + sd[5];
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = otherData[8] + sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = otherData[3];
        dd[4] = 1.0 + otherData[4];
        dd[5] = otherData[5];
        dd[6] = otherData[6];
        dd[7] = otherData[7];
        dd[8] = 1.0 + otherData[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = otherData[2];
        dd[3] = otherData[3];
        dd[4] = 1.0 + otherData[4];
        dd[5] = otherData[5];
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 1.0 + otherData[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_identity_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_identity_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0;
        dd[5] = 0.0;
        dd[6] = otherData[6];
        dd[7] = otherData[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_identity_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[3];
        dd[4] = 1.0 + otherData[4];
        dd[5] = 0.0;
        dd[6] = otherData[6];
        dd[7] = otherData[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_translation_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_translation_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 2.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0;
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_translation_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[3];
        dd[4] = 1.0 + otherData[4];
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_orthogonal_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = 1.0 + sd[4];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_orthogonal_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = 1.0 + sd[4];
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 2.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_general_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 1.0 + sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0 + sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code add}, specialized by runtime matrix properties; reached only through
     * the public {@code add} dispatcher.
     */
    private Double3x3 add_general_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 + sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 1.0 + sd[4];
        dd[5] = sd[5];
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 1.0 + sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 add(Double3x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_identity_affine(other, dest);
            return add_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, dest);
            return add_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
            return add_general(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, dest);
            return add_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, dest);
        return add_general(other, dest);
    }


    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 add(Double3x3R other) {
        if (Joml.RETURN_NEW) return add(other, Joml.double3x3());
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_identity_affine(other, this);
            return add_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return add_translation_affine(other, this);
            return add_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
            return add_general(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_orthogonal_translation(other, this);
            return add_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return add_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return add_general_translation(other, this);
        return add_general(other, this);
    }


    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 add(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = m00 + sd[0];
        dd[1] = m10 + sd[1];
        dd[2] = m20 + sd[2];
        dd[3] = m01 + sd[3];
        dd[4] = m11 + sd[4];
        dd[5] = m21 + sd[5];
        dd[6] = m02 + sd[6];
        dd[7] = m12 + sd[7];
        dd[8] = m22 + sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[4] = -1.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[4] = -1.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = -sd[4];
        dd[0] = _t0;
        double _buf0 = -sd[1];
        dd[2] = 0.0;
        dd[3] = sd[1];
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = -sd[4];
        dd[0] = _t0;
        double _buf0 = -sd[1];
        dd[3] = sd[1];
        dd[4] = _t0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = 0.0;
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code negate}, specialized by runtime matrix properties;
     * reached only through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code negate}, specialized by runtime matrix properties; reached only
     * through the public {@code negate} dispatcher.
     */
    private Double3x3 negate_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 negate(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine(dest);
        return negate_general(dest);
    }


    /**
     * Negate this matrix.
     *
     * @return this
     */
    @Mutated public Double3x3 negate() {
        if (Joml.RETURN_NEW) return negate(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return negate_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return negate_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return negate_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return negate_affine_self(this);
        return negate_general(this);
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_general(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = sd[1] - otherData[1];
        dd[2] = sd[2] - otherData[2];
        dd[3] = sd[3] - otherData[3];
        dd[4] = sd[4] - otherData[4];
        dd[5] = sd[5] - otherData[5];
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = sd[8] - otherData[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 - otherData[0];
        dd[1] = -otherData[1];
        dd[2] = -otherData[2];
        dd[3] = -otherData[3];
        dd[4] = 1.0 - otherData[4];
        dd[5] = -otherData[5];
        dd[6] = -otherData[6];
        dd[7] = -otherData[7];
        dd[8] = 1.0 - otherData[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_identity_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_identity_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = -otherData[6];
        dd[7] = -otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_identity_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 - otherData[0];
        dd[1] = -otherData[1];
        dd[2] = 0.0;
        dd[3] = -otherData[3];
        dd[4] = 1.0 - otherData[4];
        dd[5] = 0.0;
        dd[6] = -otherData[6];
        dd[7] = -otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_translation_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_translation_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_translation_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0 - otherData[0];
        dd[1] = -otherData[1];
        dd[2] = 0.0;
        dd[3] = -otherData[3];
        dd[4] = 1.0 - otherData[4];
        dd[5] = 0.0;
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_orthogonal_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4] - 1.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_orthogonal_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4] - 1.0;
        dd[5] = 0.0;
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_orthogonal_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - otherData[0];
        dd[1] = sd[1] - otherData[1];
        dd[2] = 0.0;
        dd[3] = sd[3] - otherData[3];
        dd[4] = sd[4] - otherData[4];
        dd[5] = 0.0;
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_general_identity(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4] - 1.0;
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8] - 1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code sub}, specialized by runtime matrix properties; reached only through
     * the public {@code sub} dispatcher.
     */
    private Double3x3 sub_general_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - 1.0;
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4] - 1.0;
        dd[5] = sd[5];
        dd[6] = sd[6] - otherData[6];
        dd[7] = sd[7] - otherData[7];
        dd[8] = sd[8] - 1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 sub(Double3x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_identity_affine(other, dest);
            return sub_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, dest);
            return sub_general(other, dest);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, dest);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, dest);
        return sub_general(other, dest);
    }


    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 sub(Double3x3R other) {
        if (Joml.RETURN_NEW) return sub(other, Joml.double3x3());
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_identity_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_identity_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_identity_affine(other, this);
            return sub_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_translation_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_translation_affine(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, this);
            return sub_general(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_orthogonal_identity(other, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_orthogonal_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return sub_orthogonal_affine(other, this);
            return sub_general(other, this);
        }
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return sub_general_identity(other, this);
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return sub_general_translation(other, this);
        return sub_general(other, this);
    }


    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) from this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 sub(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] - m00;
        dd[1] = sd[1] - m10;
        dd[2] = sd[2] - m20;
        dd[3] = sd[3] - m01;
        dd[4] = sd[4] - m11;
        dd[5] = sd[5] - m21;
        dd[6] = sd[6] - m02;
        dd[7] = sd[7] - m12;
        dd[8] = sd[8] - m22;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated public Double3x3 set(Double3x3R v) {
        double[] dd = this.data;
        double[] vData = ((Double3x3Impl) v).data;
        dd[0] = vData[0];
        dd[1] = vData[1];
        dd[2] = vData[2];
        dd[3] = vData[3];
        dd[4] = vData[4];
        dd[5] = vData[5];
        dd[6] = vData[6];
        dd[7] = vData[7];
        dd[8] = vData[8];
        ((Double3x3Impl) this).properties = ((Double3x3Impl) v).properties;
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
     * @return this
     */
    @Mutated public Double3x3 set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
        double[] dd = this.data;
        dd[0] = m00;
        dd[1] = m10;
        dd[2] = m20;
        dd[3] = m01;
        dd[4] = m11;
        dd[5] = m21;
        dd[6] = m02;
        dd[7] = m12;
        dd[8] = m22;
        ((Double3x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x2 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x3 set(Double2x2R m) {
        double[] dd = this.data;
        double[] mData = ((Double2x2Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = 0.0;
        dd[3] = mData[2];
        dd[4] = mData[3];
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 2x3 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x3 set(Double2x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double2x3Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = 0.0;
        dd[3] = mData[2];
        dd[4] = mData[3];
        dd[5] = 0.0;
        dd[6] = mData[4];
        dd[7] = mData[5];
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 3x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x3 set(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[4];
        dd[2] = mData[8];
        dd[3] = mData[1];
        dd[4] = mData[5];
        dd[5] = mData[9];
        dd[6] = mData[2];
        dd[7] = mData[6];
        dd[8] = mData[10];
        ((Double3x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set this matrix to the given 4x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public Double3x3 set(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        dd[0] = mData[0];
        dd[1] = mData[1];
        dd[2] = mData[2];
        dd[3] = mData[4];
        dd[4] = mData[5];
        dd[5] = mData[6];
        dd[6] = mData[8];
        dd[7] = mData[9];
        dd[8] = mData[10];
        ((Double3x3Impl) this).properties = determineProperties();
        return this;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 withTranslation(Double2R t, @Mutated Double3x3 dest) {
        return withTranslation(t.x(), t.y(), dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param t the translation offsets
     * @return this
     */
    public @Mutated Double3x3 withTranslation(Double2R t) {
        return withTranslation(t.x(), t.y());
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x3 withTranslation_orthogonal_affine(double tX, double tY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = tX;
        dd[7] = tY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Double3x3 withTranslation_orthogonal_affine_self(double tX, double tY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = tX;
        dd[7] = tY;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x3 withTranslation_identity(double tX, double tY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = tX;
        dd[7] = tY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code withTranslation}, specialized by runtime matrix
     * properties; reached only through the public {@code withTranslation} dispatcher.
     */
    private Double3x3 withTranslation_identity_self(double tX, double tY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[6] = tX;
        dd[7] = tY;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code withTranslation}, specialized by runtime matrix properties; reached
     * only through the public {@code withTranslation} dispatcher.
     */
    private Double3x3 withTranslation_general(double tX, double tY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = tX;
        dd[7] = tY;
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 withTranslation(double tX, double tY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity(tX, tY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return withTranslation_orthogonal_affine(tX, tY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return withTranslation_general(tX, tY, dest);
    }


    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param tX the {@code x} component of the translation offsets {@code (tX, tY)}
     * @param tY the {@code y} component of the translation offsets {@code (tX, tY)}
     * @return this
     */
    @Mutated public Double3x3 withTranslation(double tX, double tY) {
        if (Joml.RETURN_NEW) return withTranslation(tX, tY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return withTranslation_identity_self(tX, tY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return withTranslation_orthogonal_affine_self(tX, tY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return withTranslation_general(tX, tY, this);
    }


    /**
     * Convert this matrix to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 toFloat(@Mutated Float3x3 dest) {
        double[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        dd[0] = (float) (sd[0]);
        dd[1] = (float) (sd[1]);
        dd[2] = (float) (sd[2]);
        dd[3] = (float) (sd[3]);
        dd[4] = (float) (sd[4]);
        dd[5] = (float) (sd[5]);
        dd[6] = (float) (sd[6]);
        dd[7] = (float) (sd[7]);
        dd[8] = (float) (sd[8]);
        return dest;
    }


    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
     *
     * @param r the rigid transform (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x3 makeFromRigid(DoubleRigidR r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
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
     * @return this
     */
    @Mutated public Double3x3 makeFromRigid(double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double[] dd = this.data;
        double _t0 = rRZ * rRZ;
        double _t1 = rRZ * rRW;
        double _t2 = rRY * rRW;
        dd[0] = Math.fma(-2.0, Math.fma(rRY, rRY, _t0), 1.0);
        dd[1] = 2.0 * Math.fma(rRX, rRY, _t1);
        dd[2] = 2.0 * Math.fma(rRX, rRZ, -_t2);
        dd[3] = 2.0 * Math.fma(rRX, rRY, -_t1);
        dd[4] = Math.fma(-2.0, Math.fma(rRX, rRX, _t0), 1.0);
        dd[5] = 2.0 * Math.fma(rRX, rRW, rRY * rRZ);
        dd[6] = 2.0 * Math.fma(rRX, rRZ, _t2);
        dd[7] = 2.0 * Math.fma(rRY, rRZ, -(rRX * rRW));
        dd[8] = Math.fma(-2.0, Math.fma(rRX, rRX, rRY * rRY), 1.0);
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
     *
     * @param t the transform
     * @return this
     */
    public @Mutated Double3x3 makeFromTransform(DoubleTransformR t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
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
     * @return this
     */
    @Mutated public Double3x3 makeFromTransform(double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double[] dd = this.data;
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        dd[0] = tSX * Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0);
        dd[1] = tSX * 2.0 * Math.fma(tRX, tRY, _t1);
        dd[2] = tSX * 2.0 * Math.fma(tRX, tRZ, -_t2);
        dd[3] = tSY * 2.0 * Math.fma(tRX, tRY, -_t1);
        dd[4] = tSY * Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0);
        dd[5] = tSY * 2.0 * Math.fma(tRX, tRW, tRY * tRZ);
        dd[6] = tSZ * 2.0 * Math.fma(tRX, tRZ, _t2);
        dd[7] = tSZ * 2.0 * Math.fma(tRY, tRZ, -(tRX * tRW));
        dd[8] = tSZ * Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0);
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Double2x2 to2x2_identity(@Mutated Double2x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        ((Double2x2Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to2x2}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x2} dispatcher.
     */
    private Double2x2 to2x2_general(@Mutated Double2x2 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x2Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[3];
        dd[3] = sd[4];
        ((Double2x2Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Extract the upper-left 2x2 linear block of this matrix (dropping the translation column and
     * the last row) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x2 to2x2(@Mutated Double2x2 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x2_identity(dest);
        return to2x2_general(dest);
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Double2x3 to2x3_orthogonal_general(@Mutated Double2x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[3];
        dd[3] = sd[4];
        dd[4] = sd[6];
        dd[5] = sd[7];
        ((Double2x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Double2x3 to2x3_identity(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        ((Double2x3Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to2x3}, specialized by runtime matrix properties; reached only through
     * the public {@code to2x3} dispatcher.
     */
    private Double2x3 to2x3_translation(@Mutated Double2x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double2x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = sd[6];
        dd[5] = sd[7];
        ((Double2x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Truncate this matrix to a 2x3 matrix, dropping the last row (assumed {@code 0, 0, 1}) and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double2x3 to2x3(@Mutated Double2x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to2x3_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to2x3_translation(dest);
        return to2x3_orthogonal_general(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Double3x4 to3x4_identity(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 1.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        dd[9] = 0.0;
        dd[10] = 1.0;
        dd[11] = 0.0;
        ((Double3x4Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Double3x4 to3x4_translation(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = sd[6];
        dd[3] = 0.0;
        dd[4] = 0.0;
        double _buf0 = 1.0;
        dd[6] = sd[7];
        dd[7] = 0.0;
        dd[8] = 0.0;
        dd[9] = 0.0;
        dd[10] = 1.0;
        dd[11] = 0.0;
        dd[5] = _buf0;
        ((Double3x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Double3x4 to3x4_orthogonal(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[3];
        dd[2] = sd[6];
        double _buf0 = 0.0;
        double _buf1 = sd[1];
        double _buf2 = sd[4];
        dd[6] = sd[7];
        dd[7] = 0.0;
        dd[8] = 0.0;
        dd[9] = 0.0;
        dd[10] = 1.0;
        dd[11] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        dd[5] = _buf2;
        ((Double3x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to3x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to3x4} dispatcher.
     */
    private Double3x4 to3x4_general(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[3];
        dd[2] = sd[6];
        double _buf0 = 0.0;
        double _buf1 = sd[1];
        double _buf2 = sd[4];
        double _buf3 = sd[7];
        double _buf4 = 0.0;
        double _buf5 = sd[2];
        dd[9] = sd[5];
        dd[10] = sd[8];
        dd[11] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        dd[5] = _buf2;
        dd[6] = _buf3;
        dd[7] = _buf4;
        dd[8] = _buf5;
        ((Double3x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Extend this matrix to a 3x4 matrix with a zero translation column and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 to3x4(@Mutated Double3x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to3x4_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to3x4_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to3x4_orthogonal(dest);
        return to3x4_general(dest);
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_identity(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 1.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        dd[9] = 0.0;
        dd[10] = 1.0;
        dd[11] = 0.0;
        dd[12] = 0.0;
        dd[13] = 0.0;
        dd[14] = 0.0;
        dd[15] = 1.0;
        ((Double4x4Impl) dest).properties = Joml.BIT_IDENTITY;
        return dest;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_translation(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        double _buf0 = 1.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = sd[6];
        dd[9] = sd[7];
        dd[10] = 1.0;
        dd[11] = 0.0;
        dd[12] = 0.0;
        dd[13] = 0.0;
        dd[14] = 0.0;
        dd[15] = 1.0;
        dd[5] = _buf0;
        ((Double4x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_orthogonal(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[1];
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sd[3];
        double _buf1 = sd[4];
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = sd[6];
        dd[9] = sd[7];
        dd[10] = 1.0;
        dd[11] = 0.0;
        dd[12] = 0.0;
        dd[13] = 0.0;
        dd[14] = 0.0;
        dd[15] = 1.0;
        dd[1] = _buf0;
        dd[5] = _buf1;
        ((Double4x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code to4x4}, specialized by runtime matrix properties; reached only through
     * the public {@code to4x4} dispatcher.
     */
    private Double4x4 to4x4_general(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        dd[0] = sd[0];
        double _buf0 = sd[1];
        double _buf1 = sd[2];
        dd[3] = 0.0;
        dd[4] = sd[3];
        double _buf2 = sd[4];
        dd[6] = sd[5];
        dd[7] = 0.0;
        dd[8] = sd[6];
        dd[9] = sd[7];
        dd[10] = sd[8];
        dd[11] = 0.0;
        dd[12] = 0.0;
        dd[13] = 0.0;
        dd[14] = 0.0;
        dd[15] = 1.0;
        dd[1] = _buf0;
        dd[2] = _buf1;
        dd[5] = _buf2;
        ((Double4x4Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Extend this matrix to a 4x4 matrix, filling the missing cells with identity and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 to4x4(@Mutated Double4x4 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return to4x4_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return to4x4_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return to4x4_orthogonal(dest);
        return to4x4_general(dest);
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_identity(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_translation(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = -(0.25 * sd[7]);
        dd[1] = 0.25 * sd[6];
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_orthogonal(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = Math.max(sd[4], 1.0);
        double _t2 = 1.0 - sd[0];
        double _t4 = sd[3] + sd[1];
        double _t5 = sd[1] - sd[3];
        double _t8 = 1.0 + (sd[0] + sd[4]);
        double _t10 = 1.0 + _t8;
        double _t11 = sd[0] + (1.0 - sd[4] - 1.0);
        double _t12 = sd[4] + (_t2 - 1.0);
        double _t13 = 1.0 + (_t2 - sd[4]);
        double _t14 = (1.0 / Math.sqrt(_t10));
        double _t15 = (1.0 / Math.sqrt(_t12));
        double _t16 = (1.0 / Math.sqrt(_t13));
        double _t17 = (1.0 / Math.sqrt(_t11));
        if (_t8 > 0.0) {
            double _buf0 = -(0.5 * sd[7] * _t14);
            dd[1] = 0.5 * sd[6] * _t14;
            double _buf1 = 0.5 * _t5 * _t14;
            dd[3] = 0.5 * Math.sqrt(_t10);
            dd[0] = _buf0;
            dd[2] = _buf1;
        } else {
            if (sd[0] > _t0) {
                double _buf0 = 0.5 * Math.sqrt(_t11);
                dd[1] = 0.5 * _t4 * _t17;
                double _buf1 = 0.5 * sd[6] * _t17;
                dd[3] = -(0.5 * sd[7] * _t17);
                dd[0] = _buf0;
                dd[2] = _buf1;
            } else {
                if (sd[4] > 1.0) {
                    double _buf0 = 0.5 * _t4 * _t15;
                    dd[1] = 0.5 * Math.sqrt(_t12);
                    double _buf1 = 0.5 * sd[7] * _t15;
                    dd[3] = 0.5 * sd[6] * _t15;
                    dd[0] = _buf0;
                    dd[2] = _buf1;
                } else {
                    double _buf0 = 0.5 * sd[6] * _t16;
                    dd[1] = 0.5 * sd[7] * _t16;
                    double _buf1 = 0.5 * Math.sqrt(_t13);
                    dd[3] = 0.5 * _t5 * _t16;
                    dd[0] = _buf0;
                    dd[2] = _buf1;
                }
            }
        }
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code toDualQuat}, specialized by runtime matrix properties; reached only
     * through the public {@code toDualQuat} dispatcher.
     */
    private DoubleDualQuat toDualQuat_general(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t1 = 1.0 - sd[0];
        double _t3 = sd[5] - sd[7];
        double _t4 = Math.max(sd[4], sd[8]);
        double _t5 = sd[3] + sd[1];
        double _t6 = sd[6] + sd[2];
        double _t7 = sd[6] - sd[2];
        double _t8 = sd[7] + sd[5];
        double _t9 = sd[1] - sd[3];
        double _t13 = sd[8] + (sd[0] + sd[4]);
        double _t14 = 1.0 + _t13;
        double _t15 = sd[0] + (1.0 - sd[4] - sd[8]);
        double _t16 = sd[4] + (_t1 - sd[8]);
        double _t17 = sd[8] + (_t1 - sd[4]);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t13 > 0.0) {
            double _buf0 = 0.5 * _t3 * _t18;
            dd[1] = 0.5 * _t7 * _t18;
            dd[2] = 0.5 * _t9 * _t18;
            dd[3] = 0.5 * Math.sqrt(_t14);
            dd[0] = _buf0;
        } else {
            if (sd[0] > _t4) {
                double _buf0 = 0.5 * Math.sqrt(_t15);
                dd[1] = 0.5 * _t5 * _t21;
                dd[2] = 0.5 * _t6 * _t21;
                dd[3] = 0.5 * _t3 * _t21;
                dd[0] = _buf0;
            } else {
                if (sd[4] > sd[8]) {
                    double _buf0 = 0.5 * _t5 * _t19;
                    dd[1] = 0.5 * Math.sqrt(_t16);
                    dd[2] = 0.5 * _t8 * _t19;
                    dd[3] = 0.5 * _t7 * _t19;
                    dd[0] = _buf0;
                } else {
                    double _buf0 = 0.5 * _t6 * _t20;
                    dd[1] = 0.5 * _t8 * _t20;
                    dd[2] = 0.5 * Math.sqrt(_t17);
                    dd[3] = 0.5 * _t9 * _t20;
                    dd[0] = _buf0;
                }
            }
        }
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Convert this matrix (assumed orthonormal) to a pure-rotation dual quaternion and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toDualQuat_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toDualQuat_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return toDualQuat_orthogonal(dest);
        return toDualQuat_general(dest);
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_identity(@Mutated DoubleRigid dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleRigidImpl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 1.0;
        return dest;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_translation(@Mutated DoubleRigid dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleRigidImpl) dest).data;
        double _t2 = (1.0 / Math.sqrt(Math.fma(sd[6], sd[6], Math.fma(sd[7], sd[7], 1.0))));
        double _t3 = Math.max(1.0, _t2);
        double _t5 = sd[7] * _t2;
        double _t6 = sd[6] * _t2;
        double _t7 = _t2 < 0.0 ? -1.0 : 1.0;
        double _t8 = 1.0 + _t7;
        double _t11 = _t8 + _t2;
        double _t13 = 2.0 - _t7 - _t2;
        double _t14 = (1.0 / Math.sqrt(_t13));
        double _t15 = 1.0 + _t11;
        double _t16 = _t8 - 1.0 - _t2;
        double _t17 = 1.0 + _t2 - _t7 - 1.0;
        double _t18 = (1.0 / Math.sqrt(_t15));
        double _t19 = (1.0 / Math.sqrt(_t17));
        double _t20 = (1.0 / Math.sqrt(_t16));
        if (_t11 > 0.0) {
            dd[3] = -(0.5 * _t5 * _t18);
            dd[4] = 0.5 * _t6 * _t18;
            dd[5] = 0.0;
            dd[6] = 0.5 * Math.sqrt(_t15);
        } else {
            if (_t7 > _t3) {
                dd[3] = 0.5 * Math.sqrt(_t16);
                dd[4] = 0.0;
                dd[5] = 0.5 * _t6 * _t20;
                dd[6] = -(0.5 * _t5 * _t20);
            } else {
                if (1.0 > _t2) {
                    dd[3] = 0.0;
                    dd[4] = 0.5 * Math.sqrt(_t13);
                    dd[5] = 0.5 * _t5 * _t14;
                    dd[6] = 0.5 * _t6 * _t14;
                } else {
                    dd[3] = 0.5 * _t6 * _t19;
                    dd[4] = 0.5 * _t5 * _t19;
                    dd[5] = 0.5 * Math.sqrt(_t17);
                    dd[6] = 0.0;
                }
            }
        }
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code toRigid}, specialized by runtime matrix properties; reached only
     * through the public {@code toRigid} dispatcher.
     */
    private DoubleRigid toRigid_general(@Mutated DoubleRigid dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleRigidImpl) dest).data;
        double _t0 = -sd[4];
        double _t1 = -sd[8];
        double _t12 = (1.0 / Math.sqrt(Math.fma(sd[5], sd[5], Math.fma(sd[3], sd[3], sd[4] * sd[4]))));
        double _t13 = (1.0 / Math.sqrt(Math.fma(sd[8], sd[8], Math.fma(sd[6], sd[6], sd[7] * sd[7]))));
        double _t14 = (1.0 / Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]))));
        double _t15 = sd[1] * _t14;
        double _t16 = sd[8] * _t13;
        double _t17 = sd[7] * _t13;
        double _t18 = sd[2] * _t14;
        double _t20 = sd[5] * _t12;
        double _t21 = sd[4] * _t12;
        double _t23 = sd[0] * _t14;
        double _t28 = Math.fma(sd[7], _t13, _t20);
        double _t32 = Math.fma(sd[5], _t12, -_t17);
        double _t33 = Math.max(_t21, _t16);
        double _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), sd[3] * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), sd[6] * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        double _t44, _t45, _t46;
        if (_t43 < 0.0) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        double _t48 = 1.0 + _t44;
        double _t49 = 1.0 - _t44;
        double _t51 = Math.fma(sd[3], _t12, _t45);
        double _t52 = Math.fma(sd[6], _t13, _t46);
        double _t53 = Math.fma(sd[6], _t13, -_t46);
        double _t54 = Math.fma(-sd[3], _t12, _t45);
        double _t59 = Math.fma(sd[4], _t12, Math.fma(sd[8], _t13, _t44));
        double _t60 = Math.fma(sd[4], _t12, Math.fma(sd[8], _t13, _t48));
        double _t61 = (1.0 / Math.sqrt(_t60));
        double _t62 = Math.fma(sd[4], _t12, Math.fma(_t1, _t13, _t49));
        double _t63 = Math.fma(sd[8], _t13, Math.fma(_t0, _t12, _t49));
        double _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        if (_t59 > 0.0) {
            dd[3] = 0.5 * _t32 * _t61;
            dd[4] = 0.5 * _t53 * _t61;
            dd[5] = 0.5 * _t54 * _t61;
            dd[6] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t44 > _t33) {
                dd[3] = 0.5 * Math.sqrt(_t64);
                dd[4] = 0.5 * _t51 * _t67;
                dd[5] = 0.5 * _t52 * _t67;
                dd[6] = 0.5 * _t32 * _t67;
            } else {
                if (_t21 > _t16) {
                    dd[3] = 0.5 * _t51 * _t65;
                    dd[4] = 0.5 * Math.sqrt(_t62);
                    dd[5] = 0.5 * _t28 * _t65;
                    dd[6] = 0.5 * _t53 * _t65;
                } else {
                    dd[3] = 0.5 * _t52 * _t66;
                    dd[4] = 0.5 * _t28 * _t66;
                    dd[5] = 0.5 * Math.sqrt(_t63);
                    dd[6] = 0.5 * _t54 * _t66;
                }
            }
        }
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Extract this matrix's rotation into a rigid transform with zero translation (any scale or
     * shear projects onto the nearest rotation) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toRigid_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toRigid_translation(dest);
        return toRigid_general(dest);
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_identity(@Mutated DoubleTransform dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleTransformImpl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 1.0;
        dd[7] = 1.0;
        dd[8] = 1.0;
        dd[9] = 1.0;
        return dest;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_translation(@Mutated DoubleTransform dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleTransformImpl) dest).data;
        double _t1 = Math.fma(sd[6], sd[6], Math.fma(sd[7], sd[7], 1.0));
        double _t2 = (1.0 / Math.sqrt(_t1));
        double _t3 = Math.max(1.0, _t2);
        double _t5 = sd[7] * _t2;
        double _t6 = sd[6] * _t2;
        double _t7 = _t2 < 0.0 ? -1.0 : 1.0;
        double _t8 = 1.0 + _t7;
        double _t11 = _t8 + _t2;
        double _t13 = 2.0 - _t7 - _t2;
        double _t14 = (1.0 / Math.sqrt(_t13));
        double _t15 = 1.0 + _t11;
        double _t16 = _t8 - 1.0 - _t2;
        double _t17 = 1.0 + _t2 - _t7 - 1.0;
        double _t18 = (1.0 / Math.sqrt(_t15));
        double _t19 = (1.0 / Math.sqrt(_t17));
        double _t20 = (1.0 / Math.sqrt(_t16));
        if (_t11 > 0.0) {
            dd[3] = -(0.5 * _t5 * _t18);
            dd[4] = 0.5 * _t6 * _t18;
            dd[5] = 0.0;
            dd[6] = 0.5 * Math.sqrt(_t15);
        } else {
            if (_t7 > _t3) {
                dd[3] = 0.5 * Math.sqrt(_t16);
                dd[4] = 0.0;
                dd[5] = 0.5 * _t6 * _t20;
                dd[6] = -(0.5 * _t5 * _t20);
            } else {
                if (1.0 > _t2) {
                    dd[3] = 0.0;
                    dd[4] = 0.5 * Math.sqrt(_t13);
                    dd[5] = 0.5 * _t5 * _t14;
                    dd[6] = 0.5 * _t6 * _t14;
                } else {
                    dd[3] = 0.5 * _t6 * _t19;
                    dd[4] = 0.5 * _t5 * _t19;
                    dd[5] = 0.5 * Math.sqrt(_t17);
                    dd[6] = 0.0;
                }
            }
        }
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[7] = _t7;
        dd[8] = 1.0;
        dd[9] = Math.sqrt(_t1);
        return dest;
    }


    /**
     * Private body of {@code toTransform}, specialized by runtime matrix properties; reached only
     * through the public {@code toTransform} dispatcher.
     */
    private DoubleTransform toTransform_general(@Mutated DoubleTransform dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleTransformImpl) dest).data;
        double _t0 = -sd[4];
        double _t1 = -sd[8];
        double _t9 = Math.fma(sd[5], sd[5], Math.fma(sd[3], sd[3], sd[4] * sd[4]));
        double _t10 = Math.fma(sd[8], sd[8], Math.fma(sd[6], sd[6], sd[7] * sd[7]));
        double _t11 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t12 = (1.0 / Math.sqrt(_t9));
        double _t13 = (1.0 / Math.sqrt(_t10));
        double _t14 = (1.0 / Math.sqrt(_t11));
        double _t15 = Math.sqrt(_t11);
        double _t16 = sd[1] * _t14;
        double _t17 = sd[8] * _t13;
        double _t18 = sd[7] * _t13;
        double _t19 = sd[2] * _t14;
        double _t21 = sd[5] * _t12;
        double _t22 = sd[4] * _t12;
        double _t24 = sd[0] * _t14;
        double _t29 = Math.fma(sd[7], _t13, _t21);
        double _t33 = Math.fma(sd[5], _t12, -_t18);
        double _t34 = Math.max(_t22, _t17);
        double _t44 = Math.fma(-Math.fma(_t16, _t17, -(_t18 * _t19)), sd[3] * _t12, Math.fma(Math.fma(_t16, _t21, -(_t22 * _t19)), sd[6] * _t13, Math.fma(_t22, _t17, -(_t18 * _t21)) * _t24));
        double _t45, _t46, _t47;
        if (_t44 < 0.0) {
            _t45 = -_t24;
            _t46 = -_t16;
            _t47 = -_t19;
        } else {
            _t45 = _t24;
            _t46 = _t16;
            _t47 = _t19;
        }
        double _t49 = 1.0 + _t45;
        double _t50 = 1.0 - _t45;
        double _t52 = Math.fma(sd[3], _t12, _t46);
        double _t53 = Math.fma(sd[6], _t13, _t47);
        double _t54 = Math.fma(sd[6], _t13, -_t47);
        double _t55 = Math.fma(-sd[3], _t12, _t46);
        double _t60 = Math.fma(sd[4], _t12, Math.fma(sd[8], _t13, _t45));
        double _t61 = Math.fma(sd[4], _t12, Math.fma(sd[8], _t13, _t49));
        double _t62 = (1.0 / Math.sqrt(_t61));
        double _t63 = Math.fma(sd[4], _t12, Math.fma(_t1, _t13, _t50));
        double _t64 = Math.fma(sd[8], _t13, Math.fma(_t0, _t12, _t50));
        double _t65 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t49));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t64));
        double _t68 = (1.0 / Math.sqrt(_t65));
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = _t60 > 0.0 ? 0.5 * _t33 * _t62 : _t45 > _t34 ? 0.5 * Math.sqrt(_t65) : _t22 > _t17 ? 0.5 * _t52 * _t66 : 0.5 * _t53 * _t67;
        dd[4] = _t60 > 0.0 ? 0.5 * _t54 * _t62 : _t45 > _t34 ? 0.5 * _t52 * _t68 : _t22 > _t17 ? 0.5 * Math.sqrt(_t63) : 0.5 * _t29 * _t67;
        dd[5] = _t60 > 0.0 ? 0.5 * _t55 * _t62 : _t45 > _t34 ? 0.5 * _t53 * _t68 : _t22 > _t17 ? 0.5 * _t29 * _t66 : 0.5 * Math.sqrt(_t64);
        dd[6] = _t60 > 0.0 ? 0.5 * Math.sqrt(_t61) : _t45 > _t34 ? 0.5 * _t33 * _t68 : _t22 > _t17 ? 0.5 * _t54 * _t66 : 0.5 * _t55 * _t67;
        dd[7] = _t44 < 0.0 ? -_t15 : _t15;
        dd[8] = Math.sqrt(_t9);
        dd[9] = Math.sqrt(_t10);
        return dest;
    }


    /**
     * Decompose this matrix's linear {@code R * S} block into a TRS transform with zero translation
     * (a sheared matrix projects onto the nearest rotation) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return toTransform_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return toTransform_translation(dest);
        return toTransform_general(dest);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private DoubleQuat decomposeRotation_identity(@Mutated DoubleQuat dest) {
        return getNormalizedRotation_identity(dest);
    }


    /**
     * Private body of {@code decomposeRotation}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeRotation} dispatcher.
     */
    private DoubleQuat decomposeRotation_general(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = sd[2] * _t3;
            _t8 = sd[0] * _t3;
            _t9 = sd[1] * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t19 = -Math.fma(sd[5], _t7, Math.fma(sd[3], _t8, sd[4] * _t9));
        double _t20 = -Math.fma(sd[8], _t7, Math.fma(sd[6], _t8, sd[7] * _t9));
        double _t21 = Math.fma(_t19, _t7, sd[5]);
        double _t22 = Math.fma(_t19, _t8, sd[3]);
        double _t23 = Math.fma(_t19, _t9, sd[4]);
        double _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t34, _t35, _t36;
        if (_t29 > 0.0) {
            _t34 = _t22 * _t30;
            _t35 = _t21 * _t30;
            _t36 = _t23 * _t30;
        } else {
            _t34 = 0.0;
            _t35 = 0.0;
            _t36 = 0.0;
        }
        double _t40 = -Math.fma(Math.fma(_t20, _t7, sd[8]), _t35, Math.fma(Math.fma(_t20, _t8, sd[6]), _t34, Math.fma(_t20, _t9, sd[7]) * _t36));
        double _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, sd[8]));
        double _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, sd[6]));
        double _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, sd[7]));
        double _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        double _t50 = (1.0 / Math.sqrt(_t49));
        double _t54, _t55, _t56;
        if (_t49 > 0.0) {
            _t54 = _t46 * _t50;
            _t55 = _t45 * _t50;
            _t56 = _t44 * _t50;
        } else {
            _t54 = 0.0;
            _t55 = 0.0;
            _t56 = 0.0;
        }
        double _t60 = _t35 - _t54;
        double _t61 = Math.max(_t36, _t56);
        double _t63 = _t35 + _t54;
        double _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        double _t73, _t74, _t75;
        if (_t72 < 0.0) {
            _t73 = -_t8;
            _t74 = -_t9;
            _t75 = -_t7;
        } else {
            _t73 = _t8;
            _t74 = _t9;
            _t75 = _t7;
        }
        double _t76 = _t73 + _t36;
        double _t77 = _t74 + _t34;
        double _t78 = _t74 - _t34;
        double _t80 = _t75 + _t55;
        double _t81 = _t55 - _t75;
        double _t82 = _t76 + _t56;
        double _t86 = 1.0 + _t82;
        double _t87 = 1.0 + (_t73 - (_t36 + _t56));
        double _t88 = 1.0 + (_t36 - (_t73 + _t56));
        double _t89 = 1.0 + (_t56 - _t76);
        double _t90 = (1.0 / Math.sqrt(_t86));
        double _t91 = (1.0 / Math.sqrt(_t88));
        double _t92 = (1.0 / Math.sqrt(_t89));
        double _t93 = (1.0 / Math.sqrt(_t87));
        if (_t82 > 0.0) {
            dd[0] = 0.5 * _t60 * _t90;
            dd[1] = 0.5 * _t81 * _t90;
            dd[2] = 0.5 * _t78 * _t90;
            dd[3] = 0.5 * Math.sqrt(_t86);
        } else {
            if (_t73 > _t61) {
                dd[0] = 0.5 * Math.sqrt(_t87);
                dd[1] = 0.5 * _t77 * _t93;
                dd[2] = 0.5 * _t80 * _t93;
                dd[3] = 0.5 * _t60 * _t93;
            } else {
                if (_t36 > _t56) {
                    dd[0] = 0.5 * _t77 * _t91;
                    dd[1] = 0.5 * Math.sqrt(_t88);
                    dd[2] = 0.5 * _t63 * _t91;
                    dd[3] = 0.5 * _t81 * _t91;
                } else {
                    dd[0] = 0.5 * _t80 * _t92;
                    dd[1] = 0.5 * _t63 * _t92;
                    dd[2] = 0.5 * Math.sqrt(_t89);
                    dd[3] = 0.5 * _t78 * _t92;
                }
            }
        }
        return dest;
    }


    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat decomposeRotation(@Mutated DoubleQuat dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeRotation_identity(dest);
        return decomposeRotation_general(dest);
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Double3 decomposeScale_identity(@Mutated Double3 dest) {
        return getScale_identity(dest);
    }


    /**
     * Private body of {@code decomposeScale}, specialized by runtime matrix properties; reached
     * only through the public {@code decomposeScale} dispatcher.
     */
    private Double3 decomposeScale_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t4 = Math.sqrt(_t2);
        double _t8, _t9, _t10;
        if (_t2 > 0.0) {
            _t8 = sd[2] * _t3;
            _t9 = sd[0] * _t3;
            _t10 = sd[1] * _t3;
        } else {
            _t8 = 0.0;
            _t9 = 0.0;
            _t10 = 0.0;
        }
        double _t17 = -Math.fma(sd[5], _t8, Math.fma(sd[3], _t9, sd[4] * _t10));
        double _t18 = -Math.fma(sd[8], _t8, Math.fma(sd[6], _t9, sd[7] * _t10));
        double _t19 = Math.fma(_t17, _t8, sd[5]);
        double _t20 = Math.fma(_t17, _t9, sd[3]);
        double _t21 = Math.fma(_t17, _t10, sd[4]);
        double _t27 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 > 0.0) {
            _t32 = _t20 * _t28;
            _t33 = _t19 * _t28;
            _t34 = _t21 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t38 = -Math.fma(Math.fma(_t18, _t8, sd[8]), _t33, Math.fma(Math.fma(_t18, _t9, sd[6]), _t32, Math.fma(_t18, _t10, sd[7]) * _t34));
        double _t42 = Math.fma(_t18, _t8, Math.fma(_t38, _t33, sd[8]));
        double _t43 = Math.fma(_t18, _t9, Math.fma(_t38, _t32, sd[6]));
        double _t44 = Math.fma(_t18, _t10, Math.fma(_t38, _t34, sd[7]));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t52, _t53, _t54;
        if (_t47 > 0.0) {
            _t52 = _t44 * _t48;
            _t53 = _t43 * _t48;
            _t54 = _t42 * _t48;
        } else {
            _t52 = 0.0;
            _t53 = 0.0;
            _t54 = 0.0;
        }
        dd[0] = Math.fma(Math.fma(_t32, _t52, -(_t34 * _t53)), _t8, Math.fma(Math.fma(_t34, _t54, -(_t33 * _t52)), _t9, Math.fma(_t33, _t53, -(_t32 * _t54)) * _t10)) < 0.0 ? -_t4 : _t4;
        dd[1] = Math.sqrt(_t27);
        dd[2] = Math.sqrt(_t47);
        return dest;
    }


    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeScale(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeScale_identity(dest);
        return decomposeScale_general(dest);
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Double3 decomposeSkew_identity(@Mutated Double3 dest) {
        return getEulerAnglesXYZ_identity(dest);
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Double3 decomposeSkew_translation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[7];
        dd[1] = sd[6];
        dd[2] = 0.0;
        return dest;
    }


    /**
     * Private body of {@code decomposeSkew}, specialized by runtime matrix properties; reached only
     * through the public {@code decomposeSkew} dispatcher.
     */
    private Double3 decomposeSkew_general(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = sd[2] * _t3;
            _t8 = sd[0] * _t3;
            _t9 = sd[1] * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t14 = Math.fma(sd[8], _t7, Math.fma(sd[6], _t8, sd[7] * _t9));
        double _t15 = Math.fma(sd[5], _t7, Math.fma(sd[3], _t8, sd[4] * _t9));
        double _t16 = -_t14;
        double _t17 = -_t15;
        double _t19 = Math.fma(_t17, _t7, sd[5]);
        double _t20 = Math.fma(_t17, _t8, sd[3]);
        double _t21 = Math.fma(_t17, _t9, sd[4]);
        double _t26 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t28 = _t15 * _t27;
        double _t32, _t33, _t34;
        if (_t26 > 0.0) {
            _t32 = _t19 * _t27;
            _t33 = _t20 * _t27;
            _t34 = _t21 * _t27;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t37 = Math.fma(Math.fma(_t16, _t7, sd[8]), _t32, Math.fma(Math.fma(_t16, _t8, sd[6]), _t33, Math.fma(_t16, _t9, sd[7]) * _t34));
        double _t38 = -_t37;
        double _t42 = Math.fma(_t16, _t7, Math.fma(_t38, _t32, sd[8]));
        double _t43 = Math.fma(_t16, _t8, Math.fma(_t38, _t33, sd[6]));
        double _t44 = Math.fma(_t16, _t9, Math.fma(_t38, _t34, sd[7]));
        double _t47 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, _t44 * _t44));
        double _t48 = (1.0 / Math.sqrt(_t47));
        double _t49 = _t14 * _t48;
        double _t53, _t54, _t55;
        if (_t47 > 0.0) {
            _t53 = _t44 * _t48;
            _t54 = _t43 * _t48;
            _t55 = _t42 * _t48;
        } else {
            _t53 = 0.0;
            _t54 = 0.0;
            _t55 = 0.0;
        }
        double _t67 = Math.fma(Math.fma(_t33, _t53, -(_t34 * _t54)), _t7, Math.fma(Math.fma(_t34, _t55, -(_t32 * _t53)), _t8, Math.fma(_t32, _t54, -(_t33 * _t55)) * _t9));
        if (_t67 < 0.0) {
            dd[1] = -_t49;
            dd[2] = -_t28;
        } else {
            dd[1] = _t49;
            dd[2] = _t28;
        }
        dd[0] = _t37 * _t48;
        return dest;
    }


    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 decomposeSkew(@Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return decomposeSkew_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return decomposeSkew_translation(dest);
        return decomposeSkew_general(dest);
    }


    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated public Double3x3 makeIdentity() {
        double[] dd = this.data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_IDENTITY;
        return this;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_general(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherData[1] - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherData[2] - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherData[3] - sd[3], sd[3]);
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = Math.fma(t, otherData[5] - sd[5], sd[5]);
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = Math.fma(t, otherData[8] - sd[8], sd[8]);
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_identity(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = t * otherData[2];
        dd[3] = t * otherData[3];
        dd[4] = Math.fma(t, otherData[4] - 1.0, 1.0);
        dd[5] = t * otherData[5];
        dd[6] = t * otherData[6];
        dd[7] = t * otherData[7];
        dd[8] = Math.fma(t, otherData[8] - 1.0, 1.0);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_translation(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = t * otherData[2];
        dd[3] = t * otherData[3];
        dd[4] = Math.fma(t, otherData[4] - 1.0, 1.0);
        dd[5] = t * otherData[5];
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = Math.fma(t, otherData[8] - 1.0, 1.0);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_orthogonal(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherData[1] - sd[1], sd[1]);
        dd[2] = t * otherData[2];
        dd[3] = Math.fma(t, otherData[3] - sd[3], sd[3]);
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = t * otherData[5];
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = Math.fma(t, otherData[8] - 1.0, 1.0);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_identity_identity(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_identity_translation(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = t * otherData[6];
        dd[7] = t * otherData[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_identity_affine(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = 0.0;
        dd[3] = t * otherData[3];
        dd[4] = Math.fma(t, otherData[4] - 1.0, 1.0);
        dd[5] = 0.0;
        dd[6] = t * otherData[6];
        dd[7] = t * otherData[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_translation_identity(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = Math.fma(-t, sd[6], sd[6]);
        dd[7] = Math.fma(-t, sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_translation_translation(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_translation_affine(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - 1.0, 1.0);
        dd[1] = t * otherData[1];
        dd[2] = 0.0;
        dd[3] = t * otherData[3];
        dd[4] = Math.fma(t, otherData[4] - 1.0, 1.0);
        dd[5] = 0.0;
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_orthogonal_identity(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t1 = Math.fma(-t, sd[4], t + sd[4]);
        dd[0] = _t1;
        double _buf0 = Math.fma(-t, sd[1], sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(t, sd[1], -sd[1]);
        dd[4] = _t1;
        dd[5] = 0.0;
        dd[6] = Math.fma(-t, sd[6], sd[6]);
        dd[7] = Math.fma(-t, sd[7], sd[7]);
        dd[8] = 1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_orthogonal_translation(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, 1.0 - sd[0], sd[0]);
        dd[1] = Math.fma(-t, sd[1], sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(-t, sd[3], sd[3]);
        dd[4] = Math.fma(t, 1.0 - sd[4], sd[4]);
        dd[5] = 0.0;
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_orthogonal_affine(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, otherData[0] - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherData[1] - sd[1], sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(t, otherData[3] - sd[3], sd[3]);
        dd[4] = Math.fma(t, otherData[4] - sd[4], sd[4]);
        dd[5] = 0.0;
        dd[6] = Math.fma(t, otherData[6] - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherData[7] - sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code lerp}, specialized by runtime matrix properties; reached only through
     * the public {@code lerp} dispatcher.
     */
    private Double3x3 lerp_affine_identity(Double3x3R other, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, 1.0 - sd[0], sd[0]);
        dd[1] = Math.fma(-t, sd[1], sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(-t, sd[3], sd[3]);
        dd[4] = Math.fma(t, 1.0 - sd[4], sd[4]);
        dd[5] = 0.0;
        dd[6] = Math.fma(-t, sd[6], sd[6]);
        dd[7] = Math.fma(-t, sd[7], sd[7]);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
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
    public Double3x3 lerp(Double3x3R other, double t, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_identity_affine(other, t, dest);
            return lerp_identity(other, t, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_translation_affine(other, t, dest);
            return lerp_translation(other, t, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_orthogonal_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, dest);
            return lerp_orthogonal(other, t, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, dest);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, dest);
            return lerp_orthogonal(other, t, dest);
        }
        return lerp_general(other, t, dest);
    }


    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated public Double3x3 lerp(Double3x3R other, double t) {
        if (Joml.RETURN_NEW) return lerp(other, t, Joml.double3x3());
        int p = this.properties;
        int q = ((Double3x3Impl) other).properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_identity_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_identity_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_identity_affine(other, t, this);
            return lerp_identity(other, t, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_translation_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_translation_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_translation_affine(other, t, this);
            return lerp_translation(other, t, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_orthogonal_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, this);
            return lerp_orthogonal(other, t, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return lerp_affine_identity(other, t, this);
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return lerp_orthogonal_translation(other, t, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return lerp_orthogonal_affine(other, t, this);
            return lerp_orthogonal(other, t, this);
        }
        return lerp_general(other, t, this);
    }


    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lerp(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, double t, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(t, m00 - sd[0], sd[0]);
        dd[1] = Math.fma(t, m10 - sd[1], sd[1]);
        dd[2] = Math.fma(t, m20 - sd[2], sd[2]);
        dd[3] = Math.fma(t, m01 - sd[3], sd[3]);
        dd[4] = Math.fma(t, m11 - sd[4], sd[4]);
        dd[5] = Math.fma(t, m21 - sd[5], sd[5]);
        dd[6] = Math.fma(t, m02 - sd[6], sd[6]);
        dd[7] = Math.fma(t, m12 - sd[7], sd[7]);
        dd[8] = Math.fma(t, m22 - sd[8], sd[8]);
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[2], sd[6], Math.fma(rightData[0], sd[0], rightData[1] * sd[3]));
        double _buf1 = Math.fma(rightData[2], sd[7], Math.fma(rightData[0], sd[1], rightData[1] * sd[4]));
        double _buf2 = Math.fma(rightData[2], sd[8], Math.fma(rightData[0], sd[2], rightData[1] * sd[5]));
        double _buf3 = Math.fma(rightData[5], sd[6], Math.fma(rightData[3], sd[0], rightData[4] * sd[3]));
        double _buf4 = Math.fma(rightData[5], sd[7], Math.fma(rightData[3], sd[1], rightData[4] * sd[4]));
        double _buf5 = Math.fma(rightData[5], sd[8], Math.fma(rightData[3], sd[2], rightData[4] * sd[5]));
        double _buf6 = Math.fma(rightData[8], sd[6], Math.fma(rightData[6], sd[0], rightData[7] * sd[3]));
        double _buf7 = Math.fma(rightData[8], sd[7], Math.fma(rightData[6], sd[1], rightData[7] * sd[4]));
        dd[8] = Math.fma(rightData[8], sd[8], Math.fma(rightData[6], sd[2], rightData[7] * sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(rightData[2], sd[6], rightData[0]);
        dd[1] = Math.fma(rightData[2], sd[7], rightData[1]);
        dd[2] = rightData[2];
        dd[3] = Math.fma(rightData[5], sd[6], rightData[3]);
        dd[4] = Math.fma(rightData[5], sd[7], rightData[4]);
        dd[5] = rightData[5];
        dd[6] = Math.fma(rightData[8], sd[6], rightData[6]);
        dd[7] = Math.fma(rightData[8], sd[7], rightData[7]);
        dd[8] = rightData[8];
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[2], sd[6], Math.fma(rightData[0], sd[4], -(rightData[1] * sd[1])));
        double _buf1 = Math.fma(rightData[2], sd[7], Math.fma(rightData[0], sd[1], rightData[1] * sd[4]));
        dd[2] = rightData[2];
        double _buf2 = Math.fma(rightData[5], sd[6], Math.fma(rightData[3], sd[4], -(rightData[4] * sd[1])));
        double _buf3 = Math.fma(rightData[5], sd[7], Math.fma(rightData[3], sd[1], rightData[4] * sd[4]));
        dd[5] = rightData[5];
        double _buf4 = Math.fma(rightData[8], sd[6], Math.fma(rightData[6], sd[4], -(rightData[7] * sd[1])));
        dd[7] = Math.fma(rightData[8], sd[7], Math.fma(rightData[6], sd[1], rightData[7] * sd[4]));
        dd[8] = rightData[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_affine(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[2], sd[6], Math.fma(rightData[0], sd[0], rightData[1] * sd[3]));
        double _buf1 = Math.fma(rightData[2], sd[7], Math.fma(rightData[0], sd[1], rightData[1] * sd[4]));
        dd[2] = rightData[2];
        double _buf2 = Math.fma(rightData[5], sd[6], Math.fma(rightData[3], sd[0], rightData[4] * sd[3]));
        double _buf3 = Math.fma(rightData[5], sd[7], Math.fma(rightData[3], sd[1], rightData[4] * sd[4]));
        dd[5] = rightData[5];
        double _buf4 = Math.fma(rightData[8], sd[6], Math.fma(rightData[6], sd[0], rightData[7] * sd[3]));
        dd[7] = Math.fma(rightData[8], sd[7], Math.fma(rightData[6], sd[1], rightData[7] * sd[4]));
        dd[8] = rightData[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_translation(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = rightData[6] + sd[6];
        dd[7] = rightData[7] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_affine(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = 0.0;
        dd[3] = rightData[3];
        dd[4] = rightData[4];
        dd[5] = 0.0;
        dd[6] = rightData[6] + sd[6];
        dd[7] = rightData[7] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_translation(Double3x3R right, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        dd[2] = 0.0;
        double _buf2 = sd[3];
        double _buf3 = sd[4];
        dd[5] = 0.0;
        double _buf4 = Math.fma(rightData[6], sd[0], Math.fma(rightData[7], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_affine(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[4], -(rightData[1] * sd[1]));
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        double _buf2 = Math.fma(rightData[3], sd[4], -(rightData[4] * sd[1]));
        double _buf3 = Math.fma(rightData[3], sd[1], rightData[4] * sd[4]);
        dd[5] = 0.0;
        double _buf4 = Math.fma(-rightData[7], sd[1], Math.fma(rightData[6], sd[4], sd[6]));
        dd[7] = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_affine_affine(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        double _buf2 = Math.fma(rightData[3], sd[0], rightData[4] * sd[3]);
        double _buf3 = Math.fma(rightData[3], sd[1], rightData[4] * sd[4]);
        dd[5] = 0.0;
        double _buf4 = Math.fma(rightData[6], sd[0], Math.fma(rightData[7], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general_translation(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        double _buf4 = sd[4];
        double _buf5 = sd[5];
        double _buf6 = Math.fma(rightData[6], sd[0], Math.fma(rightData[7], sd[3], sd[6]));
        double _buf7 = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[4], sd[7]));
        dd[8] = Math.fma(rightData[6], sd[2], Math.fma(rightData[7], sd[5], sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general_affine(Double3x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double3x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        double _buf2 = Math.fma(rightData[0], sd[2], rightData[1] * sd[5]);
        double _buf3 = Math.fma(rightData[3], sd[0], rightData[4] * sd[3]);
        double _buf4 = Math.fma(rightData[3], sd[1], rightData[4] * sd[4]);
        double _buf5 = Math.fma(rightData[3], sd[2], rightData[4] * sd[5]);
        double _buf6 = Math.fma(rightData[6], sd[0], Math.fma(rightData[7], sd[3], sd[6]));
        double _buf7 = Math.fma(rightData[6], sd[1], Math.fma(rightData[7], sd[4], sd[7]));
        dd[8] = Math.fma(rightData[6], sd[2], Math.fma(rightData[7], sd[5], sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(Double3x3R right, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(right);
        int q = ((Double3x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_orthogonal_affine(right, dest);
            return mul_orthogonal(right, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_affine(right, dest);
            return mul_affine(right, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_general_affine(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x3 mul(Double3x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(right);
        int q = ((Double3x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_translation_affine(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_orthogonal_affine(right, this);
            return mul_orthogonal(right, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_affine(right, this);
            return mul_affine(right, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_general_affine(right, this);
        return mul_general(right, this);
    }


    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}, {@code m20}, {@code m21}, {@code m22}) and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 mul(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(m20, sd[6], Math.fma(m00, sd[0], m10 * sd[3]));
        double _buf1 = Math.fma(m20, sd[7], Math.fma(m00, sd[1], m10 * sd[4]));
        double _buf2 = Math.fma(m20, sd[8], Math.fma(m00, sd[2], m10 * sd[5]));
        double _buf3 = Math.fma(m21, sd[6], Math.fma(m01, sd[0], m11 * sd[3]));
        double _buf4 = Math.fma(m21, sd[7], Math.fma(m01, sd[1], m11 * sd[4]));
        double _buf5 = Math.fma(m21, sd[8], Math.fma(m01, sd[2], m11 * sd[5]));
        dd[6] = Math.fma(m22, sd[6], Math.fma(m02, sd[0], m12 * sd[3]));
        dd[7] = Math.fma(m22, sd[7], Math.fma(m02, sd[1], m12 * sd[4]));
        dd[8] = Math.fma(m22, sd[8], Math.fma(m02, sd[2], m12 * sd[5]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_identity(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = 0.0;
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x3 mul_identity_self(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = 0.0;
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_self(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(rightData[0], sd[4], -(rightData[1] * sd[1]));
        double _buf0 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        dd[3] = Math.fma(rightData[2], sd[4], -(rightData[3] * sd[1]));
        dd[4] = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_self(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(rightData[0], sd[4], -(rightData[1] * sd[1]));
        double _buf0 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[3] = Math.fma(rightData[2], sd[4], -(rightData[3] * sd[1]));
        dd[4] = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) right).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_affine(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        dd[3] = Math.fma(rightData[2], sd[0], rightData[3] * sd[3]);
        dd[4] = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code mul}, specialized by runtime matrix properties;
     * reached only through the public {@code mul} dispatcher.
     */
    private Double3x3 mul_affine_self(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[3] = Math.fma(rightData[2], sd[0], rightData[3] * sd[3]);
        dd[4] = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general(Double2x2R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x2Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        double _buf2 = Math.fma(rightData[0], sd[2], rightData[1] * sd[5]);
        dd[3] = Math.fma(rightData[2], sd[0], rightData[3] * sd[3]);
        dd[4] = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[5] = Math.fma(rightData[2], sd[2], rightData[3] * sd[5]);
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
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
    public Double3x3 mul(Double2x2R right, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(right, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(right, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal(right, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x3 mul(Double2x2R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity_self(right, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_self(right, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return mul_orthogonal_self(right, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return mul_affine_self(right, this);
        return mul_general(right, this);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        double _buf2 = Math.fma(rightData[0], sd[2], rightData[1] * sd[5]);
        double _buf3 = Math.fma(rightData[2], sd[0], rightData[3] * sd[3]);
        double _buf4 = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        double _buf5 = Math.fma(rightData[2], sd[2], rightData[3] * sd[5]);
        dd[6] = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[4], sd[7]));
        dd[8] = Math.fma(rightData[4], sd[2], Math.fma(rightData[5], sd[5], sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_identity(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = 0.0;
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        dd[5] = 0.0;
        dd[6] = rightData[4];
        dd[7] = rightData[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = rightData[0];
        dd[1] = rightData[1];
        dd[2] = 0.0;
        dd[3] = rightData[2];
        dd[4] = rightData[3];
        dd[5] = 0.0;
        dd[6] = rightData[4] + sd[6];
        dd[7] = rightData[5] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(rightData[0], sd[4], -(rightData[1] * sd[1]));
        double _buf0 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        dd[3] = Math.fma(rightData[2], sd[4], -(rightData[3] * sd[1]));
        double _buf1 = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[5] = 0.0;
        dd[6] = Math.fma(-rightData[5], sd[1], Math.fma(rightData[4], sd[4], sd[6]));
        dd[7] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_affine(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(rightData[0], sd[0], rightData[1] * sd[3]);
        double _buf1 = Math.fma(rightData[0], sd[1], rightData[1] * sd[4]);
        dd[2] = 0.0;
        double _buf2 = Math.fma(rightData[2], sd[0], rightData[3] * sd[3]);
        double _buf3 = Math.fma(rightData[2], sd[1], rightData[3] * sd[4]);
        dd[5] = 0.0;
        dd[6] = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_identity_translation(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = rightData[4];
        dd[7] = rightData[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_translation_translation(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = rightData[4] + sd[6];
        dd[7] = rightData[5] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) right).properties;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_orthogonal_translation(Double2x3R right, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        dd[2] = 0.0;
        double _buf2 = sd[3];
        double _buf3 = sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[4], sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3x3 mul_general_translation(Double2x3R right, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] rightData = ((Double2x3Impl) right).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        double _buf4 = sd[4];
        double _buf5 = sd[5];
        dd[6] = Math.fma(rightData[4], sd[0], Math.fma(rightData[5], sd[3], sd[6]));
        dd[7] = Math.fma(rightData[4], sd[1], Math.fma(rightData[5], sd[4], sd[7]));
        dd[8] = Math.fma(rightData[4], sd[2], Math.fma(rightData[5], sd[5], sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
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
    public Double3x3 mul(Double2x3R right, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_identity_translation(right, dest);
            return mul_identity(right, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, dest);
            return mul_translation(right, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, dest, Joml.BIT_AFFINE & q);
            return mul_affine(right, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, dest);
        return mul_general(right, dest);
    }


    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated public Double3x3 mul(Double2x3R right) {
        if (Joml.RETURN_NEW) return mul(right, Joml.double3x3());
        int p = this.properties;
        int q = ((Double2x3Impl) right).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_identity_translation(right, this);
            return mul_identity(right, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation_translation(right, this);
            return mul_translation(right, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_ORTHOGONAL & q);
            return mul_orthogonal(right, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_orthogonal_translation(right, this, Joml.BIT_AFFINE & q);
            return mul_affine(right, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_general_translation(right, this);
        return mul_general(right, this);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[6], sd[2], Math.fma(otherData[0], sd[0], otherData[3] * sd[1]));
        double _buf1 = Math.fma(otherData[7], sd[2], Math.fma(otherData[1], sd[0], otherData[4] * sd[1]));
        double _buf2 = Math.fma(otherData[8], sd[2], Math.fma(otherData[2], sd[0], otherData[5] * sd[1]));
        double _buf3 = Math.fma(otherData[6], sd[5], Math.fma(otherData[0], sd[3], otherData[3] * sd[4]));
        double _buf4 = Math.fma(otherData[7], sd[5], Math.fma(otherData[1], sd[3], otherData[4] * sd[4]));
        double _buf5 = Math.fma(otherData[8], sd[5], Math.fma(otherData[2], sd[3], otherData[5] * sd[4]));
        double _buf6 = Math.fma(otherData[6], sd[8], Math.fma(otherData[0], sd[6], otherData[3] * sd[7]));
        double _buf7 = Math.fma(otherData[7], sd[8], Math.fma(otherData[1], sd[6], otherData[4] * sd[7]));
        dd[8] = Math.fma(otherData[8], sd[8], Math.fma(otherData[2], sd[6], otherData[5] * sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = otherData[0];
        double _buf1 = otherData[1];
        double _buf2 = otherData[2];
        double _buf3 = otherData[3];
        double _buf4 = otherData[4];
        double _buf5 = otherData[5];
        double _buf6 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[6], Math.fma(otherData[5], sd[7], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[4], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[4], otherData[4] * sd[1]);
        double _buf2 = Math.fma(otherData[2], sd[4], otherData[5] * sd[1]);
        double _buf3 = Math.fma(otherData[3], sd[4], -(otherData[0] * sd[1]));
        double _buf4 = Math.fma(otherData[4], sd[4], -(otherData[1] * sd[1]));
        double _buf5 = Math.fma(otherData[5], sd[4], -(otherData[2] * sd[1]));
        double _buf6 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[6], Math.fma(otherData[5], sd[7], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[0], otherData[4] * sd[1]);
        double _buf2 = Math.fma(otherData[2], sd[0], otherData[5] * sd[1]);
        double _buf3 = Math.fma(otherData[0], sd[3], otherData[3] * sd[4]);
        double _buf4 = Math.fma(otherData[1], sd[3], otherData[4] * sd[4]);
        double _buf5 = Math.fma(otherData[2], sd[3], otherData[5] * sd[4]);
        double _buf6 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        double _buf7 = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = Math.fma(otherData[2], sd[6], Math.fma(otherData[5], sd[7], otherData[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = otherData[0];
        double _buf1 = otherData[1];
        dd[2] = 0.0;
        double _buf2 = otherData[3];
        double _buf3 = otherData[4];
        dd[5] = 0.0;
        double _buf4 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_translation(Double3x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = otherData[6] + sd[6];
        dd[7] = otherData[7] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[4], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[4], otherData[4] * sd[1]);
        dd[2] = 0.0;
        double _buf2 = Math.fma(otherData[3], sd[4], -(otherData[0] * sd[1]));
        double _buf3 = Math.fma(otherData[4], sd[4], -(otherData[1] * sd[1]));
        dd[5] = 0.0;
        double _buf4 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_affine_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[1], sd[0], otherData[4] * sd[1]);
        dd[2] = 0.0;
        double _buf2 = Math.fma(otherData[0], sd[3], otherData[3] * sd[4]);
        double _buf3 = Math.fma(otherData[1], sd[3], otherData[4] * sd[4]);
        dd[5] = 0.0;
        double _buf4 = Math.fma(otherData[0], sd[6], Math.fma(otherData[3], sd[7], otherData[6]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[4], sd[7], otherData[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double3x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general_translation(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(otherData[6], sd[2], sd[0]);
        dd[1] = Math.fma(otherData[7], sd[2], sd[1]);
        dd[2] = sd[2];
        dd[3] = Math.fma(otherData[6], sd[5], sd[3]);
        dd[4] = Math.fma(otherData[7], sd[5], sd[4]);
        dd[5] = sd[5];
        dd[6] = Math.fma(otherData[6], sd[8], sd[6]);
        dd[7] = Math.fma(otherData[7], sd[8], sd[7]);
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general_affine(Double3x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double3x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[6], sd[2], Math.fma(otherData[0], sd[0], otherData[3] * sd[1]));
        double _buf1 = Math.fma(otherData[7], sd[2], Math.fma(otherData[1], sd[0], otherData[4] * sd[1]));
        dd[2] = sd[2];
        double _buf2 = Math.fma(otherData[6], sd[5], Math.fma(otherData[0], sd[3], otherData[3] * sd[4]));
        double _buf3 = Math.fma(otherData[7], sd[5], Math.fma(otherData[1], sd[3], otherData[4] * sd[4]));
        dd[5] = sd[5];
        double _buf4 = Math.fma(otherData[6], sd[8], Math.fma(otherData[0], sd[6], otherData[3] * sd[7]));
        dd[7] = Math.fma(otherData[7], sd[8], Math.fma(otherData[1], sd[6], otherData[4] * sd[7]));
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
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
    public Double3x3 preMul(Double3x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(other);
        int q = ((Double3x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_orthogonal_affine(other, dest);
            return preMul_orthogonal(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_affine(other, dest);
            return preMul_affine(other, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, dest);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_general_affine(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply the transformation {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 preMul(Double3x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this.set(other);
        int q = ((Double3x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_translation_affine(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_orthogonal_affine(other, this);
            return preMul_orthogonal(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
            if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_affine(other, this);
            return preMul_affine(other, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, this);
        if ((q & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_general_affine(other, this);
        return preMul_general(other, this);
    }


    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) onto this matrix and store
     * the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(m02, sd[2], Math.fma(m00, sd[0], m01 * sd[1]));
        double _buf1 = Math.fma(m12, sd[2], Math.fma(m10, sd[0], m11 * sd[1]));
        dd[2] = Math.fma(m22, sd[2], Math.fma(m20, sd[0], m21 * sd[1]));
        double _buf2 = Math.fma(m02, sd[5], Math.fma(m00, sd[3], m01 * sd[4]));
        double _buf3 = Math.fma(m12, sd[5], Math.fma(m10, sd[3], m11 * sd[4]));
        dd[5] = Math.fma(m22, sd[5], Math.fma(m20, sd[3], m21 * sd[4]));
        double _buf4 = Math.fma(m02, sd[8], Math.fma(m00, sd[6], m01 * sd[7]));
        double _buf5 = Math.fma(m12, sd[8], Math.fma(m10, sd[6], m11 * sd[7]));
        dd[8] = Math.fma(m22, sd[8], Math.fma(m20, sd[6], m21 * sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_identity(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_identity_self(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_IDENTITY : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        dd[5] = 0.0;
        double _buf0 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[8] = 1.0;
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_self(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        double _buf0 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_TRANSLATION : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(otherData[0], sd[4], otherData[2] * sd[1]);
        double _buf0 = Math.fma(otherData[1], sd[4], otherData[3] * sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(otherData[2], sd[4], -(otherData[0] * sd[1]));
        dd[4] = Math.fma(otherData[3], sd[4], -(otherData[1] * sd[1]));
        dd[5] = 0.0;
        double _buf1 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[6] = _buf1;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_self(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(otherData[0], sd[4], otherData[2] * sd[1]);
        double _buf0 = Math.fma(otherData[1], sd[4], otherData[3] * sd[1]);
        dd[3] = Math.fma(otherData[2], sd[4], -(otherData[0] * sd[1]));
        dd[4] = Math.fma(otherData[3], sd[4], -(otherData[1] * sd[1]));
        double _buf1 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[1] = _buf0;
        dd[6] = _buf1;
        ((Double3x3Impl) dest).properties = (((Double2x2Impl) other).properties & Joml.UNIQUE_IDENTITY) != 0 ? Joml.BIT_ORTHOGONAL : Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_affine(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        dd[2] = 0.0;
        double _buf1 = Math.fma(otherData[0], sd[3], otherData[2] * sd[4]);
        dd[4] = Math.fma(otherData[1], sd[3], otherData[3] * sd[4]);
        dd[5] = 0.0;
        double _buf2 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preMul}, specialized by runtime matrix properties;
     * reached only through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_affine_self(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        double _buf1 = Math.fma(otherData[0], sd[3], otherData[2] * sd[4]);
        dd[4] = Math.fma(otherData[1], sd[3], otherData[3] * sd[4]);
        double _buf2 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general(Double2x2R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x2Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        dd[2] = sd[2];
        double _buf1 = Math.fma(otherData[0], sd[3], otherData[2] * sd[4]);
        dd[4] = Math.fma(otherData[1], sd[3], otherData[3] * sd[4]);
        dd[5] = sd[5];
        double _buf2 = Math.fma(otherData[0], sd[6], otherData[2] * sd[7]);
        dd[7] = Math.fma(otherData[1], sd[6], otherData[3] * sd[7]);
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Double2x2R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity(other, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation(other, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal(other, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 preMul(Double2x2R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preMul_identity_self(other, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_self(other, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preMul_orthogonal_self(other, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preMul_affine_self(other, this);
        return preMul_general(other, this);
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[4], sd[2], Math.fma(otherData[0], sd[0], otherData[2] * sd[1]));
        dd[1] = Math.fma(otherData[5], sd[2], Math.fma(otherData[1], sd[0], otherData[3] * sd[1]));
        dd[2] = sd[2];
        double _buf1 = Math.fma(otherData[4], sd[5], Math.fma(otherData[0], sd[3], otherData[2] * sd[4]));
        dd[4] = Math.fma(otherData[5], sd[5], Math.fma(otherData[1], sd[3], otherData[3] * sd[4]));
        dd[5] = sd[5];
        double _buf2 = Math.fma(otherData[4], sd[8], Math.fma(otherData[0], sd[6], otherData[2] * sd[7]));
        dd[7] = Math.fma(otherData[5], sd[8], Math.fma(otherData[1], sd[6], otherData[3] * sd[7]));
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_identity(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        dd[5] = 0.0;
        dd[6] = otherData[4];
        dd[7] = otherData[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = otherData[0];
        dd[1] = otherData[1];
        dd[2] = 0.0;
        dd[3] = otherData[2];
        dd[4] = otherData[3];
        dd[5] = 0.0;
        double _buf0 = Math.fma(otherData[0], sd[6], Math.fma(otherData[2], sd[7], otherData[4]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[3], sd[7], otherData[5]));
        dd[8] = 1.0;
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(otherData[0], sd[4], otherData[2] * sd[1]);
        double _buf0 = Math.fma(otherData[1], sd[4], otherData[3] * sd[1]);
        dd[2] = 0.0;
        dd[3] = Math.fma(otherData[2], sd[4], -(otherData[0] * sd[1]));
        dd[4] = Math.fma(otherData[3], sd[4], -(otherData[1] * sd[1]));
        dd[5] = 0.0;
        double _buf1 = Math.fma(otherData[0], sd[6], Math.fma(otherData[2], sd[7], otherData[4]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[3], sd[7], otherData[5]));
        dd[8] = 1.0;
        dd[1] = _buf0;
        dd[6] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_affine(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[0], otherData[2] * sd[1]);
        dd[1] = Math.fma(otherData[1], sd[0], otherData[3] * sd[1]);
        dd[2] = 0.0;
        double _buf1 = Math.fma(otherData[0], sd[3], otherData[2] * sd[4]);
        dd[4] = Math.fma(otherData[1], sd[3], otherData[3] * sd[4]);
        dd[5] = 0.0;
        double _buf2 = Math.fma(otherData[0], sd[6], Math.fma(otherData[2], sd[7], otherData[4]));
        dd[7] = Math.fma(otherData[1], sd[6], Math.fma(otherData[3], sd[7], otherData[5]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_identity_translation(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = otherData[4];
        dd[7] = otherData[5];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_translation_translation(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = otherData[4] + sd[6];
        dd[7] = otherData[5] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION & ((Double2x3Impl) other).properties;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_orthogonal_translation(Double2x3R other, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = otherData[4] + sd[6];
        dd[7] = otherData[5] + sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preMul}, specialized by runtime matrix properties; reached only
     * through the public {@code preMul} dispatcher.
     */
    private Double3x3 preMul_general_translation(Double2x3R other, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] otherData = ((Double2x3Impl) other).data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(otherData[4], sd[2], sd[0]);
        dd[1] = Math.fma(otherData[5], sd[2], sd[1]);
        dd[2] = sd[2];
        dd[3] = Math.fma(otherData[4], sd[5], sd[3]);
        dd[4] = Math.fma(otherData[5], sd[5], sd[4]);
        dd[5] = sd[5];
        dd[6] = Math.fma(otherData[4], sd[8], sd[6]);
        dd[7] = Math.fma(otherData[5], sd[8], sd[7]);
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preMul(Double2x3R other, @Mutated Double3x3 dest) {
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return dest.set(this);
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_identity_translation(other, dest);
            return preMul_identity(other, dest);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, dest);
            return preMul_translation(other, dest);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, dest);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, dest, Joml.BIT_AFFINE & q);
            return preMul_affine(other, dest);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, dest);
        return preMul_general(other, dest);
    }


    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated public Double3x3 preMul(Double2x3R other) {
        if (Joml.RETURN_NEW) return preMul(other, Joml.double3x3());
        int p = this.properties;
        int q = ((Double2x3Impl) other).properties;
        if ((q & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return this;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_identity_translation(other, this);
            return preMul_identity(other, this);
        }
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_translation_translation(other, this);
            return preMul_translation(other, this);
        }
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_ORTHOGONAL & q);
            return preMul_orthogonal(other, this);
        }
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) {
            if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_orthogonal_translation(other, this, Joml.BIT_AFFINE & q);
            return preMul_affine(other, this);
        }
        if ((q & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preMul_general_translation(other, this);
        return preMul_general(other, this);
    }


    /**
     * Set this matrix to the outer product of {@code col} and {@code row}.
     *
     * @param col the column vector (left operand)
     * @param row the row vector (right operand)
     * @return this
     */
    public @Mutated Double3x3 makeOuterProduct(Double3R col, Double3R row) {
        return makeOuterProduct(col.x(), col.y(), col.z(), row.x(), row.y(), row.z());
    }


    /**
     * Set this matrix to the outer product of ({@code colX}, {@code colY}, {@code colZ}) and
     * ({@code rowX}, {@code rowY}, {@code rowZ}).
     *
     * @param colX the {@code x} component of the vector {@code (colX, colY, colZ)}
     * @param colY the {@code y} component of the vector {@code (colX, colY, colZ)}
     * @param colZ the {@code z} component of the vector {@code (colX, colY, colZ)}
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @return this
     */
    @Mutated public Double3x3 makeOuterProduct(double colX, double colY, double colZ, double rowX, double rowY, double rowZ) {
        double[] dd = this.data;
        dd[0] = colX * rowX;
        dd[1] = colY * rowX;
        dd[2] = colZ * rowX;
        dd[3] = colX * rowY;
        dd[4] = colY * rowY;
        dd[5] = colZ * rowY;
        dd[6] = colX * rowZ;
        dd[7] = colY * rowZ;
        dd[8] = colZ * rowZ;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lookAlong(Double3R dir, Double3R up, @Mutated Double3x3 dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Double3x3 lookAlong(Double3R dir, Double3R up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t16 * _t22;
            _t27 = _t17 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        double _t35 = Math.fma(_t8, _t28, -(_t7 * _t27));
        double _t36 = Math.fma(_t7, _t26, -(_t9 * _t28));
        double _t37 = Math.fma(_t9, _t27, -(_t8 * _t26));
        double _buf0 = Math.fma(sd[6], _t26, Math.fma(sd[0], _t27, sd[3] * _t28));
        double _buf1 = Math.fma(sd[7], _t26, Math.fma(sd[1], _t27, sd[4] * _t28));
        double _buf2 = Math.fma(sd[8], _t26, Math.fma(sd[2], _t27, sd[5] * _t28));
        double _buf3 = Math.fma(sd[6], _t35, Math.fma(sd[0], _t36, sd[3] * _t37));
        double _buf4 = Math.fma(sd[7], _t35, Math.fma(sd[1], _t36, sd[4] * _t37));
        double _buf5 = Math.fma(sd[8], _t35, Math.fma(sd[2], _t36, sd[5] * _t37));
        dd[6] = Math.fma(sd[6], _t9, Math.fma(sd[0], _t8, sd[3] * _t7));
        dd[7] = Math.fma(sd[7], _t9, Math.fma(sd[1], _t8, sd[4] * _t7));
        dd[8] = Math.fma(sd[8], _t9, Math.fma(sd[2], _t8, sd[5] * _t7));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set this matrix to the rotation part of the unit dual quaternion {@code dq} (the encoded
     * translation is dropped).
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return this
     */
    public @Mutated Double3x3 makeFromDualQuat(DoubleDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this matrix to the rotation part of the unit dual quaternion ({@code dqRX}, {@code dqRY},
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
     * @return this
     */
    @Mutated public Double3x3 makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        double[] dd = this.data;
        double _t0 = dqRY * dqRY;
        double _t2 = dqRZ * dqRW;
        double _t3 = dqRY * dqRW;
        double _t4 = dqRX * dqRX;
        double _t5 = dqRY * dqRZ;
        double _t6 = Math.fma(-2.0, dqRZ * dqRZ, 1.0);
        dd[0] = Math.fma(-2.0, _t0, _t6);
        dd[1] = 2.0 * Math.fma(dqRX, dqRY, _t2);
        dd[2] = Math.fma(-2.0, _t3, 2.0 * dqRX * dqRZ);
        dd[3] = Math.fma(-2.0, _t2, 2.0 * dqRX * dqRY);
        dd[4] = Math.fma(-2.0, _t4, _t6);
        dd[5] = 2.0 * Math.fma(dqRX, dqRW, _t5);
        dd[6] = 2.0 * Math.fma(dqRX, dqRZ, _t3);
        dd[7] = Math.fma(-2.0, dqRX * dqRW, 2.0 * _t5);
        dd[8] = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 makeRotation(double angle) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x3 makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public Double3x3 makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        dd[0] = Math.fma(_t2, axisX * axisX, _t0);
        dd[1] = Math.fma(axisZ, _t1, _t2 * _t3);
        dd[2] = Math.fma(_t2, _t4, -(axisY * _t1));
        dd[3] = Math.fma(_t2, _t3, -(axisZ * _t1));
        dd[4] = Math.fma(_t2, axisY * axisY, _t0);
        dd[5] = Math.fma(axisX, _t1, _t2 * _t5);
        dd[6] = Math.fma(axisY, _t1, _t2 * _t4);
        dd[7] = Math.fma(_t2, _t5, -(axisX * _t1));
        dd[8] = Math.fma(_t2, axisZ * axisZ, _t0);
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated Double3x3 makeRotationLookAlong(Double3R dir, Double3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this matrix to a rotation that makes {@code +z} point along ({@code dirX}, {@code dirY},
     * {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public Double3x3 makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirY * _t3;
            _t8 = dirX * _t3;
            _t9 = dirZ * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t16 = Math.fma(upX, _t7, -(upY * _t8));
        double _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        double _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        double _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        double _t22 = (1.0 / Math.sqrt(_t21));
        double _t26, _t27, _t28;
        if (_t21 > 0.0) {
            _t26 = _t17 * _t22;
            _t27 = _t16 * _t22;
            _t28 = _t18 * _t22;
        } else {
            _t26 = 0.0;
            _t27 = 0.0;
            _t28 = 0.0;
        }
        dd[0] = _t26;
        dd[1] = _t28;
        dd[2] = _t27;
        dd[3] = Math.fma(_t7, _t27, -(_t9 * _t28));
        dd[4] = Math.fma(_t9, _t26, -(_t8 * _t27));
        dd[5] = Math.fma(_t8, _t28, -(_t7 * _t26));
        dd[6] = _t8;
        dd[7] = _t7;
        dd[8] = _t9;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    public @Mutated Double3x3 makeRotationQuat(DoubleQuatR q) {
        return makeRotationQuat(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Set this matrix to the rotation represented by the quaternion ({@code qX}, {@code qY},
     * {@code qZ}, {@code qW}).
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return this
     */
    @Mutated public Double3x3 makeRotationQuat(double qX, double qY, double qZ, double qW) {
        double[] dd = this.data;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        dd[0] = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        dd[1] = 2.0 * Math.fma(qX, qY, _t1);
        dd[2] = 2.0 * Math.fma(qX, qZ, -_t2);
        dd[3] = 2.0 * Math.fma(qX, qY, -_t1);
        dd[4] = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        dd[5] = 2.0 * Math.fma(qX, qW, qY * qZ);
        dd[6] = 2.0 * Math.fma(qX, qZ, _t2);
        dd[7] = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        dd[8] = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 makeRotationX(double angle) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = _t0;
        dd[5] = _t1;
        dd[6] = 0.0;
        dd[7] = -_t1;
        dd[8] = _t0;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians
     * about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationXYZ(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        dd[0] = _t0 * _t1;
        dd[1] = Math.fma(_t6, _t1, _t2 * _t5);
        dd[2] = Math.fma(_t4, _t2, -(_t7 * _t1));
        dd[3] = -(_t2 * _t0);
        dd[4] = Math.fma(_t5, _t1, -(_t6 * _t2));
        dd[5] = Math.fma(_t7, _t2, _t4 * _t1);
        dd[6] = _t3;
        dd[7] = -(_t4 * _t0);
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians
     * about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationXZY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        dd[0] = _t0 * _t1;
        dd[1] = Math.fma(_t6, _t0, _t5 * _t3);
        dd[2] = Math.fma(_t7, _t0, -(_t3 * _t4));
        dd[3] = -_t2;
        dd[4] = _t4 * _t1;
        dd[5] = _t5 * _t1;
        dd[6] = _t3 * _t1;
        dd[7] = Math.fma(_t6, _t3, -(_t5 * _t0));
        dd[8] = Math.fma(_t7, _t3, _t4 * _t0);
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 makeRotationY(double angle) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = 0.0;
        dd[2] = -_t1;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = _t1;
        dd[7] = 0.0;
        dd[8] = _t0;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians
     * about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationYXZ(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        dd[0] = Math.fma(_t6, _t2, _t3 * _t4);
        dd[1] = _t2 * _t5;
        dd[2] = Math.fma(_t7, _t2, -(_t1 * _t4));
        dd[3] = Math.fma(_t6, _t4, -(_t2 * _t3));
        dd[4] = _t5 * _t4;
        dd[5] = Math.fma(_t7, _t4, _t1 * _t2);
        dd[6] = _t1 * _t5;
        dd[7] = -_t0;
        dd[8] = _t5 * _t3;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians
     * about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationYZX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        dd[0] = _t0 * _t1;
        dd[1] = _t4;
        dd[2] = -(_t3 * _t1);
        dd[3] = Math.fma(_t2, _t3, -(_t6 * _t5));
        dd[4] = _t5 * _t1;
        dd[5] = Math.fma(_t7, _t5, _t2 * _t0);
        dd[6] = Math.fma(_t6, _t2, _t3 * _t5);
        dd[7] = -(_t2 * _t1);
        dd[8] = Math.fma(_t5, _t0, -(_t7 * _t2));
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 makeRotationZ(double angle) {
        double[] dd = this.data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_ORTHOGONAL;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians
     * about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationZXY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        dd[0] = Math.fma(_t0, _t1, -(_t6 * _t4));
        dd[1] = Math.fma(_t7, _t4, _t3 * _t0);
        dd[2] = -(_t4 * _t5);
        dd[3] = -(_t3 * _t5);
        dd[4] = _t5 * _t1;
        dd[5] = _t2;
        dd[6] = Math.fma(_t6, _t0, _t4 * _t1);
        dd[7] = Math.fma(_t4, _t3, -(_t7 * _t0));
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians
     * about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 makeRotationZYX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        dd[0] = _t0 * _t1;
        dd[1] = _t4 * _t0;
        dd[2] = -_t2;
        dd[3] = Math.fma(_t6, _t3, -(_t4 * _t5));
        dd[4] = Math.fma(_t7, _t3, _t5 * _t1);
        dd[5] = _t3 * _t0;
        dd[6] = Math.fma(_t6, _t5, _t3 * _t4);
        dd[7] = Math.fma(_t7, _t5, -(_t3 * _t1));
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) this).properties = 0;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x3 makeScaling(Double2R v) {
        return makeScaling(v.x(), v.y());
    }


    /**
     * Set this matrix to a scaling transformation that scales by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 makeScaling(double vX, double vY) {
        double[] dd = this.data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = vY;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x3 makeScaling(double s) {
        double[] dd = this.data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Double3x3 makeTranslation(Double2R v) {
        return makeTranslation(v.x(), v.y());
    }


    /**
     * Set this matrix to a translation transformation that translates by ({@code vX}, {@code vY}).
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 makeTranslation(double vX, double vY) {
        double[] dd = this.data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = vX;
        dd[7] = vY;
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_TRANSLATION;
        return this;
    }


    /**
     * Set this matrix to the 2D view transformation that maps the rectangle
     * {@code [left, right] x [bottom, top]} onto {@code [-1, +1] x [-1, +1]}.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this
     */
    @Mutated public Double3x3 makeView(double left, double right, double bottom, double top) {
        double[] dd = this.data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0 * _t1_inv;
        dd[5] = 0.0;
        dd[6] = -((left + right) * _t0_inv);
        dd[7] = -((bottom + top) * _t1_inv);
        dd[8] = 1.0;
        ((Double3x3Impl) this).properties = Joml.BIT_AFFINE;
        return this;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_orthogonal_affine(double angle, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        dd[2] = 0.0;
        double _buf1 = Math.fma(sd[3], _t0, -(sd[4] * _t1));
        dd[4] = Math.fma(sd[3], _t1, sd[4] * _t0);
        dd[5] = 0.0;
        double _buf2 = Math.fma(sd[6], _t0, -(sd[7] * _t1));
        dd[7] = Math.fma(sd[6], _t1, sd[7] * _t0);
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_orthogonal_affine_self(double angle, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        double _buf1 = Math.fma(sd[3], _t0, -(sd[4] * _t1));
        dd[4] = Math.fma(sd[3], _t1, sd[4] * _t0);
        double _buf2 = Math.fma(sd[6], _t0, -(sd[7] * _t1));
        dd[7] = Math.fma(sd[6], _t1, sd[7] * _t0);
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_identity(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_identity_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        double _buf0 = Math.fma(sd[6], _t0, -(sd[7] * _t1));
        dd[7] = Math.fma(sd[6], _t1, sd[7] * _t0);
        dd[8] = 1.0;
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotate}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        double _buf0 = Math.fma(sd[6], _t0, -(sd[7] * _t1));
        dd[7] = Math.fma(sd[6], _t1, sd[7] * _t0);
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotate}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotate} dispatcher.
     */
    private Double3x3 preRotate_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        dd[2] = sd[2];
        double _buf1 = Math.fma(sd[3], _t0, -(sd[4] * _t1));
        dd[4] = Math.fma(sd[3], _t1, sd[4] * _t0);
        dd[5] = sd[5];
        double _buf2 = Math.fma(sd[6], _t0, -(sd[7] * _t1));
        dd[7] = Math.fma(sd[6], _t1, sd[7] * _t0);
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotate(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_orthogonal_affine(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotate_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 preRotate(double angle) {
        if (Joml.RETURN_NEW) return preRotate(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotate_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotate_orthogonal_affine_self(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotate_general(angle, this);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAround(double angle, Double2R pivot, @Mutated Double3x3 dest) {
        return preRotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 preRotateAround(double angle, Double2R pivot) {
        return preRotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_orthogonal_affine(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        dd[2] = 0.0;
        double _buf1 = Math.fma(sd[3], _t0, -(sd[4] * _t1));
        dd[4] = Math.fma(sd[3], _t1, sd[4] * _t0);
        dd[5] = 0.0;
        double _buf2 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(sd[6], _t0, Math.fma(-sd[7], _t1, pivotX))));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(sd[6], _t1, Math.fma(sd[7], _t0, pivotY))));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_orthogonal_affine_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        double _buf1 = Math.fma(sd[3], _t0, -(sd[4] * _t1));
        dd[4] = Math.fma(sd[3], _t1, sd[4] * _t0);
        double _buf2 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(sd[6], _t0, Math.fma(-sd[7], _t1, pivotX))));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(sd[6], _t1, Math.fma(sd[7], _t0, pivotY))));
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_identity(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_identity_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[6] = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_translation(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        double _buf0 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(sd[6], _t0, Math.fma(-sd[7], _t1, pivotX))));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(sd[6], _t1, Math.fma(sd[7], _t0, pivotY))));
        dd[8] = 1.0;
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_translation_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        double _buf0 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, Math.fma(sd[6], _t0, Math.fma(-sd[7], _t1, pivotX))));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, Math.fma(sd[6], _t1, Math.fma(sd[7], _t0, pivotY))));
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code preRotateAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preRotateAround} dispatcher.
     */
    private Double3x3 preRotateAround_general(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = -pivotX;
        double _t6 = Math.fma(pivotY, _t0, Math.fma(_t2, _t1, pivotX));
        double _t7 = Math.fma(_t2, _t0, Math.fma(-pivotY, _t1, pivotY));
        double _buf0 = Math.fma(sd[2], _t6, Math.fma(sd[0], _t1, -(sd[1] * _t0)));
        dd[1] = Math.fma(sd[2], _t7, Math.fma(sd[0], _t0, sd[1] * _t1));
        dd[2] = sd[2];
        double _buf1 = Math.fma(sd[5], _t6, Math.fma(sd[3], _t1, -(sd[4] * _t0)));
        dd[4] = Math.fma(sd[5], _t7, Math.fma(sd[3], _t0, sd[4] * _t1));
        dd[5] = sd[5];
        double _buf2 = Math.fma(sd[8], _t6, Math.fma(sd[6], _t1, -(sd[7] * _t0)));
        dd[7] = Math.fma(sd[8], _t7, Math.fma(sd[6], _t0, sd[7] * _t1));
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAround(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAround_orthogonal_affine(angle, pivotX, pivotY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotateAround_general(angle, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 preRotateAround(double angle, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preRotateAround(angle, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAround_identity_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAround_translation_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAround_orthogonal_affine_self(angle, pivotX, pivotY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preRotateAround_general(angle, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAxis(double angle, Double3R axis, @Mutated Double3x3 dest) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x3 preRotateAxis(double angle, Double3R axis) {
        return preRotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x3 preRotateAxis_identity(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisY;
        double _t4 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        dd[0] = Math.fma(_t2, axisX * axisX, _t0);
        dd[1] = Math.fma(axisZ, _t1, _t2 * _t3);
        dd[2] = Math.fma(_t2, _t4, -(axisY * _t1));
        dd[3] = Math.fma(_t2, _t3, -(axisZ * _t1));
        dd[4] = Math.fma(_t2, axisY * axisY, _t0);
        dd[5] = Math.fma(axisX, _t1, _t2 * _t5);
        dd[6] = Math.fma(axisY, _t1, _t2 * _t4);
        dd[7] = Math.fma(_t2, _t5, -(axisX * _t1));
        dd[8] = Math.fma(_t2, axisZ * axisZ, _t0);
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x3 preRotateAxis_translation(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t4 = axisX * axisY;
        double _t6 = axisX * axisZ;
        double _t8 = axisY * axisZ;
        double _t14 = Math.fma(_t2, axisX * axisX, _t0);
        double _t15 = Math.fma(_t2, axisY * axisY, _t0);
        double _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        double _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        double _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        double _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        dd[0] = _t14;
        dd[1] = _t16;
        dd[2] = _t19;
        dd[3] = _t18;
        dd[4] = _t15;
        dd[5] = _t17;
        double _buf0 = Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(sd[6], _t14, sd[7] * _t18);
        double _buf1 = Math.fma(sd[6], _t16, sd[7] * _t15) + Math.fma(_t2, _t8, -(axisX * _t1));
        dd[8] = Math.fma(sd[6], _t19, Math.fma(sd[7], _t17, Math.fma(_t2, axisZ * axisZ, _t0)));
        dd[6] = _buf0;
        dd[7] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x3 preRotateAxis_orthogonal(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t4 = axisX * axisY;
        double _t6 = axisX * axisZ;
        double _t8 = axisY * axisZ;
        double _t14 = Math.fma(_t2, axisX * axisX, _t0);
        double _t15 = Math.fma(_t2, axisY * axisY, _t0);
        double _t16 = Math.fma(axisZ, _t1, _t2 * _t4);
        double _t17 = Math.fma(axisX, _t1, _t2 * _t8);
        double _t18 = Math.fma(_t2, _t4, -(axisZ * _t1));
        double _t19 = Math.fma(_t2, _t6, -(axisY * _t1));
        double _buf0 = Math.fma(sd[0], _t14, sd[1] * _t18);
        double _buf1 = Math.fma(sd[0], _t16, sd[1] * _t15);
        dd[2] = Math.fma(sd[0], _t19, sd[1] * _t17);
        double _buf2 = Math.fma(sd[3], _t14, sd[4] * _t18);
        double _buf3 = Math.fma(sd[3], _t16, sd[4] * _t15);
        dd[5] = Math.fma(sd[3], _t19, sd[4] * _t17);
        double _buf4 = Math.fma(axisY, _t1, _t2 * _t6) + Math.fma(sd[6], _t14, sd[7] * _t18);
        double _buf5 = Math.fma(sd[6], _t16, sd[7] * _t15) + Math.fma(_t2, _t8, -(axisX * _t1));
        dd[8] = Math.fma(sd[6], _t19, Math.fma(sd[7], _t17, Math.fma(_t2, axisZ * axisZ, _t0)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateAxis} dispatcher.
     */
    private Double3x3 preRotateAxis_general(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = axisX * axisZ;
        double _t5 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t1);
        double _t19 = Math.fma(_t2, axisY * axisY, _t1);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t1);
        double _t21 = Math.fma(axisY, _t0, _t2 * _t3);
        double _t22 = Math.fma(axisZ, _t0, _t2 * _t5);
        double _t23 = Math.fma(axisX, _t0, _t2 * _t7);
        double _t24 = Math.fma(_t2, _t5, -(axisZ * _t0));
        double _t25 = Math.fma(_t2, _t7, -(axisX * _t0));
        double _t26 = Math.fma(_t2, _t3, -(axisY * _t0));
        double _buf0 = Math.fma(sd[2], _t21, Math.fma(sd[0], _t18, sd[1] * _t24));
        double _buf1 = Math.fma(sd[2], _t25, Math.fma(sd[0], _t22, sd[1] * _t19));
        dd[2] = Math.fma(sd[2], _t20, Math.fma(sd[0], _t26, sd[1] * _t23));
        double _buf2 = Math.fma(sd[5], _t21, Math.fma(sd[3], _t18, sd[4] * _t24));
        double _buf3 = Math.fma(sd[5], _t25, Math.fma(sd[3], _t22, sd[4] * _t19));
        dd[5] = Math.fma(sd[5], _t20, Math.fma(sd[3], _t26, sd[4] * _t23));
        double _buf4 = Math.fma(sd[8], _t21, Math.fma(sd[6], _t18, sd[7] * _t24));
        double _buf5 = Math.fma(sd[8], _t25, Math.fma(sd[6], _t22, sd[7] * _t19));
        dd[8] = Math.fma(sd[8], _t20, Math.fma(sd[6], _t26, sd[7] * _t23));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
        return preRotateAxis_general(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}) onto this matrix.
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
     * @return this
     */
    @Mutated public Double3x3 preRotateAxis(double angle, double axisX, double axisY, double axisZ) {
        if (Joml.RETURN_NEW) return preRotateAxis(angle, axisX, axisY, axisZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateAxis_identity(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return preRotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_identity(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = _t0;
        dd[5] = _t1;
        dd[6] = 0.0;
        dd[7] = -_t1;
        dd[8] = _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_identity_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[4] = _t0;
        dd[5] = _t1;
        dd[7] = -_t1;
        dd[8] = _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = _t0;
        dd[5] = _t1;
        dd[6] = sd[6];
        double _buf0 = Math.fma(sd[7], _t0, -_t1);
        dd[8] = Math.fma(sd[7], _t1, _t0);
        dd[7] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateX}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[4] = _t0;
        dd[5] = _t1;
        dd[6] = sd[6];
        double _buf0 = Math.fma(sd[7], _t0, -_t1);
        dd[8] = Math.fma(sd[7], _t1, _t0);
        dd[7] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_orthogonal(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[0];
        double _buf0 = sd[1] * _t0;
        dd[2] = sd[1] * _t1;
        dd[3] = sd[3];
        double _buf1 = sd[4] * _t0;
        dd[5] = sd[4] * _t1;
        dd[6] = sd[6];
        double _buf2 = Math.fma(sd[7], _t0, -_t1);
        dd[8] = Math.fma(sd[7], _t1, _t0);
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[7] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateX} dispatcher.
     */
    private Double3x3 preRotateX_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[0];
        double _buf0 = Math.fma(sd[1], _t0, -(sd[2] * _t1));
        dd[2] = Math.fma(sd[1], _t1, sd[2] * _t0);
        dd[3] = sd[3];
        double _buf1 = Math.fma(sd[4], _t0, -(sd[5] * _t1));
        dd[5] = Math.fma(sd[4], _t1, sd[5] * _t0);
        dd[6] = sd[6];
        double _buf2 = Math.fma(sd[7], _t0, -(sd[8] * _t1));
        dd[8] = Math.fma(sd[7], _t1, sd[8] * _t0);
        dd[1] = _buf0;
        dd[4] = _buf1;
        dd[7] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateX(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateX_orthogonal(angle, dest);
        return preRotateX_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 preRotateX(double angle) {
        if (Joml.RETURN_NEW) return preRotateX(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateX_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateX_orthogonal(angle, this);
        return preRotateX_general(angle, this);
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_identity(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = 0.0;
        dd[2] = -_t1;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = _t1;
        dd[7] = 0.0;
        dd[8] = _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_identity_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[2] = -_t1;
        dd[6] = _t1;
        dd[8] = _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = 0.0;
        dd[2] = -_t1;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        double _buf0 = Math.fma(sd[6], _t0, _t1);
        dd[7] = sd[7];
        dd[8] = Math.fma(-sd[6], _t1, _t0);
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preRotateY}, specialized by runtime matrix
     * properties; reached only through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[2] = -_t1;
        double _buf0 = Math.fma(sd[6], _t0, _t1);
        dd[7] = sd[7];
        dd[8] = Math.fma(-sd[6], _t1, _t0);
        dd[6] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_orthogonal(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[4] * _t0;
        double _buf0 = sd[1];
        dd[2] = -(sd[4] * _t1);
        dd[3] = -(sd[1] * _t0);
        dd[4] = sd[4];
        dd[5] = sd[1] * _t1;
        double _buf1 = Math.fma(sd[6], _t0, _t1);
        dd[7] = sd[7];
        dd[8] = Math.fma(-sd[6], _t1, _t0);
        dd[1] = _buf0;
        dd[6] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_affine(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = sd[0] * _t0;
        dd[1] = sd[1];
        dd[2] = -(sd[0] * _t1);
        double _buf1 = sd[3] * _t0;
        dd[4] = sd[4];
        dd[5] = -(sd[3] * _t1);
        double _buf2 = Math.fma(sd[6], _t0, _t1);
        dd[7] = sd[7];
        dd[8] = Math.fma(-sd[6], _t1, _t0);
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code preRotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code preRotateY} dispatcher.
     */
    private Double3x3 preRotateY_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        dd[1] = sd[1];
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        double _buf1 = Math.fma(sd[3], _t0, sd[5] * _t1);
        dd[4] = sd[4];
        dd[5] = Math.fma(sd[5], _t0, -(sd[3] * _t1));
        double _buf2 = Math.fma(sd[6], _t0, sd[8] * _t1);
        dd[7] = sd[7];
        dd[8] = Math.fma(sd[8], _t0, -(sd[6] * _t1));
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateY(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateY_affine(angle, dest);
        return preRotateY_general(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 preRotateY(double angle) {
        if (Joml.RETURN_NEW) return preRotateY(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preRotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preRotateY_translation_self(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return preRotateY_orthogonal(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preRotateY_affine(angle, this);
        return preRotateY_general(angle, this);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preRotateZ(double angle, @Mutated Double3x3 dest) {
        return preRotate(angle, dest);
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 preRotateZ(double angle) {
        return preRotate(angle);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(Double2R v, @Mutated Double3x3 dest) {
        return preScale(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x3 preScale(Double2R v) {
        return preScale(v.x(), v.y());
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_identity(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = vY;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_identity_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[4] = vY;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_translation(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = vY;
        dd[5] = 0.0;
        dd[6] = sd[6] * vX;
        dd[7] = sd[7] * vY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_translation_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[4] = vY;
        dd[6] = sd[6] * vX;
        dd[7] = sd[7] * vY;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_orthogonal(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[2] = 0.0;
        dd[3] = sd[3] * vX;
        dd[4] = sd[4] * vY;
        dd[5] = 0.0;
        dd[6] = sd[6] * vX;
        dd[7] = sd[7] * vY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_orthogonal_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[3] = sd[3] * vX;
        dd[4] = sd[4] * vY;
        dd[6] = sd[6] * vX;
        dd[7] = sd[7] * vY;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_general(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vY;
        dd[2] = sd[2];
        dd[3] = sd[3] * vX;
        dd[4] = sd[4] * vY;
        dd[5] = sd[5];
        dd[6] = sd[6] * vX;
        dd[7] = sd[7] * vY;
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(double vX, double vY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(vX, vY, dest);
        return preScale_general(vX, vY, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code vX}, {@code vY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 preScale(double vX, double vY) {
        if (Joml.RETURN_NEW) return preScale(vX, vY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal_self(vX, vY, this);
        return preScale_general(vX, vY, this);
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_identity(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_identity_self(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_translation(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = s * sd[6];
        dd[7] = s * sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_translation_self(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        dd[6] = s * sd[6];
        dd[7] = s * sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_orthogonal(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = 0.0;
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = 0.0;
        dd[6] = s * sd[6];
        dd[7] = s * sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScale}, specialized by runtime matrix
     * properties; reached only through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_orthogonal_self(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[6] = s * sd[6];
        dd[7] = s * sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScale}, specialized by runtime matrix properties; reached only
     * through the public {@code preScale} dispatcher.
     */
    private Double3x3 preScale_general(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = sd[2];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = sd[5];
        dd[6] = s * sd[6];
        dd[7] = s * sd[7];
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScale(double s, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation(s, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal(s, dest);
        return preScale_general(s, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x3 preScale(double s) {
        if (Joml.RETURN_NEW) return preScale(s, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScale_translation_self(s, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScale_orthogonal_self(s, this);
        return preScale_general(s, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(double s, Double2R pivot, @Mutated Double3x3 dest) {
        return preScaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 preScaleAround(double s, Double2R pivot) {
        return preScaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_identity(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = Math.fma(-s, pivotX, pivotX);
        dd[7] = Math.fma(-s, pivotY, pivotY);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_identity_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        dd[6] = Math.fma(-s, pivotX, pivotX);
        dd[7] = Math.fma(-s, pivotY, pivotY);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_translation(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = Math.fma(-s, pivotX, Math.fma(s, sd[6], pivotX));
        dd[7] = Math.fma(-s, pivotY, Math.fma(s, sd[7], pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_translation_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        dd[6] = Math.fma(-s, pivotX, Math.fma(s, sd[6], pivotX));
        dd[7] = Math.fma(-s, pivotY, Math.fma(s, sd[7], pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_orthogonal(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = 0.0;
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(-s, pivotX, Math.fma(s, sd[6], pivotX));
        dd[7] = Math.fma(-s, pivotY, Math.fma(s, sd[7], pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_orthogonal_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[6] = Math.fma(-s, pivotX, Math.fma(s, sd[6], pivotX));
        dd[7] = Math.fma(-s, pivotY, Math.fma(s, sd[7], pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_general(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        dd[0] = Math.fma(s, sd[0], sd[2] * _t0);
        dd[1] = Math.fma(s, sd[1], sd[2] * _t1);
        dd[2] = sd[2];
        dd[3] = Math.fma(s, sd[3], sd[5] * _t0);
        dd[4] = Math.fma(s, sd[4], sd[5] * _t1);
        dd[5] = sd[5];
        dd[6] = Math.fma(s, sd[6], sd[8] * _t0);
        dd[7] = Math.fma(s, sd[7], sd[8] * _t1);
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY})
     * onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(s, pivotX, pivotY, dest);
        return preScaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY})
     * onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 preScaleAround(double s, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(s, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal_self(s, pivotX, pivotY, this);
        return preScaleAround_general(s, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(Double2R s, Double2R pivot, @Mutated Double3x3 dest) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
    }


    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 preScaleAround(Double2R s, Double2R pivot) {
        return preScaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_identity(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sY;
        dd[5] = 0.0;
        dd[6] = Math.fma(-pivotX, sX, pivotX);
        dd[7] = Math.fma(-pivotY, sY, pivotY);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_identity_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[4] = sY;
        dd[6] = Math.fma(-pivotX, sX, pivotX);
        dd[7] = Math.fma(-pivotY, sY, pivotY);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_translation(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sY;
        dd[5] = 0.0;
        dd[6] = Math.fma(-pivotX, sX, Math.fma(sX, sd[6], pivotX));
        dd[7] = Math.fma(-pivotY, sY, Math.fma(sY, sd[7], pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_translation_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[4] = sY;
        dd[6] = Math.fma(-pivotX, sX, Math.fma(sX, sd[6], pivotX));
        dd[7] = Math.fma(-pivotY, sY, Math.fma(sY, sd[7], pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_orthogonal(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX * sd[0];
        dd[1] = sY * sd[1];
        dd[2] = 0.0;
        dd[3] = sX * sd[3];
        dd[4] = sY * sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(-pivotX, sX, Math.fma(sX, sd[6], pivotX));
        dd[7] = Math.fma(-pivotY, sY, Math.fma(sY, sd[7], pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preScaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_orthogonal_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX * sd[0];
        dd[1] = sY * sd[1];
        dd[3] = sX * sd[3];
        dd[4] = sY * sd[4];
        dd[6] = Math.fma(-pivotX, sX, Math.fma(sX, sd[6], pivotX));
        dd[7] = Math.fma(-pivotY, sY, Math.fma(sY, sd[7], pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code preScaleAround}, specialized by runtime matrix properties; reached
     * only through the public {@code preScaleAround} dispatcher.
     */
    private Double3x3 preScaleAround_general(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        dd[0] = Math.fma(sX, sd[0], sd[2] * _t2);
        dd[1] = Math.fma(sY, sd[1], sd[2] * _t3);
        dd[2] = sd[2];
        dd[3] = Math.fma(sX, sd[3], sd[5] * _t2);
        dd[4] = Math.fma(sY, sd[4], sd[5] * _t3);
        dd[5] = sd[5];
        dd[6] = Math.fma(sX, sd[6], sd[8] * _t2);
        dd[7] = Math.fma(sY, sd[7], sd[8] * _t3);
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preScaleAround(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
        return preScaleAround_general(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 preScaleAround(double sX, double sY, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return preScaleAround(sX, sY, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preScaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preScaleAround_translation_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preScaleAround_orthogonal_self(sX, sY, pivotX, pivotY, this);
        return preScaleAround_general(sX, sY, pivotX, pivotY, this);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preTranslate(Double2R v, @Mutated Double3x3 dest) {
        return preTranslate(v.x(), v.y(), dest);
    }


    /**
     * Pre-multiply a translation by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x3 preTranslate(Double2R v) {
        return preTranslate(v.x(), v.y());
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_orthogonal_affine(double vX, double vY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = sd[6] + vX;
        dd[7] = sd[7] + vY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_orthogonal_affine_self(double vX, double vY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = sd[6] + vX;
        dd[7] = sd[7] + vY;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_identity(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = vX;
        dd[7] = vY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_identity_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[6] = vX;
        dd[7] = vY;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_translation(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = sd[6] + vX;
        dd[7] = sd[7] + vY;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code preTranslate}, specialized by runtime matrix
     * properties; reached only through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_translation_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[6] = sd[6] + vX;
        dd[7] = sd[7] + vY;
        ((Double3x3Impl) dest).properties = Joml.BIT_TRANSLATION;
        return dest;
    }


    /**
     * Private body of {@code preTranslate}, specialized by runtime matrix properties; reached only
     * through the public {@code preTranslate} dispatcher.
     */
    private Double3x3 preTranslate_general(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = Math.fma(sd[2], vX, sd[0]);
        dd[1] = Math.fma(sd[2], vY, sd[1]);
        dd[2] = sd[2];
        dd[3] = Math.fma(sd[5], vX, sd[3]);
        dd[4] = Math.fma(sd[5], vY, sd[4]);
        dd[5] = sd[5];
        dd[6] = Math.fma(sd[8], vX, sd[6]);
        dd[7] = Math.fma(sd[8], vY, sd[7]);
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 preTranslate(double vX, double vY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preTranslate_orthogonal_affine(vX, vY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preTranslate_general(vX, vY, dest);
    }


    /**
     * Pre-multiply a translation by ({@code vX}, {@code vY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 preTranslate(double vX, double vY) {
        if (Joml.RETURN_NEW) return preTranslate(vX, vY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return preTranslate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return preTranslate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return preTranslate_orthogonal_affine_self(vX, vY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return preTranslate_general(vX, vY, this);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_orthogonal_affine(double angle, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        dd[2] = 0.0;
        dd[3] = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        dd[4] = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_orthogonal_affine_self(double angle, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        dd[3] = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        dd[4] = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_identity(double angle, @Mutated Double3x3 dest) {
        return preRotate_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_identity_self(double angle, @Mutated Double3x3 dest) {
        return preRotate_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotate}, specialized by runtime matrix properties;
     * reached only through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotate}, specialized by runtime matrix properties; reached only
     * through the public {@code rotate} dispatcher.
     */
    private Double3x3 rotate_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        double _buf2 = Math.fma(sd[2], _t0, sd[5] * _t1);
        dd[3] = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        dd[4] = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        dd[5] = Math.fma(sd[5], _t0, -(sd[2] * _t1));
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation by {@code angle} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotate(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_orthogonal_affine(angle, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotate_general(angle, dest);
    }


    /**
     * Apply a rotation by {@code angle} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 rotate(double angle) {
        if (Joml.RETURN_NEW) return rotate(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotate_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotate_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotate_orthogonal_affine_self(angle, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotate_general(angle, this);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAround(double angle, Double2R pivot, @Mutated Double3x3 dest) {
        return rotateAround(angle, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 rotateAround(double angle, Double2R pivot) {
        return rotateAround(angle, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_orthogonal_affine(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        double _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        dd[2] = 0.0;
        double _buf2 = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        double _buf3 = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[0], _t6, Math.fma(sd[3], _t7, sd[6]));
        dd[7] = Math.fma(sd[1], _t6, Math.fma(sd[4], _t7, sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_orthogonal_affine_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        double _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        double _buf2 = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        double _buf3 = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        dd[6] = Math.fma(sd[0], _t6, Math.fma(sd[3], _t7, sd[6]));
        dd[7] = Math.fma(sd[1], _t6, Math.fma(sd[4], _t7, sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_identity(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preRotateAround_identity(angle, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_identity_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preRotateAround_identity_self(angle, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_translation(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, sd[6] + pivotX));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, sd[7] + pivotY));
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateAround}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_translation_self(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        dd[0] = _t0;
        dd[1] = _t1;
        dd[3] = -_t1;
        dd[4] = _t0;
        dd[6] = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, sd[6] + pivotX));
        dd[7] = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, sd[7] + pivotY));
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateAround}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAround} dispatcher.
     */
    private Double3x3 rotateAround_general(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = -pivotX;
        double _t6 = Math.fma(pivotY, _t1, Math.fma(_t2, _t0, pivotX));
        double _t7 = Math.fma(_t2, _t1, Math.fma(-pivotY, _t0, pivotY));
        double _buf0 = Math.fma(sd[0], _t0, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t0, sd[4] * _t1);
        double _buf2 = Math.fma(sd[2], _t0, sd[5] * _t1);
        double _buf3 = Math.fma(sd[3], _t0, -(sd[0] * _t1));
        double _buf4 = Math.fma(sd[4], _t0, -(sd[1] * _t1));
        double _buf5 = Math.fma(sd[5], _t0, -(sd[2] * _t1));
        dd[6] = Math.fma(sd[0], _t6, Math.fma(sd[3], _t7, sd[6]));
        dd[7] = Math.fma(sd[1], _t6, Math.fma(sd[4], _t7, sd[7]));
        dd[8] = Math.fma(sd[2], _t6, Math.fma(sd[5], _t7, sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAround(double angle, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation(angle, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAround_orthogonal_affine(angle, pivotX, pivotY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateAround_general(angle, pivotX, pivotY, dest);
    }


    /**
     * Apply the rotation {@code angle} about the pivot point ({@code pivotX}, {@code pivotY}) to
     * this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 rotateAround(double angle, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return rotateAround(angle, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAround_identity_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAround_translation_self(angle, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAround_orthogonal_affine_self(angle, pivotX, pivotY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateAround_general(angle, pivotX, pivotY, this);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAxis(double angle, Double3R axis, @Mutated Double3x3 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated Double3x3 rotateAxis(double angle, Double3R axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x3 rotateAxis_identity(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        return preRotateAxis_identity(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x3 rotateAxis_translation(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t5 = axisY * axisZ;
        double _t6 = axisX * axisY;
        double _t10 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t11 = Math.fma(axisX, _t1, _t2 * _t5);
        double _t12 = Math.fma(_t2, _t3, -(axisY * _t1));
        dd[0] = Math.fma(_t2, axisX * axisX, Math.fma(sd[6], _t12, _t0));
        dd[1] = Math.fma(sd[7], _t12, Math.fma(axisZ, _t1, _t2 * _t6));
        dd[2] = _t12;
        dd[3] = Math.fma(sd[6], _t11, Math.fma(_t2, _t6, -(axisZ * _t1)));
        dd[4] = Math.fma(_t2, axisY * axisY, Math.fma(sd[7], _t11, _t0));
        dd[5] = _t11;
        dd[6] = Math.fma(sd[6], _t10, Math.fma(axisY, _t1, _t2 * _t3));
        dd[7] = Math.fma(sd[7], _t10, Math.fma(_t2, _t5, -(axisX * _t1)));
        dd[8] = _t10;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x3 rotateAxis_orthogonal(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t6 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        double _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        double _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        double _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        double _buf0 = Math.fma(sd[6], _t24, Math.fma(sd[0], _t18, sd[3] * _t21));
        double _buf1 = Math.fma(sd[7], _t24, Math.fma(sd[1], _t18, sd[4] * _t21));
        dd[2] = _t24;
        double _buf2 = Math.fma(sd[6], _t22, Math.fma(sd[0], _t25, sd[3] * _t19));
        double _buf3 = Math.fma(sd[7], _t22, Math.fma(sd[1], _t25, sd[4] * _t19));
        dd[5] = _t22;
        dd[6] = Math.fma(sd[6], _t20, Math.fma(sd[0], _t23, sd[3] * _t26));
        dd[7] = Math.fma(sd[7], _t20, Math.fma(sd[1], _t23, sd[4] * _t26));
        dd[8] = _t20;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateAxis}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateAxis} dispatcher.
     */
    private Double3x3 rotateAxis_general(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t3 = axisX * axisZ;
        double _t6 = axisX * axisY;
        double _t7 = axisY * axisZ;
        double _t18 = Math.fma(_t2, axisX * axisX, _t0);
        double _t19 = Math.fma(_t2, axisY * axisY, _t0);
        double _t20 = Math.fma(_t2, axisZ * axisZ, _t0);
        double _t21 = Math.fma(axisZ, _t1, _t2 * _t6);
        double _t22 = Math.fma(axisX, _t1, _t2 * _t7);
        double _t23 = Math.fma(axisY, _t1, _t2 * _t3);
        double _t24 = Math.fma(_t2, _t3, -(axisY * _t1));
        double _t25 = Math.fma(_t2, _t6, -(axisZ * _t1));
        double _t26 = Math.fma(_t2, _t7, -(axisX * _t1));
        double _buf0 = Math.fma(sd[6], _t24, Math.fma(sd[0], _t18, sd[3] * _t21));
        double _buf1 = Math.fma(sd[7], _t24, Math.fma(sd[1], _t18, sd[4] * _t21));
        double _buf2 = Math.fma(sd[8], _t24, Math.fma(sd[2], _t18, sd[5] * _t21));
        double _buf3 = Math.fma(sd[6], _t22, Math.fma(sd[0], _t25, sd[3] * _t19));
        double _buf4 = Math.fma(sd[7], _t22, Math.fma(sd[1], _t25, sd[4] * _t19));
        double _buf5 = Math.fma(sd[8], _t22, Math.fma(sd[2], _t25, sd[5] * _t19));
        dd[6] = Math.fma(sd[6], _t20, Math.fma(sd[0], _t23, sd[3] * _t26));
        dd[7] = Math.fma(sd[7], _t20, Math.fma(sd[1], _t23, sd[4] * _t26));
        dd[8] = Math.fma(sd[8], _t20, Math.fma(sd[2], _t23, sd[5] * _t26));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, dest);
        return rotateAxis_general(angle, axisX, axisY, axisZ, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this matrix.
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
     * @return this
     */
    @Mutated public Double3x3 rotateAxis(double angle, double axisX, double axisY, double axisZ) {
        if (Joml.RETURN_NEW) return rotateAxis(angle, axisX, axisY, axisZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateAxis_identity(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateAxis_translation(angle, axisX, axisY, axisZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateAxis_orthogonal(angle, axisX, axisY, axisZ, this);
        return rotateAxis_general(angle, axisX, axisY, axisZ, this);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_identity(double angle, @Mutated Double3x3 dest) {
        return preRotateX_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_identity_self(double angle, @Mutated Double3x3 dest) {
        return preRotateX_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = sd[6] * _t0;
        dd[4] = Math.fma(sd[7], _t0, _t1);
        dd[5] = _t0;
        dd[6] = sd[6] * _t1;
        dd[7] = Math.fma(sd[7], _t1, -_t0);
        dd[8] = _t1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[3] = sd[6] * _t0;
        dd[4] = Math.fma(sd[7], _t0, _t1);
        dd[5] = _t0;
        dd[6] = sd[6] * _t1;
        dd[7] = Math.fma(sd[7], _t1, -_t0);
        dd[8] = _t1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_orthogonal(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[2] = 0.0;
        dd[3] = Math.fma(sd[6], _t0, -(sd[1] * _t1));
        double _buf1 = Math.fma(sd[4], _t1, sd[7] * _t0);
        dd[5] = _t0;
        dd[6] = Math.fma(sd[6], _t1, sd[1] * _t0);
        dd[7] = Math.fma(sd[7], _t1, -(sd[4] * _t0));
        dd[8] = _t1;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_orthogonal_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[3] = Math.fma(sd[6], _t0, -(sd[1] * _t1));
        double _buf1 = Math.fma(sd[4], _t1, sd[7] * _t0);
        dd[5] = _t0;
        dd[6] = Math.fma(sd[6], _t1, sd[1] * _t0);
        dd[7] = Math.fma(sd[7], _t1, -(sd[4] * _t0));
        dd[8] = _t1;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_affine(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        double _buf0 = Math.fma(sd[3], _t0, sd[6] * _t1);
        double _buf1 = Math.fma(sd[4], _t0, sd[7] * _t1);
        dd[5] = _t1;
        dd[6] = Math.fma(sd[6], _t0, -(sd[3] * _t1));
        dd[7] = Math.fma(sd[7], _t0, -(sd[4] * _t1));
        dd[8] = _t0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_affine_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[0];
        dd[1] = sd[1];
        double _buf0 = Math.fma(sd[3], _t0, sd[6] * _t1);
        double _buf1 = Math.fma(sd[4], _t0, sd[7] * _t1);
        dd[5] = _t1;
        dd[6] = Math.fma(sd[6], _t0, -(sd[3] * _t1));
        dd[7] = Math.fma(sd[7], _t0, -(sd[4] * _t1));
        dd[8] = _t0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX} dispatcher.
     */
    private Double3x3 rotateX_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        double _buf0 = Math.fma(sd[3], _t0, sd[6] * _t1);
        double _buf1 = Math.fma(sd[4], _t0, sd[7] * _t1);
        double _buf2 = Math.fma(sd[5], _t0, sd[8] * _t1);
        dd[6] = Math.fma(sd[6], _t0, -(sd[3] * _t1));
        dd[7] = Math.fma(sd[7], _t0, -(sd[4] * _t1));
        dd[8] = Math.fma(sd[8], _t0, -(sd[5] * _t1));
        dd[3] = _buf0;
        dd[4] = _buf1;
        dd[5] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation(angle, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX_affine(angle, dest);
        return rotateX_general(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 rotateX(double angle) {
        if (Joml.RETURN_NEW) return rotateX(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX_translation_self(angle, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX_orthogonal_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX_affine_self(angle, this);
        return rotateX_general(angle, this);
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[4] = -1.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[4] = -1.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[1];
        dd[4] = -sd[4];
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[3] = sd[1];
        dd[4] = -sd[4];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX180} dispatcher.
     */
    private Double3x3 rotateX180_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX180(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX180_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX180_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX180_affine(dest);
        return rotateX180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateX180() {
        if (Joml.RETURN_NEW) return rotateX180(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX180_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX180_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX180_affine_self(this);
        return rotateX180_general(this);
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = -1.0;
        dd[6] = 0.0;
        dd[7] = 1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[4] = 0.0;
        dd[5] = -1.0;
        dd[7] = 1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = -sd[6];
        dd[4] = -sd[7];
        dd[5] = -1.0;
        dd[6] = 0.0;
        dd[7] = 1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[3] = -sd[6];
        dd[4] = -sd[7];
        dd[5] = -1.0;
        dd[6] = 0.0;
        dd[7] = 1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        dd[5] = -1.0;
        dd[6] = sd[3];
        dd[7] = sd[4];
        dd[8] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        dd[5] = -1.0;
        dd[6] = sd[3];
        dd[7] = sd[4];
        dd[8] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX270} dispatcher.
     */
    private Double3x3 rotateX270_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        double _buf2 = -sd[8];
        dd[6] = sd[3];
        dd[7] = sd[4];
        dd[8] = sd[5];
        dd[3] = _buf0;
        dd[4] = _buf1;
        dd[5] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX270(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX270_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX270_orthogonal(dest);
        return rotateX270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateX270() {
        if (Joml.RETURN_NEW) return rotateX270(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX270_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX270_orthogonal_self(this);
        return rotateX270_general(this);
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 1.0;
        dd[6] = 0.0;
        dd[7] = -1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[4] = 0.0;
        dd[5] = 1.0;
        dd[7] = -1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = sd[6];
        dd[4] = sd[7];
        dd[5] = 1.0;
        dd[6] = 0.0;
        dd[7] = -1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[3] = sd[6];
        dd[4] = sd[7];
        dd[5] = 1.0;
        dd[6] = 0.0;
        dd[7] = -1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[2] = 0.0;
        dd[3] = sd[6];
        double _buf1 = sd[7];
        dd[5] = 1.0;
        dd[6] = sd[1];
        dd[7] = -sd[4];
        dd[8] = 0.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[4];
        double _buf0 = sd[1];
        dd[3] = sd[6];
        double _buf1 = sd[7];
        dd[5] = 1.0;
        dd[6] = sd[1];
        dd[7] = -sd[4];
        dd[8] = 0.0;
        dd[1] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = 0.0;
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        dd[5] = 1.0;
        dd[6] = -sd[3];
        dd[7] = -sd[4];
        dd[8] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateX90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        dd[5] = 1.0;
        dd[6] = -sd[3];
        dd[7] = -sd[4];
        dd[8] = 0.0;
        dd[3] = _buf0;
        dd[4] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateX90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateX90} dispatcher.
     */
    private Double3x3 rotateX90_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        double _buf2 = sd[8];
        dd[6] = -sd[3];
        dd[7] = -sd[4];
        dd[8] = -sd[5];
        dd[3] = _buf0;
        dd[4] = _buf1;
        dd[5] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateX90(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX90_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX90_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX90_affine(dest);
        return rotateX90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateX90() {
        if (Joml.RETURN_NEW) return rotateX90(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateX90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateX90_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateX90_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateX90_affine_self(this);
        return rotateX90_general(this);
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x3 rotateXYZ_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t3;
        double _t7 = _t3 * _t5;
        dd[0] = _t0 * _t1;
        dd[1] = Math.fma(_t6, _t1, _t2 * _t5);
        dd[2] = Math.fma(_t4, _t2, -(_t7 * _t1));
        dd[3] = -(_t2 * _t0);
        dd[4] = Math.fma(_t5, _t1, -(_t6 * _t2));
        dd[5] = Math.fma(_t7, _t2, _t4 * _t1);
        dd[6] = _t3;
        dd[7] = -(_t4 * _t0);
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x3 rotateXYZ_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.cos(angleX);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleY);
        double _t6 = _t2 * _t3;
        double _t8 = _t3 * _t5;
        double _t9 = _t0 * _t2;
        double _t12 = Math.fma(_t6, _t1, _t0 * _t4);
        double _t13 = Math.fma(_t0, _t1, -(_t6 * _t4));
        dd[0] = Math.fma(sd[6], _t13, _t5 * _t4);
        dd[1] = Math.fma(sd[7], _t13, Math.fma(_t9, _t4, _t1 * _t3));
        dd[2] = _t13;
        dd[3] = Math.fma(sd[6], _t12, -(_t1 * _t5));
        dd[4] = Math.fma(sd[7], _t12, Math.fma(_t3, _t4, -(_t9 * _t1)));
        dd[5] = _t12;
        dd[6] = Math.fma(sd[6], _t8, _t2);
        dd[7] = Math.fma(sd[7], _t8, -(_t0 * _t5));
        dd[8] = _t8;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x3 rotateXYZ_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.cos(angleX);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleY);
        double _t6 = _t2 * _t3;
        double _t7 = _t5 * _t4;
        double _t8 = _t0 * _t2;
        double _t11 = _t1 * _t5;
        double _t12 = _t3 * _t5;
        double _t13 = _t0 * _t5;
        double _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        double _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        double _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        double _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t7, sd[3] * _t18));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t7, sd[4] * _t18));
        dd[2] = _t20;
        double _buf2 = Math.fma(sd[6], _t19, Math.fma(sd[3], _t21, -(sd[0] * _t11)));
        double _buf3 = Math.fma(sd[7], _t19, Math.fma(sd[4], _t21, -(sd[1] * _t11)));
        dd[5] = _t19;
        dd[6] = Math.fma(sd[6], _t12, Math.fma(sd[0], _t2, -(sd[3] * _t13)));
        dd[7] = Math.fma(sd[7], _t12, Math.fma(sd[1], _t2, -(sd[4] * _t13)));
        dd[8] = _t12;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXYZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXYZ} dispatcher.
     */
    private Double3x3 rotateXYZ_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.cos(angleX);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleY);
        double _t6 = _t2 * _t3;
        double _t7 = _t5 * _t4;
        double _t8 = _t0 * _t2;
        double _t11 = _t1 * _t5;
        double _t12 = _t3 * _t5;
        double _t13 = _t0 * _t5;
        double _t18 = Math.fma(_t8, _t4, _t1 * _t3);
        double _t19 = Math.fma(_t6, _t1, _t0 * _t4);
        double _t20 = Math.fma(_t0, _t1, -(_t6 * _t4));
        double _t21 = Math.fma(_t3, _t4, -(_t8 * _t1));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t7, sd[3] * _t18));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t7, sd[4] * _t18));
        double _buf2 = Math.fma(sd[8], _t20, Math.fma(sd[2], _t7, sd[5] * _t18));
        double _buf3 = Math.fma(sd[6], _t19, Math.fma(sd[3], _t21, -(sd[0] * _t11)));
        double _buf4 = Math.fma(sd[7], _t19, Math.fma(sd[4], _t21, -(sd[1] * _t11)));
        double _buf5 = Math.fma(sd[8], _t19, Math.fma(sd[5], _t21, -(sd[2] * _t11)));
        dd[6] = Math.fma(sd[6], _t12, Math.fma(sd[0], _t2, -(sd[3] * _t13)));
        dd[7] = Math.fma(sd[7], _t12, Math.fma(sd[1], _t2, -(sd[4] * _t13)));
        dd[8] = Math.fma(sd[8], _t12, Math.fma(sd[2], _t2, -(sd[5] * _t13)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXYZ(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXYZ_orthogonal(angleX, angleY, angleZ, dest);
        return rotateXYZ_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateXYZ(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateXYZ(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXYZ_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXYZ_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXYZ_orthogonal(angleX, angleY, angleZ, this);
        return rotateXYZ_general(angleX, angleY, angleZ, this);
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x3 rotateXZY_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t4;
        double _t7 = _t5 * _t2;
        dd[0] = _t0 * _t1;
        dd[1] = Math.fma(_t6, _t0, _t5 * _t3);
        dd[2] = Math.fma(_t7, _t0, -(_t3 * _t4));
        dd[3] = -_t2;
        dd[4] = _t4 * _t1;
        dd[5] = _t5 * _t1;
        dd[6] = _t3 * _t1;
        dd[7] = Math.fma(_t6, _t3, -(_t5 * _t0));
        dd[8] = Math.fma(_t7, _t3, _t4 * _t0);
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x3 rotateXZY_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.cos(angleZ);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t5;
        double _t10 = _t1 * _t4;
        double _t12 = Math.fma(_t6, _t3, _t4 * _t2);
        double _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        dd[0] = Math.fma(sd[6], _t13, _t2 * _t5);
        dd[1] = Math.fma(sd[7], _t13, Math.fma(_t10, _t2, _t0 * _t3));
        dd[2] = _t13;
        dd[3] = Math.fma(sd[6], _t8, -_t1);
        dd[4] = Math.fma(sd[7], _t8, _t4 * _t5);
        dd[5] = _t8;
        dd[6] = Math.fma(sd[6], _t12, _t3 * _t5);
        dd[7] = Math.fma(sd[7], _t12, Math.fma(_t10, _t3, -(_t0 * _t2)));
        dd[8] = _t12;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x3 rotateXZY_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.cos(angleZ);
        double _t6 = _t0 * _t1;
        double _t8 = _t2 * _t5;
        double _t9 = _t1 * _t4;
        double _t11 = _t0 * _t5;
        double _t12 = _t4 * _t5;
        double _t14 = _t3 * _t5;
        double _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        double _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t8, sd[3] * _t18));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t8, sd[4] * _t18));
        dd[2] = _t20;
        double _buf2 = Math.fma(sd[6], _t11, Math.fma(sd[3], _t12, -(sd[0] * _t1)));
        double _buf3 = Math.fma(sd[7], _t11, Math.fma(sd[4], _t12, -(sd[1] * _t1)));
        dd[5] = _t11;
        dd[6] = Math.fma(sd[6], _t19, Math.fma(sd[0], _t14, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t19, Math.fma(sd[1], _t14, sd[4] * _t21));
        dd[8] = _t19;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateXZY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateXZY} dispatcher.
     */
    private Double3x3 rotateXZY_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.cos(angleZ);
        double _t6 = _t0 * _t1;
        double _t8 = _t2 * _t5;
        double _t9 = _t1 * _t4;
        double _t11 = _t0 * _t5;
        double _t12 = _t4 * _t5;
        double _t14 = _t3 * _t5;
        double _t18 = Math.fma(_t9, _t2, _t0 * _t3);
        double _t19 = Math.fma(_t6, _t3, _t4 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t9, _t3, -(_t0 * _t2));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t8, sd[3] * _t18));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t8, sd[4] * _t18));
        double _buf2 = Math.fma(sd[8], _t20, Math.fma(sd[2], _t8, sd[5] * _t18));
        double _buf3 = Math.fma(sd[6], _t11, Math.fma(sd[3], _t12, -(sd[0] * _t1)));
        double _buf4 = Math.fma(sd[7], _t11, Math.fma(sd[4], _t12, -(sd[1] * _t1)));
        double _buf5 = Math.fma(sd[8], _t11, Math.fma(sd[5], _t12, -(sd[2] * _t1)));
        dd[6] = Math.fma(sd[6], _t19, Math.fma(sd[0], _t14, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t19, Math.fma(sd[1], _t14, sd[4] * _t21));
        dd[8] = Math.fma(sd[8], _t19, Math.fma(sd[2], _t14, sd[5] * _t21));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXZY(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXZY_orthogonal(angleX, angleY, angleZ, dest);
        return rotateXZY_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateXZY(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateXZY(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateXZY_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateXZY_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateXZY_orthogonal(angleX, angleY, angleZ, this);
        return rotateXZY_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn180(@Mutated Double3x3 dest) {
        return rotateX180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateXn180() {
        return rotateX180();
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn270(@Mutated Double3x3 dest) {
        return rotateX90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateXn270() {
        return rotateX90();
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateXn90(@Mutated Double3x3 dest) {
        return rotateX270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateXn90() {
        return rotateX270();
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_identity(double angle, @Mutated Double3x3 dest) {
        return preRotateY_identity(angle, dest);
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_identity_self(double angle, @Mutated Double3x3 dest) {
        return preRotateY_identity_self(angle, dest);
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_translation(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[0] = Math.fma(-sd[6], _t0, _t1);
        dd[1] = -(sd[7] * _t0);
        dd[2] = -_t0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[6], _t1, _t0);
        dd[7] = sd[7] * _t1;
        dd[8] = _t1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_translation_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        dd[0] = Math.fma(-sd[6], _t0, _t1);
        dd[1] = -(sd[7] * _t0);
        dd[2] = -_t0;
        dd[6] = Math.fma(sd[6], _t1, _t0);
        dd[7] = sd[7] * _t1;
        dd[8] = _t1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_orthogonal(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[6] * _t1));
        double _buf1 = Math.fma(sd[1], _t0, -(sd[7] * _t1));
        dd[2] = -_t1;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[0], _t1, sd[6] * _t0);
        dd[7] = Math.fma(sd[1], _t1, sd[7] * _t0);
        dd[8] = _t0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY}, specialized by runtime matrix properties;
     * reached only through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_orthogonal_self(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[6] * _t1));
        double _buf1 = Math.fma(sd[1], _t0, -(sd[7] * _t1));
        dd[2] = -_t1;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = Math.fma(sd[0], _t1, sd[6] * _t0);
        dd[7] = Math.fma(sd[1], _t1, sd[7] * _t0);
        dd[8] = _t0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY} dispatcher.
     */
    private Double3x3 rotateY_general(double angle, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(sd[0], _t0, -(sd[6] * _t1));
        double _buf1 = Math.fma(sd[1], _t0, -(sd[7] * _t1));
        double _buf2 = Math.fma(sd[2], _t0, -(sd[8] * _t1));
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = Math.fma(sd[0], _t1, sd[6] * _t0);
        dd[7] = Math.fma(sd[1], _t1, sd[7] * _t0);
        dd[8] = Math.fma(sd[2], _t1, sd[8] * _t0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY(double angle, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity(angle, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation(angle, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY_orthogonal(angle, dest);
        return rotateY_general(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 rotateY(double angle) {
        if (Joml.RETURN_NEW) return rotateY(angle, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY_identity_self(angle, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY_translation_self(angle, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY_orthogonal_self(angle, this);
        return rotateY_general(angle, this);
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = 0.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -1.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY180} dispatcher.
     */
    private Double3x3 rotateY180_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        dd[8] = -sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY180(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY180_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY180_orthogonal(dest);
        return rotateY180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateY180() {
        if (Joml.RETURN_NEW) return rotateY180(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY180_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY180_orthogonal_self(this);
        return rotateY180_general(this);
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 1.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[2] = 1.0;
        dd[6] = -1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = 1.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = -1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = 1.0;
        dd[6] = -1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        dd[2] = 1.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = -sd[0];
        dd[7] = -sd[1];
        dd[8] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        dd[2] = 1.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = -sd[0];
        dd[7] = -sd[1];
        dd[8] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY270} dispatcher.
     */
    private Double3x3 rotateY270_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[6];
        double _buf1 = sd[7];
        double _buf2 = sd[8];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = -sd[0];
        dd[7] = -sd[1];
        dd[8] = -sd[2];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY270(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY270_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY270_orthogonal(dest);
        return rotateY270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateY270() {
        if (Joml.RETURN_NEW) return rotateY270(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY270_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY270_orthogonal_self(this);
        return rotateY270_general(this);
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = -1.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[2] = -1.0;
        dd[6] = 1.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[6];
        dd[1] = -sd[7];
        dd[2] = -1.0;
        dd[3] = 0.0;
        dd[4] = 1.0;
        dd[5] = 0.0;
        dd[6] = 1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[6];
        dd[1] = -sd[7];
        dd[2] = -1.0;
        dd[6] = 1.0;
        dd[7] = 0.0;
        dd[8] = 0.0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        dd[2] = -1.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = 0.0;
        dd[6] = sd[0];
        dd[7] = sd[1];
        dd[8] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateY90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        dd[2] = -1.0;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[6] = sd[0];
        dd[7] = sd[1];
        dd[8] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateY90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateY90} dispatcher.
     */
    private Double3x3 rotateY90_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[6];
        double _buf1 = -sd[7];
        double _buf2 = -sd[8];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[0];
        dd[7] = sd[1];
        dd[8] = sd[2];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateY90(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY90_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY90_orthogonal(dest);
        return rotateY90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateY90() {
        if (Joml.RETURN_NEW) return rotateY90(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateY90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateY90_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateY90_orthogonal_self(this);
        return rotateY90_general(this);
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x3 rotateYXZ_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cos(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t0 * _t3;
        dd[0] = Math.fma(_t6, _t2, _t3 * _t4);
        dd[1] = _t2 * _t5;
        dd[2] = Math.fma(_t7, _t2, -(_t1 * _t4));
        dd[3] = Math.fma(_t6, _t4, -(_t2 * _t3));
        dd[4] = _t5 * _t4;
        dd[5] = Math.fma(_t7, _t4, _t1 * _t2);
        dd[6] = _t1 * _t5;
        dd[7] = -_t0;
        dd[8] = _t5 * _t3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x3 rotateYXZ_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t5 * _t1;
        double _t12 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t13 = Math.fma(_t6, _t2, -(_t3 * _t4));
        dd[0] = Math.fma(sd[6], _t13, Math.fma(_t8, _t2, _t1 * _t4));
        dd[1] = Math.fma(sd[7], _t13, _t2 * _t5);
        dd[2] = _t13;
        dd[3] = Math.fma(sd[6], _t12, Math.fma(_t8, _t4, -(_t2 * _t1)));
        dd[4] = Math.fma(sd[7], _t12, _t5 * _t4);
        dd[5] = _t12;
        dd[6] = Math.fma(sd[6], _t10, _t3 * _t5);
        dd[7] = Math.fma(sd[7], _t10, -_t0);
        dd[8] = _t10;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x3 rotateYXZ_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t13 = _t5 * _t4;
        double _t14 = _t5 * _t1;
        double _t15 = _t3 * _t5;
        double _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        double _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t18, sd[3] * _t10));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t18, sd[4] * _t10));
        dd[2] = _t20;
        double _buf2 = Math.fma(sd[6], _t19, Math.fma(sd[0], _t21, sd[3] * _t13));
        double _buf3 = Math.fma(sd[7], _t19, Math.fma(sd[1], _t21, sd[4] * _t13));
        dd[5] = _t19;
        dd[6] = Math.fma(sd[6], _t14, Math.fma(sd[0], _t15, -(sd[3] * _t0)));
        dd[7] = Math.fma(sd[7], _t14, Math.fma(sd[1], _t15, -(sd[4] * _t0)));
        dd[8] = _t14;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYXZ}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYXZ} dispatcher.
     */
    private Double3x3 rotateYXZ_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t13 = _t5 * _t4;
        double _t14 = _t5 * _t1;
        double _t15 = _t3 * _t5;
        double _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        double _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        double _buf0 = Math.fma(sd[6], _t20, Math.fma(sd[0], _t18, sd[3] * _t10));
        double _buf1 = Math.fma(sd[7], _t20, Math.fma(sd[1], _t18, sd[4] * _t10));
        double _buf2 = Math.fma(sd[8], _t20, Math.fma(sd[2], _t18, sd[5] * _t10));
        double _buf3 = Math.fma(sd[6], _t19, Math.fma(sd[0], _t21, sd[3] * _t13));
        double _buf4 = Math.fma(sd[7], _t19, Math.fma(sd[1], _t21, sd[4] * _t13));
        double _buf5 = Math.fma(sd[8], _t19, Math.fma(sd[2], _t21, sd[5] * _t13));
        dd[6] = Math.fma(sd[6], _t14, Math.fma(sd[0], _t15, -(sd[3] * _t0)));
        dd[7] = Math.fma(sd[7], _t14, Math.fma(sd[1], _t15, -(sd[4] * _t0)));
        dd[8] = Math.fma(sd[8], _t14, Math.fma(sd[2], _t15, -(sd[5] * _t0)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYXZ(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYXZ_orthogonal(angleX, angleY, angleZ, dest);
        return rotateYXZ_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateYXZ(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateYXZ(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYXZ_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYXZ_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYXZ_orthogonal(angleX, angleY, angleZ, this);
        return rotateYXZ_general(angleX, angleY, angleZ, this);
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x3 rotateYZX_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t4 * _t0;
        double _t7 = _t3 * _t4;
        dd[0] = _t0 * _t1;
        dd[1] = _t4;
        dd[2] = -(_t3 * _t1);
        dd[3] = Math.fma(_t2, _t3, -(_t6 * _t5));
        dd[4] = _t5 * _t1;
        dd[5] = Math.fma(_t7, _t5, _t2 * _t0);
        dd[6] = Math.fma(_t6, _t2, _t3 * _t5);
        dd[7] = -(_t2 * _t1);
        dd[8] = Math.fma(_t5, _t0, -(_t7 * _t2));
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x3 rotateYZX_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t3;
        double _t9 = _t3 * _t0;
        double _t12 = Math.fma(_t7, _t4, _t5 * _t0);
        double _t13 = Math.fma(_t4, _t0, -(_t7 * _t5));
        dd[0] = Math.fma(_t0, _t1, -(sd[6] * _t6));
        dd[1] = Math.fma(-sd[7], _t6, _t3);
        dd[2] = -_t6;
        dd[3] = Math.fma(sd[6], _t12, Math.fma(_t5, _t2, -(_t9 * _t4)));
        dd[4] = Math.fma(sd[7], _t12, _t4 * _t1);
        dd[5] = _t12;
        dd[6] = Math.fma(sd[6], _t13, Math.fma(_t9, _t5, _t2 * _t4));
        dd[7] = Math.fma(sd[7], _t13, -(_t5 * _t1));
        dd[8] = _t13;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x3 rotateYZX_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t2 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t3 * _t2;
        double _t11 = _t4 * _t1;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        double _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        double _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        double _buf0 = Math.fma(-sd[6], _t6, Math.fma(sd[0], _t7, sd[3] * _t3));
        double _buf1 = Math.fma(-sd[7], _t6, Math.fma(sd[1], _t7, sd[4] * _t3));
        dd[2] = -_t6;
        double _buf2 = Math.fma(sd[6], _t18, Math.fma(sd[0], _t20, sd[3] * _t11));
        double _buf3 = Math.fma(sd[7], _t18, Math.fma(sd[1], _t20, sd[4] * _t11));
        dd[5] = _t18;
        dd[6] = Math.fma(sd[6], _t21, Math.fma(sd[0], _t19, -(sd[3] * _t13)));
        dd[7] = Math.fma(sd[7], _t21, Math.fma(sd[1], _t19, -(sd[4] * _t13)));
        dd[8] = _t21;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateYZX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateYZX} dispatcher.
     */
    private Double3x3 rotateYZX_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.cos(angleX);
        double _t5 = Math.sin(angleX);
        double _t6 = _t0 * _t1;
        double _t7 = _t2 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t3 * _t2;
        double _t11 = _t4 * _t1;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t8, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t10, _t5, _t0 * _t4);
        double _t20 = Math.fma(_t5, _t0, -(_t10 * _t4));
        double _t21 = Math.fma(_t4, _t2, -(_t8 * _t5));
        double _buf0 = Math.fma(-sd[6], _t6, Math.fma(sd[0], _t7, sd[3] * _t3));
        double _buf1 = Math.fma(-sd[7], _t6, Math.fma(sd[1], _t7, sd[4] * _t3));
        double _buf2 = Math.fma(-sd[8], _t6, Math.fma(sd[2], _t7, sd[5] * _t3));
        double _buf3 = Math.fma(sd[6], _t18, Math.fma(sd[0], _t20, sd[3] * _t11));
        double _buf4 = Math.fma(sd[7], _t18, Math.fma(sd[1], _t20, sd[4] * _t11));
        double _buf5 = Math.fma(sd[8], _t18, Math.fma(sd[2], _t20, sd[5] * _t11));
        dd[6] = Math.fma(sd[6], _t21, Math.fma(sd[0], _t19, -(sd[3] * _t13)));
        dd[7] = Math.fma(sd[7], _t21, Math.fma(sd[1], _t19, -(sd[4] * _t13)));
        dd[8] = Math.fma(sd[8], _t21, Math.fma(sd[2], _t19, -(sd[5] * _t13)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYZX(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYZX_orthogonal(angleX, angleY, angleZ, dest);
        return rotateYZX_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateYZX(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateYZX(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateYZX_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateYZX_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateYZX_orthogonal(angleX, angleY, angleZ, this);
        return rotateYZX_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn180(@Mutated Double3x3 dest) {
        return rotateY180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateYn180() {
        return rotateY180();
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn270(@Mutated Double3x3 dest) {
        return rotateY90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateYn270() {
        return rotateY90();
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateYn90(@Mutated Double3x3 dest) {
        return rotateY270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateYn90() {
        return rotateY270();
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ(double angle, @Mutated Double3x3 dest) {
        return rotate(angle, dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public Double3x3 rotateZ(double angle) {
        return rotate(angle);
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[4] = -1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = -1.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -1.0;
        dd[4] = -1.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = -sd[4];
        dd[0] = _t0;
        double _buf0 = -sd[1];
        dd[2] = 0.0;
        dd[3] = sd[1];
        dd[4] = _t0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = -sd[4];
        dd[0] = _t0;
        double _buf0 = -sd[1];
        dd[3] = sd[1];
        dd[4] = _t0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = 0.0;
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ180}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code rotateZ180}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ180} dispatcher.
     */
    private Double3x3 rotateZ180_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ180(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ180_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ180_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ180_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ180_affine(dest);
        return rotateZ180_general(dest);
    }


    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZ180() {
        if (Joml.RETURN_NEW) return rotateZ180(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ180_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ180_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ180_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ180_affine_self(this);
        return rotateZ180_general(this);
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = -1.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = -1.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = -1.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = -1.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_orthogonal(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[1];
        double _buf0 = -sd[4];
        dd[2] = 0.0;
        dd[3] = sd[4];
        dd[4] = sd[1];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_orthogonal_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[1];
        double _buf0 = -sd[4];
        dd[3] = sd[4];
        dd[4] = sd[1];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[1] = _buf0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_affine(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[3];
        double _buf1 = -sd[4];
        dd[2] = 0.0;
        dd[3] = sd[0];
        dd[4] = sd[1];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ270}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_affine_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[3];
        double _buf1 = -sd[4];
        dd[3] = sd[0];
        dd[4] = sd[1];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code rotateZ270}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ270} dispatcher.
     */
    private Double3x3 rotateZ270_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = -sd[3];
        double _buf1 = -sd[4];
        double _buf2 = -sd[5];
        dd[3] = sd[0];
        dd[4] = sd[1];
        dd[5] = sd[2];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ270(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ270_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ270_translation(dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ270_orthogonal(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ270_affine(dest);
        return rotateZ270_general(dest);
    }


    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZ270() {
        if (Joml.RETURN_NEW) return rotateZ270(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ270_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ270_translation_self(this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return rotateZ270_orthogonal_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ270_affine_self(this);
        return rotateZ270_general(this);
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_orthogonal_affine(@Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[3];
        double _buf1 = sd[4];
        dd[2] = 0.0;
        dd[3] = -sd[0];
        dd[4] = -sd[1];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_orthogonal_affine_self(@Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[3];
        double _buf1 = sd[4];
        dd[3] = -sd[0];
        dd[4] = -sd[1];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_identity(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 1.0;
        dd[2] = 0.0;
        dd[3] = -1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_identity_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 1.0;
        dd[3] = -1.0;
        dd[4] = 0.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_translation(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 1.0;
        dd[2] = 0.0;
        dd[3] = -1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code rotateZ90}, specialized by runtime matrix
     * properties; reached only through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_translation_self(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = 0.0;
        dd[1] = 1.0;
        dd[3] = -1.0;
        dd[4] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Private body of {@code rotateZ90}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZ90} dispatcher.
     */
    private Double3x3 rotateZ90_general(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[3];
        double _buf1 = sd[4];
        double _buf2 = sd[5];
        dd[3] = -sd[0];
        dd[4] = -sd[1];
        dd[5] = -sd[2];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZ90(@Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ90_identity(dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ90_translation(dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ90_orthogonal_affine(dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateZ90_general(dest);
    }


    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZ90() {
        if (Joml.RETURN_NEW) return rotateZ90(Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZ90_identity_self(this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZ90_translation_self(this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZ90_orthogonal_affine_self(this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return rotateZ90_general(this);
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x3 rotateZXY_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleX);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleY);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t3;
        double _t7 = _t2 * _t1;
        dd[0] = Math.fma(_t0, _t1, -(_t6 * _t4));
        dd[1] = Math.fma(_t7, _t4, _t3 * _t0);
        dd[2] = -(_t4 * _t5);
        dd[3] = -(_t3 * _t5);
        dd[4] = _t5 * _t1;
        dd[5] = _t2;
        dd[6] = Math.fma(_t6, _t0, _t4 * _t1);
        dd[7] = Math.fma(_t4, _t3, -(_t7 * _t0));
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x3 rotateZXY_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleX);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.cos(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.sin(angleZ);
        double _t6 = _t0 * _t1;
        double _t7 = _t4 * _t5;
        double _t8 = _t1 * _t2;
        double _t9 = _t4 * _t3;
        dd[0] = Math.fma(-sd[6], _t6, Math.fma(_t2, _t3, -(_t7 * _t0)));
        dd[1] = Math.fma(-sd[7], _t6, Math.fma(_t9, _t0, _t5 * _t2));
        dd[2] = -_t6;
        dd[3] = Math.fma(sd[6], _t4, -(_t5 * _t1));
        dd[4] = Math.fma(sd[7], _t4, _t1 * _t3);
        dd[5] = _t4;
        dd[6] = Math.fma(sd[6], _t8, Math.fma(_t7, _t2, _t0 * _t3));
        dd[7] = Math.fma(sd[7], _t8, Math.fma(_t0, _t5, -(_t9 * _t2)));
        dd[8] = _t8;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x3 rotateZXY_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleX);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.cos(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.sin(angleZ);
        double _t6 = _t0 * _t1;
        double _t7 = _t4 * _t5;
        double _t8 = _t4 * _t3;
        double _t10 = _t1 * _t3;
        double _t11 = _t5 * _t1;
        double _t12 = _t1 * _t2;
        double _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        double _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        double _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        double _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        double _buf0 = Math.fma(-sd[6], _t6, Math.fma(sd[0], _t20, sd[3] * _t18));
        double _buf1 = Math.fma(-sd[7], _t6, Math.fma(sd[1], _t20, sd[4] * _t18));
        dd[2] = -_t6;
        double _buf2 = Math.fma(sd[6], _t4, Math.fma(sd[3], _t10, -(sd[0] * _t11)));
        double _buf3 = Math.fma(sd[7], _t4, Math.fma(sd[4], _t10, -(sd[1] * _t11)));
        dd[5] = _t4;
        dd[6] = Math.fma(sd[6], _t12, Math.fma(sd[0], _t19, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t12, Math.fma(sd[1], _t19, sd[4] * _t21));
        dd[8] = _t12;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZXY}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZXY} dispatcher.
     */
    private Double3x3 rotateZXY_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleX);
        double _t2 = Math.cos(angleY);
        double _t3 = Math.cos(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.sin(angleZ);
        double _t6 = _t0 * _t1;
        double _t7 = _t4 * _t5;
        double _t8 = _t4 * _t3;
        double _t10 = _t1 * _t3;
        double _t11 = _t5 * _t1;
        double _t12 = _t1 * _t2;
        double _t18 = Math.fma(_t8, _t0, _t5 * _t2);
        double _t19 = Math.fma(_t7, _t2, _t0 * _t3);
        double _t20 = Math.fma(_t2, _t3, -(_t7 * _t0));
        double _t21 = Math.fma(_t0, _t5, -(_t8 * _t2));
        double _buf0 = Math.fma(-sd[6], _t6, Math.fma(sd[0], _t20, sd[3] * _t18));
        double _buf1 = Math.fma(-sd[7], _t6, Math.fma(sd[1], _t20, sd[4] * _t18));
        double _buf2 = Math.fma(-sd[8], _t6, Math.fma(sd[2], _t20, sd[5] * _t18));
        double _buf3 = Math.fma(sd[6], _t4, Math.fma(sd[3], _t10, -(sd[0] * _t11)));
        double _buf4 = Math.fma(sd[7], _t4, Math.fma(sd[4], _t10, -(sd[1] * _t11)));
        double _buf5 = Math.fma(sd[8], _t4, Math.fma(sd[5], _t10, -(sd[2] * _t11)));
        dd[6] = Math.fma(sd[6], _t12, Math.fma(sd[0], _t19, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t12, Math.fma(sd[1], _t19, sd[4] * _t21));
        dd[8] = Math.fma(sd[8], _t12, Math.fma(sd[2], _t19, sd[5] * _t21));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZXY(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZXY_orthogonal(angleX, angleY, angleZ, dest);
        return rotateZXY_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateZXY(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateZXY(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZXY_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZXY_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZXY_orthogonal(angleX, angleY, angleZ, this);
        return rotateZXY_general(angleX, angleY, angleZ, this);
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x3 rotateZYX_identity(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t2 * _t1;
        double _t7 = _t2 * _t4;
        dd[0] = _t0 * _t1;
        dd[1] = _t4 * _t0;
        dd[2] = -_t2;
        dd[3] = Math.fma(_t6, _t3, -(_t4 * _t5));
        dd[4] = Math.fma(_t7, _t3, _t5 * _t1);
        dd[5] = _t3 * _t0;
        dd[6] = Math.fma(_t6, _t5, _t3 * _t4);
        dd[7] = Math.fma(_t7, _t5, -(_t3 * _t1));
        dd[8] = _t5 * _t0;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x3 rotateZYX_translation(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.cos(angleY);
        double _t1 = Math.cos(angleZ);
        double _t2 = Math.sin(angleY);
        double _t3 = Math.sin(angleX);
        double _t4 = Math.sin(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t3 * _t0;
        double _t7 = _t2 * _t1;
        double _t8 = _t5 * _t0;
        double _t9 = _t2 * _t4;
        dd[0] = Math.fma(_t0, _t1, -(sd[6] * _t2));
        dd[1] = Math.fma(_t4, _t0, -(sd[7] * _t2));
        dd[2] = -_t2;
        dd[3] = Math.fma(sd[6], _t6, Math.fma(_t7, _t3, -(_t4 * _t5)));
        dd[4] = Math.fma(sd[7], _t6, Math.fma(_t9, _t3, _t5 * _t1));
        dd[5] = _t6;
        dd[6] = Math.fma(sd[6], _t8, Math.fma(_t7, _t5, _t3 * _t4));
        dd[7] = Math.fma(sd[7], _t8, Math.fma(_t9, _t5, -(_t3 * _t1)));
        dd[8] = _t8;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x3 rotateZYX_orthogonal(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.cos(angleZ);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t1 * _t2;
        double _t7 = _t3 * _t1;
        double _t8 = _t4 * _t1;
        double _t9 = _t0 * _t2;
        double _t11 = _t0 * _t3;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        double _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        double _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        double _buf0 = Math.fma(-sd[6], _t0, Math.fma(sd[0], _t6, sd[3] * _t7));
        double _buf1 = Math.fma(-sd[7], _t0, Math.fma(sd[1], _t6, sd[4] * _t7));
        dd[2] = -_t0;
        double _buf2 = Math.fma(sd[6], _t8, Math.fma(sd[0], _t20, sd[3] * _t18));
        double _buf3 = Math.fma(sd[7], _t8, Math.fma(sd[1], _t20, sd[4] * _t18));
        dd[5] = _t8;
        dd[6] = Math.fma(sd[6], _t13, Math.fma(sd[0], _t19, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t13, Math.fma(sd[1], _t19, sd[4] * _t21));
        dd[8] = _t13;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Private body of {@code rotateZYX}, specialized by runtime matrix properties; reached only
     * through the public {@code rotateZYX} dispatcher.
     */
    private Double3x3 rotateZYX_general(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.sin(angleY);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.cos(angleZ);
        double _t3 = Math.sin(angleZ);
        double _t4 = Math.sin(angleX);
        double _t5 = Math.cos(angleX);
        double _t6 = _t1 * _t2;
        double _t7 = _t3 * _t1;
        double _t8 = _t4 * _t1;
        double _t9 = _t0 * _t2;
        double _t11 = _t0 * _t3;
        double _t13 = _t5 * _t1;
        double _t18 = Math.fma(_t11, _t4, _t5 * _t2);
        double _t19 = Math.fma(_t9, _t5, _t4 * _t3);
        double _t20 = Math.fma(_t9, _t4, -(_t3 * _t5));
        double _t21 = Math.fma(_t11, _t5, -(_t4 * _t2));
        double _buf0 = Math.fma(-sd[6], _t0, Math.fma(sd[0], _t6, sd[3] * _t7));
        double _buf1 = Math.fma(-sd[7], _t0, Math.fma(sd[1], _t6, sd[4] * _t7));
        double _buf2 = Math.fma(-sd[8], _t0, Math.fma(sd[2], _t6, sd[5] * _t7));
        double _buf3 = Math.fma(sd[6], _t8, Math.fma(sd[0], _t20, sd[3] * _t18));
        double _buf4 = Math.fma(sd[7], _t8, Math.fma(sd[1], _t20, sd[4] * _t18));
        double _buf5 = Math.fma(sd[8], _t8, Math.fma(sd[2], _t20, sd[5] * _t18));
        dd[6] = Math.fma(sd[6], _t13, Math.fma(sd[0], _t19, sd[3] * _t21));
        dd[7] = Math.fma(sd[7], _t13, Math.fma(sd[1], _t19, sd[4] * _t21));
        dd[8] = Math.fma(sd[8], _t13, Math.fma(sd[2], _t19, sd[5] * _t21));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZYX(double angleX, double angleY, double angleZ, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZYX_orthogonal(angleX, angleY, angleZ, dest);
        return rotateZYX_general(angleX, angleY, angleZ, dest);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public Double3x3 rotateZYX(double angleX, double angleY, double angleZ) {
        if (Joml.RETURN_NEW) return rotateZYX(angleX, angleY, angleZ, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return rotateZYX_identity(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return rotateZYX_translation(angleX, angleY, angleZ, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return rotateZYX_orthogonal(angleX, angleY, angleZ, this);
        return rotateZYX_general(angleX, angleY, angleZ, this);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn180(@Mutated Double3x3 dest) {
        return rotateZ180(dest);
    }


    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZn180() {
        return rotateZ180();
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn270(@Mutated Double3x3 dest) {
        return rotateZ90(dest);
    }


    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZn270() {
        return rotateZ90();
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 rotateZn90(@Mutated Double3x3 dest) {
        return rotateZ270(dest);
    }


    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated public Double3x3 rotateZn90() {
        return rotateZ270();
    }


    /**
     * Apply a scaling by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(Double2R v, @Mutated Double3x3 dest) {
        return scale(v.x(), v.y(), dest);
    }


    /**
     * Apply a scaling by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3x3 scale(Double2R v) {
        return scale(v.x(), v.y());
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_identity(double vX, double vY, @Mutated Double3x3 dest) {
        return preScale_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_identity_self(double vX, double vY, @Mutated Double3x3 dest) {
        return preScale_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_translation(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = vY;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_translation_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = vX;
        dd[4] = vY;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_orthogonal(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[2] = 0.0;
        dd[3] = sd[3] * vY;
        dd[4] = sd[4] * vY;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_orthogonal_self(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[3] = sd[3] * vY;
        dd[4] = sd[4] * vY;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_general(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sd[0] * vX;
        dd[1] = sd[1] * vX;
        dd[2] = sd[2] * vX;
        dd[3] = sd[3] * vY;
        dd[4] = sd[4] * vY;
        dd[5] = sd[5] * vY;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(double vX, double vY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(vX, vY, dest);
        return scale_general(vX, vY, dest);
    }


    /**
     * Apply a scaling by ({@code vX}, {@code vY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 scale(double vX, double vY) {
        if (Joml.RETURN_NEW) return scale(vX, vY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal_self(vX, vY, this);
        return scale_general(vX, vY, this);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_identity(double s, @Mutated Double3x3 dest) {
        return preScale_identity(s, dest);
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_identity_self(double s, @Mutated Double3x3 dest) {
        return preScale_identity_self(s, dest);
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_translation(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_translation_self(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_orthogonal(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = 0.0;
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = 0.0;
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scale}, specialized by runtime matrix properties;
     * reached only through the public {@code scale} dispatcher.
     */
    private Double3x3 scale_orthogonal_self(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[6] = sd[6];
        dd[7] = sd[7];
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scale}, specialized by runtime matrix properties; reached only through
     * the public {@code scale} dispatcher.
     */
    private Double3x3 scale_general(double s, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s * sd[0];
        dd[1] = s * sd[1];
        dd[2] = s * sd[2];
        dd[3] = s * sd[3];
        dd[4] = s * sd[4];
        dd[5] = s * sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a scaling by {@code s} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scale(double s, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity(s, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation(s, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal(s, dest);
        return scale_general(s, dest);
    }


    /**
     * Apply a scaling by {@code s} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated public Double3x3 scale(double s) {
        if (Joml.RETURN_NEW) return scale(s, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scale_identity_self(s, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scale_translation_self(s, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scale_orthogonal_self(s, this);
        return scale_general(s, this);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(double s, Double2R pivot, @Mutated Double3x3 dest) {
        return scaleAround(s, pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 scaleAround(double s, Double2R pivot) {
        return scaleAround(s, pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_identity(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preScaleAround_identity(s, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_identity_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preScaleAround_identity_self(s, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_translation(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = s;
        dd[5] = 0.0;
        dd[6] = Math.fma(-s, pivotX, sd[6] + pivotX);
        dd[7] = Math.fma(-s, pivotY, sd[7] + pivotY);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_translation_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = s;
        dd[4] = s;
        dd[6] = Math.fma(-s, pivotX, sd[6] + pivotX);
        dd[7] = Math.fma(-s, pivotY, sd[7] + pivotY);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_orthogonal(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _buf0 = s * sd[0];
        double _buf1 = s * sd[1];
        dd[2] = 0.0;
        double _buf2 = s * sd[3];
        double _buf3 = s * sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[0], _t0, Math.fma(sd[3], _t1, sd[6]));
        dd[7] = Math.fma(sd[1], _t0, Math.fma(sd[4], _t1, sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_orthogonal_self(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _buf0 = s * sd[0];
        double _buf1 = s * sd[1];
        double _buf2 = s * sd[3];
        double _buf3 = s * sd[4];
        dd[6] = Math.fma(sd[0], _t0, Math.fma(sd[3], _t1, sd[6]));
        dd[7] = Math.fma(sd[1], _t0, Math.fma(sd[4], _t1, sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_general(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _buf0 = s * sd[0];
        double _buf1 = s * sd[1];
        double _buf2 = s * sd[2];
        double _buf3 = s * sd[3];
        double _buf4 = s * sd[4];
        double _buf5 = s * sd[5];
        dd[6] = Math.fma(sd[0], _t0, Math.fma(sd[3], _t1, sd[6]));
        dd[7] = Math.fma(sd[1], _t0, Math.fma(sd[4], _t1, sd[7]));
        dd[8] = Math.fma(sd[2], _t0, Math.fma(sd[5], _t1, sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY}) to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(double s, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(s, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(s, pivotX, pivotY, dest);
        return scaleAround_general(s, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point ({@code pivotX}, {@code pivotY}) to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 scaleAround(double s, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(s, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(s, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal_self(s, pivotX, pivotY, this);
        return scaleAround_general(s, pivotX, pivotY, this);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(Double2R s, Double2R pivot, @Mutated Double3x3 dest) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y(), dest);
    }


    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    public @Mutated Double3x3 scaleAround(Double2R s, Double2R pivot) {
        return scaleAround(s.x(), s.y(), pivot.x(), pivot.y());
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_identity(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preScaleAround_identity(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_identity_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        return preScaleAround_identity_self(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_translation(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = sY;
        dd[5] = 0.0;
        dd[6] = Math.fma(-pivotX, sX, sd[6] + pivotX);
        dd[7] = Math.fma(-pivotY, sY, sd[7] + pivotY);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_translation_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        dd[0] = sX;
        dd[4] = sY;
        dd[6] = Math.fma(-pivotX, sX, sd[6] + pivotX);
        dd[7] = Math.fma(-pivotY, sY, sd[7] + pivotY);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_orthogonal(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        double _buf0 = sX * sd[0];
        double _buf1 = sX * sd[1];
        dd[2] = 0.0;
        double _buf2 = sY * sd[3];
        double _buf3 = sY * sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[0], _t2, Math.fma(sd[3], _t3, sd[6]));
        dd[7] = Math.fma(sd[1], _t2, Math.fma(sd[4], _t3, sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code scaleAround}, specialized by runtime matrix
     * properties; reached only through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_orthogonal_self(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        double _buf0 = sX * sd[0];
        double _buf1 = sX * sd[1];
        double _buf2 = sY * sd[3];
        double _buf3 = sY * sd[4];
        dd[6] = Math.fma(sd[0], _t2, Math.fma(sd[3], _t3, sd[6]));
        dd[7] = Math.fma(sd[1], _t2, Math.fma(sd[4], _t3, sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code scaleAround}, specialized by runtime matrix properties; reached only
     * through the public {@code scaleAround} dispatcher.
     */
    private Double3x3 scaleAround_general(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t2 = Math.fma(-pivotX, sX, pivotX);
        double _t3 = Math.fma(-pivotY, sY, pivotY);
        double _buf0 = sX * sd[0];
        double _buf1 = sX * sd[1];
        double _buf2 = sX * sd[2];
        double _buf3 = sY * sd[3];
        double _buf4 = sY * sd[4];
        double _buf5 = sY * sd[5];
        dd[6] = Math.fma(sd[0], _t2, Math.fma(sd[3], _t3, sd[6]));
        dd[7] = Math.fma(sd[1], _t2, Math.fma(sd[4], _t3, sd[7]));
        dd[8] = Math.fma(sd[2], _t2, Math.fma(sd[5], _t3, sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 scaleAround(double sX, double sY, double pivotX, double pivotY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation(sX, sY, pivotX, pivotY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal(sX, sY, pivotX, pivotY, dest);
        return scaleAround_general(sX, sY, pivotX, pivotY, dest);
    }


    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated public Double3x3 scaleAround(double sX, double sY, double pivotX, double pivotY) {
        if (Joml.RETURN_NEW) return scaleAround(sX, sY, pivotX, pivotY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return scaleAround_identity_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return scaleAround_translation_self(sX, sY, pivotX, pivotY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return scaleAround_orthogonal_self(sX, sY, pivotX, pivotY, this);
        return scaleAround_general(sX, sY, pivotX, pivotY, this);
    }


    /**
     * Apply a translation by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 translate(Double2R v, @Mutated Double3x3 dest) {
        return translate(v.x(), v.y(), dest);
    }


    /**
     * Apply a translation by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return this
     */
    public @Mutated Double3x3 translate(Double2R v) {
        return translate(v.x(), v.y());
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_orthogonal_affine(double vX, double vY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        dd[2] = 0.0;
        double _buf2 = sd[3];
        double _buf3 = sd[4];
        dd[5] = 0.0;
        dd[6] = Math.fma(sd[0], vX, Math.fma(sd[3], vY, sd[6]));
        dd[7] = Math.fma(sd[1], vX, Math.fma(sd[4], vY, sd[7]));
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_orthogonal_affine_self(double vX, double vY, @Mutated Double3x3 dest, int _props) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[3];
        double _buf3 = sd[4];
        dd[6] = Math.fma(sd[0], vX, Math.fma(sd[3], vY, sd[6]));
        dd[7] = Math.fma(sd[1], vX, Math.fma(sd[4], vY, sd[7]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = _props;
        return dest;
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_identity(double vX, double vY, @Mutated Double3x3 dest) {
        return preTranslate_identity(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_identity_self(double vX, double vY, @Mutated Double3x3 dest) {
        return preTranslate_identity_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_translation(double vX, double vY, @Mutated Double3x3 dest) {
        return preTranslate_translation(vX, vY, dest);
    }


    /**
     * Private in-place self-form body of {@code translate}, specialized by runtime matrix
     * properties; reached only through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_translation_self(double vX, double vY, @Mutated Double3x3 dest) {
        return preTranslate_translation_self(vX, vY, dest);
    }


    /**
     * Private body of {@code translate}, specialized by runtime matrix properties; reached only
     * through the public {@code translate} dispatcher.
     */
    private Double3x3 translate_general(double vX, double vY, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        double _buf4 = sd[4];
        double _buf5 = sd[5];
        dd[6] = Math.fma(sd[0], vX, Math.fma(sd[3], vY, sd[6]));
        dd[7] = Math.fma(sd[1], vX, Math.fma(sd[4], vY, sd[7]));
        dd[8] = Math.fma(sd[2], vX, Math.fma(sd[5], vY, sd[8]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 translate(double vX, double vY, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity(vX, vY, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation(vX, vY, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return translate_orthogonal_affine(vX, vY, dest, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return translate_general(vX, vY, dest);
    }


    /**
     * Apply a translation by ({@code vX}, {@code vY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param vX the {@code x} component of the translation offsets {@code (vX, vY)}
     * @param vY the {@code y} component of the translation offsets {@code (vX, vY)}
     * @return this
     */
    @Mutated public Double3x3 translate(double vX, double vY) {
        if (Joml.RETURN_NEW) return translate(vX, vY, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return translate_identity_self(vX, vY, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return translate_translation_self(vX, vY, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return translate_orthogonal_affine_self(vX, vY, this, (p & Joml.UNIQUE_ORTHOGONAL) | Joml.BIT_AFFINE);
        return translate_general(vX, vY, this);
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double3x3 view_identity(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0 * _t1_inv;
        dd[5] = 0.0;
        dd[6] = -((left + right) * _t0_inv);
        dd[7] = -((bottom + top) * _t1_inv);
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double3x3 view_identity_self(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[4] = 2.0 * _t1_inv;
        dd[6] = -((left + right) * _t0_inv);
        dd[7] = -((bottom + top) * _t1_inv);
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double3x3 view_translation(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 2.0 * _t1_inv;
        dd[5] = 0.0;
        dd[6] = sd[6] - (left + right) * _t0_inv;
        dd[7] = sd[7] - (bottom + top) * _t1_inv;
        dd[8] = 1.0;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double3x3 view_translation_self(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        dd[0] = 2.0 * _t0_inv;
        dd[4] = 2.0 * _t1_inv;
        dd[6] = sd[6] - (left + right) * _t0_inv;
        dd[7] = sd[7] - (bottom + top) * _t1_inv;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double3x3 view_orthogonal(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        dd[2] = 0.0;
        double _buf2 = 2.0 * sd[3] * _t1_inv;
        double _buf3 = 2.0 * sd[4] * _t1_inv;
        dd[5] = 0.0;
        dd[6] = sd[6] - sd[0] * _t2 * _t0_inv - sd[3] * _t3 * _t1_inv;
        dd[7] = sd[7] - sd[1] * _t2 * _t0_inv - sd[4] * _t3 * _t1_inv;
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double3x3 view_orthogonal_self(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        double _buf2 = 2.0 * sd[3] * _t1_inv;
        double _buf3 = 2.0 * sd[4] * _t1_inv;
        dd[6] = sd[6] - sd[0] * _t2 * _t0_inv - sd[3] * _t3 * _t1_inv;
        dd[7] = sd[7] - sd[1] * _t2 * _t0_inv - sd[4] * _t3 * _t1_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double3x3 view_affine(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        dd[2] = 0.0;
        double _buf2 = 2.0 * sd[3] * _t1_inv;
        double _buf3 = 2.0 * sd[4] * _t1_inv;
        dd[5] = 0.0;
        dd[6] = sd[6] + (-(sd[0] * _t2 * _t0_inv) - sd[3] * _t3 * _t1_inv);
        dd[7] = sd[7] + (-(sd[1] * _t2 * _t0_inv) - sd[4] * _t3 * _t1_inv);
        dd[8] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private in-place self-form body of {@code view}, specialized by runtime matrix properties;
     * reached only through the public {@code view} dispatcher.
     */
    private Double3x3 view_affine_self(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        double _buf2 = 2.0 * sd[3] * _t1_inv;
        double _buf3 = 2.0 * sd[4] * _t1_inv;
        dd[6] = sd[6] + (-(sd[0] * _t2 * _t0_inv) - sd[3] * _t3 * _t1_inv);
        dd[7] = sd[7] + (-(sd[1] * _t2 * _t0_inv) - sd[4] * _t3 * _t1_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        ((Double3x3Impl) dest).properties = Joml.BIT_AFFINE;
        return dest;
    }


    /**
     * Private body of {@code view}, specialized by runtime matrix properties; reached only through
     * the public {@code view} dispatcher.
     */
    private Double3x3 view_general(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = right - left;
        double _t0_inv = 1.0 / _t0;
        double _t1 = top - bottom;
        double _t1_inv = 1.0 / _t1;
        double _t2 = left + right;
        double _t3 = bottom + top;
        double _buf0 = 2.0 * sd[0] * _t0_inv;
        double _buf1 = 2.0 * sd[1] * _t0_inv;
        double _buf2 = 2.0 * sd[2] * _t0_inv;
        double _buf3 = 2.0 * sd[3] * _t1_inv;
        double _buf4 = 2.0 * sd[4] * _t1_inv;
        double _buf5 = 2.0 * sd[5] * _t1_inv;
        dd[6] = sd[6] + (-(sd[0] * _t2 * _t0_inv) - sd[3] * _t3 * _t1_inv);
        dd[7] = sd[7] + (-(sd[1] * _t2 * _t0_inv) - sd[4] * _t3 * _t1_inv);
        dd[8] = sd[8] + (-(sd[2] * _t2 * _t0_inv) - sd[5] * _t3 * _t1_inv);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 view(double left, double right, double bottom, double top, @Mutated Double3x3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity(left, right, bottom, top, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation(left, right, bottom, top, dest);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal(left, right, bottom, top, dest);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return view_affine(left, right, bottom, top, dest);
        return view_general(left, right, bottom, top, dest);
    }


    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this
     */
    @Mutated public Double3x3 view(double left, double right, double bottom, double top) {
        if (Joml.RETURN_NEW) return view(left, right, bottom, top, Joml.double3x3());
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return view_identity_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return view_translation_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_ORTHOGONAL) == Joml.BIT_ORTHOGONAL) return view_orthogonal_self(left, right, bottom, top, this);
        if ((p & Joml.BIT_AFFINE) == Joml.BIT_AFFINE) return view_affine_self(left, right, bottom, top, this);
        return view_general(left, right, bottom, top, this);
    }


    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(Double3R v, @Mutated Double3 dest) {
        return mul(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_identity(double vX, double vY, double vZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = vX;
        dd[1] = vY;
        dd[2] = vZ;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_translation(double vX, double vY, double vZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(sd[6], vZ, vX);
        dd[1] = Math.fma(sd[7], vZ, vY);
        dd[2] = vZ;
        return dest;
    }


    /**
     * Private body of {@code mul}, specialized by runtime matrix properties; reached only through
     * the public {@code mul} dispatcher.
     */
    private Double3 mul_general(double vX, double vY, double vZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(sd[6], vZ, Math.fma(sd[0], vX, sd[3] * vY));
        dd[1] = Math.fma(sd[7], vZ, Math.fma(sd[1], vX, sd[4] * vY));
        dd[2] = Math.fma(sd[8], vZ, Math.fma(sd[2], vX, sd[5] * vY));
        return dest;
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
    public Double3 mul(double vX, double vY, double vZ, @Mutated Double3 dest) {
        int p = this.properties;
        if ((p & Joml.BIT_IDENTITY) == Joml.BIT_IDENTITY) return mul_identity(vX, vY, vZ, dest);
        if ((p & Joml.BIT_TRANSLATION) == Joml.BIT_TRANSLATION) return mul_translation(vX, vY, vZ, dest);
        return mul_general(vX, vY, vZ, dest);
    }

    public double m00() { return data[0]; }
    public double m01() { return data[3]; }
    public double m02() { return data[6]; }
    public double m10() { return data[1]; }
    public double m11() { return data[4]; }
    public double m12() { return data[7]; }
    public double m20() { return data[2]; }
    public double m21() { return data[5]; }
    public double m22() { return data[8]; }

    @Override public String toString() {
        return "Double3x3(\n    " + m00() + ", " + m01() + ", " + m02() + "\n    " + m10() + ", " + m11() + ", " + m12() + "\n    " + m20() + ", " + m21() + ", " + m22() + "\n)";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double3x3Impl)) return false;
        Double3x3Impl o = (Double3x3Impl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Double.isFinite(data[0])
            && Double.isFinite(data[1])
            && Double.isFinite(data[2])
            && Double.isFinite(data[3])
            && Double.isFinite(data[4])
            && Double.isFinite(data[5])
            && Double.isFinite(data[6])
            && Double.isFinite(data[7])
            && Double.isFinite(data[8]);
    }

    @Override public boolean equalsEpsilon(Double3x3R other, double epsilon) {
        return Math.abs(data[0] - other.m00()) <= epsilon
            && Math.abs(data[3] - other.m01()) <= epsilon
            && Math.abs(data[6] - other.m02()) <= epsilon
            && Math.abs(data[1] - other.m10()) <= epsilon
            && Math.abs(data[4] - other.m11()) <= epsilon
            && Math.abs(data[7] - other.m12()) <= epsilon
            && Math.abs(data[2] - other.m20()) <= epsilon
            && Math.abs(data[5] - other.m21()) <= epsilon
            && Math.abs(data[8] - other.m22()) <= epsilon;
    }

    public double[] storeCM(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = this.data[6];
        dest[offset + 7] = this.data[7];
        dest[offset + 8] = this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadCM(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        this.data[8] = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double3x3 loadCMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    public Double3x3 loadCMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public Double3x3 storeCMUnsafe(long address) {
        return RAW_OPS.storeCMUnsafe(this, address);
    }
    @Mutated public Double3x3 loadCMUnsafe(long address) {
        return RAW_OPS.loadCMUnsafe(this, address);
    }

    public float[] storeCM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) this.data[3];
        dest[offset + 4] = (float) this.data[4];
        dest[offset + 5] = (float) this.data[5];
        dest[offset + 6] = (float) this.data[6];
        dest[offset + 7] = (float) this.data[7];
        dest[offset + 8] = (float) this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadCM(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        this.data[8] = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCMAbsolute(this, index, buf);
    }
    @Mutated public Double3x3 loadCMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadCMAbsolute(this, index, buf);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf);
    }
    public Double3x3 loadCMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf);
    }
    public Double3x3 storeCMFloatUnsafe(long address) {
        return RAW_OPS.storeCMFloatUnsafe(this, address);
    }
    @Mutated public Double3x3 loadCMFloatUnsafe(long address) {
        return RAW_OPS.loadCMFloatUnsafe(this, address);
    }

    public double[] storeRM(@Mutated double[] dest, int offset) {
        if (dest == this.data) return storeRM_aliased(dest, offset);
        return storeRM_distinct(dest, offset);
    }
    private double[] storeRM_distinct(double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[3];
        dest[offset + 2] = this.data[6];
        dest[offset + 3] = this.data[1];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[7];
        dest[offset + 6] = this.data[2];
        dest[offset + 7] = this.data[5];
        dest[offset + 8] = this.data[8];
        return dest;
    }
    private double[] storeRM_aliased(double[] dest, int offset) {
        double[] d = this.data;
        double t0 = d[0];
        double t1 = d[1];
        double t2 = d[2];
        double t3 = d[3];
        double t4 = d[4];
        double t5 = d[5];
        double t6 = d[6];
        double t7 = d[7];
        double t8 = d[8];
        dest[offset + 0] = t0;
        dest[offset + 1] = t3;
        dest[offset + 2] = t6;
        dest[offset + 3] = t1;
        dest[offset + 4] = t4;
        dest[offset + 5] = t7;
        dest[offset + 6] = t2;
        dest[offset + 7] = t5;
        dest[offset + 8] = t8;
        return dest;
    }
    @Mutated public Double3x3 loadRM(double[] src, int offset) {
        if (src == this.data) return loadRM_aliased(src, offset);
        return loadRM_distinct(src, offset);
    }
    private Double3x3 loadRM_distinct(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[3] = src[offset + 1];
        this.data[6] = src[offset + 2];
        this.data[1] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[7] = src[offset + 5];
        this.data[2] = src[offset + 6];
        this.data[5] = src[offset + 7];
        this.data[8] = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    private Double3x3 loadRM_aliased(double[] src, int offset) {
        double t0 = src[offset + 0];
        double t1 = src[offset + 1];
        double t2 = src[offset + 2];
        double t3 = src[offset + 3];
        double t4 = src[offset + 4];
        double t5 = src[offset + 5];
        double t6 = src[offset + 6];
        double t7 = src[offset + 7];
        double t8 = src[offset + 8];
        double[] d = this.data;
        d[0] = t0;
        d[3] = t1;
        d[6] = t2;
        d[1] = t3;
        d[4] = t4;
        d[7] = t5;
        d[2] = t6;
        d[5] = t7;
        d[8] = t8;
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double3x3 loadRMAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    public Double3x3 loadRMAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public Double3x3 storeRMUnsafe(long address) {
        return RAW_OPS.storeRMUnsafe(this, address);
    }
    @Mutated public Double3x3 loadRMUnsafe(long address) {
        return RAW_OPS.loadRMUnsafe(this, address);
    }

    public float[] storeRM(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[3];
        dest[offset + 2] = (float) this.data[6];
        dest[offset + 3] = (float) this.data[1];
        dest[offset + 4] = (float) this.data[4];
        dest[offset + 5] = (float) this.data[7];
        dest[offset + 6] = (float) this.data[2];
        dest[offset + 7] = (float) this.data[5];
        dest[offset + 8] = (float) this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadRM(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[3] = src[offset + 1];
        this.data[6] = src[offset + 2];
        this.data[1] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[7] = src[offset + 5];
        this.data[2] = src[offset + 6];
        this.data[5] = src[offset + 7];
        this.data[8] = src[offset + 8];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRMAbsolute(this, index, buf);
    }
    @Mutated public Double3x3 loadRMAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadRMAbsolute(this, index, buf);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf);
    }
    public Double3x3 loadRMFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf);
    }
    public Double3x3 storeRMFloatUnsafe(long address) {
        return RAW_OPS.storeRMFloatUnsafe(this, address);
    }
    @Mutated public Double3x3 loadRMFloatUnsafe(long address) {
        return RAW_OPS.loadRMFloatUnsafe(this, address);
    }

    public double[] storeCM(@Mutated double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[_p1] = this.data[3];
        dest[_p1 + 1] = this.data[4];
        dest[_p1 + 2] = this.data[5];
        dest[_p2] = this.data[6];
        dest[_p2 + 1] = this.data[7];
        dest[_p2 + 2] = this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadCM(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[_p1];
        this.data[4] = src[_p1 + 1];
        this.data[5] = src[_p1 + 2];
        this.data[6] = src[_p2];
        this.data[7] = src[_p2 + 1];
        this.data[8] = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x3 loadCMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    public Double3x3 loadCMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public Double3x3 storeCMUnsafe(long address, int stride) {
        return RAW_OPS.storeCMUnsafe(this, address, stride);
    }
    @Mutated public Double3x3 loadCMUnsafe(long address, int stride) {
        return RAW_OPS.loadCMUnsafe(this, address, stride);
    }

    public float[] storeCM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[_p1] = (float) this.data[3];
        dest[_p1 + 1] = (float) this.data[4];
        dest[_p1 + 2] = (float) this.data[5];
        dest[_p2] = (float) this.data[6];
        dest[_p2 + 1] = (float) this.data[7];
        dest[_p2 + 2] = (float) this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadCM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[_p1];
        this.data[4] = src[_p1 + 1];
        this.data[5] = src[_p1 + 2];
        this.data[6] = src[_p2];
        this.data[7] = src[_p2 + 1];
        this.data[8] = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeCMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x3 loadCMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadCMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeCMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x3 loadCMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadCMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x3 storeCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeCMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double3x3 loadCMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadCMFloatUnsafe(this, address, stride);
    }

    public double[] storeRM(@Mutated double[] dest, int offset, int stride) {
        if (dest == this.data) return storeRM_aliased(dest, offset, stride);
        return storeRM_distinct(dest, offset, stride);
    }
    private double[] storeRM_distinct(double[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = this.data[0];
        dest[offset + 1] = this.data[3];
        dest[offset + 2] = this.data[6];
        dest[_p1] = this.data[1];
        dest[_p1 + 1] = this.data[4];
        dest[_p1 + 2] = this.data[7];
        dest[_p2] = this.data[2];
        dest[_p2 + 1] = this.data[5];
        dest[_p2 + 2] = this.data[8];
        return dest;
    }
    private double[] storeRM_aliased(double[] dest, int offset, int stride) {
        double[] d = this.data;
        double t0 = d[0];
        double t1 = d[1];
        double t2 = d[2];
        double t3 = d[3];
        double t4 = d[4];
        double t5 = d[5];
        double t6 = d[6];
        double t7 = d[7];
        double t8 = d[8];
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = t0;
        dest[offset + 1] = t3;
        dest[offset + 2] = t6;
        dest[_p1] = t1;
        dest[_p1 + 1] = t4;
        dest[_p1 + 2] = t7;
        dest[_p2] = t2;
        dest[_p2 + 1] = t5;
        dest[_p2 + 2] = t8;
        return dest;
    }
    @Mutated public Double3x3 loadRM(double[] src, int offset, int stride) {
        if (src == this.data) return loadRM_aliased(src, offset, stride);
        return loadRM_distinct(src, offset, stride);
    }
    private Double3x3 loadRM_distinct(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[3] = src[offset + 1];
        this.data[6] = src[offset + 2];
        this.data[1] = src[_p1];
        this.data[4] = src[_p1 + 1];
        this.data[7] = src[_p1 + 2];
        this.data[2] = src[_p2];
        this.data[5] = src[_p2 + 1];
        this.data[8] = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    private Double3x3 loadRM_aliased(double[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        double t0 = src[offset];
        double t1 = src[offset + 1];
        double t2 = src[offset + 2];
        double t3 = src[_p1];
        double t4 = src[_p1 + 1];
        double t5 = src[_p1 + 2];
        double t6 = src[_p2];
        double t7 = src[_p2 + 1];
        double t8 = src[_p2 + 2];
        double[] d = this.data;
        d[0] = t0;
        d[3] = t1;
        d[6] = t2;
        d[1] = t3;
        d[4] = t4;
        d[7] = t5;
        d[2] = t6;
        d[5] = t7;
        d[8] = t8;
        this.properties = determineProperties();
        return this;
    }
    public DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x3 loadRMAbsolute(int index, DoubleBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    public Double3x3 loadRMAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public Double3x3 storeRMUnsafe(long address, int stride) {
        return RAW_OPS.storeRMUnsafe(this, address, stride);
    }
    @Mutated public Double3x3 loadRMUnsafe(long address, int stride) {
        return RAW_OPS.loadRMUnsafe(this, address, stride);
    }

    public float[] storeRM(@Mutated float[] dest, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        dest[offset] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[3];
        dest[offset + 2] = (float) this.data[6];
        dest[_p1] = (float) this.data[1];
        dest[_p1 + 1] = (float) this.data[4];
        dest[_p1 + 2] = (float) this.data[7];
        dest[_p2] = (float) this.data[2];
        dest[_p2 + 1] = (float) this.data[5];
        dest[_p2 + 2] = (float) this.data[8];
        return dest;
    }
    public @Mutated Double3x3 loadRM(float[] src, int offset, int stride) {
        int _p1 = offset + stride;
        int _p2 = _p1 + stride;
        this.data[0] = src[offset];
        this.data[3] = src[offset + 1];
        this.data[6] = src[offset + 2];
        this.data[1] = src[_p1];
        this.data[4] = src[_p1 + 1];
        this.data[7] = src[_p1 + 2];
        this.data[2] = src[_p2];
        this.data[5] = src[_p2 + 1];
        this.data[8] = src[_p2 + 2];
        this.properties = determineProperties();
        return this;
    }
    public FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer buf, int stride) {
        return BB_OPS.storeRMAbsolute(this, index, buf, stride);
    }
    @Mutated public Double3x3 loadRMAbsolute(int index, FloatBuffer buf, int stride) {
        return BB_OPS.loadRMAbsolute(this, index, buf, stride);
    }
    public ByteBuffer storeRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.storeRMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x3 loadRMFloatAbsolute(int index, ByteBuffer buf, int stride) {
        return BB_OPS.loadRMFloatAbsolute(this, index, buf, stride);
    }
    public Double3x3 storeRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.storeRMFloatUnsafe(this, address, stride);
    }
    @Mutated public Double3x3 loadRMFloatUnsafe(long address, int stride) {
        return RAW_OPS.loadRMFloatUnsafe(this, address, stride);
    }

    public double[] storeCM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = 0.0;
        dest[offset + 4] = this.data[3];
        dest[offset + 5] = this.data[4];
        dest[offset + 6] = this.data[5];
        dest[offset + 7] = 0.0;
        dest[offset + 8] = this.data[6];
        dest[offset + 9] = this.data[7];
        dest[offset + 10] = this.data[8];
        dest[offset + 11] = 0.0;
        dest[offset + 12] = 0.0;
        dest[offset + 13] = 0.0;
        dest[offset + 14] = 0.0;
        dest[offset + 15] = 1.0;
        return dest;
    }
    public DoubleBuffer storeCM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public Double3x3 storeCM4x4Unsafe(long address) {
        return RAW_OPS.storeCM4x4Unsafe(this, address);
    }

    public float[] storeCM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) 0.0;
        dest[offset + 4] = (float) this.data[3];
        dest[offset + 5] = (float) this.data[4];
        dest[offset + 6] = (float) this.data[5];
        dest[offset + 7] = (float) 0.0;
        dest[offset + 8] = (float) this.data[6];
        dest[offset + 9] = (float) this.data[7];
        dest[offset + 10] = (float) this.data[8];
        dest[offset + 11] = (float) 0.0;
        dest[offset + 12] = (float) 0.0;
        dest[offset + 13] = (float) 0.0;
        dest[offset + 14] = (float) 0.0;
        dest[offset + 15] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeCM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeCM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeCM4x4FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeCM4x4FloatAbsolute(this, index, buf);
    }
    public Double3x3 storeCM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeCM4x4FloatUnsafe(this, address);
    }

    public double[] storeRM4x4(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[3];
        dest[offset + 2] = this.data[6];
        dest[offset + 3] = 0.0;
        dest[offset + 4] = this.data[1];
        dest[offset + 5] = this.data[4];
        dest[offset + 6] = this.data[7];
        dest[offset + 7] = 0.0;
        dest[offset + 8] = this.data[2];
        dest[offset + 9] = this.data[5];
        dest[offset + 10] = this.data[8];
        dest[offset + 11] = 0.0;
        dest[offset + 12] = 0.0;
        dest[offset + 13] = 0.0;
        dest[offset + 14] = 0.0;
        dest[offset + 15] = 1.0;
        return dest;
    }
    public DoubleBuffer storeRM4x4Absolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4Absolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public Double3x3 storeRM4x4Unsafe(long address) {
        return RAW_OPS.storeRM4x4Unsafe(this, address);
    }

    public float[] storeRM4x4(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[3];
        dest[offset + 2] = (float) this.data[6];
        dest[offset + 3] = (float) 0.0;
        dest[offset + 4] = (float) this.data[1];
        dest[offset + 5] = (float) this.data[4];
        dest[offset + 6] = (float) this.data[7];
        dest[offset + 7] = (float) 0.0;
        dest[offset + 8] = (float) this.data[2];
        dest[offset + 9] = (float) this.data[5];
        dest[offset + 10] = (float) this.data[8];
        dest[offset + 11] = (float) 0.0;
        dest[offset + 12] = (float) 0.0;
        dest[offset + 13] = (float) 0.0;
        dest[offset + 14] = (float) 0.0;
        dest[offset + 15] = (float) 1.0;
        return dest;
    }
    public FloatBuffer storeRM4x4Absolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeRM4x4Absolute(this, index, buf);
    }
    public ByteBuffer storeRM4x4FloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeRM4x4FloatAbsolute(this, index, buf);
    }
    public Double3x3 storeRM4x4FloatUnsafe(long address) {
        return RAW_OPS.storeRM4x4FloatUnsafe(this, address);
    }

}
