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
 * Generated implementation of {@link DoubleSphere} backed by a {@code double[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleSphereImpl implements DoubleSphere {

    public double[] data;
    static final DoubleSphereSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleSphereSegOpsUnsafe()
                    : new DoubleSphereSegOpsMS();
    static final DoubleSphereBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleSphereBbOpsUnsafe()
                    : new DoubleSphereBbOpsApi();
    static final DoubleSphereRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleSphereRawOpsUnsafe()
                    : new DoubleSphereRawOpsApi();

    public DoubleSphereImpl() {
        data = new double[4];
    }


    /**
     * Set this sphere to the given values.
     *
     * @param v the sphere
     * @return this
     */
    public @Mutated DoubleSphere set(DoubleSphereR v) {
        return set(v.x(), v.y(), v.z(), v.r());
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
    @Mutated public DoubleSphere set(double vX, double vY, double vZ, double vR) {
        double[] dd = this.data;
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
    public DoubleSphere setCenter(Double3R c, @Mutated DoubleSphere dest) {
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
    public DoubleSphere setCenter(double cX, double cY, double cZ, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
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
    public DoubleSphere setRadius(double radius, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = radius;
        return dest;
    }


    /**
     * Convert this sphere to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere toFloat(@Mutated FloatSphere dest) {
        double[] sd = this.data;
        float[] dd = ((FloatSphereImpl) dest).data;
        dd[0] = (float) (sd[0]);
        dd[1] = (float) (sd[1]);
        dd[2] = (float) (sd[2]);
        dd[3] = (float) (sd[3]);
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
    public DoubleSphere transform(Double3x4R m, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        double _t9 = Math.abs(Math.fma(mData[8], mData[9], Math.fma(mData[0], mData[1], mData[4] * mData[5])));
        double _t10 = Math.abs(Math.fma(mData[8], mData[10], Math.fma(mData[0], mData[2], mData[4] * mData[6])));
        double _t11 = Math.abs(Math.fma(mData[9], mData[10], Math.fma(mData[1], mData[2], mData[5] * mData[6])));
        double _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        double _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        dd[3] = sd[3] * Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[4], mData[4], Math.fma(mData[8], mData[8], _t9 + _t10))), Math.fma(mData[1], mData[1], Math.fma(mData[5], mData[5], Math.fma(mData[9], mData[9], _t9 + _t11)))), Math.fma(mData[2], mData[2], Math.fma(mData[6], mData[6], Math.fma(mData[10], mData[10], _t10 + _t11)))));
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
    public DoubleSphere transform(Double4x4R m, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        double _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        double _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        double _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        double _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        double _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        dd[3] = sd[3] * Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11)))));
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
    public DoubleSphere translate(Double3R delta, @Mutated DoubleSphere dest) {
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
    public DoubleSphere translate(double deltaX, double deltaY, double deltaZ, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
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
    public Double3 getCenter(@Mutated Double3 dest) {
        double[] sd = this.data;
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
        double[] sd = this.data;
        return sd[3] >= 0.0;
    }

    public double x() { return data[0]; }
    public double y() { return data[1]; }
    public double z() { return data[2]; }
    public double r() { return data[3]; }

    @Override public String toString() {
        return "DoubleSphere(" + x() + ", " + y() + ", " + z() + ", " + r() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleSphereImpl)) return false;
        DoubleSphereImpl o = (DoubleSphereImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Double.isFinite(data[0])
            && Double.isFinite(data[1])
            && Double.isFinite(data[2])
            && Double.isFinite(data[3]);
    }

    @Override public boolean equalsEpsilon(DoubleSphereR other, double epsilon) {
        return Math.abs(data[0] - other.x()) <= epsilon
            && Math.abs(data[1] - other.y()) <= epsilon
            && Math.abs(data[2] - other.z()) <= epsilon
            && Math.abs(data[3] - other.r()) <= epsilon;
    }

    public boolean containsPoint(double px, double py, double pz) {
        return Intersectiond.testPointSphere(px, py, pz, x(), y(), z(), r() * r());
    }

    public boolean containsPoint(Double3R p) {
        return Intersectiond.testPointSphere(p, this);
    }

    public boolean intersectsSphere(DoubleSphereR o) {
        return Intersectiond.testSphereSphere(x(), y(), z(), r() * r(), o.x(), o.y(), o.z(), o.r() * o.r());
    }

    public boolean intersectsAABB(DoubleAABBR aabb) {
        return Intersectiond.testAabbSphere(aabb, this);
    }

    public boolean intersectsPlane(DoublePlaneR plane) {
        return Intersectiond.testPlaneSphere(plane.a(), plane.b(), plane.c(), plane.d(), x(), y(), z(), r());
    }

    public boolean intersectsRay(DoubleRayR ray) {
        return Intersectiond.testRaySphere(ray, this);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated DoubleSphere load(double[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleSphere loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleSphere loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleSphere storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleSphere loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleSphere load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) this.data[3];
        return dest;
    }
    public @Mutated DoubleSphere load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleSphere loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleSphere loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleSphere storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleSphere loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleSphere loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
