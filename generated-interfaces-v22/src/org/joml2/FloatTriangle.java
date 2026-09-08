package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * A triangle of single-precision {@code float} components.
 * <p>
 * Extends the read-only view {@link FloatTriangleR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface FloatTriangle extends FloatTriangleR {

    /**
     * Set this triangle to the given values.
     *
     * @param v the triangle
     * @return this
     */
    @Mutated FloatTriangle set(FloatTriangleR v);

    /**
     * Set this triangle to the given values.
     *
     * @param v0X the {@code v0X} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v0Y the {@code v0Y} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v0Z the {@code v0Z} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v1X the {@code v1X} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v1Y the {@code v1Y} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v1Z the {@code v1Z} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v2X the {@code v2X} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v2Y the {@code v2Y} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @param v2Z the {@code v2Z} component of the triangle
     *        {@code (v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z)}
     * @return this
     */
    @Mutated FloatTriangle set(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z);

    /**
     * Convert this triangle to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoubleTriangle} holding the result
     */
    default DoubleTriangle toDouble() { return toDouble(Joml.doubleTriangle()); }

    /**
     * Transform this triangle by {@code m}.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default FloatTriangle transform(Float3x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.floatTriangle() : this); }

    /**
     * Transform this triangle by {@code m}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default FloatTriangle transform(Float4x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.floatTriangle() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatTriangle load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatTriangle load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatTriangle loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatTriangle loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 36);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default FloatTriangle load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated FloatTriangle load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatTriangle loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatTriangle load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatTriangle load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatTriangle loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatTriangle loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle loadDouble(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle loadDoubleAbsolute(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatTriangle loadDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatTriangle loadDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadDoubleAbsolute(pos, src);
        src.position(pos + 72);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default FloatTriangle loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated FloatTriangle loadDouble(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatTriangle loadDoubleUnsafe(long address);
}
