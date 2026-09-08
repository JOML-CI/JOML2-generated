package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import jdk.incubator.vector.*;
import org.joml2.internal.simd.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatSphere} backed by a {@code float[]} array, with Vector
 * API SIMD kernels where profitable.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatSphereImpl implements FloatSphere {

    public float[] data;
    static final FloatSphereSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereSegOpsUnsafe()
                    : new FloatSphereSegOpsMS();
    static final FloatSphereBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereBbOpsUnsafe()
                    : new FloatSphereBbOpsApi();
    static final FloatSphereRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereRawOpsUnsafe()
                    : new FloatSphereRawOpsApi();

    public FloatSphereImpl() {
        data = new float[4];
    }


    /**
     * Set this sphere to the given values.
     *
     * @param v the sphere
     * @return this
     */
    @Mutated public FloatSphere set(FloatSphereR v) {
        float[] dd = this.data;
        float[] vData = ((FloatSphereImpl) v).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, vData, 0);
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this sphere to the given values.
     *
     * @param vX the {@code x} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vY the {@code y} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vZ the {@code z} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vR the {@code r} component of the sphere {@code (vX, vY, vZ, vR)}
     * @return this
     */
    @Mutated public FloatSphere set(float vX, float vY, float vZ, float vR) {
        float[] dd = this.data;
        dd[0] = vX;
        dd[1] = vY;
        dd[2] = vZ;
        dd[3] = vR;
        return this;
    }


    /**
     * Set the center of this sphere to {@code c} and store the result in {@code dest}.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setCenter(Float3R c, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] cData = ((Float3Impl) c).data;
        float[] dd = ((FloatSphereImpl) dest).data;
        dd[0] = cData[0];
        dd[1] = cData[1];
        dd[2] = cData[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Set the center of this sphere to {@code c} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setCenter(Float3R c, @Mutated DoubleSphere dest) {
        return setCenter(c.x(), c.y(), c.z(), dest);
    }


    /**
     * Set the center of this sphere to ({@code cX}, {@code cY}, {@code cZ}) and store the result in
     * {@code dest}.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setCenter(float cX, float cY, float cZ, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] dd = ((FloatSphereImpl) dest).data;
        dd[0] = cX;
        dd[1] = cY;
        dd[2] = cZ;
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Set the center of this sphere to ({@code cX}, {@code cY}, {@code cZ}) and store the result in
     * {@code dest}.
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
    public DoubleSphere setCenter(float cX, float cY, float cZ, @Mutated DoubleSphere dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = cX;
        dd[1] = cY;
        dd[2] = cZ;
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setRadius(float radius, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] dd = ((FloatSphereImpl) dest).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).withLane(3, radius);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setRadius(float radius, @Mutated DoubleSphere dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = radius;
        return dest;
    }


    /**
     * Convert this sphere to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere toDouble(@Mutated DoubleSphere dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere transform(Float3x4R m, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float[] dd = ((FloatSphereImpl) dest).data;
        float _t9 = Math.abs(Math.fma(mData[8], mData[9], Math.fma(mData[0], mData[1], mData[4] * mData[5])));
        float _t10 = Math.abs(Math.fma(mData[8], mData[10], Math.fma(mData[0], mData[2], mData[4] * mData[6])));
        float _t11 = Math.abs(Math.fma(mData[9], mData[10], Math.fma(mData[1], mData[2], mData[5] * mData[6])));
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        dd[3] = sd[3] * (float) Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[4], mData[4], Math.fma(mData[8], mData[8], _t9 + _t10))), Math.fma(mData[1], mData[1], Math.fma(mData[5], mData[5], Math.fma(mData[9], mData[9], _t9 + _t11)))), Math.fma(mData[2], mData[2], Math.fma(mData[6], mData[6], Math.fma(mData[10], mData[10], _t10 + _t11)))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere transform(Float3x4R m, @Mutated DoubleSphere dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        float _t9 = Math.abs(Math.fma(mData[8], mData[9], Math.fma(mData[0], mData[1], mData[4] * mData[5])));
        float _t10 = Math.abs(Math.fma(mData[8], mData[10], Math.fma(mData[0], mData[2], mData[4] * mData[6])));
        float _t11 = Math.abs(Math.fma(mData[9], mData[10], Math.fma(mData[1], mData[2], mData[5] * mData[6])));
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        dd[3] = sd[3] * (float) Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[4], mData[4], Math.fma(mData[8], mData[8], _t9 + _t10))), Math.fma(mData[1], mData[1], Math.fma(mData[5], mData[5], Math.fma(mData[9], mData[9], _t9 + _t11)))), Math.fma(mData[2], mData[2], Math.fma(mData[6], mData[6], Math.fma(mData[10], mData[10], _t10 + _t11)))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere transform(Float4x4R m, @Mutated FloatSphere dest) {
        if (SimdMath.USE_FMA) return transform_fma(m, dest);
        return transform_mulAdd(m, dest);
    }

    private FloatSphere transform_fma(Float4x4R m, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatSphereImpl) dest).data;
        float _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        float _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        float _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        var _col0 = FloatVector.fromArray(COL_SPECIES, mData, 8).fma(FloatVector.broadcast(COL_SPECIES, sd[2]), FloatVector.fromArray(COL_SPECIES, mData, 0).fma(FloatVector.broadcast(COL_SPECIES, sd[0]), FloatVector.fromArray(COL_SPECIES, mData, 4).fma(FloatVector.broadcast(COL_SPECIES, sd[1]), FloatVector.fromArray(COL_SPECIES, mData, 12)))).withLane(3, sd[3] * (float) Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11))))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatSphere transform_mulAdd(Float4x4R m, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatSphereImpl) dest).data;
        float _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        float _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        float _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        var _col0 = FloatVector.fromArray(COL_SPECIES, mData, 8).mul(FloatVector.broadcast(COL_SPECIES, sd[2])).add(FloatVector.fromArray(COL_SPECIES, mData, 0).mul(FloatVector.broadcast(COL_SPECIES, sd[0])).add(FloatVector.fromArray(COL_SPECIES, mData, 4).mul(FloatVector.broadcast(COL_SPECIES, sd[1])).add(FloatVector.fromArray(COL_SPECIES, mData, 12)))).withLane(3, sd[3] * (float) Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11))))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
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
    public DoubleSphere transform(Float4x4R m, @Mutated DoubleSphere dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        float _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        float _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        float _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        dd[3] = sd[3] * (float) Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11)))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Translate this sphere by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere translate(Float3R delta, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] deltaData = ((Float3Impl) delta).data;
        float[] dd = ((FloatSphereImpl) dest).data;
        var _col0 = FloatVector.zero(COL_SPECIES).withLane(0, deltaData[0]).withLane(1, deltaData[1]).withLane(2, deltaData[2]).add(FloatVector.fromArray(COL_SPECIES, sd, 0)).withLane(3, sd[3]);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Translate this sphere by {@code delta} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere translate(Float3R delta, @Mutated DoubleSphere dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this sphere by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and store the
     * result in {@code dest}.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere translate(float deltaX, float deltaY, float deltaZ, @Mutated FloatSphere dest) {
        float[] sd = this.data;
        float[] dd = ((FloatSphereImpl) dest).data;
        var _col0 = FloatVector.zero(COL_SPECIES).withLane(0, deltaX).withLane(1, deltaY).withLane(2, deltaZ).add(FloatVector.fromArray(COL_SPECIES, sd, 0)).withLane(3, sd[3]);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Translate this sphere by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and store the
     * result in {@code dest}.
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
    public DoubleSphere translate(float deltaX, float deltaY, float deltaZ, @Mutated DoubleSphere dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaZ + sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Get the center of this sphere and store the result in {@code dest}.
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
     * Get the center of this sphere and store the result in {@code dest}.
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
     * Determine whether this sphere is valid, i.e. its radius is not negative.
     *
     * @return {@code true} if this sphere is valid, i.e. its radius is not negative, {@code false}
     *        otherwise
     */
    public boolean isValid() {
        float[] sd = this.data;
        return sd[3] >= 0.0f;
    }

    public float x() { return data[0]; }
    public float y() { return data[1]; }
    public float z() { return data[2]; }
    public float r() { return data[3]; }

    @Override public String toString() {
        return "FloatSphere(" + x() + ", " + y() + ", " + z() + ", " + r() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatSphereImpl)) return false;
        FloatSphereImpl o = (FloatSphereImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2])
            && Float.isFinite(data[3]);
    }

    @Override public boolean equalsEpsilon(FloatSphereR other, float epsilon) {
        return Math.abs(data[0] - other.x()) <= epsilon
            && Math.abs(data[1] - other.y()) <= epsilon
            && Math.abs(data[2] - other.z()) <= epsilon
            && Math.abs(data[3] - other.r()) <= epsilon;
    }

    public boolean containsPoint(float px, float py, float pz) {
        return Intersectionf.testPointSphere(px, py, pz, x(), y(), z(), r() * r());
    }

    public boolean containsPoint(Float3R p) {
        return Intersectionf.testPointSphere(p, this);
    }

    public boolean intersectsSphere(FloatSphereR o) {
        return Intersectionf.testSphereSphere(x(), y(), z(), r() * r(), o.x(), o.y(), o.z(), o.r() * o.r());
    }

    public boolean intersectsAABB(FloatAABBR aabb) {
        return Intersectionf.testAabbSphere(aabb, this);
    }

    public boolean intersectsPlane(FloatPlaneR plane) {
        return Intersectionf.testPlaneSphere(plane.a(), plane.b(), plane.c(), plane.d(), x(), y(), z(), r());
    }

    public boolean intersectsRay(FloatRayR ray) {
        return Intersectionf.testRaySphere(ray, this);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        float[] d = this.data;
        FloatVector.fromArray(COL_SPECIES, d, 0).intoArray(dest, offset);
        return dest;
    }
    public @Mutated FloatSphere load(float[] src, int offset) {
        float[] d = this.data;
        FloatVector.fromArray(COL_SPECIES, src, offset).intoArray(d, 0);
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        float[] d = this.data;
        if (buf.hasArray()) {
            float[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            FloatVector.fromArray(COL_SPECIES, d, 0).intoArray(arr, off);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, baseOff, ByteOrder.nativeOrder());
        }
        return buf;
    }
    @Mutated public FloatSphere loadAbsolute(int index, FloatBuffer buf) {
        float[] d = this.data;
        if (buf.hasArray()) {
            float[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            FloatVector.fromArray(COL_SPECIES, arr, off).intoArray(d, 0);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            FloatVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        float[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public FloatSphere loadAbsolute(int index, ByteBuffer buf) {
        float[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        FloatVector.fromMemorySegment(COL_SPECIES, seg, index, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }
    public FloatSphere storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatSphere loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        float[] d = this.data;
        MemorySegment seg = dest;
        FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, offset, ByteOrder.nativeOrder());
        return dest;
    }
    public FloatSphere load(long offset, MemorySegment src) {
        float[] d = this.data;
        MemorySegment seg = src;
        FloatVector.fromMemorySegment(COL_SPECIES, seg, offset, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated FloatSphere load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatSphere loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatSphere loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatSphere storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatSphere loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatSphere loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

    private static final VectorSpecies<Float> COL_SPECIES = FloatVector.SPECIES_128;

}
