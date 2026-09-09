package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * A 3x4 matrix of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link Double3x4R} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Double.doubleToLongBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
 * NaN; the cached structural property bits are ignored, so two matrix objects holding the same
 * elements are equal whatever either one has determined about itself. {@code hashCode} is
 * consistent with it (derived from the same bit patterns). Only instances of this library's
 * implementation compare equal to each other; the {@code equals} of a matrix never returns
 * {@code true} for an object of another type.
 * <p>
 * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
 * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and a
 * NaN component never compares equal to anything.
 */
public interface Double3x4 extends Double3x4R {

    /**
     * Invert this affine matrix, i.e. compute the inverse of the implied square homogeneous matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 invert() { return invert(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 invertProduct(Double3x4R other) { return invertProduct(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}).
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 invertProduct(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return invertProduct(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 add(Double3x4R other) { return add(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) to this matrix.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 add(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return add(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Negate this matrix.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 negate() { return negate(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 sub(Double3x4R other) { return sub(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}) from this
     * matrix.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 sub(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return sub(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated Double3x4 set(Double3x4R v);

    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this
     */
    @Mutated Double3x4 set(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23);

    /**
     * Set this matrix to the given 3x3 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Double3x4 set(Double3x3R m);

    /**
     * Set this matrix to the given 4x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Double3x4 set(Double4x4R m);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param t the translation offsets
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 withTranslation(Double3R t) { return withTranslation(t, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 withTranslation(double x, double y, double z) { return withTranslation(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Convert this matrix to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code Float3x4} holding the result
     */
    default Float3x4 toFloat() { return toFloat(Joml.float3x4()); }

    /**
     * Set this matrix to the given rigid transform's {@code T * R} composition.
     *
     * @param r the rigid transform (whose rotation must be a unit quaternion)
     * @return this
     */
    @Mutated Double3x4 makeFromRigid(DoubleRigidR r);

    /**
     * Set this matrix to the given rigid transform's {@code T * R} composition.
     *
     * @param tX the {@code tX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param tY the {@code tY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param tZ the {@code tZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param rX the {@code rX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the rotation quaternion must have unit length)
     * @param rY the {@code rY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the rotation quaternion must have unit length)
     * @param rZ the {@code rZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the rotation quaternion must have unit length)
     * @param rW the {@code rW} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the rotation quaternion must have unit length)
     * @return this
     */
    @Mutated Double3x4 makeFromRigid(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW);

    /**
     * Set this matrix to the given transform's {@code T * R * S} composition.
     *
     * @param t the transform
     * @return this
     */
    @Mutated Double3x4 makeFromTransform(DoubleTransformR t);

