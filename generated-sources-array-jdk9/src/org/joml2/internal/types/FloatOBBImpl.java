package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatOBB} backed by a {@code float[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatOBBImpl implements FloatOBB {

    public float[] data;
    static final FloatOBBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBBbOpsUnsafe()
                    : new FloatOBBBbOpsApi();
    static final FloatOBBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatOBBRawOpsUnsafe()
                    : new FloatOBBRawOpsApi();

    public FloatOBBImpl() {
        data = new float[15];
        data[3] = 1;
        data[7] = 1;
        data[11] = 1;
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
        float[] dd = this.data;
        dd[0] = vCX;
        dd[1] = vCY;
        dd[2] = vCZ;
        dd[3] = vUXX;
        dd[4] = vUXY;
        dd[5] = vUXZ;
        dd[6] = vUYX;
        dd[7] = vUYY;
        dd[8] = vUYZ;
        dd[9] = vUZX;
        dd[10] = vUZY;
        dd[11] = vUZZ;
        dd[12] = vHSX;
        dd[13] = vHSY;
        dd[14] = vHSZ;
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
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = axisXX;
        dd[4] = axisXY;
        dd[5] = axisXZ;
        dd[6] = axisYX;
        dd[7] = axisYY;
        dd[8] = axisYZ;
        dd[9] = axisZX;
        dd[10] = axisZY;
        dd[11] = axisZZ;
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = axisXX;
        dd[4] = axisXY;
        dd[5] = axisXZ;
        dd[6] = axisYX;
        dd[7] = axisYY;
        dd[8] = axisYZ;
        dd[9] = axisZX;
        dd[10] = axisZY;
        dd[11] = axisZZ;
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        dd[0] = cX;
        dd[1] = cY;
        dd[2] = cZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = cX;
        dd[1] = cY;
        dd[2] = cZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = hX;
        dd[13] = hY;
        dd[14] = hZ;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = hX;
        dd[13] = hY;
        dd[14] = hZ;
        return dest;
    }


    /**
     * Reset the orientation of this oriented bounding box to identity and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatOBB setIdentityOrientation(@Mutated FloatOBB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 1.0f;
        dd[8] = 0.0f;
        dd[9] = 0.0f;
        dd[10] = 0.0f;
        dd[11] = 1.0f;
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 1.0f;
        dd[8] = 0.0f;
        dd[9] = 0.0f;
        dd[10] = 0.0f;
        dd[11] = 1.0f;
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f);
        dd[4] = 2.0f * Math.fma(qX, qY, _t1);
        dd[5] = 2.0f * Math.fma(qX, qZ, -_t2);
        dd[6] = 2.0f * Math.fma(qX, qY, -_t1);
        dd[7] = Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f);
        dd[8] = 2.0f * Math.fma(qX, qW, qY * qZ);
        dd[9] = 2.0f * Math.fma(qX, qZ, _t2);
        dd[10] = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        dd[11] = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        float _t0 = qZ * qZ;
        float _t1 = qZ * qW;
        float _t2 = qY * qW;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = Math.fma(-2.0f, Math.fma(qY, qY, _t0), 1.0f);
        dd[4] = 2.0f * Math.fma(qX, qY, _t1);
        dd[5] = 2.0f * Math.fma(qX, qZ, -_t2);
        dd[6] = 2.0f * Math.fma(qX, qY, -_t1);
        dd[7] = Math.fma(-2.0f, Math.fma(qX, qX, _t0), 1.0f);
        dd[8] = 2.0f * Math.fma(qX, qW, qY * qZ);
        dd[9] = 2.0f * Math.fma(qX, qZ, _t2);
        dd[10] = 2.0f * Math.fma(qY, qZ, -(qX * qW));
        dd[11] = Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f);
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
    }


    /**
     * Convert this oriented bounding box to {@code double} precision and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB toDouble(@Mutated DoubleOBB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
    }


    /**
     * Set this oriented bounding box to the identity.
     *
     * @return this
     */
    @Mutated public FloatOBB makeIdentity() {
        float[] dd = this.data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 1.0f;
        dd[8] = 0.0f;
        dd[9] = 0.0f;
        dd[10] = 0.0f;
        dd[11] = 1.0f;
        dd[12] = 0.0f;
        dd[13] = 0.0f;
        dd[14] = 0.0f;
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
    public FloatOBB transform(Float3x4R m, @Mutated FloatOBB dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float[] dd = ((FloatOBBImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], mData[1] * sd[4]));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], mData[9] * sd[4]));
        float _buf4 = Math.fma(mData[2], sd[8], Math.fma(mData[0], sd[6], mData[1] * sd[7]));
        float _buf5 = Math.fma(mData[6], sd[8], Math.fma(mData[4], sd[6], mData[5] * sd[7]));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[8], sd[6], mData[9] * sd[7]));
        float _buf6 = Math.fma(mData[2], sd[11], Math.fma(mData[0], sd[9], mData[1] * sd[10]));
        float _buf7 = Math.fma(mData[6], sd[11], Math.fma(mData[4], sd[9], mData[5] * sd[10]));
        dd[11] = Math.fma(mData[10], sd[11], Math.fma(mData[8], sd[9], mData[9] * sd[10]));
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        dd[9] = _buf6;
        dd[10] = _buf7;
        return dest;
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleOBB transform(Float3x4R m, @Mutated DoubleOBB dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], mData[1] * sd[4]));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], mData[9] * sd[4]));
        float _buf4 = Math.fma(mData[2], sd[8], Math.fma(mData[0], sd[6], mData[1] * sd[7]));
        float _buf5 = Math.fma(mData[6], sd[8], Math.fma(mData[4], sd[6], mData[5] * sd[7]));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[8], sd[6], mData[9] * sd[7]));
        float _buf6 = Math.fma(mData[2], sd[11], Math.fma(mData[0], sd[9], mData[1] * sd[10]));
        float _buf7 = Math.fma(mData[6], sd[11], Math.fma(mData[4], sd[9], mData[5] * sd[10]));
        dd[11] = Math.fma(mData[10], sd[11], Math.fma(mData[8], sd[9], mData[9] * sd[10]));
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        dd[9] = _buf6;
        dd[10] = _buf7;
        return dest;
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
    public FloatOBB transform(Float4x4R m, @Mutated FloatOBB dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatOBBImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], mData[4] * sd[4]));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], mData[6] * sd[4]));
        float _buf4 = Math.fma(mData[8], sd[8], Math.fma(mData[0], sd[6], mData[4] * sd[7]));
        float _buf5 = Math.fma(mData[9], sd[8], Math.fma(mData[1], sd[6], mData[5] * sd[7]));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[2], sd[6], mData[6] * sd[7]));
        float _buf6 = Math.fma(mData[8], sd[11], Math.fma(mData[0], sd[9], mData[4] * sd[10]));
        float _buf7 = Math.fma(mData[9], sd[11], Math.fma(mData[1], sd[9], mData[5] * sd[10]));
        dd[11] = Math.fma(mData[10], sd[11], Math.fma(mData[2], sd[9], mData[6] * sd[10]));
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        dd[9] = _buf6;
        dd[10] = _buf7;
        return dest;
    }


    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
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
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], mData[4] * sd[4]));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], mData[6] * sd[4]));
        float _buf4 = Math.fma(mData[8], sd[8], Math.fma(mData[0], sd[6], mData[4] * sd[7]));
        float _buf5 = Math.fma(mData[9], sd[8], Math.fma(mData[1], sd[6], mData[5] * sd[7]));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[2], sd[6], mData[6] * sd[7]));
        float _buf6 = Math.fma(mData[8], sd[11], Math.fma(mData[0], sd[9], mData[4] * sd[10]));
        float _buf7 = Math.fma(mData[9], sd[11], Math.fma(mData[1], sd[9], mData[5] * sd[10]));
        dd[11] = Math.fma(mData[10], sd[11], Math.fma(mData[2], sd[9], mData[6] * sd[10]));
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        dd[9] = _buf6;
        dd[10] = _buf7;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((FloatOBBImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaZ + sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((DoubleOBBImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaZ + sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        dd[9] = sd[9];
        dd[10] = sd[10];
        dd[11] = sd[11];
        dd[12] = sd[12];
        dd[13] = sd[13];
        dd[14] = sd[14];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t3 = pZ - sd[2];
        float _t4 = pX - sd[0];
        float _t5 = pY - sd[1];
        float _t18 = Math.max(-sd[12], Math.min(Math.fma(sd[5], _t3, Math.fma(sd[3], _t4, sd[4] * _t5)), sd[12]));
        float _t19 = Math.max(-sd[13], Math.min(Math.fma(sd[8], _t3, Math.fma(sd[6], _t4, sd[7] * _t5)), sd[13]));
        float _t20 = Math.max(-sd[14], Math.min(Math.fma(sd[11], _t3, Math.fma(sd[9], _t4, sd[10] * _t5)), sd[14]));
        dd[0] = Math.fma(sd[3], _t18, Math.fma(sd[6], _t19, Math.fma(sd[9], _t20, sd[0])));
        dd[1] = Math.fma(sd[4], _t18, Math.fma(sd[7], _t19, Math.fma(sd[10], _t20, sd[1])));
        dd[2] = Math.fma(sd[5], _t18, Math.fma(sd[8], _t19, Math.fma(sd[11], _t20, sd[2])));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t3 = pZ - sd[2];
        float _t4 = pX - sd[0];
        float _t5 = pY - sd[1];
        float _t18 = Math.max(-sd[12], Math.min(Math.fma(sd[5], _t3, Math.fma(sd[3], _t4, sd[4] * _t5)), sd[12]));
        float _t19 = Math.max(-sd[13], Math.min(Math.fma(sd[8], _t3, Math.fma(sd[6], _t4, sd[7] * _t5)), sd[13]));
        float _t20 = Math.max(-sd[14], Math.min(Math.fma(sd[11], _t3, Math.fma(sd[9], _t4, sd[10] * _t5)), sd[14]));
        dd[0] = Math.fma(sd[3], _t18, Math.fma(sd[6], _t19, Math.fma(sd[9], _t20, sd[0])));
        dd[1] = Math.fma(sd[4], _t18, Math.fma(sd[7], _t19, Math.fma(sd[10], _t20, sd[1])));
        dd[2] = Math.fma(sd[5], _t18, Math.fma(sd[8], _t19, Math.fma(sd[11], _t20, sd[2])));
        return dest;
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
        float[] sd = this.data;
        float _t0 = pZ - sd[2];
        float _t1 = pX - sd[0];
        float _t2 = pY - sd[1];
        if (!(Math.abs(Math.fma(sd[5], _t0, Math.fma(sd[3], _t1, sd[4] * _t2))) <= sd[12])) return false;
        if (!(Math.abs(Math.fma(sd[8], _t0, Math.fma(sd[6], _t1, sd[7] * _t2))) <= sd[13])) return false;
        return Math.abs(Math.fma(sd[11], _t0, Math.fma(sd[9], _t1, sd[10] * _t2))) <= sd[14];
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
        float[] sd = this.data;
        float _t0 = pZ - sd[2];
        float _t1 = pX - sd[0];
        float _t2 = pY - sd[1];
        float _t18 = Math.max(0.0f, Math.abs(Math.fma(sd[11], _t0, Math.fma(sd[9], _t1, sd[10] * _t2))) - sd[14]);
        float _t19 = Math.max(0.0f, Math.abs(Math.fma(sd[5], _t0, Math.fma(sd[3], _t1, sd[4] * _t2))) - sd[12]);
        float _t20 = Math.max(0.0f, Math.abs(Math.fma(sd[8], _t0, Math.fma(sd[6], _t1, sd[7] * _t2))) - sd[13]);
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
        float[] sd = this.data;
        float _t0 = pZ - sd[2];
        float _t1 = pX - sd[0];
        float _t2 = pY - sd[1];
        float _t18 = Math.max(0.0f, Math.abs(Math.fma(sd[11], _t0, Math.fma(sd[9], _t1, sd[10] * _t2))) - sd[14]);
        float _t19 = Math.max(0.0f, Math.abs(Math.fma(sd[5], _t0, Math.fma(sd[3], _t1, sd[4] * _t2))) - sd[12]);
        float _t20 = Math.max(0.0f, Math.abs(Math.fma(sd[8], _t0, Math.fma(sd[6], _t1, sd[7] * _t2))) - sd[13]);
        return (float) Math.sqrt(Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
    }


    /**
     * Get the local {@code X} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getAxisX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the local {@code Y} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getAxisY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = sd[8];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = sd[8];
        return dest;
    }


    /**
     * Get the local {@code Z} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getAxisZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[9];
        dd[1] = sd[10];
        dd[2] = sd[11];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[9];
        dd[1] = sd[10];
        dd[2] = sd[11];
        return dest;
    }


    /**
     * Get the center of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getCenter(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }


    /**
     * Get the half extents of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getHalfSize(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[12];
        dd[1] = sd[13];
        dd[2] = sd[14];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[12];
        dd[1] = sd[13];
        dd[2] = sd[14];
        return dest;
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
        float[] sd = this.data;
        float _t0 = oCZ - sd[2];
        float _t1 = oCX - sd[0];
        float _t2 = oCY - sd[1];
        float _t54 = Math.fma(sd[5], _t0, Math.fma(sd[3], _t1, sd[4] * _t2));
        float _t24 = Math.fma(oUXZ, sd[5], Math.fma(oUXX, sd[3], oUXY * sd[4]));
        float _t45 = 1.0E-5f + Math.abs(_t24);
        float _t25 = Math.fma(oUYZ, sd[5], Math.fma(oUYX, sd[3], oUYY * sd[4]));
        float _t46 = 1.0E-5f + Math.abs(_t25);
        float _t26 = Math.fma(oUZZ, sd[5], Math.fma(oUZX, sd[3], oUZY * sd[4]));
        float _t47 = 1.0E-5f + Math.abs(_t26);
        if (!(Math.abs(_t54) <= Math.fma(oHSX, _t45, Math.fma(oHSY, _t46, Math.fma(oHSZ, _t47, sd[12]))))) return false;
        float _t55 = Math.fma(sd[8], _t0, Math.fma(sd[6], _t1, sd[7] * _t2));
        float _t27 = Math.fma(oUXZ, sd[8], Math.fma(oUXX, sd[6], oUXY * sd[7]));
        float _t48 = 1.0E-5f + Math.abs(_t27);
        float _t28 = Math.fma(oUYZ, sd[8], Math.fma(oUYX, sd[6], oUYY * sd[7]));
        float _t49 = 1.0E-5f + Math.abs(_t28);
        float _t29 = Math.fma(oUZZ, sd[8], Math.fma(oUZX, sd[6], oUZY * sd[7]));
        float _t50 = 1.0E-5f + Math.abs(_t29);
        if (!(Math.abs(_t55) <= Math.fma(oHSX, _t48, Math.fma(oHSY, _t49, Math.fma(oHSZ, _t50, sd[13]))))) return false;
        float _t56 = Math.fma(sd[11], _t0, Math.fma(sd[9], _t1, sd[10] * _t2));
        float _t30 = Math.fma(oUXZ, sd[11], Math.fma(oUXX, sd[9], oUXY * sd[10]));
        float _t51 = 1.0E-5f + Math.abs(_t30);
        float _t31 = Math.fma(oUYZ, sd[11], Math.fma(oUYX, sd[9], oUYY * sd[10]));
        float _t52 = 1.0E-5f + Math.abs(_t31);
        float _t32 = Math.fma(oUZZ, sd[11], Math.fma(oUZX, sd[9], oUZY * sd[10]));
        float _t53 = 1.0E-5f + Math.abs(_t32);
        if (!(Math.abs(_t56) <= Math.fma(oHSX, _t51, Math.fma(oHSY, _t52, Math.fma(oHSZ, _t53, sd[14]))))) return false;
        if (!(Math.abs(Math.fma(_t30, _t56, Math.fma(_t24, _t54, _t27 * _t55))) <= Math.fma(sd[12], _t45, Math.fma(sd[13], _t48, Math.fma(sd[14], _t51, oHSX))))) return false;
        if (!(Math.abs(Math.fma(_t31, _t56, Math.fma(_t25, _t54, _t28 * _t55))) <= Math.fma(sd[12], _t46, Math.fma(sd[13], _t49, Math.fma(sd[14], _t52, oHSY))))) return false;
        if (!(Math.abs(Math.fma(_t32, _t56, Math.fma(_t26, _t54, _t29 * _t55))) <= Math.fma(sd[12], _t47, Math.fma(sd[13], _t50, Math.fma(sd[14], _t53, oHSZ))))) return false;
        if (!(Math.abs(Math.fma(_t27, _t56, -(_t30 * _t55))) <= Math.fma(oHSY, _t47, oHSZ * _t46) + Math.fma(sd[13], _t51, sd[14] * _t48))) return false;
        if (!(Math.abs(Math.fma(_t28, _t56, -(_t31 * _t55))) <= Math.fma(oHSX, _t47, oHSZ * _t45) + Math.fma(sd[13], _t52, sd[14] * _t49))) return false;
        if (!(Math.abs(Math.fma(_t29, _t56, -(_t32 * _t55))) <= Math.fma(oHSX, _t46, oHSY * _t45) + Math.fma(sd[13], _t53, sd[14] * _t50))) return false;
        if (!(Math.abs(Math.fma(_t30, _t54, -(_t24 * _t56))) <= Math.fma(oHSY, _t50, oHSZ * _t49) + Math.fma(sd[12], _t51, sd[14] * _t45))) return false;
        if (!(Math.abs(Math.fma(_t31, _t54, -(_t25 * _t56))) <= Math.fma(oHSX, _t50, oHSZ * _t48) + Math.fma(sd[12], _t52, sd[14] * _t46))) return false;
        if (!(Math.abs(Math.fma(_t32, _t54, -(_t26 * _t56))) <= Math.fma(oHSX, _t49, oHSY * _t48) + Math.fma(sd[12], _t53, sd[14] * _t47))) return false;
        if (!(Math.abs(Math.fma(_t24, _t55, -(_t27 * _t54))) <= Math.fma(oHSY, _t53, oHSZ * _t52) + Math.fma(sd[12], _t48, sd[13] * _t45))) return false;
        if (!(Math.abs(Math.fma(_t25, _t55, -(_t28 * _t54))) <= Math.fma(oHSX, _t53, oHSZ * _t51) + Math.fma(sd[12], _t49, sd[13] * _t46))) return false;
        return Math.abs(Math.fma(_t26, _t55, -(_t29 * _t54))) <= Math.fma(oHSX, _t52, oHSY * _t51) + Math.fma(sd[12], _t50, sd[13] * _t47);
    }


    /**
     * Determine whether this oriented bounding box is valid, i.e. none of its half extents is
     * negative.
     *
     * @return {@code true} if this oriented bounding box is valid, i.e. none of its half extents is
     *        negative, {@code false} otherwise
     */
    public boolean isValid() {
        float[] sd = this.data;
        if (!(sd[12] >= 0.0f)) return false;
        if (!(sd[13] >= 0.0f)) return false;
        return sd[14] >= 0.0f;
    }

    public float cX() { return data[0]; }
    public float cY() { return data[1]; }
    public float cZ() { return data[2]; }
    public float uXx() { return data[3]; }
    public float uXy() { return data[4]; }
    public float uXz() { return data[5]; }
    public float uYx() { return data[6]; }
    public float uYy() { return data[7]; }
    public float uYz() { return data[8]; }
    public float uZx() { return data[9]; }
    public float uZy() { return data[10]; }
    public float uZz() { return data[11]; }
    public float hsX() { return data[12]; }
    public float hsY() { return data[13]; }
    public float hsZ() { return data[14]; }

    @Override public String toString() {
        return "FloatOBB(" + cX() + ", " + cY() + ", " + cZ() + ", " + uXx() + ", " + uXy() + ", " + uXz() + ", " + uYx() + ", " + uYy() + ", " + uYz() + ", " + uZx() + ", " + uZy() + ", " + uZz() + ", " + hsX() + ", " + hsY() + ", " + hsZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatOBBImpl)) return false;
        FloatOBBImpl o = (FloatOBBImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2])
            && Float.isFinite(data[3])
            && Float.isFinite(data[4])
            && Float.isFinite(data[5])
            && Float.isFinite(data[6])
            && Float.isFinite(data[7])
            && Float.isFinite(data[8])
            && Float.isFinite(data[9])
            && Float.isFinite(data[10])
            && Float.isFinite(data[11])
            && Float.isFinite(data[12])
            && Float.isFinite(data[13])
            && Float.isFinite(data[14]);
    }

    @Override public boolean equalsEpsilon(FloatOBBR other, float epsilon) {
        return Math.abs(data[0] - other.cX()) <= epsilon
            && Math.abs(data[1] - other.cY()) <= epsilon
            && Math.abs(data[2] - other.cZ()) <= epsilon
            && Math.abs(data[3] - other.uXx()) <= epsilon
            && Math.abs(data[4] - other.uXy()) <= epsilon
            && Math.abs(data[5] - other.uXz()) <= epsilon
            && Math.abs(data[6] - other.uYx()) <= epsilon
            && Math.abs(data[7] - other.uYy()) <= epsilon
            && Math.abs(data[8] - other.uYz()) <= epsilon
            && Math.abs(data[9] - other.uZx()) <= epsilon
            && Math.abs(data[10] - other.uZy()) <= epsilon
            && Math.abs(data[11] - other.uZz()) <= epsilon
            && Math.abs(data[12] - other.hsX()) <= epsilon
            && Math.abs(data[13] - other.hsY()) <= epsilon
            && Math.abs(data[14] - other.hsZ()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = this.data[6];
        dest[offset + 7] = this.data[7];
        dest[offset + 8] = this.data[8];
        dest[offset + 9] = this.data[9];
        dest[offset + 10] = this.data[10];
        dest[offset + 11] = this.data[11];
        dest[offset + 12] = this.data[12];
        dest[offset + 13] = this.data[13];
        dest[offset + 14] = this.data[14];
        return dest;
    }
    public @Mutated FloatOBB load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        this.data[8] = src[offset + 8];
        this.data[9] = src[offset + 9];
        this.data[10] = src[offset + 10];
        this.data[11] = src[offset + 11];
        this.data[12] = src[offset + 12];
        this.data[13] = src[offset + 13];
        this.data[14] = src[offset + 14];
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

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = this.data[6];
        dest[offset + 7] = this.data[7];
        dest[offset + 8] = this.data[8];
        dest[offset + 9] = this.data[9];
        dest[offset + 10] = this.data[10];
        dest[offset + 11] = this.data[11];
        dest[offset + 12] = this.data[12];
        dest[offset + 13] = this.data[13];
        dest[offset + 14] = this.data[14];
        return dest;
    }
    public @Mutated FloatOBB load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        this.data[4] = (float) src[offset + 4];
        this.data[5] = (float) src[offset + 5];
        this.data[6] = (float) src[offset + 6];
        this.data[7] = (float) src[offset + 7];
        this.data[8] = (float) src[offset + 8];
        this.data[9] = (float) src[offset + 9];
        this.data[10] = (float) src[offset + 10];
        this.data[11] = (float) src[offset + 11];
        this.data[12] = (float) src[offset + 12];
        this.data[13] = (float) src[offset + 13];
        this.data[14] = (float) src[offset + 14];
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

}
