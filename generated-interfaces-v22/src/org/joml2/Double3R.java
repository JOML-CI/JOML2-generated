package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a 3D vector of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link Double3}. APIs that only read a 3D vector
 * should accept {@code Double3R}, so callers can pass mutable instances without exposing them to
 * modification.
 * <p>
 * Arguments of type {@code Double3R} must be instances created by the library ({@link Joml}
 * factories / the library's own types); the implementations read cached state through the library's
 * own classes, so foreign implementations of the {@code *R} interfaces are not supported as
 * arguments.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Double.doubleToLongBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
 * NaN. {@code hashCode} is consistent with it (derived from the same bit patterns). Only instances
 * of this library's implementation compare equal to each other; the {@code equals} of a vector
 * never returns {@code true} for an object of another type.
 * <p>
 * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
 * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and a
 * NaN component never compares equal to anything.
 */
public interface Double3R {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 24;

    /** {@return a shared all-zero vector} Never mutate it - it is returned as the read-only view for that reason. */
    public static Double3R ZERO() { return Holder.ZERO; }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 add(Double3R other, @Mutated Double3 dest);

    /**
     * Add ({@code x}, {@code y}, {@code z}) to this vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 add(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Divide each component of this vector by {@code scalar} and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 div(double scalar, @Mutated Double3 dest);

    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 div(Double3R other, @Mutated Double3 dest);

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}, {@code z}) and store the result
     * in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 div(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 fma(double b, Double3R c, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by {@code b} and add ({@code x}, {@code y}, {@code z}),
     * i.e. compute {@code this * b + (x, y, z)} per component and store the result in {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 fma(double b, double x, double y, double z, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 fma(Double3R b, Double3R c, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * (bX, bY, bZ) + (cX, cY, cZ)}
     * per component and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 fma(double bX, double bY, double bZ, double cX, double cY, double cZ, @Mutated Double3 dest);

    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 mul(double scalar, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 mul(Double3R other, @Mutated Double3 dest);

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}, {@code z}) and store the result
     * in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 mul(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negate(@Mutated Double3 dest);

    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 sub(Double3R other, @Mutated Double3 dest);

    /**
     * Subtract ({@code x}, {@code y}, {@code z}) from this vector and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 sub(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    Double3 set(double s, @Mutated Double3 dest);

    /**
     * Convert this vector to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 toFloat(@Mutated Float3 dest);

    /**
     * Convert this vector to {@code byte} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    Byte3 toByte(@Mutated Byte3 dest);

    /**
     * Convert this vector to {@code byte} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    Byte3 toByte(RoundingMode mode, @Mutated Byte3 dest);

    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    Short3 toShort(@Mutated Short3 dest);

    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    Short3 toShort(RoundingMode mode, @Mutated Short3 dest);

    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    Int3 toInt(@Mutated Int3 dest);

    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    Int3 toInt(RoundingMode mode, @Mutated Int3 dest);

    /**
     * Convert this vector to {@code long} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    Long3 toLong(@Mutated Long3 dest);

    /**
     * Convert this vector to {@code long} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    Long3 toLong(RoundingMode mode, @Mutated Long3 dest);

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest);

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest);

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier2(Double3R p1, Double3R p2, double t, @Mutated Double3 dest);

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier2(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier2Tangent(Double3R p1, Double3R p2, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezier2Tangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezierTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 bezierTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest);

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 catmullRom(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest);

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 catmullRom(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 catmullRomTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 catmullRomTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest);

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 hermite(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest);

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 hermite(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 hermiteTangent(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest);

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 hermiteTangent(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t, @Mutated Double3 dest);

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 lerp(Double3R other, double t, @Mutated Double3 dest);

    /**
     * Linearly interpolate between this vector and ({@code x}, {@code y}, {@code z}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 lerp(double x, double y, double z, double t, @Mutated Double3 dest);

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double3 lerp(Double3R other, Double3R t, @Mutated Double3 dest);

    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor ({@code tX}, {@code tY}, {@code tZ}) and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 lerp(double otherX, double otherY, double otherZ, double tX, double tY, double tZ, @Mutated Double3 dest);

    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 absolute(@Mutated Double3 dest);

    /**
     * Compute the arc cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 acos(@Mutated Double3 dest);

    /**
     * Add {@code b} scaled by {@code scalar} to this vector and store the result in {@code dest}.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 addScaled(Double3R b, double scalar, @Mutated Double3 dest);

    /**
     * Add ({@code x}, {@code y}, {@code z}) scaled by {@code scalar} to this vector and store the
     * result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 addScaled(double x, double y, double z, double scalar, @Mutated Double3 dest);

    /**
     * Add {@code b} scaled by {@code c} to this vector and store the result in {@code dest}.
     *
     * @param b the vector
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 addScaled(Double3R b, Double3R c, @Mutated Double3 dest);

    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by ({@code cX}, {@code cY}, {@code cZ}) to
     * this vector and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 addScaled(double bX, double bY, double bZ, double cX, double cY, double cZ, @Mutated Double3 dest);

    /**
     * Compute the angle in radians between this vector and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @return the angle in radians between this vector and {@code other}
     */
    double angleBetween(Double3R other);

    /**
     * Compute the angle in radians between this vector and ({@code x}, {@code y}, {@code z}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the angle in radians between this vector and ({@code x}, {@code y}, {@code z})
     */
    double angleBetween(double x, double y, double z);

    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 asin(@Mutated Double3 dest);

    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 atan(@Mutated Double3 dest);

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator) and store the result in
     * {@code dest}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    Double3 atan2(double x, @Mutated Double3 dest);

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator) and store the result in {@code dest}.
     *
     * @param x the vector of denominators, one per component
     * @param dest will hold the result
     * @return dest
     */
    Double3 atan2(Double3R x, @Mutated Double3 dest);

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code x},
     * {@code y}, {@code z}) (the denominator) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 atan2(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 cbrt(@Mutated Double3 dest);

    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 ceil(@Mutated Double3 dest);

    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    Double3 clamp(double min, double max, @Mutated Double3 dest);

    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    Double3 clamp(Double3R min, Double3R max, @Mutated Double3 dest);

    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ}) and
     * ({@code maxX}, {@code maxY}, {@code maxZ}) and store the result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 clamp(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated Double3 dest);

    /**
     * Compute the point on the line segment between {@code lineStart} and {@code lineEnd} that is
     * closest to this vector and store the result in {@code dest}.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 closestPointOnLine(Double3R lineStart, Double3R lineEnd, @Mutated Double3 dest);

    /**
     * Compute the point on the line segment between ({@code lineStartX}, {@code lineStartY},
     * {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY}, {@code lineEndZ}) that is
     * closest to this vector and store the result in {@code dest}.
     *
     * @param lineStartX the {@code x} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineStartY the {@code y} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineStartZ the {@code z} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineEndX the {@code x} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @param lineEndY the {@code y} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @param lineEndZ the {@code z} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 closestPointOnLine(double lineStartX, double lineStartY, double lineStartZ, double lineEndX, double lineEndY, double lineEndZ, @Mutated Double3 dest);

    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    double compAdd();

    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    double compMax();

    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    double compMin();

    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    double compMul();

    /**
     * Copy the sign of {@code sign} onto each component of this vector and store the result in
     * {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    Double3 copySign(double sign, @Mutated Double3 dest);

    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector and store the result in {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    Double3 copySign(Double3R sign, @Mutated Double3 dest);

    /**
     * Copy the sign of each component of ({@code x}, {@code y}, {@code z}) onto the corresponding
     * component of this vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 copySign(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 cos(@Mutated Double3 dest);

    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 cosh(@Mutated Double3 dest);

    /**
     * Compute the cross product of this vector and {@code other} and store the result in
     * {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 cross(Double3R other, @Mutated Double3 dest);

    /**
     * Compute the cross product of this vector and ({@code x}, {@code y}, {@code z}) and store the
     * result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 cross(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the value converted from radians to degrees of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 degrees(@Mutated Double3 dest);

    /**
     * Compute the distance between this vector and {@code other}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param other the other vector
     * @return the distance between this vector and {@code other}
     */
    double distance(Double3R other);

    /**
     * Compute the distance between this vector and ({@code x}, {@code y}, {@code z}).
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the distance between this vector and ({@code x}, {@code y}, {@code z})
     */
    double distance(double x, double y, double z);

    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    double distanceSquared(Double3R other);

    /**
     * Compute the squared distance between this vector and ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the squared distance between this vector and ({@code x}, {@code y}, {@code z})
     */
    double distanceSquared(double x, double y, double z);

    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    double dot(Double3R other);

    /**
     * Compute the dot product of this vector and ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the dot product of this vector and ({@code x}, {@code y}, {@code z})
     */
    double dot(double x, double y, double z);

    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 exp(@Mutated Double3 dest);

    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 exp2(@Mutated Double3 dest);

    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 expm1(@Mutated Double3 dest);

    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref} and store the result in {@code dest}.
     *
     * @param I the vector
     * @param Nref the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 faceforward(Double3R I, Double3R Nref, @Mutated Double3 dest);

    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ), (IX, IY, IZ))} is
     * negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}) as judged by the reference vector ({@code NrefX}, {@code NrefY},
     * {@code NrefZ}) and store the result in {@code dest}.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 faceforward(double IX, double IY, double IZ, double NrefX, double NrefY, double NrefZ, @Mutated Double3 dest);

    /**
     * Compute the floor of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 floor(@Mutated Double3 dest);

    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 fract(@Mutated Double3 dest);

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    Double3 hypot(double y, @Mutated Double3 dest);

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y} and store the result in
     * {@code dest}.
     *
     * @param y the vector of other operands, one per component
     * @param dest will hold the result
     * @return dest
     */
    Double3 hypot(Double3R y, @Mutated Double3 dest);

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code x}, {@code y}, {@code z})
     * and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 hypot(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 inverse(@Mutated Double3 dest);

    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 inverseSqrt(@Mutated Double3 dest);

    /**
     * Compute the length of this vector.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this vector must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @return the length of this vector
     */
    double length();

    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    double lengthSquared();

    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 log(@Mutated Double3 dest);

    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 log10(@Mutated Double3 dest);

    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 log1p(@Mutated Double3 dest);

    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 log2(@Mutated Double3 dest);

    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    double manhattanDistance(Double3R other);

    /**
     * Compute the Manhattan distance between this vector and ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the Manhattan distance between this vector and ({@code x}, {@code y}, {@code z})
     */
    double manhattanDistance(double x, double y, double z);

    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    double manhattanLength();

    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 max(double scalar, @Mutated Double3 dest);

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 max(Double3R other, @Mutated Double3 dest);

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}, {@code z}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 max(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    Double3 min(double scalar, @Mutated Double3 dest);

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 min(Double3R other, @Mutated Double3 dest);

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}, {@code z}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 min(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @param dest will hold the result
     * @return dest
     */
    Double3 mod(double y, @Mutated Double3 dest);

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the vector of divisors, one per component
     * @param dest will hold the result
     * @return dest
     */
    Double3 mod(Double3R y, @Mutated Double3 dest);

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code x}, {@code y}, {@code z}) and store the result in
     * {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 mod(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 nextDown(@Mutated Double3 dest);

    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 nextUp(@Mutated Double3 dest);

    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at the component precision, so components whose squares overflow
     * or underflow that precision are out of domain: the result is the zero vector rather than a
     * unit vector. Rescale such inputs before normalizing (the magnitude must lie roughly between
     * 1e-19 and 1.8e19 for {@code float}, 1.5e-154 and 1.3e154 for {@code double}).
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalize(@Mutated Double3 dest);

    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector) and store the result in {@code dest}.
     *
     * @param length the length to rescale to
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizeMul(double length, @Mutated Double3 dest);

    /**
     * Compute the signed angle in radians between this vector and {@code other}, positive when the
     * rotation from this vector to {@code other} is counter-clockwise as seen from the direction of
     * the given normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @param normal the reference axis that defines the sign of the angle
     * @return the signed angle in radians between this vector and {@code other}, positive when the
     *        rotation from this vector to {@code other} is counter-clockwise as seen from the
     *        direction of the given normal
     */
    double orientedAngle(Double3R other, Double3R normal);

    /**
     * Compute the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     * {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the given
     * normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)}
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)}
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)}
     * @return the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     *        {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the
     *        given normal
     */
    double orientedAngle(double otherX, double otherY, double otherZ, double normalX, double normalY, double normalZ);

    /**
     * Compute the outer product of this vector and {@code row} and store the result in
     * {@code dest}.
     *
     * @param row the row vector (right operand)
     * @param dest will hold the result
     * @return dest
     */
    Double3x3 outerProduct(Double3R row, @Mutated Double3x3 dest);

    /**
     * Compute the outer product of this vector and ({@code x}, {@code y}, {@code z}) and store the
     * result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3x3 outerProduct(double x, double y, double z, @Mutated Double3x3 dest);

    /**
     * Compute a vector perpendicular to this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 perpendicular(@Mutated Double3 dest);

    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    Double3 pow(double exponent, @Mutated Double3 dest);

    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    Double3 pow(Double3R exponent, @Mutated Double3 dest);

    /**
     * Raise each component of this vector to the power of ({@code x}, {@code y}, {@code z}) and
     * store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 pow(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Project this vector onto {@code onto} and store the result in {@code dest}.
     *
     * @param onto the vector to project onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 project(Double3R onto, @Mutated Double3 dest);

    /**
     * Project this vector onto ({@code x}, {@code y}, {@code z}) and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 project(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double3 projectOnPlane(Double3R normal, @Mutated Double3 dest);

    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param dest will hold the result
     * @return dest
     */
    Double3 projectOnPlane(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the value converted from degrees to radians of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 radians(@Mutated Double3 dest);

    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double3 reflect(Double3R normal, @Mutated Double3 dest);

    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param dest will hold the result
     * @return dest
     */
    Double3 reflect(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @param dest will hold the result
     * @return dest
     */
    Double3 refract(Double3R normal, double eta, @Mutated Double3 dest);

    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @param dest will hold the result
     * @return dest
     */
    Double3 refract(double x, double y, double z, double eta, @Mutated Double3 dest);

    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 round(@Mutated Double3 dest);

    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 sign(@Mutated Double3 dest);

    /**
     * Compute the sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 sin(@Mutated Double3 dest);

    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 sinh(@Mutated Double3 dest);

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    Double3 smoothstep(double edge0, double edge1, @Mutated Double3 dest);

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    Double3 smoothstep(Double3R edge0, Double3R edge1, @Mutated Double3 dest);

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}) and the upper edge
     * ({@code edge1X}, {@code edge1Y}, {@code edge1Z}), yielding 0 at or below the lower edge and 1
     * at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 smoothstep(double edge0X, double edge0Y, double edge0Z, double edge1X, double edge1Y, double edge1Z, @Mutated Double3 dest);

    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 sqrt(@Mutated Double3 dest);

    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    Double3 step(double edge, @Mutated Double3 dest);

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    Double3 step(Double3R edge, @Mutated Double3 dest);

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 step(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 tan(@Mutated Double3 dest);

    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 tanh(@Mutated Double3 dest);

    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize((p1 - this) x (p2 - this))} - it points to the side from which the vertices
     * {@code this}, {@code p1}, {@code p2} appear counter-clockwise (a degenerate triangle yields
     * the zero vector) and store the result in {@code dest}.
     *
     * @param p1 the second vertex of the triangle (this vector is the first)
     * @param p2 the third vertex of the triangle
     * @param dest will hold the result
     * @return dest
     */
    Double3 triangleNormal(Double3R p1, Double3R p2, @Mutated Double3 dest);

    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize(((p1X, p1Y, p1Z) - this) x ((p2X, p2Y, p2Z) - this))} - it points to the
     * side from which the vertices {@code this}, ({@code p1X}, {@code p1Y}, {@code p1Z}),
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) appear counter-clockwise (a degenerate triangle
     * yields the zero vector) and store the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 triangleNormal(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, @Mutated Double3 dest);

    /**
     * Compute the truncated value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 trunc(@Mutated Double3 dest);

    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 ulp(@Mutated Double3 dest);

    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyz0(@Mutated Double4 dest);

    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyz1(@Mutated Double4 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this} and store the
     * result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMul(Double3x3R mat, @Mutated Double3 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMulDirection(Double3x4R mat, @Mutated Double3 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMulDirection(Double4x4R mat, @Mutated Double3 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMulPosition(Double3x4R mat, @Mutated Double3 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMulPosition(Double4x4R mat, @Mutated Double3 dest);

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w} and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double3 preMulProject(Double4x4R mat, @Mutated Double3 dest);

    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1} and
     * store the result in {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotate(DoubleQuatR quat, @Mutated Double3 dest);

    /**
     * Rotate this vector by the quaternion ({@code x}, {@code y}, {@code z}, {@code w}), i.e.
     * compute {@code q * this * q^-1} and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotate(double x, double y, double z, double w, @Mutated Double3 dest);

    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis} and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateAxis(double angle, Double3R axis, @Mutated Double3 dest);

    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code x}, {@code y}, {@code z})
     * and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateAxis(double angle, double x, double y, double z, @Mutated Double3 dest);

    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateInverse(DoubleQuatR quat, @Mutated Double3 dest);

    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateInverse(double x, double y, double z, double w, @Mutated Double3 dest);

    /**
     * Rotate this vector by {@code angle} radians about the X axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateX(double angle, @Mutated Double3 dest);

    /**
     * Rotate this vector by {@code angle} radians about the Y axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateY(double angle, @Mutated Double3 dest);

    /**
     * Rotate this vector by {@code angle} radians about the Z axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double3 rotateZ(double angle, @Mutated Double3 dest);
    /** {@return the value of the {@code x} component} */
    double x();
    /** {@return the value of the {@code y} component} */
    double y();
    /** {@return the value of the {@code z} component} */
    double z();

    /**
     * Swizzle: copy ({@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 xx(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 xy(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 xz(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 yx(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 yy(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 yz(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 zx(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 zy(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double2 zz(@Mutated Double2 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xxx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xxy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xxz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xyx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xyy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xyz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xzx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xzy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 xzz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yxx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yxy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yxz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yyx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yyy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yyz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yzx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yzy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 yzz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zxx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zxy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zxz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zyx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zyy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zyz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zzx(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zzy(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 zzz(@Mutated Double3 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code x}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xxzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code y}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xyzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code x}, {@code z}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 xzzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code x}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yxzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code y}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yyzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code y}, {@code z}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 yzzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code x}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zxzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code y}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zyzz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code x}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzxx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code x}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzxy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code x}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzxz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code y}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzyx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code y}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzyy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code y}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzyz(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code z}, {@code x}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzzx(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code z}, {@code y}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzzy(@Mutated Double4 dest);

    /**
     * Swizzle: copy ({@code z}, {@code z}, {@code z}, {@code z}) of this vector into {@code dest}, in that order.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4 zzzz(@Mutated Double4 dest);

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] store(@Mutated double[] dest) { return store(dest, 0); }

    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    double[] store(@Mutated double[] dest, int offset);

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer store(@Mutated DoubleBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeAbsolute(@Mutated DoubleBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 3);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer store(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeAbsolute(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 24);
        return dest;
    }

    /**
     * Store the elements into the given memory segment.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment store(@Mutated MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment store(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3 storeUnsafe(long address);

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] store(@Mutated float[] dest) { return store(dest, 0); }

    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    float[] store(@Mutated float[] dest, int offset);

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer store(@Mutated FloatBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeAbsolute(@Mutated FloatBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 3);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloat(@Mutated ByteBuffer dest) { return storeFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloatAbsolute(@Mutated ByteBuffer dest) { return storeFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeFloatAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloatRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeFloatAbsolute(pos, dest);
        dest.position(pos + 12);
        return dest;
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeFloat(@Mutated MemorySegment dest) { return storeFloat(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeFloat(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Double3 storeFloatUnsafe(long address);

    /** {@return whether all components of this vector are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this vector component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the vector to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(Double3R other, double epsilon);

    /**
     * Compare this vector with the given object for element-wise equality.
     * <p>
     * Each component is compared bitwise, as by {@code Double.doubleToLongBits}: {@code 0.0} and
     * {@code -0.0} are not equal, and NaN is equal to NaN. Use {@link #equalsEpsilon} for a
     * tolerant comparison.
     * <p>
     * Only instances of this library's implementation compare equal to each other; any other object
     * yields {@code false}.
     *
     * @param obj the object to compare with
     * @return {@code true} if {@code obj} is a vector of this library with element-wise equal
     *        components, {@code false} otherwise
     */
    boolean equals(@org.jspecify.annotations.Nullable Object obj);

    /**
     * Compute a hash code consistent with {@link #equals}: it is derived from the components via
     * {@code Double.doubleToLongBits} alone.
     *
     * @return the hash code of this vector
     */
    int hashCode();

    /** Backs {@code ZERO()}: defers the shared instance's
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final Double3R ZERO = Joml.double3(0, 0, 0);
    }
}
