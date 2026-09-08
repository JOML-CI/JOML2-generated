package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.lang.foreign.MemorySegment;

/**
 * An oriented bounding box of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleOBBR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleOBB extends DoubleOBBR {

    /**
     * Set this oriented bounding box to the given values.
     *
     * @param v the oriented bounding box
     * @return this
     */
    @Mutated DoubleOBB set(DoubleOBBR v);

    /**
     * Set this oriented bounding box to the given values.
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
     * @return this
     */
    @Mutated DoubleOBB set(double cX, double cY, double cZ, double uXx, double uXy, double uXz, double uYx, double uYy, double uYz, double uZx, double uZy, double uZz, double hsX, double hsY, double hsZ);

    /**
     * Set the local coordinate axes of this oriented bounding box to {@code axisX}, {@code axisY}
     * and {@code axisZ}.
     *
     * @param axisX the new local X axis
     * @param axisY the new local Y axis
     * @param axisZ the new local Z axis
     * @return this
     */
    @Mutated default DoubleOBB setAxes(Double3R axisX, Double3R axisY, Double3R axisZ) { return setAxes(axisX, axisY, axisZ, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the local coordinate axes of this oriented bounding box to ({@code axisXX},
     * {@code axisXY}, {@code axisXZ}), ({@code axisYX}, {@code axisYY}, {@code axisYZ}) and
     * ({@code axisZX}, {@code axisZY}, {@code axisZZ}).
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
     * @return this
     */
    @Mutated default DoubleOBB setAxes(double axisXX, double axisXY, double axisXZ, double axisYX, double axisYY, double axisYZ, double axisZX, double axisZY, double axisZZ) { return setAxes(axisXX, axisXY, axisXZ, axisYX, axisYY, axisYZ, axisZX, axisZY, axisZZ, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the center of this oriented bounding box to {@code c}.
     *
     * @param c the vector
     * @return this
     */
    @Mutated default DoubleOBB setCenter(Double3R c) { return setCenter(c, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the center of this oriented bounding box to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleOBB setCenter(double x, double y, double z) { return setCenter(x, y, z, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the half extents of this oriented bounding box to {@code h}.
     *
     * @param h the vector
     * @return this
     */
    @Mutated default DoubleOBB setHalfSize(Double3R h) { return setHalfSize(h, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the half extents of this oriented bounding box to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleOBB setHalfSize(double x, double y, double z) { return setHalfSize(x, y, z, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Reset the orientation of this oriented bounding box to identity.
     *
     * @return this
     */
    @Mutated default DoubleOBB setIdentityOrientation() { return setIdentityOrientation(Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the orientation of this oriented bounding box to {@code q}.
     *
     * @param q the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated default DoubleOBB setOrientation(DoubleQuatR q) { return setOrientation(q, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Set the orientation of this oriented bounding box to ({@code x}, {@code y}, {@code z},
     * {@code w}).
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
    @Mutated default DoubleOBB setOrientation(double x, double y, double z, double w) { return setOrientation(x, y, z, w, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Convert this oriented bounding box to {@code float} precision, returning the result as a new
     * instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatOBB} holding the result
     */
    default FloatOBB toFloat() { return toFloat(Joml.floatOBB()); }

    /**
     * Set this oriented bounding box to the identity.
     *
     * @return this
     */
    @Mutated DoubleOBB makeIdentity();

    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleOBB transform(Double3x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Transform this oriented bounding box by {@code m} (the axes are transformed without
     * renormalization).
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated default DoubleOBB transform(Double4x4R m) { return transform(m, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Translate this oriented bounding box by {@code delta}.
     *
     * @param delta the vector
     * @return this
     */
    @Mutated default DoubleOBB translate(Double3R delta) { return translate(delta, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Translate this oriented bounding box by ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleOBB translate(double x, double y, double z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.doubleOBB() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleOBB load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleOBB load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleOBB loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 15);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleOBB loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 120);
        return this;
    }

    /**
     * Load the elements from the given memory segment.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleOBB load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleOBB load(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleOBB loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleOBB load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleOBB load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleOBB loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleOBB loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 15);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleOBB loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleOBB loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 60);
        return this;
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float}.
     *
     * @param src the source memory segment
     * @return this
     */
    @Mutated default DoubleOBB loadFloat(MemorySegment src) { return loadFloat(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return this
     */
    @Mutated DoubleOBB loadFloat(long offset, MemorySegment src);

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleOBB loadFloatUnsafe(long address);
}
