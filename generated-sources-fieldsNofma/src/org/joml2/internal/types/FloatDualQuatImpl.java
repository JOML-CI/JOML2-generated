// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
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
 * Generated implementation of {@link FloatDualQuat} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatDualQuatImpl implements FloatDualQuat {

    public float rX;
    public float rY;
    public float rZ;
    public float rW;
    public float dX;
    public float dY;
    public float dZ;
    public float dW;
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

    public FloatDualQuatImpl() {
        rW = 1;
    }

    public FloatDualQuatImpl(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) {
        this.rX = rX;
        this.rY = rY;
        this.rZ = rZ;
        this.rW = rW;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
        this.dW = dW;
    }

    public FloatDualQuatImpl(FloatDualQuatR src) {
        this.rX = src.rX();
        this.rY = src.rY();
        this.rZ = src.rZ();
        this.rW = src.rW();
        this.dX = src.dX();
        this.dY = src.dY();
        this.dZ = src.dZ();
        this.dW = src.dW();
    }


    /**
     * Add {@code other} to this dual quaternion and store the result in {@code dest}.
     *
     * @param other the dual quaternion to add
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat add(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return add(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Add {@code other} to this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to add
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat add(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat add(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) to this dual quaternion and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat add(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated DoubleDualQuat dest) {
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
     * @param scalar the factor to multiply each component by
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat mul(float scalar, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Multiply each component of this dual quaternion by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param scalar the factor to multiply each component by
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(float scalar, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat negate(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Negate this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param other the dual quaternion to subtract
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat sub(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return sub(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Subtract {@code other} from this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to subtract
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sub(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat sub(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Subtract ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) from this dual quaternion
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat sub(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated DoubleDualQuat dest) {
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
     * @param v the dual quaternion to copy
     * @return this
     */
    public @Mutated FloatDualQuat set(FloatDualQuatR v) {
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
    @Mutated public FloatDualQuat set(float vRX, float vRY, float vRZ, float vRW, float vDX, float vDY, float vDZ, float vDW) {
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
     * Convert this dual quaternion to {@code double} precision and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDouble(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.dX = this.dX;
        d.dY = this.dY;
        d.dZ = this.dZ;
        d.dW = this.dW;
        return d;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param r the rigid transform to convert
     * @return this
     */
    public @Mutated FloatDualQuat makeFromRigid(FloatRigidR r) {
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
    @Mutated public FloatDualQuat makeFromRigid(float rTX, float rTY, float rTZ, float rRX, float rRY, float rRZ, float rRW) {
        this.rX = rRX;
        this.rY = rRY;
        this.rZ = rRZ;
        this.rW = rRW;
        this.dX = 0.5f * (rTX * rRW + rTY * rRZ - rTZ * rRY);
        this.dY = 0.5f * (rTY * rRW - rTX * rRZ + rTZ * rRX);
        this.dZ = 0.5f * (rTX * rRY - rTY * rRX + rTZ * rRW);
        this.dW = 0.5f * (-(rTX * rRX) - rTY * rRY - rTZ * rRZ);
        return this;
    }


    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
     *
     * @param t the transform to convert
     * @return this
     */
    public @Mutated FloatDualQuat makeFromTransform(FloatTransformR t) {
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
    @Mutated public FloatDualQuat makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        this.rX = tRX;
        this.rY = tRY;
        this.rZ = tRZ;
        this.rW = tRW;
        this.dX = 0.5f * (tTX * tRW + tTY * tRZ - tTZ * tRY);
        this.dY = 0.5f * (tTY * tRW - tTX * tRZ + tTZ * tRX);
        this.dZ = 0.5f * (tTX * tRY - tTY * tRX + tTZ * tRW);
        this.dW = 0.5f * (-(tTX * tRX) - tTY * tRY - tTZ * tRZ);
        return this;
    }


    /**
     * Convert this unit dual quaternion to a rigid transform (an exact conversion - both represent
     * rotation plus translation) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatRigid toRigid(@Mutated FloatRigid dest) {
        FloatRigidImpl d = (FloatRigidImpl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _buf2 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _buf3 = this.rX;
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
     * Convert this unit dual quaternion to a rigid transform (an exact conversion - both represent
     * rotation plus translation) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _buf2 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _buf3 = this.rX;
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
    public FloatTransform toTransform(@Mutated FloatTransform dest) {
        FloatTransformImpl d = (FloatTransformImpl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _buf2 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _buf3 = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = 1.0f;
        d.sY = 1.0f;
        d.sZ = 1.0f;
        d.tX = _buf0;
        d.tY = _buf1;
        d.tZ = _buf2;
        d.rX = _buf3;
        return d;
    }


    /**
     * Convert this unit dual quaternion to a TRS transform (translation and rotation from the rigid
     * motion, scale = 1) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _buf2 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _buf3 = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = 1.0f;
        d.sY = 1.0f;
        d.sZ = 1.0f;
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
    public boolean isUnit(float epsilon) {
        return Math.abs(this.rX * this.rX + (this.rY * this.rY + (this.rZ * this.rZ + (this.rW * this.rW - 1.0f)))) <= epsilon;
    }


    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the translation
     * @return this
     */
    public @Mutated FloatDualQuat makeFromAxisAngle(Float3R axis, float angle, Float3R translation) {
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
    @Mutated public FloatDualQuat makeFromAxisAngle(float axisX, float axisY, float axisZ, float angle, float translationX, float translationY, float translationZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = axisX * _t1;
        float _t3 = axisY * _t1;
        float _t4 = axisZ * _t1;
        float _t5 = (float) Math.cosFromSin(_t1, _t0);
        this.rX = _t2;
        this.rY = _t3;
        this.rZ = _t4;
        this.rW = _t5;
        this.dX = 0.5f * (translationX * _t5 + translationY * _t4 - translationZ * _t3);
        this.dY = 0.5f * (translationY * _t5 - translationX * _t4 + translationZ * _t2);
        this.dZ = 0.5f * (translationX * _t3 - translationY * _t2 + translationZ * _t5);
        this.dW = 0.5f * (-(translationX * _t2) - translationY * _t3 - translationZ * _t4);
        return this;
    }


    /**
     * Set this dual quaternion to the identity.
     *
     * @return this
     */
    @Mutated public FloatDualQuat makeIdentity() {
        this.rX = 0.0f;
        this.rY = 0.0f;
        this.rZ = 0.0f;
        this.rW = 1.0f;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the translation
     * @param rotation the rotation
     * @return this
     */
    public @Mutated FloatDualQuat makeTranslationRotation(Float3R translation, FloatQuatR rotation) {
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
    @Mutated public FloatDualQuat makeTranslationRotation(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW) {
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.5f * (rotationZ * translationY + rotationW * translationX - rotationY * translationZ);
        this.dY = 0.5f * (rotationW * translationY - rotationZ * translationX + rotationX * translationZ);
        this.dZ = 0.5f * (rotationY * translationX - rotationX * translationY + rotationW * translationZ);
        this.dW = 0.5f * (-(rotationX * translationX) - rotationY * translationY - rotationZ * translationZ);
        return this;
    }


    /**
     * Set all components of this dual quaternion to zero.
     *
     * @return this
     */
    @Mutated public FloatDualQuat makeZero() {
        this.rX = 0.0f;
        this.rY = 0.0f;
        this.rZ = 0.0f;
        this.rW = 0.0f;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a pure rotation by {@code rotation} (zero translation).
     *
     * @param rotation the rotation
     * @return this
     */
    public @Mutated FloatDualQuat set(FloatQuatR rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this dual quaternion to a pure rotation by ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) (zero translation).
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
    @Mutated public FloatDualQuat set(float rotationX, float rotationY, float rotationZ, float rotationW) {
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the rotation
     * @param translation the translation
     * @return this
     */
    public @Mutated FloatDualQuat set(FloatQuatR rotation, Float3R translation) {
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
    @Mutated public FloatDualQuat set(float rotationX, float rotationY, float rotationZ, float rotationW, float translationX, float translationY, float translationZ) {
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.dX = 0.5f * (rotationZ * translationY + rotationW * translationX - rotationY * translationZ);
        this.dY = 0.5f * (rotationW * translationY - rotationZ * translationX + rotationX * translationZ);
        this.dZ = 0.5f * (rotationY * translationX - rotationX * translationY + rotationW * translationZ);
        this.dW = 0.5f * (-(rotationX * translationX) - rotationY * translationY - rotationZ * translationZ);
        return this;
    }


    /**
     * Set this dual quaternion to a pure translation by {@code translation} (identity rotation).
     *
     * @param translation the translation
     * @return this
     */
    public @Mutated FloatDualQuat set(Float3R translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this dual quaternion to a pure translation by ({@code translationX},
     * {@code translationY}, {@code translationZ}) (identity rotation).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public FloatDualQuat set(float translationX, float translationY, float translationZ) {
        this.rX = 0.0f;
        this.rY = 0.0f;
        this.rZ = 0.0f;
        this.rW = 1.0f;
        this.dX = 0.5f * translationX;
        this.dY = 0.5f * translationY;
        this.dZ = 0.5f * translationZ;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (weight {@code 0}) and ends at {@code other}
     * (weight {@code 1}).
     *
     * @param other the dual quaternion to blend towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat dlb(FloatDualQuatR other, float t, @Mutated FloatDualQuat dest) {
        return dlb(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (weight {@code 0}) and ends at {@code other}
     * (weight {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to blend towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat dlb(FloatDualQuatR other, float t, @Mutated DoubleDualQuat dest) {
        return dlb(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Blend this dual quaternion with ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) using
     * dual-quaternion linear blending with the weight {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (weight {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (weight {@code 1}).
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
    public FloatDualQuat dlb(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t7 = otherRX * this.rX + otherRY * this.rY + (otherRZ * this.rZ + otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t20 = t * (otherRX * _t7 - this.rX) + this.rX;
        float _t21 = t * (otherRY * _t7 - this.rY) + this.rY;
        float _t22 = t * (otherRZ * _t7 - this.rZ) + this.rZ;
        float _t23 = t * (otherRW * _t7 - this.rW) + this.rW;
        float _t31 = (1.0f / (float) Math.sqrt(_t20 * _t20 + _t21 * _t21 + (_t22 * _t22 + _t23 * _t23)));
        d.rX = _t20 * _t31;
        d.rY = _t21 * _t31;
        d.rZ = _t22 * _t31;
        d.rW = _t23 * _t31;
        d.dX = (t * (otherDX * _t7 - this.dX) + this.dX) * _t31;
        d.dY = (t * (otherDY * _t7 - this.dY) + this.dY) * _t31;
        d.dZ = (t * (otherDZ * _t7 - this.dZ) + this.dZ) * _t31;
        d.dW = (t * (otherDW * _t7 - this.dW) + this.dW) * _t31;
        return d;
    }


    /**
     * Blend this dual quaternion with ({@code otherRX}, {@code otherRY}, {@code otherRZ},
     * {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ}, {@code otherDW}) using
     * dual-quaternion linear blending with the weight {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (weight {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (weight {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat dlb(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t7 = otherRX * this.rX + otherRY * this.rY + (otherRZ * this.rZ + otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t20 = t * (otherRX * _t7 - this.rX) + this.rX;
        float _t21 = t * (otherRY * _t7 - this.rY) + this.rY;
        float _t22 = t * (otherRZ * _t7 - this.rZ) + this.rZ;
        float _t23 = t * (otherRW * _t7 - this.rW) + this.rW;
        float _t31 = (1.0f / (float) Math.sqrt(_t20 * _t20 + _t21 * _t21 + (_t22 * _t22 + _t23 * _t23)));
        d.rX = _t20 * _t31;
        d.rY = _t21 * _t31;
        d.rZ = _t22 * _t31;
        d.rW = _t23 * _t31;
        d.dX = (t * (otherDX * _t7 - this.dX) + this.dX) * _t31;
        d.dY = (t * (otherDY * _t7 - this.dY) + this.dY) * _t31;
        d.dZ = (t * (otherDZ * _t7 - this.dZ) + this.dZ) * _t31;
        d.dW = (t * (otherDW * _t7 - this.dW) + this.dW) * _t31;
        return d;
    }


    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the dual quaternion to interpolate towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat lerp(FloatDualQuatR other, float t, @Mutated FloatDualQuat dest) {
        return lerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to interpolate towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat lerp(FloatDualQuatR other, float t, @Mutated DoubleDualQuat dest) {
        return lerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Linearly interpolate between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (interpolation factor {@code 1}).
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
    public FloatDualQuat lerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = t * (otherRX - this.rX) + this.rX;
        d.rY = t * (otherRY - this.rY) + this.rY;
        d.rZ = t * (otherRZ - this.rZ) + this.rZ;
        d.rW = t * (otherRW - this.rW) + this.rW;
        d.dX = t * (otherDX - this.dX) + this.dX;
        d.dY = t * (otherDY - this.dY) + this.dY;
        d.dZ = t * (otherDZ - this.dZ) + this.dZ;
        d.dW = t * (otherDW - this.dW) + this.dW;
        return d;
    }


    /**
     * Linearly interpolate between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (interpolation factor {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat lerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = t * (otherRX - this.rX) + this.rX;
        d.rY = t * (otherRY - this.rY) + this.rY;
        d.rZ = t * (otherRZ - this.rZ) + this.rZ;
        d.rW = t * (otherRW - this.rW) + this.rW;
        d.dX = t * (otherDX - this.dX) + this.dX;
        d.dY = t * (otherDY - this.dY) + this.dY;
        d.dZ = t * (otherDZ - this.dZ) + this.dZ;
        d.dW = t * (otherDW - this.dW) + this.dW;
        return d;
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the dual quaternion to interpolate towards (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat sclerp(FloatDualQuatR other, float t, @Mutated FloatDualQuat dest) {
        return sclerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to interpolate towards (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sclerp(FloatDualQuatR other, float t, @Mutated DoubleDualQuat dest) {
        return sclerp(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), t, dest);
    }

    /** Private store group 0 of {@code sclerp}: computes and stores it; reached only through it. */
    private void sclerp_s4b3cdb8d_c0(FloatDualQuatImpl _dst, float _r0, float _t159, float _r3, float _t160, float _r1, float _t161, float _r2, float _t162) {
        _dst.rX = _r0 * _t159 + _r3 * _t160 + (_r1 * _t161 - _r2 * _t162);
        _dst.rY = _r1 * _t159 + _r2 * _t160 + (_r3 * _t162 - _r0 * _t161);
        _dst.rZ = _r0 * _t162 + _r3 * _t161 + (_r2 * _t159 - _r1 * _t160);
        _dst.rW = _r3 * _t159 - _r0 * _t160 - (_r1 * _t162 + _r2 * _t161);
    }

    /** Private store group 1 of {@code sclerp}: computes and stores it; reached only through it. */
    private void sclerp_s4b3cdb8d_c1(FloatDualQuatImpl _dst, float _r0, float _t164, float _r3, float _t177, float _r1, float _t178, float _r2, float _t179, float _r4, float _t159, float _r5, float _t160, float _r6, float _t161, float _r7, float _t162) {
        _dst.dX = _r0 * _t164 + _r3 * _t177 + (_r1 * _t178 - _r2 * _t179) + (_r4 * _t159 + _r5 * _t160 + (_r6 * _t161 - _r7 * _t162));
        _dst.dY = _r1 * _t164 + _r2 * _t177 + (_r3 * _t179 - _r0 * _t178) + (_r6 * _t159 + _r7 * _t160 + (_r5 * _t162 - _r4 * _t161));
        _dst.dZ = _r0 * _t179 + _r3 * _t178 + (_r2 * _t164 - _r1 * _t177) + (_r4 * _t162 + _r5 * _t161 + (_r7 * _t159 - _r6 * _t160));
        _dst.dW = _r3 * _t164 - _r0 * _t177 + (-(_r1 * _t179) - _r2 * _t178) + (_r5 * _t159 - _r4 * _t160 + (-(_r6 * _t162) - _r7 * _t161));
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s4b3cdb8d_tail(FloatDualQuatImpl _dst, float _r2, float _t11, float _r1, float _t12, float _r3, float _t9, float _r0, float _t10, float _t69, float _t89, float _t13, float _t14, float _t15, float _t16, float _r4, float _r5, float _r6, float _r7, float t) {
        float _t93 = _r2 * _t11 - _r1 * _t12 + (_r3 * _t9 - _r0 * _t10);
        float _t94 = _r1 * _t9 - _r2 * _t10 + (_r3 * _t12 - _r0 * _t11);
        float _t101 = _t69 - _t89;
        float _t102 = _r0 * _t12 + _r3 * _t11 + (-(_r1 * _t10) - _r2 * _t9);
        float _t109 = _r0 * _t13 + _r3 * _t14 + (_r1 * _t15 + _r2 * _t16) + (_r4 * _t9 + _r5 * _t10 + (_r6 * _t11 + _r7 * _t12));
        sclerp_s4b3cdb8d_tail2(_dst, _r2, _t15, _r1, _t16, _r3, _t13, _r0, _t14, _r7, _t11, _r6, _t12, _r5, _t9, _r4, _t10, _t101, _t93, _t94, _t89, _t69, _t102, _t109, t);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s4b3cdb8d_tail2(FloatDualQuatImpl _dst, float _r2, float _t15, float _r1, float _t16, float _r3, float _t13, float _r0, float _t14, float _r7, float _t11, float _r6, float _t12, float _r5, float _t9, float _r4, float _t10, float _t101, float _t93, float _t94, float _t89, float _t69, float _t102, float _t109, float t) {
        float _t110 = _r2 * _t15 - _r1 * _t16 + (_r3 * _t13 - _r0 * _t14) + (_r7 * _t11 - _r6 * _t12 + (_r5 * _t9 - _r4 * _t10));
        float _t111 = _r1 * _t13 - _r2 * _t14 + (_r3 * _t16 - _r0 * _t15) + (_r6 * _t9 - _r7 * _t10 + (_r5 * _t12 - _r4 * _t11));
        float _t115 = _r0 * _t16 + _r3 * _t15 + (-(_r1 * _t14) - _r2 * _t13) + (_r4 * _t12 + _r5 * _t11 + (-(_r6 * _t10) - _r7 * _t9));
        sclerp_s4b3cdb8d_tail3(_dst, _t101, _t93, _t94, _t89, _t69, _t102, _t109, _t110, _t111, _t115, t, _r0, _r3, _r1, _r2, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s4b3cdb8d_tail3(FloatDualQuatImpl _dst, float _t101, float _t93, float _t94, float _t89, float _t69, float _t102, float _t109, float _t110, float _t111, float _t115, float t, float _r0, float _r3, float _r1, float _r2, float _r4, float _r5, float _r6, float _r7) {
        float _t117, _t118, _t119, _t120, _t124, _t125, _t126, _t130;
        if (_t101 < 0.0f) {
            _t117 = -_t93;
            _t118 = -_t94;
            _t119 = _t89 - _t69;
            _t120 = -_t102;
            _t124 = -_t109;
            _t125 = -_t110;
            _t126 = -_t111;
            _t130 = -_t115;
        } else {
            _t117 = _t93;
            _t118 = _t94;
            _t119 = _t101;
            _t120 = _t102;
            _t124 = _t109;
            _t125 = _t110;
            _t126 = _t111;
            _t130 = _t115;
        }
        float _t136 = _t120 * _t120 + _t117 * _t117 + _t118 * _t118;
        float _t138 = (1.0f / (float) Math.sqrt(_t136));
        float _t139 = _t138 * _t117;
        float _t140 = _t138 * _t118;
        float _t142 = _t138 * _t120;
        float _t143 = t * (float) Math.atan2((float) Math.sqrt(_t136), _t119);
        sclerp_s4b3cdb8d_tail4(_dst, _t143, _t138, _t124, t, _t119, _t136, _t117, _t139, _t118, _t140, _t120, _t142, _t125, _t126, _t130, _r0, _r3, _r1, _r2, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s4b3cdb8d_tail4(FloatDualQuatImpl _dst, float _t143, float _t138, float _t124, float t, float _t119, float _t136, float _t117, float _t139, float _t118, float _t140, float _t120, float _t142, float _t125, float _t126, float _t130, float _r0, float _r3, float _r1, float _r2, float _r4, float _r5, float _r6, float _r7) {
        float _t144 = (float) Math.sin(_t143);
        float _sp0 = _t138 * _t144;
        float _t145 = _t138 * _t124;
        float _t146 = t * _t145;
        float _t147 = _t145 * _t119;
        float _t151 = (float) Math.cosFromSin(_t144, _t143);
        float _t159, _t160, _t161, _t162;
        if (_t136 < 1.0E-12f) {
            _t159 = 1.0f;
            _t160 = t * _t117;
            _t161 = t * _t118;
            _t162 = t * _t120;
        } else {
            _t159 = _t151;
            _t160 = _t139 * _t144;
            _t161 = _t140 * _t144;
            _t162 = _t142 * _t144;
        }
        float _t163 = _t146 * _t151;
        sclerp_s4b3cdb8d_tail5(_dst, _t136, t, _t124, _t146, _t144, _t125, _t147, _t139, _sp0, _t163, _t126, _t140, _t130, _t142, _r0, _t159, _r3, _t160, _r1, _t161, _r2, _t162, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s4b3cdb8d_tail5(FloatDualQuatImpl _dst, float _t136, float t, float _t124, float _t146, float _t144, float _t125, float _t147, float _t139, float _sp0, float _t163, float _t126, float _t140, float _t130, float _t142, float _r0, float _t159, float _r3, float _t160, float _r1, float _t161, float _r2, float _t162, float _r4, float _r5, float _r6, float _r7) {
        float _t164, _t177, _t178, _t179;
        if (_t136 < 1.0E-12f) {
            _t164 = t * t * _t124;
            _t177 = t * _t125;
            _t178 = t * _t126;
            _t179 = t * _t130;
        } else {
            _t164 = _t146 * _t144;
            _t177 = (_t147 * _t139 + _t125) * _sp0 - _t163 * _t139;
            _t178 = (_t147 * _t140 + _t126) * _sp0 - _t163 * _t140;
            _t179 = (_t147 * _t142 + _t130) * _sp0 - _t163 * _t142;
        }
        sclerp_s4b3cdb8d_c0(_dst, _r0, _t159, _r3, _t160, _r1, _t161, _r2, _t162);
        sclerp_s4b3cdb8d_c1(_dst, _r0, _t164, _r3, _t177, _r1, _t178, _r2, _t179, _r4, _t159, _r5, _t160, _r6, _t161, _r7, _t162);
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) using the interpolation factor {@code t}
     * and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (interpolation factor {@code 1}).
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
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
    public FloatDualQuat sclerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rY;
        float _r2 = this.rZ;
        float _r3 = this.rW;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t8 = otherRX * _r0 + otherRY * _r1 + (otherRZ * _r2 + otherRW * _r3) < 0.0f ? -1.0f : 1.0f;
        float _t9 = otherRX * _t8;
        float _t10 = otherRW * _t8;
        float _t11 = otherRY * _t8;
        float _t12 = otherRZ * _t8;
        float _t13 = otherDX * _t8;
        float _t14 = otherDW * _t8;
        float _t15 = otherDY * _t8;
        float _t16 = otherDZ * _t8;
        float _t69 = _r0 * _t9 + _r3 * _t10;
        float _t89 = -(_r1 * _t11) - _r2 * _t12;
        sclerp_s4b3cdb8d_tail(d, _r2, _t11, _r1, _t12, _r3, _t9, _r0, _t10, _t69, _t89, _t13, _t14, _t15, _t16, _r4, _r5, _r6, _r7, t);
        return d;
    }

    /** Private store group 0 of {@code sclerp}: computes and stores it; reached only through it. */
    private void sclerp_s1639cfc4_c0(DoubleDualQuatImpl _dst, float _r0, float _t159, float _r3, float _t160, float _r1, float _t161, float _r2, float _t162) {
        _dst.rX = _r0 * _t159 + _r3 * _t160 + (_r1 * _t161 - _r2 * _t162);
        _dst.rY = _r1 * _t159 + _r2 * _t160 + (_r3 * _t162 - _r0 * _t161);
        _dst.rZ = _r0 * _t162 + _r3 * _t161 + (_r2 * _t159 - _r1 * _t160);
        _dst.rW = _r3 * _t159 - _r0 * _t160 - (_r1 * _t162 + _r2 * _t161);
    }

    /** Private store group 1 of {@code sclerp}: computes and stores it; reached only through it. */
    private void sclerp_s1639cfc4_c1(DoubleDualQuatImpl _dst, float _r0, float _t164, float _r3, float _t177, float _r1, float _t178, float _r2, float _t179, float _r4, float _t159, float _r5, float _t160, float _r6, float _t161, float _r7, float _t162) {
        _dst.dX = _r0 * _t164 + _r3 * _t177 + (_r1 * _t178 - _r2 * _t179) + (_r4 * _t159 + _r5 * _t160 + (_r6 * _t161 - _r7 * _t162));
        _dst.dY = _r1 * _t164 + _r2 * _t177 + (_r3 * _t179 - _r0 * _t178) + (_r6 * _t159 + _r7 * _t160 + (_r5 * _t162 - _r4 * _t161));
        _dst.dZ = _r0 * _t179 + _r3 * _t178 + (_r2 * _t164 - _r1 * _t177) + (_r4 * _t162 + _r5 * _t161 + (_r7 * _t159 - _r6 * _t160));
        _dst.dW = _r3 * _t164 - _r0 * _t177 + (-(_r1 * _t179) - _r2 * _t178) + (_r5 * _t159 - _r4 * _t160 + (-(_r6 * _t162) - _r7 * _t161));
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s1639cfc4_tail(DoubleDualQuatImpl _dst, float _r2, float _t11, float _r1, float _t12, float _r3, float _t9, float _r0, float _t10, float _t69, float _t89, float _t13, float _t14, float _t15, float _t16, float _r4, float _r5, float _r6, float _r7, float t) {
        float _t93 = _r2 * _t11 - _r1 * _t12 + (_r3 * _t9 - _r0 * _t10);
        float _t94 = _r1 * _t9 - _r2 * _t10 + (_r3 * _t12 - _r0 * _t11);
        float _t101 = _t69 - _t89;
        float _t102 = _r0 * _t12 + _r3 * _t11 + (-(_r1 * _t10) - _r2 * _t9);
        float _t109 = _r0 * _t13 + _r3 * _t14 + (_r1 * _t15 + _r2 * _t16) + (_r4 * _t9 + _r5 * _t10 + (_r6 * _t11 + _r7 * _t12));
        sclerp_s1639cfc4_tail2(_dst, _r2, _t15, _r1, _t16, _r3, _t13, _r0, _t14, _r7, _t11, _r6, _t12, _r5, _t9, _r4, _t10, _t101, _t93, _t94, _t89, _t69, _t102, _t109, t);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s1639cfc4_tail2(DoubleDualQuatImpl _dst, float _r2, float _t15, float _r1, float _t16, float _r3, float _t13, float _r0, float _t14, float _r7, float _t11, float _r6, float _t12, float _r5, float _t9, float _r4, float _t10, float _t101, float _t93, float _t94, float _t89, float _t69, float _t102, float _t109, float t) {
        float _t110 = _r2 * _t15 - _r1 * _t16 + (_r3 * _t13 - _r0 * _t14) + (_r7 * _t11 - _r6 * _t12 + (_r5 * _t9 - _r4 * _t10));
        float _t111 = _r1 * _t13 - _r2 * _t14 + (_r3 * _t16 - _r0 * _t15) + (_r6 * _t9 - _r7 * _t10 + (_r5 * _t12 - _r4 * _t11));
        float _t115 = _r0 * _t16 + _r3 * _t15 + (-(_r1 * _t14) - _r2 * _t13) + (_r4 * _t12 + _r5 * _t11 + (-(_r6 * _t10) - _r7 * _t9));
        sclerp_s1639cfc4_tail3(_dst, _t101, _t93, _t94, _t89, _t69, _t102, _t109, _t110, _t111, _t115, t, _r0, _r3, _r1, _r2, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s1639cfc4_tail3(DoubleDualQuatImpl _dst, float _t101, float _t93, float _t94, float _t89, float _t69, float _t102, float _t109, float _t110, float _t111, float _t115, float t, float _r0, float _r3, float _r1, float _r2, float _r4, float _r5, float _r6, float _r7) {
        float _t117, _t118, _t119, _t120, _t124, _t125, _t126, _t130;
        if (_t101 < 0.0f) {
            _t117 = -_t93;
            _t118 = -_t94;
            _t119 = _t89 - _t69;
            _t120 = -_t102;
            _t124 = -_t109;
            _t125 = -_t110;
            _t126 = -_t111;
            _t130 = -_t115;
        } else {
            _t117 = _t93;
            _t118 = _t94;
            _t119 = _t101;
            _t120 = _t102;
            _t124 = _t109;
            _t125 = _t110;
            _t126 = _t111;
            _t130 = _t115;
        }
        float _t136 = _t120 * _t120 + _t117 * _t117 + _t118 * _t118;
        float _t138 = (1.0f / (float) Math.sqrt(_t136));
        float _t139 = _t138 * _t117;
        float _t140 = _t138 * _t118;
        float _t142 = _t138 * _t120;
        float _t143 = t * (float) Math.atan2((float) Math.sqrt(_t136), _t119);
        sclerp_s1639cfc4_tail4(_dst, _t143, _t138, _t124, t, _t119, _t136, _t117, _t139, _t118, _t140, _t120, _t142, _t125, _t126, _t130, _r0, _r3, _r1, _r2, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s1639cfc4_tail4(DoubleDualQuatImpl _dst, float _t143, float _t138, float _t124, float t, float _t119, float _t136, float _t117, float _t139, float _t118, float _t140, float _t120, float _t142, float _t125, float _t126, float _t130, float _r0, float _r3, float _r1, float _r2, float _r4, float _r5, float _r6, float _r7) {
        float _t144 = (float) Math.sin(_t143);
        float _sp0 = _t138 * _t144;
        float _t145 = _t138 * _t124;
        float _t146 = t * _t145;
        float _t147 = _t145 * _t119;
        float _t151 = (float) Math.cosFromSin(_t144, _t143);
        float _t159, _t160, _t161, _t162;
        if (_t136 < 1.0E-12f) {
            _t159 = 1.0f;
            _t160 = t * _t117;
            _t161 = t * _t118;
            _t162 = t * _t120;
        } else {
            _t159 = _t151;
            _t160 = _t139 * _t144;
            _t161 = _t140 * _t144;
            _t162 = _t142 * _t144;
        }
        float _t163 = _t146 * _t151;
        sclerp_s1639cfc4_tail5(_dst, _t136, t, _t124, _t146, _t144, _t125, _t147, _t139, _sp0, _t163, _t126, _t140, _t130, _t142, _r0, _t159, _r3, _t160, _r1, _t161, _r2, _t162, _r4, _r5, _r6, _r7);
    }

    /** Private tail of {@code sclerp}; reached only through it. */
    private void sclerp_s1639cfc4_tail5(DoubleDualQuatImpl _dst, float _t136, float t, float _t124, float _t146, float _t144, float _t125, float _t147, float _t139, float _sp0, float _t163, float _t126, float _t140, float _t130, float _t142, float _r0, float _t159, float _r3, float _t160, float _r1, float _t161, float _r2, float _t162, float _r4, float _r5, float _r6, float _r7) {
        float _t164, _t177, _t178, _t179;
        if (_t136 < 1.0E-12f) {
            _t164 = t * t * _t124;
            _t177 = t * _t125;
            _t178 = t * _t126;
            _t179 = t * _t130;
        } else {
            _t164 = _t146 * _t144;
            _t177 = (_t147 * _t139 + _t125) * _sp0 - _t163 * _t139;
            _t178 = (_t147 * _t140 + _t126) * _sp0 - _t163 * _t140;
            _t179 = (_t147 * _t142 + _t130) * _sp0 - _t163 * _t142;
        }
        sclerp_s1639cfc4_c0(_dst, _r0, _t159, _r3, _t160, _r1, _t161, _r2, _t162);
        sclerp_s1639cfc4_c1(_dst, _r0, _t164, _r3, _t177, _r1, _t178, _r2, _t179, _r4, _t159, _r5, _t160, _r6, _t161, _r7, _t162);
    }


    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) using the interpolation factor {@code t}
     * and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this dual quaternion (interpolation factor {@code 0}) and ends at
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) (interpolation factor {@code 1}).
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherRX the {@code rX} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRY the {@code rY} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRZ the {@code rZ} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
     * @param otherRW the {@code rW} component of the dual quaternion
     *        {@code (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)} (the
     *        real part must have unit length)
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
    public DoubleDualQuat sclerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rY;
        float _r2 = this.rZ;
        float _r3 = this.rW;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t8 = otherRX * _r0 + otherRY * _r1 + (otherRZ * _r2 + otherRW * _r3) < 0.0f ? -1.0f : 1.0f;
        float _t9 = otherRX * _t8;
        float _t10 = otherRW * _t8;
        float _t11 = otherRY * _t8;
        float _t12 = otherRZ * _t8;
        float _t13 = otherDX * _t8;
        float _t14 = otherDW * _t8;
        float _t15 = otherDY * _t8;
        float _t16 = otherDZ * _t8;
        float _t69 = _r0 * _t9 + _r3 * _t10;
        float _t89 = -(_r1 * _t11) - _r2 * _t12;
        sclerp_s1639cfc4_tail(d, _r2, _t11, _r1, _t12, _r3, _t9, _r0, _t10, _t69, _t89, _t13, _t14, _t15, _t16, _r4, _r5, _r6, _r7, t);
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
     * @param other the right operand
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat mul(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return mul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Multiply this dual quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the right operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
        return mul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }

    /** Private store group 0 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s447e38b9_c0(FloatDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRZ, float _r2, float otherRY, float _r3) {
        _dst.rX = otherRX * _r0 + otherRW * _r1 + (otherRZ * _r2 - otherRY * _r3);
        _dst.rY = otherRX * _r3 + otherRW * _r2 + (otherRY * _r0 - otherRZ * _r1);
        _dst.rZ = otherRY * _r1 + otherRZ * _r0 + (otherRW * _r3 - otherRX * _r2);
        _dst.rW = otherRW * _r0 - otherRX * _r1 - (otherRY * _r2 + otherRZ * _r3);
    }

    /** Private store group 1 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s447e38b9_c1(FloatDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRZ, float _r6, float otherRY, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDZ, float _r2, float otherDY, float _r3) {
        _dst.dX = otherRX * _r4 + otherRW * _r5 + (otherRZ * _r6 - otherRY * _r7) + (otherDX * _r0 + otherDW * _r1 + (otherDZ * _r2 - otherDY * _r3));
        _dst.dY = otherRX * _r7 + otherRW * _r6 + (otherRY * _r4 - otherRZ * _r5) + (otherDX * _r3 + otherDW * _r2 + (otherDY * _r0 - otherDZ * _r1));
        _dst.dZ = otherRY * _r5 + otherRZ * _r4 + (otherRW * _r7 - otherRX * _r6) + (otherDY * _r1 + otherDZ * _r0 + (otherDW * _r3 - otherDX * _r2));
        _dst.dW = otherRW * _r4 - otherRX * _r5 + (-(otherRY * _r6) - otherRZ * _r7) + (otherDW * _r0 - otherDX * _r1 + (-(otherDY * _r2) - otherDZ * _r3));
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
    public FloatDualQuat mul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        mul_s447e38b9_c0(d, otherRX, _r0, otherRW, _r1, otherRZ, _r2, otherRY, _r3);
        mul_s447e38b9_c1(d, otherRX, _r4, otherRW, _r5, otherRZ, _r6, otherRY, _r7, otherDX, _r0, otherDW, _r1, otherDZ, _r2, otherDY, _r3);
        return d;
    }

    /** Private store group 0 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s45241818_c0(DoubleDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRZ, float _r2, float otherRY, float _r3) {
        _dst.rX = otherRX * _r0 + otherRW * _r1 + (otherRZ * _r2 - otherRY * _r3);
        _dst.rY = otherRX * _r3 + otherRW * _r2 + (otherRY * _r0 - otherRZ * _r1);
        _dst.rZ = otherRY * _r1 + otherRZ * _r0 + (otherRW * _r3 - otherRX * _r2);
        _dst.rW = otherRW * _r0 - otherRX * _r1 - (otherRY * _r2 + otherRZ * _r3);
    }

    /** Private store group 1 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s45241818_c1(DoubleDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRZ, float _r6, float otherRY, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDZ, float _r2, float otherDY, float _r3) {
        _dst.dX = otherRX * _r4 + otherRW * _r5 + (otherRZ * _r6 - otherRY * _r7) + (otherDX * _r0 + otherDW * _r1 + (otherDZ * _r2 - otherDY * _r3));
        _dst.dY = otherRX * _r7 + otherRW * _r6 + (otherRY * _r4 - otherRZ * _r5) + (otherDX * _r3 + otherDW * _r2 + (otherDY * _r0 - otherDZ * _r1));
        _dst.dZ = otherRY * _r5 + otherRZ * _r4 + (otherRW * _r7 - otherRX * _r6) + (otherDY * _r1 + otherDZ * _r0 + (otherDW * _r3 - otherDX * _r2));
        _dst.dW = otherRW * _r4 - otherRX * _r5 + (-(otherRY * _r6) - otherRZ * _r7) + (otherDW * _r0 - otherDX * _r1 + (-(otherDY * _r2) - otherDZ * _r3));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat mul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        mul_s45241818_c0(d, otherRX, _r0, otherRW, _r1, otherRZ, _r2, otherRY, _r3);
        mul_s45241818_c1(d, otherRX, _r4, otherRW, _r5, otherRZ, _r6, otherRY, _r7, otherDX, _r0, otherDW, _r1, otherDZ, _r2, otherDY, _r3);
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
     * @param other the left operand
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat preMul(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return preMul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Pre-multiply {@code other} onto this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the left operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat preMul(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
        return preMul(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }

    /** Private store group 0 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s447e38b9_c0(FloatDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRY, float _r2, float otherRZ, float _r3) {
        _dst.rX = otherRX * _r0 + otherRW * _r1 + (otherRY * _r2 - otherRZ * _r3);
        _dst.rY = otherRY * _r0 + otherRZ * _r1 + (otherRW * _r3 - otherRX * _r2);
        _dst.rZ = otherRX * _r3 + otherRW * _r2 + (otherRZ * _r0 - otherRY * _r1);
        _dst.rW = otherRW * _r0 - otherRX * _r1 - (otherRY * _r3 + otherRZ * _r2);
    }

    /** Private store group 1 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s447e38b9_c1(FloatDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRY, float _r6, float otherRZ, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDY, float _r2, float otherDZ, float _r3) {
        _dst.dX = otherRX * _r4 + otherRW * _r5 + (otherRY * _r6 - otherRZ * _r7) + (otherDX * _r0 + otherDW * _r1 + (otherDY * _r2 - otherDZ * _r3));
        _dst.dY = otherRY * _r4 + otherRZ * _r5 + (otherRW * _r7 - otherRX * _r6) + (otherDY * _r0 + otherDZ * _r1 + (otherDW * _r3 - otherDX * _r2));
        _dst.dZ = otherRX * _r7 + otherRW * _r6 + (otherRZ * _r4 - otherRY * _r5) + (otherDX * _r3 + otherDW * _r2 + (otherDZ * _r0 - otherDY * _r1));
        _dst.dW = otherRW * _r4 - otherRX * _r5 + (-(otherRY * _r7) - otherRZ * _r6) + (otherDW * _r0 - otherDX * _r1 + (-(otherDY * _r3) - otherDZ * _r2));
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
    public FloatDualQuat preMul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rZ;
        float _r3 = this.rY;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dZ;
        float _r7 = this.dY;
        preMul_s447e38b9_c0(d, otherRX, _r0, otherRW, _r1, otherRY, _r2, otherRZ, _r3);
        preMul_s447e38b9_c1(d, otherRX, _r4, otherRW, _r5, otherRY, _r6, otherRZ, _r7, otherDX, _r0, otherDW, _r1, otherDY, _r2, otherDZ, _r3);
        return d;
    }

    /** Private store group 0 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s45241818_c0(DoubleDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRY, float _r2, float otherRZ, float _r3) {
        _dst.rX = otherRX * _r0 + otherRW * _r1 + (otherRY * _r2 - otherRZ * _r3);
        _dst.rY = otherRY * _r0 + otherRZ * _r1 + (otherRW * _r3 - otherRX * _r2);
        _dst.rZ = otherRX * _r3 + otherRW * _r2 + (otherRZ * _r0 - otherRY * _r1);
        _dst.rW = otherRW * _r0 - otherRX * _r1 - (otherRY * _r3 + otherRZ * _r2);
    }

    /** Private store group 1 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s45241818_c1(DoubleDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRY, float _r6, float otherRZ, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDY, float _r2, float otherDZ, float _r3) {
        _dst.dX = otherRX * _r4 + otherRW * _r5 + (otherRY * _r6 - otherRZ * _r7) + (otherDX * _r0 + otherDW * _r1 + (otherDY * _r2 - otherDZ * _r3));
        _dst.dY = otherRY * _r4 + otherRZ * _r5 + (otherRW * _r7 - otherRX * _r6) + (otherDY * _r0 + otherDZ * _r1 + (otherDW * _r3 - otherDX * _r2));
        _dst.dZ = otherRX * _r7 + otherRW * _r6 + (otherRZ * _r4 - otherRY * _r5) + (otherDX * _r3 + otherDW * _r2 + (otherDZ * _r0 - otherDY * _r1));
        _dst.dW = otherRW * _r4 - otherRX * _r5 + (-(otherRY * _r7) - otherRZ * _r6) + (otherDW * _r0 - otherDX * _r1 + (-(otherDY * _r3) - otherDZ * _r2));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat preMul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rZ;
        float _r3 = this.rY;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dZ;
        float _r7 = this.dY;
        preMul_s45241818_c0(d, otherRX, _r0, otherRW, _r1, otherRY, _r2, otherRZ, _r3);
        preMul_s45241818_c1(d, otherRX, _r4, otherRW, _r5, otherRY, _r6, otherRZ, _r7, otherDX, _r0, otherDW, _r1, otherDY, _r2, otherDZ, _r3);
        return d;
    }


    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param other the dual quaternion to scale and add
     * @param weight the factor to scale {@code other} by before adding
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat addScaled(FloatDualQuatR other, float weight, @Mutated FloatDualQuat dest) {
        return addScaled(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), weight, dest);
    }


    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the dual quaternion to scale and add
     * @param weight the factor to scale {@code other} by before adding
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat addScaled(FloatDualQuatR other, float weight, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat addScaled(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float weight, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = weight * otherRX + this.rX;
        d.rY = weight * otherRY + this.rY;
        d.rZ = weight * otherRZ + this.rZ;
        d.rW = weight * otherRW + this.rW;
        d.dX = weight * otherDX + this.dX;
        d.dY = weight * otherDY + this.dY;
        d.dZ = weight * otherDZ + this.dZ;
        d.dW = weight * otherDW + this.dW;
        return d;
    }


    /**
     * Add ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) scaled by {@code weight} to this dual
     * quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat addScaled(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float weight, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = weight * otherRX + this.rX;
        d.rY = weight * otherRY + this.rY;
        d.rZ = weight * otherRZ + this.rZ;
        d.rW = weight * otherRW + this.rW;
        d.dX = weight * otherDX + this.dX;
        d.dY = weight * otherDY + this.dY;
        d.dZ = weight * otherDZ + this.dZ;
        d.dW = weight * otherDW + this.dW;
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
    public FloatDualQuat conjugate(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Compute the quaternion conjugate of this dual quaternion, conjugating both the real and the
     * dual part (for a unit dual quaternion this is its inverse) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * transformation {@code D} with {@code this * D = other}, that is {@code D = this^-1 * other}
     * and store the result in {@code dest}.
     *
     * @param other the target dual quaternion, reached by composing this dual quaternion with the
     *        result
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat difference(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return difference(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation {@code D} with {@code this * D = other}, that is {@code D = this^-1 * other}
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the target dual quaternion, reached by composing this dual quaternion with the
     *        result
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat difference(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
        return difference(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }

    /** Private store group 0 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s447e38b9_c0(FloatDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRY, float _r2, float otherRZ, float _r3) {
        _dst.rX = otherRX * _r0 - otherRW * _r1 + (otherRY * _r2 - otherRZ * _r3);
        _dst.rY = otherRY * _r0 + otherRZ * _r1 + (-(otherRW * _r3) - otherRX * _r2);
        _dst.rZ = otherRX * _r3 - otherRW * _r2 + (otherRZ * _r0 - otherRY * _r1);
        _dst.rW = otherRX * _r1 + otherRW * _r0 - (-(otherRY * _r3) - otherRZ * _r2);
    }

    /** Private store group 1 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s447e38b9_c1(FloatDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRY, float _r6, float otherRZ, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDY, float _r2, float otherDZ, float _r3) {
        _dst.dX = otherRX * _r4 - otherRW * _r5 + (otherRY * _r6 - otherRZ * _r7) + (otherDX * _r0 - otherDW * _r1 + (otherDY * _r2 - otherDZ * _r3));
        _dst.dY = otherRY * _r4 + otherRZ * _r5 + (-(otherRW * _r7) - otherRX * _r6) + (otherDY * _r0 + otherDZ * _r1 + (-(otherDW * _r3) - otherDX * _r2));
        _dst.dZ = otherRX * _r7 - otherRW * _r6 + (otherRZ * _r4 - otherRY * _r5) + (otherDX * _r3 - otherDW * _r2 + (otherDZ * _r0 - otherDY * _r1));
        _dst.dW = otherRX * _r5 + otherRW * _r4 + (otherRY * _r7 + otherRZ * _r6) + (otherDX * _r1 + otherDW * _r0 + (otherDY * _r3 + otherDZ * _r2));
    }


    /**
     * Compute the difference between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}), i.e. the rigid transformation {@code D} with
     * {@code this * D = (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)},
     * that is
     * {@code D = this^-1 * (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
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
    public FloatDualQuat difference(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rZ;
        float _r3 = this.rY;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dZ;
        float _r7 = this.dY;
        difference_s447e38b9_c0(d, otherRX, _r0, otherRW, _r1, otherRY, _r2, otherRZ, _r3);
        difference_s447e38b9_c1(d, otherRX, _r4, otherRW, _r5, otherRY, _r6, otherRZ, _r7, otherDX, _r0, otherDW, _r1, otherDY, _r2, otherDZ, _r3);
        return d;
    }

    /** Private store group 0 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s45241818_c0(DoubleDualQuatImpl _dst, float otherRX, float _r0, float otherRW, float _r1, float otherRY, float _r2, float otherRZ, float _r3) {
        _dst.rX = otherRX * _r0 - otherRW * _r1 + (otherRY * _r2 - otherRZ * _r3);
        _dst.rY = otherRY * _r0 + otherRZ * _r1 + (-(otherRW * _r3) - otherRX * _r2);
        _dst.rZ = otherRX * _r3 - otherRW * _r2 + (otherRZ * _r0 - otherRY * _r1);
        _dst.rW = otherRX * _r1 + otherRW * _r0 - (-(otherRY * _r3) - otherRZ * _r2);
    }

    /** Private store group 1 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s45241818_c1(DoubleDualQuatImpl _dst, float otherRX, float _r4, float otherRW, float _r5, float otherRY, float _r6, float otherRZ, float _r7, float otherDX, float _r0, float otherDW, float _r1, float otherDY, float _r2, float otherDZ, float _r3) {
        _dst.dX = otherRX * _r4 - otherRW * _r5 + (otherRY * _r6 - otherRZ * _r7) + (otherDX * _r0 - otherDW * _r1 + (otherDY * _r2 - otherDZ * _r3));
        _dst.dY = otherRY * _r4 + otherRZ * _r5 + (-(otherRW * _r7) - otherRX * _r6) + (otherDY * _r0 + otherDZ * _r1 + (-(otherDW * _r3) - otherDX * _r2));
        _dst.dZ = otherRX * _r7 - otherRW * _r6 + (otherRZ * _r4 - otherRY * _r5) + (otherDX * _r3 - otherDW * _r2 + (otherDZ * _r0 - otherDY * _r1));
        _dst.dW = otherRX * _r5 + otherRW * _r4 + (otherRY * _r7 + otherRZ * _r6) + (otherDX * _r1 + otherDW * _r0 + (otherDY * _r3 + otherDZ * _r2));
    }


    /**
     * Compute the difference between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}), i.e. the rigid transformation {@code D} with
     * {@code this * D = (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)},
     * that is
     * {@code D = this^-1 * (otherRX, otherRY, otherRZ, otherRW, otherDX, otherDY, otherDZ, otherDW)}
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat difference(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rZ;
        float _r3 = this.rY;
        float _r4 = this.dW;
        float _r5 = this.dX;
        float _r6 = this.dZ;
        float _r7 = this.dY;
        difference_s45241818_c0(d, otherRX, _r0, otherRW, _r1, otherRY, _r2, otherRZ, _r3);
        difference_s45241818_c1(d, otherRX, _r4, otherRW, _r5, otherRY, _r6, otherRZ, _r7, otherDX, _r0, otherDW, _r1, otherDY, _r2, otherDZ, _r3);
        return d;
    }


    /**
     * Compute the dot product of this dual quaternion and {@code other}.
     *
     * @param other the other operand of the dot product
     * @return the dot product of this dual quaternion and {@code other}
     */
    public float dot(FloatDualQuatR other) {
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
        return otherRX * this.rX + otherRY * this.rY + (otherRZ * this.rZ + otherRW * this.rW) + (otherDX * this.dX + otherDY * this.dY + (otherDZ * this.dZ + otherDW * this.dW));
    }


    /**
     * Compute the dual-number conjugate of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat dualConjugate(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
     * Compute the dual-number conjugate of this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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

    /** Private store group 0 of {@code exp}: computes and stores it; reached only through it. */
    private void exp_s416ccfb5_c0(FloatDualQuatImpl _dst, float _t8, float _r0, float _t13, float _t12, float _r1, float _t14, float _r2, float _t15, float _t17) {
        _dst.rX = _t8 < 1.0E-12f ? _r0 : _t13 * _t12;
        _dst.rY = _t8 < 1.0E-12f ? _r1 : _t14 * _t12;
        _dst.rZ = _t8 < 1.0E-12f ? _r2 : _t15 * _t12;
        _dst.rW = _t8 < 1.0E-12f ? 1.0f : _t17;
    }

    /** Private store group 1 of {@code exp}: computes and stores it; reached only through it. */
    private void exp_s416ccfb5_c1(FloatDualQuatImpl _dst, float _t8, float _r3, float _t13, float _t18, float _t16, float _sp0, float _r4, float _t14, float _r5, float _t15, float _t9, float _t12) {
        _dst.dX = _t8 < 1.0E-12f ? _r3 : _t13 * _t18 + (_r3 - _t13 * _t16) * _sp0;
        _dst.dY = _t8 < 1.0E-12f ? _r4 : _t14 * _t18 + (_r4 - _t14 * _t16) * _sp0;
        _dst.dZ = _t8 < 1.0E-12f ? _r5 : _t15 * _t18 + (_r5 - _t15 * _t16) * _sp0;
        _dst.dW = _t8 < 1.0E-12f ? -_t9 : -(_t16 * _t12);
    }


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     * <p>
     * This dual quaternion is read as a screw-motion generator, a pure dual quaternion as
     * {@code log} returns it: its scalar parts {@code rW} and {@code dW} are taken as zero and
     * ignored. The result is a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat exp(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rY;
        float _r2 = this.rZ;
        float _r3 = this.dX;
        float _r4 = this.dY;
        float _r5 = this.dZ;
        float _t8 = _r0 * _r0 + _r1 * _r1 + _r2 * _r2;
        float _t9 = _r0 * _r3 + _r1 * _r4 + _r2 * _r5;
        float _t11 = (float) Math.sqrt(_t8);
        float _t10 = 1.0f / _t11;
        float _t12 = (float) Math.sin(_t11);
        float _sp0 = _t10 * _t12;
        float _t13 = _r0 * _t10;
        float _t14 = _r1 * _t10;
        float _t15 = _r2 * _t10;
        float _t16 = _t9 * _t10;
        float _t17 = (float) Math.cosFromSin(_t12, _t11);
        float _t18 = _t16 * _t17;
        exp_s416ccfb5_c0(d, _t8, _r0, _t13, _t12, _r1, _t14, _r2, _t15, _t17);
        exp_s416ccfb5_c1(d, _t8, _r3, _t13, _t18, _t16, _sp0, _r4, _t14, _r5, _t15, _t9, _t12);
        return d;
    }

    /** Private store group 0 of {@code exp}: computes and stores it; reached only through it. */
    private void exp_s6608609c_c0(DoubleDualQuatImpl _dst, float _t8, float _r0, float _t13, float _t12, float _r1, float _t14, float _r2, float _t15, float _t17) {
        _dst.rX = _t8 < 1.0E-12f ? _r0 : _t13 * _t12;
        _dst.rY = _t8 < 1.0E-12f ? _r1 : _t14 * _t12;
        _dst.rZ = _t8 < 1.0E-12f ? _r2 : _t15 * _t12;
        _dst.rW = _t8 < 1.0E-12f ? 1.0f : _t17;
    }

    /** Private store group 1 of {@code exp}: computes and stores it; reached only through it. */
    private void exp_s6608609c_c1(DoubleDualQuatImpl _dst, float _t8, float _r3, float _t13, float _t18, float _t16, float _sp0, float _r4, float _t14, float _r5, float _t15, float _t9, float _t12) {
        _dst.dX = _t8 < 1.0E-12f ? _r3 : _t13 * _t18 + (_r3 - _t13 * _t16) * _sp0;
        _dst.dY = _t8 < 1.0E-12f ? _r4 : _t14 * _t18 + (_r4 - _t14 * _t16) * _sp0;
        _dst.dZ = _t8 < 1.0E-12f ? _r5 : _t15 * _t18 + (_r5 - _t15 * _t16) * _sp0;
        _dst.dW = _t8 < 1.0E-12f ? -_t9 : -(_t16 * _t12);
    }


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     * <p>
     * This dual quaternion is read as a screw-motion generator, a pure dual quaternion as
     * {@code log} returns it: its scalar parts {@code rW} and {@code dW} are taken as zero and
     * ignored. The result is a unit dual quaternion.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat exp(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rY;
        float _r2 = this.rZ;
        float _r3 = this.dX;
        float _r4 = this.dY;
        float _r5 = this.dZ;
        float _t8 = _r0 * _r0 + _r1 * _r1 + _r2 * _r2;
        float _t9 = _r0 * _r3 + _r1 * _r4 + _r2 * _r5;
        float _t11 = (float) Math.sqrt(_t8);
        float _t10 = 1.0f / _t11;
        float _t12 = (float) Math.sin(_t11);
        float _sp0 = _t10 * _t12;
        float _t13 = _r0 * _t10;
        float _t14 = _r1 * _t10;
        float _t15 = _r2 * _t10;
        float _t16 = _t9 * _t10;
        float _t17 = (float) Math.cosFromSin(_t12, _t11);
        float _t18 = _t16 * _t17;
        exp_s6608609c_c0(d, _t8, _r0, _t13, _t12, _r1, _t14, _r2, _t15, _t17);
        exp_s6608609c_c1(d, _t8, _r3, _t13, _t18, _t16, _sp0, _r4, _t14, _r5, _t15, _t9, _t12);
        return d;
    }


    /**
     * Get the dual part of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat getDual(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = this.dX;
        d.y = this.dY;
        d.z = this.dZ;
        d.w = this.dW;
        return d;
    }


    /**
     * Get the dual part of this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXYZ(e.x(), e.y(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXYZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.rX * this.rX;
        float _t1 = this.rY * this.rY;
        float _t2 = this.rX * this.rW;
        float _t3 = this.rY * this.rZ;
        float _t6 = this.rZ * this.rZ;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.rX * this.rZ + this.rY * this.rW);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 + _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.z = (float) Math.atan2(2.0f * (this.rZ * this.rW - this.rX * this.rY), 1.0f - 2.0f * (_t1 + _t6));
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Y and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXYZ(e.x(), e.y(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.rX * this.rX;
        float _t1 = this.rY * this.rY;
        float _t2 = this.rX * this.rW;
        float _t3 = this.rY * this.rZ;
        float _t6 = this.rZ * this.rZ;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.rX * this.rZ + this.rY * this.rW);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 + _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.z = (float) Math.atan2(2.0f * (this.rZ * this.rW - this.rX * this.rY), 1.0f - 2.0f * (_t1 + _t6));
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Z and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXZY(e.x(), e.z(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXZY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.rX * this.rX;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rX * this.rW;
        float _t3 = this.rY * this.rZ;
        float _t6 = this.rY * this.rY;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.rZ * this.rW - this.rX * this.rY);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 - _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.y = (float) Math.atan2(2.0f * (this.rX * this.rZ + this.rY * this.rW), 1.0f - 2.0f * (_t6 + _t1));
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Z and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXZY(e.x(), e.z(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.rX * this.rX;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rX * this.rW;
        float _t3 = this.rY * this.rZ;
        float _t6 = this.rY * this.rY;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.rZ * this.rW - this.rX * this.rY);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 - _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.y = (float) Math.atan2(2.0f * (this.rX * this.rZ + this.rY * this.rW), 1.0f - 2.0f * (_t6 + _t1));
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, X and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYXZ(e.y(), e.x(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYXZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = this.rX * this.rX;
        float _t3 = this.rY * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t6 = this.rZ * this.rZ;
        float _t10 = 2.0f * (this.rX * this.rW - this.rY * this.rZ);
        float _t12 = 2.0f * (_t4 + _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t5 - _t4), 1.0f - 2.0f * (_t3 + _t6));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t12, _t13);
            d.z = (float) Math.atan2(2.0f * (this.rX * this.rY + this.rZ * this.rW), 1.0f - 2.0f * (_t2 + _t6));
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t10, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, X and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYXZ(e.y(), e.x(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = this.rX * this.rX;
        float _t3 = this.rY * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t6 = this.rZ * this.rZ;
        float _t10 = 2.0f * (this.rX * this.rW - this.rY * this.rZ);
        float _t12 = 2.0f * (_t4 + _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t5 - _t4), 1.0f - 2.0f * (_t3 + _t6));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t12, _t13);
            d.z = (float) Math.atan2(2.0f * (this.rX * this.rY + this.rZ * this.rW), 1.0f - 2.0f * (_t2 + _t6));
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t10, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, Z and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYZX(e.y(), e.z(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYZX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.rY * this.rY;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rY * this.rW;
        float _t3 = this.rX * this.rZ;
        float _t6 = this.rX * this.rX;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.rX * this.rY + this.rZ * this.rW);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.y = (float) Math.atan2(2.0f * (_t3 + _t2), 1.0f - 2.0f * (_t6 + _t0));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.rX * this.rW - this.rY * this.rZ), 1.0f - 2.0f * (_t6 + _t1));
            d.y = (float) Math.atan2(_t11, _t13);
        }
        d.z = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, Z and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYZX(e.y(), e.z(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.rY * this.rY;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rY * this.rW;
        float _t3 = this.rX * this.rZ;
        float _t6 = this.rX * this.rX;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.rX * this.rY + this.rZ * this.rW);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.y = (float) Math.atan2(2.0f * (_t3 + _t2), 1.0f - 2.0f * (_t6 + _t0));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.rX * this.rW - this.rY * this.rZ), 1.0f - 2.0f * (_t6 + _t1));
            d.y = (float) Math.atan2(_t11, _t13);
        }
        d.z = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, X and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZXY(e.z(), e.x(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZXY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = this.rX * this.rX;
        float _t3 = this.rZ * this.rZ;
        float _t4 = this.rZ * this.rW;
        float _t5 = this.rX * this.rY;
        float _t6 = this.rY * this.rY;
        float _t10 = 2.0f * (this.rX * this.rW + this.rY * this.rZ);
        float _t12 = 2.0f * (_t4 - _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            d.y = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t5 + _t4), 1.0f - 2.0f * (_t6 + _t3));
        } else {
            d.y = (float) Math.atan2(2.0f * (this.rY * this.rW - this.rX * this.rZ), 1.0f - 2.0f * (_t2 + _t6));
            d.z = (float) Math.atan2(_t12, _t13);
        }
        d.x = (float) Math.atan2(_t10, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, X and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZXY(e.z(), e.x(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = this.rX * this.rX;
        float _t3 = this.rZ * this.rZ;
        float _t4 = this.rZ * this.rW;
        float _t5 = this.rX * this.rY;
        float _t6 = this.rY * this.rY;
        float _t10 = 2.0f * (this.rX * this.rW + this.rY * this.rZ);
        float _t12 = 2.0f * (_t4 - _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            d.y = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t5 + _t4), 1.0f - 2.0f * (_t6 + _t3));
        } else {
            d.y = (float) Math.atan2(2.0f * (this.rY * this.rW - this.rX * this.rZ), 1.0f - 2.0f * (_t2 + _t6));
            d.z = (float) Math.atan2(_t12, _t13);
        }
        d.x = (float) Math.atan2(_t10, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, Y and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZYX(e.z(), e.y(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZYX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.rY * this.rY;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rX * this.rY;
        float _t3 = this.rZ * this.rW;
        float _t6 = this.rX * this.rX;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.rY * this.rW - this.rX * this.rZ);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t3 - _t2), 1.0f - 2.0f * (_t6 + _t1));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.rX * this.rW + this.rY * this.rZ), 1.0f - 2.0f * (_t6 + _t0));
            d.z = (float) Math.atan2(_t11, _t13);
        }
        d.y = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, Y and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZYX(e.z(), e.y(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.rY * this.rY;
        float _t1 = this.rZ * this.rZ;
        float _t2 = this.rX * this.rY;
        float _t3 = this.rZ * this.rW;
        float _t6 = this.rX * this.rX;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.rY * this.rW - this.rX * this.rZ);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t3 - _t2), 1.0f - 2.0f * (_t6 + _t1));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.rX * this.rW + this.rY * this.rZ), 1.0f - 2.0f * (_t6 + _t0));
            d.z = (float) Math.atan2(_t11, _t13);
        }
        d.y = (float) Math.atan2(_t12, (float) Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the rotation of this dual quaternion, i.e. its raw real part (a unit quaternion only when
     * this dual quaternion has unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat getRotation(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = this.rX;
        d.y = this.rY;
        d.z = this.rZ;
        d.w = this.rW;
        return d;
    }


    /**
     * Get the rotation of this dual quaternion, i.e. its raw real part (a unit quaternion only when
     * this dual quaternion has unit length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 getTranslation(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.z = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Get the translation of this dual quaternion, i.e. {@code 2 * dual * conj(real)} (the actual
     * translation only when this dual quaternion has unit length) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getTranslation(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf1 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.z = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
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
    public FloatDualQuat inverseUnit(@Mutated FloatDualQuat dest) {
        return conjugate(dest);
    }


    /**
     * Compute the inverse of this dual quaternion, which is assumed to have unit length and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public FloatDualQuat invert(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t12 = this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW);
        float _t12_inv = 1.0f / _t12;
        float _sp0 = 2.0f * (this.rX * this.dX + this.rY * this.dY + (this.rZ * this.dZ + this.rW * this.dW)) / (_t12 * _t12);
        float _buf0 = -(this.rX * _t12_inv);
        float _buf1 = -(this.rY * _t12_inv);
        float _buf2 = -(this.rZ * _t12_inv);
        float _buf3 = this.rW * _t12_inv;
        d.dX = this.rX * _sp0 - this.dX * _t12_inv;
        d.dY = this.rY * _sp0 - this.dY * _t12_inv;
        d.dZ = this.rZ * _sp0 - this.dZ * _t12_inv;
        d.dW = this.dW * _t12_inv - this.rW * _sp0;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Invert this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat invert(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t12 = this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW);
        float _t12_inv = 1.0f / _t12;
        float _sp0 = 2.0f * (this.rX * this.dX + this.rY * this.dY + (this.rZ * this.dZ + this.rW * this.dW)) / (_t12 * _t12);
        float _buf0 = -(this.rX * _t12_inv);
        float _buf1 = -(this.rY * _t12_inv);
        float _buf2 = -(this.rZ * _t12_inv);
        float _buf3 = this.rW * _t12_inv;
        d.dX = this.rX * _sp0 - this.dX * _t12_inv;
        d.dY = this.rY * _sp0 - this.dY * _t12_inv;
        d.dZ = this.rZ * _sp0 - this.dZ * _t12_inv;
        d.dW = this.dW * _t12_inv - this.rW * _sp0;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Compute the length of this dual quaternion's real (rotation) part.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the real part must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the length of this dual quaternion's real (rotation) part
     */
    public float length() {
        return (float) Math.sqrt(this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW));
    }


    /**
     * Compute the squared length of this dual quaternion's real (rotation) part.
     *
     * @return the squared length of this dual quaternion's real (rotation) part
     */
    public float lengthSquared() {
        return this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW);
    }

    /** Private store group 0 of {@code log}: computes and stores it; reached only through it. */
    private void log_s416ccfb5_c0(FloatDualQuatImpl _dst, float _t20, float _t8, float _t23, float _t24, float _t9, float _t25, float _t10, float _t26) {
        _dst.rX = _t20 < 1.0E-12f ? _t8 : _t23 * _t24;
        _dst.rY = _t20 < 1.0E-12f ? _t9 : _t25 * _t24;
        _dst.rZ = _t20 < 1.0E-12f ? _t10 : _t26 * _t24;
        _dst.rW = 0.0f;
    }

    /** Private store group 1 of {@code log}: computes and stores it; reached only through it. */
    private void log_s416ccfb5_c1(FloatDualQuatImpl _dst, float _t20, float _t12, float _t28, float _t23, float _sp0, float _t27, float _t14, float _t25, float _t15, float _t26) {
        _dst.dX = _t20 < 1.0E-12f ? _t12 : (_t28 * _t23 + _t12) * _sp0 - _t23 * _t27;
        _dst.dY = _t20 < 1.0E-12f ? _t14 : (_t28 * _t25 + _t14) * _sp0 - _t25 * _t27;
        _dst.dZ = _t20 < 1.0E-12f ? _t15 : (_t28 * _t26 + _t15) * _sp0 - _t26 * _t27;
        _dst.dW = 0.0f;
    }

    /** Private tail of {@code log}; reached only through it. */
    private void log_s416ccfb5_tail(FloatDualQuatImpl _dst, float _t20, float _t8, float _t11, float _t9, float _t10, float _r0, float _r7, float _t12, float _t14, float _t15) {
        float _t21 = (1.0f / (float) Math.sqrt(_t20));
        float _t23 = _t21 * _t8;
        float _t24 = (float) Math.atan2((float) Math.sqrt(_t20), _t11);
        float _sp0 = _t21 * _t24;
        float _t25 = _t21 * _t9;
        float _t26 = _t21 * _t10;
        float _t27 = _t21 * (_r0 < 0.0f ? -_r7 : _r7);
        float _t28 = _t27 * _t11;
        log_s416ccfb5_c0(_dst, _t20, _t8, _t23, _t24, _t9, _t25, _t10, _t26);
        log_s416ccfb5_c1(_dst, _t20, _t12, _t28, _t23, _sp0, _t27, _t14, _t25, _t15, _t26);
    }


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion; the result is pure (both scalar parts
     * zero), the input {@code exp} expects.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat log(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dY;
        float _r6 = this.dZ;
        float _r7 = this.dW;
        float _t8, _t9, _t10, _t11, _t12, _t14, _t15;
        if (_r0 < 0.0f) {
            _t8 = -_r1;
            _t9 = -_r2;
            _t10 = -_r3;
            _t11 = -_r0;
            _t12 = -_r4;
            _t14 = -_r5;
            _t15 = -_r6;
        } else {
            _t8 = _r1;
            _t9 = _r2;
            _t10 = _r3;
            _t11 = _r0;
            _t12 = _r4;
            _t14 = _r5;
            _t15 = _r6;
        }
        float _t20 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10;
        log_s416ccfb5_tail(d, _t20, _t8, _t11, _t9, _t10, _r0, _r7, _t12, _t14, _t15);
        return d;
    }

    /** Private store group 0 of {@code log}: computes and stores it; reached only through it. */
    private void log_s6608609c_c0(DoubleDualQuatImpl _dst, float _t20, float _t8, float _t23, float _t24, float _t9, float _t25, float _t10, float _t26) {
        _dst.rX = _t20 < 1.0E-12f ? _t8 : _t23 * _t24;
        _dst.rY = _t20 < 1.0E-12f ? _t9 : _t25 * _t24;
        _dst.rZ = _t20 < 1.0E-12f ? _t10 : _t26 * _t24;
        _dst.rW = 0.0f;
    }

    /** Private store group 1 of {@code log}: computes and stores it; reached only through it. */
    private void log_s6608609c_c1(DoubleDualQuatImpl _dst, float _t20, float _t12, float _t28, float _t23, float _sp0, float _t27, float _t14, float _t25, float _t15, float _t26) {
        _dst.dX = _t20 < 1.0E-12f ? _t12 : (_t28 * _t23 + _t12) * _sp0 - _t23 * _t27;
        _dst.dY = _t20 < 1.0E-12f ? _t14 : (_t28 * _t25 + _t14) * _sp0 - _t25 * _t27;
        _dst.dZ = _t20 < 1.0E-12f ? _t15 : (_t28 * _t26 + _t15) * _sp0 - _t26 * _t27;
        _dst.dW = 0.0f;
    }

    /** Private tail of {@code log}; reached only through it. */
    private void log_s6608609c_tail(DoubleDualQuatImpl _dst, float _t20, float _t8, float _t11, float _t9, float _t10, float _r0, float _r7, float _t12, float _t14, float _t15) {
        float _t21 = (1.0f / (float) Math.sqrt(_t20));
        float _t23 = _t21 * _t8;
        float _t24 = (float) Math.atan2((float) Math.sqrt(_t20), _t11);
        float _sp0 = _t21 * _t24;
        float _t25 = _t21 * _t9;
        float _t26 = _t21 * _t10;
        float _t27 = _t21 * (_r0 < 0.0f ? -_r7 : _r7);
        float _t28 = _t27 * _t11;
        log_s6608609c_c0(_dst, _t20, _t8, _t23, _t24, _t9, _t25, _t10, _t26);
        log_s6608609c_c1(_dst, _t20, _t12, _t28, _t23, _sp0, _t27, _t14, _t25, _t15, _t26);
    }


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion; the result is pure (both scalar parts
     * zero), the input {@code exp} expects.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat log(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dY;
        float _r6 = this.dZ;
        float _r7 = this.dW;
        float _t8, _t9, _t10, _t11, _t12, _t14, _t15;
        if (_r0 < 0.0f) {
            _t8 = -_r1;
            _t9 = -_r2;
            _t10 = -_r3;
            _t11 = -_r0;
            _t12 = -_r4;
            _t14 = -_r5;
            _t15 = -_r6;
        } else {
            _t8 = _r1;
            _t9 = _r2;
            _t10 = _r3;
            _t11 = _r0;
            _t12 = _r4;
            _t14 = _r5;
            _t15 = _r6;
        }
        float _t20 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10;
        log_s6608609c_tail(d, _t20, _t8, _t11, _t9, _t10, _r0, _r7, _t12, _t14, _t15);
        return d;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public FloatDualQuat makeFromMatrix(Float4x4R m) {
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
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t14));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t16));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t17));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t15));
        float _t62, _t63, _t64, _t65;
        if (_t13 > 0.0f) {
            _t62 = _sp0 * _t3;
            _t63 = _sp0 * _t7;
            _t64 = _sp0 * _t9;
            _t65 = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                _t62 = 0.5f * (float) Math.sqrt(_t15);
                _t63 = _sp3 * _t5;
                _t64 = _sp3 * _t6;
                _t65 = _sp3 * _t3;
            } else {
                if (m.m11() > m.m22()) {
                    _t62 = _sp1 * _t5;
                    _t63 = 0.5f * (float) Math.sqrt(_t16);
                    _t64 = _sp1 * _t8;
                    _t65 = _sp1 * _t7;
                } else {
                    _t62 = _sp2 * _t6;
                    _t63 = _sp2 * _t8;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = _sp2 * _t9;
                }
            }
        }
        this.rX = _t62;
        this.rY = _t63;
        this.rZ = _t64;
        this.rW = _t65;
        this.dX = 0.5f * (m.m03() * _t65 + m.m13() * _t64 - m.m23() * _t63);
        this.dY = 0.5f * (m.m13() * _t65 - m.m03() * _t64 + m.m23() * _t62);
        this.dZ = 0.5f * (m.m03() * _t63 - m.m13() * _t62 + m.m23() * _t65);
        this.dW = 0.5f * (-(m.m03() * _t62) - m.m13() * _t63 - m.m23() * _t64);
        return this;
    }


    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public FloatDualQuat makeFromMatrix(Float3x4R m) {
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
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t14));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t16));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t17));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t15));
        float _t62, _t63, _t64, _t65;
        if (_t13 > 0.0f) {
            _t62 = _sp0 * _t3;
            _t63 = _sp0 * _t7;
            _t64 = _sp0 * _t9;
            _t65 = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                _t62 = 0.5f * (float) Math.sqrt(_t15);
                _t63 = _sp3 * _t5;
                _t64 = _sp3 * _t6;
                _t65 = _sp3 * _t3;
            } else {
                if (m.m11() > m.m22()) {
                    _t62 = _sp1 * _t5;
                    _t63 = 0.5f * (float) Math.sqrt(_t16);
                    _t64 = _sp1 * _t8;
                    _t65 = _sp1 * _t7;
                } else {
                    _t62 = _sp2 * _t6;
                    _t63 = _sp2 * _t8;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = _sp2 * _t9;
                }
            }
        }
        this.rX = _t62;
        this.rY = _t63;
        this.rZ = _t64;
        this.rW = _t65;
        this.dX = 0.5f * (m.m03() * _t65 + m.m13() * _t64 - m.m23() * _t63);
        this.dY = 0.5f * (m.m13() * _t65 - m.m03() * _t64 + m.m23() * _t62);
        this.dZ = 0.5f * (m.m03() * _t63 - m.m13() * _t62 + m.m23() * _t65);
        this.dW = 0.5f * (-(m.m03() * _t62) - m.m13() * _t63 - m.m23() * _t64);
        return this;
    }


    /**
     * Set this dual quaternion to the rotation represented by the given matrix (which must be a
     * rotation: orthonormal, with determinant +1 - a scaled or sheared block gives a wrong
     * quaternion, not a longer one; {@code getNormalizedRotation} strips scale first), with zero
     * translation.
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public FloatDualQuat makeFromMatrix(Float3x3R m) {
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
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t14));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t16));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t17));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            this.rX = _sp0 * _t3;
            this.rY = _sp0 * _t7;
            this.rZ = _sp0 * _t9;
            this.rW = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                this.rX = 0.5f * (float) Math.sqrt(_t15);
                this.rY = _sp3 * _t5;
                this.rZ = _sp3 * _t6;
                this.rW = _sp3 * _t3;
            } else {
                if (m.m11() > m.m22()) {
                    this.rX = _sp1 * _t5;
                    this.rY = 0.5f * (float) Math.sqrt(_t16);
                    this.rZ = _sp1 * _t8;
                    this.rW = _sp1 * _t7;
                } else {
                    this.rX = _sp2 * _t6;
                    this.rY = _sp2 * _t8;
                    this.rZ = 0.5f * (float) Math.sqrt(_t17);
                    this.rW = _sp2 * _t9;
                }
            }
        }
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length (a zero real
     * part yields the zero dual quaternion) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the real part must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat normalize(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t6 = this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW);
        float _t7 = (1.0f / (float) Math.sqrt(_t6));
        if (_t6 != 0.0f) {
            d.rX = this.rX * _t7;
            d.rY = this.rY * _t7;
            d.rZ = this.rZ * _t7;
            d.rW = this.rW * _t7;
            d.dX = this.dX * _t7;
            d.dY = this.dY * _t7;
            d.dZ = this.dZ * _t7;
            d.dW = this.dW * _t7;
        } else {
            d.rX = 0.0f;
            d.rY = 0.0f;
            d.rZ = 0.0f;
            d.rW = 0.0f;
            d.dX = 0.0f;
            d.dY = 0.0f;
            d.dZ = 0.0f;
            d.dW = 0.0f;
        }
        return d;
    }


    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length (a zero real
     * part yields the zero dual quaternion) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the real part must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat normalize(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t6 = this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW);
        float _t7 = (1.0f / (float) Math.sqrt(_t6));
        if (_t6 != 0.0f) {
            d.rX = this.rX * _t7;
            d.rY = this.rY * _t7;
            d.rZ = this.rZ * _t7;
            d.rW = this.rW * _t7;
            d.dX = this.dX * _t7;
            d.dY = this.dY * _t7;
            d.dZ = this.dZ * _t7;
            d.dW = this.dW * _t7;
        } else {
            d.rX = 0.0f;
            d.rY = 0.0f;
            d.rZ = 0.0f;
            d.rW = 0.0f;
            d.dX = 0.0f;
            d.dY = 0.0f;
            d.dZ = 0.0f;
            d.dW = 0.0f;
        }
        return d;
    }

    /** Private store group 0 of {@code pow}: computes and stores it; reached only through it. */
    private void pow_s7aa26011_c0(FloatDualQuatImpl _dst, float _t20, float t, float _t8, float _t23, float _t30, float _t9, float _t25, float _t10, float _t26, float _t32) {
        _dst.rX = _t20 < 1.0E-12f ? t * _t8 : _t23 * _t30;
        _dst.rY = _t20 < 1.0E-12f ? t * _t9 : _t25 * _t30;
        _dst.rZ = _t20 < 1.0E-12f ? t * _t10 : _t26 * _t30;
        _dst.rW = _t20 < 1.0E-12f ? 1.0f : _t32;
    }

    /** Private store group 1 of {@code pow}: computes and stores it; reached only through it. */
    private void pow_s7aa26011_c1(FloatDualQuatImpl _dst, float _t20, float t, float _t12, float _t31, float _t23, float _sp0, float _t33, float _t14, float _t25, float _t15, float _t26, float _t13, float _t29, float _t30) {
        _dst.dX = _t20 < 1.0E-12f ? t * _t12 : (_t31 * _t23 + _t12) * _sp0 - _t33 * _t23;
        _dst.dY = _t20 < 1.0E-12f ? t * _t14 : (_t31 * _t25 + _t14) * _sp0 - _t33 * _t25;
        _dst.dZ = _t20 < 1.0E-12f ? t * _t15 : (_t31 * _t26 + _t15) * _sp0 - _t33 * _t26;
        _dst.dW = _t20 < 1.0E-12f ? t * t * _t13 : _t29 * _t30;
    }

    /** Private tail of {@code pow}; reached only through it. */
    private void pow_s7aa26011_tail(FloatDualQuatImpl _dst, float _t8, float _t9, float _t10, float _t13, float t, float _t11, float _t12, float _t14, float _t15) {
        float _t20 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10;
        float _t21 = (1.0f / (float) Math.sqrt(_t20));
        float _t23 = _t21 * _t8;
        float _t25 = _t21 * _t9;
        float _t26 = _t21 * _t10;
        float _t27 = _t21 * _t13;
        float _t28 = t * (float) Math.atan2((float) Math.sqrt(_t20), _t11);
        float _t29 = t * _t27;
        float _t30 = (float) Math.sin(_t28);
        float _sp0 = _t21 * _t30;
        float _t31 = _t27 * _t11;
        float _t32 = (float) Math.cosFromSin(_t30, _t28);
        float _t33 = _t29 * _t32;
        pow_s7aa26011_c0(_dst, _t20, t, _t8, _t23, _t30, _t9, _t25, _t10, _t26, _t32);
        pow_s7aa26011_c1(_dst, _t20, t, _t12, _t31, _t23, _sp0, _t33, _t14, _t25, _t15, _t26, _t13, _t29, _t30);
    }


    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}) and store the result in {@code dest}.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat pow(float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15;
        if (_r0 < 0.0f) {
            _t8 = -_r1;
            _t9 = -_r2;
            _t10 = -_r3;
            _t11 = -_r0;
            _t12 = -_r4;
            _t13 = -_r5;
            _t14 = -_r6;
            _t15 = -_r7;
        } else {
            _t8 = _r1;
            _t9 = _r2;
            _t10 = _r3;
            _t11 = _r0;
            _t12 = _r4;
            _t13 = _r5;
            _t14 = _r6;
            _t15 = _r7;
        }
        pow_s7aa26011_tail(d, _t8, _t9, _t10, _t13, t, _t11, _t12, _t14, _t15);
        return d;
    }

    /** Private store group 0 of {@code pow}: computes and stores it; reached only through it. */
    private void pow_s5384dbc0_c0(DoubleDualQuatImpl _dst, float _t20, float t, float _t8, float _t23, float _t30, float _t9, float _t25, float _t10, float _t26, float _t32) {
        _dst.rX = _t20 < 1.0E-12f ? t * _t8 : _t23 * _t30;
        _dst.rY = _t20 < 1.0E-12f ? t * _t9 : _t25 * _t30;
        _dst.rZ = _t20 < 1.0E-12f ? t * _t10 : _t26 * _t30;
        _dst.rW = _t20 < 1.0E-12f ? 1.0f : _t32;
    }

    /** Private store group 1 of {@code pow}: computes and stores it; reached only through it. */
    private void pow_s5384dbc0_c1(DoubleDualQuatImpl _dst, float _t20, float t, float _t12, float _t31, float _t23, float _sp0, float _t33, float _t14, float _t25, float _t15, float _t26, float _t13, float _t29, float _t30) {
        _dst.dX = _t20 < 1.0E-12f ? t * _t12 : (_t31 * _t23 + _t12) * _sp0 - _t33 * _t23;
        _dst.dY = _t20 < 1.0E-12f ? t * _t14 : (_t31 * _t25 + _t14) * _sp0 - _t33 * _t25;
        _dst.dZ = _t20 < 1.0E-12f ? t * _t15 : (_t31 * _t26 + _t15) * _sp0 - _t33 * _t26;
        _dst.dW = _t20 < 1.0E-12f ? t * t * _t13 : _t29 * _t30;
    }

    /** Private tail of {@code pow}; reached only through it. */
    private void pow_s5384dbc0_tail(DoubleDualQuatImpl _dst, float _t8, float _t9, float _t10, float _t13, float t, float _t11, float _t12, float _t14, float _t15) {
        float _t20 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10;
        float _t21 = (1.0f / (float) Math.sqrt(_t20));
        float _t23 = _t21 * _t8;
        float _t25 = _t21 * _t9;
        float _t26 = _t21 * _t10;
        float _t27 = _t21 * _t13;
        float _t28 = t * (float) Math.atan2((float) Math.sqrt(_t20), _t11);
        float _t29 = t * _t27;
        float _t30 = (float) Math.sin(_t28);
        float _sp0 = _t21 * _t30;
        float _t31 = _t27 * _t11;
        float _t32 = (float) Math.cosFromSin(_t30, _t28);
        float _t33 = _t29 * _t32;
        pow_s5384dbc0_c0(_dst, _t20, t, _t8, _t23, _t30, _t9, _t25, _t10, _t26, _t32);
        pow_s5384dbc0_c1(_dst, _t20, t, _t12, _t31, _t23, _sp0, _t33, _t14, _t25, _t15, _t26, _t13, _t29, _t30);
    }


    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat pow(float t, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rW;
        float _r1 = this.rX;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15;
        if (_r0 < 0.0f) {
            _t8 = -_r1;
            _t9 = -_r2;
            _t10 = -_r3;
            _t11 = -_r0;
            _t12 = -_r4;
            _t13 = -_r5;
            _t14 = -_r6;
            _t15 = -_r7;
        } else {
            _t8 = _r1;
            _t9 = _r2;
            _t10 = _r3;
            _t11 = _r0;
            _t12 = _r4;
            _t13 = _r5;
            _t14 = _r6;
            _t15 = _r7;
        }
        pow_s5384dbc0_tail(d, _t8, _t9, _t10, _t13, t, _t11, _t12, _t14, _t15);
        return d;
    }


    /**
     * Set the rotation of this dual quaternion to {@code rotation} and store the result in
     * {@code dest}.
     *
     * @param rotation the new rotation
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat setRotation(FloatQuatR rotation, @Mutated FloatDualQuat dest) {
        return setRotation(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Set the rotation of this dual quaternion to {@code rotation} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param rotation the new rotation
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setRotation(FloatQuatR rotation, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat setRotation(float rotationX, float rotationY, float rotationZ, float rotationW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t21 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _t22 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _t23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        d.rX = rotationX;
        d.rY = rotationY;
        d.rZ = rotationZ;
        d.rW = rotationW;
        d.dX = 0.5f * (rotationZ * _t21 + rotationW * _t22 - rotationY * _t23);
        d.dY = 0.5f * (rotationW * _t21 - rotationZ * _t22 + rotationX * _t23);
        d.dZ = 0.5f * (rotationY * _t22 - rotationX * _t21 + rotationW * _t23);
        d.dW = 0.5f * (-(rotationX * _t22) - rotationY * _t21 - rotationZ * _t23);
        return d;
    }


    /**
     * Set the rotation of this dual quaternion to ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat setRotation(float rotationX, float rotationY, float rotationZ, float rotationW, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t21 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _t22 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _t23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        d.rX = rotationX;
        d.rY = rotationY;
        d.rZ = rotationZ;
        d.rW = rotationW;
        d.dX = 0.5f * (rotationZ * _t21 + rotationW * _t22 - rotationY * _t23);
        d.dY = 0.5f * (rotationW * _t21 - rotationZ * _t22 + rotationX * _t23);
        d.dZ = 0.5f * (rotationY * _t22 - rotationX * _t21 + rotationW * _t23);
        d.dW = 0.5f * (-(rotationX * _t22) - rotationY * _t21 - rotationZ * _t23);
        return d;
    }


    /**
     * Set the translation of this dual quaternion to {@code translation} and store the result in
     * {@code dest}.
     *
     * @param translation the new translation
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat setTranslation(Float3R translation, @Mutated FloatDualQuat dest) {
        return setTranslation(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Set the translation of this dual quaternion to {@code translation} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param translation the new translation
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat setTranslation(Float3R translation, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat setTranslation(float translationX, float translationY, float translationZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _buf0 = this.rX;
        float _buf1 = this.rY;
        float _buf2 = this.rZ;
        float _buf3 = this.rW;
        d.dX = 0.5f * (this.rZ * translationY + this.rW * translationX - this.rY * translationZ);
        d.dY = 0.5f * (this.rW * translationY - this.rZ * translationX + this.rX * translationZ);
        d.dZ = 0.5f * (this.rY * translationX - this.rX * translationY + this.rW * translationZ);
        d.dW = 0.5f * (-(this.rX * translationX) - this.rY * translationY - this.rZ * translationZ);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Set the translation of this dual quaternion to ({@code translationX}, {@code translationY},
     * {@code translationZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat setTranslation(float translationX, float translationY, float translationZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _buf0 = this.rX;
        float _buf1 = this.rY;
        float _buf2 = this.rZ;
        float _buf3 = this.rW;
        d.dX = 0.5f * (this.rZ * translationY + this.rW * translationX - this.rY * translationZ);
        d.dY = 0.5f * (this.rW * translationY - this.rZ * translationX + this.rX * translationZ);
        d.dZ = 0.5f * (this.rY * translationX - this.rX * translationY + this.rW * translationZ);
        d.dW = 0.5f * (-(this.rX * translationX) - this.rY * translationY - this.rZ * translationZ);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }

    /** Private column 0 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s5af251ec_c0(Float4x4Impl _dst, float _t12, float _t10, float _t3, float _t2, float _t5, float _t4) {
        _dst.m00 = _t12 - _t10;
        _dst.m10 = 2.0f * (_t3 + _t2);
        _dst.m20 = -2.0f * _t5 + (_t4 + _t4);
        _dst.m30 = 0.0f;
    }

    /** Private column 1 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s5af251ec_c1(Float4x4Impl _dst, float _t2, float _t3, float _t12, float _t11, float _t7, float _t8) {
        _dst.m01 = -2.0f * _t2 + (_t3 + _t3);
        _dst.m11 = _t12 - _t11;
        _dst.m21 = 2.0f * (_t7 + _t8);
        _dst.m31 = 0.0f;
    }

    /** Private column 2 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s5af251ec_c2(Float4x4Impl _dst, float _t4, float _t5, float _t7, float _t8, float _t10, float _t11) {
        _dst.m02 = 2.0f * (_t4 + _t5);
        _dst.m12 = -2.0f * _t7 + (_t8 + _t8);
        _dst.m22 = 1.0f - _t10 - _t11;
        _dst.m32 = 0.0f;
    }

    /** Private column 3 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s5af251ec_c3(Float4x4Impl _dst, float _r3, float _r4, float _r0, float _r5, float _r1, float _r6, float _r2, float _r7) {
        _dst.m03 = 2.0f * (_r3 * _r4 - _r0 * _r5 + (_r1 * _r6 - _r2 * _r7));
        _dst.m13 = 2.0f * (_r0 * _r6 - _r2 * _r4 + (_r1 * _r5 - _r3 * _r7));
        _dst.m23 = 2.0f * (_r2 * _r5 - _r3 * _r6 + (_r1 * _r4 - _r0 * _r7));
        _dst.m33 = 1.0f;
    }


    /**
     * Compute the matrix representation of this dual quaternion (which must be a unit dual
     * quaternion) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x4 toMatrix(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        float _r0 = this.rZ;
        float _r1 = this.rW;
        float _r2 = this.rX;
        float _r3 = this.rY;
        float _r4 = this.dZ;
        float _r5 = this.dY;
        float _r6 = this.dX;
        float _r7 = this.dW;
        float _t2 = _r0 * _r1;
        float _t3 = _r2 * _r3;
        float _t4 = _r2 * _r0;
        float _t5 = _r3 * _r1;
        float _t7 = _r2 * _r1;
        float _t8 = _r3 * _r0;
        float _t10 = (_r3 + _r3) * _r3;
        float _t11 = (_r2 + _r2) * _r2;
        float _t12 = 1.0f - (_r0 + _r0) * _r0;
        toMatrix_s5af251ec_c0(d, _t12, _t10, _t3, _t2, _t5, _t4);
        toMatrix_s5af251ec_c1(d, _t2, _t3, _t12, _t11, _t7, _t8);
        toMatrix_s5af251ec_c2(d, _t4, _t5, _t7, _t8, _t10, _t11);
        toMatrix_s5af251ec_c3(d, _r3, _r4, _r0, _r5, _r1, _r6, _r2, _r7);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }

    /** Private column 0 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s20bb8ca5_c0(Double4x4Impl _dst, float _t12, float _t10, float _t3, float _t2, float _t5, float _t4) {
        _dst.m00 = _t12 - _t10;
        _dst.m10 = 2.0f * (_t3 + _t2);
        _dst.m20 = -2.0f * _t5 + (_t4 + _t4);
        _dst.m30 = 0.0f;
    }

    /** Private column 1 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s20bb8ca5_c1(Double4x4Impl _dst, float _t2, float _t3, float _t12, float _t11, float _t7, float _t8) {
        _dst.m01 = -2.0f * _t2 + (_t3 + _t3);
        _dst.m11 = _t12 - _t11;
        _dst.m21 = 2.0f * (_t7 + _t8);
        _dst.m31 = 0.0f;
    }

    /** Private column 2 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s20bb8ca5_c2(Double4x4Impl _dst, float _t4, float _t5, float _t7, float _t8, float _t10, float _t11) {
        _dst.m02 = 2.0f * (_t4 + _t5);
        _dst.m12 = -2.0f * _t7 + (_t8 + _t8);
        _dst.m22 = 1.0f - _t10 - _t11;
        _dst.m32 = 0.0f;
    }

    /** Private column 3 of {@code toMatrix}: computes and stores it; reached only through it. */
    private void toMatrix_s20bb8ca5_c3(Double4x4Impl _dst, float _r3, float _r4, float _r0, float _r5, float _r1, float _r6, float _r2, float _r7) {
        _dst.m03 = 2.0f * (_r3 * _r4 - _r0 * _r5 + (_r1 * _r6 - _r2 * _r7));
        _dst.m13 = 2.0f * (_r0 * _r6 - _r2 * _r4 + (_r1 * _r5 - _r3 * _r7));
        _dst.m23 = 2.0f * (_r2 * _r5 - _r3 * _r6 + (_r1 * _r4 - _r0 * _r7));
        _dst.m33 = 1.0f;
    }


    /**
     * Compute the matrix representation of this dual quaternion (which must be a unit dual
     * quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        float _r0 = this.rZ;
        float _r1 = this.rW;
        float _r2 = this.rX;
        float _r3 = this.rY;
        float _r4 = this.dZ;
        float _r5 = this.dY;
        float _r6 = this.dX;
        float _r7 = this.dW;
        float _t2 = _r0 * _r1;
        float _t3 = _r2 * _r3;
        float _t4 = _r2 * _r0;
        float _t5 = _r3 * _r1;
        float _t7 = _r2 * _r1;
        float _t8 = _r3 * _r0;
        float _t10 = (_r3 + _r3) * _r3;
        float _t11 = (_r2 + _r2) * _r2;
        float _t12 = 1.0f - (_r0 + _r0) * _r0;
        toMatrix_s20bb8ca5_c0(d, _t12, _t10, _t3, _t2, _t5, _t4);
        toMatrix_s20bb8ca5_c1(d, _t2, _t3, _t12, _t11, _t7, _t8);
        toMatrix_s20bb8ca5_c2(d, _t4, _t5, _t7, _t8, _t10, _t11);
        toMatrix_s20bb8ca5_c3(d, _r3, _r4, _r0, _r5, _r1, _r6, _r2, _r7);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Compute the 3x3 matrix representation of the rotation part of this dual quaternion (which
     * must be a unit dual quaternion; the encoded translation is dropped) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 toMatrix3x3(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = (this.rY + this.rY) * this.rY;
        float _t11 = (this.rX + this.rX) * this.rX;
        float _t12 = 1.0f - (this.rZ + this.rZ) * this.rZ;
        d.m00 = _t12 - _t10;
        d.m10 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + (_t4 + _t4);
        d.m01 = -2.0f * _t2 + (_t3 + _t3);
        d.m11 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = -2.0f * _t7 + (_t8 + _t8);
        d.m22 = 1.0f - _t10 - _t11;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x3 matrix representation of the rotation part of this dual quaternion (which
     * must be a unit dual quaternion; the encoded translation is dropped) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = (this.rY + this.rY) * this.rY;
        float _t11 = (this.rX + this.rX) * this.rX;
        float _t12 = 1.0f - (this.rZ + this.rZ) * this.rZ;
        d.m00 = _t12 - _t10;
        d.m10 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + (_t4 + _t4);
        d.m01 = -2.0f * _t2 + (_t3 + _t3);
        d.m11 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = -2.0f * _t7 + (_t8 + _t8);
        d.m22 = 1.0f - _t10 - _t11;
        d.properties = 0;
        return d;
    }

    /** Private column 0 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s7311250d_c0(Float3x4Impl _dst, float _t12, float _t10, float _t3, float _t2, float _t5, float _t4) {
        _dst.m00 = _t12 - _t10;
        _dst.m10 = 2.0f * (_t3 + _t2);
        _dst.m20 = -2.0f * _t5 + (_t4 + _t4);
    }

    /** Private column 1 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s7311250d_c1(Float3x4Impl _dst, float _t2, float _t3, float _t12, float _t11, float _t7, float _t8) {
        _dst.m01 = -2.0f * _t2 + (_t3 + _t3);
        _dst.m11 = _t12 - _t11;
        _dst.m21 = 2.0f * (_t7 + _t8);
    }

    /** Private column 2 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s7311250d_c2(Float3x4Impl _dst, float _t4, float _t5, float _t7, float _t8, float _t10, float _t11) {
        _dst.m02 = 2.0f * (_t4 + _t5);
        _dst.m12 = -2.0f * _t7 + (_t8 + _t8);
        _dst.m22 = 1.0f - _t10 - _t11;
    }

    /** Private column 3 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s7311250d_c3(Float3x4Impl _dst, float _r3, float _r4, float _r0, float _r5, float _r1, float _r6, float _r2, float _r7) {
        _dst.m03 = 2.0f * (_r3 * _r4 - _r0 * _r5 + (_r1 * _r6 - _r2 * _r7));
        _dst.m13 = 2.0f * (_r0 * _r6 - _r2 * _r4 + (_r1 * _r5 - _r3 * _r7));
        _dst.m23 = 2.0f * (_r2 * _r5 - _r3 * _r6 + (_r1 * _r4 - _r0 * _r7));
    }


    /**
     * Compute the 3x4 matrix representation of this dual quaternion (which must be a unit dual
     * quaternion; the omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3x4 toMatrix3x4(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        float _r0 = this.rZ;
        float _r1 = this.rW;
        float _r2 = this.rX;
        float _r3 = this.rY;
        float _r4 = this.dZ;
        float _r5 = this.dY;
        float _r6 = this.dX;
        float _r7 = this.dW;
        float _t2 = _r0 * _r1;
        float _t3 = _r2 * _r3;
        float _t4 = _r2 * _r0;
        float _t5 = _r3 * _r1;
        float _t7 = _r2 * _r1;
        float _t8 = _r3 * _r0;
        float _t10 = (_r3 + _r3) * _r3;
        float _t11 = (_r2 + _r2) * _r2;
        float _t12 = 1.0f - (_r0 + _r0) * _r0;
        toMatrix3x4_s7311250d_c0(d, _t12, _t10, _t3, _t2, _t5, _t4);
        toMatrix3x4_s7311250d_c1(d, _t2, _t3, _t12, _t11, _t7, _t8);
        toMatrix3x4_s7311250d_c2(d, _t4, _t5, _t7, _t8, _t10, _t11);
        toMatrix3x4_s7311250d_c3(d, _r3, _r4, _r0, _r5, _r1, _r6, _r2, _r7);
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }

    /** Private column 0 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s38da5fc6_c0(Double3x4Impl _dst, float _t12, float _t10, float _t3, float _t2, float _t5, float _t4) {
        _dst.m00 = _t12 - _t10;
        _dst.m10 = 2.0f * (_t3 + _t2);
        _dst.m20 = -2.0f * _t5 + (_t4 + _t4);
    }

    /** Private column 1 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s38da5fc6_c1(Double3x4Impl _dst, float _t2, float _t3, float _t12, float _t11, float _t7, float _t8) {
        _dst.m01 = -2.0f * _t2 + (_t3 + _t3);
        _dst.m11 = _t12 - _t11;
        _dst.m21 = 2.0f * (_t7 + _t8);
    }

    /** Private column 2 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s38da5fc6_c2(Double3x4Impl _dst, float _t4, float _t5, float _t7, float _t8, float _t10, float _t11) {
        _dst.m02 = 2.0f * (_t4 + _t5);
        _dst.m12 = -2.0f * _t7 + (_t8 + _t8);
        _dst.m22 = 1.0f - _t10 - _t11;
    }

    /** Private column 3 of {@code toMatrix3x4}: computes and stores it; reached only through it. */
    private void toMatrix3x4_s38da5fc6_c3(Double3x4Impl _dst, float _r3, float _r4, float _r0, float _r5, float _r1, float _r6, float _r2, float _r7) {
        _dst.m03 = 2.0f * (_r3 * _r4 - _r0 * _r5 + (_r1 * _r6 - _r2 * _r7));
        _dst.m13 = 2.0f * (_r0 * _r6 - _r2 * _r4 + (_r1 * _r5 - _r3 * _r7));
        _dst.m23 = 2.0f * (_r2 * _r5 - _r3 * _r6 + (_r1 * _r4 - _r0 * _r7));
    }


    /**
     * Compute the 3x4 matrix representation of this dual quaternion (which must be a unit dual
     * quaternion; the omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        float _r0 = this.rZ;
        float _r1 = this.rW;
        float _r2 = this.rX;
        float _r3 = this.rY;
        float _r4 = this.dZ;
        float _r5 = this.dY;
        float _r6 = this.dX;
        float _r7 = this.dW;
        float _t2 = _r0 * _r1;
        float _t3 = _r2 * _r3;
        float _t4 = _r2 * _r0;
        float _t5 = _r3 * _r1;
        float _t7 = _r2 * _r1;
        float _t8 = _r3 * _r0;
        float _t10 = (_r3 + _r3) * _r3;
        float _t11 = (_r2 + _r2) * _r2;
        float _t12 = 1.0f - (_r0 + _r0) * _r0;
        toMatrix3x4_s38da5fc6_c0(d, _t12, _t10, _t3, _t2, _t5, _t4);
        toMatrix3x4_s38da5fc6_c1(d, _t2, _t3, _t12, _t11, _t7, _t8);
        toMatrix3x4_s38da5fc6_c2(d, _t4, _t5, _t7, _t8, _t10, _t11);
        toMatrix3x4_s38da5fc6_c3(d, _r3, _r4, _r0, _r5, _r1, _r6, _r2, _r7);
        d.properties = Joml.BIT_ORTHOGONAL;
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
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dir the direction to look along, i.e. the direction the local {@code +z} axis is
     *        mapped to
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat lookAlong(Float3R dir, Float3R up, @Mutated FloatDualQuat dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this dual
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dir the direction to look along, i.e. the direction the local {@code +z} axis is
     *        mapped to
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat lookAlong(Float3R dir, Float3R up, @Mutated DoubleDualQuat dest) {
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
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
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
    public FloatDualQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t5 = (1.0f / (float) Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ));
        float _t6 = dirZ * _t5;
        float _t7 = dirY * _t5;
        float _t8 = dirX * _t5;
        float _t17 = upY * _t6 - upZ * _t7;
        float _t18 = upZ * _t8 - upX * _t6;
        float _t19 = upX * _t7 - upY * _t8;
        float _ct0 = _t17 * _t17 + _t18 * _t18 + _t19 * _t19;
        if (!(_ct0 > 0.0f)) return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, dest);
        float _t26 = (1.0f / (float) Math.sqrt(_ct0));
        float _t27 = _t17 * _t26;
        float _t28 = _t19 * _t26;
        float _t29 = _t18 * _t26;
        float _t30 = 1.0f - _t27;
        float _t31 = _t6 * _t27;
        float _t32 = _t8 * _t28;
        float _t35 = _t8 - _t28;
        float _t38 = _t8 + _t28;
        float _t43 = _t31 - _t32;
        float _t44 = _t8 * _t29 - _t7 * _t27;
        float _t45 = _t7 * _t28 - _t6 * _t29;
        float _t48 = Math.max(_t43, _t6);
        float _t49 = _t44 - _t7;
        float _t50 = _t44 + _t7;
        float _t53 = _t29 - _t45;
        float _t54 = _t45 + _t29;
        float _t56 = _t43 + _t27 + _t6;
        float _t57 = _t31 + (_t27 + (_t6 + 1.0f) - _t32);
        float _t58 = _t27 + (_t32 + (1.0f - _t6) - _t31);
        float _t59 = _t31 + (_t30 - _t6 - _t32);
        float _t60 = _t6 + (_t32 + _t30 - _t31);
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t58));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t59));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t60));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t57));
        float _t105, _t106, _t107, _t108;
        if (_t56 > 0.0f) {
            _t105 = 0.5f * (float) Math.sqrt(_t57);
            _t106 = _sp3 * _t49;
            _t107 = _sp3 * _t53;
            _t108 = _sp3 * _t35;
        } else {
            if (_t27 > _t48) {
                _t105 = _sp0 * _t49;
                _t106 = 0.5f * (float) Math.sqrt(_t58);
                _t107 = _sp0 * _t38;
                _t108 = _sp0 * _t54;
            } else {
                if (_t43 > _t6) {
                    _t105 = _sp1 * _t35;
                    _t106 = _sp1 * _t54;
                    _t107 = _sp1 * _t50;
                    _t108 = 0.5f * (float) Math.sqrt(_t59);
                } else {
                    _t105 = _sp2 * _t53;
                    _t106 = _sp2 * _t38;
                    _t107 = 0.5f * (float) Math.sqrt(_t60);
                    _t108 = _sp2 * _t50;
                }
            }
        }
        float _buf0 = this.rX * _t105 + this.rW * _t106 + (this.rY * _t107 - this.rZ * _t108);
        float _buf1 = this.rY * _t105 + this.rZ * _t106 + (this.rW * _t108 - this.rX * _t107);
        float _buf2 = this.rX * _t108 + this.rW * _t107 + (this.rZ * _t105 - this.rY * _t106);
        d.rW = this.rW * _t105 - this.rX * _t106 - (this.rY * _t108 + this.rZ * _t107);
        float _buf3 = this.dX * _t105 + this.dW * _t106 + (this.dY * _t107 - this.dZ * _t108);
        float _buf4 = this.dY * _t105 + this.dZ * _t106 + (this.dW * _t108 - this.dX * _t107);
        float _buf5 = this.dX * _t108 + this.dW * _t107 + (this.dZ * _t105 - this.dY * _t106);
        d.dW = this.dW * _t105 - this.dX * _t106 - (this.dY * _t108 + this.dZ * _t107);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t5 = (1.0f / (float) Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ));
        float _t6 = dirZ * _t5;
        float _t7 = dirY * _t5;
        float _t8 = dirX * _t5;
        float _t17 = upY * _t6 - upZ * _t7;
        float _t18 = upZ * _t8 - upX * _t6;
        float _t19 = upX * _t7 - upY * _t8;
        float _ct0 = _t17 * _t17 + _t18 * _t18 + _t19 * _t19;
        if (!(_ct0 > 0.0f)) return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, dest);
        float _t26 = (1.0f / (float) Math.sqrt(_ct0));
        float _t27 = _t17 * _t26;
        float _t28 = _t19 * _t26;
        float _t29 = _t18 * _t26;
        float _t30 = 1.0f - _t27;
        float _t31 = _t6 * _t27;
        float _t32 = _t8 * _t28;
        float _t35 = _t8 - _t28;
        float _t38 = _t8 + _t28;
        float _t43 = _t31 - _t32;
        float _t44 = _t8 * _t29 - _t7 * _t27;
        float _t45 = _t7 * _t28 - _t6 * _t29;
        float _t48 = Math.max(_t43, _t6);
        float _t49 = _t44 - _t7;
        float _t50 = _t44 + _t7;
        float _t53 = _t29 - _t45;
        float _t54 = _t45 + _t29;
        float _t56 = _t43 + _t27 + _t6;
        float _t57 = _t31 + (_t27 + (_t6 + 1.0f) - _t32);
        float _t58 = _t27 + (_t32 + (1.0f - _t6) - _t31);
        float _t59 = _t31 + (_t30 - _t6 - _t32);
        float _t60 = _t6 + (_t32 + _t30 - _t31);
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t58));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t59));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t60));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t57));
        float _t105, _t106, _t107, _t108;
        if (_t56 > 0.0f) {
            _t105 = 0.5f * (float) Math.sqrt(_t57);
            _t106 = _sp3 * _t49;
            _t107 = _sp3 * _t53;
            _t108 = _sp3 * _t35;
        } else {
            if (_t27 > _t48) {
                _t105 = _sp0 * _t49;
                _t106 = 0.5f * (float) Math.sqrt(_t58);
                _t107 = _sp0 * _t38;
                _t108 = _sp0 * _t54;
            } else {
                if (_t43 > _t6) {
                    _t105 = _sp1 * _t35;
                    _t106 = _sp1 * _t54;
                    _t107 = _sp1 * _t50;
                    _t108 = 0.5f * (float) Math.sqrt(_t59);
                } else {
                    _t105 = _sp2 * _t53;
                    _t106 = _sp2 * _t38;
                    _t107 = 0.5f * (float) Math.sqrt(_t60);
                    _t108 = _sp2 * _t50;
                }
            }
        }
        float _buf0 = this.rX * _t105 + this.rW * _t106 + (this.rY * _t107 - this.rZ * _t108);
        float _buf1 = this.rY * _t105 + this.rZ * _t106 + (this.rW * _t108 - this.rX * _t107);
        float _buf2 = this.rX * _t108 + this.rW * _t107 + (this.rZ * _t105 - this.rY * _t106);
        d.rW = this.rW * _t105 - this.rX * _t106 - (this.rY * _t108 + this.rZ * _t107);
        float _buf3 = this.dX * _t105 + this.dW * _t106 + (this.dY * _t107 - this.dZ * _t108);
        float _buf4 = this.dY * _t105 + this.dZ * _t106 + (this.dW * _t108 - this.dX * _t107);
        float _buf5 = this.dX * _t108 + this.dW * _t107 + (this.dZ * _t105 - this.dY * _t106);
        d.dW = this.dW * _t105 - this.dX * _t106 - (this.dY * _t108 + this.dZ * _t107);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private FloatDualQuat lookAlong_degenerate(Float3R dir, Float3R up, @Mutated FloatDualQuat dest) {
        return lookAlong_degenerate(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleDualQuat lookAlong_degenerate(Float3R dir, Float3R up, @Mutated DoubleDualQuat dest) {
        return lookAlong_degenerate(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private FloatDualQuat lookAlong_degenerate(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11, _t12, _t13, _t14;
        if (_t4 == 0.0f) {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 1.0f;
            _t14 = 0.0f;
        } else {
            _t9 = upZ;
            _t10 = upX;
            _t11 = upY;
            _t12 = dirX * _t5;
            _t13 = dirZ * _t5;
            _t14 = dirY * _t5;
        }
        float _t15 = Math.abs(_t12);
        float _t16 = Math.abs(_t13);
        float _t17 = -_t14;
        float _t19 = 1.0f + _t13;
        float _t20 = 1.0f - _t13;
        float _t27, _t28, _t32;
        if (_t15 > _t16) {
            _t27 = 0.0f;
            _t28 = _t17;
            _t32 = _t12;
        } else {
            _t27 = _t14;
            _t28 = 0.0f;
            _t32 = -_t13;
        }
        float _t29 = _t9 * _t12 - _t10 * _t13;
        float _t30 = _t11 * _t13 - _t9 * _t14;
        float _t31 = _t10 * _t14 - _t12 * _t11;
        float _t41 = _t29 * _t29 + _t30 * _t30 + _t31 * _t31;
        float _t47, _t48, _t49, _t50;
        if (_t41 == 0.0f) {
            _t47 = (1.0f / (float) Math.sqrt(_t28 * _t28 + _t32 * _t32 + _t27 * _t27));
            _t48 = _t47 * _t27;
            _t49 = _t47 * _t28;
            _t50 = _t47 * _t32;
        } else {
            _t47 = (1.0f / (float) Math.sqrt(_t41));
            _t48 = _t47 * _t31;
            _t49 = _t47 * _t30;
            _t50 = _t47 * _t29;
        }
        float _t51 = _t48 * _t12;
        float _t52 = _t12 - _t48;
        float _t54 = _t48 + _t12;
        float _t55 = _t49 * _t13;
        float _t57 = _t49 * _t14;
        float _t61 = _t50 * _t12;
        float _t67 = _t55 - _t51;
        float _t71 = _t48 * _t14 - _t50 * _t13;
        float _t72 = Math.max(_t67, _t13);
        float _t74 = _t61 + (_t14 - _t57);
        float _t75 = _t61 + (_t17 - _t57);
        float _t76 = _t55 + (_t49 + _t13 - _t51);
        float _t77 = _t55 + (_t49 + _t19 - _t51);
        float _t78 = _t49 + (_t51 + _t20 - _t55);
        float _t79 = _t55 + (_t20 - _t49 - _t51);
        float _t80 = _t51 + (_t19 - _t49) - _t55;
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t78));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t79));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t80));
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t77));
        float _t93 = _t50 - _t71;
        float _t94 = _t71 + _t50;
        float _t127, _t128, _t129, _t130;
        if (_t76 > 0.0f) {
            _t127 = _sp0 * _t93;
            _t128 = _sp0 * _t52;
            _t129 = 0.5f * (float) Math.sqrt(_t77);
            _t130 = _sp0 * _t75;
        } else {
            if (_t49 > _t72) {
                _t127 = _sp1 * _t54;
                _t128 = _sp1 * _t94;
                _t129 = _sp1 * _t75;
                _t130 = 0.5f * (float) Math.sqrt(_t78);
            } else {
                if (_t67 > _t13) {
                    _t127 = _sp2 * _t74;
                    _t128 = 0.5f * (float) Math.sqrt(_t79);
                    _t129 = _sp2 * _t52;
                    _t130 = _sp2 * _t94;
                } else {
                    _t127 = 0.5f * (float) Math.sqrt(_t80);
                    _t128 = _sp3 * _t74;
                    _t129 = _sp3 * _t93;
                    _t130 = _sp3 * _t54;
                }
            }
        }
        float _buf0 = this.rX * _t129 + this.rW * _t130 + (this.rY * _t127 - this.rZ * _t128);
        float _buf1 = this.rY * _t129 + this.rZ * _t130 + (this.rW * _t128 - this.rX * _t127);
        float _buf2 = this.rX * _t128 + this.rW * _t127 + (this.rZ * _t129 - this.rY * _t130);
        d.rW = this.rW * _t129 - this.rX * _t130 - (this.rY * _t128 + this.rZ * _t127);
        float _buf3 = this.dX * _t129 + this.dW * _t130 + (this.dY * _t127 - this.dZ * _t128);
        float _buf4 = this.dY * _t129 + this.dZ * _t130 + (this.dW * _t128 - this.dX * _t127);
        float _buf5 = this.dX * _t128 + this.dW * _t127 + (this.dZ * _t129 - this.dY * _t130);
        d.dW = this.dW * _t129 - this.dX * _t130 - (this.dY * _t128 + this.dZ * _t127);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    @Mutated private FloatDualQuat lookAlong_degenerate(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this);
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleDualQuat lookAlong_degenerate(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11, _t12, _t13, _t14;
        if (_t4 == 0.0f) {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 1.0f;
            _t14 = 0.0f;
        } else {
            _t9 = upZ;
            _t10 = upX;
            _t11 = upY;
            _t12 = dirX * _t5;
            _t13 = dirZ * _t5;
            _t14 = dirY * _t5;
        }
        float _t15 = Math.abs(_t12);
        float _t16 = Math.abs(_t13);
        float _t17 = -_t14;
        float _t19 = 1.0f + _t13;
        float _t20 = 1.0f - _t13;
        float _t27, _t28, _t32;
        if (_t15 > _t16) {
            _t27 = 0.0f;
            _t28 = _t17;
            _t32 = _t12;
        } else {
            _t27 = _t14;
            _t28 = 0.0f;
            _t32 = -_t13;
        }
        float _t29 = _t9 * _t12 - _t10 * _t13;
        float _t30 = _t11 * _t13 - _t9 * _t14;
        float _t31 = _t10 * _t14 - _t12 * _t11;
        float _t41 = _t29 * _t29 + _t30 * _t30 + _t31 * _t31;
        float _t47, _t48, _t49, _t50;
        if (_t41 == 0.0f) {
            _t47 = (1.0f / (float) Math.sqrt(_t28 * _t28 + _t32 * _t32 + _t27 * _t27));
            _t48 = _t47 * _t27;
            _t49 = _t47 * _t28;
            _t50 = _t47 * _t32;
        } else {
            _t47 = (1.0f / (float) Math.sqrt(_t41));
            _t48 = _t47 * _t31;
            _t49 = _t47 * _t30;
            _t50 = _t47 * _t29;
        }
        float _t51 = _t48 * _t12;
        float _t52 = _t12 - _t48;
        float _t54 = _t48 + _t12;
        float _t55 = _t49 * _t13;
        float _t57 = _t49 * _t14;
        float _t61 = _t50 * _t12;
        float _t67 = _t55 - _t51;
        float _t71 = _t48 * _t14 - _t50 * _t13;
        float _t72 = Math.max(_t67, _t13);
        float _t74 = _t61 + (_t14 - _t57);
        float _t75 = _t61 + (_t17 - _t57);
        float _t76 = _t55 + (_t49 + _t13 - _t51);
        float _t77 = _t55 + (_t49 + _t19 - _t51);
        float _t78 = _t49 + (_t51 + _t20 - _t55);
        float _t79 = _t55 + (_t20 - _t49 - _t51);
        float _t80 = _t51 + (_t19 - _t49) - _t55;
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t78));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t79));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t80));
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t77));
        float _t93 = _t50 - _t71;
        float _t94 = _t71 + _t50;
        float _t127, _t128, _t129, _t130;
        if (_t76 > 0.0f) {
            _t127 = _sp0 * _t93;
            _t128 = _sp0 * _t52;
            _t129 = 0.5f * (float) Math.sqrt(_t77);
            _t130 = _sp0 * _t75;
        } else {
            if (_t49 > _t72) {
                _t127 = _sp1 * _t54;
                _t128 = _sp1 * _t94;
                _t129 = _sp1 * _t75;
                _t130 = 0.5f * (float) Math.sqrt(_t78);
            } else {
                if (_t67 > _t13) {
                    _t127 = _sp2 * _t74;
                    _t128 = 0.5f * (float) Math.sqrt(_t79);
                    _t129 = _sp2 * _t52;
                    _t130 = _sp2 * _t94;
                } else {
                    _t127 = 0.5f * (float) Math.sqrt(_t80);
                    _t128 = _sp3 * _t74;
                    _t129 = _sp3 * _t93;
                    _t130 = _sp3 * _t54;
                }
            }
        }
        float _buf0 = this.rX * _t129 + this.rW * _t130 + (this.rY * _t127 - this.rZ * _t128);
        float _buf1 = this.rY * _t129 + this.rZ * _t130 + (this.rW * _t128 - this.rX * _t127);
        float _buf2 = this.rX * _t128 + this.rW * _t127 + (this.rZ * _t129 - this.rY * _t130);
        d.rW = this.rW * _t129 - this.rX * _t130 - (this.rY * _t128 + this.rZ * _t127);
        float _buf3 = this.dX * _t129 + this.dW * _t130 + (this.dY * _t127 - this.dZ * _t128);
        float _buf4 = this.dY * _t129 + this.dZ * _t130 + (this.dW * _t128 - this.dX * _t127);
        float _buf5 = this.dX * _t128 + this.dW * _t127 + (this.dZ * _t129 - this.dY * _t130);
        d.dW = this.dW * _t129 - this.dX * _t130 - (this.dY * _t128 + this.dZ * _t127);
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
    public @Mutated FloatDualQuat makeRotationAxis(float angle, Float3R axis) {
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
    @Mutated public FloatDualQuat makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return makeRotationX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return makeRotationY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return makeRotationZ(axisZ * angle);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = (float) Math.cosFromSin(_t1, _t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along {@code dir}.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dir the direction to look along, i.e. the direction the local {@code +z} axis is
     *        mapped to
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated FloatDualQuat makeRotationLookAlong(Float3R dir, Float3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}).
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t5 = (1.0f / (float) Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ));
        float _t6 = dirZ * _t5;
        float _t7 = dirY * _t5;
        float _t8 = dirX * _t5;
        float _t17 = upY * _t6 - upZ * _t7;
        float _t18 = upZ * _t8 - upX * _t6;
        float _t19 = upX * _t7 - upY * _t8;
        float _ct0 = _t17 * _t17 + _t18 * _t18 + _t19 * _t19;
        if (!(_ct0 > 0.0f)) return makeRotationLookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ);
        float _t26 = (1.0f / (float) Math.sqrt(_ct0));
        float _t27 = _t17 * _t26;
        float _t28 = _t19 * _t26;
        float _t29 = _t18 * _t26;
        float _t30 = 1.0f - _t27;
        float _t31 = _t6 * _t27;
        float _t32 = _t8 * _t28;
        float _t37 = _t8 + _t28;
        float _t38 = _t8 - _t28;
        float _t43 = _t31 - _t32;
        float _t44 = _t8 * _t29 - _t7 * _t27;
        float _t45 = _t7 * _t28 - _t6 * _t29;
        float _t48 = _t44 - _t7;
        float _t49 = Math.max(_t43, _t6);
        float _t50 = _t44 + _t7;
        float _t53 = _t45 + _t29;
        float _t54 = _t29 - _t45;
        float _t56 = _t43 + _t27 + _t6;
        float _t57 = _t31 + (_t27 + (_t6 + 1.0f) - _t32);
        float _t58 = _t27 + (_t32 + (1.0f - _t6) - _t31);
        float _t59 = _t31 + (_t30 - _t6 - _t32);
        float _t60 = _t6 + (_t32 + _t30 - _t31);
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t57));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t59));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t60));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t58));
        if (_t56 > 0.0f) {
            this.rX = _sp0 * _t48;
            this.rY = _sp0 * _t38;
            this.rZ = _sp0 * _t54;
            this.rW = 0.5f * (float) Math.sqrt(_t57);
        } else {
            if (_t27 > _t49) {
                this.rX = 0.5f * (float) Math.sqrt(_t58);
                this.rY = _sp3 * _t53;
                this.rZ = _sp3 * _t37;
                this.rW = _sp3 * _t48;
            } else {
                if (_t43 > _t6) {
                    this.rX = _sp1 * _t53;
                    this.rY = 0.5f * (float) Math.sqrt(_t59);
                    this.rZ = _sp1 * _t50;
                    this.rW = _sp1 * _t38;
                } else {
                    this.rX = _sp2 * _t37;
                    this.rY = _sp2 * _t50;
                    this.rZ = 0.5f * (float) Math.sqrt(_t60);
                    this.rW = _sp2 * _t54;
                }
            }
        }
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    private @Mutated FloatDualQuat makeRotationLookAlong_degenerate(Float3R dir, Float3R up) {
        return makeRotationLookAlong_degenerate(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    @Mutated private FloatDualQuat makeRotationLookAlong_degenerate(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11, _t12, _t13, _t14;
        if (_t4 == 0.0f) {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 1.0f;
            _t14 = 0.0f;
        } else {
            _t9 = upZ;
            _t10 = upX;
            _t11 = upY;
            _t12 = dirX * _t5;
            _t13 = dirZ * _t5;
            _t14 = dirY * _t5;
        }
        float _t15 = Math.abs(_t12);
        float _t16 = Math.abs(_t13);
        float _t17 = -_t14;
        float _t19 = 1.0f + _t13;
        float _t20 = 1.0f - _t13;
        float _t27, _t28, _t32;
        if (_t15 > _t16) {
            _t27 = 0.0f;
            _t28 = _t17;
            _t32 = _t12;
        } else {
            _t27 = _t14;
            _t28 = 0.0f;
            _t32 = -_t13;
        }
        float _t29 = _t9 * _t12 - _t10 * _t13;
        float _t30 = _t11 * _t13 - _t9 * _t14;
        float _t31 = _t10 * _t14 - _t12 * _t11;
        float _t41 = _t29 * _t29 + _t30 * _t30 + _t31 * _t31;
        float _t47, _t48, _t49, _t50;
        if (_t41 == 0.0f) {
            _t47 = (1.0f / (float) Math.sqrt(_t28 * _t28 + _t32 * _t32 + _t27 * _t27));
            _t48 = _t47 * _t27;
            _t49 = _t47 * _t28;
            _t50 = _t47 * _t32;
        } else {
            _t47 = (1.0f / (float) Math.sqrt(_t41));
            _t48 = _t47 * _t31;
            _t49 = _t47 * _t30;
            _t50 = _t47 * _t29;
        }
        float _t51 = _t48 * _t12;
        float _t53 = _t48 + _t12;
        float _t54 = _t12 - _t48;
        float _t55 = _t49 * _t13;
        float _t57 = _t49 * _t14;
        float _t61 = _t50 * _t12;
        float _t67 = _t55 - _t51;
        float _t71 = _t48 * _t14 - _t50 * _t13;
        float _t72 = Math.max(_t67, _t13);
        float _t74 = _t61 + (_t14 - _t57);
        float _t75 = _t61 + (_t17 - _t57);
        float _t76 = _t55 + (_t49 + _t13 - _t51);
        float _t77 = _t55 + (_t49 + _t19 - _t51);
        float _t78 = _t49 + (_t51 + _t20 - _t55);
        float _t79 = _t55 + (_t20 - _t49 - _t51);
        float _t80 = _t51 + (_t19 - _t49) - _t55;
        float _sp0 = 0.5f * (1.0f / (float) Math.sqrt(_t77));
        float _sp1 = 0.5f * (1.0f / (float) Math.sqrt(_t79));
        float _sp2 = 0.5f * (1.0f / (float) Math.sqrt(_t80));
        float _sp3 = 0.5f * (1.0f / (float) Math.sqrt(_t78));
        float _t85 = _t71 + _t50;
        float _t86 = _t50 - _t71;
        if (_t76 > 0.0f) {
            this.rX = _sp0 * _t75;
            this.rY = _sp0 * _t54;
            this.rZ = _sp0 * _t86;
            this.rW = 0.5f * (float) Math.sqrt(_t77);
        } else {
            if (_t49 > _t72) {
                this.rX = 0.5f * (float) Math.sqrt(_t78);
                this.rY = _sp3 * _t85;
                this.rZ = _sp3 * _t53;
                this.rW = _sp3 * _t75;
            } else {
                if (_t67 > _t13) {
                    this.rX = _sp1 * _t85;
                    this.rY = 0.5f * (float) Math.sqrt(_t79);
                    this.rZ = _sp1 * _t74;
                    this.rW = _sp1 * _t54;
                } else {
                    this.rX = _sp2 * _t53;
                    this.rY = _sp2 * _t74;
                    this.rZ = 0.5f * (float) Math.sqrt(_t80);
                    this.rW = _sp2 * _t86;
                }
            }
        }
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationX(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.rX = _t1;
        this.rY = 0.0f;
        this.rZ = 0.0f;
        this.rW = (float) Math.cosFromSin(_t1, _t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so
     * a vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t4, _t1);
        float _t7 = (float) Math.cosFromSin(_t5, _t2);
        float _t8 = (float) Math.cosFromSin(_t3, _t0);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t6;
        float _t11 = _t4 * _t8;
        float _t12 = _t8 * _t6;
        this.rX = _t10 * _t7 + _t11 * _t5;
        this.rY = _t11 * _t7 - _t10 * _t5;
        this.rZ = _t9 * _t7 + _t12 * _t5;
        this.rW = _t12 * _t7 - _t9 * _t5;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so
     * a vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationXZY(float angleX, float angleZ, float angleY) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t4, _t1);
        float _t7 = (float) Math.cosFromSin(_t5, _t2);
        float _t8 = (float) Math.cosFromSin(_t3, _t0);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t6;
        float _t11 = _t4 * _t8;
        float _t12 = _t8 * _t6;
        this.rX = _t10 * _t7 - _t11 * _t5;
        this.rY = _t12 * _t5 - _t9 * _t7;
        this.rZ = _t10 * _t5 + _t11 * _t7;
        this.rW = _t9 * _t5 + _t12 * _t7;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationY(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.rX = 0.0f;
        this.rY = _t1;
        this.rZ = 0.0f;
        this.rW = (float) Math.cosFromSin(_t1, _t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so
     * a vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationYXZ(float angleY, float angleX, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t4, _t1);
        float _t7 = (float) Math.cosFromSin(_t5, _t2);
        float _t8 = (float) Math.cosFromSin(_t3, _t0);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t6;
        float _t11 = _t4 * _t8;
        float _t12 = _t8 * _t6;
        this.rX = _t10 * _t7 + _t11 * _t5;
        this.rY = _t11 * _t7 - _t10 * _t5;
        this.rZ = _t12 * _t5 - _t9 * _t7;
        this.rW = _t9 * _t5 + _t12 * _t7;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so
     * a vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationYZX(float angleY, float angleZ, float angleX) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t5, _t2);
        float _t7 = (float) Math.cosFromSin(_t3, _t0);
        float _t8 = (float) Math.cosFromSin(_t4, _t1);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t8;
        float _t11 = _t4 * _t7;
        float _t12 = _t7 * _t8;
        this.rX = _t9 * _t6 + _t12 * _t5;
        this.rY = _t10 * _t6 + _t11 * _t5;
        this.rZ = _t11 * _t6 - _t10 * _t5;
        this.rW = _t12 * _t6 - _t9 * _t5;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationZ(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.rX = 0.0f;
        this.rY = 0.0f;
        this.rZ = _t1;
        this.rW = (float) Math.cosFromSin(_t1, _t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so
     * a vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationZXY(float angleZ, float angleX, float angleY) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t4, _t1);
        float _t7 = (float) Math.cosFromSin(_t5, _t2);
        float _t8 = (float) Math.cosFromSin(_t3, _t0);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t6;
        float _t11 = _t4 * _t8;
        float _t12 = _t8 * _t6;
        this.rX = _t10 * _t7 - _t11 * _t5;
        this.rY = _t9 * _t7 + _t12 * _t5;
        this.rZ = _t10 * _t5 + _t11 * _t7;
        this.rW = _t12 * _t7 - _t9 * _t5;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so
     * a vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public FloatDualQuat makeRotationZYX(float angleZ, float angleY, float angleX) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t12 = _t6 * _t7;
        this.rX = _t12 * _t5 - _t9 * _t8;
        this.rY = _t10 * _t8 + _t11 * _t5;
        this.rZ = _t11 * _t8 - _t10 * _t5;
        this.rW = _t9 * _t5 + _t12 * _t8;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
     * @param rotation the rotation to apply (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotate(FloatQuatR rotation, @Mutated FloatDualQuat dest) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this dual quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param rotation the rotation to apply (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotate(FloatQuatR rotation, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat rotate(float rotationX, float rotationY, float rotationZ, float rotationW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _buf0 = rotationX * this.rW + rotationW * this.rX + (rotationZ * this.rY - rotationY * this.rZ);
        float _buf1 = rotationX * this.rZ + rotationW * this.rY + (rotationY * this.rW - rotationZ * this.rX);
        float _buf2 = rotationY * this.rX + rotationZ * this.rW + (rotationW * this.rZ - rotationX * this.rY);
        d.rW = rotationW * this.rW - rotationX * this.rX - (rotationY * this.rY + rotationZ * this.rZ);
        float _buf3 = rotationX * this.dW + rotationW * this.dX + (rotationZ * this.dY - rotationY * this.dZ);
        float _buf4 = rotationX * this.dZ + rotationW * this.dY + (rotationY * this.dW - rotationZ * this.dX);
        float _buf5 = rotationY * this.dX + rotationZ * this.dW + (rotationW * this.dZ - rotationX * this.dY);
        d.dW = rotationW * this.dW - rotationX * this.dX - (rotationY * this.dY + rotationZ * this.dZ);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat rotate(float rotationX, float rotationY, float rotationZ, float rotationW, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _buf0 = rotationX * this.rW + rotationW * this.rX + (rotationZ * this.rY - rotationY * this.rZ);
        float _buf1 = rotationX * this.rZ + rotationW * this.rY + (rotationY * this.rW - rotationZ * this.rX);
        float _buf2 = rotationY * this.rX + rotationZ * this.rW + (rotationW * this.rZ - rotationX * this.rY);
        d.rW = rotationW * this.rW - rotationX * this.rX - (rotationY * this.rY + rotationZ * this.rZ);
        float _buf3 = rotationX * this.dW + rotationW * this.dX + (rotationZ * this.dY - rotationY * this.dZ);
        float _buf4 = rotationX * this.dZ + rotationW * this.dY + (rotationY * this.dW - rotationZ * this.dX);
        float _buf5 = rotationY * this.dX + rotationZ * this.dW + (rotationW * this.dZ - rotationX * this.dY);
        d.dW = rotationW * this.dW - rotationX * this.dX - (rotationY * this.dY + rotationZ * this.dZ);
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
    public FloatDualQuat rotateAxis(float angle, Float3R axis, @Mutated FloatDualQuat dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this dual quaternion
     * and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateAxis(float angle, Float3R axis, @Mutated DoubleDualQuat dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }

    /** Private store group 0 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s61270cf0_c0(FloatDualQuatImpl _dst, float _r0, float _t5, float _r1, float _t2, float _r2, float _t3, float _r3, float _t4) {
        _dst.rX = _r0 * _t5 + _r1 * _t2 + (_r2 * _t3 - _r3 * _t4);
        _dst.rY = _r2 * _t5 + _r3 * _t2 + (_r1 * _t4 - _r0 * _t3);
        _dst.rZ = _r0 * _t4 + _r1 * _t3 + (_r3 * _t5 - _r2 * _t2);
        _dst.rW = _r1 * _t5 - _r0 * _t2 - (_r2 * _t4 + _r3 * _t3);
    }

    /** Private store group 1 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s61270cf0_c1(FloatDualQuatImpl _dst, float _r4, float _t5, float _r5, float _t2, float _r6, float _t3, float _r7, float _t4) {
        _dst.dX = _r4 * _t5 + _r5 * _t2 + (_r6 * _t3 - _r7 * _t4);
        _dst.dY = _r6 * _t5 + _r7 * _t2 + (_r5 * _t4 - _r4 * _t3);
        _dst.dZ = _r4 * _t4 + _r5 * _t3 + (_r7 * _t5 - _r6 * _t2);
        _dst.dW = _r5 * _t5 - _r4 * _t2 - (_r6 * _t4 + _r7 * _t3);
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
    public FloatDualQuat rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated FloatDualQuat dest) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle, dest);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle, dest);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle, dest);
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = axisX * _t1;
        float _t3 = axisZ * _t1;
        float _t4 = axisY * _t1;
        float _t5 = (float) Math.cosFromSin(_t1, _t0);
        rotateAxis_s61270cf0_c0(d, _r0, _t5, _r1, _t2, _r2, _t3, _r3, _t4);
        rotateAxis_s61270cf0_c1(d, _r4, _t5, _r5, _t2, _r6, _t3, _r7, _t4);
        return d;
    }

    /** Private store group 0 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s3d95cac1_c0(DoubleDualQuatImpl _dst, float _r0, float _t5, float _r1, float _t2, float _r2, float _t3, float _r3, float _t4) {
        _dst.rX = _r0 * _t5 + _r1 * _t2 + (_r2 * _t3 - _r3 * _t4);
        _dst.rY = _r2 * _t5 + _r3 * _t2 + (_r1 * _t4 - _r0 * _t3);
        _dst.rZ = _r0 * _t4 + _r1 * _t3 + (_r3 * _t5 - _r2 * _t2);
        _dst.rW = _r1 * _t5 - _r0 * _t2 - (_r2 * _t4 + _r3 * _t3);
    }

    /** Private store group 1 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s3d95cac1_c1(DoubleDualQuatImpl _dst, float _r4, float _t5, float _r5, float _t2, float _r6, float _t3, float _r7, float _t4) {
        _dst.dX = _r4 * _t5 + _r5 * _t2 + (_r6 * _t3 - _r7 * _t4);
        _dst.dY = _r6 * _t5 + _r7 * _t2 + (_r5 * _t4 - _r4 * _t3);
        _dst.dZ = _r4 * _t4 + _r5 * _t3 + (_r7 * _t5 - _r6 * _t2);
        _dst.dW = _r5 * _t5 - _r4 * _t2 - (_r6 * _t4 + _r7 * _t3);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated DoubleDualQuat dest) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle, dest);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle, dest);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle, dest);
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = axisX * _t1;
        float _t3 = axisZ * _t1;
        float _t4 = axisY * _t1;
        float _t5 = (float) Math.cosFromSin(_t1, _t0);
        rotateAxis_s3d95cac1_c0(d, _r0, _t5, _r1, _t2, _r2, _t3, _r3, _t4);
        rotateAxis_s3d95cac1_c1(d, _r4, _t5, _r5, _t2, _r6, _t3, _r7, _t4);
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
    public FloatDualQuat rotateX(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 + this.rW * _t1;
        float _buf1 = this.rY * _t2 + this.rZ * _t1;
        d.rZ = this.rZ * _t2 - this.rY * _t1;
        d.rW = this.rW * _t2 - this.rX * _t1;
        float _buf2 = this.dX * _t2 + this.dW * _t1;
        float _buf3 = this.dY * _t2 + this.dZ * _t1;
        d.dZ = this.dZ * _t2 - this.dY * _t1;
        d.dW = this.dW * _t2 - this.dX * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateX(float angle, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 + this.rW * _t1;
        float _buf1 = this.rY * _t2 + this.rZ * _t1;
        d.rZ = this.rZ * _t2 - this.rY * _t1;
        d.rW = this.rW * _t2 - this.rX * _t1;
        float _buf2 = this.dX * _t2 + this.dW * _t1;
        float _buf3 = this.dY * _t2 + this.dZ * _t1;
        d.dZ = this.dZ * _t2 - this.dY * _t1;
        d.dW = this.dW * _t2 - this.dX * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
    }

    /** Private store group 0 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s106d101b_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s106d101b_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateXYZ}; reached only through it. */
    private void rotateXYZ_s106d101b_tail(FloatDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 - _t10 * _t5;
        rotateXYZ_s106d101b_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateXYZ_s106d101b_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this dual quaternion and store the result in
     * {@code dest}.
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
    public FloatDualQuat rotateXYZ(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t10 * _t8 + _t11 * _t5;
        float _t23 = _t9 * _t8 + _t13 * _t5;
        rotateXYZ_s106d101b_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s77102cf6_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s77102cf6_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateXYZ}; reached only through it. */
    private void rotateXYZ_s77102cf6_tail(DoubleDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 - _t10 * _t5;
        rotateXYZ_s77102cf6_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateXYZ_s77102cf6_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateXYZ(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t10 * _t8 + _t11 * _t5;
        float _t23 = _t9 * _t8 + _t13 * _t5;
        rotateXYZ_s77102cf6_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s52accddb_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s52accddb_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateXZY}; reached only through it. */
    private void rotateXZY_s52accddb_tail(FloatDualQuatImpl _dst, float _t13, float _t5, float _t9, float _t8, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t13 * _t5 - _t9 * _t8;
        rotateXZY_s52accddb_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateXZY_s52accddb_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotateXZY(float angleX, float angleZ, float angleY, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t10 * _t8 - _t11 * _t5;
        float _t23 = _t10 * _t5 + _t11 * _t8;
        rotateXZY_s52accddb_tail(d, _t13, _t5, _t9, _t8, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s7cc82736_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s7cc82736_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateXZY}; reached only through it. */
    private void rotateXZY_s7cc82736_tail(DoubleDualQuatImpl _dst, float _t13, float _t5, float _t9, float _t8, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t13 * _t5 - _t9 * _t8;
        rotateXZY_s7cc82736_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateXZY_s7cc82736_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateXZY(float angleX, float angleZ, float angleY, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t10 * _t8 - _t11 * _t5;
        float _t23 = _t10 * _t5 + _t11 * _t8;
        rotateXZY_s7cc82736_tail(d, _t13, _t5, _t9, _t8, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
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
    public FloatDualQuat rotateY(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 - this.rZ * _t1;
        float _buf1 = this.rY * _t2 + this.rW * _t1;
        d.rZ = this.rX * _t1 + this.rZ * _t2;
        d.rW = this.rW * _t2 - this.rY * _t1;
        float _buf2 = this.dX * _t2 - this.dZ * _t1;
        float _buf3 = this.dY * _t2 + this.dW * _t1;
        d.dZ = this.dX * _t1 + this.dZ * _t2;
        d.dW = this.dW * _t2 - this.dY * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateY(float angle, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 - this.rZ * _t1;
        float _buf1 = this.rY * _t2 + this.rW * _t1;
        d.rZ = this.rX * _t1 + this.rZ * _t2;
        d.rW = this.rW * _t2 - this.rY * _t1;
        float _buf2 = this.dX * _t2 - this.dZ * _t1;
        float _buf3 = this.dY * _t2 + this.dW * _t1;
        d.dZ = this.dX * _t1 + this.dZ * _t2;
        d.dW = this.dW * _t2 - this.dY * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
    }

    /** Private store group 0 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s5a6dbddb_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s5a6dbddb_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateYXZ}; reached only through it. */
    private void rotateYXZ_s5a6dbddb_tail(FloatDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 - _t10 * _t5;
        rotateYXZ_s5a6dbddb_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateYXZ_s5a6dbddb_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotateYXZ(float angleY, float angleX, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t10 * _t8 + _t11 * _t5;
        float _t23 = _t13 * _t5 - _t9 * _t8;
        rotateYXZ_s5a6dbddb_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s6d253736_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s6d253736_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateYXZ}; reached only through it. */
    private void rotateYXZ_s6d253736_tail(DoubleDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 - _t10 * _t5;
        rotateYXZ_s6d253736_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateYXZ_s6d253736_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateYXZ(float angleY, float angleX, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t10 * _t8 + _t11 * _t5;
        float _t23 = _t13 * _t5 - _t9 * _t8;
        rotateYXZ_s6d253736_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s5eed395b_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s5eed395b_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateYZX}; reached only through it. */
    private void rotateYZX_s5eed395b_tail(FloatDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 + _t10 * _t5;
        rotateYZX_s5eed395b_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateYZX_s5eed395b_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotateYZX(float angleY, float angleZ, float angleX, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t4 * _t6;
        float _t11 = _t3 * _t7;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t9 * _t8 + _t13 * _t5;
        float _t23 = _t10 * _t8 - _t11 * _t5;
        rotateYZX_s5eed395b_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s78952bb6_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s78952bb6_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateYZX}; reached only through it. */
    private void rotateYZX_s78952bb6_tail(DoubleDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 + _t10 * _t5;
        rotateYZX_s78952bb6_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateYZX_s78952bb6_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateYZX(float angleY, float angleZ, float angleX, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t4 * _t6;
        float _t11 = _t3 * _t7;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t9 * _t8 + _t13 * _t5;
        float _t23 = _t10 * _t8 - _t11 * _t5;
        rotateYZX_s78952bb6_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
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
    public FloatDualQuat rotateZ(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 + this.rY * _t1;
        d.rY = this.rY * _t2 - this.rX * _t1;
        float _buf1 = this.rZ * _t2 + this.rW * _t1;
        d.rW = this.rW * _t2 - this.rZ * _t1;
        float _buf2 = this.dX * _t2 + this.dY * _t1;
        d.dY = this.dY * _t2 - this.dX * _t1;
        float _buf3 = this.dZ * _t2 + this.dW * _t1;
        d.dW = this.dW * _t2 - this.dZ * _t1;
        d.rX = _buf0;
        d.rZ = _buf1;
        d.dX = _buf2;
        d.dZ = _buf3;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this dual quaternion and store
     * the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZ(float angle, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        float _t2 = (float) Math.cosFromSin(_t1, _t0);
        float _buf0 = this.rX * _t2 + this.rY * _t1;
        d.rY = this.rY * _t2 - this.rX * _t1;
        float _buf1 = this.rZ * _t2 + this.rW * _t1;
        d.rW = this.rW * _t2 - this.rZ * _t1;
        float _buf2 = this.dX * _t2 + this.dY * _t1;
        d.dY = this.dY * _t2 - this.dX * _t1;
        float _buf3 = this.dZ * _t2 + this.dW * _t1;
        d.dW = this.dW * _t2 - this.dZ * _t1;
        d.rX = _buf0;
        d.rZ = _buf1;
        d.dX = _buf2;
        d.dZ = _buf3;
        return d;
    }

    /** Private store group 0 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s66ae295b_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s66ae295b_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateZXY}; reached only through it. */
    private void rotateZXY_s66ae295b_tail(FloatDualQuatImpl _dst, float _t9, float _t8, float _t13, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t9 * _t8 + _t13 * _t5;
        rotateZXY_s66ae295b_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateZXY_s66ae295b_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotateZXY(float angleZ, float angleX, float angleY, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t10 * _t8 - _t11 * _t5;
        float _t23 = _t10 * _t5 + _t11 * _t8;
        rotateZXY_s66ae295b_tail(d, _t9, _t8, _t13, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s68f23bb6_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s68f23bb6_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateZXY}; reached only through it. */
    private void rotateZXY_s68f23bb6_tail(DoubleDualQuatImpl _dst, float _t9, float _t8, float _t13, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t9 * _t8 + _t13 * _t5;
        rotateZXY_s68f23bb6_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateZXY_s68f23bb6_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZXY(float angleZ, float angleX, float angleY, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t3 * _t7;
        float _t11 = _t4 * _t6;
        float _t13 = _t6 * _t7;
        float _t21 = _t13 * _t8 - _t9 * _t5;
        float _t22 = _t10 * _t8 - _t11 * _t5;
        float _t23 = _t10 * _t5 + _t11 * _t8;
        rotateZXY_s68f23bb6_tail(d, _t9, _t8, _t13, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s28ede71b_c0(FloatDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s28ede71b_c1(FloatDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateZYX}; reached only through it. */
    private void rotateZYX_s28ede71b_tail(FloatDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 + _t10 * _t5;
        rotateZYX_s28ede71b_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateZYX_s28ede71b_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat rotateZYX(float angleZ, float angleY, float angleX, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t4 * _t6;
        float _t11 = _t3 * _t7;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t13 * _t5 - _t9 * _t8;
        float _t23 = _t10 * _t8 - _t11 * _t5;
        rotateZYX_s28ede71b_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
        return d;
    }

    /** Private store group 0 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s6eaa35f6_c0(DoubleDualQuatImpl _dst, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _t24) {
        _dst.rX = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.rY = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.rZ = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.rW = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }

    /** Private store group 1 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s6eaa35f6_c1(DoubleDualQuatImpl _dst, float _r4, float _t21, float _r5, float _t22, float _r6, float _t23, float _r7, float _t24) {
        _dst.dX = _r4 * _t21 + _r5 * _t22 + (_r6 * _t23 - _r7 * _t24);
        _dst.dY = _r6 * _t21 + _r7 * _t22 + (_r5 * _t24 - _r4 * _t23);
        _dst.dZ = _r4 * _t24 + _r5 * _t23 + (_r7 * _t21 - _r6 * _t22);
        _dst.dW = _r5 * _t21 - _r4 * _t22 - (_r6 * _t24 + _r7 * _t23);
    }

    /** Private tail of {@code rotateZYX}; reached only through it. */
    private void rotateZYX_s6eaa35f6_tail(DoubleDualQuatImpl _dst, float _t11, float _t8, float _t10, float _t5, float _r0, float _t21, float _r1, float _t22, float _r2, float _t23, float _r3, float _r4, float _r5, float _r6, float _r7) {
        float _t24 = _t11 * _t8 + _t10 * _t5;
        rotateZYX_s6eaa35f6_c0(_dst, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        rotateZYX_s6eaa35f6_c1(_dst, _r4, _t21, _r5, _t22, _r6, _t23, _r7, _t24);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat rotateZYX(float angleZ, float angleY, float angleX, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _r0 = this.rX;
        float _r1 = this.rW;
        float _r2 = this.rY;
        float _r3 = this.rZ;
        float _r4 = this.dX;
        float _r5 = this.dW;
        float _r6 = this.dY;
        float _r7 = this.dZ;
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cosFromSin(_t3, _t0);
        float _t7 = (float) Math.cosFromSin(_t4, _t1);
        float _t8 = (float) Math.cosFromSin(_t5, _t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t4 * _t6;
        float _t11 = _t3 * _t7;
        float _t13 = _t6 * _t7;
        float _t21 = _t9 * _t5 + _t13 * _t8;
        float _t22 = _t13 * _t5 - _t9 * _t8;
        float _t23 = _t10 * _t8 - _t11 * _t5;
        rotateZYX_s6eaa35f6_tail(d, _t11, _t8, _t10, _t5, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _r4, _r5, _r6, _r7);
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
     * @param translation the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat translate(Float3R translation, @Mutated FloatDualQuat dest) {
        return translate(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Apply a translation by {@code translation} to this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param translation the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat translate(Float3R translation, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat translate(float translationX, float translationY, float translationZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * translationZ;
        float _t1 = 0.5f * translationX;
        float _t2 = 0.5f * translationY;
        float _buf0 = this.rX;
        float _buf1 = this.rY;
        float _buf2 = this.rZ;
        float _buf3 = this.rW;
        d.dX = this.rY * _t0 + (this.rW * _t1 + this.dX - this.rZ * _t2);
        d.dY = this.rW * _t2 + (this.rZ * _t1 + this.dY - this.rX * _t0);
        d.dZ = this.rX * _t2 + (this.rW * _t0 + (this.dZ - this.rY * _t1));
        d.dW = this.dW - this.rZ * _t0 - this.rY * _t2 - this.rX * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this dual quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat translate(float translationX, float translationY, float translationZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t0 = 0.5f * translationZ;
        float _t1 = 0.5f * translationX;
        float _t2 = 0.5f * translationY;
        float _buf0 = this.rX;
        float _buf1 = this.rY;
        float _buf2 = this.rZ;
        float _buf3 = this.rW;
        d.dX = this.rY * _t0 + (this.rW * _t1 + this.dX - this.rZ * _t2);
        d.dY = this.rW * _t2 + (this.rZ * _t1 + this.dY - this.rX * _t0);
        d.dZ = this.rX * _t2 + (this.rW * _t0 + (this.dZ - this.rY * _t1));
        d.dW = this.dW - this.rZ * _t0 - this.rY * _t2 - this.rX * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        return d;
    }


    /**
     * Transform {@code p} by this dual quaternion and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transform(Float3R p, @Mutated Float3 dest) {
        return transform(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform {@code p} by this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Float3R p, @Mutated Double3 dest) {
        return transform(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by this dual quaternion and store the result
     * in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transform(float pX, float pY, float pZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * (pY * this.rX - pX * this.rY);
        float _t10 = 2.0f * (pZ * this.rY - pY * this.rZ);
        float _t11 = 2.0f * (pX * this.rZ - pZ * this.rX);
        float _buf0 = this.rY * _t9 + (this.rW * _t10 + (2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW)) + pX) - this.rZ * _t11);
        float _buf1 = this.rZ * _t10 + (this.rW * _t11 + (2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW)) + pY) - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + (2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW)) + pZ) - this.rY * _t10);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by this dual quaternion and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(float pX, float pY, float pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * (pY * this.rX - pX * this.rY);
        float _t10 = 2.0f * (pZ * this.rY - pY * this.rZ);
        float _t11 = 2.0f * (pX * this.rZ - pZ * this.rX);
        float _buf0 = this.rY * _t9 + (this.rW * _t10 + (2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW)) + pX) - this.rZ * _t11);
        float _buf1 = this.rZ * _t10 + (this.rW * _t11 + (2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW)) + pY) - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + (2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW)) + pZ) - this.rY * _t10);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformDirection(Float3R v, @Mutated Float3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Float3R v, @Mutated Double3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformDirection(float vX, float vY, float vZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * (this.rX * vY - this.rY * vX);
        float _t10 = 2.0f * (this.rY * vZ - this.rZ * vY);
        float _t11 = 2.0f * (this.rZ * vX - this.rX * vZ);
        float _buf0 = this.rY * _t9 + (this.rW * _t10 + vX - this.rZ * _t11);
        float _buf1 = this.rZ * _t10 + (this.rW * _t11 + vY - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + vZ - this.rY * _t10);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform the given direction by this dual quaternion, ignoring any translation and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(float vX, float vY, float vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * (this.rX * vY - this.rY * vX);
        float _t10 = 2.0f * (this.rY * vZ - this.rZ * vY);
        float _t11 = 2.0f * (this.rZ * vX - this.rX * vZ);
        float _buf0 = this.rY * _t9 + (this.rW * _t10 + vX - this.rZ * _t11);
        float _buf1 = this.rZ * _t10 + (this.rW * _t11 + vY - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + vZ - this.rY * _t10);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} (assumes a unit,
     * rigid dual quaternion) and store the result in {@code dest}.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformDirectionInverse(Float3R v, @Mutated Float3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} (assumes a unit,
     * rigid dual quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(Float3R v, @Mutated Double3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} (assumes a unit,
     * rigid dual quaternion) and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformDirectionInverse(float vX, float vY, float vZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * (this.rX * vZ - this.rZ * vX);
        float _t10 = 2.0f * (this.rZ * vY - this.rY * vZ);
        float _t11 = 2.0f * (this.rY * vX - this.rX * vY);
        float _buf0 = this.rZ * _t9 + (this.rW * _t10 + vX - this.rY * _t11);
        float _buf1 = this.rX * _t11 + (this.rW * _t9 + vY - this.rZ * _t10);
        d.z = this.rY * _t10 + (this.rW * _t11 + vZ - this.rX * _t9);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} (assumes a unit,
     * rigid dual quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(float vX, float vY, float vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * (this.rX * vZ - this.rZ * vX);
        float _t10 = 2.0f * (this.rZ * vY - this.rY * vZ);
        float _t11 = 2.0f * (this.rY * vX - this.rX * vY);
        float _buf0 = this.rZ * _t9 + (this.rW * _t10 + vX - this.rY * _t11);
        float _buf1 = this.rX * _t11 + (this.rW * _t9 + vY - this.rZ * _t10);
        d.z = this.rY * _t10 + (this.rW * _t11 + vZ - this.rX * _t9);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform {@code p} by the inverse of this dual quaternion (assumes a unit, rigid dual
     * quaternion) and store the result in {@code dest}.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformInverse(Float3R p, @Mutated Float3 dest) {
        return transformInverse(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform {@code p} by the inverse of this dual quaternion (assumes a unit, rigid dual
     * quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Float3R p, @Mutated Double3 dest) {
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
    public Float3 transformInverse(float pX, float pY, float pZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t24 = pZ - 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _t25 = pX - 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _t26 = pY - 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _t36 = 2.0f * (this.rX * _t24 - this.rZ * _t25);
        float _t37 = 2.0f * (this.rZ * _t26 - this.rY * _t24);
        float _t38 = 2.0f * (this.rY * _t25 - this.rX * _t26);
        float _buf0 = this.rZ * _t36 + (this.rW * _t37 + _t25 - this.rY * _t38);
        float _buf1 = this.rX * _t38 + (this.rW * _t36 + _t26 - this.rZ * _t37);
        d.z = this.rY * _t37 + (this.rW * _t38 + _t24 - this.rX * _t36);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this dual quaternion
     * (assumes a unit, rigid dual quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(float pX, float pY, float pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t24 = pZ - 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        float _t25 = pX - 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _t26 = pY - 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        float _t36 = 2.0f * (this.rX * _t24 - this.rZ * _t25);
        float _t37 = 2.0f * (this.rZ * _t26 - this.rY * _t24);
        float _t38 = 2.0f * (this.rY * _t25 - this.rX * _t26);
        float _buf0 = this.rZ * _t36 + (this.rW * _t37 + _t25 - this.rY * _t38);
        float _buf1 = this.rX * _t38 + (this.rW * _t36 + _t26 - this.rZ * _t37);
        d.z = this.rY * _t37 + (this.rW * _t38 + _t24 - this.rX * _t36);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformPosition(Float3R p, @Mutated Float3 dest) {
        return transform(p, dest);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Float3R p, @Mutated Double3 dest) {
        return transform(p, dest);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformPosition(float pX, float pY, float pZ, @Mutated Float3 dest) {
        return transform(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(float pX, float pY, float pZ, @Mutated Double3 dest) {
        return transform(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} (assumes a unit, rigid dual quaternion) and store the result
     * in {@code dest}.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformPositionInverse(Float3R p, @Mutated Float3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} (assumes a unit, rigid dual quaternion) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(Float3R p, @Mutated Double3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} (assumes a unit, rigid dual quaternion) and store the result
     * in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformPositionInverse(float pX, float pY, float pZ, @Mutated Float3 dest) {
        return transformInverse(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} (assumes a unit, rigid dual quaternion) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(float pX, float pY, float pZ, @Mutated Double3 dest) {
        return transformInverse(pX, pY, pZ, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param v the vector to transform
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformVector(Float3R v, @Mutated Float3 dest) {
        return transformDirection(v, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param v the vector to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(Float3R v, @Mutated Double3 dest) {
        return transformDirection(v, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformVector(float vX, float vY, float vZ, @Mutated Float3 dest) {
        return transformDirection(vX, vY, vZ, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     * <p>
     * This dual quaternion must be a unit dual quaternion.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(float vX, float vY, float vZ, @Mutated Double3 dest) {
        return transformDirection(vX, vY, vZ, dest);
    }

    public float rX() { return this.rX; }
    public float rY() { return this.rY; }
    public float rZ() { return this.rZ; }
    public float rW() { return this.rW; }
    public float dX() { return this.dX; }
    public float dY() { return this.dY; }
    public float dZ() { return this.dZ; }
    public float dW() { return this.dW; }

    @Override public String toString() {
        return "FloatDualQuat(" + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ", " + dX() + ", " + dY() + ", " + dZ() + ", " + dW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatDualQuatImpl)) return false;
        FloatDualQuatImpl o = (FloatDualQuatImpl) obj;
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

    @Override public boolean isFinite() {
        return Float.isFinite(rX)
            && Float.isFinite(rY)
            && Float.isFinite(rZ)
            && Float.isFinite(rW)
            && Float.isFinite(dX)
            && Float.isFinite(dY)
            && Float.isFinite(dZ)
            && Float.isFinite(dW);
    }

    @Override public boolean equalsEpsilon(FloatDualQuatR other, float epsilon) {
        return Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon
            && Math.abs(dX - other.dX()) <= epsilon
            && Math.abs(dY - other.dY()) <= epsilon
            && Math.abs(dZ - other.dZ()) <= epsilon
            && Math.abs(dW - other.dW()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
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
    public @Mutated FloatDualQuat load(float[] src, int offset) {
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
    @Mutated public FloatDualQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatDualQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatDualQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatDualQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatDualQuat load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
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
    public @Mutated FloatDualQuat load(double[] src, int offset) {
        this.rX = (float) src[offset + 0];
        this.rY = (float) src[offset + 1];
        this.rZ = (float) src[offset + 2];
        this.rW = (float) src[offset + 3];
        this.dX = (float) src[offset + 4];
        this.dY = (float) src[offset + 5];
        this.dZ = (float) src[offset + 6];
        this.dW = (float) src[offset + 7];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatDualQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatDualQuat loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatDualQuat storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatDualQuat loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatDualQuat loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
