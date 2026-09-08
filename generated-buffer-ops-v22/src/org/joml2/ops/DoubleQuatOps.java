package org.joml2.ops;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.kernels.*;
import org.joml2.internal.unsafe.*;

/**
 * Static, allocation-free operations on raw storage holding a {@link DoubleQuat}.
 *
 * <p>Each method takes one or more buffers ({@code double[]},
 * {@link java.nio.DoubleBuffer}, {@link java.nio.ByteBuffer}, or
 * {@link java.lang.foreign.MemorySegment}) plus an element/byte offset and operates
 * directly on that storage. No {@link DoubleQuat} instance is allocated;
 * the array overloads and the Unsafe-backed buffer fast paths never allocate at all.
 * The portable fallback taken for heap {@code ByteBuffer}s, read-only buffers, and the
 * API backend may wrap buffers in lightweight {@link java.lang.foreign.MemorySegment} views.</p>
 *
 * <p>All buffer parameters in a single call must use the same storage backing,
 * except the {@code copy} methods, which translate between any two backings.
 * Elements are laid out in component order (the canonical DoubleQuat storage order).</p>
 *
 * <p>Each method summary below is the one the {@link DoubleQuat} API carries, so
 * the two can never describe the same operation differently: "this quaternion" there is the
 * quaternion held in {@code src} at {@code srcOffset}, and the result is written to
 * {@code dest} at {@code destOffset}. The full text sits on the {@code double[]} overload of
 * each method; the other storage overloads point at it, differing from it in
 * storage alone.</p>
 */
public final class DoubleQuatOps {
    private DoubleQuatOps() {}

    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invert(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest[destOffset + 0] = -(_selfx * _t3_inv);
        dest[destOffset + 1] = -(_selfy * _t3_inv);
        dest[destOffset + 2] = -(_selfz * _t3_inv);
        dest[destOffset + 3] = _selfw * _t3_inv;
        return dest;
    }

    /** {@link #invert(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invert(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invert_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invert_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invert(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invert(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invert_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invert_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invert(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invert(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invert_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invert_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invert(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invert(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invert_unsafe(dest, src);
        invert(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] invertProduct(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t21 = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        double _t22 = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        double _t23 = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        double _t24 = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dest[destOffset + 0] = -(_t21 * _t28_inv);
        dest[destOffset + 1] = -(_t23 * _t28_inv);
        dest[destOffset + 2] = -(_t22 * _t28_inv);
        dest[destOffset + 3] = _t24 * _t28_inv;
        return dest;
    }

    /** {@link #invertProduct(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invertProduct(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invertProduct_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.invertProduct_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #invertProduct(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invertProduct(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invertProduct_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.invertProduct_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #invertProduct(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invertProduct(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invertProduct_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.invertProduct_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #invertProduct(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invertProduct(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invertProduct_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        invertProduct(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invertProduct(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        double _t21 = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        double _t22 = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        double _t23 = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        double _t24 = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dest[destOffset + 0] = -(_t21 * _t28_inv);
        dest[destOffset + 1] = -(_t23 * _t28_inv);
        dest[destOffset + 2] = -(_t22 * _t28_inv);
        dest[destOffset + 3] = _t24 * _t28_inv;
        return dest;
    }

    /** {@link #invertProduct(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invertProduct(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invertProduct_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invertProduct_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #invertProduct(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invertProduct(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invertProduct_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.invertProduct_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #invertProduct(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invertProduct(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.invertProduct_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.invertProduct_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #invertProduct(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invertProduct(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invertProduct_unsafe(dest, src, other);
        invertProduct(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] add(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = otherX + _selfx;
        dest[destOffset + 1] = otherY + _selfy;
        dest[destOffset + 2] = otherZ + _selfz;
        dest[destOffset + 3] = otherW + _selfw;
        return dest;
    }

    /** {@link #add(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer add(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.add_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.add_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #add(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer add(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.add_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.add_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #add(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment add(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.add_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.add_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #add(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long add(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.add_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        add(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] add(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _otherx + _selfx;
        dest[destOffset + 1] = _othery + _selfy;
        dest[destOffset + 2] = _otherz + _selfz;
        dest[destOffset + 3] = _otherw + _selfw;
        return dest;
    }

    /** {@link #add(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer add(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.add_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.add_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #add(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer add(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.add_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.add_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #add(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment add(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.add_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.add_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #add(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long add(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.add_unsafe(dest, src, other);
        add(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Negate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] negate(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -_selfx;
        dest[destOffset + 1] = -_selfy;
        dest[destOffset + 2] = -_selfz;
        dest[destOffset + 3] = -_selfw;
        return dest;
    }

    /** {@link #negate(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer negate(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.negate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.negate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negate(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer negate(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.negate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.negate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negate(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment negate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.negate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.negate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negate(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long negate(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.negate_unsafe(dest, src);
        negate(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] sub(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = _selfx - otherX;
        dest[destOffset + 1] = _selfy - otherY;
        dest[destOffset + 2] = _selfz - otherZ;
        dest[destOffset + 3] = _selfw - otherW;
        return dest;
    }

    /** {@link #sub(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer sub(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.sub_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.sub_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #sub(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer sub(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.sub_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.sub_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #sub(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment sub(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.sub_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.sub_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #sub(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long sub(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.sub_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        sub(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] sub(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = _selfx - _otherx;
        dest[destOffset + 1] = _selfy - _othery;
        dest[destOffset + 2] = _selfz - _otherz;
        dest[destOffset + 3] = _selfw - _otherw;
        return dest;
    }

    /** {@link #sub(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer sub(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.sub_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.sub_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #sub(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer sub(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.sub_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.sub_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #sub(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment sub(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.sub_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.sub_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #sub(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long sub(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.sub_unsafe(dest, src, other);
        sub(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the given values.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param vX the {@code x} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @return {@code dest}
     */
    public static double[] set(double[] dest, int destOffset, double vX, double vY, double vZ, double vW) {
        dest[destOffset + 0] = vX;
        dest[destOffset + 1] = vY;
        dest[destOffset + 2] = vZ;
        dest[destOffset + 3] = vW;
        return dest;
    }

    /** {@link #set(double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer set(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.set_unsafe(dest, destOffset, vX, vY, vZ, vW);
        return DoubleQuatOpsKernelsTypedBuffer.set_api(dest, destOffset, vX, vY, vZ, vW);
    }

    /** {@link #set(double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer set(java.nio.ByteBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.set_unsafe(dest, destOffset, vX, vY, vZ, vW);
        return DoubleQuatOpsKernelsByteBuffer.set_api(dest, destOffset, vX, vY, vZ, vW);
    }

    /** {@link #set(double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment set(java.lang.foreign.MemorySegment dest, long destOffset, double vX, double vY, double vZ, double vW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.set_unsafe(dest, destOffset, vX, vY, vZ, vW);
        return DoubleQuatOpsKernelsSegment.set_api(dest, destOffset, vX, vY, vZ, vW);
    }

    /** {@link #set(double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long set(long dest, double vX, double vY, double vZ, double vW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.set_unsafe(dest, vX, vY, vZ, vW);
        set(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, vX, vY, vZ, vW);
        return dest;
    }

    /**
     * Set this quaternion to the given values.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param v the storage holding the quaternion
     * @param vOffset the element index in {@code v} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] set(double[] dest, int destOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        double _vw = v[vOffset + 3];
        dest[destOffset + 0] = _vx;
        dest[destOffset + 1] = _vy;
        dest[destOffset + 2] = _vz;
        dest[destOffset + 3] = _vw;
        return dest;
    }

    /** {@link #set(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer set(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && v.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.set_unsafe(dest, destOffset, v, vOffset);
        return DoubleQuatOpsKernelsTypedBuffer.set_api(dest, destOffset, v, vOffset);
    }

    /** {@link #set(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer set(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && v.isDirect()) return DoubleQuatOpsKernelsByteBuffer.set_unsafe(dest, destOffset, v, vOffset);
        return DoubleQuatOpsKernelsByteBuffer.set_api(dest, destOffset, v, vOffset);
    }

    /** {@link #set(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment set(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && v.isNative()) return DoubleQuatOpsKernelsSegment.set_unsafe(dest, destOffset, v, vOffset);
        return DoubleQuatOpsKernelsSegment.set_api(dest, destOffset, v, vOffset);
    }

    /** {@link #set(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long set(long dest, long v) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.set_unsafe(dest, v);
        set(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(v, 32L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param dqRX the {@code rX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRY the {@code rY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRZ the {@code rZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRW the {@code rW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDX the {@code dX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDY the {@code dY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDZ the {@code dZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDW the {@code dW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @return {@code dest}
     */
    public static double[] makeFromDualQuat(double[] dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        dest[destOffset + 0] = dqRX;
        dest[destOffset + 1] = dqRY;
        dest[destOffset + 2] = dqRZ;
        dest[destOffset + 3] = dqRW;
        return dest;
    }

