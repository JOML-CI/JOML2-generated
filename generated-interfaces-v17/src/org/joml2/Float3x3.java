package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;

/**
 * A 3x3 matrix of single-precision {@code float} components.
 * <p>
 * Extends the read-only view {@link Float3x3R} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface Float3x3 extends Float3x3R {

    /**
     * Compute the cofactor matrix of this matrix.
     *
     * @return this
     */
    @Mutated default Float3x3 cofactor() { return cofactor(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Invert this matrix.
     *
     * @return this
     */
    @Mutated default Float3x3 invert() { return invert(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1}.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated default Float3x3 invertProduct(Float3x3R other) { return invertProduct(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}).
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated default Float3x3 invertProduct(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return invertProduct(m00, m01, m02, m10, m11, m12, m20, m21, m22, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse.
     *
     * @return this
     */
    @Mutated default Float3x3 normal() { return normal(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Transpose this matrix.
     *
     * @return this
     */
    @Mutated default Float3x3 transpose() { return transpose(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Add {@code other} to this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated default Float3x3 add(Float3x3R other) { return add(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) to this matrix.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated default Float3x3 add(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return add(m00, m01, m02, m10, m11, m12, m20, m21, m22, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Negate this matrix.
     *
     * @return this
     */
    @Mutated default Float3x3 negate() { return negate(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Subtract {@code other} from this matrix.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated default Float3x3 sub(Float3x3R other) { return sub(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11}, {@code m12},
     * {@code m20}, {@code m21}, {@code m22}) from this matrix.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated default Float3x3 sub(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return sub(m00, m01, m02, m10, m11, m12, m20, m21, m22, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Set this matrix to the given values.
     *
     * @param v the matrix
     * @return this
     */
    @Mutated Float3x3 set(Float3x3R v);

    /**
     * Set this matrix to the given values.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated Float3x3 set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22);

    /**
     * Set this matrix to the given 2x2 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Float3x3 set(Float2x2R m);

    /**
     * Set this matrix to the given 2x3 matrix, copying the overlapping cells and filling the rest
     * with identity.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Float3x3 set(Float2x3R m);

    /**
     * Set this matrix to the given 3x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Float3x3 set(Float3x4R m);

    /**
     * Set this matrix to the given 4x4 matrix, copying the overlapping cells and dropping the rest.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated Float3x3 set(Float4x4R m);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param t the translation offsets
     * @return this
     */
    @Mutated default Float3x3 withTranslation(Float2R t) { return withTranslation(t, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first two elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y)}
     * @param y the {@code y} component of the translation offsets {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 withTranslation(float x, float y) { return withTranslation(x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Convert this matrix to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double3x3} holding the result
     */
    default Double3x3 toDouble() { return toDouble(Joml.double3x3()); }

    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
     *
     * @param r the rigid transform (must be a unit vector)
     * @return this
     */
    @Mutated Float3x3 makeFromRigid(FloatRigidR r);

    /**
     * Set this matrix to the given rigid transform's rotation block (the translation is dropped).
     *
     * @param tX the {@code tX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param tY the {@code tY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param tZ the {@code tZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param rX the {@code rX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param rY the {@code rY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param rZ the {@code rZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @param rW the {@code rW} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)} (the vector must have unit length)
     * @return this
     */
    @Mutated Float3x3 makeFromRigid(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW);

    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
     *
     * @param t the transform
     * @return this
     */
    @Mutated Float3x3 makeFromTransform(FloatTransformR t);

    /**
     * Set this matrix to the given transform's linear block {@code R * S} (the translation is
     * dropped).
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
    @Mutated Float3x3 makeFromTransform(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW, float sX, float sY, float sZ);

    /**
     * Set this matrix to the identity.
     *
     * @return this
     */
    @Mutated Float3x3 makeIdentity();

    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3x3 lerp(Float3x3R other, float t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m10}, {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) using the
     * interpolation factor {@code t}.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default Float3x3 lerp(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22, float t) { return lerp(m00, m01, m02, m10, m11, m12, m20, m21, m22, t, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Multiply this matrix by {@code right}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @return this
     */
    @Mutated default Float3x3 mul(Float3x3R right) { return mul(right, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m10}, {@code m11},
     * {@code m12}, {@code m20}, {@code m21}, {@code m22}).
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated default Float3x3 mul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return mul(m00, m01, m02, m10, m11, m12, m20, m21, m22, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 mul(Float2x2R right) { return mul(right, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 mul(Float2x3R right) { return mul(right, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply the transformation {@code other} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @return this
     */
    @Mutated default Float3x3 preMul(Float3x3R other) { return preMul(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m10},
     * {@code m11}, {@code m12}, {@code m20}, {@code m21}, {@code m22}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param m00 the element in row 0, column 0 of the matrix
     * @param m01 the element in row 0, column 1 of the matrix
     * @param m02 the element in row 0, column 2 of the matrix
     * @param m10 the element in row 1, column 0 of the matrix
     * @param m11 the element in row 1, column 1 of the matrix
     * @param m12 the element in row 1, column 2 of the matrix
     * @param m20 the element in row 2, column 0 of the matrix
     * @param m21 the element in row 2, column 1 of the matrix
     * @param m22 the element in row 2, column 2 of the matrix
     * @return this
     */
    @Mutated default Float3x3 preMul(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) { return preMul(m00, m01, m02, m10, m11, m12, m20, m21, m22, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 preMul(Float2x2R other) { return preMul(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 preMul(Float2x3R other) { return preMul(other, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Set this matrix to the outer product of {@code col} and {@code row}.
     *
     * @param col the column vector (left operand)
     * @param row the row vector (right operand)
     * @return this
     */
    @Mutated Float3x3 makeOuterProduct(Float3R col, Float3R row);

    /**
     * Set this matrix to the outer product of ({@code colX}, {@code colY}, {@code colZ}) and
     * ({@code rowX}, {@code rowY}, {@code rowZ}).
     *
     * @param colX the {@code x} component of the vector {@code (colX, colY, colZ)}
     * @param colY the {@code y} component of the vector {@code (colX, colY, colZ)}
     * @param colZ the {@code z} component of the vector {@code (colX, colY, colZ)}
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @return this
     */
    @Mutated Float3x3 makeOuterProduct(float colX, float colY, float colZ, float rowX, float rowY, float rowZ);

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated default Float3x3 lookAlong(Float3R dir, Float3R up) { return lookAlong(dir, up, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) { return lookAlong(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Set this matrix to the rotation part of the unit dual quaternion {@code dq} (the encoded
     * translation is dropped).
     *
     * @param dq the dual quaternion (must be a unit dual quaternion)
     * @return this
     */
    @Mutated Float3x3 makeFromDualQuat(FloatDualQuatR dq);

    /**
     * Set this matrix to the rotation part of the unit dual quaternion ({@code rX}, {@code rY},
     * {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ}, {@code dW}) (the encoded
     * translation is dropped).
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @return this
     */
    @Mutated Float3x3 makeFromDualQuat(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW);

    /**
     * Set this matrix to a rotation by {@code angle}.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Float3x3 makeRotation(float angle);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated Float3x3 makeRotationAxis(float angle, Float3R axis);

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
    @Mutated Float3x3 makeRotationAxis(float angle, float x, float y, float z);

    /**
     * Set this matrix to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated Float3x3 makeRotationLookAlong(Float3R dir, Float3R up);

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
    @Mutated Float3x3 makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ);

    /**
     * Set this matrix to the rotation represented by the quaternion {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated Float3x3 makeRotationQuat(FloatQuatR q);

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
    @Mutated Float3x3 makeRotationQuat(float x, float y, float z, float w);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Float3x3 makeRotationX(float angle);

    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians
     * about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationXYZ(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians
     * about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationXZY(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Float3x3 makeRotationY(float angle);

    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians
     * about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationYXZ(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians
     * about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationYZX(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated Float3x3 makeRotationZ(float angle);

    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians
     * about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationZXY(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians
     * about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated Float3x3 makeRotationZYX(float angleX, float angleY, float angleZ);

    /**
     * Set this matrix to a scaling transformation that scales by {@code v}.
     *
     * @param v the vector
     * @return this
     */
    @Mutated Float3x3 makeScaling(Float2R v);

    /**
     * Set this matrix to a scaling transformation that scales by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated Float3x3 makeScaling(float x, float y);

    /**
     * Set this matrix to a scaling transformation that scales by {@code s}.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated Float3x3 makeScaling(float s);

    /**
     * Set this matrix to a translation transformation that translates by {@code v}.
     *
     * @param v the translation offsets
     * @return this
     */
    @Mutated Float3x3 makeTranslation(Float2R v);

    /**
     * Set this matrix to a translation transformation that translates by ({@code x}, {@code y}).
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y)}
     * @param y the {@code y} component of the translation offsets {@code (x, y)}
     * @return this
     */
    @Mutated Float3x3 makeTranslation(float x, float y);

    /**
     * Set this matrix to the 2D view transformation that maps the rectangle
     * {@code [left, right] x [bottom, top]} onto {@code [-1, +1] x [-1, +1]}.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this
     */
    @Mutated Float3x3 makeView(float left, float right, float bottom, float top);

    /**
     * Pre-multiply a rotation by {@code angle} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 preRotate(float angle) { return preRotate(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply the rotation {@code angle} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 preRotateAround(float angle, Float2R pivot) { return preRotateAround(angle, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply the rotation {@code angle} about the pivot point ({@code x}, {@code y}) onto
     * this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 preRotateAround(float angle, float x, float y) { return preRotateAround(angle, x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 preRotateAxis(float angle, Float3R axis) { return preRotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 preRotateAxis(float angle, float x, float y, float z) { return preRotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 preRotateX(float angle) { return preRotateX(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 preRotateY(float angle) { return preRotateY(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 preRotateZ(float angle) { return preRotateZ(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @return this
     */
    @Mutated default Float3x3 preScale(Float2R v) { return preScale(v, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by ({@code x}, {@code y}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 preScale(float x, float y) { return preScale(x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by {@code s} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated default Float3x3 preScale(float s) { return preScale(s, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 preScaleAround(float s, Float2R pivot) { return preScaleAround(s, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code x}, {@code y}) onto this
     * matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 preScaleAround(float s, float x, float y) { return preScaleAround(s, x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 preScaleAround(Float2R s, Float2R pivot) { return preScaleAround(s, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated default Float3x3 preScaleAround(float sX, float sY, float pivotX, float pivotY) { return preScaleAround(sX, sY, pivotX, pivotY, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a translation by {@code v} onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @return this
     */
    @Mutated default Float3x3 preTranslate(Float2R v) { return preTranslate(v, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Pre-multiply a translation by ({@code x}, {@code y}) onto this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 preTranslate(float x, float y) { return preTranslate(x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation by {@code angle} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 rotate(float angle) { return rotate(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply the rotation {@code angle} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 rotateAround(float angle, Float2R pivot) { return rotateAround(angle, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply the rotation {@code angle} about the pivot point ({@code x}, {@code y}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 rotateAround(float angle, float x, float y) { return rotateAround(angle, x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated default Float3x3 rotateAxis(float angle, Float3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.float3x3() : this); }

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
     * @return this
     */
    @Mutated default Float3x3 rotateAxis(float angle, float x, float y, float z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 rotateX(float angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateX180() { return rotateX180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateX270() { return rotateX270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateX90() { return rotateX90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateXYZ(float angleX, float angleY, float angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateXZY(float angleX, float angleY, float angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateXn180() { return rotateXn180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateXn270() { return rotateXn270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateXn90() { return rotateXn90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 rotateY(float angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateY180() { return rotateY180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateY270() { return rotateY270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateY90() { return rotateY90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateYXZ(float angleX, float angleY, float angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateYZX(float angleX, float angleY, float angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateYn180() { return rotateYn180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateYn270() { return rotateYn270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateYn90() { return rotateYn90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default Float3x3 rotateZ(float angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZ180() { return rotateZ180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZ270() { return rotateZ270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZ90() { return rotateZ90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateZXY(float angleX, float angleY, float angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default Float3x3 rotateZYX(float angleX, float angleY, float angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZn180() { return rotateZn180(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZn270() { return rotateZn270(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @return this
     */
    @Mutated default Float3x3 rotateZn90() { return rotateZn90(Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @return this
     */
    @Mutated default Float3x3 scale(Float2R v) { return scale(v, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by ({@code x}, {@code y}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 scale(float x, float y) { return scale(x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by {@code s} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @return this
     */
    @Mutated default Float3x3 scale(float s) { return scale(s, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 scaleAround(float s, Float2R pivot) { return scaleAround(s, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point ({@code x}, {@code y}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y)}
     * @param y the {@code y} component of the vector {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 scaleAround(float s, float x, float y) { return scaleAround(s, x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @return this
     */
    @Mutated default Float3x3 scaleAround(Float2R s, Float2R pivot) { return scaleAround(s, pivot, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a scaling by ({@code sX}, {@code sY}) about the pivot point ({@code pivotX},
     * {@code pivotY}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY)}
     * @param sY the {@code y} component of the vector {@code (sX, sY)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY)}
     * @return this
     */
    @Mutated default Float3x3 scaleAround(float sX, float sY, float pivotX, float pivotY) { return scaleAround(sX, sY, pivotX, pivotY, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a translation by {@code v} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @return this
     */
    @Mutated default Float3x3 translate(Float2R v) { return translate(v, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a translation by ({@code x}, {@code y}) to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y)}
     * @param y the {@code y} component of the translation offsets {@code (x, y)}
     * @return this
     */
    @Mutated default Float3x3 translate(float x, float y) { return translate(x, y, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Apply a 2D view transformation that maps the rectangle {@code [left, right] x [bottom, top]}
     * onto {@code [-1, +1] x [-1, +1]} to this matrix.
     * <p>
     * If {@code M} is {@code this} matrix and {@code V} the view matrix, then the new matrix will
     * be {@code M * V}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * V * v}, the view will be applied first.
     *
     * @param left the distance to the left edge of the view rectangle
     * @param right the distance to the right edge of the view rectangle
     * @param bottom the distance to the bottom edge of the view rectangle
     * @param top the distance to the top edge of the view rectangle
     * @return this
     */
    @Mutated default Float3x3 view(float left, float right, float bottom, float top) { return view(left, right, bottom, top, Joml.RETURN_NEW ? Joml.float3x3() : this); }

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 loadCM(float[] src) { return loadCM(src, 0); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3x3 loadCM(float[] src, int offset);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCM(FloatBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMAbsolute(FloatBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(FloatBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCM(ByteBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMAbsolute(ByteBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(ByteBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 36);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3x3 loadCMUnsafe(long address);

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 loadCM(double[] src) { return loadCM(src, 0); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3x3 loadCM(double[] src, int offset);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCM(DoubleBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMAbsolute(DoubleBuffer src) { return loadCMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(DoubleBuffer src) {
        int pos = src.position();
        loadCMAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMDouble(ByteBuffer src) { return loadCMDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMDoubleAbsolute(ByteBuffer src) { return loadCMDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadCMDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadCMDoubleAbsolute(pos, src);
        src.position(pos + 72);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3x3 loadCMDoubleUnsafe(long address);

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 loadRM(float[] src) { return loadRM(src, 0); }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3x3 loadRM(float[] src, int offset);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRM(FloatBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMAbsolute(FloatBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(FloatBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRM(ByteBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMAbsolute(ByteBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(ByteBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 36);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3x3 loadRMUnsafe(long address);

    /**
     * Load the elements from the given array in row-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 loadRM(double[] src) { return loadRM(src, 0); }

    /**
     * Load the elements from the given array in row-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated Float3x3 loadRM(double[] src, int offset);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRM(DoubleBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMAbsolute(DoubleBuffer src) { return loadRMAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(DoubleBuffer src) {
        int pos = src.position();
        loadRMAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMDouble(ByteBuffer src) { return loadRMDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMDoubleAbsolute(ByteBuffer src) { return loadRMDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRMDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadRMDoubleAbsolute(pos, src);
        src.position(pos + 72);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated Float3x3 loadRMDoubleUnsafe(long address);

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCM(float[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCM(FloatBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, FloatBuffer src, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(FloatBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCM(ByteBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 4);
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
     */
    @Mutated Float3x3 loadCMUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCM(double[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCM(DoubleBuffer src, int stride) { return loadCMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCMAbsolute(int index, DoubleBuffer src, int stride);

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCMRelative(DoubleBuffer src, int stride) {
        int pos = src.position();
        loadCMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCMDouble(ByteBuffer src, int stride) { return loadCMDoubleAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCMDoubleAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in column-major order, converting each element
     * from {@code double}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadCMDoubleRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadCMDoubleAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 8);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in column-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadCMDoubleUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRM(float[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRM(FloatBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, FloatBuffer src, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(FloatBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRM(ByteBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 4);
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
     */
    @Mutated Float3x3 loadRMUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in row-major order, starting at the given offset, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRM(double[] src, int offset, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRM(DoubleBuffer src, int stride) { return loadRMAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRMAbsolute(int index, DoubleBuffer src, int stride);

    /**
     * Load the elements from the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRMRelative(DoubleBuffer src, int stride) {
        int pos = src.position();
        loadRMAbsolute(pos, src, stride);
        src.position(pos + 3 * stride);
        return this;
    }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRMDouble(ByteBuffer src, int stride) { return loadRMDoubleAbsolute(src.position(), src, stride); }

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRMDoubleAbsolute(int index, ByteBuffer src, int stride);

    /**
     * Load the elements from the given byte buffer in row-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRMDoubleRelative(ByteBuffer src, int stride) {
        int pos = src.position();
        loadRMDoubleAbsolute(pos, src, stride);
        src.position(pos + (3 * stride) * 8);
        return this;
    }

    /**
     * Load the elements from the given raw memory address in row-major order, converting each
     * element from {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated Float3x3 loadRMDoubleUnsafe(long address, int stride);

    /**
     * Load the elements from the given array in column-major order.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 load(float[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated default Float3x3 load(float[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 load(FloatBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 load(int index, FloatBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRelative(FloatBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default Float3x3 load(double[] src) { return loadCM(src); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated default Float3x3 load(double[] src, int offset) { return loadCM(src, offset); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position (the position is not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 load(DoubleBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 load(int index, DoubleBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default Float3x3 loadRelative(DoubleBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 load(ByteBuffer src) { return loadCMAbsolute(src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 load(int index, ByteBuffer src) { return loadCMAbsolute(index, src); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default Float3x3 loadRelative(ByteBuffer src) { return loadCMRelative(src); }

    /**
     * Load the elements from the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated default Float3x3 loadUnsafe(long address) { return loadCMUnsafe(address); }

    /**
     * Load the elements from the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 load(float[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given array in column-major order, converting each element from
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 load(double[] src, int offset, int stride) { return loadCM(src, offset, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 load(int index, FloatBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRelative(FloatBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 load(int index, DoubleBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given buffer in column-major order, converting each element from
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param src the source buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRelative(DoubleBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 load(int index, ByteBuffer src, int stride) { return loadCMAbsolute(index, src, stride); }

    /**
     * Load the elements from the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     *
     * @param src the source byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadRelative(ByteBuffer src, int stride) { return loadCMRelative(src, stride); }

    /**
     * Load the elements from the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    @Mutated default Float3x3 loadUnsafe(long address, int stride) { return loadCMUnsafe(address, stride); }
}
