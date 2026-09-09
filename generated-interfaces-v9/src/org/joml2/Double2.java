package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * A 2D vector of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link Double2R} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface Double2 extends Double2R {

    /**
     * Add {@code other} to this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 add(Double2R other) { return add(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Add ({@code x}, {@code y}) to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 add(double x, double y) { return add(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Divide each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 div(double scalar) { return div(scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Divide this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 div(Double2R other) { return div(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Divide this vector component-wise by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 div(double x, double y) { return div(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return this
     */
    @Mutated default Double2 fma(double b, Double2R c) { return fma(b, c, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add ({@code x}, {@code y}), i.e. compute
     * {@code this * b + (x, y)} per component.
     *
     * @param b the factor to multiply this vector by
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 fma(double b, double x, double y) { return fma(b, x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return this
     */
    @Mutated default Double2 fma(Double2R b, Double2R c) { return fma(b, c, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}) and add ({@code cX},
     * {@code cY}), i.e. compute {@code this * (bX, bY) + (cX, cY)} per component.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY)}
     * @param bY the {@code y} component of the vector {@code (bX, bY)}
     * @param cX the {@code x} component of the vector {@code (cX, cY)}
     * @param cY the {@code y} component of the vector {@code (cX, cY)}
     * @return this
     */
    @Mutated default Double2 fma(double bX, double bY, double cX, double cY) { return fma(bX, bY, cX, cY, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply each component of this vector by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 mul(double scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 mul(Double2R other) { return mul(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Multiply this vector component-wise by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 mul(double x, double y) { return mul(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Negate this vector.
     *
     * @return this
     */
    @Mutated default Double2 negate() { return negate(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Subtract {@code other} from this vector.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 sub(Double2R other) { return sub(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Subtract ({@code x}, {@code y}) from this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 sub(double x, double y) { return sub(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Double2 set(Double2R v);

    /**
     * Set this vector to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated Double2 set(double x, double y);

    /**
     * Set this vector to {@code s}.
     *
     * @param s the value assigned to every component
     * @return this
     */
    @Mutated default Double2 set(double s) { return set(s, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Convert this vector to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code Float2} holding the result
     */
    default Float2 toFloat() { return toFloat(Joml.float2()); }

    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Byte2} holding the result
     */
    default Byte2 toByte() { return toByte(Joml.byte2()); }

    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Byte2} holding the result
     */
    default Byte2 toByte(RoundingMode mode) { return toByte(mode, Joml.byte2()); }

    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Short2} holding the result
     */
    default Short2 toShort() { return toShort(Joml.short2()); }

    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Short2} holding the result
     */
    default Short2 toShort(RoundingMode mode) { return toShort(mode, Joml.short2()); }

    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Int2} holding the result
     */
    default Int2 toInt() { return toInt(Joml.int2()); }

    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Int2} holding the result
     */
    default Int2 toInt(RoundingMode mode) { return toInt(mode, Joml.int2()); }

    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Long2} holding the result
     */
    default Long2 toLong() { return toLong(Joml.long2()); }

    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param mode the rounding mode to use
     * @return a new {@code Long2} holding the result
     */
    default Long2 toLong(RoundingMode mode) { return toLong(mode, Joml.long2()); }

    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated Double2 makeZero();

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier(Double2R p1, Double2R p2, Double2R p3, double t) { return bezier(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) { return bezier(p1X, p1Y, p2X, p2Y, p3X, p3Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier2(Double2R p1, Double2R p2, double t) { return bezier2(p1, p2, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier2(double p1X, double p1Y, double p2X, double p2Y, double t) { return bezier2(p1X, p1Y, p2X, p2Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier2Tangent(Double2R p1, Double2R p2, double t) { return bezier2Tangent(p1, p2, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezier2Tangent(double p1X, double p1Y, double p2X, double p2Y, double t) { return bezier2Tangent(p1X, p1Y, p2X, p2Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

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
    @Mutated default Double2 bezierTangent(Double2R p1, Double2R p2, Double2R p3, double t) { return bezierTangent(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 bezierTangent(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) { return bezierTangent(p1X, p1Y, p2X, p2Y, p3X, p3Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 catmullRom(Double2R p1, Double2R p2, Double2R p3, double t) { return catmullRom(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 catmullRom(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) { return catmullRom(p1X, p1Y, p2X, p2Y, p3X, p3Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

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
    @Mutated default Double2 catmullRomTangent(Double2R p1, Double2R p2, Double2R p3, double t) { return catmullRomTangent(p1, p2, p3, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 catmullRomTangent(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) { return catmullRomTangent(p1X, p1Y, p2X, p2Y, p3X, p3Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 hermite(Double2R t0, Double2R v1, Double2R t1, double t) { return hermite(t0, v1, t1, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 hermite(double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) { return hermite(t0X, t0Y, v1X, v1Y, t1X, t1Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

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
    @Mutated default Double2 hermiteTangent(Double2R t0, Double2R v1, Double2R t1, double t) { return hermiteTangent(t0, v1, t1, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 hermiteTangent(double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) { return hermiteTangent(t0X, t0Y, v1X, v1Y, t1X, t1Y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 lerp(Double2R other, double t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Linearly interpolate between this vector and ({@code x}, {@code y}) using the interpolation
     * factor {@code t}.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 lerp(double x, double y, double t) { return lerp(x, y, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Double2 lerp(Double2R other, Double2R t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}) using the
     * interpolation factor ({@code tX}, {@code tY}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param tX the {@code x} component of the vector {@code (tX, tY)}
     * @param tY the {@code y} component of the vector {@code (tX, tY)}
     * @return this
     */
    @Mutated default Double2 lerp(double otherX, double otherY, double tX, double tY) { return lerp(otherX, otherY, tX, tY, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the absolute value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 absolute() { return absolute(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the arc cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 acos() { return acos(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Add {@code b} scaled by {@code scalar} to this vector.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 addScaled(Double2R b, double scalar) { return addScaled(b, scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Add ({@code x}, {@code y}) scaled by {@code scalar} to this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 addScaled(double x, double y, double scalar) { return addScaled(x, y, scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Add {@code b} scaled by {@code c} to this vector.
     *
     * @param b the vector
     * @param c the vector
     * @return this
     */
    @Mutated default Double2 addScaled(Double2R b, Double2R c) { return addScaled(b, c, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Add ({@code bX}, {@code bY}) scaled by ({@code cX}, {@code cY}) to this vector.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY)}
     * @param bY the {@code y} component of the vector {@code (bX, bY)}
     * @param cX the {@code x} component of the vector {@code (cX, cY)}
     * @param cY the {@code y} component of the vector {@code (cX, cY)}
     * @return this
     */
    @Mutated default Double2 addScaled(double bX, double bY, double cX, double cY) { return addScaled(bX, bY, cX, cY, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the arc sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 asin() { return asin(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the arc tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 atan() { return atan(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator).
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return this
     */
    @Mutated default Double2 atan2(double x) { return atan2(x, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator).
     *
     * @param x the vector of denominators, one per component
     * @return this
     */
    @Mutated default Double2 atan2(Double2R x) { return atan2(x, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code x},
     * {@code y}) (the denominator).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 atan2(double x, double y) { return atan2(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the cube root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 cbrt() { return cbrt(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the ceiling of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 ceil() { return ceil(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return this
     */
    @Mutated default Double2 clamp(double min, double max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Clamp each component of this vector between {@code min} and {@code max}.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return this
     */
    @Mutated default Double2 clamp(Double2R min, Double2R max) { return clamp(min, max, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}).
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @return this
     */
    @Mutated default Double2 clamp(double minX, double minY, double maxX, double maxY) { return clamp(minX, minY, maxX, maxY, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Copy the sign of {@code sign} onto each component of this vector.
     *
     * @param sign the value whose sign is copied
     * @return this
     */
    @Mutated default Double2 copySign(double sign) { return copySign(sign, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector.
     *
     * @param sign the value whose sign is copied
     * @return this
     */
    @Mutated default Double2 copySign(Double2R sign) { return copySign(sign, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Copy the sign of each component of ({@code x}, {@code y}) onto the corresponding component of
     * this vector.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 copySign(double x, double y) { return copySign(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 cos() { return cos(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the hyperbolic cosine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 cosh() { return cosh(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the value converted from radians to degrees of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 degrees() { return degrees(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the base-e exponential of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 exp() { return exp(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the base-2 exponential of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 exp2() { return exp2(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the base-e exponential minus one of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 expm1() { return expm1(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref}.
     *
     * @param I the vector
     * @param Nref the vector
     * @return this
     */
    @Mutated default Double2 faceforward(Double2R I, Double2R Nref) { return faceforward(I, Nref, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY), (IX, IY))} is negative, and
     * negated otherwise - orienting it against the incident direction ({@code IX}, {@code IY}) as
     * judged by the reference vector ({@code NrefX}, {@code NrefY}).
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY)}
     * @param IY the {@code y} component of the vector {@code (IX, IY)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY)}
     * @return this
     */
    @Mutated default Double2 faceforward(double IX, double IY, double NrefX, double NrefY) { return faceforward(IX, IY, NrefX, NrefY, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the floor of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 floor() { return floor(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the fractional part of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 fract() { return fract(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y}.
     *
     * @param y the other operand
     * @return this
     */
    @Mutated default Double2 hypot(double y) { return hypot(y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y}.
     *
     * @param y the vector of other operands, one per component
     * @return this
     */
    @Mutated default Double2 hypot(Double2R y) { return hypot(y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 hypot(double x, double y) { return hypot(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 inverse() { return inverse(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the inverse square root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 inverseSqrt() { return inverseSqrt(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the natural logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 log() { return log(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the base-10 logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 log10() { return log10(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the natural logarithm of one plus the value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 log1p() { return log1p(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the base-2 logarithm of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 log2() { return log2(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the larger of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 max(double scalar) { return max(scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 max(Double2R other) { return max(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 max(double x, double y) { return max(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default Double2 min(double scalar) { return min(scalar, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}.
     *
     * @param other the other vector
     * @return this
     */
    @Mutated default Double2 min(Double2R other) { return min(other, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 min(double x, double y) { return min(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

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
    @Mutated default Double2 mod(double y) { return mod(y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the vector of divisors, one per component
     * @return this
     */
    @Mutated default Double2 mod(Double2R y) { return mod(y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code x}, {@code y}).
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 mod(double x, double y) { return mod(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector.
     *
     * @return this
     */
    @Mutated default Double2 nextDown() { return nextDown(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector.
     *
     * @return this
     */
    @Mutated default Double2 nextUp() { return nextUp(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector).
     * <p>
     * The squared length is formed at the component precision, so components whose squares overflow
     * or underflow that precision are out of domain: the result is the zero vector rather than a
     * unit vector. Rescale such inputs before normalizing (the threshold is around 1.8e19 for
     * {@code float} and 1.3e154 for {@code double}).
     *
     * @return this
     */
    @Mutated default Double2 normalize() { return normalize(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector).
     *
     * @param length the length to rescale to
     * @return this
     */
    @Mutated default Double2 normalizeMul(double length) { return normalizeMul(length, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Raise each component of this vector to the power of {@code exponent}.
     *
     * @param exponent the exponent
     * @return this
     */
    @Mutated default Double2 pow(double exponent) { return pow(exponent, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Raise each component of this vector to the power of {@code exponent}.
     *
     * @param exponent the exponent
     * @return this
     */
    @Mutated default Double2 pow(Double2R exponent) { return pow(exponent, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Raise each component of this vector to the power of ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 pow(double x, double y) { return pow(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Project this vector onto {@code onto}.
     *
     * @param onto the vector to project onto
     * @return this
     */
    @Mutated default Double2 project(Double2R onto) { return project(onto, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Project this vector onto ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 project(double x, double y) { return project(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Project this vector onto the plane with the given normal.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    @Mutated default Double2 projectOnPlane(Double2R normal) { return projectOnPlane(normal, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Project this vector onto the plane with the given normal.
     *
     * @param x the {@code x} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default Double2 projectOnPlane(double x, double y) { return projectOnPlane(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the value converted from degrees to radians of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 radians() { return radians(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Reflect this vector about the given normal.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    @Mutated default Double2 reflect(Double2R normal) { return reflect(normal, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Reflect this vector about the given normal.
     *
     * @param x the {@code x} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default Double2 reflect(double x, double y) { return reflect(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

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
    @Mutated default Double2 refract(Double2R normal, double eta) { return refract(normal, eta, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection).
     *
     * @param x the {@code x} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y)} (the vector must have unit
     *        length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return this
     */
    @Mutated default Double2 refract(double x, double y, double eta) { return refract(x, y, eta, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 round() { return round(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the sign of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 sign() { return sign(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 sin() { return sin(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the hyperbolic sine of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 sinh() { return sinh(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return this
     */
    @Mutated default Double2 smoothstep(double edge0, double edge1) { return smoothstep(edge0, edge1, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return this
     */
    @Mutated default Double2 smoothstep(Double2R edge0, Double2R edge1) { return smoothstep(edge0, edge1, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}) and the upper edge ({@code edge1X},
     * {@code edge1Y}), yielding 0 at or below the lower edge and 1 at or above the upper edge.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y)}
     * @return this
     */
    @Mutated default Double2 smoothstep(double edge0X, double edge0Y, double edge1X, double edge1Y) { return smoothstep(edge0X, edge0Y, edge1X, edge1Y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the square root of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 sqrt() { return sqrt(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise.
     *
     * @param edge the edge to compare each component against
     * @return this
     */
    @Mutated default Double2 step(double edge) { return step(edge, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise.
     *
     * @param edge the edge to compare each component against
     * @return this
     */
    @Mutated default Double2 step(Double2R edge) { return step(edge, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Double2 step(double x, double y) { return step(x, y, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 tan() { return tan(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the hyperbolic tangent of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 tanh() { return tanh(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the truncated value of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 trunc() { return trunc(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Compute the unit in the last place (ulp) of each component of this vector.
     *
     * @return this
     */
    @Mutated default Double2 ulp() { return ulp(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this}.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Double2 preMul(Double2x2R mat) { return preMul(mat, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Double2 preMulDirection(Double2x3R mat) { return preMulDirection(mat, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation.
     *
     * @param mat the matrix
     * @return this
     */
    @Mutated default Double2 preMulPosition(Double2x3R mat) { return preMulPosition(mat, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Rotate this vector counter-clockwise about the origin by {@code angle} radians.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Double2 rotate(double angle) { return rotate(angle, Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Double2 xx() { return xx(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code x}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Double2 xy() { return xy(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code x}), in place.
     *
     * @return this
     */
    @Mutated default Double2 yx() { return yx(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Swizzle: rearrange this vector's components to ({@code y}, {@code y}), in place.
     *
     * @return this
     */
    @Mutated default Double2 yy() { return yy(Joml.RETURN_NEW ? Joml.double2() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double2 load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double2 load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double2 loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double2 loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 16);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Double2 loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double2 load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double2 load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double2 loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double2 loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 2);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double2 loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double2 loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 8);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Double2 loadFloatUnsafe(long address);
}
