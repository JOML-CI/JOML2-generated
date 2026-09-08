package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a quaternion of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link DoubleQuat}. APIs that only read a
 * quaternion should accept {@code DoubleQuatR}, so callers can pass mutable instances without
 * exposing them to modification.
 */
public interface DoubleQuatR {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 32;

    /** {@return a shared identity quaternion} Never mutate it - it is returned as the read-only view for that reason. */
    public static DoubleQuatR IDENTITY() { return Holder.IDENTITY; }
    /** {@return a shared all-zero quaternion} Never mutate it - it is returned as the read-only view for that reason. */
    public static DoubleQuatR ZERO() { return Holder.ZERO; }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat invert(@Mutated DoubleQuat dest);

    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat invertProduct(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Compute the inverse of the product of this quaternion and ({@code x}, {@code y}, {@code z},
     * {@code w}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat invertProduct(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat add(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Add ({@code x}, {@code y}, {@code z}, {@code w}) to this quaternion and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat add(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Negate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat negate(@Mutated DoubleQuat dest);

    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat sub(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Subtract ({@code x}, {@code y}, {@code z}, {@code w}) from this quaternion and store the
     * result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat sub(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Convert this quaternion to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatQuat toFloat(@Mutated FloatQuat dest);

    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest);

    /**
     * Compute the matrix representation of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double4x4 toMatrix(@Mutated Double4x4 dest);

    /**
     * Compute the 3x3 rotation matrix representation of this quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3x3 toMatrix3x3(@Mutated Double3x3 dest);

    /**
     * Compute the 3x4 matrix representation of this quaternion (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3x4 toMatrix3x4(@Mutated Double3x4 dest);

    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param swing will hold the swing
     * @param twist will hold the twist
     * @return this
     */
    DoubleQuat decomposeSwingTwist(Double3R axis, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist);

    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code x} followed by a
     * twist about {@code x}, storing them in {@code swing} and {@code twist} respectively, such
     * that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param swing will hold the swing
     * @param twist will hold the twist
     * @return this
     */
    DoubleQuat decomposeSwingTwist(double x, double y, double z, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist);

    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat getSwing(Double3R axis, @Mutated DoubleQuat dest);

    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to ({@code x},
     * {@code y}, {@code z}) in the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
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
    DoubleQuat getSwing(double x, double y, double z, @Mutated DoubleQuat dest);

    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat getTwist(Double3R axis, @Mutated DoubleQuat dest);

    /**
     * Extract the twist component of this quaternion: the rotation about ({@code x}, {@code y},
     * {@code z}) in the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
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
    DoubleQuat getTwist(double x, double y, double z, @Mutated DoubleQuat dest);

    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat lerp(DoubleQuatR other, double t, @Mutated DoubleQuat dest);

    /**
     * Linearly interpolate between this quaternion and ({@code x}, {@code y}, {@code z}, {@code w})
     * using the interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat lerp(double x, double y, double z, double w, double t, @Mutated DoubleQuat dest);

    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat nlerp(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest);

    /**
     * Interpolate between this quaternion and ({@code x}, {@code y}, {@code z}, {@code w}) using
     * the interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat nlerp(double x, double y, double z, double w, double alpha, @Mutated DoubleQuat dest);

    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat nlerpShortest(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest);

    /**
     * Interpolate along the shortest path between this quaternion and ({@code x}, {@code y},
     * {@code z}, {@code w}) using the interpolation factor {@code alpha} and normalize the result
     * and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat nlerpShortest(double x, double y, double z, double w, double alpha, @Mutated DoubleQuat dest);

    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * {@code target} using the interpolation factor {@code alpha} and store the result in
     * {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat slerp(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest);

    /**
     * Spherically interpolate between this quaternion (which must have unit length) and ({@code x},
     * {@code y}, {@code z}, {@code w}) using the interpolation factor {@code alpha} and store the
     * result in {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat slerp(double x, double y, double z, double w, double alpha, @Mutated DoubleQuat dest);

    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat slerpShortest(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest);

    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and ({@code x}, {@code y}, {@code z}, {@code w}) using the interpolation factor
     * {@code alpha} and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat slerpShortest(double x, double y, double z, double w, double alpha, @Mutated DoubleQuat dest);

    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param control0 the inner control quaternion associated with the start rotation
     * @param control1 the inner control quaternion associated with the end rotation
     * @param target the target rotation
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat squad(DoubleQuatR control0, DoubleQuatR control1, DoubleQuatR target, double t, @Mutated DoubleQuat dest);

    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param control0X the {@code x} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0Y the {@code y} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0Z the {@code z} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0W the {@code w} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control1X the {@code x} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1Y the {@code y} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1Z the {@code z} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1W the {@code w} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat squad(double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t, @Mutated DoubleQuat dest);

    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat mul(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Multiply this quaternion by ({@code x}, {@code y}, {@code z}, {@code w}) and store the result
     * in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat mul(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply the transformation {@code other} onto this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat preMul(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply the transformation ({@code x}, {@code y}, {@code z}, {@code w}) onto this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat preMul(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    double angle();

    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the angle in radians between this quaternion and {@code other}
     */
    double angleTo(DoubleQuatR other);

    /**
     * Compute the angle in radians between this quaternion and ({@code x}, {@code y}, {@code z},
     * {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return the angle in radians between this quaternion and ({@code x}, {@code y}, {@code z},
     *        {@code w})
     */
    double angleTo(double x, double y, double z, double w);

    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 axis(@Mutated Double3 dest);

    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat calculateW(@Mutated DoubleQuat dest);

    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat conjugate(@Mutated DoubleQuat dest);

    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length)
     * and store the result in {@code dest}.
     *
     * @param q the quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat conjugateBy(DoubleQuatR q, @Mutated DoubleQuat dest);

    /**
     * Conjugate this quaternion by ({@code x}, {@code y}, {@code z}, {@code w}), i.e. compute
     * {@code q * this * conj(q)} where {@code q} is the given quaternion (equal to
     * {@code q * this * q^-1} when it has unit length) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat conjugateBy(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other} and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat difference(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Compute the difference between this quaternion and ({@code x}, {@code y}, {@code z},
     * {@code w}), i.e. the rotation that, applied after {@code this}, results in ({@code x},
     * {@code y}, {@code z}, {@code w}) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat difference(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the dot product of this quaternion and {@code other}
     */
    double dot(DoubleQuatR other);

    /**
     * Compute the dot product of this quaternion and ({@code x}, {@code y}, {@code z}, {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return the dot product of this quaternion and ({@code x}, {@code y}, {@code z}, {@code w})
     */
    double dot(double x, double y, double z, double w);

    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat exp(@Mutated DoubleQuat dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesXYZ(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesXZY(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesYXZ(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesYZX(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesZXY(@Mutated Double3 dest);

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getEulerAnglesZYX(@Mutated Double3 dest);

    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param angularVel the angular velocity, in radians per second, applied in the reference frame
     * @param dt the time step
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat integrate(Double3R angularVel, double dt, @Mutated DoubleQuat dest);

    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dt the time step
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat integrate(double x, double y, double z, double dt, @Mutated DoubleQuat dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invNormalizedPositiveZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 invPositiveZ(@Mutated Double3 dest);

    /**
     * Compute the length of this quaternion.
     *
     * @return the length of this quaternion
     */
    double length();

    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    double lengthSquared();

    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat log(@Mutated DoubleQuat dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 negativeZ(@Mutated Double3 dest);

    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat normalize(@Mutated DoubleQuat dest);

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedNegativeZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 normalizedPositiveZ(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveX(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveY(@Mutated Double3 dest);

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 positiveZ(@Mutated Double3 dest);

    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat pow(double t, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply {@code other} onto this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code R * Q}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code R * Q * v}, the transformation of the operand will be applied last.
     * <p>
     * Identical to {@link #preMul}; the lower-case spelling is kept for JOML 1 source
     * compatibility.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat premul(DoubleQuatR other, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply ({@code x}, {@code y}, {@code z}, {@code w}) onto this quaternion and store the
     * result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code R * Q}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code R * Q * v}, the transformation of the operand will be applied last.
     * <p>
     * Identical to {@link #preMul}; the lower-case spelling is kept for JOML 1 source
     * compatibility.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat premul(double x, double y, double z, double w, @Mutated DoubleQuat dest);

    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateTowards(DoubleQuatR target, double step, @Mutated DoubleQuat dest);

    /**
     * Rotate this quaternion towards ({@code x}, {@code y}, {@code z}, {@code w}), by at most the
     * given maximum angle and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateTowards(double x, double y, double z, double w, double step, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat lookAlong(Double3R dir, Double3R up, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
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
    DoubleQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat preRotateX(double angle, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat preRotateY(double angle, @Mutated DoubleQuat dest);

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat preRotateZ(double angle, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateAxis(double angle, Double3R axis, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
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
    DoubleQuat rotateAxis(double angle, double x, double y, double z, @Mutated DoubleQuat dest);

    /**
     * Apply the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen) to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateTo(Double3R fromDir, Double3R toDir, @Mutated DoubleQuat dest);

    /**
     * Apply the rotation that rotates ({@code fromDirX}, {@code fromDirY}, {@code fromDirZ}) onto
     * ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit vectors; for opposite
     * vectors an arbitrary perpendicular rotation axis is chosen) to this quaternion and store the
     * result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ, @Mutated DoubleQuat dest);

    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateX(double angle, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateXZY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateY(double angle, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateYXZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateYZX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateZ(double angle, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateZXY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleQuat rotateZYX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest);

    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 transform(Double3R v, @Mutated Double3 dest);

    /**
     * Transform ({@code x}, {@code y}, {@code z}) by this quaternion and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 transform(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Transform {@code v} by this quaternion and store the result back into {@code v}.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Double3 transform(@Mutated Double3 v) { return transform(v, v); }

    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformInverse(Double3R v, @Mutated Double3 dest);

    /**
     * Transform ({@code x}, {@code y}, {@code z}) by the inverse of this quaternion (assumes a unit
     * quaternion) and store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 transformInverse(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result back into {@code v}.
     *
     * @param v the vector (also receives the result)
     * @return {@code v}
     */
    default Double3 transformInverse(@Mutated Double3 v) { return transformInverse(v, v); }
    /** {@return the value of the {@code x} component} */
    double x();
    /** {@return the value of the {@code y} component} */
    double y();
    /** {@return the value of the {@code z} component} */
    double z();
    /** {@return the value of the {@code w} component} */
    double w();

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
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer store(@Mutated DoubleBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeAbsolute(@Mutated DoubleBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default DoubleBuffer storeRelative(@Mutated DoubleBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 4);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer store(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeAbsolute(@Mutated ByteBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 32);
        return dest;
    }

    /**
     * Store the elements into the given memory segment.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment store(@Mutated MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
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
    DoubleQuat storeUnsafe(long address);

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
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer store(@Mutated FloatBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeAbsolute(@Mutated FloatBuffer dest) { return storeAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param dest the destination buffer
     * @return dest
     */
    FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer dest);

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param dest the destination buffer
     * @return dest
     */
    default FloatBuffer storeRelative(@Mutated FloatBuffer dest) {
        int pos = dest.position();
        storeAbsolute(pos, dest);
        dest.position(pos + 4);
        return dest;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloat(@Mutated ByteBuffer dest) { return storeFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloatAbsolute(@Mutated ByteBuffer dest) { return storeFloatAbsolute(dest.position(), dest); }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param dest the destination byte buffer
     * @return dest
     */
    ByteBuffer storeFloatAbsolute(int index, @Mutated ByteBuffer dest);

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param dest the destination byte buffer
     * @return dest
     */
    default ByteBuffer storeFloatRelative(@Mutated ByteBuffer dest) {
        int pos = dest.position();
        storeFloatAbsolute(pos, dest);
        dest.position(pos + 16);
        return dest;
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float}.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    default MemorySegment storeFloat(@Mutated MemorySegment dest) { return storeFloat(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float},
     * starting at the given offset.
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
    DoubleQuat storeFloatUnsafe(long address);

    /** {@return whether all components of this quaternion are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this quaternion component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the quaternion to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(DoubleQuatR other, double epsilon);

    /** Backs {@code ZERO()} and {@code IDENTITY()}: defers the shared instances'
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final DoubleQuatR IDENTITY = Joml.doubleQuat();
        static final DoubleQuatR ZERO = Joml.doubleQuat(0, 0, 0, 0);
    }
}