    /** {@link #makeFromDualQuat(double[], int, double, double, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeFromDualQuat(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeFromDualQuat_unsafe(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return DoubleQuatOpsKernelsTypedBuffer.makeFromDualQuat_api(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
    }

    /** {@link #makeFromDualQuat(double[], int, double, double, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeFromDualQuat(java.nio.ByteBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeFromDualQuat_unsafe(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return DoubleQuatOpsKernelsByteBuffer.makeFromDualQuat_api(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
    }

    /** {@link #makeFromDualQuat(double[], int, double, double, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeFromDualQuat(java.lang.foreign.MemorySegment dest, long destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeFromDualQuat_unsafe(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return DoubleQuatOpsKernelsSegment.makeFromDualQuat_api(dest, destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
    }

    /** {@link #makeFromDualQuat(double[], int, double, double, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeFromDualQuat(long dest, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeFromDualQuat_unsafe(dest, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        makeFromDualQuat(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param m the storage holding the matrix
     * @param mOffset the element index in {@code m} at which the matrix starts
     * @return {@code dest}
     */
    public static double[] makeFromMatrixMat3x3(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m10 = m[mOffset + 1];
        double _m20 = m[mOffset + 2];
        double _m01 = m[mOffset + 3];
        double _m11 = m[mOffset + 4];
        double _m21 = m[mOffset + 5];
        double _m02 = m[mOffset + 6];
        double _m12 = m[mOffset + 7];
        double _m22 = m[mOffset + 8];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t1 * _t18;
            dest[destOffset + 1] = 0.5 * _t7 * _t18;
            dest[destOffset + 2] = 0.5 * _t9 * _t18;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t14);
        } else {
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
                    dest[destOffset + 0] = 0.5 * _t4 * _t19;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t16);
                    dest[destOffset + 2] = 0.5 * _t8 * _t19;
                    dest[destOffset + 3] = 0.5 * _t7 * _t19;
                } else {
                    dest[destOffset + 0] = 0.5 * _t6 * _t20;
                    dest[destOffset + 1] = 0.5 * _t8 * _t20;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t17);
                    dest[destOffset + 3] = 0.5 * _t9 * _t20;
                }
            }
        }
        return dest;
    }

    /** {@link #makeFromMatrixMat3x3(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeFromMatrixMat3x3(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat3x3_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat3x3_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x3(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeFromMatrixMat3x3(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat3x3_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat3x3_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x3(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && m.isNative()) return DoubleQuatOpsKernelsSegment.makeFromMatrixMat3x3_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsSegment.makeFromMatrixMat3x3_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x3(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeFromMatrixMat3x3(long dest, long m) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeFromMatrixMat3x3_unsafe(dest, m);
        makeFromMatrixMat3x3(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(m, 72L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param m the storage holding the matrix
     * @param mOffset the element index in {@code m} at which the matrix starts
     * @return {@code dest}
     */
    public static double[] makeFromMatrixMat3x4(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m01 = m[mOffset + 1];
        double _m02 = m[mOffset + 2];
        double _m10 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m12 = m[mOffset + 6];
        double _m20 = m[mOffset + 8];
        double _m21 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t1 * _t18;
            dest[destOffset + 1] = 0.5 * _t7 * _t18;
            dest[destOffset + 2] = 0.5 * _t9 * _t18;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t14);
        } else {
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
                    dest[destOffset + 0] = 0.5 * _t4 * _t19;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t16);
                    dest[destOffset + 2] = 0.5 * _t8 * _t19;
                    dest[destOffset + 3] = 0.5 * _t7 * _t19;
                } else {
                    dest[destOffset + 0] = 0.5 * _t6 * _t20;
                    dest[destOffset + 1] = 0.5 * _t8 * _t20;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t17);
                    dest[destOffset + 3] = 0.5 * _t9 * _t20;
                }
            }
        }
        return dest;
    }

    /** {@link #makeFromMatrixMat3x4(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeFromMatrixMat3x4(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat3x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat3x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x4(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeFromMatrixMat3x4(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat3x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat3x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x4(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && m.isNative()) return DoubleQuatOpsKernelsSegment.makeFromMatrixMat3x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsSegment.makeFromMatrixMat3x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat3x4(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeFromMatrixMat3x4(long dest, long m) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeFromMatrixMat3x4_unsafe(dest, m);
        makeFromMatrixMat3x4(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(m, 96L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param m the storage holding the matrix
     * @param mOffset the element index in {@code m} at which the matrix starts
     * @return {@code dest}
     */
    public static double[] makeFromMatrixMat4x4(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m10 = m[mOffset + 1];
        double _m20 = m[mOffset + 2];
        double _m01 = m[mOffset + 4];
        double _m11 = m[mOffset + 5];
        double _m21 = m[mOffset + 6];
        double _m02 = m[mOffset + 8];
        double _m12 = m[mOffset + 9];
        double _m22 = m[mOffset + 10];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t1 * _t18;
            dest[destOffset + 1] = 0.5 * _t7 * _t18;
            dest[destOffset + 2] = 0.5 * _t9 * _t18;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t14);
        } else {
            if (_m00 > _t2) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t15);
                dest[destOffset + 1] = 0.5 * _t4 * _t21;
                dest[destOffset + 2] = 0.5 * _t6 * _t21;
                dest[destOffset + 3] = 0.5 * _t1 * _t21;
            } else {
                if (_m11 > _m22) {
                    dest[destOffset + 0] = 0.5 * _t4 * _t19;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t16);
                    dest[destOffset + 2] = 0.5 * _t8 * _t19;
                    dest[destOffset + 3] = 0.5 * _t7 * _t19;
                } else {
                    dest[destOffset + 0] = 0.5 * _t6 * _t20;
                    dest[destOffset + 1] = 0.5 * _t8 * _t20;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t17);
                    dest[destOffset + 3] = 0.5 * _t9 * _t20;
                }
            }
        }
        return dest;
    }

    /** {@link #makeFromMatrixMat4x4(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeFromMatrixMat4x4(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat4x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeFromMatrixMat4x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat4x4(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeFromMatrixMat4x4(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && m.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat4x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeFromMatrixMat4x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat4x4(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && m.isNative()) return DoubleQuatOpsKernelsSegment.makeFromMatrixMat4x4_unsafe(dest, destOffset, m, mOffset);
        return DoubleQuatOpsKernelsSegment.makeFromMatrixMat4x4_api(dest, destOffset, m, mOffset);
    }

    /** {@link #makeFromMatrixMat4x4(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeFromMatrixMat4x4(long dest, long m) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeFromMatrixMat4x4_unsafe(dest, m);
        makeFromMatrixMat4x4(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(m, 128L), 0L);
        return dest;
    }

    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the dual quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] toDualQuat(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = _selfx;
        dest[destOffset + 1] = _selfy;
        dest[destOffset + 2] = _selfz;
        dest[destOffset + 3] = _selfw;
        dest[destOffset + 4] = 0.0;
        dest[destOffset + 5] = 0.0;
        dest[destOffset + 6] = 0.0;
        dest[destOffset + 7] = 0.0;
        return dest;
    }

    /** {@link #toDualQuat(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer toDualQuat(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.toDualQuat_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.toDualQuat_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toDualQuat(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer toDualQuat(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.toDualQuat_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.toDualQuat_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toDualQuat(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment toDualQuat(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.toDualQuat_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.toDualQuat_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toDualQuat(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long toDualQuat(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.toDualQuat_unsafe(dest, src);
        toDualQuat(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 64L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Compute the matrix representation of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the matrix starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] toMatrix(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest[destOffset + 0] = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfy, _t1);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfz, -_t2);
        dest[destOffset + 3] = 0.0;
        dest[destOffset + 4] = 2.0 * Math.fma(_selfx, _selfy, -_t1);
        dest[destOffset + 5] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        dest[destOffset + 6] = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        dest[destOffset + 7] = 0.0;
        dest[destOffset + 8] = 2.0 * Math.fma(_selfx, _selfz, _t2);
        dest[destOffset + 9] = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        dest[destOffset + 10] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        dest[destOffset + 11] = 0.0;
        dest[destOffset + 12] = 0.0;
        dest[destOffset + 13] = 0.0;
        dest[destOffset + 14] = 0.0;
        dest[destOffset + 15] = 1.0;
        return dest;
    }

    /** {@link #toMatrix(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer toMatrix(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.toMatrix_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.toMatrix_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer toMatrix(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.toMatrix_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.toMatrix_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment toMatrix(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.toMatrix_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.toMatrix_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long toMatrix(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.toMatrix_unsafe(dest, src);
        toMatrix(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 128L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Compute the 3x3 rotation matrix representation of this quaternion and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the matrix starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] toMatrix3x3(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest[destOffset + 0] = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfy, _t1);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfz, -_t2);
        dest[destOffset + 3] = 2.0 * Math.fma(_selfx, _selfy, -_t1);
        dest[destOffset + 4] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        dest[destOffset + 5] = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        dest[destOffset + 6] = 2.0 * Math.fma(_selfx, _selfz, _t2);
        dest[destOffset + 7] = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        dest[destOffset + 8] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        return dest;
    }

    /** {@link #toMatrix3x3(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer toMatrix3x3(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.toMatrix3x3_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.toMatrix3x3_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x3(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer toMatrix3x3(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.toMatrix3x3_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.toMatrix3x3_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x3(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment toMatrix3x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.toMatrix3x3_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.toMatrix3x3_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x3(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long toMatrix3x3(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.toMatrix3x3_unsafe(dest, src);
        toMatrix3x3(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 72L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Compute the 3x4 matrix representation of this quaternion (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the matrix starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] toMatrix3x4(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest[destOffset + 0] = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfy, -_t1);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfz, _t2);
        dest[destOffset + 3] = 0.0;
        dest[destOffset + 4] = 2.0 * Math.fma(_selfx, _selfy, _t1);
        dest[destOffset + 5] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        dest[destOffset + 6] = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        dest[destOffset + 7] = 0.0;
        dest[destOffset + 8] = 2.0 * Math.fma(_selfx, _selfz, -_t2);
        dest[destOffset + 9] = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        dest[destOffset + 10] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        dest[destOffset + 11] = 0.0;
        return dest;
    }

    /** {@link #toMatrix3x4(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer toMatrix3x4(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.toMatrix3x4_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.toMatrix3x4_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x4(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer toMatrix3x4(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.toMatrix3x4_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.toMatrix3x4_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x4(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment toMatrix3x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.toMatrix3x4_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.toMatrix3x4_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #toMatrix3x4(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long toMatrix3x4(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.toMatrix3x4_unsafe(dest, src);
        toMatrix3x4(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 96L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param swing will hold the swing
     * @param swingOffset the element index in {@code swing} at which the quaternion starts
     * @param twist will hold the twist
     * @param twistOffset the element index in {@code twist} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return {@code swing}
     */
    public static double[] decomposeSwingTwist(double[] swing, int swingOffset, double[] twist, int twistOffset, double[] src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        swing[swingOffset + 0] = Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14));
        swing[swingOffset + 1] = Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12));
        swing[swingOffset + 2] = Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14));
        swing[swingOffset + 3] = Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11)));
        twist[twistOffset + 0] = _t12;
        twist[twistOffset + 1] = _t13;
        twist[twistOffset + 2] = _t14;
        twist[twistOffset + 3] = _t11;
        return swing;
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer decomposeSwingTwist(java.nio.DoubleBuffer swing, int swingOffset, java.nio.DoubleBuffer twist, int twistOffset, java.nio.DoubleBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isDirect() && !swing.isReadOnly() && twist.isDirect() && !twist.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsTypedBuffer.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer decomposeSwingTwist(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isDirect() && !swing.isReadOnly() && twist.isDirect() && !twist.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsByteBuffer.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment decomposeSwingTwist(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isNative() && !swing.isReadOnly() && twist.isNative() && !twist.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsSegment.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long decomposeSwingTwist(long swing, long twist, long src, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(swing, twist, src, axisX, axisY, axisZ);
        decomposeSwingTwist(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(swing, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(twist, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, axisX, axisY, axisZ);
        return swing;
    }

    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param swing will hold the swing
     * @param swingOffset the element index in {@code swing} at which the quaternion starts
     * @param twist will hold the twist
     * @param twistOffset the element index in {@code twist} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axis the storage holding the rotation axis (must be a unit vector)
     * @param axisOffset the element index in {@code axis} at which the vector starts
     * @return {@code swing}
     */
    public static double[] decomposeSwingTwist(double[] swing, int swingOffset, double[] twist, int twistOffset, double[] src, int srcOffset, double[] axis, int axisOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        swing[swingOffset + 0] = Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14));
        swing[swingOffset + 1] = Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12));
        swing[swingOffset + 2] = Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14));
        swing[swingOffset + 3] = Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11)));
        twist[twistOffset + 0] = _t12;
        twist[twistOffset + 1] = _t13;
        twist[twistOffset + 2] = _t14;
        twist[twistOffset + 3] = _t11;
        return swing;
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer decomposeSwingTwist(java.nio.DoubleBuffer swing, int swingOffset, java.nio.DoubleBuffer twist, int twistOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isDirect() && !swing.isReadOnly() && twist.isDirect() && !twist.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsTypedBuffer.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer decomposeSwingTwist(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isDirect() && !swing.isReadOnly() && twist.isDirect() && !twist.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsByteBuffer.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsByteBuffer.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment decomposeSwingTwist(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && swing.isNative() && !swing.isReadOnly() && twist.isNative() && !twist.isReadOnly() && src.isNative() && axis.isNative()) return DoubleQuatOpsKernelsSegment.decomposeSwingTwist_unsafe(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsSegment.decomposeSwingTwist_api(swing, swingOffset, twist, twistOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #decomposeSwingTwist(double[], int, double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long decomposeSwingTwist(long swing, long twist, long src, long axis) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(swing, twist, src, axis);
        decomposeSwingTwist(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(swing, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(twist, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(axis, 24L), 0L);
        return swing;
    }

    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return {@code dest}
     */
    public static double[] getSwing(double[] dest, int destOffset, double[] src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14));
        dest[destOffset + 1] = Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12));
        dest[destOffset + 2] = Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14));
        dest[destOffset + 3] = Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11)));
        return dest;
    }

    /** {@link #getSwing(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getSwing(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getSwing_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsTypedBuffer.getSwing_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getSwing(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getSwing(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getSwing_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsByteBuffer.getSwing_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getSwing(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getSwing(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getSwing_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsSegment.getSwing_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getSwing(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getSwing(long dest, long src, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getSwing_unsafe(dest, src, axisX, axisY, axisZ);
        getSwing(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, axisX, axisY, axisZ);
        return dest;
    }

    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axis the storage holding the rotation axis (must be a unit vector)
     * @param axisOffset the element index in {@code axis} at which the vector starts
     * @return {@code dest}
     */
    public static double[] getSwing(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14));
        dest[destOffset + 1] = Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12));
        dest[destOffset + 2] = Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14));
        dest[destOffset + 3] = Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11)));
        return dest;
    }

    /** {@link #getSwing(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getSwing(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getSwing_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getSwing_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getSwing(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getSwing(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getSwing_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsByteBuffer.getSwing_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getSwing(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getSwing(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && axis.isNative()) return DoubleQuatOpsKernelsSegment.getSwing_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsSegment.getSwing_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getSwing(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getSwing(long dest, long src, long axis) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getSwing_unsafe(dest, src, axis);
        getSwing(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(axis, 24L), 0L);
        return dest;
    }

    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return {@code dest}
     */
    public static double[] getTwist(double[] dest, int destOffset, double[] src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            dest[destOffset + 0] = axisX * _t6;
            dest[destOffset + 1] = axisY * _t6;
            dest[destOffset + 2] = axisZ * _t6;
            dest[destOffset + 3] = _selfw * _t5;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 1.0;
        }
        return dest;
    }

    /** {@link #getTwist(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getTwist(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getTwist_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsTypedBuffer.getTwist_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getTwist(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getTwist(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getTwist_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsByteBuffer.getTwist_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getTwist(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getTwist(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getTwist_unsafe(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsSegment.getTwist_api(dest, destOffset, src, srcOffset, axisX, axisY, axisZ);
    }

    /** {@link #getTwist(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getTwist(long dest, long src, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getTwist_unsafe(dest, src, axisX, axisY, axisZ);
        getTwist(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, axisX, axisY, axisZ);
        return dest;
    }

    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axis the storage holding the rotation axis (must be a unit vector)
     * @param axisOffset the element index in {@code axis} at which the vector starts
     * @return {@code dest}
     */
    public static double[] getTwist(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            dest[destOffset + 0] = _axisx * _t6;
            dest[destOffset + 1] = _axisy * _t6;
            dest[destOffset + 2] = _axisz * _t6;
            dest[destOffset + 3] = _selfw * _t5;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 1.0;
        }
        return dest;
    }

    /** {@link #getTwist(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getTwist(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getTwist_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getTwist_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getTwist(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getTwist(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getTwist_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsByteBuffer.getTwist_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getTwist(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getTwist(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && axis.isNative()) return DoubleQuatOpsKernelsSegment.getTwist_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset);
        return DoubleQuatOpsKernelsSegment.getTwist_api(dest, destOffset, src, srcOffset, axis, axisOffset);
    }

    /** {@link #getTwist(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getTwist(long dest, long src, long axis) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getTwist_unsafe(dest, src, axis);
        getTwist(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(axis, 24L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the identity.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] makeIdentity(double[] dest, int destOffset) {
        dest[destOffset + 0] = 0.0;
        dest[destOffset + 1] = 0.0;
        dest[destOffset + 2] = 0.0;
        dest[destOffset + 3] = 1.0;
        return dest;
    }

    /** {@link #makeIdentity(double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeIdentity(java.nio.DoubleBuffer dest, int destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeIdentity_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeIdentity_api(dest, destOffset);
    }

    /** {@link #makeIdentity(double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeIdentity(java.nio.ByteBuffer dest, int destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeIdentity_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeIdentity_api(dest, destOffset);
    }

    /** {@link #makeIdentity(double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeIdentity(java.lang.foreign.MemorySegment dest, long destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeIdentity_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsSegment.makeIdentity_api(dest, destOffset);
    }

    /** {@link #makeIdentity(double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeIdentity(long dest) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeIdentity_unsafe(dest);
        makeIdentity(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L);
        return dest;
    }

    /**
     * Set all components of this quaternion to zero.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] makeZero(double[] dest, int destOffset) {
        dest[destOffset + 0] = 0.0;
        dest[destOffset + 1] = 0.0;
        dest[destOffset + 2] = 0.0;
        dest[destOffset + 3] = 0.0;
        return dest;
    }

    /** {@link #makeZero(double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeZero(java.nio.DoubleBuffer dest, int destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeZero_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeZero_api(dest, destOffset);
    }

    /** {@link #makeZero(double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeZero(java.nio.ByteBuffer dest, int destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeZero_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeZero_api(dest, destOffset);
    }

    /** {@link #makeZero(double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeZero(java.lang.foreign.MemorySegment dest, long destOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeZero_unsafe(dest, destOffset);
        return DoubleQuatOpsKernelsSegment.makeZero_api(dest, destOffset);
    }

    /** {@link #makeZero(double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeZero(long dest) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeZero_unsafe(dest);
        makeZero(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L);
        return dest;
    }

    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] lerp(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(t, otherX - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, otherY - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, otherZ - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, otherW - _selfw, _selfw);
        return dest;
    }

    /** {@link #lerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer lerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.lerp_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return DoubleQuatOpsKernelsTypedBuffer.lerp_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    /** {@link #lerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer lerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.lerp_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return DoubleQuatOpsKernelsByteBuffer.lerp_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    /** {@link #lerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment lerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.lerp_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return DoubleQuatOpsKernelsSegment.lerp_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    /** {@link #lerp(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long lerp(long dest, long src, double otherX, double otherY, double otherZ, double otherW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.lerp_unsafe(dest, src, otherX, otherY, otherZ, otherW, t);
        lerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW, t);
        return dest;
    }

    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] lerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(t, _otherx - _selfx, _selfx);
        dest[destOffset + 1] = Math.fma(t, _othery - _selfy, _selfy);
        dest[destOffset + 2] = Math.fma(t, _otherz - _selfz, _selfz);
        dest[destOffset + 3] = Math.fma(t, _otherw - _selfw, _selfw);
        return dest;
    }

    /** {@link #lerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer lerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.lerp_unsafe(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return DoubleQuatOpsKernelsTypedBuffer.lerp_api(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    /** {@link #lerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer lerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.lerp_unsafe(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return DoubleQuatOpsKernelsByteBuffer.lerp_api(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    /** {@link #lerp(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment lerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.lerp_unsafe(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return DoubleQuatOpsKernelsSegment.lerp_api(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    /** {@link #lerp(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long lerp(long dest, long src, long other, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.lerp_unsafe(dest, src, other, t);
        lerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L, t);
        return dest;
    }

    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] nlerp(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t4 = Math.fma(alpha, targetW - _selfw, _selfw);
        double _t5 = Math.fma(alpha, targetZ - _selfz, _selfz);
        double _t6 = Math.fma(alpha, targetX - _selfx, _selfx);
        double _t7 = Math.fma(alpha, targetY - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest[destOffset + 0] = _t6 * _t12;
            dest[destOffset + 1] = _t7 * _t12;
            dest[destOffset + 2] = _t5 * _t12;
            dest[destOffset + 3] = _t4 * _t12;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #nlerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer nlerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.nlerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.nlerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer nlerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.nlerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsByteBuffer.nlerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment nlerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.nlerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsSegment.nlerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long nlerp(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.nlerp_unsafe(dest, src, targetX, targetY, targetZ, targetW, alpha);
        nlerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param target the storage holding the target rotation
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] nlerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        double _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        double _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        double _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest[destOffset + 0] = _t6 * _t12;
            dest[destOffset + 1] = _t7 * _t12;
            dest[destOffset + 2] = _t5 * _t12;
            dest[destOffset + 3] = _t4 * _t12;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #nlerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer nlerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.nlerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.nlerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer nlerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.nlerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsByteBuffer.nlerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment nlerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.nlerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsSegment.nlerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerp(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long nlerp(long dest, long src, long target, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.nlerp_unsafe(dest, src, target, alpha);
        nlerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, alpha);
        return dest;
    }

    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] nlerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t8 = -Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
            _t17 = Math.fma(alpha, -targetW - _selfw, _selfw);
            _t18 = Math.fma(alpha, -targetZ - _selfz, _selfz);
            _t19 = Math.fma(alpha, -targetX - _selfx, _selfx);
            _t20 = Math.fma(alpha, -targetY - _selfy, _selfy);
        } else {
            _t17 = Math.fma(alpha, targetW - _selfw, _selfw);
            _t18 = Math.fma(alpha, targetZ - _selfz, _selfz);
            _t19 = Math.fma(alpha, targetX - _selfx, _selfx);
            _t20 = Math.fma(alpha, targetY - _selfy, _selfy);
        }
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            dest[destOffset + 0] = _t19 * _t25;
            dest[destOffset + 1] = _t20 * _t25;
            dest[destOffset + 2] = _t18 * _t25;
            dest[destOffset + 3] = _t17 * _t25;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer nlerpShortest(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.nlerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer nlerpShortest(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsByteBuffer.nlerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment nlerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsSegment.nlerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long nlerpShortest(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.nlerpShortest_unsafe(dest, src, targetX, targetY, targetZ, targetW, alpha);
        nlerpShortest(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param target the storage holding the target rotation
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] nlerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t8 = -Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
            _t17 = Math.fma(alpha, -_targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, -_targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, -_targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, -_targety - _selfy, _selfy);
        } else {
            _t17 = Math.fma(alpha, _targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, _targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, _targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, _targety - _selfy, _selfy);
        }
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            dest[destOffset + 0] = _t19 * _t25;
            dest[destOffset + 1] = _t20 * _t25;
            dest[destOffset + 2] = _t18 * _t25;
            dest[destOffset + 3] = _t17 * _t25;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer nlerpShortest(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.nlerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer nlerpShortest(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsByteBuffer.nlerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment nlerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.nlerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsSegment.nlerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #nlerpShortest(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long nlerpShortest(long dest, long src, long target, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.nlerpShortest_unsafe(dest, src, target, alpha);
        nlerpShortest(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, alpha);
        return dest;
    }

    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * {@code target} using the interpolation factor {@code alpha} and store the result in
     * {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] slerp(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            dest[destOffset + 0] = Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv;
            dest[destOffset + 1] = Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv;
            dest[destOffset + 2] = Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv;
            dest[destOffset + 3] = Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv;
        } else {
            dest[destOffset + 0] = Math.fma(alpha, targetX, _selfx * _t0);
            dest[destOffset + 1] = Math.fma(alpha, targetY, _selfy * _t0);
            dest[destOffset + 2] = Math.fma(alpha, targetZ, _selfz * _t0);
            dest[destOffset + 3] = Math.fma(alpha, targetW, _selfw * _t0);
        }
        return dest;
    }

    /** {@link #slerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer slerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.slerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.slerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer slerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.slerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsByteBuffer.slerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment slerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.slerp_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsSegment.slerp_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long slerp(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.slerp_unsafe(dest, src, targetX, targetY, targetZ, targetW, alpha);
        slerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * {@code target} using the interpolation factor {@code alpha} and store the result in
     * {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param target the storage holding the target rotation (must be a unit quaternion)
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] slerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            dest[destOffset + 0] = Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv;
            dest[destOffset + 1] = Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv;
            dest[destOffset + 2] = Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv;
            dest[destOffset + 3] = Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv;
        } else {
            dest[destOffset + 0] = Math.fma(alpha, _targetx, _selfx * _t0);
            dest[destOffset + 1] = Math.fma(alpha, _targety, _selfy * _t0);
            dest[destOffset + 2] = Math.fma(alpha, _targetz, _selfz * _t0);
            dest[destOffset + 3] = Math.fma(alpha, _targetw, _selfw * _t0);
        }
        return dest;
    }

    /** {@link #slerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer slerp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.slerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.slerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer slerp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.slerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsByteBuffer.slerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment slerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.slerp_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsSegment.slerp_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerp(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long slerp(long dest, long src, long target, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.slerp_unsafe(dest, src, target, alpha);
        slerp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, alpha);
        return dest;
    }

    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] slerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
            _t21 = -targetW;
            _t22 = -targetZ;
            _t23 = -targetX;
            _t24 = -targetY;
        } else {
            _t21 = targetW;
            _t22 = targetZ;
            _t23 = targetX;
            _t24 = targetY;
        }
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
            _t42 = Math.fma(_selfw, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(_selfz, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(_selfx, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(_selfy, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, _selfw * _t0);
            _t43 = Math.fma(alpha, _t22, _selfz * _t0);
            _t44 = Math.fma(alpha, _t23, _selfx * _t0);
            _t45 = Math.fma(alpha, _t24, _selfy * _t0);
        }
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            dest[destOffset + 0] = _t50 * _t44;
            dest[destOffset + 1] = _t50 * _t45;
            dest[destOffset + 2] = _t50 * _t43;
            dest[destOffset + 3] = _t50 * _t42;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #slerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer slerpShortest(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.slerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.slerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer slerpShortest(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.slerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsByteBuffer.slerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment slerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.slerpShortest_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return DoubleQuatOpsKernelsSegment.slerpShortest_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long slerpShortest(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.slerpShortest_unsafe(dest, src, targetX, targetY, targetZ, targetW, alpha);
        slerpShortest(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param target the storage holding the target rotation (must be a unit quaternion)
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] slerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
            _t21 = -_targetw;
            _t22 = -_targetz;
            _t23 = -_targetx;
            _t24 = -_targety;
        } else {
            _t21 = _targetw;
            _t22 = _targetz;
            _t23 = _targetx;
            _t24 = _targety;
        }
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
            _t42 = Math.fma(_selfw, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(_selfz, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(_selfx, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(_selfy, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, _selfw * _t0);
            _t43 = Math.fma(alpha, _t22, _selfz * _t0);
            _t44 = Math.fma(alpha, _t23, _selfx * _t0);
            _t45 = Math.fma(alpha, _t24, _selfy * _t0);
        }
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            dest[destOffset + 0] = _t50 * _t44;
            dest[destOffset + 1] = _t50 * _t45;
            dest[destOffset + 2] = _t50 * _t43;
            dest[destOffset + 3] = _t50 * _t42;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #slerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer slerpShortest(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.slerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsTypedBuffer.slerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer slerpShortest(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.slerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsByteBuffer.slerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment slerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.slerpShortest_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return DoubleQuatOpsKernelsSegment.slerpShortest_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    /** {@link #slerpShortest(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long slerpShortest(long dest, long src, long target, double alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.slerpShortest_unsafe(dest, src, target, alpha);
        slerpShortest(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, alpha);
        return dest;
    }

    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
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
     * @return {@code dest}
     */
    public static double[] squad(double[] dest, int destOffset, double[] src, int srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 1.0 - t;
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
            _t71 = Math.fma(control0W, _t45, control1W * _t41) * _t35_inv;
            _t73 = Math.fma(control0Z, _t45, control1Z * _t41) * _t35_inv;
            _t75 = Math.fma(control0X, _t45, control1X * _t41) * _t35_inv;
            _t77 = Math.fma(control0Y, _t45, control1Y * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, control1W, control0W * _t0);
            _t73 = Math.fma(t, control1Z, control0Z * _t0);
            _t75 = Math.fma(t, control1X, control0X * _t0);
            _t77 = Math.fma(t, control1Y, control0Y * _t0);
        }
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
            _t72 = Math.fma(_selfw, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(_selfz, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(_selfx, _t46, targetX * _t42) * _t36_inv;
            _t78 = Math.fma(_selfy, _t46, targetY * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, _selfw * _t0);
            _t74 = Math.fma(t, targetZ, _selfz * _t0);
            _t76 = Math.fma(t, targetX, _selfx * _t0);
            _t78 = Math.fma(t, targetY, _selfy * _t0);
        }
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            dest[destOffset + 0] = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            dest[destOffset + 1] = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            dest[destOffset + 2] = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            dest[destOffset + 3] = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            dest[destOffset + 0] = Math.fma(_t14, _t76, _t13 * _t75);
            dest[destOffset + 1] = Math.fma(_t14, _t78, _t13 * _t77);
            dest[destOffset + 2] = Math.fma(_t14, _t74, _t13 * _t73);
            dest[destOffset + 3] = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return dest;
    }

    /** {@link #squad(double[], int, double[], int, double, double, double, double, double, double, double, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer squad(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.squad_unsafe(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return DoubleQuatOpsKernelsTypedBuffer.squad_api(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
    }

    /** {@link #squad(double[], int, double[], int, double, double, double, double, double, double, double, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer squad(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.squad_unsafe(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return DoubleQuatOpsKernelsByteBuffer.squad_api(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
    }

    /** {@link #squad(double[], int, double[], int, double, double, double, double, double, double, double, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment squad(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.squad_unsafe(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return DoubleQuatOpsKernelsSegment.squad_api(dest, destOffset, src, srcOffset, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
    }

    /** {@link #squad(double[], int, double[], int, double, double, double, double, double, double, double, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long squad(long dest, long src, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.squad_unsafe(dest, src, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        squad(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return dest;
    }

    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param control0 the storage holding the inner control quaternion associated with the start
     *        rotation
     * @param control0Offset the element index in {@code control0} at which the quaternion starts
     * @param control1 the storage holding the inner control quaternion associated with the end
     *        rotation
     * @param control1Offset the element index in {@code control1} at which the quaternion starts
     * @param target the storage holding the target rotation
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return {@code dest}
     */
    public static double[] squad(double[] dest, int destOffset, double[] src, int srcOffset, double[] control0, int control0Offset, double[] control1, int control1Offset, double[] target, int targetOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _control0x = control0[control0Offset + 0];
        double _control0y = control0[control0Offset + 1];
        double _control0z = control0[control0Offset + 2];
        double _control0w = control0[control0Offset + 3];
        double _control1x = control1[control1Offset + 0];
        double _control1y = control1[control1Offset + 1];
        double _control1z = control1[control1Offset + 2];
        double _control1w = control1[control1Offset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t0 = 1.0 - t;
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_control0w, _control1w, Math.fma(_control0z, _control1z, Math.fma(_control0x, _control1x, _control0y * _control1y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
            _t71 = Math.fma(_control0w, _t45, _control1w * _t41) * _t35_inv;
            _t73 = Math.fma(_control0z, _t45, _control1z * _t41) * _t35_inv;
            _t75 = Math.fma(_control0x, _t45, _control1x * _t41) * _t35_inv;
            _t77 = Math.fma(_control0y, _t45, _control1y * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, _control1w, _control0w * _t0);
            _t73 = Math.fma(t, _control1z, _control0z * _t0);
            _t75 = Math.fma(t, _control1x, _control0x * _t0);
            _t77 = Math.fma(t, _control1y, _control0y * _t0);
        }
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
            _t72 = Math.fma(_selfw, _t46, _targetw * _t42) * _t36_inv;
            _t74 = Math.fma(_selfz, _t46, _targetz * _t42) * _t36_inv;
            _t76 = Math.fma(_selfx, _t46, _targetx * _t42) * _t36_inv;
            _t78 = Math.fma(_selfy, _t46, _targety * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, _targetw, _selfw * _t0);
            _t74 = Math.fma(t, _targetz, _selfz * _t0);
            _t76 = Math.fma(t, _targetx, _selfx * _t0);
            _t78 = Math.fma(t, _targety, _selfy * _t0);
        }
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            dest[destOffset + 0] = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            dest[destOffset + 1] = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            dest[destOffset + 2] = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            dest[destOffset + 3] = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            dest[destOffset + 0] = Math.fma(_t14, _t76, _t13 * _t75);
            dest[destOffset + 1] = Math.fma(_t14, _t78, _t13 * _t77);
            dest[destOffset + 2] = Math.fma(_t14, _t74, _t13 * _t73);
            dest[destOffset + 3] = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return dest;
    }

    /** {@link #squad(double[], int, double[], int, double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer squad(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer control0, int control0Offset, java.nio.DoubleBuffer control1, int control1Offset, java.nio.DoubleBuffer target, int targetOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && control0.isDirect() && control1.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.squad_unsafe(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
        return DoubleQuatOpsKernelsTypedBuffer.squad_api(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
    }

    /** {@link #squad(double[], int, double[], int, double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer squad(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer control0, int control0Offset, java.nio.ByteBuffer control1, int control1Offset, java.nio.ByteBuffer target, int targetOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && control0.isDirect() && control1.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.squad_unsafe(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
        return DoubleQuatOpsKernelsByteBuffer.squad_api(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
    }

    /** {@link #squad(double[], int, double[], int, double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment squad(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment control0, long control0Offset, java.lang.foreign.MemorySegment control1, long control1Offset, java.lang.foreign.MemorySegment target, long targetOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && control0.isNative() && control1.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.squad_unsafe(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
        return DoubleQuatOpsKernelsSegment.squad_api(dest, destOffset, src, srcOffset, control0, control0Offset, control1, control1Offset, target, targetOffset, t);
    }

    /** {@link #squad(double[], int, double[], int, double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long squad(long dest, long src, long control0, long control1, long target, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.squad_unsafe(dest, src, control0, control1, target, t);
        squad(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(control0, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(control1, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, t);
        return dest;
    }

    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] mul(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        dest[destOffset + 1] = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        dest[destOffset + 2] = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        dest[destOffset + 3] = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        return dest;
    }

    /** {@link #mul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer mul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.mul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.mul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #mul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer mul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.mul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.mul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #mul(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment mul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.mul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.mul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #mul(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long mul(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.mul_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        mul(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] mul(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        dest[destOffset + 1] = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        dest[destOffset + 2] = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        dest[destOffset + 3] = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        return dest;
    }

    /** {@link #mul(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer mul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.mul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.mul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #mul(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer mul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.mul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.mul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #mul(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment mul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.mul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.mul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #mul(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long mul(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.mul_unsafe(dest, src, other);
        mul(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Pre-multiply the transformation {@code other} onto this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] preMul(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherY, _selfz, -(otherZ * _selfy));
        dest[destOffset + 1] = Math.fma(otherY, _selfw, otherZ * _selfx) + Math.fma(otherW, _selfy, -(otherX * _selfz));
        dest[destOffset + 2] = Math.fma(otherX, _selfy, otherW * _selfz) + Math.fma(otherZ, _selfw, -(otherY * _selfx));
        dest[destOffset + 3] = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        return dest;
    }

    /** {@link #preMul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer preMul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.preMul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.preMul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #preMul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer preMul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.preMul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.preMul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #preMul(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment preMul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.preMul_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.preMul_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #preMul(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long preMul(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.preMul_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        preMul(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Pre-multiply the transformation {@code other} onto this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] preMul(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        dest[destOffset + 0] = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_othery, _selfz, -(_otherz * _selfy));
        dest[destOffset + 1] = Math.fma(_othery, _selfw, _otherz * _selfx) + Math.fma(_otherw, _selfy, -(_otherx * _selfz));
        dest[destOffset + 2] = Math.fma(_otherx, _selfy, _otherw * _selfz) + Math.fma(_otherz, _selfw, -(_othery * _selfx));
        dest[destOffset + 3] = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        return dest;
    }

    /** {@link #preMul(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer preMul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.preMul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.preMul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #preMul(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer preMul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.preMul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.preMul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #preMul(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment preMul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.preMul_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.preMul_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #preMul(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long preMul(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.preMul_unsafe(dest, src, other);
        preMul(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public static double angle(double[] src, int srcOffset) {
        double _selfw = src[srcOffset + 3];
        return 2.0 * Math.acos(Math.min(1.0, Math.max(-1.0, _selfw)));
    }

    /** {@link #angle(double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static double angle(java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.angle_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.angle_api(src, srcOffset);
    }

    /** {@link #angle(double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static double angle(java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.angle_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.angle_api(src, srcOffset);
    }

    /** {@link #angle(double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double angle(java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return DoubleQuatOpsKernelsSegment.angle_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsSegment.angle_api(src, srcOffset);
    }

    /** {@link #angle(double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double angle(long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.angle_unsafe(src);
        return angle(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the angle in radians between this quaternion and {@code other}
     */
    public static double angleTo(double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy))))));
    }

    /** {@link #angleTo(double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static double angleTo(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.angleTo_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.angleTo_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #angleTo(double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static double angleTo(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.angleTo_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.angleTo_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #angleTo(double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double angleTo(java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return DoubleQuatOpsKernelsSegment.angleTo_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.angleTo_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #angleTo(double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double angleTo(long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.angleTo_unsafe(src, otherX, otherY, otherZ, otherW);
        return angleTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
    }

    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return the angle in radians between this quaternion and {@code other}
     */
    public static double angleTo(double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy))))));
    }

    /** {@link #angleTo(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static double angleTo(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.angleTo_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.angleTo_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #angleTo(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static double angleTo(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.angleTo_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.angleTo_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #angleTo(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double angleTo(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.angleTo_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.angleTo_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #angleTo(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double angleTo(long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.angleTo_unsafe(src, other);
        return angleTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
    }

    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] axis(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest[destOffset + 0] = _selfx * _t3;
            dest[destOffset + 1] = _selfy * _t3;
            dest[destOffset + 2] = _selfz * _t3;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #axis(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer axis(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.axis_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.axis_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #axis(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer axis(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.axis_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.axis_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #axis(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment axis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.axis_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.axis_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #axis(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long axis(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.axis_unsafe(dest, src);
        axis(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] calculateW(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        dest[destOffset + 0] = _selfx;
        dest[destOffset + 1] = _selfy;
        dest[destOffset + 2] = _selfz;
        dest[destOffset + 3] = Math.sqrt(Math.max(0.0, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0)))));
        return dest;
    }

    /** {@link #calculateW(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer calculateW(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.calculateW_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.calculateW_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #calculateW(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer calculateW(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.calculateW_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.calculateW_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #calculateW(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment calculateW(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.calculateW_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.calculateW_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #calculateW(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long calculateW(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.calculateW_unsafe(dest, src);
        calculateW(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] conjugate(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -_selfx;
        dest[destOffset + 1] = -_selfy;
        dest[destOffset + 2] = -_selfz;
        dest[destOffset + 3] = _selfw;
        return dest;
    }

    /** {@link #conjugate(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer conjugate(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.conjugate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.conjugate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #conjugate(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer conjugate(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.conjugate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.conjugate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #conjugate(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment conjugate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.conjugate_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.conjugate_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #conjugate(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long conjugate(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.conjugate_unsafe(dest, src);
        conjugate(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @return {@code dest}
     */
    public static double[] conjugateBy(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t1 = -qY;
        double _t21 = Math.fma(qX, _selfy, qW * _selfz) + Math.fma(qZ, _selfw, -(qY * _selfx));
        double _t22 = Math.fma(qY, _selfw, qZ * _selfx) + Math.fma(qW, _selfy, -(qX * _selfz));
        double _t23 = Math.fma(qX, _selfw, qW * _selfx) + Math.fma(qY, _selfz, -(qZ * _selfy));
        double _t24 = Math.fma(-qZ, _selfz, Math.fma(_t1, _selfy, Math.fma(qW, _selfw, -(qX * _selfx))));
        dest[destOffset + 0] = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        dest[destOffset + 1] = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        dest[destOffset + 2] = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        dest[destOffset + 3] = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return dest;
    }

    /** {@link #conjugateBy(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer conjugateBy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.conjugateBy_unsafe(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return DoubleQuatOpsKernelsTypedBuffer.conjugateBy_api(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer conjugateBy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.conjugateBy_unsafe(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return DoubleQuatOpsKernelsByteBuffer.conjugateBy_api(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment conjugateBy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double qX, double qY, double qZ, double qW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.conjugateBy_unsafe(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return DoubleQuatOpsKernelsSegment.conjugateBy_api(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long conjugateBy(long dest, long src, double qX, double qY, double qZ, double qW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.conjugateBy_unsafe(dest, src, qX, qY, qZ, qW);
        conjugateBy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, qX, qY, qZ, qW);
        return dest;
    }

    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param q the storage holding the quaternion
     * @param qOffset the element index in {@code q} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] conjugateBy(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _qx = q[qOffset + 0];
        double _qy = q[qOffset + 1];
        double _qz = q[qOffset + 2];
        double _qw = q[qOffset + 3];
        double _t1 = -_qy;
        double _t21 = Math.fma(_qx, _selfy, _qw * _selfz) + Math.fma(_qz, _selfw, -(_qy * _selfx));
        double _t22 = Math.fma(_qy, _selfw, _qz * _selfx) + Math.fma(_qw, _selfy, -(_qx * _selfz));
        double _t23 = Math.fma(_qx, _selfw, _qw * _selfx) + Math.fma(_qy, _selfz, -(_qz * _selfy));
        double _t24 = Math.fma(-_qz, _selfz, Math.fma(_t1, _selfy, Math.fma(_qw, _selfw, -(_qx * _selfx))));
        dest[destOffset + 0] = Math.fma(_qy, _t21, -(_qz * _t22)) + Math.fma(_qw, _t23, -(_qx * _t24));
        dest[destOffset + 1] = Math.fma(_qz, _t23, -(_qy * _t24)) + Math.fma(_qw, _t22, -(_qx * _t21));
        dest[destOffset + 2] = Math.fma(_qx, _t22, _qw * _t21) + Math.fma(_t1, _t23, -(_qz * _t24));
        dest[destOffset + 3] = Math.fma(_qz, _t21, Math.fma(_qy, _t22, Math.fma(_qx, _t23, _qw * _t24)));
        return dest;
    }

    /** {@link #conjugateBy(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer conjugateBy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && q.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.conjugateBy_unsafe(dest, destOffset, src, srcOffset, q, qOffset);
        return DoubleQuatOpsKernelsTypedBuffer.conjugateBy_api(dest, destOffset, src, srcOffset, q, qOffset);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer conjugateBy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer q, int qOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && q.isDirect()) return DoubleQuatOpsKernelsByteBuffer.conjugateBy_unsafe(dest, destOffset, src, srcOffset, q, qOffset);
        return DoubleQuatOpsKernelsByteBuffer.conjugateBy_api(dest, destOffset, src, srcOffset, q, qOffset);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment conjugateBy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && q.isNative()) return DoubleQuatOpsKernelsSegment.conjugateBy_unsafe(dest, destOffset, src, srcOffset, q, qOffset);
        return DoubleQuatOpsKernelsSegment.conjugateBy_api(dest, destOffset, src, srcOffset, q, qOffset);
    }

    /** {@link #conjugateBy(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long conjugateBy(long dest, long src, long q) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.conjugateBy_unsafe(dest, src, q);
        conjugateBy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(q, 32L), 0L);
        return dest;
    }

    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] difference(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest[destOffset + 0] = (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv;
        dest[destOffset + 1] = -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv;
        dest[destOffset + 2] = (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv;
        dest[destOffset + 3] = Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv;
        return dest;
    }

    /** {@link #difference(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer difference(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.difference_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.difference_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #difference(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer difference(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.difference_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.difference_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #difference(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment difference(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.difference_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.difference_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #difference(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long difference(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.difference_unsafe(dest, src, otherX, otherY, otherZ, otherW);
        difference(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] difference(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest[destOffset + 0] = (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv;
        dest[destOffset + 1] = -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv;
        dest[destOffset + 2] = (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv;
        dest[destOffset + 3] = Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv;
        return dest;
    }

    /** {@link #difference(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer difference(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.difference_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.difference_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #difference(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer difference(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.difference_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.difference_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #difference(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment difference(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.difference_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.difference_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #difference(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long difference(long dest, long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.difference_unsafe(dest, src, other);
        difference(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
        return dest;
    }

    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the dot product of this quaternion and {@code other}
     */
    public static double dot(double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        return Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)));
    }

    /** {@link #dot(double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static double dot(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.dot_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsTypedBuffer.dot_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #dot(double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static double dot(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.dot_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsByteBuffer.dot_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #dot(double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double dot(java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return DoubleQuatOpsKernelsSegment.dot_unsafe(src, srcOffset, otherX, otherY, otherZ, otherW);
        return DoubleQuatOpsKernelsSegment.dot_api(src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #dot(double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double dot(long src, double otherX, double otherY, double otherZ, double otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.dot_unsafe(src, otherX, otherY, otherZ, otherW);
        return dot(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, otherX, otherY, otherZ, otherW);
    }

    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return the dot product of this quaternion and {@code other}
     */
    public static double dot(double[] src, int srcOffset, double[] other, int otherOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _otherx = other[otherOffset + 0];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _otherw = other[otherOffset + 3];
        return Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)));
    }

    /** {@link #dot(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static double dot(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.dot_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsTypedBuffer.dot_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #dot(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static double dot(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && other.isDirect()) return DoubleQuatOpsKernelsByteBuffer.dot_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsByteBuffer.dot_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #dot(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double dot(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && other.isNative()) return DoubleQuatOpsKernelsSegment.dot_unsafe(src, srcOffset, other, otherOffset);
        return DoubleQuatOpsKernelsSegment.dot_api(src, srcOffset, other, otherOffset);
    }

    /** {@link #dot(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double dot(long src, long other) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.dot_unsafe(src, other);
        return dot(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(other, 32L), 0L);
    }

    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] exp(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = Math.exp(_selfw);
        double _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.sqrt(_t3);
        double _t8 = Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest[destOffset + 0] = _selfx * _t8;
            dest[destOffset + 1] = _selfy * _t8;
            dest[destOffset + 2] = _selfz * _t8;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.cos(_t4) * _t0;
        return dest;
    }

    /** {@link #exp(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer exp(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.exp_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.exp_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #exp(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer exp(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.exp_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.exp_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #exp(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment exp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.exp_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.exp_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #exp(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long exp(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.exp_unsafe(dest, src);
        exp(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesXYZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t1 = _selfy * _selfz;
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            dest[destOffset + 0] = Math.atan2(2.0 * Math.fma(_selfx, _selfw, _t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0));
            dest[destOffset + 2] = 0.0;
        } else {
            dest[destOffset + 0] = Math.atan2(_t9, _t10);
            dest[destOffset + 2] = Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0));
        }
        dest[destOffset + 1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }

    /** {@link #getEulerAnglesXYZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesXYZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesXYZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesXYZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXYZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesXYZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesXYZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesXYZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXYZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesXYZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesXYZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesXYZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXYZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesXYZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesXYZ_unsafe(dest, src);
        getEulerAnglesXYZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesXZY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t1 = _selfy * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _t1);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest[destOffset + 0] = Math.atan2(2.0 * Math.fma(_selfx, _selfw, -_t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
            dest[destOffset + 1] = 0.0;
        } else {
            dest[destOffset + 0] = Math.atan2(_t7, _t9);
            dest[destOffset + 1] = Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        }
        dest[destOffset + 2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }

    /** {@link #getEulerAnglesXZY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesXZY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesXZY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesXZY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXZY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesXZY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesXZY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesXZY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXZY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesXZY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesXZY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesXZY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesXZY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesXZY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesXZY_unsafe(dest, src);
        getEulerAnglesXZY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesYXZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz));
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            dest[destOffset + 1] = Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0));
            dest[destOffset + 2] = 0.0;
        } else {
            dest[destOffset + 1] = Math.atan2(_t8, _t10);
            dest[destOffset + 2] = Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0));
        }
        dest[destOffset + 0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t9)));
        return dest;
    }

    /** {@link #getEulerAnglesYXZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesYXZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesYXZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesYXZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYXZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesYXZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesYXZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesYXZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYXZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesYXZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesYXZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesYXZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYXZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesYXZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesYXZ_unsafe(dest, src);
        getEulerAnglesYXZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesYZX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        } else {
            dest[destOffset + 0] = Math.atan2(2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
            dest[destOffset + 1] = Math.atan2(_t8, _t9);
        }
        dest[destOffset + 2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }

    /** {@link #getEulerAnglesYZX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesYZX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesYZX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesYZX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYZX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesYZX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesYZX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesYZX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYZX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesYZX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesYZX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesYZX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesYZX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesYZX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesYZX_unsafe(dest, src);
        getEulerAnglesYZX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesZXY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t1 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t1), 1.0));
        } else {
            dest[destOffset + 1] = Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
            dest[destOffset + 2] = Math.atan2(_t8, _t9);
        }
        dest[destOffset + 0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }

    /** {@link #getEulerAnglesZXY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesZXY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesZXY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesZXY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZXY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesZXY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesZXY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesZXY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZXY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesZXY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesZXY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesZXY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZXY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesZXY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesZXY_unsafe(dest, src);
        getEulerAnglesZXY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] getEulerAnglesZYX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 2] = Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        } else {
            dest[destOffset + 0] = Math.atan2(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
            dest[destOffset + 2] = Math.atan2(_t7, _t9);
        }
        dest[destOffset + 1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }

    /** {@link #getEulerAnglesZYX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer getEulerAnglesZYX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesZYX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.getEulerAnglesZYX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZYX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer getEulerAnglesZYX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesZYX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.getEulerAnglesZYX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZYX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment getEulerAnglesZYX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.getEulerAnglesZYX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.getEulerAnglesZYX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #getEulerAnglesZYX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long getEulerAnglesZYX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.getEulerAnglesZYX_unsafe(dest, src);
        getEulerAnglesZYX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angularVelX the {@code x} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelY the {@code y} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelZ the {@code z} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param dt the time step
     * @return {@code dest}
     */
    public static double[] integrate(double[] dest, int destOffset, double[] src, int srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * dt;
        double _t1 = angularVelZ * _t0;
        double _t2 = angularVelX * _t0;
        double _t3 = angularVelY * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17));
        dest[destOffset + 1] = Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15));
        dest[destOffset + 2] = Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16));
        dest[destOffset + 3] = Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15))));
        return dest;
    }

    /** {@link #integrate(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer integrate(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.integrate_unsafe(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
        return DoubleQuatOpsKernelsTypedBuffer.integrate_api(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer integrate(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.integrate_unsafe(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
        return DoubleQuatOpsKernelsByteBuffer.integrate_api(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment integrate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.integrate_unsafe(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
        return DoubleQuatOpsKernelsSegment.integrate_api(dest, destOffset, src, srcOffset, angularVelX, angularVelY, angularVelZ, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long integrate(long dest, long src, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.integrate_unsafe(dest, src, angularVelX, angularVelY, angularVelZ, dt);
        integrate(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angularVelX, angularVelY, angularVelZ, dt);
        return dest;
    }

    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angularVel the storage holding the angular velocity, in radians per second, applied in
     *        the reference frame
     * @param angularVelOffset the element index in {@code angularVel} at which the vector starts
     * @param dt the time step
     * @return {@code dest}
     */
    public static double[] integrate(double[] dest, int destOffset, double[] src, int srcOffset, double[] angularVel, int angularVelOffset, double dt) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _angularVelx = angularVel[angularVelOffset + 0];
        double _angularVely = angularVel[angularVelOffset + 1];
        double _angularVelz = angularVel[angularVelOffset + 2];
        double _t0 = 0.5 * dt;
        double _t1 = _angularVelz * _t0;
        double _t2 = _angularVelx * _t0;
        double _t3 = _angularVely * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17));
        dest[destOffset + 1] = Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15));
        dest[destOffset + 2] = Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16));
        dest[destOffset + 3] = Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15))));
        return dest;
    }

    /** {@link #integrate(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer integrate(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer angularVel, int angularVelOffset, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && angularVel.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.integrate_unsafe(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
        return DoubleQuatOpsKernelsTypedBuffer.integrate_api(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer integrate(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer angularVel, int angularVelOffset, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && angularVel.isDirect()) return DoubleQuatOpsKernelsByteBuffer.integrate_unsafe(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
        return DoubleQuatOpsKernelsByteBuffer.integrate_api(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment integrate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment angularVel, long angularVelOffset, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && angularVel.isNative()) return DoubleQuatOpsKernelsSegment.integrate_unsafe(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
        return DoubleQuatOpsKernelsSegment.integrate_api(dest, destOffset, src, srcOffset, angularVel, angularVelOffset, dt);
    }

    /** {@link #integrate(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long integrate(long dest, long src, long angularVel, double dt) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.integrate_unsafe(dest, src, angularVel, dt);
        integrate(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(angularVel, 24L), 0L, dt);
        return dest;
    }

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNegativeX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t9 * _t13);
            dest[destOffset + 1] = -(_t8 * _t13);
            dest[destOffset + 2] = -(_t7 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #invNegativeX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNegativeX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNegativeX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNegativeX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNegativeX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNegativeX_unsafe(dest, src);
        invNegativeX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNegativeY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t7 * _t13);
            dest[destOffset + 1] = -(_t9 * _t13);
            dest[destOffset + 2] = -(_t8 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #invNegativeY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNegativeY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNegativeY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNegativeY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNegativeY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNegativeY_unsafe(dest, src);
        invNegativeY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNegativeZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t8 * _t13);
            dest[destOffset + 1] = -(_t7 * _t13);
            dest[destOffset + 2] = -(_t9 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #invNegativeZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNegativeZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNegativeZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNegativeZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNegativeZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNegativeZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNegativeZ_unsafe(dest, src);
        invNegativeZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedNegativeX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0);
        dest[destOffset + 1] = -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest[destOffset + 2] = -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        return dest;
    }

    /** {@link #invNormalizedNegativeX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedNegativeX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedNegativeX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedNegativeX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedNegativeX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedNegativeX_unsafe(dest, src);
        invNormalizedNegativeX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedNegativeY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest[destOffset + 1] = Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0);
        dest[destOffset + 2] = -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        return dest;
    }

    /** {@link #invNormalizedNegativeY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedNegativeY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedNegativeY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedNegativeY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedNegativeY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedNegativeY_unsafe(dest, src);
        invNormalizedNegativeY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedNegativeZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        dest[destOffset + 1] = -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest[destOffset + 2] = Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0);
        return dest;
    }

    /** {@link #invNormalizedNegativeZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedNegativeZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedNegativeZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedNegativeZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedNegativeZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedNegativeZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedNegativeZ_unsafe(dest, src);
        invNormalizedNegativeZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedPositiveX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        return dest;
    }

    /** {@link #invNormalizedPositiveX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedPositiveX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedPositiveX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedPositiveX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedPositiveX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedPositiveX_unsafe(dest, src);
        invNormalizedPositiveX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedPositiveY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        dest[destOffset + 1] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        return dest;
    }

    /** {@link #invNormalizedPositiveY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedPositiveY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedPositiveY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedPositiveY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedPositiveY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedPositiveY_unsafe(dest, src);
        invNormalizedPositiveY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invNormalizedPositiveZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        dest[destOffset + 2] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        return dest;
    }

    /** {@link #invNormalizedPositiveZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invNormalizedPositiveZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invNormalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invNormalizedPositiveZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invNormalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invNormalizedPositiveZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invNormalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invNormalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invNormalizedPositiveZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invNormalizedPositiveZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invNormalizedPositiveZ_unsafe(dest, src);
        invNormalizedPositiveZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invPositiveX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t9 * _t13;
            dest[destOffset + 1] = _t8 * _t13;
            dest[destOffset + 2] = _t7 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #invPositiveX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invPositiveX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invPositiveX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invPositiveX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invPositiveX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invPositiveX_unsafe(dest, src);
        invPositiveX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invPositiveY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t7 * _t13;
            dest[destOffset + 1] = _t9 * _t13;
            dest[destOffset + 2] = _t8 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #invPositiveY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invPositiveY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invPositiveY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invPositiveY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invPositiveY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invPositiveY_unsafe(dest, src);
        invPositiveY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] invPositiveZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t8 * _t13;
            dest[destOffset + 1] = _t7 * _t13;
            dest[destOffset + 2] = _t9 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #invPositiveZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer invPositiveZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.invPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.invPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer invPositiveZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.invPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.invPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment invPositiveZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.invPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.invPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #invPositiveZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long invPositiveZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.invPositiveZ_unsafe(dest, src);
        invPositiveZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Compute the length of this quaternion.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return the length of this quaternion
     */
    public static double length(double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        return Math.sqrt(Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy))));
    }

    /** {@link #length(double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static double length(java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.length_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.length_api(src, srcOffset);
    }

    /** {@link #length(double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static double length(java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.length_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.length_api(src, srcOffset);
    }

    /** {@link #length(double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double length(java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return DoubleQuatOpsKernelsSegment.length_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsSegment.length_api(src, srcOffset);
    }

    /** {@link #length(double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double length(long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.length_unsafe(src);
        return length(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Compute the squared length of this quaternion.
     *
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return the squared length of this quaternion
     */
    public static double lengthSquared(double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        return Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    /** {@link #lengthSquared(double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static double lengthSquared(java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.lengthSquared_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.lengthSquared_api(src, srcOffset);
    }

    /** {@link #lengthSquared(double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static double lengthSquared(java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.lengthSquared_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.lengthSquared_api(src, srcOffset);
    }

    /** {@link #lengthSquared(double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static double lengthSquared(java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return DoubleQuatOpsKernelsSegment.lengthSquared_unsafe(src, srcOffset);
        return DoubleQuatOpsKernelsSegment.lengthSquared_api(src, srcOffset);
    }

    /** {@link #lengthSquared(double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static double lengthSquared(long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.lengthSquared_unsafe(src);
        return lengthSquared(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] log(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t8 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest[destOffset + 0] = _selfx * _t8;
            dest[destOffset + 1] = _selfy * _t8;
            dest[destOffset + 2] = _selfz * _t8;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.log(Math.sqrt(_t4));
        return dest;
    }

    /** {@link #log(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer log(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.log_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.log_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #log(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer log(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.log_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.log_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #log(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment log(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.log_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.log_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #log(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long log(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.log_unsafe(dest, src);
        log(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] negativeX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t9 * _t13);
            dest[destOffset + 1] = -(_t7 * _t13);
            dest[destOffset + 2] = -(_t8 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #negativeX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer negativeX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.negativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.negativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer negativeX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.negativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.negativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment negativeX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.negativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.negativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long negativeX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.negativeX_unsafe(dest, src);
        negativeX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] negativeY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t8 * _t13);
            dest[destOffset + 1] = -(_t9 * _t13);
            dest[destOffset + 2] = -(_t7 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #negativeY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer negativeY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.negativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.negativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer negativeY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.negativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.negativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment negativeY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.negativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.negativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long negativeY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.negativeY_unsafe(dest, src);
        negativeY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] negativeZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = -(_t7 * _t13);
            dest[destOffset + 1] = -(_t8 * _t13);
            dest[destOffset + 2] = -(_t9 * _t13);
        } else {
            dest[destOffset + 0] = -0.0;
            dest[destOffset + 1] = -0.0;
            dest[destOffset + 2] = -0.0;
        }
        return dest;
    }

    /** {@link #negativeZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer negativeZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.negativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.negativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer negativeZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.negativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.negativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment negativeZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.negativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.negativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #negativeZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long negativeZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.negativeZ_unsafe(dest, src);
        negativeZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalize(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest[destOffset + 0] = _selfx * _t4;
            dest[destOffset + 1] = _selfy * _t4;
            dest[destOffset + 2] = _selfz * _t4;
            dest[destOffset + 3] = _selfw * _t4;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #normalize(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalize(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalize_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalize_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalize(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalize(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalize_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalize_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalize(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalize(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalize_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalize_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalize(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalize(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalize_unsafe(dest, src);
        normalize(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedNegativeX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0);
        dest[destOffset + 1] = -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest[destOffset + 2] = -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        return dest;
    }

    /** {@link #normalizedNegativeX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedNegativeX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedNegativeX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedNegativeX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedNegativeX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedNegativeX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedNegativeX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedNegativeX_unsafe(dest, src);
        normalizedNegativeX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedNegativeY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest[destOffset + 1] = Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0);
        dest[destOffset + 2] = -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        return dest;
    }

    /** {@link #normalizedNegativeY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedNegativeY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedNegativeY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedNegativeY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedNegativeY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedNegativeY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedNegativeY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedNegativeY_unsafe(dest, src);
        normalizedNegativeY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedNegativeZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        dest[destOffset + 1] = -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest[destOffset + 2] = Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0);
        return dest;
    }

    /** {@link #normalizedNegativeZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedNegativeZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedNegativeZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedNegativeZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedNegativeZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedNegativeZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedNegativeZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedNegativeZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedNegativeZ_unsafe(dest, src);
        normalizedNegativeZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedPositiveX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        return dest;
    }

    /** {@link #normalizedPositiveX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedPositiveX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedPositiveX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedPositiveX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedPositiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedPositiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedPositiveX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedPositiveX_unsafe(dest, src);
        normalizedPositiveX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedPositiveY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        dest[destOffset + 1] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        dest[destOffset + 2] = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        return dest;
    }

    /** {@link #normalizedPositiveY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedPositiveY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedPositiveY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedPositiveY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedPositiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedPositiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedPositiveY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedPositiveY_unsafe(dest, src);
        normalizedPositiveY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] normalizedPositiveZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        dest[destOffset + 0] = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        dest[destOffset + 1] = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        dest[destOffset + 2] = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        return dest;
    }

    /** {@link #normalizedPositiveZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer normalizedPositiveZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.normalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer normalizedPositiveZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.normalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment normalizedPositiveZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.normalizedPositiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.normalizedPositiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #normalizedPositiveZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long normalizedPositiveZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.normalizedPositiveZ_unsafe(dest, src);
        normalizedPositiveZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] positiveX(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t9 * _t13;
            dest[destOffset + 1] = _t7 * _t13;
            dest[destOffset + 2] = _t8 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #positiveX(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer positiveX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.positiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.positiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveX(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer positiveX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.positiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.positiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveX(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment positiveX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.positiveX_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.positiveX_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveX(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long positiveX(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.positiveX_unsafe(dest, src);
        positiveX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] positiveY(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t8 * _t13;
            dest[destOffset + 1] = _t9 * _t13;
            dest[destOffset + 2] = _t7 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #positiveY(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer positiveY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.positiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.positiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveY(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer positiveY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.positiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.positiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveY(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment positiveY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.positiveY_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.positiveY_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveY(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long positiveY(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.positiveY_unsafe(dest, src);
        positiveY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] positiveZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest[destOffset + 0] = _t7 * _t13;
            dest[destOffset + 1] = _t8 * _t13;
            dest[destOffset + 2] = _t9 * _t13;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        return dest;
    }

    /** {@link #positiveZ(double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer positiveZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.positiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsTypedBuffer.positiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveZ(double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer positiveZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.positiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsByteBuffer.positiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveZ(double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment positiveZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.positiveZ_unsafe(dest, destOffset, src, srcOffset);
        return DoubleQuatOpsKernelsSegment.positiveZ_api(dest, destOffset, src, srcOffset);
    }

    /** {@link #positiveZ(double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long positiveZ(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.positiveZ_unsafe(dest, src);
        positiveZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param t the exponent
     * @return {@code dest}
     */
    public static double[] pow(double[] dest, int destOffset, double[] src, int srcOffset, double t) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19, _t20, _t21;
        if (_t2 > 0.0) {
            _t19 = t * _selfz * _t12;
            _t20 = t * _selfx * _t12;
            _t21 = t * _selfy * _t12;
        } else {
            _t19 = t * 0.0;
            _t20 = t * 0.0;
            _t21 = t * 0.0;
        }
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        double _t29 = Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            dest[destOffset + 0] = _t20 * _t29;
            dest[destOffset + 1] = _t21 * _t29;
            dest[destOffset + 2] = _t19 * _t29;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
        }
        dest[destOffset + 3] = Math.cos(_t25) * _t11;
        return dest;
    }

    /** {@link #pow(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer pow(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.pow_unsafe(dest, destOffset, src, srcOffset, t);
        return DoubleQuatOpsKernelsTypedBuffer.pow_api(dest, destOffset, src, srcOffset, t);
    }

    /** {@link #pow(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer pow(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.pow_unsafe(dest, destOffset, src, srcOffset, t);
        return DoubleQuatOpsKernelsByteBuffer.pow_api(dest, destOffset, src, srcOffset, t);
    }

    /** {@link #pow(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment pow(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.pow_unsafe(dest, destOffset, src, srcOffset, t);
        return DoubleQuatOpsKernelsSegment.pow_api(dest, destOffset, src, srcOffset, t);
    }

    /** {@link #pow(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long pow(long dest, long src, double t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.pow_unsafe(dest, src, t);
        pow(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, t);
        return dest;
    }

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
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return {@code dest}
     */
    public static double[] premul(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #premul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer premul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #premul(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer premul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #premul(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment premul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    /** {@link #premul(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long premul(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        return DoubleQuatOps.preMul(dest, src, otherX, otherY, otherZ, otherW);
    }

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
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param other the storage holding the other quaternion
     * @param otherOffset the element index in {@code other} at which the quaternion starts
     * @return {@code dest}
     */
    public static double[] premul(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #premul(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer premul(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #premul(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer premul(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #premul(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment premul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        return DoubleQuatOps.preMul(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    /** {@link #premul(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long premul(long dest, long src, long other) {
        return DoubleQuatOps.preMul(dest, src, other);
    }

    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param step the maximum rotation angle in radians
     * @return {@code dest}
     */
    public static double[] rotateTowards(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t7 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
            _t15 = -targetW;
            _t16 = -targetZ;
            _t17 = -targetX;
            _t18 = -targetY;
        } else {
            _t15 = targetW;
            _t16 = targetZ;
            _t17 = targetX;
            _t18 = targetY;
        }
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
            _t46 = Math.fma(_selfw, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(_selfz, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(_selfx, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(_selfy, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(_selfw, _t21, _t15 * _t20);
            _t47 = Math.fma(_selfz, _t21, _t16 * _t20);
            _t48 = Math.fma(_selfx, _t21, _t17 * _t20);
            _t49 = Math.fma(_selfy, _t21, _t18 * _t20);
        }
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            dest[destOffset + 0] = _t54 * _t48;
            dest[destOffset + 1] = _t54 * _t49;
            dest[destOffset + 2] = _t54 * _t47;
            dest[destOffset + 3] = _t54 * _t46;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #rotateTowards(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateTowards(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateTowards_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
        return DoubleQuatOpsKernelsTypedBuffer.rotateTowards_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateTowards(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateTowards_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
        return DoubleQuatOpsKernelsByteBuffer.rotateTowards_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateTowards(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateTowards_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
        return DoubleQuatOpsKernelsSegment.rotateTowards_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateTowards(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateTowards_unsafe(dest, src, targetX, targetY, targetZ, targetW, step);
        rotateTowards(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, targetX, targetY, targetZ, targetW, step);
        return dest;
    }

    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param target the storage holding the target rotation
     * @param targetOffset the element index in {@code target} at which the quaternion starts
     * @param step the maximum rotation angle in radians
     * @return {@code dest}
     */
    public static double[] rotateTowards(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double step) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _targetx = target[targetOffset + 0];
        double _targety = target[targetOffset + 1];
        double _targetz = target[targetOffset + 2];
        double _targetw = target[targetOffset + 3];
        double _t7 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
            _t15 = -_targetw;
            _t16 = -_targetz;
            _t17 = -_targetx;
            _t18 = -_targety;
        } else {
            _t15 = _targetw;
            _t16 = _targetz;
            _t17 = _targetx;
            _t18 = _targety;
        }
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
            _t46 = Math.fma(_selfw, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(_selfz, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(_selfx, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(_selfy, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(_selfw, _t21, _t15 * _t20);
            _t47 = Math.fma(_selfz, _t21, _t16 * _t20);
            _t48 = Math.fma(_selfx, _t21, _t17 * _t20);
            _t49 = Math.fma(_selfy, _t21, _t18 * _t20);
        }
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            dest[destOffset + 0] = _t54 * _t48;
            dest[destOffset + 1] = _t54 * _t49;
            dest[destOffset + 2] = _t54 * _t47;
            dest[destOffset + 3] = _t54 * _t46;
        } else {
            dest[destOffset + 0] = 0.0;
            dest[destOffset + 1] = 0.0;
            dest[destOffset + 2] = 0.0;
            dest[destOffset + 3] = 0.0;
        }
        return dest;
    }

    /** {@link #rotateTowards(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateTowards(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer target, int targetOffset, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateTowards_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return DoubleQuatOpsKernelsTypedBuffer.rotateTowards_api(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateTowards(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && target.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateTowards_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return DoubleQuatOpsKernelsByteBuffer.rotateTowards_api(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateTowards(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && target.isNative()) return DoubleQuatOpsKernelsSegment.rotateTowards_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return DoubleQuatOpsKernelsSegment.rotateTowards_api(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    /** {@link #rotateTowards(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateTowards(long dest, long src, long target, double step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateTowards_unsafe(dest, src, target, step);
        rotateTowards(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(target, 32L), 0L, step);
        return dest;
    }

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return {@code dest}
     */
    public static double[] lookAlong(double[] dest, int destOffset, double[] src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109));
        dest[destOffset + 1] = Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108));
        dest[destOffset + 2] = Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111));
        dest[destOffset + 3] = Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111))));
        return dest;
    }

    /** {@link #lookAlong(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer lookAlong(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.lookAlong_unsafe(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsTypedBuffer.lookAlong_api(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #lookAlong(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer lookAlong(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.lookAlong_unsafe(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsByteBuffer.lookAlong_api(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #lookAlong(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment lookAlong(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.lookAlong_unsafe(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsSegment.lookAlong_api(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #lookAlong(double[], int, double[], int, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long lookAlong(long dest, long src, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.lookAlong_unsafe(dest, src, dirX, dirY, dirZ, upX, upY, upZ);
        lookAlong(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param dir the storage holding the direction
     * @param dirOffset the element index in {@code dir} at which the vector starts
     * @param up the storage holding the direction of "up"
     * @param upOffset the element index in {@code up} at which the vector starts
     * @return {@code dest}
     */
    public static double[] lookAlong(double[] dest, int destOffset, double[] src, int srcOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _dirx = dir[dirOffset + 0];
        double _diry = dir[dirOffset + 1];
        double _dirz = dir[dirOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109));
        dest[destOffset + 1] = Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108));
        dest[destOffset + 2] = Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111));
        dest[destOffset + 3] = Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111))));
        return dest;
    }

    /** {@link #lookAlong(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer lookAlong(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && dir.isDirect() && up.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.lookAlong_unsafe(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsTypedBuffer.lookAlong_api(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #lookAlong(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer lookAlong(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && dir.isDirect() && up.isDirect()) return DoubleQuatOpsKernelsByteBuffer.lookAlong_unsafe(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsByteBuffer.lookAlong_api(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #lookAlong(double[], int, double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment lookAlong(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && dir.isNative() && up.isNative()) return DoubleQuatOpsKernelsSegment.lookAlong_unsafe(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsSegment.lookAlong_api(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #lookAlong(double[], int, double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long lookAlong(long dest, long src, long dir, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.lookAlong_unsafe(dest, src, dir, up);
        lookAlong(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dir, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 24L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return {@code dest}
     */
    public static double[] makeRotationAxis(double[] dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest[destOffset + 0] = axisX * _t1;
        dest[destOffset + 1] = axisY * _t1;
        dest[destOffset + 2] = axisZ * _t1;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    /** {@link #makeRotationAxis(double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationAxis(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationAxis_unsafe(dest, destOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationAxis_api(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #makeRotationAxis(double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationAxis(java.nio.ByteBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationAxis_unsafe(dest, destOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationAxis_api(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #makeRotationAxis(double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationAxis(java.lang.foreign.MemorySegment dest, long destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationAxis_unsafe(dest, destOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsSegment.makeRotationAxis_api(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #makeRotationAxis(double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationAxis(long dest, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationAxis_unsafe(dest, angle, axisX, axisY, axisZ);
        makeRotationAxis(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angle, axisX, axisY, axisZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param axis the storage holding the rotation axis (must be a unit vector)
     * @param axisOffset the element index in {@code axis} at which the vector starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] makeRotationAxis(double[] dest, int destOffset, double[] axis, int axisOffset, double angle) {
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest[destOffset + 0] = _axisx * _t1;
        dest[destOffset + 1] = _axisy * _t1;
        dest[destOffset + 2] = _axisz * _t1;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    /** {@link #makeRotationAxis(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationAxis(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && axis.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationAxis_unsafe(dest, destOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationAxis_api(dest, destOffset, axis, axisOffset, angle);
    }

    /** {@link #makeRotationAxis(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationAxis(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && axis.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeRotationAxis_unsafe(dest, destOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationAxis_api(dest, destOffset, axis, axisOffset, angle);
    }

    /** {@link #makeRotationAxis(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && axis.isNative()) return DoubleQuatOpsKernelsSegment.makeRotationAxis_unsafe(dest, destOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsSegment.makeRotationAxis_api(dest, destOffset, axis, axisOffset, angle);
    }

    /** {@link #makeRotationAxis(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationAxis(long dest, long axis, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationAxis_unsafe(dest, axis, angle);
        makeRotationAxis(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(axis, 24L), 0L, angle);
        return dest;
    }

    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return {@code dest}
     */
    public static double[] makeRotationLookAlong(double[] dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t55 * _t64;
            dest[destOffset + 1] = 0.5 * _t38 * _t64;
            dest[destOffset + 2] = 0.5 * _t58 * _t64;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t61);
                dest[destOffset + 1] = 0.5 * _t57 * _t67;
                dest[destOffset + 2] = 0.5 * _t37 * _t67;
                dest[destOffset + 3] = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    dest[destOffset + 0] = 0.5 * _t57 * _t65;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t62);
                    dest[destOffset + 2] = 0.5 * _t54 * _t65;
                    dest[destOffset + 3] = 0.5 * _t38 * _t65;
                } else {
                    dest[destOffset + 0] = 0.5 * _t37 * _t66;
                    dest[destOffset + 1] = 0.5 * _t54 * _t66;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t63);
                    dest[destOffset + 3] = 0.5 * _t58 * _t66;
                }
            }
        }
        return dest;
    }

    /** {@link #makeRotationLookAlong(double[], int, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationLookAlong(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationLookAlong_unsafe(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationLookAlong_api(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #makeRotationLookAlong(double[], int, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationLookAlong(java.nio.ByteBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationLookAlong_unsafe(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationLookAlong_api(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #makeRotationLookAlong(double[], int, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationLookAlong(java.lang.foreign.MemorySegment dest, long destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationLookAlong_unsafe(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return DoubleQuatOpsKernelsSegment.makeRotationLookAlong_api(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    /** {@link #makeRotationLookAlong(double[], int, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationLookAlong(long dest, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(dest, dirX, dirY, dirZ, upX, upY, upZ);
        makeRotationLookAlong(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param dir the storage holding the direction
     * @param dirOffset the element index in {@code dir} at which the vector starts
     * @param up the storage holding the direction of "up"
     * @param upOffset the element index in {@code up} at which the vector starts
     * @return {@code dest}
     */
    public static double[] makeRotationLookAlong(double[] dest, int destOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        double _dirx = dir[dirOffset + 0];
        double _diry = dir[dirOffset + 1];
        double _dirz = dir[dirOffset + 2];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            dest[destOffset + 0] = 0.5 * _t55 * _t64;
            dest[destOffset + 1] = 0.5 * _t38 * _t64;
            dest[destOffset + 2] = 0.5 * _t58 * _t64;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                dest[destOffset + 0] = 0.5 * Math.sqrt(_t61);
                dest[destOffset + 1] = 0.5 * _t57 * _t67;
                dest[destOffset + 2] = 0.5 * _t37 * _t67;
                dest[destOffset + 3] = 0.5 * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    dest[destOffset + 0] = 0.5 * _t57 * _t65;
                    dest[destOffset + 1] = 0.5 * Math.sqrt(_t62);
                    dest[destOffset + 2] = 0.5 * _t54 * _t65;
                    dest[destOffset + 3] = 0.5 * _t38 * _t65;
                } else {
                    dest[destOffset + 0] = 0.5 * _t37 * _t66;
                    dest[destOffset + 1] = 0.5 * _t54 * _t66;
                    dest[destOffset + 2] = 0.5 * Math.sqrt(_t63);
                    dest[destOffset + 3] = 0.5 * _t58 * _t66;
                }
            }
        }
        return dest;
    }

    /** {@link #makeRotationLookAlong(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationLookAlong(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dir.isDirect() && up.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationLookAlong_unsafe(dest, destOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationLookAlong_api(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #makeRotationLookAlong(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationLookAlong(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && dir.isDirect() && up.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeRotationLookAlong_unsafe(dest, destOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationLookAlong_api(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #makeRotationLookAlong(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationLookAlong(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && dir.isNative() && up.isNative()) return DoubleQuatOpsKernelsSegment.makeRotationLookAlong_unsafe(dest, destOffset, dir, dirOffset, up, upOffset);
        return DoubleQuatOpsKernelsSegment.makeRotationLookAlong_api(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    /** {@link #makeRotationLookAlong(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationLookAlong(long dest, long dir, long up) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(dest, dir, up);
        makeRotationLookAlong(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dir, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(up, 24L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to the rotation that rotates {@code fromDir} onto {@code toDir} (both
     * must be unit vectors; for opposite vectors an arbitrary perpendicular rotation axis is
     * chosen).
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @return {@code dest}
     */
    public static double[] makeRotationTo(double[] dest, int destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _t4 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = fromDirY;
            _t8 = 0.0;
            _t9 = -fromDirX;
        } else {
            _t6 = 0.0;
            _t8 = -fromDirY;
            _t9 = fromDirZ;
        }
        double _t7 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            dest[destOffset + 0] = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11;
            dest[destOffset + 1] = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11;
            dest[destOffset + 2] = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t10);
        } else {
            if (_t14 > 0.0) {
                dest[destOffset + 0] = _t15 * _t6;
                dest[destOffset + 1] = _t15 * _t9;
                dest[destOffset + 2] = _t15 * _t8;
                dest[destOffset + 3] = 0.0;
            } else {
                dest[destOffset + 0] = 0.0;
                dest[destOffset + 1] = 0.0;
                dest[destOffset + 2] = 0.0;
                dest[destOffset + 3] = 0.0;
            }
        }
        return dest;
    }

    /** {@link #makeRotationTo(double[], int, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationTo(java.nio.DoubleBuffer dest, int destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationTo_unsafe(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationTo_api(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #makeRotationTo(double[], int, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationTo(java.nio.ByteBuffer dest, int destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationTo_unsafe(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationTo_api(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #makeRotationTo(double[], int, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationTo(java.lang.foreign.MemorySegment dest, long destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationTo_unsafe(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsSegment.makeRotationTo_api(dest, destOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #makeRotationTo(double[], int, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationTo(long dest, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationTo_unsafe(dest, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        makeRotationTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    /**
     * Set this quaternion to the rotation that rotates {@code fromDir} onto {@code toDir} (both
     * must be unit vectors; for opposite vectors an arbitrary perpendicular rotation axis is
     * chosen).
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param fromDir the storage holding the vector
     * @param fromDirOffset the element index in {@code fromDir} at which the vector starts
     * @param toDir the storage holding the vector
     * @param toDirOffset the element index in {@code toDir} at which the vector starts
     * @return {@code dest}
     */
    public static double[] makeRotationTo(double[] dest, int destOffset, double[] fromDir, int fromDirOffset, double[] toDir, int toDirOffset) {
        double _fromDirx = fromDir[fromDirOffset + 0];
        double _fromDiry = fromDir[fromDirOffset + 1];
        double _fromDirz = fromDir[fromDirOffset + 2];
        double _toDirx = toDir[toDirOffset + 0];
        double _toDiry = toDir[toDirOffset + 1];
        double _toDirz = toDir[toDirOffset + 2];
        double _t4 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = _fromDiry;
            _t8 = 0.0;
            _t9 = -_fromDirx;
        } else {
            _t6 = 0.0;
            _t8 = -_fromDiry;
            _t9 = _fromDirz;
        }
        double _t7 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            dest[destOffset + 0] = Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t11;
            dest[destOffset + 1] = Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t11;
            dest[destOffset + 2] = Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t11;
            dest[destOffset + 3] = 0.5 * Math.sqrt(_t10);
        } else {
            if (_t14 > 0.0) {
                dest[destOffset + 0] = _t15 * _t6;
                dest[destOffset + 1] = _t15 * _t9;
                dest[destOffset + 2] = _t15 * _t8;
                dest[destOffset + 3] = 0.0;
            } else {
                dest[destOffset + 0] = 0.0;
                dest[destOffset + 1] = 0.0;
                dest[destOffset + 2] = 0.0;
                dest[destOffset + 3] = 0.0;
            }
        }
        return dest;
    }

    /** {@link #makeRotationTo(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationTo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer fromDir, int fromDirOffset, java.nio.DoubleBuffer toDir, int toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && fromDir.isDirect() && toDir.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationTo_unsafe(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationTo_api(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #makeRotationTo(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationTo(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && fromDir.isDirect() && toDir.isDirect()) return DoubleQuatOpsKernelsByteBuffer.makeRotationTo_unsafe(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationTo_api(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #makeRotationTo(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationTo(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && fromDir.isNative() && toDir.isNative()) return DoubleQuatOpsKernelsSegment.makeRotationTo_unsafe(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsSegment.makeRotationTo_api(dest, destOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #makeRotationTo(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationTo(long dest, long fromDir, long toDir) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationTo_unsafe(dest, fromDir, toDir);
        makeRotationTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(fromDir, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(toDir, 24L), 0L);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] makeRotationX(double[] dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest[destOffset + 0] = Math.sin(_t0);
        dest[destOffset + 1] = 0.0;
        dest[destOffset + 2] = 0.0;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    /** {@link #makeRotationX(double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationX(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationX_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationX_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationX(double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationX(java.nio.ByteBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationX_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationX_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationX(double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationX(java.lang.foreign.MemorySegment dest, long destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationX_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsSegment.makeRotationX_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationX(double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationX(long dest, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationX_unsafe(dest, angle);
        makeRotationX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angle);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationXYZ(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        dest[destOffset + 0] = Math.fma(_t9, _t5, _t10 * _t8);
        dest[destOffset + 1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dest[destOffset + 2] = Math.fma(_t11, _t5, _t12 * _t8);
        dest[destOffset + 3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return dest;
    }

    /** {@link #makeRotationXYZ(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationXYZ(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationXYZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationXYZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXYZ(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationXYZ(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationXYZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationXYZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXYZ(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationXYZ(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationXYZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationXYZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXYZ(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationXYZ(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationXYZ_unsafe(dest, angleX, angleY, angleZ);
        makeRotationXYZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationXZY(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        dest[destOffset + 0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dest[destOffset + 1] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dest[destOffset + 2] = Math.fma(_t9, _t8, _t10 * _t5);
        dest[destOffset + 3] = Math.fma(_t12, _t8, _t11 * _t5);
        return dest;
    }

    /** {@link #makeRotationXZY(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationXZY(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationXZY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationXZY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXZY(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationXZY(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationXZY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationXZY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXZY(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationXZY(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationXZY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationXZY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationXZY(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationXZY(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationXZY_unsafe(dest, angleX, angleY, angleZ);
        makeRotationXZY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] makeRotationY(double[] dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest[destOffset + 0] = 0.0;
        dest[destOffset + 1] = Math.sin(_t0);
        dest[destOffset + 2] = 0.0;
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    /** {@link #makeRotationY(double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationY(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationY_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationY_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationY(double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationY(java.nio.ByteBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationY_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationY_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationY(double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationY(java.lang.foreign.MemorySegment dest, long destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationY_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsSegment.makeRotationY_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationY(double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationY(long dest, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationY_unsafe(dest, angle);
        makeRotationY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angle);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationYXZ(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        dest[destOffset + 0] = Math.fma(_t9, _t5, _t10 * _t8);
        dest[destOffset + 1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dest[destOffset + 2] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dest[destOffset + 3] = Math.fma(_t12, _t8, _t11 * _t5);
        return dest;
    }

    /** {@link #makeRotationYXZ(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationYXZ(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationYXZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationYXZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYXZ(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationYXZ(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationYXZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationYXZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYXZ(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationYXZ(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationYXZ_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationYXZ_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYXZ(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationYXZ(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationYXZ_unsafe(dest, angleX, angleY, angleZ);
        makeRotationYXZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationYZX(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        dest[destOffset + 0] = Math.fma(_t9, _t5, _t10 * _t8);
        dest[destOffset + 1] = Math.fma(_t11, _t5, _t12 * _t8);
        dest[destOffset + 2] = Math.fma(_t12, _t5, -(_t11 * _t8));
        dest[destOffset + 3] = Math.fma(_t10, _t5, -(_t9 * _t8));
        return dest;
    }

    /** {@link #makeRotationYZX(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationYZX(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationYZX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationYZX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYZX(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationYZX(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationYZX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationYZX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYZX(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationYZX(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationYZX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationYZX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationYZX(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationYZX(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationYZX_unsafe(dest, angleX, angleY, angleZ);
        makeRotationYZX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] makeRotationZ(double[] dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest[destOffset + 0] = 0.0;
        dest[destOffset + 1] = 0.0;
        dest[destOffset + 2] = Math.sin(_t0);
        dest[destOffset + 3] = Math.cos(_t0);
        return dest;
    }

    /** {@link #makeRotationZ(double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationZ(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationZ_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationZ_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationZ(double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationZ(java.nio.ByteBuffer dest, int destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationZ_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationZ_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationZ(double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationZ(java.lang.foreign.MemorySegment dest, long destOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationZ_unsafe(dest, destOffset, angle);
        return DoubleQuatOpsKernelsSegment.makeRotationZ_api(dest, destOffset, angle);
    }

    /** {@link #makeRotationZ(double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationZ(long dest, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationZ_unsafe(dest, angle);
        makeRotationZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angle);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationZXY(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        dest[destOffset + 0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dest[destOffset + 1] = Math.fma(_t11, _t5, _t12 * _t8);
        dest[destOffset + 2] = Math.fma(_t9, _t8, _t10 * _t5);
        dest[destOffset + 3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return dest;
    }

    /** {@link #makeRotationZXY(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationZXY(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationZXY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationZXY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZXY(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationZXY(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationZXY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationZXY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZXY(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationZXY(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationZXY_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationZXY_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZXY(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationZXY(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationZXY_unsafe(dest, angleX, angleY, angleZ);
        makeRotationZXY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] makeRotationZYX(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        dest[destOffset + 0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dest[destOffset + 1] = Math.fma(_t11, _t8, _t12 * _t5);
        dest[destOffset + 2] = Math.fma(_t12, _t8, -(_t11 * _t5));
        dest[destOffset + 3] = Math.fma(_t10, _t5, _t9 * _t8);
        return dest;
    }

    /** {@link #makeRotationZYX(double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer makeRotationZYX(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsTypedBuffer.makeRotationZYX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.makeRotationZYX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZYX(double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer makeRotationZYX(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return DoubleQuatOpsKernelsByteBuffer.makeRotationZYX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.makeRotationZYX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZYX(double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment makeRotationZYX(java.lang.foreign.MemorySegment dest, long destOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) return DoubleQuatOpsKernelsSegment.makeRotationZYX_unsafe(dest, destOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.makeRotationZYX_api(dest, destOffset, angleX, angleY, angleZ);
    }

    /** {@link #makeRotationZYX(double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long makeRotationZYX(long dest, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.makeRotationZYX_unsafe(dest, angleX, angleY, angleZ);
        makeRotationZYX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] preRotateX(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfw * _t2);
        dest[destOffset + 1] = Math.fma(_selfy, _t1, -(_selfz * _t2));
        dest[destOffset + 2] = Math.fma(_selfy, _t2, _selfz * _t1);
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfx * _t2));
        return dest;
    }

    /** {@link #preRotateX(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer preRotateX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.preRotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.preRotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateX(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer preRotateX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.preRotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.preRotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateX(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment preRotateX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.preRotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.preRotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateX(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long preRotateX(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.preRotateX_unsafe(dest, src, angle);
        preRotateX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] preRotateY(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfz * _t2);
        dest[destOffset + 1] = Math.fma(_selfy, _t1, _selfw * _t2);
        dest[destOffset + 2] = Math.fma(_selfz, _t1, -(_selfx * _t2));
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfy * _t2));
        return dest;
    }

    /** {@link #preRotateY(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer preRotateY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.preRotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.preRotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateY(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer preRotateY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.preRotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.preRotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateY(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment preRotateY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.preRotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.preRotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateY(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long preRotateY(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.preRotateY_unsafe(dest, src, angle);
        preRotateY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] preRotateZ(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, -(_selfy * _t2));
        dest[destOffset + 1] = Math.fma(_selfx, _t2, _selfy * _t1);
        dest[destOffset + 2] = Math.fma(_selfz, _t1, _selfw * _t2);
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfz * _t2));
        return dest;
    }

    /** {@link #preRotateZ(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer preRotateZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.preRotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.preRotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateZ(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer preRotateZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.preRotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.preRotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateZ(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment preRotateZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.preRotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.preRotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #preRotateZ(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long preRotateZ(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.preRotateZ_unsafe(dest, src, angle);
        preRotateZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return {@code dest}
     */
    public static double[] rotateAxis(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5));
        dest[destOffset + 1] = Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4));
        dest[destOffset + 2] = Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3));
        dest[destOffset + 3] = Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3))));
        return dest;
    }

    /** {@link #rotateAxis(double[], int, double[], int, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateAxis(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateAxis_unsafe(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateAxis_api(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateAxis(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateAxis_unsafe(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateAxis_api(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateAxis_unsafe(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return DoubleQuatOpsKernelsSegment.rotateAxis_api(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateAxis(long dest, long src, double angle, double axisX, double axisY, double axisZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateAxis_unsafe(dest, src, angle, axisX, axisY, axisZ);
        rotateAxis(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle, axisX, axisY, axisZ);
        return dest;
    }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param axis the storage holding the rotation axis (must be a unit vector)
     * @param axisOffset the element index in {@code axis} at which the vector starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] rotateAxis(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _axisx = axis[axisOffset + 0];
        double _axisy = axis[axisOffset + 1];
        double _axisz = axis[axisOffset + 2];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = _axisx * _t2;
        double _t4 = _axisz * _t2;
        double _t5 = _axisy * _t2;
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5));
        dest[destOffset + 1] = Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4));
        dest[destOffset + 2] = Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3));
        dest[destOffset + 3] = Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3))));
        return dest;
    }

    /** {@link #rotateAxis(double[], int, double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateAxis(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateAxis_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.rotateAxis_api(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateAxis(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && axis.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateAxis_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.rotateAxis_api(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && axis.isNative()) return DoubleQuatOpsKernelsSegment.rotateAxis_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return DoubleQuatOpsKernelsSegment.rotateAxis_api(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    /** {@link #rotateAxis(double[], int, double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateAxis(long dest, long src, long axis, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateAxis_unsafe(dest, src, axis, angle);
        rotateAxis(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(axis, 24L), 0L, angle);
        return dest;
    }

    /**
     * Apply the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen) to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @return {@code dest}
     */
    public static double[] rotateTo(double[] dest, int destOffset, double[] src, int srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t10 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = fromDirY;
            _t17 = 0.0;
            _t18 = -fromDirX;
        } else {
            _t15 = 0.0;
            _t17 = -fromDirY;
            _t18 = fromDirZ;
        }
        double _t16 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t21;
            _t38 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t21;
            _t39 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39));
        dest[destOffset + 1] = Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38));
        dest[destOffset + 2] = Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37));
        dest[destOffset + 3] = Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37))));
        return dest;
    }

    /** {@link #rotateTo(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateTo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateTo_api(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #rotateTo(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateTo(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateTo_api(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #rotateTo(double[], int, double[], int, double, double, double, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateTo(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return DoubleQuatOpsKernelsSegment.rotateTo_api(dest, destOffset, src, srcOffset, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    /** {@link #rotateTo(double[], int, double[], int, double, double, double, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateTo(long dest, long src, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateTo_unsafe(dest, src, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        rotateTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    /**
     * Apply the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen) to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param fromDir the storage holding the vector
     * @param fromDirOffset the element index in {@code fromDir} at which the vector starts
     * @param toDir the storage holding the vector
     * @param toDirOffset the element index in {@code toDir} at which the vector starts
     * @return {@code dest}
     */
    public static double[] rotateTo(double[] dest, int destOffset, double[] src, int srcOffset, double[] fromDir, int fromDirOffset, double[] toDir, int toDirOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _fromDirx = fromDir[fromDirOffset + 0];
        double _fromDiry = fromDir[fromDirOffset + 1];
        double _fromDirz = fromDir[fromDirOffset + 2];
        double _toDirx = toDir[toDirOffset + 0];
        double _toDiry = toDir[toDirOffset + 1];
        double _toDirz = toDir[toDirOffset + 2];
        double _t10 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = _fromDiry;
            _t17 = 0.0;
            _t18 = -_fromDirx;
        } else {
            _t15 = 0.0;
            _t17 = -_fromDiry;
            _t18 = _fromDirz;
        }
        double _t16 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t21;
            _t38 = Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t21;
            _t39 = Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        dest[destOffset + 0] = Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39));
        dest[destOffset + 1] = Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38));
        dest[destOffset + 2] = Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37));
        dest[destOffset + 3] = Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37))));
        return dest;
    }

    /** {@link #rotateTo(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateTo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer fromDir, int fromDirOffset, java.nio.DoubleBuffer toDir, int toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && fromDir.isDirect() && toDir.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsTypedBuffer.rotateTo_api(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #rotateTo(double[], int, double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateTo(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && fromDir.isDirect() && toDir.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsByteBuffer.rotateTo_api(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #rotateTo(double[], int, double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateTo(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && fromDir.isNative() && toDir.isNative()) return DoubleQuatOpsKernelsSegment.rotateTo_unsafe(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
        return DoubleQuatOpsKernelsSegment.rotateTo_api(dest, destOffset, src, srcOffset, fromDir, fromDirOffset, toDir, toDirOffset);
    }

    /** {@link #rotateTo(double[], int, double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateTo(long dest, long src, long fromDir, long toDir) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateTo_unsafe(dest, src, fromDir, toDir);
        rotateTo(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(fromDir, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(toDir, 24L), 0L);
        return dest;
    }

    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] rotateX(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfw * _t2);
        dest[destOffset + 1] = Math.fma(_selfy, _t1, _selfz * _t2);
        dest[destOffset + 2] = Math.fma(_selfz, _t1, -(_selfy * _t2));
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfx * _t2));
        return dest;
    }

    /** {@link #rotateX(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.rotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateX(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.rotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateX(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateX_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.rotateX_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateX(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateX(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateX_unsafe(dest, src, angle);
        rotateX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateXYZ(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        dest[destOffset + 0] = Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t20, -(_selfz * _t22));
        dest[destOffset + 1] = Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t22, -(_selfx * _t20));
        dest[destOffset + 2] = Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t21, -(_selfy * _t19));
        dest[destOffset + 3] = Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t21, -(_selfx * _t19))));
        return dest;
    }

    /** {@link #rotateXYZ(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateXYZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateXYZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateXYZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXYZ(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateXYZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateXYZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateXYZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXYZ(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateXYZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateXYZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateXYZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXYZ(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateXYZ(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateXYZ_unsafe(dest, src, angleX, angleY, angleZ);
        rotateXYZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateXZY(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        dest[destOffset + 0] = Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t20, -(_selfz * _t22));
        dest[destOffset + 1] = Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t22, -(_selfx * _t20));
        dest[destOffset + 2] = Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t19, -(_selfy * _t21));
        dest[destOffset + 3] = Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t21))));
        return dest;
    }

    /** {@link #rotateXZY(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateXZY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateXZY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateXZY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXZY(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateXZY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateXZY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateXZY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXZY(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateXZY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateXZY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateXZY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateXZY(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateXZY(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateXZY_unsafe(dest, src, angleX, angleY, angleZ);
        rotateXZY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] rotateY(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, -(_selfz * _t2));
        dest[destOffset + 1] = Math.fma(_selfy, _t1, _selfw * _t2);
        dest[destOffset + 2] = Math.fma(_selfx, _t2, _selfz * _t1);
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfy * _t2));
        return dest;
    }

    /** {@link #rotateY(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.rotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateY(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.rotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateY(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateY_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.rotateY_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateY(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateY(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateY_unsafe(dest, src, angle);
        rotateY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateYXZ(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        dest[destOffset + 0] = Math.fma(_selfx, _t19, _selfw * _t20) + Math.fma(_selfy, _t21, -(_selfz * _t22));
        dest[destOffset + 1] = Math.fma(_selfy, _t19, _selfz * _t20) + Math.fma(_selfw, _t22, -(_selfx * _t21));
        dest[destOffset + 2] = Math.fma(_selfx, _t22, _selfw * _t21) + Math.fma(_selfz, _t19, -(_selfy * _t20));
        dest[destOffset + 3] = Math.fma(-_selfz, _t21, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t20))));
        return dest;
    }

    /** {@link #rotateYXZ(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateYXZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateYXZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateYXZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYXZ(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateYXZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateYXZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateYXZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYXZ(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateYXZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateYXZ_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateYXZ_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYXZ(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateYXZ(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateYXZ_unsafe(dest, src, angleX, angleY, angleZ);
        rotateYXZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateYZX(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t3;
        double _t12 = _t6 * _t4;
        double _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        dest[destOffset + 0] = Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t22, -(_selfz * _t20));
        dest[destOffset + 1] = Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t20, -(_selfx * _t22));
        dest[destOffset + 2] = Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t21, -(_selfy * _t19));
        dest[destOffset + 3] = Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t19))));
        return dest;
    }

    /** {@link #rotateYZX(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateYZX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateYZX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateYZX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYZX(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateYZX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateYZX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateYZX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYZX(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateYZX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateYZX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateYZX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateYZX(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateYZX(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateYZX_unsafe(dest, src, angleX, angleY, angleZ);
        rotateYZX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis and store the result
     * in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angle the angle in radians
     * @return {@code dest}
     */
    public static double[] rotateZ(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest[destOffset + 0] = Math.fma(_selfx, _t1, _selfy * _t2);
        dest[destOffset + 1] = Math.fma(_selfy, _t1, -(_selfx * _t2));
        dest[destOffset + 2] = Math.fma(_selfz, _t1, _selfw * _t2);
        dest[destOffset + 3] = Math.fma(_selfw, _t1, -(_selfz * _t2));
        return dest;
    }

    /** {@link #rotateZ(double[], int, double[], int, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateZ(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsTypedBuffer.rotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateZ(double[], int, double[], int, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateZ(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsByteBuffer.rotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateZ(double[], int, double[], int, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateZ_unsafe(dest, destOffset, src, srcOffset, angle);
        return DoubleQuatOpsKernelsSegment.rotateZ_api(dest, destOffset, src, srcOffset, angle);
    }

    /** {@link #rotateZ(double[], int, double[], int, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateZ(long dest, long src, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateZ_unsafe(dest, src, angle);
        rotateZ(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angle);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateZXY(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        dest[destOffset + 0] = Math.fma(_selfx, _t21, _selfw * _t22) + Math.fma(_selfy, _t19, -(_selfz * _t20));
        dest[destOffset + 1] = Math.fma(_selfy, _t21, _selfz * _t22) + Math.fma(_selfw, _t20, -(_selfx * _t19));
        dest[destOffset + 2] = Math.fma(_selfx, _t20, _selfw * _t19) + Math.fma(_selfz, _t21, -(_selfy * _t22));
        dest[destOffset + 3] = Math.fma(-_selfz, _t19, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t22))));
        return dest;
    }

    /** {@link #rotateZXY(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateZXY(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateZXY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateZXY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZXY(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateZXY(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateZXY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateZXY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZXY(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateZXY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateZXY_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateZXY_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZXY(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateZXY(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateZXY_unsafe(dest, src, angleX, angleY, angleZ);
        rotateZXY(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the quaternion starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return {@code dest}
     */
    public static double[] rotateZYX(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t4 * _t6;
        double _t12 = _t3 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        dest[destOffset + 0] = Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t22, -(_selfz * _t20));
        dest[destOffset + 1] = Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t20, -(_selfx * _t22));
        dest[destOffset + 2] = Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t19, -(_selfy * _t21));
        dest[destOffset + 3] = Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t19, -(_selfx * _t21))));
        return dest;
    }

    /** {@link #rotateZYX(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer rotateZYX(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.rotateZYX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsTypedBuffer.rotateZYX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZYX(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer rotateZYX(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.rotateZYX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsByteBuffer.rotateZYX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZYX(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment rotateZYX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.rotateZYX_unsafe(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return DoubleQuatOpsKernelsSegment.rotateZYX_api(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    /** {@link #rotateZYX(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long rotateZYX(long dest, long src, double angleX, double angleY, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.rotateZYX_unsafe(dest, src, angleX, angleY, angleZ);
        rotateZYX(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, angleX, angleY, angleZ);
        return dest;
    }

    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return {@code dest}
     */
    public static double[] transform(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t9 = 2.0 * Math.fma(_selfx, vY, -(_selfy * vX));
        double _t10 = 2.0 * Math.fma(_selfz, vX, -(_selfx * vZ));
        double _t11 = 2.0 * Math.fma(_selfy, vZ, -(_selfz * vY));
        dest[destOffset + 0] = Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, vX)));
        dest[destOffset + 1] = Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vY)));
        dest[destOffset + 2] = Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, vZ)));
        return dest;
    }

    /** {@link #transform(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer transform(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.transform_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsTypedBuffer.transform_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transform(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer transform(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.transform_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsByteBuffer.transform_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transform(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment transform(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.transform_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsSegment.transform_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transform(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long transform(long dest, long src, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.transform_unsafe(dest, src, vX, vY, vZ);
        transform(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, vX, vY, vZ);
        return dest;
    }

    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param v the storage holding the vector
     * @param vOffset the element index in {@code v} at which the vector starts
     * @return {@code dest}
     */
    public static double[] transform(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        double _t9 = 2.0 * Math.fma(_selfx, _vy, -(_selfy * _vx));
        double _t10 = 2.0 * Math.fma(_selfz, _vx, -(_selfx * _vz));
        double _t11 = 2.0 * Math.fma(_selfy, _vz, -(_selfz * _vy));
        dest[destOffset + 0] = Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, _vx)));
        dest[destOffset + 1] = Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vy)));
        dest[destOffset + 2] = Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, _vz)));
        return dest;
    }

    /** {@link #transform(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer transform(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && v.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.transform_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsTypedBuffer.transform_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transform(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer transform(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && v.isDirect()) return DoubleQuatOpsKernelsByteBuffer.transform_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsByteBuffer.transform_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transform(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment transform(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && v.isNative()) return DoubleQuatOpsKernelsSegment.transform_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsSegment.transform_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transform(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long transform(long dest, long src, long v) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.transform_unsafe(dest, src, v);
        transform(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(v, 24L), 0L);
        return dest;
    }

    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return {@code dest}
     */
    public static double[] transformInverse(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _t9 = 2.0 * Math.fma(_selfx, vZ, -(_selfz * vX));
        double _t10 = 2.0 * Math.fma(_selfy, vX, -(_selfx * vY));
        double _t11 = 2.0 * Math.fma(_selfz, vY, -(_selfy * vZ));
        dest[destOffset + 0] = Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, vX)));
        dest[destOffset + 1] = Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, vY)));
        dest[destOffset + 2] = Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vZ)));
        return dest;
    }

    /** {@link #transformInverse(double[], int, double[], int, double, double, double)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer transformInverse(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.transformInverse_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsTypedBuffer.transformInverse_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transformInverse(double[], int, double[], int, double, double, double)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer transformInverse(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return DoubleQuatOpsKernelsByteBuffer.transformInverse_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsByteBuffer.transformInverse_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transformInverse(double[], int, double[], int, double, double, double)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment transformInverse(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) return DoubleQuatOpsKernelsSegment.transformInverse_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return DoubleQuatOpsKernelsSegment.transformInverse_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    /** {@link #transformInverse(double[], int, double[], int, double, double, double)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long transformInverse(long dest, long src, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.transformInverse_unsafe(dest, src, vX, vY, vZ);
        transformInverse(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, vX, vY, vZ);
        return dest;
    }

    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @param destOffset the element index in {@code dest} at which the vector starts
     * @param src the storage holding the quaternion
     * @param srcOffset the element index in {@code src} at which the quaternion starts
     * @param v the storage holding the vector
     * @param vOffset the element index in {@code v} at which the vector starts
     * @return {@code dest}
     */
    public static double[] transformInverse(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _selfw = src[srcOffset + 3];
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        double _t9 = 2.0 * Math.fma(_selfx, _vz, -(_selfz * _vx));
        double _t10 = 2.0 * Math.fma(_selfy, _vx, -(_selfx * _vy));
        double _t11 = 2.0 * Math.fma(_selfz, _vy, -(_selfy * _vz));
        dest[destOffset + 0] = Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, _vx)));
        dest[destOffset + 1] = Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, _vy)));
        dest[destOffset + 2] = Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vz)));
        return dest;
    }

    /** {@link #transformInverse(double[], int, double[], int, double[], int)} on {@link java.nio.DoubleBuffer} storage. */
    public static java.nio.DoubleBuffer transformInverse(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && v.isDirect()) return DoubleQuatOpsKernelsTypedBuffer.transformInverse_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsTypedBuffer.transformInverse_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transformInverse(double[], int, double[], int, double[], int)} on {@link java.nio.ByteBuffer} storage. */
    public static java.nio.ByteBuffer transformInverse(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && v.isDirect()) return DoubleQuatOpsKernelsByteBuffer.transformInverse_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsByteBuffer.transformInverse_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transformInverse(double[], int, double[], int, double[], int)} on {@link java.lang.foreign.MemorySegment} storage. */
    public static java.lang.foreign.MemorySegment transformInverse(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative() && v.isNative()) return DoubleQuatOpsKernelsSegment.transformInverse_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return DoubleQuatOpsKernelsSegment.transformInverse_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    /** {@link #transformInverse(double[], int, double[], int, double[], int)} on storage addressed by a raw native address - each address points at the first element, so there are no offsets. */
    public static long transformInverse(long dest, long src, long v) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) return DoubleQuatOpsKernelsAddress.transformInverse_unsafe(dest, src, v);
        transformInverse(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 24L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(v, 24L), 0L);
        return dest;
    }


    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest[destOffset + _i] = src[srcOffset + _i];
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest[destOffset + _i] = src.get(srcOffset + _i);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest[destOffset + _i] = src.getDouble(srcOffset + _i * 8);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest[destOffset + _i] = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(null, src, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static double[] copy(double[] dest, int destOffset, long src, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(null, src, dest, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, (long) count * 32L), 0L, count);
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.put(destOffset + _i, src[srcOffset + _i]);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.put(destOffset + _i, src.get(srcOffset + _i));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.put(destOffset + _i, src.getDouble(srcOffset + _i * 8));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.put(destOffset + _i, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, long src, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L, (long) count * 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, (long) count * 32L), 0L, count);
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, double[] src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.putDouble(destOffset + _i * 8, src[srcOffset + _i]);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.putDouble(destOffset + _i * 8, src.get(srcOffset + _i));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.putDouble(destOffset + _i * 8, src.getDouble(srcOffset + _i * 8));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.putDouble(destOffset + _i * 8, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, long src, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset, (long) count * 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, (long) count * 32L), 0L, count);
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, null, dest.address() + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src[srcOffset + _i]);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, null, dest.address() + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src.get(srcOffset + _i));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.ByteBuffer src, int srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, null, dest.address() + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src.getDouble(srcOffset + _i * 8));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        return copy(dest, destOffset, src, srcOffset, 1);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly() && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, null, dest.address() + destOffset, (long) count * 32L);
            return dest;
        }
        int n = count * 4;
        for (int _i = 0; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L));
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, dest.address() + destOffset, 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, long src, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isNative() && !dest.isReadOnly()) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, dest.address() + destOffset, (long) count * 32L);
            return dest;
        }
        return copy(dest, destOffset, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, (long) count * 32L), 0L, count);
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, double[] src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, null, dest, 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, src, srcOffset);
        return dest;
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, double[] src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(src, UnsafeCopy.DOUBLE_ARRAY_BASE + (long) srcOffset * 8L, null, dest, (long) count * 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, (long) count * 32L), 0L, src, srcOffset, count);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, null, dest, 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, src, srcOffset);
        return dest;
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L, null, dest, (long) count * 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, (long) count * 32L), 0L, src, srcOffset, count);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.nio.ByteBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, null, dest, 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, src, srcOffset);
        return dest;
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) {
            UnsafeOpsHolder.U.copyMemory(null, UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset, null, dest, (long) count * 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, (long) count * 32L), 0L, src, srcOffset, count);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, null, dest, 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, src, srcOffset);
        return dest;
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) {
            UnsafeOpsHolder.U.copyMemory(null, src.address() + srcOffset, null, dest, (long) count * 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, (long) count * 32L), 0L, src, srcOffset, count);
        return dest;
    }

    /**
     * Copy one DoubleQuat (4 doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, long src) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, dest, 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, 32L), 0L);
        return dest;
    }

    /**
     * Bulk-copy {@code count} consecutive DoubleQuat values ({@code count * 4} doubles) from {@code src}
     * to {@code dest}, translating between their storage backings. Returns {@code dest}.
     * The source and destination ranges must not overlap unless they are identical.
     */
    public static long copy(long dest, long src, int count) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE) {
            UnsafeOpsHolder.U.copyMemory(null, src, null, dest, (long) count * 32L);
            return dest;
        }
        copy(VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(dest, (long) count * 32L), 0L, VirtualMemoryHolder.VIRTUAL_MEMORY.asSlice(src, (long) count * 32L), 0L, count);
        return dest;
    }
}
