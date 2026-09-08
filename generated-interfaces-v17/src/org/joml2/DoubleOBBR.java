package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * Read-only view of an oriented bounding box of double-precision {@code double} components.
 * <p>
 * Declares the accessors, queries, store methods and dest-form operations that read but never
 * mutate the receiver; the mutable counterpart is {@link DoubleOBB}. APIs that only read an
 * oriented bounding box should accept {@code DoubleOBBR}, so callers can pass mutable instances
 * without exposing them to modification.
 */
public interface DoubleOBBR {
    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 120;

    /** {@return a shared all-zero oriented bounding box} Never mutate it - it is returned as the read-only view for that reason. */
    public static DoubleOBBR ZERO() { return Holder.ZERO; }


    /**
     * Set the local coordinate axes of this oriented bounding box to {@code axisX}, {@code axisY}
     * and {@code axisZ} and store the result in {@code dest}.
     *
     * @param axisX the new local X axis
     * @param axisY the new local Y axis
     * @param axisZ the new local Z axis
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setAxes(Double3R axisX, Double3R axisY, Double3R axisZ, @Mutated DoubleOBB dest);

    /**
     * Set the local coordinate axes of this oriented bounding box to ({@code axisXX},
     * {@code axisXY}, {@code axisXZ}), ({@code axisYX}, {@code axisYY}, {@code axisYZ}) and
     * ({@code axisZX}, {@code axisZY}, {@code axisZZ}) and store the result in {@code dest}.
     *
     * @param axisXX the {@code x} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisXY the {@code y} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisXZ the {@code z} component of the vector {@code (axisXX, axisXY, axisXZ)}
     * @param axisYX the {@code x} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisYY the {@code y} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisYZ the {@code z} component of the vector {@code (axisYX, axisYY, axisYZ)}
     * @param axisZX the {@code x} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @param axisZY the {@code y} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @param axisZZ the {@code z} component of the vector {@code (axisZX, axisZY, axisZZ)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setAxes(double axisXX, double axisXY, double axisXZ, double axisYX, double axisYY, double axisYZ, double axisZX, double axisZY, double axisZZ, @Mutated DoubleOBB dest);

    /**
     * Set the center of this oriented bounding box to {@code c} and store the result in
     * {@code dest}.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setCenter(Double3R c, @Mutated DoubleOBB dest);

    /**
     * Set the center of this oriented bounding box to ({@code x}, {@code y}, {@code z}) and store
     * the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setCenter(double x, double y, double z, @Mutated DoubleOBB dest);

    /**
     * Set the half extents of this oriented bounding box to {@code h} and store the result in
     * {@code dest}.
     *
     * @param h the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setHalfSize(Double3R h, @Mutated DoubleOBB dest);

    /**
     * Set the half extents of this oriented bounding box to ({@code x}, {@code y}, {@code z}) and
     * store the result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setHalfSize(double x, double y, double z, @Mutated DoubleOBB dest);

    /**
     * Reset the orientation of this oriented bounding box to identity and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setIdentityOrientation(@Mutated DoubleOBB dest);

    /**
     * Set the orientation of this oriented bounding box to {@code q} and store the result in
     * {@code dest}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB setOrientation(DoubleQuatR q, @Mutated DoubleOBB dest);

    /**
     * Set the orientation of this oriented bounding box to ({@code x}, {@code y}, {@code z},
     * {@code w}) and store the result in {@code dest}.
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
    DoubleOBB setOrientation(double x, double y, double z, double w, @Mutated DoubleOBB dest);

    /**
     * Convert this oriented bounding box to {@code float} precision and store the result in
     * {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    FloatOBB toFloat(@Mutated FloatOBB dest);

    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB transform(Double3x4R m, @Mutated DoubleOBB dest);

    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization) and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB transform(Double4x4R m, @Mutated DoubleOBB dest);

    /**
     * Translate this oriented bounding box by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB translate(Double3R delta, @Mutated DoubleOBB dest);

    /**
     * Translate this oriented bounding box by ({@code x}, {@code y}, {@code z}) and store the
     * result in {@code dest}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    DoubleOBB translate(double x, double y, double z, @Mutated DoubleOBB dest);

    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param p the point
     * @param dest will hold the result
     * @return dest
     */
    Double3 closestPointToPoint(Double3R p, @Mutated Double3 dest);

    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     * <p>
     * The result is stored in {@code dest}; {@code this} is not modified.
     *
     * @param x the {@code x} component of the point {@code (x, y, z)}
     * @param y the {@code y} component of the point {@code (x, y, z)}
     * @param z the {@code z} component of the point {@code (x, y, z)}
     * @param dest will hold the result
     * @return dest
     */
    Double3 closestPointToPoint(double x, double y, double z, @Mutated Double3 dest);

