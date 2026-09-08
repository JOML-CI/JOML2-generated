package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * A 3D vector of single-precision {@code float} components.
 * <p>
 * Extends the read-only view {@link Float3R} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface Float3 extends Float3R {

    /**
     * Add {@code other} to this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 add(Float3R other) { return add(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Add ({@code x}, {@code y}, {@code z}) to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 add(float x, float y, float z) { return add(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Divide each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 div(float scalar) { return div(scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Divide this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 div(Float3R other) { return div(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 div(float x, float y, float z) { return div(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return this
     */
    @Mutated default Float3 fma(float b, Float3R c) { return fma(b, c, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add ({@code x}, {@code y}, {@code z}),
     * i.e. compute {@code this * b + c} per component.
     *
     * @param b the factor to multiply this vector by
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 fma(float b, float x, float y, float z) { return fma(b, x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return this
     */
    @Mutated default Float3 fma(Float3R b, Float3R c) { return fma(b, c, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * b + c} per component.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return this
     */
    @Mutated default Float3 fma(float bX, float bY, float bZ, float cX, float cY, float cZ) { return fma(bX, bY, bZ, cX, cY, cZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 mul(float scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 mul(Float3R other) { return mul(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 mul(float x, float y, float z) { return mul(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Negate this vector.
     *
     * @return this
     */
    @Mutated default Float3 negate() { return negate(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Subtract {@code other} from this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 sub(Float3R other) { return sub(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Subtract ({@code x}, {@code y}, {@code z}) from this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 sub(float x, float y, float z) { return sub(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Float3 set(Float3R v);

    /**
     * Set this vector to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated Float3 set(float x, float y, float z);

    /**
     * Set this vector to {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated default Float3 set(float s) { return set(s, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Convert this vector to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double3} holding the result
     */
    default Double3 toDouble() { return toDouble(Joml.double3()); }

    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Byte3} holding the result
     */
    default Byte3 toByte() { return toByte(Joml.byte3()); }

    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Byte3} holding the result
     */
    default Byte3 toByte(RoundingMode mode) { return toByte(mode, Joml.byte3()); }

    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Short3} holding the result
     */
    default Short3 toShort() { return toShort(Joml.short3()); }

    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Short3} holding the result
     */
    default Short3 toShort(RoundingMode mode) { return toShort(mode, Joml.short3()); }

    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Int3} holding the result
     */
    default Int3 toInt() { return toInt(Joml.int3()); }

    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Int3} holding the result
     */
    default Int3 toInt(RoundingMode mode) { return toInt(mode, Joml.int3()); }

    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Long3} holding the result
     */
    default Long3 toLong() { return toLong(Joml.long3()); }

    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Long3} holding the result
     */
    default Long3 toLong(RoundingMode mode) { return toLong(mode, Joml.long3()); }

    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated Float3 makeZero();

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezier(Float3R p1, Float3R p2, Float3R p3, float t) { return bezier(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points.
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
     * @return this
     */
    @Mutated default Float3 bezier(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) { return bezier(p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezier2(Float3R p1, Float3R p2, float t) { return bezier2(p1, p2, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezier2(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) { return bezier2(p1X, p1Y, p1Z, p2X, p2Y, p2Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezier2Tangent(Float3R p1, Float3R p2, float t) { return bezier2Tangent(p1, p2, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezier2Tangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) { return bezier2Tangent(p1X, p1Y, p1Z, p2X, p2Y, p2Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 bezierTangent(Float3R p1, Float3R p2, Float3R p3, float t) { return bezierTangent(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}.
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
     * @return this
     */
    @Mutated default Float3 bezierTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) { return bezierTangent(p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 catmullRom(Float3R p1, Float3R p2, Float3R p3, float t) { return catmullRom(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points.
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
     * @return this
     */
    @Mutated default Float3 catmullRom(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) { return catmullRom(p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 catmullRomTangent(Float3R p1, Float3R p2, Float3R p3, float t) { return catmullRomTangent(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}.
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
     * @return this
     */
    @Mutated default Float3 catmullRomTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) { return catmullRomTangent(p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 hermite(Float3R t0, Float3R v1, Float3R t1, float t) { return hermite(t0, v1, t1, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation.
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
     * @return this
     */
    @Mutated default Float3 hermite(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) { return hermite(t0X, t0Y, t0Z, v1X, v1Y, v1Z, t1X, t1Y, t1Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 hermiteTangent(Float3R t0, Float3R v1, Float3R t1, float t) { return hermiteTangent(t0, v1, t1, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}.
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
     * @return this
     */
    @Mutated default Float3 hermiteTangent(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) { return hermiteTangent(t0X, t0Y, t0Z, v1X, v1Y, v1Z, t1X, t1Y, t1Z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 lerp(Float3R other, float t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Linearly interpolate between this vector and ({@code x}, {@code y}, {@code z}) using the
     * interpolation factor {@code t}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 lerp(float x, float y, float z, float t) { return lerp(x, y, z, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3 lerp(Float3R other, Float3R t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor ({@code tX}, {@code tY}, {@code tZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @return this
     */
    @Mutated default Float3 lerp(float otherX, float otherY, float otherZ, float tX, float tY, float tZ) { return lerp(otherX, otherY, otherZ, tX, tY, tZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the absolute value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 absolute() { return absolute(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the arc cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 acos() { return acos(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Add {@code b} scaled by {@code scalar} to this vector.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 addScaled(Float3R b, float scalar) { return addScaled(b, scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Add ({@code x}, {@code y}, {@code z}) scaled by {@code scalar} to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 addScaled(float x, float y, float z, float scalar) { return addScaled(x, y, z, scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Add {@code b} scaled by {@code c} to this vector.
     *
     * @param b the vector
     * @param c the vector
     * @return this
     */
    @Mutated default Float3 addScaled(Float3R b, Float3R c) { return addScaled(b, c, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by ({@code cX}, {@code cY}, {@code cZ}) to
     * this vector.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return this
     */
    @Mutated default Float3 addScaled(float bX, float bY, float bZ, float cX, float cY, float cZ) { return addScaled(bX, bY, bZ, cX, cY, cZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the arc sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 asin() { return asin(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the arc tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 atan() { return atan(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise arc tangent of this vector over {@code x}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return this
     */
    @Mutated default Float3 atan2(float x) { return atan2(x, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise arc tangent of this vector over {@code x}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return this
     */
    @Mutated default Float3 atan2(Float3R x) { return atan2(x, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise arc tangent of this vector over ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the value to take the arc tangent over (the denominator)
     *        {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 atan2(float x, float y, float z) { return atan2(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the cube root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 cbrt() { return cbrt(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the ceiling of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 ceil() { return ceil(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return this
     */
    @Mutated default Float3 clamp(float min, float max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return this
     */
    @Mutated default Float3 clamp(Float3R min, Float3R max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ}) and
     * ({@code maxX}, {@code maxY}, {@code maxZ}).
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @return this
     */
    @Mutated default Float3 clamp(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) { return clamp(minX, minY, minZ, maxX, maxY, maxZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set this vector to the point closest to it on the line segment between {@code lineStart} and
     * {@code lineEnd}.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @return this
     */
    @Mutated default Float3 closestPointOnLine(Float3R lineStart, Float3R lineEnd) { return closestPointOnLine(lineStart, lineEnd, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set this vector to the point closest to it on the line segment between ({@code lineStartX},
     * {@code lineStartY}, {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY},
     * {@code lineEndZ}).
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
     * @return this
     */
    @Mutated default Float3 closestPointOnLine(float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ) { return closestPointOnLine(lineStartX, lineStartY, lineStartZ, lineEndX, lineEndY, lineEndZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Copy the sign of {@code sign} onto each component of this vector.
     *
     * @param sign the value whose sign is copied
     * @return this
     */
    @Mutated default Float3 copySign(float sign) { return copySign(sign, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector.
     *
     * @param sign the value whose sign is copied
     * @return this
     */
    @Mutated default Float3 copySign(Float3R sign) { return copySign(sign, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Copy the sign of each component of ({@code x}, {@code y}, {@code z}) onto the corresponding
     * component of this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 copySign(float x, float y, float z) { return copySign(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 cos() { return cos(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the hyperbolic cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 cosh() { return cosh(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the cross product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 cross(Float3R other) { return cross(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the cross product of this vector and ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 cross(float x, float y, float z) { return cross(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the value converted from radians to degrees of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 degrees() { return degrees(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the base-e exponential of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 exp() { return exp(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the base-2 exponential of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 exp2() { return exp2(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the base-e exponential minus one of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 expm1() { return expm1(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref}.
     *
     * @param I the vector
     * @param Nref the vector
     * @return this
     */
    @Mutated default Float3 faceforward(Float3R I, Float3R Nref) { return faceforward(I, Nref, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ), (IX, IY, IZ))} is
     * negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}) as judged by the reference vector ({@code NrefX}, {@code NrefY},
     * {@code NrefZ}).
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @return this
     */
    @Mutated default Float3 faceforward(float IX, float IY, float IZ, float NrefX, float NrefY, float NrefZ) { return faceforward(IX, IY, IZ, NrefX, NrefY, NrefZ, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the floor of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 floor() { return floor(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the fractional part of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 fract() { return fract(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y}.
     *
     * @param y the other operand
     * @return this
     */
    @Mutated default Float3 hypot(float y) { return hypot(y, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y}.
     *
     * @param y the other operand
     * @return this
     */
    @Mutated default Float3 hypot(Float3R y) { return hypot(y, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the other operand {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 hypot(float x, float y, float z) { return hypot(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 inverse() { return inverse(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the inverse square root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 inverseSqrt() { return inverseSqrt(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the natural logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 log() { return log(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the base-10 logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 log10() { return log10(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the natural logarithm of one plus the value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 log1p() { return log1p(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the base-2 logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 log2() { return log2(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the larger of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 max(float scalar) { return max(scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 max(Float3R other) { return max(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 max(float x, float y, float z) { return max(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Float3 min(float scalar) { return min(scalar, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Float3 min(Float3R other) { return min(other, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 min(float x, float y, float z) { return min(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @return this
     */
    @Mutated default Float3 mod(float y) { return mod(y, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @return this
     */
    @Mutated default Float3 mod(Float3R y) { return mod(y, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code x}, {@code y}, {@code z}).
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the divisor {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 mod(float x, float y, float z) { return mod(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector.
     *
     * @return this
     */
    @Mutated default Float3 nextDown() { return nextDown(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector.
     *
     * @return this
     */
    @Mutated default Float3 nextUp() { return nextUp(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector). <p> The
     * squared length is formed at the component precision, so components whose squares overflow or
     * underflow that precision are out of domain: the result is the zero vector rather than a unit
     * vector. Rescale such inputs before normalizing (the threshold is around 1.8e19 for
     * {@code float} and 1.3e154 for {@code double}).
     *
     * @return this
     */
    @Mutated default Float3 normalize() { return normalize(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector).
     *
     * @param length the length to rescale to
     * @return this
     */
    @Mutated default Float3 normalizeMul(float length) { return normalizeMul(length, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set this vector to one of its perpendicular vectors.
     *
     * @return this
     */
    @Mutated default Float3 perpendicular() { return perpendicular(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Raise each component of this vector to the power of {@code exponent}.
     *
     * @param exponent the exponent
     * @return this
     */
    @Mutated default Float3 pow(float exponent) { return pow(exponent, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Raise each component of this vector to the power of {@code exponent}.
     *
     * @param exponent the exponent
     * @return this
     */
    @Mutated default Float3 pow(Float3R exponent) { return pow(exponent, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Raise each component of this vector to the power of ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 pow(float x, float y, float z) { return pow(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Project this vector onto {@code onto}.
     *
     * @param onto the vector to project onto
     * @return this
     */
    @Mutated default Float3 project(Float3R onto) { return project(onto, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Project this vector onto ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 project(float x, float y, float z) { return project(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Project this vector onto the plane with the given normal.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    @Mutated default Float3 projectOnPlane(Float3R normal) { return projectOnPlane(normal, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Project this vector onto the plane with the given normal.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default Float3 projectOnPlane(float x, float y, float z) { return projectOnPlane(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the value converted from degrees to radians of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 radians() { return radians(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Reflect this vector about the given normal.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    @Mutated default Float3 reflect(Float3R normal) { return reflect(normal, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Reflect this vector about the given normal.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default Float3 reflect(float x, float y, float z) { return reflect(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection).
     *
     * @param normal the normal (must be a unit vector)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return this
     */
    @Mutated default Float3 refract(Float3R normal, float eta) { return refract(normal, eta, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return this
     */
    @Mutated default Float3 refract(float x, float y, float z, float eta) { return refract(x, y, z, eta, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the rounded value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 round() { return round(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the sign of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 sign() { return sign(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 sin() { return sin(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the hyperbolic sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 sinh() { return sinh(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return this
     */
    @Mutated default Float3 smoothstep(float edge0, float edge1) { return smoothstep(edge0, edge1, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return this
     */
    @Mutated default Float3 smoothstep(Float3R edge0, Float3R edge1) { return smoothstep(edge0, edge1, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}) and the upper edge
     * ({@code edge1X}, {@code edge1Y}, {@code edge1Z}), yielding 0 at or below the lower edge and 1
     * at or above the upper edge.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @return this
     */
    @Mutated default Float3 smoothstep(float edge0X, float edge0Y, float edge0Z, float edge1X, float edge1Y, float edge1Z) { return smoothstep(edge0X, edge0Y, edge0Z, edge1X, edge1Y, edge1Z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the square root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 sqrt() { return sqrt(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise.
     *
     * @param edge the edge to compare each component against
     * @return this
     */
    @Mutated default Float3 step(float edge) { return step(edge, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise.
     *
     * @param edge the edge to compare each component against
     * @return this
     */
    @Mutated default Float3 step(Float3R edge) { return step(edge, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default Float3 step(float x, float y, float z) { return step(x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 tan() { return tan(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the hyperbolic tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 tanh() { return tanh(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the normal of the triangle spanned by this vector and the two given points.
     *
     * @param p1 the vector
     * @param p2 the vector
     * @return this
     */
    @Mutated default Float3 triangleNormal(Float3R p1, Float3R p2) { return triangleNormal(p1, p2, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the normal of the triangle spanned by this vector and the two given points.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @return this
     */
    @Mutated default Float3 triangleNormal(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z) { return triangleNormal(p1X, p1Y, p1Z, p2X, p2Y, p2Z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the truncated value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 trunc() { return trunc(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Compute the unit in the last place (ulp) of each component of this vector.
     *
     * @return this
     */
    @Mutated default Float3 ulp() { return ulp(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMul(Float3x3R mat) { return preMul(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMulDirection(Float3x4R mat) { return preMulDirection(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMulDirection(Float4x4R mat) { return preMulDirection(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMulPosition(Float3x4R mat) { return preMulPosition(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMulPosition(Float4x4R mat) { return preMulPosition(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w}.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Float3 preMulProject(Float4x4R mat) { return preMulProject(mat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated default Float3 rotate(FloatQuatR quat) { return rotate(quat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by the quaternion ({@code x}, {@code y}, {@code z}, {@code w}), i.e.
     * compute {@code q * this * q^-1}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @return this
     */
    @Mutated default Float3 rotate(float x, float y, float z, float w) { return rotate(x, y, z, w, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated default Float3 rotateAxis(float angle, Float3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}).
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default Float3 rotateAxis(float angle, float x, float y, float z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by the inverse of the given rotation.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated default Float3 rotateInverse(FloatQuatR quat) { return rotateInverse(quat, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by the inverse of the given rotation.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @return this
     */
    @Mutated default Float3 rotateInverse(float x, float y, float z, float w) { return rotateInverse(x, y, z, w, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3 rotateX(float angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3 rotateY(float angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Rotate this vector by {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3 rotateZ(float angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xxx() { return xxx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xxy() { return xxy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xxz() { return xxz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xyx() { return xyx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xyy() { return xyy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xyz() { return xyz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code z}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xzx() { return xzx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code z}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xzy() { return xzy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code z}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 xzz() { return xzz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yxx() { return yxx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yxy() { return yxy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yxz() { return yxz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yyx() { return yyx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yyy() { return yyy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yyz() { return yyz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code z}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yzx() { return yzx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code z}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yzy() { return yzy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code z}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 yzz() { return yzz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zxx() { return zxx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zxy() { return zxy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code x}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zxz() { return zxz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zyx() { return zyx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zyy() { return zyy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code y}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zyz() { return zyz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code z}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zzx() { return zzx(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code z}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zzy() { return zzy(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code z}, {@code z}, {@code z}), in place.
     *
     * @return this
     */
    @Mutated default Float3 zzz() { return zzz(Joml.RETURN_NEW ? Joml.float3() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3 load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3 load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3 loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 3);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3 loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 12);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default Float3 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated Float3 load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3 loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3 load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3 load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3 loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3 loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 3);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 loadDouble(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 loadDoubleAbsolute(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3 loadDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3 loadDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadDoubleAbsolute(pos, src);
        src.position(pos + 24);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default Float3 loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated Float3 loadDouble(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3 loadDoubleUnsafe(long address);
}