    /**
     * Set this matrix to the given transform's {@code T * R * S} composition.
     *
     * @param tX the {@code tX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param tY the {@code tY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param tZ the {@code tZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rX the {@code rX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rY the {@code rY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rZ the {@code rZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rW the {@code rW} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sX the {@code sX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sY the {@code sY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sZ the {@code sZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @return this
     */
    @Mutated Double3x4 makeFromTransform(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW, double sX, double sY, double sZ);

    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated Double3x4 makeIdentity();

    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lerp(Double3x4R other, double t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}) using the interpolation factor {@code t}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lerp(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23, double t) { return lerp(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, t, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mul(Double3x4R right) { return mul(right, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10},
     * {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}).
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * Both operands are identity-extended to this matrix's square size for the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mul(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return mul(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mul(Double2x2R right) { return mul(right, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mul(Double2x3R right) { return mul(right, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mul(Double3x3R right) { return mul(right, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the transformation {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preMul(Double3x4R other) { return preMul(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m03},
     * {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22},
     * {@code m23}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m03 the element in row 0, column 3 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m13 the element in row 1, column 3 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param m23 the element in row 2, column 3 of the matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preMul(double m00, double m01, double m02, double m03, double m10, double m11, double m12, double m13, double m20, double m21, double m22, double m23) { return preMul(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preMul(Double2x2R other) { return preMul(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preMul(Double2x3R other) { return preMul(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preMul(Double3x3R other) { return preMul(other, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @return this
     */
    @Mutated Double3x4 composeTRS(Double3R translation, DoubleQuatR rotation, Double3R scale);

    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
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
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @return this
     */
    @Mutated Double3x4 composeTRS(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ);

    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale
     * (applied in scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translation the vector
     * @param rotation the quaternion (must be a unit quaternion)
     * @param scale the scale factor
     * @param m the matrix
     * @return this
     */
    @Mutated Double3x4 composeTRSMul(Double3R translation, DoubleQuatR rotation, Double3R scale, Double3x4R m);

    /**
     * Set this matrix to a transformation composed of the given translation, rotation and scale
     * (applied in scale-rotation-translation order), post-multiplied by the given matrix.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
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
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param m the matrix
     * @return this
     */
    @Mutated Double3x4 composeTRSMul(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ, Double3x4R m);

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAlong(Double3R dir, Double3R up) { return lookAlong(dir, up, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) { return lookAlong(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAt(Double3R eye, Double3R center, Double3R up, Handedness handedness) { return lookAt(eye, center, up, handedness, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Handedness handedness) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, handedness, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAt(Double3R eye, Double3R center, Double3R up) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 lookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Set this matrix to a cylindrical billboard transformation that rotates about the given axis
     * to face the camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up" (must be a unit vector)
     * @return this
     */
    @Mutated Double3x4 makeBillboardCylindrical(Double3R objPos, Double3R targetPos, Double3R up);

    /**
     * Set this matrix to a cylindrical billboard transformation that rotates about the given axis
     * to face the camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)} (the vector must
     *        have unit length)
     * @return this
     */
    @Mutated Double3x4 makeBillboardCylindrical(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ);

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up"
     * @return this
     */
    @Mutated Double3x4 makeBillboardSpherical(Double3R objPos, Double3R targetPos, Double3R up);

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated Double3x4 makeBillboardSpherical(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ);

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     * <p>
     * Alias for {@code makeBillboardSpherical}.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @param up the direction of "up"
     * @return this
     */
    @Mutated default Double3x4 targetTo(Double3R objPos, Double3R targetPos, Double3R up) { return makeBillboardSpherical(objPos, targetPos, up); }

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera.
     * <p>
     * Alias for {@code makeBillboardSpherical}.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated default Double3x4 targetTo(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) { return makeBillboardSpherical(objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ); }

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera, using the
     * rotation of shortest arc.
     *
     * @param objPos the position of the object to orient
     * @param targetPos the position to face (e.g. the camera position)
     * @return this
     */
    @Mutated Double3x4 makeBillboardSphericalShortest(Double3R objPos, Double3R targetPos);

    /**
     * Set this matrix to a spherical billboard transformation that faces the camera, using the
     * rotation of shortest arc.
     *
     * @param objPosX the {@code x} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosY the {@code y} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param objPosZ the {@code z} component of the vector {@code (objPosX, objPosY, objPosZ)}
     * @param targetPosX the {@code x} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosY the {@code y} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @param targetPosZ the {@code z} component of the vector
     *        {@code (targetPosX, targetPosY, targetPosZ)}
     * @return this
     */
    @Mutated Double3x4 makeBillboardSphericalShortest(double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ);

    /**
     * Set this matrix to the rigid transformation represented by the unit dual quaternion
     * {@code dq}.
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return this
     */
    @Mutated Double3x4 makeFromDualQuat(DoubleDualQuatR dq);

    /**
     * Set this matrix to the rigid transformation represented by the unit dual quaternion
     * ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ},
     * {@code dW}).
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the real part must have unit length)
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the real part must have unit length)
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the real part must have unit length)
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the real part must have unit length)
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated Double3x4 makeFromDualQuat(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW);

    /**
     * Set this matrix to a "look at" view transformation with the eye at {@code eye} looking at
     * {@code center}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated Double3x4 makeLookAt(Double3R eye, Double3R center, Double3R up, Handedness handedness);

    /**
     * Set this matrix to a "look at" view transformation with the eye at ({@code eyeX},
     * {@code eyeY}, {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param handedness the handedness of the coordinate system to map into
     * @return this
     */
    @Mutated Double3x4 makeLookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ, Handedness handedness);

    /**
     * Set this matrix to a "look at" view transformation with the eye at {@code eye} looking at
     * {@code center}.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @return this
     */
    @Mutated default Double3x4 makeLookAt(Double3R eye, Double3R center, Double3R up) { return makeLookAt(eye, center, up, Handedness.RIGHT_HANDED); }

    /**
     * Set this matrix to a "look at" view transformation with the eye at ({@code eyeX},
     * {@code eyeY}, {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}).
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param eyeX the {@code x} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeY the {@code y} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param eyeZ the {@code z} component of the vector {@code (eyeX, eyeY, eyeZ)}
     * @param centerX the {@code x} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerY the {@code y} component of the vector {@code (centerX, centerY, centerZ)}
     * @param centerZ the {@code z} component of the vector {@code (centerX, centerY, centerZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated default Double3x4 makeLookAt(double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) { return makeLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED); }

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +y, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXYZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +y, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXYnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +z, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXZY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, +z, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXZnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -y, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXnYZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -y, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXnYnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -z, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXnZY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+x, -z, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingXnZnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +x, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYXZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +x, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYXnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +z, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYZX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, +z, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYZnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -x, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYnXZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -x, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYnXnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -z, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYnZX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+y, -z, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingYnZnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +x, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZXY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +x, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZXnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +y, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZYX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, +y, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZYnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -x, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZnXY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -x, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZnXnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -y, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZnYX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (+z, -y, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingZnYnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +y, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXYZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +y, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXYnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +z, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXZY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, +z, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXZnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -y, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXnYZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -y, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXnYnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -z, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXnZY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-x, -z, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnXnZnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +x, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYXZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +x, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYXnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +z, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYZX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, +z, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYZnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -x, +z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYnXZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -x, -z)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYnXnZ();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -z, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYnZX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-y, -z, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnYnZnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +x, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZXY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +x, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZXnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +y, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZYX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, +y, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZYnX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -x, +y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZnXY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -x, -y)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZnXnY();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -y, +x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZnYX();

    /**
     * Set this matrix to a transformation that maps the axes {@code (x, y, z)} to
     * {@code (-z, -y, -x)}.
     *
     * @return this
     */
    @Mutated Double3x4 makeMappingnZnYnX();

    /**
     * Set this matrix to a reflection transformation about the plane through the origin with the
     * normal {@code normal}.
     *
     * @param normal the normal (must be a unit vector)
     * @return this
     */
    @Mutated Double3x4 makeReflection(Double3R normal);

    /**
     * Set this matrix to a reflection transformation about the plane through the origin with the
     * normal ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated Double3x4 makeReflection(double x, double y, double z);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated Double3x4 makeRotationAxis(double angle, Double3R axis);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis ({@code x}, {@code y},
     * {@code z}).
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
    @Mutated Double3x4 makeRotationAxis(double angle, double x, double y, double z);

    /**
     * Set this matrix to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated Double3x4 makeRotationLookAlong(Double3R dir, Double3R up);

    /**
     * Set this matrix to a rotation that makes {@code +z} point along ({@code dirX}, {@code dirY},
     * {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated Double3x4 makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ);

    /**
     * Set this matrix to the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated Double3x4 makeRotationQuat(DoubleQuatR q);

    /**
     * Set this matrix to the rotation represented by the quaternion ({@code x}, {@code y},
     * {@code z}, {@code w}).
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
    @Mutated Double3x4 makeRotationQuat(double x, double y, double z, double w);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Double3x4 makeRotationX(double angle);

    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians
     * about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a
     * vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationXYZ(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians
     * about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a
     * vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationXZY(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Double3x4 makeRotationY(double angle);

    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians
     * about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a
     * vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationYXZ(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians
     * about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a
     * vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationYZX(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Double3x4 makeRotationZ(double angle);

    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians
     * about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a
     * vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationZXY(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians
     * about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a
     * vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Double3x4 makeRotationZYX(double angleX, double angleY, double angleZ);

    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Double3x4 makeScaling(Double3R v);

    /**
     * Set this matrix to a scaling transformation that scales by ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated Double3x4 makeScaling(double x, double y, double z);

    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated Double3x4 makeScaling(double s);

    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    @Mutated Double3x4 makeTranslation(Double3R v);

    /**
     * Set this matrix to a translation transformation that translates by ({@code x}, {@code y},
     * {@code z}).
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @return this
     */
    @Mutated Double3x4 makeTranslation(double x, double y, double z);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXYZ() { return mapXYZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXYnZ() { return mapXYnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXZY() { return mapXZY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXZnY() { return mapXZnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXnYZ() { return mapXnYZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXnYnZ() { return mapXnYnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXnZY() { return mapXnZY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapXnZnY() { return mapXnZnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYXZ() { return mapYXZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYXnZ() { return mapYXnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYZX() { return mapYZX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYZnX() { return mapYZnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYnXZ() { return mapYnXZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYnXnZ() { return mapYnXnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYnZX() { return mapYnZX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapYnZnX() { return mapYnZnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZXY() { return mapZXY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZXnY() { return mapZXnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZYX() { return mapZYX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZYnX() { return mapZYnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZnXY() { return mapZnXY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZnXnY() { return mapZnXnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZnYX() { return mapZnYX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapZnYnX() { return mapZnYnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXYZ() { return mapnXYZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXYnZ() { return mapnXYnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXZY() { return mapnXZY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXZnY() { return mapnXZnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXnYZ() { return mapnXnYZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXnYnZ() { return mapnXnYnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXnZY() { return mapnXnZY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnXnZnY() { return mapnXnZnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYXZ() { return mapnYXZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYXnZ() { return mapnYXnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYZX() { return mapnYZX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYZnX() { return mapnYZnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYnXZ() { return mapnYnXZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYnXnZ() { return mapnYnXnZ(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYnZX() { return mapnYnZX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnYnZnX() { return mapnYnZnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZXY() { return mapnZXY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZXnY() { return mapnZXnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZYX() { return mapnZYX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZYnX() { return mapnZYnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZnXY() { return mapnZnXY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZnXnY() { return mapnZnXnY(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZnYX() { return mapnZnYX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 mapnZnYnX() { return mapnZnYnX(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateAround(DoubleQuatR rot, Double3R pivot) { return preRotateAround(rot, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) { return preRotateAround(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateAxis(double angle, Double3R axis) { return preRotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code x}, {@code y},
     * {@code z}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateAxis(double angle, double x, double y, double z) { return preRotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateQuat(DoubleQuatR q) { return preRotateQuat(q, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z},
     * {@code w}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateQuat(double x, double y, double z, double w) { return preRotateQuat(x, y, z, w, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateX(double angle) { return preRotateX(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateY(double angle) { return preRotateY(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preRotateZ(double angle) { return preRotateZ(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScale(Double3R v) { return preScale(v, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by ({@code x}, {@code y}, {@code z}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScale(double x, double y, double z) { return preScale(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by {@code s} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScale(double s) { return preScale(s, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScaleAround(double s, Double3R pivot) { return preScaleAround(s, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z})
     * onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScaleAround(double s, double x, double y, double z) { return preScaleAround(s, x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScaleAround(Double3R s, Double3R pivot) { return preScaleAround(s, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preScaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) { return preScaleAround(sX, sY, sZ, pivotX, pivotY, pivotZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a translation by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preTranslate(Double3R v) { return preTranslate(v, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Pre-multiply a translation by ({@code x}, {@code y}, {@code z}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 preTranslate(double x, double y, double z) { return preTranslate(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normal the normal (must be a unit vector)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 reflect(Double3R normal) { return reflect(normal, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a reflection about the plane through the origin with the normal ({@code x}, {@code y},
     * {@code z}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 reflect(double x, double y, double z) { return reflect(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateAround(DoubleQuatR rot, Double3R pivot) { return rotateAround(rot, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     *
     * @param rotX the {@code x} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotY the {@code y} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotZ the {@code z} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param rotW the {@code w} component of the quaternion {@code (rotX, rotY, rotZ, rotW)} (the
     *        quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateAround(double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) { return rotateAround(rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateAxis(double angle, Double3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateAxis(double angle, double x, double y, double z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateQuat(DoubleQuatR q) { return rotateQuat(q, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z}, {@code w})
     * to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateQuat(double x, double y, double z, double w) { return rotateQuat(x, y, z, w, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateX(double angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateX180() { return rotateX180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateX270() { return rotateX270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateX90() { return rotateX90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateXYZ(double angleX, double angleY, double angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateXZY(double angleX, double angleY, double angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateXn180() { return rotateXn180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateXn270() { return rotateXn270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateXn90() { return rotateXn90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateY(double angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateY180() { return rotateY180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateY270() { return rotateY270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateY90() { return rotateY90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateYXZ(double angleX, double angleY, double angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateYZX(double angleX, double angleY, double angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateYn180() { return rotateYn180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateYn270() { return rotateYn270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateYn90() { return rotateYn90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZ(double angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZ180() { return rotateZ180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZ270() { return rotateZ270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZ90() { return rotateZ90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZXY(double angleX, double angleY, double angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZYX(double angleX, double angleY, double angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZn180() { return rotateZn180(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZn270() { return rotateZn270(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 rotateZn90() { return rotateZn90(Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scale(Double3R v) { return scale(v, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by ({@code x}, {@code y}, {@code z}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scale(double x, double y, double z) { return scale(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by {@code s} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scale(double s) { return scale(s, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scaleAround(double s, Double3R pivot) { return scaleAround(s, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z}) to this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scaleAround(double s, double x, double y, double z) { return scaleAround(s, x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scaleAround(Double3R s, Double3R pivot) { return scaleAround(s, pivot, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 scaleAround(double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) { return scaleAround(sX, sY, sZ, pivotX, pivotY, pivotZ, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a translation by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 translate(Double3R v) { return translate(v, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Apply a translation by ({@code x}, {@code y}, {@code z}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @return this (a new instance when {@code Joml.RETURN_NEW} is enabled)
     */
    @Mutated default Double3x4 translate(double x, double y, double z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.double3x4() : this); }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 loadCM(double[] src) { return loadCM(src, 0); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double3x4 loadCM(double[] src, int offset);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCM(DoubleBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMAbsolute(DoubleBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(DoubleBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 12);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCM(ByteBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMAbsolute(ByteBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(ByteBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 96);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadCMUnsafe(long address);

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 loadCM(float[] src) { return loadCM(src, 0); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double3x4 loadCM(float[] src, int offset);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCM(FloatBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMAbsolute(FloatBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(FloatBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 12);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMFloat(ByteBuffer src) { return loadCMFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMFloatAbsolute(ByteBuffer src) { return loadCMFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at the given absolute index (the position is not used or
     * modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double3x4 loadCMFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadCMFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadCMFloatAbsolute(pos, src);
        src.position(pos + 48);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadCMFloatUnsafe(long address);

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 loadRM(double[] src) { return loadRM(src, 0); }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double3x4 loadRM(double[] src, int offset);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRM(DoubleBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMAbsolute(DoubleBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(DoubleBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 12);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRM(ByteBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMAbsolute(ByteBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(ByteBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 96);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadRMUnsafe(long address);

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 loadRM(float[] src) { return loadRM(src, 0); }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Double3x4 loadRM(float[] src, int offset);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRM(FloatBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMAbsolute(FloatBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(FloatBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 12);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMFloat(ByteBuffer src) { return loadRMFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMFloatAbsolute(ByteBuffer src) { return loadRMFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Double3x4 loadRMFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRMFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadRMFloatAbsolute(pos, src);
        src.position(pos + 48);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadRMFloatUnsafe(long address);

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCM(double[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCM(DoubleBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, DoubleBuffer src, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(DoubleBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + 4 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCM(ByteBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + (4 * stride) * 8);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadCMUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCM(float[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCM(FloatBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCMAbsolute(int index, FloatBuffer src, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCMRelative(FloatBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + 4 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCMFloat(ByteBuffer src, int stride) { return loadCMFloatAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadCMFloatAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code float}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadCMFloatRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadCMFloatAbsolute(pos, src, stride);
        src.position(pos + (4 * stride) * 4);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code float}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadCMFloatUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRM(double[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRM(DoubleBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, DoubleBuffer src, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(DoubleBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRM(ByteBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 8);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadRMUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRM(float[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRM(FloatBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRMAbsolute(int index, FloatBuffer src, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRMRelative(FloatBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRMFloat(ByteBuffer src, int stride) { return loadRMFloatAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Double3x4 loadRMFloatAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code float}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRMFloatRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadRMFloatAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 4);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code float}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated Double3x4 loadRMFloatUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 load(double[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated default Double3x4 load(double[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 load(DoubleBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 load(int index, DoubleBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRelative(DoubleBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code float}.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Double3x4 load(float[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code float}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated default Double3x4 load(float[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code float}, starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 load(FloatBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code float}, starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 load(int index, FloatBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code float}, starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Double3x4 loadRelative(FloatBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 load(ByteBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 load(int index, ByteBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Double3x4 loadRelative(ByteBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated default Double3x4 loadUnsafe(long address) { return loadCMUnsafe(address); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 load(double[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code float}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 load(float[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 load(int index, DoubleBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRelative(DoubleBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code float}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 load(int index, FloatBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code float}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRelative(FloatBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 load(int index, ByteBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers are not bounds-checked; the API backend
     * goes through the buffer's own {@code get}/{@code put} methods and performs the standard
     * checks.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Double3x4 loadRelative(ByteBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     * @throws UnsupportedOperationException if the API store/load backend is active (JDK 9 / JDK 17
     *        variants only)
     */
    @Mutated default Double3x4 loadUnsafe(long address, int stride) { return loadCMUnsafe(address, stride); }
}
