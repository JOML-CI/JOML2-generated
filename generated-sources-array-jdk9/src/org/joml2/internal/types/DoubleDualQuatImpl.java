package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleDualQuat} backed by a {@code double[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleDualQuatImpl implements DoubleDualQuat {

    public double[] data;
    static final DoubleDualQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleDualQuatBbOpsUnsafe()
                    : new DoubleDualQuatBbOpsApi();
    static final DoubleDualQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleDualQuatRawOpsUnsafe()
                    : new DoubleDualQuatRawOpsApi();

    public DoubleDualQuatImpl() {
        data = new double[8];
        data[3] = 1;
    }


    /**
     * Add {@code other} to this dual quaternion and store the result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat add(DoubleDualQuatR other, @Mutated DoubleDualQuat dest) {
        return add(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) to this dual quaternion and store the
     * result in {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat add(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = otherRX + sd[0];
        dd[1] = otherRY + sd[1];
        dd[2] = otherRZ + sd[2];
        dd[3] = otherRW + sd[3];
        dd[4] = otherDX + sd[4];
        dd[5] = otherDY + sd[5];
        dd[6] = otherDZ + sd[6];
        dd[7] = otherDW + sd[7];
        return dest;
    }


    /**
     * Multiply each component of this dual quaternion by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(double scalar, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = scalar * sd[0];
        dd[1] = scalar * sd[1];
        dd[2] = scalar * sd[2];
        dd[3] = scalar * sd[3];
        dd[4] = scalar * sd[4];
        dd[5] = scalar * sd[5];
        dd[6] = scalar * sd[6];
        dd[7] = scalar * sd[7];
        return dest;
    }


    /**
     * Negate this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat negate(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        return dest;
    }


    /**
     * Subtract {@code other} from this dual quaternion and store the result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sub(DoubleDualQuatR other, @Mutated DoubleDualQuat dest) {
        return sub(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Subtract ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) from this dual quaternion
     * and store the result in {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sub(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = sd[0] - otherRX;
        dd[1] = sd[1] - otherRY;
        dd[2] = sd[2] - otherRZ;
        dd[3] = sd[3] - otherRW;
        dd[4] = sd[4] - otherDX;
        dd[5] = sd[5] - otherDY;
        dd[6] = sd[6] - otherDZ;
        dd[7] = sd[7] - otherDW;
        return dest;
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param v the dual quaternion
     * @return this
     */
    public @Mutated DoubleDualQuat set(DoubleDualQuatR v) {
        return set(v.rX(), v.rY(), v.rZ(), v.rW(), v.dX(), v.dY(), v.dZ(), v.dW());
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param vRX the {@code rX} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vRY the {@code rY} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vRZ the {@code rZ} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vRW the {@code rW} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vDX the {@code dX} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vDY the {@code dY} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vDZ the {@code dZ} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @param vDW the {@code dW} component of the dual quaternion
     *        {@code (vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW)}
     * @return this
     */
    @Mutated public DoubleDualQuat set(double vRX, double vRY, double vRZ, double vRW, double vDX, double vDY, double vDZ, double vDW) {
        double[] dd = this.data;
        dd[0] = vRX;
        dd[1] = vRY;
        dd[2] = vRZ;
        dd[3] = vRW;
        dd[4] = vDX;
        dd[5] = vDY;
        dd[6] = vDZ;
        dd[7] = vDW;
        return this;
    }


    /**
     * Convert this dual quaternion to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat toFloat(@Mutated FloatDualQuat dest) {
        double[] sd = this.data;
        float[] dd = ((FloatDualQuatImpl) dest).data;
        dd[0] = (float) (sd[0]);
        dd[1] = (float) (sd[1]);
        dd[2] = (float) (sd[2]);
        dd[3] = (float) (sd[3]);
        dd[4] = (float) (sd[4]);
        dd[5] = (float) (sd[5]);
        dd[6] = (float) (sd[6]);
        dd[7] = (float) (sd[7]);
        return dest;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param r the rigid transform
     * @return this
     */
    public @Mutated DoubleDualQuat makeFromRigid(DoubleRigidR r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param rTX the {@code tX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTY the {@code tY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTZ the {@code tZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRX the {@code rX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRY the {@code rY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRZ the {@code rZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRW the {@code rW} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @return this
     */
    @Mutated public DoubleDualQuat makeFromRigid(double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        double[] dd = this.data;
        double _t0 = -rTZ;
        dd[0] = rRX;
        dd[1] = rRY;
        dd[2] = rRZ;
        dd[3] = rRW;
        dd[4] = 0.5 * Math.fma(_t0, rRY, Math.fma(rTX, rRW, rTY * rRZ));
        dd[5] = 0.5 * Math.fma(rTZ, rRX, Math.fma(rTY, rRW, -(rTX * rRZ)));
        dd[6] = 0.5 * Math.fma(rTZ, rRW, Math.fma(rTX, rRY, -(rTY * rRX)));
        dd[7] = 0.5 * Math.fma(_t0, rRZ, Math.fma(-rTY, rRY, -(rTX * rRX)));
        return this;
    }


    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
     *
     * @param t the transform
     * @return this
     */
    public @Mutated DoubleDualQuat makeFromTransform(DoubleTransformR t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
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
    @Mutated public DoubleDualQuat makeFromTransform(double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double[] dd = this.data;
        double _t0 = -tTZ;
        dd[0] = tRX;
        dd[1] = tRY;
        dd[2] = tRZ;
        dd[3] = tRW;
        dd[4] = 0.5 * Math.fma(_t0, tRY, Math.fma(tTX, tRW, tTY * tRZ));
        dd[5] = 0.5 * Math.fma(tTZ, tRX, Math.fma(tTY, tRW, -(tTX * tRZ)));
        dd[6] = 0.5 * Math.fma(tTZ, tRW, Math.fma(tTX, tRY, -(tTY * tRX)));
        dd[7] = 0.5 * Math.fma(_t0, tRZ, Math.fma(-tTY, tRY, -(tTX * tRX)));
        return this;
    }


    /**
     * Convert this unit dual quaternion to a rigid transform (an exact conversion - both represent
     * rotation plus translation) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleRigidImpl) dest).data;
        double _buf0 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        double _buf1 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        double _buf2 = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        double _buf3 = sd[0];
        dd[4] = sd[1];
        dd[5] = sd[2];
        dd[6] = sd[3];
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        return dest;
    }


    /**
     * Convert this unit dual quaternion to a TRS transform (translation and rotation from the rigid
     * motion, scale = 1) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleTransformImpl) dest).data;
        double _buf0 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        double _buf1 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        double _buf2 = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        double _buf3 = sd[0];
        dd[4] = sd[1];
        dd[5] = sd[2];
        dd[6] = sd[3];
        dd[7] = 1.0;
        dd[8] = 1.0;
        dd[9] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        return dest;
    }


    /**
     * Determine whether the real (rotation) part of this dual quaternion has unit length.
     *
     * @param epsilon the maximum allowed deviation of the squared real-part length from {@code 1}
     * @return {@code true} if the real (rotation) part of this dual quaternion has unit length,
     *        {@code false} otherwise
     */
    public boolean isUnit(double epsilon) {
        double[] sd = this.data;
        return Math.abs(Math.fma(sd[0], sd[0], Math.fma(sd[1], sd[1], Math.fma(sd[2], sd[2], Math.fma(sd[3], sd[3], -1.0))))) <= epsilon;
    }


    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    public @Mutated DoubleDualQuat makeFromAxisAngle(Double3R axis, double angle, Double3R translation) {
        return makeFromAxisAngle(axis.x(), axis.y(), axis.z(), angle, translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * ({@code axisX}, {@code axisY}, {@code axisZ}), combined with a translation by
     * ({@code translationX}, {@code translationY}, {@code translationZ}).
     *
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param angle the angle in radians
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public DoubleDualQuat makeFromAxisAngle(double axisX, double axisY, double axisZ, double angle, double translationX, double translationY, double translationZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = -translationZ;
        double _t2 = Math.sin(_t0);
        double _t3 = Math.cos(_t0);
        double _t4 = axisX * _t2;
        double _t5 = axisY * _t2;
        double _t6 = axisZ * _t2;
        dd[0] = _t4;
        dd[1] = _t5;
        dd[2] = _t6;
        dd[3] = _t3;
        dd[4] = 0.5 * Math.fma(_t1, _t5, Math.fma(translationX, _t3, translationY * _t6));
        dd[5] = 0.5 * Math.fma(translationZ, _t4, Math.fma(translationY, _t3, -(translationX * _t6)));
        dd[6] = 0.5 * Math.fma(translationZ, _t3, Math.fma(translationX, _t5, -(translationY * _t4)));
        dd[7] = 0.5 * Math.fma(_t1, _t6, Math.fma(-translationY, _t5, -(translationX * _t4)));
        return this;
    }


    /**
     * Set this dual quaternion to the identity.
     *
     * @return this
     */
    @Mutated public DoubleDualQuat makeIdentity() {
        double[] dd = this.data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    public @Mutated DoubleDualQuat makeTranslationRotation(Double3R translation, DoubleQuatR rotation) {
        return makeTranslationRotation(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this dual quaternion to a rigid transformation that first rotates by ({@code rotationX},
     * {@code rotationY}, {@code rotationZ}, {@code rotationW}) and then translates by
     * ({@code translationX}, {@code translationY}, {@code translationZ}) ({@code T * R}).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return this
     */
    @Mutated public DoubleDualQuat makeTranslationRotation(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW) {
        double[] dd = this.data;
        double _t0 = -rotationY;
        dd[0] = rotationX;
        dd[1] = rotationY;
        dd[2] = rotationZ;
        dd[3] = rotationW;
        dd[4] = 0.5 * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX));
        dd[5] = 0.5 * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX)));
        dd[6] = 0.5 * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY)));
        dd[7] = 0.5 * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX)));
        return this;
    }


    /**
     * Set all components of this dual quaternion to zero.
     *
     * @return this
     */
    @Mutated public DoubleDualQuat makeZero() {
        double[] dd = this.data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 0.0;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    public @Mutated DoubleDualQuat set(DoubleQuatR rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return this
     */
    @Mutated public DoubleDualQuat set(double rotationX, double rotationY, double rotationZ, double rotationW) {
        double[] dd = this.data;
        dd[0] = rotationX;
        dd[1] = rotationY;
        dd[2] = rotationZ;
        dd[3] = rotationW;
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @param translation the vector
     * @return this
     */
    public @Mutated DoubleDualQuat set(DoubleQuatR rotation, Double3R translation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w(), translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public DoubleDualQuat set(double rotationX, double rotationY, double rotationZ, double rotationW, double translationX, double translationY, double translationZ) {
        double[] dd = this.data;
        double _t0 = -rotationY;
        dd[0] = rotationX;
        dd[1] = rotationY;
        dd[2] = rotationZ;
        dd[3] = rotationW;
        dd[4] = 0.5 * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX));
        dd[5] = 0.5 * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX)));
        dd[6] = 0.5 * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY)));
        dd[7] = 0.5 * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX)));
        return this;
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param translation the vector
     * @return this
     */
    public @Mutated DoubleDualQuat set(Double3R translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public DoubleDualQuat set(double translationX, double translationY, double translationZ) {
        double[] dd = this.data;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
        dd[4] = 0.5 * translationX;
        dd[5] = 0.5 * translationY;
        dd[6] = 0.5 * translationZ;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t} and store the result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat dlb(DoubleDualQuatR other, double t, @Mutated DoubleDualQuat dest) {
        return dlb(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Blend this dual quaternion with ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) using
     * dual-quaternion linear blending with the weight {@code t} and store the result in
     * {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat dlb(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, double t, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t9 = Math.fma(otherRX, sd[0], otherRY * sd[1]) + Math.fma(otherRZ, sd[2], otherRW * sd[3]) < 0.0 ? -1.0 : 1.0;
        double _t14 = Math.fma(t, Math.fma(otherRX, _t9, -sd[0]), sd[0]);
        double _t15 = Math.fma(t, Math.fma(otherRY, _t9, -sd[1]), sd[1]);
        double _t16 = Math.fma(t, Math.fma(otherRZ, _t9, -sd[2]), sd[2]);
        double _t17 = Math.fma(t, Math.fma(otherRW, _t9, -sd[3]), sd[3]);
        double _t23 = (1.0 / Math.sqrt(Math.fma(_t14, _t14, _t15 * _t15) + Math.fma(_t16, _t16, _t17 * _t17)));
        dd[0] = _t14 * _t23;
        dd[1] = _t15 * _t23;
        dd[2] = _t16 * _t23;
        dd[3] = _t17 * _t23;
        dd[4] = Math.fma(t, Math.fma(otherDX, _t9, -sd[4]), sd[4]) * _t23;
        dd[5] = Math.fma(t, Math.fma(otherDY, _t9, -sd[5]), sd[5]) * _t23;
        dd[6] = Math.fma(t, Math.fma(otherDZ, _t9, -sd[6]), sd[6]) * _t23;
        dd[7] = Math.fma(t, Math.fma(otherDW, _t9, -sd[7]), sd[7]) * _t23;
        return dest;
    }


    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t} and store the result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat lerp(DoubleDualQuatR other, double t, @Mutated DoubleDualQuat dest) {
        return lerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Linearly interpolate between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat lerp(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, double t, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = Math.fma(t, otherRX - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherRY - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherRZ - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherRW - sd[3], sd[3]);
        dd[4] = Math.fma(t, otherDX - sd[4], sd[4]);
        dd[5] = Math.fma(t, otherDY - sd[5], sd[5]);
        dd[6] = Math.fma(t, otherDZ - sd[6], sd[6]);
        dd[7] = Math.fma(t, otherDW - sd[7], sd[7]);
        return dest;
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sclerp(DoubleDualQuatR other, double t, @Mutated DoubleDualQuat dest) {
        return sclerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) using the interpolation factor {@code t}
     * and store the result in {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        dual quaternion must have unit length)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sclerp(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, double t, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -sd[2];
        double _t1 = -sd[6];
        double _t8 = Math.fma(otherRX, sd[0], otherRY * sd[1]) + Math.fma(otherRZ, sd[2], otherRW * sd[3]) < 0.0 ? -1.0 : 1.0;
        double _t9 = otherRX * _t8;
        double _t10 = otherRW * _t8;
        double _t11 = otherRZ * _t8;
        double _t12 = otherRY * _t8;
        double _t13 = otherDX * _t8;
        double _t14 = otherDW * _t8;
        double _t15 = otherDY * _t8;
        double _t16 = otherDZ * _t8;
        double _t49 = -(sd[4] * _t10);
        double _t53 = -(sd[4] * _t12);
        double _t64 = Math.fma(sd[4], _t11, sd[7] * _t12);
        double _t71 = Math.fma(sd[6], _t12, -(sd[5] * _t11));
        double _t75 = Math.fma(sd[5], _t9, -(sd[6] * _t10));
        double _t81 = Math.fma(sd[2], _t11, Math.fma(sd[1], _t12, Math.fma(sd[0], _t9, sd[3] * _t10)));
        double _t84 = Math.fma(sd[1], _t9, -(sd[2] * _t10)) + Math.fma(sd[3], _t11, -(sd[0] * _t12));
        double _t85 = Math.fma(sd[0], _t11, sd[3] * _t12) + Math.fma(_t0, _t9, -(sd[1] * _t10));
        double _t86 = Math.fma(sd[2], _t12, -(sd[1] * _t11)) + Math.fma(sd[3], _t9, -(sd[0] * _t10));
        double _t87 = Math.fma(sd[2], _t15, -(sd[1] * _t16)) + Math.fma(sd[3], _t13, -(sd[0] * _t14));
        double _t89 = Math.fma(sd[1], _t13, -(sd[2] * _t14)) + Math.fma(sd[3], _t16, -(sd[0] * _t15));
        double _t91 = Math.fma(sd[0], _t16, sd[3] * _t15) + Math.fma(_t0, _t13, -(sd[1] * _t14));
        double _t93 = Math.fma(sd[0], _t13, sd[3] * _t14) + Math.fma(sd[1], _t15, sd[2] * _t16) + (Math.fma(sd[4], _t9, sd[7] * _t10) + Math.fma(sd[5], _t12, sd[6] * _t11));
        double _t99 = t * (_t87 + (_t71 + Math.fma(sd[7], _t9, _t49)));
        double _t100 = t * (_t89 + (_t75 + Math.fma(sd[7], _t11, _t53)));
        double _t101 = t * (_t91 + (_t64 + Math.fma(_t1, _t9, -(sd[5] * _t10))));
        double _t109 = Math.fma(_t84, _t84, Math.fma(_t85, _t85, _t86 * _t86));
        double _t111 = (1.0 / Math.sqrt(_t109));
        double _t113 = t * Math.atan2(Math.sqrt(_t109), _t81);
        double _t114 = Math.cos(_t113);
        double _t115 = _t86 * _t111;
        double _t116 = Math.sin(_t113);
        double _t117 = _t84 * _t111;
        double _t118 = _t85 * _t111;
        double _t119 = _t93 * _t111;
        double _t120 = t * _t119;
        double _t121 = _t81 * _t119;
        double _t122, _t140, _t141, _t142, _t149;
        if (_t109 < 1.0e-12f) {
            _t122 = 1.0;
            _t140 = 0.0;
            _t141 = 0.0;
            _t142 = 0.0;
            _t149 = t * _t93;
        } else {
            _t122 = _t114;
            _t140 = _t115 * _t116;
            _t141 = _t117 * _t116;
            _t142 = _t118 * _t116;
            _t149 = _t120 * _t116;
        }
        double _t127 = _t120 * _t114;
        double _t156, _t157, _t158;
        if (_t109 < 1.0e-12f) {
            if (_t81 < 0.0) {
                _t156 = -_t99;
                _t157 = -_t100;
                _t158 = -_t101;
            } else {
                _t156 = _t99;
                _t157 = _t100;
                _t158 = _t101;
            }
        } else {
            _t156 = Math.fma((_t87 + (_t71 + Math.fma(sd[7], _t9, Math.fma(_t121, _t115, _t49)))) * _t111, _t116, -(_t115 * _t127));
            _t157 = Math.fma((_t89 + (_t75 + Math.fma(sd[7], _t11, Math.fma(_t121, _t117, _t53)))) * _t111, _t116, -(_t117 * _t127));
            _t158 = Math.fma((_t91 + (_t64 + Math.fma(-sd[5], _t10, Math.fma(_t121, _t118, -(sd[6] * _t9))))) * _t111, _t116, -(_t118 * _t127));
        }
        double _buf0 = Math.fma(sd[0], _t122, sd[3] * _t140) + Math.fma(sd[1], _t141, -(sd[2] * _t142));
        double _buf1 = Math.fma(sd[1], _t122, sd[2] * _t140) + Math.fma(sd[3], _t142, -(sd[0] * _t141));
        double _buf2 = Math.fma(sd[0], _t142, sd[3] * _t141) + Math.fma(sd[2], _t122, -(sd[1] * _t140));
        double _buf3 = Math.fma(_t0, _t141, Math.fma(-sd[1], _t142, Math.fma(sd[3], _t122, -(sd[0] * _t140))));
        double _buf4 = Math.fma(sd[0], _t149, sd[3] * _t156) + Math.fma(sd[1], _t157, -(sd[2] * _t158)) + (Math.fma(sd[4], _t122, sd[7] * _t140) + Math.fma(sd[5], _t141, -(sd[6] * _t142)));
        double _buf5 = Math.fma(sd[1], _t149, sd[2] * _t156) + Math.fma(sd[3], _t158, -(sd[0] * _t157)) + (Math.fma(sd[5], _t122, sd[6] * _t140) + Math.fma(sd[7], _t142, -(sd[4] * _t141)));
        dd[6] = Math.fma(sd[0], _t158, sd[3] * _t157) + Math.fma(sd[2], _t149, -(sd[1] * _t156)) + (Math.fma(sd[4], _t142, sd[7] * _t141) + Math.fma(sd[6], _t122, -(sd[5] * _t140)));
        dd[7] = Math.fma(sd[3], _t149, -(sd[0] * _t156)) + Math.fma(_t0, _t157, -(sd[1] * _t158)) + (Math.fma(sd[7], _t122, -(sd[4] * _t140)) + Math.fma(_t1, _t141, -(sd[5] * _t142)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        return dest;
    }


    /**
     * Multiply this dual quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(DoubleDualQuatR other, @Mutated DoubleDualQuat dest) {
        return mul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Multiply this dual quaternion by ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -otherRZ;
        double _buf0 = Math.fma(otherRX, sd[3], otherRW * sd[0]) + Math.fma(otherRZ, sd[1], -(otherRY * sd[2]));
        double _buf1 = Math.fma(otherRX, sd[2], otherRW * sd[1]) + Math.fma(otherRY, sd[3], -(otherRZ * sd[0]));
        double _buf2 = Math.fma(otherRY, sd[0], otherRZ * sd[3]) + Math.fma(otherRW, sd[2], -(otherRX * sd[1]));
        double _buf3 = Math.fma(_t0, sd[2], Math.fma(-otherRY, sd[1], Math.fma(otherRW, sd[3], -(otherRX * sd[0]))));
        double _buf4 = Math.fma(otherRX, sd[7], otherRW * sd[4]) + Math.fma(otherRZ, sd[5], -(otherRY * sd[6])) + (Math.fma(otherDX, sd[3], otherDW * sd[0]) + Math.fma(otherDZ, sd[1], -(otherDY * sd[2])));
        double _buf5 = Math.fma(otherRX, sd[6], otherRW * sd[5]) + Math.fma(otherRY, sd[7], -(otherRZ * sd[4])) + (Math.fma(otherDX, sd[2], otherDW * sd[1]) + Math.fma(otherDY, sd[3], -(otherDZ * sd[0])));
        double _buf6 = Math.fma(otherRY, sd[4], otherRZ * sd[7]) + Math.fma(otherRW, sd[6], -(otherRX * sd[5])) + (Math.fma(otherDY, sd[0], otherDZ * sd[3]) + Math.fma(otherDW, sd[2], -(otherDX * sd[1])));
        dd[7] = Math.fma(otherRW, sd[7], -(otherRX * sd[4])) + Math.fma(_t0, sd[6], -(otherRY * sd[5])) + (Math.fma(otherDW, sd[3], -(otherDX * sd[0])) + Math.fma(-otherDZ, sd[2], -(otherDY * sd[1])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        return dest;
    }


    /**
     * Pre-multiply {@code other} onto this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat preMul(DoubleDualQuatR other, @Mutated DoubleDualQuat dest) {
        return preMul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Pre-multiply ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) onto this dual quaternion
     * and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat preMul(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -otherRZ;
        double _buf0 = Math.fma(otherRX, sd[3], otherRW * sd[0]) + Math.fma(otherRY, sd[2], -(otherRZ * sd[1]));
        double _buf1 = Math.fma(otherRY, sd[3], otherRZ * sd[0]) + Math.fma(otherRW, sd[1], -(otherRX * sd[2]));
        double _buf2 = Math.fma(otherRX, sd[1], otherRW * sd[2]) + Math.fma(otherRZ, sd[3], -(otherRY * sd[0]));
        double _buf3 = Math.fma(_t0, sd[2], Math.fma(-otherRY, sd[1], Math.fma(otherRW, sd[3], -(otherRX * sd[0]))));
        double _buf4 = Math.fma(otherRX, sd[7], otherRW * sd[4]) + Math.fma(otherRY, sd[6], -(otherRZ * sd[5])) + (Math.fma(otherDX, sd[3], otherDW * sd[0]) + Math.fma(otherDY, sd[2], -(otherDZ * sd[1])));
        double _buf5 = Math.fma(otherRY, sd[7], otherRZ * sd[4]) + Math.fma(otherRW, sd[5], -(otherRX * sd[6])) + (Math.fma(otherDY, sd[3], otherDZ * sd[0]) + Math.fma(otherDW, sd[1], -(otherDX * sd[2])));
        double _buf6 = Math.fma(otherRX, sd[5], otherRW * sd[6]) + Math.fma(otherRZ, sd[7], -(otherRY * sd[4])) + (Math.fma(otherDX, sd[1], otherDW * sd[2]) + Math.fma(otherDZ, sd[3], -(otherDY * sd[0])));
        dd[7] = Math.fma(otherRW, sd[7], -(otherRX * sd[4])) + Math.fma(_t0, sd[6], -(otherRY * sd[5])) + (Math.fma(otherDW, sd[3], -(otherDX * sd[0])) + Math.fma(-otherDZ, sd[2], -(otherDY * sd[1])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        return dest;
    }


    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param other the other dual quaternion
     * @param weight the factor to scale {@code other} by before adding
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat addScaled(DoubleDualQuatR other, double weight, @Mutated DoubleDualQuat dest) {
        return addScaled(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), weight, dest);
    }


    /**
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) scaled by {@code weight} to this dual
     * quaternion and store the result in {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param weight the factor to scale ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     *        {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW})
     *        by before adding
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat addScaled(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, double weight, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = Math.fma(weight, otherRX, sd[0]);
        dd[1] = Math.fma(weight, otherRY, sd[1]);
        dd[2] = Math.fma(weight, otherRZ, sd[2]);
        dd[3] = Math.fma(weight, otherRW, sd[3]);
        dd[4] = Math.fma(weight, otherDX, sd[4]);
        dd[5] = Math.fma(weight, otherDY, sd[5]);
        dd[6] = Math.fma(weight, otherDZ, sd[6]);
        dd[7] = Math.fma(weight, otherDW, sd[7]);
        return dest;
    }


    /**
     * Compute the quaternion conjugate of this dual quaternion, conjugating both the real and the
     * dual part (for a unit dual quaternion this is its inverse) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat conjugate(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = -sd[6];
        dd[7] = sd[7];
        return dest;
    }


    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat difference(DoubleDualQuatR other, @Mutated DoubleDualQuat dest) {
        return difference(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Compute the difference between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}), i.e. the rigid transformation that, applied after {@code this}, results in
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) and store the result in {@code dest}.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat difference(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -otherRX;
        double _buf0 = Math.fma(otherRX, sd[3], -(otherRW * sd[0])) + Math.fma(otherRY, sd[2], -(otherRZ * sd[1]));
        double _buf1 = Math.fma(otherRY, sd[3], otherRZ * sd[0]) + Math.fma(_t0, sd[2], -(otherRW * sd[1]));
        double _buf2 = Math.fma(otherRX, sd[1], -(otherRW * sd[2])) + Math.fma(otherRZ, sd[3], -(otherRY * sd[0]));
        double _buf3 = Math.fma(otherRZ, sd[2], Math.fma(otherRY, sd[1], Math.fma(otherRX, sd[0], otherRW * sd[3])));
        double _buf4 = Math.fma(otherRX, sd[7], -(otherRW * sd[4])) + Math.fma(otherRY, sd[6], -(otherRZ * sd[5])) + (Math.fma(otherDX, sd[3], -(otherDW * sd[0])) + Math.fma(otherDY, sd[2], -(otherDZ * sd[1])));
        double _buf5 = Math.fma(otherRY, sd[7], otherRZ * sd[4]) + Math.fma(_t0, sd[6], -(otherRW * sd[5])) + (Math.fma(otherDY, sd[3], otherDZ * sd[0]) + Math.fma(-otherDX, sd[2], -(otherDW * sd[1])));
        double _buf6 = Math.fma(otherRX, sd[5], -(otherRW * sd[6])) + Math.fma(otherRZ, sd[7], -(otherRY * sd[4])) + (Math.fma(otherDX, sd[1], -(otherDW * sd[2])) + Math.fma(otherDZ, sd[3], -(otherDY * sd[0])));
        dd[7] = Math.fma(otherRX, sd[4], otherRW * sd[7]) + Math.fma(otherRY, sd[5], otherRZ * sd[6]) + (Math.fma(otherDX, sd[0], otherDW * sd[3]) + Math.fma(otherDY, sd[1], otherDZ * sd[2]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        return dest;
    }


    /**
     * Compute the dot product of this dual quaternion and {@code other}.
     *
     * @param other the other dual quaternion
     * @return the dot product of this dual quaternion and {@code other}
     */
    public double dot(DoubleDualQuatR other) {
        return dot(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }


    /**
     * Compute the dot product of this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}).
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDX the {@code dX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDY the {@code dY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDZ the {@code dZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @param otherDW the {@code dW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * @return the dot product of this dual quaternion and ({@code otherRX}, {@code otherRY},
     *        {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     *        {@code otherDW})
     */
    public double dot(double otherRX, double otherRY, double otherRZ, double otherRW, double otherDX, double otherDY, double otherDZ, double otherDW) {
        double[] sd = this.data;
        return Math.fma(otherRX, sd[0], otherRY * sd[1]) + Math.fma(otherRZ, sd[2], otherRW * sd[3]) + (Math.fma(otherDX, sd[4], otherDY * sd[5]) + Math.fma(otherDZ, sd[6], otherDW * sd[7]));
    }


    /**
     * Compute the dual-number conjugate of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat dualConjugate(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = -sd[4];
        dd[5] = -sd[5];
        dd[6] = -sd[6];
        dd[7] = -sd[7];
        return dest;
    }


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat exp(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t4 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t6 = (1.0 / Math.sqrt(_t4));
        double _t7 = Math.sqrt(_t4);
        double _t8 = Math.sin(_t7);
        double _t9 = Math.cos(_t7);
        double _t10 = sd[0] * _t6;
        double _t11 = sd[1] * _t6;
        double _t12 = sd[2] * _t6;
        double _t13 = Math.fma(sd[2], sd[6], Math.fma(sd[0], sd[4], sd[1] * sd[5])) * _t6;
        double _t14 = _t13 * _t9;
        if (_t4 < 1.0e-12f) {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 1.0;
            dd[4] = sd[4];
            dd[5] = sd[5];
            dd[6] = sd[6];
            dd[7] = 0.0;
        } else {
            dd[0] = _t10 * _t8;
            dd[1] = _t11 * _t8;
            dd[2] = _t12 * _t8;
            dd[3] = _t9;
            dd[4] = Math.fma(_t10, _t14, Math.fma(-_t10, _t13, sd[4]) * _t6 * _t8);
            dd[5] = Math.fma(_t11, _t14, Math.fma(-_t11, _t13, sd[5]) * _t6 * _t8);
            dd[6] = Math.fma(_t12, _t14, Math.fma(-_t12, _t13, sd[6]) * _t6 * _t8);
            dd[7] = -(_t13 * _t8);
        }
        return dest;
    }


    /**
     * Get the dual part of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getDual(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = sd[4];
        dd[1] = sd[5];
        dd[2] = sd[6];
        dd[3] = sd[7];
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Y and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = sd[1] * sd[2];
        double _t3 = sd[2] * sd[2];
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], _t1), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t3), 1.0));
            dd[2] = 0.0;
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t9, _t10);
            dd[2] = Math.atan2(2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t3), 1.0));
            dd[0] = _buf0;
        }
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Z and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t1 = sd[1] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], _t1);
        double _t8 = 2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], -_t1), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[1] = 0.0;
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t7, _t9);
            dd[1] = Math.atan2(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0));
            dd[0] = _buf0;
        }
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, X and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t3 = sd[2] * sd[2];
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], -(sd[1] * sd[2]));
        double _t10 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t3), 1.0));
            dd[2] = 0.0;
            dd[1] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t8, _t10);
            dd[2] = Math.atan2(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t3), 1.0));
            dd[1] = _buf0;
        }
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t9)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, Z and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[1] = Math.atan2(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], -(sd[1] * sd[2])), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0));
            dd[1] = Math.atan2(_t8, _t9);
            dd[0] = _buf0;
        }
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, X and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t1), 1.0));
            dd[1] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[2] = Math.atan2(_t8, _t9);
            dd[1] = _buf0;
        }
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, Y and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0));
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[2] = Math.atan2(_t7, _t9);
            dd[0] = _buf0;
        }
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }


    /**
     * Get the rotation of this dual quaternion, i.e. its raw real part (a unit quaternion only when
     * this dual quaternion has unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getRotation(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Get the translation of this dual quaternion, i.e. {@code 2 * dual * conj(real)} (the actual
     * translation only when this dual quaternion has unit length) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getTranslation(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        double _buf1 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        dd[2] = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Compute the inverse of this dual quaternion, which is assumed to have unit length and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat inverseUnit(@Mutated DoubleDualQuat dest) {
        return conjugate(dest);
    }


    /**
     * Invert this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat invert(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t8 = Math.fma(sd[0], sd[0], sd[1] * sd[1]) + Math.fma(sd[2], sd[2], sd[3] * sd[3]);
        double _t8_inv = 1.0 / _t8;
        double _t10 = 2.0 * (Math.fma(sd[0], sd[4], sd[1] * sd[5]) + Math.fma(sd[2], sd[6], sd[3] * sd[7]));
        double _t11 = _t8 * _t8;
        double _t11_inv = 1.0 / _t11;
        double _buf0 = -(sd[0] * _t8_inv);
        double _buf1 = -(sd[1] * _t8_inv);
        double _buf2 = -(sd[2] * _t8_inv);
        double _buf3 = sd[3] * _t8_inv;
        dd[4] = sd[0] * _t10 * _t11_inv - sd[4] * _t8_inv;
        dd[5] = sd[1] * _t10 * _t11_inv - sd[5] * _t8_inv;
        dd[6] = sd[2] * _t10 * _t11_inv - sd[6] * _t8_inv;
        dd[7] = sd[7] * _t8_inv - sd[3] * _t10 * _t11_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        return dest;
    }


    /**
     * Compute the length of this dual quaternion's real (rotation) part.
     *
     * @return the length of this dual quaternion's real (rotation) part
     */
    public double length() {
        double[] sd = this.data;
        return Math.sqrt(Math.fma(sd[0], sd[0], sd[1] * sd[1]) + Math.fma(sd[2], sd[2], sd[3] * sd[3]));
    }


    /**
     * Compute the squared length of this dual quaternion's real (rotation) part.
     *
     * @return the squared length of this dual quaternion's real (rotation) part
     */
    public double lengthSquared() {
        double[] sd = this.data;
        return Math.fma(sd[0], sd[0], sd[1] * sd[1]) + Math.fma(sd[2], sd[2], sd[3] * sd[3]);
    }


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat log(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t5 = sd[0] * _t3;
        double _t6 = Math.atan2(Math.sqrt(_t2), sd[3]);
        double _t7 = sd[1] * _t3;
        double _t8 = sd[2] * _t3;
        double _t9 = sd[7] * _t3;
        double _t10 = sd[3] * _t9;
        if (_t2 < 1.0e-12f) {
            if (sd[3] < 0.0) {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                dd[4] = -sd[4];
                dd[5] = -sd[5];
                dd[6] = -sd[6];
            } else {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                dd[4] = sd[4];
                dd[5] = sd[5];
                dd[6] = sd[6];
            }
        } else {
            dd[0] = _t5 * _t6;
            dd[1] = _t7 * _t6;
            dd[2] = _t8 * _t6;
            dd[4] = Math.fma(Math.fma(_t5, _t10, sd[4]) * _t3, _t6, -(_t5 * _t9));
            dd[5] = Math.fma(Math.fma(_t7, _t10, sd[5]) * _t3, _t6, -(_t7 * _t9));
            dd[6] = Math.fma(Math.fma(_t8, _t10, sd[6]) * _t3, _t6, -(_t8 * _t9));
        }
        dd[3] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleDualQuat makeFromMatrix(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double _t0 = -mData[14];
        double _t2 = 1.0 - mData[0];
        double _t4 = mData[6] - mData[9];
        double _t5 = Math.max(mData[5], mData[10]);
        double _t6 = mData[4] + mData[1];
        double _t7 = mData[8] + mData[2];
        double _t8 = mData[8] - mData[2];
        double _t9 = mData[9] + mData[6];
        double _t10 = mData[1] - mData[4];
        double _t14 = mData[10] + (mData[0] + mData[5]);
        double _t15 = 1.0 + _t14;
        double _t16 = mData[0] + (1.0 - mData[5] - mData[10]);
        double _t17 = mData[5] + (_t2 - mData[10]);
        double _t18 = mData[10] + (_t2 - mData[5]);
        double _t19 = (1.0 / Math.sqrt(_t15));
        double _t21 = (1.0 / Math.sqrt(_t17));
        double _t22 = (1.0 / Math.sqrt(_t18));
        double _t23 = (1.0 / Math.sqrt(_t16));
        double _t63, _t64, _t65, _t66;
        if (_t14 > 0.0) {
            _t63 = 0.5 * _t4 * _t19;
            _t64 = 0.5 * _t8 * _t19;
            _t65 = 0.5 * _t10 * _t19;
            _t66 = 0.5 * Math.sqrt(_t15);
        } else {
            if (mData[0] > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (mData[5] > mData[10]) {
                    _t63 = 0.5 * _t6 * _t21;
                    _t64 = 0.5 * Math.sqrt(_t17);
                    _t65 = 0.5 * _t9 * _t21;
                    _t66 = 0.5 * _t8 * _t21;
                } else {
                    _t63 = 0.5 * _t7 * _t22;
                    _t64 = 0.5 * _t9 * _t22;
                    _t65 = 0.5 * Math.sqrt(_t18);
                    _t66 = 0.5 * _t10 * _t22;
                }
            }
        }
        dd[0] = _t63;
        dd[1] = _t64;
        dd[2] = _t65;
        dd[3] = _t66;
        dd[4] = 0.5 * Math.fma(_t0, _t64, Math.fma(mData[12], _t66, mData[13] * _t65));
        dd[5] = 0.5 * Math.fma(mData[14], _t63, Math.fma(mData[13], _t66, -(mData[12] * _t65)));
        dd[6] = 0.5 * Math.fma(mData[14], _t66, Math.fma(mData[12], _t64, -(mData[13] * _t63)));
        dd[7] = 0.5 * Math.fma(_t0, _t65, Math.fma(-mData[13], _t64, -(mData[12] * _t63)));
        return this;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleDualQuat makeFromMatrix(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double _t0 = -mData[11];
        double _t2 = 1.0 - mData[0];
        double _t4 = mData[9] - mData[6];
        double _t5 = Math.max(mData[5], mData[10]);
        double _t6 = mData[1] + mData[4];
        double _t7 = mData[2] + mData[8];
        double _t8 = mData[2] - mData[8];
        double _t9 = mData[6] + mData[9];
        double _t10 = mData[4] - mData[1];
        double _t14 = mData[10] + (mData[0] + mData[5]);
        double _t15 = 1.0 + _t14;
        double _t16 = mData[0] + (1.0 - mData[5] - mData[10]);
        double _t17 = mData[5] + (_t2 - mData[10]);
        double _t18 = mData[10] + (_t2 - mData[5]);
        double _t19 = (1.0 / Math.sqrt(_t15));
        double _t21 = (1.0 / Math.sqrt(_t17));
        double _t22 = (1.0 / Math.sqrt(_t18));
        double _t23 = (1.0 / Math.sqrt(_t16));
        double _t63, _t64, _t65, _t66;
        if (_t14 > 0.0) {
            _t63 = 0.5 * _t4 * _t19;
            _t64 = 0.5 * _t8 * _t19;
            _t65 = 0.5 * _t10 * _t19;
            _t66 = 0.5 * Math.sqrt(_t15);
        } else {
            if (mData[0] > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (mData[5] > mData[10]) {
                    _t63 = 0.5 * _t6 * _t21;
                    _t64 = 0.5 * Math.sqrt(_t17);
                    _t65 = 0.5 * _t9 * _t21;
                    _t66 = 0.5 * _t8 * _t21;
                } else {
                    _t63 = 0.5 * _t7 * _t22;
                    _t64 = 0.5 * _t9 * _t22;
                    _t65 = 0.5 * Math.sqrt(_t18);
                    _t66 = 0.5 * _t10 * _t22;
                }
            }
        }
        dd[0] = _t63;
        dd[1] = _t64;
        dd[2] = _t65;
        dd[3] = _t66;
        dd[4] = 0.5 * Math.fma(_t0, _t64, Math.fma(mData[3], _t66, mData[7] * _t65));
        dd[5] = 0.5 * Math.fma(mData[11], _t63, Math.fma(mData[7], _t66, -(mData[3] * _t65)));
        dd[6] = 0.5 * Math.fma(mData[11], _t66, Math.fma(mData[3], _t64, -(mData[7] * _t63)));
        dd[7] = 0.5 * Math.fma(_t0, _t65, Math.fma(-mData[7], _t64, -(mData[3] * _t63)));
        return this;
    }


    /**
     * Set this dual quaternion to the rotation represented by the given matrix, with zero
     * translation.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleDualQuat makeFromMatrix(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        double _t1 = 1.0 - mData[0];
        double _t3 = mData[5] - mData[7];
        double _t4 = Math.max(mData[4], mData[8]);
        double _t5 = mData[3] + mData[1];
        double _t6 = mData[6] + mData[2];
        double _t7 = mData[6] - mData[2];
        double _t8 = mData[7] + mData[5];
        double _t9 = mData[1] - mData[3];
        double _t13 = mData[8] + (mData[0] + mData[4]);
        double _t14 = 1.0 + _t13;
        double _t15 = mData[0] + (1.0 - mData[4] - mData[8]);
        double _t16 = mData[4] + (_t1 - mData[8]);
        double _t17 = mData[8] + (_t1 - mData[4]);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t13 > 0.0) {
            dd[0] = 0.5 * _t3 * _t18;
            dd[1] = 0.5 * _t7 * _t18;
            dd[2] = 0.5 * _t9 * _t18;
            dd[3] = 0.5 * Math.sqrt(_t14);
        } else {
            if (mData[0] > _t4) {
                dd[0] = 0.5 * Math.sqrt(_t15);
                dd[1] = 0.5 * _t5 * _t21;
                dd[2] = 0.5 * _t6 * _t21;
                dd[3] = 0.5 * _t3 * _t21;
            } else {
                if (mData[4] > mData[8]) {
                    dd[0] = 0.5 * _t5 * _t19;
                    dd[1] = 0.5 * Math.sqrt(_t16);
                    dd[2] = 0.5 * _t8 * _t19;
                    dd[3] = 0.5 * _t7 * _t19;
                } else {
                    dd[0] = 0.5 * _t6 * _t20;
                    dd[1] = 0.5 * _t8 * _t20;
                    dd[2] = 0.5 * Math.sqrt(_t17);
                    dd[3] = 0.5 * _t9 * _t20;
                }
            }
        }
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat normalize(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t5 = (1.0 / Math.sqrt(Math.fma(sd[0], sd[0], sd[1] * sd[1]) + Math.fma(sd[2], sd[2], sd[3] * sd[3])));
        dd[0] = sd[0] * _t5;
        dd[1] = sd[1] * _t5;
        dd[2] = sd[2] * _t5;
        dd[3] = sd[3] * _t5;
        dd[4] = sd[4] * _t5;
        dd[5] = sd[5] * _t5;
        dd[6] = sd[6] * _t5;
        dd[7] = sd[7] * _t5;
        return dest;
    }


    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}) and store the result in {@code dest}.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat pow(double t, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = t * sd[4];
        double _t1 = t * sd[5];
        double _t2 = t * sd[6];
        double _t5 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t8 = sd[0] * _t6;
        double _t10 = sd[1] * _t6;
        double _t11 = sd[2] * _t6;
        double _t12 = sd[7] * _t6;
        double _t13 = t * Math.atan2(Math.sqrt(_t5), sd[3]);
        double _t14 = t * _t12;
        double _t15 = Math.sin(_t13);
        double _t16 = Math.cos(_t13);
        double _t17 = sd[3] * _t12;
        double _t18 = _t14 * _t16;
        if (_t5 < 1.0e-12f) {
            if (sd[3] < 0.0) {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                double _buf0 = 1.0;
                dd[4] = -_t0;
                dd[5] = -_t1;
                dd[6] = -_t2;
                dd[7] = t * sd[7];
                dd[3] = _buf0;
            } else {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                double _buf0 = 1.0;
                dd[4] = _t0;
                dd[5] = _t1;
                dd[6] = _t2;
                dd[7] = t * sd[7];
                dd[3] = _buf0;
            }
        } else {
            dd[0] = _t8 * _t15;
            dd[1] = _t10 * _t15;
            dd[2] = _t11 * _t15;
            double _buf0 = _t16;
            dd[4] = Math.fma(Math.fma(_t8, _t17, sd[4]) * _t6, _t15, -(_t8 * _t18));
            dd[5] = Math.fma(Math.fma(_t10, _t17, sd[5]) * _t6, _t15, -(_t10 * _t18));
            dd[6] = Math.fma(Math.fma(_t11, _t17, sd[6]) * _t6, _t15, -(_t11 * _t18));
            dd[7] = _t14 * _t15;
            dd[3] = _buf0;
        }
        return dest;
    }


    /**
     * Set the rotation of this dual quaternion to {@code rotation} and store the result in
     * {@code dest}.
     *
     * @param rotation the quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setRotation(DoubleQuatR rotation, @Mutated DoubleDualQuat dest) {
        return setRotation(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Set the rotation of this dual quaternion to ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) and store the result in {@code dest}.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setRotation(double rotationX, double rotationY, double rotationZ, double rotationW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -rotationY;
        double _t22 = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        double _t23 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        double _t24 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        dd[0] = rotationX;
        dd[1] = rotationY;
        dd[2] = rotationZ;
        dd[3] = rotationW;
        dd[4] = 0.5 * Math.fma(_t0, _t22, Math.fma(rotationZ, _t23, rotationW * _t24));
        dd[5] = 0.5 * Math.fma(rotationX, _t22, Math.fma(rotationW, _t23, -(rotationZ * _t24)));
        dd[6] = 0.5 * Math.fma(rotationW, _t22, Math.fma(rotationY, _t24, -(rotationX * _t23)));
        dd[7] = 0.5 * Math.fma(-rotationZ, _t22, Math.fma(_t0, _t23, -(rotationX * _t24)));
        return dest;
    }


    /**
     * Set the translation of this dual quaternion to {@code translation} and store the result in
     * {@code dest}.
     *
     * @param translation the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setTranslation(Double3R translation, @Mutated DoubleDualQuat dest) {
        return setTranslation(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Set the translation of this dual quaternion to ({@code translationX}, {@code translationY},
     * {@code translationZ}) and store the result in {@code dest}.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setTranslation(double translationX, double translationY, double translationZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -sd[1];
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        dd[4] = 0.5 * Math.fma(_t0, translationZ, Math.fma(sd[2], translationY, sd[3] * translationX));
        dd[5] = 0.5 * Math.fma(sd[0], translationZ, Math.fma(sd[3], translationY, -(sd[2] * translationX)));
        dd[6] = 0.5 * Math.fma(sd[3], translationZ, Math.fma(sd[1], translationX, -(sd[0] * translationY)));
        dd[7] = 0.5 * Math.fma(-sd[2], translationZ, Math.fma(_t0, translationY, -(sd[0] * translationX)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        return dest;
    }


    /**
     * Compute the matrix representation of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        double _t0 = sd[1] * sd[1];
        double _t2 = sd[2] * sd[3];
        double _t3 = sd[1] * sd[3];
        double _t4 = sd[0] * sd[0];
        double _t5 = sd[1] * sd[2];
        double _t6 = Math.fma(-2.0, sd[2] * sd[2], 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], _t2);
        dd[2] = Math.fma(-2.0, _t3, 2.0 * sd[0] * sd[2]);
        dd[3] = 0.0;
        double _buf2 = Math.fma(-2.0, _t2, 2.0 * sd[0] * sd[1]);
        double _buf3 = Math.fma(-2.0, _t4, _t6);
        dd[6] = 2.0 * Math.fma(sd[0], sd[3], _t5);
        dd[7] = 0.0;
        double _buf4 = 2.0 * Math.fma(sd[0], sd[2], _t3);
        double _buf5 = Math.fma(-2.0, sd[0] * sd[3], 2.0 * _t5);
        dd[10] = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        dd[11] = 0.0;
        double _buf6 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        double _buf7 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        dd[14] = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        dd[15] = 1.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[4] = _buf2;
        dd[5] = _buf3;
        dd[8] = _buf4;
        dd[9] = _buf5;
        dd[12] = _buf6;
        dd[13] = _buf7;
        ((Double4x4Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the 3x3 matrix representation of this dual quaternion's rotation part (the encoded
     * translation is dropped) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = sd[1] * sd[1];
        double _t2 = sd[2] * sd[3];
        double _t3 = sd[1] * sd[3];
        double _t4 = sd[0] * sd[0];
        double _t5 = sd[1] * sd[2];
        double _t6 = Math.fma(-2.0, sd[2] * sd[2], 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], _t2);
        dd[2] = Math.fma(-2.0, _t3, 2.0 * sd[0] * sd[2]);
        dd[3] = Math.fma(-2.0, _t2, 2.0 * sd[0] * sd[1]);
        dd[4] = Math.fma(-2.0, _t4, _t6);
        dd[5] = 2.0 * Math.fma(sd[0], sd[3], _t5);
        dd[6] = 2.0 * Math.fma(sd[0], sd[2], _t3);
        dd[7] = Math.fma(-2.0, sd[0] * sd[3], 2.0 * _t5);
        dd[8] = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        dd[0] = _buf0;
        dd[1] = _buf1;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the 3x4 matrix representation of this dual quaternion (the omitted last row is
     * implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        double _t0 = sd[1] * sd[1];
        double _t2 = sd[2] * sd[3];
        double _t3 = sd[1] * sd[3];
        double _t4 = sd[0] * sd[0];
        double _t5 = sd[1] * sd[2];
        double _t6 = Math.fma(-2.0, sd[2] * sd[2], 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = Math.fma(-2.0, _t2, 2.0 * sd[0] * sd[1]);
        double _buf2 = 2.0 * Math.fma(sd[0], sd[2], _t3);
        double _buf3 = 2.0 * (Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])));
        double _buf4 = 2.0 * Math.fma(sd[0], sd[1], _t2);
        double _buf5 = Math.fma(-2.0, _t4, _t6);
        double _buf6 = Math.fma(-2.0, sd[0] * sd[3], 2.0 * _t5);
        double _buf7 = 2.0 * (Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])));
        dd[8] = Math.fma(-2.0, _t3, 2.0 * sd[0] * sd[2]);
        dd[9] = 2.0 * Math.fma(sd[0], sd[3], _t5);
        dd[10] = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        dd[11] = 2.0 * (Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        dd[4] = _buf4;
        dd[5] = _buf5;
        dd[6] = _buf6;
        dd[7] = _buf7;
        ((Double3x4Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this dual
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat lookAlong(Double3R dir, Double3R up, @Mutated DoubleDualQuat dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
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
    public DoubleDualQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        double _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        double _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
        dd[3] = Math.fma(-sd[2], _t108, Math.fma(-sd[1], _t109, Math.fma(sd[3], _t110, -(sd[0] * _t111))));
        double _buf3 = Math.fma(sd[4], _t110, sd[7] * _t111) + Math.fma(sd[5], _t108, -(sd[6] * _t109));
        double _buf4 = Math.fma(sd[5], _t110, sd[6] * _t111) + Math.fma(sd[7], _t109, -(sd[4] * _t108));
        double _buf5 = Math.fma(sd[4], _t109, sd[7] * _t108) + Math.fma(sd[6], _t110, -(sd[5] * _t111));
        dd[7] = Math.fma(-sd[6], _t108, Math.fma(-sd[5], _t109, Math.fma(sd[7], _t110, -(sd[4] * _t111))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated DoubleDualQuat makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the axis
     * ({@code axisX}, {@code axisY}, {@code axisZ}).
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
    @Mutated public DoubleDualQuat makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dd[0] = axisX * _t1;
        dd[1] = axisY * _t1;
        dd[2] = axisZ * _t1;
        dd[3] = Math.cos(_t0);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated DoubleDualQuat makeRotationLookAlong(Double3R dir, Double3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            dd[0] = 0.5 * _t55 * _t64;
            dd[1] = 0.5 * _t38 * _t64;
            dd[2] = 0.5 * _t58 * _t64;
            dd[3] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                dd[0] = 0.5 * Math.sqrt(_t61);
                dd[1] = 0.5 * _t57 * _t67;
                dd[2] = 0.5 * _t37 * _t67;
                dd[3] = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    dd[0] = 0.5 * _t57 * _t65;
                    dd[1] = 0.5 * Math.sqrt(_t62);
                    dd[2] = 0.5 * _t54 * _t65;
                    dd[3] = 0.5 * _t38 * _t65;
                } else {
                    dd[0] = 0.5 * _t37 * _t66;
                    dd[1] = 0.5 * _t54 * _t66;
                    dd[2] = 0.5 * Math.sqrt(_t63);
                    dd[3] = 0.5 * _t58 * _t66;
                }
            }
        }
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationX(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        dd[0] = Math.sin(_t0);
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = Math.cos(_t0);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationXYZ(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dd[2] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationXZY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dd[2] = Math.fma(_t9, _t8, _t10 * _t5);
        dd[3] = Math.fma(_t12, _t8, _t11 * _t5);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationY(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        dd[0] = 0.0;
        dd[1] = Math.sin(_t0);
        dd[2] = 0.0;
        dd[3] = Math.cos(_t0);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationYXZ(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dd[2] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dd[3] = Math.fma(_t12, _t8, _t11 * _t5);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationYZX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[2] = Math.fma(_t12, _t5, -(_t11 * _t8));
        dd[3] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationZ(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = Math.sin(_t0);
        dd[3] = Math.cos(_t0);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationZXY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[2] = Math.fma(_t9, _t8, _t10 * _t5);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationZYX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t8, _t12 * _t5);
        dd[2] = Math.fma(_t12, _t8, -(_t11 * _t5));
        dd[3] = Math.fma(_t10, _t5, _t9 * _t8);
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return this;
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this dual quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotate(DoubleQuatR rotation, @Mutated DoubleDualQuat dest) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotate(double rotationX, double rotationY, double rotationZ, double rotationW, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -rotationZ;
        double _t1 = -rotationY;
        double _buf0 = Math.fma(rotationX, sd[3], rotationW * sd[0]) + Math.fma(rotationZ, sd[1], -(rotationY * sd[2]));
        double _buf1 = Math.fma(rotationX, sd[2], rotationW * sd[1]) + Math.fma(rotationY, sd[3], -(rotationZ * sd[0]));
        double _buf2 = Math.fma(rotationY, sd[0], rotationZ * sd[3]) + Math.fma(rotationW, sd[2], -(rotationX * sd[1]));
        dd[3] = Math.fma(_t0, sd[2], Math.fma(_t1, sd[1], Math.fma(rotationW, sd[3], -(rotationX * sd[0]))));
        double _buf3 = Math.fma(rotationX, sd[7], rotationW * sd[4]) + Math.fma(rotationZ, sd[5], -(rotationY * sd[6]));
        double _buf4 = Math.fma(rotationX, sd[6], rotationW * sd[5]) + Math.fma(rotationY, sd[7], -(rotationZ * sd[4]));
        double _buf5 = Math.fma(rotationY, sd[4], rotationZ * sd[7]) + Math.fma(rotationW, sd[6], -(rotationX * sd[5]));
        dd[7] = Math.fma(_t0, sd[6], Math.fma(_t1, sd[5], Math.fma(rotationW, sd[7], -(rotationX * sd[4]))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this dual quaternion
     * and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateAxis(double angle, Double3R axis, @Mutated DoubleDualQuat dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
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
    public DoubleDualQuat rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        double _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        double _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        double _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
        dd[3] = Math.fma(-sd[2], _t4, Math.fma(-sd[1], _t5, Math.fma(sd[3], _t1, -(sd[0] * _t3))));
        double _buf3 = Math.fma(sd[4], _t1, sd[7] * _t3) + Math.fma(sd[5], _t4, -(sd[6] * _t5));
        double _buf4 = Math.fma(sd[5], _t1, sd[6] * _t3) + Math.fma(sd[7], _t5, -(sd[4] * _t4));
        double _buf5 = Math.fma(sd[4], _t5, sd[7] * _t4) + Math.fma(sd[6], _t1, -(sd[5] * _t3));
        dd[7] = Math.fma(-sd[6], _t4, Math.fma(-sd[5], _t5, Math.fma(sd[7], _t1, -(sd[4] * _t3))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateX(double angle, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(sd[0], _t1, sd[3] * _t2);
        double _buf1 = Math.fma(sd[1], _t1, sd[2] * _t2);
        dd[2] = Math.fma(sd[2], _t1, -(sd[1] * _t2));
        dd[3] = Math.fma(sd[3], _t1, -(sd[0] * _t2));
        double _buf2 = Math.fma(sd[4], _t1, sd[7] * _t2);
        double _buf3 = Math.fma(sd[5], _t1, sd[6] * _t2);
        dd[6] = Math.fma(sd[6], _t1, -(sd[5] * _t2));
        dd[7] = Math.fma(sd[7], _t1, -(sd[4] * _t2));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[4] = _buf2;
        dd[5] = _buf3;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
        double _buf3 = Math.fma(sd[4], _t21, sd[7] * _t19) + Math.fma(sd[5], _t20, -(sd[6] * _t22));
        double _buf4 = Math.fma(sd[5], _t21, sd[6] * _t19) + Math.fma(sd[7], _t22, -(sd[4] * _t20));
        double _buf5 = Math.fma(sd[4], _t22, sd[7] * _t20) + Math.fma(sd[6], _t21, -(sd[5] * _t19));
        dd[7] = Math.fma(-sd[6], _t20, Math.fma(-sd[5], _t22, Math.fma(sd[7], _t21, -(sd[4] * _t19))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateXZY(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
        double _buf3 = Math.fma(sd[4], _t19, sd[7] * _t21) + Math.fma(sd[5], _t20, -(sd[6] * _t22));
        double _buf4 = Math.fma(sd[5], _t19, sd[6] * _t21) + Math.fma(sd[7], _t22, -(sd[4] * _t20));
        double _buf5 = Math.fma(sd[4], _t22, sd[7] * _t20) + Math.fma(sd[6], _t19, -(sd[5] * _t21));
        dd[7] = Math.fma(-sd[6], _t20, Math.fma(-sd[5], _t22, Math.fma(sd[7], _t19, -(sd[4] * _t21))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateY(double angle, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(sd[0], _t1, -(sd[2] * _t2));
        double _buf1 = Math.fma(sd[1], _t1, sd[3] * _t2);
        dd[2] = Math.fma(sd[0], _t2, sd[2] * _t1);
        dd[3] = Math.fma(sd[3], _t1, -(sd[1] * _t2));
        double _buf2 = Math.fma(sd[4], _t1, -(sd[6] * _t2));
        double _buf3 = Math.fma(sd[5], _t1, sd[7] * _t2);
        dd[6] = Math.fma(sd[4], _t2, sd[6] * _t1);
        dd[7] = Math.fma(sd[7], _t1, -(sd[5] * _t2));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[4] = _buf2;
        dd[5] = _buf3;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateYXZ(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t20) + Math.fma(sd[1], _t21, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t20) + Math.fma(sd[3], _t22, -(sd[0] * _t21));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t21) + Math.fma(sd[2], _t19, -(sd[1] * _t20));
        dd[3] = Math.fma(-sd[2], _t21, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t20))));
        double _buf3 = Math.fma(sd[4], _t19, sd[7] * _t20) + Math.fma(sd[5], _t21, -(sd[6] * _t22));
        double _buf4 = Math.fma(sd[5], _t19, sd[6] * _t20) + Math.fma(sd[7], _t22, -(sd[4] * _t21));
        double _buf5 = Math.fma(sd[4], _t22, sd[7] * _t21) + Math.fma(sd[6], _t19, -(sd[5] * _t20));
        dd[7] = Math.fma(-sd[6], _t21, Math.fma(-sd[5], _t22, Math.fma(sd[7], _t19, -(sd[4] * _t20))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateYZX(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t3;
        double _t12 = _t6 * _t4;
        double _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
        double _buf3 = Math.fma(sd[4], _t21, sd[7] * _t19) + Math.fma(sd[5], _t22, -(sd[6] * _t20));
        double _buf4 = Math.fma(sd[5], _t21, sd[6] * _t19) + Math.fma(sd[7], _t20, -(sd[4] * _t22));
        double _buf5 = Math.fma(sd[4], _t20, sd[7] * _t22) + Math.fma(sd[6], _t21, -(sd[5] * _t19));
        dd[7] = Math.fma(-sd[6], _t22, Math.fma(-sd[5], _t20, Math.fma(sd[7], _t21, -(sd[4] * _t19))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZ(double angle, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(sd[0], _t1, sd[1] * _t2);
        dd[1] = Math.fma(sd[1], _t1, -(sd[0] * _t2));
        double _buf1 = Math.fma(sd[2], _t1, sd[3] * _t2);
        dd[3] = Math.fma(sd[3], _t1, -(sd[2] * _t2));
        double _buf2 = Math.fma(sd[4], _t1, sd[5] * _t2);
        dd[5] = Math.fma(sd[5], _t1, -(sd[4] * _t2));
        double _buf3 = Math.fma(sd[6], _t1, sd[7] * _t2);
        dd[7] = Math.fma(sd[7], _t1, -(sd[6] * _t2));
        dd[0] = _buf0;
        dd[2] = _buf1;
        dd[4] = _buf2;
        dd[6] = _buf3;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZXY(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t22) + Math.fma(sd[1], _t19, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t22) + Math.fma(sd[3], _t20, -(sd[0] * _t19));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t19) + Math.fma(sd[2], _t21, -(sd[1] * _t22));
        dd[3] = Math.fma(-sd[2], _t19, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t22))));
        double _buf3 = Math.fma(sd[4], _t21, sd[7] * _t22) + Math.fma(sd[5], _t19, -(sd[6] * _t20));
        double _buf4 = Math.fma(sd[5], _t21, sd[6] * _t22) + Math.fma(sd[7], _t20, -(sd[4] * _t19));
        double _buf5 = Math.fma(sd[4], _t20, sd[7] * _t19) + Math.fma(sd[6], _t21, -(sd[5] * _t22));
        dd[7] = Math.fma(-sd[6], _t19, Math.fma(-sd[5], _t20, Math.fma(sd[7], _t21, -(sd[4] * _t22))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZYX(double angleX, double angleY, double angleZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t4 * _t6;
        double _t12 = _t3 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
        double _buf3 = Math.fma(sd[4], _t19, sd[7] * _t21) + Math.fma(sd[5], _t22, -(sd[6] * _t20));
        double _buf4 = Math.fma(sd[5], _t19, sd[6] * _t21) + Math.fma(sd[7], _t20, -(sd[4] * _t22));
        double _buf5 = Math.fma(sd[4], _t20, sd[7] * _t22) + Math.fma(sd[6], _t19, -(sd[5] * _t21));
        dd[7] = Math.fma(-sd[6], _t22, Math.fma(-sd[5], _t20, Math.fma(sd[7], _t19, -(sd[4] * _t21))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[4] = _buf3;
        dd[5] = _buf4;
        dd[6] = _buf5;
        return dest;
    }


    /**
     * Apply a translation by {@code translation} to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     *
     * @param translation the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat translate(Double3R translation, @Mutated DoubleDualQuat dest) {
        return translate(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat translate(double translationX, double translationY, double translationZ, @Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        double _t0 = -sd[2];
        double _t1 = -sd[0];
        double _t2 = -sd[1];
        double _t3 = 0.5 * translationZ;
        double _t4 = 0.5 * translationY;
        double _t5 = 0.5 * translationX;
        double _buf0 = sd[0];
        double _buf1 = sd[1];
        double _buf2 = sd[2];
        double _buf3 = sd[3];
        dd[4] = Math.fma(sd[1], _t3, Math.fma(_t0, _t4, Math.fma(sd[3], _t5, sd[4])));
        dd[5] = Math.fma(sd[3], _t4, Math.fma(_t1, _t3, Math.fma(sd[2], _t5, sd[5])));
        dd[6] = Math.fma(sd[0], _t4, Math.fma(sd[3], _t3, Math.fma(_t2, _t5, sd[6])));
        dd[7] = Math.fma(_t1, _t5, Math.fma(_t2, _t4, Math.fma(_t0, _t3, sd[7])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        return dest;
    }


    /**
     * Transform {@code p} by this dual quaternion and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Double3R p, @Mutated Double3 dest) {
        return transform(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by this dual quaternion and store the result
     * in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(double pX, double pY, double pZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(pY, sd[0], -(pX * sd[1]));
        double _t10 = 2.0 * Math.fma(pX, sd[2], -(pZ * sd[0]));
        double _t11 = 2.0 * Math.fma(pZ, sd[1], -(pY * sd[2]));
        double _buf0 = Math.fma(sd[1], _t9, Math.fma(-sd[2], _t10, Math.fma(sd[3], _t11, Math.fma(2.0, Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])), pX))));
        double _buf1 = Math.fma(sd[2], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, Math.fma(2.0, Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])), pY))));
        dd[2] = Math.fma(sd[0], _t10, Math.fma(-sd[1], _t11, Math.fma(sd[3], _t9, Math.fma(2.0, Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])), pZ))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Double3R v, @Mutated Double3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(double vX, double vY, double vZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], vY, -(sd[1] * vX));
        double _t10 = 2.0 * Math.fma(sd[2], vX, -(sd[0] * vZ));
        double _t11 = 2.0 * Math.fma(sd[1], vZ, -(sd[2] * vY));
        double _buf0 = Math.fma(sd[1], _t9, Math.fma(-sd[2], _t10, Math.fma(sd[3], _t11, vX)));
        double _buf1 = Math.fma(sd[2], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vY)));
        dd[2] = Math.fma(sd[0], _t10, Math.fma(-sd[1], _t11, Math.fma(sd[3], _t9, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(Double3R v, @Mutated Double3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(double vX, double vY, double vZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], vZ, -(sd[2] * vX));
        double _t10 = 2.0 * Math.fma(sd[1], vX, -(sd[0] * vY));
        double _t11 = 2.0 * Math.fma(sd[2], vY, -(sd[1] * vZ));
        double _buf0 = Math.fma(sd[2], _t9, Math.fma(-sd[1], _t10, Math.fma(sd[3], _t11, vX)));
        double _buf1 = Math.fma(sd[0], _t10, Math.fma(-sd[2], _t11, Math.fma(sd[3], _t9, vY)));
        dd[2] = Math.fma(sd[1], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform {@code p} by the inverse of this dual quaternion (assumes a unit, rigid dual
     * quaternion) and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this dual quaternion
     * (assumes a unit, rigid dual quaternion) and store the result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(double pX, double pY, double pZ, @Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t21 = Math.fma(-2.0, Math.fma(sd[0], sd[5], -(sd[1] * sd[4])) + Math.fma(sd[3], sd[6], -(sd[2] * sd[7])), pZ);
        double _t22 = Math.fma(-2.0, Math.fma(sd[1], sd[6], -(sd[2] * sd[5])) + Math.fma(sd[3], sd[4], -(sd[0] * sd[7])), pX);
        double _t23 = Math.fma(-2.0, Math.fma(sd[2], sd[4], -(sd[0] * sd[6])) + Math.fma(sd[3], sd[5], -(sd[1] * sd[7])), pY);
        double _t33 = 2.0 * Math.fma(sd[0], _t21, -(sd[2] * _t22));
        double _t34 = 2.0 * Math.fma(sd[1], _t22, -(sd[0] * _t23));
        double _t35 = 2.0 * Math.fma(sd[2], _t23, -(sd[1] * _t21));
        double _buf0 = Math.fma(sd[2], _t33, Math.fma(-sd[1], _t34, Math.fma(sd[3], _t35, _t22)));
        double _buf1 = Math.fma(sd[0], _t34, Math.fma(-sd[2], _t35, Math.fma(sd[3], _t33, _t23)));
        dd[2] = Math.fma(sd[1], _t35, Math.fma(-sd[0], _t33, Math.fma(sd[3], _t34, _t21)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Double3R p, @Mutated Double3 dest) {
        return transform(p, dest);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(double pX, double pY, double pZ, @Mutated Double3 dest) {
        return transform(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(double pX, double pY, double pZ, @Mutated Double3 dest) {
        return transformInverse(pX, pY, pZ, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(Double3R v, @Mutated Double3 dest) {
        return transformDirection(v, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(double vX, double vY, double vZ, @Mutated Double3 dest) {
        return transformDirection(vX, vY, vZ, dest);
    }

    public double rX() { return data[0]; }
    public double rY() { return data[1]; }
    public double rZ() { return data[2]; }
    public double rW() { return data[3]; }
    public double dX() { return data[4]; }
    public double dY() { return data[5]; }
    public double dZ() { return data[6]; }
    public double dW() { return data[7]; }

    @Override public String toString() {
        return "DoubleDualQuat(" + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ", " + dX() + ", " + dY() + ", " + dZ() + ", " + dW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleDualQuatImpl)) return false;
        DoubleDualQuatImpl o = (DoubleDualQuatImpl) obj;
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
            && Double.isFinite(data[7]);
    }

    @Override public boolean equalsEpsilon(DoubleDualQuatR other, double epsilon) {
        return Math.abs(data[0] - other.rX()) <= epsilon
            && Math.abs(data[1] - other.rY()) <= epsilon
            && Math.abs(data[2] - other.rZ()) <= epsilon
            && Math.abs(data[3] - other.rW()) <= epsilon
            && Math.abs(data[4] - other.dX()) <= epsilon
            && Math.abs(data[5] - other.dY()) <= epsilon
            && Math.abs(data[6] - other.dZ()) <= epsilon
            && Math.abs(data[7] - other.dW()) <= epsilon;
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
        return dest;
    }
    public @Mutated DoubleDualQuat load(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleDualQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleDualQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleDualQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleDualQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) this.data[3];
        dest[offset + 4] = (float) this.data[4];
        dest[offset + 5] = (float) this.data[5];
        dest[offset + 6] = (float) this.data[6];
        dest[offset + 7] = (float) this.data[7];
        return dest;
    }
    public @Mutated DoubleDualQuat load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleDualQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleDualQuat loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleDualQuat storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleDualQuat loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }

}
