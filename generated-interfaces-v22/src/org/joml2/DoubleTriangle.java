package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * A triangle of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleTriangleR} with the mutating surface: in-place
 * self-forms, setters and load methods. A self-form operation writes its result to {@code this} and
 * returns it - unless the {@code joml.returnNew} mode is enabled, in which case it leaves
 * {@code this} unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleTriangle extends DoubleTriangleR {

    /**
     * Set this triangle to the given values.
     *
     * @param v the triangle
     * @return this
     */
    @Mutated DoubleTriangle set(DoubleTriangleR v);

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
    @Mutated DoubleTriangle set(double v0X, double v0Y, double v0Z, double v1X, double v1Y, double v1Z, double v2X, double v2Y, double v2Z);

    /**
     * Convert this triangle to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatTriangle} holding the result
     */
    default FloatTriangle toFloat() { return toFloat(Joml.floatTriangle()); }

    /**
     * Transform this triangle by {@code m}.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleTriangle transform(Double3x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleTriangle() : this); }

    /**
     * Transform this triangle by {@code m}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleTriangle transform(Double4x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleTriangle() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleTriangle load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleTriangle load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleTriangle loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadRelative(DoubleBuffer src) {
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
    @Mutated default DoubleTriangle load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleTriangle loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 72);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleTriangle load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleTriangle load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleTriangle loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleTriangle load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleTriangle load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleTriangle loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 9);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleTriangle loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleTriangle loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 36);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleTriangle loadFloat(MemorySegment src) { return loadFloat(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleTriangle loadFloat(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleTriangle loadFloatUnsafe(long address);
}
