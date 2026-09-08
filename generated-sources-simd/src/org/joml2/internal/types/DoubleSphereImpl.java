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
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleSphere} backed by a {@code double[]} array, with Vector
 * API SIMD kernels where profitable.
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
    @Mutated public DoubleSphere set(DoubleSphereR v) {
        double[] dd = this.data;
        double[] vData = ((DoubleSphereImpl) v).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, vData, 0);
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
        double[] sd = this.data;
        double[] cData = ((Double3Impl) c).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        dd[0] = cData[0];
        dd[1] = cData[1];
        dd[2] = cData[2];
        dd[3] = sd[3];
        return dest;
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
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).withLane(3, radius);
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return transform_fma(m, dest);
        return transform_mulAdd(m, dest);
    }

    private DoubleSphere transform_fma(Double4x4R m, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        double _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        double _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        double _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        var _col0 = DoubleVector.fromArray(COL_SPECIES, mData, 8).fma(DoubleVector.broadcast(COL_SPECIES, sd[2]), DoubleVector.fromArray(COL_SPECIES, mData, 0).fma(DoubleVector.broadcast(COL_SPECIES, sd[0]), DoubleVector.fromArray(COL_SPECIES, mData, 4).fma(DoubleVector.broadcast(COL_SPECIES, sd[1]), DoubleVector.fromArray(COL_SPECIES, mData, 12)))).withLane(3, sd[3] * Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11))))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleSphere transform_mulAdd(Double4x4R m, @Mutated DoubleSphere dest) {
        double[] sd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        double _t9 = Math.abs(Math.fma(mData[2], mData[6], Math.fma(mData[0], mData[4], mData[1] * mData[5])));
        double _t10 = Math.abs(Math.fma(mData[2], mData[10], Math.fma(mData[0], mData[8], mData[1] * mData[9])));
        double _t11 = Math.abs(Math.fma(mData[6], mData[10], Math.fma(mData[4], mData[8], mData[5] * mData[9])));
        var _col0 = DoubleVector.fromArray(COL_SPECIES, mData, 8).mul(DoubleVector.broadcast(COL_SPECIES, sd[2])).add(DoubleVector.fromArray(COL_SPECIES, mData, 0).mul(DoubleVector.broadcast(COL_SPECIES, sd[0])).add(DoubleVector.fromArray(COL_SPECIES, mData, 4).mul(DoubleVector.broadcast(COL_SPECIES, sd[1])).add(DoubleVector.fromArray(COL_SPECIES, mData, 12)))).withLane(3, sd[3] * Math.sqrt(Math.max(Math.max(Math.fma(mData[0], mData[0], Math.fma(mData[1], mData[1], Math.fma(mData[2], mData[2], _t9 + _t10))), Math.fma(mData[4], mData[4], Math.fma(mData[5], mData[5], Math.fma(mData[6], mData[6], _t9 + _t11)))), Math.fma(mData[8], mData[8], Math.fma(mData[9], mData[9], Math.fma(mData[10], mData[10], _t10 + _t11))))));
        _col0.intoArray(dd, 0);
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
        double[] sd = this.data;
        double[] deltaData = ((Double3Impl) delta).data;
        double[] dd = ((DoubleSphereImpl) dest).data;
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, deltaData[0]).withLane(1, deltaData[1]).withLane(2, deltaData[2]).add(DoubleVector.fromArray(COL_SPECIES, sd, 0)).withLane(3, sd[3]);
        _col0.intoArray(dd, 0);
        return dest;
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
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, deltaX).withLane(1, deltaY).withLane(2, deltaZ).add(DoubleVector.fromArray(COL_SPECIES, sd, 0)).withLane(3, sd[3]);
        _col0.intoArray(dd, 0);
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
        double[] d = this.data;
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoArray(dest, offset);
        return dest;
    }
    public @Mutated DoubleSphere load(double[] src, int offset) {
        double[] d = this.data;
        DoubleVector.fromArray(COL_SPECIES, src, offset).intoArray(d, 0);
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        double[] d = this.data;
        if (buf.hasArray()) {
            double[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            DoubleVector.fromArray(COL_SPECIES, d, 0).intoArray(arr, off);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 8;
            DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, baseOff, ByteOrder.nativeOrder());
        }
        return buf;
    }
    @Mutated public DoubleSphere loadAbsolute(int index, DoubleBuffer buf) {
        double[] d = this.data;
        if (buf.hasArray()) {
            double[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            DoubleVector.fromArray(COL_SPECIES, arr, off).intoArray(d, 0);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 8;
            DoubleVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        double[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public DoubleSphere loadAbsolute(int index, ByteBuffer buf) {
        double[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        DoubleVector.fromMemorySegment(COL_SPECIES, seg, index, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }
    public DoubleSphere storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleSphere loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        double[] d = this.data;
        MemorySegment seg = dest;
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, offset, ByteOrder.nativeOrder());
        return dest;
    }
    public DoubleSphere load(long offset, MemorySegment src) {
        double[] d = this.data;
        MemorySegment seg = src;
        DoubleVector.fromMemorySegment(COL_SPECIES, seg, offset, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
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

    private static final VectorSpecies<Double> COL_SPECIES = DoubleVector.SPECIES_256;

}
