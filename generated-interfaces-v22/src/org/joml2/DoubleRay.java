package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * A ray of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleRayR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleRay extends DoubleRayR {

    /**
     * Set this ray to the given values.
     *
     * @param v the ray
     * @return this
     */
    @Mutated DoubleRay set(DoubleRayR v);

    /**
     * Set this ray to the given values.
     *
     * @param oX the {@code oX} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @param oY the {@code oY} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @param oZ the {@code oZ} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @param dX the {@code dX} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @param dY the {@code dY} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @param dZ the {@code dZ} component of the ray {@code (oX, oY, oZ, dX, dY, dZ)}
     * @return this
     */
    @Mutated DoubleRay set(double oX, double oY, double oZ, double dX, double dY, double dZ);

    /**
     * Set the direction of this ray to {@code d}.
     *
     * @param d the vector
     * @return this
     */
    @Mutated default DoubleRay setDirection(Double3R d) { return setDirection(d, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Set the direction of this ray to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleRay setDirection(double x, double y, double z) { return setDirection(x, y, z, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Set the origin of this ray to {@code o}.
     *
     * @param o the vector
     * @return this
     */
    @Mutated default DoubleRay setOrigin(Double3R o) { return setOrigin(o, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Set the origin of this ray to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleRay setOrigin(double x, double y, double z) { return setOrigin(x, y, z, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Convert this ray to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatRay} holding the result
     */
    default FloatRay toFloat() { return toFloat(Joml.floatRay()); }

    /**
     * Transform this ray by {@code m}.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleRay transform(Double3x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Transform this ray by {@code m}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleRay transform(Double4x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleRay() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRay load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRay load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRay loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 6);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRay loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 48);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleRay load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleRay load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRay loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRay load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRay load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRay loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRay loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 6);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRay loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRay loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 24);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleRay loadFloat(MemorySegment src) { return loadFloat(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleRay loadFloat(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRay loadFloatUnsafe(long address);
}
