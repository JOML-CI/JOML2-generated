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
 * Generated implementation of {@link FloatOBB} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatOBBImpl implements FloatOBB {

    public float cX;
    public float cY;
    public float cZ;
    public float uXx;
    public float uXy;
    public float uXz;
    public float uYx;
    public float uYy;
    public float uYz;
    public float uZx;
    public float uZy;
    public float uZz;
    public float hsX;
    public float hsY;
    public float hsZ;
    static final FloatOBBSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBSegOpsUnsafe()
                    : new FloatOBBSegOpsMS();
    static final FloatOBBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBBbOpsUnsafe()
                    : new FloatOBBBbOpsApi();
    static final FloatOBBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBRawOpsUnsafe()
                    : new FloatOBBRawOpsApi();

    public FloatOBBImpl() {
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
    public @Mutated FloatOBB set(FloatOBBR v) {
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
    @Mutated public FloatOBB set(float vCX, float vCY, float vCZ, float vUXX, float vUXY, float vUXZ, float vUYX, float vUYY, float vUYZ, float vUZX, float vUZY, float vUZZ, float vHSX, float vHSY, float vHSZ) {
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
    public FloatOBB setAxes(Float3R axisX, Float3R axisY, Float3R axisZ, @Mutated FloatOBB dest) {
        return setAxes(axisX.x(), axisX.y(), axisX.z(), axisY.x(), axisY.y(), axisY.z(), axisZ.x(), axisZ.y(), axisZ.z(), dest);
    }


    /**
     * Set the local coordinate axes of this oriented bounding box to {@code axisX}, {@code axisY}
     * and {@code axisZ} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param axisX the new local X axis
     * @param axisY the new local Y axis
     * @param axisZ the new local Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setAxes(Float3R axisX, Float3R axisY, Float3R axisZ, @Mutated DoubleOBB dest) {
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
    public FloatOBB setAxes(float axisXX, float axisXY, float axisXZ, float axisYX, float axisYY, float axisYZ, float axisZX, float axisZY, float axisZZ, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
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
     * Set the local coordinate axes of this oriented bounding box to ({@code axisXX},
     * {@code axisXY}, {@code axisXZ}), ({@code axisYX}, {@code axisYY}, {@code axisYZ}) and
     * ({@code axisZX}, {@code axisZY}, {@code axisZZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleOBB setAxes(float axisXX, float axisXY, float axisXZ, float axisYX, float axisYY, float axisYZ, float axisZX, float axisZY, float axisZZ, @Mutated DoubleOBB dest) {
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
    public FloatOBB setCenter(Float3R c, @Mutated FloatOBB dest) {
        return setCenter(c.x(), c.y(), c.z(), dest);
    }


    /**
     * Set the center of this oriented bounding box to {@code c} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setCenter(Float3R c, @Mutated DoubleOBB dest) {
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
    public FloatOBB setCenter(float cX, float cY, float cZ, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
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
     * Set the center of this oriented bounding box to ({@code cX}, {@code cY}, {@code cZ}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setCenter(float cX, float cY, float cZ, @Mutated DoubleOBB dest) {
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
    public FloatOBB setHalfSize(Float3R h, @Mutated FloatOBB dest) {
        return setHalfSize(h.x(), h.y(), h.z(), dest);
    }


    /**
     * Set the half extents of this oriented bounding box to {@code h} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param h the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setHalfSize(Float3R h, @Mutated DoubleOBB dest) {
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
    public FloatOBB setHalfSize(float hX, float hY, float hZ, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
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
     * Set the half extents of this oriented bounding box to ({@code hX}, {@code hY}, {@code hZ})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param hX the {@code x} component of the vector {@code (hX, hY, hZ)}
     * @param hY the {@code y} component of the vector {@code (hX, hY, hZ)}
     * @param hZ the {@code z} component of the vector {@code (hX, hY, hZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setHalfSize(float hX, float hY, float hZ, @Mutated DoubleOBB dest) {
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
    public FloatOBB setIdentityOrientation(@Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = 1.0f;
        d.uXy = 0.0f;
        d.uXz = 0.0f;
        d.uYx = 0.0f;
        d.uYy = 1.0f;
        d.uYz = 0.0f;
        d.uZx = 0.0f;
        d.uZy = 0.0f;
        d.uZz = 1.0f;
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Reset the orientation of this oriented bounding box to identity and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setIdentityOrientation(@Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = 1.0f;
        d.uXy = 0.0f;
        d.uXz = 0.0f;
        d.uYx = 0.0f;
        d.uYy = 1.0f;
        d.uYz = 0.0f;
        d.uZx = 0.0f;
        d.uZy = 0.0f;
        d.uZz = 1.0f;
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
    public FloatOBB setOrientation(FloatQuatR q, @Mutated FloatOBB dest) {
        return setOrientation(q.x(), q.y(), q.z(), q.w(), dest);
    }


    /**
     * Set the orientation of this oriented bounding box to {@code q} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB setOrientation(FloatQuatR q, @Mutated DoubleOBB dest) {
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
    public FloatOBB setOrientation(float qX, float qY, float qZ, float qW, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
        float _t0 = qY * qY;
        float _t1 = qZ * qZ;
        float _t2 = qX * qY;
        float _t3 = qZ * qW;
        float _t4 = qX * qZ;
        float _t5 = qY * qW;
        float _t6 = qX * qX;
        float _t7 = qX * qW;
        float _t8 = qY * qZ;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = 1.0f - 2.0f * (_t0 + _t1);
        d.uXy = 2.0f * (_t2 + _t3);
        d.uXz = 2.0f * (_t4 - _t5);
        d.uYx = 2.0f * (_t2 - _t3);
        d.uYy = 1.0f - 2.0f * (_t6 + _t1);
        d.uYz = 2.0f * (_t7 + _t8);
        d.uZx = 2.0f * (_t4 + _t5);
        d.uZy = 2.0f * (_t8 - _t7);
        d.uZz = 1.0f - 2.0f * (_t6 + _t0);
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Set the orientation of this oriented bounding box to ({@code qX}, {@code qY}, {@code qZ},
     * {@code qW}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleOBB setOrientation(float qX, float qY, float qZ, float qW, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        float _t0 = qY * qY;
        float _t1 = qZ * qZ;
        float _t2 = qX * qY;
        float _t3 = qZ * qW;
        float _t4 = qX * qZ;
        float _t5 = qY * qW;
        float _t6 = qX * qX;
        float _t7 = qX * qW;
        float _t8 = qY * qZ;
        d.cX = this.cX;
        d.cY = this.cY;
        d.cZ = this.cZ;
        d.uXx = 1.0f - 2.0f * (_t0 + _t1);
        d.uXy = 2.0f * (_t2 + _t3);
        d.uXz = 2.0f * (_t4 - _t5);
        d.uYx = 2.0f * (_t2 - _t3);
        d.uYy = 1.0f - 2.0f * (_t6 + _t1);
        d.uYz = 2.0f * (_t7 + _t8);
        d.uZx = 2.0f * (_t4 + _t5);
        d.uZy = 2.0f * (_t8 - _t7);
        d.uZz = 1.0f - 2.0f * (_t6 + _t0);
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Convert this oriented bounding box to {@code double} precision and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB toDouble(@Mutated DoubleOBB dest) {
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
        d.hsX = this.hsX;
        d.hsY = this.hsY;
        d.hsZ = this.hsZ;
        return d;
    }


    /**
     * Set this oriented bounding box to the identity.
     *
     * @return this
     */
    @Mutated public FloatOBB makeIdentity() {
        this.cX = 0.0f;
        this.cY = 0.0f;
        this.cZ = 0.0f;
        this.uXx = 1.0f;
        this.uXy = 0.0f;
        this.uXz = 0.0f;
        this.uYx = 0.0f;
        this.uYy = 1.0f;
        this.uYz = 0.0f;
        this.uZx = 0.0f;
        this.uZy = 0.0f;
        this.uZz = 1.0f;
        this.hsX = 0.0f;
        this.hsY = 0.0f;
        this.hsZ = 0.0f;
        return this;
    }


    /**
     * Transform this oriented bounding box by {@code m}: the center is transformed as a point, each
     * axis as a direction and renormalized, and each half-size is scaled by the length its
     * transformed axis had, so the box follows the matrix's scale (exact for rotation and scale; a
     * shear is approximated) and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatOBB transform(Float3x4R m, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
        float _t36 = m.m00() * this.uXx + m.m01() * this.uXy + m.m02() * this.uXz;
        float _t37 = m.m10() * this.uXx + m.m11() * this.uXy + m.m12() * this.uXz;
        float _t38 = m.m20() * this.uXx + m.m21() * this.uXy + m.m22() * this.uXz;
        float _t39 = m.m00() * this.uYx + m.m01() * this.uYy + m.m02() * this.uYz;
        float _t40 = m.m10() * this.uYx + m.m11() * this.uYy + m.m12() * this.uYz;
        float _t41 = m.m20() * this.uYx + m.m21() * this.uYy + m.m22() * this.uYz;
        float _t42 = m.m00() * this.uZx + m.m01() * this.uZy + m.m02() * this.uZz;
        float _t43 = m.m10() * this.uZx + m.m11() * this.uZy + m.m12() * this.uZz;
        float _t44 = m.m20() * this.uZx + m.m21() * this.uZy + m.m22() * this.uZz;
        float _t57 = _t36 * _t36 + _t37 * _t37 + _t38 * _t38;
        float _t58 = _t39 * _t39 + _t40 * _t40 + _t41 * _t41;
        float _t59 = _t42 * _t42 + _t43 * _t43 + _t44 * _t44;
        float _t60 = (1.0f / (float) Math.sqrt(_t57));
        float _t61 = (1.0f / (float) Math.sqrt(_t58));
        float _t62 = (1.0f / (float) Math.sqrt(_t59));
        float _buf0 = m.m02() * this.cZ + (m.m00() * this.cX + (m.m01() * this.cY + m.m03()));
        float _buf1 = m.m12() * this.cZ + (m.m10() * this.cX + (m.m11() * this.cY + m.m13()));
        d.cZ = m.m22() * this.cZ + (m.m20() * this.cX + (m.m21() * this.cY + m.m23()));
        d.uXx = _t36 * _t60;
        d.uXy = _t37 * _t60;
        d.uXz = _t38 * _t60;
        d.uYx = _t39 * _t61;
        d.uYy = _t40 * _t61;
        d.uYz = _t41 * _t61;
        d.uZx = _t42 * _t62;
        d.uZy = _t43 * _t62;
        d.uZz = _t44 * _t62;
        d.hsX = this.hsX * (float) Math.sqrt(_t57);
        d.hsY = this.hsY * (float) Math.sqrt(_t58);
        d.hsZ = this.hsZ * (float) Math.sqrt(_t59);
        d.cX = _buf0;
        d.cY = _buf1;
        return d;
    }


    /**
     * Transform this oriented bounding box by {@code m}: the center is transformed as a point, each
     * axis as a direction and renormalized, and each half-size is scaled by the length its
     * transformed axis had, so the box follows the matrix's scale (exact for rotation and scale; a
     * shear is approximated) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB transform(Float3x4R m, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        float _t36 = m.m00() * this.uXx + m.m01() * this.uXy + m.m02() * this.uXz;
        float _t37 = m.m10() * this.uXx + m.m11() * this.uXy + m.m12() * this.uXz;
        float _t38 = m.m20() * this.uXx + m.m21() * this.uXy + m.m22() * this.uXz;
        float _t39 = m.m00() * this.uYx + m.m01() * this.uYy + m.m02() * this.uYz;
        float _t40 = m.m10() * this.uYx + m.m11() * this.uYy + m.m12() * this.uYz;
        float _t41 = m.m20() * this.uYx + m.m21() * this.uYy + m.m22() * this.uYz;
        float _t42 = m.m00() * this.uZx + m.m01() * this.uZy + m.m02() * this.uZz;
        float _t43 = m.m10() * this.uZx + m.m11() * this.uZy + m.m12() * this.uZz;
        float _t44 = m.m20() * this.uZx + m.m21() * this.uZy + m.m22() * this.uZz;
        float _t57 = _t36 * _t36 + _t37 * _t37 + _t38 * _t38;
        float _t58 = _t39 * _t39 + _t40 * _t40 + _t41 * _t41;
        float _t59 = _t42 * _t42 + _t43 * _t43 + _t44 * _t44;
        float _t60 = (1.0f / (float) Math.sqrt(_t57));
        float _t61 = (1.0f / (float) Math.sqrt(_t58));
        float _t62 = (1.0f / (float) Math.sqrt(_t59));
        float _buf0 = m.m02() * this.cZ + (m.m00() * this.cX + (m.m01() * this.cY + m.m03()));
        float _buf1 = m.m12() * this.cZ + (m.m10() * this.cX + (m.m11() * this.cY + m.m13()));
        d.cZ = m.m22() * this.cZ + (m.m20() * this.cX + (m.m21() * this.cY + m.m23()));
        d.uXx = _t36 * _t60;
        d.uXy = _t37 * _t60;
        d.uXz = _t38 * _t60;
        d.uYx = _t39 * _t61;
        d.uYy = _t40 * _t61;
        d.uYz = _t41 * _t61;
        d.uZx = _t42 * _t62;
        d.uZy = _t43 * _t62;
        d.uZz = _t44 * _t62;
        d.hsX = this.hsX * (float) Math.sqrt(_t57);
        d.hsY = this.hsY * (float) Math.sqrt(_t58);
        d.hsZ = this.hsZ * (float) Math.sqrt(_t59);
        d.cX = _buf0;
        d.cY = _buf1;
        return d;
    }


    /**
     * Transform this oriented bounding box by {@code m}: the center is transformed as a point, each
     * axis as a direction and renormalized, and each half-size is scaled by the length its
     * transformed axis had, so the box follows the matrix's scale (exact for rotation and scale; a
     * shear is approximated) and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatOBB transform(Float4x4R m, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
        float _t36 = m.m00() * this.uXx + m.m01() * this.uXy + m.m02() * this.uXz;
        float _t37 = m.m10() * this.uXx + m.m11() * this.uXy + m.m12() * this.uXz;
        float _t38 = m.m20() * this.uXx + m.m21() * this.uXy + m.m22() * this.uXz;
        float _t39 = m.m00() * this.uYx + m.m01() * this.uYy + m.m02() * this.uYz;
        float _t40 = m.m10() * this.uYx + m.m11() * this.uYy + m.m12() * this.uYz;
        float _t41 = m.m20() * this.uYx + m.m21() * this.uYy + m.m22() * this.uYz;
        float _t42 = m.m00() * this.uZx + m.m01() * this.uZy + m.m02() * this.uZz;
        float _t43 = m.m10() * this.uZx + m.m11() * this.uZy + m.m12() * this.uZz;
        float _t44 = m.m20() * this.uZx + m.m21() * this.uZy + m.m22() * this.uZz;
        float _t57 = _t36 * _t36 + _t37 * _t37 + _t38 * _t38;
        float _t58 = _t39 * _t39 + _t40 * _t40 + _t41 * _t41;
        float _t59 = _t42 * _t42 + _t43 * _t43 + _t44 * _t44;
        float _t60 = (1.0f / (float) Math.sqrt(_t57));
        float _t61 = (1.0f / (float) Math.sqrt(_t58));
        float _t62 = (1.0f / (float) Math.sqrt(_t59));
        float _buf0 = m.m02() * this.cZ + (m.m00() * this.cX + (m.m01() * this.cY + m.m03()));
        float _buf1 = m.m12() * this.cZ + (m.m10() * this.cX + (m.m11() * this.cY + m.m13()));
        d.cZ = m.m22() * this.cZ + (m.m20() * this.cX + (m.m21() * this.cY + m.m23()));
        d.uXx = _t36 * _t60;
        d.uXy = _t37 * _t60;
        d.uXz = _t38 * _t60;
        d.uYx = _t39 * _t61;
        d.uYy = _t40 * _t61;
        d.uYz = _t41 * _t61;
        d.uZx = _t42 * _t62;
        d.uZy = _t43 * _t62;
        d.uZz = _t44 * _t62;
        d.hsX = this.hsX * (float) Math.sqrt(_t57);
        d.hsY = this.hsY * (float) Math.sqrt(_t58);
        d.hsZ = this.hsZ * (float) Math.sqrt(_t59);
        d.cX = _buf0;
        d.cY = _buf1;
        return d;
    }


    /**
     * Transform this oriented bounding box by {@code m}: the center is transformed as a point, each
     * axis as a direction and renormalized, and each half-size is scaled by the length its
     * transformed axis had, so the box follows the matrix's scale (exact for rotation and scale; a
     * shear is approximated) and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB transform(Float4x4R m, @Mutated DoubleOBB dest) {
        DoubleOBBImpl d = (DoubleOBBImpl) dest;
        float _t36 = m.m00() * this.uXx + m.m01() * this.uXy + m.m02() * this.uXz;
        float _t37 = m.m10() * this.uXx + m.m11() * this.uXy + m.m12() * this.uXz;
        float _t38 = m.m20() * this.uXx + m.m21() * this.uXy + m.m22() * this.uXz;
        float _t39 = m.m00() * this.uYx + m.m01() * this.uYy + m.m02() * this.uYz;
        float _t40 = m.m10() * this.uYx + m.m11() * this.uYy + m.m12() * this.uYz;
        float _t41 = m.m20() * this.uYx + m.m21() * this.uYy + m.m22() * this.uYz;
        float _t42 = m.m00() * this.uZx + m.m01() * this.uZy + m.m02() * this.uZz;
        float _t43 = m.m10() * this.uZx + m.m11() * this.uZy + m.m12() * this.uZz;
        float _t44 = m.m20() * this.uZx + m.m21() * this.uZy + m.m22() * this.uZz;
        float _t57 = _t36 * _t36 + _t37 * _t37 + _t38 * _t38;
        float _t58 = _t39 * _t39 + _t40 * _t40 + _t41 * _t41;
        float _t59 = _t42 * _t42 + _t43 * _t43 + _t44 * _t44;
        float _t60 = (1.0f / (float) Math.sqrt(_t57));
        float _t61 = (1.0f / (float) Math.sqrt(_t58));
        float _t62 = (1.0f / (float) Math.sqrt(_t59));
        float _buf0 = m.m02() * this.cZ + (m.m00() * this.cX + (m.m01() * this.cY + m.m03()));
        float _buf1 = m.m12() * this.cZ + (m.m10() * this.cX + (m.m11() * this.cY + m.m13()));
        d.cZ = m.m22() * this.cZ + (m.m20() * this.cX + (m.m21() * this.cY + m.m23()));
        d.uXx = _t36 * _t60;
        d.uXy = _t37 * _t60;
        d.uXz = _t38 * _t60;
        d.uYx = _t39 * _t61;
        d.uYy = _t40 * _t61;
        d.uYz = _t41 * _t61;
        d.uZx = _t42 * _t62;
        d.uZy = _t43 * _t62;
        d.uZz = _t44 * _t62;
        d.hsX = this.hsX * (float) Math.sqrt(_t57);
        d.hsY = this.hsY * (float) Math.sqrt(_t58);
        d.hsZ = this.hsZ * (float) Math.sqrt(_t59);
        d.cX = _buf0;
        d.cY = _buf1;
        return d;
    }


    /**
     * Translate this oriented bounding box by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatOBB translate(Float3R delta, @Mutated FloatOBB dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this oriented bounding box by {@code delta} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB translate(Float3R delta, @Mutated DoubleOBB dest) {
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
    public FloatOBB translate(float deltaX, float deltaY, float deltaZ, @Mutated FloatOBB dest) {
        FloatOBBImpl d = (FloatOBBImpl) dest;
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
     * Translate this oriented bounding box by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB translate(float deltaX, float deltaY, float deltaZ, @Mutated DoubleOBB dest) {
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
    public Float3 closestPointToPoint(Float3R p, @Mutated Float3 dest) {
        return closestPointToPoint(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(Float3R p, @Mutated Double3 dest) {
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
    public Float3 closestPointToPoint(float pX, float pY, float pZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t3 = pX - this.cX;
        float _t4 = pY - this.cY;
        float _t5 = pZ - this.cZ;
        float _t24 = Math.max(-this.hsX, Math.min(this.uXx * _t3 + this.uXy * _t4 + this.uXz * _t5, this.hsX));
        float _t25 = Math.max(-this.hsY, Math.min(this.uYx * _t3 + this.uYy * _t4 + this.uYz * _t5, this.hsY));
        float _t26 = Math.max(-this.hsZ, Math.min(this.uZx * _t3 + this.uZy * _t4 + this.uZz * _t5, this.hsZ));
        d.x = this.uXx * _t24 + (this.uYx * _t25 + (this.uZx * _t26 + this.cX));
        d.y = this.uXy * _t24 + (this.uYy * _t25 + (this.uZy * _t26 + this.cY));
        d.z = this.uXz * _t24 + (this.uYz * _t25 + (this.uZz * _t26 + this.cZ));
        return d;
    }


    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(float pX, float pY, float pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t3 = pX - this.cX;
        float _t4 = pY - this.cY;
        float _t5 = pZ - this.cZ;
        float _t24 = Math.max(-this.hsX, Math.min(this.uXx * _t3 + this.uXy * _t4 + this.uXz * _t5, this.hsX));
        float _t25 = Math.max(-this.hsY, Math.min(this.uYx * _t3 + this.uYy * _t4 + this.uYz * _t5, this.hsY));
        float _t26 = Math.max(-this.hsZ, Math.min(this.uZx * _t3 + this.uZy * _t4 + this.uZz * _t5, this.hsZ));
        d.x = this.uXx * _t24 + (this.uYx * _t25 + (this.uZx * _t26 + this.cX));
        d.y = this.uXy * _t24 + (this.uYy * _t25 + (this.uZy * _t26 + this.cY));
        d.z = this.uXz * _t24 + (this.uYz * _t25 + (this.uZz * _t26 + this.cZ));
        return d;
    }


    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    public boolean containsPoint(Float3R p) {
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
        float _t0 = pX - this.cX;
        float _t1 = pY - this.cY;
        float _t2 = pZ - this.cZ;
        if (!(Math.abs(this.uXx * _t0 + this.uXy * _t1 + this.uXz * _t2) <= this.hsX)) return false;
        if (!(Math.abs(this.uYx * _t0 + this.uYy * _t1 + this.uYz * _t2) <= this.hsY)) return false;
        return Math.abs(this.uZx * _t0 + this.uZy * _t1 + this.uZz * _t2) <= this.hsZ;
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
    public float distanceSquaredToPoint(Float3R p) {
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
    public float distanceSquaredToPoint(float pX, float pY, float pZ) {
        float _t0 = pX - this.cX;
        float _t1 = pY - this.cY;
        float _t2 = pZ - this.cZ;
        float _t24 = Math.max(0.0f, Math.abs(this.uXx * _t0 + this.uXy * _t1 + this.uXz * _t2) - this.hsX);
        float _t25 = Math.max(0.0f, Math.abs(this.uYx * _t0 + this.uYy * _t1 + this.uYz * _t2) - this.hsY);
        float _t26 = Math.max(0.0f, Math.abs(this.uZx * _t0 + this.uZy * _t1 + this.uZz * _t2) - this.hsZ);
        return _t24 * _t24 + _t25 * _t25 + _t26 * _t26;
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
    public float distanceToPoint(Float3R p) {
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
    public float distanceToPoint(float pX, float pY, float pZ) {
        float _t0 = pX - this.cX;
        float _t1 = pY - this.cY;
        float _t2 = pZ - this.cZ;
        float _t24 = Math.max(0.0f, Math.abs(this.uXx * _t0 + this.uXy * _t1 + this.uXz * _t2) - this.hsX);
        float _t25 = Math.max(0.0f, Math.abs(this.uYx * _t0 + this.uYy * _t1 + this.uYz * _t2) - this.hsY);
        float _t26 = Math.max(0.0f, Math.abs(this.uZx * _t0 + this.uZy * _t1 + this.uZz * _t2) - this.hsZ);
        return (float) Math.sqrt(_t24 * _t24 + _t25 * _t25 + _t26 * _t26);
    }


    /**
     * Get the local {@code X} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getAxisX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.uXx;
        d.y = this.uXy;
        d.z = this.uXz;
        return d;
    }


    /**
     * Get the local {@code X} axis of this oriented bounding box and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 getAxisY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.uYx;
        d.y = this.uYy;
        d.z = this.uYz;
        return d;
    }


    /**
     * Get the local {@code Y} axis of this oriented bounding box and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 getAxisZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.uZx;
        d.y = this.uZy;
        d.z = this.uZz;
        return d;
    }


    /**
     * Get the local {@code Z} axis of this oriented bounding box and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 getCenter(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.cX;
        d.y = this.cY;
        d.z = this.cZ;
        return d;
    }


    /**
     * Get the center of this oriented bounding box and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 getHalfSize(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.hsX;
        d.y = this.hsY;
        d.z = this.hsZ;
        return d;
    }


    /**
     * Get the half extents of this oriented bounding box and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public boolean intersectsOBB(FloatOBBR o) {
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
        float _t0 = oCX - this.cX;
        float _t1 = oCY - this.cY;
        float _t2 = oCZ - this.cZ;
        float _t78 = this.uXx * _t0 + this.uXy * _t1 + this.uXz * _t2;
        float _t49 = oUXX * this.uXx + oUXY * this.uXy + oUXZ * this.uXz;
        float _t69 = 1.0E-5f + Math.abs(_t49);
        float _t50 = oUYX * this.uXx + oUYY * this.uXy + oUYZ * this.uXz;
        float _t70 = 1.0E-5f + Math.abs(_t50);
        float _t51 = oUZX * this.uXx + oUZY * this.uXy + oUZZ * this.uXz;
        float _t71 = 1.0E-5f + Math.abs(_t51);
        if (!(Math.abs(_t78) <= oHSX * _t69 + (oHSY * _t70 + (oHSZ * _t71 + this.hsX)))) return false;
        float _t79 = this.uYx * _t0 + this.uYy * _t1 + this.uYz * _t2;
        float _t53 = oUXX * this.uYx + oUXY * this.uYy + oUXZ * this.uYz;
        float _t72 = 1.0E-5f + Math.abs(_t53);
        float _t54 = oUYX * this.uYx + oUYY * this.uYy + oUYZ * this.uYz;
        float _t73 = 1.0E-5f + Math.abs(_t54);
        float _t55 = oUZX * this.uYx + oUZY * this.uYy + oUZZ * this.uYz;
        float _t74 = 1.0E-5f + Math.abs(_t55);
        if (!(Math.abs(_t79) <= oHSX * _t72 + (oHSY * _t73 + (oHSZ * _t74 + this.hsY)))) return false;
        float _t80 = this.uZx * _t0 + this.uZy * _t1 + this.uZz * _t2;
        float _t57 = oUXX * this.uZx + oUXY * this.uZy + oUXZ * this.uZz;
        float _t75 = 1.0E-5f + Math.abs(_t57);
        float _t58 = oUYX * this.uZx + oUYY * this.uZy + oUYZ * this.uZz;
        float _t76 = 1.0E-5f + Math.abs(_t58);
        float _t59 = oUZX * this.uZx + oUZY * this.uZy + oUZZ * this.uZz;
        float _t77 = 1.0E-5f + Math.abs(_t59);
        if (!(Math.abs(_t80) <= oHSX * _t75 + (oHSY * _t76 + (oHSZ * _t77 + this.hsZ)))) return false;
        if (!(Math.abs(_t49 * _t78 + _t53 * _t79 + _t57 * _t80) <= this.hsX * _t69 + (this.hsY * _t72 + (this.hsZ * _t75 + oHSX)))) return false;
        if (!(Math.abs(_t50 * _t78 + _t54 * _t79 + _t58 * _t80) <= this.hsX * _t70 + (this.hsY * _t73 + (this.hsZ * _t76 + oHSY)))) return false;
        if (!(Math.abs(_t51 * _t78 + _t55 * _t79 + _t59 * _t80) <= this.hsX * _t71 + (this.hsY * _t74 + (this.hsZ * _t77 + oHSZ)))) return false;
        if (!(Math.abs(_t53 * _t80 - _t57 * _t79) <= oHSY * _t71 + oHSZ * _t70 + (this.hsY * _t75 + this.hsZ * _t72))) return false;
        if (!(Math.abs(_t54 * _t80 - _t58 * _t79) <= oHSX * _t71 + oHSZ * _t69 + (this.hsY * _t76 + this.hsZ * _t73))) return false;
        if (!(Math.abs(_t55 * _t80 - _t59 * _t79) <= oHSX * _t70 + oHSY * _t69 + (this.hsY * _t77 + this.hsZ * _t74))) return false;
        if (!(Math.abs(_t57 * _t78 - _t49 * _t80) <= oHSY * _t74 + oHSZ * _t73 + (this.hsX * _t75 + this.hsZ * _t69))) return false;
        if (!(Math.abs(_t58 * _t78 - _t50 * _t80) <= oHSX * _t74 + oHSZ * _t72 + (this.hsX * _t76 + this.hsZ * _t70))) return false;
        if (!(Math.abs(_t59 * _t78 - _t51 * _t80) <= oHSX * _t73 + oHSY * _t72 + (this.hsX * _t77 + this.hsZ * _t71))) return false;
        if (!(Math.abs(_t49 * _t79 - _t53 * _t78) <= oHSY * _t77 + oHSZ * _t76 + (this.hsX * _t72 + this.hsY * _t69))) return false;
        if (!(Math.abs(_t50 * _t79 - _t54 * _t78) <= oHSX * _t77 + oHSZ * _t75 + (this.hsX * _t73 + this.hsY * _t70))) return false;
        return Math.abs(_t51 * _t79 - _t55 * _t78) <= oHSX * _t76 + oHSY * _t75 + (this.hsX * _t74 + this.hsY * _t71);
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

    public float cX() { return this.cX; }
    public float cY() { return this.cY; }
    public float cZ() { return this.cZ; }
    public float uXx() { return this.uXx; }
    public float uXy() { return this.uXy; }
    public float uXz() { return this.uXz; }
    public float uYx() { return this.uYx; }
    public float uYy() { return this.uYy; }
    public float uYz() { return this.uYz; }
    public float uZx() { return this.uZx; }
    public float uZy() { return this.uZy; }
    public float uZz() { return this.uZz; }
    public float hsX() { return this.hsX; }
    public float hsY() { return this.hsY; }
    public float hsZ() { return this.hsZ; }

    @Override public String toString() {
        return "FloatOBB(" + cX() + ", " + cY() + ", " + cZ() + ", " + uXx() + ", " + uXy() + ", " + uXz() + ", " + uYx() + ", " + uYy() + ", " + uYz() + ", " + uZx() + ", " + uZy() + ", " + uZz() + ", " + hsX() + ", " + hsY() + ", " + hsZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatOBBImpl)) return false;
        FloatOBBImpl o = (FloatOBBImpl) obj;
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

    @Override public boolean isFinite() {
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

    @Override public boolean equalsEpsilon(FloatOBBR other, float epsilon) {
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

    public float[] store(@Mutated float[] dest, int offset) {
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
    public @Mutated FloatOBB load(float[] src, int offset) {
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
    @Mutated public FloatOBB loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatOBB loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatOBB storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatOBB loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatOBB load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
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
    public @Mutated FloatOBB load(double[] src, int offset) {
        this.cX = (float) src[offset + 0];
        this.cY = (float) src[offset + 1];
        this.cZ = (float) src[offset + 2];
        this.uXx = (float) src[offset + 3];
        this.uXy = (float) src[offset + 4];
        this.uXz = (float) src[offset + 5];
        this.uYx = (float) src[offset + 6];
        this.uYy = (float) src[offset + 7];
        this.uYz = (float) src[offset + 8];
        this.uZx = (float) src[offset + 9];
        this.uZy = (float) src[offset + 10];
        this.uZz = (float) src[offset + 11];
        this.hsX = (float) src[offset + 12];
        this.hsY = (float) src[offset + 13];
        this.hsZ = (float) src[offset + 14];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatOBB loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatOBB loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatOBB storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatOBB loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatOBB loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
