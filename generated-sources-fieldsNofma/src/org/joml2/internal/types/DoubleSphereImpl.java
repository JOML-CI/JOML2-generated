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
 * Generated implementation of {@link DoubleSphere} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleSphereImpl implements DoubleSphere {

    public double x;
    public double y;
    public double z;
    public double r;
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
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.r = vR;
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
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = cX;
        d.y = cY;
        d.z = cZ;
        d.r = this.r;
        return d;
    }


    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setRadius(double radius, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.r = radius;
        return d;
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
        FloatSphereImpl d = (FloatSphereImpl) dest;
        d.x = (float) (this.x);
        d.y = (float) (this.y);
        d.z = (float) (this.z);
        d.r = (float) (this.r);
        return d;
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
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        double _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        double _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        double _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        double _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        double _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        double _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        double _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        double _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        double _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        double _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = deltaX + this.x;
        d.y = deltaY + this.y;
        d.z = deltaZ + this.z;
        d.r = this.r;
        return d;
    }


    /**
     * Compute the point of this sphere closest to the given point. For a point inside or on the
     * sphere, the result is the point itself; otherwise it is the point on the surface in the
     * direction from the center toward the given point.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(Double3R p, @Mutated Double3 dest) {
        return closestPointToPoint(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Compute the point of this sphere closest to the given point. For a point inside or on the
     * sphere, the result is the point itself; otherwise it is the point on the surface in the
     * direction from the center toward the given point.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointToPoint(double pX, double pY, double pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = pX - this.x;
        double _t1 = pY - this.y;
        double _t2 = pZ - this.z;
        double _t3 = this.r * this.r;
        double _t8 = _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
        double _t10 = this.r * (1.0 / Math.sqrt(_t8));
        if (_t8 <= _t3) {
            d.x = pX;
            d.y = pY;
            d.z = pZ;
        } else {
            d.x = _t0 * _t10 + this.x;
            d.y = _t1 * _t10 + this.y;
            d.z = _t2 * _t10 + this.z;
        }
        return d;
    }


    /**
     * Compute the squared distance between this sphere and the given axis-aligned box, i.e. the
     * square of the distance from the box to the center minus the radius, clamped at zero; zero
     * when they overlap or touch.
     *
     * @param aabb the axis-aligned box
     * @return the squared distance between this sphere and the given axis-aligned box, i.e. the
     *        square of the distance from the box to the center minus the radius, clamped at zero;
     *        zero when they overlap or touch
     */
    public double distanceSquaredToAABB(DoubleAABBR aabb) {
        return distanceSquaredToAABB(aabb.minX(), aabb.minY(), aabb.minZ(), aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }


    /**
     * Compute the squared distance between this sphere and the given axis-aligned box, i.e. the
     * square of the distance from the box to the center minus the radius, clamped at zero; zero
     * when they overlap or touch.
     *
     * @param minX the {@code minX} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @return the squared distance between this sphere and the given axis-aligned box, i.e. the
     *        square of the distance from the box to the center minus the radius, clamped at zero;
     *        zero when they overlap or touch
     */
    public double distanceSquaredToAABB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        double _t6 = this.x - Math.max(minX, Math.min(this.x, maxX));
        double _t7 = this.y - Math.max(minY, Math.min(this.y, maxY));
        double _t8 = this.z - Math.max(minZ, Math.min(this.z, maxZ));
        double _t16 = Math.max(0.0, Math.sqrt(_t6 * _t6 + _t7 * _t7 + _t8 * _t8) - this.r);
        return _t16 * _t16;
    }


    /**
     * Compute the squared distance between this sphere and the given axis-aligned box, i.e. the
     * square of the distance from the box to the center minus the radius, clamped at zero; zero
     * when they overlap or touch.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return the squared distance between this sphere and the given axis-aligned box, i.e. the
     *        square of the distance from the box to the center minus the radius, clamped at zero;
     *        zero when they overlap or touch
     */
    public double distanceSquaredToAABB(Double3R min, Double3R max) {
        return distanceSquaredToAABB(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }


    /**
     * Compute the squared distance between this sphere and the given point, i.e. the square of the
     * distance from the point to the center minus the radius, clamped at zero; zero for a point
     * inside or on the sphere.
     *
     * @param p the point
     * @return the squared distance between this sphere and the given point, i.e. the square of the
     *        distance from the point to the center minus the radius, clamped at zero; zero for a
     *        point inside or on the sphere
     */
    public double distanceSquaredToPoint(Double3R p) {
        return distanceSquaredToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the squared distance between this sphere and the given point, i.e. the square of the
     * distance from the point to the center minus the radius, clamped at zero; zero for a point
     * inside or on the sphere.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the squared distance between this sphere and the given point, i.e. the square of the
     *        distance from the point to the center minus the radius, clamped at zero; zero for a
     *        point inside or on the sphere
     */
    public double distanceSquaredToPoint(double pX, double pY, double pZ) {
        double _t0 = pX - this.x;
        double _t1 = pY - this.y;
        double _t2 = pZ - this.z;
        double _t10 = Math.max(0.0, Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2) - this.r);
        return _t10 * _t10;
    }


    /**
     * Compute the squared distance between this sphere and the given sphere, i.e. the square of the
     * distance between the centers minus both radii, clamped at zero; zero when they overlap or
     * touch.
     *
     * @param other the other sphere
     * @return the squared distance between this sphere and the given sphere, i.e. the square of the
     *        distance between the centers minus both radii, clamped at zero; zero when they overlap
     *        or touch
     */
    public double distanceSquaredToSphere(DoubleSphereR other) {
        return distanceSquaredToSphere(other.x(), other.y(), other.z(), other.r());
    }


    /**
     * Compute the squared distance between this sphere and the given sphere, i.e. the square of the
     * distance between the centers minus both radii, clamped at zero; zero when they overlap or
     * touch.
     *
     * @param otherX the {@code x} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherY the {@code y} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherZ the {@code z} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherR the {@code r} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @return the squared distance between this sphere and the given sphere, i.e. the square of the
     *        distance between the centers minus both radii, clamped at zero; zero when they overlap
     *        or touch
     */
    public double distanceSquaredToSphere(double otherX, double otherY, double otherZ, double otherR) {
        double _t0 = otherX - this.x;
        double _t1 = otherY - this.y;
        double _t2 = otherZ - this.z;
        double _t11 = Math.max(0.0, Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2) - this.r - otherR);
        return _t11 * _t11;
    }


    /**
     * Compute the distance between this sphere and the given axis-aligned box, i.e. the distance
     * from the box to the center minus the radius, clamped at zero; zero when they overlap or
     * touch.
     *
     * @param aabb the axis-aligned box
     * @return the distance between this sphere and the given axis-aligned box, i.e. the distance
     *        from the box to the center minus the radius, clamped at zero; zero when they overlap
     *        or touch
     */
    public double distanceToAABB(DoubleAABBR aabb) {
        return distanceToAABB(aabb.minX(), aabb.minY(), aabb.minZ(), aabb.maxX(), aabb.maxY(), aabb.maxZ());
    }


    /**
     * Compute the distance between this sphere and the given axis-aligned box, i.e. the distance
     * from the box to the center minus the radius, clamped at zero; zero when they overlap or
     * touch.
     *
     * @param minX the {@code minX} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @return the distance between this sphere and the given axis-aligned box, i.e. the distance
     *        from the box to the center minus the radius, clamped at zero; zero when they overlap
     *        or touch
     */
    public double distanceToAABB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        double _t6 = this.x - Math.max(minX, Math.min(this.x, maxX));
        double _t7 = this.y - Math.max(minY, Math.min(this.y, maxY));
        double _t8 = this.z - Math.max(minZ, Math.min(this.z, maxZ));
        return Math.max(0.0, Math.sqrt(_t6 * _t6 + _t7 * _t7 + _t8 * _t8) - this.r);
    }


    /**
     * Compute the distance between this sphere and the given axis-aligned box, i.e. the distance
     * from the box to the center minus the radius, clamped at zero; zero when they overlap or
     * touch.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return the distance between this sphere and the given axis-aligned box, i.e. the distance
     *        from the box to the center minus the radius, clamped at zero; zero when they overlap
     *        or touch
     */
    public double distanceToAABB(Double3R min, Double3R max) {
        return distanceToAABB(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }


    /**
     * Compute the distance between this sphere and the given plane, i.e. the distance from the
     * center to the plane minus the radius, clamped at zero; zero when the plane intersects or
     * touches the sphere. The plane's normal need not be of unit length.
     *
     * @param plane the plane
     * @return the distance between this sphere and the given plane, i.e. the distance from the
     *        center to the plane minus the radius, clamped at zero; zero when the plane intersects
     *        or touches the sphere. The plane's normal need not be of unit length
     */
    public double distanceToPlane(DoublePlaneR plane) {
        return distanceToPlane(plane.a(), plane.b(), plane.c(), plane.d());
    }


    /**
     * Compute the distance between this sphere and the given plane, i.e. the distance from the
     * center to the plane minus the radius, clamped at zero; zero when the plane intersects or
     * touches the sphere. The plane's normal need not be of unit length.
     *
     * @param planeA the {@code a} component of the plane {@code (planeA, planeB, planeC, planeD)}
     * @param planeB the {@code b} component of the plane {@code (planeA, planeB, planeC, planeD)}
     * @param planeC the {@code c} component of the plane {@code (planeA, planeB, planeC, planeD)}
     * @param planeD the {@code d} component of the plane {@code (planeA, planeB, planeC, planeD)}
     * @return the distance between this sphere and the given plane, i.e. the distance from the
     *        center to the plane minus the radius, clamped at zero; zero when the plane intersects
     *        or touches the sphere. The plane's normal need not be of unit length
     */
    public double distanceToPlane(double planeA, double planeB, double planeC, double planeD) {
        return Math.max(0.0, (1.0 / Math.sqrt(planeA * planeA + planeB * planeB + planeC * planeC)) * Math.abs(planeA * this.x + (planeB * this.y + (planeC * this.z + planeD))) - this.r);
    }


    /**
     * Compute the distance between this sphere and the given plane, i.e. the distance from the
     * center to the plane minus the radius, clamped at zero; zero when the plane intersects or
     * touches the sphere. The plane's normal need not be of unit length.
     *
     * @param plane the plane
     * @return the distance between this sphere and the given plane, i.e. the distance from the
     *        center to the plane minus the radius, clamped at zero; zero when the plane intersects
     *        or touches the sphere. The plane's normal need not be of unit length
     */
    public double distanceToPlane(Double4R plane) {
        return distanceToPlane(plane.x(), plane.y(), plane.z(), plane.w());
    }


    /**
     * Compute the distance between this sphere and the given point, i.e. the distance from the
     * point to the center minus the radius, clamped at zero; zero for a point inside or on the
     * sphere.
     *
     * @param p the point
     * @return the distance between this sphere and the given point, i.e. the distance from the
     *        point to the center minus the radius, clamped at zero; zero for a point inside or on
     *        the sphere
     */
    public double distanceToPoint(Double3R p) {
        return distanceToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the distance between this sphere and the given point, i.e. the distance from the
     * point to the center minus the radius, clamped at zero; zero for a point inside or on the
     * sphere.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the distance between this sphere and the given point, i.e. the distance from the
     *        point to the center minus the radius, clamped at zero; zero for a point inside or on
     *        the sphere
     */
    public double distanceToPoint(double pX, double pY, double pZ) {
        double _t0 = pX - this.x;
        double _t1 = pY - this.y;
        double _t2 = pZ - this.z;
        return Math.max(0.0, Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2) - this.r);
    }


    /**
     * Compute the distance between this sphere and the given sphere, i.e. the distance between the
     * centers minus both radii, clamped at zero; zero when they overlap or touch.
     *
     * @param other the other sphere
     * @return the distance between this sphere and the given sphere, i.e. the distance between the
     *        centers minus both radii, clamped at zero; zero when they overlap or touch
     */
    public double distanceToSphere(DoubleSphereR other) {
        return distanceToSphere(other.x(), other.y(), other.z(), other.r());
    }


    /**
     * Compute the distance between this sphere and the given sphere, i.e. the distance between the
     * centers minus both radii, clamped at zero; zero when they overlap or touch.
     *
     * @param otherX the {@code x} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherY the {@code y} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherZ the {@code z} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @param otherR the {@code r} component of the other sphere
     *        {@code (otherX, otherY, otherZ, otherR)}
     * @return the distance between this sphere and the given sphere, i.e. the distance between the
     *        centers minus both radii, clamped at zero; zero when they overlap or touch
     */
    public double distanceToSphere(double otherX, double otherY, double otherZ, double otherR) {
        double _t0 = otherX - this.x;
        double _t1 = otherY - this.y;
        double _t2 = otherZ - this.z;
        return Math.max(0.0, Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2) - this.r - otherR);
    }


    /**
     * Get the center of this sphere and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCenter(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        return d;
    }


    /**
     * Determine whether this sphere is valid, i.e. its radius is not negative.
     *
     * @return {@code true} if this sphere is valid, i.e. its radius is not negative, {@code false}
     *        otherwise
     */
    public boolean isValid() {
        return this.r >= 0.0;
    }


    /**
     * Compute the signed distance between the given point and the surface of this sphere, i.e. the
     * distance from the point to the center minus the radius: positive outside, zero on the surface
     * and negative inside.
     *
     * @param p the point
     * @return the signed distance between the given point and the surface of this sphere, i.e. the
     *        distance from the point to the center minus the radius: positive outside, zero on the
     *        surface and negative inside
     */
    public double signedDistanceToPoint(Double3R p) {
        return signedDistanceToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the signed distance between the given point and the surface of this sphere, i.e. the
     * distance from the point to the center minus the radius: positive outside, zero on the surface
     * and negative inside.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the signed distance between the given point and the surface of this sphere, i.e. the
     *        distance from the point to the center minus the radius: positive outside, zero on the
     *        surface and negative inside
     */
    public double signedDistanceToPoint(double pX, double pY, double pZ) {
        double _t0 = pX - this.x;
        double _t1 = pY - this.y;
        double _t2 = pZ - this.z;
        return Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2) - this.r;
    }

    public double x() { return this.x; }
    public double y() { return this.y; }
    public double z() { return this.z; }
    public double r() { return this.r; }

    @Override public String toString() {
        return "DoubleSphere(" + x() + ", " + y() + ", " + z() + ", " + r() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleSphereImpl)) return false;
        DoubleSphereImpl o = (DoubleSphereImpl) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(o.x)
            && Double.doubleToLongBits(y) == Double.doubleToLongBits(o.y)
            && Double.doubleToLongBits(z) == Double.doubleToLongBits(o.z)
            && Double.doubleToLongBits(r) == Double.doubleToLongBits(o.r);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(r) ^ (Double.doubleToLongBits(r) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y)
            && Double.isFinite(z)
            && Double.isFinite(r);
    }

    @Override public boolean equalsEpsilon(DoubleSphereR other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(r - other.r()) <= epsilon;
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
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.r;
        return dest;
    }
    public @Mutated DoubleSphere load(double[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.r = src[offset + 3];
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
        dest[offset + 0] = (float) this.x;
        dest[offset + 1] = (float) this.y;
        dest[offset + 2] = (float) this.z;
        dest[offset + 3] = (float) this.r;
        return dest;
    }
    public @Mutated DoubleSphere load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.r = src[offset + 3];
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
