package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a 4x4 matrix of single-precision {@code float} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link Float4x4}. APIs that only read a 4x4
 * matrix should accept {@code Float4x4R}, so callers can pass mutable instances without exposing
 * them to modification.
 * <p>
 * Arguments of type {@code Float4x4R} must be instances created by the library ({@link Joml}
 * factories / the library's own types); the implementations read cached state through the library's
 * own classes, so foreign implementations of the {@code *R} interfaces are not supported as
 * arguments.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Float.floatToIntBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
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
public interface Float4x4R {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 64;

    /** The number of rows - the tight stride of the column-major ({@code storeCM}/{@code loadCM}) strided overloads. */
    public static final int ROWS = 4;
    /** The number of columns - the tight stride of the row-major ({@code storeRM}/{@code loadRM}) strided overloads. */
    public static final int COLUMNS = 4;

    /** {@return a shared identity matrix} Never mutate it - it is returned as the read-only view for that reason. */
    public static Float4x4R IDENTITY() { return Holder.IDENTITY; }
    /** {@return a shared all-zero matrix} Never mutate it - it is returned as the read-only view for that reason. */
    public static Float4x4R ZERO() { return Holder.ZERO; }


    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    Float4 getColumn(int col, @Mutated Float4 dest);

    /**
     * Get the column at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param col the column index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code col} is not in {@code [0, COLUMNS)}
     */
    Double4 getColumn(int col, @Mutated Double4 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesXYZ(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Y and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesXYZ(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesXZY(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the X, Z and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesXZY(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesYXZ(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, X and Z axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesYXZ(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesYZX(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Y, Z and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesYZX(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesZXY(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, X and Y axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesZXY(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getEulerAnglesZYX(@Mutated Float3 dest);

    /**
     * Get the Euler angles in radians of this matrix, to be applied about the Z, Y and X axes, in
     * that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The upper-left 3x3 of this matrix must be a pure rotation (orthonormal, free of scaling and
     * shear): the angles are read from its raw elements, so a scaled matrix yields wrong angles
     * rather than the angles of its rotation part.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesZYX(@Mutated Double3 dest);

    /**
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatQuat getNormalizedRotation(@Mutated FloatQuat dest);

    /**
     * Extract the rotation of this matrix as a quaternion, column-normalizing the linear block
     * first to strip scale (skew is not removed: a sheared block yields a quaternion that is not
     * unit length) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat getNormalizedRotation(@Mutated DoubleQuat dest);

    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    Float4 getRow(int row, @Mutated Float4 dest);

    /**
     * Get the row at the given index of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param row the row index
     * @param dest will hold the result
     * @return dest
     * @throws IndexOutOfBoundsException if {@code row} is not in {@code [0, ROWS)}
     */
    Double4 getRow(int row, @Mutated Double4 dest);

    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getScale(@Mutated Float3 dest);

    /**
     * Get the scaling factors of this matrix, as the lengths of its basis columns (always
     * non-negative; skew is ignored) and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getScale(@Mutated Double3 dest);

    /**
     * Get the translation of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 getTranslation(@Mutated Float3 dest);

    /**
     * Get the translation of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getTranslation(@Mutated Double3 dest);

    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatQuat getUnnormalizedRotation(@Mutated FloatQuat dest);

    /**
     * Extract the rotation of this matrix as a quaternion directly from the linear block without
     * normalizing it, assuming it is already orthonormal and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat getUnnormalizedRotation(@Mutated DoubleQuat dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNegativeX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNegativeY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNegativeZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedNegativeX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedNegativeY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedNegativeZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedPositiveX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedPositiveY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invNormalizedPositiveZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invPositiveX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invPositiveY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 invPositiveZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this matrix must
     * lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 negativeX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 negativeY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 negativeZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedNegativeX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedNegativeY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedNegativeZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedPositiveX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedPositiveY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 normalizedPositiveZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveZ(@Mutated Double3 dest);

    /**
     * Obtain the position that is transformed to the origin by this matrix, assuming its upper-left
     * 3x3 block is orthonormal (e.g. a rotation-translation or view matrix) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 origin(@Mutated Float3 dest);

    /**
     * Obtain the position that is transformed to the origin by this matrix, assuming its upper-left
     * 3x3 block is orthonormal (e.g. a rotation-translation or view matrix) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 origin(@Mutated Double3 dest);

    /**
     * Obtain the position that is transformed to the origin by this matrix, for an arbitrary
     * invertible linear block (scale and skew included) and store the result in {@code dest}.
     * <p>
     * Unlike {@code origin}, which evaluates -R^T*t and is therefore only correct for an
     * orthonormal upper-left 3x3 block, this form divides through by the determinant and stays
     * correct under scale and skew. A singular matrix has no such point: dividing by its zero
     * determinant yields a non-finite result, {@code NaN} or an infinity per component.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 originAffine(@Mutated Float3 dest);

    /**
     * Obtain the position that is transformed to the origin by this matrix, for an arbitrary
     * invertible linear block (scale and skew included) and store the result in {@code dest}.
     * <p>
     * Unlike {@code origin}, which evaluates -R^T*t and is therefore only correct for an
     * orthonormal upper-left 3x3 block, this form divides through by the determinant and stays
     * correct under scale and skew. A singular matrix has no such point: dividing by its zero
     * determinant yields a non-finite result, {@code NaN} or an infinity per component.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 originAffine(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 positiveX(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 positiveY(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 positiveZ(@Mutated Float3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this matrix is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this matrix
     * must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band
     * first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveZ(@Mutated Double3 dest);

    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 cofactor(@Mutated Float4x4 dest);

    /**
     * Compute the cofactor matrix of this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 cofactor(@Mutated Double4x4 dest);

    /**
     * Compute the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    float determinant();

    /**
     * Compute the Frobenius norm of this matrix.
     *
     * @return the Frobenius norm of this matrix
     */
    float frobeniusNorm();

    /**
     * Invert this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 invert(@Mutated Float4x4 dest);

    /**
     * Invert this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 invert(@Mutated Double4x4 dest);

    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 invertProduct(Float4x4R other, @Mutated Float4x4 dest);

    /**
     * Compute the inverse of the product of this matrix and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 invertProduct(Float4x4R other, @Mutated Double4x4 dest);

    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) and store the
     * result in {@code dest}.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 invertProduct(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Float4x4 dest);

    /**
     * Compute the inverse of the product of this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 invertProduct(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Double4x4 dest);

    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 normal(@Mutated Float4x4 dest);

    /**
     * Compute the normal matrix of this matrix, i.e. the transpose of its inverse and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 normal(@Mutated Double4x4 dest);

    /**
     * Compute the trace of this matrix.
     *
     * @return the trace of this matrix
     */
    float trace();

    /**
     * Transpose this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 transpose(@Mutated Float4x4 dest);

    /**
     * Transpose this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 transpose(@Mutated Double4x4 dest);

    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 add(Float4x4R other, @Mutated Float4x4 dest);

    /**
     * Add {@code other} to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 add(Float4x4R other, @Mutated Double4x4 dest);

    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}, {@code m30},
     * {@code m31}, {@code m32}, {@code m33}) to this matrix and store the result in {@code dest}.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 add(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Float4x4 dest);

    /**
     * Add ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}, {@code m30},
     * {@code m31}, {@code m32}, {@code m33}) to this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 add(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Double4x4 dest);

    /**
     * Negate this matrix and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 negate(@Mutated Float4x4 dest);

    /**
     * Negate this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 negate(@Mutated Double4x4 dest);

    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 sub(Float4x4R other, @Mutated Float4x4 dest);

    /**
     * Subtract {@code other} from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 sub(Float4x4R other, @Mutated Double4x4 dest);

    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}, {@code m30},
     * {@code m31}, {@code m32}, {@code m33}) from this matrix and store the result in {@code dest}.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 sub(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Float4x4 dest);

    /**
     * Subtract ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10}, {@code m11},
     * {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23}, {@code m30},
     * {@code m31}, {@code m32}, {@code m33}) from this matrix and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 sub(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Double4x4 dest);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 withTranslation(Float3R t, @Mutated Float4x4 dest);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 withTranslation(Float3R t, @Mutated Double4x4 dest);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 withTranslation(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Set the translation of this matrix, leaving every other element untouched.
     * <p>
     * Only the first three elements of the last column are written, so a square matrix keeps the
     * projective element that sits below them. Unlike {@code translate}, this overwrites the
     * translation instead of composing a translation onto the existing transformation.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 withTranslation(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Convert this matrix to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 toDouble(@Mutated Double4x4 dest);

    /**
     * Extract the upper-left 3x3 block of this matrix (dropping the translation column and the last
     * row) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3x3 to3x3(@Mutated Float3x3 dest);

    /**
     * Extract the upper-left 3x3 block of this matrix (dropping the translation column and the last
     * row) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3x3 to3x3(@Mutated Double3x3 dest);

    /**
     * Truncate this matrix to a 3x4 matrix, dropping the last row (assumed {@code 0, 0, 0, 1}) and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3x4 to3x4(@Mutated Float3x4 dest);

    /**
     * Truncate this matrix to a 3x4 matrix, dropping the last row (assumed {@code 0, 0, 0, 1}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3x4 to3x4(@Mutated Double3x4 dest);

    /**
     * Convert this matrix to a dual quaternion, assuming its upper-left 3x3 block is orthonormal (a
     * rigid transform) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatDualQuat toDualQuat(@Mutated FloatDualQuat dest);

    /**
     * Convert this matrix to a dual quaternion, assuming its upper-left 3x3 block is orthonormal (a
     * rigid transform) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest);

    /**
     * Decompose this matrix into a rigid transform: translation from the last column, rotation from
     * the column-normalized upper-left 3x3 block (scale is removed by normalizing the columns, but
     * shear is not removed: a sheared block yields a rotation quaternion that is not unit length)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatRigid toRigid(@Mutated FloatRigid dest);

    /**
     * Decompose this matrix into a rigid transform: translation from the last column, rotation from
     * the column-normalized upper-left 3x3 block (scale is removed by normalizing the columns, but
     * shear is not removed: a sheared block yields a rotation quaternion that is not unit length)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleRigid toRigid(@Mutated DoubleRigid dest);

    /**
     * Decompose this matrix into a TRS transform: translation from the last column, scale from the
     * column lengths of the upper-left 3x3 block, rotation from the column-normalized block (scale
     * is removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatTransform toTransform(@Mutated FloatTransform dest);

    /**
     * Decompose this matrix into a TRS transform: translation from the last column, scale from the
     * column lengths of the upper-left 3x3 block, rotation from the column-normalized block (scale
     * is removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleTransform toTransform(@Mutated DoubleTransform dest);

    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatQuat decomposeRotation(@Mutated FloatQuat dest);

    /**
     * Extract the rotation part of this matrix and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat decomposeRotation(@Mutated DoubleQuat dest);

    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 decomposeScale(@Mutated Float3 dest);

    /**
     * Extract the scaling factors of this matrix via Gram-Schmidt orthogonalization (skew-aware;
     * the x factor carries the sign of a reflection when the determinant is negative) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 decomposeScale(@Mutated Double3 dest);

    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix) and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float3 decomposeSkew(@Mutated Float3 dest);

    /**
     * Extract the shear (skew) factors of this matrix via Gram-Schmidt orthogonalization, as
     * {@code (skewYZ, skewXZ, skewXY)} (all zero for a shear-free matrix) and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 decomposeSkew(@Mutated Double3 dest);

    /**
     * Decompose this matrix into its translation, rotation and scale components, storing them in
     * {@code translation}, {@code rotation} and {@code scale} respectively.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param translation will hold the translation
     * @param rotation will hold the rotation
     * @param scale will hold the scale
     * @return this
     */
    Float4x4 decomposeTRS(@Mutated Float3 translation, @Mutated FloatQuat rotation, @Mutated Float3 scale);

    /**
     * Decompose this matrix into its translation, rotation and scale components, storing them in
     * {@code translation}, {@code rotation} and {@code scale} respectively.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of each column must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param translation will hold the translation
     * @param rotation will hold the rotation
     * @param scale will hold the scale
     * @return this
     */
    Float4x4 decomposeTRS(@Mutated Double3 translation, @Mutated DoubleQuat rotation, @Mutated Double3 scale);

    /**
     * Compute the axis-aligned box enclosing the frustum of this matrix, interpreted as a
     * projection or combined view-projection matrix and store the result in {@code dest}.
     * <p>
     * The box encloses all eight frustum corners, so it is the tightest axis-aligned bound on the
     * frustum but not on the geometry inside it. A projection whose far plane is at infinity has an
     * unbounded frustum, and the box is then infinite too.
     *
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    FloatAABB frustumAabb(DepthRange depthRange, @Mutated FloatAABB dest);

    /**
     * Compute the axis-aligned box enclosing the frustum of this matrix, interpreted as a
     * projection or combined view-projection matrix and store the result in {@code dest}.
     * <p>
     * The box encloses all eight frustum corners, so it is the tightest axis-aligned bound on the
     * frustum but not on the geometry inside it. A projection whose far plane is at infinity has an
     * unbounded frustum, and the box is then infinite too.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    DoubleAABB frustumAabb(DepthRange depthRange, @Mutated DoubleAABB dest);

    /**
     * Compute the axis-aligned box enclosing the frustum of this matrix, interpreted as a
     * projection or combined view-projection matrix and store the result in {@code dest}.
     * <p>
     * The box encloses all eight frustum corners, so it is the tightest axis-aligned bound on the
     * frustum but not on the geometry inside it. A projection whose far plane is at infinity has an
     * unbounded frustum, and the box is then infinite too.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param dest will hold the result
     * @return dest
     */
    default FloatAABB frustumAabb(@Mutated FloatAABB dest) { return frustumAabb(DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the axis-aligned box enclosing the frustum of this matrix, interpreted as a
     * projection or combined view-projection matrix and store the result in {@code dest}.
     * <p>
     * The box encloses all eight frustum corners, so it is the tightest axis-aligned bound on the
     * frustum but not on the geometry inside it. A projection whose far plane is at infinity has an
     * unbounded frustum, and the box is then infinite too.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    default DoubleAABB frustumAabb(@Mutated DoubleAABB dest) { return frustumAabb(DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the given frustum corner of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * Each constant names a corner of the clip-space cube by the sign its three coordinates take
     * there, so {@code NXNYNZ} is the bottom-left corner of the near plane and {@code PXPYPZ} the
     * top-right corner of the far plane.
     *
     * @param corner the frustum corner to compute
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 frustumCorner(FrustumCorner corner, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Compute the given frustum corner of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * Each constant names a corner of the clip-space cube by the sign its three coordinates take
     * there, so {@code NXNYNZ} is the bottom-left corner of the near plane and {@code PXPYPZ} the
     * top-right corner of the far plane.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param corner the frustum corner to compute
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 frustumCorner(FrustumCorner corner, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Compute the given frustum corner of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * Each constant names a corner of the clip-space cube by the sign its three coordinates take
     * there, so {@code NXNYNZ} is the bottom-left corner of the near plane and {@code PXPYPZ} the
     * top-right corner of the far plane.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param corner the frustum corner to compute
     * @param dest will hold the result
     * @return dest
     */
    default Float3 frustumCorner(FrustumCorner corner, @Mutated Float3 dest) { return frustumCorner(corner, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the given frustum corner of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * Each constant names a corner of the clip-space cube by the sign its three coordinates take
     * there, so {@code NXNYNZ} is the bottom-left corner of the near plane and {@code PXPYPZ} the
     * top-right corner of the far plane.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param corner the frustum corner to compute
     * @param dest will hold the result
     * @return dest
     */
    default Double3 frustumCorner(FrustumCorner corner, @Mutated Double3 dest) { return frustumCorner(corner, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the given frustum plane of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * The plane equation is {@code a*x + b*y + c*z + d}, with the normal {@code (a, b, c)} pointing
     * into the frustum, so a point is inside the frustum when it evaluates to a non-negative value
     * against all six planes. The coefficients are not normalized: {@code (a, b, c)} has an
     * arbitrary length and {@code d} is therefore not a metric distance. Normalize the result to
     * compare plane-point distances.
     *
     * @param plane the frustum plane to compute
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4 frustumPlane(FrustumPlane plane, DepthRange depthRange, @Mutated Float4 dest);

    /**
     * Compute the given frustum plane of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * The plane equation is {@code a*x + b*y + c*z + d}, with the normal {@code (a, b, c)} pointing
     * into the frustum, so a point is inside the frustum when it evaluates to a non-negative value
     * against all six planes. The coefficients are not normalized: {@code (a, b, c)} has an
     * arbitrary length and {@code d} is therefore not a metric distance. Normalize the result to
     * compare plane-point distances.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the frustum plane to compute
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4 frustumPlane(FrustumPlane plane, DepthRange depthRange, @Mutated Double4 dest);

    /**
     * Compute the given frustum plane of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * The plane equation is {@code a*x + b*y + c*z + d}, with the normal {@code (a, b, c)} pointing
     * into the frustum, so a point is inside the frustum when it evaluates to a non-negative value
     * against all six planes. The coefficients are not normalized: {@code (a, b, c)} has an
     * arbitrary length and {@code d} is therefore not a metric distance. Normalize the result to
     * compare plane-point distances.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param plane the frustum plane to compute
     * @param dest will hold the result
     * @return dest
     */
    default Float4 frustumPlane(FrustumPlane plane, @Mutated Float4 dest) { return frustumPlane(plane, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the given frustum plane of this matrix, interpreted as a projection or combined
     * view-projection matrix and store the result in {@code dest}.
     * <p>
     * The plane equation is {@code a*x + b*y + c*z + d}, with the normal {@code (a, b, c)} pointing
     * into the frustum, so a point is inside the frustum when it evaluates to a non-negative value
     * against all six planes. The coefficients are not normalized: {@code (a, b, c)} has an
     * arbitrary length and {@code d} is therefore not a metric distance. Normalize the result to
     * compare plane-point distances.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the frustum plane to compute
     * @param dest will hold the result
     * @return dest
     */
    default Double4 frustumPlane(FrustumPlane plane, @Mutated Double4 dest) { return frustumPlane(plane, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the direction of the view ray through the frustum of this matrix at the given
     * horizontal and vertical interpolation factors.
     * <p>
     * {@code (0, 0)} is the bottom-left and {@code (1, 1)} the top-right frustum corner. The result
     * is not normalized: it is the difference between the far and the near frustum corner along
     * that ray, so the near corner plus the result lies on the far plane. For a projection whose
     * far plane is at infinity the result is a finite direction along the ray of unspecified
     * length. A far plane whose homogeneous w is at most {@code 2^-20} ({@code float}) /
     * {@code 2^-40} ({@code double}) times the near plane's is treated as being at infinity.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param x the horizontal frustum interpolation factor in {@code [0, 1]}
     * @param y the vertical frustum interpolation factor in {@code [0, 1]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 frustumRayDir(float x, float y, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Compute the direction of the view ray through the frustum of this matrix at the given
     * horizontal and vertical interpolation factors.
     * <p>
     * {@code (0, 0)} is the bottom-left and {@code (1, 1)} the top-right frustum corner. The result
     * is not normalized: it is the difference between the far and the near frustum corner along
     * that ray, so the near corner plus the result lies on the far plane. For a projection whose
     * far plane is at infinity the result is a finite direction along the ray of unspecified
     * length. A far plane whose homogeneous w is at most {@code 2^-20} ({@code float}) /
     * {@code 2^-40} ({@code double}) times the near plane's is treated as being at infinity.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the horizontal frustum interpolation factor in {@code [0, 1]}
     * @param y the vertical frustum interpolation factor in {@code [0, 1]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 frustumRayDir(float x, float y, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Compute the direction of the view ray through the frustum of this matrix at the given
     * horizontal and vertical interpolation factors.
     * <p>
     * {@code (0, 0)} is the bottom-left and {@code (1, 1)} the top-right frustum corner. The result
     * is not normalized: it is the difference between the far and the near frustum corner along
     * that ray, so the near corner plus the result lies on the far plane. For a projection whose
     * far plane is at infinity the result is a finite direction along the ray of unspecified
     * length. A far plane whose homogeneous w is at most {@code 2^-20} ({@code float}) /
     * {@code 2^-40} ({@code double}) times the near plane's is treated as being at infinity.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param x the horizontal frustum interpolation factor in {@code [0, 1]}
     * @param y the vertical frustum interpolation factor in {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 frustumRayDir(float x, float y, @Mutated Float3 dest) { return frustumRayDir(x, y, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the direction of the view ray through the frustum of this matrix at the given
     * horizontal and vertical interpolation factors.
     * <p>
     * {@code (0, 0)} is the bottom-left and {@code (1, 1)} the top-right frustum corner. The result
     * is not normalized: it is the difference between the far and the near frustum corner along
     * that ray, so the near corner plus the result lies on the far plane. For a projection whose
     * far plane is at infinity the result is a finite direction along the ray of unspecified
     * length. A far plane whose homogeneous w is at most {@code 2^-20} ({@code float}) /
     * {@code 2^-40} ({@code double}) times the near plane's is treated as being at infinity.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the horizontal frustum interpolation factor in {@code [0, 1]}
     * @param y the vertical frustum interpolation factor in {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 frustumRayDir(float x, float y, @Mutated Double3 dest) { return frustumRayDir(x, y, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testAabb(Float3R min, Float3R max, DepthRange depthRange);

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, DepthRange depthRange);

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param aabb the axis-aligned bounding box
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testAabb(FloatAABBR aabb, DepthRange depthRange);

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testAabb(Float3R min, Float3R max) { return testAabb(min, max, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) { return testAabb(minX, minY, minZ, maxX, maxY, maxZ, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given axis-aligned box against the frustum defined by this
     * matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param aabb the axis-aligned bounding box
     * @return the frustum test of the given axis-aligned box against the frustum defined by this
     *        matrix: {@code 1} if the box intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testAabb(FloatAABBR aabb) { return testAabb(aabb, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given point against the frustum defined by this matrix:
     * {@code 1} if the point lies inside, {@code 0} otherwise.
     *
     * @param point the vector
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given point against the frustum defined by this matrix:
     *        {@code 1} if the point lies inside, {@code 0} otherwise
     */
    float testPoint(Float3R point, DepthRange depthRange);

    /**
     * Compute the frustum test of the given point against the frustum defined by this matrix:
     * {@code 1} if the point lies inside, {@code 0} otherwise.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given point against the frustum defined by this matrix:
     *        {@code 1} if the point lies inside, {@code 0} otherwise
     */
    float testPoint(float x, float y, float z, DepthRange depthRange);

    /**
     * Compute the frustum test of the given point against the frustum defined by this matrix:
     * {@code 1} if the point lies inside, {@code 0} otherwise.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param point the vector
     * @return the frustum test of the given point against the frustum defined by this matrix:
     *        {@code 1} if the point lies inside, {@code 0} otherwise
     */
    default float testPoint(Float3R point) { return testPoint(point, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given point against the frustum defined by this matrix:
     * {@code 1} if the point lies inside, {@code 0} otherwise.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return the frustum test of the given point against the frustum defined by this matrix:
     *        {@code 1} if the point lies inside, {@code 0} otherwise
     */
    default float testPoint(float x, float y, float z) { return testPoint(x, y, z, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param center the center point
     * @param radius the radius
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testSphere(Float3R center, float radius, DepthRange depthRange);

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param radius the radius
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testSphere(float x, float y, float z, float radius, DepthRange depthRange);

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     *
     * @param sph the sphere
     * @param depthRange the clip-space depth range the projection maps onto
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    float testSphere(FloatSphereR sph, DepthRange depthRange);

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param center the center point
     * @param radius the radius
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testSphere(Float3R center, float radius) { return testSphere(center, radius, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param radius the radius
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testSphere(float x, float y, float z, float radius) { return testSphere(x, y, z, radius, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Compute the frustum test of the given sphere against the frustum defined by this matrix:
     * {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully outside.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param sph the sphere
     * @return the frustum test of the given sphere against the frustum defined by this matrix:
     *        {@code 1} if the sphere intersects or is inside the frustum, {@code 0} if fully
     *        outside
     */
    default float testSphere(FloatSphereR sph) { return testSphere(sph, DepthRange.NEGATIVE_ONE_TO_ONE); }

    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lerp(Float4x4R other, float t, @Mutated Float4x4 dest);

    /**
     * Linearly interpolate between this matrix and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 lerp(Float4x4R other, float t, @Mutated Double4x4 dest);

    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lerp(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, float t, @Mutated Float4x4 dest);

    /**
     * Linearly interpolate between this matrix and ({@code m00}, {@code m01}, {@code m02},
     * {@code m03}, {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21},
     * {@code m22}, {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) using the
     * interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 lerp(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, float t, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(Float4x4R right, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(Float4x4R right, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10},
     * {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23},
     * {@code m30}, {@code m31}, {@code m32}, {@code m33}) and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by ({@code m00}, {@code m01}, {@code m02}, {@code m03}, {@code m10},
     * {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22}, {@code m23},
     * {@code m30}, {@code m31}, {@code m32}, {@code m33}) and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(Float2x2R right, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(Float2x2R right, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(Float2x3R right, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(Float2x3R right, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(Float3x3R right, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(Float3x3R right, @Mutated Double4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mul(Float3x4R right, @Mutated Float4x4 dest);

    /**
     * Multiply this matrix by {@code right} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param right the right operand
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mul(Float3x4R right, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(Float4x4R other, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the transformation {@code other} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(Float4x4R other, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m03},
     * {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22},
     * {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) onto this matrix and store
     * the result in {@code dest}.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the transformation ({@code m00}, {@code m01}, {@code m02}, {@code m03},
     * {@code m10}, {@code m11}, {@code m12}, {@code m13}, {@code m20}, {@code m21}, {@code m22},
     * {@code m23}, {@code m30}, {@code m31}, {@code m32}, {@code m33}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the given transformation matrix, then the
     * new matrix will be {@code T * M}. So when transforming a vector {@code v} with the new matrix
     * by using {@code T * M * v}, the given transformation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param m30 the element in row 3, column 0 of the matrix
     * @param m31 the element in row 3, column 1 of the matrix
     * @param m32 the element in row 3, column 2 of the matrix
     * @param m33 the element in row 3, column 3 of the matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, @Mutated Double4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(Float2x2R other, @Mutated Float4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(Float2x2R other, @Mutated Double4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(Float2x3R other, @Mutated Float4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(Float2x3R other, @Mutated Double4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(Float3x3R other, @Mutated Float4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(Float3x3R other, @Mutated Double4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preMul(Float3x4R other, @Mutated Float4x4 dest);

    /**
     * Pre-multiply {@code other} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the operand, then the new matrix will be
     * {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * The operand is identity-extended to this matrix's square size before the multiplication, and
     * the product is projected back onto this shape.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other matrix
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preMul(Float3x4R other, @Mutated Double4x4 dest);

    /**
     * Apply an arcball view transformation about the given center to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code A} the arcball view matrix, then the new
     * matrix will be {@code M * A}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * A * v}, the arcball view will be applied first.
     *
     * @param radius the radius
     * @param center the center point
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 arcball(float radius, Float3R center, float angleX, float angleY, @Mutated Float4x4 dest);

    /**
     * Apply an arcball view transformation about the given center to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code A} the arcball view matrix, then the new
     * matrix will be {@code M * A}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * A * v}, the arcball view will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param radius the radius
     * @param center the center point
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 arcball(float radius, Float3R center, float angleX, float angleY, @Mutated Double4x4 dest);

    /**
     * Apply an arcball view transformation about the given center to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code A} the arcball view matrix, then the new
     * matrix will be {@code M * A}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * A * v}, the arcball view will be applied first.
     *
     * @param radius the radius
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 arcball(float radius, float x, float y, float z, float angleX, float angleY, @Mutated Float4x4 dest);

    /**
     * Apply an arcball view transformation about the given center to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code A} the arcball view matrix, then the new
     * matrix will be {@code M * A}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * A * v}, the arcball view will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param radius the radius
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 arcball(float radius, float x, float y, float z, float angleX, float angleY, @Mutated Double4x4 dest);

    /**
     * Apply an axonometric dimetric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param alpha the tilt angle in radians about the X axis (at {@code atan(1/sqrt(2))} the
     *        result is isometric)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 axonometricDimetric(float alpha, @Mutated Float4x4 dest);

    /**
     * Apply an axonometric dimetric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param alpha the tilt angle in radians about the X axis (at {@code atan(1/sqrt(2))} the
     *        result is isometric)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 axonometricDimetric(float alpha, @Mutated Double4x4 dest);

    /**
     * Apply an axonometric isometric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 axonometricIsometric(@Mutated Float4x4 dest);

    /**
     * Apply an axonometric isometric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 axonometricIsometric(@Mutated Double4x4 dest);

    /**
     * Apply an axonometric trimetric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param alphaX the rotation angle in radians about the X axis
     * @param alphaY the rotation angle in radians about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 axonometricTrimetric(float alphaX, float alphaY, @Mutated Float4x4 dest);

    /**
     * Apply an axonometric trimetric viewing rotation (compose with an orthographic projection for
     * the full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param alphaX the rotation angle in radians about the X axis
     * @param alphaY the rotation angle in radians about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 axonometricTrimetric(float alphaX, float alphaY, @Mutated Double4x4 dest);

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, DepthRange depthRange, @Mutated Float4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, DepthRange depthRange, @Mutated Double4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, @Mutated Float4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, @Mutated Double4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, @Mutated Float4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an arbitrary perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane (must be positive; positive infinity affects
     *        only the depth row - left/right/bottom/top are measured at the near plane, so prefer
     *        the angle-based builders for an infinite near)
     * @param zFar the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 frustum(float left, float right, float bottom, float top, float zNear, float zFar, @Mutated Double4x4 dest) { return frustum(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lookAlong(Float3R dir, Float3R up, @Mutated Float4x4 dest);

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 lookAlong(Float3R dir, Float3R up, @Mutated Double4x4 dest);

    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look along" matrix, then the new
     * matrix will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * L * v}, the "look along" will be applied first.
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
    Double4x4 lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated Double4x4 dest);

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lookAt(Float3R eye, Float3R center, Float3R up, Handedness handedness, @Mutated Float4x4 dest);

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 lookAt(Float3R eye, Float3R center, Float3R up, Handedness handedness, @Mutated Double4x4 dest);

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Handedness handedness, @Mutated Float4x4 dest);

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, Handedness handedness, @Mutated Double4x4 dest);

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 lookAt(Float3R eye, Float3R center, Float3R up, @Mutated Float4x4 dest) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED, dest); }

    /**
     * Apply a "look at" view transformation with the eye at {@code eye} looking at {@code center}
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param eye the position of the camera
     * @param center the point in space to look at
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 lookAt(Float3R eye, Float3R center, Float3R up, @Mutated Double4x4 dest) { return lookAt(eye, center, up, Handedness.RIGHT_HANDED, dest); }

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, @Mutated Float4x4 dest) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED, dest); }

    /**
     * Apply a "look at" view transformation with the eye at ({@code eyeX}, {@code eyeY},
     * {@code eyeZ}) looking at ({@code centerX}, {@code centerY}, {@code centerZ}) to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code L} the "look at" matrix, then the new matrix
     * will be {@code M * L}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * L * v}, the "look at" will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 lookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ, @Mutated Double4x4 dest) { return lookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ, Handedness.RIGHT_HANDED, dest); }

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXYZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXYZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXYnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXYnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXZY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXZY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXZnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXZnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXnYZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXnYZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXnYnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXnYnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXnZY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXnZY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapXnZnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapXnZnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYXZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYXZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYXnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYXnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYZX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYZX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYZnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYZnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYnXZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYnXZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYnXnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYnXnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYnZX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYnZX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapYnZnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapYnZnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZXY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZXY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZXnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZXnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZYX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZYX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZYnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZYnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZnXY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZnXY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZnXnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZnXnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZnYX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZnYX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapZnYnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (+z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapZnYnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXYZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXYZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXYnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXYnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXZY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXZY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXZnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, +z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXZnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXnYZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXnYZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXnYnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -y, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXnYnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXnZY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXnZY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnXnZnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-x, -z, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnXnZnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYXZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYXZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYXnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYXnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYZX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYZX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYZnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, +z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYZnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYnXZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, +z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYnXZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYnXnZ(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -x, -z)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYnXnZ(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYnZX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYnZX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnYnZnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-y, -z, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnYnZnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZXY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZXY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZXnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZXnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZYX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZYX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZYnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, +y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZYnX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZnXY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, +y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZnXY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZnXnY(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -x, -y)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZnXnY(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZnYX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, +x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZnYX(@Mutated Double4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 mapnZnYnX(@Mutated Float4x4 dest);

    /**
     * Apply a transformation that maps the axes {@code (x, y, z)} to {@code (-z, -y, -x)} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the mapping matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the mapping will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 mapnZnYnX(@Mutated Double4x4 dest);

    /**
     * Apply an oblique cabinet projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueCabinet(float angle, @Mutated Float4x4 dest);

    /**
     * Apply an oblique cabinet projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueCabinet(float angle, @Mutated Double4x4 dest);

    /**
     * Apply an oblique cavalier projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueCavalier(float angle, @Mutated Float4x4 dest);

    /**
     * Apply an oblique cavalier projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueCavalier(float angle, @Mutated Double4x4 dest);

    /**
     * Apply an oblique military projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueMilitary(float angle, @Mutated Float4x4 dest);

    /**
     * Apply an oblique military projection shear (compose with an orthographic projection for the
     * full transform) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the oblique shear matrix, then the new
     * matrix will be {@code M * O}. So when transforming a vector {@code v} with the new matrix by
     * using {@code M * O * v}, the oblique shear will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueMilitary(float angle, @Mutated Double4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueZ(Float4R plane, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueZ(Float4R plane, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueZ(float x, float y, float z, float w, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueZ(float x, float y, float z, float w, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 obliqueZ(FloatPlaneR plane, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 obliqueZ(FloatPlaneR plane, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(Float4R plane, DepthRange depthRange, @Mutated Float4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(Float4R plane, DepthRange depthRange, @Mutated Double4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(float x, float y, float z, float w, DepthRange depthRange, @Mutated Float4x4 dest) { return obliqueZ(x, y, z, w, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(float x, float y, float z, float w, DepthRange depthRange, @Mutated Double4x4 dest) { return obliqueZ(x, y, z, w, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(Float4R plane, Handedness handedness, @Mutated Float4x4 dest) { return obliqueZ(plane, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(Float4R plane, Handedness handedness, @Mutated Double4x4 dest) { return obliqueZ(plane, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(float x, float y, float z, float w, Handedness handedness, @Mutated Float4x4 dest) { return obliqueZ(x, y, z, w, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(float x, float y, float z, float w, Handedness handedness, @Mutated Double4x4 dest) { return obliqueZ(x, y, z, w, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(Float4R plane, @Mutated Float4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(Float4R plane, @Mutated Double4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(float x, float y, float z, float w, @Mutated Float4x4 dest) { return obliqueZ(x, y, z, w, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param y the {@code y} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param z the {@code z} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param w the {@code w} component of the clip plane {@code (a, b, c, d)} in camera space, with
     *        the normal pointing into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(float x, float y, float z, float w, @Mutated Double4x4 dest) { return obliqueZ(x, y, z, w, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(FloatPlaneR plane, DepthRange depthRange, @Mutated Float4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(FloatPlaneR plane, DepthRange depthRange, @Mutated Double4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(FloatPlaneR plane, Handedness handedness, @Mutated Float4x4 dest) { return obliqueZ(plane, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(FloatPlaneR plane, Handedness handedness, @Mutated Double4x4 dest) { return obliqueZ(plane, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 obliqueZ(FloatPlaneR plane, @Mutated Float4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Modify this perspective projection matrix to use an oblique near clip plane (the Lengyel
     * method): the near clip plane is replaced by the given clip plane in camera/view space, and
     * the far plane is adjusted to preserve depth precision.
     * <p>
     * The handedness and depth range must be the ones this perspective projection was built with:
     * they decide where the near and far clip planes sit in clip space and which way the projective
     * row points, which the closed-form solution depends on.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param plane the clip plane {@code (a, b, c, d)} in camera space, with the normal pointing
     *        into the visible half-space
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 obliqueZ(FloatPlaneR plane, @Mutated Double4x4 dest) { return obliqueZ(plane, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, DepthRange depthRange, @Mutated Float4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, DepthRange depthRange, @Mutated Double4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, @Mutated Float4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness, @Mutated Double4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, @Mutated Float4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param zNear the distance to the near clip plane
     * @param zFar the distance to the far clip plane
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho(float left, float right, float bottom, float top, float zNear, float zFar, @Mutated Double4x4 dest) { return ortho(left, right, bottom, top, zNear, zFar, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 ortho2D(float left, float right, float bottom, float top, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 ortho2D(float left, float right, float bottom, float top, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho2D(float left, float right, float bottom, float top, DepthRange depthRange, @Mutated Float4x4 dest) { return ortho2D(left, right, bottom, top, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho2D(float left, float right, float bottom, float top, DepthRange depthRange, @Mutated Double4x4 dest) { return ortho2D(left, right, bottom, top, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho2D(float left, float right, float bottom, float top, Handedness handedness, @Mutated Float4x4 dest) { return ortho2D(left, right, bottom, top, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho2D(float left, float right, float bottom, float top, Handedness handedness, @Mutated Double4x4 dest) { return ortho2D(left, right, bottom, top, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 ortho2D(float left, float right, float bottom, float top, @Mutated Float4x4 dest) { return ortho2D(left, right, bottom, top, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a 2D orthographic projection transformation to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code O} the orthographic projection matrix, then
     * the new matrix will be {@code M * O}. So when transforming a vector {@code v} with the new
     * matrix by using {@code M * O * v}, the orthographic projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param left the distance to the left frustum edge
     * @param right the distance to the right frustum edge
     * @param bottom the distance to the bottom frustum edge
     * @param top the distance to the top frustum edge
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 ortho2D(float left, float right, float bottom, float top, @Mutated Double4x4 dest) { return ortho2D(left, right, bottom, top, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param view the light view transformation (must be affine)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 orthoCrop(Float4x4R view, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 orthoCrop(Float4x4R view, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param view the light view transformation (must be affine)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, DepthRange depthRange, @Mutated Float4x4 dest) { return orthoCrop(view, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, DepthRange depthRange, @Mutated Double4x4 dest) { return orthoCrop(view, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param view the light view transformation (must be affine)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, Handedness handedness, @Mutated Float4x4 dest) { return orthoCrop(view, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, Handedness handedness, @Mutated Double4x4 dest) { return orthoCrop(view, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param view the light view transformation (must be affine)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, @Mutated Float4x4 dest) { return orthoCrop(view, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits the view-projection frustum represented by
     * {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix (e.g. from {@code lookAt}). Typical use is fitting a
     * shadow-map projection around the camera frustum.
     * <p>
     * {@code depthRange} does double duty here: it selects the produced orthographic projection's
     * own clip-space depth range AND the source frustum's NDC z extent that "the whole frustum"
     * means - {@code [-1, 1]} for {@code NEGATIVE_ONE_TO_ONE}, {@code [0, 1]} for
     * {@code ZERO_TO_ONE}. That assumes the camera projection and the produced orthographic
     * projection share a convention. When they do not, pass the source's own NDC bounds explicitly
     * to the {@code minZ}/{@code maxZ} overload, whose bounds are independent of
     * {@code depthRange}.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, @Mutated Double4x4 dest) { return orthoCrop(view, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, DepthRange depthRange, @Mutated Float4x4 dest) { return orthoCrop(view, minZ, maxZ, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, DepthRange depthRange, @Mutated Double4x4 dest) { return orthoCrop(view, minZ, maxZ, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, Handedness handedness, @Mutated Float4x4 dest) { return orthoCrop(view, minZ, maxZ, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, Handedness handedness, @Mutated Double4x4 dest) { return orthoCrop(view, minZ, maxZ, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, @Mutated Float4x4 dest) { return orthoCrop(view, minZ, maxZ, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Build an orthographic projection that tightly fits a depth sub-range of the view-projection
     * frustum represented by {@code this} matrix into the given affine {@code view} transformation.
     * <p>
     * {@code this} must be the inverse of the combined camera view-projection matrix; {@code view}
     * is typically the light's view matrix. {@code minZ} and {@code maxZ} delimit the frustum slice
     * in the source projection's normalized device coordinates (order-independent), e.g. the NDC z
     * of a shadow cascade's near and far split planes. They are independent of {@code depthRange},
     * which selects the produced orthographic projection's own clip-space depth range.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param view the light view transformation (must be affine)
     * @param minZ the near depth bound of the slice, in source-projection NDC z
     * @param maxZ the far depth bound of the slice, in source-projection NDC z
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 orthoCrop(Float4x4R view, float minZ, float maxZ, @Mutated Double4x4 dest) { return orthoCrop(view, minZ, maxZ, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 perspective(float fovy, float aspect, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 perspective(float fovy, float aspect, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspective(float fovy, float aspect, float near, float far, DepthRange depthRange, @Mutated Float4x4 dest) { return perspective(fovy, aspect, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspective(float fovy, float aspect, float near, float far, DepthRange depthRange, @Mutated Double4x4 dest) { return perspective(fovy, aspect, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspective(float fovy, float aspect, float near, float far, Handedness handedness, @Mutated Float4x4 dest) { return perspective(fovy, aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspective(float fovy, float aspect, float near, float far, Handedness handedness, @Mutated Double4x4 dest) { return perspective(fovy, aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspective(float fovy, float aspect, float near, float far, @Mutated Float4x4 dest) { return perspective(fovy, aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a symmetric perspective projection frustum transformation to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param fovy the vertical field of view in radians (must be greater than zero and less than
     *        {@code PI})
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspective(float fovy, float aspect, float near, float far, @Mutated Double4x4 dest) { return perspective(fovy, aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, DepthRange depthRange, @Mutated Float4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, DepthRange depthRange, @Mutated Double4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness, @Mutated Float4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness, @Mutated Double4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, @Mutated Float4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a perspective projection frustum transformation for the given vertical field-of-view
     * range to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleMin the minimum vertical field-of-view angle in radians
     * @param angleMax the maximum vertical field-of-view angle in radians
     * @param aspect the aspect ratio of the view (i.e. width / height)
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFovRange(float angleMin, float angleMax, float aspect, float near, float far, @Mutated Double4x4 dest) { return perspectiveFovRange(angleMin, angleMax, aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 perspectiveFrustumSlice(float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 perspectiveFrustumSlice(float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFrustumSlice(float near, float far, DepthRange depthRange, @Mutated Float4x4 dest) { return perspectiveFrustumSlice(near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFrustumSlice(float near, float far, DepthRange depthRange, @Mutated Double4x4 dest) { return perspectiveFrustumSlice(near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFrustumSlice(float near, float far, Handedness handedness, @Mutated Float4x4 dest) { return perspectiveFrustumSlice(near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFrustumSlice(float near, float far, Handedness handedness, @Mutated Double4x4 dest) { return perspectiveFrustumSlice(near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveFrustumSlice(float near, float far, @Mutated Float4x4 dest) { return perspectiveFrustumSlice(near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Change the near and far clip plane distances of an existing perspective frustum
     * transformation and leave everything else unchanged.
     * <p>
     * Only meaningful when this matrix is a perspective projection obtained via {@code perspective}
     * or {@code frustum}: all elements except the depth row are copied through, and that row is
     * recomputed for the new {@code near}/{@code far}. Pass the same {@code handedness} and
     * {@code depthRange} the matrix was built with.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param near the new distance to the near clip plane (pass positive infinity to re-slice to an
     *        infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the new distance to the far clip plane (pass positive infinity to re-slice to an
     *        infinite far plane)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveFrustumSlice(float near, float far, @Mutated Double4x4 dest) { return perspectiveFrustumSlice(near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Float4x4 dest);

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness, DepthRange depthRange, @Mutated Double4x4 dest);

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, DepthRange depthRange, @Mutated Float4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, DepthRange depthRange, @Mutated Double4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, Handedness.RIGHT_HANDED, depthRange, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness, @Mutated Float4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param handedness the handedness of the coordinate system to map into
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness, @Mutated Double4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Float4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, @Mutated Float4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply an asymmetric perspective projection frustum transformation with the frustum sides
     * given as view-axis angles to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the perspective projection matrix, then the
     * new matrix will be {@code M * P}. So when transforming a vector {@code v} with the new matrix
     * by using {@code M * P * v}, the perspective projection will be applied first.
     * <p>
     * Uses {@link Handedness#RIGHT_HANDED} for {@code handedness} and
     * {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * Degenerate parameters - coincident clip planes such as {@code near == far},
     * {@code left == right} or {@code bottom == top}, or a zero field of view - leave the result
     * undefined, and it may differ between the library variants.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleLeft the angle in radians from the view axis to the left frustum edge (negative
     *        for a frustum extending to the left)
     * @param angleRight the angle in radians from the view axis to the right frustum edge
     * @param angleDown the angle in radians from the view axis to the bottom frustum edge (negative
     *        for a frustum extending downwards)
     * @param angleUp the angle in radians from the view axis to the top frustum edge
     * @param near the distance to the near clip plane (must be positive; pass positive infinity for
     *        an infinite near plane - equivalent to an infinite far plane with the depth range
     *        reversed)
     * @param far the distance to the far clip plane (pass positive infinity for an infinite far
     *        plane)
     * @param dest will hold the result
     * @return dest
     */
    default Double4x4 perspectiveOffCenterFov(float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, @Mutated Double4x4 dest) { return perspectiveOffCenterFov(angleLeft, angleRight, angleDown, angleUp, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a picking transformation restricting the view to the given picking region to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the picking matrix, then the new matrix
     * will be {@code M * P}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * P * v}, the picking will be applied first.
     *
     * @param centerX the x coordinate of the picking-region center in window coordinates
     * @param centerY the y coordinate of the picking-region center in window coordinates
     * @param deltaX the width of the picking region in window coordinates
     * @param deltaY the height of the picking region in window coordinates
     * @param vpX the x coordinate of the viewport origin
     * @param vpY the y coordinate of the viewport origin
     * @param vpW the width of the viewport
     * @param vpH the height of the viewport
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 pickMatrix(float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH, @Mutated Float4x4 dest);

    /**
     * Apply a picking transformation restricting the view to the given picking region to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code P} the picking matrix, then the new matrix
     * will be {@code M * P}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * P * v}, the picking will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param centerX the x coordinate of the picking-region center in window coordinates
     * @param centerY the y coordinate of the picking-region center in window coordinates
     * @param deltaX the width of the picking region in window coordinates
     * @param deltaY the height of the picking region in window coordinates
     * @param vpX the x coordinate of the viewport origin
     * @param vpY the y coordinate of the viewport origin
     * @param vpW the width of the viewport
     * @param vpH the height of the viewport
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 pickMatrix(float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateAround(FloatQuatR rot, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the rotation {@code rot} about the pivot point {@code pivot} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateAround(FloatQuatR rot, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the
     * result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the
     * pivot point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateAxis(float angle, Float3R axis, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis {@code axis} onto this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateAxis(float angle, Float3R axis, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code x}, {@code y},
     * {@code z}) onto this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateAxis(float angle, float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the axis ({@code x}, {@code y},
     * {@code z}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    Double4x4 preRotateAxis(float angle, float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateQuat(FloatQuatR q, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the rotation represented by the quaternion {@code q} onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateQuat(FloatQuatR q, @Mutated Double4x4 dest);

    /**
     * Pre-multiply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z},
     * {@code w}) onto this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateQuat(float x, float y, float z, float w, @Mutated Float4x4 dest);

    /**
     * Pre-multiply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z},
     * {@code w}) onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    Double4x4 preRotateQuat(float x, float y, float z, float w, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateX(float angle, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateX(float angle, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateY(float angle, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateY(float angle, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preRotateZ(float angle, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code R * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code R * M * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preRotateZ(float angle, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by {@code v} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScale(Float3R v, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by {@code v} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code S * M * p}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScale(Float3R v, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by ({@code x}, {@code y}, {@code z}) onto this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScale(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by ({@code x}, {@code y}, {@code z}) onto this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScale(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScale(float s, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScale(float s, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScaleAround(float s, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScaleAround(float s, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z})
     * onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScaleAround(float s, float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z})
     * onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScaleAround(float s, float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScaleAround(Float3R s, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by {@code s} about the pivot point {@code pivot} onto this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScaleAround(Float3R s, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preScaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code S * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code S * M * v}, the scaling will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preScaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a translation by {@code v} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preTranslate(Float3R v, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a translation by {@code v} onto this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code p} with the new matrix by using
     * {@code T * M * p}, the translation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preTranslate(Float3R v, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a translation by ({@code x}, {@code y}, {@code z}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 preTranslate(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a translation by ({@code x}, {@code y}, {@code z}) onto this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code T * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code T * M * v}, the translation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 preTranslate(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     *
     * @param obj the object-space position to project
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 project(Float3R obj, Float4R viewport, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param obj the object-space position to project
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 project(Float3R obj, Float4R viewport, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     *
     * @param objX the {@code x} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objY the {@code y} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objZ the {@code z} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 project(float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param objX the {@code x} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objY the {@code y} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objZ the {@code z} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 project(float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param obj the object-space position to project
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 project(Float3R obj, Float4R viewport, @Mutated Float3 dest) { return project(obj, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param obj the object-space position to project
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 project(Float3R obj, Float4R viewport, @Mutated Double3 dest) { return project(obj, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param objX the {@code x} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objY the {@code y} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objZ the {@code z} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 project(float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Float3 dest) { return project(objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Project the given position onto window coordinates using this matrix and the given viewport
     * and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param objX the {@code x} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objY the {@code y} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param objZ the {@code z} component of the object-space position to project
     *        {@code (objX, objY, objZ)}
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 project(float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Double3 dest) { return project(objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 reflect(Float3R normal, @Mutated Float4x4 dest);

    /**
     * Apply a reflection about the plane through the origin with the normal {@code normal} to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 reflect(Float3R normal, @Mutated Double4x4 dest);

    /**
     * Apply a reflection about the plane through the origin with the normal ({@code x}, {@code y},
     * {@code z}) to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 reflect(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Apply a reflection about the plane through the origin with the normal ({@code x}, {@code y},
     * {@code z}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the reflection matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the reflection will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    Double4x4 reflect(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateAround(FloatQuatR rot, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Apply the rotation {@code rot} about the pivot point {@code pivot} to this matrix and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param rot the quaternion (must be a unit quaternion)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateAround(FloatQuatR rot, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ, @Mutated Float4x4 dest);

    /**
     * Apply the rotation ({@code rotX}, {@code rotY}, {@code rotZ}, {@code rotW}) about the pivot
     * point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The pivot sandwich {@code translate(pivot) * R * translate(-pivot)} is evaluated so that its
     * translation part, {@code pivot - R * pivot}, keeps its accuracy for pivots far from the
     * origin.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateAround(float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateAxis(float angle, Float3R axis, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this matrix and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateAxis(float angle, Float3R axis, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateAxis(float angle, float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    Double4x4 rotateAxis(float angle, float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateQuat(FloatQuatR q, @Mutated Float4x4 dest);

    /**
     * Apply the rotation represented by the quaternion {@code q} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateQuat(FloatQuatR q, @Mutated Double4x4 dest);

    /**
     * Apply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z}, {@code w})
     * to this matrix and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateQuat(float x, float y, float z, float w, @Mutated Float4x4 dest);

    /**
     * Apply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z}, {@code w})
     * to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    Double4x4 rotateQuat(float x, float y, float z, float w, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateX(float angle, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateX(float angle, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateX180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateX180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateX270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateX270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateX90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateX90(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateXYZ(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateXYZ(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateXZY(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateXZY(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateXn180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateXn180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateXn270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateXn270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateXn90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the X axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateXn90(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateY(float angle, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateY(float angle, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateY180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateY180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateY270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateY270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateY90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateY90(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateYXZ(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateYXZ(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateYZX(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateYZX(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateYn180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateYn180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateYn270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateYn270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateYn90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the Y axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateYn90(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZ(float angle, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZ(float angle, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZ180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZ180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZ270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZ270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZ90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of 90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZ90(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZXY(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateZXY(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZYX(float angleX, float angleY, float angleZ, @Mutated Float4x4 dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
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
    Double4x4 rotateZYX(float angleX, float angleY, float angleZ, @Mutated Double4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZn180(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -180 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZn180(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZn270(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -270 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZn270(@Mutated Double4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 rotateZn90(@Mutated Float4x4 dest);

    /**
     * Apply a rotation of -90 degrees about the Z axis to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code R} the rotation matrix, then the new matrix
     * will be {@code M * R}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 rotateZn90(@Mutated Double4x4 dest);

    /**
     * Apply a scaling by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scale(Float3R v, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * S * p}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scale(Float3R v, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by ({@code x}, {@code y}, {@code z}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scale(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by ({@code x}, {@code y}, {@code z}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scale(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by {@code s} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scale(float s, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by {@code s} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scale(float s, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scaleAround(float s, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scaleAround(float s, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z}) to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scaleAround(float s, float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point ({@code x}, {@code y}, {@code z}) to this
     * matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scaleAround(float s, float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scaleAround(Float3R s, Float3R pivot, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by {@code s} about the pivot point {@code pivot} to this matrix and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the scale factors
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scaleAround(Float3R s, Float3R pivot, @Mutated Double4x4 dest);

    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 scaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ, @Mutated Float4x4 dest);

    /**
     * Apply a scaling by ({@code sX}, {@code sY}, {@code sZ}) about the pivot point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) to this matrix and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the scaling matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the scaling will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 scaleAround(float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ, @Mutated Double4x4 dest);

    /**
     * Apply a projection shadow transformation that projects geometry onto the given plane, cast
     * from the given light source (a direction when {@code light.w} is {@code 0}, a position when
     * it is {@code 1}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shadow matrix, then the new matrix will
     * be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shadow will be applied first.
     *
     * @param light the light direction or position ({@code w = 0} for a directional light,
     *        {@code w = 1} for a point light)
     * @param plane the plane equation {@code (a, b, c, d)} with {@code ax + by + cz + d = 0}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 shadow(Float4R light, Float4R plane, @Mutated Float4x4 dest);

    /**
     * Apply a projection shadow transformation that projects geometry onto the given plane, cast
     * from the given light source (a direction when {@code light.w} is {@code 0}, a position when
     * it is {@code 1}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shadow matrix, then the new matrix will
     * be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shadow will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param light the light direction or position ({@code w = 0} for a directional light,
     *        {@code w = 1} for a point light)
     * @param plane the plane equation {@code (a, b, c, d)} with {@code ax + by + cz + d = 0}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 shadow(Float4R light, Float4R plane, @Mutated Double4x4 dest);

    /**
     * Apply a projection shadow transformation that projects geometry onto the given plane, cast
     * from the given light source (a direction when {@code lightW} is {@code 0}, a position when it
     * is {@code 1}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shadow matrix, then the new matrix will
     * be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shadow will be applied first.
     *
     * @param lightX the {@code x} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightY the {@code y} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightZ the {@code z} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightW the {@code w} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param planeX the {@code x} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeY the {@code y} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeZ the {@code z} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeW the {@code w} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 shadow(float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW, @Mutated Float4x4 dest);

    /**
     * Apply a projection shadow transformation that projects geometry onto the given plane, cast
     * from the given light source (a direction when {@code lightW} is {@code 0}, a position when it
     * is {@code 1}) to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shadow matrix, then the new matrix will
     * be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shadow will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param lightX the {@code x} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightY the {@code y} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightZ the {@code z} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param lightW the {@code w} component of the vector {@code (lightX, lightY, lightZ, lightW)}
     * @param planeX the {@code x} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeY the {@code y} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeZ the {@code z} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param planeW the {@code w} component of the vector {@code (planeX, planeY, planeZ, planeW)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 shadow(float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW, @Mutated Double4x4 dest);

    /**
     * Apply a shearing transformation to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shearing matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shearing will be applied first.
     *
     * @param xy the shear of x proportional to y
     * @param xz the shear of x proportional to z
     * @param yx the shear of y proportional to x
     * @param yz the shear of y proportional to z
     * @param zx the shear of z proportional to x
     * @param zy the shear of z proportional to y
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 shear(float xy, float xz, float yx, float yz, float zx, float zy, @Mutated Float4x4 dest);

    /**
     * Apply a shearing transformation to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code S} the shearing matrix, then the new matrix
     * will be {@code M * S}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * S * v}, the shearing will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param xy the shear of x proportional to y
     * @param xz the shear of x proportional to z
     * @param yx the shear of y proportional to x
     * @param yz the shear of y proportional to z
     * @param zx the shear of z proportional to x
     * @param zy the shear of z proportional to y
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 shear(float xy, float xz, float yx, float yz, float zx, float zy, @Mutated Double4x4 dest);

    /**
     * Apply a transformation that restricts the view to one tile of a regular grid to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the tile matrix, then the new matrix will
     * be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the tile will be applied first.
     *
     * @param x the column index of the tile, in {@code [0, w)}
     * @param y the row index of the tile, in {@code [0, h)}
     * @param w the number of tiles along the x axis
     * @param h the number of tiles along the y axis
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 tile(float x, float y, float w, float h, @Mutated Float4x4 dest);

    /**
     * Apply a transformation that restricts the view to one tile of a regular grid to this matrix
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the tile matrix, then the new matrix will
     * be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the tile will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the column index of the tile, in {@code [0, w)}
     * @param y the row index of the tile, in {@code [0, h)}
     * @param w the number of tiles along the x axis
     * @param h the number of tiles along the y axis
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 tile(float x, float y, float w, float h, @Mutated Double4x4 dest);

    /**
     * Apply a translation by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     *
     * @param v the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 translate(Float3R v, @Mutated Float4x4 dest);

    /**
     * Apply a translation by {@code v} to this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code p} with the new matrix by using
     * {@code M * T * p}, the translation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 translate(Float3R v, @Mutated Double4x4 dest);

    /**
     * Apply a translation by ({@code x}, {@code y}, {@code z}) to this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 translate(float x, float y, float z, @Mutated Float4x4 dest);

    /**
     * Apply a translation by ({@code x}, {@code y}, {@code z}) to this matrix and store the result
     * in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code T} the translation matrix, then the new matrix
     * will be {@code M * T}. So when transforming a vector {@code v} with the new matrix by using
     * {@code M * T * v}, the translation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the translation offsets {@code (x, y, z)}
     * @param y the {@code y} component of the translation offsets {@code (x, y, z)}
     * @param z the {@code z} component of the translation offsets {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 translate(float x, float y, float z, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a trapezoid-crop transformation mapping the given trapezoid onto the
     * {@code [-1, +1]} clip square onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code C} the crop matrix, then the new matrix will
     * be {@code C * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code C * M * v}, the crop will be applied last.
     *
     * @param p0 the left corner of the shorter parallel edge of the trapezoid
     * @param p1 the right corner of the shorter parallel edge of the trapezoid
     * @param p2 the right corner of the longer parallel edge of the trapezoid
     * @param p3 the left corner of the longer parallel edge of the trapezoid
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 trapezoidCrop(Float2R p0, Float2R p1, Float2R p2, Float2R p3, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a trapezoid-crop transformation mapping the given trapezoid onto the
     * {@code [-1, +1]} clip square onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code C} the crop matrix, then the new matrix will
     * be {@code C * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code C * M * v}, the crop will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p0 the left corner of the shorter parallel edge of the trapezoid
     * @param p1 the right corner of the shorter parallel edge of the trapezoid
     * @param p2 the right corner of the longer parallel edge of the trapezoid
     * @param p3 the left corner of the longer parallel edge of the trapezoid
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 trapezoidCrop(Float2R p0, Float2R p1, Float2R p2, Float2R p3, @Mutated Double4x4 dest);

    /**
     * Pre-multiply a trapezoid-crop transformation mapping the given trapezoid onto the
     * {@code [-1, +1]} clip square onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code C} the crop matrix, then the new matrix will
     * be {@code C * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code C * M * v}, the crop will be applied last.
     *
     * @param p0X the {@code x} component of the vector {@code (p0X, p0Y)}
     * @param p0Y the {@code y} component of the vector {@code (p0X, p0Y)}
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param dest will hold the result
     * @return dest
     */
    Float4x4 trapezoidCrop(float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y, @Mutated Float4x4 dest);

    /**
     * Pre-multiply a trapezoid-crop transformation mapping the given trapezoid onto the
     * {@code [-1, +1]} clip square onto this matrix and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} matrix and {@code C} the crop matrix, then the new matrix will
     * be {@code C * M}. So when transforming a vector {@code v} with the new matrix by using
     * {@code C * M * v}, the crop will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p0X the {@code x} component of the vector {@code (p0X, p0Y)}
     * @param p0Y the {@code y} component of the vector {@code (p0X, p0Y)}
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 trapezoidCrop(float p0X, float p0Y, float p1X, float p1Y, float p2X, float p2Y, float p3X, float p3Y, @Mutated Double4x4 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 unproject(Float3R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 unproject(Float3R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 unproject(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 unproject(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 unproject(Float3R winCoords, Float4R viewport, @Mutated Float3 dest) { return unproject(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 unproject(Float3R winCoords, Float4R viewport, @Mutated Double3 dest) { return unproject(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 unproject(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Float3 dest) { return unproject(winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is inverted
     * internally) and the given viewport and store the result in {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 unproject(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Double3 dest) { return unproject(winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 unprojectInv(Float3R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 unprojectInv(Float3R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Float3 unprojectInv(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Float3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param dest will hold the result
     * @return dest
     */
    Double3 unprojectInv(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Double3 dest);

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 unprojectInv(Float3R winCoords, Float4R viewport, @Mutated Float3 dest) { return unprojectInv(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y, depth)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 unprojectInv(Float3R winCoords, Float4R viewport, @Mutated Double3 dest) { return unprojectInv(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Float3 unprojectInv(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Float3 dest) { return unprojectInv(winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into object space using this matrix (which is assumed
     * to be the inverse of a projection-view matrix) and the given viewport and store the result in
     * {@code dest}.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param winCoordsZ the {@code z} component of the window coordinates {@code (x, y, depth)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param dest will hold the result
     * @return dest
     */
    default Double3 unprojectInv(float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Double3 dest) { return unprojectInv(winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, dest); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectInvRay(Float2R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectInvRay(Float2R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectInvRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectInvRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectInvRay(Float2R winCoords, Float4R viewport, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir) { return unprojectInvRay(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectInvRay(Float2R winCoords, Float4R viewport, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir) { return unprojectInvRay(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectInvRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir) { return unprojectInvRay(winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * assumed to be the inverse of a projection-view matrix) and the given viewport, storing the
     * ray origin in {@code rayOrigin} and the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectInvRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir) { return unprojectInvRay(winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectRay(Float2R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectRay(Float2R winCoords, Float4R viewport, DepthRange depthRange, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param depthRange the clip-space depth range the projection maps onto
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    Float4x4 unprojectRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, DepthRange depthRange, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir);

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectRay(Float2R winCoords, Float4R viewport, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir) { return unprojectRay(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoords the window coordinates {@code (x, y)} to unproject
     * @param viewport the viewport {@code [x, y, width, height]}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectRay(Float2R winCoords, Float4R viewport, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir) { return unprojectRay(winCoords, viewport, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Float3 rayOrigin, @Mutated Float3 rayDir) { return unprojectRay(winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Unproject the given window coordinates into a ray in object space using this matrix (which is
     * inverted internally) and the given viewport, storing the ray origin in {@code rayOrigin} and
     * the ray direction in {@code rayDir}.
     * <p>
     * A projection whose far plane is at infinity is supported: the far point is then a point at
     * infinity and the ray direction is taken from it as a finite direction. A far plane whose
     * homogeneous w is at most {@code 2^-20} ({@code float}) / {@code 2^-40} ({@code double}) times
     * the near plane's is treated as being at infinity.
     * <p>
     * Uses {@link DepthRange#NEGATIVE_ONE_TO_ONE} for {@code depthRange}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param winCoordsX the {@code x} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param winCoordsY the {@code y} component of the window coordinates {@code (x, y)} to
     *        unproject
     * @param viewportX the {@code x} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportY the {@code y} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportZ the {@code z} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param viewportW the {@code w} component of the vector
     *        {@code (viewportX, viewportY, viewportZ, viewportW)}
     * @param rayOrigin will hold the origin of the ray
     * @param rayDir will hold the direction of the ray
     * @return this
     */
    default Float4x4 unprojectRay(float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW, @Mutated Double3 rayOrigin, @Mutated Double3 rayDir) { return unprojectRay(winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW, DepthRange.NEGATIVE_ONE_TO_ONE, rayOrigin, rayDir); }

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float4 mul(Float4R v, @Mutated Float4 dest);

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double4 mul(Float4R v, @Mutated Double4 dest);

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z, w)}
     * @param y the {@code y} component of the vector {@code (x, y, z, w)}
     * @param z the {@code z} component of the vector {@code (x, y, z, w)}
     * @param w the {@code w} component of the vector {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    Float4 mul(float x, float y, float z, float w, @Mutated Float4 dest);

    /**
     * Multiply this matrix by the given vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z, w)}
     * @param y the {@code y} component of the vector {@code (x, y, z, w)}
     * @param z the {@code z} component of the vector {@code (x, y, z, w)}
     * @param w the {@code w} component of the vector {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    Double4 mul(float x, float y, float z, float w, @Mutated Double4 dest);

    /**
     * Multiply this matrix by the given vector and store the result back into {@code v}.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Float4 mul(@Mutated Float4 v) { return mul(v, v); }

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param aabb the axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    FloatAABB transformAabb(FloatAABBR aabb, @Mutated FloatAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param aabb the axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    DoubleAABB transformAabb(FloatAABBR aabb, @Mutated DoubleAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    FloatAABB transformAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated FloatAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleAABB transformAabb(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated DoubleAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    FloatAABB transformAabb(Float3R min, Float3R max, @Mutated FloatAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    DoubleAABB transformAabb(Float3R min, Float3R max, @Mutated DoubleAABB dest);

    /**
     * Transform the given axis-aligned box by this matrix and compute the axis-aligned box
     * enclosing the result and store the result back into {@code aabb}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param aabb the axis-aligned bounding box (also receives the result)
     * @return {@code aabb}
     */
    default FloatAABB transformAabb(@Mutated FloatAABB aabb) { return transformAabb(aabb, aabb); }

    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformDirection(Float3R v, @Mutated Float3 dest);

    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformDirection(Float3R v, @Mutated Double3 dest);

    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformDirection(float x, float y, float z, @Mutated Float3 dest);

    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformDirection(float x, float y, float z, @Mutated Double3 dest);

    /**
     * Transform the given direction by this matrix, ignoring any translation and store the result
     * back into {@code v}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Float3 transformDirection(@Mutated Float3 v) { return transformDirection(v, v); }

    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformPosition(Float3R v, @Mutated Float3 dest);

    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformPosition(Float3R v, @Mutated Double3 dest);

    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformPosition(float x, float y, float z, @Mutated Float3 dest);

    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformPosition(float x, float y, float z, @Mutated Double3 dest);

    /**
     * Transform the given position by this matrix, treating it as a point with an implicit
     * {@code w = 1} and store the result back into {@code v}.
     * <p>
     * Only the affine part of this matrix is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Float3 transformPosition(@Mutated Float3 v) { return transformPosition(v, v); }

    /**
     * Transform {@code v} by this matrix and perform perspective division and store the result in
     * {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformProject(Float3R v, @Mutated Float3 dest);

    /**
     * Transform {@code v} by this matrix and perform perspective division and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformProject(Float3R v, @Mutated Double3 dest);

    /**
     * Transform ({@code x}, {@code y}, {@code z}) by this matrix and perform perspective division
     * and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Float3 transformProject(float x, float y, float z, @Mutated Float3 dest);

    /**
     * Transform ({@code x}, {@code y}, {@code z}) by this matrix and perform perspective division
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformProject(float x, float y, float z, @Mutated Double3 dest);

    /**
     * Transform {@code v} by this matrix and perform perspective division and store the result back
     * into {@code v}.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Float3 transformProject(@Mutated Float3 v) { return transformProject(v, v); }
    /** {@return the value of the {@code m00} element} */
    float m00();
    /** {@return the value of the {@code m01} element} */
    float m01();
    /** {@return the value of the {@code m02} element} */
    float m02();
    /** {@return the value of the {@code m03} element} */
    float m03();
    /** {@return the value of the {@code m10} element} */
    float m10();
    /** {@return the value of the {@code m11} element} */
    float m11();
    /** {@return the value of the {@code m12} element} */
    float m12();
    /** {@return the value of the {@code m13} element} */
    float m13();
    /** {@return the value of the {@code m20} element} */
    float m20();
    /** {@return the value of the {@code m21} element} */
    float m21();
    /** {@return the value of the {@code m22} element} */
    float m22();
    /** {@return the value of the {@code m23} element} */
    float m23();
    /** {@return the value of the {@code m30} element} */
    float m30();
    /** {@return the value of the {@code m31} element} */
    float m31();
    /** {@return the value of the {@code m32} element} */
    float m32();
    /** {@return the value of the {@code m33} element} */
    float m33();

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] storeCM(@Mutated float[] dest) { return storeCM(dest, 0); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    float[] storeCM(@Mutated float[] dest, int offset);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default FloatBuffer storeCM(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default FloatBuffer storeCMAbsolute(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
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
    default FloatBuffer storeCMRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default ByteBuffer storeCM(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default ByteBuffer storeCMAbsolute(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    ByteBuffer storeCMAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
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
    default ByteBuffer storeCMRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 64);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeCM(@Mutated MemorySegment dest) { return storeCM(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeCM(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Float4x4 storeCMUnsafe(long address);

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] storeCM(@Mutated double[] dest) { return storeCM(dest, 0); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    double[] storeCM(@Mutated double[] dest, int offset);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default DoubleBuffer storeCM(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default DoubleBuffer storeCMAbsolute(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
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
    default DoubleBuffer storeCMRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified).
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
    default ByteBuffer storeCMDouble(@Mutated ByteBuffer dest) { return storeCMDoubleAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified).
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
    default ByteBuffer storeCMDoubleAbsolute(@Mutated ByteBuffer dest) { return storeCMDoubleAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at the given absolute index (the position is not used or
     * modified).
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
    ByteBuffer storeCMDoubleAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position and advancing the position accordingly.
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
    default ByteBuffer storeCMDoubleRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeCMDoubleAbsolute(pos, dest);
        dest.position(pos + 128);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeCMDouble(@Mutated MemorySegment dest) { return storeCMDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeCMDouble(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Float4x4 storeCMDoubleUnsafe(long address);

    /**
     * Store the elements into the given array in row-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] storeRM(@Mutated float[] dest) { return storeRM(dest, 0); }

    /**
     * Store the elements into the given array in row-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    float[] storeRM(@Mutated float[] dest, int offset);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
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
    default FloatBuffer storeRM(@Mutated FloatBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
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
    default FloatBuffer storeRMAbsolute(@Mutated FloatBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
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
    FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
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
    default FloatBuffer storeRMRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
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
    default ByteBuffer storeRM(@Mutated ByteBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified).
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
    default ByteBuffer storeRMAbsolute(@Mutated ByteBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    ByteBuffer storeRMAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly.
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
    default ByteBuffer storeRMRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 64);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in row-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeRM(@Mutated MemorySegment dest) { return storeRM(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeRM(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address in row-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Float4x4 storeRMUnsafe(long address);

    /**
     * Store the elements into the given array in row-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] storeRM(@Mutated double[] dest) { return storeRM(dest, 0); }

    /**
     * Store the elements into the given array in row-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    double[] storeRM(@Mutated double[] dest, int offset);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
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
    default DoubleBuffer storeRM(@Mutated DoubleBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified).
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
    default DoubleBuffer storeRMAbsolute(@Mutated DoubleBuffer dest) { return storeRMAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified).
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
    DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly.
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
    default DoubleBuffer storeRMRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
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
    default ByteBuffer storeRMDouble(@Mutated ByteBuffer dest) { return storeRMDoubleAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
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
    default ByteBuffer storeRMDoubleAbsolute(@Mutated ByteBuffer dest) { return storeRMDoubleAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
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
    ByteBuffer storeRMDoubleAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
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
    default ByteBuffer storeRMDoubleRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeRMDoubleAbsolute(pos, dest);
        dest.position(pos + 128);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeRMDouble(@Mutated MemorySegment dest) { return storeRMDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    MemorySegment storeRMDouble(long offset, @Mutated MemorySegment dest);

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    Float4x4 storeRMDoubleUnsafe(long address);

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    float[] storeCM(@Mutated float[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeCM(@Mutated FloatBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    FloatBuffer storeCMAbsolute(int index, @Mutated FloatBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeCMRelative(@Mutated FloatBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + 4 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCM(@Mutated ByteBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeCMAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + (4 * stride) * 4);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in column-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default MemorySegment storeCM(@Mutated MemorySegment dest, int stride) { return storeCM(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    MemorySegment storeCM(long offset, @Mutated MemorySegment dest, int stride);

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Float4x4 storeCMUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    double[] storeCM(@Mutated double[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeCM(@Mutated DoubleBuffer dest, int stride) { return storeCMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    DoubleBuffer storeCMAbsolute(int index, @Mutated DoubleBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeCMRelative(@Mutated DoubleBuffer dest, int stride) {
        int pos = dest.position();
        storeCMAbsolute(pos, dest, stride);
        dest.position(pos + 4 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMDouble(@Mutated ByteBuffer dest, int stride) { return storeCMDoubleAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at the given absolute index (the position is not used or
     * modified), with {@code stride} elements between the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeCMDoubleAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in column-major order, converting each element
     * to {@code double}, starting at its current position and advancing the position accordingly,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeCMDoubleRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeCMDoubleAbsolute(pos, dest, stride);
        dest.position(pos + (4 * stride) * 8);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default MemorySegment storeCMDouble(@Mutated MemorySegment dest, int stride) { return storeCMDouble(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, converting each
     * element to {@code double}, starting at the given offset, with {@code stride} elements between
     * the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    MemorySegment storeCMDouble(long offset, @Mutated MemorySegment dest, int stride);

    /**
     * Store the elements into the given raw memory address in column-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Float4x4 storeCMDoubleUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in row-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    float[] storeRM(@Mutated float[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRM(@Mutated FloatBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    FloatBuffer storeRMAbsolute(int index, @Mutated FloatBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRMRelative(@Mutated FloatBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + 4 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRM(@Mutated ByteBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in row-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeRMAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in row-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + (4 * stride) * 4);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default MemorySegment storeRM(@Mutated MemorySegment dest, int stride) { return storeRM(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in row-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    MemorySegment storeRM(long offset, @Mutated MemorySegment dest, int stride);

    /**
     * Store the elements into the given raw memory address in row-major order, with {@code stride}
     * elements between the starts of consecutive columns/rows. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Float4x4 storeRMUnsafe(long address, int stride);

    /**
     * Store the elements into the given array in row-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    double[] storeRM(@Mutated double[] dest, int offset, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * (the position is not modified), with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRM(@Mutated DoubleBuffer dest, int stride) { return storeRMAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given buffer in row-major order, starting at the given absolute
     * index (the position is not used or modified), with {@code stride} elements between the starts
     * of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    DoubleBuffer storeRMAbsolute(int index, @Mutated DoubleBuffer dest, int stride);

    /**
     * Store the elements into the given buffer in row-major order, starting at its current position
     * and advancing the position accordingly, with {@code stride} elements between the starts of
     * consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRMRelative(@Mutated DoubleBuffer dest, int stride) {
        int pos = dest.position();
        storeRMAbsolute(pos, dest, stride);
        dest.position(pos + 4 * stride);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified), with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMDouble(@Mutated ByteBuffer dest, int stride) { return storeRMDoubleAbsolute(dest.position(), dest, stride); }

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    ByteBuffer storeRMDoubleAbsolute(int index, @Mutated ByteBuffer dest, int stride);

    /**
     * Store the elements into the given byte buffer in row-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRMDoubleRelative(@Mutated ByteBuffer dest, int stride) {
        int pos = dest.position();
        storeRMDoubleAbsolute(pos, dest, stride);
        dest.position(pos + (4 * stride) * 8);
        return dest;
    }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default MemorySegment storeRMDouble(@Mutated MemorySegment dest, int stride) { return storeRMDouble(0L, dest, stride); }

    /**
     * Store the elements into the given memory segment in row-major order, converting each element
     * to {@code double}, starting at the given offset, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    MemorySegment storeRMDouble(long offset, @Mutated MemorySegment dest, int stride);

    /**
     * Store the elements into the given raw memory address in row-major order, converting each
     * element to {@code double}, with {@code stride} elements between the starts of consecutive
     * columns/rows. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    Float4x4 storeRMDoubleUnsafe(long address, int stride);

    /** {@return whether all components of this matrix are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this matrix component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the matrix to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(Float4x4R other, float epsilon);

    /**
     * Compare this matrix with the given object for element-wise equality.
     * <p>
     * Each component is compared bitwise, as by {@code Float.floatToIntBits}: {@code 0.0} and
     * {@code -0.0} are not equal, and NaN is equal to NaN. Use {@link #equalsEpsilon} for a
     * tolerant comparison.
     * <p>
     * The cached structural property bits are ignored: two matrix objects holding the same elements
     * are equal whatever either one has determined about itself.
     * <p>
     * Only instances of this library's implementation compare equal to each other; any other object
     * yields {@code false}.
     *
     * @param obj the object to compare with
     * @return {@code true} if {@code obj} is a matrix of this library with element-wise equal
     *        components, {@code false} otherwise
     */
    boolean equals(@org.jspecify.annotations.Nullable Object obj);

    /**
     * Compute a hash code consistent with {@link #equals}: it is derived from the components via
     * {@code Float.floatToIntBits} alone, ignoring the cached structural property bits.
     *
     * @return the hash code of this matrix
     */
    int hashCode();

    /**
     * Numerically determine the structural properties of this matrix (identity, translation,
     * affinity) and return them as property bits.
     * <p>
     * This is a pure query: it does not update this matrix's cached property bits. The
     * mutating operations refresh the cache themselves.
     *
     * @return the determined property bits
     */
    int determineProperties();
    /** {@return whether this matrix is known to be the identity} O(1) read of the cached property bits; conservative. */
    boolean isIdentity();
    /** {@return whether this matrix is known to be a pure translation} O(1) read of the cached property bits; conservative. */
    boolean isTranslation();
    /** {@return whether this matrix is known to be orthogonal, i.e. its upper-left block is orthonormal with positive determinant (a proper rotation; a reflection is affine, not orthogonal)} O(1) read of the cached property bits; conservative. */
    boolean isOrthogonal();
    /** {@return whether this matrix is known to be affine} O(1) read of the cached property bits; conservative. */
    boolean isAffine();

    /**
     * Store the elements into the given array in column-major order.
     *
     * @param dest the destination array
     * @return dest
     */
    default float[] store(@Mutated float[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    default float[] store(@Mutated float[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default FloatBuffer store(@Mutated FloatBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    default FloatBuffer store(int index, @Mutated FloatBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
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
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    default double[] store(@Mutated double[] dest) { return storeCM(dest); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    default double[] store(@Mutated double[] dest, int offset) { return storeCM(dest, offset); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position (the position is not modified).
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
    default DoubleBuffer store(@Mutated DoubleBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified).
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
    default DoubleBuffer store(int index, @Mutated DoubleBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly.
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
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position (the position is not modified).
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
    default ByteBuffer store(@Mutated ByteBuffer dest) { return storeCMAbsolute(dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified).
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
    default ByteBuffer store(int index, @Mutated ByteBuffer dest) { return storeCMAbsolute(index, dest); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly.
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
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest) { return storeCMRelative(dest); }

    /**
     * Store the elements into the given memory segment in column-major order.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment store(@Mutated MemorySegment dest) { return storeCM(dest); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment store(long offset, @Mutated MemorySegment dest) { return storeCM(offset, dest); }

    /**
     * Store the elements into the given raw memory address in column-major order. No bounds or
     * liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    default Float4x4 storeUnsafe(long address) { return storeCMUnsafe(address); }

    /**
     * Store the elements into the given array in column-major order, starting at the given offset,
     * with {@code stride} elements between the starts of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default float[] store(@Mutated float[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

    /**
     * Store the elements into the given array in column-major order, converting each element to
     * {@code double}, starting at the given offset, with {@code stride} elements between the starts
     * of consecutive columns/rows.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default double[] store(@Mutated double[] dest, int offset, int stride) { return storeCM(dest, offset, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer store(int index, @Mutated FloatBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at the given absolute index (the position is not used or modified),
     * with {@code stride} elements between the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer store(int index, @Mutated DoubleBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given buffer in column-major order, converting each element to
     * {@code double}, starting at its current position and advancing the position accordingly, with
     * {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at the given
     * absolute index (the position is not used or modified), with {@code stride} elements between
     * the starts of consecutive columns/rows.
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
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer store(int index, @Mutated ByteBuffer dest, int stride) { return storeCMAbsolute(index, dest, stride); }

    /**
     * Store the elements into the given byte buffer in column-major order, starting at its current
     * position and advancing the position accordingly, with {@code stride} elements between the
     * starts of consecutive columns/rows.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination byte buffer
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest, int stride) { return storeCMRelative(dest, stride); }

    /**
     * Store the elements into the given memory segment in column-major order, starting at the given
     * offset, with {@code stride} elements between the starts of consecutive columns/rows.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return dest
     */
    default MemorySegment store(long offset, @Mutated MemorySegment dest, int stride) { return storeCM(offset, dest, stride); }

    /**
     * Store the elements into the given raw memory address in column-major order, with
     * {@code stride} elements between the starts of consecutive columns/rows. No bounds or liveness
     * checks are performed.
     *
     * @param address the raw memory address
     * @param stride the number of elements between the starts of consecutive columns/rows
     * @return this
     */
    default Float4x4 storeUnsafe(long address, int stride) { return storeCMUnsafe(address, stride); }

    /** Backs {@code ZERO()} and {@code IDENTITY()}: defers the shared instances'
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final Float4x4R IDENTITY = Joml.float4x4();
        static final Float4x4R ZERO = Joml.float4x4(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
