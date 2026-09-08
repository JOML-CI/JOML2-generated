package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable oriented bounding box of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param cX the {@code cX} component
 * @param cY the {@code cY} component
 * @param cZ the {@code cZ} component
 * @param uXx the {@code uXx} component
 * @param uXy the {@code uXy} component
 * @param uXz the {@code uXz} component
 * @param uYx the {@code uYx} component
 * @param uYy the {@code uYy} component
 * @param uYz the {@code uYz} component
 * @param uZx the {@code uZx} component
 * @param uZy the {@code uZy} component
 * @param uZz the {@code uZz} component
 * @param hsX the {@code hsX} component
 * @param hsY the {@code hsY} component
 * @param hsZ the {@code hsZ} component
 */
public record FloatOBB(float cX, float cY, float cZ, float uXx, float uXy, float uXz, float uYx, float uYy, float uYz, float uZx, float uZy, float uZz, float hsX, float hsY, float hsZ) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 60;

    /** Canonical constructor. */
    public FloatOBB(float cX, float cY, float cZ, float uXx, float uXy, float uXz, float uYx, float uYy, float uYz, float uZx, float uZy, float uZz, float hsX, float hsY, float hsZ) {
        this.cX = cX;
        this.cY = cY;
        this.cZ = cZ;
        this.uXx = uXx;
        this.uXy = uXy;
        this.uXz = uXz;
        this.uYx = uYx;
        this.uYy = uYy;
        this.uYz = uYz;
        this.uZx = uZx;
        this.uZy = uZy;
        this.uZz = uZz;
        this.hsX = hsX;
        this.hsY = hsY;
        this.hsZ = hsZ;
    }

    /**
     * Create a new instance initialized to a degenerate box with identity orientation and zero
     * center and extents.
     */
    public FloatOBB() {
        this(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0);
    }

    /** {@return the {@code cX} component} */
    public float cX() { return cX; }
    /** {@return the {@code cY} component} */
    public float cY() { return cY; }
    /** {@return the {@code cZ} component} */
    public float cZ() { return cZ; }
    /** {@return the {@code uXx} component} */
    public float uXx() { return uXx; }
    /** {@return the {@code uXy} component} */
    public float uXy() { return uXy; }
    /** {@return the {@code uXz} component} */
    public float uXz() { return uXz; }
    /** {@return the {@code uYx} component} */
    public float uYx() { return uYx; }
    /** {@return the {@code uYy} component} */
    public float uYy() { return uYy; }
    /** {@return the {@code uYz} component} */
    public float uYz() { return uYz; }
    /** {@return the {@code uZx} component} */
    public float uZx() { return uZx; }
    /** {@return the {@code uZy} component} */
    public float uZy() { return uZy; }
    /** {@return the {@code uZz} component} */
    public float uZz() { return uZz; }
    /** {@return the {@code hsX} component} */
    public float hsX() { return hsX; }
    /** {@return the {@code hsY} component} */
    public float hsY() { return hsY; }
    /** {@return the {@code hsZ} component} */
    public float hsZ() { return hsZ; }


    /**
     * Create a new oriented bounding box from the given values.
     *
     * @param v the oriented bounding box
     * @return the resulting oriented bounding box
     */
    public FloatOBB set(FloatOBB v) {
        return set(v.cX(), v.cY(), v.cZ(), v.uXx(), v.uXy(), v.uXz(), v.uYx(), v.uYy(), v.uYz(), v.uZx(), v.uZy(), v.uZz(), v.hsX(), v.hsY(), v.hsZ());
    }


    /**
     * Create a new oriented bounding box from the given values.
     *
     * @param vCX the {@code cX} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vCY the {@code cY} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vCZ the {@code cZ} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUXX the {@code uXx} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUXY the {@code uXy} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUXZ the {@code uXz} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUYX the {@code uYx} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUYY the {@code uYy} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUYZ the {@code uYz} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUZX the {@code uZx} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUZY the {@code uZy} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vUZZ the {@code uZz} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vHSX the {@code hsX} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vHSY the {@code hsY} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @param vHSZ the {@code hsZ} component of the oriented bounding box
     *        {@code (vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ)}
     * @return the resulting oriented bounding box
     */
    public FloatOBB set(float vCX, float vCY, float vCZ, float vUXX, float vUXY, float vUXZ, float vUYX, float vUYY, float vUYZ, float vUZX, float vUZY, float vUZZ, float vHSX, float vHSY, float vHSZ) {
        return new FloatOBB(vCX, vCY, vCZ, vUXX, vUXY, vUXZ, vUYX, vUYY, vUYZ, vUZX, vUZY, vUZZ, vHSX, vHSY, vHSZ);
    }


    /**
     * Set the local coordinate axes of this oriented bounding box to {@code axisX}, {@code axisY}
     * and {@code axisZ}, returning the result as a value.
     *
     * @param axisX the new local X axis
     * @param axisY the new local Y axis
     * @param axisZ the new local Z axis
     * @return the resulting oriented bounding box
     */
    public FloatOBB setAxes(Float3 axisX, Float3 axisY, Float3 axisZ) {
        return setAxes(axisX.x(), axisX.y(), axisX.z(), axisY.x(), axisY.y(), axisY.z(), axisZ.x(), axisZ.y(), axisZ.z());
    }


    /**
     * Set the local coordinate axes of this oriented bounding box to ({@code axisXX},
     * {@code axisXY}, {@code axisXZ}), ({@code axisYX}, {@code axisYY}, {@code axisYZ}) and
     * ({@code axisZX}, {@code axisZY}, {@code axisZZ}), returning the result as a value.
     *
     * @param axisXX the {@code x} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisXY the {@code y} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisXZ the {@code z} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisYX the {@code x} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisYY the {@code y} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisYZ the {@code z} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisZX the {@code x} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @param axisZY the {@code y} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @param axisZZ the {@code z} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @return the resulting oriented bounding box
     */
    public FloatOBB setAxes(float axisXX, float axisXY, float axisXZ, float axisYX, float axisYY, float axisYZ, float axisZX, float axisZY, float axisZZ) {
        return new FloatOBB(this.cX, this.cY, this.cZ, axisXX, axisXY, axisXZ, axisYX, axisYY, axisYZ, axisZX, axisZY, axisZZ, this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Set the center of this oriented bounding box to {@code c}, returning the result as a value.
     *
     * @param c the vector
     * @return the resulting oriented bounding box
     */
    public FloatOBB setCenter(Float3 c) {
        return setCenter(c.x(), c.y(), c.z());
    }


    /**
     * Set the center of this oriented bounding box to ({@code cX}, {@code cY}, {@code cZ}),
     * returning the result as a value.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return the resulting oriented bounding box
     */
    public FloatOBB setCenter(float cX, float cY, float cZ) {
        return new FloatOBB(cX, cY, cZ, this.uXx, this.uXy, this.uXz, this.uYx, this.uYy, this.uYz, this.uZx, this.uZy, this.uZz, this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Set the half extents of this oriented bounding box to {@code h}, returning the result as a
     * value.
     *
     * @param h the vector
     * @return the resulting oriented bounding box
     */
    public FloatOBB setHalfSize(Float3 h) {
        return setHalfSize(h.x(), h.y(), h.z());
    }


    /**
     * Set the half extents of this oriented bounding box to ({@code hX}, {@code hY}, {@code hZ}),
     * returning the result as a value.
     *
     * @param hX the {@code x} component of the vector {@code (hX, hY, hZ)}
     * @param hY the {@code y} component of the vector {@code (hX, hY, hZ)}
     * @param hZ the {@code z} component of the vector {@code (hX, hY, hZ)}
     * @return the resulting oriented bounding box
     */
    public FloatOBB setHalfSize(float hX, float hY, float hZ) {
        return new FloatOBB(this.cX, this.cY, this.cZ, this.uXx, this.uXy, this.uXz, this.uYx, this.uYy, this.uYz, this.uZx, this.uZy, this.uZz, hX, hY, hZ);
    }


    /**
     * Reset the orientation of this oriented bounding box to identity, returning the result as a
     * value.
     *
     * @return the resulting oriented bounding box
     */
    public FloatOBB setIdentityOrientation() {
        return new FloatOBB(this.cX, this.cY, this.cZ, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Set the orientation of this oriented bounding box to {@code q}, returning the result as a
     * value.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return the resulting oriented bounding box
     */
    public FloatOBB setOrientation(FloatQuat q) {
        return setOrientation(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Set the orientation of this oriented bounding box to ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}), returning the result as a value.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @return the resulting oriented bounding box
     */
    public FloatOBB setOrientation(float qX, float qY, float qZ, float qW) {
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        return new FloatOBB(this.cX, this.cY, this.cZ, Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f), 2.0f * Math.fma(qX, qY, _t1), 2.0f * Math.fma(qX, qZ, -_t2), 2.0f * Math.fma(qX, qY, -_t1), Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f), 2.0f * Math.fma(qX, qW, qY * qZ), 2.0f * Math.fma(qX, qZ, _t2), 2.0f * Math.fma(qY, qZ, -(qX * qW)), Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f), this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Convert this oriented bounding box to {@code double} precision, returning the result as a new
     * instance.
     *
     * @return a new {@code DoubleOBB} holding the result
     */
    public DoubleOBB toDouble() {
        return new DoubleOBB(this.cX, this.cY, this.cZ, this.uXx, this.uXy, this.uXz, this.uYx, this.uYy, this.uYz, this.uZx, this.uZy, this.uZz, this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Create an identity oriented bounding box.
     *
     * @return the resulting oriented bounding box
     */
    public static FloatOBB makeIdentity() {
        return new FloatOBB(0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    /** Private tail of {@code transform}; reached only through it. */
    private FloatOBB transform_s37cad600_tail(Float3x4 m, float _sfx0, float _sfx1, float _sfx2, float _sfx3, float _sfx4, float _sfx5) {
        float _sfx6 = Math.fma(m.m02(), this.uYz, Math.fma(m.m00(), this.uYx, m.m01() * this.uYy));
        float _sfx7 = Math.fma(m.m12(), this.uYz, Math.fma(m.m10(), this.uYx, m.m11() * this.uYy));
        float _sfx8 = Math.fma(m.m22(), this.uYz, Math.fma(m.m20(), this.uYx, m.m21() * this.uYy));
        float _sfx9 = Math.fma(m.m02(), this.uZz, Math.fma(m.m00(), this.uZx, m.m01() * this.uZy));
        float _sfx10 = Math.fma(m.m12(), this.uZz, Math.fma(m.m10(), this.uZx, m.m11() * this.uZy));
        float _sfx11 = Math.fma(m.m22(), this.uZz, Math.fma(m.m20(), this.uZx, m.m21() * this.uZy));
        float _sfx12 = this.hsX;
        float _sfx13 = this.hsY;
        float _sfx14 = this.hsZ;
        return new FloatOBB(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6, _sfx7, _sfx8, _sfx9, _sfx10, _sfx11, _sfx12, _sfx13, _sfx14);
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization), returning the result as a value.
     *
     * @param m the matrix
     * @return the resulting oriented bounding box
     */
    public FloatOBB transform(Float3x4 m) {
        float _sfx0 = Math.fma(m.m02(), this.cZ, Math.fma(m.m00(), this.cX, Math.fma(m.m01(), this.cY, m.m03())));
        float _sfx1 = Math.fma(m.m12(), this.cZ, Math.fma(m.m10(), this.cX, Math.fma(m.m11(), this.cY, m.m13())));
        float _sfx2 = Math.fma(m.m22(), this.cZ, Math.fma(m.m20(), this.cX, Math.fma(m.m21(), this.cY, m.m23())));
        float _sfx3 = Math.fma(m.m02(), this.uXz, Math.fma(m.m00(), this.uXx, m.m01() * this.uXy));
        float _sfx4 = Math.fma(m.m12(), this.uXz, Math.fma(m.m10(), this.uXx, m.m11() * this.uXy));
        float _sfx5 = Math.fma(m.m22(), this.uXz, Math.fma(m.m20(), this.uXx, m.m21() * this.uXy));
        return transform_s37cad600_tail(m, _sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5);
    }

    /** Private tail of {@code transform}; reached only through it. */
    private FloatOBB transform_s37d8ed81_tail(Float4x4 m, float _sfx0, float _sfx1, float _sfx2, float _sfx3, float _sfx4, float _sfx5) {
        float _sfx6 = Math.fma(m.m02(), this.uYz, Math.fma(m.m00(), this.uYx, m.m01() * this.uYy));
        float _sfx7 = Math.fma(m.m12(), this.uYz, Math.fma(m.m10(), this.uYx, m.m11() * this.uYy));
        float _sfx8 = Math.fma(m.m22(), this.uYz, Math.fma(m.m20(), this.uYx, m.m21() * this.uYy));
        float _sfx9 = Math.fma(m.m02(), this.uZz, Math.fma(m.m00(), this.uZx, m.m01() * this.uZy));
        float _sfx10 = Math.fma(m.m12(), this.uZz, Math.fma(m.m10(), this.uZx, m.m11() * this.uZy));
        float _sfx11 = Math.fma(m.m22(), this.uZz, Math.fma(m.m20(), this.uZx, m.m21() * this.uZy));
        float _sfx12 = this.hsX;
        float _sfx13 = this.hsY;
        float _sfx14 = this.hsZ;
        return new FloatOBB(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6, _sfx7, _sfx8, _sfx9, _sfx10, _sfx11, _sfx12, _sfx13, _sfx14);
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization), returning the result as a value.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return the resulting oriented bounding box
     */
    public FloatOBB transform(Float4x4 m) {
        float _sfx0 = Math.fma(m.m02(), this.cZ, Math.fma(m.m00(), this.cX, Math.fma(m.m01(), this.cY, m.m03())));
        float _sfx1 = Math.fma(m.m12(), this.cZ, Math.fma(m.m10(), this.cX, Math.fma(m.m11(), this.cY, m.m13())));
        float _sfx2 = Math.fma(m.m22(), this.cZ, Math.fma(m.m20(), this.cX, Math.fma(m.m21(), this.cY, m.m23())));
        float _sfx3 = Math.fma(m.m02(), this.uXz, Math.fma(m.m00(), this.uXx, m.m01() * this.uXy));
        float _sfx4 = Math.fma(m.m12(), this.uXz, Math.fma(m.m10(), this.uXx, m.m11() * this.uXy));
        float _sfx5 = Math.fma(m.m22(), this.uXz, Math.fma(m.m20(), this.uXx, m.m21() * this.uXy));
        return transform_s37d8ed81_tail(m, _sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5);
    }


    /**
     * Translate this oriented bounding box by {@code delta}, returning the result as a value.
     *
     * @param delta the vector
     * @return the resulting oriented bounding box
     */
    public FloatOBB translate(Float3 delta) {
        return translate(delta.x(), delta.y(), delta.z());
    }


    /**
     * Translate this oriented bounding box by ({@code deltaX}, {@code deltaY}, {@code deltaZ}),
     * returning the result as a value.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @return the resulting oriented bounding box
     */
    public FloatOBB translate(float deltaX, float deltaY, float deltaZ) {
        return new FloatOBB(deltaX + this.cX, deltaY + this.cY, deltaZ + this.cZ, this.uXx, this.uXy, this.uXz, this.uYx, this.uYy, this.uYz, this.uZx, this.uZy, this.uZz, this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    public boolean containsPoint(Float3 p) {
        return containsPoint(p.x(), p.y(), p.z());
    }


    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    public boolean containsPoint(float pX, float pY, float pZ) {
        float _t0 = pZ - this.cZ;
        float _t1 = pX - this.cX;
        float _t2 = pY - this.cY;
        if (!(Math.abs(Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2))) <= this.hsX)) return false;
        if (!(Math.abs(Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2))) <= this.hsY)) return false;
        return Math.abs(Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2))) <= this.hsZ;
    }


    /**
     * Get the local {@code X} axis of this oriented bounding box, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getAxisX() {
        return new Float3(this.uXx, this.uXy, this.uXz);
    }


    /**
     * Get the local {@code Y} axis of this oriented bounding box, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getAxisY() {
        return new Float3(this.uYx, this.uYy, this.uYz);
    }


    /**
     * Get the local {@code Z} axis of this oriented bounding box, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getAxisZ() {
        return new Float3(this.uZx, this.uZy, this.uZz);
    }


    /**
     * Get the center of this oriented bounding box, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getCenter() {
        return new Float3(this.cX, this.cY, this.cZ);
    }


    /**
     * Get the half extents of this oriented bounding box, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getHalfSize() {
        return new Float3(this.hsX, this.hsY, this.hsZ);
    }


    /**
     * Determine whether this oriented bounding box intersects {@code o}.
     *
     * @param o the oriented bounding box
     * @return {@code true} if this oriented bounding box intersects {@code o}, {@code false}
     *        otherwise
     */
    public boolean intersectsOBB(FloatOBB o) {
        return intersectsOBB(o.cX(), o.cY(), o.cZ(), o.uXx(), o.uXy(), o.uXz(), o.uYx(), o.uYy(), o.uYz(), o.uZx(), o.uZy(), o.uZz(), o.hsX(), o.hsY(), o.hsZ());
    }


    /**
     * Determine whether this oriented bounding box intersects ({@code oCX}, {@code oCY},
     * {@code oCZ}, {@code oUXX}, {@code oUXY}, {@code oUXZ}, {@code oUYX}, {@code oUYY},
     * {@code oUYZ}, {@code oUZX}, {@code oUZY}, {@code oUZZ}, {@code oHSX}, {@code oHSY},
     * {@code oHSZ}).
     *
     * @param oCX the {@code cX} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oCY the {@code cY} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oCZ the {@code cZ} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUXX the {@code uXx} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUXY the {@code uXy} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUXZ the {@code uXz} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUYX the {@code uYx} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUYY the {@code uYy} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUYZ the {@code uYz} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUZX the {@code uZx} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUZY the {@code uZy} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oUZZ the {@code uZz} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oHSX the {@code hsX} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oHSY the {@code hsY} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @param oHSZ the {@code hsZ} component of the oriented bounding box
     *        {@code (oCX, oCY, oCZ, oUXX, oUXY, oUXZ, oUYX, oUYY, oUYZ, oUZX, oUZY, oUZZ, oHSX, oHSY, oHSZ)}
     * @return {@code true} if this oriented bounding box intersects ({@code oCX}, {@code oCY},
     *        {@code oCZ}, {@code oUXX}, {@code oUXY}, {@code oUXZ}, {@code oUYX}, {@code oUYY},
     *        {@code oUYZ}, {@code oUZX}, {@code oUZY}, {@code oUZZ}, {@code oHSX}, {@code oHSY},
     *        {@code oHSZ}), {@code false} otherwise
     */
    public boolean intersectsOBB(float oCX, float oCY, float oCZ, float oUXX, float oUXY, float oUXZ, float oUYX, float oUYY, float oUYZ, float oUZX, float oUZY, float oUZZ, float oHSX, float oHSY, float oHSZ) {
        float _t0 = oCZ - this.cZ;
        float _t1 = oCX - this.cX;
        float _t2 = oCY - this.cY;
        float _t54 = Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2));
        float _t24 = Math.fma(oUXZ, this.uXz, Math.fma(oUXX, this.uXx, oUXY * this.uXy));
        float _t45 = 1.0E-5f + Math.abs(_t24);
        float _t25 = Math.fma(oUYZ, this.uXz, Math.fma(oUYX, this.uXx, oUYY * this.uXy));
        float _t46 = 1.0E-5f + Math.abs(_t25);
        float _t26 = Math.fma(oUZZ, this.uXz, Math.fma(oUZX, this.uXx, oUZY * this.uXy));
        float _t47 = 1.0E-5f + Math.abs(_t26);
        if (!(Math.abs(_t54) <= Math.fma(oHSX, _t45, Math.fma(oHSY, _t46, Math.fma(oHSZ, _t47, this.hsX))))) return false;
        float _t55 = Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2));
        float _t27 = Math.fma(oUXZ, this.uYz, Math.fma(oUXX, this.uYx, oUXY * this.uYy));
        float _t48 = 1.0E-5f + Math.abs(_t27);
        float _t28 = Math.fma(oUYZ, this.uYz, Math.fma(oUYX, this.uYx, oUYY * this.uYy));
        float _t49 = 1.0E-5f + Math.abs(_t28);
        float _t29 = Math.fma(oUZZ, this.uYz, Math.fma(oUZX, this.uYx, oUZY * this.uYy));
        float _t50 = 1.0E-5f + Math.abs(_t29);
        if (!(Math.abs(_t55) <= Math.fma(oHSX, _t48, Math.fma(oHSY, _t49, Math.fma(oHSZ, _t50, this.hsY))))) return false;
        float _t56 = Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2));
        float _t30 = Math.fma(oUXZ, this.uZz, Math.fma(oUXX, this.uZx, oUXY * this.uZy));
        float _t51 = 1.0E-5f + Math.abs(_t30);
        float _t31 = Math.fma(oUYZ, this.uZz, Math.fma(oUYX, this.uZx, oUYY * this.uZy));
        float _t52 = 1.0E-5f + Math.abs(_t31);
        float _t32 = Math.fma(oUZZ, this.uZz, Math.fma(oUZX, this.uZx, oUZY * this.uZy));
        float _t53 = 1.0E-5f + Math.abs(_t32);
        if (!(Math.abs(_t56) <= Math.fma(oHSX, _t51, Math.fma(oHSY, _t52, Math.fma(oHSZ, _t53, this.hsZ))))) return false;
        if (!(Math.abs(Math.fma(_t30, _t56, Math.fma(_t24, _t54, _t27 * _t55))) <= Math.fma(this.hsX, _t45, Math.fma(this.hsY, _t48, Math.fma(this.hsZ, _t51, oHSX))))) return false;
        if (!(Math.abs(Math.fma(_t31, _t56, Math.fma(_t25, _t54, _t28 * _t55))) <= Math.fma(this.hsX, _t46, Math.fma(this.hsY, _t49, Math.fma(this.hsZ, _t52, oHSY))))) return false;
        if (!(Math.abs(Math.fma(_t32, _t56, Math.fma(_t26, _t54, _t29 * _t55))) <= Math.fma(this.hsX, _t47, Math.fma(this.hsY, _t50, Math.fma(this.hsZ, _t53, oHSZ))))) return false;
        if (!(Math.abs(Math.fma(_t27, _t56, -(_t30 * _t55))) <= Math.fma(oHSY, _t47, oHSZ * _t46) + Math.fma(this.hsY, _t51, this.hsZ * _t48))) return false;
        if (!(Math.abs(Math.fma(_t28, _t56, -(_t31 * _t55))) <= Math.fma(oHSX, _t47, oHSZ * _t45) + Math.fma(this.hsY, _t52, this.hsZ * _t49))) return false;
        if (!(Math.abs(Math.fma(_t29, _t56, -(_t32 * _t55))) <= Math.fma(oHSX, _t46, oHSY * _t45) + Math.fma(this.hsY, _t53, this.hsZ * _t50))) return false;
        if (!(Math.abs(Math.fma(_t30, _t54, -(_t24 * _t56))) <= Math.fma(oHSY, _t50, oHSZ * _t49) + Math.fma(this.hsX, _t51, this.hsZ * _t45))) return false;
        if (!(Math.abs(Math.fma(_t31, _t54, -(_t25 * _t56))) <= Math.fma(oHSX, _t50, oHSZ * _t48) + Math.fma(this.hsX, _t52, this.hsZ * _t46))) return false;
        if (!(Math.abs(Math.fma(_t32, _t54, -(_t26 * _t56))) <= Math.fma(oHSX, _t49, oHSY * _t48) + Math.fma(this.hsX, _t53, this.hsZ * _t47))) return false;
        if (!(Math.abs(Math.fma(_t24, _t55, -(_t27 * _t54))) <= Math.fma(oHSY, _t53, oHSZ * _t52) + Math.fma(this.hsX, _t48, this.hsY * _t45))) return false;
        if (!(Math.abs(Math.fma(_t25, _t55, -(_t28 * _t54))) <= Math.fma(oHSX, _t53, oHSZ * _t51) + Math.fma(this.hsX, _t49, this.hsY * _t46))) return false;
        return Math.abs(Math.fma(_t26, _t55, -(_t29 * _t54))) <= Math.fma(oHSX, _t52, oHSY * _t51) + Math.fma(this.hsX, _t50, this.hsY * _t47);
    }


    /**
     * Determine whether this oriented bounding box is valid, i.e. none of its half extents is
     * negative.
     *
     * @return {@code true} if this oriented bounding box is valid, i.e. none of its half extents is
     *        negative, {@code false} otherwise
     */
    public boolean isValid() {
        if (!(this.hsX >= 0.0f)) return false;
        if (!(this.hsY >= 0.0f)) return false;
        return this.hsZ >= 0.0f;
    }

    /** {@return a copy with the {@code cX} component replaced by {@code v}} */
    public FloatOBB withCX(float v) {
        return new FloatOBB(v, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code cY} component replaced by {@code v}} */
    public FloatOBB withCY(float v) {
        return new FloatOBB(cX, v, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code cZ} component replaced by {@code v}} */
    public FloatOBB withCZ(float v) {
        return new FloatOBB(cX, cY, v, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uXx} component replaced by {@code v}} */
    public FloatOBB withUXx(float v) {
        return new FloatOBB(cX, cY, cZ, v, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uXy} component replaced by {@code v}} */
    public FloatOBB withUXy(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, v, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uXz} component replaced by {@code v}} */
    public FloatOBB withUXz(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, v, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uYx} component replaced by {@code v}} */
    public FloatOBB withUYx(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, v, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uYy} component replaced by {@code v}} */
    public FloatOBB withUYy(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, v, uYz, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uYz} component replaced by {@code v}} */
    public FloatOBB withUYz(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, v, uZx, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uZx} component replaced by {@code v}} */
    public FloatOBB withUZx(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, v, uZy, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uZy} component replaced by {@code v}} */
    public FloatOBB withUZy(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, v, uZz, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code uZz} component replaced by {@code v}} */
    public FloatOBB withUZz(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, v, hsX, hsY, hsZ);
    }

    /** {@return a copy with the {@code hsX} component replaced by {@code v}} */
    public FloatOBB withHsX(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, v, hsY, hsZ);
    }

    /** {@return a copy with the {@code hsY} component replaced by {@code v}} */
    public FloatOBB withHsY(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, v, hsZ);
    }

    /** {@return a copy with the {@code hsZ} component replaced by {@code v}} */
    public FloatOBB withHsZ(float v) {
        return new FloatOBB(cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, v);
    }

    @Override public String toString() {
        return "FloatOBB(" + cX() + ", " + cY() + ", " + cZ() + ", " + uXx() + ", " + uXy() + ", " + uXz() + ", " + uYx() + ", " + uYy() + ", " + uYz() + ", " + uZx() + ", " + uZy() + ", " + uZz() + ", " + hsX() + ", " + hsY() + ", " + hsZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatOBB)) return false;
        FloatOBB o = (FloatOBB) obj;
        return Float.floatToIntBits(cX) == Float.floatToIntBits(o.cX)
            && Float.floatToIntBits(cY) == Float.floatToIntBits(o.cY)
            && Float.floatToIntBits(cZ) == Float.floatToIntBits(o.cZ)
            && Float.floatToIntBits(uXx) == Float.floatToIntBits(o.uXx)
            && Float.floatToIntBits(uXy) == Float.floatToIntBits(o.uXy)
            && Float.floatToIntBits(uXz) == Float.floatToIntBits(o.uXz)
            && Float.floatToIntBits(uYx) == Float.floatToIntBits(o.uYx)
            && Float.floatToIntBits(uYy) == Float.floatToIntBits(o.uYy)
            && Float.floatToIntBits(uYz) == Float.floatToIntBits(o.uYz)
            && Float.floatToIntBits(uZx) == Float.floatToIntBits(o.uZx)
            && Float.floatToIntBits(uZy) == Float.floatToIntBits(o.uZy)
            && Float.floatToIntBits(uZz) == Float.floatToIntBits(o.uZz)
            && Float.floatToIntBits(hsX) == Float.floatToIntBits(o.hsX)
            && Float.floatToIntBits(hsY) == Float.floatToIntBits(o.hsY)
            && Float.floatToIntBits(hsZ) == Float.floatToIntBits(o.hsZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(cX);
        h = 31 * h + Float.floatToIntBits(cY);
        h = 31 * h + Float.floatToIntBits(cZ);
        h = 31 * h + Float.floatToIntBits(uXx);
        h = 31 * h + Float.floatToIntBits(uXy);
        h = 31 * h + Float.floatToIntBits(uXz);
        h = 31 * h + Float.floatToIntBits(uYx);
        h = 31 * h + Float.floatToIntBits(uYy);
        h = 31 * h + Float.floatToIntBits(uYz);
        h = 31 * h + Float.floatToIntBits(uZx);
        h = 31 * h + Float.floatToIntBits(uZy);
        h = 31 * h + Float.floatToIntBits(uZz);
        h = 31 * h + Float.floatToIntBits(hsX);
        h = 31 * h + Float.floatToIntBits(hsY);
        h = 31 * h + Float.floatToIntBits(hsZ);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(cX)
            && Float.isFinite(cY)
            && Float.isFinite(cZ)
            && Float.isFinite(uXx)
            && Float.isFinite(uXy)
            && Float.isFinite(uXz)
            && Float.isFinite(uYx)
            && Float.isFinite(uYy)
            && Float.isFinite(uYz)
            && Float.isFinite(uZx)
            && Float.isFinite(uZy)
            && Float.isFinite(uZz)
            && Float.isFinite(hsX)
            && Float.isFinite(hsY)
            && Float.isFinite(hsZ);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatOBB other, float epsilon) {
        return Math.abs(cX - other.cX()) <= epsilon
            && Math.abs(cY - other.cY()) <= epsilon
            && Math.abs(cZ - other.cZ()) <= epsilon
            && Math.abs(uXx - other.uXx()) <= epsilon
            && Math.abs(uXy - other.uXy()) <= epsilon
            && Math.abs(uXz - other.uXz()) <= epsilon
            && Math.abs(uYx - other.uYx()) <= epsilon
            && Math.abs(uYy - other.uYy()) <= epsilon
            && Math.abs(uYz - other.uYz()) <= epsilon
            && Math.abs(uZx - other.uZx()) <= epsilon
            && Math.abs(uZy - other.uZy()) <= epsilon
            && Math.abs(uZz - other.uZz()) <= epsilon
            && Math.abs(hsX - other.hsX()) <= epsilon
            && Math.abs(hsY - other.hsY()) <= epsilon
            && Math.abs(hsZ - other.hsZ()) <= epsilon;
    }

    static final FloatOBBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBBbOpsUnsafe()
                    : new FloatOBBBbOpsApi();
    static final FloatOBBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBRawOpsUnsafe()
                    : new FloatOBBRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.cX;
        dest[offset + 1] = this.cY;
        dest[offset + 2] = this.cZ;
        dest[offset + 3] = this.uXx;
        dest[offset + 4] = this.uXy;
        dest[offset + 5] = this.uXz;
        dest[offset + 6] = this.uYx;
        dest[offset + 7] = this.uYy;
        dest[offset + 8] = this.uYz;
        dest[offset + 9] = this.uZx;
        dest[offset + 10] = this.uZy;
        dest[offset + 11] = this.uZz;
        dest[offset + 12] = this.hsX;
        dest[offset + 13] = this.hsY;
        dest[offset + 14] = this.hsZ;
        return dest;
    }

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store(float[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(float[] src, int offset) {
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
        float _c12 = src[offset + 12];
        float _c13 = src[offset + 13];
        float _c14 = src[offset + 14];
        return new FloatOBB(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11, _c12, _c13, _c14);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer store(FloatBuffer buf) {
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
    public FloatBuffer storeAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 15);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatOBB r = loadAbsolute(pos, buf);
        buf.position(pos + 15);
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
        buf.position(pos + 60);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatOBB r = loadAbsolute(pos, buf);
        buf.position(pos + 60);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatOBB storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }


    /**
     * Store the elements into the given array, converting each element to {@code double}, starting
     * at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] store(double[] dest, int offset) {
        dest[offset + 0] = this.cX;
        dest[offset + 1] = this.cY;
        dest[offset + 2] = this.cZ;
        dest[offset + 3] = this.uXx;
        dest[offset + 4] = this.uXy;
        dest[offset + 5] = this.uXz;
        dest[offset + 6] = this.uYx;
        dest[offset + 7] = this.uYy;
        dest[offset + 8] = this.uYz;
        dest[offset + 9] = this.uZx;
        dest[offset + 10] = this.uZy;
        dest[offset + 11] = this.uZz;
        dest[offset + 12] = this.hsX;
        dest[offset + 13] = this.hsY;
        dest[offset + 14] = this.hsZ;
        return dest;
    }

    /**
     * Store the elements into the given array, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store(double[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, converting each element from {@code double}, starting
     * at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(double[] src, int offset) {
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
        float _c12 = (float) src[offset + 12];
        float _c13 = (float) src[offset + 13];
        float _c14 = (float) src[offset + 14];
        return new FloatOBB(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8, _c9, _c10, _c11, _c12, _c13, _c14);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer store(DoubleBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position and advancing the position accordingly.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 15);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatOBB r = loadAbsolute(pos, buf);
        buf.position(pos + 15);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDouble(ByteBuffer buf) {
        return storeDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 120);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatOBB r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 120);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatOBB storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatOBB} holding the loaded elements
     */
    public static FloatOBB loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

}
