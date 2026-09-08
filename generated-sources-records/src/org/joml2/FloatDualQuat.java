package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable dual quaternion of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param rX the {@code rX} component
 * @param rY the {@code rY} component
 * @param rZ the {@code rZ} component
 * @param rW the {@code rW} component
 * @param dX the {@code dX} component
 * @param dY the {@code dY} component
 * @param dZ the {@code dZ} component
 * @param dW the {@code dW} component
 */
public record FloatDualQuat(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 32;

    /** The zero dual quaternion (all components 0). */
    public static final FloatDualQuat ZERO = new FloatDualQuat(0, 0, 0, 0, 0, 0, 0, 0);

    /** The identity dual quaternion. */
    public static final FloatDualQuat IDENTITY = new FloatDualQuat();

    /** Canonical constructor. */
    public FloatDualQuat(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) {
        this.rX = rX;
        this.rY = rY;
        this.rZ = rZ;
        this.rW = rW;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
        this.dW = dW;
    }

    /**
     * Create a new instance initialized to the identity.
     */
    public FloatDualQuat() {
        this(0, 0, 0, 1, 0, 0, 0, 0);
    }

    /** {@return the {@code rX} component} */
    public float rX() { return rX; }
    /** {@return the {@code rY} component} */
    public float rY() { return rY; }
    /** {@return the {@code rZ} component} */
    public float rZ() { return rZ; }
    /** {@return the {@code rW} component} */
    public float rW() { return rW; }
    /** {@return the {@code dX} component} */
    public float dX() { return dX; }
    /** {@return the {@code dY} component} */
    public float dY() { return dY; }
    /** {@return the {@code dZ} component} */
    public float dZ() { return dZ; }
    /** {@return the {@code dW} component} */
    public float dW() { return dW; }


    /**
     * Add {@code other} to this dual quaternion, returning the result as a value.
     *
     * @param other the other dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat add(FloatDualQuat other) {
        return add(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }


    /**
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) to this dual quaternion, returning the
     * result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat add(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        return new FloatDualQuat(otherRX + this.rX, otherRY + this.rY, otherRZ + this.rZ, otherRW + this.rW, otherDX + this.dX, otherDY + this.dY, otherDZ + this.dZ, otherDW + this.dW);
    }


    /**
     * Multiply each component of this dual quaternion by {@code scalar}, returning the result as a
     * value.
     *
     * @param scalar the scalar value
     * @return the resulting dual quaternion
     */
    public FloatDualQuat mul(float scalar) {
        return new FloatDualQuat(scalar * this.rX, scalar * this.rY, scalar * this.rZ, scalar * this.rW, scalar * this.dX, scalar * this.dY, scalar * this.dZ, scalar * this.dW);
    }


    /**
     * Negate this dual quaternion, returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat negate() {
        return new FloatDualQuat(-this.rX, -this.rY, -this.rZ, -this.rW, -this.dX, -this.dY, -this.dZ, -this.dW);
    }


    /**
     * Subtract {@code other} from this dual quaternion, returning the result as a value.
     *
     * @param other the other dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat sub(FloatDualQuat other) {
        return sub(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }


    /**
     * Subtract ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) from this dual
     * quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat sub(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        return new FloatDualQuat(this.rX - otherRX, this.rY - otherRY, this.rZ - otherRZ, this.rW - otherRW, this.dX - otherDX, this.dY - otherDY, this.dZ - otherDZ, this.dW - otherDW);
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param v the dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(FloatDualQuat v) {
        return set(v.rX(), v.rY(), v.rZ(), v.rW(), v.dX(), v.dY(), v.dZ(), v.dW());
    }


    /**
     * Create a new dual quaternion from the given values.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(float vRX, float vRY, float vRZ, float vRW, float vDX, float vDY, float vDZ, float vDW) {
        return new FloatDualQuat(vRX, vRY, vRZ, vRW, vDX, vDY, vDZ, vDW);
    }


    /**
     * Convert this dual quaternion to {@code double} precision, returning the result as a new
     * instance.
     *
     * @return a new {@code DoubleDualQuat} holding the result
     */
    public DoubleDualQuat toDouble() {
        return new DoubleDualQuat(this.rX, this.rY, this.rZ, this.rW, this.dX, this.dY, this.dZ, this.dW);
    }


    /**
     * Create the rigid motion of the given rigid transform (an exact conversion - both represent
     * rotation plus translation).
     *
     * @param r the rigid transform
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromRigid(FloatRigid r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Create the rigid motion of the given rigid transform (an exact conversion - both represent
     * rotation plus translation).
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromRigid(float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        float _t0 = -rTZ;
        return new FloatDualQuat(rRX, rRY, rRZ, rRW, 0.5f * Math.fma(_t0, rRY, Math.fma(rTX, rRW, rTY * rRZ)), 0.5f * Math.fma(rTZ, rRX, Math.fma(rTY, rRW, -(rTX * rRZ))), 0.5f * Math.fma(rTZ, rRW, Math.fma(rTX, rRY, -(rTY * rRX))), 0.5f * Math.fma(_t0, rRZ, Math.fma(-rTY, rRY, -(rTX * rRX))));
    }


    /**
     * Create the rigid motion (rotation and translation) of the given transform; the scale is
     * dropped (dual quaternions cannot represent it).
     *
     * @param t the transform
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromTransform(FloatTransform t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Create the rigid motion (rotation and translation) of the given transform; the scale is
     * dropped (dual quaternions cannot represent it).
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = -tTZ;
        return new FloatDualQuat(tRX, tRY, tRZ, tRW, 0.5f * Math.fma(_t0, tRY, Math.fma(tTX, tRW, tTY * tRZ)), 0.5f * Math.fma(tTZ, tRX, Math.fma(tTY, tRW, -(tTX * tRZ))), 0.5f * Math.fma(tTZ, tRW, Math.fma(tTX, tRY, -(tTY * tRX))), 0.5f * Math.fma(_t0, tRZ, Math.fma(-tTY, tRY, -(tTX * tRX))));
    }


    /**
     * Convert this unit dual quaternion to a rigid transform (an exact conversion - both represent
     * rotation plus translation), returning the result as a value.
     *
     * @return the resulting rigid transform
     */
    public FloatRigid toRigid() {
        return new FloatRigid(2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW))), 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW))), 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW))), this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Convert this unit dual quaternion to a TRS transform (translation and rotation from the rigid
     * motion, scale = 1), returning the result as a value.
     *
     * @return the resulting transform
     */
    public FloatTransform toTransform() {
        return new FloatTransform(2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW))), 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW))), 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW))), this.rX, this.rY, this.rZ, this.rW, 1.0f, 1.0f, 1.0f);
    }


    /**
     * Determine whether the real (rotation) part of this dual quaternion has unit length.
     *
     * @param epsilon the maximum allowed deviation of the squared real-part length from {@code 1}
     * @return {@code true} if the real (rotation) part of this dual quaternion has unit length,
     *        {@code false} otherwise
     */
    public boolean isUnit(float epsilon) {
        return Math.abs(Math.fma(this.rX, this.rX, Math.fma(this.rY, this.rY, Math.fma(this.rZ, this.rZ, Math.fma(this.rW, this.rW, -1.0f))))) <= epsilon;
    }


    /**
     * Create the rotation of {@code angle} radians about the axis {@code axis}, combined with a
     * translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromAxisAngle(Float3 axis, float angle, Float3 translation) {
        return makeFromAxisAngle(axis.x(), axis.y(), axis.z(), angle, translation.x(), translation.y(), translation.z());
    }


    /**
     * Create the rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}), combined with a translation by ({@code translationX}, {@code translationY},
     * {@code translationZ}).
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromAxisAngle(float axisX, float axisY, float axisZ, float angle, float translationX, float translationY, float translationZ) {
        float _t0 = 0.5f * angle;
        float _t1 = -translationZ;
        float _t2 = (float) Math.sin(_t0);
        float _t3 = (float) Math.cos(_t0);
        float _t4 = axisX * _t2;
        float _t5 = axisY * _t2;
        float _t6 = axisZ * _t2;
        return new FloatDualQuat(_t4, _t5, _t6, _t3, 0.5f * Math.fma(_t1, _t5, Math.fma(translationX, _t3, translationY * _t6)), 0.5f * Math.fma(translationZ, _t4, Math.fma(translationY, _t3, -(translationX * _t6))), 0.5f * Math.fma(translationZ, _t3, Math.fma(translationX, _t5, -(translationY * _t4))), 0.5f * Math.fma(_t1, _t6, Math.fma(-translationY, _t5, -(translationX * _t4))));
    }


    /**
     * Create an identity dual quaternion.
     *
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeIdentity() {
        return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rigid transformation that first rotates by {@code rotation} and then translates by
     * {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeTranslationRotation(Float3 translation, FloatQuat rotation) {
        return makeTranslationRotation(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a rigid transformation that first rotates by ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) and then translates by ({@code translationX},
     * {@code translationY}, {@code translationZ}) ({@code T * R}).
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeTranslationRotation(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW) {
        float _t0 = -rotationY;
        return new FloatDualQuat(rotationX, rotationY, rotationZ, rotationW, 0.5f * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX)), 0.5f * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX))), 0.5f * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY))), 0.5f * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX))));
    }


    /**
     * Create an all-zero dual quaternion.
     *
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeZero() {
        return FloatDualQuat.ZERO;
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param rotation the quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(FloatQuat rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatDualQuat(rotationX, rotationY, rotationZ, rotationW, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a new dual quaternion from the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotation(FloatQuat rotation) {
        return makeRotation(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a new dual quaternion from the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotation(float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatDualQuat(rotationX, rotationY, rotationZ, rotationW, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param rotation the quaternion
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(FloatQuat rotation, Float3 translation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w(), translation.x(), translation.y(), translation.z());
    }


    /**
     * Create a new dual quaternion from the given values.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(float rotationX, float rotationY, float rotationZ, float rotationW, float translationX, float translationY, float translationZ) {
        float _t0 = -rotationY;
        return new FloatDualQuat(rotationX, rotationY, rotationZ, rotationW, 0.5f * Math.fma(_t0, translationZ, Math.fma(rotationZ, translationY, rotationW * translationX)), 0.5f * Math.fma(rotationX, translationZ, Math.fma(rotationW, translationY, -(rotationZ * translationX))), 0.5f * Math.fma(rotationW, translationZ, Math.fma(rotationY, translationX, -(rotationX * translationY))), 0.5f * Math.fma(-rotationZ, translationZ, Math.fma(_t0, translationY, -(rotationX * translationX))));
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(Float3 translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Create a new dual quaternion from the given values.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat set(float translationX, float translationY, float translationZ) {
        return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, 0.5f * translationX, 0.5f * translationY, 0.5f * translationZ, 0.0f);
    }


    /**
     * Create a new dual quaternion from the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeTranslation(Float3 translation) {
        return makeTranslation(translation.x(), translation.y(), translation.z());
    }


    /**
     * Create a new dual quaternion from the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeTranslation(float translationX, float translationY, float translationZ) {
        return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, 0.5f * translationX, 0.5f * translationY, 0.5f * translationZ, 0.0f);
    }


    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t}, returning the result as a value.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat dlb(FloatDualQuat other, float t) {
        return dlb(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t);
    }


    /**
     * Blend this dual quaternion with ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) using
     * dual-quaternion linear blending with the weight {@code t}, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat dlb(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t) {
        float _t9 = Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t14 = Math.fma(t, Math.fma(otherRX, _t9, -this.rX), this.rX);
        float _t15 = Math.fma(t, Math.fma(otherRY, _t9, -this.rY), this.rY);
        float _t16 = Math.fma(t, Math.fma(otherRZ, _t9, -this.rZ), this.rZ);
        float _t17 = Math.fma(t, Math.fma(otherRW, _t9, -this.rW), this.rW);
        float _t23 = (1.0f / (float) Math.sqrt(Math.fma(_t14, _t14, _t15 * _t15) + Math.fma(_t16, _t16, _t17 * _t17)));
        return new FloatDualQuat(_t14 * _t23, _t15 * _t23, _t16 * _t23, _t17 * _t23, Math.fma(t, Math.fma(otherDX, _t9, -this.dX), this.dX) * _t23, Math.fma(t, Math.fma(otherDY, _t9, -this.dY), this.dY) * _t23, Math.fma(t, Math.fma(otherDZ, _t9, -this.dZ), this.dZ) * _t23, Math.fma(t, Math.fma(otherDW, _t9, -this.dW), this.dW) * _t23);
    }


    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t}, returning the result as a value.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat lerp(FloatDualQuat other, float t) {
        return lerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t);
    }


    /**
     * Linearly interpolate between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}) using the interpolation factor {@code t}, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat lerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t) {
        return new FloatDualQuat(Math.fma(t, otherRX - this.rX, this.rX), Math.fma(t, otherRY - this.rY, this.rY), Math.fma(t, otherRZ - this.rZ, this.rZ), Math.fma(t, otherRW - this.rW, this.rW), Math.fma(t, otherDX - this.dX, this.dX), Math.fma(t, otherDY - this.dY, this.dY), Math.fma(t, otherDZ - this.dZ, this.dZ), Math.fma(t, otherDW - this.dW, this.dW));
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t}, returning the result as a value.
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat sclerp(FloatDualQuat other, float t) {
        return sclerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t);
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) using the interpolation factor {@code t},
     * returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat sclerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t) {
        float _t0 = -this.rZ;
        float _t1 = -this.dZ;
        float _t8 = Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t9 = otherRX * _t8;
        float _t10 = otherRW * _t8;
        float _t11 = otherRZ * _t8;
        float _t12 = otherRY * _t8;
        float _t13 = otherDX * _t8;
        float _t14 = otherDW * _t8;
        float _t15 = otherDY * _t8;
        float _t16 = otherDZ * _t8;
        float _t49 = -(this.dX * _t10);
        float _t53 = -(this.dX * _t12);
        float _t64 = Math.fma(this.dX, _t11, this.dW * _t12);
        float _t71 = Math.fma(this.dZ, _t12, -(this.dY * _t11));
        float _t75 = Math.fma(this.dY, _t9, -(this.dZ * _t10));
        float _t81 = Math.fma(this.rZ, _t11, Math.fma(this.rY, _t12, Math.fma(this.rX, _t9, this.rW * _t10)));
        float _t84 = Math.fma(this.rY, _t9, -(this.rZ * _t10)) + Math.fma(this.rW, _t11, -(this.rX * _t12));
        float _t85 = Math.fma(this.rX, _t11, this.rW * _t12) + Math.fma(_t0, _t9, -(this.rY * _t10));
        float _t86 = Math.fma(this.rZ, _t12, -(this.rY * _t11)) + Math.fma(this.rW, _t9, -(this.rX * _t10));
        float _t87 = Math.fma(this.rZ, _t15, -(this.rY * _t16)) + Math.fma(this.rW, _t13, -(this.rX * _t14));
        float _t89 = Math.fma(this.rY, _t13, -(this.rZ * _t14)) + Math.fma(this.rW, _t16, -(this.rX * _t15));
        float _t91 = Math.fma(this.rX, _t16, this.rW * _t15) + Math.fma(_t0, _t13, -(this.rY * _t14));
        float _t93 = Math.fma(this.rX, _t13, this.rW * _t14) + Math.fma(this.rY, _t15, this.rZ * _t16) + (Math.fma(this.dX, _t9, this.dW * _t10) + Math.fma(this.dY, _t12, this.dZ * _t11));
        float _t99 = t * (_t87 + (_t71 + Math.fma(this.dW, _t9, _t49)));
        float _t100 = t * (_t89 + (_t75 + Math.fma(this.dW, _t11, _t53)));
        float _t101 = t * (_t91 + (_t64 + Math.fma(_t1, _t9, -(this.dY * _t10))));
        float _t109 = Math.fma(_t84, _t84, Math.fma(_t85, _t85, _t86 * _t86));
        float _t111 = (1.0f / (float) Math.sqrt(_t109));
        float _t113 = t * (float) Math.atan2((float) Math.sqrt(_t109), _t81);
        float _t114 = (float) Math.cos(_t113);
        float _t115 = _t86 * _t111;
        float _t116 = (float) Math.sin(_t113);
        float _t117 = _t84 * _t111;
        float _t118 = _t85 * _t111;
        float _t119 = _t93 * _t111;
        float _t120 = t * _t119;
        float _t121 = _t81 * _t119;
        float _t122, _t140, _t141, _t142, _t149;
        if (_t109 < 1.0e-12f) {
            _t122 = 1.0f;
            _t140 = 0.0f;
            _t141 = 0.0f;
            _t142 = 0.0f;
            _t149 = t * _t93;
        } else {
            _t122 = _t114;
            _t140 = _t115 * _t116;
            _t141 = _t117 * _t116;
            _t142 = _t118 * _t116;
            _t149 = _t120 * _t116;
        }
        float _t127 = _t120 * _t114;
        float _t156, _t157, _t158;
        if (_t109 < 1.0e-12f) {
            if (_t81 < 0.0f) {
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
        return new FloatDualQuat(Math.fma(this.rX, _t122, this.rW * _t140) + Math.fma(this.rY, _t141, -(this.rZ * _t142)), Math.fma(this.rY, _t122, this.rZ * _t140) + Math.fma(this.rW, _t142, -(this.rX * _t141)), Math.fma(this.rX, _t142, this.rW * _t141) + Math.fma(this.rZ, _t122, -(this.rY * _t140)), Math.fma(_t0, _t141, Math.fma(-this.rY, _t142, Math.fma(this.rW, _t122, -(this.rX * _t140)))), Math.fma(this.rX, _t149, this.rW * _t156) + Math.fma(this.rY, _t157, -(this.rZ * _t158)) + (Math.fma(this.dX, _t122, this.dW * _t140) + Math.fma(this.dY, _t141, -(this.dZ * _t142))), Math.fma(this.rY, _t149, this.rZ * _t156) + Math.fma(this.rW, _t158, -(this.rX * _t157)) + (Math.fma(this.dY, _t122, this.dZ * _t140) + Math.fma(this.dW, _t142, -(this.dX * _t141))), Math.fma(this.rX, _t158, this.rW * _t157) + Math.fma(this.rZ, _t149, -(this.rY * _t156)) + (Math.fma(this.dX, _t142, this.dW * _t141) + Math.fma(this.dZ, _t122, -(this.dY * _t140))), Math.fma(this.rW, _t149, -(this.rX * _t156)) + Math.fma(_t0, _t157, -(this.rY * _t158)) + (Math.fma(this.dW, _t122, -(this.dX * _t140)) + Math.fma(_t1, _t141, -(this.dY * _t142))));
    }


    /**
     * Multiply this dual quaternion by {@code other}, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the other dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat mul(FloatDualQuat other) {
        return mul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }

    /** Private tail of {@code mul}; reached only through it. */
    private FloatDualQuat mul_s401e608_tail(float otherRX, float otherRW, float otherRY, float otherRZ, float otherDX, float otherDW, float otherDY, float otherDZ, float _t0, float _sfx0, float _sfx1, float _sfx2, float _sfx3, float _sfx4) {
        float _sfx5 = Math.fma(otherRX, this.dZ, otherRW * this.dY) + Math.fma(otherRY, this.dW, -(otherRZ * this.dX)) + (Math.fma(otherDX, this.rZ, otherDW * this.rY) + Math.fma(otherDY, this.rW, -(otherDZ * this.rX)));
        float _sfx6 = Math.fma(otherRY, this.dX, otherRZ * this.dW) + Math.fma(otherRW, this.dZ, -(otherRX * this.dY)) + (Math.fma(otherDY, this.rX, otherDZ * this.rW) + Math.fma(otherDW, this.rZ, -(otherDX * this.rY)));
        float _sfx7 = Math.fma(otherRW, this.dW, -(otherRX * this.dX)) + Math.fma(_t0, this.dZ, -(otherRY * this.dY)) + (Math.fma(otherDW, this.rW, -(otherDX * this.rX)) + Math.fma(-otherDZ, this.rZ, -(otherDY * this.rY)));
        return new FloatDualQuat(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6, _sfx7);
    }


    /**
     * Multiply this dual quaternion by ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}),
     * returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat mul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        float _t0 = -otherRZ;
        float _sfx0 = Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRZ, this.rY, -(otherRY * this.rZ));
        float _sfx1 = Math.fma(otherRX, this.rZ, otherRW * this.rY) + Math.fma(otherRY, this.rW, -(otherRZ * this.rX));
        float _sfx2 = Math.fma(otherRY, this.rX, otherRZ * this.rW) + Math.fma(otherRW, this.rZ, -(otherRX * this.rY));
        float _sfx3 = Math.fma(_t0, this.rZ, Math.fma(-otherRY, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX))));
        float _sfx4 = Math.fma(otherRX, this.dW, otherRW * this.dX) + Math.fma(otherRZ, this.dY, -(otherRY * this.dZ)) + (Math.fma(otherDX, this.rW, otherDW * this.rX) + Math.fma(otherDZ, this.rY, -(otherDY * this.rZ)));
        return mul_s401e608_tail(otherRX, otherRW, otherRY, otherRZ, otherDX, otherDW, otherDY, otherDZ, _t0, _sfx0, _sfx1, _sfx2, _sfx3, _sfx4);
    }


    /**
     * Pre-multiply {@code other} onto this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     *
     * @param other the other dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat preMul(FloatDualQuat other) {
        return preMul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }

    /** Private tail of {@code preMul}; reached only through it. */
    private FloatDualQuat preMul_s401e608_tail(float otherRY, float otherRZ, float otherRW, float otherRX, float otherDY, float otherDZ, float otherDW, float otherDX, float _t0, float _sfx0, float _sfx1, float _sfx2, float _sfx3, float _sfx4) {
        float _sfx5 = Math.fma(otherRY, this.dW, otherRZ * this.dX) + Math.fma(otherRW, this.dY, -(otherRX * this.dZ)) + (Math.fma(otherDY, this.rW, otherDZ * this.rX) + Math.fma(otherDW, this.rY, -(otherDX * this.rZ)));
        float _sfx6 = Math.fma(otherRX, this.dY, otherRW * this.dZ) + Math.fma(otherRZ, this.dW, -(otherRY * this.dX)) + (Math.fma(otherDX, this.rY, otherDW * this.rZ) + Math.fma(otherDZ, this.rW, -(otherDY * this.rX)));
        float _sfx7 = Math.fma(otherRW, this.dW, -(otherRX * this.dX)) + Math.fma(_t0, this.dZ, -(otherRY * this.dY)) + (Math.fma(otherDW, this.rW, -(otherDX * this.rX)) + Math.fma(-otherDZ, this.rZ, -(otherDY * this.rY)));
        return new FloatDualQuat(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6, _sfx7);
    }


    /**
     * Pre-multiply ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) onto this dual
     * quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat preMul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        float _t0 = -otherRZ;
        float _sfx0 = Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY));
        float _sfx1 = Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(otherRW, this.rY, -(otherRX * this.rZ));
        float _sfx2 = Math.fma(otherRX, this.rY, otherRW * this.rZ) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX));
        float _sfx3 = Math.fma(_t0, this.rZ, Math.fma(-otherRY, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX))));
        float _sfx4 = Math.fma(otherRX, this.dW, otherRW * this.dX) + Math.fma(otherRY, this.dZ, -(otherRZ * this.dY)) + (Math.fma(otherDX, this.rW, otherDW * this.rX) + Math.fma(otherDY, this.rZ, -(otherDZ * this.rY)));
        return preMul_s401e608_tail(otherRY, otherRZ, otherRW, otherRX, otherDY, otherDZ, otherDW, otherDX, _t0, _sfx0, _sfx1, _sfx2, _sfx3, _sfx4);
    }


    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion, returning the result as a
     * value.
     *
     * @param other the other dual quaternion
     * @param weight the factor to scale {@code other} by before adding
     * @return the resulting dual quaternion
     */
    public FloatDualQuat addScaled(FloatDualQuat other, float weight) {
        return addScaled(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), weight);
    }


    /**
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) scaled by {@code weight} to this dual
     * quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat addScaled(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float weight) {
        return new FloatDualQuat(Math.fma(weight, otherRX, this.rX), Math.fma(weight, otherRY, this.rY), Math.fma(weight, otherRZ, this.rZ), Math.fma(weight, otherRW, this.rW), Math.fma(weight, otherDX, this.dX), Math.fma(weight, otherDY, this.dY), Math.fma(weight, otherDZ, this.dZ), Math.fma(weight, otherDW, this.dW));
    }


    /**
     * Compute the quaternion conjugate of this dual quaternion, conjugating both the real and the
     * dual part (for a unit dual quaternion this is its inverse), returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat conjugate() {
        return new FloatDualQuat(-this.rX, -this.rY, -this.rZ, this.rW, -this.dX, -this.dY, -this.dZ, this.dW);
    }


    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other}, returning the
     * result as a value.
     *
     * @param other the other dual quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat difference(FloatDualQuat other) {
        return difference(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW());
    }

    /** Private tail of {@code difference}; reached only through it. */
    private FloatDualQuat difference_s401e608_tail(float otherRY, float otherRZ, float _t0, float otherRW, float otherDY, float otherDZ, float otherDX, float otherDW, float otherRX, float _sfx0, float _sfx1, float _sfx2, float _sfx3, float _sfx4) {
        float _sfx5 = Math.fma(otherRY, this.dW, otherRZ * this.dX) + Math.fma(_t0, this.dZ, -(otherRW * this.dY)) + (Math.fma(otherDY, this.rW, otherDZ * this.rX) + Math.fma(-otherDX, this.rZ, -(otherDW * this.rY)));
        float _sfx6 = Math.fma(otherRX, this.dY, -(otherRW * this.dZ)) + Math.fma(otherRZ, this.dW, -(otherRY * this.dX)) + (Math.fma(otherDX, this.rY, -(otherDW * this.rZ)) + Math.fma(otherDZ, this.rW, -(otherDY * this.rX)));
        float _sfx7 = Math.fma(otherRX, this.dX, otherRW * this.dW) + Math.fma(otherRY, this.dY, otherRZ * this.dZ) + (Math.fma(otherDX, this.rX, otherDW * this.rW) + Math.fma(otherDY, this.rY, otherDZ * this.rZ));
        return new FloatDualQuat(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6, _sfx7);
    }


    /**
     * Compute the difference between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}), i.e. the rigid transformation that, applied after {@code this}, results in
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}), returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat difference(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        float _t0 = -otherRX;
        float _sfx0 = Math.fma(otherRX, this.rW, -(otherRW * this.rX)) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY));
        float _sfx1 = Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(_t0, this.rZ, -(otherRW * this.rY));
        float _sfx2 = Math.fma(otherRX, this.rY, -(otherRW * this.rZ)) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX));
        float _sfx3 = Math.fma(otherRZ, this.rZ, Math.fma(otherRY, this.rY, Math.fma(otherRX, this.rX, otherRW * this.rW)));
        float _sfx4 = Math.fma(otherRX, this.dW, -(otherRW * this.dX)) + Math.fma(otherRY, this.dZ, -(otherRZ * this.dY)) + (Math.fma(otherDX, this.rW, -(otherDW * this.rX)) + Math.fma(otherDY, this.rZ, -(otherDZ * this.rY)));
        return difference_s401e608_tail(otherRY, otherRZ, _t0, otherRW, otherDY, otherDZ, otherDX, otherDW, otherRX, _sfx0, _sfx1, _sfx2, _sfx3, _sfx4);
    }


    /**
     * Compute the dot product of this dual quaternion and {@code other}.
     *
     * @param other the other dual quaternion
     * @return the dot product of this dual quaternion and {@code other}
     */
    public float dot(FloatDualQuat other) {
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
    public float dot(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW) {
        return Math.fma(otherRX, this.rX, otherRY * this.rY) + Math.fma(otherRZ, this.rZ, otherRW * this.rW) + (Math.fma(otherDX, this.dX, otherDY * this.dY) + Math.fma(otherDZ, this.dZ, otherDW * this.dW));
    }


    /**
     * Compute the dual-number conjugate of this dual quaternion, returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat dualConjugate() {
        return new FloatDualQuat(this.rX, this.rY, this.rZ, this.rW, -this.dX, -this.dY, -this.dZ, -this.dW);
    }


    /**
     * Compute the exponential of this dual quaternion, returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat exp() {
        float _t4 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        float _t6 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = (float) Math.sqrt(_t4);
        float _t8 = (float) Math.sin(_t7);
        float _t9 = (float) Math.cos(_t7);
        float _t10 = this.rX * _t6;
        float _t11 = this.rY * _t6;
        float _t12 = this.rZ * _t6;
        float _t13 = Math.fma(this.rZ, this.dZ, Math.fma(this.rX, this.dX, this.rY * this.dY)) * _t6;
        float _t14 = _t13 * _t9;
        if (_t4 < 1.0e-12f) {
            return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, this.dX, this.dY, this.dZ, 0.0f);
        } else {
            return new FloatDualQuat(_t10 * _t8, _t11 * _t8, _t12 * _t8, _t9, Math.fma(_t10, _t14, Math.fma(-_t10, _t13, this.dX) * _t6 * _t8), Math.fma(_t11, _t14, Math.fma(-_t11, _t13, this.dY) * _t6 * _t8), Math.fma(_t12, _t14, Math.fma(-_t12, _t13, this.dZ) * _t6 * _t8), -(_t13 * _t8));
        }
    }


    /**
     * Get the dual part of this dual quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getDual() {
        return new FloatQuat(this.dX, this.dY, this.dZ, this.dW);
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Y and Z
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXYZ() {
        float _t1 = this.rY * this.rZ;
        float _t3 = this.rZ * this.rZ;
        float _t8 = 2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        float _t9 = 2.0f * Math.fma(this.rX, this.rW, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, _t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t3), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), 0.0f);
        } else {
            return new Float3((float) Math.atan2(_t9, _t10), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Z and Y
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXZY() {
        float _t0 = this.rZ * this.rZ;
        float _t1 = this.rY * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rW, _t1);
        float _t8 = 2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, -_t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), 0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        } else {
            return new Float3((float) Math.atan2(_t7, _t9), (float) Math.atan2(2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        }
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, X and Z
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYXZ() {
        float _t3 = this.rZ * this.rZ;
        float _t8 = 2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        float _t9 = 2.0f * Math.fma(this.rX, this.rW, -(this.rY * this.rZ));
        float _t10 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))), (float) Math.atan2(2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t3), 1.0f)), 0.0f);
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))), (float) Math.atan2(_t8, _t10), (float) Math.atan2(2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, Z and X
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYZX() {
        float _t0 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        float _t8 = 2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.atan2(2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, -(this.rY * this.rZ)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f)), (float) Math.atan2(_t8, _t9), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        }
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, X and Y
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZXY() {
        float _t1 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ);
        float _t8 = 2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))), 0.0f, (float) Math.atan2(2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t1), 1.0f)));
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))), (float) Math.atan2(2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.atan2(_t8, _t9));
        }
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, Y and X
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZYX() {
        float _t0 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        float _t8 = 2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f)));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(_t7, _t9));
        }
    }


    /**
     * Get the rotation of this dual quaternion, i.e. its raw real part (a unit quaternion only when
     * this dual quaternion has unit length), returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getRotation() {
        return new FloatQuat(this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Get the translation of this dual quaternion, i.e. {@code 2 * dual * conj(real)} (the actual
     * translation only when this dual quaternion has unit length), returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getTranslation() {
        return new Float3(2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW))), 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW))), 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW))));
    }


    /**
     * Compute the inverse of this dual quaternion, which is assumed to have unit length, returning
     * the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat inverseUnit() {
        return conjugate();
    }


    /**
     * Invert this dual quaternion, returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat invert() {
        float _t8 = Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW);
        float _t8_inv = 1.0f / _t8;
        float _t10 = 2.0f * (Math.fma(this.rX, this.dX, this.rY * this.dY) + Math.fma(this.rZ, this.dZ, this.rW * this.dW));
        float _t11 = _t8 * _t8;
        float _t11_inv = 1.0f / _t11;
        return new FloatDualQuat(-(this.rX * _t8_inv), -(this.rY * _t8_inv), -(this.rZ * _t8_inv), this.rW * _t8_inv, this.rX * _t10 * _t11_inv - this.dX * _t8_inv, this.rY * _t10 * _t11_inv - this.dY * _t8_inv, this.rZ * _t10 * _t11_inv - this.dZ * _t8_inv, this.dW * _t8_inv - this.rW * _t10 * _t11_inv);
    }


    /**
     * Compute the length of this dual quaternion's real (rotation) part.
     *
     * @return the length of this dual quaternion's real (rotation) part
     */
    public float length() {
        return (float) Math.sqrt(Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW));
    }


    /**
     * Compute the squared length of this dual quaternion's real (rotation) part.
     *
     * @return the squared length of this dual quaternion's real (rotation) part
     */
    public float lengthSquared() {
        return Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW);
    }


    /**
     * Compute the natural logarithm of this dual quaternion, returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat log() {
        float _t2 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t5 = this.rX * _t3;
        float _t6 = (float) Math.atan2((float) Math.sqrt(_t2), this.rW);
        float _t7 = this.rY * _t3;
        float _t8 = this.rZ * _t3;
        float _t9 = this.dW * _t3;
        float _t10 = this.rW * _t9;
        if (_t2 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                return new FloatDualQuat(0.0f, 0.0f, 0.0f, 0.0f, -this.dX, -this.dY, -this.dZ, 0.0f);
            } else {
                return new FloatDualQuat(0.0f, 0.0f, 0.0f, 0.0f, this.dX, this.dY, this.dZ, 0.0f);
            }
        } else {
            return new FloatDualQuat(_t5 * _t6, _t7 * _t6, _t8 * _t6, 0.0f, Math.fma(Math.fma(_t5, _t10, this.dX) * _t3, _t6, -(_t5 * _t9)), Math.fma(Math.fma(_t7, _t10, this.dY) * _t3, _t6, -(_t7 * _t9)), Math.fma(Math.fma(_t8, _t10, this.dZ) * _t3, _t6, -(_t8 * _t9)), 0.0f);
        }
    }


    /**
     * Create the rigid motion of the given matrix: rotation from its upper-left 3x3 block, which is
     * assumed to be a rotation, and translation from its last column.
     *
     * @param m the matrix
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromMatrix(Float4x4 m) {
        float _t0 = -m.m23();
        float _t2 = 1.0f - m.m00();
        float _t4 = m.m21() - m.m12();
        float _t5 = Math.max(m.m11(), m.m22());
        float _t6 = m.m01() + m.m10();
        float _t7 = m.m02() + m.m20();
        float _t8 = m.m02() - m.m20();
        float _t9 = m.m12() + m.m21();
        float _t10 = m.m10() - m.m01();
        float _t14 = m.m22() + (m.m00() + m.m11());
        float _t15 = 1.0f + _t14;
        float _t16 = m.m00() + (1.0f - m.m11() - m.m22());
        float _t17 = m.m11() + (_t2 - m.m22());
        float _t18 = m.m22() + (_t2 - m.m11());
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
            if (m.m00() > _t5) {
                _t63 = 0.5f * (float) Math.sqrt(_t16);
                _t64 = 0.5f * _t6 * _t23;
                _t65 = 0.5f * _t7 * _t23;
                _t66 = 0.5f * _t4 * _t23;
            } else {
                if (m.m11() > m.m22()) {
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
        return new FloatDualQuat(_t63, _t64, _t65, _t66, 0.5f * Math.fma(_t0, _t64, Math.fma(m.m03(), _t66, m.m13() * _t65)), 0.5f * Math.fma(m.m23(), _t63, Math.fma(m.m13(), _t66, -(m.m03() * _t65))), 0.5f * Math.fma(m.m23(), _t66, Math.fma(m.m03(), _t64, -(m.m13() * _t63))), 0.5f * Math.fma(_t0, _t65, Math.fma(-m.m13(), _t64, -(m.m03() * _t63))));
    }


    /**
     * Create the rigid motion of the given matrix: rotation from its upper-left 3x3 block, which is
     * assumed to be a rotation, and translation from its last column.
     *
     * @param m the matrix
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromMatrix(Float3x4 m) {
        float _t0 = -m.m23();
        float _t2 = 1.0f - m.m00();
        float _t4 = m.m21() - m.m12();
        float _t5 = Math.max(m.m11(), m.m22());
        float _t6 = m.m01() + m.m10();
        float _t7 = m.m02() + m.m20();
        float _t8 = m.m02() - m.m20();
        float _t9 = m.m12() + m.m21();
        float _t10 = m.m10() - m.m01();
        float _t14 = m.m22() + (m.m00() + m.m11());
        float _t15 = 1.0f + _t14;
        float _t16 = m.m00() + (1.0f - m.m11() - m.m22());
        float _t17 = m.m11() + (_t2 - m.m22());
        float _t18 = m.m22() + (_t2 - m.m11());
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
            if (m.m00() > _t5) {
                _t63 = 0.5f * (float) Math.sqrt(_t16);
                _t64 = 0.5f * _t6 * _t23;
                _t65 = 0.5f * _t7 * _t23;
                _t66 = 0.5f * _t4 * _t23;
            } else {
                if (m.m11() > m.m22()) {
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
        return new FloatDualQuat(_t63, _t64, _t65, _t66, 0.5f * Math.fma(_t0, _t64, Math.fma(m.m03(), _t66, m.m13() * _t65)), 0.5f * Math.fma(m.m23(), _t63, Math.fma(m.m13(), _t66, -(m.m03() * _t65))), 0.5f * Math.fma(m.m23(), _t66, Math.fma(m.m03(), _t64, -(m.m13() * _t63))), 0.5f * Math.fma(_t0, _t65, Math.fma(-m.m13(), _t64, -(m.m03() * _t63))));
    }


    /**
     * Create the rotation represented by the given matrix, with zero translation.
     *
     * @param m the matrix
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeFromMatrix(Float3x3 m) {
        float _t1 = 1.0f - m.m00();
        float _t3 = m.m21() - m.m12();
        float _t4 = Math.max(m.m11(), m.m22());
        float _t5 = m.m01() + m.m10();
        float _t6 = m.m02() + m.m20();
        float _t7 = m.m02() - m.m20();
        float _t8 = m.m12() + m.m21();
        float _t9 = m.m10() - m.m01();
        float _t13 = m.m22() + (m.m00() + m.m11());
        float _t14 = 1.0f + _t13;
        float _t15 = m.m00() + (1.0f - m.m11() - m.m22());
        float _t16 = m.m11() + (_t1 - m.m22());
        float _t17 = m.m22() + (_t1 - m.m11());
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            return new FloatDualQuat(0.5f * _t3 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14), 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (m.m00() > _t4) {
                return new FloatDualQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t5 * _t21, 0.5f * _t6 * _t21, 0.5f * _t3 * _t21, 0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                if (m.m11() > m.m22()) {
                    return new FloatDualQuat(0.5f * _t5 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19, 0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    return new FloatDualQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20, 0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
    }


    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length, returning
     * the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat normalize() {
        float _t5 = (1.0f / (float) Math.sqrt(Math.fma(this.rX, this.rX, this.rY * this.rY) + Math.fma(this.rZ, this.rZ, this.rW * this.rW)));
        return new FloatDualQuat(this.rX * _t5, this.rY * _t5, this.rZ * _t5, this.rW * _t5, this.dX * _t5, this.dY * _t5, this.dZ * _t5, this.dW * _t5);
    }

    /** Private tail of {@code pow}; reached only through it. */
    private FloatDualQuat pow_s5250ffb0_tail(float _t14, float _t16, float _t5, float _t8, float _t15, float _t10, float _t11, float _t0, float _t17, float _t6, float _t1, float _t2, float t) {
        float _t18 = _t14 * _t16;
        if (_t5 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, -_t0, -_t1, -_t2, t * this.dW);
            } else {
                return new FloatDualQuat(0.0f, 0.0f, 0.0f, 1.0f, _t0, _t1, _t2, t * this.dW);
            }
        } else {
            return new FloatDualQuat(_t8 * _t15, _t10 * _t15, _t11 * _t15, _t16, Math.fma(Math.fma(_t8, _t17, this.dX) * _t6, _t15, -(_t8 * _t18)), Math.fma(Math.fma(_t10, _t17, this.dY) * _t6, _t15, -(_t10 * _t18)), Math.fma(Math.fma(_t11, _t17, this.dZ) * _t6, _t15, -(_t11 * _t18)), _t14 * _t15);
        }
    }


    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}), returning the result as a value.
     *
     * @param t the exponent
     * @return the resulting dual quaternion
     */
    public FloatDualQuat pow(float t) {
        float _t0 = t * this.dX;
        float _t1 = t * this.dY;
        float _t2 = t * this.dZ;
        float _t5 = Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t8 = this.rX * _t6;
        float _t10 = this.rY * _t6;
        float _t11 = this.rZ * _t6;
        float _t12 = this.dW * _t6;
        float _t13 = t * (float) Math.atan2((float) Math.sqrt(_t5), this.rW);
        float _t14 = t * _t12;
        float _t15 = (float) Math.sin(_t13);
        float _t16 = (float) Math.cos(_t13);
        float _t17 = this.rW * _t12;
        return pow_s5250ffb0_tail(_t14, _t16, _t5, _t8, _t15, _t10, _t11, _t0, _t17, _t6, _t1, _t2, t);
    }


    /**
     * Set the rotation of this dual quaternion to {@code rotation}, returning the result as a
     * value.
     *
     * @param rotation the quaternion
     * @return the resulting dual quaternion
     */
    public FloatDualQuat setRotation(FloatQuat rotation) {
        return setRotation(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set the rotation of this dual quaternion to ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}), returning the result as a value.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat setRotation(float rotationX, float rotationY, float rotationZ, float rotationW) {
        float _t0 = -rotationY;
        float _t22 = 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)));
        float _t23 = 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)));
        float _t24 = 2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)));
        return new FloatDualQuat(rotationX, rotationY, rotationZ, rotationW, 0.5f * Math.fma(_t0, _t22, Math.fma(rotationZ, _t23, rotationW * _t24)), 0.5f * Math.fma(rotationX, _t22, Math.fma(rotationW, _t23, -(rotationZ * _t24))), 0.5f * Math.fma(rotationW, _t22, Math.fma(rotationY, _t24, -(rotationX * _t23))), 0.5f * Math.fma(-rotationZ, _t22, Math.fma(_t0, _t23, -(rotationX * _t24))));
    }


    /**
     * Set the translation of this dual quaternion to {@code translation}, returning the result as a
     * value.
     *
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public FloatDualQuat setTranslation(Float3 translation) {
        return setTranslation(translation.x(), translation.y(), translation.z());
    }


    /**
     * Set the translation of this dual quaternion to ({@code translationX}, {@code translationY},
     * {@code translationZ}), returning the result as a value.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting dual quaternion
     */
    public FloatDualQuat setTranslation(float translationX, float translationY, float translationZ) {
        float _t0 = -this.rY;
        return new FloatDualQuat(this.rX, this.rY, this.rZ, this.rW, 0.5f * Math.fma(_t0, translationZ, Math.fma(this.rZ, translationY, this.rW * translationX)), 0.5f * Math.fma(this.rX, translationZ, Math.fma(this.rW, translationY, -(this.rZ * translationX))), 0.5f * Math.fma(this.rW, translationZ, Math.fma(this.rY, translationX, -(this.rX * translationY))), 0.5f * Math.fma(-this.rZ, translationZ, Math.fma(_t0, translationY, -(this.rX * translationX))));
    }

    /** Private per-column body of {@code toMatrix}; reached only through it. */
    private Float4 toMatrix_s0_c0(float _t0, float _t6, float _t2, float _t3) {
        return new Float4(Math.fma(-2.0f, _t0, _t6), 2.0f * Math.fma(this.rX, this.rY, _t2), Math.fma(-2.0f, _t3, 2.0f * this.rX * this.rZ), 0.0f);
    }

    /** Private per-column body of {@code toMatrix}; reached only through it. */
    private Float4 toMatrix_s0_c1(float _t2, float _t4, float _t6, float _t5) {
        return new Float4(Math.fma(-2.0f, _t2, 2.0f * this.rX * this.rY), Math.fma(-2.0f, _t4, _t6), 2.0f * Math.fma(this.rX, this.rW, _t5), 0.0f);
    }

    /** Private per-column body of {@code toMatrix}; reached only through it. */
    private Float4 toMatrix_s0_c2(float _t3, float _t5, float _t4, float _t0) {
        return new Float4(2.0f * Math.fma(this.rX, this.rZ, _t3), Math.fma(-2.0f, this.rX * this.rW, 2.0f * _t5), Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)), 0.0f);
    }

    /** Private per-column body of {@code toMatrix}; reached only through it. */
    private Float4 toMatrix_s0_c3() {
        return new Float4(2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW))), 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW))), 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW))), 1.0f);
    }


    /**
     * Compute the matrix representation of this dual quaternion, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float4x4 toMatrix() {
        float _t0 = this.rY * this.rY;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rY * this.rW;
        float _t4 = this.rX * this.rX;
        float _t5 = this.rY * this.rZ;
        float _t6 = Math.fma(-2.0f, this.rZ * this.rZ, 1.0f);
        return new Float4x4(toMatrix_s0_c0(_t0, _t6, _t2, _t3), toMatrix_s0_c1(_t2, _t4, _t6, _t5), toMatrix_s0_c2(_t3, _t5, _t4, _t0), toMatrix_s0_c3(), 0);
    }


    /**
     * Compute the 3x3 matrix representation of this dual quaternion's rotation part (the encoded
     * translation is dropped), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 toMatrix3x3() {
        float _t0 = this.rY * this.rY;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rY * this.rW;
        float _t4 = this.rX * this.rX;
        float _t5 = this.rY * this.rZ;
        float _t6 = Math.fma(-2.0f, this.rZ * this.rZ, 1.0f);
        return new Float3x3(Math.fma(-2.0f, _t0, _t6), Math.fma(-2.0f, _t2, 2.0f * this.rX * this.rY), 2.0f * Math.fma(this.rX, this.rZ, _t3), 2.0f * Math.fma(this.rX, this.rY, _t2), Math.fma(-2.0f, _t4, _t6), Math.fma(-2.0f, this.rX * this.rW, 2.0f * _t5), Math.fma(-2.0f, _t3, 2.0f * this.rX * this.rZ), 2.0f * Math.fma(this.rX, this.rW, _t5), Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)), 0);
    }

    /** Private per-column body of {@code toMatrix3x4}; reached only through it. */
    private Float3 toMatrix3x4_s0_c0(float _t0, float _t6, float _t2, float _t3) {
        return new Float3(Math.fma(-2.0f, _t0, _t6), 2.0f * Math.fma(this.rX, this.rY, _t2), Math.fma(-2.0f, _t3, 2.0f * this.rX * this.rZ));
    }

    /** Private per-column body of {@code toMatrix3x4}; reached only through it. */
    private Float3 toMatrix3x4_s0_c1(float _t2, float _t4, float _t6, float _t5) {
        return new Float3(Math.fma(-2.0f, _t2, 2.0f * this.rX * this.rY), Math.fma(-2.0f, _t4, _t6), 2.0f * Math.fma(this.rX, this.rW, _t5));
    }

    /** Private per-column body of {@code toMatrix3x4}; reached only through it. */
    private Float3 toMatrix3x4_s0_c2(float _t3, float _t5, float _t4, float _t0) {
        return new Float3(2.0f * Math.fma(this.rX, this.rZ, _t3), Math.fma(-2.0f, this.rX * this.rW, 2.0f * _t5), Math.fma(-2.0f, _t4, Math.fma(-2.0f, _t0, 1.0f)));
    }

    /** Private per-column body of {@code toMatrix3x4}; reached only through it. */
    private Float3 toMatrix3x4_s0_c3() {
        return new Float3(2.0f * (Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW))), 2.0f * (Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW))), 2.0f * (Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW))));
    }


    /**
     * Compute the 3x4 matrix representation of this dual quaternion (the omitted last row is
     * implicitly {@code 0, 0, 0, 1}), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x4 toMatrix3x4() {
        float _t0 = this.rY * this.rY;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rY * this.rW;
        float _t4 = this.rX * this.rX;
        float _t5 = this.rY * this.rZ;
        float _t6 = Math.fma(-2.0f, this.rZ * this.rZ, 1.0f);
        return new Float3x4(toMatrix3x4_s0_c0(_t0, _t6, _t2, _t3), toMatrix3x4_s0_c1(_t2, _t4, _t6, _t5), toMatrix3x4_s0_c2(_t3, _t5, _t4, _t0), toMatrix3x4_s0_c3(), 0);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this dual
     * quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting dual quaternion
     */
    public FloatDualQuat lookAlong(Float3 dir, Float3 up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this dual quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        return new FloatDualQuat(Math.fma(this.rX, _t110, this.rW * _t111) + Math.fma(this.rY, _t108, -(this.rZ * _t109)), Math.fma(this.rY, _t110, this.rZ * _t111) + Math.fma(this.rW, _t109, -(this.rX * _t108)), Math.fma(this.rX, _t109, this.rW * _t108) + Math.fma(this.rZ, _t110, -(this.rY * _t111)), Math.fma(-this.rZ, _t108, Math.fma(-this.rY, _t109, Math.fma(this.rW, _t110, -(this.rX * _t111)))), Math.fma(this.dX, _t110, this.dW * _t111) + Math.fma(this.dY, _t108, -(this.dZ * _t109)), Math.fma(this.dY, _t110, this.dZ * _t111) + Math.fma(this.dW, _t109, -(this.dX * _t108)), Math.fma(this.dX, _t109, this.dW * _t108) + Math.fma(this.dZ, _t110, -(this.dY * _t111)), Math.fma(-this.dZ, _t108, Math.fma(-this.dY, _t109, Math.fma(this.dW, _t110, -(this.dX * _t111)))));
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationAxis(float angle, Float3 axis) {
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        return new FloatDualQuat(axisX * _t1, axisY * _t1, axisZ * _t1, (float) Math.cos(_t0), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationLookAlong(Float3 dir, Float3 up) {
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
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t56 = Math.max(_t49, _t7);
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t64 = (1.0f / (float) Math.sqrt(_t60));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        if (_t59 > 0.0f) {
            return new FloatDualQuat(0.5f * _t55 * _t64, 0.5f * _t38 * _t64, 0.5f * _t58 * _t64, 0.5f * (float) Math.sqrt(_t60), 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (_t31 > _t56) {
                return new FloatDualQuat(0.5f * (float) Math.sqrt(_t61), 0.5f * _t57 * _t67, 0.5f * _t37 * _t67, 0.5f * _t55 * _t67, 0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                if (_t49 > _t7) {
                    return new FloatDualQuat(0.5f * _t57 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t54 * _t65, 0.5f * _t38 * _t65, 0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    return new FloatDualQuat(0.5f * _t37 * _t66, 0.5f * _t54 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t58 * _t66, 0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationX(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatDualQuat((float) Math.sin(_t0), 0.0f, 0.0f, (float) Math.cos(_t0), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        return new FloatDualQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationXZY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        return new FloatDualQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t8, _t11 * _t5), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationY(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatDualQuat(0.0f, (float) Math.sin(_t0), 0.0f, (float) Math.cos(_t0), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        return new FloatDualQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t12, _t8, _t11 * _t5), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationYZX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        return new FloatDualQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)), Math.fma(_t10, _t5, -(_t9 * _t8)), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationZ(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatDualQuat(0.0f, 0.0f, (float) Math.sin(_t0), (float) Math.cos(_t0), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationZXY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        return new FloatDualQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t5, -(_t11 * _t8)), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public static FloatDualQuat makeRotationZYX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        return new FloatDualQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, _t12 * _t5), Math.fma(_t12, _t8, -(_t11 * _t5)), Math.fma(_t10, _t5, _t9 * _t8), 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this dual quaternion,
     * returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotate(FloatQuat rotation) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this dual quaternion, returning the result as a
     * value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotate(float rotationX, float rotationY, float rotationZ, float rotationW) {
        float _t0 = -rotationZ;
        float _t1 = -rotationY;
        return new FloatDualQuat(Math.fma(rotationX, this.rW, rotationW * this.rX) + Math.fma(rotationZ, this.rY, -(rotationY * this.rZ)), Math.fma(rotationX, this.rZ, rotationW * this.rY) + Math.fma(rotationY, this.rW, -(rotationZ * this.rX)), Math.fma(rotationY, this.rX, rotationZ * this.rW) + Math.fma(rotationW, this.rZ, -(rotationX * this.rY)), Math.fma(_t0, this.rZ, Math.fma(_t1, this.rY, Math.fma(rotationW, this.rW, -(rotationX * this.rX)))), Math.fma(rotationX, this.dW, rotationW * this.dX) + Math.fma(rotationZ, this.dY, -(rotationY * this.dZ)), Math.fma(rotationX, this.dZ, rotationW * this.dY) + Math.fma(rotationY, this.dW, -(rotationZ * this.dX)), Math.fma(rotationY, this.dX, rotationZ * this.dW) + Math.fma(rotationW, this.dZ, -(rotationX * this.dY)), Math.fma(_t0, this.dZ, Math.fma(_t1, this.dY, Math.fma(rotationW, this.dW, -(rotationX * this.dX)))));
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this dual
     * quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }

    /** Private tail of {@code rotateAxis}; reached only through it. */
    private FloatDualQuat rotateAxis_s3b957671_tail(float axisY, float _t2, float _t1, float _t3, float _t4) {
        float _t5 = axisY * _t2;
        return new FloatDualQuat(Math.fma(this.rX, _t1, this.rW * _t3) + Math.fma(this.rY, _t4, -(this.rZ * _t5)), Math.fma(this.rY, _t1, this.rZ * _t3) + Math.fma(this.rW, _t5, -(this.rX * _t4)), Math.fma(this.rX, _t5, this.rW * _t4) + Math.fma(this.rZ, _t1, -(this.rY * _t3)), Math.fma(-this.rZ, _t4, Math.fma(-this.rY, _t5, Math.fma(this.rW, _t1, -(this.rX * _t3)))), Math.fma(this.dX, _t1, this.dW * _t3) + Math.fma(this.dY, _t4, -(this.dZ * _t5)), Math.fma(this.dY, _t1, this.dZ * _t3) + Math.fma(this.dW, _t5, -(this.dX * _t4)), Math.fma(this.dX, _t5, this.dW * _t4) + Math.fma(this.dZ, _t1, -(this.dY * _t3)), Math.fma(-this.dZ, _t4, Math.fma(-this.dY, _t5, Math.fma(this.dW, _t1, -(this.dX * _t3)))));
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this dual quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        return rotateAxis_s3b957671_tail(axisY, _t2, _t1, _t3, _t4);
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this dual quaternion, returning
     * the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateX(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatDualQuat(Math.fma(this.rX, _t1, this.rW * _t2), Math.fma(this.rY, _t1, this.rZ * _t2), Math.fma(this.rZ, _t1, -(this.rY * _t2)), Math.fma(this.rW, _t1, -(this.rX * _t2)), Math.fma(this.dX, _t1, this.dW * _t2), Math.fma(this.dY, _t1, this.dZ * _t2), Math.fma(this.dZ, _t1, -(this.dY * _t2)), Math.fma(this.dW, _t1, -(this.dX * _t2)));
    }

    /** Private tail of {@code rotateXYZ}; reached only through it. */
    private FloatDualQuat rotateXYZ_s6e793366_tail(float _t12, float _t5, float _t11, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        return new FloatDualQuat(Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t20, -(this.rZ * _t22)), Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t22, -(this.rX * _t20)), Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t21, -(this.rY * _t19)), Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t21, -(this.rX * _t19)))), Math.fma(this.dX, _t21, this.dW * _t19) + Math.fma(this.dY, _t20, -(this.dZ * _t22)), Math.fma(this.dY, _t21, this.dZ * _t19) + Math.fma(this.dW, _t22, -(this.dX * _t20)), Math.fma(this.dX, _t22, this.dW * _t20) + Math.fma(this.dZ, _t21, -(this.dY * _t19)), Math.fma(-this.dZ, _t20, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t21, -(this.dX * _t19)))));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateXYZ_s6e793366_tail(_t12, _t5, _t11, _t8, _t21, _t19, _t20);
    }

    /** Private tail of {@code rotateXZY}; reached only through it. */
    private FloatDualQuat rotateXZY_s6e793366_tail(float _t10, float _t5, float _t9, float _t8, float _t19, float _t21, float _t20) {
        float _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return new FloatDualQuat(Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t20, -(this.rZ * _t22)), Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t22, -(this.rX * _t20)), Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t19, -(this.rY * _t21)), Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t21)))), Math.fma(this.dX, _t19, this.dW * _t21) + Math.fma(this.dY, _t20, -(this.dZ * _t22)), Math.fma(this.dY, _t19, this.dZ * _t21) + Math.fma(this.dW, _t22, -(this.dX * _t20)), Math.fma(this.dX, _t22, this.dW * _t20) + Math.fma(this.dZ, _t19, -(this.dY * _t21)), Math.fma(-this.dZ, _t20, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t19, -(this.dX * _t21)))));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateXZY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        return rotateXZY_s6e793366_tail(_t10, _t5, _t9, _t8, _t19, _t21, _t20);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this dual quaternion, returning
     * the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateY(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatDualQuat(Math.fma(this.rX, _t1, -(this.rZ * _t2)), Math.fma(this.rY, _t1, this.rW * _t2), Math.fma(this.rX, _t2, this.rZ * _t1), Math.fma(this.rW, _t1, -(this.rY * _t2)), Math.fma(this.dX, _t1, -(this.dZ * _t2)), Math.fma(this.dY, _t1, this.dW * _t2), Math.fma(this.dX, _t2, this.dZ * _t1), Math.fma(this.dW, _t1, -(this.dY * _t2)));
    }

    /** Private tail of {@code rotateYXZ}; reached only through it. */
    private FloatDualQuat rotateYXZ_s6e793366_tail(float _t12, float _t8, float _t11, float _t5, float _t19, float _t20, float _t21) {
        float _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        return new FloatDualQuat(Math.fma(this.rX, _t19, this.rW * _t20) + Math.fma(this.rY, _t21, -(this.rZ * _t22)), Math.fma(this.rY, _t19, this.rZ * _t20) + Math.fma(this.rW, _t22, -(this.rX * _t21)), Math.fma(this.rX, _t22, this.rW * _t21) + Math.fma(this.rZ, _t19, -(this.rY * _t20)), Math.fma(-this.rZ, _t21, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t20)))), Math.fma(this.dX, _t19, this.dW * _t20) + Math.fma(this.dY, _t21, -(this.dZ * _t22)), Math.fma(this.dY, _t19, this.dZ * _t20) + Math.fma(this.dW, _t22, -(this.dX * _t21)), Math.fma(this.dX, _t22, this.dW * _t21) + Math.fma(this.dZ, _t19, -(this.dY * _t20)), Math.fma(-this.dZ, _t21, Math.fma(-this.dY, _t22, Math.fma(this.dW, _t19, -(this.dX * _t20)))));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return rotateYXZ_s6e793366_tail(_t12, _t8, _t11, _t5, _t19, _t20, _t21);
    }

    /** Private tail of {@code rotateYZX}; reached only through it. */
    private FloatDualQuat rotateYZX_s6e793366_tail(float _t11, float _t5, float _t12, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        return new FloatDualQuat(Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t22, -(this.rZ * _t20)), Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t20, -(this.rX * _t22)), Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t21, -(this.rY * _t19)), Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t19)))), Math.fma(this.dX, _t21, this.dW * _t19) + Math.fma(this.dY, _t22, -(this.dZ * _t20)), Math.fma(this.dY, _t21, this.dZ * _t19) + Math.fma(this.dW, _t20, -(this.dX * _t22)), Math.fma(this.dX, _t20, this.dW * _t22) + Math.fma(this.dZ, _t21, -(this.dY * _t19)), Math.fma(-this.dZ, _t22, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t21, -(this.dX * _t19)))));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateYZX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t3;
        float _t12 = _t6 * _t4;
        float _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateYZX_s6e793366_tail(_t11, _t5, _t12, _t8, _t21, _t19, _t20);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this dual quaternion, returning
     * the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateZ(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatDualQuat(Math.fma(this.rX, _t1, this.rY * _t2), Math.fma(this.rY, _t1, -(this.rX * _t2)), Math.fma(this.rZ, _t1, this.rW * _t2), Math.fma(this.rW, _t1, -(this.rZ * _t2)), Math.fma(this.dX, _t1, this.dY * _t2), Math.fma(this.dY, _t1, -(this.dX * _t2)), Math.fma(this.dZ, _t1, this.dW * _t2), Math.fma(this.dW, _t1, -(this.dZ * _t2)));
    }

    /** Private tail of {@code rotateZXY}; reached only through it. */
    private FloatDualQuat rotateZXY_s6e793366_tail(float _t11, float _t5, float _t12, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        return new FloatDualQuat(Math.fma(this.rX, _t21, this.rW * _t22) + Math.fma(this.rY, _t19, -(this.rZ * _t20)), Math.fma(this.rY, _t21, this.rZ * _t22) + Math.fma(this.rW, _t20, -(this.rX * _t19)), Math.fma(this.rX, _t20, this.rW * _t19) + Math.fma(this.rZ, _t21, -(this.rY * _t22)), Math.fma(-this.rZ, _t19, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t22)))), Math.fma(this.dX, _t21, this.dW * _t22) + Math.fma(this.dY, _t19, -(this.dZ * _t20)), Math.fma(this.dY, _t21, this.dZ * _t22) + Math.fma(this.dW, _t20, -(this.dX * _t19)), Math.fma(this.dX, _t20, this.dW * _t19) + Math.fma(this.dZ, _t21, -(this.dY * _t22)), Math.fma(-this.dZ, _t19, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t21, -(this.dX * _t22)))));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateZXY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateZXY_s6e793366_tail(_t11, _t5, _t12, _t8, _t21, _t19, _t20);
    }

    /** Private tail of {@code rotateZYX}; reached only through it. */
    private FloatDualQuat rotateZYX_s6e793366_tail(float _t11, float _t8, float _t12, float _t5, float _t19, float _t21, float _t20) {
        float _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        return new FloatDualQuat(Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t22, -(this.rZ * _t20)), Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t20, -(this.rX * _t22)), Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t19, -(this.rY * _t21)), Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t19, -(this.rX * _t21)))), Math.fma(this.dX, _t19, this.dW * _t21) + Math.fma(this.dY, _t22, -(this.dZ * _t20)), Math.fma(this.dY, _t19, this.dZ * _t21) + Math.fma(this.dW, _t20, -(this.dX * _t22)), Math.fma(this.dX, _t20, this.dW * _t22) + Math.fma(this.dZ, _t19, -(this.dY * _t21)), Math.fma(-this.dZ, _t22, Math.fma(-this.dY, _t20, Math.fma(this.dW, _t19, -(this.dX * _t21)))));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this dual quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting dual quaternion
     */
    public FloatDualQuat rotateZYX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t4 * _t6;
        float _t12 = _t3 * _t7;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return rotateZYX_s6e793366_tail(_t11, _t8, _t12, _t5, _t19, _t21, _t20);
    }


    /**
     * Apply a translation by {@code translation} to this dual quaternion, returning the result as a
     * value.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     *
     * @param translation the vector
     * @return the resulting dual quaternion
     */
    public FloatDualQuat translate(Float3 translation) {
        return translate(translation.x(), translation.y(), translation.z());
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this dual quaternion, returning the result as a value.
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
     * @return the resulting dual quaternion
     */
    public FloatDualQuat translate(float translationX, float translationY, float translationZ) {
        float _t0 = -this.rZ;
        float _t1 = -this.rX;
        float _t2 = -this.rY;
        float _t3 = 0.5f * translationZ;
        float _t4 = 0.5f * translationY;
        float _t5 = 0.5f * translationX;
        return new FloatDualQuat(this.rX, this.rY, this.rZ, this.rW, Math.fma(this.rY, _t3, Math.fma(_t0, _t4, Math.fma(this.rW, _t5, this.dX))), Math.fma(this.rW, _t4, Math.fma(_t1, _t3, Math.fma(this.rZ, _t5, this.dY))), Math.fma(this.rX, _t4, Math.fma(this.rW, _t3, Math.fma(_t2, _t5, this.dZ))), Math.fma(_t1, _t5, Math.fma(_t2, _t4, Math.fma(_t0, _t3, this.dW))));
    }


    /**
     * Transform {@code p} by this dual quaternion, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transform(Float3 p) {
        return transform(p.x(), p.y(), p.z());
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by this dual quaternion, returning the result
     * as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transform(float pX, float pY, float pZ) {
        float _t9 = 2.0f * Math.fma(pY, this.rX, -(pX * this.rY));
        float _t10 = 2.0f * Math.fma(pX, this.rZ, -(pZ * this.rX));
        float _t11 = 2.0f * Math.fma(pZ, this.rY, -(pY * this.rZ));
        return new Float3(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, Math.fma(2.0f, Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)), pX)))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, Math.fma(2.0f, Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)), pY)))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, Math.fma(2.0f, Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)), pZ)))));
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation, returning
     * the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformDirection(Float3 v) {
        return transformDirection(v.x(), v.y(), v.z());
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation, returning
     * the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformDirection(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.rX, vY, -(this.rY * vX));
        float _t10 = 2.0f * Math.fma(this.rZ, vX, -(this.rX * vZ));
        float _t11 = 2.0f * Math.fma(this.rY, vZ, -(this.rZ * vY));
        return new Float3(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, vX))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vY))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, vZ))));
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()}, returning the
     * result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformDirectionInverse(Float3 v) {
        return transformDirectionInverse(v.x(), v.y(), v.z());
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()}, returning the
     * result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformDirectionInverse(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.rX, vZ, -(this.rZ * vX));
        float _t10 = 2.0f * Math.fma(this.rY, vX, -(this.rX * vY));
        float _t11 = 2.0f * Math.fma(this.rZ, vY, -(this.rY * vZ));
        return new Float3(Math.fma(this.rZ, _t9, Math.fma(-this.rY, _t10, Math.fma(this.rW, _t11, vX))), Math.fma(this.rX, _t10, Math.fma(-this.rZ, _t11, Math.fma(this.rW, _t9, vY))), Math.fma(this.rY, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vZ))));
    }


    /**
     * Transform {@code p} by the inverse of this dual quaternion (assumes a unit, rigid dual
     * quaternion), returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transformInverse(Float3 p) {
        return transformInverse(p.x(), p.y(), p.z());
    }

    /** Private tail of {@code transformInverse}; reached only through it. */
    private Float3 transformInverse_s2b62622f_tail(float _t21, float _t22, float _t23) {
        float _t33 = 2.0f * Math.fma(this.rX, _t21, -(this.rZ * _t22));
        float _t34 = 2.0f * Math.fma(this.rY, _t22, -(this.rX * _t23));
        float _t35 = 2.0f * Math.fma(this.rZ, _t23, -(this.rY * _t21));
        return new Float3(Math.fma(this.rZ, _t33, Math.fma(-this.rY, _t34, Math.fma(this.rW, _t35, _t22))), Math.fma(this.rX, _t34, Math.fma(-this.rZ, _t35, Math.fma(this.rW, _t33, _t23))), Math.fma(this.rY, _t35, Math.fma(-this.rX, _t33, Math.fma(this.rW, _t34, _t21))));
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this dual quaternion
     * (assumes a unit, rigid dual quaternion), returning the result as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transformInverse(float pX, float pY, float pZ) {
        float _t21 = Math.fma(-2.0f, Math.fma(this.rX, this.dY, -(this.rY * this.dX)) + Math.fma(this.rW, this.dZ, -(this.rZ * this.dW)), pZ);
        float _t22 = Math.fma(-2.0f, Math.fma(this.rY, this.dZ, -(this.rZ * this.dY)) + Math.fma(this.rW, this.dX, -(this.rX * this.dW)), pX);
        float _t23 = Math.fma(-2.0f, Math.fma(this.rZ, this.dX, -(this.rX * this.dZ)) + Math.fma(this.rW, this.dY, -(this.rY * this.dW)), pY);
        return transformInverse_s2b62622f_tail(_t21, _t22, _t23);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transformPosition(Float3 p) {
        return transform(p);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transformPosition(float pX, float pY, float pZ) {
        return transform(pX, pY, pZ);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()}, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transformPositionInverse(Float3 p) {
        return transformInverse(p);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()}, returning the result as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transformPositionInverse(float pX, float pY, float pZ) {
        return transformInverse(pX, pY, pZ);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformVector(Float3 v) {
        return transformDirection(v);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformVector(float vX, float vY, float vZ) {
        return transformDirection(vX, vY, vZ);
    }

    /** {@return a copy with the {@code rX} component replaced by {@code v}} */
    public FloatDualQuat withRX(float v) {
        return new FloatDualQuat(v, rY, rZ, rW, dX, dY, dZ, dW);
    }

    /** {@return a copy with the {@code rY} component replaced by {@code v}} */
    public FloatDualQuat withRY(float v) {
        return new FloatDualQuat(rX, v, rZ, rW, dX, dY, dZ, dW);
    }

    /** {@return a copy with the {@code rZ} component replaced by {@code v}} */
    public FloatDualQuat withRZ(float v) {
        return new FloatDualQuat(rX, rY, v, rW, dX, dY, dZ, dW);
    }

    /** {@return a copy with the {@code rW} component replaced by {@code v}} */
    public FloatDualQuat withRW(float v) {
        return new FloatDualQuat(rX, rY, rZ, v, dX, dY, dZ, dW);
    }

    /** {@return a copy with the {@code dX} component replaced by {@code v}} */
    public FloatDualQuat withDX(float v) {
        return new FloatDualQuat(rX, rY, rZ, rW, v, dY, dZ, dW);
    }

    /** {@return a copy with the {@code dY} component replaced by {@code v}} */
    public FloatDualQuat withDY(float v) {
        return new FloatDualQuat(rX, rY, rZ, rW, dX, v, dZ, dW);
    }

    /** {@return a copy with the {@code dZ} component replaced by {@code v}} */
    public FloatDualQuat withDZ(float v) {
        return new FloatDualQuat(rX, rY, rZ, rW, dX, dY, v, dW);
    }

    /** {@return a copy with the {@code dW} component replaced by {@code v}} */
    public FloatDualQuat withDW(float v) {
        return new FloatDualQuat(rX, rY, rZ, rW, dX, dY, dZ, v);
    }

    @Override public String toString() {
        return "FloatDualQuat(" + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ", " + dX() + ", " + dY() + ", " + dZ() + ", " + dW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatDualQuat)) return false;
        FloatDualQuat o = (FloatDualQuat) obj;
        return Float.floatToIntBits(rX) == Float.floatToIntBits(o.rX)
            && Float.floatToIntBits(rY) == Float.floatToIntBits(o.rY)
            && Float.floatToIntBits(rZ) == Float.floatToIntBits(o.rZ)
            && Float.floatToIntBits(rW) == Float.floatToIntBits(o.rW)
            && Float.floatToIntBits(dX) == Float.floatToIntBits(o.dX)
            && Float.floatToIntBits(dY) == Float.floatToIntBits(o.dY)
            && Float.floatToIntBits(dZ) == Float.floatToIntBits(o.dZ)
            && Float.floatToIntBits(dW) == Float.floatToIntBits(o.dW);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(rX);
        h = 31 * h + Float.floatToIntBits(rY);
        h = 31 * h + Float.floatToIntBits(rZ);
        h = 31 * h + Float.floatToIntBits(rW);
        h = 31 * h + Float.floatToIntBits(dX);
        h = 31 * h + Float.floatToIntBits(dY);
        h = 31 * h + Float.floatToIntBits(dZ);
        h = 31 * h + Float.floatToIntBits(dW);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(rX)
            && Float.isFinite(rY)
            && Float.isFinite(rZ)
            && Float.isFinite(rW)
            && Float.isFinite(dX)
            && Float.isFinite(dY)
            && Float.isFinite(dZ)
            && Float.isFinite(dW);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatDualQuat other, float epsilon) {
        return Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon
            && Math.abs(dX - other.dX()) <= epsilon
            && Math.abs(dY - other.dY()) <= epsilon
            && Math.abs(dZ - other.dZ()) <= epsilon
            && Math.abs(dW - other.dW()) <= epsilon;
    }

    static final FloatDualQuatSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatDualQuatSegOpsUnsafe()
                    : new FloatDualQuatSegOpsMS();
    static final FloatDualQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatDualQuatBbOpsUnsafe()
                    : new FloatDualQuatBbOpsApi();
    static final FloatDualQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatDualQuatRawOpsUnsafe()
                    : new FloatDualQuatRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
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
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c5 = src[offset + 5];
        float _c6 = src[offset + 6];
        float _c7 = src[offset + 7];
        return new FloatDualQuat(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(float[] src) { return load(src, 0); }

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
        buf.position(pos + 8);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatDualQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 8);
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
        buf.position(pos + 32);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatDualQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 32);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatDualQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(long offset, MemorySegment src) {
        return SEG_OPS.load(offset, src);
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
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c5 = (float) src[offset + 5];
        float _c6 = (float) src[offset + 6];
        float _c7 = (float) src[offset + 7];
        return new FloatDualQuat(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(double[] src) { return load(src, 0); }

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
        buf.position(pos + 8);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatDualQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 8);
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
        buf.position(pos + 64);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatDualQuat r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 64);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatDualQuat storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double}.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(MemorySegment dest) { return storeDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     *
     * @param src the source memory segment
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatDualQuat} holding the loaded elements
     */
    public static FloatDualQuat loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
