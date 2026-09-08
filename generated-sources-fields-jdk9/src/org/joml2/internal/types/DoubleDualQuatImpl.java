package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleDualQuat} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleDualQuatImpl implements DoubleDualQuat {

    public double rX;
    public double rY;
    public double rZ;
    public double rW;
    public double dX;
    public double dY;
    public double dZ;
    public double dW;
    static final DoubleDualQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleDualQuatBbOpsUnsafe()
                    : new DoubleDualQuatBbOpsApi();
    static final DoubleDualQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleDualQuatRawOpsUnsafe()
                    : new DoubleDualQuatRawOpsApi();

    public DoubleDualQuatImpl() {
        rW = 1;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = otherRX + this.rX;
        d.rY = otherRY + this.rY;
        d.rZ = otherRZ + this.rZ;
        d.rW = otherRW + this.rW;
        d.dX = otherDX + this.dX;
        d.dY = otherDY + this.dY;
        d.dZ = otherDZ + this.dZ;
        d.dW = otherDW + this.dW;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = scalar * this.rX;
        d.rY = scalar * this.rY;
        d.rZ = scalar * this.rZ;
        d.rW = scalar * this.rW;
        d.dX = scalar * this.dX;
        d.dY = scalar * this.dY;
        d.dZ = scalar * this.dZ;
        d.dW = scalar * this.dW;
        return d;
    }


    /**
     * Negate this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat negate(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = -this.rX;
        d.rY = -this.rY;
        d.rZ = -this.rZ;
        d.rW = -this.rW;
        d.dX = -this.dX;
        d.dY = -this.dY;
        d.dZ = -this.dZ;
        d.dW = -this.dW;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = this.rX - otherRX;
        d.rY = this.rY - otherRY;
        d.rZ = this.rZ - otherRZ;
        d.rW = this.rW - otherRW;
        d.dX = this.dX - otherDX;
        d.dY = this.dY - otherDY;
        d.dZ = this.dZ - otherDZ;
        d.dW = this.dW - otherDW;
        return d;
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
        this.rX = vRX;
        this.rY = vRY;
        this.rZ = vRZ;
        this.rW = vRW;
        this.dX = vDX;
        this.dY = vDY;
        this.dZ = vDZ;
        this.dW = vDW;
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
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = (float) (this.rX);
        d.rY = (float) (this.rY);
        d.rZ = (float) (this.rZ);
        d.rW = (float) (this.rW);
        d.dX = (float) (this.dX);
        d.dY = (float) (this.dY);
        d.dZ = (float) (this.dZ);
        d.dW = (float) (this.dW);
        return d;
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
        double _t0 = -rTZ;
        this.rX = rRX;
        this.rY = rRY;
        this.rZ = rRZ;
        this.rW = rRW;
        this.dX = 0.5 * Math.fma(_t0, rRY, Math.fma(rTX, rRW, rTY * rRZ));
        this.dY = 0.5 * Math.fma(rTZ, rRX, Math.fma(rTY, rRW, -(rTX * rRZ)));
        this.dZ = 0.5 * Math.fma(rTZ, rRW, Math.fma(rTX, rRY, -(rTY * rRX)));
        this.dW = 0.5 * Math.fma(_t0, rRZ, Math.fma(-rTY, rRY, -(rTX * rRX)));
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
        double _t0 = -tTZ;
        this.rX = tRX;
        this.rY = tRY;
        this.rZ = tRZ;
        this.rW = tRW;
        this.dX = 0.5 * Math.fma(_t0, tRY, Math.fma(tTX, tRW, tTY * tRZ));
        this.dY = 0.5 * Math.fma(tTZ, tRX, Math.fma(tTY, tRW, -(tTX * tRZ)));
        this.dZ = 0.5 * Math.fma(tTZ, tRW, Math.fma(tTX, tRY, -(tTY * tRX)));
        this.dW = 0.5 * Math.fma(_t0, tRZ, Math.fma(-tTY, tRY, -(tTX * tRX)));
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
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _buf0 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        double _buf1 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        double _buf2 = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        double _buf3 = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.tX = _buf0;
        d.tY = _buf1;
        d.tZ = _buf2;
        d.rX = _buf3;
        return d;
    }


    /**
     * Convert this unit dual quaternion to a TRS transform (translation and rotation from the rigid
     * motion, scale = 1) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _buf0 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        double _buf1 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        double _buf2 = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        double _buf3 = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = 1.0;
        d.sY = 1.0;
        d.sZ = 1.0;
        d.tX = _buf0;
        d.tY = _buf1;
        d.tZ = _buf2;
        d.rX = _buf3;
        return d;
    }


    /**
     * Determine whether the real (rotation) part of this dual quaternion has unit length.
     *
     * @param epsilon the maximum allowed deviation of the squared real-part length from {@code 1}
     * @return {@code true} if the real (rotation) part of this dual quaternion has unit length,
     *        {@code false} otherwise
     */
    public boolean isUnit(double epsilon) {
        return Math.abs(Math.fma(this.rX, this.rX, Math.fma(this.rY, this.rY, Math.fma(this.rZ, this.rZ, Math.fma(this.rW, this.rW, -1.0))))) <= epsilon;
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
        double _t0 = 0.5 * angle;
        double _t1 = -translationZ;
        double _t2 = Math.sin(_t0);
        double _t3 = Math.cos(_t0);
        double _t4 = axisX * _t2;
        double _t5 = axisY * _t2;
        double _t6 = axisZ * _t2;
        this.rX = _t4;
        this.rY = _t5;
        this.rZ = _t6;
        this.rW = _t3;
        this.dX = 0.5 * Math.fma(_t1, _t5, Math.fma(translationX, _t3, translationY * _t6));
        this.dY = 0.5 * Math.fma(translationZ, _t4, Math.fma(translationY, _t3, -(translationX * _t6)));
        this.dZ = 0.5 * Math.fma(translationZ, _t3, Math.fma(translationX, _t5, -(translationY * _t4)));
        this.dW = 0.5 * Math.fma(_t1, _t6, Math.fma(-translationY, _t5, -(translationX * _t4)));
        return this;
    }


    /**
     * Set this dual quaternion to the identity.
     *
     * @return this
     */
    @Mutated public DoubleDualQuat makeIdentity() {
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        double _t0 = -rotationY;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.5 * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX));
        this.dY = 0.5 * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX)));
        this.dZ = 0.5 * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY)));
        this.dW = 0.5 * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX)));
        return this;
    }


    /**
     * Set all components of this dual quaternion to zero.
     *
     * @return this
     */
    @Mutated public DoubleDualQuat makeZero() {
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 0.0;
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        double _t0 = -rotationY;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.5 * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX));
        this.dY = 0.5 * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX)));
        this.dZ = 0.5 * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY)));
        this.dW = 0.5 * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX)));
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
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.dX = 0.5 * translationX;
        this.dY = 0.5 * translationY;
        this.dZ = 0.5 * translationZ;
        this.dW = 0.0;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t9 = Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) < 0.0 ? -1.0 : 1.0;
        double _t14 = Math.fma(t, Math.fma(otherRX, _t9, -this.rX), this.rX);
        double _t15 = Math.fma(t, Math.fma(otherRY, _t9, -this.rY), this.rY);
        double _t16 = Math.fma(t, Math.fma(otherRZ, _t9, -this.rZ), this.rZ);
        double _t17 = Math.fma(t, Math.fma(otherRW, _t9, -this.rW), this.rW);
        double _t23 = (1.0 / Math.sqrt(Math.fma(_t14, _t14, _t15 * _t15) + Math.fma(_t16, _t16, _t17 * _t17)));
        d.rX = _t14 * _t23;
        d.rY = _t15 * _t23;
        d.rZ = _t16 * _t23;
        d.rW = _t17 * _t23;
        d.dX = Math.fma(t, Math.fma(otherDX, _t9, -this.dX), this.dX) * _t23;
        d.dY = Math.fma(t, Math.fma(otherDY, _t9, -this.dY), this.dY) * _t23;
        d.dZ = Math.fma(t, Math.fma(otherDZ, _t9, -this.dZ), this.dZ) * _t23;
        d.dW = Math.fma(t, Math.fma(otherDW, _t9, -this.dW), this.dW) * _t23;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = Math.fma(t, otherRX - this.rX, this.rX);
        d.rY = Math.fma(t, otherRY - this.rY, this.rY);
        d.rZ = Math.fma(t, otherRZ - this.rZ, this.rZ);
        d.rW = Math.fma(t, otherRW - this.rW, this.rW);
        d.dX = Math.fma(t, otherDX - this.dX, this.dX);
        d.dY = Math.fma(t, otherDY - this.dY, this.dY);
        d.dZ = Math.fma(t, otherDZ - this.dZ, this.dZ);
        d.dW = Math.fma(t, otherDW - this.dW, this.dW);
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -this.rZ;
        double _t1 = -this.dZ;
        double _t8 = Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) < 0.0 ? -1.0 : 1.0;
        double _t9 = otherRX * _t8;
        double _t10 = otherRW * _t8;
        double _t11 = otherRZ * _t8;
        double _t12 = otherRY * _t8;
        double _t13 = otherDX * _t8;
        double _t14 = otherDW * _t8;
        double _t15 = otherDY * _t8;
        double _t16 = otherDZ * _t8;
        double _t49 = -(this.dX * _t10);
        double _t53 = -(this.dX * _t12);
        double _t64 = Math.fma(this.dX, _t11, this.dW * _t12);
        double _t71 = Math.fma(this.dZ, _t12, -(this.dY * _t11));
        double _t75 = Math.fma(this.dY, _t9, -(this.dZ * _t10));
        double _t81 = Math.fma(this.rZ, _t11, Math.fma(this.rY, _t12, Math.fma(this.rX, _t9, this.rW * _t10)));
        double _t84 = Math.fma(this.rY, _t9, -(this.rZ * _t10)) + Math.fma(this.rW, _t11, -(this.rX * _t12));
        double _t85 = Math.fma(this.rX, _t11, this.rW * _t12) + Math.fma(_t0, _t9, -(this.rY * _t10));
        double _t86 = Math.fma(this.rZ, _t12, -(this.rY * _t11)) + Math.fma(this.rW, _t9, -(this.rX * _t10));
        double _t87 = Math.fma(this.rZ, _t15, -(this.rY * _t16)) + Math.fma(this.rW, _t13, -(this.rX * _t14));
        double _t89 = Math.fma(this.rY, _t13, -(this.rZ * _t14)) + Math.fma(this.rW, _t16, -(this.rX * _t15));
        double _t91 = Math.fma(this.rX, _t16, this.rW * _t15) + Math.fma(_t0, _t13, -(this.rY * _t14));
        double _t93 = Math.fma(this.rX, _t13, this.rW * _t14) + Math.fma(this.rY, _t15, this.rZ * _t16) + (Math.fma(this.dX, _t9, this.dW * _t10) + Math.fma(this.dY, _t12, this.dZ * _t11));
        double _t99 = t * (_t87 + (_t71 + Math.fma(this.dW, _t9, _t49)));
        double _t100 = t * (_t89 + (_t75 + Math.fma(this.dW, _t11, _t53)));
        double _t101 = t * (_t91 + (_t64 + Math.fma(_t1, _t9, -(this.dY * _t10))));
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
            _t156 = Math.fma((_t87 + (_t71 + Math.fma(this.dW, _t9, Math.fma(_t121, _t115, _t49)))) * _t111, _t116, -(_t115 * _t127));
            _t157 = Math.fma((_t89 + (_t75 + Math.fma(this.dW, _t11, Math.fma(_t121, _t117, _t53)))) * _t111, _t116, -(_t117 * _t127));
            _t158 = Math.fma((_t91 + (_t64 + Math.fma(-this.dY, _t10, Math.fma(_t121, _t118, -(this.dZ * _t9))))) * _t111, _t116, -(_t118 * _t127));
        }
        double _buf0 = Math.fma(this.rX, _t122, this.rW * _t140) + Math.fma(this.rY, _t141, -(this.rZ * _t142));
        double _buf1 = Math.fma(this.rY, _t122, this.rZ * _t140) + Math.fma(this.rW, _t142, -(this.rX * _t141));
        double _buf2 = Math.fma(this.rX, _t142, this.rW * _t141) + Math.fma(this.rZ, _t122, -(this.rY * _t140));
        double _buf3 = Math.fma(_t0, _t141, Math.fma(-this.rY, _t142, Math.fma(this.rW, _t122, -(this.rX * _t140))));
        double _buf4 = Math.fma(this.rX, _t149, this.rW * _t156) + Math.fma(this.rY, _t157, -(this.rZ * _t158)) + (Math.fma(this.dX, _t122, this.dW * _t140) + Math.fma(this.dY, _t141, -(this.dZ * _t142)));
        double _buf5 = Math.fma(this.rY, _t149, this.rZ * _t156) + Math.fma(this.rW, _t158, -(this.rX * _t157)) + (Math.fma(this.dY, _t122, this.dZ * _t140) + Math.fma(this.dW, _t142, -(this.dX * _t141)));
        d.dZ = Math.fma(this.rX, _t158, this.rW * _t157) + Math.fma(this.rZ, _t149, -(this.rY * _t156)) + (Math.fma(this.dX, _t142, this.dW * _t141) + Math.fma(this.dZ, _t122, -(this.dY * _t140)));
        d.dW = Math.fma(this.rW, _t149, -(this.rX * _t156)) + Math.fma(_t0, _t157, -(this.rY * _t158)) + (Math.fma(this.dW, _t122, -(this.dX * _t140)) + Math.fma(_t1, _t141, -(this.dY * _t142)));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        d.dX = _buf4;
        d.dY = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -otherRZ;
        double _buf0 = Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRZ, this.rY, -(otherRY * this.rZ));
        double _buf1 = Math.fma(otherRX, this.rZ, otherRW * this.rY) + Math.fma(otherRY, this.rW, -(otherRZ * this.rX));
        double _buf2 = Math.fma(otherRY, this.rX, otherRZ * this.rW) + Math.fma(otherRW, this.rZ, -(otherRX * this.rY));
        double _buf3 = Math.fma(_t0, this.rZ, Math.fma(-otherRY, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX))));
        double _buf4 = Math.fma(otherRX, this.dW, otherRW * this.dX) + Math.fma(otherRZ, this.dY, -(otherRY * this.dZ)) + (Math.fma(otherDX, this.rW, otherDW * this.rX) + Math.fma(otherDZ, this.rY, -(otherDY * this.rZ)));
        double _buf5 = Math.fma(otherRX, this.dZ, otherRW * this.dY) + Math.fma(otherRY, this.dW, -(otherRZ * this.dX)) + (Math.fma(otherDX, this.rZ, otherDW * this.rY) + Math.fma(otherDY, this.rW, -(otherDZ * this.rX)));
        double _buf6 = Math.fma(otherRY, this.dX, otherRZ * this.dW) + Math.fma(otherRW, this.dZ, -(otherRX * this.dY)) + (Math.fma(otherDY, this.rX, otherDZ * this.rW) + Math.fma(otherDW, this.rZ, -(otherDX * this.rY)));
        d.dW = Math.fma(otherRW, this.dW, -(otherRX * this.dX)) + Math.fma(_t0, this.dZ, -(otherRY * this.dY)) + (Math.fma(otherDW, this.rW, -(otherDX * this.rX)) + Math.fma(-otherDZ, this.rZ, -(otherDY * this.rY)));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        d.dX = _buf4;
        d.dY = _buf5;
        d.dZ = _buf6;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -otherRZ;
        double _buf0 = Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY));
        double _buf1 = Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(otherRW, this.rY, -(otherRX * this.rZ));
        double _buf2 = Math.fma(otherRX, this.rY, otherRW * this.rZ) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX));
        double _buf3 = Math.fma(_t0, this.rZ, Math.fma(-otherRY, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX))));
        double _buf4 = Math.fma(otherRX, this.dW, otherRW * this.dX) + Math.fma(otherRY, this.dZ, -(otherRZ * this.dY)) + (Math.fma(otherDX, this.rW, otherDW * this.rX) + Math.fma(otherDY, this.rZ, -(otherDZ * this.rY)));
        double _buf5 = Math.fma(otherRY, this.dW, otherRZ * this.dX) + Math.fma(otherRW, this.dY, -(otherRX * this.dZ)) + (Math.fma(otherDY, this.rW, otherDZ * this.rX) + Math.fma(otherDW, this.rY, -(otherDX * this.rZ)));
        double _buf6 = Math.fma(otherRX, this.dY, otherRW * this.dZ) + Math.fma(otherRZ, this.dW, -(otherRY * this.dX)) + (Math.fma(otherDX, this.rY, otherDW * this.rZ) + Math.fma(otherDZ, this.rW, -(otherDY * this.rX)));
        d.dW = Math.fma(otherRW, this.dW, -(otherRX * this.dX)) + Math.fma(_t0, this.dZ, -(otherRY * this.dY)) + (Math.fma(otherDW, this.rW, -(otherDX * this.rX)) + Math.fma(-otherDZ, this.rZ, -(otherDY * this.rY)));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        d.dX = _buf4;
        d.dY = _buf5;
        d.dZ = _buf6;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = Math.fma(weight, otherRX, this.rX);
        d.rY = Math.fma(weight, otherRY, this.rY);
        d.rZ = Math.fma(weight, otherRZ, this.rZ);
        d.rW = Math.fma(weight, otherRW, this.rW);
        d.dX = Math.fma(weight, otherDX, this.dX);
        d.dY = Math.fma(weight, otherDY, this.dY);
        d.dZ = Math.fma(weight, otherDZ, this.dZ);
        d.dW = Math.fma(weight, otherDW, this.dW);
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = -this.rX;
        d.rY = -this.rY;
        d.rZ = -this.rZ;
        d.rW = this.rW;
        d.dX = -this.dX;
        d.dY = -this.dY;
        d.dZ = -this.dZ;
        d.dW = this.dW;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -otherRX;
        double _buf0 = Math.fma(otherRX, this.rW, -(otherRW * this.rX)) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY));
        double _buf1 = Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(_t0, this.rZ, -(otherRW * this.rY));
        double _buf2 = Math.fma(otherRX, this.rY, -(otherRW * this.rZ)) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX));
        double _buf3 = Math.fma(otherRZ, this.rZ, Math.fma(otherRY, this.rY, Math.fma(otherRX, this.rX, otherRW * this.rW)));
        double _buf4 = Math.fma(otherRX, this.dW, -(otherRW * this.dX)) + Math.fma(otherRY, this.dZ, -(otherRZ * this.dY)) + (Math.fma(otherDX, this.rW, -(otherDW * this.rX)) + Math.fma(otherDY, this.rZ, -(otherDZ * this.rY)));
        double _buf5 = Math.fma(otherRY, this.dW, otherRZ * this.dX) + Math.fma(_t0, this.dZ, -(otherRW * this.dY)) + (Math.fma(otherDY, this.rW, otherDZ * this.rX) + Math.fma(-otherDX, this.rZ, -(otherDW * this.rY)));
        double _buf6 = Math.fma(otherRX, this.dY, -(otherRW * this.dZ)) + Math.fma(otherRZ, this.dW, -(otherRY * this.dX)) + (Math.fma(otherDX, this.rY, -(otherDW * this.rZ)) + Math.fma(otherDZ, this.rW, -(otherDY * this.rX)));
        d.dW = Math.fma(otherRX, this.dX, otherRW * this.dW) + Math.fma(otherRY, this.dY, otherRZ * this.dZ) + (Math.fma(otherDX, this.rX, otherDW * this.rW) + Math.fma(otherDY, this.rY, otherDZ * this.rZ));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        d.dX = _buf4;
        d.dY = _buf5;
        d.dZ = _buf6;
        return d;
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
        return Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) + (Math.fma(otherDX, this.dX, otherDY * this.dY) + Math.fma(otherDZ, this.dZ, otherDW * this.dW));
    }


    /**
     * Compute the dual-number conjugate of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat dualConjugate(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.dX = -this.dX;
        d.dY = -this.dY;
        d.dZ = -this.dZ;
        d.dW = -this.dW;
        return d;
    }


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat exp(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t4 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        double _t6 = (1.0 / Math.sqrt(_t4));
        double _t7 = Math.sqrt(_t4);
        double _t8 = Math.sin(_t7);
        double _t9 = Math.cos(_t7);
        double _t10 = this.rX * _t6;
        double _t11 = this.rY * _t6;
        double _t12 = this.rZ * _t6;
        double _t13 = Math.fma(this.rZ, this.dZ, Math.fma(this.rX, this.dX, this.rY * this.dY)) * _t6;
        double _t14 = _t13 * _t9;
        if (_t4 < 1.0e-12f) {
            d.rX = 0.0;
            d.rY = 0.0;
            d.rZ = 0.0;
            d.rW = 1.0;
            d.dX = this.dX;
            d.dY = this.dY;
            d.dZ = this.dZ;
            d.dW = 0.0;
        } else {
            d.rX = _t10 * _t8;
            d.rY = _t11 * _t8;
            d.rZ = _t12 * _t8;
            d.rW = _t9;
            d.dX = Math.fma(_t10, _t14, Math.fma(-_t10, _t13, this.dX) * _t6 * _t8);
            d.dY = Math.fma(_t11, _t14, Math.fma(-_t11, _t13, this.dY) * _t6 * _t8);
            d.dZ = Math.fma(_t12, _t14, Math.fma(-_t12, _t13, this.dZ) * _t6 * _t8);
            d.dW = -(_t13 * _t8);
        }
        return d;
    }


    /**
     * Get the dual part of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getDual(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.dX;
        d.y = this.dY;
        d.z = this.dZ;
        d.w = this.dW;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t1 = this.rY * this.rZ;
        double _t3 = this.rZ * this.rZ;
        double _t8 = 2.0 * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        double _t9 = 2.0 * Math.fma(this.rX, this.rW, -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rX, this.rW, _t1), Math.fma(-2.0, Math.fma(this.rX, this.rX, _t3), 1.0));
            d.z = 0.0;
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(_t9, _t10);
            d.z = Math.atan2(2.0 * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0, Math.fma(this.rY, this.rY, _t3), 1.0));
            d.x = _buf0;
        }
        d.y = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rZ * this.rZ;
        double _t1 = this.rY * this.rZ;
        double _t7 = 2.0 * Math.fma(this.rX, this.rW, _t1);
        double _t8 = 2.0 * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        double _t9 = Math.fma(-2.0, Math.fma(this.rX, this.rX, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rX, this.rW, -_t1), Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0));
            d.y = 0.0;
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(_t7, _t9);
            d.y = Math.atan2(2.0 * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0, Math.fma(this.rY, this.rY, _t0), 1.0));
            d.x = _buf0;
        }
        d.z = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t3 = this.rZ * this.rZ;
        double _t8 = 2.0 * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        double _t9 = 2.0 * Math.fma(this.rX, this.rW, -(this.rY * this.rZ));
        double _t10 = Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0, Math.fma(this.rY, this.rY, _t3), 1.0));
            d.z = 0.0;
            d.y = _buf0;
        } else {
            double _buf0 = Math.atan2(_t8, _t10);
            d.z = Math.atan2(2.0 * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0, Math.fma(this.rX, this.rX, _t3), 1.0));
            d.y = _buf0;
        }
        d.x = Math.asin(Math.min(1.0, Math.max(-1.0, _t9)));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rZ * this.rZ;
        double _t7 = 2.0 * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        double _t8 = 2.0 * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        double _t9 = Math.fma(-2.0, Math.fma(this.rY, this.rY, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            d.y = Math.atan2(2.0 * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0));
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rX, this.rW, -(this.rY * this.rZ)), Math.fma(-2.0, Math.fma(this.rX, this.rX, _t0), 1.0));
            d.y = Math.atan2(_t8, _t9);
            d.x = _buf0;
        }
        d.z = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t1 = this.rZ * this.rZ;
        double _t7 = 2.0 * Math.fma(this.rX, this.rW, this.rY * this.rZ);
        double _t8 = 2.0 * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        double _t9 = Math.fma(-2.0, Math.fma(this.rX, this.rX, _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            d.z = Math.atan2(2.0 * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0, Math.fma(this.rY, this.rY, _t1), 1.0));
            d.y = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0));
            d.z = Math.atan2(_t8, _t9);
            d.y = _buf0;
        }
        d.x = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rZ * this.rZ;
        double _t7 = 2.0 * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        double _t8 = 2.0 * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        double _t9 = Math.fma(-2.0, Math.fma(this.rY, this.rY, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            d.z = Math.atan2(2.0 * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0, Math.fma(this.rX, this.rX, _t0), 1.0));
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0));
            d.z = Math.atan2(_t7, _t9);
            d.x = _buf0;
        }
        d.y = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return d;
    }


    /**
     * Get the rotation of this dual quaternion, i.e. its raw real part (a unit quaternion only when
     * this dual quaternion has unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getRotation(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.rX;
        d.y = this.rY;
        d.z = this.rZ;
        d.w = this.rW;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        double _buf1 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        d.z = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t8 = Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW);
        double _t8_inv = 1.0 / _t8;
        double _t10 = 2.0 * (Math.fma(this.rX, this.dX, this.rY * this.dY) + Math.fma(this.rZ, this.dZ, this.rW * this.dW));
        double _t11 = _t8 * _t8;
        double _t11_inv = 1.0 / _t11;
        double _buf0 = -(this.rX * _t8_inv);
        double _buf1 = -(this.rY * _t8_inv);
        double _buf2 = -(this.rZ * _t8_inv);
        double _buf3 = this.rW * _t8_inv;
        d.dX = this.rX * _t10 * _t11_inv - this.dX * _t8_inv;
        d.dY = this.rY * _t10 * _t11_inv - this.dY * _t8_inv;
        d.dZ = this.rZ * _t10 * _t11_inv - this.dZ * _t8_inv;
        d.dW = this.dW * _t8_inv - this.rW * _t10 * _t11_inv;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Compute the length of this dual quaternion's real (rotation) part.
     *
     * @return the length of this dual quaternion's real (rotation) part
     */
    public double length() {
        return Math.sqrt(Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW));
    }


    /**
     * Compute the squared length of this dual quaternion's real (rotation) part.
     *
     * @return the squared length of this dual quaternion's real (rotation) part
     */
    public double lengthSquared() {
        return Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW);
    }


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat log(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t2 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t5 = this.rX * _t3;
        double _t6 = Math.atan2(Math.sqrt(_t2), this.rW);
        double _t7 = this.rY * _t3;
        double _t8 = this.rZ * _t3;
        double _t9 = this.dW * _t3;
        double _t10 = this.rW * _t9;
        if (_t2 < 1.0e-12f) {
            if (this.rW < 0.0) {
                d.rX = 0.0;
                d.rY = 0.0;
                d.rZ = 0.0;
                d.dX = -this.dX;
                d.dY = -this.dY;
                d.dZ = -this.dZ;
            } else {
                d.rX = 0.0;
                d.rY = 0.0;
                d.rZ = 0.0;
                d.dX = this.dX;
                d.dY = this.dY;
                d.dZ = this.dZ;
            }
        } else {
            d.rX = _t5 * _t6;
            d.rY = _t7 * _t6;
            d.rZ = _t8 * _t6;
            d.dX = Math.fma(Math.fma(_t5, _t10, this.dX) * _t3, _t6, -(_t5 * _t9));
            d.dY = Math.fma(Math.fma(_t7, _t10, this.dY) * _t3, _t6, -(_t7 * _t9));
            d.dZ = Math.fma(Math.fma(_t8, _t10, this.dZ) * _t3, _t6, -(_t8 * _t9));
        }
        d.rW = 0.0;
        d.dW = 0.0;
        return d;
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
        double _t0 = -m.m23();
        double _t2 = 1.0 - m.m00();
        double _t4 = m.m21() - m.m12();
        double _t5 = Math.max(m.m11(), m.m22());
        double _t6 = m.m01() + m.m10();
        double _t7 = m.m02() + m.m20();
        double _t8 = m.m02() - m.m20();
        double _t9 = m.m12() + m.m21();
        double _t10 = m.m10() - m.m01();
        double _t14 = m.m22() + (m.m00() + m.m11());
        double _t15 = 1.0 + _t14;
        double _t16 = m.m00() + (1.0 - m.m11() - m.m22());
        double _t17 = m.m11() + (_t2 - m.m22());
        double _t18 = m.m22() + (_t2 - m.m11());
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
            if (m.m00() > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (m.m11() > m.m22()) {
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
        this.rX = _t63;
        this.rY = _t64;
        this.rZ = _t65;
        this.rW = _t66;
        this.dX = 0.5 * Math.fma(_t0, _t64, Math.fma(m.m03(), _t66, m.m13() * _t65));
        this.dY = 0.5 * Math.fma(m.m23(), _t63, Math.fma(m.m13(), _t66, -(m.m03() * _t65)));
        this.dZ = 0.5 * Math.fma(m.m23(), _t66, Math.fma(m.m03(), _t64, -(m.m13() * _t63)));
        this.dW = 0.5 * Math.fma(_t0, _t65, Math.fma(-m.m13(), _t64, -(m.m03() * _t63)));
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
        double _t0 = -m.m23();
        double _t2 = 1.0 - m.m00();
        double _t4 = m.m21() - m.m12();
        double _t5 = Math.max(m.m11(), m.m22());
        double _t6 = m.m01() + m.m10();
        double _t7 = m.m02() + m.m20();
        double _t8 = m.m02() - m.m20();
        double _t9 = m.m12() + m.m21();
        double _t10 = m.m10() - m.m01();
        double _t14 = m.m22() + (m.m00() + m.m11());
        double _t15 = 1.0 + _t14;
        double _t16 = m.m00() + (1.0 - m.m11() - m.m22());
        double _t17 = m.m11() + (_t2 - m.m22());
        double _t18 = m.m22() + (_t2 - m.m11());
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
            if (m.m00() > _t5) {
                _t63 = 0.5 * Math.sqrt(_t16);
                _t64 = 0.5 * _t6 * _t23;
                _t65 = 0.5 * _t7 * _t23;
                _t66 = 0.5 * _t4 * _t23;
            } else {
                if (m.m11() > m.m22()) {
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
        this.rX = _t63;
        this.rY = _t64;
        this.rZ = _t65;
        this.rW = _t66;
        this.dX = 0.5 * Math.fma(_t0, _t64, Math.fma(m.m03(), _t66, m.m13() * _t65));
        this.dY = 0.5 * Math.fma(m.m23(), _t63, Math.fma(m.m13(), _t66, -(m.m03() * _t65)));
        this.dZ = 0.5 * Math.fma(m.m23(), _t66, Math.fma(m.m03(), _t64, -(m.m13() * _t63)));
        this.dW = 0.5 * Math.fma(_t0, _t65, Math.fma(-m.m13(), _t64, -(m.m03() * _t63)));
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
        double _t1 = 1.0 - m.m00();
        double _t3 = m.m21() - m.m12();
        double _t4 = Math.max(m.m11(), m.m22());
        double _t5 = m.m01() + m.m10();
        double _t6 = m.m02() + m.m20();
        double _t7 = m.m02() - m.m20();
        double _t8 = m.m12() + m.m21();
        double _t9 = m.m10() - m.m01();
        double _t13 = m.m22() + (m.m00() + m.m11());
        double _t14 = 1.0 + _t13;
        double _t15 = m.m00() + (1.0 - m.m11() - m.m22());
        double _t16 = m.m11() + (_t1 - m.m22());
        double _t17 = m.m22() + (_t1 - m.m11());
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t13 > 0.0) {
            this.rX = 0.5 * _t3 * _t18;
            this.rY = 0.5 * _t7 * _t18;
            this.rZ = 0.5 * _t9 * _t18;
            this.rW = 0.5 * Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                this.rX = 0.5 * Math.sqrt(_t15);
                this.rY = 0.5 * _t5 * _t21;
                this.rZ = 0.5 * _t6 * _t21;
                this.rW = 0.5 * _t3 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.rX = 0.5 * _t5 * _t19;
                    this.rY = 0.5 * Math.sqrt(_t16);
                    this.rZ = 0.5 * _t8 * _t19;
                    this.rW = 0.5 * _t7 * _t19;
                } else {
                    this.rX = 0.5 * _t6 * _t20;
                    this.rY = 0.5 * _t8 * _t20;
                    this.rZ = 0.5 * Math.sqrt(_t17);
                    this.rW = 0.5 * _t9 * _t20;
                }
            }
        }
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t5 = (1.0 / Math.sqrt(Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW)));
        d.rX = this.rX * _t5;
        d.rY = this.rY * _t5;
        d.rZ = this.rZ * _t5;
        d.rW = this.rW * _t5;
        d.dX = this.dX * _t5;
        d.dY = this.dY * _t5;
        d.dZ = this.dZ * _t5;
        d.dW = this.dW * _t5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = t * this.dX;
        double _t1 = t * this.dY;
        double _t2 = t * this.dZ;
        double _t5 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t8 = this.rX * _t6;
        double _t10 = this.rY * _t6;
        double _t11 = this.rZ * _t6;
        double _t12 = this.dW * _t6;
        double _t13 = t * Math.atan2(Math.sqrt(_t5), this.rW);
        double _t14 = t * _t12;
        double _t15 = Math.sin(_t13);
        double _t16 = Math.cos(_t13);
        double _t17 = this.rW * _t12;
        double _t18 = _t14 * _t16;
        if (_t5 < 1.0e-12f) {
            if (this.rW < 0.0) {
                d.rX = 0.0;
                d.rY = 0.0;
                d.rZ = 0.0;
                double _buf0 = 1.0;
                d.dX = -_t0;
                d.dY = -_t1;
                d.dZ = -_t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            } else {
                d.rX = 0.0;
                d.rY = 0.0;
                d.rZ = 0.0;
                double _buf0 = 1.0;
                d.dX = _t0;
                d.dY = _t1;
                d.dZ = _t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            }
        } else {
            d.rX = _t8 * _t15;
            d.rY = _t10 * _t15;
            d.rZ = _t11 * _t15;
            double _buf0 = _t16;
            d.dX = Math.fma(Math.fma(_t8, _t17, this.dX) * _t6, _t15, -(_t8 * _t18));
            d.dY = Math.fma(Math.fma(_t10, _t17, this.dY) * _t6, _t15, -(_t10 * _t18));
            d.dZ = Math.fma(Math.fma(_t11, _t17, this.dZ) * _t6, _t15, -(_t11 * _t18));
            d.dW = _t14 * _t15;
            d.rW = _buf0;
        }
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -rotationY;
        double _t22 = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        double _t23 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        double _t24 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        d.rX = rotationX;
        d.rY = rotationY;
        d.rZ = rotationZ;
        d.rW = rotationW;
        d.dX = 0.5 * Math.fma(_t0, _t22, Math.fma(rotationZ, _t23, rotationW * _t24));
        d.dY = 0.5 * Math.fma(rotationX, _t22, Math.fma(rotationW, _t23, -(rotationZ * _t24)));
        d.dZ = 0.5 * Math.fma(rotationW, _t22, Math.fma(rotationY, _t24, -(rotationX * _t23)));
        d.dW = 0.5 * Math.fma(-rotationZ, _t22, Math.fma(_t0, _t23, -(rotationX * _t24)));
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -this.rY;
        double _buf0 = this.rX;
        double _buf1 = this.rY;
        double _buf2 = this.rZ;
        double _buf3 = this.rW;
        d.dX = 0.5 * Math.fma(_t0, translationZ, Math.fma(this.rZ, translationY, this.rW * translationX));
        d.dY = 0.5 * Math.fma(this.rX, translationZ, Math.fma(this.rW, translationY, -(this.rZ * translationX)));
        d.dZ = 0.5 * Math.fma(this.rW, translationZ, Math.fma(this.rY, translationX, -(this.rX * translationY)));
        d.dW = 0.5 * Math.fma(-this.rZ, translationZ, Math.fma(_t0, translationY, -(this.rX * translationX)));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Compute the matrix representation of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t2 = this.rZ * this.rW;
        double _t3 = this.rY * this.rW;
        double _t4 = this.rX * this.rX;
        double _t5 = this.rY * this.rZ;
        double _t6 = Math.fma(-2.0, this.rZ * this.rZ, 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = 2.0 * Math.fma(this.rX, this.rY, _t2);
        d.m20 = Math.fma(-2.0, _t3, 2.0 * this.rX * this.rZ);
        d.m30 = 0.0;
        double _buf2 = Math.fma(-2.0, _t2, 2.0 * this.rX * this.rY);
        double _buf3 = Math.fma(-2.0, _t4, _t6);
        d.m21 = 2.0 * Math.fma(this.rX, this.rW, _t5);
        d.m31 = 0.0;
        double _buf4 = 2.0 * Math.fma(this.rX, this.rZ, _t3);
        double _buf5 = Math.fma(-2.0, this.rX * this.rW, 2.0 * _t5);
        d.m22 = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        d.m32 = 0.0;
        double _buf6 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        double _buf7 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        d.m23 = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        d.m33 = 1.0;
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m11 = _buf3;
        d.m02 = _buf4;
        d.m12 = _buf5;
        d.m03 = _buf6;
        d.m13 = _buf7;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x3 matrix representation of this dual quaternion's rotation part (the encoded
     * translation is dropped) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t2 = this.rZ * this.rW;
        double _t3 = this.rY * this.rW;
        double _t4 = this.rX * this.rX;
        double _t5 = this.rY * this.rZ;
        double _t6 = Math.fma(-2.0, this.rZ * this.rZ, 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = 2.0 * Math.fma(this.rX, this.rY, _t2);
        d.m20 = Math.fma(-2.0, _t3, 2.0 * this.rX * this.rZ);
        d.m01 = Math.fma(-2.0, _t2, 2.0 * this.rX * this.rY);
        d.m11 = Math.fma(-2.0, _t4, _t6);
        d.m21 = 2.0 * Math.fma(this.rX, this.rW, _t5);
        d.m02 = 2.0 * Math.fma(this.rX, this.rZ, _t3);
        d.m12 = Math.fma(-2.0, this.rX * this.rW, 2.0 * _t5);
        d.m22 = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x4 matrix representation of this dual quaternion (the omitted last row is
     * implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t2 = this.rZ * this.rW;
        double _t3 = this.rY * this.rW;
        double _t4 = this.rX * this.rX;
        double _t5 = this.rY * this.rZ;
        double _t6 = Math.fma(-2.0, this.rZ * this.rZ, 1.0);
        double _buf0 = Math.fma(-2.0, _t0, _t6);
        double _buf1 = Math.fma(-2.0, _t2, 2.0 * this.rX * this.rY);
        double _buf2 = 2.0 * Math.fma(this.rX, this.rZ, _t3);
        double _buf3 = 2.0 * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        double _buf4 = 2.0 * Math.fma(this.rX, this.rY, _t2);
        double _buf5 = Math.fma(-2.0, _t4, _t6);
        double _buf6 = Math.fma(-2.0, this.rX * this.rW, 2.0 * _t5);
        double _buf7 = 2.0 * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        d.m20 = Math.fma(-2.0, _t3, 2.0 * this.rX * this.rZ);
        d.m21 = 2.0 * Math.fma(this.rX, this.rW, _t5);
        d.m22 = Math.fma(-2.0, _t4, Math.fma(-2.0, _t0, 1.0));
        d.m23 = 2.0 * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.m10 = _buf4;
        d.m11 = _buf5;
        d.m12 = _buf6;
        d.m13 = _buf7;
        d.properties = 0;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t110, this.rW * _t111) + Math.fma(this.rY, _t108, -(this.rZ * _t109));
        double _buf1 = Math.fma(this.rY, _t110, this.rZ * _t111) + Math.fma(this.rW, _t109, -(this.rX * _t108));
        double _buf2 = Math.fma(this.rX, _t109, this.rW * _t108) + Math.fma(this.rZ, _t110, -(this.rY * _t111));
        d.rW = Math.fma(-this.rZ, _t108, Math.fma(-this.rY, _t109, Math.fma(this.rW, _t110, -(this.rX * _t111))));
        double _buf3 = Math.fma(this.dX, _t110, this.dW * _t111) + Math.fma(this.dY, _t108, -(this.dZ * _t109));
        double _buf4 = Math.fma(this.dY, _t110, this.dZ * _t111) + Math.fma(this.dW, _t109, -(this.dX * _t108));
        double _buf5 = Math.fma(this.dX, _t109, this.dW * _t108) + Math.fma(this.dZ, _t110, -(this.dY * _t111));
        d.dW = Math.fma(-this.dZ, _t108, Math.fma(-this.dY, _t109, Math.fma(this.dW, _t110, -(this.dX * _t111))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = Math.cos(_t0);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
            this.rX = 0.5 * _t55 * _t64;
            this.rY = 0.5 * _t38 * _t64;
            this.rZ = 0.5 * _t58 * _t64;
            this.rW = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                this.rX = 0.5 * Math.sqrt(_t61);
                this.rY = 0.5 * _t57 * _t67;
                this.rZ = 0.5 * _t37 * _t67;
                this.rW = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    this.rX = 0.5 * _t57 * _t65;
                    this.rY = 0.5 * Math.sqrt(_t62);
                    this.rZ = 0.5 * _t54 * _t65;
                    this.rW = 0.5 * _t38 * _t65;
                } else {
                    this.rX = 0.5 * _t37 * _t66;
                    this.rY = 0.5 * _t54 * _t66;
                    this.rZ = 0.5 * Math.sqrt(_t63);
                    this.rW = 0.5 * _t58 * _t66;
                }
            }
        }
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationX(double angle) {
        double _t0 = 0.5 * angle;
        this.rX = Math.sin(_t0);
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = Math.cos(_t0);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, _t10 * _t8);
        this.rY = Math.fma(_t10, _t5, -(_t9 * _t8));
        this.rZ = Math.fma(_t11, _t5, _t12 * _t8);
        this.rW = Math.fma(_t12, _t5, -(_t11 * _t8));
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.rY = Math.fma(_t11, _t8, -(_t12 * _t5));
        this.rZ = Math.fma(_t9, _t8, _t10 * _t5);
        this.rW = Math.fma(_t12, _t8, _t11 * _t5);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        this.rX = 0.0;
        this.rY = Math.sin(_t0);
        this.rZ = 0.0;
        this.rW = Math.cos(_t0);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, _t10 * _t8);
        this.rY = Math.fma(_t10, _t5, -(_t9 * _t8));
        this.rZ = Math.fma(_t11, _t8, -(_t12 * _t5));
        this.rW = Math.fma(_t12, _t8, _t11 * _t5);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, _t10 * _t8);
        this.rY = Math.fma(_t11, _t5, _t12 * _t8);
        this.rZ = Math.fma(_t12, _t5, -(_t11 * _t8));
        this.rW = Math.fma(_t10, _t5, -(_t9 * _t8));
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleDualQuat makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = Math.sin(_t0);
        this.rW = Math.cos(_t0);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.rY = Math.fma(_t11, _t5, _t12 * _t8);
        this.rZ = Math.fma(_t9, _t8, _t10 * _t5);
        this.rW = Math.fma(_t12, _t5, -(_t11 * _t8));
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        this.rX = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.rY = Math.fma(_t11, _t8, _t12 * _t5);
        this.rZ = Math.fma(_t12, _t8, -(_t11 * _t5));
        this.rW = Math.fma(_t10, _t5, _t9 * _t8);
        this.dX = 0.0;
        this.dY = 0.0;
        this.dZ = 0.0;
        this.dW = 0.0;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -rotationZ;
        double _t1 = -rotationY;
        double _buf0 = Math.fma(rotationX, this.rW, rotationW * this.rX) + Math.fma(rotationZ, this.rY, -(rotationY * this.rZ));
        double _buf1 = Math.fma(rotationX, this.rZ, rotationW * this.rY) + Math.fma(rotationY, this.rW, -(rotationZ * this.rX));
        double _buf2 = Math.fma(rotationY, this.rX, rotationZ * this.rW) + Math.fma(rotationW, this.rZ, -(rotationX * this.rY));
        d.rW = Math.fma(_t0, this.rZ, Math.fma(_t1, this.rY, Math.fma(rotationW, this.rW, -(rotationX * this.rX))));
        double _buf3 = Math.fma(rotationX, this.dW, rotationW * this.dX) + Math.fma(rotationZ, this.dY, -(rotationY * this.dZ));
        double _buf4 = Math.fma(rotationX, this.dZ, rotationW * this.dY) + Math.fma(rotationY, this.dW, -(rotationZ * this.dX));
        double _buf5 = Math.fma(rotationY, this.dX, rotationZ * this.dW) + Math.fma(rotationW, this.dZ, -(rotationX * this.dY));
        d.dW = Math.fma(_t0, this.dZ, Math.fma(_t1, this.dY, Math.fma(rotationW, this.dW, -(rotationX * this.dX))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        double _buf0 = Math.fma(this.rX, _t1, this.rW * _t3) + Math.fma(this.rY, _t4, -(this.rZ * _t5));
        double _buf1 = Math.fma(this.rY, _t1, this.rZ * _t3) + Math.fma(this.rW, _t5, -(this.rX * _t4));
        double _buf2 = Math.fma(this.rX, _t5, this.rW * _t4) + Math.fma(this.rZ, _t1, -(this.rY * _t3));
        d.rW = Math.fma(-this.rZ, _t4, Math.fma(-this.rY, _t5, Math.fma(this.rW, _t1, -(this.rX * _t3))));
        double _buf3 = Math.fma(this.dX, _t1, this.dW * _t3) + Math.fma(this.dY, _t4, -(this.dZ * _t5));
        double _buf4 = Math.fma(this.dY, _t1, this.dZ * _t3) + Math.fma(this.dW, _t5, -(this.dX * _t4));
        double _buf5 = Math.fma(this.dX, _t5, this.dW * _t4) + Math.fma(this.dZ, _t1, -(this.dY * _t3));
        d.dW = Math.fma(-this.dZ, _t4, Math.fma(-this.dY, _t5, Math.fma(this.dW, _t1, -(this.dX * _t3))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(this.rX, _t1, this.rW * _t2);
        double _buf1 = Math.fma(this.rY, _t1, this.rZ * _t2);
        d.rZ = Math.fma(this.rZ, _t1, -(this.rY * _t2));
        d.rW = Math.fma(this.rW, _t1, -(this.rX * _t2));
        double _buf2 = Math.fma(this.dX, _t1, this.dW * _t2);
        double _buf3 = Math.fma(this.dY, _t1, this.dZ * _t2);
        d.dZ = Math.fma(this.dZ, _t1, -(this.dY * _t2));
        d.dW = Math.fma(this.dW, _t1, -(this.dX * _t2));
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t20, -(this.rZ * _t22));
        double _buf1 = Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t22, -(this.rX * _t20));
        double _buf2 = Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t21, -(this.rY * _t19));
        d.rW = Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t21, -(this.rX * _t19))));
        double _buf3 = Math.fma(this.dX, _t21, this.dW * _t19) + Math.fma(this.dY, _t20, -(this.dZ * _t22));
        double _buf4 = Math.fma(this.dY, _t21, this.dZ * _t19) + Math.fma(this.dW, _t22, -(this.dX * _t20));
        double _buf5 = Math.fma(this.dX, _t22, this.dW * _t20) + Math.fma(this.dZ, _t21, -(this.dY * _t19));
        d.dW = Math.fma(-this.dZ, _t20, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t21, -(this.dX * _t19))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t20, -(this.rZ * _t22));
        double _buf1 = Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t22, -(this.rX * _t20));
        double _buf2 = Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t19, -(this.rY * _t21));
        d.rW = Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t21))));
        double _buf3 = Math.fma(this.dX, _t19, this.dW * _t21) + Math.fma(this.dY, _t20, -(this.dZ * _t22));
        double _buf4 = Math.fma(this.dY, _t19, this.dZ * _t21) + Math.fma(this.dW, _t22, -(this.dX * _t20));
        double _buf5 = Math.fma(this.dX, _t22, this.dW * _t20) + Math.fma(this.dZ, _t19, -(this.dY * _t21));
        d.dW = Math.fma(-this.dZ, _t20, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t19, -(this.dX * _t21))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(this.rX, _t1, -(this.rZ * _t2));
        double _buf1 = Math.fma(this.rY, _t1, this.rW * _t2);
        d.rZ = Math.fma(this.rX, _t2, this.rZ * _t1);
        d.rW = Math.fma(this.rW, _t1, -(this.rY * _t2));
        double _buf2 = Math.fma(this.dX, _t1, -(this.dZ * _t2));
        double _buf3 = Math.fma(this.dY, _t1, this.dW * _t2);
        d.dZ = Math.fma(this.dX, _t2, this.dZ * _t1);
        d.dW = Math.fma(this.dW, _t1, -(this.dY * _t2));
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t19, this.rW * _t20) + Math.fma(this.rY, _t21, -(this.rZ * _t22));
        double _buf1 = Math.fma(this.rY, _t19, this.rZ * _t20) + Math.fma(this.rW, _t22, -(this.rX * _t21));
        double _buf2 = Math.fma(this.rX, _t22, this.rW * _t21) + Math.fma(this.rZ, _t19, -(this.rY * _t20));
        d.rW = Math.fma(-this.rZ, _t21, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t20))));
        double _buf3 = Math.fma(this.dX, _t19, this.dW * _t20) + Math.fma(this.dY, _t21, -(this.dZ * _t22));
        double _buf4 = Math.fma(this.dY, _t19, this.dZ * _t20) + Math.fma(this.dW, _t22, -(this.dX * _t21));
        double _buf5 = Math.fma(this.dX, _t22, this.dW * _t21) + Math.fma(this.dZ, _t19, -(this.dY * _t20));
        d.dW = Math.fma(-this.dZ, _t21, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t19, -(this.dX * _t20))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t22, -(this.rZ * _t20));
        double _buf1 = Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t20, -(this.rX * _t22));
        double _buf2 = Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t21, -(this.rY * _t19));
        d.rW = Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t19))));
        double _buf3 = Math.fma(this.dX, _t21, this.dW * _t19) + Math.fma(this.dY, _t22, -(this.dZ * _t20));
        double _buf4 = Math.fma(this.dY, _t21, this.dZ * _t19) + Math.fma(this.dW, _t20, -(this.dX * _t22));
        double _buf5 = Math.fma(this.dX, _t20, this.dW * _t22) + Math.fma(this.dZ, _t21, -(this.dY * _t19));
        d.dW = Math.fma(-this.dZ, _t22, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t21, -(this.dX * _t19))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = Math.fma(this.rX, _t1, this.rY * _t2);
        d.rY = Math.fma(this.rY, _t1, -(this.rX * _t2));
        double _buf1 = Math.fma(this.rZ, _t1, this.rW * _t2);
        d.rW = Math.fma(this.rW, _t1, -(this.rZ * _t2));
        double _buf2 = Math.fma(this.dX, _t1, this.dY * _t2);
        d.dY = Math.fma(this.dY, _t1, -(this.dX * _t2));
        double _buf3 = Math.fma(this.dZ, _t1, this.dW * _t2);
        d.dW = Math.fma(this.dW, _t1, -(this.dZ * _t2));
        d.rX = _buf0;
        d.rZ = _buf1;
        d.dX = _buf2;
        d.dZ = _buf3;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t21, this.rW * _t22) + Math.fma(this.rY, _t19, -(this.rZ * _t20));
        double _buf1 = Math.fma(this.rY, _t21, this.rZ * _t22) + Math.fma(this.rW, _t20, -(this.rX * _t19));
        double _buf2 = Math.fma(this.rX, _t20, this.rW * _t19) + Math.fma(this.rZ, _t21, -(this.rY * _t22));
        d.rW = Math.fma(-this.rZ, _t19, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t22))));
        double _buf3 = Math.fma(this.dX, _t21, this.dW * _t22) + Math.fma(this.dY, _t19, -(this.dZ * _t20));
        double _buf4 = Math.fma(this.dY, _t21, this.dZ * _t22) + Math.fma(this.dW, _t20, -(this.dX * _t19));
        double _buf5 = Math.fma(this.dX, _t20, this.dW * _t19) + Math.fma(this.dZ, _t21, -(this.dY * _t22));
        d.dW = Math.fma(-this.dZ, _t19, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t21, -(this.dX * _t22))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        double _buf0 = Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t22, -(this.rZ * _t20));
        double _buf1 = Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t20, -(this.rX * _t22));
        double _buf2 = Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t19, -(this.rY * _t21));
        d.rW = Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t19, -(this.rX * _t21))));
        double _buf3 = Math.fma(this.dX, _t19, this.dW * _t21) + Math.fma(this.dY, _t22, -(this.dZ * _t20));
        double _buf4 = Math.fma(this.dY, _t19, this.dZ * _t21) + Math.fma(this.dW, _t20, -(this.dX * _t22));
        double _buf5 = Math.fma(this.dX, _t20, this.dW * _t22) + Math.fma(this.dZ, _t19, -(this.dY * _t21));
        d.dW = Math.fma(-this.dZ, _t22, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t19, -(this.dX * _t21))));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _t0 = -this.rZ;
        double _t1 = -this.rX;
        double _t2 = -this.rY;
        double _t3 = 0.5 * translationZ;
        double _t4 = 0.5 * translationY;
        double _t5 = 0.5 * translationX;
        double _buf0 = this.rX;
        double _buf1 = this.rY;
        double _buf2 = this.rZ;
        double _buf3 = this.rW;
        d.dX = Math.fma(this.rY, _t3, Math.fma(_t0, _t4, Math.fma(this.rW, _t5, this.dX)));
        d.dY = Math.fma(this.rW, _t4, Math.fma(_t1, _t3, Math.fma(this.rZ, _t5, this.dY)));
        d.dZ = Math.fma(this.rX, _t4, Math.fma(this.rW, _t3, Math.fma(_t2, _t5, this.dZ)));
        d.dW = Math.fma(_t1, _t5, Math.fma(_t2, _t4, Math.fma(_t0, _t3, this.dW)));
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * Math.fma(pY, this.rX, -(pX * this.rY));
        double _t10 = 2.0 * Math.fma(pX, this.rZ, -(pZ * this.rX));
        double _t11 = 2.0 * Math.fma(pZ, this.rY, -(pY * this.rZ));
        double _buf0 = Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, Math.fma(2.0, Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)), pX))));
        double _buf1 = Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, Math.fma(2.0, Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)), pY))));
        d.z = Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, Math.fma(2.0, Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)), pZ))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * Math.fma(this.rX, vY, -(this.rY * vX));
        double _t10 = 2.0 * Math.fma(this.rZ, vX, -(this.rX * vZ));
        double _t11 = 2.0 * Math.fma(this.rY, vZ, -(this.rZ * vY));
        double _buf0 = Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, vX)));
        double _buf1 = Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vY)));
        d.z = Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * Math.fma(this.rX, vZ, -(this.rZ * vX));
        double _t10 = 2.0 * Math.fma(this.rY, vX, -(this.rX * vY));
        double _t11 = 2.0 * Math.fma(this.rZ, vY, -(this.rY * vZ));
        double _buf0 = Math.fma(this.rZ, _t9, Math.fma(-this.rY, _t10, Math.fma(this.rW, _t11, vX)));
        double _buf1 = Math.fma(this.rX, _t10, Math.fma(-this.rZ, _t11, Math.fma(this.rW, _t9, vY)));
        d.z = Math.fma(this.rY, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        double _t21 = Math.fma(-2.0, Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)), pZ);
        double _t22 = Math.fma(-2.0, Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)), pX);
        double _t23 = Math.fma(-2.0, Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)), pY);
        double _t33 = 2.0 * Math.fma(this.rX, _t21, -(this.rZ * _t22));
        double _t34 = 2.0 * Math.fma(this.rY, _t22, -(this.rX * _t23));
        double _t35 = 2.0 * Math.fma(this.rZ, _t23, -(this.rY * _t21));
        double _buf0 = Math.fma(this.rZ, _t33, Math.fma(-this.rY, _t34, Math.fma(this.rW, _t35, _t22)));
        double _buf1 = Math.fma(this.rX, _t34, Math.fma(-this.rZ, _t35, Math.fma(this.rW, _t33, _t23)));
        d.z = Math.fma(this.rY, _t35, Math.fma(-this.rX, _t33, Math.fma(this.rW, _t34, _t21)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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

    public double rX() { return this.rX; }
    public double rY() { return this.rY; }
    public double rZ() { return this.rZ; }
    public double rW() { return this.rW; }
    public double dX() { return this.dX; }
    public double dY() { return this.dY; }
    public double dZ() { return this.dZ; }
    public double dW() { return this.dW; }

    @Override public String toString() {
        return "DoubleDualQuat(" + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ", " + dX() + ", " + dY() + ", " + dZ() + ", " + dW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleDualQuatImpl)) return false;
        DoubleDualQuatImpl o = (DoubleDualQuatImpl) obj;
        return Double.doubleToLongBits(rX) == Double.doubleToLongBits(o.rX)
            && Double.doubleToLongBits(rY) == Double.doubleToLongBits(o.rY)
            && Double.doubleToLongBits(rZ) == Double.doubleToLongBits(o.rZ)
            && Double.doubleToLongBits(rW) == Double.doubleToLongBits(o.rW)
            && Double.doubleToLongBits(dX) == Double.doubleToLongBits(o.dX)
            && Double.doubleToLongBits(dY) == Double.doubleToLongBits(o.dY)
            && Double.doubleToLongBits(dZ) == Double.doubleToLongBits(o.dZ)
            && Double.doubleToLongBits(dW) == Double.doubleToLongBits(o.dW);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(rX) ^ (Double.doubleToLongBits(rX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rY) ^ (Double.doubleToLongBits(rY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rZ) ^ (Double.doubleToLongBits(rZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rW) ^ (Double.doubleToLongBits(rW) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dX) ^ (Double.doubleToLongBits(dX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dY) ^ (Double.doubleToLongBits(dY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dZ) ^ (Double.doubleToLongBits(dZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dW) ^ (Double.doubleToLongBits(dW) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(rX)
            && Double.isFinite(rY)
            && Double.isFinite(rZ)
            && Double.isFinite(rW)
            && Double.isFinite(dX)
            && Double.isFinite(dY)
            && Double.isFinite(dZ)
            && Double.isFinite(dW);
    }

    @Override public boolean equalsEpsilon(DoubleDualQuatR other, double epsilon) {
        return Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon
            && Math.abs(dX - other.dX()) <= epsilon
            && Math.abs(dY - other.dY()) <= epsilon
            && Math.abs(dZ - other.dZ()) <= epsilon
            && Math.abs(dW - other.dW()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.rX;
        dest[offset + 1] = this.rY;
        dest[offset + 2] = this.rZ;
        dest[offset + 3] = this.rW;
        dest[offset + 4] = this.dX;
        dest[offset + 5] = this.dY;
        dest[offset + 6] = this.dZ;
        dest[offset + 7] = this.dW;
        return dest;
    }
    public @Mutated DoubleDualQuat load(double[] src, int offset) {
        this.rX = src[offset + 0];
        this.rY = src[offset + 1];
        this.rZ = src[offset + 2];
        this.rW = src[offset + 3];
        this.dX = src[offset + 4];
        this.dY = src[offset + 5];
        this.dZ = src[offset + 6];
        this.dW = src[offset + 7];
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
        dest[offset + 0] = (float) this.rX;
        dest[offset + 1] = (float) this.rY;
        dest[offset + 2] = (float) this.rZ;
        dest[offset + 3] = (float) this.rW;
        dest[offset + 4] = (float) this.dX;
        dest[offset + 5] = (float) this.dY;
        dest[offset + 6] = (float) this.dZ;
        dest[offset + 7] = (float) this.dW;
        return dest;
    }
    public @Mutated DoubleDualQuat load(float[] src, int offset) {
        this.rX = src[offset + 0];
        this.rY = src[offset + 1];
        this.rZ = src[offset + 2];
        this.rW = src[offset + 3];
        this.dX = src[offset + 4];
        this.dY = src[offset + 5];
        this.dZ = src[offset + 6];
        this.dW = src[offset + 7];
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