    /**
     * Compute the point of this oriented bounding box closest to the given point, i.e. the point
     * expressed in the box's local frame, clamped per axis to the box's half extents and mapped
     * back to world space. For a point inside or on the box, the result is the point itself (up to
     * rounding). Assumes the box's axes are orthonormal.
     *
     * @param p the point (also receives the result)
     * @return {@code p}
     */
    default Double3 closestPointToPoint(@Mutated Double3 p) { return closestPointToPoint(p, p); }

    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param p the vector
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    boolean containsPoint(Double3R p);

    /**
     * Determine whether this oriented bounding box contains the given point (boundary inclusive).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return {@code true} if this oriented bounding box contains the given point (boundary
     *        inclusive), {@code false} otherwise
     */
    boolean containsPoint(double x, double y, double z);

    /**
     * Compute the squared distance between this oriented bounding box and the given point,
     * evaluated in the box's local frame; zero for a point inside or on the box. Assumes the box's
     * axes are orthonormal.
     *
     * @param p the point
     * @return the squared distance between this oriented bounding box and the given point,
     *        evaluated in the box's local frame; zero for a point inside or on the box. Assumes the
     *        box's axes are orthonormal
     */
    double distanceSquaredToPoint(Double3R p);

    /**
     * Compute the squared distance between this oriented bounding box and the given point,
     * evaluated in the box's local frame; zero for a point inside or on the box. Assumes the box's
     * axes are orthonormal.
     *
     * @param x the {@code x} component of the point {@code (x, y, z)}
     * @param y the {@code y} component of the point {@code (x, y, z)}
     * @param z the {@code z} component of the point {@code (x, y, z)}
     * @return the squared distance between this oriented bounding box and the given point,
     *        evaluated in the box's local frame; zero for a point inside or on the box. Assumes the
     *        box's axes are orthonormal
     */
    double distanceSquaredToPoint(double x, double y, double z);

    /**
     * Compute the distance between this oriented bounding box and the given point, evaluated in the
     * box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     * orthonormal.
     *
     * @param p the point
     * @return the distance between this oriented bounding box and the given point, evaluated in the
     *        box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     *        orthonormal
     */
    double distanceToPoint(Double3R p);

    /**
     * Compute the distance between this oriented bounding box and the given point, evaluated in the
     * box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     * orthonormal.
     *
     * @param x the {@code x} component of the point {@code (x, y, z)}
     * @param y the {@code y} component of the point {@code (x, y, z)}
     * @param z the {@code z} component of the point {@code (x, y, z)}
     * @return the distance between this oriented bounding box and the given point, evaluated in the
     *        box's local frame; zero for a point inside or on the box. Assumes the box's axes are
     *        orthonormal
     */
    double distanceToPoint(double x, double y, double z);

    /**
     * Get the local {@code X} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getAxisX(@Mutated Double3 dest);

    /**
     * Get the local {@code Y} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getAxisY(@Mutated Double3 dest);

    /**
     * Get the local {@code Z} axis of this oriented bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getAxisZ(@Mutated Double3 dest);

    /**
     * Get the center of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getCenter(@Mutated Double3 dest);

    /**
     * Get the half extents of this oriented bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    Double3 getHalfSize(@Mutated Double3 dest);

    /**
     * Determine whether this oriented bounding box intersects {@code o}.
     *
     * @param o the oriented bounding box
     * @return {@code true} if this oriented bounding box intersects {@code o}, {@code false}
     *        otherwise
     */
    boolean intersectsOBB(DoubleOBBR o);

