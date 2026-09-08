package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleOBB} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleOBBImpl implements DoubleOBB {

    public double cX;
    public double cY;
    public double cZ;
    public double uXx;
    public double uXy;
    public double uXz;
    public double uYx;
    public double uYy;
    public double uYz;
    public double uZx;
    public double uZy;
    public double uZz;
    public double hsX;
    public double hsY;
    public double hsZ;
    static final DoubleOBBSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleOBBSegOpsUnsafe()
                    : new DoubleOBBSegOpsMS();
    static final DoubleOBBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleOBBBbOpsUnsafe()
                    : new DoubleOBBBbOpsApi();
    static final DoubleOBBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleOBBRawOpsUnsafe()
                    : new DoubleOBBRawOpsApi();

    public DoubleOBBImpl() {
        uXx = 1;
        uYy = 1;
        uZz = 1;
    }


    /**
     * Set this oriented bounding box to the given values.
     *
     * @param v the oriented bounding box
     * @return this
     */
    public @Mutated DoubleOBB set(DoubleOBBR v) {
        return set(v.cX(), v.cY(), v.cZ(), v.uXx(), v.uXy(), v.uXz(), v.uYx(), v.uYy(), v.uYz(), v.uZx(), v.uZy(), v.uZz(), v.hsX(), v.hsY(), v.hsZ());
    }


    /**
     * Set this oriented bounding box to the given values.
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
     * @return this
     */
    @Mutated public DoubleOBB set(double vCX, double vCY, double vCZ, double vUXX, double vUXY, double vUXZ, double vUYX, double vUYY, double vUYZ, double vUZX, double vUZY, double vUZZ, double vHSX, double vHSY, double vHSZ) {
        this.cX = vCX;
        this.cY = vCY;
        this.cZ = vCZ;
        this.uXx = vUXX;
        this.uXy = vUXY;
        this.uXz = vUXZ;
        this.uYx = vUYX;
        this.uYy = vUYY;
        this.uYz = vUYZ;
        this.uZx = vUZX;
        this.uZy = vUZY;
        this.uZz = vUZZ;
        this.hsX = vHSX;
        this.hsY = vHSY;
        this.hsZ = vHSZ;
        return this;
    }


    /**
     * Set the local coordinate axes of this oriented bounding box to {@code axisX}, {@code axisY}
     * and {@code axisZ} and store the result in {@code dest}.
     *
     * @param axisX the new local X axis
     * @param axisY the new local Y axis
     * @param axisZ the new local Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setAxes(Double3R axisX, Double3R axisY, Double3R axisZ, @Mutated DoubleOBB dest) {
        return setAxes(axisX.x(), axisX.y(), axisX.z(), axisY.x(), axisY.y(), axisY.z(), axisZ.x(), axisZ.y(), axisZ.z(), dest);
    }


    /**
     * Set the local coordinate axes of this oriented bounding box to ({@code axisXX},
     * {@code axisXY}, {@code axisXZ}), ({@code axisYX}, {@code axisYY}, {@code axisYZ}) and
     * ({@code axisZX}, {@code axisZY}, {@code axisZZ}) and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setAxes(double axisXX, double axisXY, double axisXZ, double axisYX, double axisYY, double axisYZ, double axisZX, double axisZY, double axisZZ, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = axisXX;
        d.uXy = axisXY;
        d.uXz = axisXZ;
        d.uYx = axisYX;
        d.uYy = axisYY;
        d.uYz = axisYZ;
        d.uZx = axisZX;
        d.uZy = axisZY;
        d.uZz = axisZZ;
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Set the center of this oriented bounding box to {@code c} and store the result in
     * {@code dest}.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setCenter(Double3R c, @Mutated DoubleOBB dest) {
        return setCenter(c.x(), c.y(), c.z(), dest);
    }


    /**
     * Set the center of this oriented bounding box to ({@code cX}, {@code cY}, {@code cZ}) and
     * store the result in {@code dest}.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setCenter(double cX, double cY, double cZ, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = cX;
        d.cY = cY;
        d.cZ = cZ;
        d.uXx = this.uXx;
        d.uXy = this.uXy;
        d.uXz = this.uXz;
        d.uYx = this.uYx;
        d.uYy = this.uYy;
        d.uYz = this.uYz;
        d.uZx = this.uZx;
        d.uZy = this.uZy;
        d.uZz = this.uZz;
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Set the half extents of this oriented bounding box to {@code h} and store the result in
     * {@code dest}.
     *
     * @param h the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setHalfSize(Double3R h, @Mutated DoubleOBB dest) {
        return setHalfSize(h.x(), h.y(), h.z(), dest);
    }


    /**
     * Set the half extents of this oriented bounding box to ({@code hX}, {@code hY}, {@code hZ})
     * and store the result in {@code dest}.
     *
     * @param hX the {@code x} component of the vector {@code (hX, hY, hZ)}
     * @param hY the {@code y} component of the vector {@code (hX, hY, hZ)}
     * @param hZ the {@code z} component of the vector {@code (hX, hY, hZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setHalfSize(double hX, double hY, double hZ, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = this.uXx;
        d.uXy = this.uXy;
        d.uXz = this.uXz;
        d.uYx = this.uYx;
        d.uYy = this.uYy;
        d.uYz = this.uYz;
        d.uZx = this.uZx;
        d.uZy = this.uZy;
        d.uZz = this.uZz;
        d.hsX = hX;
        d.hsY = hY;
        d.hsZ = hZ;
        return d;
    }


    /**
     * Reset the orientation of this oriented bounding box to identity and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setIdentityOrientation(@Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = 1.0;
        d.uXy = 0.0;
        d.uXz = 0.0;
        d.uYx = 0.0;
        d.uYy = 1.0;
        d.uYz = 0.0;
        d.uZx = 0.0;
        d.uZy = 0.0;
        d.uZz = 1.0;
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Set the orientation of this oriented bounding box to {@code q} and store the result in
     * {@code dest}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setOrientation(DoubleQuatR q, @Mutated DoubleOBB dest) {
        return setOrientation(q.x(), q.y(), q.z(), q.w(), dest);
    }


    /**
     * Set the orientation of this oriented bounding box to ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) and store the result in {@code dest}.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)} (the quaternion
     *        must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setOrientation(double qX, double qY, double qZ, double qW, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        double _t0 = qZ * qZ;
        double _t1 = qZ * qW;
        double _t2 = qY * qW;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = Math.fma(-2.0, Math.fma(qY, qY, _t0), 1.0);
        d.uXy = 2.0 * Math.fma(qX, qY, _t1);
        d.uXz = 2.0 * Math.fma(qX, qZ, -_t2);
        d.uYx = 2.0 * Math.fma(qX, qY, -_t1);
        d.uYy = Math.fma(-2.0, Math.fma(qX, qX, _t0), 1.0);
        d.uYz = 2.0 * Math.fma(qX, qW, qY * qZ);
        d.uZx = 2.0 * Math.fma(qX, qZ, _t2);
        d.uZy = 2.0 * Math.fma(qY, qZ, -(qX * qW));
        d.uZz = Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0);
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Convert this oriented bounding box to {@code float} precision and store the result in
     * {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatOBB toFloat(@Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
        d.cX = (float) (this.cX);
        d.cY = (float) (this.cY);
        d.cZ = (float) (this.cZ);
        d.uXx = (float) (this.uXx);
        d.uXy = (float) (this.uXy);
        d.uXz = (float) (this.uXz);
        d.uYx = (float) (this.uYx);
        d.uYy = (float) (this.uYy);
        d.uYz = (float) (this.uYz);
        d.uZx = (float) (this.uZx);
        d.uZy = (float) (this.uZy);
        d.uZz = (float) (this.uZz);
        d.hsX = (float) (this.hsX);
        d.hsY = (float) (this.hsY);
        d.hsZ = (float) (this.hsZ);
        return d;
    }


    /**
     * Set this oriented bounding box to the identity.
     *
     * @return this
     */
    @Mutated public DoubleOBB makeIdentity() {
        this.cX = 0.0;
        this.cY = 0.0;
        this.cZ = 0.0;
        this.uXx = 1.0;
        this.uXy = 0.0;
        this.uXz = 0.0;
        this.uYx = 0.0;
        this.uYy = 1.0;
        this.uYz = 0.0;
        this.uZx = 0.0;
        this.uZy = 0.0;
        this.uZz = 1.0;
        this.hsX = 0.0;
        this.hsY = 0.0;
        this.hsZ = 0.0;
        return this;
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB transform(Double3x4R m, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        double _buf0 = Math.fma(m.m02(), this.cZ, Math.fma(m.m00(), this.cX, Math.fma(m.m01(), this.cY, m.m03())));
        double _buf1 = Math.fma(m.m12(), this.cZ, Math.fma(m.m10(), this.cX, Math.fma(m.m11(), this.cY, m.m13())));
        d.cZ = Math.fma(m.m22(), this.cZ, Math.fma(m.m20(), this.cX, Math.fma(m.m21(), this.cY, m.m23())));
        double _buf2 = Math.fma(m.m02(), this.uXz, Math.fma(m.m00(), this.uXx, m.m01() * this.uXy));
        double _buf3 = Math.fma(m.m12(), this.uXz, Math.fma(m.m10(), this.uXx, m.m11() * this.uXy));
        d.uXz = Math.fma(m.m22(), this.uXz, Math.fma(m.m20(), this.uXx, m.m21() * this.uXy));
        double _buf4 = Math.fma(m.m02(), this.uYz, Math.fma(m.m00(), this.uYx, m.m01() * this.uYy));
        double _buf5 = Math.fma(m.m12(), this.uYz, Math.fma(m.m10(), this.uYx, m.m11() * this.uYy));
        d.uYz = Math.fma(m.m22(), this.uYz, Math.fma(m.m20(), this.uYx, m.m21() * this.uYy));
        double _buf6 = Math.fma(m.m02(), this.uZz, Math.fma(m.m00(), this.uZx, m.m01() * this.uZy));
        double _buf7 = Math.fma(m.m12(), this.uZz, Math.fma(m.m10(), this.uZx, m.m11() * this.uZy));
        d.uZz = Math.fma(m.m22(), this.uZz, Math.fma(m.m20(), this.uZx, m.m21() * this.uZy));
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        d.cX = _buf0;
        d.cY = _buf1;
        d.uXx = _buf2;
        d.uXy = _buf3;
        d.uYx = _buf4;
        d.uYy = _buf5;
        d.uZx = _buf6;
        d.uZy = _buf7;
        return d;
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB transform(Double4x4R m, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        double _buf0 = Math.fma(m.m02(), this.cZ, Math.fma(m.m00(), this.cX, Math.fma(m.m01(), this.cY, m.m03())));
        double _buf1 = Math.fma(m.m12(), this.cZ, Math.fma(m.m10(), this.cX, Math.fma(m.m11(), this.cY, m.m13())));
        d.cZ = Math.fma(m.m22(), this.cZ, Math.fma(m.m20(), this.cX, Math.fma(m.m21(), this.cY, m.m23())));
        double _buf2 = Math.fma(m.m02(), this.uXz, Math.fma(m.m00(), this.uXx, m.m01() * this.uXy));
        double _buf3 = Math.fma(m.m12(), this.uXz, Math.fma(m.m10(), this.uXx, m.m11() * this.uXy));
        d.uXz = Math.fma(m.m22(), this.uXz, Math.fma(m.m20(), this.uXx, m.m21() * this.uXy));
        double _buf4 = Math.fma(m.m02(), this.uYz, Math.fma(m.m00(), this.uYx, m.m01() * this.uYy));
        double _buf5 = Math.fma(m.m12(), this.uYz, Math.fma(m.m10(), this.uYx, m.m11() * this.uYy));
        d.uYz = Math.fma(m.m22(), this.uYz, Math.fma(m.m20(), this.uYx, m.m21() * this.uYy));
        double _buf6 = Math.fma(m.m02(), this.uZz, Math.fma(m.m00(), this.uZx, m.m01() * this.uZy));
        double _buf7 = Math.fma(m.m12(), this.uZz, Math.fma(m.m10(), this.uZx, m.m11() * this.uZy));
        d.uZz = Math.fma(m.m22(), this.uZz, Math.fma(m.m20(), this.uZx, m.m21() * this.uZy));
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        d.cX = _buf0;
        d.cY = _buf1;
        d.uXx = _buf2;
        d.uXy = _buf3;
        d.uYx = _buf4;
        d.uYy = _buf5;
        d.uZx = _buf6;
        d.uZy = _buf7;
        return d;
    }


    /**
     * Translate this oriented bounding box by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB translate(Double3R delta, @Mutated DoubleOBB dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this oriented bounding box by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and
     * store the result in {@code dest}.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB translate(double deltaX, double deltaY, double deltaZ, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = deltaX + this.cX;
        d.cY = deltaY + this.cY;
        d.cZ = deltaZ + this.cZ;
        d.uXx = this.uXx;
        d.uXy = this.uXy;
        d.uXz = this.uXz;
        d.uYx = this.uYx;
        d.uYy = this.uYy;
        d.uYz = this.uYz;
        d.uZx = this.uZx;
        d.uZy = this.uZy;
        d.uZz = this.uZz;
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(Double3R p, @Mutated Double3 dest) {
        return closestPointToPoint(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(double pX, double pY, double pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t3 = pZ - this.cZ;
        double _t4 = pX - this.cX;
        double _t5 = pY - this.cY;
        double _t18 = Math.max(-this.hsX, Math.min(Math.fma(this.uXz, _t3, Math.fma(this.uXx, _t4, this.uXy * _t5)), this.hsX));
        double _t19 = Math.max(-this.hsY, Math.min(Math.fma(this.uYz, _t3, Math.fma(this.uYx, _t4, this.uYy * _t5)), this.hsY));
        double _t20 = Math.max(-this.hsZ, Math.min(Math.fma(this.uZz, _t3, Math.fma(this.uZx, _t4, this.uZy * _t5)), this.hsZ));
        d.x = Math.fma(this.uXx, _t18, Math.fma(this.uYx, _t19, Math.fma(this.uZx, _t20, this.cX)));
        d.y = Math.fma(this.uXy, _t18, Math.fma(this.uYy, _t19, Math.fma(this.uZy, _t20, this.cY)));
        d.z = Math.fma(this.uXz, _t18, Math.fma(this.uYz, _t19, Math.fma(this.uZz, _t20, this.cZ)));
        return d;
    }


    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    public boolean containsPoint(Double3R p) {
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
    public boolean containsPoint(double pX, double pY, double pZ) {
        double _t0 = pZ - this.cZ;
        double _t1 = pX - this.cX;
        double _t2 = pY - this.cY;
        if (!(Math.abs(Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2))) <= this.hsX)) return false;
        if (!(Math.abs(Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2))) <= this.hsY)) return false;
        return Math.abs(Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2))) <= this.hsZ;
    }


    /**
     * Compute the squared distance between this oriented bounding box and the given point,
     * evaluated in the box's local frame; zero for a point inside or on the box. Assumes the box's
     * axes are orthonormal.
     *
     * @param p the point
     * @return the squared distance between this oriented bounding box and the given point,
     *        evaluated in the box's local frame; zero for a point inside or on the box. Assumes the
     *        box's axes are orthonormal
     */
    public double distanceSquaredToPoint(Double3R p) {
        return distanceSquaredToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the squared distance between this oriented bounding box and the given point,
     * evaluated in the box's local frame; zero for a point inside or on the box. Assumes the box's
     * axes are orthonormal.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the squared distance between this oriented bounding box and the given point,
     *        evaluated in the box's local frame; zero for a point inside or on the box. Assumes the
     *        box's axes are orthonormal
     */
    public double distanceSquaredToPoint(double pX, double pY, double pZ) {
        double _t0 = pZ - this.cZ;
        double _t1 = pX - this.cX;
        double _t2 = pY - this.cY;
        double _t18 = Math.max(0.0, Math.abs(Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2))) - this.hsZ);
        double _t19 = Math.max(0.0, Math.abs(Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2))) - this.hsX);
        double _t20 = Math.max(0.0, Math.abs(Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2))) - this.hsY);
        return Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
    }


    /**
     * Compute the distance between this oriented bounding box and the given point, evaluated in the
     * box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     * orthonormal.
     *
     * @param p the point
     * @return the distance between this oriented bounding box and the given point, evaluated in the
     *        box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     *        orthonormal
     */
    public double distanceToPoint(Double3R p) {
        return distanceToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the distance between this oriented bounding box and the given point, evaluated in the
     * box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     * orthonormal.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the distance between this oriented bounding box and the given point, evaluated in the
     *        box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     *        orthonormal
     */
    public double distanceToPoint(double pX, double pY, double pZ) {
        double _t0 = pZ - this.cZ;
        double _t1 = pX - this.cX;
        double _t2 = pY - this.cY;
        double _t18 = Math.max(0.0, Math.abs(Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2))) - this.hsZ);
        double _t19 = Math.max(0.0, Math.abs(Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2))) - this.hsX);
        double _t20 = Math.max(0.0, Math.abs(Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2))) - this.hsY);
        return Math.sqrt(Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
    }


    /**
     * Get the local {@code X} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getAxisX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.uXx;
        d.y = this.uXy;
        d.z = this.uXz;
        return d;
    }


    /**
     * Get the local {@code Y} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getAxisY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.uYx;
        d.y = this.uYy;
        d.z = this.uYz;
        return d;
    }


    /**
     * Get the local {@code Z} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getAxisZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.uZx;
        d.y = this.uZy;
        d.z = this.uZz;
        return d;
    }


    /**
     * Get the center of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCenter(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.cX;
        d.y = this.cY;
        d.z = this.cZ;
        return d;
    }


    /**
     * Get the half extents of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getHalfSize(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.hsX;
        d.y = this.hsY;
        d.z = this.hsZ;
        return d;
    }


    /**
     * Determine whether this oriented bounding box intersects {@code o}.
     *
     * @param o the oriented bounding box
     * @return {@code true} if this oriented bounding box intersects {@code o}, {@code false}
     *        otherwise
     */
    public boolean intersectsOBB(DoubleOBBR o) {
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
    public boolean intersectsOBB(double oCX, double oCY, double oCZ, double oUXX, double oUXY, double oUXZ, double oUYX, double oUYY, double oUYZ, double oUZX, double oUZY, double oUZZ, double oHSX, double oHSY, double oHSZ) {
        double _t0 = oCZ - this.cZ;
        double _t1 = oCX - this.cX;
        double _t2 = oCY - this.cY;
        double _t54 = Math.fma(this.uXz, _t0, Math.fma(this.uXx, _t1, this.uXy * _t2));
        double _t24 = Math.fma(oUXZ, this.uXz, Math.fma(oUXX, this.uXx, oUXY * this.uXy));
        double _t45 = 1.0E-5 + Math.abs(_t24);
        double _t25 = Math.fma(oUYZ, this.uXz, Math.fma(oUYX, this.uXx, oUYY * this.uXy));
        double _t46 = 1.0E-5 + Math.abs(_t25);
        double _t26 = Math.fma(oUZZ, this.uXz, Math.fma(oUZX, this.uXx, oUZY * this.uXy));
        double _t47 = 1.0E-5 + Math.abs(_t26);
        if (!(Math.abs(_t54) <= Math.fma(oHSX, _t45, Math.fma(oHSY, _t46, Math.fma(oHSZ, _t47, this.hsX))))) return false;
        double _t55 = Math.fma(this.uYz, _t0, Math.fma(this.uYx, _t1, this.uYy * _t2));
        double _t27 = Math.fma(oUXZ, this.uYz, Math.fma(oUXX, this.uYx, oUXY * this.uYy));
        double _t48 = 1.0E-5 + Math.abs(_t27);
        double _t28 = Math.fma(oUYZ, this.uYz, Math.fma(oUYX, this.uYx, oUYY * this.uYy));
        double _t49 = 1.0E-5 + Math.abs(_t28);
        double _t29 = Math.fma(oUZZ, this.uYz, Math.fma(oUZX, this.uYx, oUZY * this.uYy));
        double _t50 = 1.0E-5 + Math.abs(_t29);
        if (!(Math.abs(_t55) <= Math.fma(oHSX, _t48, Math.fma(oHSY, _t49, Math.fma(oHSZ, _t50, this.hsY))))) return false;
        double _t56 = Math.fma(this.uZz, _t0, Math.fma(this.uZx, _t1, this.uZy * _t2));
        double _t30 = Math.fma(oUXZ, this.uZz, Math.fma(oUXX, this.uZx, oUXY * this.uZy));
        double _t51 = 1.0E-5 + Math.abs(_t30);
        double _t31 = Math.fma(oUYZ, this.uZz, Math.fma(oUYX, this.uZx, oUYY * this.uZy));
        double _t52 = 1.0E-5 + Math.abs(_t31);
        double _t32 = Math.fma(oUZZ, this.uZz, Math.fma(oUZX, this.uZx, oUZY * this.uZy));
        double _t53 = 1.0E-5 + Math.abs(_t32);
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
        if (!(this.hsX >= 0.0)) return false;
        if (!(this.hsY >= 0.0)) return false;
        return this.hsZ >= 0.0;
    }

    public double cX() { return this.cX; }
    public double cY() { return this.cY; }
    public double cZ() { return this.cZ; }
    public double uXx() { return this.uXx; }
    public double uXy() { return this.uXy; }
    public double uXz() { return this.uXz; }
    public double uYx() { return this.uYx; }
    public double uYy() { return this.uYy; }
    public double uYz() { return this.uYz; }
    public double uZx() { return this.uZx; }
    public double uZy() { return this.uZy; }
    public double uZz() { return this.uZz; }
    public double hsX() { return this.hsX; }
    public double hsY() { return this.hsY; }
    public double hsZ() { return this.hsZ; }

    @Override public String toString() {
        return "DoubleOBB(" + cX() + ", " + cY() + ", " + cZ() + ", " + uXx() + ", " + uXy() + ", " + uXz() + ", " + uYx() + ", " + uYy() + ", " + uYz() + ", " + uZx() + ", " + uZy() + ", " + uZz() + ", " + hsX() + ", " + hsY() + ", " + hsZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleOBBImpl)) return false;
        DoubleOBBImpl o = (DoubleOBBImpl) obj;
        return Double.doubleToLongBits(cX) == Double.doubleToLongBits(o.cX)
            && Double.doubleToLongBits(cY) == Double.doubleToLongBits(o.cY)
            && Double.doubleToLongBits(cZ) == Double.doubleToLongBits(o.cZ)
            && Double.doubleToLongBits(uXx) == Double.doubleToLongBits(o.uXx)
            && Double.doubleToLongBits(uXy) == Double.doubleToLongBits(o.uXy)
            && Double.doubleToLongBits(uXz) == Double.doubleToLongBits(o.uXz)
            && Double.doubleToLongBits(uYx) == Double.doubleToLongBits(o.uYx)
            && Double.doubleToLongBits(uYy) == Double.doubleToLongBits(o.uYy)
            && Double.doubleToLongBits(uYz) == Double.doubleToLongBits(o.uYz)
            && Double.doubleToLongBits(uZx) == Double.doubleToLongBits(o.uZx)
            && Double.doubleToLongBits(uZy) == Double.doubleToLongBits(o.uZy)
            && Double.doubleToLongBits(uZz) == Double.doubleToLongBits(o.uZz)
            && Double.doubleToLongBits(hsX) == Double.doubleToLongBits(o.hsX)
            && Double.doubleToLongBits(hsY) == Double.doubleToLongBits(o.hsY)
            && Double.doubleToLongBits(hsZ) == Double.doubleToLongBits(o.hsZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(cX) ^ (Double.doubleToLongBits(cX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(cY) ^ (Double.doubleToLongBits(cY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(cZ) ^ (Double.doubleToLongBits(cZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uXx) ^ (Double.doubleToLongBits(uXx) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uXy) ^ (Double.doubleToLongBits(uXy) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uXz) ^ (Double.doubleToLongBits(uXz) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uYx) ^ (Double.doubleToLongBits(uYx) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uYy) ^ (Double.doubleToLongBits(uYy) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uYz) ^ (Double.doubleToLongBits(uYz) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uZx) ^ (Double.doubleToLongBits(uZx) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uZy) ^ (Double.doubleToLongBits(uZy) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(uZz) ^ (Double.doubleToLongBits(uZz) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(hsX) ^ (Double.doubleToLongBits(hsX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(hsY) ^ (Double.doubleToLongBits(hsY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(hsZ) ^ (Double.doubleToLongBits(hsZ) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(cX)
            && Double.isFinite(cY)
            && Double.isFinite(cZ)
            && Double.isFinite(uXx)
            && Double.isFinite(uXy)
            && Double.isFinite(uXz)
            && Double.isFinite(uYx)
            && Double.isFinite(uYy)
            && Double.isFinite(uYz)
            && Double.isFinite(uZx)
            && Double.isFinite(uZy)
            && Double.isFinite(uZz)
            && Double.isFinite(hsX)
            && Double.isFinite(hsY)
            && Double.isFinite(hsZ);
    }

    @Override public boolean equalsEpsilon(DoubleOBBR other, double epsilon) {
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

    public double[] store(@Mutated double[] dest, int offset) {
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
    public @Mutated DoubleOBB load(double[] src, int offset) {
        this.cX = src[offset + 0];
        this.cY = src[offset + 1];
        this.cZ = src[offset + 2];
        this.uXx = src[offset + 3];
        this.uXy = src[offset + 4];
        this.uXz = src[offset + 5];
        this.uYx = src[offset + 6];
        this.uYy = src[offset + 7];
        this.uYz = src[offset + 8];
        this.uZx = src[offset + 9];
        this.uZy = src[offset + 10];
        this.uZz = src[offset + 11];
        this.hsX = src[offset + 12];
        this.hsY = src[offset + 13];
        this.hsZ = src[offset + 14];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleOBB loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleOBB loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleOBB storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleOBB loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleOBB load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.cX;
        dest[offset + 1] = (float) this.cY;
        dest[offset + 2] = (float) this.cZ;
        dest[offset + 3] = (float) this.uXx;
        dest[offset + 4] = (float) this.uXy;
        dest[offset + 5] = (float) this.uXz;
        dest[offset + 6] = (float) this.uYx;
        dest[offset + 7] = (float) this.uYy;
        dest[offset + 8] = (float) this.uYz;
        dest[offset + 9] = (float) this.uZx;
        dest[offset + 10] = (float) this.uZy;
        dest[offset + 11] = (float) this.uZz;
        dest[offset + 12] = (float) this.hsX;
        dest[offset + 13] = (float) this.hsY;
        dest[offset + 14] = (float) this.hsZ;
        return dest;
    }
    public @Mutated DoubleOBB load(float[] src, int offset) {
        this.cX = src[offset + 0];
        this.cY = src[offset + 1];
        this.cZ = src[offset + 2];
        this.uXx = src[offset + 3];
        this.uXy = src[offset + 4];
        this.uXz = src[offset + 5];
        this.uYx = src[offset + 6];
        this.uYy = src[offset + 7];
        this.uYz = src[offset + 8];
        this.uZx = src[offset + 9];
        this.uZy = src[offset + 10];
        this.uZz = src[offset + 11];
        this.hsX = src[offset + 12];
        this.hsY = src[offset + 13];
        this.hsZ = src[offset + 14];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleOBB loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleOBB loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleOBB storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleOBB loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleOBB loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
