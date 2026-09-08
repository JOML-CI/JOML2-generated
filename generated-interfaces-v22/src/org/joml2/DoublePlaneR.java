package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * Read-only view of a plane of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link DoublePlane}. APIs that only read a plane
 * should accept {@code DoublePlaneR}, so callers can pass mutable instances without exposing them
 * to modification.
 */
public interface DoublePlaneR {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 32;

    /** {@return a shared all-zero plane} Never mutate it - it is returned as the read-only view for that reason. */
    public static DoublePlaneR ZERO() { return Holder.ZERO; }


    /**
     * Set the normal of this plane to {@code n} and store the result in {@code dest}.
     *
     * @param n the normal
     * @param dest will hold the result
     * @return dest
     */
    DoublePlane setNormal(Double3R n, @Mutated DoublePlane dest);

    /**
     * Set the normal of this plane to ({@code x}, {@code y}, {@code z}) and store the result in
     * {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoublePlane setNormal(double x, double y, double z, @Mutated DoublePlane dest);

    /**
     * Convert this plane to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatPlane toFloat(@Mutated FloatPlane dest);

    /**
     * Normalize this plane, scaling {@code (a, b, c, d)} so that the normal {@code (a, b, c)} has
     * unit length and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoublePlane normalize(@Mutated DoublePlane dest);

    /**
     * Compute the (unsigned) distance between this plane and the given point. The plane's normal
     * need not be of unit length: the result is divided by that normal's length.
     *
     * @param p the point
     * @return the (unsigned) distance between this plane and the given point. The plane's normal
     *        need not be of unit length: the result is divided by that normal's length
     */
    double distanceToPoint(Double3R p);

    /**
     * Compute the (unsigned) distance between this plane and the given point. The plane's normal
     * need not be of unit length: the result is divided by that normal's length.
     *
     * @param x the {@code x} component of the point {@code (x, y, z)}
     * @param y the {@code y} component of the point {@code (x, y, z)}
     * @param z the {@code z} component of the point {@code (x, y, z)}
     * @return the (unsigned) distance between this plane and the given point. The plane's normal
     *        need not be of unit length: the result is divided by that normal's length
     */
    double distanceToPoint(double x, double y, double z);

    /**
     * Get the normal of this plane and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getNormal(@Mutated Double3 dest);
    /** {@return the value of the {@code a} component} */
    double a();
    /** {@return the value of the {@code b} component} */
    double b();
    /** {@return the value of the {@code c} component} */
    double c();
    /** {@return the value of the {@code d} component} */
    double d();

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
    DoublePlane storeUnsafe(long address);

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
    DoublePlane storeFloatUnsafe(long address);

    /** {@return whether all components of this plane are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this plane component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the plane to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(DoublePlaneR other, double epsilon);

    /**
     * Compute the signed distance of the given point to this plane. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @return the signed distance from the given point to this plane - positive on the side the
     *        plane normal points to, and a true distance even when that normal is not unit length
     */
    double signedDistance(double pX, double pY, double pZ);

    /**
     * Compute the signed distance of the given point to this plane. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param p the point
     * @return the signed distance from the given point to this plane - positive on the side the
     *        plane normal points to, and a true distance even when that normal is not unit length
     */
    double signedDistance(Double3R p);

    /**
     * Project the given point onto this plane.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @param dest will hold the orthogonal projection of the given point onto this plane
     * @return {@code dest}
     */
    Double3 projectPoint(double pX, double pY, double pZ, @Mutated Double3 dest);

    /**
     * Project the given point onto this plane.
     *
     * @param p the point
     * @param dest will hold the orthogonal projection of the given point onto this plane
     * @return {@code dest}
     */
    Double3 projectPoint(Double3R p, @Mutated Double3 dest);

    /**
     * Determine whether this plane contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectiond} kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @param epsilon the maximum distance from the plane at which the point still counts as lying
     *        on it
     * @return {@code true} if the given point lies within {@code epsilon} of this plane,
     *        {@code false} otherwise
     */
    boolean containsPoint(double pX, double pY, double pZ, double epsilon);

    /**
     * Determine whether this plane contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectiond} kernels.
     *
     * @param p the point
     * @param epsilon the maximum distance from the plane at which the point still counts as lying
     *        on it
     * @return {@code true} if the given point lies within {@code epsilon} of this plane,
     *        {@code false} otherwise
     */
    boolean containsPoint(Double3R p, double epsilon);

    /**
     * Determine whether this plane intersects the given sphere. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param sph the sphere
     * @return {@code true} if this plane and the given sphere intersect, {@code false} otherwise
     */
    boolean intersectsSphere(DoubleSphereR sph);

    /**
     * Determine whether this plane intersects the given axis-aligned box. Delegates to the shared
     * {@code Intersectiond} kernels.
     *
     * @param box the axis-aligned box
     * @return {@code true} if this plane and the given axis-aligned box intersect, {@code false}
     *        otherwise
     */
    boolean intersectsAABB(DoubleAABBR box);

    /** Backs {@code ZERO()}: defers the shared instance's
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final DoublePlaneR ZERO = Joml.doublePlane(0, 0, 0, 0);
    }
}