    /**
     * Determine whether this oriented bounding box intersects ({@code cX}, {@code cY}, {@code cZ},
     * {@code uXx}, {@code uXy}, {@code uXz}, {@code uYx}, {@code uYy}, {@code uYz}, {@code uZx},
     * {@code uZy}, {@code uZz}, {@code hsX}, {@code hsY}, {@code hsZ}).
     *
     * @param cX the {@code cX} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param cY the {@code cY} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param cZ the {@code cZ} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uXx the {@code uXx} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uXy the {@code uXy} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uXz the {@code uXz} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uYx the {@code uYx} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uYy the {@code uYy} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uYz the {@code uYz} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uZx the {@code uZx} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uZy the {@code uZy} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param uZz the {@code uZz} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param hsX the {@code hsX} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param hsY the {@code hsY} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @param hsZ the {@code hsZ} component of the oriented bounding box
     *        {@code (cX, cY, cZ, uXx, uXy, uXz, uYx, uYy, uYz, uZx, uZy, uZz, hsX, hsY, hsZ)}
     * @return {@code true} if this oriented bounding box intersects ({@code cX}, {@code cY},
     *        {@code cZ}, {@code uXx}, {@code uXy}, {@code uXz}, {@code uYx}, {@code uYy},
     *        {@code uYz}, {@code uZx}, {@code uZy}, {@code uZz}, {@code hsX}, {@code hsY},
     *        {@code hsZ}), {@code false} otherwise
     */
    boolean intersectsOBB(double cX, double cY, double cZ, double uXx, double uXy, double uXz, double uYx, double uYy, double uYz, double uZx, double uZy, double uZz, double hsX, double hsY, double hsZ);

    /**
     * Determine whether this oriented bounding box is valid, i.e. none of its half extents is
     * negative.
     *
     * @return {@code true} if this oriented bounding box is valid, i.e. none of its half extents is
     *        negative, {@code false} otherwise
     */
    boolean isValid();
    /** {@return the value of the {@code cX} component} */
    double cX();
    /** {@return the value of the {@code cY} component} */
    double cY();
    /** {@return the value of the {@code cZ} component} */
    double cZ();
    /** {@return the value of the {@code uXx} component} */
    double uXx();
    /** {@return the value of the {@code uXy} component} */
    double uXy();
    /** {@return the value of the {@code uXz} component} */
    double uXz();
    /** {@return the value of the {@code uYx} component} */
    double uYx();
    /** {@return the value of the {@code uYy} component} */
    double uYy();
    /** {@return the value of the {@code uYz} component} */
    double uYz();
    /** {@return the value of the {@code uZx} component} */
    double uZx();
    /** {@return the value of the {@code uZy} component} */
    double uZy();
    /** {@return the value of the {@code uZz} component} */
    double uZz();
    /** {@return the value of the {@code hsX} component} */
    double hsX();
    /** {@return the value of the {@code hsY} component} */
    double hsY();
    /** {@return the value of the {@code hsZ} component} */
    double hsZ();

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
        dest.position(pos + 15);
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
        dest.position(pos + 120);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    DoubleOBB storeUnsafe(long address);

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
        dest.position(pos + 15);
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
        dest.position(pos + 60);
        return dest;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    DoubleOBB storeFloatUnsafe(long address);

    /** {@return whether all components of this oriented bounding box are finite, i.e. neither NaN nor infinite} */
    boolean isFinite();

    /**
     * Compare this oriented bounding box component-wise against {@code other}, allowing a difference
     * of at most {@code epsilon} per component.
     *
     * @param other the oriented bounding box to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    boolean equalsEpsilon(DoubleOBBR other, double epsilon);

    /** Backs {@code ZERO()}: defers the shared instance's
     *  allocation to first use, avoiding a class-initialization cycle with the
     *  implementation class. Not part of the public API. */
    final class Holder {
        private Holder() {}
        static final DoubleOBBR ZERO = Joml.doubleOBB(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
