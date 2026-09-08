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


    /**
     * Add {@code other} to this dual quaternion and store the result in {@code dest}.
     *
     * @param other the other dual quaternion
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
     * @param other the other dual quaternion
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
     * @param scalar the scalar value
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
     * @param scalar the scalar value
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
     * @param other the other dual quaternion
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
     * @param other the other dual quaternion
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
     * @param v the dual quaternion
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
     * @param r the rigid transform
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
     * @param t the transform
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
     * @param translation the vector
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
        float _t2 = (float) Math.cos(_t0);
        float _t3 = axisX * _t1;
        float _t4 = axisY * _t1;
        float _t5 = axisZ * _t1;
        this.rX = _t3;
        this.rY = _t4;
        this.rZ = _t5;
        this.rW = _t2;
        this.dX = 0.5f * (translationX * _t2 + translationY * _t5 - translationZ * _t4);
        this.dY = 0.5f * (translationY * _t2 - translationX * _t5 + translationZ * _t3);
        this.dZ = 0.5f * (translationX * _t4 - translationY * _t3 + translationZ * _t2);
        this.dW = 0.5f * (-(translationX * _t3) - translationY * _t4 - translationZ * _t5);
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
     * @param translation the vector
     * @param rotation the quaternion
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
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    public @Mutated FloatDualQuat set(FloatQuatR rotation) {
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
     * @param rotation the quaternion
     * @param translation the vector
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
     * Set this dual quaternion to the given values.
     *
     * @param translation the vector
     * @return this
     */
    public @Mutated FloatDualQuat set(Float3R translation) {
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
     *
     * @param other the other dual quaternion
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other dual quaternion
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
     *
     * @param other the other dual quaternion
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other dual quaternion
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
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat sclerp(FloatDualQuatR other, float t, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat sclerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t7 = otherRX * this.rX + otherRY * this.rY + (otherRZ * this.rZ + otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t8 = otherRZ * _t7;
        float _t9 = otherRY * _t7;
        float _t10 = otherRW * _t7;
        float _t11 = otherRX * _t7;
        float _t12 = otherDX * _t7;
        float _t13 = otherDW * _t7;
        float _t14 = otherDY * _t7;
        float _t15 = otherDZ * _t7;
        float _t46 = this.dW * _t11;
        float _t47 = this.dX * _t10;
        float _t54 = this.dW * _t8;
        float _t55 = this.dX * _t9;
        float _t62 = this.dY * _t10;
        float _t63 = this.dZ * _t11;
        float _t79 = this.dZ * _t9 - this.dY * _t8;
        float _t83 = this.dY * _t11 - this.dZ * _t10;
        float _t86 = this.dX * _t8 + this.dW * _t9;
        float _t91 = this.rZ * _t9 - this.rY * _t8 + (this.rW * _t11 - this.rX * _t10);
        float _t92 = this.rY * _t11 - this.rZ * _t10 + (this.rW * _t8 - this.rX * _t9);
        float _t93 = this.rX * _t11 + this.rW * _t10 + this.rY * _t9 + this.rZ * _t8;
        float _t96 = this.rZ * _t14 - this.rY * _t15 + (this.rW * _t12 - this.rX * _t13);
        float _t98 = this.rY * _t12 - this.rZ * _t13 + (this.rW * _t15 - this.rX * _t14);
        float _t100 = this.rX * _t8 + this.rW * _t9 + (-(this.rY * _t10) - this.rZ * _t11);
        float _t101 = this.rX * _t15 + this.rW * _t14 + (-(this.rY * _t13) - this.rZ * _t12);
        float _t105 = this.rX * _t12 + this.rW * _t13 + (this.rY * _t14 + this.rZ * _t15) + (this.dX * _t11 + this.dW * _t10 + (this.dY * _t9 + this.dZ * _t8));
        float _t110 = t * (_t96 + (_t79 + (_t46 - _t47)));
        float _t111 = t * (_t98 + (_t83 + (_t54 - _t55)));
        float _t115 = t * (_t101 + (_t86 + (-_t62 - _t63)));
        float _t121 = _t100 * _t100 + _t91 * _t91 + _t92 * _t92;
        float _t123 = (1.0f / (float) Math.sqrt(_t121));
        float _t125 = _t91 * _t123;
        float _t126 = _t92 * _t123;
        float _t127 = _t100 * _t123;
        float _t128 = t * (float) Math.atan2((float) Math.sqrt(_t121), _t93);
        float _t129 = (float) Math.cos(_t128);
        float _t130 = (float) Math.sin(_t128);
        float _t131 = _t105 * _t123;
        float _t132 = t * _t131;
        float _t133 = _t93 * _t131;
        float _t134, _t155, _t156, _t157, _t161;
        if (_t121 < 1.0e-12f) {
            _t134 = 1.0f;
            _t155 = 0.0f;
            _t156 = 0.0f;
            _t157 = 0.0f;
            _t161 = t * _t105;
        } else {
            _t134 = _t129;
            _t155 = _t125 * _t130;
            _t156 = _t126 * _t130;
            _t157 = _t127 * _t130;
            _t161 = _t132 * _t130;
        }
        float _t139 = _t132 * _t129;
        float _t171, _t172, _t173;
        if (_t121 < 1.0e-12f) {
            if (_t93 < 0.0f) {
                _t171 = -_t110;
                _t172 = -_t111;
                _t173 = -_t115;
            } else {
                _t171 = _t110;
                _t172 = _t111;
                _t173 = _t115;
            }
        } else {
            _t171 = (_t96 + (_t79 + (_t46 + (_t133 * _t125 - _t47)))) * _t123 * _t130 - _t125 * _t139;
            _t172 = (_t98 + (_t83 + (_t54 + (_t133 * _t126 - _t55)))) * _t123 * _t130 - _t126 * _t139;
            _t173 = (_t101 + (_t86 + (_t133 * _t127 - _t63 - _t62))) * _t123 * _t130 - _t127 * _t139;
        }
        float _buf0 = this.rX * _t134 + this.rW * _t155 + (this.rY * _t156 - this.rZ * _t157);
        float _buf1 = this.rY * _t134 + this.rZ * _t155 + (this.rW * _t157 - this.rX * _t156);
        float _buf2 = this.rX * _t157 + this.rW * _t156 + (this.rZ * _t134 - this.rY * _t155);
        float _buf3 = this.rW * _t134 - this.rX * _t155 - this.rY * _t157 - this.rZ * _t156;
        float _buf4 = this.rX * _t161 + this.rW * _t171 + (this.rY * _t172 - this.rZ * _t173) + (this.dX * _t134 + this.dW * _t155 + (this.dY * _t156 - this.dZ * _t157));
        float _buf5 = this.rY * _t161 + this.rZ * _t171 + (this.rW * _t173 - this.rX * _t172) + (this.dY * _t134 + this.dZ * _t155 + (this.dW * _t157 - this.dX * _t156));
        float _buf6 = this.rX * _t173 + this.rW * _t172 + (this.rZ * _t161 - this.rY * _t171) + (this.dX * _t157 + this.dW * _t156 + (this.dZ * _t134 - this.dY * _t155));
        d.dW = this.rW * _t161 - this.rX * _t171 + (-(this.rY * _t173) - this.rZ * _t172) + (this.dW * _t134 - this.dX * _t155 + (-(this.dY * _t157) - this.dZ * _t156));
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
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) using the interpolation factor {@code t}
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleDualQuat sclerp(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, float t, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t7 = otherRX * this.rX + otherRY * this.rY + (otherRZ * this.rZ + otherRW * this.rW) < 0.0f ? -1.0f : 1.0f;
        float _t8 = otherRZ * _t7;
        float _t9 = otherRY * _t7;
        float _t10 = otherRW * _t7;
        float _t11 = otherRX * _t7;
        float _t12 = otherDX * _t7;
        float _t13 = otherDW * _t7;
        float _t14 = otherDY * _t7;
        float _t15 = otherDZ * _t7;
        float _t46 = this.dW * _t11;
        float _t47 = this.dX * _t10;
        float _t54 = this.dW * _t8;
        float _t55 = this.dX * _t9;
        float _t62 = this.dY * _t10;
        float _t63 = this.dZ * _t11;
        float _t79 = this.dZ * _t9 - this.dY * _t8;
        float _t83 = this.dY * _t11 - this.dZ * _t10;
        float _t86 = this.dX * _t8 + this.dW * _t9;
        float _t91 = this.rZ * _t9 - this.rY * _t8 + (this.rW * _t11 - this.rX * _t10);
        float _t92 = this.rY * _t11 - this.rZ * _t10 + (this.rW * _t8 - this.rX * _t9);
        float _t93 = this.rX * _t11 + this.rW * _t10 + this.rY * _t9 + this.rZ * _t8;
        float _t96 = this.rZ * _t14 - this.rY * _t15 + (this.rW * _t12 - this.rX * _t13);
        float _t98 = this.rY * _t12 - this.rZ * _t13 + (this.rW * _t15 - this.rX * _t14);
        float _t100 = this.rX * _t8 + this.rW * _t9 + (-(this.rY * _t10) - this.rZ * _t11);
        float _t101 = this.rX * _t15 + this.rW * _t14 + (-(this.rY * _t13) - this.rZ * _t12);
        float _t105 = this.rX * _t12 + this.rW * _t13 + (this.rY * _t14 + this.rZ * _t15) + (this.dX * _t11 + this.dW * _t10 + (this.dY * _t9 + this.dZ * _t8));
        float _t110 = t * (_t96 + (_t79 + (_t46 - _t47)));
        float _t111 = t * (_t98 + (_t83 + (_t54 - _t55)));
        float _t115 = t * (_t101 + (_t86 + (-_t62 - _t63)));
        float _t121 = _t100 * _t100 + _t91 * _t91 + _t92 * _t92;
        float _t123 = (1.0f / (float) Math.sqrt(_t121));
        float _t125 = _t91 * _t123;
        float _t126 = _t92 * _t123;
        float _t127 = _t100 * _t123;
        float _t128 = t * (float) Math.atan2((float) Math.sqrt(_t121), _t93);
        float _t129 = (float) Math.cos(_t128);
        float _t130 = (float) Math.sin(_t128);
        float _t131 = _t105 * _t123;
        float _t132 = t * _t131;
        float _t133 = _t93 * _t131;
        float _t134, _t155, _t156, _t157, _t161;
        if (_t121 < 1.0e-12f) {
            _t134 = 1.0f;
            _t155 = 0.0f;
            _t156 = 0.0f;
            _t157 = 0.0f;
            _t161 = t * _t105;
        } else {
            _t134 = _t129;
            _t155 = _t125 * _t130;
            _t156 = _t126 * _t130;
            _t157 = _t127 * _t130;
            _t161 = _t132 * _t130;
        }
        float _t139 = _t132 * _t129;
        float _t171, _t172, _t173;
        if (_t121 < 1.0e-12f) {
            if (_t93 < 0.0f) {
                _t171 = -_t110;
                _t172 = -_t111;
                _t173 = -_t115;
            } else {
                _t171 = _t110;
                _t172 = _t111;
                _t173 = _t115;
            }
        } else {
            _t171 = (_t96 + (_t79 + (_t46 + (_t133 * _t125 - _t47)))) * _t123 * _t130 - _t125 * _t139;
            _t172 = (_t98 + (_t83 + (_t54 + (_t133 * _t126 - _t55)))) * _t123 * _t130 - _t126 * _t139;
            _t173 = (_t101 + (_t86 + (_t133 * _t127 - _t63 - _t62))) * _t123 * _t130 - _t127 * _t139;
        }
        float _buf0 = this.rX * _t134 + this.rW * _t155 + (this.rY * _t156 - this.rZ * _t157);
        float _buf1 = this.rY * _t134 + this.rZ * _t155 + (this.rW * _t157 - this.rX * _t156);
        float _buf2 = this.rX * _t157 + this.rW * _t156 + (this.rZ * _t134 - this.rY * _t155);
        float _buf3 = this.rW * _t134 - this.rX * _t155 - this.rY * _t157 - this.rZ * _t156;
        float _buf4 = this.rX * _t161 + this.rW * _t171 + (this.rY * _t172 - this.rZ * _t173) + (this.dX * _t134 + this.dW * _t155 + (this.dY * _t156 - this.dZ * _t157));
        float _buf5 = this.rY * _t161 + this.rZ * _t171 + (this.rW * _t173 - this.rX * _t172) + (this.dY * _t134 + this.dZ * _t155 + (this.dW * _t157 - this.dX * _t156));
        float _buf6 = this.rX * _t173 + this.rW * _t172 + (this.rZ * _t161 - this.rY * _t171) + (this.dX * _t157 + this.dW * _t156 + (this.dZ * _t134 - this.dY * _t155));
        d.dW = this.rW * _t161 - this.rX * _t171 + (-(this.rY * _t173) - this.rZ * _t172) + (this.dW * _t134 - this.dX * _t155 + (-(this.dY * _t157) - this.dZ * _t156));
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
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat mul(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat mul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRZ * this.rY - otherRY * this.rZ);
        float _buf1 = otherRX * this.rZ + otherRW * this.rY + (otherRY * this.rW - otherRZ * this.rX);
        float _buf2 = otherRY * this.rX + otherRZ * this.rW + (otherRW * this.rZ - otherRX * this.rY);
        float _buf3 = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW + otherRW * this.dX + (otherRZ * this.dY - otherRY * this.dZ) + (otherDX * this.rW + otherDW * this.rX + (otherDZ * this.rY - otherDY * this.rZ));
        float _buf5 = otherRX * this.dZ + otherRW * this.dY + (otherRY * this.dW - otherRZ * this.dX) + (otherDX * this.rZ + otherDW * this.rY + (otherDY * this.rW - otherDZ * this.rX));
        float _buf6 = otherRY * this.dX + otherRZ * this.dW + (otherRW * this.dZ - otherRX * this.dY) + (otherDY * this.rX + otherDZ * this.rW + (otherDW * this.rZ - otherDX * this.rY));
        d.dW = otherRW * this.dW - otherRX * this.dX + (-(otherRY * this.dY) - otherRZ * this.dZ) + (otherDW * this.rW - otherDX * this.rX + (-(otherDY * this.rY) - otherDZ * this.rZ));
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
        float _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRZ * this.rY - otherRY * this.rZ);
        float _buf1 = otherRX * this.rZ + otherRW * this.rY + (otherRY * this.rW - otherRZ * this.rX);
        float _buf2 = otherRY * this.rX + otherRZ * this.rW + (otherRW * this.rZ - otherRX * this.rY);
        float _buf3 = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW + otherRW * this.dX + (otherRZ * this.dY - otherRY * this.dZ) + (otherDX * this.rW + otherDW * this.rX + (otherDZ * this.rY - otherDY * this.rZ));
        float _buf5 = otherRX * this.dZ + otherRW * this.dY + (otherRY * this.dW - otherRZ * this.dX) + (otherDX * this.rZ + otherDW * this.rY + (otherDY * this.rW - otherDZ * this.rX));
        float _buf6 = otherRY * this.dX + otherRZ * this.dW + (otherRW * this.dZ - otherRX * this.dY) + (otherDY * this.rX + otherDZ * this.rW + (otherDW * this.rZ - otherDX * this.rY));
        d.dW = otherRW * this.dW - otherRX * this.dX + (-(otherRY * this.dY) - otherRZ * this.dZ) + (otherDW * this.rW - otherDX * this.rX + (-(otherDY * this.rY) - otherDZ * this.rZ));
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
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat preMul(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat preMul(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        float _buf1 = otherRY * this.rW + otherRZ * this.rX + (otherRW * this.rY - otherRX * this.rZ);
        float _buf2 = otherRX * this.rY + otherRW * this.rZ + (otherRZ * this.rW - otherRY * this.rX);
        float _buf3 = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW + otherRW * this.dX + (otherRY * this.dZ - otherRZ * this.dY) + (otherDX * this.rW + otherDW * this.rX + (otherDY * this.rZ - otherDZ * this.rY));
        float _buf5 = otherRY * this.dW + otherRZ * this.dX + (otherRW * this.dY - otherRX * this.dZ) + (otherDY * this.rW + otherDZ * this.rX + (otherDW * this.rY - otherDX * this.rZ));
        float _buf6 = otherRX * this.dY + otherRW * this.dZ + (otherRZ * this.dW - otherRY * this.dX) + (otherDX * this.rY + otherDW * this.rZ + (otherDZ * this.rW - otherDY * this.rX));
        d.dW = otherRW * this.dW - otherRX * this.dX + (-(otherRY * this.dY) - otherRZ * this.dZ) + (otherDW * this.rW - otherDX * this.rX + (-(otherDY * this.rY) - otherDZ * this.rZ));
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
        float _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        float _buf1 = otherRY * this.rW + otherRZ * this.rX + (otherRW * this.rY - otherRX * this.rZ);
        float _buf2 = otherRX * this.rY + otherRW * this.rZ + (otherRZ * this.rW - otherRY * this.rX);
        float _buf3 = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW + otherRW * this.dX + (otherRY * this.dZ - otherRZ * this.dY) + (otherDX * this.rW + otherDW * this.rX + (otherDY * this.rZ - otherDZ * this.rY));
        float _buf5 = otherRY * this.dW + otherRZ * this.dX + (otherRW * this.dY - otherRX * this.dZ) + (otherDY * this.rW + otherDZ * this.rX + (otherDW * this.rY - otherDX * this.rZ));
        float _buf6 = otherRX * this.dY + otherRW * this.dZ + (otherRZ * this.dW - otherRY * this.dX) + (otherDX * this.rY + otherDW * this.rZ + (otherDZ * this.rW - otherDY * this.rX));
        d.dW = otherRW * this.dW - otherRX * this.dX + (-(otherRY * this.dY) - otherRZ * this.dZ) + (otherDW * this.rW - otherDX * this.rX + (-(otherDY * this.rY) - otherDZ * this.rZ));
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
     * @param other the other dual quaternion
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
     * transformation that, applied after {@code this}, results in {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat difference(FloatDualQuatR other, @Mutated FloatDualQuat dest) {
        return difference(other.rX(), other.rY(), other.rZ(), other.rW(), other.dX(), other.dY(), other.dZ(), other.dW(), dest);
    }


    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other dual quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat difference(FloatDualQuatR other, @Mutated DoubleDualQuat dest) {
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
    public FloatDualQuat difference(float otherRX, float otherRY, float otherRZ, float otherRW, float otherDX, float otherDY, float otherDZ, float otherDW, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _buf0 = otherRX * this.rW - otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        float _buf1 = otherRY * this.rW + otherRZ * this.rX + (-(otherRW * this.rY) - otherRX * this.rZ);
        float _buf2 = otherRX * this.rY - otherRW * this.rZ + (otherRZ * this.rW - otherRY * this.rX);
        float _buf3 = otherRX * this.rX + otherRW * this.rW + otherRY * this.rY + otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW - otherRW * this.dX + (otherRY * this.dZ - otherRZ * this.dY) + (otherDX * this.rW - otherDW * this.rX + (otherDY * this.rZ - otherDZ * this.rY));
        float _buf5 = otherRY * this.dW + otherRZ * this.dX + (-(otherRW * this.dY) - otherRX * this.dZ) + (otherDY * this.rW + otherDZ * this.rX + (-(otherDW * this.rY) - otherDX * this.rZ));
        float _buf6 = otherRX * this.dY - otherRW * this.dZ + (otherRZ * this.dW - otherRY * this.dX) + (otherDX * this.rY - otherDW * this.rZ + (otherDZ * this.rW - otherDY * this.rX));
        d.dW = otherRX * this.dX + otherRW * this.dW + (otherRY * this.dY + otherRZ * this.dZ) + (otherDX * this.rX + otherDW * this.rW + (otherDY * this.rY + otherDZ * this.rZ));
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
     * Compute the difference between this dual quaternion and ({@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}, {@code otherDX}, {@code otherDY}, {@code otherDZ},
     * {@code otherDW}), i.e. the rigid transformation that, applied after {@code this}, results in
     * ({@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherDX},
     * {@code otherDY}, {@code otherDZ}, {@code otherDW}) and store the result in {@code dest}.
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
        float _buf0 = otherRX * this.rW - otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        float _buf1 = otherRY * this.rW + otherRZ * this.rX + (-(otherRW * this.rY) - otherRX * this.rZ);
        float _buf2 = otherRX * this.rY - otherRW * this.rZ + (otherRZ * this.rW - otherRY * this.rX);
        float _buf3 = otherRX * this.rX + otherRW * this.rW + otherRY * this.rY + otherRZ * this.rZ;
        float _buf4 = otherRX * this.dW - otherRW * this.dX + (otherRY * this.dZ - otherRZ * this.dY) + (otherDX * this.rW - otherDW * this.rX + (otherDY * this.rZ - otherDZ * this.rY));
        float _buf5 = otherRY * this.dW + otherRZ * this.dX + (-(otherRW * this.dY) - otherRX * this.dZ) + (otherDY * this.rW + otherDZ * this.rX + (-(otherDW * this.rY) - otherDX * this.rZ));
        float _buf6 = otherRX * this.dY - otherRW * this.dZ + (otherRZ * this.dW - otherRY * this.dX) + (otherDX * this.rY - otherDW * this.rZ + (otherDZ * this.rW - otherDY * this.rX));
        d.dW = otherRX * this.dX + otherRW * this.dW + (otherRY * this.dY + otherRZ * this.dZ) + (otherDX * this.rX + otherDW * this.rW + (otherDY * this.rY + otherDZ * this.rZ));
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


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat exp(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t8 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t10 = (1.0f / (float) Math.sqrt(_t8));
        float _t11 = (float) Math.sqrt(_t8);
        float _t12 = (float) Math.sin(_t11);
        float _t13 = (float) Math.cos(_t11);
        float _t14 = this.rX * _t10;
        float _t15 = this.rY * _t10;
        float _t16 = this.rZ * _t10;
        float _t17 = (this.rX * this.dX + this.rY * this.dY + this.rZ * this.dZ) * _t10;
        float _t18 = _t17 * _t13;
        if (_t8 < 1.0e-12f) {
            d.rX = 0.0f;
            d.rY = 0.0f;
            d.rZ = 0.0f;
            d.rW = 1.0f;
            d.dX = this.dX;
            d.dY = this.dY;
            d.dZ = this.dZ;
            d.dW = 0.0f;
        } else {
            d.rX = _t14 * _t12;
            d.rY = _t15 * _t12;
            d.rZ = _t16 * _t12;
            d.rW = _t13;
            d.dX = _t14 * _t18 + (this.dX - _t14 * _t17) * _t10 * _t12;
            d.dY = _t15 * _t18 + (this.dY - _t15 * _t17) * _t10 * _t12;
            d.dZ = _t16 * _t18 + (this.dZ - _t16 * _t17) * _t10 * _t12;
            d.dW = -(_t17 * _t12);
        }
        return d;
    }


    /**
     * Compute the exponential of this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat exp(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t8 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t10 = (1.0f / (float) Math.sqrt(_t8));
        float _t11 = (float) Math.sqrt(_t8);
        float _t12 = (float) Math.sin(_t11);
        float _t13 = (float) Math.cos(_t11);
        float _t14 = this.rX * _t10;
        float _t15 = this.rY * _t10;
        float _t16 = this.rZ * _t10;
        float _t17 = (this.rX * this.dX + this.rY * this.dY + this.rZ * this.dZ) * _t10;
        float _t18 = _t17 * _t13;
        if (_t8 < 1.0e-12f) {
            d.rX = 0.0f;
            d.rY = 0.0f;
            d.rZ = 0.0f;
            d.rW = 1.0f;
            d.dX = this.dX;
            d.dY = this.dY;
            d.dZ = this.dZ;
            d.dW = 0.0f;
        } else {
            d.rX = _t14 * _t12;
            d.rY = _t15 * _t12;
            d.rZ = _t16 * _t12;
            d.rW = _t13;
            d.dX = _t14 * _t18 + (this.dX - _t14 * _t17) * _t10 * _t12;
            d.dY = _t15 * _t18 + (this.dY - _t15 * _t17) * _t10 * _t12;
            d.dZ = _t16 * _t18 + (this.dZ - _t16 * _t17) * _t10 * _t12;
            d.dW = -(_t17 * _t12);
        }
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
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Y and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
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
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the X, Z and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
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
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, X and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
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
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Y, Z and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
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
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, X and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
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
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this dual quaternion, to be applied about the Z, Y and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
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
        float _t14 = 2.0f * (this.rX * this.dX + this.rY * this.dY + (this.rZ * this.dZ + this.rW * this.dW));
        float _t15 = _t12 * _t12;
        float _t15_inv = 1.0f / _t15;
        float _buf0 = -(this.rX * _t12_inv);
        float _buf1 = -(this.rY * _t12_inv);
        float _buf2 = -(this.rZ * _t12_inv);
        float _buf3 = this.rW * _t12_inv;
        d.dX = this.rX * _t14 * _t15_inv - this.dX * _t12_inv;
        d.dY = this.rY * _t14 * _t15_inv - this.dY * _t12_inv;
        d.dZ = this.rZ * _t14 * _t15_inv - this.dZ * _t12_inv;
        d.dW = this.dW * _t12_inv - this.rW * _t14 * _t15_inv;
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
        float _t14 = 2.0f * (this.rX * this.dX + this.rY * this.dY + (this.rZ * this.dZ + this.rW * this.dW));
        float _t15 = _t12 * _t12;
        float _t15_inv = 1.0f / _t15;
        float _buf0 = -(this.rX * _t12_inv);
        float _buf1 = -(this.rY * _t12_inv);
        float _buf2 = -(this.rZ * _t12_inv);
        float _buf3 = this.rW * _t12_inv;
        d.dX = this.rX * _t14 * _t15_inv - this.dX * _t12_inv;
        d.dY = this.rY * _t14 * _t15_inv - this.dY * _t12_inv;
        d.dZ = this.rZ * _t14 * _t15_inv - this.dZ * _t12_inv;
        d.dW = this.dW * _t12_inv - this.rW * _t14 * _t15_inv;
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


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat log(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t4 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = this.rX * _t5;
        float _t8 = (float) Math.atan2((float) Math.sqrt(_t4), this.rW);
        float _t9 = this.rY * _t5;
        float _t10 = this.rZ * _t5;
        float _t11 = this.dW * _t5;
        float _t12 = this.rW * _t11;
        if (_t4 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                d.dX = -this.dX;
                d.dY = -this.dY;
                d.dZ = -this.dZ;
            } else {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                d.dX = this.dX;
                d.dY = this.dY;
                d.dZ = this.dZ;
            }
        } else {
            d.rX = _t7 * _t8;
            d.rY = _t9 * _t8;
            d.rZ = _t10 * _t8;
            d.dX = (_t7 * _t12 + this.dX) * _t5 * _t8 - _t7 * _t11;
            d.dY = (_t9 * _t12 + this.dY) * _t5 * _t8 - _t9 * _t11;
            d.dZ = (_t10 * _t12 + this.dZ) * _t5 * _t8 - _t10 * _t11;
        }
        d.rW = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Compute the natural logarithm of this dual quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat log(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t4 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = this.rX * _t5;
        float _t8 = (float) Math.atan2((float) Math.sqrt(_t4), this.rW);
        float _t9 = this.rY * _t5;
        float _t10 = this.rZ * _t5;
        float _t11 = this.dW * _t5;
        float _t12 = this.rW * _t11;
        if (_t4 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                d.dX = -this.dX;
                d.dY = -this.dY;
                d.dZ = -this.dZ;
            } else {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                d.dX = this.dX;
                d.dY = this.dY;
                d.dZ = this.dZ;
            }
        } else {
            d.rX = _t7 * _t8;
            d.rY = _t9 * _t8;
            d.rZ = _t10 * _t8;
            d.dX = (_t7 * _t12 + this.dX) * _t5 * _t8 - _t7 * _t11;
            d.dY = (_t9 * _t12 + this.dY) * _t5 * _t8 - _t9 * _t11;
            d.dZ = (_t10 * _t12 + this.dZ) * _t5 * _t8 - _t10 * _t11;
        }
        d.rW = 0.0f;
        d.dW = 0.0f;
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t15));
        float _t62, _t63, _t64, _t65;
        if (_t13 > 0.0f) {
            _t62 = 0.5f * _t3 * _t18;
            _t63 = 0.5f * _t7 * _t18;
            _t64 = 0.5f * _t9 * _t18;
            _t65 = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                _t62 = 0.5f * (float) Math.sqrt(_t15);
                _t63 = 0.5f * _t5 * _t22;
                _t64 = 0.5f * _t6 * _t22;
                _t65 = 0.5f * _t3 * _t22;
            } else {
                if (m.m11() > m.m22()) {
                    _t62 = 0.5f * _t5 * _t20;
                    _t63 = 0.5f * (float) Math.sqrt(_t16);
                    _t64 = 0.5f * _t8 * _t20;
                    _t65 = 0.5f * _t7 * _t20;
                } else {
                    _t62 = 0.5f * _t6 * _t21;
                    _t63 = 0.5f * _t8 * _t21;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = 0.5f * _t9 * _t21;
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
     * @param m the matrix
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t20 = (1.0f / (float) Math.sqrt(_t16));
        float _t21 = (1.0f / (float) Math.sqrt(_t17));
        float _t22 = (1.0f / (float) Math.sqrt(_t15));
        float _t62, _t63, _t64, _t65;
        if (_t13 > 0.0f) {
            _t62 = 0.5f * _t3 * _t18;
            _t63 = 0.5f * _t7 * _t18;
            _t64 = 0.5f * _t9 * _t18;
            _t65 = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                _t62 = 0.5f * (float) Math.sqrt(_t15);
                _t63 = 0.5f * _t5 * _t22;
                _t64 = 0.5f * _t6 * _t22;
                _t65 = 0.5f * _t3 * _t22;
            } else {
                if (m.m11() > m.m22()) {
                    _t62 = 0.5f * _t5 * _t20;
                    _t63 = 0.5f * (float) Math.sqrt(_t16);
                    _t64 = 0.5f * _t8 * _t20;
                    _t65 = 0.5f * _t7 * _t20;
                } else {
                    _t62 = 0.5f * _t6 * _t21;
                    _t63 = 0.5f * _t8 * _t21;
                    _t64 = 0.5f * (float) Math.sqrt(_t17);
                    _t65 = 0.5f * _t9 * _t21;
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
     * Set this dual quaternion to the rotation represented by the given matrix, with zero
     * translation.
     *
     * @param m the matrix
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t13 > 0.0f) {
            this.rX = 0.5f * _t3 * _t18;
            this.rY = 0.5f * _t7 * _t18;
            this.rZ = 0.5f * _t9 * _t18;
            this.rW = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t4) {
                this.rX = 0.5f * (float) Math.sqrt(_t15);
                this.rY = 0.5f * _t5 * _t21;
                this.rZ = 0.5f * _t6 * _t21;
                this.rW = 0.5f * _t3 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.rX = 0.5f * _t5 * _t19;
                    this.rY = 0.5f * (float) Math.sqrt(_t16);
                    this.rZ = 0.5f * _t8 * _t19;
                    this.rW = 0.5f * _t7 * _t19;
                } else {
                    this.rX = 0.5f * _t6 * _t20;
                    this.rY = 0.5f * _t8 * _t20;
                    this.rZ = 0.5f * (float) Math.sqrt(_t17);
                    this.rW = 0.5f * _t9 * _t20;
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
     * Normalize this dual quaternion so that its real (rotation) part has unit length and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatDualQuat normalize(@Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t7 = (1.0f / (float) Math.sqrt(this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW)));
        d.rX = this.rX * _t7;
        d.rY = this.rY * _t7;
        d.rZ = this.rZ * _t7;
        d.rW = this.rW * _t7;
        d.dX = this.dX * _t7;
        d.dY = this.dY * _t7;
        d.dZ = this.dZ * _t7;
        d.dW = this.dW * _t7;
        return d;
    }


    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat normalize(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t7 = (1.0f / (float) Math.sqrt(this.rX * this.rX + this.rY * this.rY + (this.rZ * this.rZ + this.rW * this.rW)));
        d.rX = this.rX * _t7;
        d.rY = this.rY * _t7;
        d.rZ = this.rZ * _t7;
        d.rW = this.rW * _t7;
        d.dX = this.dX * _t7;
        d.dY = this.dY * _t7;
        d.dZ = this.dZ * _t7;
        d.dW = this.dW * _t7;
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
    public FloatDualQuat pow(float t, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = t * this.dX;
        float _t1 = t * this.dY;
        float _t2 = t * this.dZ;
        float _t7 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = this.rX * _t8;
        float _t12 = this.rY * _t8;
        float _t13 = this.rZ * _t8;
        float _t14 = this.dW * _t8;
        float _t15 = t * (float) Math.atan2((float) Math.sqrt(_t7), this.rW);
        float _t16 = t * _t14;
        float _t17 = (float) Math.sin(_t15);
        float _t18 = (float) Math.cos(_t15);
        float _t19 = this.rW * _t14;
        float _t20 = _t16 * _t18;
        if (_t7 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                float _buf0 = 1.0f;
                d.dX = -_t0;
                d.dY = -_t1;
                d.dZ = -_t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            } else {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                float _buf0 = 1.0f;
                d.dX = _t0;
                d.dY = _t1;
                d.dZ = _t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            }
        } else {
            d.rX = _t10 * _t17;
            d.rY = _t12 * _t17;
            d.rZ = _t13 * _t17;
            float _buf0 = _t18;
            d.dX = (_t10 * _t19 + this.dX) * _t8 * _t17 - _t10 * _t20;
            d.dY = (_t12 * _t19 + this.dY) * _t8 * _t17 - _t12 * _t20;
            d.dZ = (_t13 * _t19 + this.dZ) * _t8 * _t17 - _t13 * _t20;
            d.dW = _t16 * _t17;
            d.rW = _buf0;
        }
        return d;
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
        float _t0 = t * this.dX;
        float _t1 = t * this.dY;
        float _t2 = t * this.dZ;
        float _t7 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = this.rX * _t8;
        float _t12 = this.rY * _t8;
        float _t13 = this.rZ * _t8;
        float _t14 = this.dW * _t8;
        float _t15 = t * (float) Math.atan2((float) Math.sqrt(_t7), this.rW);
        float _t16 = t * _t14;
        float _t17 = (float) Math.sin(_t15);
        float _t18 = (float) Math.cos(_t15);
        float _t19 = this.rW * _t14;
        float _t20 = _t16 * _t18;
        if (_t7 < 1.0e-12f) {
            if (this.rW < 0.0f) {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                float _buf0 = 1.0f;
                d.dX = -_t0;
                d.dY = -_t1;
                d.dZ = -_t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            } else {
                d.rX = 0.0f;
                d.rY = 0.0f;
                d.rZ = 0.0f;
                float _buf0 = 1.0f;
                d.dX = _t0;
                d.dY = _t1;
                d.dZ = _t2;
                d.dW = t * this.dW;
                d.rW = _buf0;
            }
        } else {
            d.rX = _t10 * _t17;
            d.rY = _t12 * _t17;
            d.rZ = _t13 * _t17;
            float _buf0 = _t18;
            d.dX = (_t10 * _t19 + this.dX) * _t8 * _t17 - _t10 * _t20;
            d.dY = (_t12 * _t19 + this.dY) * _t8 * _t17 - _t12 * _t20;
            d.dZ = (_t13 * _t19 + this.dZ) * _t8 * _t17 - _t13 * _t20;
            d.dW = _t16 * _t17;
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
     * @param rotation the quaternion
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
     * @param translation the vector
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
     * @param translation the vector
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


    /**
     * Compute the matrix representation of this dual quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x4 toMatrix(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        float _buf0 = _t12 - _t10;
        float _buf1 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m30 = 0.0f;
        float _buf2 = -2.0f * _t2 + 2.0f * _t3;
        float _buf3 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m31 = 0.0f;
        float _buf4 = 2.0f * (_t4 + _t5);
        float _buf5 = -2.0f * _t7 + 2.0f * _t8;
        d.m22 = 1.0f - _t10 - _t11;
        d.m32 = 0.0f;
        float _buf6 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf7 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.m23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        d.m33 = 1.0f;
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
     * Compute the matrix representation of this dual quaternion and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        float _buf0 = _t12 - _t10;
        float _buf1 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m30 = 0.0f;
        float _buf2 = -2.0f * _t2 + 2.0f * _t3;
        float _buf3 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m31 = 0.0f;
        float _buf4 = 2.0f * (_t4 + _t5);
        float _buf5 = -2.0f * _t7 + 2.0f * _t8;
        d.m22 = 1.0f - _t10 - _t11;
        d.m32 = 0.0f;
        float _buf6 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf7 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.m23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
        d.m33 = 1.0f;
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
    public Float3x3 toMatrix3x3(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        d.m00 = _t12 - _t10;
        d.m10 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m01 = -2.0f * _t2 + 2.0f * _t3;
        d.m11 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = -2.0f * _t7 + 2.0f * _t8;
        d.m22 = 1.0f - _t10 - _t11;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x3 matrix representation of this dual quaternion's rotation part (the encoded
     * translation is dropped) and store the result in {@code dest}.
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
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        d.m00 = _t12 - _t10;
        d.m10 = 2.0f * (_t3 + _t2);
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m01 = -2.0f * _t2 + 2.0f * _t3;
        d.m11 = _t12 - _t11;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = -2.0f * _t7 + 2.0f * _t8;
        d.m22 = 1.0f - _t10 - _t11;
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
    public Float3x4 toMatrix3x4(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        float _buf0 = _t12 - _t10;
        float _buf1 = -2.0f * _t2 + 2.0f * _t3;
        float _buf2 = 2.0f * (_t4 + _t5);
        float _buf3 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf4 = 2.0f * (_t3 + _t2);
        float _buf5 = _t12 - _t11;
        float _buf6 = -2.0f * _t7 + 2.0f * _t8;
        float _buf7 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m22 = 1.0f - _t10 - _t11;
        d.m23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
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
     * Compute the 3x4 matrix representation of this dual quaternion (the omitted last row is
     * implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        float _t2 = this.rZ * this.rW;
        float _t3 = this.rX * this.rY;
        float _t4 = this.rX * this.rZ;
        float _t5 = this.rY * this.rW;
        float _t7 = this.rX * this.rW;
        float _t8 = this.rY * this.rZ;
        float _t10 = 2.0f * this.rY * this.rY;
        float _t11 = 2.0f * this.rX * this.rX;
        float _t12 = 1.0f - 2.0f * this.rZ * this.rZ;
        float _buf0 = _t12 - _t10;
        float _buf1 = -2.0f * _t2 + 2.0f * _t3;
        float _buf2 = 2.0f * (_t4 + _t5);
        float _buf3 = 2.0f * (this.rY * this.dZ - this.rZ * this.dY + (this.rW * this.dX - this.rX * this.dW));
        float _buf4 = 2.0f * (_t3 + _t2);
        float _buf5 = _t12 - _t11;
        float _buf6 = -2.0f * _t7 + 2.0f * _t8;
        float _buf7 = 2.0f * (this.rZ * this.dX - this.rX * this.dZ + (this.rW * this.dY - this.rY * this.dW));
        d.m20 = -2.0f * _t5 + 2.0f * _t4;
        d.m21 = 2.0f * (_t7 + _t8);
        d.m22 = 1.0f - _t10 - _t11;
        d.m23 = 2.0f * (this.rX * this.dY - this.rY * this.dX + (this.rW * this.dZ - this.rZ * this.dW));
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dir the direction
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
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t11 - _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t10 * _t34;
        float _t45 = _t11 + _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t43 + _t35 - _t44;
        float _t64 = _t44 + (_t35 - _t43);
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t71 = (1.0f / (float) Math.sqrt(_t67));
        float _t72 = (1.0f / (float) Math.sqrt(_t68));
        float _t73 = (1.0f / (float) Math.sqrt(_t69));
        float _t74 = (1.0f / (float) Math.sqrt(_t66));
        float _t114, _t115, _t116, _t117;
        if (_t65 > 0.0f) {
            _t114 = 0.5f * _t63 * _t74;
            _t115 = 0.5f * _t42 * _t74;
            _t116 = 0.5f * (float) Math.sqrt(_t66);
            _t117 = 0.5f * _t62 * _t74;
        } else {
            if (_t33 > _t60) {
                _t114 = 0.5f * _t45 * _t71;
                _t115 = 0.5f * _t64 * _t71;
                _t116 = 0.5f * _t62 * _t71;
                _t117 = 0.5f * (float) Math.sqrt(_t67);
            } else {
                if (_t55 > _t9) {
                    _t114 = 0.5f * _t61 * _t72;
                    _t115 = 0.5f * (float) Math.sqrt(_t68);
                    _t116 = 0.5f * _t42 * _t72;
                    _t117 = 0.5f * _t64 * _t72;
                } else {
                    _t114 = 0.5f * (float) Math.sqrt(_t69);
                    _t115 = 0.5f * _t61 * _t73;
                    _t116 = 0.5f * _t63 * _t73;
                    _t117 = 0.5f * _t45 * _t73;
                }
            }
        }
        float _buf0 = this.rX * _t116 + this.rW * _t117 + (this.rY * _t114 - this.rZ * _t115);
        float _buf1 = this.rY * _t116 + this.rZ * _t117 + (this.rW * _t115 - this.rX * _t114);
        float _buf2 = this.rX * _t115 + this.rW * _t114 + (this.rZ * _t116 - this.rY * _t117);
        d.rW = this.rW * _t116 - this.rX * _t117 - this.rY * _t115 - this.rZ * _t114;
        float _buf3 = this.dX * _t116 + this.dW * _t117 + (this.dY * _t114 - this.dZ * _t115);
        float _buf4 = this.dY * _t116 + this.dZ * _t117 + (this.dW * _t115 - this.dX * _t114);
        float _buf5 = this.dX * _t115 + this.dW * _t114 + (this.dZ * _t116 - this.dY * _t117);
        d.dW = this.dW * _t116 - this.dX * _t117 - this.dY * _t115 - this.dZ * _t114;
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
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t11 - _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t10 * _t34;
        float _t45 = _t11 + _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t43 + _t35 - _t44;
        float _t64 = _t44 + (_t35 - _t43);
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t71 = (1.0f / (float) Math.sqrt(_t67));
        float _t72 = (1.0f / (float) Math.sqrt(_t68));
        float _t73 = (1.0f / (float) Math.sqrt(_t69));
        float _t74 = (1.0f / (float) Math.sqrt(_t66));
        float _t114, _t115, _t116, _t117;
        if (_t65 > 0.0f) {
            _t114 = 0.5f * _t63 * _t74;
            _t115 = 0.5f * _t42 * _t74;
            _t116 = 0.5f * (float) Math.sqrt(_t66);
            _t117 = 0.5f * _t62 * _t74;
        } else {
            if (_t33 > _t60) {
                _t114 = 0.5f * _t45 * _t71;
                _t115 = 0.5f * _t64 * _t71;
                _t116 = 0.5f * _t62 * _t71;
                _t117 = 0.5f * (float) Math.sqrt(_t67);
            } else {
                if (_t55 > _t9) {
                    _t114 = 0.5f * _t61 * _t72;
                    _t115 = 0.5f * (float) Math.sqrt(_t68);
                    _t116 = 0.5f * _t42 * _t72;
                    _t117 = 0.5f * _t64 * _t72;
                } else {
                    _t114 = 0.5f * (float) Math.sqrt(_t69);
                    _t115 = 0.5f * _t61 * _t73;
                    _t116 = 0.5f * _t63 * _t73;
                    _t117 = 0.5f * _t45 * _t73;
                }
            }
        }
        float _buf0 = this.rX * _t116 + this.rW * _t117 + (this.rY * _t114 - this.rZ * _t115);
        float _buf1 = this.rY * _t116 + this.rZ * _t117 + (this.rW * _t115 - this.rX * _t114);
        float _buf2 = this.rX * _t115 + this.rW * _t114 + (this.rZ * _t116 - this.rY * _t117);
        d.rW = this.rW * _t116 - this.rX * _t117 - this.rY * _t115 - this.rZ * _t114;
        float _buf3 = this.dX * _t116 + this.dW * _t117 + (this.dY * _t114 - this.dZ * _t115);
        float _buf4 = this.dY * _t116 + this.dZ * _t117 + (this.dW * _t115 - this.dX * _t114);
        float _buf5 = this.dX * _t115 + this.dW * _t114 + (this.dZ * _t116 - this.dY * _t117);
        d.dW = this.dW * _t116 - this.dX * _t117 - this.dY * _t115 - this.dZ * _t114;
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
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = (float) Math.cos(_t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
        return this;
    }


    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated FloatDualQuat makeRotationLookAlong(Float3R dir, Float3R up) {
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
    @Mutated public FloatDualQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t10 * _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t11 + _t34;
        float _t45 = _t11 - _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t42 + (_t35 - _t43);
        float _t64 = _t43 + _t35 - _t42;
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t70 = (1.0f / (float) Math.sqrt(_t66));
        float _t71 = (1.0f / (float) Math.sqrt(_t68));
        float _t72 = (1.0f / (float) Math.sqrt(_t69));
        float _t73 = (1.0f / (float) Math.sqrt(_t67));
        if (_t65 > 0.0f) {
            this.rX = 0.5f * _t62 * _t70;
            this.rY = 0.5f * _t45 * _t70;
            this.rZ = 0.5f * _t64 * _t70;
            this.rW = 0.5f * (float) Math.sqrt(_t66);
        } else {
            if (_t33 > _t60) {
                this.rX = 0.5f * (float) Math.sqrt(_t67);
                this.rY = 0.5f * _t63 * _t73;
                this.rZ = 0.5f * _t44 * _t73;
                this.rW = 0.5f * _t62 * _t73;
            } else {
                if (_t55 > _t9) {
                    this.rX = 0.5f * _t63 * _t71;
                    this.rY = 0.5f * (float) Math.sqrt(_t68);
                    this.rZ = 0.5f * _t61 * _t71;
                    this.rW = 0.5f * _t45 * _t71;
                } else {
                    this.rX = 0.5f * _t44 * _t72;
                    this.rY = 0.5f * _t61 * _t72;
                    this.rZ = 0.5f * (float) Math.sqrt(_t69);
                    this.rW = 0.5f * _t64 * _t72;
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
        this.rX = (float) Math.sin(_t0);
        this.rY = 0.0f;
        this.rZ = 0.0f;
        this.rW = (float) Math.cos(_t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationXYZ(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t10 * _t5 - _t9 * _t8;
        this.rZ = _t11 * _t5 + _t12 * _t8;
        this.rW = _t12 * _t5 - _t11 * _t8;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationXZY(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t8 - _t12 * _t5;
        this.rZ = _t9 * _t8 + _t10 * _t5;
        this.rW = _t12 * _t8 + _t11 * _t5;
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
        this.rX = 0.0f;
        this.rY = (float) Math.sin(_t0);
        this.rZ = 0.0f;
        this.rW = (float) Math.cos(_t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationYXZ(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t10 * _t5 - _t9 * _t8;
        this.rZ = _t11 * _t8 - _t12 * _t5;
        this.rW = _t12 * _t8 + _t11 * _t5;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationYZX(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t11 * _t5 + _t12 * _t8;
        this.rZ = _t12 * _t5 - _t11 * _t8;
        this.rW = _t10 * _t5 - _t9 * _t8;
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
        this.rX = 0.0f;
        this.rY = 0.0f;
        this.rZ = (float) Math.sin(_t0);
        this.rW = (float) Math.cos(_t0);
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationZXY(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t5 + _t12 * _t8;
        this.rZ = _t9 * _t8 + _t10 * _t5;
        this.rW = _t12 * _t5 - _t11 * _t8;
        this.dX = 0.0f;
        this.dY = 0.0f;
        this.dZ = 0.0f;
        this.dW = 0.0f;
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
    @Mutated public FloatDualQuat makeRotationZYX(float angleX, float angleY, float angleZ) {
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
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t8 + _t12 * _t5;
        this.rZ = _t12 * _t8 - _t11 * _t5;
        this.rW = _t10 * _t5 + _t9 * _t8;
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
     * @param rotation the quaternion (must be a unit quaternion)
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
     * @param rotation the quaternion (must be a unit quaternion)
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
        d.rW = rotationW * this.rW - rotationX * this.rX - rotationY * this.rY - rotationZ * this.rZ;
        float _buf3 = rotationX * this.dW + rotationW * this.dX + (rotationZ * this.dY - rotationY * this.dZ);
        float _buf4 = rotationX * this.dZ + rotationW * this.dY + (rotationY * this.dW - rotationZ * this.dX);
        float _buf5 = rotationY * this.dX + rotationZ * this.dW + (rotationW * this.dZ - rotationX * this.dY);
        d.dW = rotationW * this.dW - rotationX * this.dX - rotationY * this.dY - rotationZ * this.dZ;
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
        d.rW = rotationW * this.rW - rotationX * this.rX - rotationY * this.rY - rotationZ * this.rZ;
        float _buf3 = rotationX * this.dW + rotationW * this.dX + (rotationZ * this.dY - rotationY * this.dZ);
        float _buf4 = rotationX * this.dZ + rotationW * this.dY + (rotationY * this.dW - rotationZ * this.dX);
        float _buf5 = rotationY * this.dX + rotationZ * this.dW + (rotationW * this.dZ - rotationX * this.dY);
        d.dW = rotationW * this.dW - rotationX * this.dX - rotationY * this.dY - rotationZ * this.dZ;
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
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = this.rX * _t1 + this.rW * _t3 + (this.rY * _t4 - this.rZ * _t5);
        float _buf1 = this.rY * _t1 + this.rZ * _t3 + (this.rW * _t5 - this.rX * _t4);
        float _buf2 = this.rX * _t5 + this.rW * _t4 + (this.rZ * _t1 - this.rY * _t3);
        d.rW = this.rW * _t1 - this.rX * _t3 - this.rY * _t5 - this.rZ * _t4;
        float _buf3 = this.dX * _t1 + this.dW * _t3 + (this.dY * _t4 - this.dZ * _t5);
        float _buf4 = this.dY * _t1 + this.dZ * _t3 + (this.dW * _t5 - this.dX * _t4);
        float _buf5 = this.dX * _t5 + this.dW * _t4 + (this.dZ * _t1 - this.dY * _t3);
        d.dW = this.dW * _t1 - this.dX * _t3 - this.dY * _t5 - this.dZ * _t4;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = this.rX * _t1 + this.rW * _t3 + (this.rY * _t4 - this.rZ * _t5);
        float _buf1 = this.rY * _t1 + this.rZ * _t3 + (this.rW * _t5 - this.rX * _t4);
        float _buf2 = this.rX * _t5 + this.rW * _t4 + (this.rZ * _t1 - this.rY * _t3);
        d.rW = this.rW * _t1 - this.rX * _t3 - this.rY * _t5 - this.rZ * _t4;
        float _buf3 = this.dX * _t1 + this.dW * _t3 + (this.dY * _t4 - this.dZ * _t5);
        float _buf4 = this.dY * _t1 + this.dZ * _t3 + (this.dW * _t5 - this.dX * _t4);
        float _buf5 = this.dX * _t5 + this.dW * _t4 + (this.dZ * _t1 - this.dY * _t3);
        d.dW = this.dW * _t1 - this.dX * _t3 - this.dY * _t5 - this.dZ * _t4;
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
    public FloatDualQuat rotateX(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 + this.rW * _t2;
        float _buf1 = this.rY * _t1 + this.rZ * _t2;
        d.rZ = this.rZ * _t1 - this.rY * _t2;
        d.rW = this.rW * _t1 - this.rX * _t2;
        float _buf2 = this.dX * _t1 + this.dW * _t2;
        float _buf3 = this.dY * _t1 + this.dZ * _t2;
        d.dZ = this.dZ * _t1 - this.dY * _t2;
        d.dW = this.dW * _t1 - this.dX * _t2;
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
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 + this.rW * _t2;
        float _buf1 = this.rY * _t1 + this.rZ * _t2;
        d.rZ = this.rZ * _t1 - this.rY * _t2;
        d.rW = this.rW * _t1 - this.rX * _t2;
        float _buf2 = this.dX * _t1 + this.dW * _t2;
        float _buf3 = this.dY * _t1 + this.dZ * _t2;
        d.dZ = this.dZ * _t1 - this.dY * _t2;
        d.dW = this.dW * _t1 - this.dX * _t2;
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
    public FloatDualQuat rotateXYZ(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 + _t12 * _t8;
        float _t23 = _t10 * _t5 + _t9 * _t8;
        float _t24 = _t12 * _t5 - _t11 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this dual quaternion and store the result in {@code dest}.
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 + _t12 * _t8;
        float _t23 = _t10 * _t5 + _t9 * _t8;
        float _t24 = _t12 * _t5 - _t11 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public FloatDualQuat rotateXZY(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 - _t12 * _t5;
        float _t23 = _t11 * _t5 + _t12 * _t8;
        float _t24 = _t10 * _t5 - _t9 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public DoubleDualQuat rotateXZY(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 - _t12 * _t5;
        float _t23 = _t11 * _t5 + _t12 * _t8;
        float _t24 = _t10 * _t5 - _t9 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public FloatDualQuat rotateY(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 - this.rZ * _t2;
        float _buf1 = this.rY * _t1 + this.rW * _t2;
        d.rZ = this.rX * _t2 + this.rZ * _t1;
        d.rW = this.rW * _t1 - this.rY * _t2;
        float _buf2 = this.dX * _t1 - this.dZ * _t2;
        float _buf3 = this.dY * _t1 + this.dW * _t2;
        d.dZ = this.dX * _t2 + this.dZ * _t1;
        d.dW = this.dW * _t1 - this.dY * _t2;
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
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 - this.rZ * _t2;
        float _buf1 = this.rY * _t1 + this.rW * _t2;
        d.rZ = this.rX * _t2 + this.rZ * _t1;
        d.rW = this.rW * _t1 - this.rY * _t2;
        float _buf2 = this.dX * _t1 - this.dZ * _t2;
        float _buf3 = this.dY * _t1 + this.dW * _t2;
        d.dZ = this.dX * _t2 + this.dZ * _t1;
        d.dW = this.dW * _t1 - this.dY * _t2;
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
    public FloatDualQuat rotateYXZ(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 + _t12 * _t5;
        float _t23 = _t10 * _t5 - _t9 * _t8;
        float _t24 = _t12 * _t8 - _t11 * _t5;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this dual quaternion and store the result in {@code dest}.
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
    public DoubleDualQuat rotateYXZ(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 + _t12 * _t5;
        float _t23 = _t10 * _t5 - _t9 * _t8;
        float _t24 = _t12 * _t8 - _t11 * _t5;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public FloatDualQuat rotateYZX(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t10 * _t5 + _t9 * _t8;
        float _t23 = _t11 * _t5 - _t12 * _t8;
        float _t24 = _t12 * _t5 + _t11 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public DoubleDualQuat rotateYZX(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t10 * _t5 + _t9 * _t8;
        float _t23 = _t11 * _t5 - _t12 * _t8;
        float _t24 = _t12 * _t5 + _t11 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public FloatDualQuat rotateZ(float angle, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 + this.rY * _t2;
        d.rY = this.rY * _t1 - this.rX * _t2;
        float _buf1 = this.rZ * _t1 + this.rW * _t2;
        d.rW = this.rW * _t1 - this.rZ * _t2;
        float _buf2 = this.dX * _t1 + this.dY * _t2;
        d.dY = this.dY * _t1 - this.dX * _t2;
        float _buf3 = this.dZ * _t1 + this.dW * _t2;
        d.dW = this.dW * _t1 - this.dZ * _t2;
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
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = this.rX * _t1 + this.rY * _t2;
        d.rY = this.rY * _t1 - this.rX * _t2;
        float _buf1 = this.rZ * _t1 + this.rW * _t2;
        d.rW = this.rW * _t1 - this.rZ * _t2;
        float _buf2 = this.dX * _t1 + this.dY * _t2;
        d.dY = this.dY * _t1 - this.dX * _t2;
        float _buf3 = this.dZ * _t1 + this.dW * _t2;
        d.dW = this.dW * _t1 - this.dZ * _t2;
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
    public FloatDualQuat rotateZXY(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 - _t12 * _t8;
        float _t23 = _t11 * _t8 + _t12 * _t5;
        float _t24 = _t10 * _t5 + _t9 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.dX = _buf3;
        d.dY = _buf4;
        d.dZ = _buf5;
        return d;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this dual quaternion and store the result in {@code dest}.
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
    public DoubleDualQuat rotateZXY(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 - _t12 * _t8;
        float _t23 = _t11 * _t8 + _t12 * _t5;
        float _t24 = _t10 * _t5 + _t9 * _t8;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public FloatDualQuat rotateZYX(float angleX, float angleY, float angleZ, @Mutated FloatDualQuat dest) {
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t10 * _t5 - _t9 * _t8;
        float _t23 = _t11 * _t8 - _t12 * _t5;
        float _t24 = _t12 * _t8 + _t11 * _t5;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
    public DoubleDualQuat rotateZYX(float angleX, float angleY, float angleZ, @Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t10 * _t5 - _t9 * _t8;
        float _t23 = _t11 * _t8 - _t12 * _t5;
        float _t24 = _t12 * _t8 + _t11 * _t5;
        float _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        float _buf1 = this.rY * _t21 + this.rZ * _t22 + (this.rW * _t24 - this.rX * _t23);
        float _buf2 = this.rX * _t24 + this.rW * _t23 + (this.rZ * _t21 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        float _buf3 = this.dX * _t21 + this.dW * _t22 + (this.dY * _t23 - this.dZ * _t24);
        float _buf4 = this.dY * _t21 + this.dZ * _t22 + (this.dW * _t24 - this.dX * _t23);
        float _buf5 = this.dX * _t24 + this.dW * _t23 + (this.dZ * _t21 - this.dY * _t22);
        d.dW = this.dW * _t21 - this.dX * _t22 - this.dY * _t24 - this.dZ * _t23;
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
     * @param translation the vector
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
     *
     * @param p the vector
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
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Float3R p, @Mutated Double3 dest) {
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
     *
     * @param v the vector
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
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Float3R v, @Mutated Double3 dest) {
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
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 transformDirectionInverse(Float3R v, @Mutated Float3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this dual quaternion's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(Float3R v, @Mutated Double3 dest) {
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
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
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
     * @param p the vector
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
     * @param p the vector
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
     *
     * @param p the vector
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
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Float3R p, @Mutated Double3 dest) {
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
    public Float3 transformPosition(float pX, float pY, float pZ, @Mutated Float3 dest) {
        return transform(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by this dual quaternion, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
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
    public Double3 transformPosition(float pX, float pY, float pZ, @Mutated Double3 dest) {
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
    public Float3 transformPositionInverse(Float3R p, @Mutated Float3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(Float3R p, @Mutated Double3 dest) {
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
    public Float3 transformPositionInverse(float pX, float pY, float pZ, @Mutated Float3 dest) {
        return transformInverse(pX, pY, pZ, dest);
    }


    /**
     * Transform the given position by the inverse of this dual quaternion (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
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
     *
     * @param v the vector
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
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(Float3R v, @Mutated Double3 dest) {
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
    public Float3 transformVector(float vX, float vY, float vZ, @Mutated Float3 dest) {
        return transformDirection(vX, vY, vZ, dest);
    }


    /**
     * Transform the given vector by the rotation part of this dual quaternion, ignoring the
     * translation and store the result in {@code dest}.
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
