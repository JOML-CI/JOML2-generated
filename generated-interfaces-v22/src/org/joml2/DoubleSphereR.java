package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a sphere of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link DoubleSphere}. APIs that only read a
 * sphere should accept {@code DoubleSphereR}, so callers can pass mutable instances without
 * exposing them to modification.
 */
public interface DoubleSphereR {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 32;

    /** {@return a shared all-zero sphere} Never mutate it - it is returned as the read-only view for that reason. */
    public static DoubleSphereR ZERO() { return Holder.ZERO; }


    /**
     * Set the center of this sphere to {@code c} and store the result in {@code dest}.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere setCenter(Double3R c, @Mutated DoubleSphere dest);

    /**
     * Set the center of this sphere to ({@code x}, {@code y}, {@code z}) and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere setCenter(double x, double y, double z, @Mutated DoubleSphere dest);

    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere setRadius(double radius, @Mutated DoubleSphere dest);

    /**
     * Convert this sphere to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatSphere toFloat(@Mutated FloatSphere dest);

    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere transform(Double3x4R m, @Mutated DoubleSphere dest);

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
    DoubleSphere transform(Double4x4R m, @Mutated DoubleSphere dest);

    /**
     * Translate this sphere by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere translate(Double3R delta, @Mutated DoubleSphere dest);

    /**
     * Translate this sphere by ({@code x}, {@code y}, {@code z}) and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleSphere translate(double x, double y, double z, @Mutated DoubleSphere dest);

    /**
     * Get the center of this sphere and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getCenter(@Mutated Double3 dest);

    /**
     * Determine whether this sphere is valid, i.e. its radius is not negative.
     *
     * @return {@code true} if this sphere is valid, i.e. its radius is not negative, {@code false}
     *        otherwise
     */
    boolean isValid();
    /** {@return the value of the {@code x} component} */
    double x();
    /** {@return the value of the {@code y} component} */
    double y();
    /** {@return the value of the {@code z} component} */
    double z();
    /** {@return the value of the {@code r} component} */
    double r();

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
    DoubleSphere storeUnsafe(long address);

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
    DoubleSphere storeFloatUnsafe(long address);

    /** {@return whether all components of this sphere are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this sphere component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the sphere to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(DoubleSphereR other, double epsilon);

    /**
     * Determine whether this sphere contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectiond} kernels.
     *
     * @param px the x coordinate of the point
     * @param py the y coordinate of the point
     * @param pz the z coordinate of the point
     * @return {@code true} if the given point lies inside or on this sphere, {@code false}
     *        otherwise
     */
    boolean containsPoint(double px, double py, double pz);

    /**
     * Determine whether this sphere contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectiond} kernels.
     *
     * @param p the point
     * @return {@code true} if the given point lies inside or on this sphere, {@code false}
     *        otherwise
     */
    boolean containsPoint(Double3R p);

    /**
     * Determine whether this sphere intersects the given sphere. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param o the other sphere
     * @return {@code true} if this sphere and the given sphere intersect, {@code false} otherwise
     */
    boolean intersectsSphere(DoubleSphereR o);

    /**
     * Determine whether this sphere intersects the given axis-aligned box. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param aabb the axis-aligned box
     * @return {@code true} if this sphere and the given axis-aligned box intersect, {@code false}
     *        otherwise
     */
    boolean intersectsAABB(DoubleAABBR aabb);

    /**
     * Determine whether this sphere intersects the given plane. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param plane the plane
     * @return {@code true} if this sphere and the given plane intersect, {@code false} otherwise
     */
    boolean intersectsPlane(DoublePlaneR plane);

    /**
     * Determine whether this sphere intersects the given ray. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param ray the ray
     * @return {@code true} if this sphere and the given ray intersect, {@code false} otherwise
     */
    boolean intersectsRay(DoubleRayR ray);

    /** Backs {@code ZERO()}: defers the shared instance's
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final DoubleSphereR ZERO = Joml.doubleSphere(0, 0, 0, 0);
    }
}
